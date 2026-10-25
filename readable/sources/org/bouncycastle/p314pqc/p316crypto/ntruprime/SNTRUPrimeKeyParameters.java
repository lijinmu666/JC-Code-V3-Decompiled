package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class SNTRUPrimeKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final SNTRUPrimeParameters f23432params;

    public SNTRUPrimeKeyParameters(boolean z, SNTRUPrimeParameters sNTRUPrimeParameters) {
        super(z);
        this.f23432params = sNTRUPrimeParameters;
    }

    public SNTRUPrimeParameters getParameters() {
        return this.f23432params;
    }
}
