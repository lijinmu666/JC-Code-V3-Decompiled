package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Blake2xsDigest implements InterfaceC5284Xof {
    private static final int DIGEST_LENGTH = 32;
    private static final long MAX_NUMBER_BLOCKS = 4294967296L;
    public static final int UNKNOWN_DIGEST_LENGTH = 65535;
    private long blockPos;

    /* renamed from: buf */
    private byte[] f19312buf;

    /* renamed from: bufPos */
    private int f19313bufPos;
    private int digestLength;
    private int digestPos;

    /* renamed from: h0 */
    private byte[] f19314h0;

    /* renamed from: hash */
    private Blake2sDigest f19315hash;
    private long nodeOffset;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19316purpose;

    public Blake2xsDigest() {
        this(UNKNOWN_DIGEST_LENGTH, CryptoServicePurpose.ANY);
    }

    private long computeNodeOffset() {
        return this.digestLength * MAX_NUMBER_BLOCKS;
    }

    private int computeStepLength() {
        int i = this.digestLength;
        if (i == 65535) {
            return 32;
        }
        return Math.min(32, i - this.digestPos);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return mo14998doFinal(bArr, i, this.digestLength);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (i > bArr.length - i2) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f19314h0 == null) {
            byte[] bArr2 = new byte[this.f19315hash.getDigestSize()];
            this.f19314h0 = bArr2;
            this.f19315hash.mo14967doFinal(bArr2, 0);
        }
        int i3 = this.digestLength;
        if (i3 != 65535) {
            if (this.digestPos + i2 > i3) {
                throw new IllegalArgumentException("Output length is above the digest length");
            }
        } else if ((this.blockPos << 5) >= getUnknownMaxLength()) {
            throw new IllegalArgumentException("Maximum length is 2^32 blocks of 32 bytes");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.f19313bufPos >= 32) {
                Blake2sDigest blake2sDigest = new Blake2sDigest(computeStepLength(), 32, this.nodeOffset);
                byte[] bArr3 = this.f19314h0;
                blake2sDigest.mo14970update(bArr3, 0, bArr3.length);
                C6238Arrays.m18249fill(this.f19312buf, (byte) 0);
                blake2sDigest.mo14967doFinal(this.f19312buf, 0);
                this.f19313bufPos = 0;
                this.nodeOffset++;
                this.blockPos++;
            }
            byte[] bArr4 = this.f19312buf;
            int i5 = this.f19313bufPos;
            bArr[i + i4] = bArr4[i5];
            this.f19313bufPos = i5 + 1;
            this.digestPos++;
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "BLAKE2xs";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return this.f19315hash.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    public long getUnknownMaxLength() {
        return 137438953472L;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19315hash.mo14968reset();
        this.f19314h0 = null;
        this.f19313bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0L;
        this.nodeOffset = computeNodeOffset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        this.f19315hash.mo14969update(b);
    }

    public Blake2xsDigest(int i) {
        this(i, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        mo14968reset();
        return iDoOutput;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        this.f19315hash.mo14970update(bArr, i, i2);
    }

    public Blake2xsDigest(int i, CryptoServicePurpose cryptoServicePurpose) {
        this(i, null, null, null, cryptoServicePurpose);
    }

    public Blake2xsDigest(int i, byte[] bArr) {
        this(i, bArr, null, null, CryptoServicePurpose.ANY);
    }

    public Blake2xsDigest(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, CryptoServicePurpose cryptoServicePurpose) {
        this.f19314h0 = null;
        this.f19312buf = new byte[32];
        this.f19313bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0L;
        if (i < 1 || i > 65535) {
            throw new IllegalArgumentException("BLAKE2xs digest length must be between 1 and 2^16-1");
        }
        this.digestLength = i;
        this.nodeOffset = computeNodeOffset();
        this.f19316purpose = cryptoServicePurpose;
        this.f19315hash = new Blake2sDigest(32, bArr, bArr2, bArr3, this.nodeOffset, cryptoServicePurpose);
    }

    public Blake2xsDigest(Blake2xsDigest blake2xsDigest) {
        this.f19314h0 = null;
        this.f19312buf = new byte[32];
        this.f19313bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0L;
        this.digestLength = blake2xsDigest.digestLength;
        this.f19315hash = new Blake2sDigest(blake2xsDigest.f19315hash);
        this.f19314h0 = C6238Arrays.m18231clone(blake2xsDigest.f19314h0);
        this.f19312buf = C6238Arrays.m18231clone(blake2xsDigest.f19312buf);
        this.f19313bufPos = blake2xsDigest.f19313bufPos;
        this.digestPos = blake2xsDigest.digestPos;
        this.blockPos = blake2xsDigest.blockPos;
        this.nodeOffset = blake2xsDigest.nodeOffset;
        this.f19316purpose = blake2xsDigest.f19316purpose;
    }
}
