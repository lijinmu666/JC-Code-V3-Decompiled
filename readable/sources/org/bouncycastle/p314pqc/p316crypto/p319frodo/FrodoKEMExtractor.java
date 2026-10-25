package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;

/* loaded from: classes2.dex */
public class FrodoKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private FrodoEngine f23160engine;

    /* renamed from: key */
    private FrodoKeyParameters f23161key;

    public FrodoKEMExtractor(FrodoKeyParameters frodoKeyParameters) {
        this.f23161key = frodoKeyParameters;
        initCipher(frodoKeyParameters.getParameters());
    }

    private void initCipher(FrodoParameters frodoParameters) {
        this.f23160engine = frodoParameters.getEngine();
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23160engine.getSessionKeySize()];
        this.f23160engine.m17564kem_dec(bArr2, bArr, ((FrodoPrivateKeyParameters) this.f23161key).getPrivateKey());
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23160engine.getCipherTextSize();
    }
}
