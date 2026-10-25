package org.bouncycastle.p281jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.internal.p231asn1.p239isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1OutputStream;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.RFC4519Style;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.CRLDistPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPointName;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.PKIXCRLStore;
import org.bouncycastle.p249jcajce.PKIXCRLStoreSelector;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.PKIXCertStore;
import org.bouncycastle.p249jcajce.PKIXCertStoreSelector;
import org.bouncycastle.p249jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.p281jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Properties;
import org.bouncycastle.p361util.StoreException;
import org.bouncycastle.p366x509.X509AttributeCertificate;

/* loaded from: classes2.dex */
class CertPathValidatorUtilities {
    protected static final String ANY_POLICY = "2.5.29.32.0";
    protected static final int CRL_SIGN = 6;
    protected static final int KEY_CERT_SIGN = 5;
    protected static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.m14433getId();
    protected static final String BASIC_CONSTRAINTS = Extension.basicConstraints.m14433getId();
    protected static final String POLICY_MAPPINGS = Extension.policyMappings.m14433getId();
    protected static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.m14433getId();
    protected static final String NAME_CONSTRAINTS = Extension.nameConstraints.m14433getId();
    protected static final String KEY_USAGE = Extension.keyUsage.m14433getId();
    protected static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.m14433getId();
    protected static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.m14433getId();
    protected static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.m14433getId();
    protected static final String POLICY_CONSTRAINTS = Extension.policyConstraints.m14433getId();
    protected static final String FRESHEST_CRL = Extension.freshestCRL.m14433getId();
    protected static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.m14433getId();
    protected static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.m14433getId();
    protected static final String CRL_NUMBER = Extension.cRLNumber.m14433getId();
    protected static final String REASON_CODE = Extension.reasonCode.m14433getId();
    static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static void checkCRLCriticalExtensions(X509CRL x509crl, String str) throws AnnotatedException {
        int size;
        if (x509crl.hasUnsupportedCriticalExtension()) {
            throw new AnnotatedException(str);
        }
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null || (size = criticalExtensionOIDs.size()) <= 0) {
            return;
        }
        if (criticalExtensionOIDs.contains(ISSUING_DISTRIBUTION_POINT)) {
            size--;
        }
        if (criticalExtensionOIDs.contains(DELTA_CRL_INDICATOR)) {
            size--;
        }
        if (size > 0) {
            throw new AnnotatedException(str);
        }
    }

    public static void checkCRLEntryCriticalExtensions(X509CRLEntry x509CRLEntry, String str) throws AnnotatedException {
        if (x509CRLEntry.hasUnsupportedCriticalExtension()) {
            throw new AnnotatedException(str);
        }
    }

    public static void checkCRLsNotEmpty(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, Set set, Object obj) throws RecoverableCertPathValidatorException {
        if (set.isEmpty()) {
            if (obj instanceof X509AttributeCertificate) {
                throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0] + "\"", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
            }
            throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + RFC4519Style.INSTANCE.toString(PrincipalUtils.getIssuerPrincipal((X509Certificate) obj)) + "\"", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        }
    }

    public static void findCertificates(Set set, PKIXCertStoreSelector pKIXCertStoreSelector, List list) throws AnnotatedException {
        for (Object obj : list) {
            if (obj instanceof InterfaceC6249Store) {
                try {
                    set.addAll(((InterfaceC6249Store) obj).getMatches(pKIXCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            } else {
                try {
                    set.addAll(PKIXCertStoreSelector.getCertificates(pKIXCertStoreSelector, (CertStore) obj));
                } catch (CertStoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
                }
            }
        }
    }

    public static Collection findIssuerCerts(X509Certificate x509Certificate, List<CertStore> list, List<PKIXCertStore> list2) throws AnnotatedException, IOException {
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(PrincipalUtils.getIssuerPrincipal(x509Certificate).getEncoded());
            PKIXCertStoreSelector<? extends Certificate> pKIXCertStoreSelectorM16077build = new PKIXCertStoreSelector.C5479Builder(x509CertSelector).m16077build();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                findCertificates(linkedHashSet, pKIXCertStoreSelectorM16077build, list);
                findCertificates(linkedHashSet, pKIXCertStoreSelectorM16077build, list2);
                return linkedHashSet;
            } catch (AnnotatedException e) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e);
            }
        } catch (Exception e2) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e2);
        }
    }

    public static Collection findTargets(PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters) throws CertPathBuilderException {
        PKIXExtendedParameters baseParameters = pKIXExtendedBuilderParameters.getBaseParameters();
        PKIXCertStoreSelector targetConstraints = baseParameters.getTargetConstraints();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            findCertificates(linkedHashSet, targetConstraints, baseParameters.getCertificateStores());
            findCertificates(linkedHashSet, targetConstraints, baseParameters.getCertStores());
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
            Certificate certificate = targetConstraints.getCertificate();
            if (certificate != null) {
                return Collections.singleton(certificate);
            }
            throw new CertPathBuilderException("No certificate found matching targetConstraints.");
        } catch (AnnotatedException e) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e);
        }
    }

    public static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set) {
        return findTrustAnchor(x509Certificate, set, null);
    }

    public static PKIXPolicyNode findValidPolicy(Iterator it, String str) {
        while (it.hasNext()) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) it.next();
            if (str.equals(pKIXPolicyNode.getValidPolicy())) {
                return pKIXPolicyNode;
            }
        }
        return null;
    }

    public static List<PKIXCertStore> getAdditionalStoresFromAltNames(byte[] bArr, Map<GeneralName, PKIXCertStore> map) {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        GeneralName[] names = GeneralNames.getInstance(ASN1OctetString.getInstance(bArr).getOctets()).getNames();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            PKIXCertStore pKIXCertStore = map.get(names[i]);
            if (pKIXCertStore != null) {
                arrayList.add(pKIXCertStore);
            }
        }
        return arrayList;
    }

    public static List<PKIXCRLStore> getAdditionalStoresFromCRLDistributionPoint(CRLDistPoint cRLDistPoint, PKIXExtendedParameters pKIXExtendedParameters, Date date, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        if (cRLDistPoint == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            ArrayList arrayList = new ArrayList();
            Map<GeneralName, PKIXCRLStore> namedCRLStoreMap = pKIXExtendedParameters.getNamedCRLStoreMap();
            if (!namedCRLStoreMap.isEmpty()) {
                for (DistributionPoint distributionPoint : distributionPoints) {
                    DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                    if (distributionPoint2 != null && distributionPoint2.m14684getType() == 0) {
                        for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.m14683getName()).getNames()) {
                            PKIXCRLStore pKIXCRLStore = namedCRLStoreMap.get(generalName);
                            if (pKIXCRLStore != null) {
                                arrayList.add(pKIXCRLStore);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && Properties.isOverrideSet("org.bouncycastle.x509.enableCRLDP")) {
                try {
                    CertificateFactory certificateFactoryCreateCertificateFactory = jcaJceHelper.createCertificateFactory("X.509");
                    for (DistributionPoint distributionPoint3 : distributionPoints) {
                        DistributionPointName distributionPoint4 = distributionPoint3.getDistributionPoint();
                        if (distributionPoint4 != null && distributionPoint4.m14684getType() == 0) {
                            GeneralName[] names = GeneralNames.getInstance(distributionPoint4.m14683getName()).getNames();
                            int i = 0;
                            while (true) {
                                if (i < names.length) {
                                    GeneralName generalName2 = names[i];
                                    if (generalName2.getTagNo() == 6) {
                                        try {
                                            PKIXCRLStore pKIXCRLStoreM16238getCrl = CrlCache.m16238getCrl(certificateFactoryCreateCertificateFactory, date, new URI(((ASN1String) generalName2.m14690getName()).getString()));
                                            if (pKIXCRLStoreM16238getCrl != null) {
                                                arrayList.add(pKIXCRLStoreM16238getCrl);
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new AnnotatedException("cannot create certificate factory: " + e.getMessage(), e);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            throw new AnnotatedException("Distribution points could not be read.", e2);
        }
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey publicKey) throws ExtCertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm();
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e);
        }
    }

    public static void getCRLIssuersFromDistributionPoint(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector) throws AnnotatedException, IOException {
        ArrayList arrayList = new ArrayList();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    try {
                        arrayList.add(X500Name.getInstance(names[i].m14690getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
        } else {
            if (distributionPoint.getDistributionPoint() == null) {
                throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                x509CRLSelector.addIssuerName(((X500Name) it2.next()).getEncoded());
            } catch (IOException e2) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e2);
            }
        }
    }

    public static void getCertStatus(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        ASN1Enumerated aSN1Enumerated;
        try {
            if (X509CRLObject.isIndirectCRL(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj));
                if (revokedCertificate == null) {
                    return;
                }
                X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                if (!PrincipalUtils.getEncodedIssuerPrincipal(obj).mo14431equals(certificateIssuer == null ? PrincipalUtils.getIssuerPrincipal(x509crl) : PrincipalUtils.getX500Name(certificateIssuer))) {
                    return;
                }
            } else if (!PrincipalUtils.getEncodedIssuerPrincipal(obj).mo14431equals(PrincipalUtils.getIssuerPrincipal(x509crl)) || (revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj))) == null) {
                return;
            }
            if (revokedCertificate.hasExtensions()) {
                checkCRLEntryCriticalExtensions(revokedCertificate, "CRL entry has unsupported critical extensions.");
                try {
                    aSN1Enumerated = ASN1Enumerated.getInstance(getExtensionValue(revokedCertificate, REASON_CODE));
                } catch (Exception e) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e);
                }
            } else {
                aSN1Enumerated = null;
            }
            int iIntValueExact = aSN1Enumerated == null ? 0 : aSN1Enumerated.intValueExact();
            if (date.getTime() >= revokedCertificate.getRevocationDate().getTime() || iIntValueExact == 0 || iIntValueExact == 1 || iIntValueExact == 2 || iIntValueExact == 10) {
                certStatus.setCertStatus(iIntValueExact);
                certStatus.setRevocationDate(revokedCertificate.getRevocationDate());
            }
        } catch (CRLException e2) {
            throw new AnnotatedException("Failed check for indirect CRL.", e2);
        }
    }

    public static Set getCompleteCRLs(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, DistributionPoint distributionPoint, Object obj, PKIXExtendedParameters pKIXExtendedParameters, Date date) throws AnnotatedException, IOException, RecoverableCertPathValidatorException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(PrincipalUtils.getEncodedIssuerPrincipal(obj));
            getCRLIssuersFromDistributionPoint(distributionPoint, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            Set setFindCRLs = PKIXCRLUtil.findCRLs(new PKIXCRLStoreSelector.C5477Builder(x509CRLSelector).setCompleteCRLEnabled(true).m16074build(), date, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores());
            checkCRLsNotEmpty(pKIXCertRevocationCheckerParameters, setFindCRLs, obj);
            return setFindCRLs;
        } catch (AnnotatedException e) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e);
        }
    }

    public static Set getDeltaCRLs(Date date, X509CRL x509crl, List<CertStore> list, List<PKIXCRLStore> list2, JcaJceHelper jcaJceHelper) throws AnnotatedException, IOException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded());
            try {
                ASN1Primitive extensionValue = getExtensionValue(x509crl, CRL_NUMBER);
                BigInteger positiveValue = extensionValue != null ? ASN1Integer.getInstance(extensionValue).getPositiveValue() : null;
                try {
                    byte[] extensionValue2 = x509crl.getExtensionValue(ISSUING_DISTRIBUTION_POINT);
                    x509CRLSelector.setMinCRLNumber(positiveValue != null ? positiveValue.add(BigInteger.valueOf(1L)) : null);
                    PKIXCRLStoreSelector.C5477Builder c5477Builder = new PKIXCRLStoreSelector.C5477Builder(x509CRLSelector);
                    c5477Builder.setIssuingDistributionPoint(extensionValue2);
                    c5477Builder.setIssuingDistributionPointEnabled(true);
                    c5477Builder.setMaxBaseCRLNumber(positiveValue);
                    c5477Builder.setDeltaCRLIndicatorEnabled(true);
                    PKIXCRLStoreSelector<? extends CRL> pKIXCRLStoreSelectorM16074build = c5477Builder.m16074build();
                    Set deltaCRLs = getDeltaCRLs(PKIXCRLUtil.findCRLs(pKIXCRLStoreSelectorM16074build, date, list, list2));
                    if (deltaCRLs.isEmpty() && Properties.isOverrideSet("org.bouncycastle.x509.enableCRLDP")) {
                        try {
                            CertificateFactory certificateFactoryCreateCertificateFactory = jcaJceHelper.createCertificateFactory("X.509");
                            for (DistributionPoint distributionPoint : CRLDistPoint.getInstance(extensionValue2).getDistributionPoints()) {
                                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                                if (distributionPoint2 != null && distributionPoint2.m14684getType() == 0) {
                                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.m14683getName()).getNames();
                                    int i = 0;
                                    while (true) {
                                        if (i < names.length) {
                                            GeneralName generalName = names[i];
                                            if (generalName.getTagNo() == 6) {
                                                try {
                                                    PKIXCRLStore pKIXCRLStoreM16238getCrl = CrlCache.m16238getCrl(certificateFactoryCreateCertificateFactory, date, new URI(((ASN1String) generalName.m14690getName()).getString()));
                                                    if (pKIXCRLStoreM16238getCrl != null) {
                                                        deltaCRLs = getDeltaCRLs(PKIXCRLUtil.findCRLs(pKIXCRLStoreSelectorM16074build, date, Collections.EMPTY_LIST, Collections.singletonList(pKIXCRLStoreM16238getCrl)));
                                                    }
                                                } catch (Exception unused) {
                                                    continue;
                                                }
                                            }
                                            i++;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            throw new AnnotatedException("cannot create certificate factory: " + e.getMessage(), e);
                        }
                    }
                    return deltaCRLs;
                } catch (Exception e2) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e2);
                }
            } catch (Exception e3) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e3);
            }
        } catch (IOException e4) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e4);
        }
    }

    public static ASN1Primitive getExtensionValue(X509Extension x509Extension, String str) {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return getObject(str, extensionValue);
    }

    public static PublicKey getNextWorkingKey(List list, int i, JcaJceHelper jcaJceHelper) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i++;
            if (i >= list.size()) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
            if (!(publicKey2 instanceof DSAPublicKey)) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            dSAPublicKey = (DSAPublicKey) publicKey2;
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return jcaJceHelper.createKeyFactory("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static ASN1Primitive getObject(String str, byte[] bArr) throws AnnotatedException {
        try {
            return ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(bArr).getOctets());
        } catch (Exception e) {
            throw new AnnotatedException("exception processing extension " + str, e);
        }
    }

    public static final Set getQualifierSet(ASN1Sequence aSN1Sequence) throws ExtCertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStreamM14438create = ASN1OutputStream.m14438create(byteArrayOutputStream);
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            try {
                aSN1OutputStreamM14438create.writeObject((ASN1Encodable) objects.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e);
            }
        }
        return hashSet;
    }

    private static BigInteger getSerialNumber(Object obj) {
        return ((X509Certificate) obj).getSerialNumber();
    }

    public static Date getValidCertDateFromValidityModel(Date date, int i, CertPath certPath, int i2) throws AnnotatedException {
        if (1 != i || i2 <= 0) {
            return date;
        }
        int i3 = i2 - 1;
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i3);
        if (i3 == 0) {
            try {
                byte[] extensionValue = x509Certificate.getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.m14433getId());
                ASN1GeneralizedTime aSN1GeneralizedTime = extensionValue != null ? ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extensionValue)) : null;
                if (aSN1GeneralizedTime != null) {
                    try {
                        return aSN1GeneralizedTime.m14427getDate();
                    } catch (ParseException e) {
                        throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e);
                    }
                }
            } catch (IOException unused) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            } catch (IllegalArgumentException unused2) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            }
        }
        return x509Certificate.getNotBefore();
    }

    public static Date getValidityDate(PKIXExtendedParameters pKIXExtendedParameters, Date date) {
        Date validityDate = pKIXExtendedParameters.getValidityDate();
        return validityDate == null ? date : validityDate;
    }

    public static boolean hasCriticalExtension(X509CRL x509crl, String str) {
        return hasCriticalExtension(x509crl.getCriticalExtensionOIDs(), str);
    }

    public static boolean isAnyPolicy(Set set) {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    private static boolean isDeltaCRL(X509CRL x509crl) {
        return hasCriticalExtension(x509crl, DELTA_CRL_INDICATOR);
    }

    public static boolean isIssuerTrustAnchor(X509Certificate x509Certificate, Set set, String str) {
        try {
            return findTrustAnchor(x509Certificate, set, str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSelfIssued(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    public static boolean processCertD1i(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if (pKIXPolicyNode.getExpectedPolicies().contains(aSN1ObjectIdentifier.m14433getId())) {
                HashSet hashSet = new HashSet();
                hashSet.add(aSN1ObjectIdentifier.m14433getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, aSN1ObjectIdentifier.m14433getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return true;
            }
        }
        return false;
    }

    public static void processCertD1ii(int i, List[] listArr, ASN1ObjectIdentifier aSN1ObjectIdentifier, Set set) {
        PKIXPolicyNode pKIXPolicyNodeFindValidPolicy = findValidPolicy(listArr[i - 1].iterator(), "2.5.29.32.0");
        if (pKIXPolicyNodeFindValidPolicy != null) {
            String strM14433getId = aSN1ObjectIdentifier.m14433getId();
            HashSet hashSet = new HashSet();
            hashSet.add(strM14433getId);
            PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNodeFindValidPolicy, set, strM14433getId, false);
            pKIXPolicyNodeFindValidPolicy.addChild(pKIXPolicyNode);
            listArr[i].add(pKIXPolicyNode);
        }
    }

    public static PKIXPolicyNode removeChildlessPolicyNodes(PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i) {
        if (pKIXPolicyNode == null) {
            return null;
        }
        while (true) {
            i--;
            if (i < 0) {
                return pKIXPolicyNode;
            }
            List list = listArr[i];
            int size = list.size();
            while (true) {
                size--;
                if (size >= 0) {
                    PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(size);
                    if (!pKIXPolicyNode2.hasChildren()) {
                        list.remove(size);
                        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
                        if (pKIXPolicyNode3 == null) {
                            return null;
                        }
                        pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
                    }
                }
            }
        }
    }

    public static PKIXPolicyNode removePolicyNode(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        if (pKIXPolicyNode == null) {
            return null;
        }
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode3 != null) {
            pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
            removePolicyNodeRecurse(listArr, pKIXPolicyNode2);
            return pKIXPolicyNode;
        }
        for (List list : listArr) {
            list.clear();
        }
        return null;
    }

    private static void removePolicyNodeRecurse(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.hasChildren()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                removePolicyNodeRecurse(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }

    public static void verifyX509Certificate(X509Certificate x509Certificate, PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[PHI: r5
      0x003c: PHI (r5v5 org.bouncycastle.asn1.x500.X500Name) = 
      (r5v1 org.bouncycastle.asn1.x500.X500Name)
      (r5v1 org.bouncycastle.asn1.x500.X500Name)
      (r5v1 org.bouncycastle.asn1.x500.X500Name)
      (r5v2 org.bouncycastle.asn1.x500.X500Name)
      (r5v2 org.bouncycastle.asn1.x500.X500Name)
      (r5v1 org.bouncycastle.asn1.x500.X500Name)
     binds: [B:13:0x0042, B:15:0x0048, B:17:0x004e, B:34:0x003c, B:21:0x006a, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set, String str) throws AnnotatedException {
        X509CertSelector x509CertSelector = new X509CertSelector();
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        x509CertSelector.setSubject(issuerX500Principal);
        Iterator it = set.iterator();
        TrustAnchor trustAnchor = null;
        Exception e = null;
        X500Name x500Name = null;
        PublicKey cAPublicKey = null;
        while (it.hasNext() && trustAnchor == null) {
            trustAnchor = (TrustAnchor) it.next();
            if (trustAnchor.getTrustedCert() != null) {
                if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                    cAPublicKey = trustAnchor.getTrustedCert().getPublicKey();
                } else {
                    trustAnchor = null;
                }
            } else if (trustAnchor.getCA() != null && trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null) {
                if (x500Name == null) {
                    x500Name = X500Name.getInstance(issuerX500Principal.getEncoded());
                }
                try {
                    if (x500Name.mo14431equals(X500Name.getInstance(trustAnchor.getCA().getEncoded()))) {
                        cAPublicKey = trustAnchor.getCAPublicKey();
                    }
                } catch (IllegalArgumentException unused) {
                }
            }
            if (cAPublicKey != null) {
                try {
                    verifyX509Certificate(x509Certificate, cAPublicKey, str);
                } catch (Exception e2) {
                    e = e2;
                    trustAnchor = null;
                    cAPublicKey = null;
                }
            }
        }
        if (trustAnchor != null || e == null) {
            return trustAnchor;
        }
        throw new AnnotatedException("TrustAnchor found but certificate validation failed.", e);
    }

    private static Set getDeltaCRLs(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            if (isDeltaCRL(x509crl)) {
                hashSet.add(x509crl);
            }
        }
        return hashSet;
    }

    public static boolean hasCriticalExtension(X509Certificate x509Certificate, String str) {
        return hasCriticalExtension(x509Certificate.getCriticalExtensionOIDs(), str);
    }

    private static boolean hasCriticalExtension(Set set, String str) {
        return set != null && set.contains(str);
    }
}
