package org.bouncycastle.p314pqc.p316crypto.p327saber;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;

/* loaded from: classes2.dex */
public class SABERKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private SABEREngine f23456engine;

    /* renamed from: key */
    private SABERKeyParameters f23457key;

    public SABERKEMExtractor(SABERKeyParameters sABERKeyParameters) {
        this.f23457key = sABERKeyParameters;
        initCipher(sABERKeyParameters.getParameters());
    }

    private void initCipher(SABERParameters sABERParameters) {
        this.f23456engine = sABERParameters.getEngine();
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23456engine.getSessionKeySize()];
        this.f23456engine.crypto_kem_dec(bArr2, bArr, ((SABERPrivateKeyParameters) this.f23457key).getPrivateKey());
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23456engine.getCipherTextSize();
    }
}
