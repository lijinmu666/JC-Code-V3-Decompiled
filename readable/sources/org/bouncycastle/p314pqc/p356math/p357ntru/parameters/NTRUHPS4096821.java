package org.bouncycastle.p314pqc.p356math.p357ntru.parameters;

import org.bouncycastle.p314pqc.p356math.p357ntru.HPS4096Polynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;

/* loaded from: classes2.dex */
public class NTRUHPS4096821 extends NTRUHPSParameterSet {
    public NTRUHPS4096821() {
        super(821, 12, 32, 32, 32);
    }

    @Override // org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPSParameterSet, org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet
    public Polynomial createPolynomial() {
        return new HPS4096Polynomial(this);
    }
}
