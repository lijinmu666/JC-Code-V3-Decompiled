package org.bouncycastle.p281jce.p282spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes2.dex */
public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f22066g;

    /* renamed from: p */
    private BigInteger f22067p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f22067p = bigInteger;
        this.f22066g = bigInteger2;
    }

    /* renamed from: getG */
    public BigInteger m16275getG() {
        return this.f22066g;
    }

    /* renamed from: getP */
    public BigInteger m16276getP() {
        return this.f22067p;
    }
}
