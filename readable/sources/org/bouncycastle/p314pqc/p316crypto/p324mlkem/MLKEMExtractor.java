package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private final MLKEMEngine f23338engine;
    private final MLKEMPrivateKeyParameters privateKey;

    public MLKEMExtractor(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters) {
        if (mLKEMPrivateKeyParameters == null) {
            throw new NullPointerException("'privateKey' cannot be null");
        }
        this.privateKey = mLKEMPrivateKeyParameters;
        this.f23338engine = mLKEMPrivateKeyParameters.getParameters().getEngine();
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        if (bArr.length == getEncapsulationLength()) {
            return this.f23338engine.kemDecrypt(this.privateKey, bArr);
        }
        throw new IllegalArgumentException("encapsulation wrong length");
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23338engine.getCipherTextBytes();
    }
}
