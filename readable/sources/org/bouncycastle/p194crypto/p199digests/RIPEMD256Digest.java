package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class RIPEMD256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: H0 */
    private int f19496H0;

    /* renamed from: H1 */
    private int f19497H1;

    /* renamed from: H2 */
    private int f19498H2;

    /* renamed from: H3 */
    private int f19499H3;

    /* renamed from: H4 */
    private int f19500H4;

    /* renamed from: H5 */
    private int f19501H5;

    /* renamed from: H6 */
    private int f19502H6;

    /* renamed from: H7 */
    private int f19503H7;

    /* renamed from: X */
    private int[] f19504X;

    /* renamed from: xOff */
    private int f19505xOff;

    public RIPEMD256Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: F1 */
    private int m15133F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15143f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: F2 */
    private int m15134F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15144f2(i2, i3, i4) + i5 + 1518500249, i6);
    }

    /* renamed from: F3 */
    private int m15135F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15145f3(i2, i3, i4) + i5 + 1859775393, i6);
    }

    /* renamed from: F4 */
    private int m15136F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(((i + m15146f4(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    /* renamed from: FF1 */
    private int m15137FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15143f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: FF2 */
    private int m15138FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15144f2(i2, i3, i4) + i5 + 1836072691, i6);
    }

    /* renamed from: FF3 */
    private int m15139FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15145f3(i2, i3, i4) + i5 + 1548603684, i6);
    }

    /* renamed from: FF4 */
    private int m15140FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15141RL(i + m15146f4(i2, i3, i4) + i5 + 1352829926, i6);
    }

    /* renamed from: RL */
    private int m15141RL(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    /* renamed from: copyIn */
    private void m15142copyIn(RIPEMD256Digest rIPEMD256Digest) {
        super.m15075copyIn((GeneralDigest) rIPEMD256Digest);
        this.f19496H0 = rIPEMD256Digest.f19496H0;
        this.f19497H1 = rIPEMD256Digest.f19497H1;
        this.f19498H2 = rIPEMD256Digest.f19498H2;
        this.f19499H3 = rIPEMD256Digest.f19499H3;
        this.f19500H4 = rIPEMD256Digest.f19500H4;
        this.f19501H5 = rIPEMD256Digest.f19501H5;
        this.f19502H6 = rIPEMD256Digest.f19502H6;
        this.f19503H7 = rIPEMD256Digest.f19503H7;
        int[] iArr = rIPEMD256Digest.f19504X;
        System.arraycopy(iArr, 0, this.f19504X, 0, iArr.length);
        this.f19505xOff = rIPEMD256Digest.f19505xOff;
    }

    /* renamed from: f1 */
    private int m15143f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m15144f2(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: f3 */
    private int m15145f3(int i, int i2, int i3) {
        return ((~i2) | i) ^ i3;
    }

    /* renamed from: f4 */
    private int m15146f4(int i, int i2, int i3) {
        return (i & i3) | ((~i3) & i2);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new RIPEMD256Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToLittleEndian(this.f19496H0, bArr, i);
        AbstractC6245Pack.intToLittleEndian(this.f19497H1, bArr, i + 4);
        AbstractC6245Pack.intToLittleEndian(this.f19498H2, bArr, i + 8);
        AbstractC6245Pack.intToLittleEndian(this.f19499H3, bArr, i + 12);
        AbstractC6245Pack.intToLittleEndian(this.f19500H4, bArr, i + 16);
        AbstractC6245Pack.intToLittleEndian(this.f19501H5, bArr, i + 20);
        AbstractC6245Pack.intToLittleEndian(this.f19502H6, bArr, i + 24);
        AbstractC6245Pack.intToLittleEndian(this.f19503H7, bArr, i + 28);
        mo14968reset();
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        int i = this.f19496H0;
        int i2 = this.f19497H1;
        int i3 = this.f19498H2;
        int i4 = this.f19499H3;
        int i5 = this.f19500H4;
        int i6 = this.f19501H5;
        int i7 = this.f19502H6;
        int i8 = this.f19503H7;
        int iM15133F1 = m15133F1(i, i2, i3, i4, this.f19504X[0], 11);
        int iM15133F12 = m15133F1(i4, iM15133F1, i2, i3, this.f19504X[1], 14);
        int iM15133F13 = m15133F1(i3, iM15133F12, iM15133F1, i2, this.f19504X[2], 15);
        int iM15133F14 = m15133F1(i2, iM15133F13, iM15133F12, iM15133F1, this.f19504X[3], 12);
        int iM15133F15 = m15133F1(iM15133F1, iM15133F14, iM15133F13, iM15133F12, this.f19504X[4], 5);
        int iM15133F16 = m15133F1(iM15133F12, iM15133F15, iM15133F14, iM15133F13, this.f19504X[5], 8);
        int iM15133F17 = m15133F1(iM15133F13, iM15133F16, iM15133F15, iM15133F14, this.f19504X[6], 7);
        int iM15133F18 = m15133F1(iM15133F14, iM15133F17, iM15133F16, iM15133F15, this.f19504X[7], 9);
        int iM15133F19 = m15133F1(iM15133F15, iM15133F18, iM15133F17, iM15133F16, this.f19504X[8], 11);
        int iM15133F110 = m15133F1(iM15133F16, iM15133F19, iM15133F18, iM15133F17, this.f19504X[9], 13);
        int iM15133F111 = m15133F1(iM15133F17, iM15133F110, iM15133F19, iM15133F18, this.f19504X[10], 14);
        int iM15133F112 = m15133F1(iM15133F18, iM15133F111, iM15133F110, iM15133F19, this.f19504X[11], 15);
        int iM15133F113 = m15133F1(iM15133F19, iM15133F112, iM15133F111, iM15133F110, this.f19504X[12], 6);
        int iM15133F114 = m15133F1(iM15133F110, iM15133F113, iM15133F112, iM15133F111, this.f19504X[13], 7);
        int iM15133F115 = m15133F1(iM15133F111, iM15133F114, iM15133F113, iM15133F112, this.f19504X[14], 9);
        int iM15133F116 = m15133F1(iM15133F112, iM15133F115, iM15133F114, iM15133F113, this.f19504X[15], 8);
        int iM15140FF4 = m15140FF4(i5, i6, i7, i8, this.f19504X[5], 8);
        int iM15140FF42 = m15140FF4(i8, iM15140FF4, i6, i7, this.f19504X[14], 9);
        int iM15140FF43 = m15140FF4(i7, iM15140FF42, iM15140FF4, i6, this.f19504X[7], 9);
        int iM15140FF44 = m15140FF4(i6, iM15140FF43, iM15140FF42, iM15140FF4, this.f19504X[0], 11);
        int iM15140FF45 = m15140FF4(iM15140FF4, iM15140FF44, iM15140FF43, iM15140FF42, this.f19504X[9], 13);
        int iM15140FF46 = m15140FF4(iM15140FF42, iM15140FF45, iM15140FF44, iM15140FF43, this.f19504X[2], 15);
        int iM15140FF47 = m15140FF4(iM15140FF43, iM15140FF46, iM15140FF45, iM15140FF44, this.f19504X[11], 15);
        int iM15140FF48 = m15140FF4(iM15140FF44, iM15140FF47, iM15140FF46, iM15140FF45, this.f19504X[4], 5);
        int iM15140FF49 = m15140FF4(iM15140FF45, iM15140FF48, iM15140FF47, iM15140FF46, this.f19504X[13], 7);
        int iM15140FF410 = m15140FF4(iM15140FF46, iM15140FF49, iM15140FF48, iM15140FF47, this.f19504X[6], 7);
        int iM15140FF411 = m15140FF4(iM15140FF47, iM15140FF410, iM15140FF49, iM15140FF48, this.f19504X[15], 8);
        int iM15140FF412 = m15140FF4(iM15140FF48, iM15140FF411, iM15140FF410, iM15140FF49, this.f19504X[8], 11);
        int iM15140FF413 = m15140FF4(iM15140FF49, iM15140FF412, iM15140FF411, iM15140FF410, this.f19504X[1], 14);
        int iM15140FF414 = m15140FF4(iM15140FF410, iM15140FF413, iM15140FF412, iM15140FF411, this.f19504X[10], 14);
        int iM15140FF415 = m15140FF4(iM15140FF411, iM15140FF414, iM15140FF413, iM15140FF412, this.f19504X[3], 12);
        int iM15140FF416 = m15140FF4(iM15140FF412, iM15140FF415, iM15140FF414, iM15140FF413, this.f19504X[12], 6);
        int iM15134F2 = m15134F2(iM15140FF413, iM15133F116, iM15133F115, iM15133F114, this.f19504X[7], 7);
        int iM15134F22 = m15134F2(iM15133F114, iM15134F2, iM15133F116, iM15133F115, this.f19504X[4], 6);
        int iM15134F23 = m15134F2(iM15133F115, iM15134F22, iM15134F2, iM15133F116, this.f19504X[13], 8);
        int iM15134F24 = m15134F2(iM15133F116, iM15134F23, iM15134F22, iM15134F2, this.f19504X[1], 13);
        int iM15134F25 = m15134F2(iM15134F2, iM15134F24, iM15134F23, iM15134F22, this.f19504X[10], 11);
        int iM15134F26 = m15134F2(iM15134F22, iM15134F25, iM15134F24, iM15134F23, this.f19504X[6], 9);
        int iM15134F27 = m15134F2(iM15134F23, iM15134F26, iM15134F25, iM15134F24, this.f19504X[15], 7);
        int iM15134F28 = m15134F2(iM15134F24, iM15134F27, iM15134F26, iM15134F25, this.f19504X[3], 15);
        int iM15134F29 = m15134F2(iM15134F25, iM15134F28, iM15134F27, iM15134F26, this.f19504X[12], 7);
        int iM15134F210 = m15134F2(iM15134F26, iM15134F29, iM15134F28, iM15134F27, this.f19504X[0], 12);
        int iM15134F211 = m15134F2(iM15134F27, iM15134F210, iM15134F29, iM15134F28, this.f19504X[9], 15);
        int iM15134F212 = m15134F2(iM15134F28, iM15134F211, iM15134F210, iM15134F29, this.f19504X[5], 9);
        int iM15134F213 = m15134F2(iM15134F29, iM15134F212, iM15134F211, iM15134F210, this.f19504X[2], 11);
        int iM15134F214 = m15134F2(iM15134F210, iM15134F213, iM15134F212, iM15134F211, this.f19504X[14], 7);
        int iM15134F215 = m15134F2(iM15134F211, iM15134F214, iM15134F213, iM15134F212, this.f19504X[11], 13);
        int iM15134F216 = m15134F2(iM15134F212, iM15134F215, iM15134F214, iM15134F213, this.f19504X[8], 12);
        int iM15139FF3 = m15139FF3(iM15133F113, iM15140FF416, iM15140FF415, iM15140FF414, this.f19504X[6], 9);
        int iM15139FF32 = m15139FF3(iM15140FF414, iM15139FF3, iM15140FF416, iM15140FF415, this.f19504X[11], 13);
        int iM15139FF33 = m15139FF3(iM15140FF415, iM15139FF32, iM15139FF3, iM15140FF416, this.f19504X[3], 15);
        int iM15139FF34 = m15139FF3(iM15140FF416, iM15139FF33, iM15139FF32, iM15139FF3, this.f19504X[7], 7);
        int iM15139FF35 = m15139FF3(iM15139FF3, iM15139FF34, iM15139FF33, iM15139FF32, this.f19504X[0], 12);
        int iM15139FF36 = m15139FF3(iM15139FF32, iM15139FF35, iM15139FF34, iM15139FF33, this.f19504X[13], 8);
        int iM15139FF37 = m15139FF3(iM15139FF33, iM15139FF36, iM15139FF35, iM15139FF34, this.f19504X[5], 9);
        int iM15139FF38 = m15139FF3(iM15139FF34, iM15139FF37, iM15139FF36, iM15139FF35, this.f19504X[10], 11);
        int iM15139FF39 = m15139FF3(iM15139FF35, iM15139FF38, iM15139FF37, iM15139FF36, this.f19504X[14], 7);
        int iM15139FF310 = m15139FF3(iM15139FF36, iM15139FF39, iM15139FF38, iM15139FF37, this.f19504X[15], 7);
        int iM15139FF311 = m15139FF3(iM15139FF37, iM15139FF310, iM15139FF39, iM15139FF38, this.f19504X[8], 12);
        int iM15139FF312 = m15139FF3(iM15139FF38, iM15139FF311, iM15139FF310, iM15139FF39, this.f19504X[12], 7);
        int iM15139FF313 = m15139FF3(iM15139FF39, iM15139FF312, iM15139FF311, iM15139FF310, this.f19504X[4], 6);
        int iM15139FF314 = m15139FF3(iM15139FF310, iM15139FF313, iM15139FF312, iM15139FF311, this.f19504X[9], 15);
        int iM15139FF315 = m15139FF3(iM15139FF311, iM15139FF314, iM15139FF313, iM15139FF312, this.f19504X[1], 13);
        int iM15139FF316 = m15139FF3(iM15139FF312, iM15139FF315, iM15139FF314, iM15139FF313, this.f19504X[2], 11);
        int iM15135F3 = m15135F3(iM15134F213, iM15139FF316, iM15134F215, iM15134F214, this.f19504X[3], 11);
        int iM15135F32 = m15135F3(iM15134F214, iM15135F3, iM15139FF316, iM15134F215, this.f19504X[10], 13);
        int iM15135F33 = m15135F3(iM15134F215, iM15135F32, iM15135F3, iM15139FF316, this.f19504X[14], 6);
        int iM15135F34 = m15135F3(iM15139FF316, iM15135F33, iM15135F32, iM15135F3, this.f19504X[4], 7);
        int iM15135F35 = m15135F3(iM15135F3, iM15135F34, iM15135F33, iM15135F32, this.f19504X[9], 14);
        int iM15135F36 = m15135F3(iM15135F32, iM15135F35, iM15135F34, iM15135F33, this.f19504X[15], 9);
        int iM15135F37 = m15135F3(iM15135F33, iM15135F36, iM15135F35, iM15135F34, this.f19504X[8], 13);
        int iM15135F38 = m15135F3(iM15135F34, iM15135F37, iM15135F36, iM15135F35, this.f19504X[1], 15);
        int iM15135F39 = m15135F3(iM15135F35, iM15135F38, iM15135F37, iM15135F36, this.f19504X[2], 14);
        int iM15135F310 = m15135F3(iM15135F36, iM15135F39, iM15135F38, iM15135F37, this.f19504X[7], 8);
        int iM15135F311 = m15135F3(iM15135F37, iM15135F310, iM15135F39, iM15135F38, this.f19504X[0], 13);
        int iM15135F312 = m15135F3(iM15135F38, iM15135F311, iM15135F310, iM15135F39, this.f19504X[6], 6);
        int iM15135F313 = m15135F3(iM15135F39, iM15135F312, iM15135F311, iM15135F310, this.f19504X[13], 5);
        int iM15135F314 = m15135F3(iM15135F310, iM15135F313, iM15135F312, iM15135F311, this.f19504X[11], 12);
        int iM15135F315 = m15135F3(iM15135F311, iM15135F314, iM15135F313, iM15135F312, this.f19504X[5], 7);
        int iM15135F316 = m15135F3(iM15135F312, iM15135F315, iM15135F314, iM15135F313, this.f19504X[12], 5);
        int iM15138FF2 = m15138FF2(iM15139FF313, iM15134F216, iM15139FF315, iM15139FF314, this.f19504X[15], 9);
        int iM15138FF22 = m15138FF2(iM15139FF314, iM15138FF2, iM15134F216, iM15139FF315, this.f19504X[5], 7);
        int iM15138FF23 = m15138FF2(iM15139FF315, iM15138FF22, iM15138FF2, iM15134F216, this.f19504X[1], 15);
        int iM15138FF24 = m15138FF2(iM15134F216, iM15138FF23, iM15138FF22, iM15138FF2, this.f19504X[3], 11);
        int iM15138FF25 = m15138FF2(iM15138FF2, iM15138FF24, iM15138FF23, iM15138FF22, this.f19504X[7], 8);
        int iM15138FF26 = m15138FF2(iM15138FF22, iM15138FF25, iM15138FF24, iM15138FF23, this.f19504X[14], 6);
        int iM15138FF27 = m15138FF2(iM15138FF23, iM15138FF26, iM15138FF25, iM15138FF24, this.f19504X[6], 6);
        int iM15138FF28 = m15138FF2(iM15138FF24, iM15138FF27, iM15138FF26, iM15138FF25, this.f19504X[9], 14);
        int iM15138FF29 = m15138FF2(iM15138FF25, iM15138FF28, iM15138FF27, iM15138FF26, this.f19504X[11], 12);
        int iM15138FF210 = m15138FF2(iM15138FF26, iM15138FF29, iM15138FF28, iM15138FF27, this.f19504X[8], 13);
        int iM15138FF211 = m15138FF2(iM15138FF27, iM15138FF210, iM15138FF29, iM15138FF28, this.f19504X[12], 5);
        int iM15138FF212 = m15138FF2(iM15138FF28, iM15138FF211, iM15138FF210, iM15138FF29, this.f19504X[2], 14);
        int iM15138FF213 = m15138FF2(iM15138FF29, iM15138FF212, iM15138FF211, iM15138FF210, this.f19504X[10], 13);
        int iM15138FF214 = m15138FF2(iM15138FF210, iM15138FF213, iM15138FF212, iM15138FF211, this.f19504X[0], 13);
        int iM15138FF215 = m15138FF2(iM15138FF211, iM15138FF214, iM15138FF213, iM15138FF212, this.f19504X[4], 7);
        int iM15138FF216 = m15138FF2(iM15138FF212, iM15138FF215, iM15138FF214, iM15138FF213, this.f19504X[13], 5);
        int iM15136F4 = m15136F4(iM15135F313, iM15135F316, iM15138FF215, iM15135F314, this.f19504X[1], 11);
        int iM15136F42 = m15136F4(iM15135F314, iM15136F4, iM15135F316, iM15138FF215, this.f19504X[9], 12);
        int iM15136F43 = m15136F4(iM15138FF215, iM15136F42, iM15136F4, iM15135F316, this.f19504X[11], 14);
        int iM15136F44 = m15136F4(iM15135F316, iM15136F43, iM15136F42, iM15136F4, this.f19504X[10], 15);
        int iM15136F45 = m15136F4(iM15136F4, iM15136F44, iM15136F43, iM15136F42, this.f19504X[0], 14);
        int iM15136F46 = m15136F4(iM15136F42, iM15136F45, iM15136F44, iM15136F43, this.f19504X[8], 15);
        int iM15136F47 = m15136F4(iM15136F43, iM15136F46, iM15136F45, iM15136F44, this.f19504X[12], 9);
        int iM15136F48 = m15136F4(iM15136F44, iM15136F47, iM15136F46, iM15136F45, this.f19504X[4], 8);
        int iM15136F49 = m15136F4(iM15136F45, iM15136F48, iM15136F47, iM15136F46, this.f19504X[13], 9);
        int iM15136F410 = m15136F4(iM15136F46, iM15136F49, iM15136F48, iM15136F47, this.f19504X[3], 14);
        int iM15136F411 = m15136F4(iM15136F47, iM15136F410, iM15136F49, iM15136F48, this.f19504X[7], 5);
        int iM15136F412 = m15136F4(iM15136F48, iM15136F411, iM15136F410, iM15136F49, this.f19504X[15], 6);
        int iM15136F413 = m15136F4(iM15136F49, iM15136F412, iM15136F411, iM15136F410, this.f19504X[14], 8);
        int iM15136F414 = m15136F4(iM15136F410, iM15136F413, iM15136F412, iM15136F411, this.f19504X[5], 6);
        int iM15136F415 = m15136F4(iM15136F411, iM15136F414, iM15136F413, iM15136F412, this.f19504X[6], 5);
        int iM15136F416 = m15136F4(iM15136F412, iM15136F415, iM15136F414, iM15136F413, this.f19504X[2], 12);
        int iM15137FF1 = m15137FF1(iM15138FF213, iM15138FF216, iM15135F315, iM15138FF214, this.f19504X[8], 15);
        int iM15137FF12 = m15137FF1(iM15138FF214, iM15137FF1, iM15138FF216, iM15135F315, this.f19504X[6], 5);
        int iM15137FF13 = m15137FF1(iM15135F315, iM15137FF12, iM15137FF1, iM15138FF216, this.f19504X[4], 8);
        int iM15137FF14 = m15137FF1(iM15138FF216, iM15137FF13, iM15137FF12, iM15137FF1, this.f19504X[1], 11);
        int iM15137FF15 = m15137FF1(iM15137FF1, iM15137FF14, iM15137FF13, iM15137FF12, this.f19504X[3], 14);
        int iM15137FF16 = m15137FF1(iM15137FF12, iM15137FF15, iM15137FF14, iM15137FF13, this.f19504X[11], 14);
        int iM15137FF17 = m15137FF1(iM15137FF13, iM15137FF16, iM15137FF15, iM15137FF14, this.f19504X[15], 6);
        int iM15137FF18 = m15137FF1(iM15137FF14, iM15137FF17, iM15137FF16, iM15137FF15, this.f19504X[0], 14);
        int iM15137FF19 = m15137FF1(iM15137FF15, iM15137FF18, iM15137FF17, iM15137FF16, this.f19504X[5], 6);
        int iM15137FF110 = m15137FF1(iM15137FF16, iM15137FF19, iM15137FF18, iM15137FF17, this.f19504X[12], 9);
        int iM15137FF111 = m15137FF1(iM15137FF17, iM15137FF110, iM15137FF19, iM15137FF18, this.f19504X[2], 12);
        int iM15137FF112 = m15137FF1(iM15137FF18, iM15137FF111, iM15137FF110, iM15137FF19, this.f19504X[13], 9);
        int iM15137FF113 = m15137FF1(iM15137FF19, iM15137FF112, iM15137FF111, iM15137FF110, this.f19504X[9], 12);
        int iM15137FF114 = m15137FF1(iM15137FF110, iM15137FF113, iM15137FF112, iM15137FF111, this.f19504X[7], 5);
        int iM15137FF115 = m15137FF1(iM15137FF111, iM15137FF114, iM15137FF113, iM15137FF112, this.f19504X[10], 15);
        int iM15137FF116 = m15137FF1(iM15137FF112, iM15137FF115, iM15137FF114, iM15137FF113, this.f19504X[14], 8);
        this.f19496H0 += iM15136F413;
        this.f19497H1 += iM15136F416;
        this.f19498H2 += iM15136F415;
        this.f19499H3 += iM15137FF114;
        this.f19500H4 += iM15137FF113;
        this.f19501H5 += iM15137FF116;
        this.f19502H6 += iM15137FF115;
        this.f19503H7 += iM15136F414;
        this.f19505xOff = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f19504X;
            if (i9 == iArr.length) {
                return;
            }
            iArr[i9] = 0;
            i9++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19505xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19504X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f19504X;
        int i2 = this.f19505xOff;
        this.f19505xOff = i2 + 1;
        iArr[i2] = AbstractC6245Pack.littleEndianToInt(bArr, i);
        if (this.f19505xOff == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19496H0 = 1732584193;
        this.f19497H1 = -271733879;
        this.f19498H2 = -1732584194;
        this.f19499H3 = 271733878;
        this.f19500H4 = 1985229328;
        this.f19501H5 = -19088744;
        this.f19502H6 = -1985229329;
        this.f19503H7 = 19088743;
        this.f19505xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19504X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD256Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19504X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 128, cryptoServicePurpose));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15142copyIn((RIPEMD256Digest) memoable);
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest.f19390purpose);
        this.f19504X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 128, this.f19390purpose));
        m15142copyIn(rIPEMD256Digest);
    }
}
