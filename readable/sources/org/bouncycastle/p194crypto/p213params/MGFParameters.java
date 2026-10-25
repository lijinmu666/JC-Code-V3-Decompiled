package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;

/* loaded from: classes2.dex */
public class MGFParameters implements DerivationParameters {

    /* renamed from: seed */
    byte[] f20778seed;

    public MGFParameters(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    /* renamed from: getSeed */
    public byte[] m15775getSeed() {
        return this.f20778seed;
    }

    public MGFParameters(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f20778seed = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
