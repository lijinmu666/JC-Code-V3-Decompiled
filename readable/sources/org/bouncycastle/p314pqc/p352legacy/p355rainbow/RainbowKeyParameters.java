package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class RainbowKeyParameters extends AsymmetricKeyParameter {
    private final int docLength;

    /* renamed from: params */
    private final RainbowParameters f24036params;

    public RainbowKeyParameters(boolean z, RainbowParameters rainbowParameters) {
        super(z);
        this.f24036params = rainbowParameters;
        this.docLength = rainbowParameters.m18124getM();
    }

    public int getDocLength() {
        return this.docLength;
    }

    public RainbowParameters getParameters() {
        return this.f24036params;
    }
}
