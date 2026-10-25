package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class DilithiumParameterSpec implements AlgorithmParameterSpec {
    public static final DilithiumParameterSpec dilithium2;
    public static final DilithiumParameterSpec dilithium3;
    public static final DilithiumParameterSpec dilithium5;
    private static Map parameters;

    /* renamed from: name */
    private final String f23898name;

    static {
        DilithiumParameterSpec dilithiumParameterSpec = new DilithiumParameterSpec(DilithiumParameters.dilithium2);
        dilithium2 = dilithiumParameterSpec;
        DilithiumParameterSpec dilithiumParameterSpec2 = new DilithiumParameterSpec(DilithiumParameters.dilithium3);
        dilithium3 = dilithiumParameterSpec2;
        DilithiumParameterSpec dilithiumParameterSpec3 = new DilithiumParameterSpec(DilithiumParameters.dilithium5);
        dilithium5 = dilithiumParameterSpec3;
        HashMap map = new HashMap();
        parameters = map;
        map.put("dilithium2", dilithiumParameterSpec);
        parameters.put("dilithium3", dilithiumParameterSpec2);
        parameters.put("dilithium5", dilithiumParameterSpec3);
    }

    private DilithiumParameterSpec(DilithiumParameters dilithiumParameters) {
        this.f23898name = C6250Strings.toUpperCase(dilithiumParameters.m17515getName());
    }

    public static DilithiumParameterSpec fromName(String str) {
        return (DilithiumParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18043getName() {
        return this.f23898name;
    }
}
