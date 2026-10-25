package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.io.IOException;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public final class XMSSPrivateKeyParameters extends XMSSKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile C6108BDS bdsState;

    /* renamed from: params */
    private final XMSSParameters f23655params;
    private final byte[] publicSeed;

    /* renamed from: root */
    private final byte[] f23656root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters$Builder */
    public static class C6126Builder {

        /* renamed from: params */
        private final XMSSParameters f23658params;

        /* renamed from: index */
        private int f23657index = 0;
        private int maxIndex = -1;
        private byte[] secretKeySeed = null;
        private byte[] secretKeyPRF = null;
        private byte[] publicSeed = null;

        /* renamed from: root */
        private byte[] f23659root = null;
        private C6108BDS bdsState = null;
        private byte[] privateKey = null;

        public C6126Builder(XMSSParameters xMSSParameters) {
            this.f23658params = xMSSParameters;
        }

        /* renamed from: build */
        public XMSSPrivateKeyParameters m17927build() {
            if (this.privateKey == null && (this.publicSeed == null || this.secretKeySeed == null)) {
                throw new IllegalStateException("publicSeed or secretKeySeed is null");
            }
            return new XMSSPrivateKeyParameters(this);
        }

        public C6126Builder withBDSState(C6108BDS c6108bds) {
            this.bdsState = c6108bds;
            return this;
        }

        public C6126Builder withIndex(int i) {
            this.f23657index = i;
            return this;
        }

        public C6126Builder withMaxIndex(int i) {
            this.maxIndex = i;
            return this;
        }

        public C6126Builder withPrivateKey(byte[] bArr) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6126Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6126Builder withRoot(byte[] bArr) {
            this.f23659root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6126Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public C6126Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSPrivateKeyParameters(C6126Builder c6126Builder) {
        super(true, c6126Builder.f23658params.getTreeDigest());
        XMSSParameters xMSSParameters = c6126Builder.f23658params;
        this.f23655params = xMSSParameters;
        if (xMSSParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSParameters.getTreeDigestSize();
        byte[] bArr = c6126Builder.privateKey;
        if (bArr != null) {
            int height = xMSSParameters.getHeight();
            int iBigEndianToInt = AbstractC6245Pack.bigEndianToInt(bArr, 0);
            if (!XMSSUtil.isIndexValid(height, iBigEndianToInt)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.secretKeySeed = XMSSUtil.extractBytesAtOffset(bArr, 4, treeDigestSize);
            int i = 4 + treeDigestSize;
            this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(bArr, i, treeDigestSize);
            int i2 = i + treeDigestSize;
            this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, i2, treeDigestSize);
            int i3 = i2 + treeDigestSize;
            this.f23656root = XMSSUtil.extractBytesAtOffset(bArr, i3, treeDigestSize);
            int i4 = i3 + treeDigestSize;
            try {
                C6108BDS c6108bds = (C6108BDS) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(bArr, i4, bArr.length - i4), C6108BDS.class);
                if (c6108bds.getIndex() != iBigEndianToInt) {
                    throw new IllegalStateException("serialized BDS has wrong index");
                }
                this.bdsState = c6108bds.withWOTSDigest(c6126Builder.f23658params.getTreeDigestOID());
                return;
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }
        byte[] bArr2 = c6126Builder.secretKeySeed;
        if (bArr2 == null) {
            this.secretKeySeed = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.secretKeySeed = bArr2;
        }
        byte[] bArr3 = c6126Builder.secretKeyPRF;
        if (bArr3 == null) {
            this.secretKeyPRF = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.secretKeyPRF = bArr3;
        }
        byte[] bArr4 = c6126Builder.publicSeed;
        if (bArr4 == null) {
            this.publicSeed = new byte[treeDigestSize];
        } else {
            if (bArr4.length != treeDigestSize) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.publicSeed = bArr4;
        }
        byte[] bArr5 = c6126Builder.f23659root;
        if (bArr5 == null) {
            this.f23656root = new byte[treeDigestSize];
        } else {
            if (bArr5.length != treeDigestSize) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f23656root = bArr5;
        }
        C6108BDS c6108bds2 = c6126Builder.bdsState;
        this.bdsState = c6108bds2 == null ? new C6108BDS(xMSSParameters, bArr4, bArr2, (OTSHashAddress) new OTSHashAddress.C6114Builder().mo17893build(), c6126Builder.f23657index) : c6108bds2;
        if (c6126Builder.maxIndex >= 0 && c6126Builder.maxIndex != this.bdsState.getMaxIndex()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    public XMSSPrivateKeyParameters extractKeyShard(int i) {
        XMSSPrivateKeyParameters xMSSPrivateKeyParametersM17927build;
        if (i < 1) {
            throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
        }
        synchronized (this) {
            long j = i;
            try {
                if (j > getUsagesRemaining()) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
                xMSSPrivateKeyParametersM17927build = new C6126Builder(this.f23655params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.f23656root).withIndex(getIndex()).withBDSState(this.bdsState.withMaxIndex((this.bdsState.getIndex() + i) - 1, this.f23655params.getTreeDigestOID())).m17927build();
                if (j == getUsagesRemaining()) {
                    this.bdsState = new C6108BDS(this.f23655params, this.bdsState.getMaxIndex(), getIndex() + i);
                } else {
                    OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().mo17893build();
                    for (int i2 = 0; i2 != i; i2++) {
                        this.bdsState = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, oTSHashAddress);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xMSSPrivateKeyParametersM17927build;
    }

    public C6108BDS getBDSState() {
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

    public int getIndex() {
        return this.bdsState.getIndex();
    }

    public XMSSPrivateKeyParameters getNextKey() {
        XMSSPrivateKeyParameters xMSSPrivateKeyParametersExtractKeyShard;
        synchronized (this) {
            xMSSPrivateKeyParametersExtractKeyShard = extractKeyShard(1);
        }
        return xMSSPrivateKeyParametersExtractKeyShard;
    }

    public XMSSParameters getParameters() {
        return this.f23655params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    /* renamed from: getRoot */
    public byte[] m17925getRoot() {
        return XMSSUtil.cloneArray(this.f23656root);
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
    public XMSSPrivateKeyParameters m17926rollKey() {
        synchronized (this) {
            try {
                this.bdsState = this.bdsState.getIndex() < this.bdsState.getMaxIndex() ? this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, (OTSHashAddress) new OTSHashAddress.C6114Builder().mo17893build()) : new C6108BDS(this.f23655params, this.bdsState.getMaxIndex(), this.bdsState.getMaxIndex() + 1);
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
                int treeDigestSize = this.f23655params.getTreeDigestSize();
                byte[] bArr = new byte[treeDigestSize + 4 + treeDigestSize + treeDigestSize + treeDigestSize];
                AbstractC6245Pack.intToBigEndian(this.bdsState.getIndex(), bArr, 0);
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, 4);
                int i = 4 + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i);
                int i2 = i + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2);
                XMSSUtil.copyBytesAtOffset(bArr, this.f23656root, i2 + treeDigestSize);
                try {
                    bArrConcatenate = C6238Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
                } catch (IOException e) {
                    throw new RuntimeException("error serializing bds state: " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrConcatenate;
    }
}
