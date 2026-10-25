package org.bouncycastle.internal.p231asn1.p232bsi;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm;

    /* renamed from: bsi_de */
    public static final ASN1ObjectIdentifier f21233bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_224;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_256;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_384;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_512;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;

    /* renamed from: ecka_eg */
    public static final ASN1ObjectIdentifier f21234ecka_eg;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512;

    /* renamed from: id_ecc */
    public static final ASN1ObjectIdentifier f21235id_ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        f21233bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1.1");
        f21235id_ecc = aSN1ObjectIdentifierM14432branch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("4.1");
        ecdsa_plain_signatures = aSN1ObjectIdentifierM14432branch2;
        ecdsa_plain_SHA1 = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        ecdsa_plain_SHA224 = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        ecdsa_plain_SHA256 = aSN1ObjectIdentifierM14432branch2.m14432branch("3");
        ecdsa_plain_SHA384 = aSN1ObjectIdentifierM14432branch2.m14432branch("4");
        ecdsa_plain_SHA512 = aSN1ObjectIdentifierM14432branch2.m14432branch("5");
        ecdsa_plain_RIPEMD160 = aSN1ObjectIdentifierM14432branch2.m14432branch("6");
        ecdsa_plain_SHA3_224 = aSN1ObjectIdentifierM14432branch2.m14432branch("8");
        ecdsa_plain_SHA3_256 = aSN1ObjectIdentifierM14432branch2.m14432branch("9");
        ecdsa_plain_SHA3_384 = aSN1ObjectIdentifierM14432branch2.m14432branch("10");
        ecdsa_plain_SHA3_512 = aSN1ObjectIdentifierM14432branch2.m14432branch("11");
        algorithm = aSN1ObjectIdentifier.m14432branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14432branch.m14432branch("5.1");
        f21234ecka_eg = aSN1ObjectIdentifierM14432branch3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch4 = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
        ecka_eg_X963kdf = aSN1ObjectIdentifierM14432branch4;
        ecka_eg_X963kdf_SHA1 = aSN1ObjectIdentifierM14432branch4.m14432branch("1");
        ecka_eg_X963kdf_SHA224 = aSN1ObjectIdentifierM14432branch4.m14432branch("2");
        ecka_eg_X963kdf_SHA256 = aSN1ObjectIdentifierM14432branch4.m14432branch("3");
        ecka_eg_X963kdf_SHA384 = aSN1ObjectIdentifierM14432branch4.m14432branch("4");
        ecka_eg_X963kdf_SHA512 = aSN1ObjectIdentifierM14432branch4.m14432branch("5");
        ecka_eg_X963kdf_RIPEMD160 = aSN1ObjectIdentifierM14432branch4.m14432branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch5 = aSN1ObjectIdentifierM14432branch3.m14432branch("2");
        ecka_eg_SessionKDF = aSN1ObjectIdentifierM14432branch5;
        ecka_eg_SessionKDF_3DES = aSN1ObjectIdentifierM14432branch5.m14432branch("1");
        ecka_eg_SessionKDF_AES128 = aSN1ObjectIdentifierM14432branch5.m14432branch("2");
        ecka_eg_SessionKDF_AES192 = aSN1ObjectIdentifierM14432branch5.m14432branch("3");
        ecka_eg_SessionKDF_AES256 = aSN1ObjectIdentifierM14432branch5.m14432branch("4");
    }
}
