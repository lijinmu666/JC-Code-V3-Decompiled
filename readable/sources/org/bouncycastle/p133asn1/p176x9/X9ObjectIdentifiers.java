package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface X9ObjectIdentifiers {
    public static final ASN1ObjectIdentifier ansi_X9_42;
    public static final ASN1ObjectIdentifier ansi_X9_62;
    public static final ASN1ObjectIdentifier c2onb191v4;
    public static final ASN1ObjectIdentifier c2onb191v5;
    public static final ASN1ObjectIdentifier c2onb239v4;
    public static final ASN1ObjectIdentifier c2onb239v5;
    public static final ASN1ObjectIdentifier c2pnb163v1;
    public static final ASN1ObjectIdentifier c2pnb163v2;
    public static final ASN1ObjectIdentifier c2pnb163v3;
    public static final ASN1ObjectIdentifier c2pnb176w1;
    public static final ASN1ObjectIdentifier c2pnb208w1;
    public static final ASN1ObjectIdentifier c2pnb272w1;
    public static final ASN1ObjectIdentifier c2pnb304w1;
    public static final ASN1ObjectIdentifier c2pnb368w1;
    public static final ASN1ObjectIdentifier c2tnb191v1;
    public static final ASN1ObjectIdentifier c2tnb191v2;
    public static final ASN1ObjectIdentifier c2tnb191v3;
    public static final ASN1ObjectIdentifier c2tnb239v1;
    public static final ASN1ObjectIdentifier c2tnb239v2;
    public static final ASN1ObjectIdentifier c2tnb239v3;
    public static final ASN1ObjectIdentifier c2tnb359v1;
    public static final ASN1ObjectIdentifier c2tnb431r1;
    public static final ASN1ObjectIdentifier cTwoCurve;
    public static final ASN1ObjectIdentifier characteristic_two_field;

    /* renamed from: dhEphem */
    public static final ASN1ObjectIdentifier f18787dhEphem;
    public static final ASN1ObjectIdentifier dhHybrid1;
    public static final ASN1ObjectIdentifier dhHybrid2;
    public static final ASN1ObjectIdentifier dhHybridOneFlow;
    public static final ASN1ObjectIdentifier dhOneFlow;
    public static final ASN1ObjectIdentifier dhSinglePass_cofactorDH_sha1kdf_scheme;
    public static final ASN1ObjectIdentifier dhSinglePass_stdDH_sha1kdf_scheme;
    public static final ASN1ObjectIdentifier dhStatic;
    public static final ASN1ObjectIdentifier dhpublicnumber;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA2;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA224;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA256;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA384;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA512;
    public static final ASN1ObjectIdentifier ellipticCurve;

    /* renamed from: gnBasis */
    public static final ASN1ObjectIdentifier f18788gnBasis;

    /* renamed from: id_dsa */
    public static final ASN1ObjectIdentifier f18789id_dsa;
    public static final ASN1ObjectIdentifier id_dsa_with_sha1;
    public static final ASN1ObjectIdentifier id_ecPublicKey;
    public static final ASN1ObjectIdentifier id_ecSigType;
    public static final ASN1ObjectIdentifier id_fieldType;
    public static final ASN1ObjectIdentifier id_kdf_kdf2;
    public static final ASN1ObjectIdentifier id_kdf_kdf3;
    public static final ASN1ObjectIdentifier id_publicKeyType;

    /* renamed from: mqv1 */
    public static final ASN1ObjectIdentifier f18790mqv1;

    /* renamed from: mqv2 */
    public static final ASN1ObjectIdentifier f18791mqv2;
    public static final ASN1ObjectIdentifier mqvSinglePass_sha1kdf_scheme;

    /* renamed from: ppBasis */
    public static final ASN1ObjectIdentifier f18792ppBasis;
    public static final ASN1ObjectIdentifier prime192v1;
    public static final ASN1ObjectIdentifier prime192v2;
    public static final ASN1ObjectIdentifier prime192v3;
    public static final ASN1ObjectIdentifier prime239v1;
    public static final ASN1ObjectIdentifier prime239v2;
    public static final ASN1ObjectIdentifier prime239v3;
    public static final ASN1ObjectIdentifier prime256v1;
    public static final ASN1ObjectIdentifier primeCurve;
    public static final ASN1ObjectIdentifier prime_field;

    /* renamed from: tpBasis */
    public static final ASN1ObjectIdentifier f18793tpBasis;
    public static final ASN1ObjectIdentifier x9_42_schemes;

    /* renamed from: x9_44 */
    public static final ASN1ObjectIdentifier f18794x9_44;
    public static final ASN1ObjectIdentifier x9_44_components;
    public static final ASN1ObjectIdentifier x9_63_scheme;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.10045");
        ansi_X9_62 = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1");
        id_fieldType = aSN1ObjectIdentifierM14432branch;
        prime_field = aSN1ObjectIdentifierM14432branch.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        characteristic_two_field = aSN1ObjectIdentifierM14432branch2;
        f18788gnBasis = aSN1ObjectIdentifierM14432branch2.m14432branch("3.1");
        f18793tpBasis = aSN1ObjectIdentifierM14432branch2.m14432branch("3.2");
        f18792ppBasis = aSN1ObjectIdentifierM14432branch2.m14432branch("3.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifier.m14432branch("4");
        id_ecSigType = aSN1ObjectIdentifierM14432branch3;
        ecdsa_with_SHA1 = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch4 = aSN1ObjectIdentifier.m14432branch("2");
        id_publicKeyType = aSN1ObjectIdentifierM14432branch4;
        id_ecPublicKey = aSN1ObjectIdentifierM14432branch4.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch5 = aSN1ObjectIdentifierM14432branch3.m14432branch("3");
        ecdsa_with_SHA2 = aSN1ObjectIdentifierM14432branch5;
        ecdsa_with_SHA224 = aSN1ObjectIdentifierM14432branch5.m14432branch("1");
        ecdsa_with_SHA256 = aSN1ObjectIdentifierM14432branch5.m14432branch("2");
        ecdsa_with_SHA384 = aSN1ObjectIdentifierM14432branch5.m14432branch("3");
        ecdsa_with_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch6 = aSN1ObjectIdentifier.m14432branch("3");
        ellipticCurve = aSN1ObjectIdentifierM14432branch6;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch7 = aSN1ObjectIdentifierM14432branch6.m14432branch("0");
        cTwoCurve = aSN1ObjectIdentifierM14432branch7;
        c2pnb163v1 = aSN1ObjectIdentifierM14432branch7.m14432branch("1");
        c2pnb163v2 = aSN1ObjectIdentifierM14432branch7.m14432branch("2");
        c2pnb163v3 = aSN1ObjectIdentifierM14432branch7.m14432branch("3");
        c2pnb176w1 = aSN1ObjectIdentifierM14432branch7.m14432branch("4");
        c2tnb191v1 = aSN1ObjectIdentifierM14432branch7.m14432branch("5");
        c2tnb191v2 = aSN1ObjectIdentifierM14432branch7.m14432branch("6");
        c2tnb191v3 = aSN1ObjectIdentifierM14432branch7.m14432branch("7");
        c2onb191v4 = aSN1ObjectIdentifierM14432branch7.m14432branch("8");
        c2onb191v5 = aSN1ObjectIdentifierM14432branch7.m14432branch("9");
        c2pnb208w1 = aSN1ObjectIdentifierM14432branch7.m14432branch("10");
        c2tnb239v1 = aSN1ObjectIdentifierM14432branch7.m14432branch("11");
        c2tnb239v2 = aSN1ObjectIdentifierM14432branch7.m14432branch("12");
        c2tnb239v3 = aSN1ObjectIdentifierM14432branch7.m14432branch("13");
        c2onb239v4 = aSN1ObjectIdentifierM14432branch7.m14432branch("14");
        c2onb239v5 = aSN1ObjectIdentifierM14432branch7.m14432branch("15");
        c2pnb272w1 = aSN1ObjectIdentifierM14432branch7.m14432branch("16");
        c2pnb304w1 = aSN1ObjectIdentifierM14432branch7.m14432branch("17");
        c2tnb359v1 = aSN1ObjectIdentifierM14432branch7.m14432branch("18");
        c2pnb368w1 = aSN1ObjectIdentifierM14432branch7.m14432branch("19");
        c2tnb431r1 = aSN1ObjectIdentifierM14432branch7.m14432branch("20");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch8 = aSN1ObjectIdentifierM14432branch6.m14432branch("1");
        primeCurve = aSN1ObjectIdentifierM14432branch8;
        prime192v1 = aSN1ObjectIdentifierM14432branch8.m14432branch("1");
        prime192v2 = aSN1ObjectIdentifierM14432branch8.m14432branch("2");
        prime192v3 = aSN1ObjectIdentifierM14432branch8.m14432branch("3");
        prime239v1 = aSN1ObjectIdentifierM14432branch8.m14432branch("4");
        prime239v2 = aSN1ObjectIdentifierM14432branch8.m14432branch("5");
        prime239v3 = aSN1ObjectIdentifierM14432branch8.m14432branch("6");
        prime256v1 = aSN1ObjectIdentifierM14432branch8.m14432branch("7");
        f18789id_dsa = new ASN1ObjectIdentifier("1.2.840.10040.4.1");
        id_dsa_with_sha1 = new ASN1ObjectIdentifier("1.2.840.10040.4.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.3.133.16.840.63.0");
        x9_63_scheme = aSN1ObjectIdentifier2;
        dhSinglePass_stdDH_sha1kdf_scheme = aSN1ObjectIdentifier2.m14432branch("2");
        dhSinglePass_cofactorDH_sha1kdf_scheme = aSN1ObjectIdentifier2.m14432branch("3");
        mqvSinglePass_sha1kdf_scheme = aSN1ObjectIdentifier2.m14432branch("16");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.10046");
        ansi_X9_42 = aSN1ObjectIdentifier3;
        dhpublicnumber = aSN1ObjectIdentifier3.m14432branch("2.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch9 = aSN1ObjectIdentifier3.m14432branch("3");
        x9_42_schemes = aSN1ObjectIdentifierM14432branch9;
        dhStatic = aSN1ObjectIdentifierM14432branch9.m14432branch("1");
        f18787dhEphem = aSN1ObjectIdentifierM14432branch9.m14432branch("2");
        dhOneFlow = aSN1ObjectIdentifierM14432branch9.m14432branch("3");
        dhHybrid1 = aSN1ObjectIdentifierM14432branch9.m14432branch("4");
        dhHybrid2 = aSN1ObjectIdentifierM14432branch9.m14432branch("5");
        dhHybridOneFlow = aSN1ObjectIdentifierM14432branch9.m14432branch("6");
        f18791mqv2 = aSN1ObjectIdentifierM14432branch9.m14432branch("7");
        f18790mqv1 = aSN1ObjectIdentifierM14432branch9.m14432branch("8");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("1.3.133.16.840.9.44");
        f18794x9_44 = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch10 = aSN1ObjectIdentifier4.m14432branch("1");
        x9_44_components = aSN1ObjectIdentifierM14432branch10;
        id_kdf_kdf2 = aSN1ObjectIdentifierM14432branch10.m14432branch("1");
        id_kdf_kdf3 = aSN1ObjectIdentifierM14432branch10.m14432branch("2");
    }
}
