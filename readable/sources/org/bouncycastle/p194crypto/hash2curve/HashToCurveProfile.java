package org.bouncycastle.p194crypto.hash2curve;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public enum HashToCurveProfile {
    P256_XMD_SHA_256(BigInteger.valueOf(-10), 48, 128, 1, null, null),
    P384_XMD_SHA_384(BigInteger.valueOf(-12), 72, 192, 1, null, null),
    P521_XMD_SHA_512(BigInteger.valueOf(-4), 98, 256, 1, null, null),
    CURVE25519W_XMD_SHA_512_ELL2(BigInteger.valueOf(2), 48, 128, 8, 486662, 1);


    /* renamed from: L */
    private final int f20288L;

    /* renamed from: Z */
    private final BigInteger f20289Z;

    /* renamed from: h */
    private final int f20290h;

    /* renamed from: k */
    private final int f20291k;

    /* renamed from: mJ */
    private final Integer f20292mJ;

    /* renamed from: mK */
    private final Integer f20293mK;

    HashToCurveProfile(BigInteger bigInteger, int i, int i2, int i3, Integer num, Integer num2) {
        this.f20289Z = bigInteger;
        this.f20288L = i;
        this.f20291k = i2;
        this.f20290h = i3;
        this.f20292mJ = num;
        this.f20293mK = num2;
    }

    /* renamed from: getH */
    public int m15517getH() {
        return this.f20290h;
    }

    /* renamed from: getK */
    public int m15518getK() {
        return this.f20291k;
    }

    /* renamed from: getL */
    public int m15519getL() {
        return this.f20288L;
    }

    /* renamed from: getZ */
    public BigInteger m15520getZ() {
        return this.f20289Z;
    }

    /* renamed from: getmJ */
    public Integer m15521getmJ() {
        return this.f20292mJ;
    }

    /* renamed from: getmK */
    public Integer m15522getmK() {
        return this.f20293mK;
    }
}
