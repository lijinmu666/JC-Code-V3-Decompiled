package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.lang.reflect.Array;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
class HarakaSXof extends HarakaSBase {
    public HarakaSXof(byte[] bArr) {
        byte[] bArr2 = new byte[640];
        m18154update(bArr, 0, bArr.length);
        m18152doFinal(bArr2, 0, 640);
        this.haraka512_rc = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 10, 8);
        this.haraka256_rc = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 10, 8);
        for (int i = 0; i < 10; i++) {
            interleaveConstant32(this.haraka256_rc[i], bArr2, i << 5);
            interleaveConstant(this.haraka512_rc[i], bArr2, i << 6);
        }
    }

    /* renamed from: doFinal */
    public int m18152doFinal(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f24083buffer;
        int i3 = this.f24084off;
        bArr2[i3] = (byte) (bArr2[i3] ^ 31);
        bArr2[31] = (byte) (bArr2[31] ^ ByteCompanionObject.MIN_VALUE);
        int i4 = i2;
        while (i4 >= 32) {
            haraka512Perm(this.f24083buffer);
            System.arraycopy(this.f24083buffer, 0, bArr, i, 32);
            i += 32;
            i4 -= 32;
        }
        if (i4 > 0) {
            haraka512Perm(this.f24083buffer);
            System.arraycopy(this.f24083buffer, 0, bArr, i, i4);
        }
        mo14968reset();
        return i2;
    }

    public String getAlgorithmName() {
        return "Haraka-S";
    }

    /* renamed from: update */
    public void m18153update(byte b) {
        byte[] bArr = this.f24083buffer;
        int i = this.f24084off;
        int i2 = i + 1;
        this.f24084off = i2;
        bArr[i] = (byte) (b ^ bArr[i]);
        if (i2 == 32) {
            haraka512Perm(bArr);
            this.f24084off = 0;
        }
    }

    /* renamed from: update */
    public void m18154update(byte[] bArr, int i, int i2) {
        int i3 = (this.f24084off + i2) >> 5;
        int i4 = i;
        for (int i5 = 0; i5 < i3; i5++) {
            while (true) {
                int i6 = this.f24084off;
                if (i6 < 32) {
                    byte[] bArr2 = this.f24083buffer;
                    this.f24084off = i6 + 1;
                    bArr2[i6] = (byte) (bArr[i4] ^ bArr2[i6]);
                    i4++;
                }
            }
            haraka512Perm(this.f24083buffer);
            this.f24084off = 0;
        }
        while (i4 < i + i2) {
            byte[] bArr3 = this.f24083buffer;
            int i7 = this.f24084off;
            this.f24084off = i7 + 1;
            bArr3[i7] = (byte) (bArr3[i7] ^ bArr[i4]);
            i4++;
        }
    }
}
