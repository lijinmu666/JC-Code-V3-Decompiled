package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.io.IOException;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSMTPrivateKeyParameters extends XMSSMTKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile BDSStateMap bdsState;

    /* renamed from: index */
    private volatile long f23630index;

    /* renamed from: params */
    private final XMSSMTParameters f23631params;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23632root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* renamed from: used */
    private volatile boolean f23633used;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters$Builder */
    public static class C6119Builder {

        /* renamed from: params */
        private final XMSSMTParameters f23635params;

        /* renamed from: index */
        private long f23634index = 0;
        private long maxIndex = -1;
        private byte[] secretKeySeed = null;
        private byte[] secretKeyPRF = null;
        private byte[] publicSeed = null;

        /* renamed from: root */
        private byte[] f23636root = null;
        private BDSStateMap bdsState = null;
        private byte[] privateKey = null;

        /* renamed from: xmss */
        private XMSSParameters f23637xmss = null;

        public C6119Builder(XMSSMTParameters xMSSMTParameters) {
            this.f23635params = xMSSMTParameters;
        }

        /* renamed from: build */
        public XMSSMTPrivateKeyParameters m17917build() {
            return new XMSSMTPrivateKeyParameters(this);
        }

        public C6119Builder withBDSState(BDSStateMap bDSStateMap) {
            if (bDSStateMap.getMaxIndex() == 0) {
                this.bdsState = new BDSStateMap(bDSStateMap, (1 << this.f23635params.getHeight()) - 1);
            } else {
                this.bdsState = bDSStateMap;
            }
            return this;
        }

        public C6119Builder withIndex(long j) {
            this.f23634index = j;
            return this;
        }

        public C6119Builder withMaxIndex(long j) {
            this.maxIndex = j;
            return this;
        }

        public C6119Builder withPrivateKey(byte[] bArr) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            this.f23637xmss = this.f23635params.getXMSSParameters();
            return this;
        }

        public C6119Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6119Builder withRoot(byte[] bArr) {
            this.f23636root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6119Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6119Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSMTPrivateKeyParameters(C6119Builder c6119Builder) {
        super(true, c6119Builder.f23635params.getTreeDigest());
        XMSSMTParameters xMSSMTParameters = c6119Builder.f23635params;
        this.f23631params = xMSSMTParameters;
        if (xMSSMTParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSMTParameters.getTreeDigestSize();
        byte[] bArr = c6119Builder.privateKey;
        if (bArr != null) {
            if (c6119Builder.f23637xmss == null) {
                throw new NullPointerException("xmss == null");
            }
            int height = xMSSMTParameters.getHeight();
            int i = (height + 7) / 8;
            this.f23630index = XMSSUtil.bytesToXBigEndian(bArr, 0, i);
            if (!XMSSUtil.isIndexValid(height, this.f23630index)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.secretKeySeed = XMSSUtil.extractBytesAtOffset(bArr, i, treeDigestSize);
            int i2 = i + treeDigestSize;
            this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(bArr, i2, treeDigestSize);
            int i3 = i2 + treeDigestSize;
            this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, i3, treeDigestSize);
            int i4 = i3 + treeDigestSize;
            this.f23632root = XMSSUtil.extractBytesAtOffset(bArr, i4, treeDigestSize);
            int i5 = i4 + treeDigestSize;
            try {
                this.bdsState = ((BDSStateMap) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(bArr, i5, bArr.length - i5), BDSStateMap.class)).withWOTSDigest(c6119Builder.f23637xmss.getTreeDigestOID());
                return;
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }
        this.f23630index = c6119Builder.f23634index;
        byte[] bArr2 = c6119Builder.secretKeySeed;
        if (bArr2 == null) {
            this.secretKeySeed = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.secretKeySeed = bArr2;
        }
        byte[] bArr3 = c6119Builder.secretKeyPRF;
        if (bArr3 == null) {
            this.secretKeyPRF = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.secretKeyPRF = bArr3;
        }
        byte[] bArr4 = c6119Builder.publicSeed;
        if (bArr4 == null) {
            this.publicSeed = new byte[treeDigestSize];
        } else {
            if (bArr4.length != treeDigestSize) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.publicSeed = bArr4;
        }
        byte[] bArr5 = c6119Builder.f23636root;
        if (bArr5 == null) {
            this.f23632root = new byte[treeDigestSize];
        } else {
            if (bArr5.length != treeDigestSize) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f23632root = bArr5;
        }
        BDSStateMap bDSStateMap = c6119Builder.bdsState;
        if (bDSStateMap == null) {
            bDSStateMap = (!XMSSUtil.isIndexValid(xMSSMTParameters.getHeight(), c6119Builder.f23634index) || bArr4 == null || bArr2 == null) ? new BDSStateMap(c6119Builder.maxIndex + 1) : new BDSStateMap(xMSSMTParameters, c6119Builder.f23634index, bArr4, bArr2);
        }
        this.bdsState = bDSStateMap;
        if (c6119Builder.maxIndex >= 0 && c6119Builder.maxIndex != this.bdsState.getMaxIndex()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public XMSSMTPrivateKeyParameters extractKeyShard(int i) {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParametersM17917build;
        if (i < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j = i;
            try {
                if (j > getUsagesRemaining()) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                xMSSMTPrivateKeyParametersM17917build = new C6119Builder(this.f23631params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.f23632root).withIndex(getIndex()).withBDSState(new BDSStateMap(this.bdsState, (getIndex() + j) - 1)).m17917build();
                for (int i2 = 0; i2 != i; i2++) {
                    m17916rollKey();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xMSSMTPrivateKeyParametersM17917build;
    }

    public BDSStateMap getBDSState() {
        return this.bdsState;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public long getIndex() {
        return this.f23630index;
    }

    public XMSSMTPrivateKeyParameters getNextKey() {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParametersExtractKeyShard;
        synchronized (this) {
            xMSSMTPrivateKeyParametersExtractKeyShard = extractKeyShard(1);
        }
        return xMSSMTPrivateKeyParametersExtractKeyShard;
    }

    public XMSSMTParameters getParameters() {
        return this.f23631params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17915getRoot() {
        return XMSSUtil.cloneArray(this.f23632root);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public long getUsagesRemaining() {
        long maxIndex;
        synchronized (this) {
            maxIndex = (this.bdsState.getMaxIndex() - getIndex()) + 1;
        }
        return maxIndex;
    }

    /* renamed from: rollKey */
    public XMSSMTPrivateKeyParameters m17916rollKey() {
        synchronized (this) {
            try {
                if (getIndex() < this.bdsState.getMaxIndex()) {
                    this.bdsState.updateState(this.f23631params, this.f23630index, this.publicSeed, this.secretKeySeed);
                    this.f23630index++;
                } else {
                    this.f23630index = this.bdsState.getMaxIndex() + 1;
                    this.bdsState = new BDSStateMap(this.bdsState.getMaxIndex());
                }
                this.f23633used = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSStoreableObjectInterface
    @Deprecated
    public byte[] toByteArray() {
        byte[] bArrConcatenate;
        synchronized (this) {
            try {
                int treeDigestSize = this.f23631params.getTreeDigestSize();
                int height = (this.f23631params.getHeight() + 7) / 8;
                byte[] bArr = new byte[height + treeDigestSize + treeDigestSize + treeDigestSize + treeDigestSize];
                XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.f23630index, height), 0);
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, height);
                int i = height + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i);
                int i2 = i + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2);
                XMSSUtil.copyBytesAtOffset(bArr, this.f23632root, i2 + treeDigestSize);
                try {
                    bArrConcatenate = C6238Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
                } catch (IOException e) {
                    throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrConcatenate;
    }
}
