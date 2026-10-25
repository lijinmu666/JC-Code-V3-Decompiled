package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HQCKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private final HQCEngine f23194engine;
    private final HQCPrivateKeyParameters privateKey;

    public HQCKEMExtractor(HQCPrivateKeyParameters hQCPrivateKeyParameters) {
        if (hQCPrivateKeyParameters == null) {
            throw new NullPointerException("'privateKey' cannot be null");
        }
        this.privateKey = hQCPrivateKeyParameters;
        this.f23194engine = hQCPrivateKeyParameters.getParameters().getEngine();
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        this.f23194engine.m17590decaps(bArr2, bArr, this.privateKey.getPrivateKey());
        return C6238Arrays.copyOfRange(bArr2, 0, 32);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23194engine.getCipherTextBytes();
    }
}
