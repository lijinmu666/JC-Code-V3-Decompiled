package org.bouncycastle.internal.p231asn1.p235edec;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface EdECObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_Ed25519;
    public static final ASN1ObjectIdentifier id_Ed448;
    public static final ASN1ObjectIdentifier id_X25519;

    /* renamed from: id_X448 */
    public static final ASN1ObjectIdentifier f21248id_X448;
    public static final ASN1ObjectIdentifier id_edwards_curve_algs;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.101");
        id_edwards_curve_algs = aSN1ObjectIdentifier;
        id_X25519 = aSN1ObjectIdentifier.m14432branch("110").m14434intern();
        f21248id_X448 = aSN1ObjectIdentifier.m14432branch("111").m14434intern();
        id_Ed25519 = aSN1ObjectIdentifier.m14432branch("112").m14434intern();
        id_Ed448 = aSN1ObjectIdentifier.m14432branch("113").m14434intern();
    }
}
