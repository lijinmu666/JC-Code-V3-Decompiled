package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import java.math.BigInteger;
import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.pqc.crypto.slhdsa.Fors */
/* loaded from: classes2.dex */
class C6094Fors {

    /* renamed from: engine */
    SLHDSAEngine f23473engine;

    public C6094Fors(SLHDSAEngine sLHDSAEngine) {
        this.f23473engine = sLHDSAEngine;
    }

    /* renamed from: base2B */
    public static int[] m17819base2B(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i2];
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            while (i4 < i) {
                bigIntegerAdd = bigIntegerAdd.shiftLeft(8).add(BigInteger.valueOf(bArr[i3] & C1126UByte.MAX_VALUE));
                i3++;
                i4 += 8;
            }
            i4 -= i;
            iArr[i5] = bigIntegerAdd.shiftRight(i4).mod(BigInteger.valueOf(2L).pow(i)).intValue();
        }
        return iArr;
    }

    public byte[] pkFromSig(SIG_FORS[] sig_forsArr, byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
        byte[][] bArr3 = new byte[2][];
        SLHDSAEngine sLHDSAEngine = this.f23473engine;
        int i = sLHDSAEngine.f23497K;
        byte[][] bArr4 = new byte[i][];
        int[] iArrM17819base2B = m17819base2B(bArr, sLHDSAEngine.f23493A, i);
        for (int i2 = 0; i2 < this.f23473engine.f23497K; i2++) {
            int i3 = iArrM17819base2B[i2];
            byte[] bArrM17824getSK = sig_forsArr[i2].m17824getSK();
            c6093adrs.setTreeHeight(0);
            c6093adrs.setTreeIndex((i2 << this.f23473engine.f23493A) + i3);
            bArr3[0] = this.f23473engine.mo17825F(bArr2, c6093adrs, bArrM17824getSK);
            byte[][] authPath = sig_forsArr[i2].getAuthPath();
            c6093adrs.setTreeIndex((i2 << this.f23473engine.f23493A) + i3);
            int i4 = 0;
            while (i4 < this.f23473engine.f23493A) {
                int i5 = i4 + 1;
                c6093adrs.setTreeHeight(i5);
                if (((1 << i4) & i3) == 0) {
                    c6093adrs.setTreeIndex(c6093adrs.getTreeIndex() / 2);
                    bArr3[1] = this.f23473engine.mo17826H(bArr2, c6093adrs, bArr3[0], authPath[i4]);
                } else {
                    c6093adrs.setTreeIndex((c6093adrs.getTreeIndex() - 1) / 2);
                    bArr3[1] = this.f23473engine.mo17826H(bArr2, c6093adrs, authPath[i4], bArr3[0]);
                }
                bArr3[0] = bArr3[1];
                i4 = i5;
            }
            bArr4[i2] = bArr3[0];
        }
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        c6093adrs2.setTypeAndClear(4);
        c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
        return this.f23473engine.mo17830T_l(bArr2, c6093adrs2, C6238Arrays.concatenate(bArr4));
    }

    /* renamed from: sign */
    public SIG_FORS[] m17820sign(byte[] bArr, byte[] bArr2, byte[] bArr3, C6093ADRS c6093adrs) {
        C6094Fors c6094Fors = this;
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        SLHDSAEngine sLHDSAEngine = c6094Fors.f23473engine;
        int[] iArrM17819base2B = m17819base2B(bArr, sLHDSAEngine.f23493A, sLHDSAEngine.f23497K);
        SIG_FORS[] sig_forsArr = new SIG_FORS[c6094Fors.f23473engine.f23497K];
        int i = 0;
        int i2 = 0;
        while (i2 < c6094Fors.f23473engine.f23497K) {
            int i3 = iArrM17819base2B[i2];
            c6093adrs2.setTypeAndClear(6);
            c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs2.setTreeHeight(i);
            c6093adrs2.setTreeIndex((i2 << c6094Fors.f23473engine.f23493A) + i3);
            byte[] bArrMo17828PRF = c6094Fors.f23473engine.mo17828PRF(bArr3, bArr2, c6093adrs2);
            c6093adrs2.changeType(3);
            byte[][] bArr4 = new byte[c6094Fors.f23473engine.f23493A][];
            int i4 = i;
            while (true) {
                int i5 = c6094Fors.f23473engine.f23493A;
                if (i4 < i5) {
                    int i6 = i4;
                    byte[][] bArr5 = bArr4;
                    bArr5[i6] = treehash(bArr2, (i2 << i5) + (((i3 >>> i4) ^ 1) << i4), i4, bArr3, c6093adrs2);
                    i4 = i6 + 1;
                    bArrMo17828PRF = bArrMo17828PRF;
                    bArr4 = bArr5;
                    c6094Fors = this;
                }
            }
            sig_forsArr[i2] = new SIG_FORS(bArrMo17828PRF, bArr4);
            i2++;
            i = 0;
            c6094Fors = this;
        }
        return sig_forsArr;
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C6093ADRS c6093adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c6093adrs2.setTypeAndClear(6);
            c6093adrs2.setKeyPairAddress(c6093adrs.getKeyPairAddress());
            c6093adrs2.setTreeHeight(0);
            int i4 = i + i3;
            c6093adrs2.setTreeIndex(i4);
            byte[] bArrMo17828PRF = this.f23473engine.mo17828PRF(bArr2, bArr, c6093adrs2);
            c6093adrs2.changeType(3);
            byte[] bArrMo17825F = this.f23473engine.mo17825F(bArr2, c6093adrs2, bArrMo17828PRF);
            c6093adrs2.setTreeHeight(1);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c6093adrs2.setTreeIndex(i4);
                bArrMo17825F = this.f23473engine.mo17826H(bArr2, c6093adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrMo17825F);
                i5++;
                c6093adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrMo17825F, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }
}
