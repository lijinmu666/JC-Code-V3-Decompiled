package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: Y1 */
    private static final int f19520Y1 = 1518500249;

    /* renamed from: Y2 */
    private static final int f19521Y2 = 1859775393;

    /* renamed from: Y3 */
    private static final int f19522Y3 = -1894007588;

    /* renamed from: Y4 */
    private static final int f19523Y4 = -899497514;

    /* renamed from: H1 */
    private int f19524H1;

    /* renamed from: H2 */
    private int f19525H2;

    /* renamed from: H3 */
    private int f19526H3;

    /* renamed from: H4 */
    private int f19527H4;

    /* renamed from: H5 */
    private int f19528H5;

    /* renamed from: X */
    private int[] f19529X;

    /* renamed from: xOff */
    private int f19530xOff;

    public SHA1Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: copyIn */
    private void m15154copyIn(SHA1Digest sHA1Digest) {
        this.f19524H1 = sHA1Digest.f19524H1;
        this.f19525H2 = sHA1Digest.f19525H2;
        this.f19526H3 = sHA1Digest.f19526H3;
        this.f19527H4 = sHA1Digest.f19527H4;
        this.f19528H5 = sHA1Digest.f19528H5;
        int[] iArr = sHA1Digest.f19529X;
        System.arraycopy(iArr, 0, this.f19529X, 0, iArr.length);
        this.f19530xOff = sHA1Digest.f19530xOff;
    }

    /* renamed from: f */
    private int m15155f(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: g */
    private int m15156g(int i, int i2, int i3) {
        return ((i2 | i3) & i) | (i2 & i3);
    }

    /* renamed from: h */
    private int m15157h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA1Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 128, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToBigEndian(this.f19524H1, bArr, i);
        AbstractC6245Pack.intToBigEndian(this.f19525H2, bArr, i + 4);
        AbstractC6245Pack.intToBigEndian(this.f19526H3, bArr, i + 8);
        AbstractC6245Pack.intToBigEndian(this.f19527H4, bArr, i + 12);
        AbstractC6245Pack.intToBigEndian(this.f19528H5, bArr, i + 16);
        mo14968reset();
        return 20;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int i = this.f19530xOff * 4;
        byte[] bArr = new byte[i + 41];
        super.populateState(bArr);
        AbstractC6245Pack.intToBigEndian(this.f19524H1, bArr, 16);
        AbstractC6245Pack.intToBigEndian(this.f19525H2, bArr, 20);
        AbstractC6245Pack.intToBigEndian(this.f19526H3, bArr, 24);
        AbstractC6245Pack.intToBigEndian(this.f19527H4, bArr, 28);
        AbstractC6245Pack.intToBigEndian(this.f19528H5, bArr, 32);
        AbstractC6245Pack.intToBigEndian(this.f19530xOff, bArr, 36);
        for (int i2 = 0; i2 != this.f19530xOff; i2++) {
            AbstractC6245Pack.intToBigEndian(this.f19529X[i2], bArr, (i2 * 4) + 40);
        }
        bArr[i + 40] = (byte) this.f19390purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.f19529X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int iM15157h = this.f19524H1;
        int iM15157h2 = this.f19525H2;
        int i3 = this.f19526H3;
        int i4 = this.f19527H4;
        int i5 = this.f19528H5;
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            int iM15155f = i5 + ((iM15157h << 5) | (iM15157h >>> 27)) + m15155f(iM15157h2, i3, i4) + this.f19529X[i6] + f19520Y1;
            int i8 = (iM15157h2 >>> 2) | (iM15157h2 << 30);
            int iM15155f2 = i4 + ((iM15155f << 5) | (iM15155f >>> 27)) + m15155f(iM15157h, i8, i3) + this.f19529X[i6 + 1] + f19520Y1;
            int i9 = (iM15157h >>> 2) | (iM15157h << 30);
            int iM15155f3 = i3 + ((iM15155f2 << 5) | (iM15155f2 >>> 27)) + m15155f(iM15155f, i9, i8) + this.f19529X[i6 + 2] + f19520Y1;
            i5 = (iM15155f >>> 2) | (iM15155f << 30);
            int i10 = i6 + 4;
            iM15157h2 = i8 + ((iM15155f3 << 5) | (iM15155f3 >>> 27)) + m15155f(iM15155f2, i5, i9) + this.f19529X[i6 + 3] + f19520Y1;
            i4 = (iM15155f2 >>> 2) | (iM15155f2 << 30);
            i6 += 5;
            iM15157h = i9 + ((iM15157h2 << 5) | (iM15157h2 >>> 27)) + m15155f(iM15155f3, i4, i5) + this.f19529X[i10] + f19520Y1;
            i3 = (iM15155f3 >>> 2) | (iM15155f3 << 30);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            int iM15157h3 = i5 + ((iM15157h << 5) | (iM15157h >>> 27)) + m15157h(iM15157h2, i3, i4) + this.f19529X[i6] + f19521Y2;
            int i12 = (iM15157h2 >>> 2) | (iM15157h2 << 30);
            int iM15157h4 = i4 + ((iM15157h3 << 5) | (iM15157h3 >>> 27)) + m15157h(iM15157h, i12, i3) + this.f19529X[i6 + 1] + f19521Y2;
            int i13 = (iM15157h >>> 2) | (iM15157h << 30);
            int iM15157h5 = i3 + ((iM15157h4 << 5) | (iM15157h4 >>> 27)) + m15157h(iM15157h3, i13, i12) + this.f19529X[i6 + 2] + f19521Y2;
            i5 = (iM15157h3 >>> 2) | (iM15157h3 << 30);
            int i14 = i6 + 4;
            iM15157h2 = i12 + ((iM15157h5 << 5) | (iM15157h5 >>> 27)) + m15157h(iM15157h4, i5, i13) + this.f19529X[i6 + 3] + f19521Y2;
            i4 = (iM15157h4 >>> 2) | (iM15157h4 << 30);
            i6 += 5;
            iM15157h = i13 + ((iM15157h2 << 5) | (iM15157h2 >>> 27)) + m15157h(iM15157h5, i4, i5) + this.f19529X[i14] + f19521Y2;
            i3 = (iM15157h5 >>> 2) | (iM15157h5 << 30);
        }
        for (int i15 = 0; i15 < 4; i15++) {
            int iM15156g = i5 + ((iM15157h << 5) | (iM15157h >>> 27)) + m15156g(iM15157h2, i3, i4) + this.f19529X[i6] + f19522Y3;
            int i16 = (iM15157h2 >>> 2) | (iM15157h2 << 30);
            int iM15156g2 = i4 + ((iM15156g << 5) | (iM15156g >>> 27)) + m15156g(iM15157h, i16, i3) + this.f19529X[i6 + 1] + f19522Y3;
            int i17 = (iM15157h >>> 2) | (iM15157h << 30);
            int iM15156g3 = i3 + ((iM15156g2 << 5) | (iM15156g2 >>> 27)) + m15156g(iM15156g, i17, i16) + this.f19529X[i6 + 2] + f19522Y3;
            i5 = (iM15156g >>> 2) | (iM15156g << 30);
            int i18 = i6 + 4;
            iM15157h2 = i16 + ((iM15156g3 << 5) | (iM15156g3 >>> 27)) + m15156g(iM15156g2, i5, i17) + this.f19529X[i6 + 3] + f19522Y3;
            i4 = (iM15156g2 >>> 2) | (iM15156g2 << 30);
            i6 += 5;
            iM15157h = i17 + ((iM15157h2 << 5) | (iM15157h2 >>> 27)) + m15156g(iM15156g3, i4, i5) + this.f19529X[i18] + f19522Y3;
            i3 = (iM15156g3 >>> 2) | (iM15156g3 << 30);
        }
        for (int i19 = 0; i19 <= 3; i19++) {
            int iM15157h6 = i5 + ((iM15157h << 5) | (iM15157h >>> 27)) + m15157h(iM15157h2, i3, i4) + this.f19529X[i6] + f19523Y4;
            int i20 = (iM15157h2 >>> 2) | (iM15157h2 << 30);
            int iM15157h7 = i4 + ((iM15157h6 << 5) | (iM15157h6 >>> 27)) + m15157h(iM15157h, i20, i3) + this.f19529X[i6 + 1] + f19523Y4;
            int i21 = (iM15157h >>> 2) | (iM15157h << 30);
            int iM15157h8 = i3 + ((iM15157h7 << 5) | (iM15157h7 >>> 27)) + m15157h(iM15157h6, i21, i20) + this.f19529X[i6 + 2] + f19523Y4;
            i5 = (iM15157h6 >>> 2) | (iM15157h6 << 30);
            int i22 = i6 + 4;
            iM15157h2 = i20 + ((iM15157h8 << 5) | (iM15157h8 >>> 27)) + m15157h(iM15157h7, i5, i21) + this.f19529X[i6 + 3] + f19523Y4;
            i4 = (iM15157h7 >>> 2) | (iM15157h7 << 30);
            i6 += 5;
            iM15157h = i21 + ((iM15157h2 << 5) | (iM15157h2 >>> 27)) + m15157h(iM15157h8, i4, i5) + this.f19529X[i22] + f19523Y4;
            i3 = (iM15157h8 >>> 2) | (iM15157h8 << 30);
        }
        this.f19524H1 += iM15157h;
        this.f19525H2 += iM15157h2;
        this.f19526H3 += i3;
        this.f19527H4 += i4;
        this.f19528H5 += i5;
        this.f19530xOff = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            this.f19529X[i23] = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19530xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19529X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        this.f19529X[this.f19530xOff] = AbstractC6245Pack.bigEndianToInt(bArr, i);
        int i2 = this.f19530xOff + 1;
        this.f19530xOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19524H1 = 1732584193;
        this.f19525H2 = -271733879;
        this.f19526H3 = -1732584194;
        this.f19527H4 = 271733878;
        this.f19528H5 = -1009589776;
        this.f19530xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19529X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public SHA1Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19529X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.m15075copyIn((GeneralDigest) sHA1Digest);
        m15154copyIn(sHA1Digest);
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.f19529X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        m15154copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.f19529X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        this.f19524H1 = AbstractC6245Pack.bigEndianToInt(bArr, 16);
        this.f19525H2 = AbstractC6245Pack.bigEndianToInt(bArr, 20);
        this.f19526H3 = AbstractC6245Pack.bigEndianToInt(bArr, 24);
        this.f19527H4 = AbstractC6245Pack.bigEndianToInt(bArr, 28);
        this.f19528H5 = AbstractC6245Pack.bigEndianToInt(bArr, 32);
        this.f19530xOff = AbstractC6245Pack.bigEndianToInt(bArr, 36);
        for (int i = 0; i != this.f19530xOff; i++) {
            this.f19529X[i] = AbstractC6245Pack.bigEndianToInt(bArr, (i * 4) + 40);
        }
    }
}
