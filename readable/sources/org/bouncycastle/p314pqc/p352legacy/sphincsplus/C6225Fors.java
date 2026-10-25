package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.legacy.sphincsplus.Fors */
/* loaded from: classes2.dex */
class C6225Fors {

    /* renamed from: engine */
    SPHINCSPlusEngine f24078engine;

    public C6225Fors(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.f24078engine = sPHINCSPlusEngine;
    }

    public static int[] message_to_idxs(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            iArr[i4] = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i4] = iArr[i4] ^ (((bArr[i3 >> 3] >> (i3 & 7)) & 1) << i5);
                i3++;
            }
        }
        return iArr;
    }

    public byte[] pkFromSig(SIG_FORS[] sig_forsArr, byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
        int i = 2;
        byte[][] bArr3 = new byte[2][];
        SPHINCSPlusEngine sPHINCSPlusEngine = this.f24078engine;
        int i2 = sPHINCSPlusEngine.f24099K;
        byte[][] bArr4 = new byte[i2][];
        int i3 = sPHINCSPlusEngine.f24101T;
        int[] iArrMessage_to_idxs = message_to_idxs(bArr, i2, sPHINCSPlusEngine.f24095A);
        int i4 = 0;
        while (i4 < this.f24078engine.f24099K) {
            int i5 = iArrMessage_to_idxs[i4];
            byte[] bArrM18156getSK = sig_forsArr[i4].m18156getSK();
            c6224adrs.setTreeHeight(0);
            int i6 = (i4 * i3) + i5;
            c6224adrs.setTreeIndex(i6);
            bArr3[0] = this.f24078engine.mo18157F(bArr2, c6224adrs, bArrM18156getSK);
            byte[][] authPath = sig_forsArr[i4].getAuthPath();
            c6224adrs.setTreeIndex(i6);
            int i7 = 0;
            while (i7 < this.f24078engine.f24095A) {
                int i8 = i7 + 1;
                c6224adrs.setTreeHeight(i8);
                if ((i5 / (1 << i7)) % i == 0) {
                    c6224adrs.setTreeIndex(c6224adrs.getTreeIndex() / i);
                    bArr3[1] = this.f24078engine.mo18158H(bArr2, c6224adrs, bArr3[0], authPath[i7]);
                } else {
                    c6224adrs.setTreeIndex((c6224adrs.getTreeIndex() - 1) / 2);
                    bArr3[1] = this.f24078engine.mo18158H(bArr2, c6224adrs, authPath[i7], bArr3[0]);
                }
                bArr3[0] = bArr3[1];
                i7 = i8;
                i = 2;
            }
            bArr4[i4] = bArr3[0];
            i4++;
            i = 2;
        }
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        c6224adrs2.setTypeAndClear(4);
        c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
        return this.f24078engine.mo18162T_l(bArr2, c6224adrs2, C6238Arrays.concatenate(bArr4));
    }

    /* renamed from: sign */
    public SIG_FORS[] m18144sign(byte[] bArr, byte[] bArr2, byte[] bArr3, C6224ADRS c6224adrs) {
        C6225Fors c6225Fors = this;
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        SPHINCSPlusEngine sPHINCSPlusEngine = c6225Fors.f24078engine;
        int[] iArrMessage_to_idxs = message_to_idxs(bArr, sPHINCSPlusEngine.f24099K, sPHINCSPlusEngine.f24095A);
        SPHINCSPlusEngine sPHINCSPlusEngine2 = c6225Fors.f24078engine;
        SIG_FORS[] sig_forsArr = new SIG_FORS[sPHINCSPlusEngine2.f24099K];
        int i = sPHINCSPlusEngine2.f24101T;
        int i2 = 0;
        int i3 = 0;
        while (i3 < c6225Fors.f24078engine.f24099K) {
            int i4 = iArrMessage_to_idxs[i3];
            c6224adrs2.setTypeAndClear(6);
            c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs2.setTreeHeight(i2);
            int i5 = i3 * i;
            c6224adrs2.setTreeIndex(i5 + i4);
            byte[] bArrMo18160PRF = c6225Fors.f24078engine.mo18160PRF(bArr3, bArr2, c6224adrs2);
            c6224adrs2.changeType(3);
            byte[][] bArr4 = new byte[c6225Fors.f24078engine.f24095A][];
            int i6 = i2;
            while (i6 < c6225Fors.f24078engine.f24095A) {
                int i7 = 1 << i6;
                int i8 = i6;
                byte[][] bArr5 = bArr4;
                bArr5[i8] = treehash(bArr2, i5 + (((i4 / i7) ^ 1) * i7), i8, bArr3, c6224adrs2);
                i6 = i8 + 1;
                bArrMo18160PRF = bArrMo18160PRF;
                bArr4 = bArr5;
                c6225Fors = this;
            }
            sig_forsArr[i3] = new SIG_FORS(bArrMo18160PRF, bArr4);
            i3++;
            i2 = 0;
            c6225Fors = this;
        }
        return sig_forsArr;
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C6224ADRS c6224adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c6224adrs2.setTypeAndClear(6);
            c6224adrs2.setKeyPairAddress(c6224adrs.getKeyPairAddress());
            c6224adrs2.setTreeHeight(0);
            int i4 = i + i3;
            c6224adrs2.setTreeIndex(i4);
            byte[] bArrMo18160PRF = this.f24078engine.mo18160PRF(bArr2, bArr, c6224adrs2);
            c6224adrs2.changeType(3);
            byte[] bArrMo18157F = this.f24078engine.mo18157F(bArr2, c6224adrs2, bArrMo18160PRF);
            c6224adrs2.setTreeHeight(1);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c6224adrs2.setTreeIndex(i4);
                bArrMo18157F = this.f24078engine.mo18158H(bArr2, c6224adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrMo18157F);
                i5++;
                c6224adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrMo18157F, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }
}
