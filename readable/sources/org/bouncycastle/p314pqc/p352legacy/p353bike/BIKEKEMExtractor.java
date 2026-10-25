package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BIKEKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: engine */
    private BIKEEngine f23937engine;

    /* renamed from: key */
    private BIKEKeyParameters f23938key;

    public BIKEKEMExtractor(BIKEPrivateKeyParameters bIKEPrivateKeyParameters) {
        this.f23938key = bIKEPrivateKeyParameters;
        initCipher(bIKEPrivateKeyParameters.getParameters());
    }

    private void initCipher(BIKEParameters bIKEParameters) {
        this.f23937engine = bIKEParameters.getEngine();
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23937engine.getSessionKeySize()];
        BIKEPrivateKeyParameters bIKEPrivateKeyParameters = (BIKEPrivateKeyParameters) this.f23938key;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, bIKEPrivateKeyParameters.getParameters().getRByte());
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, bIKEPrivateKeyParameters.getParameters().getRByte(), bArr.length);
        this.f23937engine.m18061decaps(bArr2, bIKEPrivateKeyParameters.m18069getH0(), bIKEPrivateKeyParameters.m18070getH1(), bIKEPrivateKeyParameters.getSigma(), bArrCopyOfRange, bArrCopyOfRange2);
        return C6238Arrays.copyOfRange(bArr2, 0, this.f23938key.getParameters().getSessionKeySize() / 8);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f23938key.getParameters().getRByte() + this.f23938key.getParameters().getLByte();
    }
}
