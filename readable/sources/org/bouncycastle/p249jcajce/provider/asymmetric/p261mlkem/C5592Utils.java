package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mlkem.Utils */
/* loaded from: classes2.dex */
class C5592Utils {
    private static Map parameters;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(MLKEMParameterSpec.ml_kem_512.m16208getName(), MLKEMParameters.ml_kem_512);
        parameters.put(MLKEMParameterSpec.ml_kem_768.m16208getName(), MLKEMParameters.ml_kem_768);
        parameters.put(MLKEMParameterSpec.ml_kem_1024.m16208getName(), MLKEMParameters.ml_kem_1024);
    }

    public static MLKEMParameters getParameters(String str) {
        return (MLKEMParameters) parameters.get(str);
    }
}
