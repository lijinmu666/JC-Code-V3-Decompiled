package org.bouncycastle.p194crypto.p207kems;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.p207kems.p208mlkem.MLKEMEngine;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;

/* loaded from: classes2.dex */
public class MLKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private final MLKEMEngine f20375engine;
    private final MLKEMPrivateKeyParameters privateKey;

    public MLKEMExtractor(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters) {
        if (mLKEMPrivateKeyParameters == null) {
            throw new NullPointerException("'privateKey' cannot be null");
        }
        this.privateKey = mLKEMPrivateKeyParameters;
        this.f20375engine = MLKEMEngine.getInstance(mLKEMPrivateKeyParameters.getParameters());
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        if (bArr.length == getEncapsulationLength()) {
            return this.f20375engine.kemDecrypt(this.privateKey, bArr);
        }
        throw new IllegalArgumentException("encapsulation wrong length");
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f20375engine.getCipherTextBytes();
    }
}
