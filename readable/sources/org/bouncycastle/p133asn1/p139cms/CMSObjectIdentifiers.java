package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;

/* loaded from: classes.dex */
public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256;

    /* renamed from: id_alg */
    public static final ASN1ObjectIdentifier f18180id_alg;
    public static final ASN1ObjectIdentifier id_alg_cek_hkdf_sha256;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;

    /* renamed from: id_ori */
    public static final ASN1ObjectIdentifier f18181id_ori;
    public static final ASN1ObjectIdentifier id_ori_kem;

    /* renamed from: id_ri */
    public static final ASN1ObjectIdentifier f18182id_ri;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response;
    public static final ASN1ObjectIdentifier id_ri_scvp;

    /* renamed from: data */
    public static final ASN1ObjectIdentifier f18179data = PKCSObjectIdentifiers.f18493data;
    public static final ASN1ObjectIdentifier signedData = PKCSObjectIdentifiers.signedData;
    public static final ASN1ObjectIdentifier envelopedData = PKCSObjectIdentifiers.envelopedData;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    public static final ASN1ObjectIdentifier digestedData = PKCSObjectIdentifiers.digestedData;
    public static final ASN1ObjectIdentifier encryptedData = PKCSObjectIdentifiers.encryptedData;
    public static final ASN1ObjectIdentifier authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    public static final ASN1ObjectIdentifier compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    public static final ASN1ObjectIdentifier authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    public static final ASN1ObjectIdentifier timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
    public static final ASN1ObjectIdentifier zlibCompress = PKCSObjectIdentifiers.id_alg_zlibCompress;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = X509ObjectIdentifiers.f18746id_pkix.m14432branch("16");
        f18182id_ri = aSN1ObjectIdentifierM14432branch;
        id_ri_ocsp_response = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_ri_scvp = aSN1ObjectIdentifierM14432branch.m14432branch("4");
        f18180id_alg = X509ObjectIdentifiers.pkix_algorithms;
        id_RSASSA_PSS_SHAKE128 = X509ObjectIdentifiers.id_rsassa_pss_shake128;
        id_RSASSA_PSS_SHAKE256 = X509ObjectIdentifiers.id_rsassa_pss_shake256;
        id_ecdsa_with_shake128 = X509ObjectIdentifiers.id_ecdsa_with_shake128;
        id_ecdsa_with_shake256 = X509ObjectIdentifiers.id_ecdsa_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = PKCSObjectIdentifiers.id_smime.m14432branch("13");
        f18181id_ori = aSN1ObjectIdentifierM14432branch2;
        id_ori_kem = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_alg_cek_hkdf_sha256 = PKCSObjectIdentifiers.smime_alg.m14432branch("31");
    }
}
