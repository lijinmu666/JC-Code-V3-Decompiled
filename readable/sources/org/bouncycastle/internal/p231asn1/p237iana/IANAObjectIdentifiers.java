package org.bouncycastle.internal.p231asn1.p237iana;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface IANAObjectIdentifiers {

    /* renamed from: SNMPv2 */
    public static final ASN1ObjectIdentifier f21255SNMPv2;
    public static final ASN1ObjectIdentifier _private;
    public static final ASN1ObjectIdentifier directory;
    public static final ASN1ObjectIdentifier experimental;

    /* renamed from: hmacMD5 */
    public static final ASN1ObjectIdentifier f21256hmacMD5;
    public static final ASN1ObjectIdentifier hmacRIPEMD160;
    public static final ASN1ObjectIdentifier hmacSHA1;
    public static final ASN1ObjectIdentifier hmacTIGER;
    public static final ASN1ObjectIdentifier id_MLDSA44_ECDSA_P256_SHA256;
    public static final ASN1ObjectIdentifier id_MLDSA44_Ed25519_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA44_RSA2048_PKCS15_SHA256;
    public static final ASN1ObjectIdentifier id_MLDSA44_RSA2048_PSS_SHA256;
    public static final ASN1ObjectIdentifier id_MLDSA65_ECDSA_P256_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_ECDSA_P384_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_ECDSA_brainpoolP256r1_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_Ed25519_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_RSA3072_PKCS15_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_RSA3072_PSS_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_RSA4096_PKCS15_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA65_RSA4096_PSS_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA87_ECDSA_P384_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA87_ECDSA_P521_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA87_ECDSA_brainpoolP384r1_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA87_Ed448_SHAKE256;
    public static final ASN1ObjectIdentifier id_MLDSA87_RSA3072_PSS_SHA512;
    public static final ASN1ObjectIdentifier id_MLDSA87_RSA4096_PSS_SHA512;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256;

    /* renamed from: id_alg */
    public static final ASN1ObjectIdentifier f21257id_alg;
    public static final ASN1ObjectIdentifier id_alg_unsigned;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256;
    public static final ASN1ObjectIdentifier internet;

    /* renamed from: ipsec */
    public static final ASN1ObjectIdentifier f21258ipsec;
    public static final ASN1ObjectIdentifier isakmpOakley;

    /* renamed from: mail */
    public static final ASN1ObjectIdentifier f21259mail;

    /* renamed from: mgmt */
    public static final ASN1ObjectIdentifier f21260mgmt;

    /* renamed from: pkix */
    public static final ASN1ObjectIdentifier f21261pkix;
    public static final ASN1ObjectIdentifier security;
    public static final ASN1ObjectIdentifier security_mechanisms;
    public static final ASN1ObjectIdentifier security_nametypes;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1");
        internet = aSN1ObjectIdentifier;
        directory = aSN1ObjectIdentifier.m14432branch("1");
        f21260mgmt = aSN1ObjectIdentifier.m14432branch("2");
        experimental = aSN1ObjectIdentifier.m14432branch("3");
        _private = aSN1ObjectIdentifier.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("5");
        security = aSN1ObjectIdentifierM14432branch;
        f21255SNMPv2 = aSN1ObjectIdentifier.m14432branch("6");
        f21259mail = aSN1ObjectIdentifier.m14432branch("7");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifierM14432branch.m14432branch("5");
        security_mechanisms = aSN1ObjectIdentifierM14432branch2;
        security_nametypes = aSN1ObjectIdentifierM14432branch.m14432branch("6");
        f21261pkix = aSN1ObjectIdentifierM14432branch2.m14432branch("7");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifierM14432branch2.m14432branch("8");
        f21258ipsec = aSN1ObjectIdentifierM14432branch3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch4 = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
        isakmpOakley = aSN1ObjectIdentifierM14432branch4;
        f21256hmacMD5 = aSN1ObjectIdentifierM14432branch4.m14432branch("1");
        hmacSHA1 = aSN1ObjectIdentifierM14432branch4.m14432branch("2");
        hmacTIGER = aSN1ObjectIdentifierM14432branch4.m14432branch("3");
        hmacRIPEMD160 = aSN1ObjectIdentifierM14432branch4.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch5 = aSN1ObjectIdentifier.m14432branch("5.5.7.6");
        f21257id_alg = aSN1ObjectIdentifierM14432branch5;
        id_RSASSA_PSS_SHAKE128 = aSN1ObjectIdentifierM14432branch5.m14432branch("30");
        id_RSASSA_PSS_SHAKE256 = aSN1ObjectIdentifierM14432branch5.m14432branch("31");
        id_ecdsa_with_shake128 = aSN1ObjectIdentifierM14432branch5.m14432branch("32");
        id_ecdsa_with_shake256 = aSN1ObjectIdentifierM14432branch5.m14432branch("33");
        id_alg_unsigned = aSN1ObjectIdentifierM14432branch5.m14432branch("36");
        id_MLDSA44_RSA2048_PSS_SHA256 = aSN1ObjectIdentifierM14432branch5.m14432branch("37");
        id_MLDSA44_RSA2048_PKCS15_SHA256 = aSN1ObjectIdentifierM14432branch5.m14432branch("38");
        id_MLDSA44_Ed25519_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("39");
        id_MLDSA44_ECDSA_P256_SHA256 = aSN1ObjectIdentifierM14432branch5.m14432branch("40");
        id_MLDSA65_RSA3072_PSS_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("41");
        id_MLDSA65_RSA3072_PKCS15_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("42");
        id_MLDSA65_RSA4096_PSS_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("43");
        id_MLDSA65_RSA4096_PKCS15_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("44");
        id_MLDSA65_ECDSA_P256_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("45");
        id_MLDSA65_ECDSA_P384_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("46");
        id_MLDSA65_ECDSA_brainpoolP256r1_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("47");
        id_MLDSA65_Ed25519_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("48");
        id_MLDSA87_ECDSA_P384_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("49");
        id_MLDSA87_ECDSA_brainpoolP384r1_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("50");
        id_MLDSA87_Ed448_SHAKE256 = aSN1ObjectIdentifierM14432branch5.m14432branch("51");
        id_MLDSA87_RSA3072_PSS_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("52");
        id_MLDSA87_RSA4096_PSS_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("53");
        id_MLDSA87_ECDSA_P521_SHA512 = aSN1ObjectIdentifierM14432branch5.m14432branch("54");
    }
}
