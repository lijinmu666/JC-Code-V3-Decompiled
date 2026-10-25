package org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes;

import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs102941BaseTypes {
    public static final OERDefinition.C5888Builder CertificateFormat = OERDefinition.m17131integer(0, 255).typeName("CertificateFormat");
    public static final OERDefinition.C5888Builder CertificateSubjectAttributes = OERDefinition.m17139seq(OERDefinition.optional(IEEE1609dot2.CertificateId.mo17150label("id"), Ieee1609Dot2BaseTypes.ValidityPeriod.mo17150label("validityPeriod"), Ieee1609Dot2BaseTypes.GeographicRegion.mo17150label("region"), Ieee1609Dot2BaseTypes.SubjectAssurance.mo17150label("assuranceLevel"), Ieee1609Dot2BaseTypes.SequenceOfPsidSsp.mo17150label("appPermissions"), IEEE1609dot2.SequenceOfPsidGroupPermissions.mo17150label("certIssuePermissions"), OERDefinition.extension(new Object[0]))).typeName("CertificateSubjectAttributes");
    public static final OERDefinition.C5888Builder EcSignature = OERDefinition.m17128choice(EtsiTs103097Module.EtsiTs103097Data_Encrypted.mo17150label("encryptedEcSignature"), EtsiTs103097Module.EtsiTs103097Data_SignedExternalPayload.mo17150label("ecSignature")).typeName("EcSignature");
    public static final OERDefinition.C5888Builder PublicKeys = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.PublicVerificationKey.mo17150label("verificationKey"), OERDefinition.optional(Ieee1609Dot2BaseTypes.PublicEncryptionKey.mo17150label("encryptionKey"))).typeName("PublicKeys");

    /* renamed from: Version */
    public static final OERDefinition.C5888Builder f22804Version = OERDefinition.m17131integer(0, 255).typeName("Version");
}
