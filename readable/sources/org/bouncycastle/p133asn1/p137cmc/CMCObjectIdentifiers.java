package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes.dex */
public interface CMCObjectIdentifiers {

    /* renamed from: id_cct */
    public static final ASN1ObjectIdentifier f18060id_cct;
    public static final ASN1ObjectIdentifier id_cct_PKIData;
    public static final ASN1ObjectIdentifier id_cct_PKIResponse;

    /* renamed from: id_cmc */
    public static final ASN1ObjectIdentifier f18061id_cmc;
    public static final ASN1ObjectIdentifier id_cmc_addExtensions;
    public static final ASN1ObjectIdentifier id_cmc_authData;
    public static final ASN1ObjectIdentifier id_cmc_batchRequests;
    public static final ASN1ObjectIdentifier id_cmc_batchResponses;
    public static final ASN1ObjectIdentifier id_cmc_confirmCertAcceptance;
    public static final ASN1ObjectIdentifier id_cmc_controlProcessed;
    public static final ASN1ObjectIdentifier id_cmc_dataReturn;
    public static final ASN1ObjectIdentifier id_cmc_decryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_encryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_getCRL;
    public static final ASN1ObjectIdentifier id_cmc_getCert;
    public static final ASN1ObjectIdentifier id_cmc_identification;
    public static final ASN1ObjectIdentifier id_cmc_identityProof;
    public static final ASN1ObjectIdentifier id_cmc_identityProofV2;
    public static final ASN1ObjectIdentifier id_cmc_lraPOPWitness;
    public static final ASN1ObjectIdentifier id_cmc_modCertTemplate;
    public static final ASN1ObjectIdentifier id_cmc_popLinkRandom;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitness;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitnessV2;
    public static final ASN1ObjectIdentifier id_cmc_publishCert;
    public static final ASN1ObjectIdentifier id_cmc_queryPending;
    public static final ASN1ObjectIdentifier id_cmc_recipientNonce;
    public static final ASN1ObjectIdentifier id_cmc_regInfo;
    public static final ASN1ObjectIdentifier id_cmc_responseInfo;
    public static final ASN1ObjectIdentifier id_cmc_revokeRequest;
    public static final ASN1ObjectIdentifier id_cmc_senderNonce;
    public static final ASN1ObjectIdentifier id_cmc_statusInfo;
    public static final ASN1ObjectIdentifier id_cmc_statusInfoV2;
    public static final ASN1ObjectIdentifier id_cmc_transactionId;
    public static final ASN1ObjectIdentifier id_cmc_trustedAnchors;

    /* renamed from: id_kp */
    public static final ASN1ObjectIdentifier f18062id_kp;
    public static final ASN1ObjectIdentifier id_kp_cmKGA;
    public static final ASN1ObjectIdentifier id_kp_cmcCA;
    public static final ASN1ObjectIdentifier id_kp_cmcRA;

    /* renamed from: id_pkix */
    public static final ASN1ObjectIdentifier f18063id_pkix;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        f18063id_pkix = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("7");
        f18061id_cmc = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifier.m14432branch("12");
        f18060id_cct = aSN1ObjectIdentifierM14432branch2;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifier.m14432branch("3");
        f18062id_kp = aSN1ObjectIdentifierM14432branch3;
        id_cmc_identityProof = aSN1ObjectIdentifierM14432branch.m14432branch("3");
        id_cmc_dataReturn = aSN1ObjectIdentifierM14432branch.m14432branch("4");
        id_cmc_regInfo = aSN1ObjectIdentifierM14432branch.m14432branch("18");
        id_cmc_responseInfo = aSN1ObjectIdentifierM14432branch.m14432branch("19");
        id_cmc_queryPending = aSN1ObjectIdentifierM14432branch.m14432branch("21");
        id_cmc_popLinkRandom = aSN1ObjectIdentifierM14432branch.m14432branch("22");
        id_cmc_popLinkWitness = aSN1ObjectIdentifierM14432branch.m14432branch("23");
        id_cmc_identification = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_cmc_transactionId = aSN1ObjectIdentifierM14432branch.m14432branch("5");
        id_cmc_senderNonce = aSN1ObjectIdentifierM14432branch.m14432branch("6");
        id_cmc_recipientNonce = aSN1ObjectIdentifierM14432branch.m14432branch("7");
        id_cct_PKIData = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        id_cct_PKIResponse = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_cmc_statusInfo = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_cmc_addExtensions = aSN1ObjectIdentifierM14432branch.m14432branch("8");
        id_cmc_encryptedPOP = aSN1ObjectIdentifierM14432branch.m14432branch("9");
        id_cmc_decryptedPOP = aSN1ObjectIdentifierM14432branch.m14432branch("10");
        id_cmc_lraPOPWitness = aSN1ObjectIdentifierM14432branch.m14432branch("11");
        id_cmc_getCert = aSN1ObjectIdentifierM14432branch.m14432branch("15");
        id_cmc_getCRL = aSN1ObjectIdentifierM14432branch.m14432branch("16");
        id_cmc_revokeRequest = aSN1ObjectIdentifierM14432branch.m14432branch("17");
        id_cmc_confirmCertAcceptance = aSN1ObjectIdentifierM14432branch.m14432branch("24");
        id_cmc_statusInfoV2 = aSN1ObjectIdentifierM14432branch.m14432branch("25");
        id_cmc_trustedAnchors = aSN1ObjectIdentifierM14432branch.m14432branch("26");
        id_cmc_authData = aSN1ObjectIdentifierM14432branch.m14432branch("27");
        id_cmc_batchRequests = aSN1ObjectIdentifierM14432branch.m14432branch("28");
        id_cmc_batchResponses = aSN1ObjectIdentifierM14432branch.m14432branch("29");
        id_cmc_publishCert = aSN1ObjectIdentifierM14432branch.m14432branch("30");
        id_cmc_modCertTemplate = aSN1ObjectIdentifierM14432branch.m14432branch("31");
        id_cmc_controlProcessed = aSN1ObjectIdentifierM14432branch.m14432branch("32");
        id_cmc_identityProofV2 = aSN1ObjectIdentifierM14432branch.m14432branch("34");
        id_cmc_popLinkWitnessV2 = aSN1ObjectIdentifierM14432branch.m14432branch("33");
        id_kp_cmcCA = aSN1ObjectIdentifierM14432branch3.m14432branch("27");
        id_kp_cmcRA = aSN1ObjectIdentifierM14432branch3.m14432branch("28");
        id_kp_cmKGA = aSN1ObjectIdentifierM14432branch3.m14432branch("32");
    }
}
