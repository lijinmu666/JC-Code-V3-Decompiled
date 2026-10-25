package org.bouncycastle.p314pqc.p316crypto.p319frodo;

/* renamed from: org.bouncycastle.pqc.crypto.frodo.Noise */
/* loaded from: classes2.dex */
abstract class AbstractC6062Noise {
    /* renamed from: sample */
    public static void m17570sample(short[] sArr, short[] sArr2, int i, short[] sArr3) {
        int length = sArr3.length;
        for (int i2 = 0; i2 < length; i2++) {
            short s = sArr2[i + i2];
            int i3 = (65535 & s) >>> 1;
            int i4 = s & 1;
            int i5 = 0;
            for (int i6 = 0; i6 < sArr.length - 1; i6++) {
                i5 += (sArr[i6] - i3) >>> 31;
            }
            sArr3[i2] = (short) (((-i4) ^ i5) + i4);
        }
    }
}
