package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class MLKEMKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private MLKEMParameters f20795params;

    public MLKEMKeyParameters(boolean z, MLKEMParameters mLKEMParameters) {
        super(z);
        this.f20795params = mLKEMParameters;
    }

    public MLKEMParameters getParameters() {
        return this.f20795params;
    }
}
