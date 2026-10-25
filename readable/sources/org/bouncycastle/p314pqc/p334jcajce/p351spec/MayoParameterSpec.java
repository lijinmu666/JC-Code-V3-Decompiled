package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class MayoParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: mayo1 */
    public static final MayoParameterSpec f23908mayo1;

    /* renamed from: mayo2 */
    public static final MayoParameterSpec f23909mayo2;

    /* renamed from: mayo3 */
    public static final MayoParameterSpec f23910mayo3;

    /* renamed from: mayo5 */
    public static final MayoParameterSpec f23911mayo5;
    private static Map parameters;

    /* renamed from: name */
    private final String f23912name;

    static {
        MayoParameterSpec mayoParameterSpec = new MayoParameterSpec(MayoParameters.f23275mayo1);
        f23908mayo1 = mayoParameterSpec;
        MayoParameterSpec mayoParameterSpec2 = new MayoParameterSpec(MayoParameters.f23276mayo2);
        f23909mayo2 = mayoParameterSpec2;
        MayoParameterSpec mayoParameterSpec3 = new MayoParameterSpec(MayoParameters.f23277mayo3);
        f23910mayo3 = mayoParameterSpec3;
        MayoParameterSpec mayoParameterSpec4 = new MayoParameterSpec(MayoParameters.f23278mayo5);
        f23911mayo5 = mayoParameterSpec4;
        HashMap map = new HashMap();
        parameters = map;
        map.put("MAYO_1", mayoParameterSpec);
        parameters.put("MAYO_2", mayoParameterSpec2);
        parameters.put("MAYO_3", mayoParameterSpec3);
        parameters.put("MAYO_5", mayoParameterSpec4);
    }

    private MayoParameterSpec(MayoParameters mayoParameters) {
        this.f23912name = mayoParameters.m17670getName();
    }

    public static MayoParameterSpec fromName(String str) {
        return (MayoParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18048getName() {
        return this.f23912name;
    }
}
