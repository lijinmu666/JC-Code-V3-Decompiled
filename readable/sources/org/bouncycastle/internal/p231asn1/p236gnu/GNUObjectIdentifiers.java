package org.bouncycastle.internal.p231asn1.p236gnu;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;

/* loaded from: classes2.dex */
public interface GNUObjectIdentifiers {

    /* renamed from: Ed25519 */
    public static final ASN1ObjectIdentifier f21251Ed25519;
    public static final ASN1ObjectIdentifier ellipticCurve;

    /* renamed from: GNU */
    public static final ASN1ObjectIdentifier f21252GNU = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.1");

    /* renamed from: GnuPG */
    public static final ASN1ObjectIdentifier f21253GnuPG = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2");
    public static final ASN1ObjectIdentifier notation = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1");
    public static final ASN1ObjectIdentifier pkaAddress = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1.1");
    public static final ASN1ObjectIdentifier GnuRadar = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.3");
    public static final ASN1ObjectIdentifier digestAlgorithm = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12");
    public static final ASN1ObjectIdentifier Tiger_192 = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12.2");
    public static final ASN1ObjectIdentifier encryptionAlgorithm = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13");

    /* renamed from: Serpent */
    public static final ASN1ObjectIdentifier f21254Serpent = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2");
    public static final ASN1ObjectIdentifier Serpent_128_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.1");
    public static final ASN1ObjectIdentifier Serpent_128_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.2");
    public static final ASN1ObjectIdentifier Serpent_128_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.3");
    public static final ASN1ObjectIdentifier Serpent_128_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.4");
    public static final ASN1ObjectIdentifier Serpent_192_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.21");
    public static final ASN1ObjectIdentifier Serpent_192_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.22");
    public static final ASN1ObjectIdentifier Serpent_192_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.23");
    public static final ASN1ObjectIdentifier Serpent_192_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.24");
    public static final ASN1ObjectIdentifier Serpent_256_ECB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.41");
    public static final ASN1ObjectIdentifier Serpent_256_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.42");
    public static final ASN1ObjectIdentifier Serpent_256_OFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.43");
    public static final ASN1ObjectIdentifier Serpent_256_CFB = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.44");

    /* renamed from: CRC */
    public static final ASN1ObjectIdentifier f21249CRC = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14");

    /* renamed from: CRC32 */
    public static final ASN1ObjectIdentifier f21250CRC32 = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14.1");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.15");
        ellipticCurve = aSN1ObjectIdentifier;
        f21251Ed25519 = aSN1ObjectIdentifier.m14432branch("1");
    }
}
