package org.bouncycastle.p314pqc.p352legacy.p354picnic;

/* renamed from: org.bouncycastle.pqc.legacy.picnic.View */
/* loaded from: classes2.dex */
class C6220View {
    final byte[] communicatedBits;
    final int[] inputShare;
    final int[] outputShare;

    public C6220View(PicnicEngine picnicEngine) {
        int i = picnicEngine.stateSizeWords;
        this.inputShare = new int[i];
        this.communicatedBits = new byte[picnicEngine.andSizeBytes];
        this.outputShare = new int[i];
    }
}
