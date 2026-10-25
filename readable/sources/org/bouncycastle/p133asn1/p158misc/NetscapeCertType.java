package org.bouncycastle.p133asn1.p158misc;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.DERBitString;

/* loaded from: classes2.dex */
public class NetscapeCertType extends DERBitString {
    public static final int objectSigning = 16;
    public static final int objectSigningCA = 1;
    public static final int reserved = 8;

    /* renamed from: smime */
    public static final int f18419smime = 32;

    /* renamed from: smimeCA */
    public static final int f18420smimeCA = 2;

    /* renamed from: sslCA */
    public static final int f18421sslCA = 4;
    public static final int sslClient = 128;
    public static final int sslServer = 64;

    public NetscapeCertType(int i) {
        super(i);
    }

    public boolean hasUsages(int i) {
        return (intValue() & i) == i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitString
    public String toString() {
        return "NetscapeCertType: 0x" + Integer.toHexString(intValue());
    }

    public NetscapeCertType(ASN1BitString aSN1BitString) {
        super(aSN1BitString.getBytes(), aSN1BitString.getPadBits());
    }
}
