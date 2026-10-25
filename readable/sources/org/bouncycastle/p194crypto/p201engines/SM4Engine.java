package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class SM4Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: X */
    private final int[] f20075X = new int[4];

    /* renamed from: rk */
    private int[] f20076rk;

    /* renamed from: Sbox */
    private static final byte[] f20074Sbox = {-42, -112, -23, -2, -52, -31, C1217Base64.padSymbol, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, ByteCompanionObject.MIN_VALUE, -33, -108, -6, 117, -113, C5066Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, ByteCompanionObject.MAX_VALUE, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: CK */
    private static final int[] f20072CK = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    /* renamed from: FK */
    private static final int[] f20073FK = {-1548633402, 1453994832, 1736282519, -1301273892};

    /* renamed from: F0 */
    private int m15399F0(int[] iArr, int i) {
        return m15405T((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i) ^ iArr[0];
    }

    /* renamed from: F1 */
    private int m15400F1(int[] iArr, int i) {
        return m15405T((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i) ^ iArr[1];
    }

    /* renamed from: F2 */
    private int m15401F2(int[] iArr, int i) {
        return m15405T((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i) ^ iArr[2];
    }

    /* renamed from: F3 */
    private int m15402F3(int[] iArr, int i) {
        return m15405T((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i) ^ iArr[3];
    }

    /* renamed from: L */
    private int m15403L(int i) {
        return rotateLeft(i, 24) ^ (((rotateLeft(i, 2) ^ i) ^ rotateLeft(i, 10)) ^ rotateLeft(i, 18));
    }

    /* renamed from: L_ap */
    private int m15404L_ap(int i) {
        return rotateLeft(i, 23) ^ (rotateLeft(i, 13) ^ i);
    }

    /* renamed from: T */
    private int m15405T(int i) {
        return m15403L(m15407tau(i));
    }

    /* renamed from: T_ap */
    private int m15406T_ap(int i) {
        return m15404L_ap(m15407tau(i));
    }

    private int[] expandKey(boolean z, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {AbstractC6245Pack.bigEndianToInt(bArr, 0), AbstractC6245Pack.bigEndianToInt(bArr, 4), AbstractC6245Pack.bigEndianToInt(bArr, 8), AbstractC6245Pack.bigEndianToInt(bArr, 12)};
        int i = iArr2[0];
        int[] iArr3 = f20073FK;
        int[] iArr4 = {i ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z) {
            int i2 = iArr4[0];
            int i3 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr5 = f20072CK;
            int iM15406T_ap = i2 ^ m15406T_ap(i3 ^ iArr5[0]);
            iArr[0] = iM15406T_ap;
            int iM15406T_ap2 = m15406T_ap((iM15406T_ap ^ (iArr4[2] ^ iArr4[3])) ^ iArr5[1]) ^ iArr4[1];
            iArr[1] = iM15406T_ap2;
            int iM15406T_ap3 = m15406T_ap((iM15406T_ap2 ^ (iArr4[3] ^ iArr[0])) ^ iArr5[2]) ^ iArr4[2];
            iArr[2] = iM15406T_ap3;
            iArr[3] = m15406T_ap((iM15406T_ap3 ^ (iArr[0] ^ iArr[1])) ^ iArr5[3]) ^ iArr4[3];
            for (int i4 = 4; i4 < 32; i4++) {
                iArr[i4] = iArr[i4 - 4] ^ m15406T_ap(((iArr[i4 - 3] ^ iArr[i4 - 2]) ^ iArr[i4 - 1]) ^ f20072CK[i4]);
            }
        } else {
            int i5 = iArr4[0];
            int i6 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr6 = f20072CK;
            int iM15406T_ap4 = i5 ^ m15406T_ap(i6 ^ iArr6[0]);
            iArr[31] = iM15406T_ap4;
            int iM15406T_ap5 = m15406T_ap((iM15406T_ap4 ^ (iArr4[2] ^ iArr4[3])) ^ iArr6[1]) ^ iArr4[1];
            iArr[30] = iM15406T_ap5;
            int iM15406T_ap6 = m15406T_ap((iM15406T_ap5 ^ (iArr4[3] ^ iArr[31])) ^ iArr6[2]) ^ iArr4[2];
            iArr[29] = iM15406T_ap6;
            iArr[28] = m15406T_ap((iM15406T_ap6 ^ (iArr[31] ^ iArr[30])) ^ iArr6[3]) ^ iArr4[3];
            for (int i7 = 27; i7 >= 0; i7--) {
                iArr[i7] = iArr[i7 + 4] ^ m15406T_ap(((iArr[i7 + 3] ^ iArr[i7 + 2]) ^ iArr[i7 + 1]) ^ f20072CK[31 - i7]);
            }
        }
        return iArr;
    }

    private int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (-i2));
    }

    /* renamed from: tau */
    private int m15407tau(int i) {
        byte[] bArr = f20074Sbox;
        return (bArr[i & 255] & C1126UByte.MAX_VALUE) | ((bArr[(i >> 24) & 255] & C1126UByte.MAX_VALUE) << 24) | ((bArr[(i >> 16) & 255] & C1126UByte.MAX_VALUE) << 16) | ((bArr[(i >> 8) & 255] & C1126UByte.MAX_VALUE) << 8);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "SM4";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        if (bArrM15773getKey.length != 16) {
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        this.f20076rk = expandKey(z, bArrM15773getKey);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f20076rk == null) {
            throw new IllegalStateException("SM4 not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f20075X[0] = AbstractC6245Pack.bigEndianToInt(bArr, i);
        this.f20075X[1] = AbstractC6245Pack.bigEndianToInt(bArr, i + 4);
        this.f20075X[2] = AbstractC6245Pack.bigEndianToInt(bArr, i + 8);
        this.f20075X[3] = AbstractC6245Pack.bigEndianToInt(bArr, i + 12);
        for (int i3 = 0; i3 < 32; i3 += 4) {
            int[] iArr = this.f20075X;
            iArr[0] = m15399F0(iArr, this.f20076rk[i3]);
            int[] iArr2 = this.f20075X;
            iArr2[1] = m15400F1(iArr2, this.f20076rk[i3 + 1]);
            int[] iArr3 = this.f20075X;
            iArr3[2] = m15401F2(iArr3, this.f20076rk[i3 + 2]);
            int[] iArr4 = this.f20075X;
            iArr4[3] = m15402F3(iArr4, this.f20076rk[i3 + 3]);
        }
        AbstractC6245Pack.intToBigEndian(this.f20075X[3], bArr2, i2);
        AbstractC6245Pack.intToBigEndian(this.f20075X[2], bArr2, i2 + 4);
        AbstractC6245Pack.intToBigEndian(this.f20075X[1], bArr2, i2 + 8);
        AbstractC6245Pack.intToBigEndian(this.f20075X[0], bArr2, i2 + 12);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
