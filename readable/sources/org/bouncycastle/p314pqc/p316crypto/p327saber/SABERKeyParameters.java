package org.bouncycastle.p314pqc.p316crypto.p327saber;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class SABERKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: params */
    private SABERParameters f23462params;

    public SABERKeyParameters(boolean z, SABERParameters sABERParameters) {
        super(z);
        this.f23462params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.f23462params;
    }
}
