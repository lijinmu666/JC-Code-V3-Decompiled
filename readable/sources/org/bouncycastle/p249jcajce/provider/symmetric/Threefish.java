package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.ThreefishEngine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* loaded from: classes2.dex */
public final class Threefish {

    public static class AlgParams_1024 extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-1024 IV";
        }
    }

    public static class AlgParams_256 extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-256 IV";
        }
    }

    public static class AlgParams_512 extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-512 IV";
        }
    }

    public static class CMAC_1024 extends C5789BaseMac {
        public CMAC_1024() {
            super(new C5358CMac(new ThreefishEngine(1024)));
        }
    }

    public static class CMAC_256 extends C5789BaseMac {
        public CMAC_256() {
            super(new C5358CMac(new ThreefishEngine(256)));
        }
    }

    public static class CMAC_512 extends C5789BaseMac {
        public CMAC_512() {
            super(new C5358CMac(new ThreefishEngine(512)));
        }
    }

    public static class ECB_1024 extends BaseBlockCipher {
        public ECB_1024() {
            super(new ThreefishEngine(1024));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Threefish$ECB_256 */
    public static class C5779ECB_256 extends BaseBlockCipher {
        public C5779ECB_256() {
            super(new ThreefishEngine(256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Threefish$ECB_512 */
    public static class C5780ECB_512 extends BaseBlockCipher {
        public C5780ECB_512() {
            super(new ThreefishEngine(512));
        }
    }

    public static class KeyGen_1024 extends BaseKeyGenerator {
        public KeyGen_1024() {
            super("Threefish-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_256 extends BaseKeyGenerator {
        public KeyGen_256() {
            super("Threefish-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_512 extends BaseKeyGenerator {
        public KeyGen_512() {
            super("Threefish-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21838PREFIX = Threefish.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21838PREFIX;
            sb.append(str);
            sb.append("$CMAC_256");
            configurableProvider.addAlgorithm("Mac.Threefish-256CMAC", sb.toString());
            configurableProvider.addAlgorithm("Mac.Threefish-512CMAC", str + "$CMAC_512");
            configurableProvider.addAlgorithm("Mac.Threefish-1024CMAC", str + "$CMAC_1024");
            configurableProvider.addAlgorithm("Cipher.Threefish-256", str + "$ECB_256");
            configurableProvider.addAlgorithm("Cipher.Threefish-512", str + "$ECB_512");
            configurableProvider.addAlgorithm("Cipher.Threefish-1024", str + "$ECB_1024");
            configurableProvider.addAlgorithm("KeyGenerator.Threefish-256", str + "$KeyGen_256");
            configurableProvider.addAlgorithm("KeyGenerator.Threefish-512", str + "$KeyGen_512");
            configurableProvider.addAlgorithm("KeyGenerator.Threefish-1024", str + "$KeyGen_1024");
            configurableProvider.addAlgorithm("AlgorithmParameters.Threefish-256", str + "$AlgParams_256");
            configurableProvider.addAlgorithm("AlgorithmParameters.Threefish-512", str + "$AlgParams_512");
            configurableProvider.addAlgorithm("AlgorithmParameters.Threefish-1024", str + "$AlgParams_1024");
        }
    }

    private Threefish() {
    }
}
