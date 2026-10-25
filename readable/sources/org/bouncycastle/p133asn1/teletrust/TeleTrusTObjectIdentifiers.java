package org.bouncycastle.p133asn1.teletrust;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1;
    public static final ASN1ObjectIdentifier brainpoolP160t1;
    public static final ASN1ObjectIdentifier brainpoolP192r1;
    public static final ASN1ObjectIdentifier brainpoolP192t1;
    public static final ASN1ObjectIdentifier brainpoolP224r1;
    public static final ASN1ObjectIdentifier brainpoolP224t1;
    public static final ASN1ObjectIdentifier brainpoolP256r1;
    public static final ASN1ObjectIdentifier brainpoolP256t1;
    public static final ASN1ObjectIdentifier brainpoolP320r1;
    public static final ASN1ObjectIdentifier brainpoolP320t1;
    public static final ASN1ObjectIdentifier brainpoolP384r1;
    public static final ASN1ObjectIdentifier brainpoolP384t1;
    public static final ASN1ObjectIdentifier brainpoolP512r1;
    public static final ASN1ObjectIdentifier brainpoolP512t1;

    /* renamed from: ecSign */
    public static final ASN1ObjectIdentifier f18545ecSign;
    public static final ASN1ObjectIdentifier ecSignWithRipemd160;
    public static final ASN1ObjectIdentifier ecSignWithSha1;
    public static final ASN1ObjectIdentifier ecc_brainpool;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier ripemd128;
    public static final ASN1ObjectIdentifier ripemd160;
    public static final ASN1ObjectIdentifier ripemd256;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd128;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd160;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd256;
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm;
    public static final ASN1ObjectIdentifier versionOne;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.3");
        teleTrusTAlgorithm = aSN1ObjectIdentifier;
        ripemd160 = aSN1ObjectIdentifier.m14432branch("2.1");
        ripemd128 = aSN1ObjectIdentifier.m14432branch("2.2");
        ripemd256 = aSN1ObjectIdentifier.m14432branch("2.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("3.1");
        teleTrusTRSAsignatureAlgorithm = aSN1ObjectIdentifierM14432branch;
        rsaSignatureWithripemd160 = aSN1ObjectIdentifierM14432branch.m14432branch("2");
        rsaSignatureWithripemd128 = aSN1ObjectIdentifierM14432branch.m14432branch("3");
        rsaSignatureWithripemd256 = aSN1ObjectIdentifierM14432branch.m14432branch("4");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch2 = aSN1ObjectIdentifier.m14432branch("3.2");
        f18545ecSign = aSN1ObjectIdentifierM14432branch2;
        ecSignWithSha1 = aSN1ObjectIdentifierM14432branch2.m14432branch("1");
        ecSignWithRipemd160 = aSN1ObjectIdentifierM14432branch2.m14432branch("2");
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch3 = aSN1ObjectIdentifier.m14432branch("3.2.8");
        ecc_brainpool = aSN1ObjectIdentifierM14432branch3;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch4 = aSN1ObjectIdentifierM14432branch3.m14432branch("1");
        ellipticCurve = aSN1ObjectIdentifierM14432branch4;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch5 = aSN1ObjectIdentifierM14432branch4.m14432branch("1");
        versionOne = aSN1ObjectIdentifierM14432branch5;
        brainpoolP160r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("1");
        brainpoolP160t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("2");
        brainpoolP192r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("3");
        brainpoolP192t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("4");
        brainpoolP224r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("5");
        brainpoolP224t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("6");
        brainpoolP256r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("7");
        brainpoolP256t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("8");
        brainpoolP320r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("9");
        brainpoolP320t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("10");
        brainpoolP384r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("11");
        brainpoolP384t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("12");
        brainpoolP512r1 = aSN1ObjectIdentifierM14432branch5.m14432branch("13");
        brainpoolP512t1 = aSN1ObjectIdentifierM14432branch5.m14432branch("14");
    }
}
