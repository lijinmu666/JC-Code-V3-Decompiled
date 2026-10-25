package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class SRP6GroupParameters {

    /* renamed from: N */
    private BigInteger f20863N;

    /* renamed from: g */
    private BigInteger f20864g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f20863N = bigInteger;
        this.f20864g = bigInteger2;
    }

    /* renamed from: getG */
    public BigInteger m15825getG() {
        return this.f20864g;
    }

    /* renamed from: getN */
    public BigInteger m15826getN() {
        return this.f20863N;
    }
}
