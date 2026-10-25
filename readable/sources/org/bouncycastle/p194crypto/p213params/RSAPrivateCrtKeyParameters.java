package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f20822dP;

    /* renamed from: dQ */
    private BigInteger f20823dQ;

    /* renamed from: e */
    private BigInteger f20824e;

    /* renamed from: p */
    private BigInteger f20825p;

    /* renamed from: q */
    private BigInteger f20826q;

    /* renamed from: qInv */
    private BigInteger f20827qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6, bigInteger7, bigInteger8, false);
    }

    /* renamed from: getDP */
    public BigInteger m15806getDP() {
        return this.f20822dP;
    }

    /* renamed from: getDQ */
    public BigInteger m15807getDQ() {
        return this.f20823dQ;
    }

    /* renamed from: getP */
    public BigInteger m15808getP() {
        return this.f20825p;
    }

    public BigInteger getPublicExponent() {
        return this.f20824e;
    }

    /* renamed from: getQ */
    public BigInteger m15809getQ() {
        return this.f20826q;
    }

    /* renamed from: getQInv */
    public BigInteger m15810getQInv() {
        return this.f20827qInv;
    }

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8, boolean z) {
        super(true, bigInteger, bigInteger3, z);
        this.f20824e = bigInteger2;
        this.f20825p = bigInteger4;
        this.f20826q = bigInteger5;
        this.f20822dP = bigInteger6;
        this.f20823dQ = bigInteger7;
        this.f20827qInv = bigInteger8;
    }
}
