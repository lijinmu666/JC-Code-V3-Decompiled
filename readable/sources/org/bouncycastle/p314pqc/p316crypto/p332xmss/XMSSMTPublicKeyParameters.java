package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSMTPublicKeyParameters extends XMSSMTKeyParameters implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: oid */
    private final int f23638oid;

    /* renamed from: params */
    private final XMSSMTParameters f23639params;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23640root;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters$Builder */
    public static class C6121Builder {

        /* renamed from: params */
        private final XMSSMTParameters f23641params;

        /* renamed from: root */
        private byte[] f23642root = null;
        private byte[] publicSeed = null;
        private byte[] publicKey = null;

        public C6121Builder(XMSSMTParameters xMSSMTParameters) {
            this.f23641params = xMSSMTParameters;
        }

        /* renamed from: build */
        public XMSSMTPublicKeyParameters m17919build() {
            return new XMSSMTPublicKeyParameters(this);
        }

        public C6121Builder withPublicKey(byte[] bArr) {
            this.publicKey = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6121Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6121Builder withRoot(byte[] bArr) {
            this.f23642root = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSMTPublicKeyParameters(C6121Builder c6121Builder) {
        super(false, c6121Builder.f23641params.getTreeDigest());
        XMSSMTParameters xMSSMTParameters = c6121Builder.f23641params;
        this.f23639params = xMSSMTParameters;
        if (xMSSMTParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSMTParameters.getTreeDigestSize();
        byte[] bArr = c6121Builder.publicKey;
        if (bArr != null) {
            if (bArr.length == treeDigestSize + treeDigestSize) {
                this.f23638oid = 0;
                this.f23640root = XMSSUtil.extractBytesAtOffset(bArr, 0, treeDigestSize);
                this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, treeDigestSize, treeDigestSize);
                return;
            } else {
                if (bArr.length != treeDigestSize + 4 + treeDigestSize) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f23638oid = AbstractC6245Pack.bigEndianToInt(bArr, 0);
                this.f23640root = XMSSUtil.extractBytesAtOffset(bArr, 4, treeDigestSize);
                this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, 4 + treeDigestSize, treeDigestSize);
                return;
            }
        }
        if (xMSSMTParameters.m17914getOid() != null) {
            this.f23638oid = xMSSMTParameters.m17914getOid().mo17891getOid();
        } else {
            this.f23638oid = 0;
        }
        byte[] bArr2 = c6121Builder.f23642root;
        if (bArr2 == null) {
            this.f23640root = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f23640root = bArr2;
        }
        byte[] bArr3 = c6121Builder.publicSeed;
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

    public XMSSMTParameters getParameters() {
        return this.f23639params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17918getRoot() {
        return XMSSUtil.cloneArray(this.f23640root);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    @Deprecated
    public byte[] toByteArray() {
        byte[] bArr;
        int treeDigestSize = this.f23639params.getTreeDigestSize();
        int i = this.f23638oid;
        int i2 = 0;
        if (i != 0) {
            bArr = new byte[treeDigestSize + 4 + treeDigestSize];
            AbstractC6245Pack.intToBigEndian(i, bArr, 0);
            i2 = 4;
        } else {
            bArr = new byte[treeDigestSize + treeDigestSize];
        }
        XMSSUtil.copyBytesAtOffset(bArr, this.f23640root, i2);
        XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2 + treeDigestSize);
        return bArr;
    }
}
