package org.bouncycastle.p194crypto.hash2curve.p204impl;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class SqrtRatio {

    /* renamed from: isQR */
    private final boolean f20324isQR;

    /* renamed from: ratio */
    private final BigInteger f20325ratio;

    public SqrtRatio(boolean z, BigInteger bigInteger) {
        this.f20324isQR = z;
        this.f20325ratio = bigInteger;
    }

    public BigInteger getRatio() {
        return this.f20325ratio;
    }

    /* renamed from: isQR */
    public boolean m15533isQR() {
        return this.f20324isQR;
    }
}
