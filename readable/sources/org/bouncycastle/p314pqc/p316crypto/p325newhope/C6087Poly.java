package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import android.R;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;
import p132okio.C5066Utf8;

/* renamed from: org.bouncycastle.pqc.crypto.newhope.Poly */
/* loaded from: classes2.dex */
class C6087Poly {
    /* renamed from: add */
    public static void m17750add(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            sArr3[i] = C6089Reduce.m17755barrett((short) (sArr[i] + sArr2[i]));
        }
    }

    public static void fromBytes(short[] sArr, byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 7;
            int i3 = bArr[i2] & C1126UByte.MAX_VALUE;
            byte b = bArr[i2 + 1];
            int i4 = b & C1126UByte.MAX_VALUE;
            int i5 = bArr[i2 + 2] & C1126UByte.MAX_VALUE;
            byte b2 = bArr[i2 + 3];
            int i6 = b2 & C1126UByte.MAX_VALUE;
            int i7 = bArr[i2 + 4] & C1126UByte.MAX_VALUE;
            byte b3 = bArr[i2 + 5];
            int i8 = b3 & C1126UByte.MAX_VALUE;
            int i9 = bArr[i2 + 6] & C1126UByte.MAX_VALUE;
            int i10 = i * 4;
            sArr[i10] = (short) (i3 | ((b & C5066Utf8.REPLACEMENT_BYTE) << 8));
            sArr[i10 + 1] = (short) ((i4 >>> 6) | (i5 << 2) | ((b2 & 15) << 10));
            sArr[i10 + 2] = (short) ((i6 >>> 4) | (i7 << 4) | ((b3 & 3) << 12));
            sArr[i10 + 3] = (short) ((i9 << 6) | (i8 >>> 2));
        }
    }

    /* renamed from: fromNTT */
    public static void m17751fromNTT(short[] sArr) {
        C6084NTT.bitReverse(sArr);
        C6084NTT.m17741core(sArr, C6088Precomp.OMEGAS_INV_MONTGOMERY);
        C6084NTT.mulCoefficients(sArr, C6088Precomp.PSIS_INV_MONTGOMERY);
    }

    public static void getNoise(short[] sArr, byte[] bArr, byte b) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[4096];
        ChaCha20.m17731process(bArr, bArr2, bArr3, 0, 4096);
        for (int i = 0; i < 1024; i++) {
            int iBigEndianToInt = AbstractC6245Pack.bigEndianToInt(bArr3, i * 4);
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 += (iBigEndianToInt >> i3) & R.attr.cacheColorHint;
            }
            sArr[i] = (short) (((((i2 >>> 24) + i2) & 255) + 12289) - (((i2 >>> 16) + (i2 >>> 8)) & 255));
        }
    }

    private static short normalize(short s) {
        short sM17755barrett = C6089Reduce.m17755barrett(s);
        int i = sM17755barrett - 12289;
        return (short) (((sM17755barrett ^ i) & (i >> 31)) ^ i);
    }

    public static void pointWise(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            sArr3[i] = C6089Reduce.montgomery((sArr[i] & 65535) * (65535 & C6089Reduce.montgomery((sArr2[i] & 65535) * 3186)));
        }
    }

    /* renamed from: toBytes */
    public static void m17752toBytes(byte[] bArr, short[] sArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            short sNormalize = normalize(sArr[i2]);
            short sNormalize2 = normalize(sArr[i2 + 1]);
            short sNormalize3 = normalize(sArr[i2 + 2]);
            short sNormalize4 = normalize(sArr[i2 + 3]);
            int i3 = i * 7;
            bArr[i3] = (byte) sNormalize;
            bArr[i3 + 1] = (byte) ((sNormalize >> 8) | (sNormalize2 << 6));
            bArr[i3 + 2] = (byte) (sNormalize2 >> 2);
            bArr[i3 + 3] = (byte) ((sNormalize2 >> 10) | (sNormalize3 << 4));
            bArr[i3 + 4] = (byte) (sNormalize3 >> 4);
            bArr[i3 + 5] = (byte) ((sNormalize3 >> 12) | (sNormalize4 << 2));
            bArr[i3 + 6] = (byte) (sNormalize4 >> 6);
        }
    }

    /* renamed from: toNTT */
    public static void m17753toNTT(short[] sArr) {
        C6084NTT.mulCoefficients(sArr, C6088Precomp.PSIS_BITREV_MONTGOMERY);
        C6084NTT.m17741core(sArr, C6088Precomp.OMEGAS_MONTGOMERY);
    }

    /* renamed from: uniform */
    public static void m17754uniform(short[] sArr, byte[] bArr) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        int i = 0;
        while (true) {
            byte[] bArr2 = new byte[256];
            sHAKEDigest.doOutput(bArr2, 0, 256);
            for (int i2 = 0; i2 < 256; i2 += 2) {
                int i3 = (bArr2[i2] & C1126UByte.MAX_VALUE) | ((bArr2[i2 + 1] & C1126UByte.MAX_VALUE) << 8);
                if (i3 < 61445) {
                    int i4 = i + 1;
                    sArr[i] = (short) i3;
                    if (i4 == 1024) {
                        return;
                    } else {
                        i = i4;
                    }
                }
            }
        }
    }
}
