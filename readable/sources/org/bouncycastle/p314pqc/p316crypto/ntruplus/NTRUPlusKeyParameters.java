package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class NTRUPlusKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final NTRUPlusParameters f23406params;

    public NTRUPlusKeyParameters(boolean z, NTRUPlusParameters nTRUPlusParameters) {
        super(z);
        this.f23406params = nTRUPlusParameters;
    }

    public NTRUPlusParameters getParameters() {
        return this.f23406params;
    }
}
