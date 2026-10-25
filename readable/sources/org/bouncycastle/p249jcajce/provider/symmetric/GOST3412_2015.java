package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.GOST3412_2015Engine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p210modes.G3413CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.G3413CFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.G3413CTRBlockCipher;
import org.bouncycastle.p194crypto.p210modes.G3413OFBBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* loaded from: classes2.dex */
public class GOST3412_2015 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$CBC */
    public static class C5739CBC extends BaseBlockCipher {
        public C5739CBC() {
            super((BlockCipher) new G3413CBCBlockCipher(new GOST3412_2015Engine()), false, 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$CTR */
    public static class C5740CTR extends BaseBlockCipher {
        public C5740CTR() {
            super(new BufferedBlockCipher(new G3413CTRBlockCipher(new GOST3412_2015Engine())), true, 64);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$ECB */
    public static class C5741ECB extends BaseBlockCipher {
        public C5741ECB() {
            super(new GOST3412_2015Engine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$GCFB */
    public static class C5742GCFB extends BaseBlockCipher {
        public C5742GCFB() {
            super(new BufferedBlockCipher(new G3413CFBBlockCipher(new GOST3412_2015Engine())), false, 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$GCFB8 */
    public static class C5743GCFB8 extends BaseBlockCipher {
        public C5743GCFB8() {
            super(new BufferedBlockCipher(new G3413CFBBlockCipher(new GOST3412_2015Engine(), 8)), false, 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$KeyGen */
    public static class C5744KeyGen extends BaseKeyGenerator {
        public C5744KeyGen() {
            this(256);
        }

        public C5744KeyGen(int i) {
            super("GOST3412-2015", i, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$Mac */
    public static class C5745Mac extends C5789BaseMac {
        public C5745Mac() {
            super(new C5358CMac(new GOST3412_2015Engine()));
        }
    }

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21797PREFIX = GOST3412_2015.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21797PREFIX;
            sb.append(str);
            sb.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015", sb.toString());
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015/CFB", str + "$GCFB");
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015/CFB8", str + "$GCFB8");
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015/OFB", str + "$OFB");
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015/CBC", str + "$CBC");
            configurableProvider.addAlgorithm("Cipher.GOST3412-2015/CTR", str + "$CTR");
            configurableProvider.addAlgorithm("KeyGenerator.GOST3412-2015", str + "$KeyGen");
            configurableProvider.addAlgorithm("Mac.GOST3412MAC", str + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.GOST3412-2015", "GOST3412MAC");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.GOST3412_2015$OFB */
    public static class C5746OFB extends BaseBlockCipher {
        public C5746OFB() {
            super(new BufferedBlockCipher(new G3413OFBBlockCipher(new GOST3412_2015Engine())), false, 128);
        }
    }
}
