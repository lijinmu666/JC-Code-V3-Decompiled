package org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc;

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
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCKEMGenerator;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.HQCParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HQCKeyGeneratorSpi extends KeyGeneratorSpi {

    /* renamed from: extSpec */
    private KEMExtractSpec f23755extSpec;

    /* renamed from: genSpec */
    private KEMGenerateSpec f23756genSpec;
    private HQCParameters hqcParameters;

    /* renamed from: random */
    private SecureRandom f23757random;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC128 */
    public static class C6181HQC128 extends HQCKeyGeneratorSpi {
        public C6181HQC128() {
            super(HQCParameters.f23200hqc128);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC192 */
    public static class C6182HQC192 extends HQCKeyGeneratorSpi {
        public C6182HQC192() {
            super(HQCParameters.f23201hqc192);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.hqc.HQCKeyGeneratorSpi$HQC256 */
    public static class C6183HQC256 extends HQCKeyGeneratorSpi {
        public C6183HQC256() {
            super(HQCParameters.f23202hqc256);
        }
    }

    public HQCKeyGeneratorSpi() {
        this(null);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() throws DestroyFailedException {
        KEMGenerateSpec kEMGenerateSpec = this.f23756genSpec;
        if (kEMGenerateSpec != null) {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = new HQCKEMGenerator(this.f23757random).generateEncapsulated(((BCHQCPublicKey) kEMGenerateSpec.getPublicKey()).getKeyParams());
            SecretKeyWithEncapsulation secretKeyWithEncapsulation = new SecretKeyWithEncapsulation(new SecretKeySpec(secretWithEncapsulationGenerateEncapsulated.getSecret(), this.f23756genSpec.getKeyAlgorithmName()), secretWithEncapsulationGenerateEncapsulated.getEncapsulation());
            try {
                secretWithEncapsulationGenerateEncapsulated.destroy();
                return secretKeyWithEncapsulation;
            } catch (DestroyFailedException unused) {
                throw new IllegalStateException("key cleanup failed");
            }
        }
        HQCKEMExtractor hQCKEMExtractor = new HQCKEMExtractor(((BCHQCPrivateKey) this.f23755extSpec.getPrivateKey()).getKeyParams());
        byte[] encapsulation = this.f23755extSpec.getEncapsulation();
        byte[] bArrExtractSecret = hQCKEMExtractor.extractSecret(encapsulation);
        SecretKeyWithEncapsulation secretKeyWithEncapsulation2 = new SecretKeyWithEncapsulation(new SecretKeySpec(bArrExtractSecret, this.f23755extSpec.getKeyAlgorithmName()), encapsulation);
        C6238Arrays.m18227clear(bArrExtractSecret);
        return secretKeyWithEncapsulation2;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public HQCKeyGeneratorSpi(HQCParameters hQCParameters) {
        this.hqcParameters = hQCParameters;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.f23757random = secureRandom;
        if (algorithmParameterSpec instanceof KEMGenerateSpec) {
            this.f23756genSpec = (KEMGenerateSpec) algorithmParameterSpec;
            this.f23755extSpec = null;
            HQCParameters hQCParameters = this.hqcParameters;
            if (hQCParameters != null) {
                String strM18046getName = HQCParameterSpec.fromName(hQCParameters.m17592getName()).m18046getName();
                if (strM18046getName.equals(this.f23756genSpec.getPublicKey().getAlgorithm())) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("key generator locked to " + strM18046getName);
            }
            return;
        }
        if (!(algorithmParameterSpec instanceof KEMExtractSpec)) {
            throw new InvalidAlgorithmParameterException("unknown spec");
        }
        this.f23756genSpec = null;
        this.f23755extSpec = (KEMExtractSpec) algorithmParameterSpec;
        HQCParameters hQCParameters2 = this.hqcParameters;
        if (hQCParameters2 != null) {
            String strM18046getName2 = HQCParameterSpec.fromName(hQCParameters2.m17592getName()).m18046getName();
            if (strM18046getName2.equals(this.f23755extSpec.getPrivateKey().getAlgorithm())) {
                return;
            }
            throw new InvalidAlgorithmParameterException("key generator locked to " + strM18046getName2);
        }
    }
}
