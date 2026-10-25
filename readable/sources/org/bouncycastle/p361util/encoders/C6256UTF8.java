package org.bouncycastle.p361util.encoders;

import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* renamed from: org.bouncycastle.util.encoders.UTF8 */
/* loaded from: classes2.dex */
public class C6256UTF8 {

    /* renamed from: C_CR1 */
    private static final byte f24219C_CR1 = 1;

    /* renamed from: C_CR2 */
    private static final byte f24220C_CR2 = 2;

    /* renamed from: C_CR3 */
    private static final byte f24221C_CR3 = 3;

    /* renamed from: C_ILL */
    private static final byte f24222C_ILL = 0;

    /* renamed from: C_L2A */
    private static final byte f24223C_L2A = 4;

    /* renamed from: C_L3A */
    private static final byte f24224C_L3A = 5;

    /* renamed from: C_L3B */
    private static final byte f24225C_L3B = 6;

    /* renamed from: C_L3C */
    private static final byte f24226C_L3C = 7;

    /* renamed from: C_L4A */
    private static final byte f24227C_L4A = 8;

    /* renamed from: C_L4B */
    private static final byte f24228C_L4B = 9;

    /* renamed from: C_L4C */
    private static final byte f24229C_L4C = 10;

    /* renamed from: S_CS1 */
    private static final byte f24230S_CS1 = 0;

    /* renamed from: S_CS2 */
    private static final byte f24231S_CS2 = 16;

    /* renamed from: S_CS3 */
    private static final byte f24232S_CS3 = 32;

    /* renamed from: S_END */
    private static final byte f24233S_END = -1;

    /* renamed from: S_ERR */
    private static final byte f24234S_ERR = -2;

    /* renamed from: S_P3A */
    private static final byte f24235S_P3A = 48;

    /* renamed from: S_P3B */
    private static final byte f24236S_P3B = 64;

    /* renamed from: S_P4A */
    private static final byte f24237S_P4A = 80;

    /* renamed from: S_P4B */
    private static final byte f24238S_P4B = 96;
    private static final short[] firstUnitTable = new short[128];
    private static final byte[] transitionTable;

    static {
        byte[] bArr = new byte[112];
        transitionTable = bArr;
        byte[] bArr2 = new byte[128];
        m18349fill(bArr2, 0, 15, (byte) 1);
        m18349fill(bArr2, 16, 31, (byte) 2);
        m18349fill(bArr2, 32, 63, (byte) 3);
        m18349fill(bArr2, 64, 65, (byte) 0);
        m18349fill(bArr2, 66, 95, (byte) 4);
        m18349fill(bArr2, 96, 96, f24224C_L3A);
        m18349fill(bArr2, 97, 108, (byte) 6);
        m18349fill(bArr2, 109, 109, f24226C_L3C);
        m18349fill(bArr2, 110, 111, (byte) 6);
        m18349fill(bArr2, 112, 112, f24227C_L4A);
        m18349fill(bArr2, 113, 115, f24228C_L4B);
        m18349fill(bArr2, 116, 116, f24229C_L4C);
        m18349fill(bArr2, 117, 127, (byte) 0);
        m18349fill(bArr, 0, bArr.length - 1, f24234S_ERR);
        m18349fill(bArr, 8, 11, (byte) -1);
        m18349fill(bArr, 24, 27, (byte) 0);
        m18349fill(bArr, 40, 43, f24231S_CS2);
        m18349fill(bArr, 58, 59, (byte) 0);
        m18349fill(bArr, 72, 73, (byte) 0);
        m18349fill(bArr, 89, 91, f24231S_CS2);
        m18349fill(bArr, 104, 104, f24231S_CS2);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, f24226C_L3C, f24226C_L3C, f24226C_L3C};
        byte[] bArr4 = {f24234S_ERR, f24234S_ERR, f24234S_ERR, f24234S_ERR, 0, f24235S_P3A, f24231S_CS2, f24236S_P3B, f24237S_P4A, f24232S_CS3, f24238S_P4B};
        for (int i = 0; i < 128; i++) {
            byte b = bArr2[i];
            firstUnitTable[i] = (short) (bArr4[b] | ((bArr3[b] & i) << 8));
        }
    }

    /* renamed from: fill */
    private static void m18349fill(byte[] bArr, int i, int i2, byte b) {
        while (i <= i2) {
            bArr[i] = b;
            i++;
        }
    }

    public static int transcodeToUTF16(byte[] bArr, int i, int i2, char[] cArr) {
        int i3 = i2 + i;
        int i4 = 0;
        while (i < i3) {
            int i5 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                short s = firstUnitTable[b & ByteCompanionObject.MAX_VALUE];
                int i6 = s >>> 8;
                byte b2 = (byte) s;
                while (b2 >= 0) {
                    if (i5 >= i3) {
                        return -1;
                    }
                    int i7 = i5 + 1;
                    byte b3 = bArr[i5];
                    i6 = (i6 << 6) | (b3 & C5066Utf8.REPLACEMENT_BYTE);
                    b2 = transitionTable[b2 + ((b3 & 255) >>> 4)];
                    i5 = i7;
                }
                if (b2 == -2) {
                    return -1;
                }
                if (i6 <= 65535) {
                    if (i4 >= cArr.length) {
                        return -1;
                    }
                    cArr[i4] = (char) i6;
                    i4++;
                } else {
                    if (i4 >= cArr.length - 1) {
                        return -1;
                    }
                    int i8 = i4 + 1;
                    cArr[i4] = (char) ((i6 >>> 10) + C5066Utf8.HIGH_SURROGATE_HEADER);
                    i4 += 2;
                    cArr[i8] = (char) ((i6 & 1023) | C5066Utf8.LOG_SURROGATE_HEADER);
                }
                i = i5;
            } else {
                if (i4 >= cArr.length) {
                    return -1;
                }
                cArr[i4] = (char) b;
                i = i5;
                i4++;
            }
        }
        return i4;
    }

    public static int transcodeToUTF16(byte[] bArr, char[] cArr) {
        return transcodeToUTF16(bArr, 0, bArr.length, cArr);
    }
}
