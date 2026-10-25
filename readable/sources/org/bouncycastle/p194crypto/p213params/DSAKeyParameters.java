package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class DSAKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private DSAParameters f20709params;

    public DSAKeyParameters(boolean z, DSAParameters dSAParameters) {
        super(z);
        this.f20709params = dSAParameters;
    }

    public DSAParameters getParameters() {
        return this.f20709params;
    }
}
