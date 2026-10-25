package org.bouncycastle.p314pqc.p334jcajce.provider.sphincsplus;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusSigner;

/* loaded from: classes2.dex */
public class SignatureSpi extends java.security.SignatureSpi {

    /* renamed from: digest */
    private final InterfaceC5277Digest f23873digest;

    /* renamed from: signer */
    private final SPHINCSPlusSigner f23874signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.sphincsplus.SignatureSpi$Direct */
    public static class C6209Direct extends SignatureSpi {
        public C6209Direct() {
            super(new NullDigest(), new SPHINCSPlusSigner());
        }
    }

    public SignatureSpi(InterfaceC5277Digest interfaceC5277Digest, SPHINCSPlusSigner sPHINCSPlusSigner) {
        this.f23873digest = interfaceC5277Digest;
        this.f23874signer = sPHINCSPlusSigner;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCSPHINCSPlusPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to SPHINCS+");
        }
        SPHINCSPlusPrivateKeyParameters keyParams = ((BCSPHINCSPlusPrivateKey) privateKey).getKeyParams();
        SecureRandom secureRandom = ((java.security.SignatureSpi) this).appRandom;
        SPHINCSPlusSigner sPHINCSPlusSigner = this.f23874signer;
        if (secureRandom != null) {
            sPHINCSPlusSigner.mo15864init(true, new ParametersWithRandom(keyParams, secureRandom));
        } else {
            sPHINCSPlusSigner.mo15864init(true, keyParams);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCSPHINCSPlusPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to SPHINCS+");
        }
        this.f23874signer.mo15864init(false, ((BCSPHINCSPlusPublicKey) publicKey).getKeyParams());
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f23873digest.getDigestSize()];
        this.f23873digest.mo14967doFinal(bArr, 0);
        try {
            return this.f23874signer.generateSignature(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23873digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23873digest.getDigestSize()];
        this.f23873digest.mo14967doFinal(bArr2, 0);
        return this.f23874signer.verifySignature(bArr2, bArr);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        ((java.security.SignatureSpi) this).appRandom = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23873digest.mo14970update(bArr, i, i2);
    }
}
