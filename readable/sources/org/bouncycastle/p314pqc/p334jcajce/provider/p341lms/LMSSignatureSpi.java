package org.bouncycastle.p314pqc.p334jcajce.provider.p341lms;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p314pqc.p316crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContext;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedVerifier;

/* loaded from: classes2.dex */
public class LMSSignatureSpi extends Signature {

    /* renamed from: digest */
    private InterfaceC5277Digest f23775digest;
    private LMSContextBasedSigner lmOtsSigner;
    private LMSContextBasedVerifier lmOtsVerifier;

    /* renamed from: random */
    private SecureRandom f23776random;

    /* renamed from: signer */
    private MessageSigner f23777signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi$generic */
    public static class C6188generic extends LMSSignatureSpi {
        public C6188generic() {
            super("LMS", new NullDigest());
        }
    }

    public LMSSignatureSpi(String str) {
        super(str);
    }

    private InterfaceC5277Digest getSigner() throws SignatureException {
        try {
            return this.lmOtsSigner.generateLMSContext();
        } catch (ExhaustedPrivateKeyException e) {
            throw new SignatureException(e.getMessage(), e);
        }
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCLMSPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to LMS");
        }
        LMSContextBasedSigner lMSContextBasedSigner = (LMSContextBasedSigner) ((BCLMSPrivateKey) privateKey).getKeyParams();
        this.lmOtsSigner = lMSContextBasedSigner;
        if (lMSContextBasedSigner.getUsagesRemaining() == 0) {
            throw new InvalidKeyException("private key exhausted");
        }
        this.f23775digest = null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCLMSPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to LMS");
        }
        NullDigest nullDigest = new NullDigest();
        this.f23775digest = nullDigest;
        nullDigest.mo14968reset();
        this.lmOtsVerifier = (LMSContextBasedVerifier) ((BCLMSPublicKey) publicKey).getKeyParams();
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        if (this.f23775digest == null) {
            this.f23775digest = getSigner();
        }
        try {
            byte[] bArrGenerateSignature = this.lmOtsSigner.generateSignature((LMSContext) this.f23775digest);
            this.f23775digest = null;
            return bArrGenerateSignature;
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage(), e);
            }
            throw new SignatureException(e.toString(), e);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        if (this.f23775digest == null) {
            this.f23775digest = getSigner();
        }
        this.f23775digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        LMSContext lMSContextGenerateLMSContext = this.lmOtsVerifier.generateLMSContext(bArr);
        byte[] digestResult = DigestUtil.getDigestResult(this.f23775digest);
        lMSContextGenerateLMSContext.mo14970update(digestResult, 0, digestResult.length);
        return this.lmOtsVerifier.mo17619verify(lMSContextGenerateLMSContext);
    }

    public LMSSignatureSpi(String str, InterfaceC5277Digest interfaceC5277Digest) {
        super(str);
        this.f23775digest = interfaceC5277Digest;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23776random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        if (this.f23775digest == null) {
            this.f23775digest = getSigner();
        }
        this.f23775digest.mo14970update(bArr, i, i2);
    }
}
