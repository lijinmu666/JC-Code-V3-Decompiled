package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 28;

    /* renamed from: K */
    static final int[] f19531K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f19532H1;

    /* renamed from: H2 */
    private int f19533H2;

    /* renamed from: H3 */
    private int f19534H3;

    /* renamed from: H4 */
    private int f19535H4;

    /* renamed from: H5 */
    private int f19536H5;

    /* renamed from: H6 */
    private int f19537H6;

    /* renamed from: H7 */
    private int f19538H7;

    /* renamed from: H8 */
    private int f19539H8;

    /* renamed from: X */
    private int[] f19540X;

    /* renamed from: xOff */
    private int f19541xOff;

    public SHA224Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: Ch */
    private int m15158Ch(int i, int i2, int i3) {
        return (i & i2) ^ ((~i) & i3);
    }

    /* renamed from: Maj */
    private int m15159Maj(int i, int i2, int i3) {
        return ((i & i2) ^ (i & i3)) ^ (i2 & i3);
    }

    /* renamed from: Sum0 */
    private int m15160Sum0(int i) {
        return (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19))) ^ ((i << 10) | (i >>> 22));
    }

    /* renamed from: Sum1 */
    private int m15161Sum1(int i) {
        return (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21))) ^ ((i << 7) | (i >>> 25));
    }

    /* renamed from: Theta0 */
    private int m15162Theta0(int i) {
        return (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14))) ^ (i >>> 3);
    }

    /* renamed from: Theta1 */
    private int m15163Theta1(int i) {
        return (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13))) ^ (i >>> 10);
    }

    /* renamed from: doCopy */
    private void m15164doCopy(SHA224Digest sHA224Digest) {
        super.m15075copyIn(sHA224Digest);
        this.f19532H1 = sHA224Digest.f19532H1;
        this.f19533H2 = sHA224Digest.f19533H2;
        this.f19534H3 = sHA224Digest.f19534H3;
        this.f19535H4 = sHA224Digest.f19535H4;
        this.f19536H5 = sHA224Digest.f19536H5;
        this.f19537H6 = sHA224Digest.f19537H6;
        this.f19538H7 = sHA224Digest.f19538H7;
        this.f19539H8 = sHA224Digest.f19539H8;
        int[] iArr = sHA224Digest.f19540X;
        System.arraycopy(iArr, 0, this.f19540X, 0, iArr.length);
        this.f19541xOff = sHA224Digest.f19541xOff;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA224Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 192, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToBigEndian(this.f19532H1, bArr, i);
        AbstractC6245Pack.intToBigEndian(this.f19533H2, bArr, i + 4);
        AbstractC6245Pack.intToBigEndian(this.f19534H3, bArr, i + 8);
        AbstractC6245Pack.intToBigEndian(this.f19535H4, bArr, i + 12);
        AbstractC6245Pack.intToBigEndian(this.f19536H5, bArr, i + 16);
        AbstractC6245Pack.intToBigEndian(this.f19537H6, bArr, i + 20);
        AbstractC6245Pack.intToBigEndian(this.f19538H7, bArr, i + 24);
        mo14968reset();
        return 28;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SHA-224";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 28;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int i = this.f19541xOff * 4;
        byte[] bArr = new byte[i + 53];
        super.populateState(bArr);
        AbstractC6245Pack.intToBigEndian(this.f19532H1, bArr, 16);
        AbstractC6245Pack.intToBigEndian(this.f19533H2, bArr, 20);
        AbstractC6245Pack.intToBigEndian(this.f19534H3, bArr, 24);
        AbstractC6245Pack.intToBigEndian(this.f19535H4, bArr, 28);
        AbstractC6245Pack.intToBigEndian(this.f19536H5, bArr, 32);
        AbstractC6245Pack.intToBigEndian(this.f19537H6, bArr, 36);
        AbstractC6245Pack.intToBigEndian(this.f19538H7, bArr, 40);
        AbstractC6245Pack.intToBigEndian(this.f19539H8, bArr, 44);
        AbstractC6245Pack.intToBigEndian(this.f19541xOff, bArr, 48);
        for (int i2 = 0; i2 != this.f19541xOff; i2++) {
            AbstractC6245Pack.intToBigEndian(this.f19540X[i2], bArr, (i2 * 4) + 52);
        }
        bArr[i + 52] = (byte) this.f19390purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f19540X;
            int iM15163Theta1 = m15163Theta1(iArr[i - 2]);
            int[] iArr2 = this.f19540X;
            iArr[i] = iM15163Theta1 + iArr2[i - 7] + m15162Theta0(iArr2[i - 15]) + this.f19540X[i - 16];
        }
        int iM15160Sum0 = this.f19532H1;
        int iM15160Sum02 = this.f19533H2;
        int iM15160Sum03 = this.f19534H3;
        int iM15160Sum04 = this.f19535H4;
        int i2 = this.f19536H5;
        int i3 = this.f19537H6;
        int i4 = this.f19538H7;
        int i5 = this.f19539H8;
        int i6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            int iM15161Sum1 = m15161Sum1(i2) + m15158Ch(i2, i3, i4);
            int[] iArr3 = f19531K;
            int i8 = i5 + iM15161Sum1 + iArr3[i6] + this.f19540X[i6];
            int i9 = iM15160Sum04 + i8;
            int iM15160Sum05 = i8 + m15160Sum0(iM15160Sum0) + m15159Maj(iM15160Sum0, iM15160Sum02, iM15160Sum03);
            int i10 = i6 + 1;
            int iM15161Sum12 = i4 + m15161Sum1(i9) + m15158Ch(i9, i2, i3) + iArr3[i10] + this.f19540X[i10];
            int i11 = iM15160Sum03 + iM15161Sum12;
            int iM15160Sum06 = iM15161Sum12 + m15160Sum0(iM15160Sum05) + m15159Maj(iM15160Sum05, iM15160Sum0, iM15160Sum02);
            int i12 = i6 + 2;
            int iM15161Sum13 = i3 + m15161Sum1(i11) + m15158Ch(i11, i9, i2) + iArr3[i12] + this.f19540X[i12];
            int i13 = iM15160Sum02 + iM15161Sum13;
            int iM15160Sum07 = iM15161Sum13 + m15160Sum0(iM15160Sum06) + m15159Maj(iM15160Sum06, iM15160Sum05, iM15160Sum0);
            int i14 = i6 + 3;
            int iM15161Sum14 = i2 + m15161Sum1(i13) + m15158Ch(i13, i11, i9) + iArr3[i14] + this.f19540X[i14];
            int i15 = iM15160Sum0 + iM15161Sum14;
            int iM15160Sum08 = iM15161Sum14 + m15160Sum0(iM15160Sum07) + m15159Maj(iM15160Sum07, iM15160Sum06, iM15160Sum05);
            int i16 = i6 + 4;
            int iM15161Sum15 = i9 + m15161Sum1(i15) + m15158Ch(i15, i13, i11) + iArr3[i16] + this.f19540X[i16];
            i5 = iM15160Sum05 + iM15161Sum15;
            iM15160Sum04 = iM15161Sum15 + m15160Sum0(iM15160Sum08) + m15159Maj(iM15160Sum08, iM15160Sum07, iM15160Sum06);
            int i17 = i6 + 5;
            int iM15161Sum16 = i11 + m15161Sum1(i5) + m15158Ch(i5, i15, i13) + iArr3[i17] + this.f19540X[i17];
            i4 = iM15160Sum06 + iM15161Sum16;
            iM15160Sum03 = iM15161Sum16 + m15160Sum0(iM15160Sum04) + m15159Maj(iM15160Sum04, iM15160Sum08, iM15160Sum07);
            int i18 = i6 + 6;
            int iM15161Sum17 = i13 + m15161Sum1(i4) + m15158Ch(i4, i5, i15) + iArr3[i18] + this.f19540X[i18];
            i3 = iM15160Sum07 + iM15161Sum17;
            iM15160Sum02 = iM15161Sum17 + m15160Sum0(iM15160Sum03) + m15159Maj(iM15160Sum03, iM15160Sum04, iM15160Sum08);
            int i19 = i6 + 7;
            int iM15161Sum18 = i15 + m15161Sum1(i3) + m15158Ch(i3, i4, i5) + iArr3[i19] + this.f19540X[i19];
            i2 = iM15160Sum08 + iM15161Sum18;
            iM15160Sum0 = iM15161Sum18 + m15160Sum0(iM15160Sum02) + m15159Maj(iM15160Sum02, iM15160Sum03, iM15160Sum04);
            i6 += 8;
        }
        this.f19532H1 += iM15160Sum0;
        this.f19533H2 += iM15160Sum02;
        this.f19534H3 += iM15160Sum03;
        this.f19535H4 += iM15160Sum04;
        this.f19536H5 += i2;
        this.f19537H6 += i3;
        this.f19538H7 += i4;
        this.f19539H8 += i5;
        this.f19541xOff = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.f19540X[i20] = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19541xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19540X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        this.f19540X[this.f19541xOff] = AbstractC6245Pack.bigEndianToInt(bArr, i);
        int i2 = this.f19541xOff + 1;
        this.f19541xOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19532H1 = -1056596264;
        this.f19533H2 = 914150663;
        this.f19534H3 = 812702999;
        this.f19535H4 = -150054599;
        this.f19536H5 = -4191439;
        this.f19537H6 = 1750603025;
        this.f19538H7 = 1694076839;
        this.f19539H8 = -1090891868;
        this.f19541xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19540X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public SHA224Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19540X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15164doCopy((SHA224Digest) memoable);
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super(sHA224Digest);
        this.f19540X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        m15164doCopy(sHA224Digest);
    }

    public SHA224Digest(byte[] bArr) {
        super(bArr);
        this.f19540X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        this.f19532H1 = AbstractC6245Pack.bigEndianToInt(bArr, 16);
        this.f19533H2 = AbstractC6245Pack.bigEndianToInt(bArr, 20);
        this.f19534H3 = AbstractC6245Pack.bigEndianToInt(bArr, 24);
        this.f19535H4 = AbstractC6245Pack.bigEndianToInt(bArr, 28);
        this.f19536H5 = AbstractC6245Pack.bigEndianToInt(bArr, 32);
        this.f19537H6 = AbstractC6245Pack.bigEndianToInt(bArr, 36);
        this.f19538H7 = AbstractC6245Pack.bigEndianToInt(bArr, 40);
        this.f19539H8 = AbstractC6245Pack.bigEndianToInt(bArr, 44);
        this.f19541xOff = AbstractC6245Pack.bigEndianToInt(bArr, 48);
        for (int i = 0; i != this.f19541xOff; i++) {
            this.f19540X[i] = AbstractC6245Pack.bigEndianToInt(bArr, (i * 4) + 52);
        }
    }
}
