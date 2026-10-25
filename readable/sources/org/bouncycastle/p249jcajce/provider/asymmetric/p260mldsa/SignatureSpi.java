package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.MLDSASigner;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p249jcajce.MLDSAProxyPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature;

/* loaded from: classes2.dex */
public class SignatureSpi extends BaseDeterministicOrRandomSignature {
    protected MLDSAParameters parameters;

    /* renamed from: signer */
    protected MLDSASigner f21579signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.SignatureSpi$MLDSA */
    public static class C5586MLDSA extends SignatureSpi {
        public C5586MLDSA() {
            super(new MLDSASigner());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.SignatureSpi$MLDSA44 */
    public static class C5587MLDSA44 extends SignatureSpi {
        public C5587MLDSA44() {
            super(new MLDSASigner(), MLDSAParameters.ml_dsa_44);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.SignatureSpi$MLDSA65 */
    public static class C5588MLDSA65 extends SignatureSpi {
        public C5588MLDSA65() {
            super(new MLDSASigner(), MLDSAParameters.ml_dsa_65);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mldsa.SignatureSpi$MLDSA87 */
    public static class C5589MLDSA87 extends SignatureSpi {
        public C5589MLDSA87() {
            super(new MLDSASigner(), MLDSAParameters.ml_dsa_87);
        }
    }

    public static class MLDSACalcMu extends SignatureSpi {
        public MLDSACalcMu() {
            super(new MLDSASigner());
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, java.security.SignatureSpi
        public byte[] engineSign() throws SignatureException {
            try {
                return this.f21579signer.generateMu();
            } catch (Exception e) {
                throw new SignatureException(e.toString());
            }
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, java.security.SignatureSpi
        public boolean engineVerify(byte[] bArr) {
            return this.f21579signer.verifyMu(bArr);
        }
    }

    public static class MLDSAExtMu extends SignatureSpi {

        /* renamed from: bOut */
        private ByteArrayOutputStream f21580bOut;

        public MLDSAExtMu() {
            super(new MLDSASigner());
            this.f21580bOut = new ByteArrayOutputStream(64);
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, java.security.SignatureSpi
        public byte[] engineSign() throws SignatureException {
            try {
                byte[] byteArray = this.f21580bOut.toByteArray();
                this.f21580bOut.reset();
                return this.f21579signer.generateMuSignature(byteArray);
            } catch (DataLengthException e) {
                throw new SignatureException(e.getMessage());
            } catch (Exception e2) {
                throw new SignatureException(e2.toString());
            }
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, java.security.SignatureSpi
        public boolean engineVerify(byte[] bArr) throws SignatureException {
            byte[] byteArray = this.f21580bOut.toByteArray();
            this.f21580bOut.reset();
            try {
                return this.f21579signer.verifyMuSignature(byteArray, bArr);
            } catch (DataLengthException e) {
                throw new SignatureException(e.getMessage());
            }
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
        public void updateEngine(byte b) {
            this.f21580bOut.write(b);
        }

        @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa.SignatureSpi, org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
        public void updateEngine(byte[] bArr, int i, int i2) {
            this.f21580bOut.write(bArr, i, i2);
        }
    }

    public SignatureSpi(MLDSASigner mLDSASigner) {
        super("MLDSA");
        this.f21579signer = mLDSASigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f21579signer.generateSignature();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        return this.f21579signer.verifySignature(bArr);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void reInitialize(boolean z, CipherParameters cipherParameters) {
        this.f21579signer.mo14987init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void signInit(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        ((java.security.SignatureSpi) this).appRandom = secureRandom;
        if (privateKey instanceof BCMLDSAPrivateKey) {
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
            return;
        }
        if (!(privateKey instanceof MLDSAProxyPrivateKey) || !(this instanceof MLDSACalcMu)) {
            throw new InvalidKeyException("unknown private key passed to ML-DSA");
        }
        MLDSAPublicKey publicKey = ((MLDSAProxyPrivateKey) privateKey).getPublicKey();
        try {
            this.keyParams = PublicKeyFactory.createKey(publicKey.getEncoded());
            MLDSAParameters mLDSAParameters2 = this.parameters;
            if (mLDSAParameters2 != null) {
                String strM16205getName2 = MLDSAParameterSpec.fromName(mLDSAParameters2.m15777getName()).m16205getName();
                if (strM16205getName2.equals(publicKey.getAlgorithm())) {
                    return;
                }
                throw new InvalidKeyException("signature configured for " + strM16205getName2);
            }
        } catch (IOException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte b) {
        this.f21579signer.mo14989update(b);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void verifyInit(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMLDSAPublicKey) {
            this.keyParams = ((BCMLDSAPublicKey) publicKey).getKeyParams();
        } else {
            try {
                AsymmetricKeyParameter asymmetricKeyParameterCreateKey = org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory.createKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
                this.keyParams = asymmetricKeyParameterCreateKey;
                publicKey = new BCMLDSAPublicKey((MLDSAPublicKeyParameters) asymmetricKeyParameterCreateKey);
            } catch (Exception unused) {
                throw new InvalidKeyException("unknown public key passed to ML-DSA");
            }
        }
        MLDSAParameters mLDSAParameters = this.parameters;
        if (mLDSAParameters != null) {
            String strM16205getName = MLDSAParameterSpec.fromName(mLDSAParameters.m15777getName()).m16205getName();
            if (strM16205getName.equals(publicKey.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("signature configured for " + strM16205getName);
        }
    }

    public SignatureSpi(MLDSASigner mLDSASigner, MLDSAParameters mLDSAParameters) {
        super(MLDSAParameterSpec.fromName(mLDSAParameters.m15777getName()).m16205getName());
        this.f21579signer = mLDSASigner;
        this.parameters = mLDSAParameters;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte[] bArr, int i, int i2) {
        this.f21579signer.mo14990update(bArr, i, i2);
    }
}
