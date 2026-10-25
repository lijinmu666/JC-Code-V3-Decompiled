package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: g */
    private BigInteger f20808g;
    int lowerSigmaBound;

    /* renamed from: n */
    private BigInteger f20809n;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        super(z);
        this.f20808g = bigInteger;
        this.f20809n = bigInteger2;
        this.lowerSigmaBound = i;
    }

    /* renamed from: getG */
    public BigInteger m15799getG() {
        return this.f20808g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.f20809n;
    }
}
