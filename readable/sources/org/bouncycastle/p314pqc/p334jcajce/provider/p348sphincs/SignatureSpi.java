package org.bouncycastle.p314pqc.p334jcajce.provider.p348sphincs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512tDigest;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCS256Signer;

/* loaded from: classes2.dex */
public class SignatureSpi extends java.security.SignatureSpi {

    /* renamed from: digest */
    private InterfaceC5277Digest f23862digest;

    /* renamed from: random */
    private SecureRandom f23863random;

    /* renamed from: signer */
    private SPHINCS256Signer f23864signer;
    private final ASN1ObjectIdentifier treeDigest;

    public static class withSha3_512 extends SignatureSpi {
        public withSha3_512() {
            super(new SHA3Digest(512), NISTObjectIdentifiers.id_sha3_256, new SPHINCS256Signer(new SHA3Digest(256), new SHA3Digest(512)));
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), NISTObjectIdentifiers.id_sha512_256, new SPHINCS256Signer(new SHA512tDigest(256), new SHA512Digest()));
        }
    }

    public SignatureSpi(InterfaceC5277Digest interfaceC5277Digest, ASN1ObjectIdentifier aSN1ObjectIdentifier, SPHINCS256Signer sPHINCS256Signer) {
        this.f23862digest = interfaceC5277Digest;
        this.treeDigest = aSN1ObjectIdentifier;
        this.f23864signer = sPHINCS256Signer;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCSphincs256PrivateKey)) {
            throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
        }
        BCSphincs256PrivateKey bCSphincs256PrivateKey = (BCSphincs256PrivateKey) privateKey;
        if (this.treeDigest.m14446equals((ASN1Primitive) bCSphincs256PrivateKey.getTreeDigest())) {
            CipherParameters keyParams = bCSphincs256PrivateKey.getKeyParams();
            this.f23862digest.mo14968reset();
            this.f23864signer.mo15864init(true, keyParams);
        } else {
            throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + bCSphincs256PrivateKey.getTreeDigest());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof BCSphincs256PublicKey)) {
            throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) publicKey;
        if (this.treeDigest.m14446equals((ASN1Primitive) bCSphincs256PublicKey.getTreeDigest())) {
            CipherParameters keyParams = bCSphincs256PublicKey.getKeyParams();
            this.f23862digest.mo14968reset();
            this.f23864signer.mo15864init(false, keyParams);
        } else {
            throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + bCSphincs256PublicKey.getTreeDigest());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f23862digest.getDigestSize()];
        this.f23862digest.mo14967doFinal(bArr, 0);
        try {
            return this.f23864signer.generateSignature(bArr);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f23862digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23862digest.getDigestSize()];
        this.f23862digest.mo14967doFinal(bArr2, 0);
        return this.f23864signer.verifySignature(bArr2, bArr);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f23863random = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f23862digest.mo14970update(bArr, i, i2);
    }
}
