package org.bouncycastle.p300oer.p301its.template.etsi103097.extension;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p300oer.C5887Element;
import org.bouncycastle.p300oer.InterfaceC5893Switch;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.SwitchIndexer;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs103097ExtensionModule {
    public static final OERDefinition.C5888Builder EtsiOriginatingHeaderInfoExtension;
    public static final OERDefinition.C5888Builder EtsiTs102941CrlRequest;
    public static final OERDefinition.C5888Builder EtsiTs102941CtlRequest;
    public static final OERDefinition.C5888Builder EtsiTs102941DeltaCtlRequest;

    /* renamed from: ExtId */
    public static final OERDefinition.C5888Builder f22805ExtId;
    public static final OERDefinition.C5888Builder Extension;
    public static final ASN1Integer etsiTs102941CrlRequestId;
    public static final ASN1Integer etsiTs102941DeltaCtlRequestId;
    private static final ASN1Encodable[] extensionKeys;

    static {
        ASN1Integer aSN1Integer = ASN1Integer.f17918ONE;
        etsiTs102941CrlRequestId = aSN1Integer;
        ASN1Integer aSN1Integer2 = ASN1Integer.f17920TWO;
        etsiTs102941DeltaCtlRequestId = aSN1Integer2;
        extensionKeys = new ASN1Encodable[]{aSN1Integer, aSN1Integer2};
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.m17131integer(0L, 255L).validSwitchValue(aSN1Integer, aSN1Integer2).typeName("ExtId");
        f22805ExtId = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888Builder = Ieee1609Dot2BaseTypes.HashedId8;
        EtsiTs102941CrlRequest = OERDefinition.m17139seq(c5888Builder.mo17150label("issuerId"), OERDefinition.optional(Ieee1609Dot2BaseTypes.f22813Time32.mo17150label("lastKnownUpdate"))).typeName("EtsiTs102941CrlRequest");
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17139seq(c5888Builder.mo17150label("issuerId"), OERDefinition.optional(OERDefinition.m17131integer(0L, 255L).mo17150label("lastKnownCtlSequence"))).typeName("EtsiTs102941CtlRequest");
        EtsiTs102941CtlRequest = c5888BuilderTypeName2;
        EtsiTs102941DeltaCtlRequest = c5888BuilderTypeName2.typeName("EtsiTs102941DeltaCtlRequest");
        OERDefinition.C5888Builder c5888BuilderTypeName3 = OERDefinition.m17139seq(c5888BuilderTypeName.mo17150label("id"), OERDefinition.m17126aSwitch(new InterfaceC5893Switch() { // from class: org.bouncycastle.oer.its.template.etsi103097.extension.EtsiTs103097ExtensionModule.1
            private final C5887Element etsiTs102941CrlRequestIdDef = EtsiTs103097ExtensionModule.EtsiTs102941CrlRequest.mo17150label("content").m17146build();
            private final C5887Element etsiTs102941DeltaCtlRequestIdDef = EtsiTs103097ExtensionModule.EtsiTs102941DeltaCtlRequest.mo17150label("content").m17146build();

            @Override // org.bouncycastle.p300oer.InterfaceC5893Switch
            /* renamed from: keys */
            public ASN1Encodable[] mo17169keys() {
                return EtsiTs103097ExtensionModule.extensionKeys;
            }

            @Override // org.bouncycastle.p300oer.InterfaceC5893Switch
            /* renamed from: result */
            public C5887Element mo17170result(SwitchIndexer switchIndexer) {
                ASN1Integer aSN1Integer3 = ASN1Integer.getInstance(switchIndexer.mo17171get(0).toASN1Primitive());
                if (aSN1Integer3.m14446equals((ASN1Primitive) EtsiTs103097ExtensionModule.etsiTs102941CrlRequestId)) {
                    return this.etsiTs102941CrlRequestIdDef;
                }
                if (aSN1Integer3.m14446equals((ASN1Primitive) EtsiTs103097ExtensionModule.etsiTs102941DeltaCtlRequestId)) {
                    return this.etsiTs102941DeltaCtlRequestIdDef;
                }
                throw new IllegalStateException("unknown extension type " + aSN1Integer3);
            }
        }).mo17150label("content")).typeName("Extension");
        Extension = c5888BuilderTypeName3;
        EtsiOriginatingHeaderInfoExtension = c5888BuilderTypeName3.typeName("EtsiOriginatingHeaderInfoExtension");
    }
}
