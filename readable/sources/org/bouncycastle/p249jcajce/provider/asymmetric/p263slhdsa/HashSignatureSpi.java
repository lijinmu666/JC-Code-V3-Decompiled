package org.bouncycastle.p249jcajce.provider.asymmetric.p263slhdsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.HashSLHDSASigner;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature;

/* loaded from: classes2.dex */
public class HashSignatureSpi extends BaseDeterministicOrRandomSignature {

    /* renamed from: signer */
    private final HashSLHDSASigner f21623signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.slhdsa.HashSignatureSpi$Direct */
    public static class C5607Direct extends HashSignatureSpi {
        public C5607Direct() {
            super(new HashSLHDSASigner());
        }
    }

    public HashSignatureSpi(HashSLHDSASigner hashSLHDSASigner) {
        super("HASH-SLH-DSA");
        this.f21623signer = hashSLHDSASigner;
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        if (!(this.keyParams instanceof SLHDSAPrivateKeyParameters)) {
            throw new SignatureException("engine initialized for verification");
        }
        try {
            try {
                return this.f21623signer.generateSignature();
            } catch (Exception e) {
                throw new SignatureException(e.toString());
            }
        } finally {
            this.isInitState = true;
        }
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        if (!(this.keyParams instanceof SLHDSAPublicKeyParameters)) {
            throw new SignatureException("engine initialized for signing");
        }
        try {
            return this.f21623signer.verifySignature(bArr);
        } finally {
            this.isInitState = true;
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void reInitialize(boolean z, CipherParameters cipherParameters) {
        this.f21623signer.mo14987init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void signInit(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        ((SignatureSpi) this).appRandom = secureRandom;
        if (!(privateKey instanceof BCSLHDSAPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to SLH-DSA");
        }
        this.keyParams = ((BCSLHDSAPrivateKey) privateKey).getKeyParams();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseDeterministicOrRandomSignature
    public void updateEngine(byte b) {
        this.f21623signer.mo14989update(b);
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
        this.f21623signer.mo14990update(bArr, i, i2);
    }
}
