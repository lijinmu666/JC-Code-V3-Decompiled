package org.bouncycastle.p314pqc.p352legacy.p353bike;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p284math.p295raw.AbstractC5867Mod;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p284math.p295raw.Interleave;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class BIKERing {
    private static final int PERMUTATION_CUTOFF = 64;

    /* renamed from: bits */
    private final int f23960bits;
    private final Map<Integer, Integer> halfPowers;

    /* renamed from: size */
    private final int f23961size;

    /* renamed from: sizeExt */
    private final int f23962sizeExt;

    public BIKERing(int i) {
        HashMap map = new HashMap();
        this.halfPowers = map;
        if (((-65535) & i) != 1) {
            throw new IllegalArgumentException();
        }
        this.f23960bits = i;
        int i2 = (i + 63) >>> 6;
        this.f23961size = i2;
        this.f23962sizeExt = i2 * 2;
        generateHalfPowersInv(map, i);
    }

    private static int generateHalfPower(int i, int i2, int i3) {
        int i4 = 1;
        while (i3 >= 32) {
            i4 = (int) ((((BodyPartID.bodyIdMax & (i2 * i4)) * i) + i4) >>> 32);
            i3 -= 32;
        }
        if (i3 <= 0) {
            return i4;
        }
        return (int) ((((BodyPartID.bodyIdMax & ((i2 * i4) & ((-1) >>> (-i3)))) * i) + i4) >>> i3);
    }

    private static void generateHalfPowersInv(Map<Integer, Integer> map, int i) {
        int i2;
        int i3 = i - 2;
        int iBitLength = Integers.bitLength(i3);
        int iInverse32 = AbstractC5867Mod.inverse32(-i);
        for (int i4 = 1; i4 < iBitLength; i4++) {
            int i5 = 1 << (i4 - 1);
            if (i5 >= 64 && !map.containsKey(Integers.m18296valueOf(i5))) {
                map.put(Integers.m18296valueOf(i5), Integers.m18296valueOf(generateHalfPower(i, iInverse32, i5)));
            }
            int i6 = 1 << i4;
            if ((i3 & i6) != 0 && (i2 = (i6 - 1) & i3) >= 64 && !map.containsKey(Integers.m18296valueOf(i2))) {
                map.put(Integers.m18296valueOf(i2), Integers.m18296valueOf(generateHalfPower(i, iInverse32, i2)));
            }
        }
    }

    private static int implModAdd(int i, int i2, int i3) {
        int i4 = (i2 + i3) - i;
        return i4 + (i & (i4 >> 31));
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

    private void implPermute(long[] jArr, int i, long[] jArr2) {
        int i2 = this.f23960bits;
        int iIntValue = this.halfPowers.get(Integers.m18296valueOf(i)).intValue();
        int iImplModAdd = implModAdd(i2, iIntValue, iIntValue);
        int iImplModAdd2 = implModAdd(i2, iImplModAdd, iImplModAdd);
        int iImplModAdd3 = implModAdd(i2, iImplModAdd2, iImplModAdd2);
        int iImplModAdd4 = i2 - iImplModAdd3;
        int iImplModAdd5 = implModAdd(i2, iImplModAdd4, iIntValue);
        int iImplModAdd6 = implModAdd(i2, iImplModAdd4, iImplModAdd);
        int iImplModAdd7 = implModAdd(i2, iImplModAdd5, iImplModAdd);
        int iImplModAdd8 = implModAdd(i2, iImplModAdd4, iImplModAdd2);
        int iImplModAdd9 = implModAdd(i2, iImplModAdd5, iImplModAdd2);
        int iImplModAdd10 = implModAdd(i2, iImplModAdd6, iImplModAdd2);
        int iImplModAdd11 = implModAdd(i2, iImplModAdd7, iImplModAdd2);
        int i3 = 0;
        while (true) {
            int i4 = this.f23961size;
            if (i3 >= i4) {
                int i5 = i4 - 1;
                jArr2[i5] = ((-1) >>> (-i2)) & jArr2[i5];
                return;
            }
            long j = 0;
            for (int i6 = 0; i6 < 64; i6 += 8) {
                iImplModAdd4 = implModAdd(i2, iImplModAdd4, iImplModAdd3);
                iImplModAdd5 = implModAdd(i2, iImplModAdd5, iImplModAdd3);
                iImplModAdd6 = implModAdd(i2, iImplModAdd6, iImplModAdd3);
                iImplModAdd7 = implModAdd(i2, iImplModAdd7, iImplModAdd3);
                iImplModAdd8 = implModAdd(i2, iImplModAdd8, iImplModAdd3);
                iImplModAdd9 = implModAdd(i2, iImplModAdd9, iImplModAdd3);
                iImplModAdd10 = implModAdd(i2, iImplModAdd10, iImplModAdd3);
                iImplModAdd11 = implModAdd(i2, iImplModAdd11, iImplModAdd3);
                j = j | (((jArr[iImplModAdd4 >>> 6] >>> iImplModAdd4) & 1) << i6) | (((jArr[iImplModAdd5 >>> 6] >>> iImplModAdd5) & 1) << (i6 + 1)) | (((jArr[iImplModAdd6 >>> 6] >>> iImplModAdd6) & 1) << (i6 + 2)) | (((jArr[iImplModAdd7 >>> 6] >>> iImplModAdd7) & 1) << (i6 + 3)) | (((jArr[iImplModAdd8 >>> 6] >>> iImplModAdd8) & 1) << (i6 + 4)) | (((jArr[iImplModAdd9 >>> 6] >>> iImplModAdd9) & 1) << (i6 + 5)) | (((jArr[iImplModAdd10 >>> 6] >>> iImplModAdd10) & 1) << (i6 + 6)) | (((jArr[iImplModAdd11 >>> 6] >>> iImplModAdd11) & 1) << (i6 + 7));
            }
            jArr2[i3] = j;
            i3++;
        }
    }

    private void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, this.f23961size, jArr2, 0);
    }

    /* renamed from: add */
    public void m18071add(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < this.f23961size; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: addTo */
    public void m18072addTo(long[] jArr, long[] jArr2) {
        for (int i = 0; i < this.f23961size; i++) {
            jArr2[i] = jArr2[i] ^ jArr[i];
        }
    }

    /* renamed from: copy */
    public void m18073copy(long[] jArr, long[] jArr2) {
        for (int i = 0; i < this.f23961size; i++) {
            jArr2[i] = jArr[i];
        }
    }

    /* renamed from: create */
    public long[] m18074create() {
        return new long[this.f23961size];
    }

    public long[] createExt() {
        return new long[this.f23962sizeExt];
    }

    public void decodeBytes(byte[] bArr, long[] jArr) {
        int i = this.f23960bits & 63;
        AbstractC6245Pack.littleEndianToLong(bArr, 0, jArr, 0, this.f23961size - 1);
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, (this.f23961size - 1) << 3, bArr2, 0, (i + 7) >>> 3);
        jArr[this.f23961size - 1] = AbstractC6245Pack.littleEndianToLong(bArr2, 0);
    }

    public byte[] encodeBitsTransposed(long[] jArr) {
        byte[] bArr = new byte[this.f23960bits];
        bArr[0] = (byte) (jArr[0] & 1);
        int i = 1;
        while (true) {
            int i2 = this.f23960bits;
            if (i >= i2) {
                return bArr;
            }
            bArr[i2 - i] = (byte) ((jArr[i >>> 6] >>> (i & 63)) & 1);
            i++;
        }
    }

    public void encodeBytes(long[] jArr, byte[] bArr) {
        int i = this.f23960bits & 63;
        AbstractC6245Pack.longToLittleEndian(jArr, 0, this.f23961size - 1, bArr, 0);
        byte[] bArr2 = new byte[8];
        AbstractC6245Pack.longToLittleEndian(jArr[this.f23961size - 1], bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, (this.f23961size - 1) << 3, (i + 7) >>> 3);
    }

    /* renamed from: getSize */
    public int m18075getSize() {
        return this.f23961size;
    }

    public int getSizeExt() {
        return this.f23962sizeExt;
    }

    public void implMultiplyAcc(long[] jArr, long[] jArr2, long[] jArr3) {
        int i;
        long[] jArr4 = new long[16];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f23961size; i3++) {
            implMulwAcc(jArr4, jArr[i3], jArr2[i3], jArr3, i3 << 1);
        }
        long j = jArr3[0];
        long j2 = jArr3[1];
        for (int i4 = 1; i4 < this.f23961size; i4++) {
            int i5 = i4 << 1;
            j ^= jArr3[i5];
            jArr3[i4] = j ^ j2;
            j2 ^= jArr3[i5 + 1];
        }
        long j3 = j ^ j2;
        while (true) {
            i = this.f23961size;
            if (i2 >= i) {
                break;
            }
            jArr3[i + i2] = jArr3[i2] ^ j3;
            i2++;
        }
        int i6 = i - 1;
        for (int i7 = 1; i7 < i6 * 2; i7++) {
            int iMin = Math.min(i6, i7);
            int i8 = i7 - iMin;
            for (int i9 = iMin; i8 < i9; i9--) {
                implMulwAcc(jArr4, jArr[i8] ^ jArr[i9], jArr2[i8] ^ jArr2[i9], jArr3, i7);
                i8++;
            }
        }
    }

    /* renamed from: inv */
    public void m18076inv(long[] jArr, long[] jArr2) {
        long[] jArrM18074create = m18074create();
        long[] jArrM18074create2 = m18074create();
        long[] jArrM18074create3 = m18074create();
        m18073copy(jArr, jArrM18074create);
        m18073copy(jArr, jArrM18074create3);
        int i = this.f23960bits - 2;
        int iBitLength = Integers.bitLength(i);
        for (int i2 = 1; i2 < iBitLength; i2++) {
            m18079squareN(jArrM18074create, 1 << (i2 - 1), jArrM18074create2);
            multiply(jArrM18074create, jArrM18074create2, jArrM18074create);
            int i3 = 1 << i2;
            if ((i & i3) != 0) {
                m18079squareN(jArrM18074create, (i3 - 1) & i, jArrM18074create2);
                multiply(jArrM18074create3, jArrM18074create2, jArrM18074create3);
            }
        }
        m18078square(jArrM18074create3, jArr2);
    }

    public void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArrCreateExt = createExt();
        implMultiplyAcc(jArr, jArr2, jArrCreateExt);
        m18077reduce(jArrCreateExt, jArr3);
    }

    /* renamed from: reduce */
    public void m18077reduce(long[] jArr, long[] jArr2) {
        int i = 64 - (this.f23960bits & 63);
        int i2 = this.f23961size;
        AbstractC5869Nat.shiftUpBits64(i2, jArr, i2, i, jArr[i2 - 1], jArr2, 0);
        m18072addTo(jArr, jArr2);
        int i3 = this.f23961size - 1;
        jArr2[i3] = jArr2[i3] & ((-1) >>> i);
    }

    /* renamed from: square */
    public void m18078square(long[] jArr, long[] jArr2) {
        long[] jArrCreateExt = createExt();
        implSquare(jArr, jArrCreateExt);
        m18077reduce(jArrCreateExt, jArr2);
    }

    /* renamed from: squareN */
    public void m18079squareN(long[] jArr, int i, long[] jArr2) {
        if (i >= 64) {
            implPermute(jArr, i, jArr2);
            return;
        }
        long[] jArrCreateExt = createExt();
        implSquare(jArr, jArrCreateExt);
        while (true) {
            m18077reduce(jArrCreateExt, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                implSquare(jArr2, jArrCreateExt);
            }
        }
    }
}
