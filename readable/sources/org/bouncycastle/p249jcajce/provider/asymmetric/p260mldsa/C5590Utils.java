package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.Utils */
/* loaded from: classes2.dex */
class C5590Utils {
    private static Map parameters;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(MLDSAParameterSpec.ml_dsa_44.m16205getName(), MLDSAParameters.ml_dsa_44);
        parameters.put(MLDSAParameterSpec.ml_dsa_65.m16205getName(), MLDSAParameters.ml_dsa_65);
        parameters.put(MLDSAParameterSpec.ml_dsa_87.m16205getName(), MLDSAParameters.ml_dsa_87);
        parameters.put(MLDSAParameterSpec.ml_dsa_44_with_sha512.m16205getName(), MLDSAParameters.ml_dsa_44_with_sha512);
        parameters.put(MLDSAParameterSpec.ml_dsa_65_with_sha512.m16205getName(), MLDSAParameters.ml_dsa_65_with_sha512);
        parameters.put(MLDSAParameterSpec.ml_dsa_87_with_sha512.m16205getName(), MLDSAParameters.ml_dsa_87_with_sha512);
    }

    public static MLDSAParameters getParameters(String str) {
        return (MLDSAParameters) parameters.get(str);
    }
}
