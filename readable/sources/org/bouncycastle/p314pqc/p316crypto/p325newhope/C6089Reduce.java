package org.bouncycastle.p314pqc.p316crypto.p325newhope;

/* renamed from: org.bouncycastle.pqc.crypto.newhope.Reduce */
/* loaded from: classes2.dex */
class C6089Reduce {

    /* renamed from: QInv */
    static final int f23374QInv = 12287;

    /* renamed from: RLog */
    static final int f23375RLog = 18;

    /* renamed from: RMask */
    static final int f23376RMask = 262143;

    /* renamed from: barrett */
    public static short m17755barrett(short s) {
        int i = s & 65535;
        return (short) (i - (((i * 5) >>> 16) * 12289));
    }

    public static short montgomery(int i) {
        return (short) (((((i * f23374QInv) & f23376RMask) * 12289) + i) >>> 18);
    }
}
