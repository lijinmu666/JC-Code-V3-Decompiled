package org.bouncycastle.p314pqc.p356math.p357ntru.parameters;

import org.bouncycastle.p314pqc.p356math.p357ntru.HPSPolynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;

/* loaded from: classes2.dex */
public abstract class NTRUHPSParameterSet extends NTRUParameterSet {
    public NTRUHPSParameterSet(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, i5);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public Polynomial createPolynomial() {
        return new HPSPolynomial(this);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public int sampleFgBytes() {
        return sampleIidBytes() + sampleFixedTypeBytes();
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public int sampleRmBytes() {
        return sampleIidBytes() + sampleFixedTypeBytes();
    }

    /* renamed from: weight */
    public int m18199weight() {
        return (m18202q() / 8) - 2;
    }
}
