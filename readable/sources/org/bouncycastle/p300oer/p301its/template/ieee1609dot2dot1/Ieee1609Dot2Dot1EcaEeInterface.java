package org.bouncycastle.p300oer.p301its.template.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class Ieee1609Dot2Dot1EcaEeInterface {
    public static final OERDefinition.C5888Builder EeEcaCertRequest = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.f22819UINT8.mo17150label("version").validSwitchValue(ASN1Integer.f17920TWO), Ieee1609Dot2BaseTypes.f22813Time32.mo17150label("generationTime"), IEEE1609dot2.CertificateType.mo17150label("type"), IEEE1609dot2.ToBeSignedCertificate.mo17150label("tbsCert"), OERDefinition.optional(OERDefinition.ia5String().mo17150label("canonicalId")), OERDefinition.extension(new Object[0])).typeName("EeEcaCertRequest");
}
