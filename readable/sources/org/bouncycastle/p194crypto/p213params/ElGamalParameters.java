package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f20746g;

    /* renamed from: l */
    private int f20747l;

    /* renamed from: p */
    private BigInteger f20748p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    /* renamed from: equals */
    public boolean m15742equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.m15745getP().equals(this.f20748p) && elGamalParameters.m15743getG().equals(this.f20746g) && elGamalParameters.m15744getL() == this.f20747l;
    }

    /* renamed from: getG */
    public BigInteger m15743getG() {
        return this.f20746g;
    }

    /* renamed from: getL */
    public int m15744getL() {
        return this.f20747l;
    }

    /* renamed from: getP */
    public BigInteger m15745getP() {
        return this.f20748p;
    }

    public int hashCode() {
        return (m15745getP().hashCode() ^ m15743getG().hashCode()) + this.f20747l;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f20746g = bigInteger2;
        this.f20748p = bigInteger;
        this.f20747l = i;
    }
}
