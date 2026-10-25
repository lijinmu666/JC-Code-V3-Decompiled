package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class RC2Parameters extends KeyParameter {

    /* renamed from: bits */
    private int f20818bits;

    public RC2Parameters(byte[] bArr) {
        this(bArr, bArr.length > 128 ? 1024 : bArr.length * 8);
    }

    public int getEffectiveKeyBits() {
        return this.f20818bits;
    }

    public RC2Parameters(byte[] bArr, int i) {
        super(bArr);
        this.f20818bits = i;
    }
}
