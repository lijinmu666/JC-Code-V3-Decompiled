package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.hqc.GF2x */
/* loaded from: classes2.dex */
class C6064GF2x {

    /* renamed from: bits */
    private final int f23180bits;

    /* renamed from: size */
    private final int f23181size;

    /* renamed from: sizeExt */
    private final int f23182sizeExt;

    public C6064GF2x(int i) {
        if (((-65535) & i) != 1) {
            throw new IllegalArgumentException();
        }
        this.f23180bits = i;
        int byte64SizeFromBitSize = C6065Utils.getByte64SizeFromBitSize(i);
        this.f23181size = byte64SizeFromBitSize;
        this.f23182sizeExt = byte64SizeFromBitSize * 2;
    }

    /* renamed from: baseMul */
    private static void m17579baseMul(int i, long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4) {
        C6238Arrays.m18255fill(jArr3, i4, (i * 2) + i4, 0L);
        long[] jArr4 = new long[16];
        for (int i5 = 0; i5 < i; i5++) {
            implMulwAcc(jArr4, jArr[i2 + i5], jArr2[i3 + i5], jArr3, i4 + (i5 << 1));
        }
        long j = jArr3[i4];
        long j2 = jArr3[i4 + 1];
        for (int i6 = 1; i6 < i; i6++) {
            int i7 = (i6 << 1) + i4;
            j ^= jArr3[i7];
            jArr3[i4 + i6] = j ^ j2;
            j2 ^= jArr3[i7 + 1];
        }
        AbstractC5869Nat.m16945xor64(i, jArr3, i4, j ^ j2, jArr3, i4 + i);
        int i8 = i - 1;
        for (int i9 = 1; i9 < i8 * 2; i9++) {
            int iMin = Math.min(i8, i9);
            int i10 = i9 - iMin;
            for (int i11 = iMin; i10 < i11; i11--) {
                implMulwAcc(jArr4, jArr[i2 + i10] ^ jArr[i2 + i11], jArr2[i3 + i10] ^ jArr2[i3 + i11], jArr3, i4 + i9);
                i10++;
            }
        }
    }

    private static void implMulwAcc(long[] jArr, long j, long j2, long[] jArr2, int i) {
        jArr[1] = j2;
        long j3 = 0;
        long j4 = j2;
        long j5 = j;
        for (int i2 = 2; i2 < 16; i2 += 2) {
            long j6 = jArr[i2 >>> 1] << 1;
            jArr[i2] = j6;
            jArr[i2 + 1] = j6 ^ j2;
            j5 = (j5 & (-72340172838076674L)) >>> 1;
            j3 ^= (j4 >> 63) & j5;
            j4 <<= 1;
        }
        int i3 = (int) j;
        long j7 = jArr[i3 & 15] ^ (jArr[(i3 >>> 4) & 15] << 4);
        int i4 = 56;
        do {
            int i5 = (int) (j >>> i4);
            long j8 = jArr[i5 & 15] ^ (jArr[(i5 >>> 4) & 15] << 4);
            j7 ^= j8 << i4;
            j3 ^= j8 >>> (-i4);
            i4 -= 8;
        } while (i4 > 0);
        jArr2[i] = jArr2[i] ^ j7;
        int i6 = i + 1;
        jArr2[i6] = jArr2[i6] ^ j3;
    }

    private void karatsuba(int i, long[] jArr, int i2, long[] jArr2, int i3, long[] jArr3, int i4, long[] jArr4, int i5) {
        if (i < 12) {
            m17579baseMul(i, jArr, i2, jArr2, i3, jArr3, i4);
            return;
        }
        int i6 = i >> 1;
        int i7 = i - i6;
        int i8 = i << 1;
        int i9 = i6 << 1;
        int i10 = i7 << 1;
        int i11 = i5 + i8;
        int i12 = i11 + i8;
        int i13 = i12 + i8;
        int i14 = i13 + i;
        int i15 = i5 + (i << 3);
        karatsuba(i6, jArr, i2, jArr2, i3, jArr4, i5, jArr4, i15);
        int i16 = i2 + i6;
        int i17 = i3 + i6;
        karatsuba(i7, jArr, i16, jArr2, i17, jArr4, i11, jArr4, i15);
        int i18 = 0;
        while (true) {
            long j = 0;
            if (i18 >= i7) {
                break;
            }
            long j2 = i18 < i6 ? jArr[i2 + i18] : 0L;
            if (i18 < i6) {
                j = jArr2[i3 + i18];
            }
            jArr4[i13 + i18] = j2 ^ jArr[i16 + i18];
            jArr4[i14 + i18] = j ^ jArr2[i17 + i18];
            i18++;
        }
        karatsuba(i7, jArr4, i13, jArr4, i14, jArr4, i12, jArr4, i15);
        System.arraycopy(jArr4, i5, jArr3, i4, i9);
        System.arraycopy(jArr4, i11, jArr3, i4 + i9, i10);
        int i19 = 0;
        while (i19 < i7 * 2) {
            long j3 = i19 < i9 ? jArr4[i5 + i19] : 0L;
            long j4 = i19 < i10 ? jArr4[i11 + i19] : 0L;
            int i20 = i4 + i6 + i19;
            jArr3[i20] = jArr3[i20] ^ ((jArr4[i12 + i19] ^ j3) ^ j4);
            i19++;
        }
    }

    /* renamed from: reduce */
    private void m17580reduce(long[] jArr, long[] jArr2) {
        int i = 64 - (this.f23180bits & 63);
        int i2 = this.f23181size;
        AbstractC5869Nat.shiftUpBits64(i2, jArr, i2, i, jArr[i2 - 1], jArr2, 0);
        m17581addTo(jArr, jArr2);
        int i3 = this.f23181size - 1;
        jArr2[i3] = jArr2[i3] & ((-1) >>> i);
    }

    /* renamed from: addTo */
    public void m17581addTo(long[] jArr, long[] jArr2) {
        AbstractC5869Nat.m16952xorTo64(this.f23181size, jArr, jArr2);
    }

    /* renamed from: clear */
    public void m17582clear(long[] jArr) {
        AbstractC5869Nat.m16955zero64(this.f23181size, jArr);
    }

    /* renamed from: create */
    public long[] m17583create() {
        return new long[this.f23181size];
    }

    public long[] createExt() {
        return new long[this.f23182sizeExt];
    }

    /* renamed from: equalTo */
    public long m17584equalTo(long[] jArr, long[] jArr2) {
        return AbstractC5869Nat.equalTo64(this.f23181size, jArr, jArr2);
    }

    /* renamed from: mul */
    public void m17585mul(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt = createExt();
        int i = this.f23181size;
        karatsuba(i, jArr, 0, jArr2, 0, jArrCreateExt, 0, new long[i << 4], 0);
        m17580reduce(jArrCreateExt, jArr3);
    }

    /* renamed from: random */
    public void m17586random(Shake256RandomGenerator shake256RandomGenerator, long[] jArr) {
        byte[] bArr = new byte[this.f23181size << 3];
        shake256RandomGenerator.xofGetBytes(bArr, C6065Utils.getByteSizeFromBitSize(this.f23180bits));
        AbstractC6245Pack.littleEndianToLong(bArr, 0, jArr);
        int i = this.f23181size - 1;
        jArr[i] = jArr[i] & ((1 << (this.f23180bits & 63)) - 1);
    }
}
