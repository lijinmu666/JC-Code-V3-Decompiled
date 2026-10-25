package org.bouncycastle.p310pkix.p311jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p174x509.AccessDescription;
import org.bouncycastle.p133asn1.p174x509.AuthorityInformationAccess;
import org.bouncycastle.p133asn1.p174x509.AuthorityKeyIdentifier;
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
import org.bouncycastle.p133asn1.p174x509.qualified.ETSIQCObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.qualified.MonetaryValue;
import org.bouncycastle.p133asn1.p174x509.qualified.QCStatement;
import org.bouncycastle.p133asn1.p174x509.qualified.RFC3739QCObjectIdentifiers;
import org.bouncycastle.p177cert.p185jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p281jce.provider.RFC3280CertPathUtilities;
import org.bouncycastle.p310pkix.PKIXNameConstraintValidator;
import org.bouncycastle.p310pkix.PKIXNameConstraintValidatorException;
import org.bouncycastle.p310pkix.p312util.ErrorBundle;
import org.bouncycastle.p310pkix.p312util.LocaleString;
import org.bouncycastle.p310pkix.p312util.p313filter.TrustedInput;
import org.bouncycastle.p310pkix.p312util.p313filter.UntrustedInput;
import org.bouncycastle.p310pkix.p312util.p313filter.UntrustedUrlInput;
import org.bouncycastle.p361util.C6244Objects;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final int NAME_CHECK_MAX = 1024;
    private static final String RESOURCE_NAME = "org.bouncycastle.pkix.CertPathReviewerMessages";
    protected CertPath certPath;

    /* renamed from: certs */
    protected List f22983certs;
    protected Date currentDate;

    /* renamed from: errors */
    protected List[] f22984errors;
    private boolean initialized;

    /* renamed from: n */
    protected int f22985n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;
    private static final String QC_STATEMENT = Extension.qCStatements.m14433getId();
    private static final String CRL_DIST_POINTS = Extension.cRLDistributionPoints.m14433getId();
    private static final String AUTH_INFO_ACCESS = Extension.authorityInfoAccess.m14433getId();

    public PKIXCertPathReviewer() {
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i != bArr.length; i++) {
                sb.append(Integer.toHexString(bArr[i] & C1126UByte.MAX_VALUE));
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    private void checkCriticalExtensions() throws CertPathReviewerException, CertPathValidatorException {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        Iterator<PKIXCertPathChecker> it = certPathCheckers.iterator();
        while (it.hasNext()) {
            try {
                try {
                    it.next().init(false);
                } catch (CertPathValidatorException e) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
                }
            } catch (CertPathReviewerException e2) {
                addError(e2.getErrorMessage(), e2.getIndex());
                return;
            }
        }
        for (int size = this.f22983certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f22983certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.KEY_USAGE);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_MAPPINGS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.BASIC_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.NAME_CONSTRAINTS);
                if (size == 0) {
                    criticalExtensionOIDs.remove(Extension.extendedKeyUsage.m14433getId());
                }
                String str = QC_STATEMENT;
                if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                Iterator<PKIXCertPathChecker> it2 = certPathCheckers.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e3) {
                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.criticalExtensionError", new Object[]{e3.getMessage(), e3, e3.getClass().getName()}), e3.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it3 = criticalExtensionOIDs.iterator();
                    while (it3.hasNext()) {
                        addError(createErrorBundle("CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(it3.next())}), size);
                    }
                }
            }
        }
    }

    private void checkNameConstraints() throws CertPathReviewerException {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.f22983certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.f22983certs.get(size);
                if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        if (aSN1Sequence2.mo14450size() > 1024) {
                                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.subjAltNameExtError"), this.certPath, size);
                                        }
                                        for (int i = 0; i < aSN1Sequence2.mo14450size(); i++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = NameConstraints.getInstance(aSN1Sequence3);
                        GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                                pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                            }
                        }
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        ASN1Integer pathLenConstraintInteger;
        int iMin = this.f22985n;
        int i = 0;
        for (int size = this.f22983certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f22983certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (iMin <= 0) {
                    addError(createErrorBundle("CertPathReviewer.pathLengthExtended"));
                }
                iMin--;
                i++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(createErrorBundle("CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && basicConstraints.m14675isCA() && (pathLenConstraintInteger = basicConstraints.getPathLenConstraintInteger()) != null) {
                iMin = Math.min(iMin, pathLenConstraintInteger.intPositiveValueExact());
            }
        }
        addNotification(createErrorBundle("CertPathReviewer.totalPathLength", new Object[]{Integers.m18296valueOf(i)}));
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x0415, code lost:
    
        r27 = r0;
        r26 = r3;
        r28 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0421, code lost:
    
        if (org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.isSelfIssued(r4) != false) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0423, code lost:
    
        if (r8 <= 0) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0425, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0427, code lost:
    
        r0 = (org.bouncycastle.p133asn1.ASN1Sequence) org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.getExtensionValue(r4, org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.POLICY_CONSTRAINTS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x042f, code lost:
    
        if (r0 == null) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0431, code lost:
    
        r0 = r0.getObjects();
        r14 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x043a, code lost:
    
        if (r0.hasMoreElements() == false) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x043c, code lost:
    
        r2 = (org.bouncycastle.p133asn1.ASN1TaggedObject) r0.nextElement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0446, code lost:
    
        if (r2.getTagNo() == 0) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0453, code lost:
    
        if (org.bouncycastle.p133asn1.ASN1Integer.getInstance(r2, false).intValueExact() != 0) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0455, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0457, code lost:
    
        r3 = 0;
        r8 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x045a, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x045d, code lost:
    
        if (r28 != null) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0465, code lost:
    
        if (r34.pkixParams.isExplicitPolicyRequired() != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0467, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0475, code lost:
    
        throw new org.bouncycastle.p310pkix.p311jcajce.CertPathReviewerException(createErrorBundle("CertPathReviewer.explicitPolicy"), r34.certPath, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x047a, code lost:
    
        if (org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.isAnyPolicy(r27) == false) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0482, code lost:
    
        if (r34.pkixParams.isExplicitPolicyRequired() == false) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0488, code lost:
    
        if (r13.isEmpty() != false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x048a, code lost:
    
        r0 = new java.util.HashSet();
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0492, code lost:
    
        if (r14 >= r26) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0494, code lost:
    
        r4 = r5[r14];
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x049b, code lost:
    
        if (r6 >= r4.size()) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x049d, code lost:
    
        r9 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r4.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04ab, code lost:
    
        if (org.bouncycastle.p281jce.provider.RFC3280CertPathUtilities.ANY_POLICY.equals(r9.getValidPolicy()) == false) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x04ad, code lost:
    
        r9 = r9.getChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04b5, code lost:
    
        if (r9.hasNext() == false) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04b7, code lost:
    
        r0.add(r9.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04bf, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x04c2, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04c5, code lost:
    
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x04cd, code lost:
    
        if (r0.hasNext() == false) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x04cf, code lost:
    
        r13.contains(((org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r0.next()).getValidPolicy());
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x04dd, code lost:
    
        r0 = r34.f22985n - 1;
        r15 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04e3, code lost:
    
        if (r0 < 0) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04e5, code lost:
    
        r2 = r5[r0];
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x04ec, code lost:
    
        if (r14 >= r2.size()) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04ee, code lost:
    
        r4 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r2.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x04f8, code lost:
    
        if (r4.hasChildren() != false) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x04fa, code lost:
    
        r15 = org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.removePolicyNode(r15, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04fe, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0501, code lost:
    
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0504, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0512, code lost:
    
        throw new org.bouncycastle.p310pkix.p311jcajce.CertPathReviewerException(createErrorBundle("CertPathReviewer.explicitPolicy"), r34.certPath, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0513, code lost:
    
        r9 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0517, code lost:
    
        r0 = new java.util.HashSet();
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x051f, code lost:
    
        if (r14 >= r26) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0521, code lost:
    
        r4 = r5[r14];
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0528, code lost:
    
        if (r6 >= r4.size()) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x052a, code lost:
    
        r9 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r4.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0538, code lost:
    
        if (org.bouncycastle.p281jce.provider.RFC3280CertPathUtilities.ANY_POLICY.equals(r9.getValidPolicy()) == false) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x053a, code lost:
    
        r9 = r9.getChildren();
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0542, code lost:
    
        if (r9.hasNext() == false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0544, code lost:
    
        r10 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0552, code lost:
    
        if (org.bouncycastle.p281jce.provider.RFC3280CertPathUtilities.ANY_POLICY.equals(r10.getValidPolicy()) != false) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0554, code lost:
    
        r0.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0558, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x055b, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x055e, code lost:
    
        r0 = r0.iterator();
        r15 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0568, code lost:
    
        if (r0.hasNext() == false) goto L415;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x056a, code lost:
    
        r2 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r0.next();
        r6 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x057a, code lost:
    
        if (r6.contains(r2.getValidPolicy()) != false) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x057c, code lost:
    
        r15 = org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.removePolicyNode(r15, r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0581, code lost:
    
        r27 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0584, code lost:
    
        if (r15 == null) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0586, code lost:
    
        r0 = r34.f22985n - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x058a, code lost:
    
        if (r0 < 0) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x058c, code lost:
    
        r2 = r5[r0];
        r14 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0593, code lost:
    
        if (r14 >= r2.size()) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0595, code lost:
    
        r4 = (org.bouncycastle.p310pkix.p311jcajce.PKIXPolicyNode) r2.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x059f, code lost:
    
        if (r4.hasChildren() != false) goto L421;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x05a1, code lost:
    
        r15 = org.bouncycastle.p310pkix.p311jcajce.CertPathValidatorUtilities.removePolicyNode(r15, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x05a5, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x05a8, code lost:
    
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x05ab, code lost:
    
        if (r8 > 0) goto L422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x05ad, code lost:
    
        if (r9 == null) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05bb, code lost:
    
        throw new org.bouncycastle.p310pkix.p311jcajce.CertPathReviewerException(createErrorBundle("CertPathReviewer.invalidPolicy"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05c7, code lost:
    
        throw new org.bouncycastle.p310pkix.p311jcajce.CertPathReviewerException(createErrorBundle("CertPathReviewer.policyConstExtError"), r34.certPath, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0239 A[Catch: CertPathReviewerException -> 0x00da, TryCatch #4 {CertPathReviewerException -> 0x00da, blocks: (B:17:0x006f, B:21:0x007d, B:22:0x0088, B:26:0x0096, B:27:0x00a1, B:29:0x00a7, B:31:0x00c8, B:32:0x00d0, B:34:0x00d6, B:38:0x00de, B:39:0x00e9, B:43:0x00f5, B:46:0x00fc, B:47:0x0105, B:49:0x010b, B:51:0x0115, B:54:0x011c, B:56:0x0120, B:97:0x020a, B:99:0x0210, B:100:0x0213, B:102:0x0219, B:104:0x0225, B:107:0x022d, B:108:0x0230, B:109:0x0233, B:111:0x0239, B:112:0x0242, B:114:0x0248, B:122:0x026b, B:123:0x0276, B:124:0x0277, B:126:0x027b, B:128:0x0283, B:129:0x0287, B:131:0x028d, B:134:0x02ad, B:136:0x02b7, B:137:0x02ba, B:138:0x02c5, B:139:0x02c6, B:140:0x02d1, B:142:0x02d4, B:143:0x02e1, B:145:0x02e7, B:147:0x030d, B:149:0x0325, B:148:0x031c, B:150:0x032c, B:151:0x0332, B:153:0x0338, B:155:0x0340, B:165:0x0362, B:159:0x0346, B:160:0x0351, B:162:0x0353, B:163:0x035f, B:167:0x036a, B:176:0x037f, B:178:0x0389, B:179:0x038d, B:181:0x0393, B:186:0x03a3, B:189:0x03b0, B:192:0x03bd, B:194:0x03c7, B:205:0x03fc, B:197:0x03cf, B:198:0x03dc, B:199:0x03dd, B:200:0x03e8, B:202:0x03ea, B:203:0x03f7, B:61:0x012f, B:62:0x0133, B:64:0x0139, B:66:0x014f, B:68:0x0159, B:69:0x015e, B:71:0x0164, B:72:0x0172, B:74:0x0178, B:76:0x0184, B:80:0x0191, B:81:0x0197, B:83:0x019d, B:88:0x01b6, B:77:0x0187, B:79:0x018b, B:92:0x01ef, B:95:0x01fe, B:96:0x0209, B:207:0x0409, B:208:0x0414, B:209:0x0415, B:213:0x0427, B:215:0x0431, B:216:0x0436, B:218:0x043c, B:221:0x044a, B:228:0x045f, B:306:0x05b0, B:307:0x05bb, B:231:0x046a, B:232:0x0475, B:233:0x0476, B:235:0x047c, B:237:0x0484, B:239:0x048a, B:241:0x0494, B:242:0x0497, B:244:0x049d, B:246:0x04ad, B:247:0x04b1, B:249:0x04b7, B:250:0x04bf, B:251:0x04c2, B:252:0x04c5, B:253:0x04c9, B:255:0x04cf, B:256:0x04dd, B:258:0x04e5, B:259:0x04e8, B:261:0x04ee, B:263:0x04fa, B:264:0x04fe, B:265:0x0501, B:267:0x0507, B:268:0x0512, B:270:0x0517, B:272:0x0521, B:273:0x0524, B:275:0x052a, B:277:0x053a, B:278:0x053e, B:280:0x0544, B:282:0x0554, B:283:0x0558, B:284:0x055b, B:285:0x055e, B:286:0x0564, B:288:0x056a, B:290:0x057c, B:293:0x0586, B:295:0x058c, B:296:0x058f, B:298:0x0595, B:300:0x05a1, B:301:0x05a5, B:302:0x05a8, B:308:0x05bc, B:309:0x05c7), top: B:320:0x006f, inners: #0, #1, #2, #3, #5, #6, #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x037d A[PHI: r8 r11
      0x037d: PHI (r8v12 int) = (r8v7 int), (r8v18 int) binds: [B:168:0x036e, B:173:0x0378] A[DONT_GENERATE, DONT_INLINE]
      0x037d: PHI (r11v9 int) = (r11v6 int), (r11v15 int) binds: [B:168:0x036e, B:173:0x0378] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0389 A[Catch: CertPathReviewerException -> 0x00da, AnnotatedException -> 0x03dd, TryCatch #8 {AnnotatedException -> 0x03dd, blocks: (B:176:0x037f, B:178:0x0389, B:179:0x038d, B:181:0x0393, B:186:0x03a3, B:189:0x03b0), top: B:325:0x037f, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0210 A[Catch: CertPathReviewerException -> 0x00da, TryCatch #4 {CertPathReviewerException -> 0x00da, blocks: (B:17:0x006f, B:21:0x007d, B:22:0x0088, B:26:0x0096, B:27:0x00a1, B:29:0x00a7, B:31:0x00c8, B:32:0x00d0, B:34:0x00d6, B:38:0x00de, B:39:0x00e9, B:43:0x00f5, B:46:0x00fc, B:47:0x0105, B:49:0x010b, B:51:0x0115, B:54:0x011c, B:56:0x0120, B:97:0x020a, B:99:0x0210, B:100:0x0213, B:102:0x0219, B:104:0x0225, B:107:0x022d, B:108:0x0230, B:109:0x0233, B:111:0x0239, B:112:0x0242, B:114:0x0248, B:122:0x026b, B:123:0x0276, B:124:0x0277, B:126:0x027b, B:128:0x0283, B:129:0x0287, B:131:0x028d, B:134:0x02ad, B:136:0x02b7, B:137:0x02ba, B:138:0x02c5, B:139:0x02c6, B:140:0x02d1, B:142:0x02d4, B:143:0x02e1, B:145:0x02e7, B:147:0x030d, B:149:0x0325, B:148:0x031c, B:150:0x032c, B:151:0x0332, B:153:0x0338, B:155:0x0340, B:165:0x0362, B:159:0x0346, B:160:0x0351, B:162:0x0353, B:163:0x035f, B:167:0x036a, B:176:0x037f, B:178:0x0389, B:179:0x038d, B:181:0x0393, B:186:0x03a3, B:189:0x03b0, B:192:0x03bd, B:194:0x03c7, B:205:0x03fc, B:197:0x03cf, B:198:0x03dc, B:199:0x03dd, B:200:0x03e8, B:202:0x03ea, B:203:0x03f7, B:61:0x012f, B:62:0x0133, B:64:0x0139, B:66:0x014f, B:68:0x0159, B:69:0x015e, B:71:0x0164, B:72:0x0172, B:74:0x0178, B:76:0x0184, B:80:0x0191, B:81:0x0197, B:83:0x019d, B:88:0x01b6, B:77:0x0187, B:79:0x018b, B:92:0x01ef, B:95:0x01fe, B:96:0x0209, B:207:0x0409, B:208:0x0414, B:209:0x0415, B:213:0x0427, B:215:0x0431, B:216:0x0436, B:218:0x043c, B:221:0x044a, B:228:0x045f, B:306:0x05b0, B:307:0x05bb, B:231:0x046a, B:232:0x0475, B:233:0x0476, B:235:0x047c, B:237:0x0484, B:239:0x048a, B:241:0x0494, B:242:0x0497, B:244:0x049d, B:246:0x04ad, B:247:0x04b1, B:249:0x04b7, B:250:0x04bf, B:251:0x04c2, B:252:0x04c5, B:253:0x04c9, B:255:0x04cf, B:256:0x04dd, B:258:0x04e5, B:259:0x04e8, B:261:0x04ee, B:263:0x04fa, B:264:0x04fe, B:265:0x0501, B:267:0x0507, B:268:0x0512, B:270:0x0517, B:272:0x0521, B:273:0x0524, B:275:0x052a, B:277:0x053a, B:278:0x053e, B:280:0x0544, B:282:0x0554, B:283:0x0558, B:284:0x055b, B:285:0x055e, B:286:0x0564, B:288:0x056a, B:290:0x057c, B:293:0x0586, B:295:0x058c, B:296:0x058f, B:298:0x0595, B:300:0x05a1, B:301:0x05a5, B:302:0x05a8, B:308:0x05bc, B:309:0x05c7), top: B:320:0x006f, inners: #0, #1, #2, #3, #5, #6, #7, #8, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkPolicy() throws CertPathReviewerException {
        int i;
        int i2;
        int size;
        PKIXPolicyNode pKIXPolicyNodePrepareNextCertB2;
        X509Certificate x509Certificate;
        HashSet hashSet;
        Set<String> set;
        int i3;
        int i4;
        String str;
        HashSet hashSet2;
        ASN1Sequence aSN1Sequence;
        ASN1Integer aSN1Integer;
        int iIntValueExact;
        int iIntValueExact2;
        HashSet hashSet3;
        HashSet hashSet4;
        String strM14433getId;
        int i5;
        int i6;
        Set<String> criticalExtensionOIDs;
        Set<String> initialPolicies = this.pkixParams.getInitialPolicies();
        int i7 = this.f22985n + 1;
        ArrayList[] arrayListArr = new ArrayList[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            arrayListArr[i8] = new ArrayList();
        }
        HashSet hashSet5 = new HashSet();
        hashSet5.add(RFC3280CertPathUtilities.ANY_POLICY);
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet5, null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
        arrayListArr[0].add(pKIXPolicyNode);
        if (this.pkixParams.isExplicitPolicyRequired()) {
            i2 = 0;
            i = 1;
        } else {
            i = 1;
            i2 = this.f22985n + 1;
        }
        int i9 = this.pkixParams.isAnyPolicyInhibited() ? 0 : this.f22985n + i;
        int i10 = this.pkixParams.isPolicyMappingInhibited() ? 0 : this.f22985n + i;
        try {
            size = this.f22983certs.size() - i;
            pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode;
            x509Certificate = null;
            hashSet = null;
        } catch (CertPathReviewerException e) {
            addError(e.getErrorMessage(), e.getIndex());
            return;
        }
        while (true) {
            String str2 = "CertPathReviewer.policyConstExtError";
            if (size < 0) {
                break;
            }
            int i11 = this.f22985n - size;
            X509Certificate x509Certificate2 = (X509Certificate) this.f22983certs.get(size);
            try {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                if (aSN1Sequence2 == null || pKIXPolicyNodePrepareNextCertB2 == null) {
                    set = initialPolicies;
                    i3 = i7;
                    i4 = i9;
                    str = "CertPathReviewer.policyConstExtError";
                    pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNodePrepareNextCertB2;
                } else {
                    Enumeration objects = aSN1Sequence2.getObjects();
                    i3 = i7;
                    HashSet hashSet6 = new HashSet();
                    while (objects.hasMoreElements()) {
                        PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                        Set<String> set2 = initialPolicies;
                        ASN1ObjectIdentifier policyIdentifier = policyInformation.getPolicyIdentifier();
                        PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNodePrepareNextCertB2;
                        hashSet6.add(policyIdentifier.m14433getId());
                        if (!RFC3280CertPathUtilities.ANY_POLICY.equals(policyIdentifier.m14433getId())) {
                            try {
                                Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(policyInformation.getPolicyQualifiers());
                                if (!CertPathValidatorUtilities.processCertD1i(i11, arrayListArr, policyIdentifier, qualifierSet)) {
                                    CertPathValidatorUtilities.processCertD1ii(i11, arrayListArr, policyIdentifier, qualifierSet);
                                }
                            } catch (CertPathValidatorException e2) {
                                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyQualifierError"), e2, this.certPath, size);
                            }
                        }
                        initialPolicies = set2;
                        pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode2;
                    }
                    set = initialPolicies;
                    PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNodePrepareNextCertB2;
                    if (hashSet == null || hashSet.contains(RFC3280CertPathUtilities.ANY_POLICY)) {
                        hashSet3 = hashSet6;
                    } else {
                        hashSet3 = new HashSet();
                        for (Object obj : hashSet) {
                            if (hashSet6.contains(obj)) {
                                hashSet3.add(obj);
                            }
                        }
                    }
                    if (i9 > 0 || (i11 < this.f22985n && CertPathValidatorUtilities.isSelfIssued(x509Certificate2))) {
                        Enumeration objects2 = aSN1Sequence2.getObjects();
                        while (objects2.hasMoreElements()) {
                            PolicyInformation policyInformation2 = PolicyInformation.getInstance(objects2.nextElement());
                            if (RFC3280CertPathUtilities.ANY_POLICY.equals(policyInformation2.getPolicyIdentifier().m14433getId())) {
                                try {
                                    Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(policyInformation2.getPolicyQualifiers());
                                    ArrayList arrayList = arrayListArr[i11 - 1];
                                    hashSet4 = hashSet3;
                                    for (int i12 = 0; i12 < arrayList.size(); i12++) {
                                        PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) arrayList.get(i12);
                                        for (Object obj2 : pKIXPolicyNode4.getExpectedPolicies()) {
                                            ArrayList arrayList2 = arrayList;
                                            String str3 = str2;
                                            if (obj2 instanceof String) {
                                                strM14433getId = (String) obj2;
                                            } else if (obj2 instanceof ASN1ObjectIdentifier) {
                                                strM14433getId = ((ASN1ObjectIdentifier) obj2).m14433getId();
                                            } else {
                                                arrayList = arrayList2;
                                                str2 = str3;
                                            }
                                            Iterator children = pKIXPolicyNode4.getChildren();
                                            boolean z = false;
                                            while (children.hasNext()) {
                                                Iterator it = children;
                                                if (strM14433getId.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                                    z = true;
                                                }
                                                children = it;
                                            }
                                            if (z) {
                                                i5 = i9;
                                            } else {
                                                HashSet hashSet7 = new HashSet();
                                                hashSet7.add(strM14433getId);
                                                i5 = i9;
                                                PKIXPolicyNode pKIXPolicyNode5 = new PKIXPolicyNode(new ArrayList(), i11, hashSet7, pKIXPolicyNode4, qualifierSet2, strM14433getId, false);
                                                pKIXPolicyNode4.addChild(pKIXPolicyNode5);
                                                arrayListArr[i11].add(pKIXPolicyNode5);
                                            }
                                            arrayList = arrayList2;
                                            str2 = str3;
                                            i9 = i5;
                                        }
                                    }
                                    i4 = i9;
                                    str = str2;
                                    pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                                    for (i6 = i11 - 1; i6 >= 0; i6--) {
                                        ArrayList arrayList3 = arrayListArr[i6];
                                        for (int i13 = 0; i13 < arrayList3.size(); i13++) {
                                            PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) arrayList3.get(i13);
                                            if (!pKIXPolicyNode6.hasChildren()) {
                                                PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodePrepareNextCertB2, arrayListArr, pKIXPolicyNode6);
                                                pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNodeRemovePolicyNode;
                                                if (pKIXPolicyNodeRemovePolicyNode == null) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs != null) {
                                        boolean zContains = criticalExtensionOIDs.contains(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                                        ArrayList arrayList4 = arrayListArr[i11];
                                        for (int i14 = 0; i14 < arrayList4.size(); i14++) {
                                            ((PKIXPolicyNode) arrayList4.get(i14)).setCritical(zContains);
                                        }
                                    }
                                    hashSet = hashSet4;
                                } catch (CertPathValidatorException e3) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyQualifierError"), e3, this.certPath, size);
                                }
                            }
                        }
                        i4 = i9;
                        hashSet4 = hashSet3;
                        str = str2;
                        pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                        while (i6 >= 0) {
                        }
                        criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs != null) {
                        }
                        hashSet = hashSet4;
                    } else {
                        i4 = i9;
                        hashSet4 = hashSet3;
                        str = str2;
                        pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                        while (i6 >= 0) {
                        }
                        criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs != null) {
                        }
                        hashSet = hashSet4;
                    }
                }
                if (aSN1Sequence2 == null) {
                    pKIXPolicyNodePrepareNextCertB2 = null;
                }
                if (i2 <= 0 && pKIXPolicyNodePrepareNextCertB2 == null) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.noValidPolicyTree"));
                }
                if (i11 != this.f22985n) {
                    try {
                        ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.POLICY_MAPPINGS);
                        if (extensionValue != null) {
                            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) extensionValue;
                            for (int i15 = 0; i15 < aSN1Sequence3.mo14450size(); i15++) {
                                ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence3.getObjectAt(i15);
                                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence4.getObjectAt(0);
                                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) aSN1Sequence4.getObjectAt(1);
                                if (RFC3280CertPathUtilities.ANY_POLICY.equals(aSN1ObjectIdentifier.m14433getId())) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                }
                                if (RFC3280CertPathUtilities.ANY_POLICY.equals(aSN1ObjectIdentifier2.m14433getId())) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                }
                            }
                        }
                        if (extensionValue != null) {
                            ASN1Sequence aSN1Sequence5 = (ASN1Sequence) extensionValue;
                            HashMap map = new HashMap();
                            HashSet<String> hashSet8 = new HashSet();
                            int i16 = 0;
                            while (i16 < aSN1Sequence5.mo14450size()) {
                                ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i16);
                                ASN1Sequence aSN1Sequence7 = aSN1Sequence5;
                                String strM14433getId2 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(0)).m14433getId();
                                HashSet hashSet9 = hashSet;
                                String strM14433getId3 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(1)).m14433getId();
                                if (map.containsKey(strM14433getId2)) {
                                    ((Set) map.get(strM14433getId2)).add(strM14433getId3);
                                } else {
                                    HashSet hashSet10 = new HashSet();
                                    hashSet10.add(strM14433getId3);
                                    map.put(strM14433getId2, hashSet10);
                                    hashSet8.add(strM14433getId2);
                                }
                                i16++;
                                aSN1Sequence5 = aSN1Sequence7;
                                hashSet = hashSet9;
                            }
                            hashSet2 = hashSet;
                            for (String str4 : hashSet8) {
                                if (i10 > 0) {
                                    try {
                                        try {
                                            CertPathValidatorUtilities.prepareNextCertB1(i11, arrayListArr, str4, map, x509Certificate2);
                                        } catch (AnnotatedException e4) {
                                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyExtError"), e4, this.certPath, size);
                                        }
                                    } catch (CertPathValidatorException e5) {
                                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyQualifierError"), e5, this.certPath, size);
                                    }
                                } else if (i10 <= 0) {
                                    pKIXPolicyNodePrepareNextCertB2 = CertPathValidatorUtilities.prepareNextCertB2(i11, arrayListArr, str4, pKIXPolicyNodePrepareNextCertB2);
                                }
                            }
                        } else {
                            hashSet2 = hashSet;
                        }
                        if (CertPathValidatorUtilities.isSelfIssued(x509Certificate2)) {
                            i9 = i4;
                            try {
                                aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                                if (aSN1Sequence != null) {
                                    Enumeration objects3 = aSN1Sequence.getObjects();
                                    while (objects3.hasMoreElements()) {
                                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects3.nextElement();
                                        int tagNo = aSN1TaggedObject.getTagNo();
                                        if (tagNo == 0) {
                                            int iIntValueExact3 = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact();
                                            if (iIntValueExact3 < i2) {
                                                i2 = iIntValueExact3;
                                            }
                                        } else if (tagNo == 1 && (iIntValueExact2 = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact()) < i10) {
                                            i10 = iIntValueExact2;
                                        }
                                    }
                                }
                                try {
                                    aSN1Integer = (ASN1Integer) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                                    if (aSN1Integer == null && (iIntValueExact = aSN1Integer.intValueExact()) < i9) {
                                        i9 = iIntValueExact;
                                    }
                                } catch (AnnotatedException unused) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyInhibitExtError"), this.certPath, size);
                                }
                            } catch (AnnotatedException unused2) {
                                throw new CertPathReviewerException(createErrorBundle(str), this.certPath, size);
                            }
                        } else {
                            if (i2 != 0) {
                                i2--;
                            }
                            if (i10 != 0) {
                                i10--;
                            }
                            if (i4 != 0) {
                                i9 = i4 - 1;
                            }
                            aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                            if (aSN1Sequence != null) {
                            }
                            aSN1Integer = (ASN1Integer) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                            if (aSN1Integer == null) {
                            }
                        }
                    } catch (AnnotatedException e6) {
                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyMapExtError"), e6, this.certPath, size);
                    }
                } else {
                    hashSet2 = hashSet;
                    i9 = i4;
                }
                size--;
                x509Certificate = x509Certificate2;
                hashSet = hashSet2;
                i7 = i3;
                initialPolicies = set;
            } catch (AnnotatedException e7) {
                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.policyExtError"), e7, this.certPath, size);
            }
            addError(e.getErrorMessage(), e.getIndex());
            return;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:59|(2:167|61)(3:66|(2:175|68)(2:72|(2:76|(1:78)))|65)|(2:182|79)|84|(17:165|86|(1:88)(1:91)|171|92|(1:94)(1:97)|98|(2:101|99)|187|102|(2:105|103)|173|106|107|177|108|109)(1:115)|(1:119)|120|(8:122|(1:126)|169|127|(4:129|(0)|135|(1:141))(1:132)|131|135|(2:137|141))(1:142)|143|161|144|163|145|186|149) */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0384, code lost:
    
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0386, code lost:
    
        addError(createErrorBundle("CertPathReviewer.pubKeyError"), r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkSignatures() throws Exception {
        TrustAnchor trustAnchor;
        ErrorBundle errorMessage;
        TrustAnchor trustAnchor2;
        X500Principal subjectPrincipal;
        X509Certificate trustedCert;
        PublicKey publicKey;
        int size;
        ErrorBundle errorBundleCreateErrorBundle;
        ErrorBundle errorBundleCreateErrorBundle2;
        X509Certificate x509Certificate;
        int i;
        int i2;
        PublicKey publicKey2;
        int i3;
        ASN1Primitive extensionValue;
        ASN1Primitive extensionValue2;
        X509Certificate x509Certificate2;
        boolean[] keyUsage;
        BasicConstraints basicConstraints;
        AuthorityKeyIdentifier authorityKeyIdentifier;
        GeneralNames authorityCertIssuer;
        boolean[] keyUsage2;
        X509Certificate x509Certificate3;
        Collection trustAnchors;
        ErrorBundle errorBundleCreateErrorBundle3;
        addNotification(createErrorBundle("CertPathReviewer.certPathValidDate", new Object[]{new TrustedInput(this.validDate), new TrustedInput(this.currentDate)}));
        try {
            List list = this.f22983certs;
            x509Certificate3 = (X509Certificate) list.get(list.size() - 1);
            trustAnchors = getTrustAnchors(x509Certificate3, this.pkixParams.getTrustAnchors());
        } catch (CertPathReviewerException e) {
            e = e;
            trustAnchor = null;
        } catch (Throwable th) {
            th = th;
            trustAnchor = null;
        }
        if (trustAnchors.size() > 1) {
            errorBundleCreateErrorBundle3 = createErrorBundle("CertPathReviewer.conflictingTrustAnchors", new Object[]{Integers.m18296valueOf(trustAnchors.size()), new UntrustedInput(x509Certificate3.getIssuerX500Principal())});
        } else {
            if (!trustAnchors.isEmpty()) {
                trustAnchor = (TrustAnchor) trustAnchors.iterator().next();
                try {
                    try {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate3, trustAnchor.getTrustedCert() != null ? trustAnchor.getTrustedCert().getPublicKey() : trustAnchor.getCAPublicKey(), this.pkixParams.getSigProvider());
                        } catch (SignatureException unused) {
                            addError(createErrorBundle("CertPathReviewer.trustButInvalidCert"));
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        errorMessage = createErrorBundle("CertPathReviewer.unknown", new Object[]{new UntrustedInput(th.getMessage()), new UntrustedInput(th)});
                        addError(errorMessage);
                        trustAnchor2 = trustAnchor;
                        if (trustAnchor2 == null) {
                        }
                        if (trustAnchor2 == null) {
                        }
                        X509Certificate x509Certificate4 = trustedCert;
                        X500Principal subjectX500Principal = subjectPrincipal;
                        PublicKey nextWorkingKey = publicKey;
                        size = this.f22983certs.size() - 1;
                        while (size >= 0) {
                        }
                        this.trustAnchor = trustAnchor2;
                        this.subjectPublicKey = nextWorkingKey;
                    }
                } catch (CertPathReviewerException e2) {
                    e = e2;
                    errorMessage = e.getErrorMessage();
                    addError(errorMessage);
                    trustAnchor2 = trustAnchor;
                    if (trustAnchor2 == null) {
                    }
                    if (trustAnchor2 == null) {
                    }
                    X509Certificate x509Certificate42 = trustedCert;
                    X500Principal subjectX500Principal2 = subjectPrincipal;
                    PublicKey nextWorkingKey2 = publicKey;
                    size = this.f22983certs.size() - 1;
                    while (size >= 0) {
                    }
                    this.trustAnchor = trustAnchor2;
                    this.subjectPublicKey = nextWorkingKey2;
                }
                trustAnchor2 = trustAnchor;
                if (trustAnchor2 == null) {
                    X509Certificate trustedCert2 = trustAnchor2.getTrustedCert();
                    try {
                        subjectPrincipal = trustedCert2 != null ? CertPathValidatorUtilities.getSubjectPrincipal(trustedCert2) : new X500Principal(trustAnchor2.getCAName());
                    } catch (IllegalArgumentException unused3) {
                        addError(createErrorBundle("CertPathReviewer.trustDNInvalid", new Object[]{new UntrustedInput(trustAnchor2.getCAName())}));
                        subjectPrincipal = null;
                    }
                    if (trustedCert2 != null && (keyUsage2 = trustedCert2.getKeyUsage()) != null && (keyUsage2.length <= 5 || !keyUsage2[5])) {
                        addNotification(createErrorBundle("CertPathReviewer.trustKeyUsage"));
                    }
                } else {
                    subjectPrincipal = null;
                }
                if (trustAnchor2 == null) {
                    trustedCert = trustAnchor2.getTrustedCert();
                    publicKey = trustedCert != null ? trustedCert.getPublicKey() : trustAnchor2.getCAPublicKey();
                    try {
                        CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                    } catch (CertPathValidatorException unused4) {
                        addError(createErrorBundle("CertPathReviewer.trustPubKeyError"));
                    }
                } else {
                    trustedCert = null;
                    publicKey = null;
                }
                X509Certificate x509Certificate422 = trustedCert;
                X500Principal subjectX500Principal22 = subjectPrincipal;
                PublicKey nextWorkingKey22 = publicKey;
                size = this.f22983certs.size() - 1;
                while (size >= 0) {
                    int i4 = this.f22985n - size;
                    X509Certificate x509Certificate5 = (X509Certificate) this.f22983certs.get(size);
                    if (nextWorkingKey22 != null) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate5, nextWorkingKey22, this.pkixParams.getSigProvider());
                        } catch (GeneralSecurityException e3) {
                            errorBundleCreateErrorBundle = createErrorBundle("CertPathReviewer.signatureNotVerified", new Object[]{e3.getMessage(), e3, e3.getClass().getName()});
                        }
                    } else {
                        if (CertPathValidatorUtilities.isSelfIssued(x509Certificate5)) {
                            try {
                                CertPathValidatorUtilities.verifyX509Certificate(x509Certificate5, x509Certificate5.getPublicKey(), this.pkixParams.getSigProvider());
                                addError(createErrorBundle("CertPathReviewer.rootKeyIsValidButNotATrustAnchor"), size);
                            } catch (GeneralSecurityException e4) {
                                errorBundleCreateErrorBundle = createErrorBundle("CertPathReviewer.signatureNotVerified", new Object[]{e4.getMessage(), e4, e4.getClass().getName()});
                            }
                        } else {
                            errorBundleCreateErrorBundle = createErrorBundle("CertPathReviewer.NoIssuerPublicKey");
                            byte[] extensionValue3 = x509Certificate5.getExtensionValue(Extension.authorityKeyIdentifier.m14433getId());
                            if (extensionValue3 != null && (authorityCertIssuer = (authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue3).getOctets())).getAuthorityCertIssuer()) != null) {
                                GeneralName generalName = authorityCertIssuer.getNames()[0];
                                BigInteger authorityCertSerialNumber = authorityKeyIdentifier.getAuthorityCertSerialNumber();
                                if (authorityCertSerialNumber != null) {
                                    errorBundleCreateErrorBundle.setExtraArguments(new Object[]{new LocaleString(RESOURCE_NAME, "missingIssuer"), " \"", generalName, "\" ", new LocaleString(RESOURCE_NAME, "missingSerial"), " ", authorityCertSerialNumber});
                                }
                            }
                        }
                        addError(errorBundleCreateErrorBundle, size);
                    }
                    try {
                        x509Certificate5.checkValidity(this.validDate);
                    } catch (CertificateExpiredException unused5) {
                        errorBundleCreateErrorBundle2 = createErrorBundle("CertPathReviewer.certificateExpired", new Object[]{new TrustedInput(x509Certificate5.getNotAfter())});
                        addError(errorBundleCreateErrorBundle2, size);
                        if (this.pkixParams.isRevocationEnabled()) {
                        }
                        if (subjectX500Principal22 != null) {
                        }
                        if (i == this.f22985n) {
                        }
                        subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                        nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f22983certs, i3);
                        CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                        size = i3 - 1;
                        x509Certificate422 = x509Certificate2;
                    } catch (CertificateNotYetValidException unused6) {
                        errorBundleCreateErrorBundle2 = createErrorBundle("CertPathReviewer.certificateNotYetValid", new Object[]{new TrustedInput(x509Certificate5.getNotBefore())});
                        addError(errorBundleCreateErrorBundle2, size);
                        if (this.pkixParams.isRevocationEnabled()) {
                        }
                        if (subjectX500Principal22 != null) {
                        }
                        if (i == this.f22985n) {
                        }
                        subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                        nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f22983certs, i3);
                        CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                        size = i3 - 1;
                        x509Certificate422 = x509Certificate2;
                    }
                    if (this.pkixParams.isRevocationEnabled()) {
                        try {
                            extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509Certificate5, CRL_DIST_POINTS);
                        } catch (AnnotatedException unused7) {
                            addError(createErrorBundle("CertPathReviewer.crlDistPtExtError"), size);
                        }
                        CRLDistPoint cRLDistPoint = extensionValue2 != null ? CRLDistPoint.getInstance(extensionValue2) : null;
                        try {
                            extensionValue = CertPathValidatorUtilities.getExtensionValue(x509Certificate5, AUTH_INFO_ACCESS);
                        } catch (AnnotatedException unused8) {
                            addError(createErrorBundle("CertPathReviewer.crlAuthInfoAccError"), size);
                        }
                        AuthorityInformationAccess authorityInformationAccess = extensionValue != null ? AuthorityInformationAccess.getInstance(extensionValue) : null;
                        Vector cRLDistUrls = getCRLDistUrls(cRLDistPoint);
                        Vector oCSPUrls = getOCSPUrls(authorityInformationAccess);
                        Iterator it = cRLDistUrls.iterator();
                        while (it.hasNext()) {
                            addNotification(createErrorBundle("CertPathReviewer.crlDistPoint", new Object[]{new UntrustedUrlInput(it.next())}), size);
                        }
                        Iterator it2 = oCSPUrls.iterator();
                        while (it2.hasNext()) {
                            addNotification(createErrorBundle("CertPathReviewer.ocspLocation", new Object[]{new UntrustedUrlInput(it2.next())}), size);
                        }
                        try {
                            x509Certificate = x509Certificate5;
                            i = i4;
                            i2 = size;
                            publicKey2 = nextWorkingKey22;
                        } catch (CertPathReviewerException e5) {
                            e = e5;
                            x509Certificate = x509Certificate5;
                            i = i4;
                            i2 = size;
                            publicKey2 = nextWorkingKey22;
                        }
                        try {
                            checkRevocation(this.pkixParams, x509Certificate5, this.validDate, x509Certificate422, nextWorkingKey22, cRLDistUrls, oCSPUrls, i2);
                            i3 = i2;
                        } catch (CertPathReviewerException e6) {
                            e = e6;
                            i3 = i2;
                            addError(e.getErrorMessage(), i3);
                            if (subjectX500Principal22 != null) {
                                addError(createErrorBundle("CertPathReviewer.certWrongIssuer", new Object[]{subjectX500Principal22.getName(), x509Certificate.getIssuerX500Principal().getName()}), i3);
                            }
                            if (i == this.f22985n) {
                            }
                            subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                            nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f22983certs, i3);
                            CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                            size = i3 - 1;
                            x509Certificate422 = x509Certificate2;
                        }
                    } else {
                        x509Certificate = x509Certificate5;
                        i = i4;
                        i3 = size;
                        publicKey2 = nextWorkingKey22;
                    }
                    if (subjectX500Principal22 != null && !x509Certificate.getIssuerX500Principal().equals(subjectX500Principal22)) {
                        addError(createErrorBundle("CertPathReviewer.certWrongIssuer", new Object[]{subjectX500Principal22.getName(), x509Certificate.getIssuerX500Principal().getName()}), i3);
                    }
                    if (i == this.f22985n) {
                        String str = "CertPathReviewer.noCACert";
                        x509Certificate2 = x509Certificate;
                        if (x509Certificate2 != null && x509Certificate2.getVersion() == 1) {
                            addError(createErrorBundle("CertPathReviewer.noCACert"), i3);
                        }
                        try {
                            basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
                        } catch (AnnotatedException unused9) {
                            addError(createErrorBundle("CertPathReviewer.errorProcesingBC"), i3);
                        }
                        if (basicConstraints != null) {
                            if (!basicConstraints.m14675isCA()) {
                            }
                            keyUsage = x509Certificate2.getKeyUsage();
                            if (keyUsage != null && (keyUsage.length <= 5 || !keyUsage[5])) {
                                addError(createErrorBundle("CertPathReviewer.noCertSign"), i3);
                            }
                        } else {
                            str = "CertPathReviewer.noBasicConstraints";
                        }
                        addError(createErrorBundle(str), i3);
                        keyUsage = x509Certificate2.getKeyUsage();
                        if (keyUsage != null) {
                            addError(createErrorBundle("CertPathReviewer.noCertSign"), i3);
                        }
                    } else {
                        x509Certificate2 = x509Certificate;
                    }
                    subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                    nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f22983certs, i3);
                    CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                    size = i3 - 1;
                    x509Certificate422 = x509Certificate2;
                }
                this.trustAnchor = trustAnchor2;
                this.subjectPublicKey = nextWorkingKey22;
            }
            errorBundleCreateErrorBundle3 = createErrorBundle("CertPathReviewer.noTrustAnchorFound", new Object[]{new UntrustedInput(x509Certificate3.getIssuerX500Principal()), Integers.m18296valueOf(this.pkixParams.getTrustAnchors().size())});
        }
        addError(errorBundleCreateErrorBundle3);
        trustAnchor = null;
        trustAnchor2 = trustAnchor;
        if (trustAnchor2 == null) {
        }
        if (trustAnchor2 == null) {
        }
        X509Certificate x509Certificate4222 = trustedCert;
        X500Principal subjectX500Principal222 = subjectPrincipal;
        PublicKey nextWorkingKey222 = publicKey;
        size = this.f22983certs.size() - 1;
        while (size >= 0) {
        }
        this.trustAnchor = trustAnchor2;
        this.subjectPublicKey = nextWorkingKey222;
    }

    private static ErrorBundle createErrorBundle(String str) {
        ErrorBundle errorBundle = new ErrorBundle(RESOURCE_NAME, str);
        errorBundle.setClassLoader(PKIXCertPathReviewer.class.getClassLoader());
        return errorBundle;
    }

    /* renamed from: getCRL */
    private X509CRL m17442getCRL(String str) throws Exception {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundleCreateErrorBundle;
        String str;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.mo14450size(); i2++) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                    str = "CertPathReviewer.QcEuCompliance";
                } else {
                    if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                        if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                            str = "CertPathReviewer.QcSSCD";
                        } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                            MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                            monetaryValue.getCurrency();
                            double dDoubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                            errorBundleCreateErrorBundle = monetaryValue.getCurrency().isAlphabetic() ? createErrorBundle("CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(dDoubleValue)), monetaryValue}) : createErrorBundle("CertPathReviewer.QcLimitValueNum", new Object[]{Integers.m18296valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(dDoubleValue)), monetaryValue});
                            addNotification(errorBundleCreateErrorBundle, i);
                        } else {
                            addNotification(createErrorBundle("CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i);
                            z = true;
                        }
                    }
                }
                errorBundleCreateErrorBundle = createErrorBundle(str);
                addNotification(errorBundleCreateErrorBundle, i);
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(createErrorBundle("CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    public void addError(ErrorBundle errorBundle) {
        this.f22984errors[0].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkCRLs(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, int i) throws Exception {
        Iterator it;
        X509CRL x509crl;
        boolean z;
        boolean z2;
        ErrorBundle errorBundleCreateErrorBundle;
        boolean[] keyUsage;
        X509CRL x509crl2;
        Iterator it2;
        ErrorBundle errorBundleCreateErrorBundle2;
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            x509CRLStoreSelector.setCertificateChecking(x509Certificate);
            try {
                Set setFindCRLs = PKIXCRLUtil.findCRLs(x509CRLStoreSelector, pKIXParameters);
                it = setFindCRLs.iterator();
                if (setFindCRLs.isEmpty()) {
                    Iterator it3 = PKIXCRLUtil.findCRLs(new X509CRLStoreSelector(), pKIXParameters).iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it3.hasNext()) {
                        arrayList.add(((X509CRL) it3.next()).getIssuerX500Principal());
                    }
                    addNotification(createErrorBundle("CertPathReviewer.noCrlInCertstore", new Object[]{new UntrustedInput(x509CRLStoreSelector.getIssuerNames()), new UntrustedInput(arrayList), Integers.m18296valueOf(arrayList.size())}), i);
                }
            } catch (AnnotatedException e) {
                addError(createErrorBundle("CertPathReviewer.crlExtractionError", new Object[]{e.getCause().getMessage(), e.getCause(), e.getCause().getClass().getName()}), i);
                it = new ArrayList().iterator();
            }
            X509CRL x509crl3 = null;
            while (it.hasNext()) {
                x509crl3 = (X509CRL) it.next();
                Date thisUpdate = x509crl3.getThisUpdate();
                Date nextUpdate = x509crl3.getNextUpdate();
                Object[] objArr = {new TrustedInput(thisUpdate), new TrustedInput(nextUpdate)};
                if (nextUpdate == null || date.before(nextUpdate)) {
                    addNotification(createErrorBundle("CertPathReviewer.localValidCRL", objArr), i);
                    x509crl = x509crl3;
                    z = true;
                    break;
                }
                addNotification(createErrorBundle("CertPathReviewer.localInvalidCRL", objArr), i);
            }
            x509crl = x509crl3;
            z = false;
            if (!z) {
                X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
                Iterator it4 = vector.iterator();
                boolean z3 = z;
                while (true) {
                    if (!it4.hasNext()) {
                        z2 = z3;
                        break;
                    }
                    try {
                        String str = (String) it4.next();
                        X509CRL x509crlM17442getCRL = m17442getCRL(str);
                        if (x509crlM17442getCRL != null) {
                            X500Principal issuerX500Principal2 = x509crlM17442getCRL.getIssuerX500Principal();
                            if (issuerX500Principal.equals(issuerX500Principal2)) {
                                x509crl2 = x509crl;
                                it2 = it4;
                                Date thisUpdate2 = x509crlM17442getCRL.getThisUpdate();
                                Date nextUpdate2 = x509crlM17442getCRL.getNextUpdate();
                                Object[] objArr2 = {new TrustedInput(thisUpdate2), new TrustedInput(nextUpdate2), new UntrustedUrlInput(str)};
                                if (nextUpdate2 != null && !date.before(nextUpdate2)) {
                                    errorBundleCreateErrorBundle2 = createErrorBundle("CertPathReviewer.onlineInvalidCRL", objArr2);
                                }
                                try {
                                    addNotification(createErrorBundle("CertPathReviewer.onlineValidCRL", objArr2), i);
                                    x509crl = x509crlM17442getCRL;
                                    z2 = true;
                                    break;
                                } catch (CertPathReviewerException e2) {
                                    e = e2;
                                    z3 = true;
                                    addNotification(e.getErrorMessage(), i);
                                    it4 = it2;
                                    x509crl = x509crl2;
                                }
                            } else {
                                x509crl2 = x509crl;
                                try {
                                    it2 = it4;
                                    try {
                                        errorBundleCreateErrorBundle2 = createErrorBundle("CertPathReviewer.onlineCRLWrongCA", new Object[]{new UntrustedInput(issuerX500Principal2.getName()), new UntrustedInput(issuerX500Principal.getName()), new UntrustedUrlInput(str)});
                                    } catch (CertPathReviewerException e3) {
                                        e = e3;
                                        addNotification(e.getErrorMessage(), i);
                                        it4 = it2;
                                        x509crl = x509crl2;
                                    }
                                } catch (CertPathReviewerException e4) {
                                    e = e4;
                                    it2 = it4;
                                    addNotification(e.getErrorMessage(), i);
                                    it4 = it2;
                                    x509crl = x509crl2;
                                }
                            }
                            addNotification(errorBundleCreateErrorBundle2, i);
                        } else {
                            x509crl2 = x509crl;
                            it2 = it4;
                        }
                    } catch (CertPathReviewerException e5) {
                        e = e5;
                        x509crl2 = x509crl;
                    }
                    it4 = it2;
                    x509crl = x509crl2;
                }
            } else {
                z2 = z;
            }
            if (x509crl != null) {
                if (x509Certificate2 != null && (keyUsage = x509Certificate2.getKeyUsage()) != null && (keyUsage.length <= 6 || !keyUsage[6])) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.noCrlSigningPermited"));
                }
                if (publicKey == null) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlNoIssuerPublicKey"));
                }
                try {
                    x509crl.verify(publicKey, BouncyCastleProvider.PROVIDER_NAME);
                    X509CRLEntry revokedCertificate = x509crl.getRevokedCertificate(x509Certificate.getSerialNumber());
                    if (revokedCertificate == null) {
                        errorBundleCreateErrorBundle = createErrorBundle("CertPathReviewer.notRevoked");
                    } else if (revokedCertificate.hasExtensions()) {
                        try {
                            ASN1Enumerated aSN1Enumerated = ASN1Enumerated.getInstance(CertPathValidatorUtilities.getExtensionValue(revokedCertificate, Extension.reasonCode.m14433getId()));
                            String str2 = aSN1Enumerated != null ? CertPathValidatorUtilities.crlReasons[aSN1Enumerated.intValueExact()] : null;
                            if (str2 == null) {
                                str2 = CertPathValidatorUtilities.crlReasons[7];
                            }
                            LocaleString localeString = new LocaleString(RESOURCE_NAME, str2);
                            if (!date.before(revokedCertificate.getRevocationDate())) {
                                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.certRevoked", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString}));
                            }
                            errorBundleCreateErrorBundle = createErrorBundle("CertPathReviewer.revokedAfterValidation", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString});
                        } catch (AnnotatedException e6) {
                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlReasonExtError"), e6);
                        }
                    }
                    addNotification(errorBundleCreateErrorBundle, i);
                    Date nextUpdate3 = x509crl.getNextUpdate();
                    if (nextUpdate3 != null && !date.before(nextUpdate3)) {
                        addNotification(createErrorBundle("CertPathReviewer.crlUpdateAvailable", new Object[]{new TrustedInput(nextUpdate3)}), i);
                    }
                    try {
                        ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl, CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                        try {
                            ASN1Primitive extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509crl, CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                            if (extensionValue2 != null) {
                                X509CRLStoreSelector x509CRLStoreSelector2 = new X509CRLStoreSelector();
                                try {
                                    x509CRLStoreSelector2.addIssuerName(CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded());
                                    x509CRLStoreSelector2.setMinCRLNumber(((ASN1Integer) extensionValue2).getPositiveValue());
                                    try {
                                        x509CRLStoreSelector2.setMaxCRLNumber(((ASN1Integer) CertPathValidatorUtilities.getExtensionValue(x509crl, CertPathValidatorUtilities.CRL_NUMBER)).getPositiveValue().subtract(BigInteger.valueOf(1L)));
                                        try {
                                            Iterator it5 = PKIXCRLUtil.findCRLs(x509CRLStoreSelector2, pKIXParameters).iterator();
                                            while (it5.hasNext()) {
                                                try {
                                                    if (C6244Objects.areEqual(extensionValue, CertPathValidatorUtilities.getExtensionValue((X509CRL) it5.next(), CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT))) {
                                                    }
                                                } catch (AnnotatedException e7) {
                                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.distrPtExtError"), e7);
                                                }
                                            }
                                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.noBaseCRL"));
                                        } catch (AnnotatedException e8) {
                                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlExtractionError"), e8);
                                        }
                                    } catch (AnnotatedException e9) {
                                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlNbrExtError"), e9);
                                    }
                                } catch (IOException e10) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlIssuerException"), e10);
                                }
                            }
                            if (extensionValue != null) {
                                IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(extensionValue);
                                try {
                                    BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
                                    if (issuingDistributionPoint.onlyContainsUserCerts() && basicConstraints != null && basicConstraints.m14675isCA()) {
                                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlOnlyUserCert"));
                                    }
                                    if (issuingDistributionPoint.onlyContainsCACerts() && (basicConstraints == null || !basicConstraints.m14675isCA())) {
                                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlOnlyCaCert"));
                                    }
                                    if (issuingDistributionPoint.onlyContainsAttributeCerts()) {
                                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlOnlyAttrCert"));
                                    }
                                } catch (AnnotatedException e11) {
                                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlBCExtError"), e11);
                                }
                            }
                        } catch (AnnotatedException unused) {
                            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.deltaCrlExtError"));
                        }
                    } catch (AnnotatedException unused2) {
                        throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.distrPtExtError"));
                    }
                } catch (Exception e12) {
                    throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlVerifyFailed"), e12);
                }
            }
            if (!z2) {
                throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.noValidCrlFound"));
            }
        } catch (IOException e13) {
            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.crlIssuerException"), e13);
        }
    }

    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws Exception {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    public void doChecks() throws Exception {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
        if (this.notifications != null) {
            return;
        }
        int i = this.f22985n;
        this.notifications = new List[i + 1];
        this.f22984errors = new List[i + 1];
        int i2 = 0;
        while (true) {
            List[] listArr = this.notifications;
            if (i2 >= listArr.length) {
                checkSignatures();
                checkNameConstraints();
                checkPathLength();
                checkPolicy();
                checkCriticalExtensions();
                return;
            }
            listArr[i2] = new ArrayList();
            this.f22984errors[i2] = new ArrayList();
            i2++;
        }
    }

    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.m14684getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.m14683getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((ASN1IA5String) names[i].m14690getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.f22985n;
    }

    public List getErrors(int i) throws Exception {
        doChecks();
        return this.f22984errors[i + 1];
    }

    public List getNotifications(int i) throws Exception {
        doChecks();
        return this.notifications[i + 1];
    }

    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().m14446equals((ASN1Primitive) AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((ASN1IA5String) accessLocation.m14690getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() throws Exception {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() throws Exception {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() throws Exception {
        doChecks();
        return this.trustAnchor;
    }

    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException, IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.m14433getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(JcaX509ExtensionUtils.parseExtensionValue(extensionValue));
                if (authorityKeyIdentifier.getAuthorityCertSerialNumber() != null) {
                    x509CertSelector.setSerialNumber(authorityKeyIdentifier.getAuthorityCertSerialNumber());
                } else {
                    ASN1OctetString keyIdentifierObject = authorityKeyIdentifier.getKeyIdentifierObject();
                    if (keyIdentifierObject != null) {
                        x509CertSelector.setSubjectKeyIdentifier(keyIdentifierObject.getEncoded(ASN1Encoding.f17902DER));
                    }
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    /* renamed from: init */
    public void m17443init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (this.initialized) {
            throw new IllegalStateException("object is already initialized!");
        }
        this.initialized = true;
        if (certPath == null) {
            throw new NullPointerException("certPath was null");
        }
        List<? extends Certificate> certificates = certPath.getCertificates();
        if (certificates.size() != 1) {
            HashSet hashSet = new HashSet();
            Iterator<TrustAnchor> it = pKIXParameters.getTrustAnchors().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getTrustedCert());
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != certificates.size(); i++) {
                if (!hashSet.contains(certificates.get(i))) {
                    arrayList.add(certificates.get(i));
                }
            }
            try {
                this.certPath = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCertPath(arrayList);
                this.f22983certs = arrayList;
            } catch (GeneralSecurityException unused) {
                throw new IllegalStateException("unable to rebuild certpath");
            }
        } else {
            this.certPath = certPath;
            this.f22983certs = certPath.getCertificates();
        }
        this.f22985n = this.f22983certs.size();
        if (this.f22983certs.isEmpty()) {
            throw new CertPathReviewerException(createErrorBundle("CertPathReviewer.emptyCertPath"));
        }
        this.pkixParams = (PKIXParameters) pKIXParameters.clone();
        Date date = new Date();
        this.currentDate = date;
        this.validDate = CertPathValidatorUtilities.getValidityDate(this.pkixParams, date);
        this.notifications = null;
        this.f22984errors = null;
        this.trustAnchor = null;
        this.subjectPublicKey = null;
        this.policyTree = null;
    }

    public boolean isValidCertPath() throws Exception {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.f22984errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }

    public PKIXCertPathReviewer(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        m17443init(certPath, pKIXParameters);
    }

    private static ErrorBundle createErrorBundle(String str, Object[] objArr) {
        ErrorBundle errorBundle = new ErrorBundle(RESOURCE_NAME, str, objArr);
        errorBundle.setClassLoader(PKIXCertPathReviewer.class.getClassLoader());
        return errorBundle;
    }

    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f22985n) {
            throw new IndexOutOfBoundsException();
        }
        this.f22984errors[i + 1].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f22985n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    public List[] getErrors() throws Exception {
        doChecks();
        return this.f22984errors;
    }

    public List[] getNotifications() throws Exception {
        doChecks();
        return this.notifications;
    }
}
