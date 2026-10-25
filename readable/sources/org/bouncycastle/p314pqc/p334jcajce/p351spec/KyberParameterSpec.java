package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class KyberParameterSpec implements AlgorithmParameterSpec {
    public static final KyberParameterSpec kyber1024;
    public static final KyberParameterSpec kyber512;
    public static final KyberParameterSpec kyber768;
    private static Map parameters;

    /* renamed from: name */
    private final String f23905name;

    static {
        KyberParameterSpec kyberParameterSpec = new KyberParameterSpec(MLKEMParameters.ml_kem_512);
        kyber512 = kyberParameterSpec;
        KyberParameterSpec kyberParameterSpec2 = new KyberParameterSpec(MLKEMParameters.ml_kem_768);
        kyber768 = kyberParameterSpec2;
        KyberParameterSpec kyberParameterSpec3 = new KyberParameterSpec(MLKEMParameters.ml_kem_1024);
        kyber1024 = kyberParameterSpec3;
        HashMap map = new HashMap();
        parameters = map;
        map.put("kyber512", kyberParameterSpec);
        parameters.put("kyber768", kyberParameterSpec2);
        parameters.put("kyber1024", kyberParameterSpec3);
    }

    private KyberParameterSpec(MLKEMParameters mLKEMParameters) {
        this.f23905name = C6250Strings.toUpperCase(mLKEMParameters.m15790getName());
    }

    public static KyberParameterSpec fromName(String str) {
        return (KyberParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18047getName() {
        return this.f23905name;
    }
}
