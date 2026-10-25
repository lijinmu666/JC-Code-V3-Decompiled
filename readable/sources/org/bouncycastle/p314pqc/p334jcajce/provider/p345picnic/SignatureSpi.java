package org.bouncycastle.p314pqc.p334jcajce.provider.p345picnic;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicSigner;

/* loaded from: classes2.dex */
public class SignatureSpi extends Signature {

    /* renamed from: digest */
    private InterfaceC5277Digest f23838digest;

    /* renamed from: random */
    private SecureRandom f23839random;

    /* renamed from: signer */
    private PicnicSigner f23840signer;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.picnic.SignatureSpi$Base */
    public static class C6206Base extends SignatureSpi {
        public C6206Base() {
            super(new NullDigest(), new PicnicSigner());
        }
    }

    public static class withSha3512 extends SignatureSpi {
        public withSha3512() {
            super(new SHA3Digest(512), new PicnicSigner());
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), new PicnicSigner());
        }
    }

    public static class withShake256 extends SignatureSpi {
        public withShake256() {
            super(new SHAKEDigest(256), new PicnicSigner());
        }
    }

    public SignatureSpi(InterfaceC5277Digest interfaceC5277Digest, PicnicSigner picnicSigner) {
        super("Picnic");
        this.f23838digest = interfaceC5277Digest;
        this.f23840signer = picnicSigner;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCPicnicPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to Picnic");
        }
        PicnicPrivateKeyParameters keyParams = ((BCPicnicPrivateKey) privateKey).getKeyParams();
        this.f23838digest.mo14968reset();
        this.f23840signer.mo15864init(true, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCPicnicPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to Picnic");
        }
        PicnicPublicKeyParameters keyParams = ((BCPicnicPublicKey) publicKey).getKeyParams();
        this.f23838digest.mo14968reset();
        this.f23840signer.mo15864init(false, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f23838digest.getDigestSize()];
        this.f23838digest.mo14967doFinal(bArr, 0);
        try {
            return this.f23840signer.generateSignature(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23838digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23838digest.getDigestSize()];
        this.f23838digest.mo14967doFinal(bArr2, 0);
        return this.f23840signer.verifySignature(bArr2, bArr);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23839random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23838digest.mo14970update(bArr, i, i2);
    }
}
