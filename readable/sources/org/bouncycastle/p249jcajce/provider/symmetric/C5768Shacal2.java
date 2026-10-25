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
import org.bouncycastle.p194crypto.p201engines.Shacal2Engine;
import org.bouncycastle.p194crypto.p209macs.C5358CMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2 */
/* loaded from: classes2.dex */
public final class C5768Shacal2 {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParamGen */
    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
            byte[] bArr = new byte[32];
            if (this.f21853random == null) {
                this.f21853random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f21853random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("Shacal2");
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(bArr));
                return algorithmParametersCreateParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Shacal2 parameter generation.");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$AlgParams */
    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Shacal2 IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$CBC */
    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new Shacal2Engine()), 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$CMAC */
    public static class CMAC extends C5789BaseMac {
        public CMAC() {
            super(new C5358CMac(new Shacal2Engine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$ECB */
    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.Shacal2.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new Shacal2Engine();
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("SHACAL-2", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.Shacal2$Mappings */
    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21831PREFIX = C5768Shacal2.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21831PREFIX;
            sb.append(str);
            sb.append("$CMAC");
            configurableProvider.addAlgorithm("Mac.Shacal-2CMAC", sb.toString());
            configurableProvider.addAlgorithm("Cipher.Shacal2", str + "$ECB");
            configurableProvider.addAlgorithm("Cipher.SHACAL-2", str + "$ECB");
            configurableProvider.addAlgorithm("KeyGenerator.Shacal2", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.Shacal2", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.Shacal2", str + "$AlgParams");
            configurableProvider.addAlgorithm("KeyGenerator.SHACAL-2", str + "$KeyGen");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.SHACAL-2", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("AlgorithmParameters.SHACAL-2", str + "$AlgParams");
        }
    }

    private C5768Shacal2() {
    }
}
