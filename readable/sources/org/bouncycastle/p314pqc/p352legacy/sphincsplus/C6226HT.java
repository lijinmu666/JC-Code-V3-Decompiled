package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.legacy.sphincsplus.HT */
/* loaded from: classes2.dex */
class C6226HT {

    /* renamed from: engine */
    SPHINCSPlusEngine f24079engine;
    final byte[] htPubKey;

    /* renamed from: pkSeed */
    private final byte[] f24080pkSeed;

    /* renamed from: skSeed */
    private final byte[] f24081skSeed;

    /* renamed from: wots */
    WotsPlus f24082wots;

    public C6226HT(SPHINCSPlusEngine sPHINCSPlusEngine, byte[] bArr, byte[] bArr2) {
        this.f24081skSeed = bArr;
        this.f24080pkSeed = bArr2;
        this.f24079engine = sPHINCSPlusEngine;
        this.f24082wots = new WotsPlus(sPHINCSPlusEngine);
        C6224ADRS c6224adrs = new C6224ADRS();
        c6224adrs.setLayerAddress(sPHINCSPlusEngine.f24096D - 1);
        c6224adrs.setTreeAddress(0L);
        if (bArr != null) {
            this.htPubKey = xmss_PKgen(bArr, bArr2, c6224adrs);
        } else {
            this.htPubKey = null;
        }
    }

    /* renamed from: sign */
    public byte[] m18145sign(byte[] bArr, long j, int i) {
        long j2 = j;
        C6224ADRS c6224adrs = new C6224ADRS();
        c6224adrs.setLayerAddress(0);
        c6224adrs.setTreeAddress(j2);
        SIG_XMSS sig_xmssXmss_sign = xmss_sign(bArr, this.f24081skSeed, i, this.f24080pkSeed, c6224adrs);
        int i2 = this.f24079engine.f24096D;
        SIG_XMSS[] sig_xmssArr = new SIG_XMSS[i2];
        sig_xmssArr[0] = sig_xmssXmss_sign;
        c6224adrs.setLayerAddress(0);
        c6224adrs.setTreeAddress(j2);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmssXmss_sign, bArr, this.f24080pkSeed, c6224adrs);
        int i3 = 1;
        while (true) {
            SPHINCSPlusEngine sPHINCSPlusEngine = this.f24079engine;
            if (i3 >= sPHINCSPlusEngine.f24096D) {
                break;
            }
            int i4 = (int) (((1 << r0) - 1) & j2);
            j2 >>>= sPHINCSPlusEngine.f24098H_PRIME;
            c6224adrs.setLayerAddress(i3);
            c6224adrs.setTreeAddress(j2);
            SIG_XMSS sig_xmssXmss_sign2 = xmss_sign(bArrXmss_pkFromSig, this.f24081skSeed, i4, this.f24080pkSeed, c6224adrs);
            sig_xmssArr[i3] = sig_xmssXmss_sign2;
            if (i3 < this.f24079engine.f24096D - 1) {
                bArrXmss_pkFromSig = xmss_pkFromSig(i4, sig_xmssXmss_sign2, bArrXmss_pkFromSig, this.f24080pkSeed, c6224adrs);
            }
            i3++;
        }
        byte[][] bArr2 = new byte[i2][];
        for (int i5 = 0; i5 != i2; i5++) {
            SIG_XMSS sig_xmss = sig_xmssArr[i5];
            bArr2[i5] = C6238Arrays.concatenate(sig_xmss.f24092sig, C6238Arrays.concatenate(sig_xmss.f24091auth));
        }
        return C6238Arrays.concatenate(bArr2);
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C6224ADRS c6224adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c6224adrs2.setTypeAndClear(0);
            int i4 = i + i3;
            c6224adrs2.setKeyPairAddress(i4);
            byte[] bArrM18182pkGen = this.f24082wots.m18182pkGen(bArr, bArr2, c6224adrs2);
            c6224adrs2.setTypeAndClear(2);
            c6224adrs2.setTreeHeight(1);
            c6224adrs2.setTreeIndex(i4);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c6224adrs2.setTreeIndex(i4);
                bArrM18182pkGen = this.f24079engine.mo18158H(bArr2, c6224adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrM18182pkGen);
                i5++;
                c6224adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrM18182pkGen, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }

    /* renamed from: verify */
    public boolean m18146verify(byte[] bArr, SIG_XMSS[] sig_xmssArr, byte[] bArr2, long j, int i, byte[] bArr3) {
        C6224ADRS c6224adrs = new C6224ADRS();
        SIG_XMSS sig_xmss = sig_xmssArr[0];
        c6224adrs.setLayerAddress(0);
        c6224adrs.setTreeAddress(j);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmss, bArr, bArr2, c6224adrs);
        int i2 = 1;
        while (true) {
            SPHINCSPlusEngine sPHINCSPlusEngine = this.f24079engine;
            if (i2 >= sPHINCSPlusEngine.f24096D) {
                return C6238Arrays.areEqual(bArr3, bArrXmss_pkFromSig);
            }
            int i3 = (int) (((1 << r0) - 1) & j);
            j >>>= sPHINCSPlusEngine.f24098H_PRIME;
            SIG_XMSS sig_xmss2 = sig_xmssArr[i2];
            c6224adrs.setLayerAddress(i2);
            c6224adrs.setTreeAddress(j);
            bArrXmss_pkFromSig = xmss_pkFromSig(i3, sig_xmss2, bArrXmss_pkFromSig, bArr2, c6224adrs);
            i2++;
        }
    }

    public byte[] xmss_PKgen(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
        return treehash(bArr, 0, this.f24079engine.f24098H_PRIME, bArr2, c6224adrs);
    }

    public byte[] xmss_pkFromSig(int i, SIG_XMSS sig_xmss, byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        int i2 = 0;
        c6224adrs2.setTypeAndClear(0);
        c6224adrs2.setKeyPairAddress(i);
        byte[] wOTSSig = sig_xmss.getWOTSSig();
        byte[][] xmssauth = sig_xmss.getXMSSAUTH();
        byte[] bArrPkFromSig = this.f24082wots.pkFromSig(wOTSSig, bArr, bArr2, c6224adrs2);
        c6224adrs2.setTypeAndClear(2);
        c6224adrs2.setTreeIndex(i);
        while (i2 < this.f24079engine.f24098H_PRIME) {
            int i3 = i2 + 1;
            c6224adrs2.setTreeHeight(i3);
            if ((i / (1 << i2)) % 2 == 0) {
                c6224adrs2.setTreeIndex(c6224adrs2.getTreeIndex() / 2);
                bArrPkFromSig = this.f24079engine.mo18158H(bArr2, c6224adrs2, bArrPkFromSig, xmssauth[i2]);
            } else {
                c6224adrs2.setTreeIndex((c6224adrs2.getTreeIndex() - 1) / 2);
                bArrPkFromSig = this.f24079engine.mo18158H(bArr2, c6224adrs2, xmssauth[i2], bArrPkFromSig);
            }
            i2 = i3;
        }
        return bArrPkFromSig;
    }

    public SIG_XMSS xmss_sign(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, C6224ADRS c6224adrs) {
        byte[][] bArr4 = new byte[this.f24079engine.f24098H_PRIME][];
        C6224ADRS c6224adrs2 = new C6224ADRS(c6224adrs);
        c6224adrs2.setTypeAndClear(2);
        c6224adrs2.setLayerAddress(c6224adrs.getLayerAddress());
        c6224adrs2.setTreeAddress(c6224adrs.getTreeAddress());
        for (int i2 = 0; i2 < this.f24079engine.f24098H_PRIME; i2++) {
            bArr4[i2] = treehash(bArr2, ((i >>> i2) ^ 1) << i2, i2, bArr3, c6224adrs2);
        }
        C6224ADRS c6224adrs3 = new C6224ADRS(c6224adrs);
        c6224adrs3.setTypeAndClear(0);
        c6224adrs3.setKeyPairAddress(i);
        return new SIG_XMSS(this.f24082wots.m18183sign(bArr, bArr2, bArr3, c6224adrs3), bArr4);
    }
}
