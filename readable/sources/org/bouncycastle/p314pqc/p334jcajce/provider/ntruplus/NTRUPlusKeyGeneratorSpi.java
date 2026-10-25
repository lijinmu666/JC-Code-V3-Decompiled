package org.bouncycastle.p314pqc.p334jcajce.provider.ntruplus;

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
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKEMGenerator;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUPlusParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUPlusKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23807extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23808genSpec;
    private NTRUPlusParameters ntruplusParameters;

    /* renamed from: random */
    private SecureRandom f23809random;

    public static class NTRUPlus1152 extends NTRUPlusKeyGeneratorSpi {
        public NTRUPlus1152() {
            super(NTRUPlusParameters.ntruplus_kem_1152);
        }
    }

    public static class NTRUPlus768 extends NTRUPlusKeyGeneratorSpi {
        public NTRUPlus768() {
            super(NTRUPlusParameters.ntruplus_kem_768);
        }
    }

    public static class NTRUPlus864 extends NTRUPlusKeyGeneratorSpi {
        public NTRUPlus864() {
            super(NTRUPlusParameters.ntruplus_kem_864);
        }
    }

    public NTRUPlusKeyGeneratorSpi() {
        this(null);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23808genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new NTRUPlusKEMGenerator(this.f23809random).generateEncapsulated(((BCNTRUPlusPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(secretWithEncapsulationGenerateEncapsulated.getSecret(), this.f23808genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
            try {
                secretWithEncapsulationGenerateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        }
        NTRUPlusKEMExtractor nTRUPlusKEMExtractor = new NTRUPlusKEMExtractor(((BCNTRUPlusPrivateKey) this.f23807extSpec.getPrivateKey()).getKeyParams());
        byte[] encapsulation = this.f23807extSpec.getEncapsulation();
        byte[] bArrExtractSecret = nTRUPlusKEMExtractor.extractSecret(encapsulation);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrExtractSecret, this.f23807extSpec.getKeyAlgorithmName()), encapsulation);
        C6238Arrays.m18227clear(bArrExtractSecret);
        return secretKeyWithEncapsulation2;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public NTRUPlusKeyGeneratorSpi(NTRUPlusParameters nTRUPlusParameters) {
        this.ntruplusParameters = nTRUPlusParameters;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f23809random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23808genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23807extSpec = null;
            NTRUPlusParameters nTRUPlusParameters = this.ntruplusParameters;
            if (nTRUPlusParameters != null) {
                String strM18051getName = NTRUPlusParameterSpec.fromName(nTRUPlusParameters.m17775getName()).m18051getName();
                if (strM18051getName.equals(this.f23808genSpec.getPublicKey().getAlgorithm())) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("key generator locked to " + strM18051getName);
            }
            return;
        }
        if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
        this.f23808genSpec = null;
        this.f23807extSpec = (KEMExtractSpec) algorithmParameterSpec;
        NTRUPlusParameters nTRUPlusParameters2 = this.ntruplusParameters;
        if (nTRUPlusParameters2 != null) {
            String strM18051getName2 = NTRUPlusParameterSpec.fromName(nTRUPlusParameters2.m17775getName()).m18051getName();
            if (strM18051getName2.equals(this.f23807extSpec.getPrivateKey().getAlgorithm())) {
                return;
            }
            throw new InvalidAlgorithmParameterException("key generator locked to " + strM18051getName2);
        }
    }
}
