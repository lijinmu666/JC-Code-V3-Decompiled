package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.p194crypto.p201engines.RFC3394WrapEngine;
import org.bouncycastle.p194crypto.p201engines.RFC5649WrapEngine;
import org.bouncycastle.p194crypto.p201engines.SM4Engine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p209macs.C5359GMac;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4 */
/* loaded from: classes2.dex */
public final class C5765SM4 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$AlgParamGen */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
            byte[] bArr = new byte[16];
            if (this.f21853random == null) {
                this.f21853random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f21853random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("SM4");
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(bArr));
                return algorithmParametersCreateParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SM4 parameter generation.");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "SM4 IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$CMAC */
    public static class CMAC extends C5789BaseMac {
        public CMAC() {
            super(new C5358CMac(new SM4Engine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$ECB */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.SM4.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SM4Engine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$GMAC */
    public static class GMAC extends C5789BaseMac {
        public GMAC() {
            super(new C5359GMac(GCMBlockCipher.newInstance(new SM4Engine())));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SM4", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21828PREFIX = C5765SM4.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21828PREFIX;
            sb.append(str);
            sb.append("$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.SM4", sb.toString());
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.SM4", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("Cipher.SM4", str + "$ECB");
            configurableProvider.addAlgorithm("KeyGenerator.SM4", str + "$KeyGen");
            addCMacAlgorithm(configurableProvider, "SM4", str + "$CMAC", str + "$KeyGen");
            addGMacAlgorithm(configurableProvider, "SM4", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "SM4", str + "$Poly1305", str + "$Poly1305KeyGen");
            configurableProvider.addAlgorithm("Cipher.SM4WRAP", str + "$Wrap");
            configurableProvider.addAlgorithm("Cipher.SM4WRAPPAD", str + "$WrapPad");
            configurableProvider.addAlgorithm("Cipher", GMObjectIdentifiers.sms4_wrap, str + "$Wrap");
            configurableProvider.addAlgorithm("Cipher", GMObjectIdentifiers.sms4_wrap_pad, str + "$WrapPad");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$Poly1305 */
    public static class Poly1305 extends C5789BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.p194crypto.p209macs.Poly1305(new SM4Engine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$Poly1305KeyGen */
    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SM4", 256, new Poly1305KeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$SM4WrapEngine */
    public static class SM4WrapEngine extends RFC3394WrapEngine {
        public SM4WrapEngine() {
            super(new SM4Engine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$SM4WrapPadEngine */
    public static class SM4WrapPadEngine extends RFC5649WrapEngine {
        public SM4WrapPadEngine() {
            super(new SM4Engine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$Wrap */
    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new SM4WrapEngine());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SM4$WrapPad */
    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new SM4WrapPadEngine());
        }
    }

    private C5765SM4() {
    }
}
