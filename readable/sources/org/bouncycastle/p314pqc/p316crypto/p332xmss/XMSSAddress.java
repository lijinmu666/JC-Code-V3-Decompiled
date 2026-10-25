package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public abstract class XMSSAddress {
    private final int keyAndMask;
    private final int layerAddress;
    private final long treeAddress;

    /* renamed from: type */
    private final int f23617type;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSAddress$Builder */
    public static abstract class AbstractC6116Builder<T extends AbstractC6116Builder> {

        /* renamed from: type */
        private final int f23618type;
        private int layerAddress = 0;
        private long treeAddress = 0;
        private int keyAndMask = 0;

        public AbstractC6116Builder(int i) {
            this.f23618type = i;
        }

        /* renamed from: build */
        public abstract XMSSAddress mo17893build();

        /* renamed from: getThis */
        public abstract T mo17894getThis();

        public T withKeyAndMask(int i) {
            this.keyAndMask = i;
            return (T) mo17894getThis();
        }

        public T withLayerAddress(int i) {
            this.layerAddress = i;
            return (T) mo17894getThis();
        }

        public T withTreeAddress(long j) {
            this.treeAddress = j;
            return (T) mo17894getThis();
        }
    }

    public XMSSAddress(AbstractC6116Builder abstractC6116Builder) {
        this.layerAddress = abstractC6116Builder.layerAddress;
        this.treeAddress = abstractC6116Builder.treeAddress;
        this.f23617type = abstractC6116Builder.f23618type;
        this.keyAndMask = abstractC6116Builder.keyAndMask;
    }

    public final int getKeyAndMask() {
        return this.keyAndMask;
    }

    public final int getLayerAddress() {
        return this.layerAddress;
    }

    public final long getTreeAddress() {
        return this.treeAddress;
    }

    /* renamed from: getType */
    public final int m17910getType() {
        return this.f23617type;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[32];
        AbstractC6245Pack.intToBigEndian(this.layerAddress, bArr, 0);
        AbstractC6245Pack.longToBigEndian(this.treeAddress, bArr, 4);
        AbstractC6245Pack.intToBigEndian(this.f23617type, bArr, 12);
        AbstractC6245Pack.intToBigEndian(this.keyAndMask, bArr, 28);
        return bArr;
    }
}
