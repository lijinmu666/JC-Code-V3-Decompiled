package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class DilithiumKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private final DilithiumParameters f23083params;

    public DilithiumKeyParameters(boolean z, DilithiumParameters dilithiumParameters) {
        super(z);
        this.f23083params = dilithiumParameters;
    }

    public DilithiumParameters getParameters() {
        return this.f23083params;
    }
}
