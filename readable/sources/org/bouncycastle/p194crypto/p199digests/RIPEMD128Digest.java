package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class RIPEMD128Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: H0 */
    private int f19483H0;

    /* renamed from: H1 */
    private int f19484H1;

    /* renamed from: H2 */
    private int f19485H2;

    /* renamed from: H3 */
    private int f19486H3;

    /* renamed from: X */
    private int[] f19487X;

    /* renamed from: xOff */
    private int f19488xOff;

    public RIPEMD128Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: F1 */
    private int m15112F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15122f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: F2 */
    private int m15113F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15123f2(i2, i3, i4) + i5 + 1518500249, i6);
    }

    /* renamed from: F3 */
    private int m15114F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15124f3(i2, i3, i4) + i5 + 1859775393, i6);
    }

    /* renamed from: F4 */
    private int m15115F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(((i + m15125f4(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    /* renamed from: FF1 */
    private int m15116FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15122f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: FF2 */
    private int m15117FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15123f2(i2, i3, i4) + i5 + 1836072691, i6);
    }

    /* renamed from: FF3 */
    private int m15118FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15124f3(i2, i3, i4) + i5 + 1548603684, i6);
    }

    /* renamed from: FF4 */
    private int m15119FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m15120RL(i + m15125f4(i2, i3, i4) + i5 + 1352829926, i6);
    }

    /* renamed from: RL */
    private int m15120RL(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    /* renamed from: copyIn */
    private void m15121copyIn(RIPEMD128Digest rIPEMD128Digest) {
        super.m15075copyIn((GeneralDigest) rIPEMD128Digest);
        this.f19483H0 = rIPEMD128Digest.f19483H0;
        this.f19484H1 = rIPEMD128Digest.f19484H1;
        this.f19485H2 = rIPEMD128Digest.f19485H2;
        this.f19486H3 = rIPEMD128Digest.f19486H3;
        int[] iArr = rIPEMD128Digest.f19487X;
        System.arraycopy(iArr, 0, this.f19487X, 0, iArr.length);
        this.f19488xOff = rIPEMD128Digest.f19488xOff;
    }

    /* renamed from: f1 */
    private int m15122f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m15123f2(int i, int i2, int i3) {
        return (i & i2) | ((~i) & i3);
    }

    /* renamed from: f3 */
    private int m15124f3(int i, int i2, int i3) {
        return ((~i2) | i) ^ i3;
    }

    /* renamed from: f4 */
    private int m15125f4(int i, int i2, int i3) {
        return (i & i3) | ((~i3) & i2);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new RIPEMD128Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, this.f19390purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15076finish();
        AbstractC6245Pack.intToLittleEndian(this.f19483H0, bArr, i);
        AbstractC6245Pack.intToLittleEndian(this.f19484H1, bArr, i + 4);
        AbstractC6245Pack.intToLittleEndian(this.f19485H2, bArr, i + 8);
        AbstractC6245Pack.intToLittleEndian(this.f19486H3, bArr, i + 12);
        mo14968reset();
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "RIPEMD128";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processBlock() {
        int i = this.f19483H0;
        int i2 = this.f19484H1;
        int i3 = this.f19485H2;
        int i4 = this.f19486H3;
        int iM15112F1 = m15112F1(i, i2, i3, i4, this.f19487X[0], 11);
        int iM15112F12 = m15112F1(i4, iM15112F1, i2, i3, this.f19487X[1], 14);
        int iM15112F13 = m15112F1(i3, iM15112F12, iM15112F1, i2, this.f19487X[2], 15);
        int iM15112F14 = m15112F1(i2, iM15112F13, iM15112F12, iM15112F1, this.f19487X[3], 12);
        int iM15112F15 = m15112F1(iM15112F1, iM15112F14, iM15112F13, iM15112F12, this.f19487X[4], 5);
        int iM15112F16 = m15112F1(iM15112F12, iM15112F15, iM15112F14, iM15112F13, this.f19487X[5], 8);
        int iM15112F17 = m15112F1(iM15112F13, iM15112F16, iM15112F15, iM15112F14, this.f19487X[6], 7);
        int iM15112F18 = m15112F1(iM15112F14, iM15112F17, iM15112F16, iM15112F15, this.f19487X[7], 9);
        int iM15112F19 = m15112F1(iM15112F15, iM15112F18, iM15112F17, iM15112F16, this.f19487X[8], 11);
        int iM15112F110 = m15112F1(iM15112F16, iM15112F19, iM15112F18, iM15112F17, this.f19487X[9], 13);
        int iM15112F111 = m15112F1(iM15112F17, iM15112F110, iM15112F19, iM15112F18, this.f19487X[10], 14);
        int iM15112F112 = m15112F1(iM15112F18, iM15112F111, iM15112F110, iM15112F19, this.f19487X[11], 15);
        int iM15112F113 = m15112F1(iM15112F19, iM15112F112, iM15112F111, iM15112F110, this.f19487X[12], 6);
        int iM15112F114 = m15112F1(iM15112F110, iM15112F113, iM15112F112, iM15112F111, this.f19487X[13], 7);
        int iM15112F115 = m15112F1(iM15112F111, iM15112F114, iM15112F113, iM15112F112, this.f19487X[14], 9);
        int iM15112F116 = m15112F1(iM15112F112, iM15112F115, iM15112F114, iM15112F113, this.f19487X[15], 8);
        int iM15113F2 = m15113F2(iM15112F113, iM15112F116, iM15112F115, iM15112F114, this.f19487X[7], 7);
        int iM15113F22 = m15113F2(iM15112F114, iM15113F2, iM15112F116, iM15112F115, this.f19487X[4], 6);
        int iM15113F23 = m15113F2(iM15112F115, iM15113F22, iM15113F2, iM15112F116, this.f19487X[13], 8);
        int iM15113F24 = m15113F2(iM15112F116, iM15113F23, iM15113F22, iM15113F2, this.f19487X[1], 13);
        int iM15113F25 = m15113F2(iM15113F2, iM15113F24, iM15113F23, iM15113F22, this.f19487X[10], 11);
        int iM15113F26 = m15113F2(iM15113F22, iM15113F25, iM15113F24, iM15113F23, this.f19487X[6], 9);
        int iM15113F27 = m15113F2(iM15113F23, iM15113F26, iM15113F25, iM15113F24, this.f19487X[15], 7);
        int iM15113F28 = m15113F2(iM15113F24, iM15113F27, iM15113F26, iM15113F25, this.f19487X[3], 15);
        int iM15113F29 = m15113F2(iM15113F25, iM15113F28, iM15113F27, iM15113F26, this.f19487X[12], 7);
        int iM15113F210 = m15113F2(iM15113F26, iM15113F29, iM15113F28, iM15113F27, this.f19487X[0], 12);
        int iM15113F211 = m15113F2(iM15113F27, iM15113F210, iM15113F29, iM15113F28, this.f19487X[9], 15);
        int iM15113F212 = m15113F2(iM15113F28, iM15113F211, iM15113F210, iM15113F29, this.f19487X[5], 9);
        int iM15113F213 = m15113F2(iM15113F29, iM15113F212, iM15113F211, iM15113F210, this.f19487X[2], 11);
        int iM15113F214 = m15113F2(iM15113F210, iM15113F213, iM15113F212, iM15113F211, this.f19487X[14], 7);
        int iM15113F215 = m15113F2(iM15113F211, iM15113F214, iM15113F213, iM15113F212, this.f19487X[11], 13);
        int iM15113F216 = m15113F2(iM15113F212, iM15113F215, iM15113F214, iM15113F213, this.f19487X[8], 12);
        int iM15114F3 = m15114F3(iM15113F213, iM15113F216, iM15113F215, iM15113F214, this.f19487X[3], 11);
        int iM15114F32 = m15114F3(iM15113F214, iM15114F3, iM15113F216, iM15113F215, this.f19487X[10], 13);
        int iM15114F33 = m15114F3(iM15113F215, iM15114F32, iM15114F3, iM15113F216, this.f19487X[14], 6);
        int iM15114F34 = m15114F3(iM15113F216, iM15114F33, iM15114F32, iM15114F3, this.f19487X[4], 7);
        int iM15114F35 = m15114F3(iM15114F3, iM15114F34, iM15114F33, iM15114F32, this.f19487X[9], 14);
        int iM15114F36 = m15114F3(iM15114F32, iM15114F35, iM15114F34, iM15114F33, this.f19487X[15], 9);
        int iM15114F37 = m15114F3(iM15114F33, iM15114F36, iM15114F35, iM15114F34, this.f19487X[8], 13);
        int iM15114F38 = m15114F3(iM15114F34, iM15114F37, iM15114F36, iM15114F35, this.f19487X[1], 15);
        int iM15114F39 = m15114F3(iM15114F35, iM15114F38, iM15114F37, iM15114F36, this.f19487X[2], 14);
        int iM15114F310 = m15114F3(iM15114F36, iM15114F39, iM15114F38, iM15114F37, this.f19487X[7], 8);
        int iM15114F311 = m15114F3(iM15114F37, iM15114F310, iM15114F39, iM15114F38, this.f19487X[0], 13);
        int iM15114F312 = m15114F3(iM15114F38, iM15114F311, iM15114F310, iM15114F39, this.f19487X[6], 6);
        int iM15114F313 = m15114F3(iM15114F39, iM15114F312, iM15114F311, iM15114F310, this.f19487X[13], 5);
        int iM15114F314 = m15114F3(iM15114F310, iM15114F313, iM15114F312, iM15114F311, this.f19487X[11], 12);
        int iM15114F315 = m15114F3(iM15114F311, iM15114F314, iM15114F313, iM15114F312, this.f19487X[5], 7);
        int iM15114F316 = m15114F3(iM15114F312, iM15114F315, iM15114F314, iM15114F313, this.f19487X[12], 5);
        int iM15115F4 = m15115F4(iM15114F313, iM15114F316, iM15114F315, iM15114F314, this.f19487X[1], 11);
        int iM15115F42 = m15115F4(iM15114F314, iM15115F4, iM15114F316, iM15114F315, this.f19487X[9], 12);
        int iM15115F43 = m15115F4(iM15114F315, iM15115F42, iM15115F4, iM15114F316, this.f19487X[11], 14);
        int iM15115F44 = m15115F4(iM15114F316, iM15115F43, iM15115F42, iM15115F4, this.f19487X[10], 15);
        int iM15115F45 = m15115F4(iM15115F4, iM15115F44, iM15115F43, iM15115F42, this.f19487X[0], 14);
        int iM15115F46 = m15115F4(iM15115F42, iM15115F45, iM15115F44, iM15115F43, this.f19487X[8], 15);
        int iM15115F47 = m15115F4(iM15115F43, iM15115F46, iM15115F45, iM15115F44, this.f19487X[12], 9);
        int iM15115F48 = m15115F4(iM15115F44, iM15115F47, iM15115F46, iM15115F45, this.f19487X[4], 8);
        int iM15115F49 = m15115F4(iM15115F45, iM15115F48, iM15115F47, iM15115F46, this.f19487X[13], 9);
        int iM15115F410 = m15115F4(iM15115F46, iM15115F49, iM15115F48, iM15115F47, this.f19487X[3], 14);
        int iM15115F411 = m15115F4(iM15115F47, iM15115F410, iM15115F49, iM15115F48, this.f19487X[7], 5);
        int iM15115F412 = m15115F4(iM15115F48, iM15115F411, iM15115F410, iM15115F49, this.f19487X[15], 6);
        int iM15115F413 = m15115F4(iM15115F49, iM15115F412, iM15115F411, iM15115F410, this.f19487X[14], 8);
        int iM15115F414 = m15115F4(iM15115F410, iM15115F413, iM15115F412, iM15115F411, this.f19487X[5], 6);
        int iM15115F415 = m15115F4(iM15115F411, iM15115F414, iM15115F413, iM15115F412, this.f19487X[6], 5);
        int iM15115F416 = m15115F4(iM15115F412, iM15115F415, iM15115F414, iM15115F413, this.f19487X[2], 12);
        int iM15119FF4 = m15119FF4(i, i2, i3, i4, this.f19487X[5], 8);
        int iM15119FF42 = m15119FF4(i4, iM15119FF4, i2, i3, this.f19487X[14], 9);
        int iM15119FF43 = m15119FF4(i3, iM15119FF42, iM15119FF4, i2, this.f19487X[7], 9);
        int iM15119FF44 = m15119FF4(i2, iM15119FF43, iM15119FF42, iM15119FF4, this.f19487X[0], 11);
        int iM15119FF45 = m15119FF4(iM15119FF4, iM15119FF44, iM15119FF43, iM15119FF42, this.f19487X[9], 13);
        int iM15119FF46 = m15119FF4(iM15119FF42, iM15119FF45, iM15119FF44, iM15119FF43, this.f19487X[2], 15);
        int iM15119FF47 = m15119FF4(iM15119FF43, iM15119FF46, iM15119FF45, iM15119FF44, this.f19487X[11], 15);
        int iM15119FF48 = m15119FF4(iM15119FF44, iM15119FF47, iM15119FF46, iM15119FF45, this.f19487X[4], 5);
        int iM15119FF49 = m15119FF4(iM15119FF45, iM15119FF48, iM15119FF47, iM15119FF46, this.f19487X[13], 7);
        int iM15119FF410 = m15119FF4(iM15119FF46, iM15119FF49, iM15119FF48, iM15119FF47, this.f19487X[6], 7);
        int iM15119FF411 = m15119FF4(iM15119FF47, iM15119FF410, iM15119FF49, iM15119FF48, this.f19487X[15], 8);
        int iM15119FF412 = m15119FF4(iM15119FF48, iM15119FF411, iM15119FF410, iM15119FF49, this.f19487X[8], 11);
        int iM15119FF413 = m15119FF4(iM15119FF49, iM15119FF412, iM15119FF411, iM15119FF410, this.f19487X[1], 14);
        int iM15119FF414 = m15119FF4(iM15119FF410, iM15119FF413, iM15119FF412, iM15119FF411, this.f19487X[10], 14);
        int iM15119FF415 = m15119FF4(iM15119FF411, iM15119FF414, iM15119FF413, iM15119FF412, this.f19487X[3], 12);
        int iM15119FF416 = m15119FF4(iM15119FF412, iM15119FF415, iM15119FF414, iM15119FF413, this.f19487X[12], 6);
        int iM15118FF3 = m15118FF3(iM15119FF413, iM15119FF416, iM15119FF415, iM15119FF414, this.f19487X[6], 9);
        int iM15118FF32 = m15118FF3(iM15119FF414, iM15118FF3, iM15119FF416, iM15119FF415, this.f19487X[11], 13);
        int iM15118FF33 = m15118FF3(iM15119FF415, iM15118FF32, iM15118FF3, iM15119FF416, this.f19487X[3], 15);
        int iM15118FF34 = m15118FF3(iM15119FF416, iM15118FF33, iM15118FF32, iM15118FF3, this.f19487X[7], 7);
        int iM15118FF35 = m15118FF3(iM15118FF3, iM15118FF34, iM15118FF33, iM15118FF32, this.f19487X[0], 12);
        int iM15118FF36 = m15118FF3(iM15118FF32, iM15118FF35, iM15118FF34, iM15118FF33, this.f19487X[13], 8);
        int iM15118FF37 = m15118FF3(iM15118FF33, iM15118FF36, iM15118FF35, iM15118FF34, this.f19487X[5], 9);
        int iM15118FF38 = m15118FF3(iM15118FF34, iM15118FF37, iM15118FF36, iM15118FF35, this.f19487X[10], 11);
        int iM15118FF39 = m15118FF3(iM15118FF35, iM15118FF38, iM15118FF37, iM15118FF36, this.f19487X[14], 7);
        int iM15118FF310 = m15118FF3(iM15118FF36, iM15118FF39, iM15118FF38, iM15118FF37, this.f19487X[15], 7);
        int iM15118FF311 = m15118FF3(iM15118FF37, iM15118FF310, iM15118FF39, iM15118FF38, this.f19487X[8], 12);
        int iM15118FF312 = m15118FF3(iM15118FF38, iM15118FF311, iM15118FF310, iM15118FF39, this.f19487X[12], 7);
        int iM15118FF313 = m15118FF3(iM15118FF39, iM15118FF312, iM15118FF311, iM15118FF310, this.f19487X[4], 6);
        int iM15118FF314 = m15118FF3(iM15118FF310, iM15118FF313, iM15118FF312, iM15118FF311, this.f19487X[9], 15);
        int iM15118FF315 = m15118FF3(iM15118FF311, iM15118FF314, iM15118FF313, iM15118FF312, this.f19487X[1], 13);
        int iM15118FF316 = m15118FF3(iM15118FF312, iM15118FF315, iM15118FF314, iM15118FF313, this.f19487X[2], 11);
        int iM15117FF2 = m15117FF2(iM15118FF313, iM15118FF316, iM15118FF315, iM15118FF314, this.f19487X[15], 9);
        int iM15117FF22 = m15117FF2(iM15118FF314, iM15117FF2, iM15118FF316, iM15118FF315, this.f19487X[5], 7);
        int iM15117FF23 = m15117FF2(iM15118FF315, iM15117FF22, iM15117FF2, iM15118FF316, this.f19487X[1], 15);
        int iM15117FF24 = m15117FF2(iM15118FF316, iM15117FF23, iM15117FF22, iM15117FF2, this.f19487X[3], 11);
        int iM15117FF25 = m15117FF2(iM15117FF2, iM15117FF24, iM15117FF23, iM15117FF22, this.f19487X[7], 8);
        int iM15117FF26 = m15117FF2(iM15117FF22, iM15117FF25, iM15117FF24, iM15117FF23, this.f19487X[14], 6);
        int iM15117FF27 = m15117FF2(iM15117FF23, iM15117FF26, iM15117FF25, iM15117FF24, this.f19487X[6], 6);
        int iM15117FF28 = m15117FF2(iM15117FF24, iM15117FF27, iM15117FF26, iM15117FF25, this.f19487X[9], 14);
        int iM15117FF29 = m15117FF2(iM15117FF25, iM15117FF28, iM15117FF27, iM15117FF26, this.f19487X[11], 12);
        int iM15117FF210 = m15117FF2(iM15117FF26, iM15117FF29, iM15117FF28, iM15117FF27, this.f19487X[8], 13);
        int iM15117FF211 = m15117FF2(iM15117FF27, iM15117FF210, iM15117FF29, iM15117FF28, this.f19487X[12], 5);
        int iM15117FF212 = m15117FF2(iM15117FF28, iM15117FF211, iM15117FF210, iM15117FF29, this.f19487X[2], 14);
        int iM15117FF213 = m15117FF2(iM15117FF29, iM15117FF212, iM15117FF211, iM15117FF210, this.f19487X[10], 13);
        int iM15117FF214 = m15117FF2(iM15117FF210, iM15117FF213, iM15117FF212, iM15117FF211, this.f19487X[0], 13);
        int iM15117FF215 = m15117FF2(iM15117FF211, iM15117FF214, iM15117FF213, iM15117FF212, this.f19487X[4], 7);
        int iM15117FF216 = m15117FF2(iM15117FF212, iM15117FF215, iM15117FF214, iM15117FF213, this.f19487X[13], 5);
        int iM15116FF1 = m15116FF1(iM15117FF213, iM15117FF216, iM15117FF215, iM15117FF214, this.f19487X[8], 15);
        int iM15116FF12 = m15116FF1(iM15117FF214, iM15116FF1, iM15117FF216, iM15117FF215, this.f19487X[6], 5);
        int iM15116FF13 = m15116FF1(iM15117FF215, iM15116FF12, iM15116FF1, iM15117FF216, this.f19487X[4], 8);
        int iM15116FF14 = m15116FF1(iM15117FF216, iM15116FF13, iM15116FF12, iM15116FF1, this.f19487X[1], 11);
        int iM15116FF15 = m15116FF1(iM15116FF1, iM15116FF14, iM15116FF13, iM15116FF12, this.f19487X[3], 14);
        int iM15116FF16 = m15116FF1(iM15116FF12, iM15116FF15, iM15116FF14, iM15116FF13, this.f19487X[11], 14);
        int iM15116FF17 = m15116FF1(iM15116FF13, iM15116FF16, iM15116FF15, iM15116FF14, this.f19487X[15], 6);
        int iM15116FF18 = m15116FF1(iM15116FF14, iM15116FF17, iM15116FF16, iM15116FF15, this.f19487X[0], 14);
        int iM15116FF19 = m15116FF1(iM15116FF15, iM15116FF18, iM15116FF17, iM15116FF16, this.f19487X[5], 6);
        int iM15116FF110 = m15116FF1(iM15116FF16, iM15116FF19, iM15116FF18, iM15116FF17, this.f19487X[12], 9);
        int iM15116FF111 = m15116FF1(iM15116FF17, iM15116FF110, iM15116FF19, iM15116FF18, this.f19487X[2], 12);
        int iM15116FF112 = m15116FF1(iM15116FF18, iM15116FF111, iM15116FF110, iM15116FF19, this.f19487X[13], 9);
        int iM15116FF113 = m15116FF1(iM15116FF19, iM15116FF112, iM15116FF111, iM15116FF110, this.f19487X[9], 12);
        int iM15116FF114 = m15116FF1(iM15116FF110, iM15116FF113, iM15116FF112, iM15116FF111, this.f19487X[7], 5);
        int iM15116FF115 = m15116FF1(iM15116FF111, iM15116FF114, iM15116FF113, iM15116FF112, this.f19487X[10], 15);
        int iM15116FF116 = m15116FF1(iM15116FF112, iM15116FF115, iM15116FF114, iM15116FF113, this.f19487X[14], 8);
        int i5 = iM15116FF114 + iM15115F415 + this.f19484H1;
        this.f19484H1 = this.f19485H2 + iM15115F414 + iM15116FF113;
        this.f19485H2 = this.f19486H3 + iM15115F413 + iM15116FF116;
        this.f19486H3 = this.f19483H0 + iM15115F416 + iM15116FF115;
        this.f19483H0 = i5;
        this.f19488xOff = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f19487X;
            if (i6 == iArr.length) {
                return;
            }
            iArr[i6] = 0;
            i6++;
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processLength(long j) {
        if (this.f19488xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f19487X;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f19487X;
        int i2 = this.f19488xOff;
        this.f19488xOff = i2 + 1;
        iArr[i2] = AbstractC6245Pack.littleEndianToInt(bArr, i);
        if (this.f19488xOff == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GeneralDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19483H0 = 1732584193;
        this.f19484H1 = -271733879;
        this.f19485H2 = -1732584194;
        this.f19486H3 = 271733878;
        this.f19488xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f19487X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD128Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.f19487X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 128, cryptoServicePurpose));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15121copyIn((RIPEMD128Digest) memoable);
    }

    public RIPEMD128Digest(RIPEMD128Digest rIPEMD128Digest) {
        super(rIPEMD128Digest.f19390purpose);
        this.f19487X = new int[16];
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 128, this.f19390purpose));
        m15121copyIn(rIPEMD128Digest);
    }
}
