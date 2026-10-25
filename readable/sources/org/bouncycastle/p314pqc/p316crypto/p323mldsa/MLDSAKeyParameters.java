package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSAKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final MLDSAParameters f23308params;

    public MLDSAKeyParameters(boolean z, MLDSAParameters mLDSAParameters) {
        super(z);
        this.f23308params = mLDSAParameters;
    }

    public MLDSAParameters getParameters() {
        return this.f23308params;
    }
}
