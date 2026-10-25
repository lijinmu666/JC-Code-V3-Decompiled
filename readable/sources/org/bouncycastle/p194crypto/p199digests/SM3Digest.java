package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: T */
    private static final int[] f19561T = new int[64];

    /* renamed from: V */
    private int[] f19562V;

    /* renamed from: W */
    private int[] f19563W;

    /* renamed from: inwords */
    private int[] f19564inwords;

    /* renamed from: xOff */
    private int f19565xOff;

    static {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            f19561T[i2] = (2043430169 >>> (32 - i2)) | (2043430169 << i2);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i3 = i % 32;
            f19561T[i] = (2055708042 >>> (32 - i3)) | (2055708042 << i3);
        }
    }

    public SM3Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: FF0 */
    private int m15173FF0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: FF1 */
    private int m15174FF1(int i, int i2, int i3) {
        return ((i2 | i3) & i) | (i2 & i3);
    }

    /* renamed from: GG0 */
    private int m15175GG0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: GG1 */
    private int m15176GG1(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: P0 */
    private int m15177P0(int i) {
        return (((i << 9) | (i >>> 23)) ^ i) ^ ((i << 17) | (i >>> 15));
    }

    /* renamed from: P1 */
    private int m15178P1(int i) {
        return (((i << 15) | (i >>> 17)) ^ i) ^ ((i << 23) | (i >>> 9));
    }

    /* renamed from: copyIn */
    private void m15179copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.f19562V;
        int[] iArr2 = this.f19562V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.f19564inwords;
        int[] iArr4 = this.f19564inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.f19565xOff = sM3Digest.f19565xOff;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SM3Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 256, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToBigEndian(this.f19562V, bArr, i);
        mo14968reset();
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            this.f19563W[i2] = this.f19564inwords[i2];
            i2++;
        }
        for (int i3 = 16; i3 < 68; i3++) {
            int[] iArr = this.f19563W;
            int i4 = iArr[i3 - 3];
            int i5 = iArr[i3 - 13];
            iArr[i3] = (m15178P1(((i4 >>> 17) | (i4 << 15)) ^ (iArr[i3 - 16] ^ iArr[i3 - 9])) ^ ((i5 >>> 25) | (i5 << 7))) ^ this.f19563W[i3 - 6];
        }
        int[] iArr2 = this.f19562V;
        int i6 = iArr2[0];
        int i7 = iArr2[1];
        int i8 = iArr2[2];
        int i9 = iArr2[3];
        int iM15177P0 = iArr2[4];
        int i10 = iArr2[5];
        int i11 = iArr2[6];
        int i12 = iArr2[7];
        int i13 = 0;
        int i14 = i11;
        for (i = 16; i13 < i; i = 16) {
            int i15 = (i6 << 12) | (i6 >>> 20);
            int i16 = i15 + iM15177P0 + f19561T[i13];
            int i17 = (i16 << 7) | (i16 >>> 25);
            int[] iArr3 = this.f19563W;
            int i18 = iArr3[i13];
            int i19 = i18 ^ iArr3[i13 + 4];
            int iM15173FF0 = m15173FF0(i6, i7, i8) + i9;
            int iM15175GG0 = m15175GG0(iM15177P0, i10, i14) + i12 + i17 + i18;
            int i20 = (i7 << 9) | (i7 >>> 23);
            int i21 = (i10 << 19) | (i10 >>> 13);
            i13++;
            i10 = iM15177P0;
            iM15177P0 = m15177P0(iM15175GG0);
            i9 = i8;
            i8 = i20;
            i12 = i14;
            i14 = i21;
            i7 = i6;
            i6 = iM15173FF0 + (i17 ^ i15) + i19;
        }
        int i22 = i12;
        int iM15177P02 = iM15177P0;
        int i23 = i14;
        int i24 = i9;
        int i25 = i8;
        int i26 = i7;
        int i27 = i6;
        int i28 = 16;
        while (i28 < 64) {
            int i29 = (i27 << 12) | (i27 >>> 20);
            int i30 = i29 + iM15177P02 + f19561T[i28];
            int i31 = (i30 << 7) | (i30 >>> 25);
            int[] iArr4 = this.f19563W;
            int i32 = iArr4[i28];
            int i33 = i32 ^ iArr4[i28 + 4];
            int iM15174FF1 = m15174FF1(i27, i26, i25) + i24;
            int iM15176GG1 = m15176GG1(iM15177P02, i10, i23) + i22 + i31 + i32;
            int i34 = (i10 << 19) | (i10 >>> 13);
            i28++;
            i10 = iM15177P02;
            iM15177P02 = m15177P0(iM15176GG1);
            i24 = i25;
            i25 = (i26 >>> 23) | (i26 << 9);
            i26 = i27;
            i27 = iM15174FF1 + (i31 ^ i29) + i33;
            i22 = i23;
            i23 = i34;
        }
        int[] iArr5 = this.f19562V;
        iArr5[0] = i27 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i26;
        iArr5[2] = iArr5[2] ^ i25;
        iArr5[3] = iArr5[3] ^ i24;
        iArr5[4] = iArr5[4] ^ iM15177P02;
        iArr5[5] = iArr5[5] ^ i10;
        iArr5[6] = i23 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i22;
        this.f19565xOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        int i = this.f19565xOff;
        if (i > 14) {
            this.f19564inwords[i] = 0;
            this.f19565xOff = i + 1;
            processBlock();
        }
        while (true) {
            int i2 = this.f19565xOff;
            if (i2 >= 14) {
                int[] iArr = this.f19564inwords;
                int i3 = i2 + 1;
                this.f19565xOff = i3;
                iArr[i2] = (int) (j >>> 32);
                this.f19565xOff = i2 + 2;
                iArr[i3] = (int) j;
                return;
            }
            this.f19564inwords[i2] = 0;
            this.f19565xOff = i2 + 1;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f19564inwords;
        int i2 = this.f19565xOff;
        this.f19565xOff = i2 + 1;
        iArr[i2] = AbstractC6245Pack.bigEndianToInt(bArr, i);
        if (this.f19565xOff >= 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        int[] iArr = this.f19562V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.f19565xOff = 0;
    }

    public SM3Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19562V = new int[8];
        this.f19564inwords = new int[16];
        this.f19563W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.m15075copyIn((GeneralDigest) sM3Digest);
        m15179copyIn(sM3Digest);
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        this.f19562V = new int[8];
        this.f19564inwords = new int[16];
        this.f19563W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        m15179copyIn(sM3Digest);
    }
}
