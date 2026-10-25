package org.bouncycastle.p194crypto.p215prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class FixedSecureRandom extends SecureRandom {

    /* renamed from: _data */
    private byte[] f20876_data;

    /* renamed from: _index */
    private int f20877_index;

    /* renamed from: _intPad */
    private int f20878_intPad;

    public FixedSecureRandom(boolean z, byte[] bArr) {
        this(z, new byte[][]{bArr});
    }

    private int nextValue() {
        byte[] bArr = this.f20876_data;
        int i = this.f20877_index;
        this.f20877_index = i + 1;
        return bArr[i] & C1126UByte.MAX_VALUE;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this.f20877_index == this.f20876_data.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this.f20876_data, this.f20877_index, bArr, 0, bArr.length);
        this.f20877_index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int iNextValue = (nextValue() << 24) | (nextValue() << 16);
        int i = this.f20878_intPad;
        if (i == 2) {
            this.f20878_intPad = i - 1;
        } else {
            iNextValue |= nextValue() << 8;
        }
        int i2 = this.f20878_intPad;
        if (i2 != 1) {
            return iNextValue | nextValue();
        }
        this.f20878_intPad = i2 - 1;
        return iNextValue;
    }

    @Override // java.util.Random
    public long nextLong() {
        return (nextValue() << 56) | (nextValue() << 48) | (nextValue() << 40) | (nextValue() << 32) | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    public FixedSecureRandom(boolean z, byte[][] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != bArr.length; i++) {
            try {
                byteArrayOutputStream.write(bArr[i]);
            } catch (IOException unused) {
                throw new IllegalArgumentException("can't save value array.");
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f20876_data = byteArray;
        if (z) {
            this.f20878_intPad = byteArray.length % 4;
        }
    }

    public FixedSecureRandom(byte[] bArr) {
        this(false, new byte[][]{bArr});
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(false, bArr);
    }
}
