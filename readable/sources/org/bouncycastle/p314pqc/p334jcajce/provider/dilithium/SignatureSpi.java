package org.bouncycastle.p314pqc.p334jcajce.provider.dilithium;

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
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumSigner;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SignatureSpi extends Signature {

    /* renamed from: bOut */
    private ByteArrayOutputStream f23728bOut;
    private DilithiumParameters parameters;

    /* renamed from: random */
    private SecureRandom f23729random;

    /* renamed from: signer */
    private DilithiumSigner f23730signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base */
    public static class C6168Base extends SignatureSpi {
        public C6168Base() {
            super(new DilithiumSigner());
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base2 */
    public static class C6169Base2 extends SignatureSpi {
        public C6169Base2() {
            super(new DilithiumSigner(), DilithiumParameters.dilithium2);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base3 */
    public static class C6170Base3 extends SignatureSpi {
        public C6170Base3() {
            super(new DilithiumSigner(), DilithiumParameters.dilithium3);
        }
    }

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.dilithium.SignatureSpi$Base5 */
    public static class C6171Base5 extends SignatureSpi {
        public C6171Base5() {
            super(new DilithiumSigner(), DilithiumParameters.dilithium5);
        }
    }

    public SignatureSpi(DilithiumSigner dilithiumSigner) {
        super("Dilithium");
        this.f23728bOut = new ByteArrayOutputStream();
        this.f23730signer = dilithiumSigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCDilithiumPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to Dilithium");
        }
        BCDilithiumPrivateKey bCDilithiumPrivateKey = (BCDilithiumPrivateKey) privateKey;
        DilithiumPrivateKeyParameters keyParams = bCDilithiumPrivateKey.getKeyParams();
        DilithiumParameters dilithiumParameters = this.parameters;
        if (dilithiumParameters != null) {
            String upperCase = C6250Strings.toUpperCase(dilithiumParameters.m17515getName());
            if (!upperCase.equals(bCDilithiumPrivateKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        SecureRandom secureRandom = this.f23729random;
        DilithiumSigner dilithiumSigner = this.f23730signer;
        if (secureRandom != null) {
            dilithiumSigner.mo15864init(true, new ParametersWithRandom(keyParams, secureRandom));
        } else {
            dilithiumSigner.mo15864init(true, keyParams);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCDilithiumPublicKey)) {
            try {
                publicKey = new BCDilithiumPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeyException("unknown public key passed to Dilithium: " + e.getMessage(), e);
            }
        }
        BCDilithiumPublicKey bCDilithiumPublicKey = (BCDilithiumPublicKey) publicKey;
        DilithiumParameters dilithiumParameters = this.parameters;
        if (dilithiumParameters != null) {
            String upperCase = C6250Strings.toUpperCase(dilithiumParameters.m17515getName());
            if (!upperCase.equals(bCDilithiumPublicKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        this.f23730signer.mo15864init(false, bCDilithiumPublicKey.getKeyParams());
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            byte[] byteArray = this.f23728bOut.toByteArray();
            this.f23728bOut.reset();
            return this.f23730signer.generateSignature(byteArray);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23728bOut.write(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] byteArray = this.f23728bOut.toByteArray();
        this.f23728bOut.reset();
        return this.f23730signer.verifySignature(byteArray, bArr);
    }

    public SignatureSpi(DilithiumSigner dilithiumSigner, DilithiumParameters dilithiumParameters) {
        super(C6250Strings.toUpperCase(dilithiumParameters.m17515getName()));
        this.f23728bOut = new ByteArrayOutputStream();
        this.f23730signer = dilithiumSigner;
        this.parameters = dilithiumParameters;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23729random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23728bOut.write(bArr, i, i2);
    }
}
