package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class NTRULPRimeKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final NTRULPRimeParameters f23415params;

    public NTRULPRimeKeyParameters(boolean z, NTRULPRimeParameters nTRULPRimeParameters) {
        super(z);
        this.f23415params = nTRULPRimeParameters;
    }

    public NTRULPRimeParameters getParameters() {
        return this.f23415params;
    }
}
