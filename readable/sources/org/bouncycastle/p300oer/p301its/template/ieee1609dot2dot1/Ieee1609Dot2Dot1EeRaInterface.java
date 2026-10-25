package org.bouncycastle.p300oer.p301its.template.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class Ieee1609Dot2Dot1EeRaInterface {
    public static final OERDefinition.C5888Builder AdditionalParams;
    public static final OERDefinition.C5888Builder ButterflyExpansion;
    public static final OERDefinition.C5888Builder ButterflyParamsOriginal;
    public static final OERDefinition.C5888Builder EeRaCertRequest;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.m17128choice(OERDefinition.m17135octets(16).mo17150label("aes128"), OERDefinition.extension(new Object[0])).typeName("ButterflyExpansion");
        ButterflyExpansion = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888BuilderMo17150label = c5888BuilderTypeName.mo17150label("signingExpansion");
        OERDefinition.C5888Builder c5888Builder = Ieee1609Dot2BaseTypes.PublicEncryptionKey;
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17139seq(c5888BuilderMo17150label, c5888Builder.mo17150label("encryptionKey"), c5888BuilderTypeName.mo17150label("encryptionExpansion")).typeName("ButterflyParamsOriginal");
        ButterflyParamsOriginal = c5888BuilderTypeName2;
        OERDefinition.C5888Builder c5888BuilderTypeName3 = OERDefinition.m17128choice(c5888BuilderTypeName2.mo17150label("original"), c5888BuilderTypeName.mo17150label("unified"), c5888BuilderTypeName.mo17150label("compactUnified"), c5888Builder.mo17150label("encryptionKey"), OERDefinition.extension(new Object[0])).typeName("AdditionalParams");
        AdditionalParams = c5888BuilderTypeName3;
        EeRaCertRequest = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.f22819UINT8.mo17150label("version").validSwitchValue(ASN1Integer.f17920TWO), Ieee1609Dot2BaseTypes.f22813Time32.mo17150label("generationTime"), IEEE1609dot2.CertificateType.mo17150label("type"), IEEE1609dot2.ToBeSignedCertificate.mo17150label("tbsCert"), OERDefinition.optional(c5888BuilderTypeName3.mo17150label("additionalParams")), OERDefinition.extension(new Object[0])).typeName("EeRaCertRequest");
    }
}
