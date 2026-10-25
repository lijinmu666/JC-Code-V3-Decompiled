package org.bouncycastle.p314pqc.p334jcajce.provider.p346saber;

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
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERKEMGenerator;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SABERKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23845extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23846genSpec;

    /* renamed from: random */
    private SecureRandom f23847random;

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23846genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new SABERKEMGenerator(this.f23847random).generateEncapsulated(((BCSABERPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(secretWithEncapsulationGenerateEncapsulated.getSecret(), this.f23846genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
            try {
                secretWithEncapsulationGenerateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        }
        SABERKEMExtractor sABERKEMExtractor = new SABERKEMExtractor(((BCSABERPrivateKey) this.f23845extSpec.getPrivateKey()).getKeyParams());
        byte[] encapsulation = this.f23845extSpec.getEncapsulation();
        byte[] bArrExtractSecret = sABERKEMExtractor.extractSecret(encapsulation);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrExtractSecret, this.f23845extSpec.getKeyAlgorithmName()), encapsulation);
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
        this.f23847random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23846genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23845extSpec = null;
        } else {
            if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
                throw new InvalidAlgorithmParameterException("unknown spec");
            }
            this.f23846genSpec = null;
            this.f23845extSpec = (KEMExtractSpec) algorithmParameterSpec;
        }
    }
}
