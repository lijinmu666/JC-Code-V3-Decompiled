package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class FrodoParameterSpec implements AlgorithmParameterSpec {
    public static final FrodoParameterSpec frodokem1344aes;
    public static final FrodoParameterSpec frodokem1344shake;
    public static final FrodoParameterSpec frodokem640aes;
    public static final FrodoParameterSpec frodokem640shake;
    public static final FrodoParameterSpec frodokem976aes;
    public static final FrodoParameterSpec frodokem976shake;
    private static Map parameters;

    /* renamed from: name */
    private final String f23900name;

    static {
        FrodoParameterSpec frodoParameterSpec = new FrodoParameterSpec(FrodoParameters.frodokem640aes);
        frodokem640aes = frodoParameterSpec;
        FrodoParameterSpec frodoParameterSpec2 = new FrodoParameterSpec(FrodoParameters.frodokem640shake);
        frodokem640shake = frodoParameterSpec2;
        FrodoParameterSpec frodoParameterSpec3 = new FrodoParameterSpec(FrodoParameters.frodokem976aes);
        frodokem976aes = frodoParameterSpec3;
        FrodoParameterSpec frodoParameterSpec4 = new FrodoParameterSpec(FrodoParameters.frodokem976shake);
        frodokem976shake = frodoParameterSpec4;
        FrodoParameterSpec frodoParameterSpec5 = new FrodoParameterSpec(FrodoParameters.frodokem1344aes);
        frodokem1344aes = frodoParameterSpec5;
        FrodoParameterSpec frodoParameterSpec6 = new FrodoParameterSpec(FrodoParameters.frodokem1344shake);
        frodokem1344shake = frodoParameterSpec6;
        HashMap map = new HashMap();
        parameters = map;
        map.put("frodokem19888r3", frodoParameterSpec);
        parameters.put("frodokem19888shaker3", frodoParameterSpec2);
        parameters.put("frodokem31296r3", frodoParameterSpec3);
        parameters.put("frodokem31296shaker3", frodoParameterSpec4);
        parameters.put("frodokem43088r3", frodoParameterSpec5);
        parameters.put("frodokem43088shaker3", frodoParameterSpec6);
        parameters.put("frodokem640aes", frodoParameterSpec);
        parameters.put("frodokem640shake", frodoParameterSpec2);
        parameters.put("frodokem976aes", frodoParameterSpec3);
        parameters.put("frodokem976shake", frodoParameterSpec4);
        parameters.put("frodokem1344aes", frodoParameterSpec5);
        parameters.put("frodokem1344shake", frodoParameterSpec6);
    }

    private FrodoParameterSpec(FrodoParameters frodoParameters) {
        this.f23900name = frodoParameters.m17569getName();
    }

    public static FrodoParameterSpec fromName(String str) {
        return (FrodoParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18045getName() {
        return this.f23900name;
    }
}
