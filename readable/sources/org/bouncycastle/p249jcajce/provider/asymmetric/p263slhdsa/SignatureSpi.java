package org.bouncycastle.p249jcajce.provider.asymmetric.p263slhdsa;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.SLHDSASigner;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature;

/* loaded from: classes2.dex */
public class SignatureSpi extends BaseDeterministicOrRandomSignature {

    /* renamed from: bOut */
    private final ByteArrayOutputStream f21627bOut;

    /* renamed from: signer */
    private final SLHDSASigner f21628signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.slhdsa.SignatureSpi$Direct */
    public static class C5612Direct extends SignatureSpi {
        public C5612Direct() {
            super(new SLHDSASigner());
        }
    }

    public SignatureSpi(SLHDSASigner sLHDSASigner) {
        super("SLH-DSA");
        this.f21627bOut = new ByteArrayOutputStream();
        this.f21628signer = sLHDSASigner;
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        if (!(this.keyParams instanceof SLHDSAPrivateKeyParameters)) {
            throw new SignatureException("engine initialized for verification");
        }
        try {
            try {
                return this.f21628signer.generateSignature(this.f21627bOut.toByteArray());
            } catch (Exception e) {
                throw new SignatureException(e.toString());
            }
        } finally {
            this.isInitState = true;
            this.f21627bOut.reset();
        }
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        if (!(this.keyParams instanceof SLHDSAPublicKeyParameters)) {
            throw new SignatureException("engine initialized for signing");
        }
        try {
            return this.f21628signer.verifySignature(this.f21627bOut.toByteArray(), bArr);
        } finally {
            this.isInitState = true;
            this.f21627bOut.reset();
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void reInitialize(boolean z, CipherParameters cipherParameters) {
        this.f21628signer.mo15864init(z, cipherParameters);
        this.f21627bOut.reset();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void signInit(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        ((java.security.SignatureSpi) this).appRandom = secureRandom;
        if (!(privateKey instanceof BCSLHDSAPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to SLH-DSA");
        }
        this.keyParams = ((BCSLHDSAPrivateKey) privateKey).getKeyParams();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte b) {
        this.f21627bOut.write(b);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void verifyInit(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCSLHDSAPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to SLH-DSA");
        }
        this.keyParams = ((BCSLHDSAPublicKey) publicKey).getKeyParams();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte[] bArr, int i, int i2) {
        this.f21627bOut.write(bArr, i, i2);
    }
}
