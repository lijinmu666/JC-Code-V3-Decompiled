package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class MayoKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final MayoParameters f23274params;

    public MayoKeyParameters(boolean z, MayoParameters mayoParameters) {
        super(z);
        this.f23274params = mayoParameters;
    }

    public MayoParameters getParameters() {
        return this.f23274params;
    }
}
