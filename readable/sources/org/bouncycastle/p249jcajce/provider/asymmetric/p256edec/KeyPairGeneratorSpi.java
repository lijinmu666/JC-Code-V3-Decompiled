package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.generators.Ed25519KeyPairGenerator;
import org.bouncycastle.p194crypto.generators.Ed448KeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.Ed25519KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.Ed448KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X25519KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X448KeyGenerationParameters;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5618ECUtil;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveGenParameterSpec;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {

    /* renamed from: Ed25519 */
    private static final int f21546Ed25519 = 1;

    /* renamed from: Ed448 */
    private static final int f21547Ed448 = 2;

    /* renamed from: EdDSA */
    private static final int f21548EdDSA = -1;

    /* renamed from: X25519 */
    private static final int f21549X25519 = 3;

    /* renamed from: X448 */
    private static final int f21550X448 = 4;

    /* renamed from: XDH */
    private static final int f21551XDH = -2;
    private final int algorithmDeclared;
    private int algorithmInitialized;
    private AsymmetricCipherKeyPairGenerator generator;
    private SecureRandom secureRandom;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519 */
    public static final class C5562Ed25519 extends KeyPairGeneratorSpi {
        public C5562Ed25519() {
            super(1);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448 */
    public static final class C5563Ed448 extends KeyPairGeneratorSpi {
        public C5563Ed448() {
            super(2);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$EdDSA */
    public static final class C5564EdDSA extends KeyPairGeneratorSpi {
        public C5564EdDSA() {
            super(-1);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519 */
    public static final class C5565X25519 extends KeyPairGeneratorSpi {
        public C5565X25519() {
            super(3);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448 */
    public static final class C5566X448 extends KeyPairGeneratorSpi {
        public C5566X448() {
            super(4);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$XDH */
    public static final class C5567XDH extends KeyPairGeneratorSpi {
        public C5567XDH() {
            super(-2);
        }
    }

    public KeyPairGeneratorSpi(int i) {
        this.algorithmDeclared = i;
        if (getAlgorithmFamily(i) != i) {
            this.algorithmInitialized = i;
        }
    }

    private static int getAlgorithmFamily(int i) {
        if (i == 1 || i == 2) {
            return -1;
        }
        if (i == 3 || i == 4) {
            return -2;
        }
        return i;
    }

    private static int getAlgorithmForName(String str) throws InvalidAlgorithmParameterException {
        if (str.equalsIgnoreCase(XDHParameterSpec.f21951X25519) || str.equals(EdECObjectIdentifiers.id_X25519.m14433getId())) {
            return 3;
        }
        if (str.equalsIgnoreCase(EdDSAParameterSpec.f21918Ed25519) || str.equals(EdECObjectIdentifiers.id_Ed25519.m14433getId())) {
            return 1;
        }
        if (str.equalsIgnoreCase(XDHParameterSpec.f21952X448) || str.equals(EdECObjectIdentifiers.f21248id_X448.m14433getId())) {
            return 4;
        }
        if (str.equalsIgnoreCase(EdDSAParameterSpec.f21919Ed448) || str.equals(EdECObjectIdentifiers.id_Ed448.m14433getId())) {
            return 2;
        }
        throw new InvalidAlgorithmParameterException("invalid parameterSpec name: " + str);
    }

    private int getAlgorithmForStrength(int i) {
        if (i == 255 || i == 256) {
            int i2 = this.algorithmDeclared;
            if (i2 != -2) {
                if (i2 == -1 || i2 == 1) {
                    return 1;
                }
                if (i2 != 3) {
                    throw new InvalidParameterException("key size not configurable");
                }
            }
            return 3;
        }
        if (i != 448) {
            throw new InvalidParameterException("unknown key size");
        }
        int i3 = this.algorithmDeclared;
        if (i3 != -2) {
            if (i3 == -1 || i3 == 2) {
                return 2;
            }
            if (i3 != 4) {
                throw new InvalidParameterException("key size not configurable");
            }
        }
        return 4;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof ECGenParameterSpec ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec ? ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).m16265getName() : algorithmParameterSpec instanceof EdDSAParameterSpec ? ((EdDSAParameterSpec) algorithmParameterSpec).getCurveName() : algorithmParameterSpec instanceof XDHParameterSpec ? ((XDHParameterSpec) algorithmParameterSpec).getCurveName() : C5618ECUtil.getNameFrom(algorithmParameterSpec);
    }

    private AsymmetricCipherKeyPairGenerator setupGenerator() {
        if (this.secureRandom == null) {
            this.secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        int i = this.algorithmInitialized;
        if (i == 1) {
            Ed25519KeyPairGenerator ed25519KeyPairGenerator = new Ed25519KeyPairGenerator();
            ed25519KeyPairGenerator.mo14944init(new Ed25519KeyGenerationParameters(this.secureRandom));
            return ed25519KeyPairGenerator;
        }
        if (i == 2) {
            Ed448KeyPairGenerator ed448KeyPairGenerator = new Ed448KeyPairGenerator();
            ed448KeyPairGenerator.mo14944init(new Ed448KeyGenerationParameters(this.secureRandom));
            return ed448KeyPairGenerator;
        }
        if (i == 3) {
            X25519KeyPairGenerator x25519KeyPairGenerator = new X25519KeyPairGenerator();
            x25519KeyPairGenerator.mo14944init(new X25519KeyGenerationParameters(this.secureRandom));
            return x25519KeyPairGenerator;
        }
        if (i != 4) {
            throw new IllegalStateException("generator not correctly initialized");
        }
        X448KeyPairGenerator x448KeyPairGenerator = new X448KeyPairGenerator();
        x448KeyPairGenerator.mo14944init(new X448KeyGenerationParameters(this.secureRandom));
        return x448KeyPairGenerator;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (this.algorithmInitialized == 0) {
            throw new IllegalStateException("generator not correctly initialized");
        }
        if (this.generator == null) {
            this.generator = setupGenerator();
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.generator.generateKeyPair();
        int i = this.algorithmInitialized;
        if (i == 1 || i == 2) {
            return new KeyPair(new BCEdDSAPublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCEdDSAPrivateKey(asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
        }
        if (i == 3 || i == 4) {
            return new KeyPair(new BCXDHPublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCXDHPrivateKey(asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
        }
        throw new IllegalStateException("generator not correctly initialized");
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.algorithmInitialized = getAlgorithmForStrength(i);
        this.secureRandom = secureRandom;
        this.generator = null;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid parameterSpec: " + algorithmParameterSpec);
        }
        int algorithmForName = getAlgorithmForName(nameFromParams);
        int i = this.algorithmDeclared;
        if (i != algorithmForName && i != getAlgorithmFamily(algorithmForName)) {
            throw new InvalidAlgorithmParameterException("parameterSpec for wrong curve type");
        }
        this.algorithmInitialized = algorithmForName;
        this.secureRandom = secureRandom;
        this.generator = null;
    }
}
