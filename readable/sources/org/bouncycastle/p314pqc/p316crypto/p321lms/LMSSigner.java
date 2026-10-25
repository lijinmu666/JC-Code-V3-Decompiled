package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.IOException;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

/* loaded from: classes2.dex */
public class LMSSigner implements MessageSigner {

    /* renamed from: privKey */
    private LMSPrivateKeyParameters f23258privKey;

    /* renamed from: pubKey */
    private LMSPublicKeyParameters f23259pubKey;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        try {
            return C6068LMS.generateSign(this.f23258privKey, bArr).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (!(cipherParameters instanceof HSSPrivateKeyParameters)) {
                this.f23258privKey = (LMSPrivateKeyParameters) cipherParameters;
                return;
            }
            HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters) cipherParameters;
            if (hSSPrivateKeyParameters.m17614getL() != 1) {
                throw new IllegalArgumentException("only a single level HSS key can be used with LMS");
            }
            this.f23258privKey = hSSPrivateKeyParameters.getRootKey();
            return;
        }
        if (!(cipherParameters instanceof HSSPublicKeyParameters)) {
            this.f23259pubKey = (LMSPublicKeyParameters) cipherParameters;
            return;
        }
        HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters) cipherParameters;
        if (hSSPublicKeyParameters.m17618getL() != 1) {
            throw new IllegalArgumentException("only a single level HSS key can be used with LMS");
        }
        this.f23259pubKey = hSSPublicKeyParameters.getLMSPublicKey();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        try {
            return C6068LMS.verifySignature(this.f23259pubKey, LMSSignature.getInstance(bArr2), bArr);
        } catch (IOException e) {
            throw new IllegalStateException("unable to decode signature: " + e.getMessage());
        }
    }
}
