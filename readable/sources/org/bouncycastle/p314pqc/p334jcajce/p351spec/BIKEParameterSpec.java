package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BIKEParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: bike128 */
    public static final BIKEParameterSpec f23893bike128;

    /* renamed from: bike192 */
    public static final BIKEParameterSpec f23894bike192;

    /* renamed from: bike256 */
    public static final BIKEParameterSpec f23895bike256;
    private static Map parameters;

    /* renamed from: name */
    private final String f23896name;

    static {
        BIKEParameterSpec bIKEParameterSpec = new BIKEParameterSpec(BIKEParameters.f23947bike128);
        f23893bike128 = bIKEParameterSpec;
        BIKEParameterSpec bIKEParameterSpec2 = new BIKEParameterSpec(BIKEParameters.f23948bike192);
        f23894bike192 = bIKEParameterSpec2;
        BIKEParameterSpec bIKEParameterSpec3 = new BIKEParameterSpec(BIKEParameters.f23949bike256);
        f23895bike256 = bIKEParameterSpec3;
        HashMap map = new HashMap();
        parameters = map;
        map.put("bike128", bIKEParameterSpec);
        parameters.put("bike192", bIKEParameterSpec2);
        parameters.put("bike256", bIKEParameterSpec3);
    }

    private BIKEParameterSpec(BIKEParameters bIKEParameters) {
        this.f23896name = bIKEParameters.m18064getName();
    }

    public static BIKEParameterSpec fromName(String str) {
        return (BIKEParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18041getName() {
        return this.f23896name;
    }
}
