package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

import java.math.BigInteger;
import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.signers.slhdsa.Fors */
/* loaded from: classes2.dex */
class C5393Fors {

    /* renamed from: engine */
    SLHDSAEngine f21066engine;

    public C5393Fors(SLHDSAEngine sLHDSAEngine) {
        this.f21066engine = sLHDSAEngine;
    }

    /* renamed from: base2B */
    public static int[] m15881base2B(byte[] bArr, int i, int i2) {
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

    public byte[] pkFromSig(SIG_FORS[] sig_forsArr, byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs) {
        byte[][] bArr3 = new byte[2][];
        SLHDSAEngine sLHDSAEngine = this.f21066engine;
        int i = sLHDSAEngine.f21081K;
        byte[][] bArr4 = new byte[i][];
        int[] iArrM15881base2B = m15881base2B(bArr, sLHDSAEngine.f21077A, i);
        for (int i2 = 0; i2 < this.f21066engine.f21081K; i2++) {
            int i3 = iArrM15881base2B[i2];
            byte[] bArrM15886getSK = sig_forsArr[i2].m15886getSK();
            c5392adrs.setTreeHeight(0);
            c5392adrs.setTreeIndex((i2 << this.f21066engine.f21077A) + i3);
            bArr3[0] = this.f21066engine.mo15887F(bArr2, c5392adrs, bArrM15886getSK);
            byte[][] authPath = sig_forsArr[i2].getAuthPath();
            c5392adrs.setTreeIndex((i2 << this.f21066engine.f21077A) + i3);
            int i4 = 0;
            while (i4 < this.f21066engine.f21077A) {
                int i5 = i4 + 1;
                c5392adrs.setTreeHeight(i5);
                if (((1 << i4) & i3) == 0) {
                    c5392adrs.setTreeIndex(c5392adrs.getTreeIndex() / 2);
                    bArr3[1] = this.f21066engine.mo15888H(bArr2, c5392adrs, bArr3[0], authPath[i4]);
                } else {
                    c5392adrs.setTreeIndex((c5392adrs.getTreeIndex() - 1) / 2);
                    bArr3[1] = this.f21066engine.mo15888H(bArr2, c5392adrs, authPath[i4], bArr3[0]);
                }
                bArr3[0] = bArr3[1];
                i4 = i5;
            }
            bArr4[i2] = bArr3[0];
        }
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        c5392adrs2.setTypeAndClear(4);
        c5392adrs2.setKeyPairAddress(c5392adrs.getKeyPairAddress());
        return this.f21066engine.mo15892T_l(bArr2, c5392adrs2, C6238Arrays.concatenate(bArr4));
    }

    /* renamed from: sign */
    public SIG_FORS[] m15882sign(byte[] bArr, byte[] bArr2, byte[] bArr3, C5392ADRS c5392adrs) {
        C5393Fors c5393Fors = this;
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        SLHDSAEngine sLHDSAEngine = c5393Fors.f21066engine;
        int[] iArrM15881base2B = m15881base2B(bArr, sLHDSAEngine.f21077A, sLHDSAEngine.f21081K);
        SIG_FORS[] sig_forsArr = new SIG_FORS[c5393Fors.f21066engine.f21081K];
        int i = 0;
        int i2 = 0;
        while (i2 < c5393Fors.f21066engine.f21081K) {
            int i3 = iArrM15881base2B[i2];
            c5392adrs2.setTypeAndClear(6);
            c5392adrs2.setKeyPairAddress(c5392adrs.getKeyPairAddress());
            c5392adrs2.setTreeHeight(i);
            c5392adrs2.setTreeIndex((i2 << c5393Fors.f21066engine.f21077A) + i3);
            byte[] bArrMo15890PRF = c5393Fors.f21066engine.mo15890PRF(bArr3, bArr2, c5392adrs2);
            c5392adrs2.changeType(3);
            byte[][] bArr4 = new byte[c5393Fors.f21066engine.f21077A][];
            int i4 = i;
            while (true) {
                int i5 = c5393Fors.f21066engine.f21077A;
                if (i4 < i5) {
                    int i6 = i4;
                    byte[][] bArr5 = bArr4;
                    bArr5[i6] = treehash(bArr2, (i2 << i5) + (((i3 >>> i4) ^ 1) << i4), i4, bArr3, c5392adrs2);
                    i4 = i6 + 1;
                    bArrMo15890PRF = bArrMo15890PRF;
                    bArr4 = bArr5;
                    c5393Fors = this;
                }
            }
            sig_forsArr[i2] = new SIG_FORS(bArrMo15890PRF, bArr4);
            i2++;
            i = 0;
            c5393Fors = this;
        }
        return sig_forsArr;
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C5392ADRS c5392adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c5392adrs2.setTypeAndClear(6);
            c5392adrs2.setKeyPairAddress(c5392adrs.getKeyPairAddress());
            c5392adrs2.setTreeHeight(0);
            int i4 = i + i3;
            c5392adrs2.setTreeIndex(i4);
            byte[] bArrMo15890PRF = this.f21066engine.mo15890PRF(bArr2, bArr, c5392adrs2);
            c5392adrs2.changeType(3);
            byte[] bArrMo15887F = this.f21066engine.mo15887F(bArr2, c5392adrs2, bArrMo15890PRF);
            c5392adrs2.setTreeHeight(1);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c5392adrs2.setTreeIndex(i4);
                bArrMo15887F = this.f21066engine.mo15888H(bArr2, c5392adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrMo15887F);
                i5++;
                c5392adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrMo15887F, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }
}
