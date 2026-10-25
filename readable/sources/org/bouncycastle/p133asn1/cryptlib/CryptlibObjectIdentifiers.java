package org.bouncycastle.p133asn1.cryptlib;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public class CryptlibObjectIdentifiers {
    public static final ASN1ObjectIdentifier cryptlib;
    public static final ASN1ObjectIdentifier curvey25519;

    /* renamed from: ecc */
    public static final ASN1ObjectIdentifier f18274ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        cryptlib = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierM14432branch = aSN1ObjectIdentifier.m14432branch("1").m14432branch("5");
        f18274ecc = aSN1ObjectIdentifierM14432branch;
        curvey25519 = aSN1ObjectIdentifierM14432branch.m14432branch("1");
    }
}
