package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class WotsPlus {

    /* renamed from: engine */
    private final SLHDSAEngine f23526engine;

    /* renamed from: w */
    private final int f23527w;

    public WotsPlus(SLHDSAEngine sLHDSAEngine) {
        this.f23526engine = sLHDSAEngine;
        this.f23527w = sLHDSAEngine.f23499WOTS_W;
    }

    /* renamed from: base_w */
    public void m17846base_w(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            if (i6 == 0) {
                i6 += 8;
                i7 = bArr[i];
                i++;
            }
            i6 -= this.f23526engine.WOTS_LOGW;
            iArr[i3] = (i7 >>> i6) & (i2 - 1);
            i5++;
            i3++;
        }
    }

    /* renamed from: chain */
    public byte[] m17847chain(byte[] bArr, int i, int i2, byte[] bArr2, C6093ADRS c6093adrs) {
        if (i2 == 0) {
            return C6238Arrays.m18231clone(bArr);
        }
        if (i + i2 > this.f23527w - 1) {
            return null;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            c6093adrs.setHashAddress(i + i3);
            bArr = this.f23526engine.mo17825F(bArr2, c6093adrs, bArr);
        }
        return bArr;
    }

    public byte[] pkFromSig(byte[] bArr, byte[] bArr2, byte[] bArr3, C6093ADRS c6093adrs) {
        SLHDSAEngine sLHDSAEngine;
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        SLHDSAEngine sLHDSAEngine2 = this.f23526engine;
        int[] iArr = new int[sLHDSAEngine2.WOTS_LEN];
        m17846base_w(bArr2, 0, this.f23527w, iArr, 0, sLHDSAEngine2.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sLHDSAEngine = this.f23526engine;
            if (i >= sLHDSAEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.f23527w - 1) - iArr[i];
            i++;
        }
        int i3 = sLHDSAEngine.WOTS_LEN2;
        int i4 = sLHDSAEngine.WOTS_LOGW;
        byte[] bArrIntToBigEndian = AbstractC6245Pack.intToBigEndian(i2 << (8 - ((i3 * i4) % 8)));
        int i5 = 4 - (((i3 * i4) + 7) / 8);
        int i6 = this.f23527w;
        SLHDSAEngine sLHDSAEngine3 = this.f23526engine;
        m17846base_w(bArrIntToBigEndian, i5, i6, iArr, sLHDSAEngine3.WOTS_LEN1, sLHDSAEngine3.WOTS_LEN2);
        SLHDSAEngine sLHDSAEngine4 = this.f23526engine;
        byte[] bArr4 = new byte[sLHDSAEngine4.f23498N];
        byte[][] bArr5 = new byte[sLHDSAEngine4.WOTS_LEN][];
        for (int i7 = 0; i7 < this.f23526engine.WOTS_LEN; i7++) {
            c6093adrs.setChainAddress(i7);
            int i8 = this.f23526engine.f23498N;
            System.arraycopy(bArr, i7 * i8, bArr4, 0, i8);
            int i9 = iArr[i7];
            bArr5[i7] = m17847chain(bArr4, i9, (this.f23527w - 1) - i9, bArr3, c6093adrs);
        }
        c6093adrs2.setTypeAndClear(1);
        c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
        return this.f23526engine.mo17830T_l(bArr3, c6093adrs2, C6238Arrays.concatenate(bArr5));
    }

    /* renamed from: pkGen */
    public byte[] m17848pkGen(byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        byte[][] bArr3 = new byte[this.f23526engine.WOTS_LEN][];
        for (int i = 0; i < this.f23526engine.WOTS_LEN; i++) {
            C6093ADRS c6093adrs3 = new C6093ADRS(c6093adrs);
            c6093adrs3.setTypeAndClear(5);
            c6093adrs3.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs3.setChainAddress(i);
            c6093adrs3.setHashAddress(0);
            byte[] bArrMo17828PRF = this.f23526engine.mo17828PRF(bArr2, bArr, c6093adrs3);
            c6093adrs3.setTypeAndClear(0);
            c6093adrs3.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs3.setChainAddress(i);
            c6093adrs3.setHashAddress(0);
            bArr3[i] = m17847chain(bArrMo17828PRF, 0, this.f23527w - 1, bArr2, c6093adrs3);
        }
        c6093adrs2.setTypeAndClear(1);
        c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
        return this.f23526engine.mo17830T_l(bArr2, c6093adrs2, C6238Arrays.concatenate(bArr3));
    }

    /* renamed from: sign */
    public byte[] m17849sign(byte[] bArr, byte[] bArr2, byte[] bArr3, C6093ADRS c6093adrs) {
        SLHDSAEngine sLHDSAEngine;
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        SLHDSAEngine sLHDSAEngine2 = this.f23526engine;
        int[] iArr = new int[sLHDSAEngine2.WOTS_LEN];
        m17846base_w(bArr, 0, this.f23527w, iArr, 0, sLHDSAEngine2.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sLHDSAEngine = this.f23526engine;
            if (i >= sLHDSAEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.f23527w - 1) - iArr[i];
            i++;
        }
        int i3 = sLHDSAEngine.WOTS_LOGW;
        if (i3 % 8 != 0) {
            i2 <<= 8 - ((sLHDSAEngine.WOTS_LEN2 * i3) % 8);
        }
        int i4 = ((sLHDSAEngine.WOTS_LEN2 * i3) + 7) / 8;
        int i5 = this.f23527w;
        SLHDSAEngine sLHDSAEngine3 = this.f23526engine;
        m17846base_w(AbstractC6245Pack.intToBigEndian(i2), 4 - i4, i5, iArr, sLHDSAEngine3.WOTS_LEN1, sLHDSAEngine3.WOTS_LEN2);
        byte[][] bArr4 = new byte[this.f23526engine.WOTS_LEN][];
        for (int i6 = 0; i6 < this.f23526engine.WOTS_LEN; i6++) {
            c6093adrs2.setTypeAndClear(5);
            c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs2.setChainAddress(i6);
            c6093adrs2.setHashAddress(0);
            byte[] bArrMo17828PRF = this.f23526engine.mo17828PRF(bArr3, bArr2, c6093adrs2);
            c6093adrs2.setTypeAndClear(0);
            c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs2.setChainAddress(i6);
            c6093adrs2.setHashAddress(0);
            bArr4[i6] = m17847chain(bArrMo17828PRF, 0, iArr[i6], bArr3, c6093adrs2);
        }
        return C6238Arrays.concatenate(bArr4);
    }
}
