package org.bouncycastle.p281jce.provider;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.MD5Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class OldPKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;

    /* renamed from: digest */
    private InterfaceC5277Digest f22020digest;

    /* renamed from: u */
    private int f22021u;

    /* renamed from: v */
    private int f22022v;

    public OldPKCS12ParametersGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f22020digest = interfaceC5277Digest;
        if (interfaceC5277Digest instanceof MD5Digest) {
            this.f22021u = 16;
        } else {
            if (!(interfaceC5277Digest instanceof SHA1Digest) && !(interfaceC5277Digest instanceof RIPEMD160Digest)) {
                throw new IllegalArgumentException("Digest " + interfaceC5277Digest.getAlgorithmName() + " unsupported");
            }
            this.f22021u = 20;
        }
        this.f22022v = 64;
    }

    /* renamed from: adjust */
    private void m16246adjust(byte[] bArr, int i, byte[] bArr2) {
        int i2 = (bArr2[bArr2.length - 1] & C1126UByte.MAX_VALUE) + (bArr[(bArr2.length + i) - 1] & C1126UByte.MAX_VALUE) + 1;
        bArr[(bArr2.length + i) - 1] = (byte) i2;
        int i3 = i2 >>> 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i4 = i + length;
            int i5 = i3 + (bArr2[length] & C1126UByte.MAX_VALUE) + (bArr[i4] & C1126UByte.MAX_VALUE);
            bArr[i4] = (byte) i5;
            i3 = i5 >>> 8;
        }
    }

    private byte[] generateDerivedKey(int i, int i2) {
        byte[] bArr;
        byte[] bArr2;
        int i3;
        int i4 = this.f22022v;
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[i2];
        int i5 = 0;
        for (int i6 = 0; i6 != i4; i6++) {
            bArr3[i6] = (byte) i;
        }
        byte[] bArr5 = this.f19139salt;
        int i7 = 1;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i8 = this.f22022v;
            int length = i8 * (((bArr5.length + i8) - 1) / i8);
            bArr = new byte[length];
            for (int i9 = 0; i9 != length; i9++) {
                byte[] bArr6 = this.f19139salt;
                bArr[i9] = bArr6[i9 % bArr6.length];
            }
        }
        byte[] bArr7 = this.password;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i10 = this.f22022v;
            int length2 = i10 * (((bArr7.length + i10) - 1) / i10);
            bArr2 = new byte[length2];
            for (int i11 = 0; i11 != length2; i11++) {
                byte[] bArr8 = this.password;
                bArr2[i11] = bArr8[i11 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i12 = this.f22022v;
        byte[] bArr10 = new byte[i12];
        int i13 = this.f22021u;
        int i14 = ((i2 + i13) - 1) / i13;
        int i15 = 1;
        while (i15 <= i14) {
            int i16 = this.f22021u;
            byte[] bArr11 = new byte[i16];
            this.f22020digest.mo14970update(bArr3, i5, i4);
            this.f22020digest.mo14970update(bArr9, i5, length3);
            this.f22020digest.mo14967doFinal(bArr11, i5);
            for (int i17 = i7; i17 < this.iterationCount; i17++) {
                this.f22020digest.mo14970update(bArr11, i5, i16);
                this.f22020digest.mo14967doFinal(bArr11, i5);
            }
            for (int i18 = i5; i18 != i12; i18++) {
                bArr10[i15] = bArr11[i18 % i16];
            }
            int i19 = i5;
            while (true) {
                int i20 = this.f22022v;
                if (i19 == length3 / i20) {
                    break;
                }
                m16246adjust(bArr9, i20 * i19, bArr10);
                i19++;
            }
            if (i15 == i14) {
                int i21 = i15 - 1;
                int i22 = this.f22021u;
                int i23 = i21 * i22;
                int i24 = i2 - (i21 * i22);
                i3 = 0;
                System.arraycopy(bArr11, 0, bArr4, i23, i24);
            } else {
                i3 = 0;
                System.arraycopy(bArr11, 0, bArr4, (i15 - 1) * this.f22021u, i16);
            }
            i15++;
            i5 = i3;
            i7 = 1;
        }
        return bArr4;
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(3, i2), 0, i2);
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(1, i2), 0, i2);
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] bArrGenerateDerivedKey = generateDerivedKey(1, i3);
        return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i3), generateDerivedKey(2, i4), 0, i4);
    }
}
