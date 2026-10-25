package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class NTRUPlusParameterSpec implements AlgorithmParameterSpec {
    public static final NTRUPlusParameterSpec ntruplus_1152;
    public static final NTRUPlusParameterSpec ntruplus_768;
    public static final NTRUPlusParameterSpec ntruplus_864;
    private static Map parameters;

    /* renamed from: name */
    private final String f23915name;

    static {
        NTRUPlusParameterSpec nTRUPlusParameterSpec = new NTRUPlusParameterSpec(NTRUPlusParameters.ntruplus_kem_768);
        ntruplus_768 = nTRUPlusParameterSpec;
        NTRUPlusParameterSpec nTRUPlusParameterSpec2 = new NTRUPlusParameterSpec(NTRUPlusParameters.ntruplus_kem_864);
        ntruplus_864 = nTRUPlusParameterSpec2;
        ntruplus_1152 = new NTRUPlusParameterSpec(NTRUPlusParameters.ntruplus_kem_1152);
        HashMap map = new HashMap();
        parameters = map;
        map.put("ntruplus-768", nTRUPlusParameterSpec);
        parameters.put("ntruplus-864", nTRUPlusParameterSpec2);
        parameters.put("ntruplus-864", nTRUPlusParameterSpec2);
    }

    private NTRUPlusParameterSpec(NTRUPlusParameters nTRUPlusParameters) {
        this.f23915name = C6250Strings.toUpperCase(nTRUPlusParameters.m17775getName());
    }

    public static NTRUPlusParameterSpec fromName(String str) {
        return (NTRUPlusParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18051getName() {
        return this.f23915name;
    }
}
