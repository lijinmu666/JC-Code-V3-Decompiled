package org.bouncycastle.p194crypto.p217signers;

import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GenericSigner implements InterfaceC5282Signer {

    /* renamed from: digest */
    private final InterfaceC5277Digest f20965digest;

    /* renamed from: engine */
    private final AsymmetricBlockCipher f20966engine;
    private boolean forSigning;

    public GenericSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest) {
        this.f20966engine = asymmetricBlockCipher;
        this.f20965digest = interfaceC5277Digest;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        if (!this.forSigning) {
            throw new IllegalStateException("GenericSigner not initialised for signature generation.");
        }
        int digestSize = this.f20965digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.f20965digest.mo14967doFinal(bArr, 0);
        return this.f20966engine.processBlock(bArr, 0, digestSize);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        AsymmetricKeyParameter asymmetricKeyParameter = cipherParameters instanceof ParametersWithRandom ? (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters() : (AsymmetricKeyParameter) cipherParameters;
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        mo14988reset();
        this.f20966engine.mo14943init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20965digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20965digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        if (this.forSigning) {
            throw new IllegalStateException("GenericSigner not initialised for verification");
        }
        int digestSize = this.f20965digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.f20965digest.mo14967doFinal(bArr2, 0);
        try {
            byte[] bArrProcessBlock = this.f20966engine.processBlock(bArr, 0, bArr.length);
            if (bArrProcessBlock.length < digestSize) {
                byte[] bArr3 = new byte[digestSize];
                System.arraycopy(bArrProcessBlock, 0, bArr3, digestSize - bArrProcessBlock.length, bArrProcessBlock.length);
                bArrProcessBlock = bArr3;
            }
            return C6238Arrays.constantTimeAreEqual(bArrProcessBlock, bArr2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20965digest.mo14970update(bArr, i, i2);
    }
}
