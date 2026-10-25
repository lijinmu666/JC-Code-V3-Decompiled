package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.internal.p231asn1.p241kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.p194crypto.p201engines.SEEDEngine;
import org.bouncycastle.p194crypto.p201engines.SEEDWrapEngine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p209macs.C5359GMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED */
/* loaded from: classes2.dex */
public final class C5764SEED {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$AlgParamGen */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
            byte[] bArr = new byte[16];
            if (this.f21853random == null) {
                this.f21853random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f21853random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("SEED");
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(bArr));
                return algorithmParametersCreateParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for SEED parameter generation.");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "SEED IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$CBC */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(128, new CBCBlockCipher(new SEEDEngine()), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$CMAC */
    public static class CMAC extends C5789BaseMac {
        public CMAC() {
            super(new C5358CMac(new SEEDEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$ECB */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(128, new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.SEED.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new SEEDEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$GMAC */
    public static class GMAC extends C5789BaseMac {
        public GMAC() {
            super(new C5359GMac(GCMBlockCipher.newInstance(new SEEDEngine())));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$KeyFactory */
    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("SEED", null);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SEED", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21827PREFIX = C5764SEED.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21827PREFIX;
            sb.append(str);
            sb.append("$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.SEED", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = KISAObjectIdentifiers.id_seedCBC;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "SEED");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.SEED", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "SEED");
            configurableProvider.addAlgorithm("Cipher.SEED", str + "$ECB");
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider.addAlgorithm("Cipher.SEEDWRAP", str + "$Wrap");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier2, "SEEDWRAP");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.SEEDKW", "SEEDWRAP");
            configurableProvider.addAlgorithm("KeyGenerator.SEED", str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier2, str + "$KeyGen");
            configurableProvider.addAlgorithm("SecretKeyFactory.SEED", str + "$KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier, "SEED");
            addCMacAlgorithm(configurableProvider, "SEED", str + "$CMAC", str + "$KeyGen");
            addGMacAlgorithm(configurableProvider, "SEED", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "SEED", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$Poly1305 */
    public static class Poly1305 extends C5789BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.p194crypto.p209macs.Poly1305(new SEEDEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$Poly1305KeyGen */
    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-SEED", 256, new Poly1305KeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SEED$Wrap */
    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(128, new SEEDWrapEngine());
        }
    }

    private C5764SEED() {
    }
}
