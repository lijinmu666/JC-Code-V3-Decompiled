package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.p194crypto.p201engines.NoekeonEngine;
import org.bouncycastle.p194crypto.p209macs.C5359GMac;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon */
/* loaded from: classes2.dex */
public final class C5754Noekeon {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$AlgParamGen */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
            byte[] bArr = new byte[16];
            if (this.f21853random == null) {
                this.f21853random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f21853random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("Noekeon");
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(bArr));
                return algorithmParametersCreateParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Noekeon parameter generation.");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Noekeon IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$ECB */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Noekeon.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new NoekeonEngine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$GMAC */
    public static class GMAC extends C5789BaseMac {
        public GMAC() {
            super(new C5359GMac(GCMBlockCipher.newInstance(new NoekeonEngine())));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Noekeon", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21807PREFIX = C5754Noekeon.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21807PREFIX;
            sb.append(str);
            sb.append("$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.NOEKEON", sb.toString());
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.NOEKEON", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("Cipher.NOEKEON", str + "$ECB");
            configurableProvider.addAlgorithm("KeyGenerator.NOEKEON", str + "$KeyGen");
            addGMacAlgorithm(configurableProvider, "NOEKEON", str + "$GMAC", str + "$KeyGen");
            addPoly1305Algorithm(configurableProvider, "NOEKEON", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$Poly1305 */
    public static class Poly1305 extends C5789BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.p194crypto.p209macs.Poly1305(new NoekeonEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Noekeon$Poly1305KeyGen */
    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Noekeon", 256, new Poly1305KeyGenerator());
        }
    }

    private C5754Noekeon() {
    }
}
