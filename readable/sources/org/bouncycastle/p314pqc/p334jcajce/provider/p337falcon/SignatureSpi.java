package org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconSigner;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SignatureSpi extends Signature {

    /* renamed from: bOut */
    private ByteArrayOutputStream f23737bOut;
    private FalconParameters parameters;

    /* renamed from: random */
    private SecureRandom f23738random;

    /* renamed from: signer */
    private FalconSigner f23739signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.falcon.SignatureSpi$Base */
    public static class C6172Base extends SignatureSpi {
        public C6172Base() {
            super(new FalconSigner());
        }
    }

    public static class Falcon1024 extends SignatureSpi {
        public Falcon1024() {
            super(new FalconSigner(), FalconParameters.falcon_1024);
        }
    }

    public static class Falcon512 extends SignatureSpi {
        public Falcon512() {
            super(new FalconSigner(), FalconParameters.falcon_512);
        }
    }

    public SignatureSpi(FalconSigner falconSigner) {
        super("FALCON");
        this.f23737bOut = new ByteArrayOutputStream();
        this.f23739signer = falconSigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCFalconPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to Falcon");
        }
        BCFalconPrivateKey bCFalconPrivateKey = (BCFalconPrivateKey) privateKey;
        FalconPrivateKeyParameters keyParams = bCFalconPrivateKey.getKeyParams();
        FalconParameters falconParameters = this.parameters;
        if (falconParameters != null) {
            String upperCase = C6250Strings.toUpperCase(falconParameters.m17549getName());
            if (!upperCase.equals(bCFalconPrivateKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        SecureRandom secureRandom = this.f23738random;
        FalconSigner falconSigner = this.f23739signer;
        if (secureRandom != null) {
            falconSigner.mo15864init(true, new ParametersWithRandom(keyParams, secureRandom));
        } else {
            falconSigner.mo15864init(true, keyParams);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCFalconPublicKey)) {
            try {
                publicKey = new BCFalconPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeyException("unknown public key passed to Falcon: " + e.getMessage(), e);
            }
        }
        BCFalconPublicKey bCFalconPublicKey = (BCFalconPublicKey) publicKey;
        FalconParameters falconParameters = this.parameters;
        if (falconParameters != null) {
            String upperCase = C6250Strings.toUpperCase(falconParameters.m17549getName());
            if (!upperCase.equals(bCFalconPublicKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        this.f23739signer.mo15864init(false, bCFalconPublicKey.getKeyParams());
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            byte[] byteArray = this.f23737bOut.toByteArray();
            this.f23737bOut.reset();
            return this.f23739signer.generateSignature(byteArray);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23737bOut.write(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] byteArray = this.f23737bOut.toByteArray();
        this.f23737bOut.reset();
        return this.f23739signer.verifySignature(byteArray, bArr);
    }

    public SignatureSpi(FalconSigner falconSigner, FalconParameters falconParameters) {
        super(C6250Strings.toUpperCase(falconParameters.m17549getName()));
        this.parameters = falconParameters;
        this.f23737bOut = new ByteArrayOutputStream();
        this.f23739signer = falconSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23738random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23737bOut.write(bArr, i, i2);
    }
}
