package org.bouncycastle.p310pkix.p312util;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.KeyPurposeId;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p302openssl.PEMParser;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class X509CertificateFormatter {
    private static final String spaceStr = "                                                              ";

    /* renamed from: oidMap */
    private static Map<ASN1ObjectIdentifier, String> f23005oidMap = new HashMap();
    private static Map<ASN1ObjectIdentifier, String> keyAlgMap = new HashMap();
    private static Map<KeyPurposeId, String> extUsageMap = new HashMap();
    private static Map<Integer, String> usageMap = new HashMap();

    static {
        f23005oidMap.put(Extension.subjectDirectoryAttributes, "subjectDirectoryAttributes");
        f23005oidMap.put(Extension.subjectKeyIdentifier, "subjectKeyIdentifier");
        f23005oidMap.put(Extension.keyUsage, "keyUsage");
        f23005oidMap.put(Extension.privateKeyUsagePeriod, "privateKeyUsagePeriod");
        f23005oidMap.put(Extension.subjectAlternativeName, "subjectAlternativeName");
        f23005oidMap.put(Extension.issuerAlternativeName, "issuerAlternativeName");
        f23005oidMap.put(Extension.basicConstraints, "basicConstraints");
        f23005oidMap.put(Extension.cRLNumber, "cRLNumber");
        f23005oidMap.put(Extension.reasonCode, "reasonCode");
        f23005oidMap.put(Extension.instructionCode, "instructionCode");
        f23005oidMap.put(Extension.invalidityDate, "invalidityDate");
        f23005oidMap.put(Extension.deltaCRLIndicator, "deltaCRLIndicator");
        f23005oidMap.put(Extension.issuingDistributionPoint, "issuingDistributionPoint");
        f23005oidMap.put(Extension.certificateIssuer, "certificateIssuer");
        f23005oidMap.put(Extension.nameConstraints, "nameConstraints");
        f23005oidMap.put(Extension.cRLDistributionPoints, "cRLDistributionPoints");
        f23005oidMap.put(Extension.certificatePolicies, "certificatePolicies");
        f23005oidMap.put(Extension.policyMappings, "policyMappings");
        f23005oidMap.put(Extension.authorityKeyIdentifier, "authorityKeyIdentifier");
        f23005oidMap.put(Extension.policyConstraints, "policyConstraints");
        f23005oidMap.put(Extension.extendedKeyUsage, "extendedKeyUsage");
        f23005oidMap.put(Extension.freshestCRL, "freshestCRL");
        f23005oidMap.put(Extension.inhibitAnyPolicy, "inhibitAnyPolicy");
        f23005oidMap.put(Extension.authorityInfoAccess, "authorityInfoAccess");
        f23005oidMap.put(Extension.subjectInfoAccess, "subjectInfoAccess");
        f23005oidMap.put(Extension.logoType, "logoType");
        f23005oidMap.put(Extension.biometricInfo, "biometricInfo");
        f23005oidMap.put(Extension.qCStatements, "qCStatements");
        f23005oidMap.put(Extension.auditIdentity, "auditIdentity");
        f23005oidMap.put(Extension.noRevAvail, "noRevAvail");
        f23005oidMap.put(Extension.targetInformation, "targetInformation");
        f23005oidMap.put(Extension.expiredCertsOnCRL, "expiredCertsOnCRL");
        usageMap.put(128, "digitalSignature");
        usageMap.put(64, "nonRepudiation");
        usageMap.put(32, "keyEncipherment");
        usageMap.put(16, "dataEncipherment");
        usageMap.put(8, "keyAgreement");
        usageMap.put(4, "keyCertSign");
        usageMap.put(2, "cRLSign");
        usageMap.put(1, "encipherOnly");
        usageMap.put(32768, "decipherOnly");
        extUsageMap.put(KeyPurposeId.anyExtendedKeyUsage, "anyExtendedKeyUsage");
        extUsageMap.put(KeyPurposeId.id_kp_serverAuth, "id_kp_serverAuth");
        extUsageMap.put(KeyPurposeId.id_kp_clientAuth, "id_kp_clientAuth");
        extUsageMap.put(KeyPurposeId.id_kp_codeSigning, "id_kp_codeSigning");
        extUsageMap.put(KeyPurposeId.id_kp_emailProtection, "id_kp_emailProtection");
        extUsageMap.put(KeyPurposeId.id_kp_ipsecEndSystem, "id_kp_ipsecEndSystem");
        extUsageMap.put(KeyPurposeId.id_kp_ipsecTunnel, "id_kp_ipsecTunnel");
        extUsageMap.put(KeyPurposeId.id_kp_ipsecUser, "id_kp_ipsecUser");
        extUsageMap.put(KeyPurposeId.id_kp_timeStamping, "id_kp_timeStamping");
        extUsageMap.put(KeyPurposeId.id_kp_OCSPSigning, "id_kp_OCSPSigning");
        extUsageMap.put(KeyPurposeId.id_kp_dvcs, "id_kp_dvcs");
        extUsageMap.put(KeyPurposeId.id_kp_sbgpCertAAServerAuth, "id_kp_sbgpCertAAServerAuth");
        extUsageMap.put(KeyPurposeId.id_kp_scvp_responder, "id_kp_scvp_responder");
        extUsageMap.put(KeyPurposeId.id_kp_eapOverPPP, "id_kp_eapOverPPP");
        extUsageMap.put(KeyPurposeId.id_kp_eapOverLAN, "id_kp_eapOverLAN");
        extUsageMap.put(KeyPurposeId.id_kp_scvpServer, "id_kp_scvpServer");
        extUsageMap.put(KeyPurposeId.id_kp_scvpClient, "id_kp_scvpClient");
        extUsageMap.put(KeyPurposeId.id_kp_ipsecIKE, "id_kp_ipsecIKE");
        extUsageMap.put(KeyPurposeId.id_kp_capwapAC, "id_kp_capwapAC");
        extUsageMap.put(KeyPurposeId.id_kp_capwapWTP, "id_kp_capwapWTP");
        extUsageMap.put(KeyPurposeId.id_kp_cmcCA, "id_kp_cmcCA");
        extUsageMap.put(KeyPurposeId.id_kp_cmcRA, "id_kp_cmcRA");
        extUsageMap.put(KeyPurposeId.id_kp_cmKGA, "id_kp_cmKGA");
        extUsageMap.put(KeyPurposeId.id_kp_smartcardlogon, "id_kp_smartcardlogon");
        extUsageMap.put(KeyPurposeId.id_kp_macAddress, "id_kp_macAddress");
        extUsageMap.put(KeyPurposeId.id_kp_msSGC, "id_kp_msSGC");
        extUsageMap.put(KeyPurposeId.id_kp_nsSGC, "id_kp_nsSGC");
        keyAlgMap.put(PKCSObjectIdentifiers.rsaEncryption, "rsaEncryption");
        keyAlgMap.put(X9ObjectIdentifiers.id_ecPublicKey, "id_ecPublicKey");
        keyAlgMap.put(EdECObjectIdentifiers.id_Ed25519, "id_Ed25519");
        keyAlgMap.put(EdECObjectIdentifiers.id_Ed448, "id_Ed448");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:46:0x022e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String asString(org.bouncycastle.p177cert.X509CertificateHolder r14) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.p310pkix.p312util.X509CertificateFormatter.asString(org.bouncycastle.cert.X509CertificateHolder):java.lang.String");
    }

    /* renamed from: format */
    public static void m17456format(StringBuilder sb, byte[] bArr, String str) {
        int i = 20;
        while (i < bArr.length) {
            int length = bArr.length - 20;
            sb.append("                       ");
            sb.append(i < length ? C6255Hex.toHexString(bArr, i, 20) : C6255Hex.toHexString(bArr, i, bArr.length - i));
            sb.append(str);
            i += 20;
        }
    }

    /* renamed from: indent */
    private static String m17457indent(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str2.substring(0, str2.length() - str3.length());
        while (true) {
            int iIndexOf = strSubstring.indexOf(str3);
            if (iIndexOf <= 0) {
                break;
            }
            sb.append(strSubstring.substring(0, iIndexOf));
            sb.append(str3);
            sb.append(str);
            if (strSubstring.length() > 0) {
                strSubstring = strSubstring.substring(iIndexOf + str3.length());
            }
        }
        if (sb.length() == 0) {
            return strSubstring;
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    private static String keyAlgToLabel(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = keyAlgMap.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    /* renamed from: main */
    public static void m17458main(String[] strArr) {
        System.out.println(asString((X509CertificateHolder) new PEMParser(new FileReader(strArr[0])).readObject()));
    }

    private static String oidToLabel(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = f23005oidMap.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    public static void prettyPrintData(byte[] bArr, StringBuilder sb, String str) {
        if (bArr.length <= 20) {
            sb.append(C6255Hex.toHexString(bArr));
            sb.append(str);
        } else {
            sb.append(C6255Hex.toHexString(bArr, 0, 20));
            sb.append(str);
            m17456format(sb, bArr, str);
        }
    }

    /* renamed from: spaces */
    private static String m17459spaces(int i) {
        return spaceStr.substring(0, i);
    }
}
