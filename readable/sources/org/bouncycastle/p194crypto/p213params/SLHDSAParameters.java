package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine;

/* loaded from: classes2.dex */
public class SLHDSAParameters {
    public static final int TYPE_PURE = 0;
    public static final int TYPE_SHA2_256 = 1;
    public static final int TYPE_SHA2_512 = 2;
    public static final int TYPE_SHAKE128 = 3;
    public static final int TYPE_SHAKE256 = 4;
    private final SLHDSAEngineProvider engineProvider;

    /* renamed from: name */
    private final String f20840name;
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
        SLHDSAEngine mo15818get();

        /* renamed from: getN */
        int mo15819getN();
    }

    public static class Sha2EngineProvider implements SLHDSAEngineProvider {

        /* renamed from: a */
        private final int f20841a;

        /* renamed from: d */
        private final int f20842d;

        /* renamed from: h */
        private final int f20843h;

        /* renamed from: k */
        private final int f20844k;

        /* renamed from: n */
        private final int f20845n;

        /* renamed from: w */
        private final int f20846w;

        public Sha2EngineProvider(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f20845n = i;
            this.f20846w = i2;
            this.f20842d = i3;
            this.f20841a = i4;
            this.f20844k = i5;
            this.f20843h = i6;
        }

        @Override // org.bouncycastle.crypto.params.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: get */
        public SLHDSAEngine mo15818get() {
            return new SLHDSAEngine.Sha2Engine(this.f20845n, this.f20846w, this.f20842d, this.f20841a, this.f20844k, this.f20843h);
        }

        @Override // org.bouncycastle.crypto.params.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: getN */
        public int mo15819getN() {
            return this.f20845n;
        }
    }

    public static class Shake256EngineProvider implements SLHDSAEngineProvider {

        /* renamed from: a */
        private final int f20847a;

        /* renamed from: d */
        private final int f20848d;

        /* renamed from: h */
        private final int f20849h;

        /* renamed from: k */
        private final int f20850k;

        /* renamed from: n */
        private final int f20851n;

        /* renamed from: w */
        private final int f20852w;

        public Shake256EngineProvider(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f20851n = i;
            this.f20852w = i2;
            this.f20848d = i3;
            this.f20847a = i4;
            this.f20850k = i5;
            this.f20849h = i6;
        }

        @Override // org.bouncycastle.crypto.params.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: get */
        public SLHDSAEngine mo15818get() {
            return new SLHDSAEngine.Shake256Engine(this.f20851n, this.f20852w, this.f20848d, this.f20847a, this.f20850k, this.f20849h);
        }

        @Override // org.bouncycastle.crypto.params.SLHDSAParameters.SLHDSAEngineProvider
        /* renamed from: getN */
        public int mo15819getN() {
            return this.f20851n;
        }
    }

    private SLHDSAParameters(String str, SLHDSAEngineProvider sLHDSAEngineProvider, int i) {
        this.f20840name = str;
        this.engineProvider = sLHDSAEngineProvider;
        this.preHashDigest = i;
    }

    public SLHDSAEngine getEngine() {
        return this.engineProvider.mo15818get();
    }

    /* renamed from: getN */
    public int m15815getN() {
        return this.engineProvider.mo15819getN();
    }

    /* renamed from: getName */
    public String m15816getName() {
        return this.f20840name;
    }

    /* renamed from: getType */
    public int m15817getType() {
        return this.preHashDigest;
    }

    public boolean isPreHash() {
        return this.preHashDigest != 0;
    }
}
