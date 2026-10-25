package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSAParameters {
    public static final int TYPE_PURE = 0;
    public static final int TYPE_SHA2_256 = 1;
    public static final int TYPE_SHA2_512 = 2;
    public static final int TYPE_SHAKE128 = 3;
    public static final int TYPE_SHAKE256 = 4;
    private final SLHDSAEngineProvider engineProvider;

    /* renamed from: name */
    private final String f23506name;
    private final int preHashDigest;
    public static final SLHDSAParameters sha2_128f = new SLHDSAParameters("sha2-128f", new Sha2EngineProvider(16, 16, 22, 6, 33, 66), 0);
    public static final SLHDSAParameters sha2_128s = new SLHDSAParameters("sha2-128s", new Sha2EngineProvider(16, 16, 7, 12, 14, 63), 0);
    public static final SLHDSAParameters sha2_192f = new SLHDSAParameters("sha2-192f", new Sha2EngineProvider(24, 16, 22, 8, 33, 66), 0);
    public static final SLHDSAParameters sha2_192s = new SLHDSAParameters("sha2-192s", new Sha2EngineProvider(24, 16, 7, 14, 17, 63), 0);
    public static final SLHDSAParameters sha2_256f = new SLHDSAParameters("sha2-256f", new Sha2EngineProvider(32, 16, 17, 9, 35, 68), 0);
    public static final SLHDSAParameters sha2_256s = new SLHDSAParameters("sha2-256s", new Sha2EngineProvider(32, 16, 8, 14, 22, 64), 0);
    public static final SLHDSAParameters shake_128f = new SLHDSAParameters("shake-128f", new Shake256EngineProvider(16, 16, 22, 6, 33, 66), 0);
    public static final SLHDSAParameters shake_128s = new SLHDSAParameters("shake-128s", new Shake256EngineProvider(16, 16, 7, 12, 14, 63), 0);
    public static final SLHDSAParameters shake_192f = new SLHDSAParameters("shake-192f", new Shake256EngineProvider(24, 16, 22, 8, 33, 66), 0);
    public static final SLHDSAParameters shake_192s = new SLHDSAParameters("shake-192s", new Shake256EngineProvider(24, 16, 7, 14, 17, 63), 0);
    public static final SLHDSAParameters shake_256f = new SLHDSAParameters("shake-256f", new Shake256EngineProvider(32, 16, 17, 9, 35, 68), 0);
    public static final SLHDSAParameters shake_256s = new SLHDSAParameters("shake-256s", new Shake256EngineProvider(32, 16, 8, 14, 22, 64), 0);
    public static final SLHDSAParameters sha2_128f_with_sha256 = new SLHDSAParameters("sha2-128f-with-sha256", new Sha2EngineProvider(16, 16, 22, 6, 33, 66), 1);
    public static final SLHDSAParameters sha2_128s_with_sha256 = new SLHDSAParameters("sha2-128s-with-sha256", new Sha2EngineProvider(16, 16, 7, 12, 14, 63), 1);
    public static final SLHDSAParameters sha2_192f_with_sha512 = new SLHDSAParameters("sha2-192f-with-sha512", new Sha2EngineProvider(24, 16, 22, 8, 33, 66), 2);
    public static final SLHDSAParameters sha2_192s_with_sha512 = new SLHDSAParameters("sha2-192s-with-sha512", new Sha2EngineProvider(24, 16, 7, 14, 17, 63), 2);
    public static final SLHDSAParameters sha2_256f_with_sha512 = new SLHDSAParameters("sha2-256f-with-sha512", new Sha2EngineProvider(32, 16, 17, 9, 35, 68), 2);
    public static final SLHDSAParameters sha2_256s_with_sha512 = new SLHDSAParameters("sha2-256s-with-sha512", new Sha2EngineProvider(32, 16, 8, 14, 22, 64), 2);
    public static final SLHDSAParameters shake_128f_with_shake128 = new SLHDSAParameters("shake-128f-with-shake128", new Shake256EngineProvider(16, 16, 22, 6, 33, 66), 3);
    public static final SLHDSAParameters shake_128s_with_shake128 = new SLHDSAParameters("shake-128s-with-shake128", new Shake256EngineProvider(16, 16, 7, 12, 14, 63), 3);
    public static final SLHDSAParameters shake_192f_with_shake256 = new SLHDSAParameters("shake-192f-with-shake256", new Shake256EngineProvider(24, 16, 22, 8, 33, 66), 4);
    public static final SLHDSAParameters shake_192s_with_shake256 = new SLHDSAParameters("shake-192s-with-shake256", new Shake256EngineProvider(24, 16, 7, 14, 17, 63), 4);
    public static final SLHDSAParameters shake_256f_with_shake256 = new SLHDSAParameters("shake-256f-with-shake256", new Shake256EngineProvider(32, 16, 17, 9, 35, 68), 4);
    public static final SLHDSAParameters shake_256s_with_shake256 = new SLHDSAParameters("shake-256s-with-shake256", new Shake256EngineProvider(32, 16, 8, 14, 22, 64), 4);

    public interface SLHDSAEngineProvider {
        /* renamed from: get */
        SLHDSAEngine mo17839get();

        /* renamed from: getN */
        int mo17840getN();
    }

    public static class Sha2EngineProvider implements SLHDSAEngineProvider {

        /* renamed from: a */
        private final int f23507a;

        /* renamed from: d */
        private final int f23508d;

        /* renamed from: h */
        private final int f23509h;

        /* renamed from: k */
        private final int f23510k;

        /* renamed from: n */
        private final int f23511n;

        /* renamed from: w */
        private final int f23512w;

        public Sha2EngineProvider(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f23511n = i;
            this.f23512w = i2;
            this.f23508d = i3;
            this.f23507a = i4;
            this.f23510k = i5;
            this.f23509h = i6;
        }

        @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: get */
        public SLHDSAEngine mo17839get() {
            return new SLHDSAEngine.Sha2Engine(this.f23511n, this.f23512w, this.f23508d, this.f23507a, this.f23510k, this.f23509h);
        }

        @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: getN */
        public int mo17840getN() {
            return this.f23511n;
        }
    }

    public static class Shake256EngineProvider implements SLHDSAEngineProvider {

        /* renamed from: a */
        private final int f23513a;

        /* renamed from: d */
        private final int f23514d;

        /* renamed from: h */
        private final int f23515h;

        /* renamed from: k */
        private final int f23516k;

        /* renamed from: n */
        private final int f23517n;

        /* renamed from: w */
        private final int f23518w;

        public Shake256EngineProvider(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f23517n = i;
            this.f23518w = i2;
            this.f23514d = i3;
            this.f23513a = i4;
            this.f23516k = i5;
            this.f23515h = i6;
        }

        @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: get */
        public SLHDSAEngine mo17839get() {
            return new SLHDSAEngine.Shake256Engine(this.f23517n, this.f23518w, this.f23514d, this.f23513a, this.f23516k, this.f23515h);
        }

        @Override // org.bouncycastle.pqc.crypto.slhdsa.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: getN */
        public int mo17840getN() {
            return this.f23517n;
        }
    }

    private SLHDSAParameters(String str, SLHDSAEngineProvider sLHDSAEngineProvider, int i) {
        this.f23506name = str;
        this.engineProvider = sLHDSAEngineProvider;
        this.preHashDigest = i;
    }

    public SLHDSAEngine getEngine() {
        return this.engineProvider.mo17839get();
    }

    /* renamed from: getN */
    public int m17836getN() {
        return this.engineProvider.mo17840getN();
    }

    /* renamed from: getName */
    public String m17837getName() {
        return this.f23506name;
    }

    /* renamed from: getType */
    public int m17838getType() {
        return this.preHashDigest;
    }

    public boolean isPreHash() {
        return this.preHashDigest != 0;
    }
}
