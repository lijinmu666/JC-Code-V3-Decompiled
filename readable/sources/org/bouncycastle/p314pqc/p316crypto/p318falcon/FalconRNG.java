package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
class FalconRNG {

    /* renamed from: bd */
    byte[] f23129bd = new byte[512];

    /* renamed from: ptr */
    int f23130ptr = 0;

    /* renamed from: sd */
    byte[] f23131sd = new byte[256];

    /* renamed from: QROUND */
    private void m17552QROUND(int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int i6 = i5 ^ iArr[i4];
        iArr[i4] = i6;
        int i7 = (i6 >>> 16) | (i6 << 16);
        iArr[i4] = i7;
        int i8 = iArr[i3] + i7;
        iArr[i3] = i8;
        int i9 = iArr[i2] ^ i8;
        iArr[i2] = i9;
        int i10 = (i9 >>> 20) | (i9 << 12);
        iArr[i2] = i10;
        int i11 = iArr[i] + i10;
        iArr[i] = i11;
        int i12 = iArr[i4] ^ i11;
        iArr[i4] = i12;
        int i13 = (i12 >>> 24) | (i12 << 8);
        iArr[i4] = i13;
        int i14 = iArr[i3] + i13;
        iArr[i3] = i14;
        int i15 = iArr[i2] ^ i14;
        iArr[i2] = i15;
        iArr[i2] = (i15 >>> 25) | (i15 << 7);
    }

    public long prng_get_u64() {
        int i = this.f23130ptr;
        if (i >= this.f23129bd.length - 9) {
            prng_refill();
            i = 0;
        }
        this.f23130ptr = i + 8;
        return AbstractC6245Pack.littleEndianToLong(this.f23129bd, i);
    }

    public byte prng_get_u8() {
        byte[] bArr = this.f23129bd;
        int i = this.f23130ptr;
        int i2 = i + 1;
        this.f23130ptr = i2;
        byte b = bArr[i];
        if (i2 == bArr.length) {
            prng_refill();
        }
        return b;
    }

    public void prng_init(SHAKEDigest sHAKEDigest) {
        sHAKEDigest.doOutput(this.f23131sd, 0, 56);
        prng_refill();
    }

    public void prng_refill() {
        int[] iArr = {1634760805, 857760878, 2036477234, 1797285236};
        int[] iArr2 = new int[16];
        int i = 0;
        long jLittleEndianToLong = AbstractC6245Pack.littleEndianToLong(this.f23131sd, 48);
        int i2 = 0;
        while (i2 < 8) {
            System.arraycopy(iArr, i, iArr2, i, 4);
            AbstractC6245Pack.littleEndianToInt(this.f23131sd, i, iArr2, 4, 12);
            int i3 = 14;
            int i4 = (int) jLittleEndianToLong;
            iArr2[14] = iArr2[14] ^ i4;
            int i5 = (int) (jLittleEndianToLong >>> 32);
            iArr2[15] = iArr2[15] ^ i5;
            int i6 = i;
            while (i6 < 10) {
                m17552QROUND(0, 4, 8, 12, iArr2);
                m17552QROUND(1, 5, 9, 13, iArr2);
                m17552QROUND(2, 6, 10, 14, iArr2);
                m17552QROUND(3, 7, 11, 15, iArr2);
                m17552QROUND(0, 5, 10, 15, iArr2);
                m17552QROUND(1, 6, 11, 12, iArr2);
                m17552QROUND(2, 7, 8, 13, iArr2);
                m17552QROUND(3, 4, 9, 14, iArr2);
                i6++;
                i3 = i3;
                i4 = i4;
                i5 = i5;
            }
            int i7 = i5;
            int i8 = i4;
            int i9 = i3;
            for (int i10 = 0; i10 < 4; i10++) {
                iArr2[i10] = iArr2[i10] + iArr[i10];
            }
            for (int i11 = 4; i11 < i9; i11++) {
                iArr2[i11] = iArr2[i11] + AbstractC6245Pack.littleEndianToInt(this.f23131sd, (i11 * 4) - 16);
            }
            iArr2[i9] = iArr2[i9] + (AbstractC6245Pack.littleEndianToInt(this.f23131sd, 40) ^ i8);
            iArr2[15] = iArr2[15] + (AbstractC6245Pack.littleEndianToInt(this.f23131sd, 44) ^ i7);
            jLittleEndianToLong++;
            for (int i12 = 0; i12 < 16; i12++) {
                AbstractC6245Pack.intToLittleEndian(iArr2[i12], this.f23129bd, (i2 << 2) + (i12 << 5));
            }
            i2++;
            i = 0;
        }
        AbstractC6245Pack.longToLittleEndian(jLittleEndianToLong, this.f23131sd, 48);
        this.f23130ptr = 0;
    }
}
