package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

import java.util.LinkedList;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.crypto.signers.slhdsa.HT */
/* loaded from: classes2.dex */
class C5394HT {

    /* renamed from: engine */
    SLHDSAEngine f21067engine;
    final byte[] htPubKey;

    /* renamed from: pkSeed */
    private final byte[] f21068pkSeed;

    /* renamed from: skSeed */
    private final byte[] f21069skSeed;

    /* renamed from: wots */
    WotsPlus f21070wots;

    public C5394HT(SLHDSAEngine sLHDSAEngine, byte[] bArr, byte[] bArr2) {
        this.f21069skSeed = bArr;
        this.f21068pkSeed = bArr2;
        this.f21067engine = sLHDSAEngine;
        this.f21070wots = new WotsPlus(sLHDSAEngine);
        C5392ADRS c5392adrs = new C5392ADRS();
        c5392adrs.setLayerAddress(sLHDSAEngine.f21078D - 1);
        c5392adrs.setTreeAddress(0L);
        if (bArr != null) {
            this.htPubKey = xmss_PKgen(bArr, bArr2, c5392adrs);
        } else {
            this.htPubKey = null;
        }
    }

    /* renamed from: sign */
    public byte[] m15883sign(byte[] bArr, long j, int i) {
        long j2 = j;
        C5392ADRS c5392adrs = new C5392ADRS();
        c5392adrs.setLayerAddress(0);
        c5392adrs.setTreeAddress(j2);
        SIG_XMSS sig_xmssXmss_sign = xmss_sign(bArr, this.f21069skSeed, i, this.f21068pkSeed, c5392adrs);
        int i2 = this.f21067engine.f21078D;
        SIG_XMSS[] sig_xmssArr = new SIG_XMSS[i2];
        sig_xmssArr[0] = sig_xmssXmss_sign;
        c5392adrs.setLayerAddress(0);
        c5392adrs.setTreeAddress(j2);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmssXmss_sign, bArr, this.f21068pkSeed, c5392adrs);
        int i3 = 1;
        while (true) {
            SLHDSAEngine sLHDSAEngine = this.f21067engine;
            if (i3 >= sLHDSAEngine.f21078D) {
                break;
            }
            int i4 = (int) (((1 << r0) - 1) & j2);
            j2 >>>= sLHDSAEngine.f21080H_PRIME;
            c5392adrs.setLayerAddress(i3);
            c5392adrs.setTreeAddress(j2);
            SIG_XMSS sig_xmssXmss_sign2 = xmss_sign(bArrXmss_pkFromSig, this.f21069skSeed, i4, this.f21068pkSeed, c5392adrs);
            sig_xmssArr[i3] = sig_xmssXmss_sign2;
            if (i3 < this.f21067engine.f21078D - 1) {
                bArrXmss_pkFromSig = xmss_pkFromSig(i4, sig_xmssXmss_sign2, bArrXmss_pkFromSig, this.f21068pkSeed, c5392adrs);
            }
            i3++;
        }
        byte[][] bArr2 = new byte[i2][];
        for (int i5 = 0; i5 != i2; i5++) {
            SIG_XMSS sig_xmss = sig_xmssArr[i5];
            bArr2[i5] = C6238Arrays.concatenate(sig_xmss.f21076sig, C6238Arrays.concatenate(sig_xmss.f21075auth));
        }
        return C6238Arrays.concatenate(bArr2);
    }

    public byte[] treehash(byte[] bArr, int i, int i2, byte[] bArr2, C5392ADRS c5392adrs) {
        if (((i >>> i2) << i2) != i) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        for (int i3 = 0; i3 < (1 << i2); i3++) {
            c5392adrs2.setTypeAndClear(0);
            int i4 = i + i3;
            c5392adrs2.setKeyPairAddress(i4);
            byte[] bArrM15900pkGen = this.f21070wots.m15900pkGen(bArr, bArr2, c5392adrs2);
            c5392adrs2.setTypeAndClear(2);
            c5392adrs2.setTreeHeight(1);
            c5392adrs2.setTreeIndex(i4);
            int i5 = 1;
            while (!linkedList.isEmpty() && ((NodeEntry) linkedList.get(0)).nodeHeight == i5) {
                i4 = (i4 - 1) / 2;
                c5392adrs2.setTreeIndex(i4);
                bArrM15900pkGen = this.f21067engine.mo15888H(bArr2, c5392adrs2, ((NodeEntry) linkedList.remove(0)).nodeValue, bArrM15900pkGen);
                i5++;
                c5392adrs2.setTreeHeight(i5);
            }
            linkedList.add(0, new NodeEntry(bArrM15900pkGen, i5));
        }
        return ((NodeEntry) linkedList.get(0)).nodeValue;
    }

    /* renamed from: verify */
    public boolean m15884verify(byte[] bArr, SIG_XMSS[] sig_xmssArr, byte[] bArr2, long j, int i, byte[] bArr3) {
        C5392ADRS c5392adrs = new C5392ADRS();
        SIG_XMSS sig_xmss = sig_xmssArr[0];
        c5392adrs.setLayerAddress(0);
        c5392adrs.setTreeAddress(j);
        byte[] bArrXmss_pkFromSig = xmss_pkFromSig(i, sig_xmss, bArr, bArr2, c5392adrs);
        int i2 = 1;
        while (true) {
            SLHDSAEngine sLHDSAEngine = this.f21067engine;
            if (i2 >= sLHDSAEngine.f21078D) {
                return C6238Arrays.areEqual(bArr3, bArrXmss_pkFromSig);
            }
            int i3 = (int) (((1 << r0) - 1) & j);
            j >>>= sLHDSAEngine.f21080H_PRIME;
            SIG_XMSS sig_xmss2 = sig_xmssArr[i2];
            c5392adrs.setLayerAddress(i2);
            c5392adrs.setTreeAddress(j);
            bArrXmss_pkFromSig = xmss_pkFromSig(i3, sig_xmss2, bArrXmss_pkFromSig, bArr2, c5392adrs);
            i2++;
        }
    }

    public byte[] xmss_PKgen(byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs) {
        return treehash(bArr, 0, this.f21067engine.f21080H_PRIME, bArr2, c5392adrs);
    }

    public byte[] xmss_pkFromSig(int i, SIG_XMSS sig_xmss, byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs) {
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        int i2 = 0;
        c5392adrs2.setTypeAndClear(0);
        c5392adrs2.setKeyPairAddress(i);
        byte[] wOTSSig = sig_xmss.getWOTSSig();
        byte[][] xmssauth = sig_xmss.getXMSSAUTH();
        byte[] bArrPkFromSig = this.f21070wots.pkFromSig(wOTSSig, bArr, bArr2, c5392adrs2);
        c5392adrs2.setTypeAndClear(2);
        c5392adrs2.setTreeIndex(i);
        while (i2 < this.f21067engine.f21080H_PRIME) {
            int i3 = i2 + 1;
            c5392adrs2.setTreeHeight(i3);
            if (((1 << i2) & i) == 0) {
                c5392adrs2.setTreeIndex(c5392adrs2.getTreeIndex() / 2);
                bArrPkFromSig = this.f21067engine.mo15888H(bArr2, c5392adrs2, bArrPkFromSig, xmssauth[i2]);
            } else {
                c5392adrs2.setTreeIndex((c5392adrs2.getTreeIndex() - 1) / 2);
                bArrPkFromSig = this.f21067engine.mo15888H(bArr2, c5392adrs2, xmssauth[i2], bArrPkFromSig);
            }
            i2 = i3;
        }
        return bArrPkFromSig;
    }

    public SIG_XMSS xmss_sign(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, C5392ADRS c5392adrs) {
        byte[][] bArr4 = new byte[this.f21067engine.f21080H_PRIME][];
        C5392ADRS c5392adrs2 = new C5392ADRS(c5392adrs);
        c5392adrs2.setTypeAndClear(2);
        c5392adrs2.setLayerAddress(c5392adrs.getLayerAddress());
        c5392adrs2.setTreeAddress(c5392adrs.getTreeAddress());
        for (int i2 = 0; i2 < this.f21067engine.f21080H_PRIME; i2++) {
            bArr4[i2] = treehash(bArr2, ((i >>> i2) ^ 1) << i2, i2, bArr3, c5392adrs2);
        }
        C5392ADRS c5392adrs3 = new C5392ADRS(c5392adrs);
        c5392adrs3.setTypeAndClear(0);
        c5392adrs3.setKeyPairAddress(i);
        return new SIG_XMSS(this.f21070wots.m15901sign(bArr, bArr2, bArr3, c5392adrs3), bArr4);
    }
}
