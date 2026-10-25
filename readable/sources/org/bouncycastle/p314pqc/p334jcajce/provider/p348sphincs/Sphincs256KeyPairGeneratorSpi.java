package org.bouncycastle.p314pqc.p334jcajce.provider.p348sphincs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512tDigest;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCS256KeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCS256KeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SPHINCS256KeyGenParameterSpec;

/* loaded from: classes2.dex */
public class Sphincs256KeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    SPHINCS256KeyPairGenerator f23865engine;
    boolean initialised;

    /* renamed from: param */
    SPHINCS256KeyGenerationParameters f23866param;

    /* renamed from: random */
    SecureRandom f23867random;
    ASN1ObjectIdentifier treeDigest;

    public Sphincs256KeyPairGeneratorSpi() {
        super("SPHINCS256");
        this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
        this.f23865engine = new SPHINCS256KeyPairGenerator();
        this.f23867random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SPHINCS256KeyGenerationParameters sPHINCS256KeyGenerationParameters = new SPHINCS256KeyGenerationParameters(this.f23867random, new SHA512tDigest(256));
            this.f23866param = sPHINCS256KeyGenerationParameters;
            this.f23865engine.mo14944init(sPHINCS256KeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23865engine.generateKeyPair();
        return new KeyPair(new BCSphincs256PublicKey(this.treeDigest, (SPHINCSPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCSphincs256PrivateKey(this.treeDigest, (SPHINCSPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        SPHINCS256KeyGenerationParameters sPHINCS256KeyGenerationParameters;
        if (!(algorithmParameterSpec instanceof SPHINCS256KeyGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
        }
        SPHINCS256KeyGenParameterSpec sPHINCS256KeyGenParameterSpec = (SPHINCS256KeyGenParameterSpec) algorithmParameterSpec;
        if (!sPHINCS256KeyGenParameterSpec.getTreeDigest().equals(SPHINCS256KeyGenParameterSpec.SHA512_256)) {
            if (sPHINCS256KeyGenParameterSpec.getTreeDigest().equals("SHA3-256")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha3_256;
                sPHINCS256KeyGenerationParameters = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA3Digest(256));
            }
            this.f23865engine.mo14944init(this.f23866param);
            this.initialised = true;
        }
        this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
        sPHINCS256KeyGenerationParameters = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA512tDigest(256));
        this.f23866param = sPHINCS256KeyGenerationParameters;
        this.f23865engine.mo14944init(this.f23866param);
        this.initialised = true;
    }
}
