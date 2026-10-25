package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PicnicSigner implements MessageSigner {

    /* renamed from: privKey */
    private PicnicPrivateKeyParameters f23975privKey;

    /* renamed from: pubKey */
    private PicnicPublicKeyParameters f23976pubKey;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        PicnicEngine engine = this.f23975privKey.getParameters().getEngine();
        byte[] bArr2 = new byte[engine.getSignatureSize(bArr.length)];
        engine.crypto_sign(bArr2, bArr, this.f23975privKey.getEncoded());
        byte[] bArr3 = new byte[engine.getTrueSignatureSize()];
        System.arraycopy(bArr2, bArr.length + 4, bArr3, 0, engine.getTrueSignatureSize());
        return bArr3;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.f23975privKey = (PicnicPrivateKeyParameters) cipherParameters;
        } else {
            this.f23976pubKey = (PicnicPublicKeyParameters) cipherParameters;
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        PicnicEngine engine = this.f23976pubKey.getParameters().getEngine();
        byte[] bArr3 = new byte[bArr.length];
        boolean zCrypto_sign_open = engine.crypto_sign_open(bArr3, C6238Arrays.concatenate(AbstractC6245Pack.intToLittleEndian(bArr2.length), bArr, bArr2), this.f23976pubKey.getEncoded());
        if (C6238Arrays.areEqual(bArr, bArr3)) {
            return zCrypto_sign_open;
        }
        return false;
    }
}
