package org.bouncycastle.p310pkix.p311jcajce;

import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.CRLDistPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPointName;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p249jcajce.PKIXCRLStore;
import org.bouncycastle.p249jcajce.PKIXCRLStoreSelector;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Iterable;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class X509RevocationChecker extends PKIXCertPathChecker {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    private final boolean canSoftFail;
    private final List<CertStore> crlCertStores;

    /* renamed from: crls */
    private final List<InterfaceC6249Store<CRL>> f22989crls;
    private Date currentDate;
    private final long failHardMaxTime;
    private final long failLogMaxTime;
    private final Map<X500Principal, Long> failures;

    /* renamed from: helper */
    private final JcaJceHelper f22990helper;
    private final boolean isCheckEEOnly;
    private X509Certificate signingCert;
    private final Set<TrustAnchor> trustAnchors;
    private final Date validationDate;
    private final int validityModel;
    private X500Principal workingIssuerName;
    private PublicKey workingPublicKey;

    /* renamed from: LOG */
    private static Logger f22988LOG = Logger.getLogger(X509RevocationChecker.class.getName());
    protected static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* renamed from: org.bouncycastle.pkix.jcajce.X509RevocationChecker$Builder */
    public static class C6046Builder {
        private boolean canSoftFail;
        private List<CertStore> crlCertStores;

        /* renamed from: crls */
        private List<InterfaceC6249Store<CRL>> f22993crls;
        private long failHardMaxTime;
        private long failLogMaxTime;
        private boolean isCheckEEOnly;
        private Provider provider;
        private String providerName;
        private Set<TrustAnchor> trustAnchors;
        private Date validityDate;
        private int validityModel;

        public C6046Builder(KeyStore keyStore) throws KeyStoreException {
            this.crlCertStores = new ArrayList();
            this.f22993crls = new ArrayList();
            this.validityModel = 0;
            this.validityDate = new Date();
            this.trustAnchors = new HashSet();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strNextElement = enumerationAliases.nextElement();
                if (keyStore.isCertificateEntry(strNextElement)) {
                    this.trustAnchors.add(new TrustAnchor((X509Certificate) keyStore.getCertificate(strNextElement), null));
                }
            }
        }

        /* renamed from: addCrls */
        public C6046Builder m17446addCrls(CertStore certStore) {
            this.crlCertStores.add(certStore);
            return this;
        }

        /* renamed from: build */
        public X509RevocationChecker m17448build() {
            return new X509RevocationChecker(this);
        }

        public C6046Builder setCheckEndEntityOnly(boolean z) {
            this.isCheckEEOnly = z;
            return this;
        }

        /* renamed from: setDate */
        public C6046Builder m17449setDate(Date date) {
            this.validityDate = new Date(date.getTime());
            return this;
        }

        public C6046Builder setSoftFail(boolean z, long j) {
            this.canSoftFail = z;
            this.failLogMaxTime = j;
            this.failHardMaxTime = -1L;
            return this;
        }

        public C6046Builder setSoftFailHardLimit(boolean z, long j) {
            this.canSoftFail = z;
            this.failLogMaxTime = (3 * j) / 4;
            this.failHardMaxTime = j;
            return this;
        }

        public C6046Builder setValidityModel(int i) {
            this.validityModel = i;
            return this;
        }

        public C6046Builder usingProvider(String str) {
            this.providerName = str;
            return this;
        }

        public C6046Builder(TrustAnchor trustAnchor) {
            this.crlCertStores = new ArrayList();
            this.f22993crls = new ArrayList();
            this.validityModel = 0;
            this.validityDate = new Date();
            this.trustAnchors = Collections.singleton(trustAnchor);
        }

        /* renamed from: addCrls */
        public C6046Builder m17447addCrls(InterfaceC6249Store<CRL> interfaceC6249Store) {
            this.f22993crls.add(interfaceC6249Store);
            return this;
        }

        public C6046Builder usingProvider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public C6046Builder(Set<TrustAnchor> set) {
            this.crlCertStores = new ArrayList();
            this.f22993crls = new ArrayList();
            this.validityModel = 0;
            this.validityDate = new Date();
            this.trustAnchors = new HashSet(set);
        }
    }

    public static class LocalCRLStore implements PKIXCRLStore<CRL>, Iterable<CRL> {

        /* renamed from: _local */
        private Collection<CRL> f22994_local;

        public LocalCRLStore(InterfaceC6249Store<CRL> interfaceC6249Store) {
            this.f22994_local = new ArrayList(interfaceC6249Store.getMatches(null));
        }

        @Override // org.bouncycastle.p249jcajce.PKIXCRLStore, org.bouncycastle.p361util.InterfaceC6249Store
        public Collection<CRL> getMatches(Selector<CRL> selector) {
            if (selector == null) {
                return new ArrayList(this.f22994_local);
            }
            ArrayList arrayList = new ArrayList();
            for (CRL crl : this.f22994_local) {
                if (selector.mo14742match(crl)) {
                    arrayList.add(crl);
                }
            }
            return arrayList;
        }

        @Override // org.bouncycastle.p361util.Iterable, java.lang.Iterable
        public Iterator<CRL> iterator() {
            return getMatches(null).iterator();
        }
    }

    private X509RevocationChecker(C6046Builder c6046Builder) {
        JcaJceHelper namedJcaJceHelper;
        this.failures = new HashMap();
        this.f22989crls = new ArrayList(c6046Builder.f22993crls);
        this.crlCertStores = new ArrayList(c6046Builder.crlCertStores);
        this.isCheckEEOnly = c6046Builder.isCheckEEOnly;
        this.validityModel = c6046Builder.validityModel;
        this.trustAnchors = c6046Builder.trustAnchors;
        this.canSoftFail = c6046Builder.canSoftFail;
        this.failLogMaxTime = c6046Builder.failLogMaxTime;
        this.failHardMaxTime = c6046Builder.failHardMaxTime;
        this.validationDate = c6046Builder.validityDate;
        if (c6046Builder.provider != null) {
            namedJcaJceHelper = new ProviderJcaJceHelper(c6046Builder.provider);
        } else {
            if (c6046Builder.providerName == null) {
                this.f22990helper = new DefaultJcaJceHelper();
                return;
            }
            namedJcaJceHelper = new NamedJcaJceHelper(c6046Builder.providerName);
        }
        this.f22990helper = namedJcaJceHelper;
    }

    private void addIssuers(final List<X500Principal> list, CertStore certStore) throws CertStoreException {
        certStore.getCRLs(new X509CRLSelector(this) { // from class: org.bouncycastle.pkix.jcajce.X509RevocationChecker.1

            /* renamed from: this$0 */
            final /* synthetic */ X509RevocationChecker f22991this$0;

            {
                this.f22991this$0 = this;
            }

            @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
            public boolean match(CRL crl) {
                if (!(crl instanceof X509CRL)) {
                    return false;
                }
                list.add(((X509CRL) crl).getIssuerX500Principal());
                return false;
            }
        });
    }

    private Set<CRL> downloadCRLs(X500Principal x500Principal, Date date, ASN1Primitive aSN1Primitive, JcaJceHelper jcaJceHelper) {
        URI uri;
        DistributionPoint[] distributionPoints = CRLDistPoint.getInstance(aSN1Primitive).getDistributionPoints();
        try {
            CertificateFactory certificateFactoryCreateCertificateFactory = jcaJceHelper.createCertificateFactory("X.509");
            X509CRLSelector x509CRLSelector = new X509CRLSelector();
            x509CRLSelector.addIssuer(x500Principal);
            PKIXCRLStoreSelector<? extends CRL> pKIXCRLStoreSelectorM16074build = new PKIXCRLStoreSelector.C5477Builder(x509CRLSelector).m16074build();
            HashSet hashSet = new HashSet();
            for (int i = 0; i != distributionPoints.length; i++) {
                DistributionPointName distributionPoint = distributionPoints[i].getDistributionPoint();
                if (distributionPoint != null && distributionPoint.m14684getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint.m14683getName()).getNames();
                    for (int i2 = 0; i2 != names.length; i2++) {
                        GeneralName generalName = names[i2];
                        if (generalName.getTagNo() == 6) {
                            try {
                                uri = new URI(((ASN1String) generalName.m14690getName()).getString());
                                try {
                                    PKIXCRLStore pKIXCRLStoreM17440getCrl = CrlCache.m17440getCrl(certificateFactoryCreateCertificateFactory, this.validationDate, uri);
                                    if (pKIXCRLStoreM17440getCrl != null) {
                                        try {
                                            hashSet.addAll(PKIXCRLUtil.findCRLs(pKIXCRLStoreSelectorM16074build, date, Collections.EMPTY_LIST, Collections.singletonList(pKIXCRLStoreM17440getCrl)));
                                        } catch (Exception e) {
                                            e = e;
                                            Logger logger = f22988LOG;
                                            Level level = Level.FINE;
                                            if (logger.isLoggable(level)) {
                                                f22988LOG.log(level, "CrlDP " + uri + " ignored: " + e.getMessage(), (Throwable) e);
                                            } else {
                                                f22988LOG.log(Level.INFO, "CrlDP " + uri + " ignored: " + e.getMessage());
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                uri = null;
                            }
                        }
                    }
                }
            }
            return hashSet;
        } catch (Exception e4) {
            Logger logger2 = f22988LOG;
            Level level2 = Level.FINE;
            if (logger2.isLoggable(level2)) {
                f22988LOG.log(level2, "could not create certFact: " + e4.getMessage(), (Throwable) e4);
                return null;
            }
            f22988LOG.log(Level.INFO, "could not create certFact: " + e4.getMessage());
            return null;
        }
    }

    public static List<PKIXCRLStore> getAdditionalStoresFromCRLDistributionPoint(CRLDistPoint cRLDistPoint, Map<GeneralName, PKIXCRLStore> map) throws AnnotatedException {
        if (cRLDistPoint == null) {
            return Collections.emptyList();
        }
        try {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            ArrayList arrayList = new ArrayList();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2 != null && distributionPoint2.m14684getType() == 0) {
                    for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.m14683getName()).getNames()) {
                        PKIXCRLStore pKIXCRLStore = map.get(generalName);
                        if (pKIXCRLStore != null) {
                            arrayList.add(pKIXCRLStore);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new AnnotatedException("could not read distribution points could not be read", e);
        }
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate certificate, Collection<String> collection) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertPathValidatorException, CRLException, NoSuchProviderException {
        Logger logger;
        Level level;
        StringBuilder sb;
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.isCheckEEOnly && x509Certificate.getBasicConstraints() != -1) {
            this.workingIssuerName = x509Certificate.getSubjectX500Principal();
            this.workingPublicKey = x509Certificate.getPublicKey();
            this.signingCert = x509Certificate;
            return;
        }
        if (this.workingIssuerName == null) {
            this.workingIssuerName = x509Certificate.getIssuerX500Principal();
            TrustAnchor trustAnchor = null;
            for (TrustAnchor trustAnchor2 : this.trustAnchors) {
                if (this.workingIssuerName.equals(trustAnchor2.getCA()) || this.workingIssuerName.equals(trustAnchor2.getTrustedCert().getSubjectX500Principal())) {
                    trustAnchor = trustAnchor2;
                }
            }
            if (trustAnchor == null) {
                throw new CertPathValidatorException("no trust anchor found for " + this.workingIssuerName);
            }
            X509Certificate trustedCert = trustAnchor.getTrustedCert();
            this.signingCert = trustedCert;
            this.workingPublicKey = trustedCert.getPublicKey();
        }
        ArrayList arrayList = new ArrayList();
        try {
            PKIXParameters pKIXParameters = new PKIXParameters(this.trustAnchors);
            pKIXParameters.setRevocationEnabled(false);
            pKIXParameters.setDate(this.validationDate);
            for (int i = 0; i != this.crlCertStores.size(); i++) {
                if (f22988LOG.isLoggable(Level.INFO)) {
                    addIssuers(arrayList, this.crlCertStores.get(i));
                }
                pKIXParameters.addCertStore(this.crlCertStores.get(i));
            }
            PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXParameters);
            c5483Builder.setValidityModel(this.validityModel);
            for (int i2 = 0; i2 != this.f22989crls.size(); i2++) {
                if (f22988LOG.isLoggable(Level.INFO)) {
                    addIssuers(arrayList, this.f22989crls.get(i2));
                }
                c5483Builder.addCRLStore(new LocalCRLStore(this.f22989crls.get(i2)));
            }
            if (arrayList.isEmpty()) {
                f22988LOG.log(Level.INFO, "configured with 0 pre-loaded CRLs");
            } else if (f22988LOG.isLoggable(Level.FINE)) {
                for (int i3 = 0; i3 != arrayList.size(); i3++) {
                    f22988LOG.log(Level.FINE, "configuring with CRL for issuer \"" + arrayList.get(i3) + "\"");
                }
            } else {
                f22988LOG.log(Level.INFO, "configured with " + arrayList.size() + " pre-loaded CRLs");
            }
            PKIXExtendedParameters pKIXExtendedParametersM16080build = c5483Builder.m16080build();
            Date validityDate = RevocationUtilities.getValidityDate(pKIXExtendedParametersM16080build, this.validationDate);
            try {
                checkCRLs(pKIXExtendedParametersM16080build, this.currentDate, validityDate, x509Certificate, this.signingCert, this.workingPublicKey, new ArrayList(), this.f22990helper);
            } catch (AnnotatedException e) {
                throw new CertPathValidatorException(e.getMessage(), e.getCause());
            } catch (CRLNotFoundException e2) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.cRLDistributionPoints;
                if (x509Certificate.getExtensionValue(aSN1ObjectIdentifier.m14433getId()) == null) {
                    throw e2;
                }
                try {
                    Set<CRL> setDownloadCRLs = downloadCRLs(x509Certificate.getIssuerX500Principal(), validityDate, RevocationUtilities.getExtensionValue(x509Certificate, aSN1ObjectIdentifier), this.f22990helper);
                    if (!setDownloadCRLs.isEmpty()) {
                        try {
                            c5483Builder.addCRLStore(new LocalCRLStore(new CollectionStore(setDownloadCRLs)));
                            PKIXExtendedParameters pKIXExtendedParametersM16080build2 = c5483Builder.m16080build();
                            checkCRLs(pKIXExtendedParametersM16080build2, this.currentDate, RevocationUtilities.getValidityDate(pKIXExtendedParametersM16080build2, this.validationDate), x509Certificate, this.signingCert, this.workingPublicKey, new ArrayList(), this.f22990helper);
                        } catch (AnnotatedException e3) {
                            throw new CertPathValidatorException(e3.getMessage(), e3.getCause());
                        }
                    } else {
                        if (!this.canSoftFail) {
                            throw e2;
                        }
                        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
                        Long l = this.failures.get(issuerX500Principal);
                        if (l != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
                            long j = this.failHardMaxTime;
                            if (j != -1 && j < jCurrentTimeMillis) {
                                throw e2;
                            }
                            if (jCurrentTimeMillis < this.failLogMaxTime) {
                                logger = f22988LOG;
                                level = Level.WARNING;
                                sb = new StringBuilder();
                            } else {
                                logger = f22988LOG;
                                level = Level.SEVERE;
                                sb = new StringBuilder();
                            }
                            sb.append("soft failing for issuer: \"");
                            sb.append(issuerX500Principal);
                            sb.append("\"");
                            logger.log(level, sb.toString());
                        } else {
                            this.failures.put(issuerX500Principal, Long.valueOf(System.currentTimeMillis()));
                        }
                    }
                } catch (AnnotatedException e4) {
                    throw new CertPathValidatorException(e4.getMessage(), e4.getCause());
                }
            }
            this.signingCert = x509Certificate;
            this.workingPublicKey = x509Certificate.getPublicKey();
            this.workingIssuerName = x509Certificate.getSubjectX500Principal();
        } catch (GeneralSecurityException e5) {
            throw new RuntimeException("error setting up baseParams: " + e5.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkCRLs(PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, List list, JcaJceHelper jcaJceHelper) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, CRLNotFoundException, InvalidKeyException, CRLException, NoSuchProviderException {
        AnnotatedException e;
        boolean z;
        int i;
        int i2;
        PKIXExtendedParameters pKIXExtendedParameters2;
        DistributionPoint[] distributionPointArr;
        int i3;
        try {
            CRLDistPoint cRLDistPoint = CRLDistPoint.getInstance(RevocationUtilities.getExtensionValue(x509Certificate, Extension.cRLDistributionPoints));
            CertStatus certStatus = new CertStatus();
            ReasonsMask reasonsMask = new ReasonsMask();
            int i4 = 11;
            if (cRLDistPoint != null) {
                try {
                    DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
                    if (distributionPoints != null) {
                        PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXExtendedParameters);
                        try {
                            Iterator<PKIXCRLStore> it = getAdditionalStoresFromCRLDistributionPoint(cRLDistPoint, pKIXExtendedParameters.getNamedCRLStoreMap()).iterator();
                            while (it.hasNext()) {
                                c5483Builder.addCRLStore(it.next());
                            }
                            PKIXExtendedParameters pKIXExtendedParametersM16080build = c5483Builder.m16080build();
                            Date validityDate = RevocationUtilities.getValidityDate(pKIXExtendedParametersM16080build, date);
                            e = null;
                            int i5 = 0;
                            z = false;
                            while (i5 < distributionPoints.length && certStatus.getCertStatus() == i4 && !reasonsMask.isAllReasons()) {
                                try {
                                    i2 = i5;
                                    pKIXExtendedParameters2 = pKIXExtendedParametersM16080build;
                                    distributionPointArr = distributionPoints;
                                    i3 = i4;
                                    try {
                                        RFC3280CertPathUtilities.checkCRL(distributionPoints[i5], pKIXExtendedParametersM16080build, date, validityDate, x509Certificate, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                                        z = true;
                                    } catch (AnnotatedException e2) {
                                        e = e2;
                                    }
                                } catch (AnnotatedException e3) {
                                    e = e3;
                                    i2 = i5;
                                    pKIXExtendedParameters2 = pKIXExtendedParametersM16080build;
                                    distributionPointArr = distributionPoints;
                                    i3 = i4;
                                }
                                i5 = i2 + 1;
                                i4 = i3;
                                pKIXExtendedParametersM16080build = pKIXExtendedParameters2;
                                distributionPoints = distributionPointArr;
                            }
                            i = i4;
                        } catch (AnnotatedException e4) {
                            throw new AnnotatedException("no additional CRL locations could be decoded from CRL distribution point extension", e4);
                        }
                    } else {
                        i = 11;
                        e = null;
                        z = false;
                    }
                } catch (Exception e5) {
                    throw new AnnotatedException("cannot read distribution points", e5);
                }
            }
            if (certStatus.getCertStatus() == i && !reasonsMask.isAllReasons()) {
                try {
                    RFC3280CertPathUtilities.checkCRL(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, X500Name.getInstance(x509Certificate.getIssuerX500Principal().getEncoded())))), null, null), (PKIXExtendedParameters) pKIXExtendedParameters.clone(), date, date2, x509Certificate, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                    z = true;
                } catch (AnnotatedException e6) {
                    e = e6;
                }
            }
            if (!z) {
                if (e == null) {
                    throw new CRLNotFoundException("no valid CRL found");
                }
                throw new CRLNotFoundException("no valid CRL found", e);
            }
            if (certStatus.getCertStatus() == i) {
                if (!reasonsMask.isAllReasons() && certStatus.getCertStatus() == i) {
                    certStatus.setCertStatus(12);
                }
                if (certStatus.getCertStatus() == 12) {
                    throw new AnnotatedException("certificate status could not be determined");
                }
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            throw new AnnotatedException(("certificate [issuer=\"" + x509Certificate.getIssuerX500Principal() + "\",serialNumber=" + x509Certificate.getSerialNumber() + ",subject=\"" + x509Certificate.getSubjectX500Principal() + "\"] revoked after " + simpleDateFormat.format(certStatus.getRevocationDate())) + ", reason: " + crlReasons[certStatus.getCertStatus()]);
        } catch (Exception e7) {
            throw new AnnotatedException("cannot read CRL distribution point extension", e7);
        }
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Object clone() {
        return this;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean z) {
        if (z) {
            throw new IllegalArgumentException("forward processing not supported");
        }
        this.currentDate = new Date();
        this.workingIssuerName = null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    private void addIssuers(final List<X500Principal> list, InterfaceC6249Store<CRL> interfaceC6249Store) {
        interfaceC6249Store.getMatches(new Selector<CRL>(this) { // from class: org.bouncycastle.pkix.jcajce.X509RevocationChecker.2

            /* renamed from: this$0 */
            final /* synthetic */ X509RevocationChecker f22992this$0;

            {
                this.f22992this$0 = this;
            }

            @Override // org.bouncycastle.p361util.Selector
            /* renamed from: clone */
            public Object mo14740clone() {
                return this;
            }

            @Override // org.bouncycastle.p361util.Selector
            /* renamed from: match, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo14742match(CRL crl) {
                if (!(crl instanceof X509CRL)) {
                    return false;
                }
                list.add(((X509CRL) crl).getIssuerX500Principal());
                return false;
            }
        });
    }
}
