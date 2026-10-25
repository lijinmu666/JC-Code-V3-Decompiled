package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p249jcajce.SecretKeyWithEncapsulation;
import org.bouncycastle.p249jcajce.p279spec.KEMExtractSpec;
import org.bouncycastle.p249jcajce.p279spec.KEMGenerateSpec;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeKEMGenerator;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimeKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23819extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23820genSpec;

    /* renamed from: random */
    private SecureRandom f23821random;

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23820genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new NTRULPRimeKEMGenerator(this.f23821random).generateEncapsulated(((BCNTRULPRimePublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(secretWithEncapsulationGenerateEncapsulated.getSecret(), this.f23820genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
            try {
                secretWithEncapsulationGenerateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        }
        NTRULPRimeKEMExtractor nTRULPRimeKEMExtractor = new NTRULPRimeKEMExtractor(((BCNTRULPRimePrivateKey) this.f23819extSpec.getPrivateKey()).getKeyParams());
        byte[] encapsulation = this.f23819extSpec.getEncapsulation();
        byte[] bArrExtractSecret = nTRULPRimeKEMExtractor.extractSecret(encapsulation);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrExtractSecret, this.f23819extSpec.getKeyAlgorithmName()), encapsulation);
        C6238Arrays.m18227clear(bArrExtractSecret);
        return secretKeyWithEncapsulation2;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f23821random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23820genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23819extSpec = null;
        } else {
            if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
                throw new InvalidAlgorithmParameterException("unknown spec");
            }
            this.f23820genSpec = null;
            this.f23819extSpec = (KEMExtractSpec) algorithmParameterSpec;
        }
    }
}
