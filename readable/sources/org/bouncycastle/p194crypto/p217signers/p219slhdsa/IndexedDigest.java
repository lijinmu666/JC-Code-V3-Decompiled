package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

/* loaded from: classes2.dex */
class IndexedDigest {

    /* renamed from: digest */
    final byte[] f21071digest;
    final int idx_leaf;
    final long idx_tree;

    public IndexedDigest(long j, int i, byte[] bArr) {
        this.idx_tree = j;
        this.idx_leaf = i;
        this.f21071digest = bArr;
    }
}
