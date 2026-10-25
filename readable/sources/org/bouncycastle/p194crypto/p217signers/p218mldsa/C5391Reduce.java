package org.bouncycastle.p194crypto.p217signers.p218mldsa;

/* renamed from: org.bouncycastle.crypto.signers.mldsa.Reduce */
/* loaded from: classes2.dex */
class C5391Reduce {
    public static int conditionalAddQ(int i) {
        return i + ((i >> 31) & 8380417);
    }

    public static int montgomeryReduce(long j) {
        return (int) ((j - (((int) (58728449 * j)) * 8380417)) >>> 32);
    }

    public static int reduce32(int i) {
        return i - (((4194304 + i) >> 23) * 8380417);
    }
}
