package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.slhdsa.HT */
/* loaded from: classes2.dex */
class C6095HT {

    /* renamed from: engine */
    SLHDSAEngine f23474engine;
    final byte[] htPubKey;

    /* renamed from: pkSeed */
    private final byte[] f23475pkSeed;

    /* renamed from: skSeed */
    private final byte[] f23476skSeed;

    /* renamed from: wots */
    WotsPlus f23477wots;

    public C6095HT(SLHDSAEngine sLHDSAEngine, byte[] bArr, byte[] bArr2) {
        this.f23476skSeed = bArr;
        this.f23475pkSeed = bArr2;
        this.f23474engine = sLHDSAEngine;
        this.f23477wots = new WotsPlus(sLHDSAEngine);
        C6093ADRS c6093adrs = new C6093ADRS();
        c6093adrs.setLayerAddress(sLHDSAEngine.f23494D - 1);
        c6093adrs.setTreeAddress(0L);
        if (bArr != null) {
            this.htPubKey = xmss_PKgen(bArr, bArr2, c6093adrs);
        } else {
            this.htPubKey = null;
        }
    }

    /* renamed from: sign */
    public byte[] m17821sign(byte[] bArr, long j, int i) {
        long j2 = j;
        C6093ADRS c6093adrs = new C6093ADRS();
        c6093adrs.setLayerAddress(0);
        c6093adrs.setTreeAddress(j2);
        SIG_XMSS sig_xmssXmss_sign = xmss_sign(bArr, this.f23476skSeed, i, this.f23475pkSeed, c6093adrs);
        int i2 = this.f23474engine.f23494D;
        SIG_XMSS[] sig_xmssArr = new SIG_XMSS[i2];
        sig_xmssArr[0] = sig_xmssXmss_sign;
        c6093adrs.setLayerAddress(0);
        c6093adrs.setTreeAddress(j2);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmssXmss_sign, bArr, this.f23475pkSeed, c6093adrs);
        int i3 = 1;
        while (true) {
            SLHDSAEngine sLHDSAEngine = this.f23474engine;
            if (i3 >= sLHDSAEngine.f23494D) {
                break;
            }
            int i4 = (int) (((1 << r0) - 1) & j2);
            j2 >>>= sLHDSAEngine.f23496H_PRIME;
            c6093adrs.setLayerAddress(i3);
            c6093adrs.setTreeAddress(j2);
            SIG_XMSS sig_xmssXmss_sign2 = xmss_sign(bArrXmss_pkFromSig, this.f23476skSeed, i4, this.f23475pkSeed, c6093adrs);
            sig_xmssArr[i3] = sig_xmssXmss_sign2;
            if (i3 < this.f23474engine.f23494D - 1) {
                bArrXmss_pkFromSig = xmss_pkFromSig(i4, sig_xmssXmss_sign2, bArrXmss_pkFromSig, this.f23475pkSeed, c6093adrs);
            }
            i3++;
        }
        byte[][] bArr2 = new byte[i2][];
        for (int i5 = 0; i5 != i2; i5++) {
            SIG_XMSS sig_xmss = sig_xmssArr[i5];
            bArr2[i5] = C6238Arrays.concatenate(sig_xmss.f23490sig, C6238Arrays.concatenate(sig_xmss.f23489auth));
        }
        return C6238Arrays.concatenate(bArr2);
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C6093ADRS c6093adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c6093adrs2.setTypeAndClear(0);
            int i4 = i + i3;
            c6093adrs2.setKeyPairAddress(i4);
            byte[] bArrM17848pkGen = this.f23477wots.m17848pkGen(bArr, bArr2, c6093adrs2);
            c6093adrs2.setTypeAndClear(2);
            c6093adrs2.setTreeHeight(1);
            c6093adrs2.setTreeIndex(i4);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c6093adrs2.setTreeIndex(i4);
                bArrM17848pkGen = this.f23474engine.mo17826H(bArr2, c6093adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrM17848pkGen);
                i5++;
                c6093adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrM17848pkGen, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }

    /* renamed from: verify */
    public boolean m17822verify(byte[] bArr, SIG_XMSS[] sig_xmssArr, byte[] bArr2, long j, int i, byte[] bArr3) {
        C6093ADRS c6093adrs = new C6093ADRS();
        SIG_XMSS sig_xmss = sig_xmssArr[0];
        c6093adrs.setLayerAddress(0);
        c6093adrs.setTreeAddress(j);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmss, bArr, bArr2, c6093adrs);
        int i2 = 1;
        while (true) {
            SLHDSAEngine sLHDSAEngine = this.f23474engine;
            if (i2 >= sLHDSAEngine.f23494D) {
                return C6238Arrays.areEqual(bArr3, bArrXmss_pkFromSig);
            }
            int i3 = (int) (((1 << r0) - 1) & j);
            j >>>= sLHDSAEngine.f23496H_PRIME;
            SIG_XMSS sig_xmss2 = sig_xmssArr[i2];
            c6093adrs.setLayerAddress(i2);
            c6093adrs.setTreeAddress(j);
            bArrXmss_pkFromSig = xmss_pkFromSig(i3, sig_xmss2, bArrXmss_pkFromSig, bArr2, c6093adrs);
            i2++;
        }
    }

    public byte[] xmss_PKgen(byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
        return treehash(bArr, 0, this.f23474engine.f23496H_PRIME, bArr2, c6093adrs);
    }

    public byte[] xmss_pkFromSig(int i, SIG_XMSS sig_xmss, byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        int i2 = 0;
        c6093adrs2.setTypeAndClear(0);
        c6093adrs2.setKeyPairAddress(i);
        byte[] wOTSSig = sig_xmss.getWOTSSig();
        byte[][] xmssauth = sig_xmss.getXMSSAUTH();
        byte[] bArrPkFromSig = this.f23477wots.pkFromSig(wOTSSig, bArr, bArr2, c6093adrs2);
        c6093adrs2.setTypeAndClear(2);
        c6093adrs2.setTreeIndex(i);
        while (i2 < this.f23474engine.f23496H_PRIME) {
            int i3 = i2 + 1;
            c6093adrs2.setTreeHeight(i3);
            if (((1 << i2) & i) == 0) {
                c6093adrs2.setTreeIndex(c6093adrs2.getTreeIndex() / 2);
                bArrPkFromSig = this.f23474engine.mo17826H(bArr2, c6093adrs2, bArrPkFromSig, xmssauth[i2]);
            } else {
                c6093adrs2.setTreeIndex((c6093adrs2.getTreeIndex() - 1) / 2);
                bArrPkFromSig = this.f23474engine.mo17826H(bArr2, c6093adrs2, xmssauth[i2], bArrPkFromSig);
            }
            i2 = i3;
        }
        return bArrPkFromSig;
    }

    public SIG_XMSS xmss_sign(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, C6093ADRS c6093adrs) {
        byte[][] bArr4 = new byte[this.f23474engine.f23496H_PRIME][];
        C6093ADRS c6093adrs2 = new C6093ADRS(c6093adrs);
        c6093adrs2.setTypeAndClear(2);
        c6093adrs2.setLayerAddress(c6093adrs.getLayerAddress());
        c6093adrs2.setTreeAddress(c6093adrs.getTreeAddress());
        for (int i2 = 0; i2 < this.f23474engine.f23496H_PRIME; i2++) {
            bArr4[i2] = treehash(bArr2, ((i >>> i2) ^ 1) << i2, i2, bArr3, c6093adrs2);
        }
        C6093ADRS c6093adrs3 = new C6093ADRS(c6093adrs);
        c6093adrs3.setTypeAndClear(0);
        c6093adrs3.setKeyPairAddress(i);
        return new SIG_XMSS(this.f23477wots.m17849sign(bArr, bArr2, bArr3, c6093adrs3), bArr4);
    }
}
