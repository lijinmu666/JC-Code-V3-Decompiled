package org.bouncycastle.p314pqc.p316crypto.p329snova;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SnovaPublicKeyParameters extends AsymmetricKeyParameter {
    private final SnovaParameters parameters;
    private final byte[] publicKey;

    public SnovaPublicKeyParameters(SnovaParameters snovaParameters, byte[] bArr) {
        super(false);
        this.publicKey = C6238Arrays.m18231clone(bArr);
        this.parameters = snovaParameters;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.publicKey);
    }

    public SnovaParameters getParameters() {
        return this.parameters;
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
