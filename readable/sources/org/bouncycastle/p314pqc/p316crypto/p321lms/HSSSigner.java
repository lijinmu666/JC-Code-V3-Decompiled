package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

/* loaded from: classes2.dex */
public class HSSSigner implements MessageSigner {

    /* renamed from: privKey */
    private HSSPrivateKeyParameters f23224privKey;

    /* renamed from: pubKey */
    private HSSPublicKeyParameters f23225pubKey;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        try {
            return C6066HSS.generateSignature(this.f23224privKey, bArr).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.f23224privKey = (HSSPrivateKeyParameters) cipherParameters;
        } else {
            this.f23225pubKey = (HSSPublicKeyParameters) cipherParameters;
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        try {
            HSSPublicKeyParameters hSSPublicKeyParameters = this.f23225pubKey;
            return C6066HSS.verifySignature(hSSPublicKeyParameters, HSSSignature.getInstance(bArr2, hSSPublicKeyParameters.m17618getL()), bArr);
        } catch (IOException e) {
            throw new IllegalStateException("unable to decode signature: " + e.getMessage());
        }
    }
}
