package org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p249jcajce.CompositePrivateKey;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;

/* loaded from: classes2.dex */
public class KeyPairGeneratorSpi extends java.security.KeyPairGeneratorSpi {
    private final ASN1ObjectIdentifier algorithm;
    private final KeyPairGenerator[] generators;
    private boolean parametersInitialized = false;
    private SecureRandom secureRandom;

    public static final class MLDSA44_ECDSA_P256_SHA256 extends KeyPairGeneratorSpi {
        public MLDSA44_ECDSA_P256_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256);
        }
    }

    public static final class MLDSA44_Ed25519_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA44_Ed25519_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512);
        }
    }

    public static final class MLDSA44_RSA2048_PKCS15_SHA256 extends KeyPairGeneratorSpi {
        public MLDSA44_RSA2048_PKCS15_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256);
        }
    }

    public static final class MLDSA44_RSA2048_PSS_SHA256 extends KeyPairGeneratorSpi {
        public MLDSA44_RSA2048_PSS_SHA256() {
            super(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256);
        }
    }

    public static final class MLDSA65_ECDSA_P256_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_ECDSA_P256_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512);
        }
    }

    public static final class MLDSA65_ECDSA_P384_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_ECDSA_P384_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512);
        }
    }

    public static final class MLDSA65_ECDSA_brainpoolP256r1_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_ECDSA_brainpoolP256r1_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512);
        }
    }

    public static final class MLDSA65_Ed25519_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_Ed25519_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512);
        }
    }

    public static final class MLDSA65_RSA3072_PKCS15_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_RSA3072_PKCS15_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512);
        }
    }

    public static final class MLDSA65_RSA3072_PSS_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_RSA3072_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512);
        }
    }

    public static final class MLDSA65_RSA4096_PKCS15_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_RSA4096_PKCS15_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512);
        }
    }

    public static final class MLDSA65_RSA4096_PSS_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA65_RSA4096_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512);
        }
    }

    public static final class MLDSA87_ECDSA_P384_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA87_ECDSA_P384_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512);
        }
    }

    public static final class MLDSA87_ECDSA_P521_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA87_ECDSA_P521_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512);
        }
    }

    public static final class MLDSA87_ECDSA_brainpoolP384r1_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA87_ECDSA_brainpoolP384r1_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512);
        }
    }

    public static final class MLDSA87_Ed448_SHAKE256 extends KeyPairGeneratorSpi {
        public MLDSA87_Ed448_SHAKE256() {
            super(IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256);
        }
    }

    public static final class MLDSA87_RSA3072_PSS_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA87_RSA3072_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512);
        }
    }

    public static final class MLDSA87_RSA4096_PSS_SHA512 extends KeyPairGeneratorSpi {
        public MLDSA87_RSA4096_PSS_SHA512() {
            super(IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512);
        }
    }

    public KeyPairGeneratorSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws InvalidAlgorithmParameterException {
        this.algorithm = aSN1ObjectIdentifier;
        String[] pairing = CompositeIndex.getPairing(aSN1ObjectIdentifier);
        AlgorithmParameterSpec[] keyPairSpecs = CompositeIndex.getKeyPairSpecs(aSN1ObjectIdentifier);
        this.generators = new KeyPairGenerator[pairing.length];
        for (int i = 0; i != pairing.length; i++) {
            try {
                this.generators[i] = KeyPairGenerator.getInstance(CompositeIndex.getBaseName(pairing[i]), BouncyCastleProvider.PROVIDER_NAME);
                AlgorithmParameterSpec algorithmParameterSpec = keyPairSpecs[i];
                if (algorithmParameterSpec != null) {
                    this.generators[i].initialize(algorithmParameterSpec);
                }
            } catch (Exception e) {
                throw new IllegalStateException("unable to create base generator: " + e.getMessage());
            }
        }
    }

    private KeyPair getCompositeKeyPair() {
        KeyPairGenerator[] keyPairGeneratorArr = this.generators;
        PublicKey[] publicKeyArr = new PublicKey[keyPairGeneratorArr.length];
        PrivateKey[] privateKeyArr = new PrivateKey[keyPairGeneratorArr.length];
        int i = 0;
        while (true) {
            KeyPairGenerator[] keyPairGeneratorArr2 = this.generators;
            if (i >= keyPairGeneratorArr2.length) {
                return new KeyPair(new CompositePublicKey(this.algorithm, publicKeyArr), new CompositePrivateKey(this.algorithm, privateKeyArr));
            }
            KeyPair keyPairGenerateKeyPair = keyPairGeneratorArr2[i].generateKeyPair();
            publicKeyArr[i] = keyPairGenerateKeyPair.getPublic();
            privateKeyArr[i] = keyPairGenerateKeyPair.getPrivate();
            i++;
        }
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        return getCompositeKeyPair();
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null) {
            throw new IllegalArgumentException("Use initialize only for custom SecureRandom. AlgorithmParameterSpec must be null because it is determined by algorithm name.");
        }
        AlgorithmParameterSpec[] keyPairSpecs = CompositeIndex.getKeyPairSpecs(this.algorithm);
        for (int i = 0; i != keyPairSpecs.length; i++) {
            AlgorithmParameterSpec algorithmParameterSpec2 = keyPairSpecs[i];
            if (algorithmParameterSpec2 != null) {
                this.generators[i].initialize(algorithmParameterSpec2, secureRandom);
            }
        }
    }
}
