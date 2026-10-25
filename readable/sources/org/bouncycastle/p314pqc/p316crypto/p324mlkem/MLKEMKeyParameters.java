package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private MLKEMParameters f23343params;

    public MLKEMKeyParameters(boolean z, MLKEMParameters mLKEMParameters) {
        super(z);
        this.f23343params = mLKEMParameters;
    }

    public MLKEMParameters getParameters() {
        return this.f23343params;
    }
}
