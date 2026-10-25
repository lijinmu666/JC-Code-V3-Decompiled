package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes2.dex */
public class LMSHSSParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: specs */
    private final LMSParameterSpec[] f23907specs;

    public LMSHSSParameterSpec(LMSParameterSpec[] lMSParameterSpecArr) {
        this.f23907specs = (LMSParameterSpec[]) lMSParameterSpecArr.clone();
    }

    public LMSParameterSpec[] getLMSSpecs() {
        return (LMSParameterSpec[]) this.f23907specs.clone();
    }
}
