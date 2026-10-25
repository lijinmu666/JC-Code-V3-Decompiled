package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes2.dex */
public interface CRMFObjectIdentifiers {

    /* renamed from: id_alg */
    public static final ASN1ObjectIdentifier f18243id_alg;
    public static final ASN1ObjectIdentifier id_alg_dh_pop;
    public static final ASN1ObjectIdentifier id_ct_encKeyWithID;
    public static final ASN1ObjectIdentifier id_dh_sig_hmac_sha1;

    /* renamed from: id_pkip */
    public static final ASN1ObjectIdentifier f18244id_pkip;

    /* renamed from: id_pkix */
    public static final ASN1ObjectIdentifier f18245id_pkix;
    public static final ASN1ObjectIdentifier id_regCtrl;
    public static final ASN1ObjectIdentifier id_regCtrl_authenticator;
    public static final ASN1ObjectIdentifier id_regCtrl_oldCertID;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiArchiveOptions;
    public static final ASN1ObjectIdentifier id_regCtrl_pkiPublicationInfo;
    public static final ASN1ObjectIdentifier id_regCtrl_protocolEncrKey;
    public static final ASN1ObjectIdentifier id_regCtrl_regToken;
    public static final ASN1ObjectIdentifier id_regInfo;
    public static final ASN1ObjectIdentifier id_regInfo_certReq;
    public static final ASN1ObjectIdentifier id_regInfo_utf8Pairs;
    public static final ASN1ObjectIdentifier passwordBasedMac = MiscObjectIdentifiers.f18417entrust.m14432branch("66.13");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.f18746id_pkix;
        f18245id_pkix = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("5");
        f18244id_pkip = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_regCtrl = aSN1ObjectIdentifierM14432branch2;
        id_regCtrl_regToken = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        id_regCtrl_authenticator = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        id_regCtrl_pkiPublicationInfo = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_regCtrl_pkiArchiveOptions = aSN1ObjectIdentifierM14432branch2.m14432branch("4");
        id_regCtrl_oldCertID = aSN1ObjectIdentifierM14432branch2.m14432branch("5");
        id_regCtrl_protocolEncrKey = aSN1ObjectIdentifierM14432branch2.m14432branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_regInfo = aSN1ObjectIdentifierM14432branch3;
        id_regInfo_utf8Pairs = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
        id_regInfo_certReq = aSN1ObjectIdentifierM14432branch3.m14432branch("2");
        id_ct_encKeyWithID = PKCSObjectIdentifiers.f18496id_ct.m14432branch("21");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X509ObjectIdentifiers.pkix_algorithms;
        f18243id_alg = aSN1ObjectIdentifier2;
        id_dh_sig_hmac_sha1 = aSN1ObjectIdentifier2.m14432branch("3");
        id_alg_dh_pop = aSN1ObjectIdentifier2.m14432branch("4");
    }
}
