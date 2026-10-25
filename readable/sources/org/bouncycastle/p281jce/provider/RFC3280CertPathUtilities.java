package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;
import org.bouncycastle.p133asn1.p174x509.BasicConstraints;
import org.bouncycastle.p133asn1.p174x509.CRLDistPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPointName;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.GeneralSubtree;
import org.bouncycastle.p133asn1.p174x509.IssuingDistributionPoint;
import org.bouncycastle.p133asn1.p174x509.NameConstraints;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;
import org.bouncycastle.p249jcajce.PKIXCRLStore;
import org.bouncycastle.p249jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.PKIXCertStoreSelector;
import org.bouncycastle.p249jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.ClassUtil;
import org.bouncycastle.p281jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
class RFC3280CertPathUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    protected static final int CRL_SIGN = 6;
    protected static final int KEY_CERT_SIGN = 5;
    private static final Class revChkClass = ClassUtil.loadClass(RFC3280CertPathUtilities.class, "java.security.cert.PKIXRevocationChecker");
    public static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.m14433getId();
    public static final String POLICY_MAPPINGS = Extension.policyMappings.m14433getId();
    public static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.m14433getId();
    public static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.m14433getId();
    public static final String FRESHEST_CRL = Extension.freshestCRL.m14433getId();
    public static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.m14433getId();
    public static final String POLICY_CONSTRAINTS = Extension.policyConstraints.m14433getId();
    public static final String BASIC_CONSTRAINTS = Extension.basicConstraints.m14433getId();
    public static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.m14433getId();
    public static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.m14433getId();
    public static final String NAME_CONSTRAINTS = Extension.nameConstraints.m14433getId();
    public static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.m14433getId();
    public static final String KEY_USAGE = Extension.keyUsage.m14433getId();
    public static final String CRL_NUMBER = Extension.cRLNumber.m14433getId();
    public static final String REASON_CODE = Extension.reasonCode.m14433getId();
    static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    private static void checkCRL(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, DistributionPoint distributionPoint, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        Iterator it;
        if (date2.getTime() > date.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(pKIXCertRevocationCheckerParameters, distributionPoint, x509Certificate, pKIXExtendedParameters, date2).iterator();
        boolean z = false;
        AnnotatedException e = null;
        while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
            try {
                X509CRL x509crl = (X509CRL) it2.next();
                CertPathValidatorUtilities.checkCRLCriticalExtensions(x509crl, "CRL contains unsupported critical extensions.");
                ReasonsMask reasonsMaskProcessCRLD = processCRLD(x509crl, distributionPoint);
                if (reasonsMaskProcessCRLD.hasNewReasons(reasonsMask)) {
                    it = it2;
                    AnnotatedException annotatedException = e;
                    try {
                        PublicKey publicKeyProcessCRLG = processCRLG(x509crl, processCRLF(x509crl, x509Certificate, x509Certificate2, publicKey, pKIXExtendedParameters, list, jcaJceHelper));
                        if (pKIXExtendedParameters.getValidityModel() != 1 && x509Certificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                            throw new AnnotatedException("No valid CRL for current time found.");
                        }
                        processCRLB1(distributionPoint, x509Certificate, x509crl);
                        processCRLB2(distributionPoint, x509Certificate, x509crl);
                        if (pKIXExtendedParameters.isUseDeltasEnabled()) {
                            try {
                                X509CRL x509crlProcessCRLH = processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date2, x509crl, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores(), jcaJceHelper), publicKeyProcessCRLG);
                                if (x509crlProcessCRLH != null) {
                                    CertPathValidatorUtilities.checkCRLCriticalExtensions(x509crlProcessCRLH, "Delta CRL contains unsupported critical extensions.");
                                    processCRLC(x509crlProcessCRLH, x509crl);
                                    processCRLI(date2, x509crlProcessCRLH, x509Certificate, certStatus);
                                }
                            } catch (AnnotatedException e2) {
                                e = e2;
                                it2 = it;
                            }
                        }
                        processCRLJ(date2, x509crl, x509Certificate, certStatus);
                        if (certStatus.getCertStatus() == 8) {
                            certStatus.setCertStatus(11);
                        }
                        reasonsMask.addReasons(reasonsMaskProcessCRLD);
                        it2 = it;
                        e = annotatedException;
                        z = true;
                    } catch (AnnotatedException e3) {
                        e = e3;
                    }
                } else {
                    continue;
                }
            } catch (AnnotatedException e4) {
                e = e4;
                it = it2;
            }
        }
        AnnotatedException annotatedException2 = e;
        if (!z) {
            throw annotatedException2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103 A[PHI: r0
      0x0103: PHI (r0v14 'e' org.bouncycastle.jce.provider.AnnotatedException) = 
      (r0v13 'e' org.bouncycastle.jce.provider.AnnotatedException)
      (r0v28 'e' org.bouncycastle.jce.provider.AnnotatedException)
      (r0v13 'e' org.bouncycastle.jce.provider.AnnotatedException)
     binds: [B:37:0x00b3, B:43:0x00f8, B:39:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkCRLs(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, List list, JcaJceHelper jcaJceHelper) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        AnnotatedException e;
        boolean z;
        int i;
        CertStatus certStatus;
        int i2;
        DistributionPoint[] distributionPointArr;
        int i3;
        CertStatus certStatus2;
        CertStatus certStatus3;
        try {
            CRLDistPoint cRLDistPoint = CRLDistPoint.getInstance(getExtensionValue(x509Certificate, CRL_DISTRIBUTION_POINTS));
            try {
                List<PKIXCRLStore> additionalStoresFromCRLDistributionPoint = CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(cRLDistPoint, pKIXExtendedParameters, date2, jcaJceHelper);
                PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXExtendedParameters);
                Iterator<PKIXCRLStore> it = additionalStoresFromCRLDistributionPoint.iterator();
                while (it.hasNext()) {
                    c5483Builder.addCRLStore(it.next());
                }
                PKIXExtendedParameters pKIXExtendedParametersM16080build = c5483Builder.m16080build();
                CertStatus certStatus4 = new CertStatus();
                ReasonsMask reasonsMask = new ReasonsMask();
                boolean z2 = true;
                int i4 = 11;
                if (cRLDistPoint != null) {
                    try {
                        DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
                        if (distributionPoints != null) {
                            e = null;
                            int i5 = 0;
                            z = false;
                            while (i5 < distributionPoints.length && certStatus4.getCertStatus() == i4 && !reasonsMask.isAllReasons()) {
                                try {
                                    i2 = i5;
                                    distributionPointArr = distributionPoints;
                                    i3 = i4;
                                    certStatus2 = certStatus4;
                                    try {
                                        checkCRL(pKIXCertRevocationCheckerParameters, distributionPoints[i5], pKIXExtendedParametersM16080build, date, date2, x509Certificate, x509Certificate2, publicKey, certStatus4, reasonsMask, list, jcaJceHelper);
                                        z = true;
                                    } catch (AnnotatedException e2) {
                                        e = e2;
                                    }
                                } catch (AnnotatedException e3) {
                                    e = e3;
                                    i2 = i5;
                                    distributionPointArr = distributionPoints;
                                    i3 = i4;
                                    certStatus2 = certStatus4;
                                }
                                i5 = i2 + 1;
                                i4 = i3;
                                distributionPoints = distributionPointArr;
                                certStatus4 = certStatus2;
                            }
                            i = i4;
                            certStatus = certStatus4;
                        } else {
                            i = 11;
                            certStatus = certStatus4;
                            e = null;
                            z = false;
                        }
                    } catch (Exception e4) {
                        throw new AnnotatedException("Distribution points could not be read.", e4);
                    }
                }
                if (certStatus.getCertStatus() == i) {
                    try {
                    } catch (AnnotatedException e5) {
                        e = e5;
                    }
                    if (reasonsMask.isAllReasons()) {
                        z2 = z;
                    } else {
                        try {
                            checkCRL(pKIXCertRevocationCheckerParameters, new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, PrincipalUtils.getIssuerPrincipal(x509Certificate)))), null, null), (PKIXExtendedParameters) pKIXExtendedParameters.clone(), date, date2, x509Certificate, x509Certificate2, publicKey, certStatus, reasonsMask, list, jcaJceHelper);
                        } catch (RuntimeException e6) {
                            throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", e6);
                        }
                    }
                }
                if (!z2) {
                    if (e == null) {
                        throw new AnnotatedException("No valid CRL found.", e);
                    }
                    throw e;
                }
                if (certStatus.getCertStatus() == i) {
                    if (reasonsMask.isAllReasons() || certStatus.getCertStatus() != i) {
                        certStatus3 = certStatus;
                    } else {
                        certStatus3 = certStatus;
                        certStatus3.setCertStatus(12);
                    }
                    if (certStatus3.getCertStatus() == 12) {
                        throw new AnnotatedException("Certificate status could not be determined.");
                    }
                    return;
                }
                CertStatus certStatus5 = certStatus;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                throw new AnnotatedException(("Certificate revocation after " + simpleDateFormat.format(certStatus5.getRevocationDate())) + ", reason: " + crlReasons[certStatus5.getCertStatus()]);
            } catch (AnnotatedException e7) {
                throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", e7);
            }
        } catch (Exception e8) {
            throw new AnnotatedException("CRL distribution point extension could not be read.", e8);
        }
    }

    private static ASN1Primitive getExtensionValue(X509Extension x509Extension, String str) {
        return CertPathValidatorUtilities.getExtensionValue(x509Extension, str);
    }

    private static String getUnsupportedCriticalExtensionMessage(Set set) {
        StringBuilder sb = new StringBuilder("Certificate has unsupported critical extension: [");
        Iterator it = set.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((String) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00fd, code lost:
    
        r7 = org.bouncycastle.p281jce.provider.CertPathValidatorUtilities.getQualifierSet(r9.getPolicyQualifiers());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PKIXPolicyNode prepareCertB(CertPath certPath, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, int i2) throws CertPathValidatorException {
        Set qualifierSet;
        X509Certificate x509Certificate;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate2 = (X509Certificate) certificates.get(i);
        int size = certificates.size() - i;
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue(x509Certificate2, POLICY_MAPPINGS));
            if (aSN1Sequence == null) {
                return pKIXPolicyNode;
            }
            HashMap map = new HashMap();
            for (int i3 = 0; i3 < aSN1Sequence.mo14450size(); i3++) {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(i3);
                String strM14433getId = ((ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(0)).m14433getId();
                String strM14433getId2 = ((ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(1)).m14433getId();
                HashSet hashSet = (HashSet) map.get(strM14433getId);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(strM14433getId, hashSet);
                }
                hashSet.add(strM14433getId2);
            }
            PKIXPolicyNode pKIXPolicyNodeRemoveChildlessPolicyNodes = pKIXPolicyNode;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                HashSet hashSet2 = (HashSet) entry.getValue();
                if (i2 <= 0) {
                    List list = listArr[size];
                    int size2 = list.size();
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(size2);
                        if (pKIXPolicyNode2.getValidPolicy().equals(str)) {
                            ((PKIXPolicyNode) pKIXPolicyNode2.getParent()).removeChild(pKIXPolicyNode2);
                            list.remove(size2);
                        }
                    }
                    pKIXPolicyNodeRemoveChildlessPolicyNodes = CertPathValidatorUtilities.removeChildlessPolicyNodes(pKIXPolicyNodeRemoveChildlessPolicyNodes, listArr, size);
                } else {
                    PKIXPolicyNode pKIXPolicyNodeFindValidPolicy = CertPathValidatorUtilities.findValidPolicy(listArr[size].iterator(), str);
                    if (pKIXPolicyNodeFindValidPolicy != null) {
                        pKIXPolicyNodeFindValidPolicy.setExpectedPolicies(hashSet2);
                    } else {
                        PKIXPolicyNode pKIXPolicyNodeFindValidPolicy2 = CertPathValidatorUtilities.findValidPolicy(listArr[size].iterator(), ANY_POLICY);
                        if (pKIXPolicyNodeFindValidPolicy2 != null) {
                            try {
                                Enumeration objects = ASN1Sequence.getInstance(getExtensionValue(x509Certificate2, CERTIFICATE_POLICIES)).getObjects();
                                while (true) {
                                    if (!objects.hasMoreElements()) {
                                        qualifierSet = null;
                                        break;
                                    }
                                    try {
                                        PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                                        if (ANY_POLICY.equals(policyInformation.getPolicyIdentifier().m14433getId())) {
                                            try {
                                                break;
                                            } catch (CertPathValidatorException e) {
                                                throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", e, certPath, i);
                                            }
                                        }
                                    } catch (Exception e2) {
                                        throw new CertPathValidatorException("Policy information could not be decoded.", e2, certPath, i);
                                    }
                                }
                                Set set = qualifierSet;
                                boolean zHasCriticalExtension = CertPathValidatorUtilities.hasCriticalExtension(x509Certificate2, CERTIFICATE_POLICIES);
                                PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNodeFindValidPolicy2.getParent();
                                if (ANY_POLICY.equals(pKIXPolicyNode3.getValidPolicy())) {
                                    x509Certificate = x509Certificate2;
                                    PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), size, hashSet2, pKIXPolicyNode3, set, str, zHasCriticalExtension);
                                    pKIXPolicyNode3.addChild(pKIXPolicyNode4);
                                    listArr[size].add(pKIXPolicyNode4);
                                }
                                x509Certificate2 = x509Certificate;
                            } catch (AnnotatedException e3) {
                                throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", e3, certPath, i);
                            }
                        }
                    }
                    x509Certificate = x509Certificate2;
                    x509Certificate2 = x509Certificate;
                }
            }
            return pKIXPolicyNodeRemoveChildlessPolicyNodes;
        } catch (AnnotatedException e4) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e4, certPath, i);
        }
    }

    public static void prepareNextCertA(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_MAPPINGS));
            if (aSN1Sequence != null) {
                for (int i2 = 0; i2 < aSN1Sequence.mo14450size(); i2++) {
                    try {
                        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i2));
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence2.getObjectAt(0));
                        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = ASN1ObjectIdentifier.getInstance(aSN1Sequence2.getObjectAt(1));
                        if (ANY_POLICY.equals(aSN1ObjectIdentifier.m14433getId())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certPath, i);
                        }
                        if (ANY_POLICY.equals(aSN1ObjectIdentifier2.m14433getId())) {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy", null, certPath, i);
                        }
                    } catch (Exception e) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e, certPath, i);
                    }
                }
            }
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e2, certPath, i);
        }
    }

    public static void prepareNextCertG(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws ExtCertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), NAME_CONSTRAINTS));
            NameConstraints nameConstraints = aSN1Sequence != null ? NameConstraints.getInstance(aSN1Sequence) : null;
            if (nameConstraints == null) {
                return;
            }
            GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
            if (permittedSubtrees != null) {
                try {
                    pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                } catch (Exception e) {
                    throw new ExtCertPathValidatorException("Permitted subtrees could not be built from name constraints extension.", e, certPath, i);
                }
            }
            GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
            if (excludedSubtrees != null) {
                for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                    try {
                        pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                    } catch (Exception e2) {
                        throw new ExtCertPathValidatorException("Excluded subtrees could not be built from name constraints extension.", e2, certPath, i);
                    }
                }
            }
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e3, certPath, i);
        }
    }

    public static int prepareNextCertH1(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    public static int prepareNextCertH2(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    public static int prepareNextCertH3(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r3 = org.bouncycastle.p133asn1.ASN1Integer.getInstance(r1, false).intValueExact();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r3 >= r5) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int prepareNextCertI1(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (aSN1Sequence != null) {
                Enumeration objects = aSN1Sequence.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (aSN1TaggedObject.getTagNo() == 0) {
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, certPath, i);
                    }
                }
            }
            return i2;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e2, certPath, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        r4 = org.bouncycastle.p133asn1.ASN1Integer.getInstance(r1, false).intValueExact();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (r4 >= r6) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int prepareNextCertI2(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (aSN1Sequence != null) {
                Enumeration objects = aSN1Sequence.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (aSN1TaggedObject.getTagNo() == 1) {
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, certPath, i);
                    }
                }
            }
            return i2;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e2, certPath, i);
        }
    }

    public static int prepareNextCertJ(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        int iIntValueExact;
        try {
            ASN1Integer aSN1Integer = ASN1Integer.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), INHIBIT_ANY_POLICY));
            return (aSN1Integer == null || (iIntValueExact = aSN1Integer.intValueExact()) >= i2) ? i2 : iIntValueExact;
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e, certPath, i);
        }
    }

    public static void prepareNextCertK(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            BasicConstraints basicConstraints = BasicConstraints.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), BASIC_CONSTRAINTS));
            if (basicConstraints == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints", null, certPath, i);
            }
            if (!basicConstraints.m14675isCA()) {
                throw new CertPathValidatorException("Not a CA certificate", null, certPath, i);
            }
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    public static int prepareNextCertL(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i))) {
            return i2;
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, i);
    }

    public static int prepareNextCertM(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        ASN1Integer pathLenConstraintInteger;
        try {
            BasicConstraints basicConstraints = BasicConstraints.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), BASIC_CONSTRAINTS));
            return (basicConstraints == null || !basicConstraints.m14675isCA() || (pathLenConstraintInteger = basicConstraints.getPathLenConstraintInteger()) == null) ? i2 : Math.min(i2, pathLenConstraintInteger.intPositiveValueExact());
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    public static void prepareNextCertN(CertPath certPath, int i) throws ExtCertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i)).getKeyUsage();
        if (keyUsage != null) {
            if (keyUsage.length <= 5 || !keyUsage[5]) {
                throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, i);
            }
        }
    }

    public static void prepareNextCertO(CertPath certPath, int i, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new CertPathValidatorException(e.getMessage(), e.getCause(), certPath, i);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException(getUnsupportedCriticalExtensionMessage(set), null, certPath, i);
        }
    }

    public static void processCRLB1(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        ASN1Primitive extensionValue = getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
        boolean z = true;
        boolean z2 = extensionValue != null && IssuingDistributionPoint.getInstance(extensionValue).isIndirectCRL();
        try {
            byte[] encoded = PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded();
            if (distributionPoint.getCRLIssuer() != null) {
                GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
                boolean z3 = false;
                for (int i = 0; i < names.length; i++) {
                    if (names[i].getTagNo() == 4) {
                        try {
                            if (C6238Arrays.areEqual(names[i].m14690getName().toASN1Primitive().getEncoded(), encoded)) {
                                z3 = true;
                            }
                        } catch (IOException e) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                        }
                    }
                }
                if (z3 && !z2) {
                    throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
                }
                if (!z3) {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
                }
                z = z3;
            } else if (!PrincipalUtils.getIssuerPrincipal(x509crl).mo14431equals(PrincipalUtils.getEncodedIssuerPrincipal(obj))) {
                z = false;
            }
            if (!z) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (IOException e2) {
            throw new AnnotatedException("Exception encoding CRL issuer: " + e2.getMessage(), e2);
        }
    }

    public static void processCRLB2(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        int i;
        GeneralName[] names;
        try {
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (issuingDistributionPoint != null) {
                if (issuingDistributionPoint.getDistributionPoint() != null) {
                    DistributionPointName distributionPoint2 = IssuingDistributionPoint.getInstance(issuingDistributionPoint).getDistributionPoint();
                    ArrayList arrayList = new ArrayList();
                    if (distributionPoint2.m14684getType() == 0) {
                        for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.m14683getName()).getNames()) {
                            arrayList.add(generalName);
                        }
                    }
                    if (distributionPoint2.m14684getType() == 1) {
                        try {
                            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(PrincipalUtils.getIssuerPrincipal(x509crl));
                            int iMo14450size = aSN1Sequence.mo14450size();
                            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(iMo14450size + 1);
                            for (int i2 = 0; i2 < iMo14450size; i2++) {
                                aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(i2));
                            }
                            aSN1EncodableVector.m14420add(distributionPoint2.m14683getName());
                            arrayList.add(new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector))));
                        } catch (Exception e) {
                            throw new AnnotatedException("Could not read CRL issuer.", e);
                        }
                    }
                    if (distributionPoint.getDistributionPoint() == null) {
                        if (distributionPoint.getCRLIssuer() == null) {
                            throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                        }
                        GeneralName[] names2 = distributionPoint.getCRLIssuer().getNames();
                        while (i < names2.length) {
                            i = arrayList.contains(names2[i]) ? 0 : i + 1;
                        }
                        throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                    }
                    DistributionPointName distributionPoint3 = distributionPoint.getDistributionPoint();
                    GeneralName[] names3 = distributionPoint3.m14684getType() == 0 ? GeneralNames.getInstance(distributionPoint3.m14683getName()).getNames() : null;
                    if (distributionPoint3.m14684getType() == 1) {
                        if (distributionPoint.getCRLIssuer() != null) {
                            names = distributionPoint.getCRLIssuer().getNames();
                        } else {
                            names = new GeneralName[1];
                            try {
                                names[0] = new GeneralName(PrincipalUtils.getEncodedIssuerPrincipal(obj));
                            } catch (Exception e2) {
                                throw new AnnotatedException("Could not read certificate issuer.", e2);
                            }
                        }
                        names3 = names;
                        for (int i3 = 0; i3 < names3.length; i3++) {
                            Enumeration objects = ASN1Sequence.getInstance(names3[i3].m14690getName().toASN1Primitive()).getObjects();
                            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                            while (objects.hasMoreElements()) {
                                aSN1EncodableVector2.m14420add((ASN1Encodable) objects.nextElement());
                            }
                            aSN1EncodableVector2.m14420add(distributionPoint3.m14683getName());
                            names3[i3] = new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector2)));
                        }
                    }
                    if (names3 != null) {
                        while (i < names3.length) {
                            i = arrayList.contains(names3[i]) ? 0 : i + 1;
                        }
                    }
                    throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                }
                try {
                    BasicConstraints basicConstraints = BasicConstraints.getInstance(getExtensionValue((X509Extension) obj, BASIC_CONSTRAINTS));
                    if (obj instanceof X509Certificate) {
                        if (issuingDistributionPoint.onlyContainsUserCerts() && basicConstraints != null && basicConstraints.m14675isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        }
                        if (issuingDistributionPoint.onlyContainsCACerts() && (basicConstraints == null || !basicConstraints.m14675isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (issuingDistributionPoint.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e3) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e3);
                }
            }
        } catch (Exception e4) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
        }
    }

    public static void processCRLC(X509CRL x509crl, X509CRL x509crl2) throws AnnotatedException {
        try {
            String str = ISSUING_DISTRIBUTION_POINT;
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(getExtensionValue(x509crl2, str));
            if (!PrincipalUtils.getIssuerPrincipal(x509crl).mo14431equals(PrincipalUtils.getIssuerPrincipal(x509crl2))) {
                throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
            }
            try {
                IssuingDistributionPoint issuingDistributionPoint2 = IssuingDistributionPoint.getInstance(getExtensionValue(x509crl, str));
                if (issuingDistributionPoint != null ? !issuingDistributionPoint.mo14431equals(issuingDistributionPoint2) : issuingDistributionPoint2 != null) {
                    throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                }
                try {
                    String str2 = AUTHORITY_KEY_IDENTIFIER;
                    ASN1Primitive extensionValue = getExtensionValue(x509crl2, str2);
                    try {
                        ASN1Primitive extensionValue2 = getExtensionValue(x509crl, str2);
                        if (extensionValue == null) {
                            throw new AnnotatedException("CRL authority key identifier is null.");
                        }
                        if (extensionValue2 == null) {
                            throw new AnnotatedException("Delta CRL authority key identifier is null.");
                        }
                        if (!extensionValue.m14446equals(extensionValue2)) {
                            throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                        }
                    } catch (AnnotatedException e) {
                        throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e);
                    }
                } catch (AnnotatedException e2) {
                    throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e2);
                }
            } catch (Exception e3) {
                throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e3);
            }
        } catch (Exception e4) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
        }
    }

    public static ReasonsMask processCRLD(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        try {
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (issuingDistributionPoint != null && issuingDistributionPoint.getOnlySomeReasons() != null && distributionPoint.getReasons() != null) {
                return new ReasonsMask(distributionPoint.getReasons()).intersect(new ReasonsMask(issuingDistributionPoint.getOnlySomeReasons()));
            }
            if ((issuingDistributionPoint == null || issuingDistributionPoint.getOnlySomeReasons() == null) && distributionPoint.getReasons() == null) {
                return ReasonsMask.allReasons;
            }
            return (distributionPoint.getReasons() == null ? ReasonsMask.allReasons : new ReasonsMask(distributionPoint.getReasons())).intersect(issuingDistributionPoint == null ? ReasonsMask.allReasons : new ReasonsMask(issuingDistributionPoint.getOnlySomeReasons()));
        } catch (Exception e) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Set processCRLF(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, PKIXExtendedParameters pKIXExtendedParameters, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException, IOException {
        int i;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded());
            PKIXCertStoreSelector<? extends Certificate> pKIXCertStoreSelectorM16077build = new PKIXCertStoreSelector.C5479Builder(x509CertSelector).m16077build();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                CertPathValidatorUtilities.findCertificates(linkedHashSet, pKIXCertStoreSelectorM16077build, pKIXExtendedParameters.getCertificateStores());
                CertPathValidatorUtilities.findCertificates(linkedHashSet, pKIXCertStoreSelectorM16077build, pKIXExtendedParameters.getCertStores());
                linkedHashSet.add(x509Certificate);
                Iterator it = linkedHashSet.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            CertPathBuilderSpi pKIXCertPathBuilderSpi_8 = revChkClass != null ? new PKIXCertPathBuilderSpi_8(true) : new PKIXCertPathBuilderSpi(true);
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            PKIXExtendedParameters.C5483Builder targetConstraints = new PKIXExtendedParameters.C5483Builder(pKIXExtendedParameters).setTargetConstraints(new PKIXCertStoreSelector.C5479Builder(x509CertSelector2).m16077build());
                            if (list.contains(x509Certificate2)) {
                                targetConstraints.setRevocationEnabled(false);
                            } else {
                                targetConstraints.setRevocationEnabled(true);
                            }
                            List<? extends Certificate> certificates = pKIXCertPathBuilderSpi_8.engineBuild(new PKIXExtendedBuilderParameters.C5481Builder(targetConstraints.m16080build()).m16078build()).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(CertPathValidatorUtilities.getNextWorkingKey(certificates, 0, jcaJceHelper));
                        } catch (CertPathBuilderException e) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", e);
                        } catch (CertPathValidatorException e2) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e2);
                        } catch (Exception e3) {
                            throw new AnnotatedException(e3.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i = 0; i < arrayList.size(); i++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i)).getKeyUsage();
                    if (keyUsage == null) {
                        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_ca_without_crl_sign", true)) {
                            hashSet.add(arrayList2.get(i));
                        } else {
                            annotatedException = new AnnotatedException("No key usage extension on CRL issuer certificate.");
                        }
                    } else if (keyUsage.length <= 6 || !keyUsage[6]) {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                }
                if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                }
                throw annotatedException;
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e4);
            }
        } catch (IOException e5) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e5);
        }
    }

    public static PublicKey processCRLG(X509CRL x509crl, Set set) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e2) {
                e = e2;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e);
    }

    public static X509CRL processCRLH(Set set, PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e);
    }

    public static void processCRLI(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
    }

    public static void processCRLJ(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        if (certStatus.getCertStatus() == 11) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    public static void processCertA(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, Date date, PKIXCertRevocationChecker pKIXCertRevocationChecker, int i, PublicKey publicKey, boolean z, X500Name x500Name, X509Certificate x509Certificate) throws CertificateNotYetValidException, ExtCertPathValidatorException, CertificateExpiredException {
        X509Certificate x509Certificate2 = (X509Certificate) certPath.getCertificates().get(i);
        if (!z) {
            try {
                CertPathValidatorUtilities.verifyX509Certificate(x509Certificate2, publicKey, pKIXExtendedParameters.getSigProvider());
            } catch (GeneralSecurityException e) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", e, certPath, i);
            }
        }
        try {
            Date validCertDateFromValidityModel = CertPathValidatorUtilities.getValidCertDateFromValidityModel(date, pKIXExtendedParameters.getValidityModel(), certPath, i);
            try {
                x509Certificate2.checkValidity(validCertDateFromValidityModel);
                if (pKIXCertRevocationChecker != null) {
                    pKIXCertRevocationChecker.initialize(new PKIXCertRevocationCheckerParameters(pKIXExtendedParameters, validCertDateFromValidityModel, certPath, i, x509Certificate, publicKey));
                    pKIXCertRevocationChecker.mo16075check(x509Certificate2);
                }
                X500Name issuerPrincipal = PrincipalUtils.getIssuerPrincipal(x509Certificate2);
                if (issuerPrincipal.mo14431equals(x500Name)) {
                    return;
                }
                throw new ExtCertPathValidatorException("IssuerName(" + issuerPrincipal + ") does not match SubjectName(" + x500Name + ") of signing certificate.", null, certPath, i);
            } catch (CertificateExpiredException e2) {
                throw new ExtCertPathValidatorException("Could not validate certificate: " + e2.getMessage(), e2, certPath, i);
            } catch (CertificateNotYetValidException e3) {
                throw new ExtCertPathValidatorException("Could not validate certificate: " + e3.getMessage(), e3, certPath, i);
            }
        } catch (AnnotatedException e4) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", e4, certPath, i);
        }
    }

    public static void processCertBC(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator, boolean z) throws CertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        if ((size - i < size || z) && CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
            return;
        }
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(PrincipalUtils.getSubjectPrincipal(x509Certificate));
            try {
                pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                try {
                    GeneralNames generalNames = GeneralNames.getInstance(getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME));
                    C5188RDN[] c5188rdnArrM14666getRDNs = X500Name.getInstance(aSN1Sequence).m14666getRDNs(C5189BCStyle.EmailAddress);
                    for (int i2 = 0; i2 != c5188rdnArrM14666getRDNs.length; i2++) {
                        String string = ((ASN1String) c5188rdnArrM14666getRDNs[i2].getFirst().getValue()).getString();
                        try {
                            pKIXNameConstraintValidator.checkPermittedEmail(string);
                            pKIXNameConstraintValidator.checkExcludedEmail(string);
                        } catch (PKIXNameConstraintValidatorException e) {
                            throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e, certPath, i);
                        }
                    }
                    if (generalNames != null) {
                        try {
                            GeneralName[] names = generalNames.getNames();
                            for (int i3 = 0; i3 < names.length; i3++) {
                                try {
                                    pKIXNameConstraintValidator.checkPermitted(names[i3]);
                                    pKIXNameConstraintValidator.checkExcluded(names[i3]);
                                } catch (PKIXNameConstraintValidatorException e2) {
                                    throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e2, certPath, i);
                                }
                            }
                        } catch (Exception e3) {
                            throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e3, certPath, i);
                        }
                    }
                } catch (Exception e4) {
                    throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e4, certPath, i);
                }
            } catch (PKIXNameConstraintValidatorException e5) {
                throw new CertPathValidatorException("Subtree check for certificate subject failed.", e5, certPath, i);
            }
        } catch (Exception e6) {
            throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e6, certPath, i);
        }
    }

    public static PKIXPolicyNode processCertD(CertPath certPath, int i, Set set, PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i2, boolean z) throws ExtCertPathValidatorException {
        String strM14433getId;
        Set set2;
        PKIXPolicyNode pKIXPolicyNode2;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        int i3 = size - i;
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue(x509Certificate, CERTIFICATE_POLICIES));
            if (aSN1Sequence == null || pKIXPolicyNode == null) {
                return null;
            }
            Enumeration objects = aSN1Sequence.getObjects();
            HashSet hashSet = new HashSet();
            while (objects.hasMoreElements()) {
                PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                ASN1ObjectIdentifier policyIdentifier = policyInformation.getPolicyIdentifier();
                hashSet.add(policyIdentifier.m14433getId());
                if (!ANY_POLICY.equals(policyIdentifier.m14433getId())) {
                    try {
                        Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(policyInformation.getPolicyQualifiers());
                        if (!CertPathValidatorUtilities.processCertD1i(i3, listArr, policyIdentifier, qualifierSet)) {
                            CertPathValidatorUtilities.processCertD1ii(i3, listArr, policyIdentifier, qualifierSet);
                        }
                    } catch (CertPathValidatorException e) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be built.", e, certPath, i);
                    }
                }
            }
            if (set.isEmpty() || set.contains(ANY_POLICY)) {
                set.clear();
                set.addAll(hashSet);
            } else {
                HashSet hashSet2 = new HashSet();
                for (Object obj : set) {
                    if (hashSet.contains(obj)) {
                        hashSet2.add(obj);
                    }
                }
                set.clear();
                set.addAll(hashSet2);
            }
            if (i2 > 0 || ((i3 < size || z) && CertPathValidatorUtilities.isSelfIssued(x509Certificate))) {
                Enumeration objects2 = aSN1Sequence.getObjects();
                while (true) {
                    if (!objects2.hasMoreElements()) {
                        break;
                    }
                    PolicyInformation policyInformation2 = PolicyInformation.getInstance(objects2.nextElement());
                    if (ANY_POLICY.equals(policyInformation2.getPolicyIdentifier().m14433getId())) {
                        Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(policyInformation2.getPolicyQualifiers());
                        List list = listArr[i3 - 1];
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) list.get(i4);
                            for (Object obj2 : pKIXPolicyNode3.getExpectedPolicies()) {
                                if (obj2 instanceof String) {
                                    strM14433getId = (String) obj2;
                                } else if (obj2 instanceof ASN1ObjectIdentifier) {
                                    strM14433getId = ((ASN1ObjectIdentifier) obj2).m14433getId();
                                }
                                String str = strM14433getId;
                                if (CertPathValidatorUtilities.findValidPolicy(pKIXPolicyNode3.getChildren(), str) == null) {
                                    HashSet hashSet3 = new HashSet();
                                    hashSet3.add(str);
                                    Set set3 = qualifierSet2;
                                    set2 = qualifierSet2;
                                    pKIXPolicyNode2 = pKIXPolicyNode3;
                                    PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i3, hashSet3, pKIXPolicyNode3, set3, str, false);
                                    pKIXPolicyNode2.addChild(pKIXPolicyNode4);
                                    listArr[i3].add(pKIXPolicyNode4);
                                } else {
                                    set2 = qualifierSet2;
                                    pKIXPolicyNode2 = pKIXPolicyNode3;
                                }
                                pKIXPolicyNode3 = pKIXPolicyNode2;
                                qualifierSet2 = set2;
                            }
                        }
                    }
                }
            }
            PKIXPolicyNode pKIXPolicyNodeRemoveChildlessPolicyNodes = CertPathValidatorUtilities.removeChildlessPolicyNodes(pKIXPolicyNode, listArr, i3);
            if (CertPathValidatorUtilities.hasCriticalExtension(x509Certificate, CERTIFICATE_POLICIES)) {
                List list2 = listArr[i3];
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    ((PKIXPolicyNode) list2.get(i5)).setCritical(true);
                }
            }
            return pKIXPolicyNodeRemoveChildlessPolicyNodes;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e2, certPath, i);
        }
    }

    public static PKIXPolicyNode processCertE(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode) throws ExtCertPathValidatorException {
        try {
            if (ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), CERTIFICATE_POLICIES)) == null) {
                return null;
            }
            return pKIXPolicyNode;
        } catch (AnnotatedException e) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e, certPath, i);
        }
    }

    public static void processCertF(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode, int i2) throws ExtCertPathValidatorException {
        if (i2 <= 0 && pKIXPolicyNode == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, certPath, i);
        }
    }

    public static int wrapupCertA(int i, X509Certificate x509Certificate) {
        return (CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i == 0) ? i : i - 1;
    }

    public static int wrapupCertB(CertPath certPath, int i, int i2) throws ExtCertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (aSN1Sequence != null) {
                Enumeration objects = aSN1Sequence.getObjects();
                while (objects.hasMoreElements()) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        try {
                            if (ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact() == 0) {
                                return 0;
                            }
                        } catch (Exception e) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e, certPath, i);
                        }
                    }
                }
            }
            return i2;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e2, certPath, i);
        }
    }

    public static void wrapupCertF(CertPath certPath, int i, List list, Set set) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new ExtCertPathValidatorException(e.getMessage(), e, certPath, i);
            } catch (Exception e2) {
                throw new CertPathValidatorException("Additional certificate path checker failed.", e2, certPath, i);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException(getUnsupportedCriticalExtensionMessage(set), null, certPath, i);
        }
    }

    public static PKIXPolicyNode wrapupCertG(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, Set set, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, Set set2) throws ExtCertPathValidatorException {
        int size = certPath.getCertificates().size();
        if (pKIXPolicyNode == null) {
            if (pKIXExtendedParameters.isExplicitPolicyRequired()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i);
            }
            return null;
        }
        if (CertPathValidatorUtilities.isAnyPolicy(set)) {
            if (pKIXExtendedParameters.isExplicitPolicyRequired()) {
                if (set2.isEmpty()) {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i);
                }
                HashSet hashSet = new HashSet();
                for (List list : listArr) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i2);
                        if (ANY_POLICY.equals(pKIXPolicyNode2.getValidPolicy())) {
                            Iterator children = pKIXPolicyNode2.getChildren();
                            while (children.hasNext()) {
                                hashSet.add(children.next());
                            }
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    set2.contains(((PKIXPolicyNode) it.next()).getValidPolicy());
                }
                pKIXPolicyNode = CertPathValidatorUtilities.removeChildlessPolicyNodes(pKIXPolicyNode, listArr, size);
            }
            return pKIXPolicyNode;
        }
        HashSet<PKIXPolicyNode> hashSet2 = new HashSet();
        for (List list2 : listArr) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) list2.get(i3);
                if (ANY_POLICY.equals(pKIXPolicyNode3.getValidPolicy())) {
                    Iterator children2 = pKIXPolicyNode3.getChildren();
                    while (children2.hasNext()) {
                        PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) children2.next();
                        if (!ANY_POLICY.equals(pKIXPolicyNode4.getValidPolicy())) {
                            hashSet2.add(pKIXPolicyNode4);
                        }
                    }
                }
            }
        }
        for (PKIXPolicyNode pKIXPolicyNode5 : hashSet2) {
            if (!set.contains(pKIXPolicyNode5.getValidPolicy())) {
                pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode5);
            }
        }
        return CertPathValidatorUtilities.removeChildlessPolicyNodes(pKIXPolicyNode, listArr, size);
    }
}
