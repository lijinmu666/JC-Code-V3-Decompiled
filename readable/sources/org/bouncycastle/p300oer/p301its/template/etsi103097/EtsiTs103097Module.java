package org.bouncycastle.p300oer.p301its.template.etsi103097;

import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;

/* loaded from: classes2.dex */
public class EtsiTs103097Module {
    public static final OERDefinition.C5888Builder EtsiTs103097Certificate = IEEE1609dot2.ExplicitCertificate.typeName("EtsiTs103097Certificate");
    public static final OERDefinition.C5888Builder EtsiTs103097Data;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_Encrypted;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_Encrypted_Unicast;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_Signed;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_SignedAndEncrypted;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_SignedAndEncrypted_Unicast;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_SignedExternalPayload;
    public static final OERDefinition.C5888Builder EtsiTs103097Data_Unsecured;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = IEEE1609dot2.Ieee1609Dot2Data.typeName("EtsiTs103097Data");
        EtsiTs103097Data = c5888BuilderTypeName;
        EtsiTs103097Data_Unsecured = c5888BuilderTypeName.typeName("EtsiTs103097DataUnsecured");
        EtsiTs103097Data_Signed = c5888BuilderTypeName.typeName("EtsiTs103097DataSigned");
        EtsiTs103097Data_SignedExternalPayload = c5888BuilderTypeName.typeName("EtsiTs103097DataSignedExternalPayload");
        EtsiTs103097Data_Encrypted = c5888BuilderTypeName.typeName("EtsiTs103097DataEncrypted");
        EtsiTs103097Data_SignedAndEncrypted = c5888BuilderTypeName.typeName("EtsiTs103097DataSignedAndEncrypted");
        EtsiTs103097Data_Encrypted_Unicast = c5888BuilderTypeName.typeName("EtsiTs103097DataEncryptedUnicast");
        EtsiTs103097Data_SignedAndEncrypted_Unicast = c5888BuilderTypeName.typeName("EtsiTs103097DataSignedAndEncryptedUnicast");
    }
}
