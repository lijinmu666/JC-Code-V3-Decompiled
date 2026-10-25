package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class FalconParameterSpec implements AlgorithmParameterSpec {
    public static final FalconParameterSpec falcon_1024;
    public static final FalconParameterSpec falcon_512;
    private static Map parameters;

    /* renamed from: name */
    private final String f23899name;

    static {
        FalconParameterSpec falconParameterSpec = new FalconParameterSpec(FalconParameters.falcon_512);
        falcon_512 = falconParameterSpec;
        FalconParameterSpec falconParameterSpec2 = new FalconParameterSpec(FalconParameters.falcon_1024);
        falcon_1024 = falconParameterSpec2;
        HashMap map = new HashMap();
        parameters = map;
        map.put("falcon-512", falconParameterSpec);
        parameters.put("falcon-1024", falconParameterSpec2);
    }

    private FalconParameterSpec(FalconParameters falconParameters) {
        this.f23899name = C6250Strings.toUpperCase(falconParameters.m17549getName());
    }

    public static FalconParameterSpec fromName(String str) {
        return (FalconParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18044getName() {
        return this.f23899name;
    }
}
