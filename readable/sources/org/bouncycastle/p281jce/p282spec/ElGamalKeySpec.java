package org.bouncycastle.p281jce.p282spec;

import java.security.spec.KeySpec;

/* loaded from: classes2.dex */
public class ElGamalKeySpec implements KeySpec {

    /* renamed from: spec */
    private ElGamalParameterSpec f22065spec;

    public ElGamalKeySpec(ElGamalParameterSpec elGamalParameterSpec) {
        this.f22065spec = elGamalParameterSpec;
    }

    public ElGamalParameterSpec getParams() {
        return this.f22065spec;
    }
}
