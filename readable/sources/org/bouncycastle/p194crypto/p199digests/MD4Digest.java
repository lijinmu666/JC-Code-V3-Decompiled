package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class MD4Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: S11 */
    private static final int f19433S11 = 3;

    /* renamed from: S12 */
    private static final int f19434S12 = 7;

    /* renamed from: S13 */
    private static final int f19435S13 = 11;

    /* renamed from: S14 */
    private static final int f19436S14 = 19;

    /* renamed from: S21 */
    private static final int f19437S21 = 3;

    /* renamed from: S22 */
    private static final int f19438S22 = 5;

    /* renamed from: S23 */
    private static final int f19439S23 = 9;

    /* renamed from: S24 */
    private static final int f19440S24 = 13;

    /* renamed from: S31 */
    private static final int f19441S31 = 3;

    /* renamed from: S32 */
    private static final int f19442S32 = 9;

    /* renamed from: S33 */
    private static final int f19443S33 = 11;

    /* renamed from: S34 */
    private static final int f19444S34 = 15;

    /* renamed from: H1 */
    private int f19445H1;

    /* renamed from: H2 */
    private int f19446H2;

    /* renamed from: H3 */
    private int f19447H3;

    /* renamed from: H4 */
    private int f19448H4;

    /* renamed from: X */
    private int[] f19449X;

    /* renamed from: xOff */
    private int f19450xOff;

    public MD4Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: F */
    private int m15101F(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: G */
    private int m15102G(int i, int i2, int i3) {
        return ((i2 | i3) & i) | (i2 & i3);
    }

    /* renamed from: H */
    private int m15103H(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: copyIn */
    private void m15104copyIn(MD4Digest mD4Digest) {
        super.m15075copyIn((GeneralDigest) mD4Digest);
        this.f19445H1 = mD4Digest.f19445H1;
        this.f19446H2 = mD4Digest.f19446H2;
        this.f19447H3 = mD4Digest.f19447H3;
        this.f19448H4 = mD4Digest.f19448H4;
        int[] iArr = mD4Digest.f19449X;
        System.arraycopy(iArr, 0, this.f19449X, 0, iArr.length);
        this.f19450xOff = mD4Digest.f19450xOff;
    }

    private int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new MD4Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToLittleEndian(this.f19445H1, bArr, i);
        AbstractC6245Pack.intToLittleEndian(this.f19446H2, bArr, i + 4);
        AbstractC6245Pack.intToLittleEndian(this.f19447H3, bArr, i + 8);
        AbstractC6245Pack.intToLittleEndian(this.f19448H4, bArr, i + 12);
        mo14968reset();
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "MD4";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        int i = this.f19445H1;
        int i2 = this.f19446H2;
        int i3 = this.f19447H3;
        int i4 = this.f19448H4;
        int iRotateLeft = rotateLeft(i + m15101F(i2, i3, i4) + this.f19449X[0], 3);
        int iRotateLeft2 = rotateLeft(i4 + m15101F(iRotateLeft, i2, i3) + this.f19449X[1], 7);
        int iRotateLeft3 = rotateLeft(i3 + m15101F(iRotateLeft2, iRotateLeft, i2) + this.f19449X[2], 11);
        int iRotateLeft4 = rotateLeft(i2 + m15101F(iRotateLeft3, iRotateLeft2, iRotateLeft) + this.f19449X[3], 19);
        int iRotateLeft5 = rotateLeft(iRotateLeft + m15101F(iRotateLeft4, iRotateLeft3, iRotateLeft2) + this.f19449X[4], 3);
        int iRotateLeft6 = rotateLeft(iRotateLeft2 + m15101F(iRotateLeft5, iRotateLeft4, iRotateLeft3) + this.f19449X[5], 7);
        int iRotateLeft7 = rotateLeft(iRotateLeft3 + m15101F(iRotateLeft6, iRotateLeft5, iRotateLeft4) + this.f19449X[6], 11);
        int iRotateLeft8 = rotateLeft(iRotateLeft4 + m15101F(iRotateLeft7, iRotateLeft6, iRotateLeft5) + this.f19449X[7], 19);
        int iRotateLeft9 = rotateLeft(iRotateLeft5 + m15101F(iRotateLeft8, iRotateLeft7, iRotateLeft6) + this.f19449X[8], 3);
        int iRotateLeft10 = rotateLeft(iRotateLeft6 + m15101F(iRotateLeft9, iRotateLeft8, iRotateLeft7) + this.f19449X[9], 7);
        int iRotateLeft11 = rotateLeft(iRotateLeft7 + m15101F(iRotateLeft10, iRotateLeft9, iRotateLeft8) + this.f19449X[10], 11);
        int iRotateLeft12 = rotateLeft(iRotateLeft8 + m15101F(iRotateLeft11, iRotateLeft10, iRotateLeft9) + this.f19449X[11], 19);
        int iRotateLeft13 = rotateLeft(iRotateLeft9 + m15101F(iRotateLeft12, iRotateLeft11, iRotateLeft10) + this.f19449X[12], 3);
        int iRotateLeft14 = rotateLeft(iRotateLeft10 + m15101F(iRotateLeft13, iRotateLeft12, iRotateLeft11) + this.f19449X[13], 7);
        int iRotateLeft15 = rotateLeft(iRotateLeft11 + m15101F(iRotateLeft14, iRotateLeft13, iRotateLeft12) + this.f19449X[14], 11);
        int iRotateLeft16 = rotateLeft(iRotateLeft12 + m15101F(iRotateLeft15, iRotateLeft14, iRotateLeft13) + this.f19449X[15], 19);
        int iRotateLeft17 = rotateLeft(iRotateLeft13 + m15102G(iRotateLeft16, iRotateLeft15, iRotateLeft14) + this.f19449X[0] + 1518500249, 3);
        int iRotateLeft18 = rotateLeft(iRotateLeft14 + m15102G(iRotateLeft17, iRotateLeft16, iRotateLeft15) + this.f19449X[4] + 1518500249, 5);
        int iRotateLeft19 = rotateLeft(iRotateLeft15 + m15102G(iRotateLeft18, iRotateLeft17, iRotateLeft16) + this.f19449X[8] + 1518500249, 9);
        int iRotateLeft20 = rotateLeft(iRotateLeft16 + m15102G(iRotateLeft19, iRotateLeft18, iRotateLeft17) + this.f19449X[12] + 1518500249, 13);
        int iRotateLeft21 = rotateLeft(iRotateLeft17 + m15102G(iRotateLeft20, iRotateLeft19, iRotateLeft18) + this.f19449X[1] + 1518500249, 3);
        int iRotateLeft22 = rotateLeft(iRotateLeft18 + m15102G(iRotateLeft21, iRotateLeft20, iRotateLeft19) + this.f19449X[5] + 1518500249, 5);
        int iRotateLeft23 = rotateLeft(iRotateLeft19 + m15102G(iRotateLeft22, iRotateLeft21, iRotateLeft20) + this.f19449X[9] + 1518500249, 9);
        int iRotateLeft24 = rotateLeft(iRotateLeft20 + m15102G(iRotateLeft23, iRotateLeft22, iRotateLeft21) + this.f19449X[13] + 1518500249, 13);
        int iRotateLeft25 = rotateLeft(iRotateLeft21 + m15102G(iRotateLeft24, iRotateLeft23, iRotateLeft22) + this.f19449X[2] + 1518500249, 3);
        int iRotateLeft26 = rotateLeft(iRotateLeft22 + m15102G(iRotateLeft25, iRotateLeft24, iRotateLeft23) + this.f19449X[6] + 1518500249, 5);
        int iRotateLeft27 = rotateLeft(iRotateLeft23 + m15102G(iRotateLeft26, iRotateLeft25, iRotateLeft24) + this.f19449X[10] + 1518500249, 9);
        int iRotateLeft28 = rotateLeft(iRotateLeft24 + m15102G(iRotateLeft27, iRotateLeft26, iRotateLeft25) + this.f19449X[14] + 1518500249, 13);
        int iRotateLeft29 = rotateLeft(iRotateLeft25 + m15102G(iRotateLeft28, iRotateLeft27, iRotateLeft26) + this.f19449X[3] + 1518500249, 3);
        int iRotateLeft30 = rotateLeft(iRotateLeft26 + m15102G(iRotateLeft29, iRotateLeft28, iRotateLeft27) + this.f19449X[7] + 1518500249, 5);
        int iRotateLeft31 = rotateLeft(iRotateLeft27 + m15102G(iRotateLeft30, iRotateLeft29, iRotateLeft28) + this.f19449X[11] + 1518500249, 9);
        int iRotateLeft32 = rotateLeft(iRotateLeft28 + m15102G(iRotateLeft31, iRotateLeft30, iRotateLeft29) + this.f19449X[15] + 1518500249, 13);
        int iRotateLeft33 = rotateLeft(iRotateLeft29 + m15103H(iRotateLeft32, iRotateLeft31, iRotateLeft30) + this.f19449X[0] + 1859775393, 3);
        int iRotateLeft34 = rotateLeft(iRotateLeft30 + m15103H(iRotateLeft33, iRotateLeft32, iRotateLeft31) + this.f19449X[8] + 1859775393, 9);
        int iRotateLeft35 = rotateLeft(iRotateLeft31 + m15103H(iRotateLeft34, iRotateLeft33, iRotateLeft32) + this.f19449X[4] + 1859775393, 11);
        int iRotateLeft36 = rotateLeft(iRotateLeft32 + m15103H(iRotateLeft35, iRotateLeft34, iRotateLeft33) + this.f19449X[12] + 1859775393, 15);
        int iRotateLeft37 = rotateLeft(iRotateLeft33 + m15103H(iRotateLeft36, iRotateLeft35, iRotateLeft34) + this.f19449X[2] + 1859775393, 3);
        int iRotateLeft38 = rotateLeft(iRotateLeft34 + m15103H(iRotateLeft37, iRotateLeft36, iRotateLeft35) + this.f19449X[10] + 1859775393, 9);
        int iRotateLeft39 = rotateLeft(iRotateLeft35 + m15103H(iRotateLeft38, iRotateLeft37, iRotateLeft36) + this.f19449X[6] + 1859775393, 11);
        int iRotateLeft40 = rotateLeft(iRotateLeft36 + m15103H(iRotateLeft39, iRotateLeft38, iRotateLeft37) + this.f19449X[14] + 1859775393, 15);
        int iRotateLeft41 = rotateLeft(iRotateLeft37 + m15103H(iRotateLeft40, iRotateLeft39, iRotateLeft38) + this.f19449X[1] + 1859775393, 3);
        int iRotateLeft42 = rotateLeft(iRotateLeft38 + m15103H(iRotateLeft41, iRotateLeft40, iRotateLeft39) + this.f19449X[9] + 1859775393, 9);
        int iRotateLeft43 = rotateLeft(iRotateLeft39 + m15103H(iRotateLeft42, iRotateLeft41, iRotateLeft40) + this.f19449X[5] + 1859775393, 11);
        int iRotateLeft44 = rotateLeft(iRotateLeft40 + m15103H(iRotateLeft43, iRotateLeft42, iRotateLeft41) + this.f19449X[13] + 1859775393, 15);
        int iRotateLeft45 = rotateLeft(iRotateLeft41 + m15103H(iRotateLeft44, iRotateLeft43, iRotateLeft42) + this.f19449X[3] + 1859775393, 3);
        int iRotateLeft46 = rotateLeft(iRotateLeft42 + m15103H(iRotateLeft45, iRotateLeft44, iRotateLeft43) + this.f19449X[11] + 1859775393, 9);
        int iRotateLeft47 = rotateLeft(iRotateLeft43 + m15103H(iRotateLeft46, iRotateLeft45, iRotateLeft44) + this.f19449X[7] + 1859775393, 11);
        int iRotateLeft48 = rotateLeft(iRotateLeft44 + m15103H(iRotateLeft47, iRotateLeft46, iRotateLeft45) + this.f19449X[15] + 1859775393, 15);
        this.f19445H1 += iRotateLeft45;
        this.f19446H2 += iRotateLeft48;
        this.f19447H3 += iRotateLeft47;
        this.f19448H4 += iRotateLeft46;
        this.f19450xOff = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f19449X;
            if (i5 == iArr.length) {
                return;
            }
            iArr[i5] = 0;
            i5++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19450xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19449X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f19449X;
        int i2 = this.f19450xOff;
        this.f19450xOff = i2 + 1;
        iArr[i2] = AbstractC6245Pack.littleEndianToInt(bArr, i);
        if (this.f19450xOff == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19445H1 = 1732584193;
        this.f19446H2 = -271733879;
        this.f19447H3 = -1732584194;
        this.f19448H4 = 271733878;
        this.f19450xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19449X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public MD4Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19449X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15104copyIn((MD4Digest) memoable);
    }

    public MD4Digest(MD4Digest mD4Digest) {
        super(mD4Digest.f19390purpose);
        this.f19449X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 64, this.f19390purpose));
        m15104copyIn(mD4Digest);
    }
}
