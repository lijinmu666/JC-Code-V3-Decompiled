package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes2.dex */
public class LMSHSSKeyGenParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: specs */
    private final LMSKeyGenParameterSpec[] f23906specs;

    public LMSHSSKeyGenParameterSpec(LMSKeyGenParameterSpec... lMSKeyGenParameterSpecArr) {
        if (lMSKeyGenParameterSpecArr.length == 0) {
            throw new IllegalArgumentException("at least one LMSKeyGenParameterSpec required");
        }
        this.f23906specs = (LMSKeyGenParameterSpec[]) lMSKeyGenParameterSpecArr.clone();
    }

    public LMSKeyGenParameterSpec[] getLMSSpecs() {
        return (LMSKeyGenParameterSpec[]) this.f23906specs.clone();
    }
}
