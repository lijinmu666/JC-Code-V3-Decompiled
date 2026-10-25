package org.bouncycastle.p314pqc.p356math.p357ntru.parameters;

import org.bouncycastle.p314pqc.p356math.p357ntru.HRSS1373Polynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.HRSSPolynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;

/* loaded from: classes2.dex */
public abstract class NTRUHRSSParameterSet extends NTRUParameterSet {
    public NTRUHRSSParameterSet(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, i5);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public Polynomial createPolynomial() {
        return m18201n() == 1373 ? new HRSS1373Polynomial(this) : new HRSSPolynomial(this);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public int sampleFgBytes() {
        return sampleIidBytes() * 2;
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public int sampleRmBytes() {
        return sampleIidBytes() * 2;
    }
}
