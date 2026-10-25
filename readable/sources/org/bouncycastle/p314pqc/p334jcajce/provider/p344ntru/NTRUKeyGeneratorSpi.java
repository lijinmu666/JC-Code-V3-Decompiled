package org.bouncycastle.p314pqc.p334jcajce.provider.p344ntru;

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
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUKEMGenerator;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23796extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23797genSpec;

    /* renamed from: random */
    private SecureRandom f23798random;

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23797genSpec;
        if (kEMGenerateSpec == null) {
            NTRUKEMExtractor nTRUKEMExtractor = new NTRUKEMExtractor(((BCNTRUPrivateKey) this.f23796extSpec.getPrivateKey()).getKeyParams());
            byte[] encapsulation = this.f23796extSpec.getEncapsulation();
            byte[] bArrExtractSecret = nTRUKEMExtractor.extractSecret(encapsulation);
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArrExtractSecret, 0, (this.f23796extSpec.getKeySize() + 7) / 8);
            C6238Arrays.m18227clear(bArrExtractSecret);
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrCopyOfRange, this.f23796extSpec.getKeyAlgorithmName()), encapsulation);
            C6238Arrays.m18227clear(bArrCopyOfRange);
            return secretKeyWithEncapsulation;
        }
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new NTRUKEMGenerator(this.f23798random).generateEncapsulated(((BCNTRUPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
        byte[] secret = secretWithEncapsulationGenerateEncapsulated.getSecret();
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(secret, 0, (this.f23797genSpec.getKeySize() + 7) / 8);
        C6238Arrays.m18227clear(secret);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrCopyOfRange2, this.f23797genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
        try {
            secretWithEncapsulationGenerateEncapsulated.destroy();
            return secretKeyWithEncapsulation2;
        } catch (DestroyFailedException unused) {
            throw new IllegalStateException("key cleanup failed");
        }
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
        this.f23798random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23797genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23796extSpec = null;
        } else {
            if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
                throw new InvalidAlgorithmParameterException("unknown spec");
            }
            this.f23797genSpec = null;
            this.f23796extSpec = (KEMExtractSpec) algorithmParameterSpec;
        }
    }
}
