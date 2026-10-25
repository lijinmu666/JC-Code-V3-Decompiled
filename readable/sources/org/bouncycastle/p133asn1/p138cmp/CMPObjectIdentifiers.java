package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p141crmf.CRMFObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes.dex */
public interface CMPObjectIdentifiers {
    public static final ASN1ObjectIdentifier ct_encKeyWithID;
    public static final ASN1ObjectIdentifier dhBasedMac;

    /* renamed from: id_it */
    public static final ASN1ObjectIdentifier f18094id_it;
    public static final ASN1ObjectIdentifier id_it_caCerts;
    public static final ASN1ObjectIdentifier id_it_certProfile;
    public static final ASN1ObjectIdentifier id_it_certReqTemplate;
    public static final ASN1ObjectIdentifier id_it_crlStatusList;
    public static final ASN1ObjectIdentifier id_it_crls;
    public static final ASN1ObjectIdentifier id_it_rootCaCert;
    public static final ASN1ObjectIdentifier id_it_rootCaKeyUpdate;

    /* renamed from: id_pkip */
    public static final ASN1ObjectIdentifier f18095id_pkip;
    public static final ASN1ObjectIdentifier id_regCtrl;
    public static final ASN1ObjectIdentifier id_regCtrl_algId;
    public static final ASN1ObjectIdentifier id_regCtrl_rsaKeyLen;
    public static final ASN1ObjectIdentifier id_regInfo;
    public static final ASN1ObjectIdentifier it_caKeyUpdateInfo;
    public static final ASN1ObjectIdentifier it_caProtEncCert;
    public static final ASN1ObjectIdentifier it_confirmWaitTime;
    public static final ASN1ObjectIdentifier it_currentCRL;
    public static final ASN1ObjectIdentifier it_encKeyPairTypes;
    public static final ASN1ObjectIdentifier it_implicitConfirm;
    public static final ASN1ObjectIdentifier it_keyPairParamRep;
    public static final ASN1ObjectIdentifier it_keyPairParamReq;
    public static final ASN1ObjectIdentifier it_origPKIMessage;
    public static final ASN1ObjectIdentifier it_preferredSymAlg;
    public static final ASN1ObjectIdentifier it_revPassphrase;
    public static final ASN1ObjectIdentifier it_signKeyPairTypes;
    public static final ASN1ObjectIdentifier it_suppLangTags;
    public static final ASN1ObjectIdentifier it_unsupportedOIDs;
    public static final ASN1ObjectIdentifier kemBasedMac;
    public static final ASN1ObjectIdentifier passwordBasedMac = CRMFObjectIdentifiers.passwordBasedMac;
    public static final ASN1ObjectIdentifier regCtrl_altCertTemplate;
    public static final ASN1ObjectIdentifier regCtrl_authenticator;
    public static final ASN1ObjectIdentifier regCtrl_oldCertID;
    public static final ASN1ObjectIdentifier regCtrl_pkiArchiveOptions;
    public static final ASN1ObjectIdentifier regCtrl_pkiPublicationInfo;
    public static final ASN1ObjectIdentifier regCtrl_protocolEncrKey;
    public static final ASN1ObjectIdentifier regCtrl_regToken;
    public static final ASN1ObjectIdentifier regInfo_certReq;
    public static final ASN1ObjectIdentifier regInfo_utf8Pairs;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.f18417entrust;
        kemBasedMac = aSN1ObjectIdentifier.m14432branch("66.16");
        dhBasedMac = aSN1ObjectIdentifier.m14432branch("66.30");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = X509ObjectIdentifiers.f18746id_pkix.m14432branch("4");
        f18094id_it = aSN1ObjectIdentifierM14432branch;
        it_caProtEncCert = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        it_signKeyPairTypes = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        it_encKeyPairTypes = aSN1ObjectIdentifierM14432branch.m14432branch("3");
        it_preferredSymAlg = aSN1ObjectIdentifierM14432branch.m14432branch("4");
        it_caKeyUpdateInfo = aSN1ObjectIdentifierM14432branch.m14432branch("5");
        it_currentCRL = aSN1ObjectIdentifierM14432branch.m14432branch("6");
        it_unsupportedOIDs = aSN1ObjectIdentifierM14432branch.m14432branch("7");
        it_keyPairParamReq = aSN1ObjectIdentifierM14432branch.m14432branch("10");
        it_keyPairParamRep = aSN1ObjectIdentifierM14432branch.m14432branch("11");
        it_revPassphrase = aSN1ObjectIdentifierM14432branch.m14432branch("12");
        it_implicitConfirm = aSN1ObjectIdentifierM14432branch.m14432branch("13");
        it_confirmWaitTime = aSN1ObjectIdentifierM14432branch.m14432branch("14");
        it_origPKIMessage = aSN1ObjectIdentifierM14432branch.m14432branch("15");
        it_suppLangTags = aSN1ObjectIdentifierM14432branch.m14432branch("16");
        id_it_caCerts = aSN1ObjectIdentifierM14432branch.m14432branch("17");
        id_it_rootCaKeyUpdate = aSN1ObjectIdentifierM14432branch.m14432branch("18");
        id_it_certReqTemplate = aSN1ObjectIdentifierM14432branch.m14432branch("19");
        id_it_rootCaCert = aSN1ObjectIdentifierM14432branch.m14432branch("20");
        id_it_certProfile = aSN1ObjectIdentifierM14432branch.m14432branch("21");
        id_it_crlStatusList = aSN1ObjectIdentifierM14432branch.m14432branch("22");
        id_it_crls = aSN1ObjectIdentifierM14432branch.m14432branch("23");
        f18095id_pkip = CRMFObjectIdentifiers.f18244id_pkip;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CRMFObjectIdentifiers.id_regCtrl;
        id_regCtrl = aSN1ObjectIdentifier2;
        id_regInfo = CRMFObjectIdentifiers.id_regInfo;
        regCtrl_regToken = CRMFObjectIdentifiers.id_regCtrl_regToken;
        regCtrl_authenticator = CRMFObjectIdentifiers.id_regCtrl_authenticator;
        regCtrl_pkiPublicationInfo = CRMFObjectIdentifiers.id_regCtrl_pkiPublicationInfo;
        regCtrl_pkiArchiveOptions = CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions;
        regCtrl_oldCertID = CRMFObjectIdentifiers.id_regCtrl_oldCertID;
        regCtrl_protocolEncrKey = CRMFObjectIdentifiers.id_regCtrl_protocolEncrKey;
        regCtrl_altCertTemplate = aSN1ObjectIdentifier2.m14432branch("7");
        id_regCtrl_algId = aSN1ObjectIdentifier2.m14432branch("11");
        id_regCtrl_rsaKeyLen = aSN1ObjectIdentifier2.m14432branch("12");
        regInfo_utf8Pairs = CRMFObjectIdentifiers.id_regInfo_utf8Pairs;
        regInfo_certReq = CRMFObjectIdentifiers.id_regInfo_certReq;
        ct_encKeyWithID = CRMFObjectIdentifiers.id_ct_encKeyWithID;
    }
}
