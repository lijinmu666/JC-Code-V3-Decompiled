package org.bouncycastle.p314pqc.p334jcajce.p351spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SPHINCSPlusParameterSpec implements AlgorithmParameterSpec {
    public static final SPHINCSPlusParameterSpec haraka_128f;
    public static final SPHINCSPlusParameterSpec haraka_128f_simple;
    public static final SPHINCSPlusParameterSpec haraka_128s;
    public static final SPHINCSPlusParameterSpec haraka_128s_simple;
    public static final SPHINCSPlusParameterSpec haraka_192f;
    public static final SPHINCSPlusParameterSpec haraka_192f_simple;
    public static final SPHINCSPlusParameterSpec haraka_192s;
    public static final SPHINCSPlusParameterSpec haraka_192s_simple;
    public static final SPHINCSPlusParameterSpec haraka_256f;
    public static final SPHINCSPlusParameterSpec haraka_256f_simple;
    public static final SPHINCSPlusParameterSpec haraka_256s;
    public static final SPHINCSPlusParameterSpec haraka_256s_simple;
    private static Map parameters;
    public static final SPHINCSPlusParameterSpec sha2_128f;
    public static final SPHINCSPlusParameterSpec sha2_128f_robust;
    public static final SPHINCSPlusParameterSpec sha2_128s;
    public static final SPHINCSPlusParameterSpec sha2_128s_robust;
    public static final SPHINCSPlusParameterSpec sha2_192f;
    public static final SPHINCSPlusParameterSpec sha2_192f_robust;
    public static final SPHINCSPlusParameterSpec sha2_192s;
    public static final SPHINCSPlusParameterSpec sha2_192s_robust;
    public static final SPHINCSPlusParameterSpec sha2_256f;
    public static final SPHINCSPlusParameterSpec sha2_256f_robust;
    public static final SPHINCSPlusParameterSpec sha2_256s;
    public static final SPHINCSPlusParameterSpec sha2_256s_robust;
    public static final SPHINCSPlusParameterSpec shake_128f;
    public static final SPHINCSPlusParameterSpec shake_128f_robust;
    public static final SPHINCSPlusParameterSpec shake_128s;
    public static final SPHINCSPlusParameterSpec shake_128s_robust;
    public static final SPHINCSPlusParameterSpec shake_192f;
    public static final SPHINCSPlusParameterSpec shake_192f_robust;
    public static final SPHINCSPlusParameterSpec shake_192s;
    public static final SPHINCSPlusParameterSpec shake_192s_robust;
    public static final SPHINCSPlusParameterSpec shake_256f;
    public static final SPHINCSPlusParameterSpec shake_256f_robust;
    public static final SPHINCSPlusParameterSpec shake_256s;
    public static final SPHINCSPlusParameterSpec shake_256s_robust;

    /* renamed from: name */
    private final String f23919name;

    static {
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec = new SPHINCSPlusParameterSpec("sha2-128f-robust");
        sha2_128f_robust = sPHINCSPlusParameterSpec;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec2 = new SPHINCSPlusParameterSpec("sha2-128s-robust");
        sha2_128s_robust = sPHINCSPlusParameterSpec2;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec3 = new SPHINCSPlusParameterSpec("sha2-192f-robust");
        sha2_192f_robust = sPHINCSPlusParameterSpec3;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec4 = new SPHINCSPlusParameterSpec("sha2-192s-robust");
        sha2_192s_robust = sPHINCSPlusParameterSpec4;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec5 = new SPHINCSPlusParameterSpec("sha2-256f-robust");
        sha2_256f_robust = sPHINCSPlusParameterSpec5;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec6 = new SPHINCSPlusParameterSpec("sha2-256s-robust");
        sha2_256s_robust = sPHINCSPlusParameterSpec6;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec7 = new SPHINCSPlusParameterSpec("sha2-128f");
        sha2_128f = sPHINCSPlusParameterSpec7;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec8 = new SPHINCSPlusParameterSpec("sha2-128s");
        sha2_128s = sPHINCSPlusParameterSpec8;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec9 = new SPHINCSPlusParameterSpec("sha2-192f");
        sha2_192f = sPHINCSPlusParameterSpec9;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec10 = new SPHINCSPlusParameterSpec("sha2-192s");
        sha2_192s = sPHINCSPlusParameterSpec10;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec11 = new SPHINCSPlusParameterSpec("sha2-256f");
        sha2_256f = sPHINCSPlusParameterSpec11;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec12 = new SPHINCSPlusParameterSpec("sha2-256s");
        sha2_256s = sPHINCSPlusParameterSpec12;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec13 = new SPHINCSPlusParameterSpec("shake-128f-robust");
        shake_128f_robust = sPHINCSPlusParameterSpec13;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec14 = new SPHINCSPlusParameterSpec("shake-128s-robust");
        shake_128s_robust = sPHINCSPlusParameterSpec14;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec15 = new SPHINCSPlusParameterSpec("shake-192f-robust");
        shake_192f_robust = sPHINCSPlusParameterSpec15;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec16 = new SPHINCSPlusParameterSpec("shake-192s-robust");
        shake_192s_robust = sPHINCSPlusParameterSpec16;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec17 = new SPHINCSPlusParameterSpec("shake-256f-robust");
        shake_256f_robust = sPHINCSPlusParameterSpec17;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec18 = new SPHINCSPlusParameterSpec("shake-256s-robust");
        shake_256s_robust = sPHINCSPlusParameterSpec18;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec19 = new SPHINCSPlusParameterSpec("shake-128f");
        shake_128f = sPHINCSPlusParameterSpec19;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec20 = new SPHINCSPlusParameterSpec("shake-128s");
        shake_128s = sPHINCSPlusParameterSpec20;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec21 = new SPHINCSPlusParameterSpec("shake-192f");
        shake_192f = sPHINCSPlusParameterSpec21;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec22 = new SPHINCSPlusParameterSpec("shake-192s");
        shake_192s = sPHINCSPlusParameterSpec22;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec23 = new SPHINCSPlusParameterSpec("shake-256f");
        shake_256f = sPHINCSPlusParameterSpec23;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec24 = new SPHINCSPlusParameterSpec("shake-256s");
        shake_256s = sPHINCSPlusParameterSpec24;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec25 = new SPHINCSPlusParameterSpec("haraka-128f-robust");
        haraka_128f = sPHINCSPlusParameterSpec25;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec26 = new SPHINCSPlusParameterSpec("haraka-128s-robust");
        haraka_128s = sPHINCSPlusParameterSpec26;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec27 = new SPHINCSPlusParameterSpec("haraka-256f-robust");
        haraka_256f = sPHINCSPlusParameterSpec27;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec28 = new SPHINCSPlusParameterSpec("haraka-256s-robust");
        haraka_256s = sPHINCSPlusParameterSpec28;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec29 = new SPHINCSPlusParameterSpec("haraka-192f-robust");
        haraka_192f = sPHINCSPlusParameterSpec29;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec30 = new SPHINCSPlusParameterSpec("haraka-192s-robust");
        haraka_192s = sPHINCSPlusParameterSpec30;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec31 = new SPHINCSPlusParameterSpec("haraka-128f-simple");
        haraka_128f_simple = sPHINCSPlusParameterSpec31;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec32 = new SPHINCSPlusParameterSpec("haraka-128s-simple");
        haraka_128s_simple = sPHINCSPlusParameterSpec32;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec33 = new SPHINCSPlusParameterSpec("haraka-192f-simple");
        haraka_192f_simple = sPHINCSPlusParameterSpec33;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec34 = new SPHINCSPlusParameterSpec("haraka-192s-simple");
        haraka_192s_simple = sPHINCSPlusParameterSpec34;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec35 = new SPHINCSPlusParameterSpec("haraka-256f-simple");
        haraka_256f_simple = sPHINCSPlusParameterSpec35;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec36 = new SPHINCSPlusParameterSpec("haraka-256s-simple");
        haraka_256s_simple = sPHINCSPlusParameterSpec36;
        HashMap map = new HashMap();
        parameters = map;
        map.put(sPHINCSPlusParameterSpec.m18055getName(), sPHINCSPlusParameterSpec);
        parameters.put(sPHINCSPlusParameterSpec2.m18055getName(), sPHINCSPlusParameterSpec2);
        parameters.put(sPHINCSPlusParameterSpec3.m18055getName(), sPHINCSPlusParameterSpec3);
        parameters.put(sPHINCSPlusParameterSpec4.m18055getName(), sPHINCSPlusParameterSpec4);
        parameters.put(sPHINCSPlusParameterSpec5.m18055getName(), sPHINCSPlusParameterSpec5);
        parameters.put(sPHINCSPlusParameterSpec6.m18055getName(), sPHINCSPlusParameterSpec6);
        parameters.put(sPHINCSPlusParameterSpec7.m18055getName(), sPHINCSPlusParameterSpec7);
        parameters.put(sPHINCSPlusParameterSpec8.m18055getName(), sPHINCSPlusParameterSpec8);
        parameters.put(sPHINCSPlusParameterSpec9.m18055getName(), sPHINCSPlusParameterSpec9);
        parameters.put(sPHINCSPlusParameterSpec10.m18055getName(), sPHINCSPlusParameterSpec10);
        parameters.put(sPHINCSPlusParameterSpec11.m18055getName(), sPHINCSPlusParameterSpec11);
        parameters.put(sPHINCSPlusParameterSpec12.m18055getName(), sPHINCSPlusParameterSpec12);
        parameters.put("sha2-128f", sPHINCSPlusParameterSpec7);
        parameters.put("sha2-128s", sPHINCSPlusParameterSpec8);
        parameters.put("sha2-192f", sPHINCSPlusParameterSpec9);
        parameters.put("sha2-192s", sPHINCSPlusParameterSpec10);
        parameters.put("sha2-256f", sPHINCSPlusParameterSpec11);
        parameters.put("sha2-256s", sPHINCSPlusParameterSpec12);
        parameters.put(sPHINCSPlusParameterSpec13.m18055getName(), sPHINCSPlusParameterSpec13);
        parameters.put(sPHINCSPlusParameterSpec14.m18055getName(), sPHINCSPlusParameterSpec14);
        parameters.put(sPHINCSPlusParameterSpec15.m18055getName(), sPHINCSPlusParameterSpec15);
        parameters.put(sPHINCSPlusParameterSpec16.m18055getName(), sPHINCSPlusParameterSpec16);
        parameters.put(sPHINCSPlusParameterSpec17.m18055getName(), sPHINCSPlusParameterSpec17);
        parameters.put(sPHINCSPlusParameterSpec18.m18055getName(), sPHINCSPlusParameterSpec18);
        parameters.put(sPHINCSPlusParameterSpec19.m18055getName(), sPHINCSPlusParameterSpec19);
        parameters.put(sPHINCSPlusParameterSpec20.m18055getName(), sPHINCSPlusParameterSpec20);
        parameters.put(sPHINCSPlusParameterSpec21.m18055getName(), sPHINCSPlusParameterSpec21);
        parameters.put(sPHINCSPlusParameterSpec22.m18055getName(), sPHINCSPlusParameterSpec22);
        parameters.put(sPHINCSPlusParameterSpec23.m18055getName(), sPHINCSPlusParameterSpec23);
        parameters.put(sPHINCSPlusParameterSpec24.m18055getName(), sPHINCSPlusParameterSpec24);
        parameters.put("shake-128f", sPHINCSPlusParameterSpec19);
        parameters.put("shake-128s", sPHINCSPlusParameterSpec20);
        parameters.put("shake-192f", sPHINCSPlusParameterSpec21);
        parameters.put("shake-192s", sPHINCSPlusParameterSpec22);
        parameters.put("shake-256f", sPHINCSPlusParameterSpec23);
        parameters.put("shake-256s", sPHINCSPlusParameterSpec24);
        parameters.put(sPHINCSPlusParameterSpec25.m18055getName(), sPHINCSPlusParameterSpec25);
        parameters.put(sPHINCSPlusParameterSpec26.m18055getName(), sPHINCSPlusParameterSpec26);
        parameters.put(sPHINCSPlusParameterSpec29.m18055getName(), sPHINCSPlusParameterSpec29);
        parameters.put(sPHINCSPlusParameterSpec30.m18055getName(), sPHINCSPlusParameterSpec30);
        parameters.put(sPHINCSPlusParameterSpec27.m18055getName(), sPHINCSPlusParameterSpec27);
        parameters.put(sPHINCSPlusParameterSpec28.m18055getName(), sPHINCSPlusParameterSpec28);
        parameters.put(sPHINCSPlusParameterSpec31.m18055getName(), sPHINCSPlusParameterSpec31);
        parameters.put(sPHINCSPlusParameterSpec32.m18055getName(), sPHINCSPlusParameterSpec32);
        parameters.put(sPHINCSPlusParameterSpec33.m18055getName(), sPHINCSPlusParameterSpec33);
        parameters.put(sPHINCSPlusParameterSpec34.m18055getName(), sPHINCSPlusParameterSpec34);
        parameters.put(sPHINCSPlusParameterSpec35.m18055getName(), sPHINCSPlusParameterSpec35);
        parameters.put(sPHINCSPlusParameterSpec36.m18055getName(), sPHINCSPlusParameterSpec36);
    }

    private SPHINCSPlusParameterSpec(String str) {
        this.f23919name = str;
    }

    public static SPHINCSPlusParameterSpec fromName(String str) {
        return (SPHINCSPlusParameterSpec) parameters.get(C6250Strings.toLowerCase(str));
    }

    /* renamed from: getName */
    public String m18055getName() {
        return this.f23919name;
    }
}
