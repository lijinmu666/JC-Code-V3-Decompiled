package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class GOST3410KeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private GOST3410Parameters f20754params;

    public GOST3410KeyParameters(boolean z, GOST3410Parameters gOST3410Parameters) {
        super(z);
        this.f20754params = gOST3410Parameters;
    }

    public GOST3410Parameters getParameters() {
        return this.f20754params;
    }
}
