package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public abstract class NTRUKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final NTRUParameters f23380params;

    public NTRUKeyParameters(boolean z, NTRUParameters nTRUParameters) {
        super(z);
        this.f23380params = nTRUParameters;
    }

    public NTRUParameters getParameters() {
        return this.f23380params;
    }
}
