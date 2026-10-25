package org.bouncycastle.p300oer.p301its.template.etsi102941;

import org.bouncycastle.p300oer.OERDefinition;
import org.bouncycastle.p300oer.p301its.template.etsi102941.basetypes.EtsiTs102941BaseTypes;
import org.bouncycastle.p300oer.p301its.template.etsi103097.EtsiTs103097Module;

/* loaded from: classes2.dex */
public class EtsiTs102941MessagesCa {
    public static final OERDefinition.C5888Builder AuthorizationRequestMessage;
    public static final OERDefinition.C5888Builder AuthorizationRequestMessageWithPop;
    public static final OERDefinition.C5888Builder AuthorizationResponseMessage;
    public static final OERDefinition.C5888Builder AuthorizationValidationRequestMessage;
    public static final OERDefinition.C5888Builder CaCertificateRekeyingMessage;
    public static final OERDefinition.C5888Builder CaCertificateRequestMessage;
    public static final OERDefinition.C5888Builder CertificateRevocationListMessage;
    public static final OERDefinition.C5888Builder EnrolmentRequestMessage;
    public static final OERDefinition.C5888Builder EnrolmentResponseMessage;
    public static final OERDefinition.C5888Builder EtsiTs102941Data;
    public static final OERDefinition.C5888Builder EtsiTs102941DataContent;
    public static final OERDefinition.C5888Builder RcaCertificateTrustListMessage;
    public static final OERDefinition.C5888Builder RcaDoubleSignedLinkCertificateMessage;
    public static final OERDefinition.C5888Builder RcaSingleSignedLinkCertificateMessage;
    public static final OERDefinition.C5888Builder TlmCertificateTrustListMessage;
    public static final OERDefinition.C5888Builder TlmLinkCertificateMessage;

    static {
        OERDefinition.C5888Builder c5888Builder = EtsiTs103097Module.EtsiTs103097Data_SignedAndEncrypted_Unicast;
        EnrolmentRequestMessage = c5888Builder.typeName("EnrolmentRequestMessage");
        EnrolmentResponseMessage = c5888Builder.typeName("EnrolmentResponseMessage");
        AuthorizationRequestMessage = EtsiTs103097Module.EtsiTs103097Data_Encrypted_Unicast.typeName("AuthorizationRequestMessage");
        AuthorizationRequestMessageWithPop = c5888Builder.typeName("AuthorizationRequestMessageWithPop");
        AuthorizationResponseMessage = c5888Builder.typeName("AuthorizationResponseMessage");
        OERDefinition.C5888Builder c5888Builder2 = EtsiTs103097Module.EtsiTs103097Data_Signed;
        CertificateRevocationListMessage = c5888Builder2.typeName("CertificateRevocationListMessage");
        TlmCertificateTrustListMessage = c5888Builder2.typeName("TlmCertificateTrustListMessage");
        RcaCertificateTrustListMessage = c5888Builder2.typeName("RcaCertificateTrustListMessage");
        OERDefinition.C5888Builder c5888BuilderTypeName = c5888Builder2.typeName("RcaSingleSignedLinkCertificateMessage");
        RcaSingleSignedLinkCertificateMessage = c5888BuilderTypeName;
        OERDefinition.C5888Builder c5888BuilderTypeName2 = OERDefinition.m17128choice(EtsiTs102941TypesEnrolment.InnerEcRequestSignedForPop.mo17150label("enrolmentRequest"), EtsiTs102941TypesEnrolment.InnerEcResponse.mo17150label("enrolmentResponse"), EtsiTs102941TypesAuthorization.InnerAtRequest.mo17150label("authorizationRequest"), EtsiTs102941TypesAuthorization.InnerAtResponse.mo17150label("authorizationResponse"), EtsiTs102941TrustLists.ToBeSignedCrl.mo17150label("certificateRevocationList"), EtsiTs102941TrustLists.ToBeSignedTlmCtl.mo17150label("certificateTrustListTlm"), EtsiTs102941TrustLists.ToBeSignedRcaCtl.mo17150label("certificateTrustListRca"), EtsiTs102941TypesAuthorizationValidation.AuthorizationValidationRequest.mo17150label("authorizationValidationRequest"), EtsiTs102941TypesAuthorizationValidation.AuthorizationValidationResponse.mo17150label("authorizationValidationResponse"), EtsiTs102941TypesCaManagement.CaCertificateRequest.mo17150label("caCertificateRequest"), OERDefinition.extension(EtsiTs102941TypesLinkCertificate.ToBeSignedLinkCertificateTlm.mo17150label("linkCertificateTlm"), EtsiTs102941TypesLinkCertificate.ToBeSignedLinkCertificateRca.mo17150label("singleSignedLinkCertificateRca"), c5888BuilderTypeName.mo17150label("doubleSignedlinkCertificateRca"))).typeName("EtsiTs102941DataContent");
        EtsiTs102941DataContent = c5888BuilderTypeName2;
        EtsiTs102941Data = OERDefinition.m17139seq(EtsiTs102941BaseTypes.f22804Version.mo17150label("version"), c5888BuilderTypeName2.mo17150label("content")).typeName("EtsiTs102941Data");
        AuthorizationValidationRequestMessage = c5888Builder.typeName("AuthorizationValidationRequestMessage");
        CaCertificateRequestMessage = c5888Builder2.typeName("CaCertificateRequestMessage");
        CaCertificateRekeyingMessage = c5888Builder2.typeName("CaCertificateRekeyingMessage");
        TlmLinkCertificateMessage = c5888Builder2.typeName("TlmLinkCertificateMessage");
        RcaDoubleSignedLinkCertificateMessage = c5888Builder2.typeName("RcaDoubleSignedLinkCertificateMessage");
    }
}
