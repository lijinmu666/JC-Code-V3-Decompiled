package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class NHAgreement {

    /* renamed from: privKey */
    private NHPrivateKeyParameters f23358privKey;

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        byte[] bArr = new byte[32];
        C6085NewHope.m17748sharedA(bArr, this.f23358privKey.f23364secData, ((NHPublicKeyParameters) cipherParameters).f23365pubData);
        return bArr;
    }

    /* renamed from: init */
    public void m17737init(CipherParameters cipherParameters) {
        this.f23358privKey = (NHPrivateKeyParameters) cipherParameters;
    }
}
