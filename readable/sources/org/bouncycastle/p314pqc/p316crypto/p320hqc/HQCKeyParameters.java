package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class HQCKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final HQCParameters f23198params;

    public HQCKeyParameters(boolean z, HQCParameters hQCParameters) {
        super(z);
        this.f23198params = hQCParameters;
    }

    public HQCParameters getParameters() {
        return this.f23198params;
    }
}
