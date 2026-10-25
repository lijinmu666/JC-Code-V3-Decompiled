package org.bouncycastle.p300oer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class BitBuilder {

    /* renamed from: bits */
    private static final byte[] f22536bits = {ByteCompanionObject.MIN_VALUE, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: buf */
    byte[] f22537buf = new byte[1];

    /* renamed from: pos */
    int f22538pos = 0;

    /* renamed from: pad */
    public void m17119pad() {
        int i = this.f22538pos;
        this.f22538pos = i + (i % 8);
    }

    /* renamed from: write */
    public int m17120write(OutputStream outputStream) throws IOException {
        int i = this.f22538pos;
        int i2 = (i + (i % 8)) / 8;
        outputStream.write(this.f22537buf, 0, i2);
        outputStream.flush();
        return i2;
    }

    public void write7BitBytes(int i) {
        boolean z = false;
        for (int i2 = 4; i2 >= 0; i2--) {
            if (!z && ((-33554432) & i) != 0) {
                z = true;
            }
            if (z) {
                writeBit(i2).writeBits(i, 32, 7);
            }
            i <<= 7;
        }
    }

    public int writeAndClear(OutputStream outputStream) throws IOException {
        int i = this.f22538pos;
        int i2 = (i + (i % 8)) / 8;
        outputStream.write(this.f22537buf, 0, i2);
        outputStream.flush();
        m17121zero();
        return i2;
    }

    public BitBuilder writeBit(int i) {
        int i2 = this.f22538pos;
        int i3 = i2 / 8;
        byte[] bArr = this.f22537buf;
        if (i3 >= bArr.length) {
            byte[] bArr2 = new byte[bArr.length + 4];
            System.arraycopy(bArr, 0, bArr2, 0, i2 / 8);
            C6238Arrays.m18227clear(this.f22537buf);
            this.f22537buf = bArr2;
        }
        if (i == 0) {
            byte[] bArr3 = this.f22537buf;
            int i4 = this.f22538pos;
            int i5 = i4 / 8;
            bArr3[i5] = (byte) ((~f22536bits[i4 % 8]) & bArr3[i5]);
        } else {
            byte[] bArr4 = this.f22537buf;
            int i6 = this.f22538pos;
            int i7 = i6 / 8;
            bArr4[i7] = (byte) (f22536bits[i6 % 8] | bArr4[i7]);
        }
        this.f22538pos++;
        return this;
    }

    public BitBuilder writeBits(long j, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            writeBit(((1 << i2) & j) > 0 ? 1 : 0);
        }
        return this;
    }

    /* renamed from: zero */
    public void m17121zero() {
        C6238Arrays.m18227clear(this.f22537buf);
        this.f22538pos = 0;
    }

    public void write7BitBytes(BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + (bigInteger.bitLength() % 8)) / 8;
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(254L).shiftLeft(iBitLength * 8);
        boolean z = false;
        while (iBitLength >= 0) {
            if (!z && bigInteger.and(bigIntegerShiftLeft).compareTo(BigInteger.ZERO) != 0) {
                z = true;
            }
            if (z) {
                writeBit(iBitLength).writeBits(bigInteger.and(bigIntegerShiftLeft).shiftRight(r3 - 8).intValue(), 8, 7);
            }
            bigInteger = bigInteger.shiftLeft(7);
            iBitLength--;
        }
    }

    public BitBuilder writeBits(long j, int i, int i2) {
        for (int i3 = i - 1; i3 >= i - i2; i3--) {
            writeBit(((1 << i3) & j) != 0 ? 1 : 0);
        }
        return this;
    }
}
