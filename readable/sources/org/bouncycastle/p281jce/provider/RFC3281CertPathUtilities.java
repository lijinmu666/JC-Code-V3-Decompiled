package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.p174x509.CRLDistPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPoint;
import org.bouncycastle.p133asn1.p174x509.DistributionPointName;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.TargetInformation;
import org.bouncycastle.p133asn1.p174x509.X509Extensions;
import org.bouncycastle.p249jcajce.PKIXCRLStore;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.PKIXCertStoreSelector;
import org.bouncycastle.p249jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.p249jcajce.PKIXExtendedParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.p366x509.PKIXAttrCertChecker;
import org.bouncycastle.p366x509.X509AttributeCertificate;
import org.bouncycastle.p366x509.X509CertStoreSelector;

/* loaded from: classes2.dex */
class RFC3281CertPathUtilities {
    private static final String TARGET_INFORMATION = Extension.targetInformation.m14433getId();
    private static final String NO_REV_AVAIL = Extension.noRevAvail.m14433getId();
    private static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.m14433getId();
    private static final String AUTHORITY_INFO_ACCESS = Extension.authorityInfoAccess.m14433getId();

    public static void additionalChecks(X509AttributeCertificate x509AttributeCertificate, Set set, Set set2) throws CertPathValidatorException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (x509AttributeCertificate.getAttributes(str) != null) {
                throw new CertPathValidatorException("Attribute certificate contains prohibited attribute: " + str + ".");
            }
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (x509AttributeCertificate.getAttributes(str2) == null) {
                throw new CertPathValidatorException("Attribute certificate does not contain necessary attribute: " + str2 + ".");
            }
        }
    }

    private static void checkCRL(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        if (x509AttributeCertificate.getExtensionValue(X509Extensions.NoRevAvail.m14433getId()) != null) {
            return;
        }
        if (date2.getTime() > date.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it = CertPathValidatorUtilities.getCompleteCRLs(new PKIXCertRevocationCheckerParameters(pKIXExtendedParameters, date2, null, -1, x509Certificate, null), distributionPoint, x509AttributeCertificate, pKIXExtendedParameters, date2).iterator();
        boolean z = false;
        AnnotatedException e = null;
        while (it.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
            try {
                X509CRL x509crl = (X509CRL) it.next();
                CertPathValidatorUtilities.checkCRLCriticalExtensions(x509crl, "CRL contains unsupported critical extensions.");
                ReasonsMask reasonsMaskProcessCRLD = RFC3280CertPathUtilities.processCRLD(x509crl, distributionPoint);
                if (reasonsMaskProcessCRLD.hasNewReasons(reasonsMask)) {
                    PublicKey publicKeyProcessCRLG = RFC3280CertPathUtilities.processCRLG(x509crl, RFC3280CertPathUtilities.processCRLF(x509crl, x509AttributeCertificate, null, null, pKIXExtendedParameters, list, jcaJceHelper));
                    if (pKIXExtendedParameters.getValidityModel() != 1 && x509AttributeCertificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                        throw new AnnotatedException("No valid CRL for current time found.");
                    }
                    RFC3280CertPathUtilities.processCRLB1(distributionPoint, x509AttributeCertificate, x509crl);
                    RFC3280CertPathUtilities.processCRLB2(distributionPoint, x509AttributeCertificate, x509crl);
                    if (pKIXExtendedParameters.isUseDeltasEnabled()) {
                        try {
                            X509CRL x509crlProcessCRLH = RFC3280CertPathUtilities.processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date, x509crl, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores(), jcaJceHelper), publicKeyProcessCRLG);
                            if (x509crlProcessCRLH != null) {
                                CertPathValidatorUtilities.checkCRLCriticalExtensions(x509crlProcessCRLH, "Delta CRL contains unsupported critical extensions.");
                                RFC3280CertPathUtilities.processCRLC(x509crlProcessCRLH, x509crl);
                                RFC3280CertPathUtilities.processCRLI(date2, x509crlProcessCRLH, x509AttributeCertificate, certStatus);
                            }
                        } catch (AnnotatedException e2) {
                            e = e2;
                        }
                    }
                    RFC3280CertPathUtilities.processCRLJ(date2, x509crl, x509AttributeCertificate, certStatus);
                    if (certStatus.getCertStatus() == 8) {
                        certStatus.setCertStatus(11);
                    }
                    reasonsMask.addReasons(reasonsMaskProcessCRLD);
                    z = true;
                }
            } catch (AnnotatedException e3) {
                e = e3;
            }
        }
        if (!z) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkCRLs(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, List list, JcaJceHelper jcaJceHelper) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CertPathValidatorException, CRLException, NoSuchProviderException {
        AnnotatedException annotatedException;
        boolean z;
        String str;
        CertStatus certStatus;
        int i;
        DistributionPoint[] distributionPointArr;
        String str2;
        CertStatus certStatus2;
        CertStatus certStatus3;
        if (pKIXExtendedParameters.isRevocationEnabled()) {
            if (x509AttributeCertificate.getExtensionValue(NO_REV_AVAIL) != null) {
                if (x509AttributeCertificate.getExtensionValue(CRL_DISTRIBUTION_POINTS) != null || x509AttributeCertificate.getExtensionValue(AUTHORITY_INFO_ACCESS) != null) {
                    throw new CertPathValidatorException("No rev avail extension is set, but also an AC revocation pointer.");
                }
                return;
            }
            try {
                CRLDistPoint cRLDistPoint = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, CRL_DISTRIBUTION_POINTS));
                try {
                    List<PKIXCRLStore> additionalStoresFromCRLDistributionPoint = CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(cRLDistPoint, pKIXExtendedParameters, date2, jcaJceHelper);
                    PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXExtendedParameters);
                    Iterator<PKIXCRLStore> it = additionalStoresFromCRLDistributionPoint.iterator();
                    while (it.hasNext()) {
                        c5483Builder.addCRLStore((PKIXCRLStore) additionalStoresFromCRLDistributionPoint);
                    }
                    PKIXExtendedParameters pKIXExtendedParametersM16080build = c5483Builder.m16080build();
                    CertStatus certStatus4 = new CertStatus();
                    ReasonsMask reasonsMask = new ReasonsMask();
                    String str3 = "No valid CRL for distribution point found.";
                    boolean z2 = true;
                    if (cRLDistPoint != null) {
                        try {
                            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
                            if (distributionPoints != null) {
                                annotatedException = null;
                                int i2 = 0;
                                z = false;
                                for (int i3 = 11; i2 < distributionPoints.length && certStatus4.getCertStatus() == i3 && !reasonsMask.isAllReasons(); i3 = 11) {
                                    try {
                                        i = i2;
                                        distributionPointArr = distributionPoints;
                                        str2 = str3;
                                        certStatus2 = certStatus4;
                                    } catch (AnnotatedException e) {
                                        e = e;
                                        i = i2;
                                        distributionPointArr = distributionPoints;
                                        str2 = str3;
                                        certStatus2 = certStatus4;
                                    }
                                    try {
                                        checkCRL(distributionPoints[i2], x509AttributeCertificate, pKIXExtendedParametersM16080build, date, date2, x509Certificate, certStatus4, reasonsMask, list, jcaJceHelper);
                                        z = true;
                                    } catch (AnnotatedException e2) {
                                        e = e2;
                                        annotatedException = new AnnotatedException(str2, e);
                                        i2 = i + 1;
                                        str3 = str2;
                                        distributionPoints = distributionPointArr;
                                        certStatus4 = certStatus2;
                                    }
                                    i2 = i + 1;
                                    str3 = str2;
                                    distributionPoints = distributionPointArr;
                                    certStatus4 = certStatus2;
                                }
                                str = str3;
                                certStatus = certStatus4;
                            } else {
                                str = "No valid CRL for distribution point found.";
                                certStatus = certStatus4;
                                annotatedException = null;
                                z = false;
                            }
                        } catch (Exception e3) {
                            throw new ExtCertPathValidatorException("Distribution points could not be read.", e3);
                        }
                    }
                    if (certStatus.getCertStatus() != 11 || reasonsMask.isAllReasons()) {
                        z2 = z;
                    } else {
                        try {
                            try {
                                checkCRL(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, PrincipalUtils.getIssuerPrincipal(x509AttributeCertificate)))), null, null), x509AttributeCertificate, (PKIXExtendedParameters) pKIXExtendedParameters.clone(), date, date2, x509Certificate, certStatus, reasonsMask, list, jcaJceHelper);
                            } catch (Exception e4) {
                                throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", e4);
                            }
                        } catch (AnnotatedException e5) {
                            annotatedException = new AnnotatedException(str, e5);
                        }
                    }
                    if (!z2) {
                        throw new ExtCertPathValidatorException("No valid CRL found.", annotatedException);
                    }
                    if (certStatus.getCertStatus() == 11) {
                        if (reasonsMask.isAllReasons() || certStatus.getCertStatus() != 11) {
                            certStatus3 = certStatus;
                        } else {
                            certStatus3 = certStatus;
                            certStatus3.setCertStatus(12);
                        }
                        if (certStatus3.getCertStatus() == 12) {
                            throw new CertPathValidatorException("Attribute certificate status could not be determined.");
                        }
                        return;
                    }
                    CertStatus certStatus5 = certStatus;
                    throw new CertPathValidatorException(("Attribute certificate revocation after " + certStatus5.getRevocationDate()) + ", reason: " + RFC3280CertPathUtilities.crlReasons[certStatus5.getCertStatus()]);
                } catch (AnnotatedException e6) {
                    throw new CertPathValidatorException("No additional CRL locations could be decoded from CRL distribution point extension.", e6);
                }
            } catch (AnnotatedException e7) {
                throw new CertPathValidatorException("CRL distribution point extension could not be read.", e7);
            }
        }
    }

    public static CertPath processAttrCert1(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathBuilderException, NoSuchAlgorithmException, IOException, CertPathValidatorException, NoSuchProviderException, InvalidAlgorithmParameterException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (x509AttributeCertificate.getHolder().getIssuer() != null) {
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setSerialNumber(x509AttributeCertificate.getHolder().getSerialNumber());
            for (Principal principal : x509AttributeCertificate.getHolder().getIssuer()) {
                try {
                    if (principal instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) principal).getEncoded());
                    }
                    CertPathValidatorUtilities.findCertificates(linkedHashSet, new PKIXCertStoreSelector.C5479Builder(x509CertSelector).m16077build(), pKIXExtendedParameters.getCertStores());
                } catch (IOException e) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e);
                } catch (AnnotatedException e2) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e2);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate.getHolder().getEntityNames() != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            for (Principal principal2 : x509AttributeCertificate.getHolder().getEntityNames()) {
                try {
                    if (principal2 instanceof X500Principal) {
                        x509CertStoreSelector.setIssuer(((X500Principal) principal2).getEncoded());
                    }
                    CertPathValidatorUtilities.findCertificates(linkedHashSet, new PKIXCertStoreSelector.C5479Builder(x509CertStoreSelector).m16077build(), pKIXExtendedParameters.getCertStores());
                } catch (IOException e3) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e3);
                } catch (AnnotatedException e4) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e4);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        PKIXExtendedParameters.C5483Builder c5483Builder = new PKIXExtendedParameters.C5483Builder(pKIXExtendedParameters);
        Iterator it = linkedHashSet.iterator();
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResultBuild = null;
        while (it.hasNext()) {
            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
            x509CertStoreSelector2.setCertificate((X509Certificate) it.next());
            c5483Builder.setTargetConstraints(new PKIXCertStoreSelector.C5479Builder(x509CertStoreSelector2).m16077build());
            try {
                try {
                    certPathBuilderResultBuild = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).build(new PKIXExtendedBuilderParameters.C5481Builder(c5483Builder.m16080build()).m16078build());
                } catch (InvalidAlgorithmParameterException e5) {
                    throw new RuntimeException(e5.getMessage());
                } catch (CertPathBuilderException e6) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be built.", e6);
                }
            } catch (NoSuchAlgorithmException e7) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e7);
            } catch (NoSuchProviderException e8) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e8);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResultBuild.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    public static CertPathValidatorResult processAttrCert2(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters) throws ExtCertPathValidatorException {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).validate(certPath, pKIXExtendedParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e.getMessage());
            } catch (CertPathValidatorException e2) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e3);
        } catch (NoSuchProviderException e4) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e4);
        }
    }

    public static void processAttrCert3(X509Certificate x509Certificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (keyUsage != null && ((keyUsage.length <= 0 || !keyUsage[0]) && (keyUsage.length <= 1 || !keyUsage[1]))) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        }
        if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    public static void processAttrCert4(X509Certificate x509Certificate, Set set) throws CertPathValidatorException {
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            TrustAnchor trustAnchor = (TrustAnchor) it.next();
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z = true;
            }
        }
        if (!z) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    public static void processAttrCert5(X509AttributeCertificate x509AttributeCertificate, Date date) throws ExtCertPathValidatorException {
        try {
            x509AttributeCertificate.checkValidity(date);
        } catch (CertificateExpiredException e) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e);
        } catch (CertificateNotYetValidException e2) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e2);
        }
    }

    public static void processAttrCert7(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, PKIXExtendedParameters pKIXExtendedParameters, Set set) throws CertPathValidatorException {
        Set<String> criticalExtensionOIDs = x509AttributeCertificate.getCriticalExtensionOIDs();
        String str = TARGET_INFORMATION;
        if (criticalExtensionOIDs.contains(str)) {
            try {
                TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, str));
            } catch (IllegalArgumentException e) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e);
            } catch (AnnotatedException e2) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e2);
            }
        }
        criticalExtensionOIDs.remove(str);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((PKIXAttrCertChecker) it.next()).m18388check(x509AttributeCertificate, certPath, certPath2, criticalExtensionOIDs);
        }
        if (criticalExtensionOIDs.isEmpty()) {
            return;
        }
        throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
    }
}
