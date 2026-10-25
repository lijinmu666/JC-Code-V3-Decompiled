package org.bouncycastle.p194crypto.p221util;

import java.math.BigInteger;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class SSHBuffer {

    /* renamed from: buffer */
    private final byte[] f21135buffer;

    /* renamed from: pos */
    private int f21136pos = 0;

    public SSHBuffer(byte[] bArr) {
        this.f21135buffer = bArr;
    }

    public byte[] getBuffer() {
        return C6238Arrays.m18231clone(this.f21135buffer);
    }

    public boolean hasRemaining() {
        return this.f21136pos < this.f21135buffer.length;
    }

    public BigInteger readBigNumPositive() {
        int iM15931readU32 = m15931readU32();
        byte[] bArr = this.f21135buffer;
        int length = bArr.length;
        int i = this.f21136pos;
        if (iM15931readU32 > length - i) {
            throw new IllegalArgumentException("not enough data for big num");
        }
        int i2 = iM15931readU32 + i;
        this.f21136pos = i2;
        return new BigInteger(1, C6238Arrays.copyOfRange(bArr, i, i2));
    }

    public byte[] readBlock() {
        int iM15931readU32 = m15931readU32();
        if (iM15931readU32 == 0) {
            return new byte[0];
        }
        byte[] bArr = this.f21135buffer;
        int length = bArr.length;
        int i = this.f21136pos;
        if (iM15931readU32 > length - i) {
            throw new IllegalArgumentException("not enough data for block");
        }
        int i2 = iM15931readU32 + i;
        this.f21136pos = i2;
        return C6238Arrays.copyOfRange(bArr, i, i2);
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public String readString() {
        return C6250Strings.fromByteArray(readBlock());
    }

    /* renamed from: readU32 */
    public int m15931readU32() {
        int i = this.f21136pos;
        byte[] bArr = this.f21135buffer;
        if (i > bArr.length - 4) {
            throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
        }
        int iBigEndianToInt = AbstractC6245Pack.bigEndianToInt(bArr, i);
        this.f21136pos += 4;
        return iBigEndianToInt;
    }

    public void skipBlock() {
        int iM15931readU32 = m15931readU32();
        int length = this.f21135buffer.length;
        int i = this.f21136pos;
        if (iM15931readU32 > length - i) {
            throw new IllegalArgumentException("not enough data for block");
        }
        this.f21136pos = i + iM15931readU32;
    }

    public SSHBuffer(byte[] bArr, byte[] bArr2) {
        this.f21135buffer = bArr2;
        for (int i = 0; i != bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.f21136pos += bArr.length;
    }

    public byte[] readPaddedBlock(int i) {
        int i2;
        int iM15931readU32 = m15931readU32();
        if (iM15931readU32 == 0) {
            return new byte[0];
        }
        byte[] bArr = this.f21135buffer;
        int length = bArr.length;
        int i3 = this.f21136pos;
        if (iM15931readU32 > length - i3) {
            throw new IllegalArgumentException("not enough data for block");
        }
        if (iM15931readU32 % i != 0) {
            throw new IllegalArgumentException("missing padding");
        }
        int i4 = i3 + iM15931readU32;
        this.f21136pos = i4;
        if (iM15931readU32 > 0 && (i2 = bArr[i4 - 1] & C1126UByte.MAX_VALUE) > 0 && i2 < i) {
            i4 -= i2;
            int i5 = 1;
            int i6 = i4;
            while (i5 <= i2) {
                if (i5 != (this.f21135buffer[i6] & C1126UByte.MAX_VALUE)) {
                    throw new IllegalArgumentException("incorrect padding");
                }
                i5++;
                i6++;
            }
        }
        return C6238Arrays.copyOfRange(this.f21135buffer, i3, i4);
    }
}
