package org.bouncycastle.p300oer.p301its.template.etsi102941;

import java.math.BigInteger;
import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes.EtsiTs102941BaseTypes;

/* loaded from: classes2.dex */
public class EtsiTs102941TypesAuthorizationValidation {
    public static final OERDefinition.C5888Builder AuthorizationValidationRequest;
    public static final OERDefinition.C5888Builder AuthorizationValidationResponse;
    public static final OERDefinition.C5888Builder AuthorizationValidationResponseCode;

    static {
        OERDefinition.C5888Builder c5888BuilderTypeName = OERDefinition.enumeration(OERDefinition.enumItem("ok", BigInteger.ZERO), "cantparse", "badcontenttype", "imnottherecipient", "unknownencryptionalgorithm", "decryptionfailed", "invalidaa", "invalidaasignature", "wrongea", "unknownits", "invalidsignature", "invalidencryptionkey", "deniedpermissions", "deniedtoomanycerts", "deniedrequest").typeName("AuthorizationValidationResponseCode");
        AuthorizationValidationResponseCode = c5888BuilderTypeName;
        AuthorizationValidationRequest = OERDefinition.m17139seq(EtsiTs102941TypesAuthorization.SharedAtRequest.mo17150label("sharedAtRequest"), EtsiTs102941BaseTypes.EcSignature.mo17150label("ecSignature"), OERDefinition.extension(new Object[0])).typeName("AuthorizationValidationRequest");
        AuthorizationValidationResponse = OERDefinition.m17139seq(OERDefinition.m17135octets(16).mo17150label("requestHash"), c5888BuilderTypeName.mo17150label("responseCode"), OERDefinition.optional(EtsiTs102941BaseTypes.CertificateSubjectAttributes.mo17150label("confirmedSubjectAttributes")), OERDefinition.extension(new Object[0])).typeName("AuthorizationValidationResponse");
    }
}
