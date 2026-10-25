package org.bouncycastle.p300oer.p301its.template.etsi102941;

import java.math.BigInteger;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes.EtsiTs102941BaseTypes;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;

/* loaded from: classes2.dex */
public class EtsiTs102941TypesEnrolment {
    public static final OERDefinition.C5888Builder EnrolmentResponseCode;
    public static final OERDefinition.C5888Builder InnerEcRequest;
    public static final OERDefinition.C5888Builder InnerEcRequestSignedForPop;
    public static final OERDefinition.C5888Builder InnerEcResponse;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.enumeration(OERDefinition.enumItem("ok", BigInteger.ZERO), "cantparse", "badcontenttype", "imnottherecipient", "unknownencryptionalgorithm", "decryptionfailed", "unknownits", "invalidsignature", "invalidencryptionkey", "baditsstatus", "incompleterequest", "deniedpermissions", "invalidkeys", "deniedrequest", OERDefinition.extension(new Object[0])).typeName("EnrolmentResponseCode");
        EnrolmentResponseCode = c5888BuilderTypeName;
        InnerEcResponse = OERDefinition.m17139seq(OERDefinition.m17135octets(16).mo17150label("requestHash"), c5888BuilderTypeName.mo17150label("responseCode"), OERDefinition.optional(EtsiTs103097Module.EtsiTs103097Certificate.mo17150label("certificate")), OERDefinition.extension(new Object[0])).typeName("InnerEcResponse");
        InnerEcRequest = OERDefinition.m17139seq(OERDefinition.m17134octets().mo17150label("itsId"), EtsiTs102941BaseTypes.CertificateFormat.mo17150label("certificateFormat"), EtsiTs102941BaseTypes.PublicKeys.mo17150label("publicKeys"), EtsiTs102941BaseTypes.CertificateSubjectAttributes.mo17150label("requestedSubjectAttributes"), OERDefinition.extension(new Object[0])).typeName("InnerEcRequest");
        InnerEcRequestSignedForPop = EtsiTs103097Module.EtsiTs103097Data_Signed.typeName("InnerEcRequestSignedForPop");
    }
}
