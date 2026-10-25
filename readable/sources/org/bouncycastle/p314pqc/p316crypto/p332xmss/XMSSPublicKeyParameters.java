package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSPublicKeyParameters extends XMSSKeyParameters implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: oid */
    private final int f23660oid;

    /* renamed from: params */
    private final XMSSParameters f23661params;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23662root;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters$Builder */
    public static class C6128Builder {

        /* renamed from: params */
        private final XMSSParameters f23663params;

        /* renamed from: root */
        private byte[] f23664root = null;
        private byte[] publicSeed = null;
        private byte[] publicKey = null;

        public C6128Builder(XMSSParameters xMSSParameters) {
            this.f23663params = xMSSParameters;
        }

        /* renamed from: build */
        public XMSSPublicKeyParameters m17929build() {
            return new XMSSPublicKeyParameters(this);
        }

        public C6128Builder withPublicKey(byte[] bArr) {
            this.publicKey = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6128Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6128Builder withRoot(byte[] bArr) {
            this.f23664root = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSPublicKeyParameters(C6128Builder c6128Builder) {
        super(false, c6128Builder.f23663params.getTreeDigest());
        XMSSParameters xMSSParameters = c6128Builder.f23663params;
        this.f23661params = xMSSParameters;
        if (xMSSParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSParameters.getTreeDigestSize();
        byte[] bArr = c6128Builder.publicKey;
        if (bArr != null) {
            if (bArr.length == treeDigestSize + treeDigestSize) {
                this.f23660oid = 0;
                this.f23662root = XMSSUtil.extractBytesAtOffset(bArr, 0, treeDigestSize);
                this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, treeDigestSize, treeDigestSize);
                return;
            } else {
                if (bArr.length != treeDigestSize + 4 + treeDigestSize) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f23660oid = AbstractC6245Pack.bigEndianToInt(bArr, 0);
                this.f23662root = XMSSUtil.extractBytesAtOffset(bArr, 4, treeDigestSize);
                this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, 4 + treeDigestSize, treeDigestSize);
                return;
            }
        }
        if (xMSSParameters.m17924getOid() != null) {
            this.f23660oid = xMSSParameters.m17924getOid().mo17891getOid();
        } else {
            this.f23660oid = 0;
        }
        byte[] bArr2 = c6128Builder.f23664root;
        if (bArr2 == null) {
            this.f23662root = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f23662root = bArr2;
        }
        byte[] bArr3 = c6128Builder.publicSeed;
        if (bArr3 == null) {
            this.publicSeed = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.publicSeed = bArr3;
        }
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    public XMSSParameters getParameters() {
        return this.f23661params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17928getRoot() {
        return XMSSUtil.cloneArray(this.f23662root);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    @Deprecated
    public byte[] toByteArray() {
        byte[] bArr;
        int treeDigestSize = this.f23661params.getTreeDigestSize();
        int i = this.f23660oid;
        int i2 = 0;
        if (i != 0) {
            bArr = new byte[treeDigestSize + 4 + treeDigestSize];
            AbstractC6245Pack.intToBigEndian(i, bArr, 0);
            i2 = 4;
        } else {
            bArr = new byte[treeDigestSize + treeDigestSize];
        }
        XMSSUtil.copyBytesAtOffset(bArr, this.f23662root, i2);
        XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2 + treeDigestSize);
        return bArr;
    }
}
