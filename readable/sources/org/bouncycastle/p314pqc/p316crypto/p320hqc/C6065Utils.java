package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.crypto.hqc.Utils */
/* loaded from: classes2.dex */
class C6065Utils {
    public static void fromByte32ArrayToLongArray(long[] jArr, int[] iArr) {
        for (int i = 0; i != iArr.length; i += 2) {
            int i2 = i / 2;
            long j = iArr[i] & BodyPartID.bodyIdMax;
            jArr[i2] = j;
            jArr[i2] = j | (iArr[i + 1] << 32);
        }
    }

    public static void fromByteArrayToLongArray(long[] jArr, byte[] bArr, int i, int i2) {
        int i3 = i2 >> 3;
        AbstractC6245Pack.littleEndianToLong(bArr, i, jArr, 0, i3);
        int i4 = i2 & 7;
        if (i4 != 0) {
            jArr[i3] = AbstractC6245Pack.littleEndianToLong_Low(bArr, (i + i2) - i4, i4);
        }
    }

    public static void fromLongArrayToByte32Array(int[] iArr, long[] jArr) {
        for (int i = 0; i != jArr.length; i++) {
            int i2 = i * 2;
            long j = jArr[i];
            iArr[i2] = (int) j;
            iArr[i2 + 1] = (int) (j >> 32);
        }
    }

    public static void fromLongArrayToByteArray(byte[] bArr, int i, int i2, long[] jArr) {
        int i3 = i2 >> 3;
        AbstractC6245Pack.longToLittleEndian(jArr, 0, i3, bArr, i);
        int i4 = i2 & 7;
        if (i4 != 0) {
            AbstractC6245Pack.longToLittleEndian_Low(jArr[i3], bArr, (i + i2) - i4, i4);
        }
    }

    public static int getByte64SizeFromBitSize(int i) {
        return (i + 63) / 64;
    }

    public static int getByteSizeFromBitSize(int i) {
        return (i + 7) / 8;
    }

    public static int toUnsigned16Bits(int i) {
        return i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    public static int toUnsigned8bits(int i) {
        return i & 255;
    }
}
