package org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo;

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
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoSigner;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SignatureSpi extends Signature {

    /* renamed from: bOut */
    private final ByteArrayOutputStream f23784bOut;
    private final MayoParameters parameters;

    /* renamed from: random */
    private SecureRandom f23785random;

    /* renamed from: signer */
    private final MayoSigner f23786signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Base */
    public static class C6197Base extends SignatureSpi {
        public C6197Base() {
            super(new MayoSigner());
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo1 */
    public static class C6198Mayo1 extends SignatureSpi {
        public C6198Mayo1() {
            super(new MayoSigner(), MayoParameters.f23275mayo1);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo2 */
    public static class C6199Mayo2 extends SignatureSpi {
        public C6199Mayo2() {
            super(new MayoSigner(), MayoParameters.f23276mayo2);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo3 */
    public static class C6200Mayo3 extends SignatureSpi {
        public C6200Mayo3() {
            super(new MayoSigner(), MayoParameters.f23277mayo3);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.mayo.SignatureSpi$Mayo5 */
    public static class C6201Mayo5 extends SignatureSpi {
        public C6201Mayo5() {
            super(new MayoSigner(), MayoParameters.f23278mayo5);
        }
    }

    public SignatureSpi(MayoSigner mayoSigner) {
        super("Mayo");
        this.f23784bOut = new ByteArrayOutputStream();
        this.f23786signer = mayoSigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCMayoPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to Mayo");
        }
        BCMayoPrivateKey bCMayoPrivateKey = (BCMayoPrivateKey) privateKey;
        MayoPrivateKeyParameters keyParams = bCMayoPrivateKey.getKeyParams();
        MayoParameters mayoParameters = this.parameters;
        if (mayoParameters != null) {
            String upperCase = C6250Strings.toUpperCase(mayoParameters.m17670getName());
            if (!upperCase.equals(bCMayoPrivateKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        SecureRandom secureRandom = this.f23785random;
        MayoSigner mayoSigner = this.f23786signer;
        if (secureRandom != null) {
            mayoSigner.mo15864init(true, new ParametersWithRandom(keyParams, secureRandom));
        } else {
            mayoSigner.mo15864init(true, keyParams);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCMayoPublicKey)) {
            try {
                publicKey = new BCMayoPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeyException("unknown public key passed to Mayo: " + e.getMessage());
            }
        }
        BCMayoPublicKey bCMayoPublicKey = (BCMayoPublicKey) publicKey;
        MayoParameters mayoParameters = this.parameters;
        if (mayoParameters != null) {
            String upperCase = C6250Strings.toUpperCase(mayoParameters.m17670getName());
            if (!upperCase.equals(bCMayoPublicKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        this.f23786signer.mo15864init(false, bCMayoPublicKey.getKeyParams());
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            byte[] byteArray = this.f23784bOut.toByteArray();
            this.f23784bOut.reset();
            return this.f23786signer.generateSignature(byteArray);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23784bOut.write(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] byteArray = this.f23784bOut.toByteArray();
        this.f23784bOut.reset();
        return this.f23786signer.verifySignature(byteArray, bArr);
    }

    public SignatureSpi(MayoSigner mayoSigner, MayoParameters mayoParameters) {
        super(C6250Strings.toUpperCase(mayoParameters.m17670getName()));
        this.parameters = mayoParameters;
        this.f23784bOut = new ByteArrayOutputStream();
        this.f23786signer = mayoSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23785random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23784bOut.write(bArr, i, i2);
    }
}
