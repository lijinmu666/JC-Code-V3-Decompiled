package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.Zuc128Engine;
import org.bouncycastle.p194crypto.p201engines.Zuc256Engine;
import org.bouncycastle.p194crypto.p209macs.Zuc128Mac;
import org.bouncycastle.p194crypto.p209macs.Zuc256Mac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseStreamCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc */
/* loaded from: classes2.dex */
public class C5788Zuc {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Zuc IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$KeyGen128 */
    public static class KeyGen128 extends BaseKeyGenerator {
        public KeyGen128() {
            super("ZUC128", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$KeyGen256 */
    public static class KeyGen256 extends BaseKeyGenerator {
        public KeyGen256() {
            super("ZUC256", 256, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21844PREFIX = C5788Zuc.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21844PREFIX;
            sb.append(str);
            sb.append("$Zuc128");
            configurableProvider.addAlgorithm("Cipher.ZUC-128", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.ZUC-128", str + "$KeyGen128");
            configurableProvider.addAlgorithm("AlgorithmParameters.ZUC-128", str + "$AlgParams");
            configurableProvider.addAlgorithm("Cipher.ZUC-256", str + "$Zuc256");
            configurableProvider.addAlgorithm("KeyGenerator.ZUC-256", str + "$KeyGen256");
            configurableProvider.addAlgorithm("AlgorithmParameters.ZUC-256", str + "$AlgParams");
            configurableProvider.addAlgorithm("Mac.ZUC-128", str + "$ZucMac128");
            configurableProvider.addAlgorithm("Mac.ZUC-256", str + "$ZucMac256");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.ZUC-256-128", "ZUC-256");
            configurableProvider.addAlgorithm("Mac.ZUC-256-64", str + "$ZucMac256_64");
            configurableProvider.addAlgorithm("Mac.ZUC-256-32", str + "$ZucMac256_32");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$Zuc128 */
    public static class Zuc128 extends BaseStreamCipher {
        public Zuc128() {
            super(new Zuc128Engine(), 16, 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$Zuc256 */
    public static class Zuc256 extends BaseStreamCipher {
        public Zuc256() {
            super(new Zuc256Engine(), 25, 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$ZucMac128 */
    public static class ZucMac128 extends C5789BaseMac {
        public ZucMac128() {
            super(new Zuc128Mac());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$ZucMac256 */
    public static class ZucMac256 extends C5789BaseMac {
        public ZucMac256() {
            super(new Zuc256Mac(128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$ZucMac256_32 */
    public static class ZucMac256_32 extends C5789BaseMac {
        public ZucMac256_32() {
            super(new Zuc256Mac(32));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Zuc$ZucMac256_64 */
    public static class ZucMac256_64 extends C5789BaseMac {
        public ZucMac256_64() {
            super(new Zuc256Mac(64));
        }
    }

    private C5788Zuc() {
    }
}
