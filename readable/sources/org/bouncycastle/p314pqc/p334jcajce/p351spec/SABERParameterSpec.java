package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SABERParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: name */
    private final String f23917name;
    public static final SABERParameterSpec lightsaberkem128r3 = new SABERParameterSpec(SABERParameters.lightsaberkem128r3);
    public static final SABERParameterSpec saberkem128r3 = new SABERParameterSpec(SABERParameters.saberkem128r3);
    public static final SABERParameterSpec firesaberkem128r3 = new SABERParameterSpec(SABERParameters.firesaberkem128r3);
    public static final SABERParameterSpec lightsaberkem192r3 = new SABERParameterSpec(SABERParameters.lightsaberkem192r3);
    public static final SABERParameterSpec saberkem192r3 = new SABERParameterSpec(SABERParameters.saberkem192r3);
    public static final SABERParameterSpec firesaberkem192r3 = new SABERParameterSpec(SABERParameters.firesaberkem192r3);
    public static final SABERParameterSpec lightsaberkem256r3 = new SABERParameterSpec(SABERParameters.lightsaberkem256r3);
    public static final SABERParameterSpec saberkem256r3 = new SABERParameterSpec(SABERParameters.saberkem256r3);
    public static final SABERParameterSpec firesaberkem256r3 = new SABERParameterSpec(SABERParameters.firesaberkem256r3);
    private static Map parameters = new HashMap();

    private SABERParameterSpec(SABERParameters sABERParameters) {
        this.f23917name = sABERParameters.m17809getName();
    }

    public static SABERParameterSpec fromName(String str) {
        return (SABERParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18053getName() {
        return this.f23917name;
    }
}
