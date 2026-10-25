package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSReducedSignature;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSMTSignature implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: index */
    private final long f23643index;

    /* renamed from: params */
    private final XMSSMTParameters f23644params;

    /* renamed from: random */
    private final byte[] f23645random;
    private final List<XMSSReducedSignature> reducedSignatures;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTSignature$Builder */
    public static class C6123Builder {

        /* renamed from: params */
        private final XMSSMTParameters f23647params;

        /* renamed from: index */
        private long f23646index = 0;

        /* renamed from: random */
        private byte[] f23648random = null;
        private List<XMSSReducedSignature> reducedSignatures = null;
        private byte[] signature = null;

        public C6123Builder(XMSSMTParameters xMSSMTParameters) {
            this.f23647params = xMSSMTParameters;
        }

        /* renamed from: build */
        public XMSSMTSignature m17920build() {
            return new XMSSMTSignature(this);
        }

        public C6123Builder withIndex(long j) {
            this.f23646index = j;
            return this;
        }

        public C6123Builder withRandom(byte[] bArr) {
            this.f23648random = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6123Builder withReducedSignatures(List<XMSSReducedSignature> list) {
            this.reducedSignatures = list;
            return this;
        }

        public C6123Builder withSignature(byte[] bArr) {
            this.signature = C6238Arrays.m18231clone(bArr);
            return this;
        }
    }

    private XMSSMTSignature(C6123Builder c6123Builder) {
        XMSSMTParameters xMSSMTParameters = c6123Builder.f23647params;
        this.f23644params = xMSSMTParameters;
        if (xMSSMTParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSMTParameters.getTreeDigestSize();
        byte[] bArr = c6123Builder.signature;
        if (bArr == null) {
            this.f23643index = c6123Builder.f23646index;
            byte[] bArr2 = c6123Builder.f23648random;
            if (bArr2 == null) {
                this.f23645random = new byte[treeDigestSize];
            } else {
                if (bArr2.length != treeDigestSize) {
                    throw new IllegalArgumentException("size of random needs to be equal to size of digest");
                }
                this.f23645random = bArr2;
            }
            List<XMSSReducedSignature> list = c6123Builder.reducedSignatures;
            this.reducedSignatures = list == null ? new ArrayList<>() : list;
            return;
        }
        int iM17903getLen = xMSSMTParameters.getWOTSPlus().getParams().m17903getLen();
        int iCeil = (int) Math.ceil(xMSSMTParameters.getHeight() / 8.0d);
        int height = ((xMSSMTParameters.getHeight() / xMSSMTParameters.getLayers()) + iM17903getLen) * treeDigestSize;
        if (bArr.length != iCeil + treeDigestSize + (xMSSMTParameters.getLayers() * height)) {
            throw new IllegalArgumentException("signature has wrong size");
        }
        long jBytesToXBigEndian = XMSSUtil.bytesToXBigEndian(bArr, 0, iCeil);
        this.f23643index = jBytesToXBigEndian;
        if (!XMSSUtil.isIndexValid(xMSSMTParameters.getHeight(), jBytesToXBigEndian)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        this.f23645random = XMSSUtil.extractBytesAtOffset(bArr, iCeil, treeDigestSize);
        this.reducedSignatures = new ArrayList();
        for (int i = iCeil + treeDigestSize; i < bArr.length; i += height) {
            this.reducedSignatures.add(new XMSSReducedSignature.C6129Builder(this.f23644params.getXMSSParameters()).withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, i, height)).mo17930build());
        }
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    public long getIndex() {
        return this.f23643index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.f23645random);
    }

    public List<XMSSReducedSignature> getReducedSignatures() {
        return this.reducedSignatures;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        int treeDigestSize = this.f23644params.getTreeDigestSize();
        int iM17903getLen = this.f23644params.getWOTSPlus().getParams().m17903getLen();
        int iCeil = (int) Math.ceil(this.f23644params.getHeight() / 8.0d);
        int height = ((this.f23644params.getHeight() / this.f23644params.getLayers()) + iM17903getLen) * treeDigestSize;
        byte[] bArr = new byte[iCeil + treeDigestSize + (this.f23644params.getLayers() * height)];
        XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.f23643index, iCeil), 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.f23645random, iCeil);
        int i = iCeil + treeDigestSize;
        Iterator<XMSSReducedSignature> it = this.reducedSignatures.iterator();
        while (it.hasNext()) {
            XMSSUtil.copyBytesAtOffset(bArr, it.next().toByteArray(), i);
            i += height;
        }
        return bArr;
    }
}
