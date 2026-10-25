package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class HQCParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: hqc128 */
    public static final HQCParameterSpec f23901hqc128;

    /* renamed from: hqc192 */
    public static final HQCParameterSpec f23902hqc192;

    /* renamed from: hqc256 */
    public static final HQCParameterSpec f23903hqc256;
    private static Map parameters;

    /* renamed from: name */
    private final String f23904name;

    static {
        HQCParameterSpec hQCParameterSpec = new HQCParameterSpec(HQCParameters.f23200hqc128);
        f23901hqc128 = hQCParameterSpec;
        HQCParameterSpec hQCParameterSpec2 = new HQCParameterSpec(HQCParameters.f23201hqc192);
        f23902hqc192 = hQCParameterSpec2;
        HQCParameterSpec hQCParameterSpec3 = new HQCParameterSpec(HQCParameters.f23202hqc256);
        f23903hqc256 = hQCParameterSpec3;
        HashMap map = new HashMap();
        parameters = map;
        map.put("hqc128", hQCParameterSpec);
        parameters.put("hqc192", hQCParameterSpec2);
        parameters.put("hqc256", hQCParameterSpec3);
    }

    private HQCParameterSpec(HQCParameters hQCParameters) {
        this.f23904name = hQCParameters.m17592getName();
    }

    public static HQCParameterSpec fromName(String str) {
        return (HQCParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18046getName() {
        return this.f23904name;
    }
}
