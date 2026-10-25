package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.Ed25519Signer;
import org.bouncycastle.p194crypto.p217signers.Ed448Signer;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;

/* loaded from: classes2.dex */
public class SignatureSpi extends java.security.SignatureSpi {
    private static final byte[] EMPTY_CONTEXT = new byte[0];
    private final String algorithm;

    /* renamed from: signer */
    private InterfaceC5282Signer f21552signer;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed25519 */
    public static final class C5568Ed25519 extends SignatureSpi {
        public C5568Ed25519() {
            super(EdDSAParameterSpec.f21918Ed25519);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed448 */
    public static final class C5569Ed448 extends SignatureSpi {
        public C5569Ed448() {
            super(EdDSAParameterSpec.f21919Ed448);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$EdDSA */
    public static final class C5570EdDSA extends SignatureSpi {
        public C5570EdDSA() {
            super(null);
        }
    }

    public SignatureSpi(String str) {
        this.algorithm = str;
    }

    private static AsymmetricKeyParameter getLwEdDSAKeyPrivate(PrivateKey privateKey) {
        return EdECUtil.generatePrivateKeyParameter(privateKey);
    }

    private static AsymmetricKeyParameter getLwEdDSAKeyPublic(PublicKey publicKey) {
        return EdECUtil.generatePublicKeyParameter(publicKey);
    }

    private InterfaceC5282Signer getSigner(String str) throws InvalidKeyException {
        String str2 = this.algorithm;
        if (str2 == null || str.equals(str2)) {
            return str.equals(EdDSAParameterSpec.f21919Ed448) ? new Ed448Signer(EMPTY_CONTEXT) : new Ed25519Signer();
        }
        throw new InvalidKeyException("inappropriate key for " + this.algorithm);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        String str;
        AsymmetricKeyParameter lwEdDSAKeyPrivate = getLwEdDSAKeyPrivate(privateKey);
        if (lwEdDSAKeyPrivate instanceof Ed25519PrivateKeyParameters) {
            str = EdDSAParameterSpec.f21918Ed25519;
        } else {
            if (!(lwEdDSAKeyPrivate instanceof Ed448PrivateKeyParameters)) {
                throw new InvalidKeyException("unsupported private key type");
            }
            str = EdDSAParameterSpec.f21919Ed448;
        }
        this.f21552signer = getSigner(str);
        this.f21552signer.mo14987init(true, lwEdDSAKeyPrivate);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        String str;
        AsymmetricKeyParameter lwEdDSAKeyPublic = getLwEdDSAKeyPublic(publicKey);
        if (lwEdDSAKeyPublic instanceof Ed25519PublicKeyParameters) {
            str = EdDSAParameterSpec.f21918Ed25519;
        } else {
            if (!(lwEdDSAKeyPublic instanceof Ed448PublicKeyParameters)) {
                throw new InvalidKeyException("unsupported public key type");
            }
            str = EdDSAParameterSpec.f21919Ed448;
        }
        this.f21552signer = getSigner(str);
        this.f21552signer.mo14987init(false, lwEdDSAKeyPublic);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f21552signer.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21552signer.mo14989update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        return this.f21552signer.verifySignature(bArr);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21552signer.mo14990update(bArr, i, i2);
    }
}
