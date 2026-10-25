package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSAKeyParameters extends AsymmetricKeyParameter {
    private final SLHDSAParameters parameters;

    public SLHDSAKeyParameters(boolean z, SLHDSAParameters sLHDSAParameters) {
        super(z);
        this.parameters = sLHDSAParameters;
    }

    public SLHDSAParameters getParameters() {
        return this.parameters;
    }
}
