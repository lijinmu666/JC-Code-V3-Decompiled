package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.crypto.cmce.Utils */
/* loaded from: classes2.dex */
class C6057Utils {
    /* renamed from: bitrev */
    public static short m17509bitrev(short s, int i) {
        short s2 = (short) (((s & 65280) >> 8) | ((s & 255) << 8));
        short s3 = (short) (((s2 & 61680) >> 4) | ((s2 & 3855) << 4));
        short s4 = (short) (((s3 & 52428) >> 2) | ((s3 & 13107) << 2));
        short s5 = (short) (((s4 & 43690) >> 1) | ((s4 & 21845) << 1));
        return (short) (i == 12 ? s5 >> 4 : s5 >> 3);
    }

    /* renamed from: load4 */
    public static int m17510load4(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToInt(bArr, i);
    }

    /* renamed from: load8 */
    public static long m17511load8(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToLong(bArr, i);
    }

    /* renamed from: load_gf */
    public static short m17512load_gf(byte[] bArr, int i, int i2) {
        return (short) (AbstractC6245Pack.littleEndianToShort(bArr, i) & i2);
    }

    /* renamed from: store8 */
    public static void m17513store8(byte[] bArr, int i, long j) {
        bArr[i] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >> 8) & 255);
        bArr[i + 2] = (byte) ((j >> 16) & 255);
        bArr[i + 3] = (byte) ((j >> 24) & 255);
        bArr[i + 4] = (byte) ((j >> 32) & 255);
        bArr[i + 5] = (byte) ((j >> 40) & 255);
        bArr[i + 6] = (byte) ((j >> 48) & 255);
        bArr[i + 7] = (byte) ((j >> 56) & 255);
    }

    public static void store_gf(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
        bArr[i + 1] = (byte) (s >> 8);
    }
}
