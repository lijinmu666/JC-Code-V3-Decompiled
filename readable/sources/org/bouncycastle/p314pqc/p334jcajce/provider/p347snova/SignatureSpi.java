package org.bouncycastle.p314pqc.p334jcajce.provider.p347snova;

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
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaSigner;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SignatureSpi extends Signature {

    /* renamed from: bOut */
    private final ByteArrayOutputStream f23853bOut;
    private final SnovaParameters parameters;

    /* renamed from: random */
    private SecureRandom f23854random;

    /* renamed from: signer */
    private final SnovaSigner f23855signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.snova.SignatureSpi$Base */
    public static class C6208Base extends SignatureSpi {
        public C6208Base() {
            super(new SnovaSigner());
        }
    }

    public static class SNOVA_24_5_4_ESK extends SignatureSpi {
        public SNOVA_24_5_4_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_4_ESK);
        }
    }

    public static class SNOVA_24_5_4_SHAKE_ESK extends SignatureSpi {
        public SNOVA_24_5_4_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_4_SHAKE_ESK);
        }
    }

    public static class SNOVA_24_5_4_SHAKE_SSK extends SignatureSpi {
        public SNOVA_24_5_4_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_4_SHAKE_SSK);
        }
    }

    public static class SNOVA_24_5_4_SSK extends SignatureSpi {
        public SNOVA_24_5_4_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_4_SSK);
        }
    }

    public static class SNOVA_24_5_5_ESK extends SignatureSpi {
        public SNOVA_24_5_5_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_5_ESK);
        }
    }

    public static class SNOVA_24_5_5_SHAKE_ESK extends SignatureSpi {
        public SNOVA_24_5_5_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_5_SHAKE_ESK);
        }
    }

    public static class SNOVA_24_5_5_SHAKE_SSK extends SignatureSpi {
        public SNOVA_24_5_5_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_5_SHAKE_SSK);
        }
    }

    public static class SNOVA_24_5_5_SSK extends SignatureSpi {
        public SNOVA_24_5_5_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_24_5_5_SSK);
        }
    }

    public static class SNOVA_25_8_3_ESK extends SignatureSpi {
        public SNOVA_25_8_3_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_25_8_3_ESK);
        }
    }

    public static class SNOVA_25_8_3_SHAKE_ESK extends SignatureSpi {
        public SNOVA_25_8_3_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_25_8_3_SHAKE_ESK);
        }
    }

    public static class SNOVA_25_8_3_SHAKE_SSK extends SignatureSpi {
        public SNOVA_25_8_3_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_25_8_3_SHAKE_SSK);
        }
    }

    public static class SNOVA_25_8_3_SSK extends SignatureSpi {
        public SNOVA_25_8_3_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_25_8_3_SSK);
        }
    }

    public static class SNOVA_29_6_5_ESK extends SignatureSpi {
        public SNOVA_29_6_5_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_29_6_5_ESK);
        }
    }

    public static class SNOVA_29_6_5_SHAKE_ESK extends SignatureSpi {
        public SNOVA_29_6_5_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_29_6_5_SHAKE_ESK);
        }
    }

    public static class SNOVA_29_6_5_SHAKE_SSK extends SignatureSpi {
        public SNOVA_29_6_5_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_29_6_5_SHAKE_SSK);
        }
    }

    public static class SNOVA_29_6_5_SSK extends SignatureSpi {
        public SNOVA_29_6_5_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_29_6_5_SSK);
        }
    }

    public static class SNOVA_37_17_2_ESK extends SignatureSpi {
        public SNOVA_37_17_2_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_17_2_ESK);
        }
    }

    public static class SNOVA_37_17_2_SHAKE_ESK extends SignatureSpi {
        public SNOVA_37_17_2_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_17_2_SHAKE_ESK);
        }
    }

    public static class SNOVA_37_17_2_SHAKE_SSK extends SignatureSpi {
        public SNOVA_37_17_2_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_17_2_SHAKE_SSK);
        }
    }

    public static class SNOVA_37_17_2_SSK extends SignatureSpi {
        public SNOVA_37_17_2_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_17_2_SSK);
        }
    }

    public static class SNOVA_37_8_4_ESK extends SignatureSpi {
        public SNOVA_37_8_4_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_8_4_ESK);
        }
    }

    public static class SNOVA_37_8_4_SHAKE_ESK extends SignatureSpi {
        public SNOVA_37_8_4_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_8_4_SHAKE_ESK);
        }
    }

    public static class SNOVA_37_8_4_SHAKE_SSK extends SignatureSpi {
        public SNOVA_37_8_4_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_8_4_SHAKE_SSK);
        }
    }

    public static class SNOVA_37_8_4_SSK extends SignatureSpi {
        public SNOVA_37_8_4_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_37_8_4_SSK);
        }
    }

    public static class SNOVA_49_11_3_ESK extends SignatureSpi {
        public SNOVA_49_11_3_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_49_11_3_ESK);
        }
    }

    public static class SNOVA_49_11_3_SHAKE_ESK extends SignatureSpi {
        public SNOVA_49_11_3_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_49_11_3_SHAKE_ESK);
        }
    }

    public static class SNOVA_49_11_3_SHAKE_SSK extends SignatureSpi {
        public SNOVA_49_11_3_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_49_11_3_SHAKE_SSK);
        }
    }

    public static class SNOVA_49_11_3_SSK extends SignatureSpi {
        public SNOVA_49_11_3_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_49_11_3_SSK);
        }
    }

    public static class SNOVA_56_25_2_ESK extends SignatureSpi {
        public SNOVA_56_25_2_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_56_25_2_ESK);
        }
    }

    public static class SNOVA_56_25_2_SHAKE_ESK extends SignatureSpi {
        public SNOVA_56_25_2_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_56_25_2_SHAKE_ESK);
        }
    }

    public static class SNOVA_56_25_2_SHAKE_SSK extends SignatureSpi {
        public SNOVA_56_25_2_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_56_25_2_SHAKE_SSK);
        }
    }

    public static class SNOVA_56_25_2_SSK extends SignatureSpi {
        public SNOVA_56_25_2_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_56_25_2_SSK);
        }
    }

    public static class SNOVA_60_10_4_ESK extends SignatureSpi {
        public SNOVA_60_10_4_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_60_10_4_ESK);
        }
    }

    public static class SNOVA_60_10_4_SHAKE_ESK extends SignatureSpi {
        public SNOVA_60_10_4_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_60_10_4_SHAKE_ESK);
        }
    }

    public static class SNOVA_60_10_4_SHAKE_SSK extends SignatureSpi {
        public SNOVA_60_10_4_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_60_10_4_SHAKE_SSK);
        }
    }

    public static class SNOVA_60_10_4_SSK extends SignatureSpi {
        public SNOVA_60_10_4_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_60_10_4_SSK);
        }
    }

    public static class SNOVA_66_15_3_ESK extends SignatureSpi {
        public SNOVA_66_15_3_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_66_15_3_ESK);
        }
    }

    public static class SNOVA_66_15_3_SHAKE_ESK extends SignatureSpi {
        public SNOVA_66_15_3_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_66_15_3_SHAKE_ESK);
        }
    }

    public static class SNOVA_66_15_3_SHAKE_SSK extends SignatureSpi {
        public SNOVA_66_15_3_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_66_15_3_SHAKE_SSK);
        }
    }

    public static class SNOVA_66_15_3_SSK extends SignatureSpi {
        public SNOVA_66_15_3_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_66_15_3_SSK);
        }
    }

    public static class SNOVA_75_33_2_ESK extends SignatureSpi {
        public SNOVA_75_33_2_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_75_33_2_ESK);
        }
    }

    public static class SNOVA_75_33_2_SHAKE_ESK extends SignatureSpi {
        public SNOVA_75_33_2_SHAKE_ESK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_75_33_2_SHAKE_ESK);
        }
    }

    public static class SNOVA_75_33_2_SHAKE_SSK extends SignatureSpi {
        public SNOVA_75_33_2_SHAKE_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_75_33_2_SHAKE_SSK);
        }
    }

    public static class SNOVA_75_33_2_SSK extends SignatureSpi {
        public SNOVA_75_33_2_SSK() {
            super(new SnovaSigner(), SnovaParameters.SNOVA_75_33_2_SSK);
        }
    }

    public SignatureSpi(SnovaSigner snovaSigner) {
        super("Snova");
        this.f23853bOut = new ByteArrayOutputStream();
        this.f23855signer = snovaSigner;
        this.parameters = null;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCSnovaPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to Snova");
        }
        BCSnovaPrivateKey bCSnovaPrivateKey = (BCSnovaPrivateKey) privateKey;
        SnovaPrivateKeyParameters keyParams = bCSnovaPrivateKey.getKeyParams();
        SnovaParameters snovaParameters = this.parameters;
        if (snovaParameters != null) {
            String upperCase = C6250Strings.toUpperCase(snovaParameters.m17868getName());
            if (!upperCase.equals(bCSnovaPrivateKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        SecureRandom secureRandom = this.f23854random;
        SnovaSigner snovaSigner = this.f23855signer;
        if (secureRandom != null) {
            snovaSigner.mo15864init(true, new ParametersWithRandom(keyParams, secureRandom));
        } else {
            snovaSigner.mo15864init(true, keyParams);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCSnovaPublicKey)) {
            try {
                publicKey = new BCSnovaPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeyException("unknown public key passed to Snova: " + e.getMessage());
            }
        }
        BCSnovaPublicKey bCSnovaPublicKey = (BCSnovaPublicKey) publicKey;
        SnovaParameters snovaParameters = this.parameters;
        if (snovaParameters != null) {
            String upperCase = C6250Strings.toUpperCase(snovaParameters.m17868getName());
            if (!upperCase.equals(bCSnovaPublicKey.getAlgorithm())) {
                throw new InvalidKeyException("signature configured for " + upperCase);
            }
        }
        this.f23855signer.mo15864init(false, bCSnovaPublicKey.getKeyParams());
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            byte[] byteArray = this.f23853bOut.toByteArray();
            this.f23853bOut.reset();
            return this.f23855signer.generateSignature(byteArray);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23853bOut.write(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] byteArray = this.f23853bOut.toByteArray();
        this.f23853bOut.reset();
        return this.f23855signer.verifySignature(byteArray, bArr);
    }

    public SignatureSpi(SnovaSigner snovaSigner, SnovaParameters snovaParameters) {
        super(C6250Strings.toUpperCase(snovaParameters.m17868getName()));
        this.parameters = snovaParameters;
        this.f23853bOut = new ByteArrayOutputStream();
        this.f23855signer = snovaSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23854random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23853bOut.write(bArr, i, i2);
    }
}
