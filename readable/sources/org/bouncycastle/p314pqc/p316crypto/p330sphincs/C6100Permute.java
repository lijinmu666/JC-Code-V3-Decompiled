package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.crypto.sphincs.Permute */
/* loaded from: classes2.dex */
class C6100Permute {
    private static final int CHACHA_ROUNDS = 12;

    /* renamed from: permute */
    public static void m17871permute(int i, int[] iArr) {
        int i2 = 16;
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        char c = 0;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = 7;
        int i11 = iArr[7];
        int i12 = 8;
        int i13 = iArr[8];
        int i14 = iArr[9];
        int i15 = iArr[10];
        int i16 = iArr[11];
        int i17 = iArr[12];
        int i18 = iArr[13];
        int i19 = iArr[14];
        int iM17872rotl = iArr[15];
        int iM17872rotl2 = i19;
        int iM17872rotl3 = i18;
        int iM17872rotl4 = i17;
        int i20 = i16;
        int i21 = i15;
        int i22 = i14;
        int i23 = i13;
        int iM17872rotl5 = i11;
        int iM17872rotl6 = i9;
        int iM17872rotl7 = i8;
        int iM17872rotl8 = i7;
        int i24 = i6;
        int i25 = i5;
        int i26 = i4;
        int i27 = i3;
        int i28 = i;
        while (i28 > 0) {
            int i29 = i27 + iM17872rotl8;
            int iM17872rotl9 = m17872rotl(iM17872rotl4 ^ i29, i2);
            int i30 = i23 + iM17872rotl9;
            int iM17872rotl10 = m17872rotl(iM17872rotl8 ^ i30, 12);
            int i31 = i29 + iM17872rotl10;
            int iM17872rotl11 = m17872rotl(iM17872rotl9 ^ i31, i12);
            int i32 = i30 + iM17872rotl11;
            int iM17872rotl12 = m17872rotl(iM17872rotl10 ^ i32, i10);
            int i33 = i26 + iM17872rotl7;
            int iM17872rotl13 = m17872rotl(iM17872rotl3 ^ i33, i2);
            int i34 = i22 + iM17872rotl13;
            int iM17872rotl14 = m17872rotl(iM17872rotl7 ^ i34, 12);
            int i35 = i33 + iM17872rotl14;
            int iM17872rotl15 = m17872rotl(iM17872rotl13 ^ i35, i12);
            int i36 = i34 + iM17872rotl15;
            int iM17872rotl16 = m17872rotl(iM17872rotl14 ^ i36, i10);
            int i37 = i25 + iM17872rotl6;
            int iM17872rotl17 = m17872rotl(iM17872rotl2 ^ i37, i2);
            int i38 = i21 + iM17872rotl17;
            int iM17872rotl18 = m17872rotl(iM17872rotl6 ^ i38, 12);
            int i39 = i37 + iM17872rotl18;
            int iM17872rotl19 = m17872rotl(iM17872rotl17 ^ i39, i12);
            int i40 = i38 + iM17872rotl19;
            int iM17872rotl20 = m17872rotl(iM17872rotl18 ^ i40, i10);
            int i41 = i24 + iM17872rotl5;
            int iM17872rotl21 = m17872rotl(iM17872rotl ^ i41, i2);
            int i42 = i20 + iM17872rotl21;
            int iM17872rotl22 = m17872rotl(iM17872rotl5 ^ i42, 12);
            int i43 = i41 + iM17872rotl22;
            int iM17872rotl23 = m17872rotl(iM17872rotl21 ^ i43, i12);
            int i44 = i42 + iM17872rotl23;
            int iM17872rotl24 = m17872rotl(iM17872rotl22 ^ i44, 7);
            int i45 = i31 + iM17872rotl16;
            int iM17872rotl25 = m17872rotl(iM17872rotl23 ^ i45, 16);
            int i46 = i40 + iM17872rotl25;
            int iM17872rotl26 = m17872rotl(iM17872rotl16 ^ i46, 12);
            i27 = i45 + iM17872rotl26;
            iM17872rotl = m17872rotl(iM17872rotl25 ^ i27, 8);
            i21 = i46 + iM17872rotl;
            iM17872rotl7 = m17872rotl(iM17872rotl26 ^ i21, 7);
            int i47 = i35 + iM17872rotl20;
            int iM17872rotl27 = m17872rotl(iM17872rotl11 ^ i47, 16);
            int i48 = i44 + iM17872rotl27;
            int iM17872rotl28 = m17872rotl(iM17872rotl20 ^ i48, 12);
            i26 = i47 + iM17872rotl28;
            iM17872rotl4 = m17872rotl(iM17872rotl27 ^ i26, 8);
            i20 = i48 + iM17872rotl4;
            iM17872rotl6 = m17872rotl(iM17872rotl28 ^ i20, 7);
            int i49 = i39 + iM17872rotl24;
            int iM17872rotl29 = m17872rotl(iM17872rotl15 ^ i49, 16);
            int i50 = i32 + iM17872rotl29;
            int iM17872rotl30 = m17872rotl(iM17872rotl24 ^ i50, 12);
            i25 = i49 + iM17872rotl30;
            iM17872rotl3 = m17872rotl(iM17872rotl29 ^ i25, 8);
            i23 = i50 + iM17872rotl3;
            iM17872rotl5 = m17872rotl(iM17872rotl30 ^ i23, 7);
            int i51 = i43 + iM17872rotl12;
            i2 = 16;
            int iM17872rotl31 = m17872rotl(iM17872rotl19 ^ i51, 16);
            int i52 = i36 + iM17872rotl31;
            int iM17872rotl32 = m17872rotl(iM17872rotl12 ^ i52, 12);
            i24 = i51 + iM17872rotl32;
            iM17872rotl2 = m17872rotl(iM17872rotl31 ^ i24, 8);
            i22 = i52 + iM17872rotl2;
            iM17872rotl8 = m17872rotl(iM17872rotl32 ^ i22, 7);
            i28 -= 2;
            i10 = 7;
            c = 0;
            i12 = 8;
        }
        iArr[c] = i27;
        iArr[1] = i26;
        iArr[2] = i25;
        iArr[3] = i24;
        iArr[4] = iM17872rotl8;
        iArr[5] = iM17872rotl7;
        iArr[6] = iM17872rotl6;
        iArr[i10] = iM17872rotl5;
        iArr[8] = i23;
        iArr[9] = i22;
        iArr[10] = i21;
        iArr[11] = i20;
        iArr[12] = iM17872rotl4;
        iArr[13] = iM17872rotl3;
        iArr[14] = iM17872rotl2;
        iArr[15] = iM17872rotl;
    }

    /* renamed from: rotl */
    public static int m17872rotl(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public void chacha_permute(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[16];
        for (int i = 0; i < 16; i++) {
            iArr[i] = AbstractC6245Pack.littleEndianToInt(bArr2, i * 4);
        }
        m17871permute(12, iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            AbstractC6245Pack.intToLittleEndian(iArr[i2], bArr, i2 * 4);
        }
    }
}
