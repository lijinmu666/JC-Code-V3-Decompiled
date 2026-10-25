package org.bouncycastle.p133asn1.p170ua;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface UAObjectIdentifiers {

    /* renamed from: UaOid */
    public static final ASN1ObjectIdentifier f18576UaOid;

    /* renamed from: alg_id */
    public static final ASN1ObjectIdentifier f18577alg_id;
    public static final ASN1ObjectIdentifier dstu4145be;
    public static final ASN1ObjectIdentifier dstu4145le;
    public static final ASN1ObjectIdentifier dstu7564digest_256;
    public static final ASN1ObjectIdentifier dstu7564digest_384;
    public static final ASN1ObjectIdentifier dstu7564digest_512;
    public static final ASN1ObjectIdentifier dstu7564mac_256;
    public static final ASN1ObjectIdentifier dstu7564mac_384;
    public static final ASN1ObjectIdentifier dstu7564mac_512;
    public static final ASN1ObjectIdentifier dstu7624cbc_128;
    public static final ASN1ObjectIdentifier dstu7624cbc_256;
    public static final ASN1ObjectIdentifier dstu7624cbc_512;
    public static final ASN1ObjectIdentifier dstu7624ccm_128;
    public static final ASN1ObjectIdentifier dstu7624ccm_256;
    public static final ASN1ObjectIdentifier dstu7624ccm_512;
    public static final ASN1ObjectIdentifier dstu7624cfb_128;
    public static final ASN1ObjectIdentifier dstu7624cfb_256;
    public static final ASN1ObjectIdentifier dstu7624cfb_512;
    public static final ASN1ObjectIdentifier dstu7624cmac_128;
    public static final ASN1ObjectIdentifier dstu7624cmac_256;
    public static final ASN1ObjectIdentifier dstu7624cmac_512;
    public static final ASN1ObjectIdentifier dstu7624ctr_128;
    public static final ASN1ObjectIdentifier dstu7624ctr_256;
    public static final ASN1ObjectIdentifier dstu7624ctr_512;
    public static final ASN1ObjectIdentifier dstu7624ecb_128;
    public static final ASN1ObjectIdentifier dstu7624ecb_256;
    public static final ASN1ObjectIdentifier dstu7624ecb_512;
    public static final ASN1ObjectIdentifier dstu7624gmac_128;
    public static final ASN1ObjectIdentifier dstu7624gmac_256;
    public static final ASN1ObjectIdentifier dstu7624gmac_512;
    public static final ASN1ObjectIdentifier dstu7624kw_128;
    public static final ASN1ObjectIdentifier dstu7624kw_256;
    public static final ASN1ObjectIdentifier dstu7624kw_512;
    public static final ASN1ObjectIdentifier dstu7624ofb_128;
    public static final ASN1ObjectIdentifier dstu7624ofb_256;
    public static final ASN1ObjectIdentifier dstu7624ofb_512;
    public static final ASN1ObjectIdentifier dstu7624xts_128;
    public static final ASN1ObjectIdentifier dstu7624xts_256;
    public static final ASN1ObjectIdentifier dstu7624xts_512;
    public static final ASN1ObjectIdentifier gost3411_id;

    /* renamed from: hash_id */
    public static final ASN1ObjectIdentifier f18578hash_id;
    public static final ASN1ObjectIdentifier hmac_gost3411_id;

    /* renamed from: sym_id */
    public static final ASN1ObjectIdentifier f18579sym_id;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.804.2.1.1.1");
        f18576UaOid = aSN1ObjectIdentifier;
        dstu4145le = aSN1ObjectIdentifier.m14432branch("1.3.1.1");
        dstu4145be = aSN1ObjectIdentifier.m14432branch("1.3.1.1.1.1");
        dstu7564digest_256 = aSN1ObjectIdentifier.m14432branch("1.2.2.1");
        dstu7564digest_384 = aSN1ObjectIdentifier.m14432branch("1.2.2.2");
        dstu7564digest_512 = aSN1ObjectIdentifier.m14432branch("1.2.2.3");
        dstu7564mac_256 = aSN1ObjectIdentifier.m14432branch("1.2.2.4");
        dstu7564mac_384 = aSN1ObjectIdentifier.m14432branch("1.2.2.5");
        dstu7564mac_512 = aSN1ObjectIdentifier.m14432branch("1.2.2.6");
        dstu7624ecb_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.1.1");
        dstu7624ecb_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.1.2");
        dstu7624ecb_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.1.3");
        dstu7624ctr_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.2.1");
        dstu7624ctr_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.2.2");
        dstu7624ctr_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.2.3");
        dstu7624cfb_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.3.1");
        dstu7624cfb_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.3.2");
        dstu7624cfb_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.3.3");
        dstu7624cmac_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.4.1");
        dstu7624cmac_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.4.2");
        dstu7624cmac_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.4.3");
        dstu7624cbc_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.5.1");
        dstu7624cbc_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.5.2");
        dstu7624cbc_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.5.3");
        dstu7624ofb_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.6.1");
        dstu7624ofb_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.6.2");
        dstu7624ofb_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.6.3");
        dstu7624gmac_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.7.1");
        dstu7624gmac_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.7.2");
        dstu7624gmac_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.7.3");
        dstu7624ccm_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.8.1");
        dstu7624ccm_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.8.2");
        dstu7624ccm_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.8.3");
        dstu7624xts_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.9.1");
        dstu7624xts_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.9.2");
        dstu7624xts_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.9.3");
        dstu7624kw_128 = aSN1ObjectIdentifier.m14432branch("1.1.3.10.1");
        dstu7624kw_256 = aSN1ObjectIdentifier.m14432branch("1.1.3.10.2");
        dstu7624kw_512 = aSN1ObjectIdentifier.m14432branch("1.1.3.10.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1");
        f18577alg_id = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        f18579sym_id = aSN1ObjectIdentifierM14432branch2;
        hmac_gost3411_id = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        f18578hash_id = aSN1ObjectIdentifierM14432branch3;
        gost3411_id = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
    }
}
