package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p217signers.HashMLDSASigner;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature;

/* loaded from: classes2.dex */
public class HashSignatureSpi extends BaseDeterministicOrRandomSignature {
    private MLDSAParameters parameters;

    /* renamed from: signer */
    private HashMLDSASigner f21575signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.HashSignatureSpi$MLDSA */
    public static class C5572MLDSA extends HashSignatureSpi {
        public C5572MLDSA() {
            super(new HashMLDSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.HashSignatureSpi$MLDSA44 */
    public static class C5573MLDSA44 extends HashSignatureSpi {
        public C5573MLDSA44() {
            super(new HashMLDSASigner(), MLDSAParameters.ml_dsa_44_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.HashSignatureSpi$MLDSA65 */
    public static class C5574MLDSA65 extends HashSignatureSpi {
        public C5574MLDSA65() {
            super(new HashMLDSASigner(), MLDSAParameters.ml_dsa_65_with_sha512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.HashSignatureSpi$MLDSA87 */
    public static class C5575MLDSA87 extends HashSignatureSpi {
        public C5575MLDSA87() {
            super(new HashMLDSASigner(), MLDSAParameters.ml_dsa_87_with_sha512);
        }
    }

    public HashSignatureSpi(HashMLDSASigner hashMLDSASigner) {
        super("HashMLDSA");
        this.f21575signer = hashMLDSASigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f21575signer.generateSignature();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        return this.f21575signer.verifySignature(bArr);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void reInitialize(boolean z, CipherParameters cipherParameters) {
        this.f21575signer.mo14987init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void signInit(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        ((SignatureSpi) this).appRandom = secureRandom;
        if (!(privateKey instanceof BCMLDSAPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to ML-DSA");
        }
        BCMLDSAPrivateKey bCMLDSAPrivateKey = (BCMLDSAPrivateKey) privateKey;
        this.keyParams = bCMLDSAPrivateKey.getKeyParams();
        MLDSAParameters mLDSAParameters = this.parameters;
        if (mLDSAParameters != null) {
            String strM16205getName = MLDSAParameterSpec.fromName(mLDSAParameters.m15777getName()).m16205getName();
            if (strM16205getName.equals(bCMLDSAPrivateKey.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("signature configured for " + strM16205getName);
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte b) {
        this.f21575signer.mo14989update(b);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void verifyInit(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCMLDSAPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to ML-DSA");
        }
        BCMLDSAPublicKey bCMLDSAPublicKey = (BCMLDSAPublicKey) publicKey;
        this.keyParams = bCMLDSAPublicKey.getKeyParams();
        MLDSAParameters mLDSAParameters = this.parameters;
        if (mLDSAParameters != null) {
            String strM16205getName = MLDSAParameterSpec.fromName(mLDSAParameters.m15777getName()).m16205getName();
            if (strM16205getName.equals(bCMLDSAPublicKey.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("signature configured for " + strM16205getName);
        }
    }

    public HashSignatureSpi(HashMLDSASigner hashMLDSASigner, MLDSAParameters mLDSAParameters) {
        super(MLDSAParameterSpec.fromName(mLDSAParameters.m15777getName()).m16205getName());
        this.f21575signer = hashMLDSASigner;
        this.parameters = mLDSAParameters;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte[] bArr, int i, int i2) {
        this.f21575signer.mo14990update(bArr, i, i2);
    }
}
