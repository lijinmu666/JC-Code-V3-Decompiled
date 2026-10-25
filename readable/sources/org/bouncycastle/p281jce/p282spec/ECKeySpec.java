package org.bouncycastle.p281jce.p282spec;

import java.security.spec.KeySpec;

/* loaded from: classes2.dex */
public class ECKeySpec implements KeySpec {

    /* renamed from: spec */
    private ECParameterSpec f22054spec;

    public ECKeySpec(ECParameterSpec eCParameterSpec) {
        this.f22054spec = eCParameterSpec;
    }

    public ECParameterSpec getParams() {
        return this.f22054spec;
    }
}
