package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
final class LTreeAddress extends XMSSAddress {

    /* renamed from: TYPE */
    private static final int f23606TYPE = 1;
    private final int lTreeAddress;
    private final int treeHeight;
    private final int treeIndex;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.LTreeAddress$Builder */
    public static class C6112Builder extends XMSSAddress.AbstractC6116Builder<C6112Builder> {
        private int lTreeAddress;
        private int treeHeight;
        private int treeIndex;

        public C6112Builder() {
            super(1);
            this.lTreeAddress = 0;
            this.treeHeight = 0;
            this.treeIndex = 0;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: build */
        public XMSSAddress mo17893build() {
            return new LTreeAddress(this);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: getThis */
        public C6112Builder mo17894getThis() {
            return this;
        }

        public C6112Builder withLTreeAddress(int i) {
            this.lTreeAddress = i;
            return this;
        }

        public C6112Builder withTreeHeight(int i) {
            this.treeHeight = i;
            return this;
        }

        public C6112Builder withTreeIndex(int i) {
            this.treeIndex = i;
            return this;
        }
    }

    private LTreeAddress(C6112Builder c6112Builder) {
        super(c6112Builder);
        this.lTreeAddress = c6112Builder.lTreeAddress;
        this.treeHeight = c6112Builder.treeHeight;
        this.treeIndex = c6112Builder.treeIndex;
    }

    public int getLTreeAddress() {
        return this.lTreeAddress;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public int getTreeIndex() {
        return this.treeIndex;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        AbstractC6245Pack.intToBigEndian(this.lTreeAddress, byteArray, 16);
        AbstractC6245Pack.intToBigEndian(this.treeHeight, byteArray, 20);
        AbstractC6245Pack.intToBigEndian(this.treeIndex, byteArray, 24);
        return byteArray;
    }
}
