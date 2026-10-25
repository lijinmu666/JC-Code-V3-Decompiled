package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class KDFFeedbackParameters implements DerivationParameters {
    private static final int UNUSED_R = -1;
    private final byte[] fixedInputData;

    /* renamed from: iv */
    private final byte[] f20772iv;

    /* renamed from: ki */
    private final byte[] f20773ki;

    /* renamed from: r */
    private final int f20774r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f20773ki = C6238Arrays.m18231clone(bArr);
        if (bArr3 == null) {
            this.fixedInputData = new byte[0];
        } else {
            this.fixedInputData = C6238Arrays.m18231clone(bArr3);
        }
        this.f20774r = i;
        if (bArr2 == null) {
            this.f20772iv = new byte[0];
        } else {
            this.f20772iv = C6238Arrays.m18231clone(bArr2);
        }
        this.useCounter = z;
    }

    public static KDFFeedbackParameters createWithCounter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (i == 8 || i == 16 || i == 24 || i == 32) {
            return new KDFFeedbackParameters(bArr, bArr2, bArr3, i, true);
        }
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] getFixedInputData() {
        return C6238Arrays.m18231clone(this.fixedInputData);
    }

    /* renamed from: getIV */
    public byte[] m15768getIV() {
        return this.f20772iv;
    }

    /* renamed from: getKI */
    public byte[] m15769getKI() {
        return this.f20773ki;
    }

    /* renamed from: getR */
    public int m15770getR() {
        return this.f20774r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
