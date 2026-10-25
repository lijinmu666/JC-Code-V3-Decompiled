package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class WotsPlus {

    /* renamed from: engine */
    private final SPHINCSPlusEngine f24139engine;

    /* renamed from: w */
    private final int f24140w;

    public WotsPlus(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.f24139engine = sPHINCSPlusEngine;
        this.f24140w = sPHINCSPlusEngine.f24102WOTS_W;
    }

    /* renamed from: base_w */
    public void m18180base_w(byte[] bArr, int i, int i2, int[] iArr, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            if (i6 == 0) {
                i6 += 8;
                i7 = bArr[i];
                i++;
            }
            i6 -= this.f24139engine.WOTS_LOGW;
            iArr[i3] = (i7 >>> i6) & (i2 - 1);
            i5++;
            i3++;
        }
    }

    /* renamed from: chain */
    public byte[] m18181chain(byte[] bArr, int i, int i2, byte[] bArr2, C6224ADRS c6224adrs) {
        if (i2 == 0) {
            return C6238Arrays.m18231clone(bArr);
        }
        if (i + i2 > this.f24140w - 1) {
            return null;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            c6224adrs.setHashAddress(i + i3);
            bArr = this.f24139engine.mo18157F(bArr2, c6224adrs, bArr);
        }
        return bArr;
    }

    public byte[] pkFromSig(byte[] bArr, byte[] bArr2, byte[] bArr3, C6224ADRS c6224adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        SPHINCSPlusEngine sPHINCSPlusEngine2 = this.f24139engine;
        int[] iArr = new int[sPHINCSPlusEngine2.WOTS_LEN];
        m18180base_w(bArr2, 0, this.f24140w, iArr, 0, sPHINCSPlusEngine2.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sPHINCSPlusEngine = this.f24139engine;
            if (i >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.f24140w - 1) - iArr[i];
            i++;
        }
        int i3 = sPHINCSPlusEngine.WOTS_LEN2;
        int i4 = sPHINCSPlusEngine.WOTS_LOGW;
        byte[] bArrIntToBigEndian = AbstractC6245Pack.intToBigEndian(i2 << (8 - ((i3 * i4) % 8)));
        int i5 = 4 - (((i3 * i4) + 7) / 8);
        int i6 = this.f24140w;
        SPHINCSPlusEngine sPHINCSPlusEngine3 = this.f24139engine;
        m18180base_w(bArrIntToBigEndian, i5, i6, iArr, sPHINCSPlusEngine3.WOTS_LEN1, sPHINCSPlusEngine3.WOTS_LEN2);
        SPHINCSPlusEngine sPHINCSPlusEngine4 = this.f24139engine;
        byte[] bArr4 = new byte[sPHINCSPlusEngine4.f24100N];
        byte[][] bArr5 = new byte[sPHINCSPlusEngine4.WOTS_LEN][];
        for (int i7 = 0; i7 < this.f24139engine.WOTS_LEN; i7++) {
            c6224adrs.setChainAddress(i7);
            int i8 = this.f24139engine.f24100N;
            System.arraycopy(bArr, i7 * i8, bArr4, 0, i8);
            int i9 = iArr[i7];
            bArr5[i7] = m18181chain(bArr4, i9, (this.f24140w - 1) - i9, bArr3, c6224adrs);
        }
        c6224adrs2.setTypeAndClear(1);
        c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
        return this.f24139engine.mo18162T_l(bArr3, c6224adrs2, C6238Arrays.concatenate(bArr5));
    }

    /* renamed from: pkGen */
    public byte[] m18182pkGen(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        byte[][] bArr3 = new byte[this.f24139engine.WOTS_LEN][];
        for (int i = 0; i < this.f24139engine.WOTS_LEN; i++) {
            C6224ADRS c6224adrs3 = new C6224ADRS(c6224adrs);
            c6224adrs3.setTypeAndClear(5);
            c6224adrs3.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs3.setChainAddress(i);
            c6224adrs3.setHashAddress(0);
            byte[] bArrMo18160PRF = this.f24139engine.mo18160PRF(bArr2, bArr, c6224adrs3);
            c6224adrs3.setTypeAndClear(0);
            c6224adrs3.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs3.setChainAddress(i);
            c6224adrs3.setHashAddress(0);
            bArr3[i] = m18181chain(bArrMo18160PRF, 0, this.f24140w - 1, bArr2, c6224adrs3);
        }
        c6224adrs2.setTypeAndClear(1);
        c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
        return this.f24139engine.mo18162T_l(bArr2, c6224adrs2, C6238Arrays.concatenate(bArr3));
    }

    /* renamed from: sign */
    public byte[] m18183sign(byte[] bArr, byte[] bArr2, byte[] bArr3, C6224ADRS c6224adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        SPHINCSPlusEngine sPHINCSPlusEngine2 = this.f24139engine;
        int[] iArr = new int[sPHINCSPlusEngine2.WOTS_LEN];
        m18180base_w(bArr, 0, this.f24140w, iArr, 0, sPHINCSPlusEngine2.WOTS_LEN1);
        int i = 0;
        int i2 = 0;
        while (true) {
            sPHINCSPlusEngine = this.f24139engine;
            if (i >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i2 += (this.f24140w - 1) - iArr[i];
            i++;
        }
        int i3 = sPHINCSPlusEngine.WOTS_LOGW;
        if (i3 % 8 != 0) {
            i2 <<= 8 - ((sPHINCSPlusEngine.WOTS_LEN2 * i3) % 8);
        }
        int i4 = ((sPHINCSPlusEngine.WOTS_LEN2 * i3) + 7) / 8;
        int i5 = this.f24140w;
        SPHINCSPlusEngine sPHINCSPlusEngine3 = this.f24139engine;
        m18180base_w(AbstractC6245Pack.intToBigEndian(i2), 4 - i4, i5, iArr, sPHINCSPlusEngine3.WOTS_LEN1, sPHINCSPlusEngine3.WOTS_LEN2);
        byte[][] bArr4 = new byte[this.f24139engine.WOTS_LEN][];
        for (int i6 = 0; i6 < this.f24139engine.WOTS_LEN; i6++) {
            c6224adrs2.setTypeAndClear(5);
            c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs2.setChainAddress(i6);
            c6224adrs2.setHashAddress(0);
            byte[] bArrMo18160PRF = this.f24139engine.mo18160PRF(bArr3, bArr2, c6224adrs2);
            c6224adrs2.setTypeAndClear(0);
            c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs2.setChainAddress(i6);
            c6224adrs2.setHashAddress(0);
            bArr4[i6] = m18181chain(bArrMo18160PRF, 0, iArr[i6], bArr3, c6224adrs2);
        }
        return C6238Arrays.concatenate(bArr4);
    }
}
