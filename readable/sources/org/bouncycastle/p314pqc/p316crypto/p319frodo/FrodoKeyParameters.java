package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class FrodoKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private FrodoParameters f23168params;

    public FrodoKeyParameters(boolean z, FrodoParameters frodoParameters) {
        super(z);
        this.f23168params = frodoParameters;
    }

    public FrodoParameters getParameters() {
        return this.f23168params;
    }
}
