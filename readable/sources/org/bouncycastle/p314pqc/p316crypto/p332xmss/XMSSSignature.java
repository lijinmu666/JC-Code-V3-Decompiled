package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSReducedSignature;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSSignature extends XMSSReducedSignature implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: index */
    private final int f23667index;

    /* renamed from: random */
    private final byte[] f23668random;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSSignature$Builder */
    public static class C6131Builder extends XMSSReducedSignature.C6129Builder {

        /* renamed from: index */
        private int f23669index;

        /* renamed from: params */
        private final XMSSParameters f23670params;

        /* renamed from: random */
        private byte[] f23671random;

        public C6131Builder(XMSSParameters xMSSParameters) {
            super(xMSSParameters);
            this.f23669index = 0;
            this.f23671random = null;
            this.f23670params = xMSSParameters;
        }

        public C6131Builder withIndex(int i) {
            this.f23669index = i;
            return this;
        }

        public C6131Builder withRandom(byte[] bArr) {
            this.f23671random = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6131Builder withSignature(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("signature == null");
            }
            int treeDigestSize = this.f23670params.getTreeDigestSize();
            int iM17903getLen = this.f23670params.getWOTSPlus().getParams().m17903getLen();
            int height = this.f23670params.getHeight() * treeDigestSize;
            this.f23669index = AbstractC6245Pack.bigEndianToInt(bArr, 0);
            this.f23671random = XMSSUtil.extractBytesAtOffset(bArr, 4, treeDigestSize);
            withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, 4 + treeDigestSize, (iM17903getLen * treeDigestSize) + height));
            return this;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSReducedSignature.C6129Builder
        /* renamed from: build */
        public XMSSSignature mo17930build() {
            return new XMSSSignature(this);
        }
    }

    private XMSSSignature(C6131Builder c6131Builder) {
        super(c6131Builder);
        this.f23667index = c6131Builder.f23669index;
        int treeDigestSize = getParams().getTreeDigestSize();
        byte[] bArr = c6131Builder.f23671random;
        if (bArr == null) {
            this.f23668random = new byte[treeDigestSize];
        } else {
            if (bArr.length != treeDigestSize) {
                throw new IllegalArgumentException("size of random needs to be equal to size of digest");
            }
            this.f23668random = bArr;
        }
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    public int getIndex() {
        return this.f23667index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.f23668random);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSReducedSignature, org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int treeDigestSize = getParams().getTreeDigestSize();
        byte[] bArr = new byte[treeDigestSize + 4 + (getParams().getWOTSPlus().getParams().m17903getLen() * treeDigestSize) + (getParams().getHeight() * treeDigestSize)];
        AbstractC6245Pack.intToBigEndian(this.f23667index, bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.f23668random, 4);
        int i = 4 + treeDigestSize;
        for (byte[] bArr2 : getWOTSPlusSignature().toByteArray()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += treeDigestSize;
        }
        for (int i2 = 0; i2 < getAuthPath().size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, getAuthPath().get(i2).getValue(), i);
            i += treeDigestSize;
        }
        return bArr;
    }
}
