package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class MLKEMParameterSpec implements AlgorithmParameterSpec {
    public static final MLKEMParameterSpec ml_kem_1024;
    public static final MLKEMParameterSpec ml_kem_512;
    public static final MLKEMParameterSpec ml_kem_768;
    private static Map parameters;

    /* renamed from: name */
    private final String f21933name;

    static {
        MLKEMParameterSpec mLKEMParameterSpec = new MLKEMParameterSpec("ML-KEM-512");
        ml_kem_512 = mLKEMParameterSpec;
        MLKEMParameterSpec mLKEMParameterSpec2 = new MLKEMParameterSpec("ML-KEM-768");
        ml_kem_768 = mLKEMParameterSpec2;
        MLKEMParameterSpec mLKEMParameterSpec3 = new MLKEMParameterSpec("ML-KEM-1024");
        ml_kem_1024 = mLKEMParameterSpec3;
        HashMap map = new HashMap();
        parameters = map;
        map.put("ml-kem-512", mLKEMParameterSpec);
        parameters.put("ml-kem-768", mLKEMParameterSpec2);
        parameters.put("ml-kem-1024", mLKEMParameterSpec3);
        parameters.put("kyber512", mLKEMParameterSpec);
        parameters.put("kyber768", mLKEMParameterSpec2);
        parameters.put("kyber1024", mLKEMParameterSpec3);
    }

    private MLKEMParameterSpec(String str) {
        this.f21933name = str;
    }

    public static MLKEMParameterSpec fromName(String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        MLKEMParameterSpec mLKEMParameterSpec = (MLKEMParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
        if (mLKEMParameterSpec != null) {
            return mLKEMParameterSpec;
        }
        throw new IllegalArgumentException("unknown parameter name: " + str);
    }

    /* renamed from: getName */
    public String m16208getName() {
        return this.f21933name;
    }
}
