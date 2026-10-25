package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.SavableDigest;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHA256Digest extends GeneralDigest implements SavableDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: K */
    static final int[] f19542K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f19543H1;

    /* renamed from: H2 */
    private int f19544H2;

    /* renamed from: H3 */
    private int f19545H3;

    /* renamed from: H4 */
    private int f19546H4;

    /* renamed from: H5 */
    private int f19547H5;

    /* renamed from: H6 */
    private int f19548H6;

    /* renamed from: H7 */
    private int f19549H7;

    /* renamed from: H8 */
    private int f19550H8;

    /* renamed from: X */
    private int[] f19551X;

    /* renamed from: xOff */
    private int f19552xOff;

    public SHA256Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: Ch */
    private static int m15165Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    /* renamed from: Maj */
    private static int m15166Maj(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    /* renamed from: Sum0 */
    private static int m15167Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    /* renamed from: Sum1 */
    private static int m15168Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    /* renamed from: Theta0 */
    private static int m15169Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    /* renamed from: Theta1 */
    private static int m15170Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    /* renamed from: copyIn */
    private void m15171copyIn(SHA256Digest sHA256Digest) {
        super.m15075copyIn((GeneralDigest) sHA256Digest);
        this.f19543H1 = sHA256Digest.f19543H1;
        this.f19544H2 = sHA256Digest.f19544H2;
        this.f19545H3 = sHA256Digest.f19545H3;
        this.f19546H4 = sHA256Digest.f19546H4;
        this.f19547H5 = sHA256Digest.f19547H5;
        this.f19548H6 = sHA256Digest.f19548H6;
        this.f19549H7 = sHA256Digest.f19549H7;
        this.f19550H8 = sHA256Digest.f19550H8;
        int[] iArr = sHA256Digest.f19551X;
        System.arraycopy(iArr, 0, this.f19551X, 0, iArr.length);
        this.f19552xOff = sHA256Digest.f19552xOff;
    }

    public static SavableDigest newInstance() {
        return new SHA256Digest();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA256Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 256, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToBigEndian(this.f19543H1, bArr, i);
        AbstractC6245Pack.intToBigEndian(this.f19544H2, bArr, i + 4);
        AbstractC6245Pack.intToBigEndian(this.f19545H3, bArr, i + 8);
        AbstractC6245Pack.intToBigEndian(this.f19546H4, bArr, i + 12);
        AbstractC6245Pack.intToBigEndian(this.f19547H5, bArr, i + 16);
        AbstractC6245Pack.intToBigEndian(this.f19548H6, bArr, i + 20);
        AbstractC6245Pack.intToBigEndian(this.f19549H7, bArr, i + 24);
        AbstractC6245Pack.intToBigEndian(this.f19550H8, bArr, i + 28);
        mo14968reset();
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return XMSSKeyParameters.f23621SHA_256;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int i = this.f19552xOff * 4;
        byte[] bArr = new byte[i + 53];
        super.populateState(bArr);
        AbstractC6245Pack.intToBigEndian(this.f19543H1, bArr, 16);
        AbstractC6245Pack.intToBigEndian(this.f19544H2, bArr, 20);
        AbstractC6245Pack.intToBigEndian(this.f19545H3, bArr, 24);
        AbstractC6245Pack.intToBigEndian(this.f19546H4, bArr, 28);
        AbstractC6245Pack.intToBigEndian(this.f19547H5, bArr, 32);
        AbstractC6245Pack.intToBigEndian(this.f19548H6, bArr, 36);
        AbstractC6245Pack.intToBigEndian(this.f19549H7, bArr, 40);
        AbstractC6245Pack.intToBigEndian(this.f19550H8, bArr, 44);
        AbstractC6245Pack.intToBigEndian(this.f19552xOff, bArr, 48);
        for (int i2 = 0; i2 != this.f19552xOff; i2++) {
            AbstractC6245Pack.intToBigEndian(this.f19551X[i2], bArr, (i2 * 4) + 52);
        }
        bArr[i + 52] = (byte) this.f19390purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f19551X;
            int iM15170Theta1 = m15170Theta1(iArr[i - 2]);
            int[] iArr2 = this.f19551X;
            iArr[i] = iM15170Theta1 + iArr2[i - 7] + m15169Theta0(iArr2[i - 15]) + this.f19551X[i - 16];
        }
        int iM15167Sum0 = this.f19543H1;
        int iM15167Sum02 = this.f19544H2;
        int iM15167Sum03 = this.f19545H3;
        int iM15167Sum04 = this.f19546H4;
        int i2 = this.f19547H5;
        int i3 = this.f19548H6;
        int i4 = this.f19549H7;
        int i5 = this.f19550H8;
        int i6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            int iM15168Sum1 = m15168Sum1(i2) + m15165Ch(i2, i3, i4);
            int[] iArr3 = f19542K;
            int i8 = i5 + iM15168Sum1 + iArr3[i6] + this.f19551X[i6];
            int i9 = iM15167Sum04 + i8;
            int iM15167Sum05 = i8 + m15167Sum0(iM15167Sum0) + m15166Maj(iM15167Sum0, iM15167Sum02, iM15167Sum03);
            int i10 = i6 + 1;
            int iM15168Sum12 = i4 + m15168Sum1(i9) + m15165Ch(i9, i2, i3) + iArr3[i10] + this.f19551X[i10];
            int i11 = iM15167Sum03 + iM15168Sum12;
            int iM15167Sum06 = iM15168Sum12 + m15167Sum0(iM15167Sum05) + m15166Maj(iM15167Sum05, iM15167Sum0, iM15167Sum02);
            int i12 = i6 + 2;
            int iM15168Sum13 = i3 + m15168Sum1(i11) + m15165Ch(i11, i9, i2) + iArr3[i12] + this.f19551X[i12];
            int i13 = iM15167Sum02 + iM15168Sum13;
            int iM15167Sum07 = iM15168Sum13 + m15167Sum0(iM15167Sum06) + m15166Maj(iM15167Sum06, iM15167Sum05, iM15167Sum0);
            int i14 = i6 + 3;
            int iM15168Sum14 = i2 + m15168Sum1(i13) + m15165Ch(i13, i11, i9) + iArr3[i14] + this.f19551X[i14];
            int i15 = iM15167Sum0 + iM15168Sum14;
            int iM15167Sum08 = iM15168Sum14 + m15167Sum0(iM15167Sum07) + m15166Maj(iM15167Sum07, iM15167Sum06, iM15167Sum05);
            int i16 = i6 + 4;
            int iM15168Sum15 = i9 + m15168Sum1(i15) + m15165Ch(i15, i13, i11) + iArr3[i16] + this.f19551X[i16];
            i5 = iM15167Sum05 + iM15168Sum15;
            iM15167Sum04 = iM15168Sum15 + m15167Sum0(iM15167Sum08) + m15166Maj(iM15167Sum08, iM15167Sum07, iM15167Sum06);
            int i17 = i6 + 5;
            int iM15168Sum16 = i11 + m15168Sum1(i5) + m15165Ch(i5, i15, i13) + iArr3[i17] + this.f19551X[i17];
            i4 = iM15167Sum06 + iM15168Sum16;
            iM15167Sum03 = iM15168Sum16 + m15167Sum0(iM15167Sum04) + m15166Maj(iM15167Sum04, iM15167Sum08, iM15167Sum07);
            int i18 = i6 + 6;
            int iM15168Sum17 = i13 + m15168Sum1(i4) + m15165Ch(i4, i5, i15) + iArr3[i18] + this.f19551X[i18];
            i3 = iM15167Sum07 + iM15168Sum17;
            iM15167Sum02 = iM15168Sum17 + m15167Sum0(iM15167Sum03) + m15166Maj(iM15167Sum03, iM15167Sum04, iM15167Sum08);
            int i19 = i6 + 7;
            int iM15168Sum18 = i15 + m15168Sum1(i3) + m15165Ch(i3, i4, i5) + iArr3[i19] + this.f19551X[i19];
            i2 = iM15167Sum08 + iM15168Sum18;
            iM15167Sum0 = iM15168Sum18 + m15167Sum0(iM15167Sum02) + m15166Maj(iM15167Sum02, iM15167Sum03, iM15167Sum04);
            i6 += 8;
        }
        this.f19543H1 += iM15167Sum0;
        this.f19544H2 += iM15167Sum02;
        this.f19545H3 += iM15167Sum03;
        this.f19546H4 += iM15167Sum04;
        this.f19547H5 += i2;
        this.f19548H6 += i3;
        this.f19549H7 += i4;
        this.f19550H8 += i5;
        this.f19552xOff = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.f19551X[i20] = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19552xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19551X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        this.f19551X[this.f19552xOff] = AbstractC6245Pack.bigEndianToInt(bArr, i);
        int i2 = this.f19552xOff + 1;
        this.f19552xOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19543H1 = 1779033703;
        this.f19544H2 = -1150833019;
        this.f19545H3 = 1013904242;
        this.f19546H4 = -1521486534;
        this.f19547H5 = 1359893119;
        this.f19548H6 = -1694144372;
        this.f19549H7 = 528734635;
        this.f19550H8 = 1541459225;
        this.f19552xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19551X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public SHA256Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19551X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14968reset();
    }

    public static SavableDigest newInstance(CryptoServicePurpose cryptoServicePurpose) {
        return new SHA256Digest(cryptoServicePurpose);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15171copyIn((SHA256Digest) memoable);
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.f19551X = new int[64];
        m15171copyIn(sHA256Digest);
    }

    public static SavableDigest newInstance(InterfaceC5277Digest interfaceC5277Digest) {
        if (interfaceC5277Digest instanceof SHA256Digest) {
            return new SHA256Digest((SHA256Digest) interfaceC5277Digest);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("receiver digest not available for input type ");
        sb.append(interfaceC5277Digest != null ? interfaceC5277Digest.getClass().getName() : "null");
        throw new IllegalArgumentException(sb.toString());
    }

    public SHA256Digest(byte[] bArr) {
        super(bArr);
        this.f19551X = new int[64];
        this.f19543H1 = AbstractC6245Pack.bigEndianToInt(bArr, 16);
        this.f19544H2 = AbstractC6245Pack.bigEndianToInt(bArr, 20);
        this.f19545H3 = AbstractC6245Pack.bigEndianToInt(bArr, 24);
        this.f19546H4 = AbstractC6245Pack.bigEndianToInt(bArr, 28);
        this.f19547H5 = AbstractC6245Pack.bigEndianToInt(bArr, 32);
        this.f19548H6 = AbstractC6245Pack.bigEndianToInt(bArr, 36);
        this.f19549H7 = AbstractC6245Pack.bigEndianToInt(bArr, 40);
        this.f19550H8 = AbstractC6245Pack.bigEndianToInt(bArr, 44);
        this.f19552xOff = AbstractC6245Pack.bigEndianToInt(bArr, 48);
        for (int i = 0; i != this.f19552xOff; i++) {
            this.f19551X[i] = AbstractC6245Pack.bigEndianToInt(bArr, (i * 4) + 52);
        }
    }

    public static SavableDigest newInstance(byte[] bArr) {
        return new SHA256Digest(bArr);
    }
}
