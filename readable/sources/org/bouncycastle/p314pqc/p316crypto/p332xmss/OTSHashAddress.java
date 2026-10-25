package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
final class OTSHashAddress extends XMSSAddress {

    /* renamed from: TYPE */
    private static final int f23607TYPE = 0;
    private final int chainAddress;
    private final int hashAddress;
    private final int otsAddress;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$Builder */
    public static class C6114Builder extends XMSSAddress.AbstractC6116Builder<C6114Builder> {
        private int chainAddress;
        private int hashAddress;
        private int otsAddress;

        public C6114Builder() {
            super(0);
            this.otsAddress = 0;
            this.chainAddress = 0;
            this.hashAddress = 0;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: build */
        public XMSSAddress mo17893build() {
            return new OTSHashAddress(this);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress.AbstractC6116Builder
        /* renamed from: getThis */
        public C6114Builder mo17894getThis() {
            return this;
        }

        public C6114Builder withChainAddress(int i) {
            this.chainAddress = i;
            return this;
        }

        public C6114Builder withHashAddress(int i) {
            this.hashAddress = i;
            return this;
        }

        public C6114Builder withOTSAddress(int i) {
            this.otsAddress = i;
            return this;
        }
    }

    private OTSHashAddress(C6114Builder c6114Builder) {
        super(c6114Builder);
        this.otsAddress = c6114Builder.otsAddress;
        this.chainAddress = c6114Builder.chainAddress;
        this.hashAddress = c6114Builder.hashAddress;
    }

    public int getChainAddress() {
        return this.chainAddress;
    }

    public int getHashAddress() {
        return this.hashAddress;
    }

    public int getOTSAddress() {
        return this.otsAddress;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        AbstractC6245Pack.intToBigEndian(this.otsAddress, byteArray, 16);
        AbstractC6245Pack.intToBigEndian(this.chainAddress, byteArray, 20);
        AbstractC6245Pack.intToBigEndian(this.hashAddress, byteArray, 24);
        return byteArray;
    }
}
