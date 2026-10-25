package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class BIKEKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private BIKEParameters f23946params;

    public BIKEKeyParameters(boolean z, BIKEParameters bIKEParameters) {
        super(z);
        this.f23946params = bIKEParameters;
    }

    public BIKEParameters getParameters() {
        return this.f23946params;
    }
}
