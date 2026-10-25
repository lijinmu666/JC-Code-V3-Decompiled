package org.bouncycastle.p366x509;

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
import org.bouncycastle.p228i18n.ErrorBundle;
import org.bouncycastle.p228i18n.LocaleString;
import org.bouncycastle.p228i18n.p229filter.TrustedInput;
import org.bouncycastle.p228i18n.p229filter.UntrustedInput;
import org.bouncycastle.p228i18n.p229filter.UntrustedUrlInput;
import org.bouncycastle.p281jce.provider.AnnotatedException;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p281jce.provider.PKIXNameConstraintValidator;
import org.bouncycastle.p281jce.provider.PKIXNameConstraintValidatorException;
import org.bouncycastle.p281jce.provider.PKIXPolicyNode;
import org.bouncycastle.p281jce.provider.RFC3280CertPathUtilities;
import org.bouncycastle.p361util.C6244Objects;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final int NAME_CHECK_MAX = 1024;
    private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;

    /* renamed from: certs */
    protected List f24282certs;
    protected Date currentDate;

    /* renamed from: errors */
    protected List[] f24283errors;
    private boolean initialized;

    /* renamed from: n */
    protected int f24284n;
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
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
                }
            } catch (CertPathReviewerException e2) {
                addError(e2.getErrorMessage(), e2.getIndex());
                return;
            }
        }
        for (int size = this.f24282certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f24282certs.get(size);
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
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e3.getMessage(), e3, e3.getClass().getName()}), e3.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it3 = criticalExtensionOIDs.iterator();
                    while (it3.hasNext()) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new ASN1ObjectIdentifier(it3.next())}), size);
                    }
                }
            }
        }
    }

    private void checkNameConstraints() throws CertPathReviewerException {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.f24282certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.f24282certs.get(size);
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
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), this.certPath, size);
                                        }
                                        for (int i = 0; i < aSN1Sequence2.mo14450size(); i++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
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
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        ASN1Integer pathLenConstraintInteger;
        int iMin = this.f24284n;
        int i = 0;
        for (int size = this.f24282certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f24282certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (iMin <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLengthExtended"));
                }
                iMin--;
                i++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && basicConstraints.m14675isCA() && (pathLenConstraintInteger = basicConstraints.getPathLenConstraintInteger()) != null) {
                iMin = Math.min(iMin, pathLenConstraintInteger.intPositiveValueExact());
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.m18296valueOf(i)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0242 A[Catch: CertPathReviewerException -> 0x00e0, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0219 A[Catch: CertPathReviewerException -> 0x00e0, TryCatch #8 {CertPathReviewerException -> 0x00e0, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:39:0x00e4, B:40:0x00f0, B:44:0x00fc, B:47:0x0103, B:48:0x010c, B:50:0x0112, B:52:0x011c, B:55:0x0123, B:57:0x0127, B:97:0x0213, B:99:0x0219, B:100:0x021c, B:102:0x0222, B:104:0x022e, B:107:0x0236, B:108:0x0239, B:109:0x023c, B:111:0x0242, B:112:0x024b, B:114:0x0251, B:122:0x0274, B:123:0x0280, B:124:0x0281, B:126:0x0285, B:128:0x028d, B:129:0x0291, B:131:0x0297, B:134:0x02b9, B:136:0x02c3, B:137:0x02c8, B:138:0x02d4, B:139:0x02d5, B:140:0x02e1, B:142:0x02e4, B:143:0x02f1, B:145:0x02f7, B:147:0x031d, B:149:0x0335, B:148:0x032c, B:150:0x033c, B:151:0x0342, B:153:0x0348, B:155:0x0350, B:166:0x037a, B:159:0x0358, B:160:0x0364, B:162:0x0366, B:163:0x0375, B:170:0x0388, B:181:0x03a5, B:183:0x03af, B:184:0x03b3, B:186:0x03b9, B:191:0x03c9, B:194:0x03d6, B:197:0x03e3, B:199:0x03ed, B:210:0x042b, B:202:0x03f5, B:203:0x0403, B:204:0x0404, B:205:0x0412, B:207:0x0414, B:208:0x0422, B:61:0x0136, B:62:0x013a, B:64:0x0140, B:66:0x0156, B:68:0x0160, B:69:0x0165, B:71:0x016b, B:72:0x0179, B:74:0x017f, B:76:0x018b, B:80:0x0198, B:81:0x019e, B:83:0x01a4, B:88:0x01bd, B:77:0x018e, B:79:0x0192, B:92:0x01f6, B:95:0x0206, B:96:0x0212, B:212:0x043a, B:213:0x0447, B:214:0x0448, B:218:0x0459, B:220:0x0463, B:221:0x0468, B:223:0x046e, B:226:0x047c, B:233:0x0491, B:310:0x05e1, B:311:0x05ed, B:236:0x049c, B:237:0x04a8, B:238:0x04a9, B:240:0x04af, B:242:0x04b7, B:244:0x04bd, B:246:0x04c7, B:247:0x04ca, B:249:0x04d0, B:251:0x04e0, B:252:0x04e4, B:254:0x04ea, B:255:0x04f2, B:256:0x04f5, B:257:0x04f8, B:258:0x04fc, B:260:0x0502, B:261:0x0510, B:263:0x0518, B:264:0x051b, B:266:0x0521, B:268:0x052d, B:269:0x0531, B:270:0x0534, B:271:0x0537, B:272:0x0543, B:274:0x0548, B:276:0x0552, B:277:0x0555, B:279:0x055b, B:281:0x056b, B:282:0x056f, B:284:0x0575, B:286:0x0585, B:287:0x0589, B:288:0x058c, B:289:0x058f, B:290:0x0595, B:292:0x059b, B:294:0x05ad, B:297:0x05b7, B:299:0x05bd, B:300:0x05c0, B:302:0x05c6, B:304:0x05d2, B:305:0x05d6, B:306:0x05d9, B:312:0x05ee, B:313:0x05fa), top: B:328:0x006f, inners: #0, #1, #2, #3, #4, #6, #9, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkPolicy() throws CertPathReviewerException {
        int i;
        int i2;
        int i3;
        PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode;
        Set<String> set;
        String str;
        int i4;
        int i5;
        HashSet hashSet;
        String str2;
        int i6;
        int iIntValueExact;
        int iIntValueExact2;
        String str3;
        HashSet hashSet2;
        HashSet hashSet3;
        String strM14433getId;
        int i7;
        int i8;
        Set<String> criticalExtensionOIDs;
        String str4 = "CertPathReviewer.policyExtError";
        Set<String> initialPolicies = this.pkixParams.getInitialPolicies();
        int i9 = this.f24284n + 1;
        ArrayList[] arrayListArr = new ArrayList[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            arrayListArr[i10] = new ArrayList();
        }
        HashSet hashSet4 = new HashSet();
        hashSet4.add(RFC3280CertPathUtilities.ANY_POLICY);
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet4, null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
        arrayListArr[0].add(pKIXPolicyNode);
        if (this.pkixParams.isExplicitPolicyRequired()) {
            i2 = 0;
            i = 1;
        } else {
            i = 1;
            i2 = this.f24284n + 1;
        }
        int i11 = this.pkixParams.isAnyPolicyInhibited() ? 0 : this.f24284n + i;
        int i12 = this.pkixParams.isPolicyMappingInhibited() ? 0 : this.f24284n + i;
        try {
            int size = this.f24282certs.size() - i;
            PKIXPolicyNode pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode;
            X509Certificate x509Certificate = null;
            HashSet hashSet5 = null;
            while (size >= 0) {
                int i13 = this.f24284n - size;
                X509Certificate x509Certificate2 = (X509Certificate) this.f24282certs.get(size);
                int i14 = i9;
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                    if (aSN1Sequence == null || pKIXPolicyNodePrepareNextCertB2 == null) {
                        set = initialPolicies;
                        str = str4;
                        i4 = i11;
                        i5 = i12;
                        pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNodePrepareNextCertB2;
                    } else {
                        Enumeration objects = aSN1Sequence.getObjects();
                        set = initialPolicies;
                        HashSet hashSet6 = new HashSet();
                        while (objects.hasMoreElements()) {
                            PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                            PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNodePrepareNextCertB2;
                            ASN1ObjectIdentifier policyIdentifier = policyInformation.getPolicyIdentifier();
                            String str5 = str4;
                            hashSet6.add(policyIdentifier.m14433getId());
                            if (!RFC3280CertPathUtilities.ANY_POLICY.equals(policyIdentifier.m14433getId())) {
                                try {
                                    Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(policyInformation.getPolicyQualifiers());
                                    if (!CertPathValidatorUtilities.processCertD1i(i13, arrayListArr, policyIdentifier, qualifierSet)) {
                                        CertPathValidatorUtilities.processCertD1ii(i13, arrayListArr, policyIdentifier, qualifierSet);
                                    }
                                } catch (CertPathValidatorException e) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e, this.certPath, size);
                                }
                            }
                            pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode2;
                            str4 = str5;
                        }
                        str = str4;
                        PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNodePrepareNextCertB2;
                        if (hashSet5 == null || hashSet5.contains(RFC3280CertPathUtilities.ANY_POLICY)) {
                            hashSet2 = hashSet6;
                        } else {
                            hashSet2 = new HashSet();
                            for (Object obj : hashSet5) {
                                if (hashSet6.contains(obj)) {
                                    hashSet2.add(obj);
                                }
                            }
                        }
                        if (i11 > 0 || (i13 < this.f24284n && CertPathValidatorUtilities.isSelfIssued(x509Certificate2))) {
                            Enumeration objects2 = aSN1Sequence.getObjects();
                            while (objects2.hasMoreElements()) {
                                PolicyInformation policyInformation2 = PolicyInformation.getInstance(objects2.nextElement());
                                if (RFC3280CertPathUtilities.ANY_POLICY.equals(policyInformation2.getPolicyIdentifier().m14433getId())) {
                                    try {
                                        Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(policyInformation2.getPolicyQualifiers());
                                        ArrayList arrayList = arrayListArr[i13 - 1];
                                        hashSet3 = hashSet2;
                                        for (int i15 = 0; i15 < arrayList.size(); i15++) {
                                            PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) arrayList.get(i15);
                                            for (Object obj2 : pKIXPolicyNode4.getExpectedPolicies()) {
                                                ArrayList arrayList2 = arrayList;
                                                int i16 = i11;
                                                if (obj2 instanceof String) {
                                                    strM14433getId = (String) obj2;
                                                } else if (obj2 instanceof ASN1ObjectIdentifier) {
                                                    strM14433getId = ((ASN1ObjectIdentifier) obj2).m14433getId();
                                                } else {
                                                    arrayList = arrayList2;
                                                    i11 = i16;
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
                                                    i7 = i12;
                                                } else {
                                                    HashSet hashSet7 = new HashSet();
                                                    hashSet7.add(strM14433getId);
                                                    i7 = i12;
                                                    PKIXPolicyNode pKIXPolicyNode5 = new PKIXPolicyNode(new ArrayList(), i13, hashSet7, pKIXPolicyNode4, qualifierSet2, strM14433getId, false);
                                                    pKIXPolicyNode4.addChild(pKIXPolicyNode5);
                                                    arrayListArr[i13].add(pKIXPolicyNode5);
                                                }
                                                arrayList = arrayList2;
                                                i11 = i16;
                                                i12 = i7;
                                            }
                                        }
                                        i4 = i11;
                                        i5 = i12;
                                        pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                                        for (i8 = i13 - 1; i8 >= 0; i8--) {
                                            ArrayList arrayList3 = arrayListArr[i8];
                                            for (int i17 = 0; i17 < arrayList3.size(); i17++) {
                                                PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) arrayList3.get(i17);
                                                if (!pKIXPolicyNode6.hasChildren()) {
                                                    PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode2 = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodePrepareNextCertB2, arrayListArr, pKIXPolicyNode6);
                                                    pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNodeRemovePolicyNode2;
                                                    if (pKIXPolicyNodeRemovePolicyNode2 == null) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                        if (criticalExtensionOIDs != null) {
                                            boolean zContains = criticalExtensionOIDs.contains(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                                            ArrayList arrayList4 = arrayListArr[i13];
                                            for (int i18 = 0; i18 < arrayList4.size(); i18++) {
                                                ((PKIXPolicyNode) arrayList4.get(i18)).setCritical(zContains);
                                            }
                                        }
                                        hashSet5 = hashSet3;
                                    } catch (CertPathValidatorException e2) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e2, this.certPath, size);
                                    }
                                }
                            }
                            i4 = i11;
                            i5 = i12;
                            hashSet3 = hashSet2;
                            pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                            while (i8 >= 0) {
                            }
                            criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs != null) {
                            }
                            hashSet5 = hashSet3;
                        } else {
                            i4 = i11;
                            i5 = i12;
                            hashSet3 = hashSet2;
                            pKIXPolicyNodePrepareNextCertB2 = pKIXPolicyNode3;
                            while (i8 >= 0) {
                            }
                            criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs != null) {
                            }
                            hashSet5 = hashSet3;
                        }
                    }
                    if (aSN1Sequence == null) {
                        pKIXPolicyNodePrepareNextCertB2 = null;
                    }
                    if (i2 <= 0 && pKIXPolicyNodePrepareNextCertB2 == null) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidPolicyTree"));
                    }
                    if (i13 != this.f24284n) {
                        try {
                            ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.POLICY_MAPPINGS);
                            if (extensionValue != null) {
                                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) extensionValue;
                                int i19 = 0;
                                while (i19 < aSN1Sequence2.mo14450size()) {
                                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(i19);
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(0);
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(1);
                                    boolean zEquals = RFC3280CertPathUtilities.ANY_POLICY.equals(aSN1ObjectIdentifier.m14433getId());
                                    ASN1Sequence aSN1Sequence4 = aSN1Sequence2;
                                    if (zEquals) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                    }
                                    if (RFC3280CertPathUtilities.ANY_POLICY.equals(aSN1ObjectIdentifier2.m14433getId())) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                    }
                                    i19++;
                                    aSN1Sequence2 = aSN1Sequence4;
                                }
                            }
                            if (extensionValue != null) {
                                ASN1Sequence aSN1Sequence5 = (ASN1Sequence) extensionValue;
                                HashMap map = new HashMap();
                                HashSet<String> hashSet8 = new HashSet();
                                int i20 = 0;
                                while (i20 < aSN1Sequence5.mo14450size()) {
                                    ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i20);
                                    ASN1Sequence aSN1Sequence7 = aSN1Sequence5;
                                    String strM14433getId2 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(0)).m14433getId();
                                    HashSet hashSet9 = hashSet5;
                                    String strM14433getId3 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(1)).m14433getId();
                                    if (map.containsKey(strM14433getId2)) {
                                        ((Set) map.get(strM14433getId2)).add(strM14433getId3);
                                    } else {
                                        HashSet hashSet10 = new HashSet();
                                        hashSet10.add(strM14433getId3);
                                        map.put(strM14433getId2, hashSet10);
                                        hashSet8.add(strM14433getId2);
                                    }
                                    i20++;
                                    aSN1Sequence5 = aSN1Sequence7;
                                    hashSet5 = hashSet9;
                                }
                                hashSet = hashSet5;
                                for (String str6 : hashSet8) {
                                    if (i5 > 0) {
                                        try {
                                            CertPathValidatorUtilities.prepareNextCertB1(i13, arrayListArr, str6, map, x509Certificate2);
                                            str3 = str;
                                        } catch (CertPathValidatorException e3) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e3, this.certPath, size);
                                        } catch (AnnotatedException e4) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, str), e4, this.certPath, size);
                                        }
                                    } else {
                                        str3 = str;
                                        if (i5 <= 0) {
                                            pKIXPolicyNodePrepareNextCertB2 = CertPathValidatorUtilities.prepareNextCertB2(i13, arrayListArr, str6, pKIXPolicyNodePrepareNextCertB2);
                                        }
                                    }
                                    str = str3;
                                }
                            } else {
                                hashSet = hashSet5;
                            }
                            str2 = str;
                            if (CertPathValidatorUtilities.isSelfIssued(x509Certificate2)) {
                                i6 = i4;
                                i12 = i5;
                            } else {
                                if (i2 != 0) {
                                    i2--;
                                }
                                i12 = i5 != 0 ? i5 - 1 : i5;
                                i6 = i4 != 0 ? i4 - 1 : i4;
                            }
                            try {
                                ASN1Sequence aSN1Sequence8 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                                if (aSN1Sequence8 != null) {
                                    Enumeration objects3 = aSN1Sequence8.getObjects();
                                    while (objects3.hasMoreElements()) {
                                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects3.nextElement();
                                        int tagNo = aSN1TaggedObject.getTagNo();
                                        if (tagNo == 0) {
                                            int iIntValueExact3 = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact();
                                            if (iIntValueExact3 < i2) {
                                                i2 = iIntValueExact3;
                                            }
                                        } else if (tagNo == 1 && (iIntValueExact2 = ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact()) < i12) {
                                            i12 = iIntValueExact2;
                                        }
                                    }
                                }
                                try {
                                    ASN1Integer aSN1Integer = (ASN1Integer) CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                                    if (aSN1Integer != null && (iIntValueExact = aSN1Integer.intValueExact()) < i6) {
                                        i6 = iIntValueExact;
                                    }
                                } catch (AnnotatedException unused) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), this.certPath, size);
                                }
                            } catch (AnnotatedException unused2) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
                            }
                        } catch (AnnotatedException e5) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyMapExtError"), e5, this.certPath, size);
                        }
                    } else {
                        hashSet = hashSet5;
                        str2 = str;
                        i6 = i4;
                        i12 = i5;
                    }
                    size--;
                    x509Certificate = x509Certificate2;
                    str4 = str2;
                    hashSet5 = hashSet;
                    i9 = i14;
                    i11 = i6;
                    initialPolicies = set;
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, str4), e6, this.certPath, size);
                }
            }
            Set<String> set2 = initialPolicies;
            int i21 = i9;
            PKIXPolicyNode pKIXPolicyNode7 = pKIXPolicyNodePrepareNextCertB2;
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate) && i2 > 0) {
                i2--;
            }
            try {
                ASN1Sequence aSN1Sequence9 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                if (aSN1Sequence9 != null) {
                    Enumeration objects4 = aSN1Sequence9.getObjects();
                    int i22 = i2;
                    while (objects4.hasMoreElements()) {
                        ASN1TaggedObject aSN1TaggedObject2 = (ASN1TaggedObject) objects4.nextElement();
                        if (aSN1TaggedObject2.getTagNo() == 0 && ASN1Integer.getInstance(aSN1TaggedObject2, false).intValueExact() == 0) {
                            i22 = 0;
                        }
                    }
                    i3 = 0;
                    i2 = i22;
                } else {
                    i3 = 0;
                }
                if (pKIXPolicyNode7 == null) {
                    if (this.pkixParams.isExplicitPolicyRequired()) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                    }
                    pKIXPolicyNodeRemovePolicyNode = null;
                } else if (!CertPathValidatorUtilities.isAnyPolicy(set2)) {
                    HashSet<PKIXPolicyNode> hashSet11 = new HashSet();
                    for (int i23 = i3; i23 < i21; i23++) {
                        ArrayList arrayList5 = arrayListArr[i23];
                        for (int i24 = i3; i24 < arrayList5.size(); i24++) {
                            PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) arrayList5.get(i24);
                            if (RFC3280CertPathUtilities.ANY_POLICY.equals(pKIXPolicyNode8.getValidPolicy())) {
                                Iterator children2 = pKIXPolicyNode8.getChildren();
                                while (children2.hasNext()) {
                                    PKIXPolicyNode pKIXPolicyNode9 = (PKIXPolicyNode) children2.next();
                                    if (!RFC3280CertPathUtilities.ANY_POLICY.equals(pKIXPolicyNode9.getValidPolicy())) {
                                        hashSet11.add(pKIXPolicyNode9);
                                    }
                                }
                            }
                        }
                    }
                    pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode7;
                    for (PKIXPolicyNode pKIXPolicyNode10 : hashSet11) {
                        Set<String> set3 = set2;
                        if (!set3.contains(pKIXPolicyNode10.getValidPolicy())) {
                            pKIXPolicyNodeRemovePolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode10);
                        }
                        set2 = set3;
                    }
                    if (pKIXPolicyNodeRemovePolicyNode != null) {
                        for (int i25 = this.f24284n - 1; i25 >= 0; i25--) {
                            ArrayList arrayList6 = arrayListArr[i25];
                            for (int i26 = i3; i26 < arrayList6.size(); i26++) {
                                PKIXPolicyNode pKIXPolicyNode11 = (PKIXPolicyNode) arrayList6.get(i26);
                                if (!pKIXPolicyNode11.hasChildren()) {
                                    pKIXPolicyNodeRemovePolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode11);
                                }
                            }
                        }
                    }
                } else if (!this.pkixParams.isExplicitPolicyRequired()) {
                    pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode7;
                } else {
                    if (hashSet5.isEmpty()) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                    }
                    HashSet hashSet12 = new HashSet();
                    for (int i27 = i3; i27 < i21; i27++) {
                        ArrayList arrayList7 = arrayListArr[i27];
                        for (int i28 = i3; i28 < arrayList7.size(); i28++) {
                            PKIXPolicyNode pKIXPolicyNode12 = (PKIXPolicyNode) arrayList7.get(i28);
                            if (RFC3280CertPathUtilities.ANY_POLICY.equals(pKIXPolicyNode12.getValidPolicy())) {
                                Iterator children3 = pKIXPolicyNode12.getChildren();
                                while (children3.hasNext()) {
                                    hashSet12.add(children3.next());
                                }
                            }
                        }
                    }
                    Iterator it2 = hashSet12.iterator();
                    while (it2.hasNext()) {
                        hashSet5.contains(((PKIXPolicyNode) it2.next()).getValidPolicy());
                    }
                    pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode7;
                    for (int i29 = this.f24284n - 1; i29 >= 0; i29--) {
                        ArrayList arrayList8 = arrayListArr[i29];
                        for (int i30 = i3; i30 < arrayList8.size(); i30++) {
                            PKIXPolicyNode pKIXPolicyNode13 = (PKIXPolicyNode) arrayList8.get(i30);
                            if (!pKIXPolicyNode13.hasChildren()) {
                                pKIXPolicyNodeRemovePolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodeRemovePolicyNode, arrayListArr, pKIXPolicyNode13);
                            }
                        }
                    }
                }
                if (i2 <= 0 && pKIXPolicyNodeRemovePolicyNode == null) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicy"));
                }
            } catch (AnnotatedException unused3) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:57|(2:156|59)(2:64|(2:162|66)(3:70|(2:74|(1:76))|77))|(2:182|78)|83|(17:174|85|(1:87)(1:90)|160|91|(1:93)(1:96)|97|(2:100|98)|187|101|(2:104|102)|154|105|106|158|107|108)(1:114)|(1:118)|119|(14:121|(1:125)|166|126|(2:128|(1:130))(1:131)|134|(2:136|(1:140))|143|170|144|172|145|186|149)(1:142)|141|143|170|144|172|145|186|149) */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03b1, code lost:
    
        r8 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03b3, code lost:
    
        addError(new org.bouncycastle.p228i18n.ErrorBundle(org.bouncycastle.p366x509.PKIXCertPathReviewer.RESOURCE_NAME, "CertPathReviewer.pubKeyError"), r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkSignatures() throws Exception {
        TrustAnchor trustAnchor;
        TrustAnchor trustAnchor2;
        X500Principal subjectPrincipal;
        X509Certificate trustedCert;
        PublicKey publicKey;
        int size;
        ErrorBundle errorBundle;
        ErrorBundle errorBundle2;
        X509Certificate x509Certificate;
        int i;
        int i2;
        PublicKey publicKey2;
        X500Principal x500Principal;
        int i3;
        ASN1Primitive extensionValue;
        ASN1Primitive extensionValue2;
        X509Certificate x509Certificate2;
        char c;
        AuthorityKeyIdentifier authorityKeyIdentifier;
        GeneralNames authorityCertIssuer;
        boolean[] keyUsage;
        X509Certificate x509Certificate3;
        Collection trustAnchors;
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathValidDate", new Object[]{new TrustedInput(this.validDate), new TrustedInput(this.currentDate)}));
        try {
            List list = this.f24282certs;
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
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.conflictingTrustAnchors", new Object[]{Integers.m18296valueOf(trustAnchors.size()), new UntrustedInput(x509Certificate3.getIssuerX500Principal())}));
        } else {
            if (!trustAnchors.isEmpty()) {
                trustAnchor = (TrustAnchor) trustAnchors.iterator().next();
                try {
                    try {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate3, trustAnchor.getTrustedCert() != null ? trustAnchor.getTrustedCert().getPublicKey() : trustAnchor.getCAPublicKey(), this.pkixParams.getSigProvider());
                        } catch (SignatureException unused) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustButInvalidCert"));
                        } catch (Exception unused2) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknown", new Object[]{new UntrustedInput(th.getMessage()), new UntrustedInput(th)}));
                        trustAnchor2 = trustAnchor;
                        if (trustAnchor2 == null) {
                        }
                        if (trustAnchor2 == null) {
                        }
                        X509Certificate x509Certificate4 = trustedCert;
                        X500Principal subjectX500Principal = subjectPrincipal;
                        PublicKey nextWorkingKey = publicKey;
                        size = this.f24282certs.size() - 1;
                        while (size >= 0) {
                        }
                        this.trustAnchor = trustAnchor2;
                        this.subjectPublicKey = nextWorkingKey;
                    }
                } catch (CertPathReviewerException e2) {
                    e = e2;
                    addError(e.getErrorMessage());
                    trustAnchor2 = trustAnchor;
                    if (trustAnchor2 == null) {
                    }
                    if (trustAnchor2 == null) {
                    }
                    X509Certificate x509Certificate42 = trustedCert;
                    X500Principal subjectX500Principal2 = subjectPrincipal;
                    PublicKey nextWorkingKey2 = publicKey;
                    size = this.f24282certs.size() - 1;
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
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustDNInvalid", new Object[]{new UntrustedInput(trustAnchor2.getCAName())}));
                        subjectPrincipal = null;
                    }
                    if (trustedCert2 != null && (keyUsage = trustedCert2.getKeyUsage()) != null && (keyUsage.length <= 5 || !keyUsage[5])) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustKeyUsage"));
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
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustPubKeyError"));
                    }
                } else {
                    trustedCert = null;
                    publicKey = null;
                }
                X509Certificate x509Certificate422 = trustedCert;
                X500Principal subjectX500Principal22 = subjectPrincipal;
                PublicKey nextWorkingKey22 = publicKey;
                size = this.f24282certs.size() - 1;
                while (size >= 0) {
                    int i4 = this.f24284n - size;
                    X509Certificate x509Certificate5 = (X509Certificate) this.f24282certs.get(size);
                    if (nextWorkingKey22 != null) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate5, nextWorkingKey22, this.pkixParams.getSigProvider());
                        } catch (GeneralSecurityException e3) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", new Object[]{e3.getMessage(), e3, e3.getClass().getName()});
                            addError(errorBundle, size);
                            x509Certificate5.checkValidity(this.validDate);
                            if (this.pkixParams.isRevocationEnabled()) {
                            }
                            if (x500Principal != null) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certWrongIssuer", new Object[]{x500Principal.getName(), x509Certificate.getIssuerX500Principal().getName()}), i3);
                            }
                            if (i == this.f24284n) {
                            }
                            c = 5;
                            subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                            nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                            CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                            size = i3 - 1;
                            x509Certificate422 = x509Certificate2;
                        }
                    } else if (CertPathValidatorUtilities.isSelfIssued(x509Certificate5)) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate5, x509Certificate5.getPublicKey(), this.pkixParams.getSigProvider());
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"), size);
                        } catch (GeneralSecurityException e4) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", new Object[]{e4.getMessage(), e4, e4.getClass().getName()});
                            addError(errorBundle, size);
                            x509Certificate5.checkValidity(this.validDate);
                            if (this.pkixParams.isRevocationEnabled()) {
                            }
                            if (x500Principal != null) {
                            }
                            if (i == this.f24284n) {
                            }
                            c = 5;
                            subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                            nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                            CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                            size = i3 - 1;
                            x509Certificate422 = x509Certificate2;
                        }
                    } else {
                        ErrorBundle errorBundle3 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.NoIssuerPublicKey");
                        byte[] extensionValue3 = x509Certificate5.getExtensionValue(Extension.authorityKeyIdentifier.m14433getId());
                        if (extensionValue3 != null && (authorityCertIssuer = (authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue3).getOctets())).getAuthorityCertIssuer()) != null) {
                            GeneralName generalName = authorityCertIssuer.getNames()[0];
                            BigInteger authorityCertSerialNumber = authorityKeyIdentifier.getAuthorityCertSerialNumber();
                            if (authorityCertSerialNumber != null) {
                                errorBundle3.setExtraArguments(new Object[]{new LocaleString(RESOURCE_NAME, "missingIssuer"), " \"", generalName, "\" ", new LocaleString(RESOURCE_NAME, "missingSerial"), " ", authorityCertSerialNumber});
                            }
                        }
                        addError(errorBundle3, size);
                    }
                    try {
                        x509Certificate5.checkValidity(this.validDate);
                    } catch (CertificateExpiredException unused5) {
                        errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certificateExpired", new Object[]{new TrustedInput(x509Certificate5.getNotAfter())});
                        addError(errorBundle2, size);
                        if (this.pkixParams.isRevocationEnabled()) {
                        }
                        if (x500Principal != null) {
                        }
                        if (i == this.f24284n) {
                        }
                        c = 5;
                        subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                        nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                        CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                        size = i3 - 1;
                        x509Certificate422 = x509Certificate2;
                    } catch (CertificateNotYetValidException unused6) {
                        errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certificateNotYetValid", new Object[]{new TrustedInput(x509Certificate5.getNotBefore())});
                        addError(errorBundle2, size);
                        if (this.pkixParams.isRevocationEnabled()) {
                        }
                        if (x500Principal != null) {
                        }
                        if (i == this.f24284n) {
                        }
                        c = 5;
                        subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                        nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                        CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                        size = i3 - 1;
                        x509Certificate422 = x509Certificate2;
                    }
                    if (this.pkixParams.isRevocationEnabled()) {
                        try {
                            extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509Certificate5, CRL_DIST_POINTS);
                        } catch (AnnotatedException unused7) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPtExtError"), size);
                        }
                        CRLDistPoint cRLDistPoint = extensionValue2 != null ? CRLDistPoint.getInstance(extensionValue2) : null;
                        try {
                            extensionValue = CertPathValidatorUtilities.getExtensionValue(x509Certificate5, AUTH_INFO_ACCESS);
                        } catch (AnnotatedException unused8) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlAuthInfoAccError"), size);
                        }
                        AuthorityInformationAccess authorityInformationAccess = extensionValue != null ? AuthorityInformationAccess.getInstance(extensionValue) : null;
                        Vector cRLDistUrls = getCRLDistUrls(cRLDistPoint);
                        Vector oCSPUrls = getOCSPUrls(authorityInformationAccess);
                        Iterator it = cRLDistUrls.iterator();
                        while (it.hasNext()) {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPoint", new Object[]{new UntrustedUrlInput(it.next())}), size);
                        }
                        Iterator it2 = oCSPUrls.iterator();
                        while (it2.hasNext()) {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ocspLocation", new Object[]{new UntrustedUrlInput(it2.next())}), size);
                        }
                        try {
                            x509Certificate = x509Certificate5;
                            i = i4;
                            i2 = size;
                            publicKey2 = nextWorkingKey22;
                            x500Principal = subjectX500Principal22;
                        } catch (CertPathReviewerException e5) {
                            e = e5;
                            x509Certificate = x509Certificate5;
                            i = i4;
                            i2 = size;
                            publicKey2 = nextWorkingKey22;
                            x500Principal = subjectX500Principal22;
                        }
                        try {
                            checkRevocation(this.pkixParams, x509Certificate5, this.validDate, x509Certificate422, nextWorkingKey22, cRLDistUrls, oCSPUrls, i2);
                            i3 = i2;
                        } catch (CertPathReviewerException e6) {
                            e = e6;
                            i3 = i2;
                            addError(e.getErrorMessage(), i3);
                            if (x500Principal != null) {
                            }
                            if (i == this.f24284n) {
                            }
                            c = 5;
                            subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                            nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                            CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                            size = i3 - 1;
                            x509Certificate422 = x509Certificate2;
                        }
                    } else {
                        x509Certificate = x509Certificate5;
                        i = i4;
                        i3 = size;
                        publicKey2 = nextWorkingKey22;
                        x500Principal = subjectX500Principal22;
                    }
                    if (x500Principal != null && !x509Certificate.getIssuerX500Principal().equals(x500Principal)) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certWrongIssuer", new Object[]{x500Principal.getName(), x509Certificate.getIssuerX500Principal().getName()}), i3);
                    }
                    if (i == this.f24284n) {
                        x509Certificate2 = x509Certificate;
                        if (x509Certificate2 != null && x509Certificate2.getVersion() == 1) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), i3);
                        }
                        try {
                            BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate2, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
                            if (basicConstraints == null) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBasicConstraints"), i3);
                            } else if (!basicConstraints.m14675isCA()) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), i3);
                            }
                        } catch (AnnotatedException unused9) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.errorProcesingBC"), i3);
                        }
                        boolean[] keyUsage2 = x509Certificate2.getKeyUsage();
                        if (keyUsage2 != null) {
                            c = 5;
                            if (keyUsage2.length <= 5 || !keyUsage2[5]) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCertSign"), i3);
                            }
                        }
                        subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                        nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                        CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                        size = i3 - 1;
                        x509Certificate422 = x509Certificate2;
                    } else {
                        x509Certificate2 = x509Certificate;
                    }
                    c = 5;
                    subjectX500Principal22 = x509Certificate2.getSubjectX500Principal();
                    nextWorkingKey22 = CertPathValidatorUtilities.getNextWorkingKey(this.f24282certs, i3);
                    CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey22);
                    size = i3 - 1;
                    x509Certificate422 = x509Certificate2;
                }
                this.trustAnchor = trustAnchor2;
                this.subjectPublicKey = nextWorkingKey22;
            }
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noTrustAnchorFound", new Object[]{new UntrustedInput(x509Certificate3.getIssuerX500Principal()), Integers.m18296valueOf(this.pkixParams.getTrustAnchors().size())}));
        }
        trustAnchor = null;
        trustAnchor2 = trustAnchor;
        if (trustAnchor2 == null) {
        }
        if (trustAnchor2 == null) {
        }
        X509Certificate x509Certificate4222 = trustedCert;
        X500Principal subjectX500Principal222 = subjectPrincipal;
        PublicKey nextWorkingKey222 = publicKey;
        size = this.f24282certs.size() - 1;
        while (size >= 0) {
        }
        this.trustAnchor = trustAnchor2;
        this.subjectPublicKey = nextWorkingKey222;
    }

    /* renamed from: getCRL */
    private X509CRL m18390getCRL(String str) throws Exception {
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
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.mo14450size(); i2++) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                        if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD");
                        } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.m14446equals((ASN1Primitive) qCStatement.getStatementId())) {
                            MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                            monetaryValue.getCurrency();
                            double dDoubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                            addNotification(monetaryValue.getCurrency().isAlphabetic() ? new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(dDoubleValue)), monetaryValue}) : new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.m18296valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(dDoubleValue)), monetaryValue}), i);
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i);
                            z = true;
                        }
                    }
                }
                addNotification(errorBundle, i);
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    public void addError(ErrorBundle errorBundle) {
        this.f24283errors[0].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0233  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkCRLs(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, int i) throws Exception {
        Iterator it;
        X509CRL x509crl;
        boolean z;
        boolean z2;
        boolean[] keyUsage;
        X509CRL x509crl2;
        Iterator it2;
        String str;
        X509CRL x509crlM18390getCRL;
        boolean z3;
        Iterator it3;
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            x509CRLStoreSelector.setCertificateChecking(x509Certificate);
            try {
                Set setFindCRLs = PKIXCRLUtil.findCRLs(x509CRLStoreSelector, pKIXParameters);
                Iterator it4 = setFindCRLs.iterator();
                if (setFindCRLs.isEmpty()) {
                    Iterator it5 = PKIXCRLUtil.findCRLs(new X509CRLStoreSelector(), pKIXParameters).iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it5.hasNext()) {
                        arrayList.add(((X509CRL) it5.next()).getIssuerX500Principal());
                    }
                    it3 = it4;
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlInCertstore", new Object[]{new UntrustedInput(x509CRLStoreSelector.getIssuerNames()), new UntrustedInput(arrayList), Integers.m18296valueOf(arrayList.size())}), i);
                } else {
                    it3 = it4;
                }
                it = it3;
            } catch (AnnotatedException e) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", new Object[]{e.getCause().getMessage(), e.getCause(), e.getCause().getClass().getName()}), i);
                it = new ArrayList().iterator();
            }
            X509CRL x509crl3 = null;
            while (it.hasNext()) {
                x509crl3 = (X509CRL) it.next();
                Date thisUpdate = x509crl3.getThisUpdate();
                Date nextUpdate = x509crl3.getNextUpdate();
                Object[] objArr = {new TrustedInput(thisUpdate), new TrustedInput(nextUpdate)};
                if (nextUpdate == null || date.before(nextUpdate)) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localValidCRL", objArr), i);
                    x509crl = x509crl3;
                    z = true;
                    break;
                }
                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localInvalidCRL", objArr), i);
            }
            x509crl = x509crl3;
            z = false;
            if (!z) {
                X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
                Iterator it6 = vector.iterator();
                boolean z4 = z;
                while (true) {
                    if (!it6.hasNext()) {
                        z2 = z4;
                        break;
                    }
                    try {
                        str = (String) it6.next();
                        x509crlM18390getCRL = m18390getCRL(str);
                    } catch (CertPathReviewerException e2) {
                        e = e2;
                        x509crl2 = x509crl;
                    }
                    if (x509crlM18390getCRL != null) {
                        X500Principal issuerX500Principal2 = x509crlM18390getCRL.getIssuerX500Principal();
                        if (issuerX500Principal.equals(issuerX500Principal2)) {
                            x509crl2 = x509crl;
                            it2 = it6;
                            z3 = z4;
                            Date thisUpdate2 = x509crlM18390getCRL.getThisUpdate();
                            Date nextUpdate2 = x509crlM18390getCRL.getNextUpdate();
                            Object[] objArr2 = {new TrustedInput(thisUpdate2), new TrustedInput(nextUpdate2), new UntrustedUrlInput(str)};
                            if (nextUpdate2 != null && !date.before(nextUpdate2)) {
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineInvalidCRL", objArr2), i);
                            }
                            try {
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineValidCRL", objArr2), i);
                                x509crl = x509crlM18390getCRL;
                                z2 = true;
                                break;
                            } catch (CertPathReviewerException e3) {
                                e = e3;
                                z4 = true;
                                addNotification(e.getErrorMessage(), i);
                                it6 = it2;
                                x509crl = x509crl2;
                            }
                        } else {
                            x509crl2 = x509crl;
                            try {
                                it2 = it6;
                                z3 = z4;
                            } catch (CertPathReviewerException e4) {
                                e = e4;
                                it2 = it6;
                                addNotification(e.getErrorMessage(), i);
                                it6 = it2;
                                x509crl = x509crl2;
                            }
                            try {
                                addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineCRLWrongCA", new Object[]{new UntrustedInput(issuerX500Principal2.getName()), new UntrustedInput(issuerX500Principal.getName()), new UntrustedUrlInput(str)}), i);
                            } catch (CertPathReviewerException e5) {
                                e = e5;
                                z4 = z3;
                                addNotification(e.getErrorMessage(), i);
                                it6 = it2;
                                x509crl = x509crl2;
                            }
                        }
                    } else {
                        x509crl2 = x509crl;
                        it2 = it6;
                        z3 = z4;
                    }
                    it6 = it2;
                    x509crl = x509crl2;
                    z4 = z3;
                }
            } else {
                z2 = z;
            }
            if (x509crl != null) {
                if (x509Certificate2 != null && (keyUsage = x509Certificate2.getKeyUsage()) != null && (keyUsage.length <= 6 || !keyUsage[6])) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlSigningPermited"));
                }
                if (publicKey == null) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNoIssuerPublicKey"));
                }
                try {
                    x509crl.verify(publicKey, BouncyCastleProvider.PROVIDER_NAME);
                    X509CRLEntry revokedCertificate = x509crl.getRevokedCertificate(x509Certificate.getSerialNumber());
                    if (revokedCertificate == null) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notRevoked"), i);
                    } else if (revokedCertificate.hasExtensions()) {
                        try {
                            ASN1Enumerated aSN1Enumerated = ASN1Enumerated.getInstance(CertPathValidatorUtilities.getExtensionValue(revokedCertificate, Extension.reasonCode.m14433getId()));
                            String str2 = aSN1Enumerated != null ? CertPathValidatorUtilities.crlReasons[aSN1Enumerated.intValueExact()] : null;
                            if (str2 == null) {
                                str2 = CertPathValidatorUtilities.crlReasons[7];
                            }
                            LocaleString localeString = new LocaleString(RESOURCE_NAME, str2);
                            if (!date.before(revokedCertificate.getRevocationDate())) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certRevoked", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString}));
                            }
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.revokedAfterValidation", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString}), i);
                        } catch (AnnotatedException e6) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlReasonExtError"), e6);
                        }
                    }
                    Date nextUpdate3 = x509crl.getNextUpdate();
                    if (nextUpdate3 != null && !date.before(nextUpdate3)) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlUpdateAvailable", new Object[]{new TrustedInput(nextUpdate3)}), i);
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
                                            Iterator it7 = PKIXCRLUtil.findCRLs(x509CRLStoreSelector2, pKIXParameters).iterator();
                                            while (it7.hasNext()) {
                                                try {
                                                    if (C6244Objects.areEqual(extensionValue, CertPathValidatorUtilities.getExtensionValue((X509CRL) it7.next(), CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT))) {
                                                    }
                                                } catch (AnnotatedException e7) {
                                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"), e7);
                                                }
                                            }
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBaseCRL"));
                                        } catch (AnnotatedException e8) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError"), e8);
                                        }
                                    } catch (AnnotatedException e9) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNbrExtError"), e9);
                                    }
                                } catch (IOException e10) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e10);
                                }
                            }
                            if (extensionValue != null) {
                                IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(extensionValue);
                                try {
                                    BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
                                    if (issuingDistributionPoint.onlyContainsUserCerts() && basicConstraints != null && basicConstraints.m14675isCA()) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyUserCert"));
                                    }
                                    if (issuingDistributionPoint.onlyContainsCACerts() && (basicConstraints == null || !basicConstraints.m14675isCA())) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyCaCert"));
                                    }
                                    if (issuingDistributionPoint.onlyContainsAttributeCerts()) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyAttrCert"));
                                    }
                                } catch (AnnotatedException e11) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlBCExtError"), e11);
                                }
                            }
                        } catch (AnnotatedException unused) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.deltaCrlExtError"));
                        }
                    } catch (AnnotatedException unused2) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"));
                    }
                } catch (Exception e12) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlVerifyFailed"), e12);
                }
            }
            if (!z2) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidCrlFound"));
            }
        } catch (IOException e13) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e13);
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
        int i = this.f24284n;
        this.notifications = new List[i + 1];
        this.f24283errors = new List[i + 1];
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
            this.f24283errors[i2] = new ArrayList();
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
        return this.f24284n;
    }

    public List getErrors(int i) throws Exception {
        doChecks();
        return this.f24283errors[i + 1];
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
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets());
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
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    /* renamed from: init */
    public void m18391init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
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
                this.f24282certs = arrayList;
            } catch (GeneralSecurityException unused) {
                throw new IllegalStateException("unable to rebuild certpath");
            }
        } else {
            this.certPath = certPath;
            this.f24282certs = certPath.getCertificates();
        }
        this.f24284n = this.f24282certs.size();
        if (this.f24282certs.isEmpty()) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        this.pkixParams = (PKIXParameters) pKIXParameters.clone();
        Date date = new Date();
        this.currentDate = date;
        this.validDate = CertPathValidatorUtilities.getValidityDate(this.pkixParams, date);
        this.notifications = null;
        this.f24283errors = null;
        this.trustAnchor = null;
        this.subjectPublicKey = null;
        this.policyTree = null;
    }

    public boolean isValidCertPath() throws Exception {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.f24283errors;
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
        m18391init(certPath, pKIXParameters);
    }

    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f24284n) {
            throw new IndexOutOfBoundsException();
        }
        this.f24283errors[i + 1].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f24284n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    public List[] getErrors() throws Exception {
        doChecks();
        return this.f24283errors;
    }

    public List[] getNotifications() throws Exception {
        doChecks();
        return this.notifications;
    }
}
