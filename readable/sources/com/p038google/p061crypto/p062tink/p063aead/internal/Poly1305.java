package com.p038google.p061crypto.p062tink.p063aead.internal;

import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    public static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i = 0;
        long jM3451load26 = m3451load26(bArr, 0, 0) & 67108863;
        int i2 = 3;
        long jM3451load262 = m3451load26(bArr, 3, 2) & 67108611;
        long jM3451load263 = m3451load26(bArr, 6, 4) & 67092735;
        long jM3451load264 = m3451load26(bArr, 9, 6) & 66076671;
        long jM3451load265 = m3451load26(bArr, 12, 8) & 1048575;
        long j = jM3451load262 * 5;
        long j2 = jM3451load263 * 5;
        long j3 = jM3451load264 * 5;
        long j4 = jM3451load265 * 5;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        int i3 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        while (i3 < bArr2.length) {
            copyBlockSize(bArr3, bArr2, i3);
            long jM3451load266 = j9 + m3451load26(bArr3, i, i);
            long jM3451load267 = j5 + m3451load26(bArr3, i2, 2);
            long jM3451load268 = j6 + m3451load26(bArr3, 6, 4);
            long jM3451load269 = j7 + m3451load26(bArr3, 9, 6);
            long jM3451load2610 = j8 + (m3451load26(bArr3, 12, 8) | (bArr3[16] << 24));
            long j10 = (jM3451load266 * jM3451load26) + (jM3451load267 * j4) + (jM3451load268 * j3) + (jM3451load269 * j2) + (jM3451load2610 * j);
            long j11 = (jM3451load266 * jM3451load262) + (jM3451load267 * jM3451load26) + (jM3451load268 * j4) + (jM3451load269 * j3) + (jM3451load2610 * j2);
            long j12 = (jM3451load266 * jM3451load263) + (jM3451load267 * jM3451load262) + (jM3451load268 * jM3451load26) + (jM3451load269 * j4) + (jM3451load2610 * j3);
            long j13 = (jM3451load266 * jM3451load264) + (jM3451load267 * jM3451load263) + (jM3451load268 * jM3451load262) + (jM3451load269 * jM3451load26) + (jM3451load2610 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (jM3451load266 * jM3451load265) + (jM3451load267 * jM3451load264) + (jM3451load268 * jM3451load263) + (jM3451load269 * jM3451load262) + (jM3451load2610 * jM3451load26) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i3 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            i2 = 3;
            j9 = j18 & 67108863;
            i = 0;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = (j24 + (j32 >> 26)) - 67108864;
        long j34 = j33 >> 63;
        long j35 = j26 & j34;
        long j36 = j27 & j34;
        long j37 = j20 & j34;
        long j38 = j22 & j34;
        long j39 = j24 & j34;
        long j40 = ~j34;
        long j41 = (j30 & 67108863 & j40) | j36;
        long j42 = (j31 & 67108863 & j40) | j37;
        long j43 = (j32 & 67108863 & j40) | j38;
        long j44 = (j33 & j40) | j39;
        long j45 = (j35 | (j29 & j40) | (j41 << 26)) & BodyPartID.bodyIdMax;
        long j46 = ((j41 >> 6) | (j42 << 20)) & BodyPartID.bodyIdMax;
        long j47 = ((j42 >> 12) | (j43 << 14)) & BodyPartID.bodyIdMax;
        long j48 = ((j43 >> 18) | (j44 << 8)) & BodyPartID.bodyIdMax;
        long jM3452load32 = j45 + m3452load32(bArr, 16);
        long j49 = jM3452load32 & BodyPartID.bodyIdMax;
        long jM3452load322 = j46 + m3452load32(bArr, 20) + (jM3452load32 >> 32);
        long j50 = jM3452load322 & BodyPartID.bodyIdMax;
        long jM3452load323 = j47 + m3452load32(bArr, 24) + (jM3452load322 >> 32);
        long j51 = jM3452load323 & BodyPartID.bodyIdMax;
        long jM3452load324 = (j48 + m3452load32(bArr, 28) + (jM3452load323 >> 32)) & BodyPartID.bodyIdMax;
        byte[] bArr4 = new byte[16];
        toByteArray(bArr4, j49, 0);
        toByteArray(bArr4, j50, 4);
        toByteArray(bArr4, j51, 8);
        toByteArray(bArr4, jM3452load324, 12);
        return bArr4;
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(16, bArr2.length - i);
        System.arraycopy(bArr2, i, bArr, 0, iMin);
        bArr[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(bArr, iMin + 1, bArr.length, (byte) 0);
        }
    }

    /* renamed from: load26 */
    private static long m3451load26(byte[] bArr, int i, int i2) {
        return (m3452load32(bArr, i) >> i2) & 67108863;
    }

    /* renamed from: load32 */
    private static long m3452load32(byte[] bArr, int i) {
        return (((bArr[i + 3] & C1126UByte.MAX_VALUE) << 24) | (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16)) & BodyPartID.bodyIdMax;
    }

    private static void toByteArray(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    public static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!C0853Bytes.m4230equal(computeMac(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
