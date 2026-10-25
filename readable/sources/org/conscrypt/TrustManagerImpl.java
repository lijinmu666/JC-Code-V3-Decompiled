package org.conscrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509ExtendedTrustManager;
import org.conscrypt.p368ct.CTLogStore;
import org.conscrypt.p368ct.CTPolicy;
import org.conscrypt.p368ct.CTVerifier;

/* loaded from: classes2.dex */
public final class TrustManagerImpl extends X509ExtendedTrustManager {
    private static ConscryptHostnameVerifier defaultHostnameVerifier;
    private final X509Certificate[] acceptedIssuers;
    private final CertBlocklist blocklist;
    private boolean ctEnabledOverride;
    private CTPolicy ctPolicy;
    private CTVerifier ctVerifier;

    /* renamed from: err */
    private final Exception f24462err;

    /* renamed from: factory */
    private final CertificateFactory f24463factory;
    private ConscryptHostnameVerifier hostnameVerifier;
    private final TrustedCertificateIndex intermediateIndex;
    private CertPinManager pinManager;
    private final KeyStore rootKeyStore;
    private final TrustedCertificateIndex trustedCertificateIndex;
    private final ConscryptCertStore trustedCertificateStore;
    private final CertPathValidator validator;

    /* renamed from: logger */
    private static final Logger f24461logger = Logger.getLogger(TrustManagerImpl.class.getName());
    private static final TrustAnchorComparator TRUST_ANCHOR_COMPARATOR = new TrustAnchorComparator();

    public static class ExtendedKeyUsagePKIXCertPathChecker extends PKIXCertPathChecker {
        private static final String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private final boolean clientAuth;

        /* renamed from: leaf */
        private final X509Certificate f24465leaf;

        /* renamed from: EKU_OID */
        private static final String f24464EKU_OID = "2.5.29.37";
        private static final Set<String> SUPPORTED_EXTENSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(f24464EKU_OID)));

        @Override // java.security.cert.PKIXCertPathChecker
        public void check(Certificate certificate, Collection<String> collection) throws CertificateParsingException, CertPathValidatorException {
            X509Certificate x509Certificate = this.f24465leaf;
            if (certificate != x509Certificate) {
                return;
            }
            try {
                List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
                if (extendedKeyUsage == null) {
                    return;
                }
                for (String str : extendedKeyUsage) {
                    if (!str.equals(EKU_anyExtendedKeyUsage)) {
                        if (this.clientAuth) {
                            if (str.equals(EKU_clientAuth)) {
                            }
                        } else if (!str.equals(EKU_serverAuth) && !str.equals(EKU_nsSGC) && !str.equals(EKU_msSGC)) {
                        }
                    }
                    collection.remove(f24464EKU_OID);
                    return;
                }
                throw new CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
            } catch (CertificateParsingException e) {
                throw new CertPathValidatorException(e);
            }
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public Set<String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public void init(boolean z) {
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public boolean isForwardCheckingSupported() {
            return true;
        }

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z, X509Certificate x509Certificate) {
            this.clientAuth = z;
            this.f24465leaf = x509Certificate;
        }
    }

    public static class TrustAnchorComparator implements Comparator<TrustAnchor> {
        private static final CertificatePriorityComparator CERT_COMPARATOR = new CertificatePriorityComparator();

        private TrustAnchorComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TrustAnchor trustAnchor, TrustAnchor trustAnchor2) {
            return CERT_COMPARATOR.compare(trustAnchor.getTrustedCert(), trustAnchor2.getTrustedCert());
        }
    }

    public TrustManagerImpl(KeyStore keyStore) {
        this(keyStore, null);
    }

    private static X509Certificate[] acceptedIssuers(KeyStore keyStore) throws KeyStoreException {
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (KeyStoreException unused) {
            return new X509Certificate[0];
        }
    }

    private void checkBlocklist(X509Certificate x509Certificate) throws CertificateException {
        CertBlocklist certBlocklist = this.blocklist;
        if (certBlocklist == null || !certBlocklist.isPublicKeyBlockListed(x509Certificate.getPublicKey())) {
            return;
        }
        throw new CertificateException("Certificate blocklisted by public key: " + x509Certificate);
    }

    /* renamed from: checkCT */
    private void m18505checkCT(String str, List<X509Certificate> list, byte[] bArr, byte[] bArr2) throws CertificateException {
        if (!this.ctPolicy.doesResultConformToPolicy(this.ctVerifier.verifySignedCertificateTimestamps(list, bArr2, bArr), str, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]))) {
            throw new CertificateException("Certificate chain does not conform to required transparency policy.");
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession, SSLParameters sSLParameters, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        byte[] ocspDataFromSession;
        byte[] tlsSctDataFromSession;
        String peerHost;
        if (sSLSession != null) {
            peerHost = sSLSession.getPeerHost();
            ocspDataFromSession = getOcspDataFromSession(sSLSession);
            tlsSctDataFromSession = getTlsSctDataFromSession(sSLSession);
        } else {
            ocspDataFromSession = null;
            tlsSctDataFromSession = null;
            peerHost = null;
        }
        if (sSLSession == null || sSLParameters == null || !"HTTPS".equalsIgnoreCase(sSLParameters.getEndpointIdentificationAlgorithm()) || getHttpsVerifier().mo18423verify(x509CertificateArr, peerHost, sSLSession)) {
            return checkTrusted(x509CertificateArr, ocspDataFromSession, tlsSctDataFromSession, str, peerHost, z);
        }
        throw new CertificateException("No subjectAltNames on the certificate match");
    }

    private List<X509Certificate> checkTrustedRecursive(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, boolean z, ArrayList<X509Certificate> arrayList, ArrayList<TrustAnchor> arrayList2, Set<X509Certificate> set) throws CertificateException {
        X509Certificate trustedCert = arrayList2.isEmpty() ? arrayList.get(arrayList.size() - 1) : arrayList2.get(arrayList2.size() - 1).getTrustedCert();
        checkBlocklist(trustedCert);
        if (trustedCert.getIssuerDN().equals(trustedCert.getSubjectDN())) {
            return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
        }
        boolean z2 = false;
        CertificateException certificateException = null;
        for (TrustAnchor trustAnchor : sortPotentialAnchors(findAllTrustAnchorsByIssuerAndSignature(trustedCert))) {
            X509Certificate trustedCert2 = trustAnchor.getTrustedCert();
            if (!set.contains(trustedCert2)) {
                set.add(trustedCert2);
                arrayList2.add(trustAnchor);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                } catch (CertificateException e) {
                    arrayList2.remove(arrayList2.size() - 1);
                    set.remove(trustedCert2);
                    certificateException = e;
                    z2 = true;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            if (z2) {
                throw certificateException;
            }
            return verifyChain(arrayList, arrayList2, str, z, bArr, bArr2);
        }
        for (int i = 1; i < x509CertificateArr.length; i++) {
            X509Certificate x509Certificate = x509CertificateArr[i];
            if (!set.contains(x509Certificate) && trustedCert.getIssuerDN().equals(x509Certificate.getSubjectDN())) {
                try {
                    x509Certificate.checkValidity();
                    ChainStrengthAnalyzer.checkCert(x509Certificate);
                    set.add(x509Certificate);
                    arrayList.add(x509Certificate);
                    try {
                        return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                    } catch (CertificateException e2) {
                        set.remove(x509Certificate);
                        arrayList.remove(arrayList.size() - 1);
                        certificateException = e2;
                    }
                } catch (CertificateException e3) {
                    certificateException = new CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e3);
                }
            }
        }
        Iterator<TrustAnchor> it = sortPotentialAnchors(this.intermediateIndex.findAllByIssuerAndSignature(trustedCert)).iterator();
        while (it.hasNext()) {
            X509Certificate trustedCert3 = it.next().getTrustedCert();
            if (!set.contains(trustedCert3)) {
                set.add(trustedCert3);
                arrayList.add(trustedCert3);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z, arrayList, arrayList2, set);
                } catch (CertificateException e4) {
                    arrayList.remove(arrayList.size() - 1);
                    set.remove(trustedCert3);
                    certificateException = e4;
                }
            }
        }
        if (certificateException != null) {
            throw certificateException;
        }
        throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, this.f24463factory.generateCertPath(arrayList), -1));
    }

    private Set<TrustAnchor> findAllTrustAnchorsByIssuerAndSignature(X509Certificate x509Certificate) {
        ConscryptCertStore conscryptCertStore;
        Set<TrustAnchor> setFindAllByIssuerAndSignature = this.trustedCertificateIndex.findAllByIssuerAndSignature(x509Certificate);
        if (setFindAllByIssuerAndSignature.isEmpty() && (conscryptCertStore = this.trustedCertificateStore) != null) {
            Set<X509Certificate> setFindAllIssuers = conscryptCertStore.findAllIssuers(x509Certificate);
            if (setFindAllIssuers.isEmpty()) {
                return setFindAllByIssuerAndSignature;
            }
            setFindAllByIssuerAndSignature = new HashSet<>(setFindAllIssuers.size());
            Iterator<X509Certificate> it = setFindAllIssuers.iterator();
            while (it.hasNext()) {
                setFindAllByIssuerAndSignature.add(this.trustedCertificateIndex.m18507index(it.next()));
            }
        }
        return setFindAllByIssuerAndSignature;
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X509Certificate trustAnchor;
        TrustAnchor trustAnchorFindBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (trustAnchorFindBySubjectAndPublicKey != null) {
            return trustAnchorFindBySubjectAndPublicKey;
        }
        ConscryptCertStore conscryptCertStore = this.trustedCertificateStore;
        if (conscryptCertStore == null || (trustAnchor = conscryptCertStore.getTrustAnchor(x509Certificate)) == null) {
            return null;
        }
        return new TrustAnchor(trustAnchor, null);
    }

    public static synchronized ConscryptHostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    private static SSLSession getHandshakeSessionOrThrow(SSLSocket sSLSocket) throws CertificateException {
        SSLSession handshakeSession = sSLSocket.getHandshakeSession();
        if (handshakeSession != null) {
            return handshakeSession;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    private ConscryptHostnameVerifier getHttpsVerifier() {
        ConscryptHostnameVerifier conscryptHostnameVerifier = this.hostnameVerifier;
        return conscryptHostnameVerifier != null ? conscryptHostnameVerifier : Platform.getDefaultHostnameVerifier();
    }

    private static byte[] getOcspDataFromSession(SSLSession sSLSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        List<byte[]> statusResponses;
        if (sSLSession instanceof ConscryptSession) {
            statusResponses = ((ConscryptSession) sSLSession).getStatusResponses();
        } else {
            try {
                Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getStatusResponses", null);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(sSLSession, null);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
            statusResponses = objInvoke instanceof List ? (List) objInvoke : null;
        }
        if (statusResponses == null || statusResponses.isEmpty()) {
            return null;
        }
        return statusResponses.get(0);
    }

    private byte[] getTlsSctDataFromSession(SSLSession sSLSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (sSLSession instanceof ConscryptSession) {
            return ((ConscryptSession) sSLSession).getPeerSignedCertificateTimestamp();
        }
        try {
            Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getPeerSignedCertificateTimestamp", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(sSLSession, null);
            if (objInvoke instanceof byte[]) {
                return (byte[]) objInvoke;
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public static synchronized void setDefaultHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        defaultHostnameVerifier = conscryptHostnameVerifier;
    }

    private void setOcspResponses(PKIXParameters pKIXParameters, X509Certificate x509Certificate, byte[] bArr) {
        PKIXRevocationChecker pKIXRevocationChecker;
        if (bArr == null) {
            return;
        }
        List<PKIXCertPathChecker> arrayList = new ArrayList<>(pKIXParameters.getCertPathCheckers());
        Iterator<PKIXCertPathChecker> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                pKIXRevocationChecker = null;
                break;
            }
            PKIXCertPathChecker next = it.next();
            if (next instanceof PKIXRevocationChecker) {
                pKIXRevocationChecker = (PKIXRevocationChecker) next;
                break;
            }
        }
        if (pKIXRevocationChecker == null) {
            try {
                pKIXRevocationChecker = (PKIXRevocationChecker) this.validator.getRevocationChecker();
                arrayList.add(pKIXRevocationChecker);
                pKIXRevocationChecker.setOptions(Collections.singleton(PKIXRevocationChecker.Option.ONLY_END_ENTITY));
            } catch (UnsupportedOperationException unused) {
                return;
            }
        }
        pKIXRevocationChecker.setOcspResponses(Collections.singletonMap(x509Certificate, bArr));
        pKIXParameters.setCertPathCheckers(arrayList);
    }

    private static Collection<TrustAnchor> sortPotentialAnchors(Set<TrustAnchor> set) {
        if (set.size() <= 1) {
            return set;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList, TRUST_ANCHOR_COMPARATOR);
        return arrayList;
    }

    private static Set<TrustAnchor> trustAnchors(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet(x509CertificateArr.length);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            hashSet.add(new TrustAnchor(x509Certificate, null));
        }
        return hashSet;
    }

    private List<X509Certificate> verifyChain(List<X509Certificate> list, List<TrustAnchor> list2, String str, boolean z, byte[] bArr, byte[] bArr2) throws CertificateException, CertPathValidatorException, InvalidAlgorithmParameterException {
        try {
            CertPath certPathGenerateCertPath = this.f24463factory.generateCertPath(list);
            if (list2.isEmpty()) {
                throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, certPathGenerateCertPath, -1));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            Iterator<TrustAnchor> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTrustedCert());
            }
            CertPinManager certPinManager = this.pinManager;
            if (certPinManager != null) {
                certPinManager.checkChainPinning(str, arrayList);
            }
            Iterator<X509Certificate> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                checkBlocklist(it2.next());
            }
            if (!z && (this.ctEnabledOverride || (str != null && Platform.isCTVerificationRequired(str)))) {
                m18505checkCT(str, arrayList, bArr, bArr2);
            }
            if (list.isEmpty()) {
                return arrayList;
            }
            ChainStrengthAnalyzer.m18416check(list);
            try {
                try {
                    HashSet hashSet = new HashSet();
                    hashSet.add(list2.get(0));
                    PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
                    pKIXParameters.setRevocationEnabled(false);
                    X509Certificate x509Certificate = list.get(0);
                    setOcspResponses(pKIXParameters, x509Certificate, bArr);
                    pKIXParameters.addCertPathChecker(new ExtendedKeyUsagePKIXCertPathChecker(z, x509Certificate));
                    this.validator.validate(certPathGenerateCertPath, pKIXParameters);
                    for (int i = 1; i < list.size(); i++) {
                        this.intermediateIndex.m18507index(list.get(i));
                    }
                    return arrayList;
                } catch (InvalidAlgorithmParameterException e) {
                    throw new CertificateException("Chain validation failed", e);
                }
            } catch (CertPathValidatorException e2) {
                throw new CertificateException("Chain validation failed", e2);
            }
        } catch (CertificateException e3) {
            f24461logger.fine("Rejected candidate cert chain due to error: " + e3.getMessage());
            throw e3;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        checkTrusted(x509CertificateArr, str, null, null, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        checkTrusted(x509CertificateArr, str, null, null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        return x509CertificateArr != null ? (X509Certificate[]) x509CertificateArr.clone() : acceptedIssuers(this.rootKeyStore);
    }

    public ConscryptHostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLSession sSLSession;
        SSLParameters sSLParameters;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        return checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, false);
    }

    public void handleTrustStorageUpdate() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        if (x509CertificateArr == null) {
            this.trustedCertificateIndex.m18509reset();
        } else {
            this.trustedCertificateIndex.m18510reset(trustAnchors(x509CertificateArr));
        }
    }

    public void setCTEnabledOverride(boolean z) {
        this.ctEnabledOverride = z;
    }

    public void setCTPolicy(CTPolicy cTPolicy) {
        this.ctPolicy = cTPolicy;
    }

    public void setCTVerifier(CTVerifier cTVerifier) {
        this.ctVerifier = cTVerifier;
    }

    public void setHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        this.hostnameVerifier = conscryptHostnameVerifier;
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public List<X509Certificate> checkClientTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
        return checkTrusted(x509CertificateArr, null, null, str, str2, true);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
        return checkTrusted(x509CertificateArr, null, null, str, str2, false);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore) {
        this(keyStore, certPinManager, conscryptCertStore, null);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        SSLSession sSLSession;
        SSLParameters sSLParameters;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, true);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, socket);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlocklist certBlocklist) {
        this(keyStore, certPinManager, conscryptCertStore, certBlocklist, null, null, null);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, sSLEngine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlocklist certBlocklist, CTLogStore cTLogStore, CTVerifier cTVerifier, CTPolicy cTPolicy) throws NoSuchAlgorithmException, CertificateException {
        ConscryptCertStore conscryptCertStore2;
        ConscryptCertStore conscryptCertStore3;
        CertPathValidator certPathValidator;
        Exception exc;
        CertificateFactory certificateFactory;
        X509Certificate[] x509CertificateArr;
        ConscryptCertStore conscryptCertStore4;
        CertificateFactory certificateFactory2;
        CertPathValidator certPathValidator2;
        ConscryptCertStore conscryptCertStore5;
        TrustedCertificateIndex trustedCertificateIndex;
        Object obj;
        TrustedCertificateIndex trustedCertificateIndex2 = null;
        try {
            certPathValidator2 = CertPathValidator.getInstance("PKIX");
            try {
                certificateFactory2 = CertificateFactory.getInstance("X509");
                try {
                    if ("AndroidCAStore".equals(keyStore.getType())) {
                        if (Platform.supportsConscryptCertStore()) {
                            if (conscryptCertStore == null) {
                                try {
                                    conscryptCertStore = Platform.newDefaultCertStore();
                                } catch (Exception e) {
                                    e = e;
                                    conscryptCertStore5 = null;
                                    exc = e;
                                    certificateFactory = certificateFactory2;
                                    certPathValidator = certPathValidator2;
                                    conscryptCertStore3 = conscryptCertStore5;
                                    conscryptCertStore2 = conscryptCertStore5;
                                    CertificateFactory certificateFactory3 = certificateFactory;
                                    conscryptCertStore4 = conscryptCertStore3;
                                    certPathValidator2 = certPathValidator;
                                    certificateFactory2 = certificateFactory3;
                                    x509CertificateArr = conscryptCertStore2;
                                    if (certBlocklist == null) {
                                    }
                                    if (cTLogStore == null) {
                                    }
                                    if (cTPolicy == null) {
                                    }
                                    this.pinManager = certPinManager;
                                    this.rootKeyStore = keyStore;
                                    this.trustedCertificateStore = conscryptCertStore4;
                                    this.validator = certPathValidator2;
                                    this.f24463factory = certificateFactory2;
                                    this.trustedCertificateIndex = trustedCertificateIndex2;
                                    this.intermediateIndex = new TrustedCertificateIndex();
                                    this.acceptedIssuers = x509CertificateArr;
                                    this.f24462err = exc;
                                    this.blocklist = certBlocklist;
                                    this.ctVerifier = new CTVerifier(cTLogStore);
                                    this.ctPolicy = cTPolicy;
                                }
                            }
                            try {
                                trustedCertificateIndex = new TrustedCertificateIndex();
                                conscryptCertStore4 = conscryptCertStore;
                                obj = null;
                                TrustedCertificateIndex trustedCertificateIndex3 = trustedCertificateIndex;
                                exc = null;
                                trustedCertificateIndex2 = trustedCertificateIndex3;
                                x509CertificateArr = obj;
                            } catch (Exception e2) {
                                exc = e2;
                                certificateFactory = certificateFactory2;
                                certPathValidator = certPathValidator2;
                                conscryptCertStore3 = conscryptCertStore;
                                conscryptCertStore2 = null;
                                CertificateFactory certificateFactory32 = certificateFactory;
                                conscryptCertStore4 = conscryptCertStore3;
                                certPathValidator2 = certPathValidator;
                                certificateFactory2 = certificateFactory32;
                                x509CertificateArr = conscryptCertStore2;
                                if (certBlocklist == null) {
                                }
                                if (cTLogStore == null) {
                                }
                                if (cTPolicy == null) {
                                }
                                this.pinManager = certPinManager;
                                this.rootKeyStore = keyStore;
                                this.trustedCertificateStore = conscryptCertStore4;
                                this.validator = certPathValidator2;
                                this.f24463factory = certificateFactory2;
                                this.trustedCertificateIndex = trustedCertificateIndex2;
                                this.intermediateIndex = new TrustedCertificateIndex();
                                this.acceptedIssuers = x509CertificateArr;
                                this.f24462err = exc;
                                this.blocklist = certBlocklist;
                                this.ctVerifier = new CTVerifier(cTLogStore);
                                this.ctPolicy = cTPolicy;
                            }
                        } else {
                            try {
                                X509Certificate[] x509CertificateArrAcceptedIssuers = acceptedIssuers(keyStore);
                                try {
                                    trustedCertificateIndex = new TrustedCertificateIndex(trustAnchors(x509CertificateArrAcceptedIssuers));
                                    conscryptCertStore4 = conscryptCertStore;
                                    obj = x509CertificateArrAcceptedIssuers;
                                    keyStore = null;
                                    TrustedCertificateIndex trustedCertificateIndex32 = trustedCertificateIndex;
                                    exc = null;
                                    trustedCertificateIndex2 = trustedCertificateIndex32;
                                    x509CertificateArr = obj;
                                } catch (Exception e3) {
                                    exc = e3;
                                    certificateFactory = certificateFactory2;
                                    certPathValidator = certPathValidator2;
                                    conscryptCertStore3 = conscryptCertStore;
                                    conscryptCertStore2 = x509CertificateArrAcceptedIssuers;
                                    keyStore = null;
                                    CertificateFactory certificateFactory322 = certificateFactory;
                                    conscryptCertStore4 = conscryptCertStore3;
                                    certPathValidator2 = certPathValidator;
                                    certificateFactory2 = certificateFactory322;
                                    x509CertificateArr = conscryptCertStore2;
                                    if (certBlocklist == null) {
                                    }
                                    if (cTLogStore == null) {
                                    }
                                    if (cTPolicy == null) {
                                    }
                                    this.pinManager = certPinManager;
                                    this.rootKeyStore = keyStore;
                                    this.trustedCertificateStore = conscryptCertStore4;
                                    this.validator = certPathValidator2;
                                    this.f24463factory = certificateFactory2;
                                    this.trustedCertificateIndex = trustedCertificateIndex2;
                                    this.intermediateIndex = new TrustedCertificateIndex();
                                    this.acceptedIssuers = x509CertificateArr;
                                    this.f24462err = exc;
                                    this.blocklist = certBlocklist;
                                    this.ctVerifier = new CTVerifier(cTLogStore);
                                    this.ctPolicy = cTPolicy;
                                }
                            } catch (Exception e4) {
                                keyStore = null;
                                exc = e4;
                                certificateFactory = certificateFactory2;
                                certPathValidator = certPathValidator2;
                                conscryptCertStore3 = conscryptCertStore;
                                conscryptCertStore2 = null;
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    keyStore = null;
                    conscryptCertStore5 = null;
                }
            } catch (Exception e6) {
                keyStore = null;
                conscryptCertStore2 = null;
                certPathValidator = certPathValidator2;
                exc = e6;
                conscryptCertStore3 = null;
                certificateFactory = null;
            }
        } catch (Exception e7) {
            keyStore = null;
            conscryptCertStore2 = null;
            conscryptCertStore3 = null;
            certPathValidator = null;
            exc = e7;
            certificateFactory = null;
        }
        certBlocklist = certBlocklist == null ? Platform.newDefaultBlocklist() : certBlocklist;
        cTLogStore = cTLogStore == null ? Platform.newDefaultLogStore() : cTLogStore;
        cTPolicy = cTPolicy == null ? Platform.newDefaultPolicy(cTLogStore) : cTPolicy;
        this.pinManager = certPinManager;
        this.rootKeyStore = keyStore;
        this.trustedCertificateStore = conscryptCertStore4;
        this.validator = certPathValidator2;
        this.f24463factory = certificateFactory2;
        this.trustedCertificateIndex = trustedCertificateIndex2;
        this.intermediateIndex = new TrustedCertificateIndex();
        this.acceptedIssuers = x509CertificateArr;
        this.f24462err = exc;
        this.blocklist = certBlocklist;
        this.ctVerifier = new CTVerifier(cTLogStore);
        this.ctPolicy = cTPolicy;
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) {
        return checkTrusted(x509CertificateArr, str, sSLSession, null, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            return checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), false);
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), true);
            return;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, String str2, boolean z) throws CertificateException {
        if (x509CertificateArr != null && x509CertificateArr.length != 0 && str != null && str.length() != 0) {
            if (this.f24462err == null) {
                HashSet hashSet = new HashSet();
                ArrayList<X509Certificate> arrayList = new ArrayList<>();
                ArrayList<TrustAnchor> arrayList2 = new ArrayList<>();
                X509Certificate x509Certificate = x509CertificateArr[0];
                TrustAnchor trustAnchorFindTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509Certificate);
                if (trustAnchorFindTrustAnchorBySubjectAndPublicKey != null) {
                    arrayList2.add(trustAnchorFindTrustAnchorBySubjectAndPublicKey);
                    hashSet.add(trustAnchorFindTrustAnchorBySubjectAndPublicKey.getTrustedCert());
                } else {
                    arrayList.add(x509Certificate);
                }
                hashSet.add(x509Certificate);
                return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str2, z, arrayList, arrayList2, hashSet);
            }
            throw new CertificateException(this.f24462err);
        }
        throw new IllegalArgumentException("null or zero-length parameter");
    }
}
