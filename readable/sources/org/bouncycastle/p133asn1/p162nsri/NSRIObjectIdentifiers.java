package org.bouncycastle.p133asn1.p162nsri;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface NSRIObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_algorithm;
    public static final ASN1ObjectIdentifier id_aria128_cbc;
    public static final ASN1ObjectIdentifier id_aria128_ccm;
    public static final ASN1ObjectIdentifier id_aria128_cfb;
    public static final ASN1ObjectIdentifier id_aria128_cmac;
    public static final ASN1ObjectIdentifier id_aria128_ctr;
    public static final ASN1ObjectIdentifier id_aria128_ecb;
    public static final ASN1ObjectIdentifier id_aria128_gcm;
    public static final ASN1ObjectIdentifier id_aria128_kw;
    public static final ASN1ObjectIdentifier id_aria128_kwp;
    public static final ASN1ObjectIdentifier id_aria128_ocb2;
    public static final ASN1ObjectIdentifier id_aria128_ofb;
    public static final ASN1ObjectIdentifier id_aria192_cbc;
    public static final ASN1ObjectIdentifier id_aria192_ccm;
    public static final ASN1ObjectIdentifier id_aria192_cfb;
    public static final ASN1ObjectIdentifier id_aria192_cmac;
    public static final ASN1ObjectIdentifier id_aria192_ctr;
    public static final ASN1ObjectIdentifier id_aria192_ecb;
    public static final ASN1ObjectIdentifier id_aria192_gcm;
    public static final ASN1ObjectIdentifier id_aria192_kw;
    public static final ASN1ObjectIdentifier id_aria192_kwp;
    public static final ASN1ObjectIdentifier id_aria192_ocb2;
    public static final ASN1ObjectIdentifier id_aria192_ofb;
    public static final ASN1ObjectIdentifier id_aria256_cbc;
    public static final ASN1ObjectIdentifier id_aria256_ccm;
    public static final ASN1ObjectIdentifier id_aria256_cfb;
    public static final ASN1ObjectIdentifier id_aria256_cmac;
    public static final ASN1ObjectIdentifier id_aria256_ctr;
    public static final ASN1ObjectIdentifier id_aria256_ecb;
    public static final ASN1ObjectIdentifier id_aria256_gcm;
    public static final ASN1ObjectIdentifier id_aria256_kw;
    public static final ASN1ObjectIdentifier id_aria256_kwp;
    public static final ASN1ObjectIdentifier id_aria256_ocb2;
    public static final ASN1ObjectIdentifier id_aria256_ofb;

    /* renamed from: id_pad */
    public static final ASN1ObjectIdentifier f18432id_pad;
    public static final ASN1ObjectIdentifier id_pad_1;
    public static final ASN1ObjectIdentifier id_pad_null;

    /* renamed from: id_sea */
    public static final ASN1ObjectIdentifier f18433id_sea;

    /* renamed from: nsri */
    public static final ASN1ObjectIdentifier f18434nsri;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.410.200046");
        f18434nsri = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1");
        id_algorithm = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        f18433id_sea = aSN1ObjectIdentifierM14432branch2;
        f18432id_pad = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        id_pad_null = aSN1ObjectIdentifierM14432branch.m14432branch("0");
        id_pad_1 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        id_aria128_ecb = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        id_aria128_cbc = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        id_aria128_cfb = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        id_aria128_ofb = aSN1ObjectIdentifierM14432branch2.m14432branch("4");
        id_aria128_ctr = aSN1ObjectIdentifierM14432branch2.m14432branch("5");
        id_aria192_ecb = aSN1ObjectIdentifierM14432branch2.m14432branch("6");
        id_aria192_cbc = aSN1ObjectIdentifierM14432branch2.m14432branch("7");
        id_aria192_cfb = aSN1ObjectIdentifierM14432branch2.m14432branch("8");
        id_aria192_ofb = aSN1ObjectIdentifierM14432branch2.m14432branch("9");
        id_aria192_ctr = aSN1ObjectIdentifierM14432branch2.m14432branch("10");
        id_aria256_ecb = aSN1ObjectIdentifierM14432branch2.m14432branch("11");
        id_aria256_cbc = aSN1ObjectIdentifierM14432branch2.m14432branch("12");
        id_aria256_cfb = aSN1ObjectIdentifierM14432branch2.m14432branch("13");
        id_aria256_ofb = aSN1ObjectIdentifierM14432branch2.m14432branch("14");
        id_aria256_ctr = aSN1ObjectIdentifierM14432branch2.m14432branch("15");
        id_aria128_cmac = aSN1ObjectIdentifierM14432branch2.m14432branch("21");
        id_aria192_cmac = aSN1ObjectIdentifierM14432branch2.m14432branch("22");
        id_aria256_cmac = aSN1ObjectIdentifierM14432branch2.m14432branch("23");
        id_aria128_ocb2 = aSN1ObjectIdentifierM14432branch2.m14432branch("31");
        id_aria192_ocb2 = aSN1ObjectIdentifierM14432branch2.m14432branch("32");
        id_aria256_ocb2 = aSN1ObjectIdentifierM14432branch2.m14432branch("33");
        id_aria128_gcm = aSN1ObjectIdentifierM14432branch2.m14432branch("34");
        id_aria192_gcm = aSN1ObjectIdentifierM14432branch2.m14432branch("35");
        id_aria256_gcm = aSN1ObjectIdentifierM14432branch2.m14432branch("36");
        id_aria128_ccm = aSN1ObjectIdentifierM14432branch2.m14432branch("37");
        id_aria192_ccm = aSN1ObjectIdentifierM14432branch2.m14432branch("38");
        id_aria256_ccm = aSN1ObjectIdentifierM14432branch2.m14432branch("39");
        id_aria128_kw = aSN1ObjectIdentifierM14432branch2.m14432branch("40");
        id_aria192_kw = aSN1ObjectIdentifierM14432branch2.m14432branch("41");
        id_aria256_kw = aSN1ObjectIdentifierM14432branch2.m14432branch("42");
        id_aria128_kwp = aSN1ObjectIdentifierM14432branch2.m14432branch("43");
        id_aria192_kwp = aSN1ObjectIdentifierM14432branch2.m14432branch("44");
        id_aria256_kwp = aSN1ObjectIdentifierM14432branch2.m14432branch("45");
    }
}
