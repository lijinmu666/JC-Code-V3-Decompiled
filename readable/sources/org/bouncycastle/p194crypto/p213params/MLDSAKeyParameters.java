package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class MLDSAKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final MLDSAParameters f20780params;

    public MLDSAKeyParameters(boolean z, MLDSAParameters mLDSAParameters) {
        super(z);
        this.f20780params = mLDSAParameters;
    }

    public MLDSAParameters getParameters() {
        return this.f20780params;
    }
}
