package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class CMCEKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private CMCEParameters f23073params;

    public CMCEKeyParameters(boolean z, CMCEParameters cMCEParameters) {
        super(z);
        this.f23073params = cMCEParameters;
    }

    public CMCEParameters getParameters() {
        return this.f23073params;
    }
}
