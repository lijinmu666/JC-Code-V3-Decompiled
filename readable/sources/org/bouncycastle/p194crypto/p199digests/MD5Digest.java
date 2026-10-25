package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class MD5Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: S11 */
    private static final int f19451S11 = 7;

    /* renamed from: S12 */
    private static final int f19452S12 = 12;

    /* renamed from: S13 */
    private static final int f19453S13 = 17;

    /* renamed from: S14 */
    private static final int f19454S14 = 22;

    /* renamed from: S21 */
    private static final int f19455S21 = 5;

    /* renamed from: S22 */
    private static final int f19456S22 = 9;

    /* renamed from: S23 */
    private static final int f19457S23 = 14;

    /* renamed from: S24 */
    private static final int f19458S24 = 20;

    /* renamed from: S31 */
    private static final int f19459S31 = 4;

    /* renamed from: S32 */
    private static final int f19460S32 = 11;

    /* renamed from: S33 */
    private static final int f19461S33 = 16;

    /* renamed from: S34 */
    private static final int f19462S34 = 23;

    /* renamed from: S41 */
    private static final int f19463S41 = 6;

    /* renamed from: S42 */
    private static final int f19464S42 = 10;

    /* renamed from: S43 */
    private static final int f19465S43 = 15;

    /* renamed from: S44 */
    private static final int f19466S44 = 21;

    /* renamed from: H1 */
    private int f19467H1;

    /* renamed from: H2 */
    private int f19468H2;

    /* renamed from: H3 */
    private int f19469H3;

    /* renamed from: H4 */
    private int f19470H4;

    /* renamed from: X */
    private int[] f19471X;

    /* renamed from: xOff */
    private int f19472xOff;

    public MD5Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: F */
    private int m15105F(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: G */
    private int m15106G(int i, int i2, int i3) {
        return (i & i3) | ((~i3) & i2);
    }

    /* renamed from: H */
    private int m15107H(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: K */
    private int m15108K(int i, int i2, int i3) {
        return ((~i3) | i) ^ i2;
    }

    /* renamed from: copyIn */
    private void m15109copyIn(MD5Digest mD5Digest) {
        super.m15075copyIn((GeneralDigest) mD5Digest);
        this.f19467H1 = mD5Digest.f19467H1;
        this.f19468H2 = mD5Digest.f19468H2;
        this.f19469H3 = mD5Digest.f19469H3;
        this.f19470H4 = mD5Digest.f19470H4;
        int[] iArr = mD5Digest.f19471X;
        System.arraycopy(iArr, 0, this.f19471X, 0, iArr.length);
        this.f19472xOff = mD5Digest.f19472xOff;
    }

    private int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new MD5Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToLittleEndian(this.f19467H1, bArr, i);
        AbstractC6245Pack.intToLittleEndian(this.f19468H2, bArr, i + 4);
        AbstractC6245Pack.intToLittleEndian(this.f19469H3, bArr, i + 8);
        AbstractC6245Pack.intToLittleEndian(this.f19470H4, bArr, i + 12);
        mo14968reset();
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "MD5";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int i = this.f19472xOff * 4;
        byte[] bArr = new byte[i + 37];
        super.populateState(bArr);
        AbstractC6245Pack.intToBigEndian(this.f19467H1, bArr, 16);
        AbstractC6245Pack.intToBigEndian(this.f19468H2, bArr, 20);
        AbstractC6245Pack.intToBigEndian(this.f19469H3, bArr, 24);
        AbstractC6245Pack.intToBigEndian(this.f19470H4, bArr, 28);
        AbstractC6245Pack.intToBigEndian(this.f19472xOff, bArr, 32);
        for (int i2 = 0; i2 != this.f19472xOff; i2++) {
            AbstractC6245Pack.intToBigEndian(this.f19471X[i2], bArr, (i2 * 4) + 36);
        }
        bArr[i + 36] = (byte) this.f19390purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        int i = this.f19467H1;
        int i2 = this.f19468H2;
        int i3 = this.f19469H3;
        int i4 = this.f19470H4;
        int iRotateLeft = rotateLeft(((i + m15105F(i2, i3, i4)) + this.f19471X[0]) - 680876936, 7) + i2;
        int iRotateLeft2 = rotateLeft(((i4 + m15105F(iRotateLeft, i2, i3)) + this.f19471X[1]) - 389564586, 12) + iRotateLeft;
        int iRotateLeft3 = rotateLeft(i3 + m15105F(iRotateLeft2, iRotateLeft, i2) + this.f19471X[2] + 606105819, 17) + iRotateLeft2;
        int iRotateLeft4 = rotateLeft(((i2 + m15105F(iRotateLeft3, iRotateLeft2, iRotateLeft)) + this.f19471X[3]) - 1044525330, 22) + iRotateLeft3;
        int iRotateLeft5 = rotateLeft(((iRotateLeft + m15105F(iRotateLeft4, iRotateLeft3, iRotateLeft2)) + this.f19471X[4]) - 176418897, 7) + iRotateLeft4;
        int iRotateLeft6 = rotateLeft(iRotateLeft2 + m15105F(iRotateLeft5, iRotateLeft4, iRotateLeft3) + this.f19471X[5] + 1200080426, 12) + iRotateLeft5;
        int iRotateLeft7 = rotateLeft(((iRotateLeft3 + m15105F(iRotateLeft6, iRotateLeft5, iRotateLeft4)) + this.f19471X[6]) - 1473231341, 17) + iRotateLeft6;
        int iRotateLeft8 = rotateLeft(((iRotateLeft4 + m15105F(iRotateLeft7, iRotateLeft6, iRotateLeft5)) + this.f19471X[7]) - 45705983, 22) + iRotateLeft7;
        int iRotateLeft9 = rotateLeft(iRotateLeft5 + m15105F(iRotateLeft8, iRotateLeft7, iRotateLeft6) + this.f19471X[8] + 1770035416, 7) + iRotateLeft8;
        int iRotateLeft10 = rotateLeft(((iRotateLeft6 + m15105F(iRotateLeft9, iRotateLeft8, iRotateLeft7)) + this.f19471X[9]) - 1958414417, 12) + iRotateLeft9;
        int iRotateLeft11 = rotateLeft(((iRotateLeft7 + m15105F(iRotateLeft10, iRotateLeft9, iRotateLeft8)) + this.f19471X[10]) - 42063, 17) + iRotateLeft10;
        int iRotateLeft12 = rotateLeft(((iRotateLeft8 + m15105F(iRotateLeft11, iRotateLeft10, iRotateLeft9)) + this.f19471X[11]) - 1990404162, 22) + iRotateLeft11;
        int iRotateLeft13 = rotateLeft(iRotateLeft9 + m15105F(iRotateLeft12, iRotateLeft11, iRotateLeft10) + this.f19471X[12] + 1804603682, 7) + iRotateLeft12;
        int iRotateLeft14 = rotateLeft(((iRotateLeft10 + m15105F(iRotateLeft13, iRotateLeft12, iRotateLeft11)) + this.f19471X[13]) - 40341101, 12) + iRotateLeft13;
        int iRotateLeft15 = rotateLeft(((iRotateLeft11 + m15105F(iRotateLeft14, iRotateLeft13, iRotateLeft12)) + this.f19471X[14]) - 1502002290, 17) + iRotateLeft14;
        int iRotateLeft16 = rotateLeft(iRotateLeft12 + m15105F(iRotateLeft15, iRotateLeft14, iRotateLeft13) + this.f19471X[15] + 1236535329, 22) + iRotateLeft15;
        int iRotateLeft17 = rotateLeft(((iRotateLeft13 + m15106G(iRotateLeft16, iRotateLeft15, iRotateLeft14)) + this.f19471X[1]) - 165796510, 5) + iRotateLeft16;
        int iRotateLeft18 = rotateLeft(((iRotateLeft14 + m15106G(iRotateLeft17, iRotateLeft16, iRotateLeft15)) + this.f19471X[6]) - 1069501632, 9) + iRotateLeft17;
        int iRotateLeft19 = rotateLeft(iRotateLeft15 + m15106G(iRotateLeft18, iRotateLeft17, iRotateLeft16) + this.f19471X[11] + 643717713, 14) + iRotateLeft18;
        int iRotateLeft20 = rotateLeft(((iRotateLeft16 + m15106G(iRotateLeft19, iRotateLeft18, iRotateLeft17)) + this.f19471X[0]) - 373897302, 20) + iRotateLeft19;
        int iRotateLeft21 = rotateLeft(((iRotateLeft17 + m15106G(iRotateLeft20, iRotateLeft19, iRotateLeft18)) + this.f19471X[5]) - 701558691, 5) + iRotateLeft20;
        int iRotateLeft22 = rotateLeft(iRotateLeft18 + m15106G(iRotateLeft21, iRotateLeft20, iRotateLeft19) + this.f19471X[10] + 38016083, 9) + iRotateLeft21;
        int iRotateLeft23 = rotateLeft(((iRotateLeft19 + m15106G(iRotateLeft22, iRotateLeft21, iRotateLeft20)) + this.f19471X[15]) - 660478335, 14) + iRotateLeft22;
        int iRotateLeft24 = rotateLeft(((iRotateLeft20 + m15106G(iRotateLeft23, iRotateLeft22, iRotateLeft21)) + this.f19471X[4]) - 405537848, 20) + iRotateLeft23;
        int iRotateLeft25 = rotateLeft(iRotateLeft21 + m15106G(iRotateLeft24, iRotateLeft23, iRotateLeft22) + this.f19471X[9] + 568446438, 5) + iRotateLeft24;
        int iRotateLeft26 = rotateLeft(((iRotateLeft22 + m15106G(iRotateLeft25, iRotateLeft24, iRotateLeft23)) + this.f19471X[14]) - 1019803690, 9) + iRotateLeft25;
        int iRotateLeft27 = rotateLeft(((iRotateLeft23 + m15106G(iRotateLeft26, iRotateLeft25, iRotateLeft24)) + this.f19471X[3]) - 187363961, 14) + iRotateLeft26;
        int iRotateLeft28 = rotateLeft(iRotateLeft24 + m15106G(iRotateLeft27, iRotateLeft26, iRotateLeft25) + this.f19471X[8] + 1163531501, 20) + iRotateLeft27;
        int iRotateLeft29 = rotateLeft(((iRotateLeft25 + m15106G(iRotateLeft28, iRotateLeft27, iRotateLeft26)) + this.f19471X[13]) - 1444681467, 5) + iRotateLeft28;
        int iRotateLeft30 = rotateLeft(((iRotateLeft26 + m15106G(iRotateLeft29, iRotateLeft28, iRotateLeft27)) + this.f19471X[2]) - 51403784, 9) + iRotateLeft29;
        int iRotateLeft31 = rotateLeft(iRotateLeft27 + m15106G(iRotateLeft30, iRotateLeft29, iRotateLeft28) + this.f19471X[7] + 1735328473, 14) + iRotateLeft30;
        int iRotateLeft32 = rotateLeft(((iRotateLeft28 + m15106G(iRotateLeft31, iRotateLeft30, iRotateLeft29)) + this.f19471X[12]) - 1926607734, 20) + iRotateLeft31;
        int iRotateLeft33 = rotateLeft(((iRotateLeft29 + m15107H(iRotateLeft32, iRotateLeft31, iRotateLeft30)) + this.f19471X[5]) - 378558, 4) + iRotateLeft32;
        int iRotateLeft34 = rotateLeft(((iRotateLeft30 + m15107H(iRotateLeft33, iRotateLeft32, iRotateLeft31)) + this.f19471X[8]) - 2022574463, 11) + iRotateLeft33;
        int iRotateLeft35 = rotateLeft(iRotateLeft31 + m15107H(iRotateLeft34, iRotateLeft33, iRotateLeft32) + this.f19471X[11] + 1839030562, 16) + iRotateLeft34;
        int iRotateLeft36 = rotateLeft(((iRotateLeft32 + m15107H(iRotateLeft35, iRotateLeft34, iRotateLeft33)) + this.f19471X[14]) - 35309556, 23) + iRotateLeft35;
        int iRotateLeft37 = rotateLeft(((iRotateLeft33 + m15107H(iRotateLeft36, iRotateLeft35, iRotateLeft34)) + this.f19471X[1]) - 1530992060, 4) + iRotateLeft36;
        int iRotateLeft38 = rotateLeft(iRotateLeft34 + m15107H(iRotateLeft37, iRotateLeft36, iRotateLeft35) + this.f19471X[4] + 1272893353, 11) + iRotateLeft37;
        int iRotateLeft39 = rotateLeft(((iRotateLeft35 + m15107H(iRotateLeft38, iRotateLeft37, iRotateLeft36)) + this.f19471X[7]) - 155497632, 16) + iRotateLeft38;
        int iRotateLeft40 = rotateLeft(((iRotateLeft36 + m15107H(iRotateLeft39, iRotateLeft38, iRotateLeft37)) + this.f19471X[10]) - 1094730640, 23) + iRotateLeft39;
        int iRotateLeft41 = rotateLeft(iRotateLeft37 + m15107H(iRotateLeft40, iRotateLeft39, iRotateLeft38) + this.f19471X[13] + 681279174, 4) + iRotateLeft40;
        int iRotateLeft42 = rotateLeft(((iRotateLeft38 + m15107H(iRotateLeft41, iRotateLeft40, iRotateLeft39)) + this.f19471X[0]) - 358537222, 11) + iRotateLeft41;
        int iRotateLeft43 = rotateLeft(((iRotateLeft39 + m15107H(iRotateLeft42, iRotateLeft41, iRotateLeft40)) + this.f19471X[3]) - 722521979, 16) + iRotateLeft42;
        int iRotateLeft44 = rotateLeft(iRotateLeft40 + m15107H(iRotateLeft43, iRotateLeft42, iRotateLeft41) + this.f19471X[6] + 76029189, 23) + iRotateLeft43;
        int iRotateLeft45 = rotateLeft(((iRotateLeft41 + m15107H(iRotateLeft44, iRotateLeft43, iRotateLeft42)) + this.f19471X[9]) - 640364487, 4) + iRotateLeft44;
        int iRotateLeft46 = rotateLeft(((iRotateLeft42 + m15107H(iRotateLeft45, iRotateLeft44, iRotateLeft43)) + this.f19471X[12]) - 421815835, 11) + iRotateLeft45;
        int iRotateLeft47 = rotateLeft(iRotateLeft43 + m15107H(iRotateLeft46, iRotateLeft45, iRotateLeft44) + this.f19471X[15] + 530742520, 16) + iRotateLeft46;
        int iRotateLeft48 = rotateLeft(((iRotateLeft44 + m15107H(iRotateLeft47, iRotateLeft46, iRotateLeft45)) + this.f19471X[2]) - 995338651, 23) + iRotateLeft47;
        int iRotateLeft49 = rotateLeft(((iRotateLeft45 + m15108K(iRotateLeft48, iRotateLeft47, iRotateLeft46)) + this.f19471X[0]) - 198630844, 6) + iRotateLeft48;
        int iRotateLeft50 = rotateLeft(iRotateLeft46 + m15108K(iRotateLeft49, iRotateLeft48, iRotateLeft47) + this.f19471X[7] + 1126891415, 10) + iRotateLeft49;
        int iRotateLeft51 = rotateLeft(((iRotateLeft47 + m15108K(iRotateLeft50, iRotateLeft49, iRotateLeft48)) + this.f19471X[14]) - 1416354905, 15) + iRotateLeft50;
        int iRotateLeft52 = rotateLeft(((iRotateLeft48 + m15108K(iRotateLeft51, iRotateLeft50, iRotateLeft49)) + this.f19471X[5]) - 57434055, 21) + iRotateLeft51;
        int iRotateLeft53 = rotateLeft(iRotateLeft49 + m15108K(iRotateLeft52, iRotateLeft51, iRotateLeft50) + this.f19471X[12] + 1700485571, 6) + iRotateLeft52;
        int iRotateLeft54 = rotateLeft(((iRotateLeft50 + m15108K(iRotateLeft53, iRotateLeft52, iRotateLeft51)) + this.f19471X[3]) - 1894986606, 10) + iRotateLeft53;
        int iRotateLeft55 = rotateLeft(((iRotateLeft51 + m15108K(iRotateLeft54, iRotateLeft53, iRotateLeft52)) + this.f19471X[10]) - 1051523, 15) + iRotateLeft54;
        int iRotateLeft56 = rotateLeft(((iRotateLeft52 + m15108K(iRotateLeft55, iRotateLeft54, iRotateLeft53)) + this.f19471X[1]) - 2054922799, 21) + iRotateLeft55;
        int iRotateLeft57 = rotateLeft(iRotateLeft53 + m15108K(iRotateLeft56, iRotateLeft55, iRotateLeft54) + this.f19471X[8] + 1873313359, 6) + iRotateLeft56;
        int iRotateLeft58 = rotateLeft(((iRotateLeft54 + m15108K(iRotateLeft57, iRotateLeft56, iRotateLeft55)) + this.f19471X[15]) - 30611744, 10) + iRotateLeft57;
        int iRotateLeft59 = rotateLeft(((iRotateLeft55 + m15108K(iRotateLeft58, iRotateLeft57, iRotateLeft56)) + this.f19471X[6]) - 1560198380, 15) + iRotateLeft58;
        int iRotateLeft60 = rotateLeft(iRotateLeft56 + m15108K(iRotateLeft59, iRotateLeft58, iRotateLeft57) + this.f19471X[13] + 1309151649, 21) + iRotateLeft59;
        int iRotateLeft61 = rotateLeft(((iRotateLeft57 + m15108K(iRotateLeft60, iRotateLeft59, iRotateLeft58)) + this.f19471X[4]) - 145523070, 6) + iRotateLeft60;
        int iRotateLeft62 = rotateLeft(((iRotateLeft58 + m15108K(iRotateLeft61, iRotateLeft60, iRotateLeft59)) + this.f19471X[11]) - 1120210379, 10) + iRotateLeft61;
        int iRotateLeft63 = rotateLeft(iRotateLeft59 + m15108K(iRotateLeft62, iRotateLeft61, iRotateLeft60) + this.f19471X[2] + 718787259, 15) + iRotateLeft62;
        int iRotateLeft64 = rotateLeft(((iRotateLeft60 + m15108K(iRotateLeft63, iRotateLeft62, iRotateLeft61)) + this.f19471X[9]) - 343485551, 21) + iRotateLeft63;
        this.f19467H1 += iRotateLeft61;
        this.f19468H2 += iRotateLeft64;
        this.f19469H3 += iRotateLeft63;
        this.f19470H4 += iRotateLeft62;
        this.f19472xOff = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f19471X;
            if (i5 == iArr.length) {
                return;
            }
            iArr[i5] = 0;
            i5++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19472xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19471X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f19471X;
        int i2 = this.f19472xOff;
        this.f19472xOff = i2 + 1;
        iArr[i2] = AbstractC6245Pack.littleEndianToInt(bArr, i);
        if (this.f19472xOff == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19467H1 = 1732584193;
        this.f19468H2 = -271733879;
        this.f19469H3 = -1732584194;
        this.f19470H4 = 271733878;
        this.f19472xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19471X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public MD5Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19471X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15109copyIn((MD5Digest) memoable);
    }

    public MD5Digest(MD5Digest mD5Digest) {
        super(mD5Digest);
        this.f19471X = new int[16];
        m15109copyIn(mD5Digest);
    }

    public MD5Digest(byte[] bArr) {
        super(bArr);
        this.f19471X = new int[16];
        this.f19467H1 = AbstractC6245Pack.bigEndianToInt(bArr, 16);
        this.f19468H2 = AbstractC6245Pack.bigEndianToInt(bArr, 20);
        this.f19469H3 = AbstractC6245Pack.bigEndianToInt(bArr, 24);
        this.f19470H4 = AbstractC6245Pack.bigEndianToInt(bArr, 28);
        this.f19472xOff = AbstractC6245Pack.bigEndianToInt(bArr, 32);
        for (int i = 0; i != this.f19472xOff; i++) {
            this.f19471X[i] = AbstractC6245Pack.bigEndianToInt(bArr, (i * 4) + 36);
        }
    }
}
