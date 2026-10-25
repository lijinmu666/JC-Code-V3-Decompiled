package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.internal.p231asn1.p236gnu.GNUObjectIdentifiers;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.p194crypto.p201engines.SerpentEngine;
import org.bouncycastle.p194crypto.p201engines.TnepresEngine;
import org.bouncycastle.p194crypto.p209macs.C5359GMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OFBBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent */
/* loaded from: classes2.dex */
public final class C5767Serpent {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Serpent IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC128 */
    public static class CBC128 extends BaseBlockCipher {
        public CBC128() {
            super(128, new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC192 */
    public static class CBC192 extends BaseBlockCipher {
        public CBC192() {
            super(192, new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CBC256 */
    public static class CBC256 extends BaseBlockCipher {
        public CBC256() {
            super(256, new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB */
    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB128 */
    public static class CFB128 extends BaseBlockCipher {
        public CFB128() {
            super(128, new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB192 */
    public static class CFB192 extends BaseBlockCipher {
        public CFB192() {
            super(192, new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$CFB256 */
    public static class CFB256 extends BaseBlockCipher {
        public CFB256() {
            super(256, new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Serpent.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SerpentEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB128 */
    public static class ECB128 extends BaseBlockCipher {
        public ECB128() {
            super(128, new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Serpent.ECB128.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SerpentEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB192 */
    public static class ECB192 extends BaseBlockCipher {
        public ECB192() {
            super(192, new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Serpent.ECB192.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SerpentEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$ECB256 */
    public static class ECB256 extends BaseBlockCipher {
        public ECB256() {
            super(256, new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Serpent.ECB256.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SerpentEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Serpent", 192, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21830PREFIX = C5767Serpent.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21830PREFIX;
            sb.append(str);
            sb.append("$ECB");
            configurableProvider.addAlgorithm("Cipher.Serpent", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.Serpent", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.Serpent", str + "$AlgParams");
            configurableProvider.addAlgorithm("Cipher.Tnepres", str + "$TECB");
            configurableProvider.addAlgorithm("KeyGenerator.Tnepres", str + "$TKeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.Tnepres", str + "$TAlgParams");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_128_ECB, str + "$ECB128");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_192_ECB, str + "$ECB192");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_256_ECB, str + "$ECB256");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_128_CBC, str + "$CBC128");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_192_CBC, str + "$CBC192");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_256_CBC, str + "$CBC256");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_128_CFB, str + "$CFB128");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_192_CFB, str + "$CFB192");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_256_CFB, str + "$CFB256");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_128_OFB, str + "$OFB128");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_192_OFB, str + "$OFB192");
            configurableProvider.addAlgorithm("Cipher", GNUObjectIdentifiers.Serpent_256_OFB, str + "$OFB256");
            addGMacAlgorithm(configurableProvider, "SERPENT", str + "$SerpentGMAC", str + "$KeyGen");
            addGMacAlgorithm(configurableProvider, "TNEPRES", str + "$TSerpentGMAC", str + "$TKeyGen");
            addPoly1305Algorithm(configurableProvider, "SERPENT", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB */
    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB128 */
    public static class OFB128 extends BaseBlockCipher {
        public OFB128() {
            super(128, new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB192 */
    public static class OFB192 extends BaseBlockCipher {
        public OFB192() {
            super(192, new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$OFB256 */
    public static class OFB256 extends BaseBlockCipher {
        public OFB256() {
            super(256, new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$Poly1305 */
    public static class Poly1305 extends C5789BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.p194crypto.p209macs.Poly1305(new SerpentEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$Poly1305KeyGen */
    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Serpent", 256, new Poly1305KeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$SerpentGMAC */
    public static class SerpentGMAC extends C5789BaseMac {
        public SerpentGMAC() {
            super(new C5359GMac(GCMBlockCipher.newInstance(new SerpentEngine())));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$TAlgParams */
    public static class TAlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Tnepres IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$TECB */
    public static class TECB extends BaseBlockCipher {
        public TECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Serpent.TECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new TnepresEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$TKeyGen */
    public static class TKeyGen extends BaseKeyGenerator {
        public TKeyGen() {
            super("Tnepres", 192, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Serpent$TSerpentGMAC */
    public static class TSerpentGMAC extends C5789BaseMac {
        public TSerpentGMAC() {
            super(new C5359GMac(GCMBlockCipher.newInstance(new TnepresEngine())));
        }
    }

    private C5767Serpent() {
    }
}
