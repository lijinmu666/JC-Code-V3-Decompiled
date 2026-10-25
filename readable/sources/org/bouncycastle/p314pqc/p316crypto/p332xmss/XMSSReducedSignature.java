package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    private final List<XMSSNode> authPath;

    /* renamed from: params */
    private final XMSSParameters f23665params;
    private final WOTSPlusSignature wotsPlusSignature;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature$Builder */
    public static class C6129Builder {

        /* renamed from: params */
        private final XMSSParameters f23666params;
        private WOTSPlusSignature wotsPlusSignature = null;
        private List<XMSSNode> authPath = null;
        private byte[] reducedSignature = null;

        public C6129Builder(XMSSParameters xMSSParameters) {
            this.f23666params = xMSSParameters;
        }

        /* renamed from: build */
        public XMSSReducedSignature mo17930build() {
            return new XMSSReducedSignature(this);
        }

        public C6129Builder withAuthPath(List<XMSSNode> list) {
            this.authPath = list;
            return this;
        }

        public C6129Builder withReducedSignature(byte[] bArr) {
            this.reducedSignature = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6129Builder withWOTSPlusSignature(WOTSPlusSignature wOTSPlusSignature) {
            this.wotsPlusSignature = wOTSPlusSignature;
            return this;
        }
    }

    public XMSSReducedSignature(C6129Builder c6129Builder) {
        List<XMSSNode> arrayList;
        XMSSParameters xMSSParameters = c6129Builder.f23666params;
        this.f23665params = xMSSParameters;
        if (xMSSParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSParameters.getTreeDigestSize();
        int iM17903getLen = xMSSParameters.getWOTSPlus().getParams().m17903getLen();
        int height = xMSSParameters.getHeight();
        byte[] bArr = c6129Builder.reducedSignature;
        if (bArr == null) {
            WOTSPlusSignature wOTSPlusSignature = c6129Builder.wotsPlusSignature;
            this.wotsPlusSignature = wOTSPlusSignature == null ? new WOTSPlusSignature(xMSSParameters.getWOTSPlus().getParams(), (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, iM17903getLen, treeDigestSize)) : wOTSPlusSignature;
            arrayList = c6129Builder.authPath;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            } else if (arrayList.size() != height) {
                throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
            }
        } else {
            if (bArr.length != (iM17903getLen * treeDigestSize) + (height * treeDigestSize)) {
                throw new IllegalArgumentException("signature has wrong size");
            }
            byte[][] bArr2 = new byte[iM17903getLen][];
            int i = 0;
            for (int i2 = 0; i2 < iM17903getLen; i2++) {
                bArr2[i2] = XMSSUtil.extractBytesAtOffset(bArr, i, treeDigestSize);
                i += treeDigestSize;
            }
            this.wotsPlusSignature = new WOTSPlusSignature(this.f23665params.getWOTSPlus().getParams(), bArr2);
            arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < height; i3++) {
                arrayList.add(new XMSSNode(i3, XMSSUtil.extractBytesAtOffset(bArr, i, treeDigestSize)));
                i += treeDigestSize;
            }
        }
        this.authPath = arrayList;
    }

    public List<XMSSNode> getAuthPath() {
        return this.authPath;
    }

    public XMSSParameters getParams() {
        return this.f23665params;
    }

    public WOTSPlusSignature getWOTSPlusSignature() {
        return this.wotsPlusSignature;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int treeDigestSize = this.f23665params.getTreeDigestSize();
        byte[] bArr = new byte[(this.f23665params.getWOTSPlus().getParams().m17903getLen() * treeDigestSize) + (this.f23665params.getHeight() * treeDigestSize)];
        int i = 0;
        for (byte[] bArr2 : this.wotsPlusSignature.toByteArray()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += treeDigestSize;
        }
        for (int i2 = 0; i2 < this.authPath.size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, this.authPath.get(i2).getValue(), i);
            i += treeDigestSize;
        }
        return bArr;
    }
}
