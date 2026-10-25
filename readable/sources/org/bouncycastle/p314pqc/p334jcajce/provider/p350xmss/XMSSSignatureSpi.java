package org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSSigner;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature;
import org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss.DigestUtil;

/* loaded from: classes2.dex */
public class XMSSSignatureSpi extends Signature implements StateAwareSignature {

    /* renamed from: digest */
    private InterfaceC5277Digest f23890digest;

    /* renamed from: random */
    private SecureRandom f23891random;

    /* renamed from: signer */
    private XMSSSigner f23892signer;
    private ASN1ObjectIdentifier treeDigest;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$generic */
    public static class C6213generic extends XMSSSignatureSpi {
        public C6213generic() {
            super("XMSS", new NullDigest(), new XMSSSigner());
        }
    }

    public static class withSha256 extends XMSSSignatureSpi {
        public withSha256() {
            super("XMSS-SHA256", new NullDigest(), new XMSSSigner());
        }
    }

    public static class withSha256andPrehash extends XMSSSignatureSpi {
        public withSha256andPrehash() {
            super("SHA256withXMSS-SHA256", new SHA256Digest(), new XMSSSigner());
        }
    }

    public static class withSha512 extends XMSSSignatureSpi {
        public withSha512() {
            super("XMSS-SHA512", new NullDigest(), new XMSSSigner());
        }
    }

    public static class withSha512andPrehash extends XMSSSignatureSpi {
        public withSha512andPrehash() {
            super("SHA512withXMSS-SHA512", new SHA512Digest(), new XMSSSigner());
        }
    }

    public static class withShake128 extends XMSSSignatureSpi {
        public withShake128() {
            super("XMSS-SHAKE128", new NullDigest(), new XMSSSigner());
        }
    }

    public static class withShake128_512andPrehash extends XMSSSignatureSpi {
        public withShake128_512andPrehash() {
            super("SHAKE128(512)withXMSS-SHAKE128", new DigestUtil.DoubleDigest(new SHAKEDigest(128)), new XMSSSigner());
        }
    }

    public static class withShake128andPrehash extends XMSSSignatureSpi {
        public withShake128andPrehash() {
            super("SHAKE128withXMSS-SHAKE128", new SHAKEDigest(128), new XMSSSigner());
        }
    }

    public static class withShake256 extends XMSSSignatureSpi {
        public withShake256() {
            super("XMSS-SHAKE256", new NullDigest(), new XMSSSigner());
        }
    }

    public static class withShake256_1024andPrehash extends XMSSSignatureSpi {
        public withShake256_1024andPrehash() {
            super("SHAKE256(1024)withXMSS-SHAKE256", new DigestUtil.DoubleDigest(new SHAKEDigest(256)), new XMSSSigner());
        }
    }

    public static class withShake256andPrehash extends XMSSSignatureSpi {
        public withShake256andPrehash() {
            super("SHAKE256withXMSS-SHAKE256", new SHAKEDigest(256), new XMSSSigner());
        }
    }

    public XMSSSignatureSpi(String str) {
        super(str);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCXMSSPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to XMSS");
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) privateKey;
        CipherParameters keyParams = bCXMSSPrivateKey.getKeyParams();
        this.treeDigest = bCXMSSPrivateKey.getTreeDigestOID();
        SecureRandom secureRandom = this.f23891random;
        if (secureRandom != null) {
            keyParams = new ParametersWithRandom(keyParams, secureRandom);
        }
        this.f23890digest.mo14968reset();
        this.f23892signer.mo15864init(true, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCXMSSPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to XMSS");
        }
        CipherParameters keyParams = ((BCXMSSPublicKey) publicKey).getKeyParams();
        this.treeDigest = null;
        this.f23890digest.mo14968reset();
        this.f23892signer.mo15864init(false, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f23892signer.generateSignature(DigestUtil.getDigestResult(this.f23890digest));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage(), e);
            }
            throw new SignatureException(e.toString(), e);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23890digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        return this.f23892signer.verifySignature(DigestUtil.getDigestResult(this.f23890digest), bArr);
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature
    public PrivateKey getUpdatedPrivateKey() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.treeDigest;
        if (aSN1ObjectIdentifier == null) {
            throw new IllegalStateException("signature object not in a signing state");
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = new BCXMSSPrivateKey(aSN1ObjectIdentifier, (XMSSPrivateKeyParameters) this.f23892signer.getUpdatedPrivateKey());
        this.treeDigest = null;
        return bCXMSSPrivateKey;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature
    public boolean isSigningCapable() {
        return (this.treeDigest == null || this.f23892signer.getUsagesRemaining() == 0) ? false : true;
    }

    public XMSSSignatureSpi(String str, InterfaceC5277Digest interfaceC5277Digest, XMSSSigner xMSSSigner) {
        super(str);
        this.f23890digest = interfaceC5277Digest;
        this.f23892signer = xMSSSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23891random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23890digest.mo14970update(bArr, i, i2);
    }
}
