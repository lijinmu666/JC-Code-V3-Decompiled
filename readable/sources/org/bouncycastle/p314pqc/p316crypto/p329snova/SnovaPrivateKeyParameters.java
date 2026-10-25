package org.bouncycastle.p314pqc.p316crypto.p329snova;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SnovaPrivateKeyParameters extends AsymmetricKeyParameter {
    private final SnovaParameters parameters;
    private final byte[] privateKey;

    public SnovaPrivateKeyParameters(SnovaParameters snovaParameters, byte[] bArr) {
        super(true);
        this.privateKey = C6238Arrays.m18231clone(bArr);
        this.parameters = snovaParameters;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.privateKey);
    }

    public SnovaParameters getParameters() {
        return this.parameters;
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.privateKey);
    }
}
