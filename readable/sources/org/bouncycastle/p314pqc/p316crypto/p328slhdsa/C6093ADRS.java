package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.slhdsa.ADRS */
/* loaded from: classes2.dex */
class C6093ADRS {

    /* renamed from: FORS_PK */
    static final int f23469FORS_PK = 4;
    static final int FORS_PRF = 6;
    static final int FORS_TREE = 3;
    static final int OFFSET_CHAIN_ADDR = 24;
    static final int OFFSET_HASH_ADDR = 28;
    static final int OFFSET_KP_ADDR = 20;
    static final int OFFSET_LAYER = 0;
    static final int OFFSET_TREE = 4;
    static final int OFFSET_TREE_HGT = 24;
    static final int OFFSET_TREE_INDEX = 28;
    static final int OFFSET_TYPE = 16;

    /* renamed from: TREE */
    static final int f23470TREE = 2;
    static final int WOTS_HASH = 0;

    /* renamed from: WOTS_PK */
    static final int f23471WOTS_PK = 1;
    static final int WOTS_PRF = 5;

    /* renamed from: value */
    final byte[] f23472value;

    public C6093ADRS() {
        this.f23472value = new byte[32];
    }

    public void changeType(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 16);
    }

    public int getKeyPairAddress() {
        return AbstractC6245Pack.bigEndianToInt(this.f23472value, 20);
    }

    public int getLayerAddress() {
        return AbstractC6245Pack.bigEndianToInt(this.f23472value, 0);
    }

    public long getTreeAddress() {
        return AbstractC6245Pack.bigEndianToLong(this.f23472value, 8);
    }

    public int getTreeIndex() {
        return AbstractC6245Pack.bigEndianToInt(this.f23472value, 28);
    }

    public void setChainAddress(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 24);
    }

    public void setHashAddress(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 28);
    }

    public void setKeyPairAddress(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 20);
    }

    public void setLayerAddress(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 0);
    }

    public void setTreeAddress(long j) {
        AbstractC6245Pack.longToBigEndian(j, this.f23472value, 8);
    }

    public void setTreeHeight(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 24);
    }

    public void setTreeIndex(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 28);
    }

    public void setTypeAndClear(int i) {
        AbstractC6245Pack.intToBigEndian(i, this.f23472value, 16);
        byte[] bArr = this.f23472value;
        C6238Arrays.m18250fill(bArr, 20, bArr.length, (byte) 0);
    }

    public C6093ADRS(C6093ADRS c6093adrs) {
        byte[] bArr = new byte[32];
        this.f23472value = bArr;
        byte[] bArr2 = c6093adrs.f23472value;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
    }
}
