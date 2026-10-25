package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimePublicKeyParameters extends NTRULPRimeKeyParameters {
    private final byte[] roundEncA;

    /* renamed from: seed */
    private final byte[] f23429seed;

    public NTRULPRimePublicKeyParameters(NTRULPRimeParameters nTRULPRimeParameters, byte[] bArr) {
        super(false, nTRULPRimeParameters);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, 32);
        this.f23429seed = bArrCopyOfRange;
        this.roundEncA = C6238Arrays.copyOfRange(bArr, bArrCopyOfRange.length, bArr.length);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[getParameters().getPublicKeyBytes()];
        byte[] bArr2 = this.f23429seed;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.roundEncA;
        System.arraycopy(bArr3, 0, bArr, this.f23429seed.length, bArr3.length);
        return bArr;
    }

    public byte[] getRoundEncA() {
        return this.roundEncA;
    }

    /* renamed from: getSeed */
    public byte[] m17788getSeed() {
        return this.f23429seed;
    }

    public NTRULPRimePublicKeyParameters(NTRULPRimeParameters nTRULPRimeParameters, byte[] bArr, byte[] bArr2) {
        super(false, nTRULPRimeParameters);
        this.f23429seed = C6238Arrays.m18231clone(bArr);
        this.roundEncA = C6238Arrays.m18231clone(bArr2);
    }
}
