package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class SPHINCSPlusParameters {
    private static final Map<Integer, SPHINCSPlusParameters> ID_TO_PARAMS;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_128f;
    public static final SPHINCSPlusParameters haraka_128f_simple;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_128s;
    public static final SPHINCSPlusParameters haraka_128s_simple;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_192f;
    public static final SPHINCSPlusParameters haraka_192f_simple;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_192s;
    public static final SPHINCSPlusParameters haraka_192s_simple;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_256f;
    public static final SPHINCSPlusParameters haraka_256f_simple;

    @Deprecated
    public static final SPHINCSPlusParameters haraka_256s;
    public static final SPHINCSPlusParameters haraka_256s_simple;
    public static final SPHINCSPlusParameters sha2_128f;
    public static final SPHINCSPlusParameters sha2_128f_robust;
    public static final SPHINCSPlusParameters sha2_128s;
    public static final SPHINCSPlusParameters sha2_128s_robust;
    public static final SPHINCSPlusParameters sha2_192f;
    public static final SPHINCSPlusParameters sha2_192f_robust;
    public static final SPHINCSPlusParameters sha2_192s;
    public static final SPHINCSPlusParameters sha2_192s_robust;
    public static final SPHINCSPlusParameters sha2_256f;
    public static final SPHINCSPlusParameters sha2_256f_robust;
    public static final SPHINCSPlusParameters sha2_256s;
    public static final SPHINCSPlusParameters sha2_256s_robust;
    public static final SPHINCSPlusParameters shake_128f;
    public static final SPHINCSPlusParameters shake_128f_robust;
    public static final SPHINCSPlusParameters shake_128s;
    public static final SPHINCSPlusParameters shake_128s_robust;
    public static final SPHINCSPlusParameters shake_192f;
    public static final SPHINCSPlusParameters shake_192f_robust;
    public static final SPHINCSPlusParameters shake_192s;
    public static final SPHINCSPlusParameters shake_192s_robust;
    public static final SPHINCSPlusParameters shake_256f;
    public static final SPHINCSPlusParameters shake_256f_robust;
    public static final SPHINCSPlusParameters shake_256s;
    public static final SPHINCSPlusParameters shake_256s_robust;
    private final SPHINCSPlusEngineProvider engineProvider;

    /* renamed from: id */
    private final Integer f24110id;

    /* renamed from: name */
    private final String f24111name;

    public static class HarakaSEngineProvider implements SPHINCSPlusEngineProvider {

        /* renamed from: a */
        private final int f24112a;

        /* renamed from: d */
        private final int f24113d;

        /* renamed from: h */
        private final int f24114h;

        /* renamed from: k */
        private final int f24115k;

        /* renamed from: n */
        private final int f24116n;

        /* renamed from: robust */
        private final boolean f24117robust;

        /* renamed from: w */
        private final int f24118w;

        public HarakaSEngineProvider(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f24117robust = z;
            this.f24116n = i;
            this.f24118w = i2;
            this.f24113d = i3;
            this.f24112a = i4;
            this.f24115k = i5;
            this.f24114h = i6;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: get */
        public SPHINCSPlusEngine mo18169get() {
            return new SPHINCSPlusEngine.HarakaSEngine(this.f24117robust, this.f24116n, this.f24118w, this.f24113d, this.f24112a, this.f24115k, this.f24114h);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: getN */
        public int mo18170getN() {
            return this.f24116n;
        }
    }

    public static class Sha2EngineProvider implements SPHINCSPlusEngineProvider {

        /* renamed from: a */
        private final int f24119a;

        /* renamed from: d */
        private final int f24120d;

        /* renamed from: h */
        private final int f24121h;

        /* renamed from: k */
        private final int f24122k;

        /* renamed from: n */
        private final int f24123n;

        /* renamed from: robust */
        private final boolean f24124robust;

        /* renamed from: w */
        private final int f24125w;

        public Sha2EngineProvider(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f24124robust = z;
            this.f24123n = i;
            this.f24125w = i2;
            this.f24120d = i3;
            this.f24119a = i4;
            this.f24122k = i5;
            this.f24121h = i6;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: get */
        public SPHINCSPlusEngine mo18169get() {
            return new SPHINCSPlusEngine.Sha2Engine(this.f24124robust, this.f24123n, this.f24125w, this.f24120d, this.f24119a, this.f24122k, this.f24121h);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: getN */
        public int mo18170getN() {
            return this.f24123n;
        }
    }

    public static class Shake256EngineProvider implements SPHINCSPlusEngineProvider {

        /* renamed from: a */
        private final int f24126a;

        /* renamed from: d */
        private final int f24127d;

        /* renamed from: h */
        private final int f24128h;

        /* renamed from: k */
        private final int f24129k;

        /* renamed from: n */
        private final int f24130n;

        /* renamed from: robust */
        private final boolean f24131robust;

        /* renamed from: w */
        private final int f24132w;

        public Shake256EngineProvider(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f24131robust = z;
            this.f24130n = i;
            this.f24132w = i2;
            this.f24127d = i3;
            this.f24126a = i4;
            this.f24129k = i5;
            this.f24128h = i6;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: get */
        public SPHINCSPlusEngine mo18169get() {
            return new SPHINCSPlusEngine.Shake256Engine(this.f24131robust, this.f24130n, this.f24132w, this.f24127d, this.f24126a, this.f24129k, this.f24128h);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngineProvider
        /* renamed from: getN */
        public int mo18170getN() {
            return this.f24130n;
        }
    }

    static {
        SPHINCSPlusParameters sPHINCSPlusParameters = new SPHINCSPlusParameters(Integers.m18296valueOf(65793), "sha2-128f-robust", new Sha2EngineProvider(true, 16, 16, 22, 6, 33, 66));
        sha2_128f_robust = sPHINCSPlusParameters;
        SPHINCSPlusParameters sPHINCSPlusParameters2 = new SPHINCSPlusParameters(Integers.m18296valueOf(65794), "sha2-128s-robust", new Sha2EngineProvider(true, 16, 16, 7, 12, 14, 63));
        sha2_128s_robust = sPHINCSPlusParameters2;
        SPHINCSPlusParameters sPHINCSPlusParameters3 = new SPHINCSPlusParameters(Integers.m18296valueOf(65795), "sha2-192f-robust", new Sha2EngineProvider(true, 24, 16, 22, 8, 33, 66));
        sha2_192f_robust = sPHINCSPlusParameters3;
        SPHINCSPlusParameters sPHINCSPlusParameters4 = new SPHINCSPlusParameters(Integers.m18296valueOf(65796), "sha2-192s-robust", new Sha2EngineProvider(true, 24, 16, 7, 14, 17, 63));
        sha2_192s_robust = sPHINCSPlusParameters4;
        SPHINCSPlusParameters sPHINCSPlusParameters5 = new SPHINCSPlusParameters(Integers.m18296valueOf(65797), "sha2-256f-robust", new Sha2EngineProvider(true, 32, 16, 17, 9, 35, 68));
        sha2_256f_robust = sPHINCSPlusParameters5;
        SPHINCSPlusParameters sPHINCSPlusParameters6 = new SPHINCSPlusParameters(Integers.m18296valueOf(65798), "sha2-256s-robust", new Sha2EngineProvider(true, 32, 16, 8, 14, 22, 64));
        sha2_256s_robust = sPHINCSPlusParameters6;
        SPHINCSPlusParameters sPHINCSPlusParameters7 = new SPHINCSPlusParameters(Integers.m18296valueOf(66049), "sha2-128f", new Sha2EngineProvider(false, 16, 16, 22, 6, 33, 66));
        sha2_128f = sPHINCSPlusParameters7;
        SPHINCSPlusParameters sPHINCSPlusParameters8 = new SPHINCSPlusParameters(Integers.m18296valueOf(66050), "sha2-128s", new Sha2EngineProvider(false, 16, 16, 7, 12, 14, 63));
        sha2_128s = sPHINCSPlusParameters8;
        SPHINCSPlusParameters sPHINCSPlusParameters9 = new SPHINCSPlusParameters(Integers.m18296valueOf(66051), "sha2-192f", new Sha2EngineProvider(false, 24, 16, 22, 8, 33, 66));
        sha2_192f = sPHINCSPlusParameters9;
        SPHINCSPlusParameters sPHINCSPlusParameters10 = new SPHINCSPlusParameters(Integers.m18296valueOf(66052), "sha2-192s", new Sha2EngineProvider(false, 24, 16, 7, 14, 17, 63));
        sha2_192s = sPHINCSPlusParameters10;
        SPHINCSPlusParameters sPHINCSPlusParameters11 = new SPHINCSPlusParameters(Integers.m18296valueOf(66053), "sha2-256f", new Sha2EngineProvider(false, 32, 16, 17, 9, 35, 68));
        sha2_256f = sPHINCSPlusParameters11;
        SPHINCSPlusParameters sPHINCSPlusParameters12 = new SPHINCSPlusParameters(Integers.m18296valueOf(66054), "sha2-256s", new Sha2EngineProvider(false, 32, 16, 8, 14, 22, 64));
        sha2_256s = sPHINCSPlusParameters12;
        SPHINCSPlusParameters sPHINCSPlusParameters13 = new SPHINCSPlusParameters(Integers.m18296valueOf(131329), "shake-128f-robust", new Shake256EngineProvider(true, 16, 16, 22, 6, 33, 66));
        shake_128f_robust = sPHINCSPlusParameters13;
        SPHINCSPlusParameters sPHINCSPlusParameters14 = new SPHINCSPlusParameters(Integers.m18296valueOf(131330), "shake-128s-robust", new Shake256EngineProvider(true, 16, 16, 7, 12, 14, 63));
        shake_128s_robust = sPHINCSPlusParameters14;
        SPHINCSPlusParameters sPHINCSPlusParameters15 = new SPHINCSPlusParameters(Integers.m18296valueOf(131331), "shake-192f-robust", new Shake256EngineProvider(true, 24, 16, 22, 8, 33, 66));
        shake_192f_robust = sPHINCSPlusParameters15;
        SPHINCSPlusParameters sPHINCSPlusParameters16 = new SPHINCSPlusParameters(Integers.m18296valueOf(131332), "shake-192s-robust", new Shake256EngineProvider(true, 24, 16, 7, 14, 17, 63));
        shake_192s_robust = sPHINCSPlusParameters16;
        SPHINCSPlusParameters sPHINCSPlusParameters17 = new SPHINCSPlusParameters(Integers.m18296valueOf(131333), "shake-256f-robust", new Shake256EngineProvider(true, 32, 16, 17, 9, 35, 68));
        shake_256f_robust = sPHINCSPlusParameters17;
        SPHINCSPlusParameters sPHINCSPlusParameters18 = new SPHINCSPlusParameters(Integers.m18296valueOf(131334), "shake-256s-robust", new Shake256EngineProvider(true, 32, 16, 8, 14, 22, 64));
        shake_256s_robust = sPHINCSPlusParameters18;
        SPHINCSPlusParameters sPHINCSPlusParameters19 = new SPHINCSPlusParameters(Integers.m18296valueOf(131585), "shake-128f", new Shake256EngineProvider(false, 16, 16, 22, 6, 33, 66));
        shake_128f = sPHINCSPlusParameters19;
        SPHINCSPlusParameters sPHINCSPlusParameters20 = new SPHINCSPlusParameters(Integers.m18296valueOf(131586), "shake-128s", new Shake256EngineProvider(false, 16, 16, 7, 12, 14, 63));
        shake_128s = sPHINCSPlusParameters20;
        SPHINCSPlusParameters sPHINCSPlusParameters21 = new SPHINCSPlusParameters(Integers.m18296valueOf(131587), "shake-192f", new Shake256EngineProvider(false, 24, 16, 22, 8, 33, 66));
        shake_192f = sPHINCSPlusParameters21;
        SPHINCSPlusParameters sPHINCSPlusParameters22 = new SPHINCSPlusParameters(Integers.m18296valueOf(131588), "shake-192s", new Shake256EngineProvider(false, 24, 16, 7, 14, 17, 63));
        shake_192s = sPHINCSPlusParameters22;
        SPHINCSPlusParameters sPHINCSPlusParameters23 = new SPHINCSPlusParameters(Integers.m18296valueOf(131589), "shake-256f", new Shake256EngineProvider(false, 32, 16, 17, 9, 35, 68));
        shake_256f = sPHINCSPlusParameters23;
        SPHINCSPlusParameters sPHINCSPlusParameters24 = new SPHINCSPlusParameters(Integers.m18296valueOf(131590), "shake-256s", new Shake256EngineProvider(false, 32, 16, 8, 14, 22, 64));
        shake_256s = sPHINCSPlusParameters24;
        SPHINCSPlusParameters sPHINCSPlusParameters25 = new SPHINCSPlusParameters(Integers.m18296valueOf(196865), "haraka-128f-robust", new HarakaSEngineProvider(true, 16, 16, 22, 6, 33, 66));
        haraka_128f = sPHINCSPlusParameters25;
        SPHINCSPlusParameters sPHINCSPlusParameters26 = new SPHINCSPlusParameters(Integers.m18296valueOf(196866), "haraka-128s-robust", new HarakaSEngineProvider(true, 16, 16, 7, 12, 14, 63));
        haraka_128s = sPHINCSPlusParameters26;
        SPHINCSPlusParameters sPHINCSPlusParameters27 = new SPHINCSPlusParameters(Integers.m18296valueOf(196867), "haraka-192f-robust", new HarakaSEngineProvider(true, 24, 16, 22, 8, 33, 66));
        haraka_192f = sPHINCSPlusParameters27;
        SPHINCSPlusParameters sPHINCSPlusParameters28 = new SPHINCSPlusParameters(Integers.m18296valueOf(196868), "haraka-192s-robust", new HarakaSEngineProvider(true, 24, 16, 7, 14, 17, 63));
        haraka_192s = sPHINCSPlusParameters28;
        SPHINCSPlusParameters sPHINCSPlusParameters29 = new SPHINCSPlusParameters(Integers.m18296valueOf(196869), "haraka-256f-robust", new HarakaSEngineProvider(true, 32, 16, 17, 9, 35, 68));
        haraka_256f = sPHINCSPlusParameters29;
        SPHINCSPlusParameters sPHINCSPlusParameters30 = new SPHINCSPlusParameters(Integers.m18296valueOf(196870), "haraka-256s-robust", new HarakaSEngineProvider(true, 32, 16, 8, 14, 22, 64));
        haraka_256s = sPHINCSPlusParameters30;
        SPHINCSPlusParameters sPHINCSPlusParameters31 = new SPHINCSPlusParameters(Integers.m18296valueOf(197121), "haraka-128f-simple", new HarakaSEngineProvider(false, 16, 16, 22, 6, 33, 66));
        haraka_128f_simple = sPHINCSPlusParameters31;
        SPHINCSPlusParameters sPHINCSPlusParameters32 = new SPHINCSPlusParameters(Integers.m18296valueOf(197122), "haraka-128s-simple", new HarakaSEngineProvider(false, 16, 16, 7, 12, 14, 63));
        haraka_128s_simple = sPHINCSPlusParameters32;
        SPHINCSPlusParameters sPHINCSPlusParameters33 = new SPHINCSPlusParameters(Integers.m18296valueOf(197123), "haraka-192f-simple", new HarakaSEngineProvider(false, 24, 16, 22, 8, 33, 66));
        haraka_192f_simple = sPHINCSPlusParameters33;
        SPHINCSPlusParameters sPHINCSPlusParameters34 = new SPHINCSPlusParameters(Integers.m18296valueOf(197124), "haraka-192s-simple", new HarakaSEngineProvider(false, 24, 16, 7, 14, 17, 63));
        haraka_192s_simple = sPHINCSPlusParameters34;
        SPHINCSPlusParameters sPHINCSPlusParameters35 = new SPHINCSPlusParameters(Integers.m18296valueOf(197125), "haraka-256f-simple", new HarakaSEngineProvider(false, 32, 16, 17, 9, 35, 68));
        haraka_256f_simple = sPHINCSPlusParameters35;
        SPHINCSPlusParameters sPHINCSPlusParameters36 = new SPHINCSPlusParameters(Integers.m18296valueOf(197126), "haraka-256s-simple", new HarakaSEngineProvider(false, 32, 16, 8, 14, 22, 64));
        haraka_256s_simple = sPHINCSPlusParameters36;
        ID_TO_PARAMS = new HashMap();
        SPHINCSPlusParameters[] sPHINCSPlusParametersArr = {sPHINCSPlusParameters, sPHINCSPlusParameters2, sPHINCSPlusParameters3, sPHINCSPlusParameters4, sPHINCSPlusParameters5, sPHINCSPlusParameters6, sPHINCSPlusParameters7, sPHINCSPlusParameters8, sPHINCSPlusParameters9, sPHINCSPlusParameters10, sPHINCSPlusParameters11, sPHINCSPlusParameters12, sPHINCSPlusParameters13, sPHINCSPlusParameters14, sPHINCSPlusParameters15, sPHINCSPlusParameters16, sPHINCSPlusParameters17, sPHINCSPlusParameters18, sPHINCSPlusParameters19, sPHINCSPlusParameters20, sPHINCSPlusParameters21, sPHINCSPlusParameters22, sPHINCSPlusParameters23, sPHINCSPlusParameters24, sPHINCSPlusParameters25, sPHINCSPlusParameters26, sPHINCSPlusParameters27, sPHINCSPlusParameters28, sPHINCSPlusParameters29, sPHINCSPlusParameters30, sPHINCSPlusParameters31, sPHINCSPlusParameters32, sPHINCSPlusParameters33, sPHINCSPlusParameters34, sPHINCSPlusParameters35, sPHINCSPlusParameters36};
        for (int i = 0; i < 36; i++) {
            SPHINCSPlusParameters sPHINCSPlusParameters37 = sPHINCSPlusParametersArr[i];
            ID_TO_PARAMS.put(sPHINCSPlusParameters37.m18172getID(), sPHINCSPlusParameters37);
        }
    }

    private SPHINCSPlusParameters(Integer num, String str, SPHINCSPlusEngineProvider sPHINCSPlusEngineProvider) {
        this.f24110id = num;
        this.f24111name = str;
        this.engineProvider = sPHINCSPlusEngineProvider;
    }

    public static SPHINCSPlusParameters getParams(Integer num) {
        return ID_TO_PARAMS.get(num);
    }

    public byte[] getEncoded() {
        return AbstractC6245Pack.intToBigEndian(m18172getID().intValue());
    }

    public SPHINCSPlusEngine getEngine() {
        return this.engineProvider.mo18169get();
    }

    /* renamed from: getID */
    public Integer m18172getID() {
        return this.f24110id;
    }

    /* renamed from: getN */
    public int m18173getN() {
        return this.engineProvider.mo18170getN();
    }

    /* renamed from: getName */
    public String m18174getName() {
        return this.f24111name;
    }

    @Deprecated
    /* renamed from: getID */
    public static Integer m18171getID(SPHINCSPlusParameters sPHINCSPlusParameters) {
        return sPHINCSPlusParameters.m18172getID();
    }
}
