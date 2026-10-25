package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMCEPrivateKeyParameters extends CMCEKeyParameters {
    private final byte[] privateKey;

    public CMCEPrivateKeyParameters(CMCEParameters cMCEParameters, byte[] bArr) {
        super(true, cMCEParameters);
        this.privateKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getAlpha() {
        return C6238Arrays.copyOfRange(this.privateKey, (getParameters().m17500getT() * 2) + 40, this.privateKey.length - 32);
    }

    /* renamed from: getC */
    public byte[] m17501getC() {
        return C6238Arrays.copyOfRange(this.privateKey, 32, 40);
    }

    public byte[] getDelta() {
        return C6238Arrays.copyOfRange(this.privateKey, 0, 32);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.privateKey);
    }

    /* renamed from: getG */
    public byte[] m17502getG() {
        return C6238Arrays.copyOfRange(this.privateKey, 40, (getParameters().m17500getT() * 2) + 40);
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.privateKey);
    }

    /* renamed from: getS */
    public byte[] m17503getS() {
        byte[] bArr = this.privateKey;
        return C6238Arrays.copyOfRange(bArr, bArr.length - 32, bArr.length);
    }

    public byte[] reconstructPublicKey() {
        return getParameters().getEngine().generate_public_key_from_private_key(this.privateKey);
    }

    public CMCEPrivateKeyParameters(CMCEParameters cMCEParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(true, cMCEParameters);
        byte[] bArr6 = new byte[bArr.length + bArr2.length + bArr3.length + bArr4.length + bArr5.length];
        this.privateKey = bArr6;
        System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
        int length2 = length + bArr2.length;
        System.arraycopy(bArr3, 0, bArr6, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        System.arraycopy(bArr4, 0, bArr6, length3, bArr4.length);
        System.arraycopy(bArr5, 0, bArr6, length3 + bArr4.length, bArr5.length);
    }
}
