package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class FalconKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final FalconParameters f23118params;

    public FalconKeyParameters(boolean z, FalconParameters falconParameters) {
        super(z);
        this.f23118params = falconParameters;
    }

    public FalconParameters getParameters() {
        return this.f23118params;
    }
}
