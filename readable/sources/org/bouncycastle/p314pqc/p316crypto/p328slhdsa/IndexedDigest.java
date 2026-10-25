package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

/* loaded from: classes2.dex */
class IndexedDigest {

    /* renamed from: digest */
    final byte[] f23483digest;
    final int idx_leaf;
    final long idx_tree;

    public IndexedDigest(long j, int i, byte[] bArr) {
        this.idx_tree = j;
        this.idx_leaf = i;
        this.f23483digest = bArr;
    }
}
