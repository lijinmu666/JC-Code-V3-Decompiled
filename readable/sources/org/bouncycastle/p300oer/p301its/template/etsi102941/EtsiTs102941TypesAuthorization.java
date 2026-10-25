package org.bouncycastle.p300oer.p301its.template.etsi102941;

import java.math.BigInteger;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes.EtsiTs102941BaseTypes;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs102941TypesAuthorization {
    public static final OERDefinition.C5888Builder AuthorizationResponseCode;
    public static final OERDefinition.C5888Builder InnerAtRequest;
    public static final OERDefinition.C5888Builder InnerAtResponse;
    public static final OERDefinition.C5888Builder SharedAtRequest;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.enumeration(OERDefinition.enumItem("ok", BigInteger.ZERO), "its-aa-cantparse", "its-aa-badcontenttype", "its-aa-imnottherecipient", "its-aa-unknownencryptionalgorithm", "its-aa-decryptionfailed", "its-aa-keysdontmatch", "its-aa-incompleterequest", "its-aa-invalidencryptionkey", "its-aa-outofsyncrequest", "its-aa-unknownea", "its-aa-invalidea", "its-aa-deniedpermissions", "aa-ea-cantreachea", "ea-aa-cantparse", "ea-aa-badcontenttype", "ea-aa-imnottherecipient", "ea-aa-unknownencryptionalgorithm", "ea-aa-decryptionfailed", "invalidaa", "invalidaasignature", "wrongea", "unknownits", "invalidsignature", "invalidencryptionkey", "deniedpermissions", "deniedtoomanycerts").typeName("AuthorizationResponseCode");
        AuthorizationResponseCode = c5888BuilderTypeName;
        InnerAtResponse = OERDefinition.m17139seq(OERDefinition.m17135octets(16).mo17150label("requestHash"), c5888BuilderTypeName.mo17150label("responseCode"), OERDefinition.optional(EtsiTs103097Module.EtsiTs103097Certificate.mo17150label("certificate")), OERDefinition.extension(new Object[0])).typeName("InnerAtResponse");
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17139seq(Ieee1609Dot2BaseTypes.HashedId8.mo17150label("eaId"), OERDefinition.m17135octets(16).mo17150label("keyTag"), EtsiTs102941BaseTypes.CertificateFormat.mo17150label("certificateFormat"), EtsiTs102941BaseTypes.CertificateSubjectAttributes.mo17150label("requestedSubjectAttributes"), OERDefinition.extension(new Object[0])).typeName("SharedAtRequest");
        SharedAtRequest = c5888BuilderTypeName2;
        InnerAtRequest = OERDefinition.m17139seq(EtsiTs102941BaseTypes.PublicKeys.mo17150label("publicKeys"), OERDefinition.m17135octets(32).mo17150label("hmacKey"), c5888BuilderTypeName2.mo17150label("sharedAtRequest"), EtsiTs102941BaseTypes.EcSignature.mo17150label("ecSignature"), OERDefinition.extension(new Object[0])).typeName("InnerAtRequest");
    }
}
