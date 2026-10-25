package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
final class HashTreeAddress extends XMSSAddress {

    /* renamed from: PADDING */
    private static final int f23602PADDING = 0;

    /* renamed from: TYPE */
    private static final int f23603TYPE = 2;

    /* renamed from: padding */
    private final int f23604padding;
    private final int treeHeight;
    private final int treeIndex;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.HashTreeAddress$Builder */
    public static class C6110Builder extends XMSSAddress.AbstractC6116Builder<C6110Builder> {
        private int treeHeight;
        private int treeIndex;

        public C6110Builder() {
            super(2);
            this.treeHeight = 0;
            this.treeIndex = 0;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: build */
        public XMSSAddress mo17893build() {
            return new HashTreeAddress(this);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: getThis */
        public C6110Builder mo17894getThis() {
            return this;
        }

        public C6110Builder withTreeHeight(int i) {
            this.treeHeight = i;
            return this;
        }

        public C6110Builder withTreeIndex(int i) {
            this.treeIndex = i;
            return this;
        }
    }

    private HashTreeAddress(C6110Builder c6110Builder) {
        super(c6110Builder);
        this.f23604padding = 0;
        this.treeHeight = c6110Builder.treeHeight;
        this.treeIndex = c6110Builder.treeIndex;
    }

    public int getPadding() {
        return this.f23604padding;
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
        AbstractC6245Pack.intToBigEndian(this.f23604padding, byteArray, 16);
        AbstractC6245Pack.intToBigEndian(this.treeHeight, byteArray, 20);
        AbstractC6245Pack.intToBigEndian(this.treeIndex, byteArray, 24);
        return byteArray;
    }
}
