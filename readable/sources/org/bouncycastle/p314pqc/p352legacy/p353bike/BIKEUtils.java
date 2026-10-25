package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
class BIKEUtils {
    public static int CHECK_BIT(byte[] bArr, int i) {
        return (bArr[i / 8] >>> (i % 8)) & 1;
    }

    /* renamed from: SET_BIT */
    public static void m18080SET_BIT(byte[] bArr, int i) {
        bArr[i / 8] = (byte) (bArr[r0] | (1 << (i % 8)));
    }

    public static void fromBitArrayToByteArray(byte[] bArr, byte[] bArr2, int i, int i2) {
        long j = i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < j) {
            int i5 = i3 + 8;
            if (i5 >= i2) {
                int i6 = i + i3;
                int i7 = bArr2[i6];
                for (int i8 = (i2 - i3) - 1; i8 >= 1; i8--) {
                    i7 |= bArr2[i6 + i8] << i8;
                }
                bArr[i4] = (byte) i7;
            } else {
                int i9 = i3 + i;
                int i10 = bArr2[i9];
                for (int i11 = 7; i11 >= 1; i11--) {
                    i10 |= bArr2[i9 + i11] << i11;
                }
                bArr[i4] = (byte) i10;
            }
            i4++;
            i3 = i5;
        }
    }

    public static void generateRandomByteArray(byte[] bArr, int i, int i2, InterfaceC5284Xof interfaceC5284Xof) {
        byte[] bArr2 = new byte[4];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            interfaceC5284Xof.doOutput(bArr2, 0, 4);
            int iLittleEndianToInt = ((int) (((AbstractC6245Pack.littleEndianToInt(bArr2, 0) & BodyPartID.bodyIdMax) * (i - i3)) >> 32)) + i3;
            if (CHECK_BIT(bArr, iLittleEndianToInt) != 0) {
                iLittleEndianToInt = i3;
            }
            m18080SET_BIT(bArr, iLittleEndianToInt);
        }
    }

    public static int getHammingWeight(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += b;
        }
        return i;
    }
}
