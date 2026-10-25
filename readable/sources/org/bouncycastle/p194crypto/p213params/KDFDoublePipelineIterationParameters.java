package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class KDFDoublePipelineIterationParameters implements DerivationParameters {
    private static final int UNUSED_R = 32;
    private final byte[] fixedInputData;

    /* renamed from: ki */
    private final byte[] f20770ki;

    /* renamed from: r */
    private final int f20771r;
    private final boolean useCounter;

    private KDFDoublePipelineIterationParameters(byte[] bArr, byte[] bArr2, int i, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f20770ki = C6238Arrays.m18231clone(bArr);
        if (bArr2 == null) {
            this.fixedInputData = new byte[0];
        } else {
            this.fixedInputData = C6238Arrays.m18231clone(bArr2);
        }
        if (i != 8 && i != 16 && i != 24 && i != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        this.f20771r = i;
        this.useCounter = z;
    }

    public static KDFDoublePipelineIterationParameters createWithCounter(byte[] bArr, byte[] bArr2, int i) {
        return new KDFDoublePipelineIterationParameters(bArr, bArr2, i, true);
    }

    public static KDFDoublePipelineIterationParameters createWithoutCounter(byte[] bArr, byte[] bArr2) {
        return new KDFDoublePipelineIterationParameters(bArr, bArr2, 32, false);
    }

    public byte[] getFixedInputData() {
        return C6238Arrays.m18231clone(this.fixedInputData);
    }

    /* renamed from: getKI */
    public byte[] m15766getKI() {
        return this.f20770ki;
    }

    /* renamed from: getR */
    public int m15767getR() {
        return this.f20771r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
