package org.bouncycastle.p300oer.p301its.template.etsi102941;

import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes.EtsiTs102941BaseTypes;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs102941TrustLists {

    /* renamed from: AaEntry */
    public static final OERDefinition.C5888Builder f22799AaEntry;
    public static final OERDefinition.C5888Builder CrlEntry;
    public static final OERDefinition.C5888Builder CtlCommand;
    public static final OERDefinition.C5888Builder CtlDelete;
    public static final OERDefinition.C5888Builder CtlEntry;
    public static final OERDefinition.C5888Builder CtlFormat;
    public static final OERDefinition.C5888Builder DcDelete;

    /* renamed from: DcEntry */
    public static final OERDefinition.C5888Builder f22800DcEntry;
    public static final OERDefinition.C5888Builder DeltaCtl;

    /* renamed from: EaEntry */
    public static final OERDefinition.C5888Builder f22801EaEntry;

    /* renamed from: FullCtl */
    public static final OERDefinition.C5888Builder f22802FullCtl;
    public static final OERDefinition.C5888Builder RootCaEntry;
    public static final OERDefinition.C5888Builder SequenceOfCrlEntry;
    public static final OERDefinition.C5888Builder SequenceOfCtlCommand;
    public static final OERDefinition.C5888Builder TlmEntry;
    public static final OERDefinition.C5888Builder ToBeSignedCrl;
    public static final OERDefinition.C5888Builder ToBeSignedRcaCtl;
    public static final OERDefinition.C5888Builder ToBeSignedTlmCtl;

    /* renamed from: Url */
    public static final OERDefinition.C5888Builder f22803Url;

    static {
        OERDefinition.C5888Builder c5888Builder = Ieee1609Dot2BaseTypes.HashedId8;
        OERDefinition.C5888Builder c5888BuilderTypeName = c5888Builder.typeName("CrlEntry");
        CrlEntry = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17140seqof(c5888BuilderTypeName).typeName("SequenceOfCrlEntry");
        SequenceOfCrlEntry = c5888BuilderTypeName2;
        OERDefinition.C5888Builder c5888Builder2 = EtsiTs102941BaseTypes.f22804Version;
        OERDefinition.C5888Builder c5888BuilderMo17150label = c5888Builder2.mo17150label("version");
        OERDefinition.C5888Builder c5888Builder3 = Ieee1609Dot2BaseTypes.f22813Time32;
        ToBeSignedCrl = OERDefinition.m17139seq(c5888BuilderMo17150label, c5888Builder3.mo17150label("thisUpdate"), c5888Builder3.mo17150label("nextUpdate"), c5888BuilderTypeName2.mo17150label("entries"), OERDefinition.extension(new Object[0])).typeName("ToBeSignedCrl");
        OERDefinition.C5888Builder c5888BuilderTypeName3 = OERDefinition.ia5String().typeName("Url");
        f22803Url = c5888BuilderTypeName3;
        OERDefinition.C5888Builder c5888BuilderTypeName4 = c5888BuilderTypeName3.typeName("DcDelete");
        DcDelete = c5888BuilderTypeName4;
        OERDefinition.C5888Builder c5888BuilderTypeName5 = OERDefinition.m17139seq(c5888BuilderTypeName3.mo17150label("url"), Ieee1609Dot2BaseTypes.SequenceOfHashedId8.mo17150label("cert")).typeName("DcEntry");
        f22800DcEntry = c5888BuilderTypeName5;
        OERDefinition.C5888Builder c5888Builder4 = EtsiTs103097Module.EtsiTs103097Certificate;
        OERDefinition.C5888Builder c5888BuilderTypeName6 = OERDefinition.m17139seq(c5888Builder4.mo17150label("aaCertificate"), c5888BuilderTypeName3.mo17150label("accessPoint")).typeName("AaEntry");
        f22799AaEntry = c5888BuilderTypeName6;
        OERDefinition.C5888Builder c5888BuilderTypeName7 = OERDefinition.m17139seq(c5888Builder4.mo17150label("eaCertificate"), c5888BuilderTypeName3.mo17150label("aaAccessPoint"), OERDefinition.optional(c5888BuilderTypeName3.mo17150label("itsAccessPoint"))).typeName("EaEntry");
        f22801EaEntry = c5888BuilderTypeName7;
        OERDefinition.C5888Builder c5888BuilderTypeName8 = OERDefinition.m17139seq(c5888Builder4.mo17150label("selfsignedRootCa"), OERDefinition.optional(c5888Builder4.mo17150label("successorTo"))).typeName("RootCaEntry");
        RootCaEntry = c5888BuilderTypeName8;
        OERDefinition.C5888Builder c5888BuilderTypeName9 = OERDefinition.m17139seq(c5888Builder4.mo17150label("selfSignedTLMCertificate"), OERDefinition.optional(c5888Builder4.mo17150label("successorTo")), c5888BuilderTypeName3.mo17150label("accessPoint")).typeName("TlmEntry");
        TlmEntry = c5888BuilderTypeName9;
        OERDefinition.C5888Builder c5888BuilderTypeName10 = OERDefinition.m17128choice(c5888Builder.mo17150label("cert"), c5888BuilderTypeName4.mo17150label("dc"), OERDefinition.extension(new Object[0])).typeName("CtlDelete");
        CtlDelete = c5888BuilderTypeName10;
        OERDefinition.C5888Builder c5888BuilderTypeName11 = OERDefinition.m17128choice(c5888BuilderTypeName8.mo17150label("rca"), c5888BuilderTypeName7.mo17150label("ea"), c5888BuilderTypeName6.mo17150label("aa"), c5888BuilderTypeName5.mo17150label("dc"), c5888BuilderTypeName9.mo17150label("tlm"), OERDefinition.extension(new Object[0])).typeName("CtlEntry");
        CtlEntry = c5888BuilderTypeName11;
        OERDefinition.C5888Builder c5888BuilderTypeName12 = OERDefinition.m17128choice(c5888BuilderTypeName11.mo17150label("add"), c5888BuilderTypeName10.mo17150label("delete"), OERDefinition.extension(new Object[0])).typeName("CtlCommand");
        CtlCommand = c5888BuilderTypeName12;
        OERDefinition.C5888Builder c5888BuilderTypeName13 = OERDefinition.m17140seqof(c5888BuilderTypeName12).typeName("SequenceOfCtlCommand");
        SequenceOfCtlCommand = c5888BuilderTypeName13;
        OERDefinition.C5888Builder c5888BuilderTypeName14 = OERDefinition.m17139seq(c5888Builder2.mo17150label("version"), c5888Builder3.mo17150label("nextUpdate"), OERDefinition.m17127bool().mo17150label("isFullCtl"), OERDefinition.m17131integer(0L, 255L).mo17150label("ctlSequence"), c5888BuilderTypeName13.mo17150label("ctlCommands"), OERDefinition.extension(new Object[0])).typeName("CtlFormat");
        CtlFormat = c5888BuilderTypeName14;
        DeltaCtl = c5888BuilderTypeName14.typeName("DeltaCtl");
        f22802FullCtl = c5888BuilderTypeName14.typeName("FullCtl");
        ToBeSignedTlmCtl = c5888BuilderTypeName14.typeName("ToBeSignedRcaCtl");
        ToBeSignedRcaCtl = c5888BuilderTypeName14.typeName("ToBeSignedRcaCtl");
    }
}
