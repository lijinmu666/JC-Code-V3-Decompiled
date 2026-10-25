package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class Zuc128CoreEngine implements StreamCipher, Memoable {

    /* renamed from: BRC */
    private final int[] f20172BRC;

    /* renamed from: F */
    private final int[] f20173F;

    /* renamed from: LFSR */
    private final int[] f20174LFSR;
    private final byte[] keyStream;
    private int theIndex;
    private int theIterations;
    private Zuc128CoreEngine theResetState;

    /* renamed from: S0 */
    private static final byte[] f20170S0 = {62, 114, 91, 71, -54, -32, 0, 51, 4, -47, 84, -104, 9, -71, 109, -53, 123, 27, -7, 50, -81, -99, 106, -91, -72, 45, -4, 29, 8, 83, 3, -112, 77, 78, -124, -103, -28, -50, -39, -111, -35, -74, -123, 72, -117, 41, 110, -84, -51, -63, -8, 30, 115, 67, 105, -58, -75, -67, -3, 57, 99, 32, -44, 56, 118, 125, -78, -89, -49, -19, 87, -59, -13, 44, -69, 20, 33, 6, 85, -101, -29, -17, 94, 49, 79, ByteCompanionObject.MAX_VALUE, 90, -92, 13, -126, 81, 73, 95, -70, 88, 28, 74, 22, -43, 23, -88, -110, 36, 31, -116, -1, -40, -82, 46, 1, -45, -83, 59, 75, -38, 70, -21, -55, -34, -102, -113, -121, -41, 58, ByteCompanionObject.MIN_VALUE, 111, 47, -56, -79, -76, 55, -9, 10, 34, 19, 40, 124, -52, 60, -119, -57, -61, -106, 86, 7, -65, 126, -16, 11, 43, -105, 82, 53, 65, 121, 97, -90, 76, 16, -2, PSSSigner.TRAILER_IMPLICIT, 38, -107, -120, -118, -80, -93, -5, -64, 24, -108, -14, -31, -27, -23, 93, -48, -36, 17, 102, 100, 92, -20, 89, 66, 117, 18, -11, 116, -100, -86, 35, 14, -122, -85, -66, 42, 2, -25, 103, -26, 68, -94, 108, -62, -109, -97, -15, -10, -6, 54, -46, 80, 104, -98, 98, 113, 21, C1217Base64.padSymbol, -42, 64, -60, -30, 15, -114, -125, 119, 107, 37, 5, C5066Utf8.REPLACEMENT_BYTE, 12, 48, -22, 112, -73, -95, -24, -87, 101, -115, 39, 26, -37, -127, -77, -96, -12, 69, 122, 25, -33, -18, 120, 52, 96};

    /* renamed from: S1 */
    private static final byte[] f20171S1 = {85, -62, 99, 113, 59, -56, 71, -122, -97, 60, -38, 91, 41, -86, -3, 119, -116, -59, -108, 12, -90, 26, 19, 0, -29, -88, 22, 114, 64, -7, -8, 66, 68, 38, 104, -106, -127, -39, 69, 62, 16, 118, -58, -89, -117, 57, 67, -31, 58, -75, 86, 42, -64, 109, -77, 5, 34, 102, -65, -36, 11, -6, 98, 72, -35, 32, 17, 6, 54, -55, -63, -49, -10, 39, 82, -69, 105, -11, -44, -121, ByteCompanionObject.MAX_VALUE, -124, 76, -46, -100, 87, -92, PSSSigner.TRAILER_IMPLICIT, 79, -102, -33, -2, -42, -115, 122, -21, 43, 83, -40, 92, -95, 20, 23, -5, 35, -43, 125, 48, 103, 115, 8, 9, -18, -73, 112, C5066Utf8.REPLACEMENT_BYTE, 97, -78, 25, -114, 78, -27, 75, -109, -113, 93, -37, -87, -83, -15, -82, 46, -53, 13, -4, -12, 45, 70, 110, 29, -105, -24, -47, -23, 77, 55, -91, 117, 94, -125, -98, -85, -126, -99, -71, 28, -32, -51, 73, -119, 1, -74, -67, 88, 36, -94, 95, 56, 120, -103, 21, -112, 80, -72, -107, -28, -48, -111, -57, -50, -19, 15, -76, 111, -96, -52, -16, 2, 74, 121, -61, -34, -93, -17, -22, 81, -26, 107, 24, -20, 27, 44, ByteCompanionObject.MIN_VALUE, -9, 116, -25, -1, 33, 90, 106, 84, 30, 65, 49, -110, 53, -60, 51, 7, 10, -70, 126, 14, 52, -120, -79, -104, 124, -13, C1217Base64.padSymbol, 96, 108, 123, -54, -45, 31, 50, 101, 4, 40, 100, -66, -123, -101, 47, 89, -118, -41, -80, 37, -84, -81, 18, 3, -30, -14};

    /* renamed from: EK_d */
    private static final short[] f20169EK_d = {17623, 9916, 25195, 4958, 22409, 13794, 28981, 2479, 19832, 12051, 27588, 6897, 24102, 15437, 30874, 18348};

    public Zuc128CoreEngine() {
        this.f20174LFSR = new int[16];
        this.f20173F = new int[2];
        this.f20172BRC = new int[4];
        this.keyStream = new byte[4];
    }

    /* renamed from: AddM */
    private int m15456AddM(int i, int i2) {
        int i3 = i + i2;
        return (Integer.MAX_VALUE & i3) + (i3 >>> 31);
    }

    private void BitReorganization() {
        int[] iArr = this.f20172BRC;
        int[] iArr2 = this.f20174LFSR;
        iArr[0] = ((iArr2[15] & 2147450880) << 1) | (iArr2[14] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
        iArr[1] = ((iArr2[11] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) << 16) | (iArr2[9] >>> 15);
        iArr[2] = ((iArr2[7] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) << 16) | (iArr2[5] >>> 15);
        iArr[3] = (iArr2[0] >>> 15) | ((iArr2[2] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) << 16);
    }

    /* renamed from: L1 */
    private static int m15457L1(int i) {
        return m15461ROT(i, 24) ^ (((m15461ROT(i, 2) ^ i) ^ m15461ROT(i, 10)) ^ m15461ROT(i, 18));
    }

    /* renamed from: L2 */
    private static int m15458L2(int i) {
        return m15461ROT(i, 30) ^ (((m15461ROT(i, 8) ^ i) ^ m15461ROT(i, 14)) ^ m15461ROT(i, 22));
    }

    private void LFSRWithInitialisationMode(int i) {
        int i2 = this.f20174LFSR[0];
        int iM15456AddM = m15456AddM(m15456AddM(m15456AddM(m15456AddM(m15456AddM(m15456AddM(i2, MulByPow2(i2, 8)), MulByPow2(this.f20174LFSR[4], 20)), MulByPow2(this.f20174LFSR[10], 21)), MulByPow2(this.f20174LFSR[13], 17)), MulByPow2(this.f20174LFSR[15], 15)), i);
        int[] iArr = this.f20174LFSR;
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = iArr[5];
        iArr[5] = iArr[6];
        iArr[6] = iArr[7];
        iArr[7] = iArr[8];
        iArr[8] = iArr[9];
        iArr[9] = iArr[10];
        iArr[10] = iArr[11];
        iArr[11] = iArr[12];
        iArr[12] = iArr[13];
        iArr[13] = iArr[14];
        iArr[14] = iArr[15];
        iArr[15] = iM15456AddM;
    }

    private void LFSRWithWorkMode() {
        int i = this.f20174LFSR[0];
        int iM15456AddM = m15456AddM(m15456AddM(m15456AddM(m15456AddM(m15456AddM(i, MulByPow2(i, 8)), MulByPow2(this.f20174LFSR[4], 20)), MulByPow2(this.f20174LFSR[10], 21)), MulByPow2(this.f20174LFSR[13], 17)), MulByPow2(this.f20174LFSR[15], 15));
        int[] iArr = this.f20174LFSR;
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = iArr[5];
        iArr[5] = iArr[6];
        iArr[6] = iArr[7];
        iArr[7] = iArr[8];
        iArr[8] = iArr[9];
        iArr[9] = iArr[10];
        iArr[10] = iArr[11];
        iArr[11] = iArr[12];
        iArr[12] = iArr[13];
        iArr[13] = iArr[14];
        iArr[14] = iArr[15];
        iArr[15] = iM15456AddM;
    }

    /* renamed from: MAKEU31 */
    private static int m15459MAKEU31(byte b, short s, byte b2) {
        return ((b & C1126UByte.MAX_VALUE) << 23) | ((s & 65535) << 8) | (b2 & C1126UByte.MAX_VALUE);
    }

    /* renamed from: MAKEU32 */
    private static int m15460MAKEU32(byte b, byte b2, byte b3, byte b4) {
        return ((b & C1126UByte.MAX_VALUE) << 24) | ((b2 & C1126UByte.MAX_VALUE) << 16) | ((b3 & C1126UByte.MAX_VALUE) << 8) | (b4 & C1126UByte.MAX_VALUE);
    }

    private static int MulByPow2(int i, int i2) {
        return ((i >>> (31 - i2)) | (i << i2)) & Integer.MAX_VALUE;
    }

    /* renamed from: ROT */
    public static int m15461ROT(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public static void encode32be(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    private void makeKeyStream() {
        encode32be(makeKeyStreamWord(), this.keyStream, 0);
    }

    private void setKeyAndIV(byte[] bArr, byte[] bArr2) {
        setKeyAndIV(this.f20174LFSR, bArr, bArr2);
        int[] iArr = this.f20173F;
        iArr[0] = 0;
        iArr[1] = 0;
        int i = 32;
        while (true) {
            BitReorganization();
            if (i <= 0) {
                m15462F();
                LFSRWithWorkMode();
                return;
            } else {
                LFSRWithInitialisationMode(m15462F() >>> 1);
                i--;
            }
        }
    }

    /* renamed from: F */
    public int m15462F() {
        int[] iArr = this.f20172BRC;
        int i = iArr[0];
        int[] iArr2 = this.f20173F;
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        int i4 = (i ^ i2) + i3;
        int i5 = i2 + iArr[1];
        int i6 = iArr[2] ^ i3;
        int iM15457L1 = m15457L1((i5 << 16) | (i6 >>> 16));
        int iM15458L2 = m15458L2((i6 << 16) | (i5 >>> 16));
        int[] iArr3 = this.f20173F;
        byte[] bArr = f20170S0;
        byte b = bArr[iM15457L1 >>> 24];
        byte[] bArr2 = f20171S1;
        iArr3[0] = m15460MAKEU32(b, bArr2[(iM15457L1 >>> 16) & 255], bArr[(iM15457L1 >>> 8) & 255], bArr2[iM15457L1 & 255]);
        this.f20173F[1] = m15460MAKEU32(bArr[iM15458L2 >>> 24], bArr2[(iM15458L2 >>> 16) & 255], bArr[(iM15458L2 >>> 8) & 255], bArr2[iM15458L2 & 255]);
        return i4;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new Zuc128CoreEngine(this);
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "Zuc-128";
    }

    public int getMaxIterations() {
        return 2047;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        byte[] bArrM15801getIV;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            parameters = parametersWithIV.getParameters();
        } else {
            parameters = cipherParameters;
            bArrM15801getIV = null;
        }
        byte[] bArrM15773getKey = parameters instanceof KeyParameter ? ((KeyParameter) parameters).m15773getKey() : null;
        this.theIndex = 0;
        this.theIterations = 0;
        setKeyAndIV(bArrM15773getKey, bArrM15801getIV);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bArrM15773getKey.length * 8, cipherParameters, z ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION));
        this.theResetState = (Zuc128CoreEngine) mo14823copy();
    }

    public int makeKeyStreamWord() {
        int i = this.theIterations;
        this.theIterations = i + 1;
        if (i >= getMaxIterations()) {
            throw new IllegalStateException("Too much data processed by singleKey/IV");
        }
        BitReorganization();
        int iM15462F = m15462F() ^ this.f20172BRC[3];
        LFSRWithWorkMode();
        return iM15462F;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.theResetState == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4 + i3] = returnByte(bArr[i4 + i]);
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        Zuc128CoreEngine zuc128CoreEngine = this.theResetState;
        if (zuc128CoreEngine != null) {
            mo14824reset(zuc128CoreEngine);
        }
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        if (this.theIndex == 0) {
            makeKeyStream();
        }
        byte[] bArr = this.keyStream;
        int i = this.theIndex;
        byte b2 = (byte) (b ^ bArr[i]);
        this.theIndex = (i + 1) % 4;
        return b2;
    }

    public Zuc128CoreEngine(Zuc128CoreEngine zuc128CoreEngine) {
        this.f20174LFSR = new int[16];
        this.f20173F = new int[2];
        this.f20172BRC = new int[4];
        this.keyStream = new byte[4];
        mo14824reset(zuc128CoreEngine);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        Zuc128CoreEngine zuc128CoreEngine = (Zuc128CoreEngine) memoable;
        int[] iArr = zuc128CoreEngine.f20174LFSR;
        int[] iArr2 = this.f20174LFSR;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = zuc128CoreEngine.f20173F;
        int[] iArr4 = this.f20173F;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = zuc128CoreEngine.f20172BRC;
        int[] iArr6 = this.f20172BRC;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        byte[] bArr = zuc128CoreEngine.keyStream;
        byte[] bArr2 = this.keyStream;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.theIndex = zuc128CoreEngine.theIndex;
        this.theIterations = zuc128CoreEngine.theIterations;
        this.theResetState = zuc128CoreEngine;
    }

    public void setKeyAndIV(int[] iArr, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("A key of 16 bytes is needed");
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("An IV of 16 bytes is needed");
        }
        int[] iArr2 = this.f20174LFSR;
        byte b = bArr[0];
        short[] sArr = f20169EK_d;
        iArr2[0] = m15459MAKEU31(b, sArr[0], bArr2[0]);
        this.f20174LFSR[1] = m15459MAKEU31(bArr[1], sArr[1], bArr2[1]);
        this.f20174LFSR[2] = m15459MAKEU31(bArr[2], sArr[2], bArr2[2]);
        this.f20174LFSR[3] = m15459MAKEU31(bArr[3], sArr[3], bArr2[3]);
        this.f20174LFSR[4] = m15459MAKEU31(bArr[4], sArr[4], bArr2[4]);
        this.f20174LFSR[5] = m15459MAKEU31(bArr[5], sArr[5], bArr2[5]);
        this.f20174LFSR[6] = m15459MAKEU31(bArr[6], sArr[6], bArr2[6]);
        this.f20174LFSR[7] = m15459MAKEU31(bArr[7], sArr[7], bArr2[7]);
        this.f20174LFSR[8] = m15459MAKEU31(bArr[8], sArr[8], bArr2[8]);
        this.f20174LFSR[9] = m15459MAKEU31(bArr[9], sArr[9], bArr2[9]);
        this.f20174LFSR[10] = m15459MAKEU31(bArr[10], sArr[10], bArr2[10]);
        this.f20174LFSR[11] = m15459MAKEU31(bArr[11], sArr[11], bArr2[11]);
        this.f20174LFSR[12] = m15459MAKEU31(bArr[12], sArr[12], bArr2[12]);
        this.f20174LFSR[13] = m15459MAKEU31(bArr[13], sArr[13], bArr2[13]);
        this.f20174LFSR[14] = m15459MAKEU31(bArr[14], sArr[14], bArr2[14]);
        this.f20174LFSR[15] = m15459MAKEU31(bArr[15], sArr[15], bArr2[15]);
    }
}
