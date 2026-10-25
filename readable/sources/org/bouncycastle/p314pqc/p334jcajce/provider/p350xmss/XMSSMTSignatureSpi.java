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
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTSigner;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature;
import org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss.DigestUtil;

/* loaded from: classes2.dex */
public class XMSSMTSignatureSpi extends Signature implements StateAwareSignature {

    /* renamed from: digest */
    private InterfaceC5277Digest f23887digest;

    /* renamed from: random */
    private SecureRandom f23888random;

    /* renamed from: signer */
    private XMSSMTSigner f23889signer;
    private ASN1ObjectIdentifier treeDigest;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$generic */
    public static class C6212generic extends XMSSMTSignatureSpi {
        public C6212generic() {
            super("XMSSMT", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha256 extends XMSSMTSignatureSpi {
        public withSha256() {
            super("XMSSMT-SHA256", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha256andPrehash extends XMSSMTSignatureSpi {
        public withSha256andPrehash() {
            super("SHA256withXMSSMT-SHA256", new SHA256Digest(), new XMSSMTSigner());
        }
    }

    public static class withSha512 extends XMSSMTSignatureSpi {
        public withSha512() {
            super("XMSSMT-SHA512", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha512andPrehash extends XMSSMTSignatureSpi {
        public withSha512andPrehash() {
            super("SHA512withXMSSMT-SHA512", new SHA512Digest(), new XMSSMTSigner());
        }
    }

    public static class withShake128 extends XMSSMTSignatureSpi {
        public withShake128() {
            super("XMSSMT-SHAKE128", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withShake128_512andPrehash extends XMSSMTSignatureSpi {
        public withShake128_512andPrehash() {
            super("SHAKE128(512)withXMSSMT-SHAKE128", new DigestUtil.DoubleDigest(new SHAKEDigest(128)), new XMSSMTSigner());
        }
    }

    public static class withShake128andPrehash extends XMSSMTSignatureSpi {
        public withShake128andPrehash() {
            super("SHAKE128withXMSSMT-SHAKE128", new SHAKEDigest(128), new XMSSMTSigner());
        }
    }

    public static class withShake256 extends XMSSMTSignatureSpi {
        public withShake256() {
            super("XMSSMT-SHAKE256", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withShake256_1024andPrehash extends XMSSMTSignatureSpi {
        public withShake256_1024andPrehash() {
            super("SHAKE256(1024)withXMSSMT-SHAKE256", new DigestUtil.DoubleDigest(new SHAKEDigest(256)), new XMSSMTSigner());
        }
    }

    public static class withShake256andPrehash extends XMSSMTSignatureSpi {
        public withShake256andPrehash() {
            super("SHAKE256withXMSSMT-SHAKE256", new SHAKEDigest(256), new XMSSMTSigner());
        }
    }

    public XMSSMTSignatureSpi(String str) {
        super(str);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCXMSSMTPrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to XMSSMT");
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) privateKey;
        CipherParameters keyParams = bCXMSSMTPrivateKey.getKeyParams();
        this.treeDigest = bCXMSSMTPrivateKey.getTreeDigestOID();
        SecureRandom secureRandom = this.f23888random;
        if (secureRandom != null) {
            keyParams = new ParametersWithRandom(keyParams, secureRandom);
        }
        this.f23887digest.mo14968reset();
        this.f23889signer.mo15864init(true, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCXMSSMTPublicKey)) {
            throw new InvalidKeyException("unknown public key passed to XMSSMT");
        }
        CipherParameters keyParams = ((BCXMSSMTPublicKey) publicKey).getKeyParams();
        this.treeDigest = null;
        this.f23887digest.mo14968reset();
        this.f23889signer.mo15864init(false, keyParams);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        try {
            return this.f23889signer.generateSignature(DigestUtil.getDigestResult(this.f23887digest));
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw new SignatureException(e.getMessage(), e);
            }
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23887digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        return this.f23889signer.verifySignature(DigestUtil.getDigestResult(this.f23887digest), bArr);
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature
    public PrivateKey getUpdatedPrivateKey() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.treeDigest;
        if (aSN1ObjectIdentifier == null) {
            throw new IllegalStateException("signature object not in a signing state");
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = new BCXMSSMTPrivateKey(aSN1ObjectIdentifier, (XMSSMTPrivateKeyParameters) this.f23889signer.getUpdatedPrivateKey());
        this.treeDigest = null;
        return bCXMSSMTPrivateKey;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.StateAwareSignature
    public boolean isSigningCapable() {
        return (this.treeDigest == null || this.f23889signer.getUsagesRemaining() == 0) ? false : true;
    }

    public XMSSMTSignatureSpi(String str, InterfaceC5277Digest interfaceC5277Digest, XMSSMTSigner xMSSMTSigner) {
        super(str);
        this.f23887digest = interfaceC5277Digest;
        this.f23889signer = xMSSMTSigner;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23888random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23887digest.mo14970update(bArr, i, i2);
    }
}
