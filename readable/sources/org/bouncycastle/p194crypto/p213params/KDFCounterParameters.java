package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class KDFCounterParameters implements DerivationParameters {
    private byte[] fixedInputDataCounterPrefix;
    private byte[] fixedInputDataCounterSuffix;

    /* renamed from: ki */
    private byte[] f20768ki;

    /* renamed from: r */
    private int f20769r;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, null, bArr2, i);
    }

    public byte[] getFixedInputData() {
        return C6238Arrays.m18231clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return C6238Arrays.m18231clone(this.fixedInputDataCounterPrefix);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return C6238Arrays.m18231clone(this.fixedInputDataCounterSuffix);
    }

    /* renamed from: getKI */
    public byte[] m15764getKI() {
        return this.f20768ki;
    }

    /* renamed from: getR */
    public int m15765getR() {
        return this.f20769r;
    }

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f20768ki = C6238Arrays.m18231clone(bArr);
        if (bArr2 == null) {
            this.fixedInputDataCounterPrefix = new byte[0];
        } else {
            this.fixedInputDataCounterPrefix = C6238Arrays.m18231clone(bArr2);
        }
        if (bArr3 == null) {
            this.fixedInputDataCounterSuffix = new byte[0];
        } else {
            this.fixedInputDataCounterSuffix = C6238Arrays.m18231clone(bArr3);
        }
        if (i != 8 && i != 16 && i != 24 && i != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        this.f20769r = i;
    }
}
