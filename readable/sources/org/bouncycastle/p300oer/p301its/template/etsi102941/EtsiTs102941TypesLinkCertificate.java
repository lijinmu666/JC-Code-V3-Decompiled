package org.bouncycastle.p300oer.p301its.template.etsi102941;

import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs102941TypesLinkCertificate {
    public static final OERDefinition.C5888Builder ToBeSignedLinkCertificate;
    public static final OERDefinition.C5888Builder ToBeSignedLinkCertificateRca;
    public static final OERDefinition.C5888Builder ToBeSignedLinkCertificateTlm;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.f22813Time32.mo17150label("expiryTime"), IEEE1609dot2.HashedData.mo17150label("certificateHash"), OERDefinition.extension(new Object[0])).typeName("ToBeSignedLinkCertificate");
        ToBeSignedLinkCertificate = c5888BuilderTypeName;
        ToBeSignedLinkCertificateTlm = c5888BuilderTypeName.typeName("ToBeSignedLinkCertificateTlm");
        ToBeSignedLinkCertificateRca = c5888BuilderTypeName.typeName("ToBeSignedLinkCertificateRca");
    }
}
