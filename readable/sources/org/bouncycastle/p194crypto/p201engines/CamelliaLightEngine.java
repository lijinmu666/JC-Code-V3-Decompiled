package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class CamelliaLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: MASK8 */
    private static final int f19779MASK8 = 255;
    private int _keySize;
    private boolean forEncryption;

    /* renamed from: SIGMA */
    private static final int[] f19781SIGMA = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};

    /* renamed from: SBOX1 */
    private static final byte[] f19780SBOX1 = {112, -126, 44, -20, -77, 39, -64, -27, -28, -123, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, 25, -91, 33, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, 31, -50, 62, 48, -36, 95, 94, -59, 11, 26, -90, -31, 57, -54, -43, 71, 93, C1217Base64.padSymbol, -39, 1, 90, -42, 81, 86, 108, 77, -117, 13, -102, 102, -5, -52, -80, 45, 116, 18, 43, 32, -16, -79, -124, -103, -33, 76, -53, -62, 52, 126, 118, 5, 109, -73, -87, 49, -47, 23, 4, -41, 20, 88, 58, 97, -34, 27, 17, 28, 50, 15, -100, 22, 83, 24, -14, 34, -2, 68, -49, -78, -61, -75, 122, -111, 36, 8, -24, -88, 96, -4, 105, 80, -86, -48, -96, 125, -95, -119, 98, -105, 84, 91, 30, -107, -32, -1, 100, -46, 16, -60, 0, 72, -93, -9, 117, -37, -118, 3, -26, -38, 9, C5066Utf8.REPLACEMENT_BYTE, -35, -108, -121, 92, -125, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, ByteCompanionObject.MAX_VALUE, -65, -30, 82, -101, -40, 38, -56, 55, -58, 59, -127, -106, 111, 75, 19, -66, 99, 46, -23, 121, -89, -116, -97, 110, PSSSigner.TRAILER_IMPLICIT, -114, 41, -11, -7, -74, 47, -3, -76, 89, 120, -104, 6, 106, -25, 70, 113, -70, -44, 37, -85, 66, -120, -94, -115, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, 42, 104, 60, 56, -15, -92, 64, 40, -45, 123, -69, -55, 67, -63, 21, -29, -83, -12, 119, -57, ByteCompanionObject.MIN_VALUE, -98};
    private boolean initialized = false;

    /* renamed from: subkey */
    private int[] f19784subkey = new int[96];

    /* renamed from: kw */
    private int[] f19783kw = new int[8];

    /* renamed from: ke */
    private int[] f19782ke = new int[12];

    public CamelliaLightEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bitsOfSecurity()));
    }

    private int bitsOfSecurity() {
        return this._keySize * 8;
    }

    private int bytes2int(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & C1126UByte.MAX_VALUE);
        }
        return i2;
    }

    private void camelliaF2(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0] ^ iArr2[i];
        int iM15281sbox4 = m15281sbox4(i2 & 255) | (m15280sbox3((i2 >>> 8) & 255) << 8) | (m15279sbox2((i2 >>> 16) & 255) << 16);
        byte[] bArr = f19780SBOX1;
        int i3 = ((bArr[(i2 >>> 24) & 255] & C1126UByte.MAX_VALUE) << 24) | iM15281sbox4;
        int i4 = iArr[1] ^ iArr2[i + 1];
        int iLeftRotate = leftRotate((m15279sbox2((i4 >>> 24) & 255) << 24) | (bArr[i4 & 255] & C1126UByte.MAX_VALUE) | (m15281sbox4((i4 >>> 8) & 255) << 8) | (m15280sbox3((i4 >>> 16) & 255) << 16), 8);
        int i5 = i3 ^ iLeftRotate;
        int iLeftRotate2 = leftRotate(iLeftRotate, 8) ^ i5;
        int iRightRotate = rightRotate(i5, 8) ^ iLeftRotate2;
        iArr[2] = (leftRotate(iLeftRotate2, 16) ^ iRightRotate) ^ iArr[2];
        iArr[3] = leftRotate(iRightRotate, 8) ^ iArr[3];
        int i6 = iArr[2] ^ iArr2[i + 2];
        int iM15281sbox42 = ((bArr[(i6 >>> 24) & 255] & C1126UByte.MAX_VALUE) << 24) | m15281sbox4(i6 & 255) | (m15280sbox3((i6 >>> 8) & 255) << 8) | (m15279sbox2((i6 >>> 16) & 255) << 16);
        int i7 = iArr2[i + 3] ^ iArr[3];
        int iLeftRotate3 = leftRotate((m15279sbox2((i7 >>> 24) & 255) << 24) | (bArr[i7 & 255] & C1126UByte.MAX_VALUE) | (m15281sbox4((i7 >>> 8) & 255) << 8) | (m15280sbox3((i7 >>> 16) & 255) << 16), 8);
        int i8 = iM15281sbox42 ^ iLeftRotate3;
        int iLeftRotate4 = leftRotate(iLeftRotate3, 8) ^ i8;
        int iRightRotate2 = rightRotate(i8, 8) ^ iLeftRotate4;
        iArr[0] = (leftRotate(iLeftRotate4, 16) ^ iRightRotate2) ^ iArr[0];
        iArr[1] = iArr[1] ^ leftRotate(iRightRotate2, 8);
    }

    private void camelliaFLs(int[] iArr, int[] iArr2, int i) {
        int iLeftRotate = iArr[1] ^ leftRotate(iArr[0] & iArr2[i], 1);
        iArr[1] = iLeftRotate;
        iArr[0] = (iLeftRotate | iArr2[i + 1]) ^ iArr[0];
        int i2 = iArr[2];
        int i3 = iArr2[i + 3];
        int i4 = iArr[3];
        int i5 = i2 ^ (i3 | i4);
        iArr[2] = i5;
        iArr[3] = leftRotate(iArr2[i + 2] & i5, 1) ^ i4;
    }

    private static void decroldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = 32 - i;
        iArr2[i4] = (iArr[i2] << i) | (iArr[i5] >>> i6);
        int i7 = i3 + 3;
        int i8 = i2 + 2;
        iArr2[i7] = (iArr[i5] << i) | (iArr[i8] >>> i6);
        int i9 = i2 + 3;
        iArr2[i3] = (iArr[i8] << i) | (iArr[i9] >>> i6);
        int i10 = i3 + 1;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i2] >>> i6);
        iArr[i2] = iArr2[i4];
        iArr[i5] = iArr2[i7];
        iArr[i8] = iArr2[i3];
        iArr[i9] = iArr2[i10];
    }

    private static void decroldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 3;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        iArr2[i3] = (iArr[i10] << i6) | (iArr[i2] >>> i8);
        int i11 = i3 + 1;
        iArr2[i11] = (iArr[i5] >>> i8) | (iArr[i2] << i6);
        iArr[i2] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i3];
        iArr[i10] = iArr2[i11];
    }

    private void int2bytes(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    /* renamed from: lRot8 */
    private byte m15277lRot8(byte b, int i) {
        return (byte) ((b << i) | ((b & 255) >>> (8 - i)));
    }

    private static int leftRotate(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    private int processBlock128(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = bytes2int(bArr, (i3 * 4) + i) ^ this.f19783kw[i3];
        }
        camelliaF2(iArr, this.f19784subkey, 0);
        camelliaF2(iArr, this.f19784subkey, 4);
        camelliaF2(iArr, this.f19784subkey, 8);
        camelliaFLs(iArr, this.f19782ke, 0);
        camelliaF2(iArr, this.f19784subkey, 12);
        camelliaF2(iArr, this.f19784subkey, 16);
        camelliaF2(iArr, this.f19784subkey, 20);
        camelliaFLs(iArr, this.f19782ke, 4);
        camelliaF2(iArr, this.f19784subkey, 24);
        camelliaF2(iArr, this.f19784subkey, 28);
        camelliaF2(iArr, this.f19784subkey, 32);
        int i4 = iArr[2];
        int[] iArr2 = this.f19783kw;
        int i5 = iArr2[4] ^ i4;
        iArr[2] = i5;
        iArr[3] = iArr[3] ^ iArr2[5];
        iArr[0] = iArr[0] ^ iArr2[6];
        iArr[1] = iArr2[7] ^ iArr[1];
        int2bytes(i5, bArr2, i2);
        int2bytes(iArr[3], bArr2, i2 + 4);
        int2bytes(iArr[0], bArr2, i2 + 8);
        int2bytes(iArr[1], bArr2, i2 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = bytes2int(bArr, (i3 * 4) + i) ^ this.f19783kw[i3];
        }
        camelliaF2(iArr, this.f19784subkey, 0);
        camelliaF2(iArr, this.f19784subkey, 4);
        camelliaF2(iArr, this.f19784subkey, 8);
        camelliaFLs(iArr, this.f19782ke, 0);
        camelliaF2(iArr, this.f19784subkey, 12);
        camelliaF2(iArr, this.f19784subkey, 16);
        camelliaF2(iArr, this.f19784subkey, 20);
        camelliaFLs(iArr, this.f19782ke, 4);
        camelliaF2(iArr, this.f19784subkey, 24);
        camelliaF2(iArr, this.f19784subkey, 28);
        camelliaF2(iArr, this.f19784subkey, 32);
        camelliaFLs(iArr, this.f19782ke, 8);
        camelliaF2(iArr, this.f19784subkey, 36);
        camelliaF2(iArr, this.f19784subkey, 40);
        camelliaF2(iArr, this.f19784subkey, 44);
        int i4 = iArr[2];
        int[] iArr2 = this.f19783kw;
        int i5 = i4 ^ iArr2[4];
        iArr[2] = i5;
        iArr[3] = iArr[3] ^ iArr2[5];
        iArr[0] = iArr[0] ^ iArr2[6];
        iArr[1] = iArr2[7] ^ iArr[1];
        int2bytes(i5, bArr2, i2);
        int2bytes(iArr[3], bArr2, i2 + 4);
        int2bytes(iArr[0], bArr2, i2 + 8);
        int2bytes(iArr[1], bArr2, i2 + 12);
        return 16;
    }

    private static int rightRotate(int i, int i2) {
        return (i >>> i2) + (i << (32 - i2));
    }

    /* renamed from: roldq */
    private static void m15278roldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = 32 - i;
        iArr2[i3] = (iArr[i2] << i) | (iArr[i4] >>> i5);
        int i6 = i3 + 1;
        int i7 = i2 + 2;
        iArr2[i6] = (iArr[i4] << i) | (iArr[i7] >>> i5);
        int i8 = i3 + 2;
        int i9 = i2 + 3;
        iArr2[i8] = (iArr[i7] << i) | (iArr[i9] >>> i5);
        int i10 = i3 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i2] >>> i5);
        iArr[i2] = iArr2[i3];
        iArr[i4] = iArr2[i6];
        iArr[i7] = iArr2[i8];
        iArr[i9] = iArr2[i10];
    }

    private static void roldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i - 32;
        int i6 = i2 + 2;
        int i7 = 64 - i;
        iArr2[i3] = (iArr[i4] << i5) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 3;
        iArr2[i8] = (iArr[i6] << i5) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        iArr2[i10] = (iArr[i9] << i5) | (iArr[i2] >>> i7);
        int i11 = i3 + 3;
        iArr2[i11] = (iArr[i4] >>> i7) | (iArr[i2] << i5);
        iArr[i2] = iArr2[i3];
        iArr[i4] = iArr2[i8];
        iArr[i6] = iArr2[i10];
        iArr[i9] = iArr2[i11];
    }

    /* renamed from: sbox2 */
    private int m15279sbox2(int i) {
        return m15277lRot8(f19780SBOX1[i], 1) & C1126UByte.MAX_VALUE;
    }

    /* renamed from: sbox3 */
    private int m15280sbox3(int i) {
        return m15277lRot8(f19780SBOX1[i], 7) & C1126UByte.MAX_VALUE;
    }

    /* renamed from: sbox4 */
    private int m15281sbox4(int i) {
        return f19780SBOX1[m15277lRot8((byte) i, 1) & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE;
    }

    /* renamed from: setKey */
    private void m15282setKey(boolean z, byte[] bArr) {
        this.forEncryption = z;
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        this._keySize = bArr.length;
        int length = bArr.length;
        if (length == 16) {
            iArr[0] = bytes2int(bArr, 0);
            iArr[1] = bytes2int(bArr, 4);
            iArr[2] = bytes2int(bArr, 8);
            iArr[3] = bytes2int(bArr, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        } else if (length == 24) {
            iArr[0] = bytes2int(bArr, 0);
            iArr[1] = bytes2int(bArr, 4);
            iArr[2] = bytes2int(bArr, 8);
            iArr[3] = bytes2int(bArr, 12);
            iArr[4] = bytes2int(bArr, 16);
            int iBytes2int = bytes2int(bArr, 20);
            iArr[5] = iBytes2int;
            iArr[6] = ~iArr[4];
            iArr[7] = ~iBytes2int;
        } else {
            if (length != 32) {
                throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
            }
            iArr[0] = bytes2int(bArr, 0);
            iArr[1] = bytes2int(bArr, 4);
            iArr[2] = bytes2int(bArr, 8);
            iArr[3] = bytes2int(bArr, 12);
            iArr[4] = bytes2int(bArr, 16);
            iArr[5] = bytes2int(bArr, 20);
            iArr[6] = bytes2int(bArr, 24);
            iArr[7] = bytes2int(bArr, 28);
        }
        for (int i = 0; i < 4; i++) {
            iArr2[i] = iArr[i] ^ iArr[i + 4];
        }
        camelliaF2(iArr2, f19781SIGMA, 0);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr2[i2] = iArr2[i2] ^ iArr[i2];
        }
        camelliaF2(iArr2, f19781SIGMA, 4);
        if (this._keySize == 16) {
            if (z) {
                int[] iArr5 = this.f19783kw;
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                m15278roldq(15, iArr, 0, this.f19784subkey, 4);
                m15278roldq(30, iArr, 0, this.f19784subkey, 12);
                m15278roldq(15, iArr, 0, iArr4, 0);
                int[] iArr6 = this.f19784subkey;
                iArr6[18] = iArr4[2];
                iArr6[19] = iArr4[3];
                m15278roldq(17, iArr, 0, this.f19782ke, 4);
                m15278roldq(17, iArr, 0, this.f19784subkey, 24);
                m15278roldq(17, iArr, 0, this.f19784subkey, 32);
                int[] iArr7 = this.f19784subkey;
                iArr7[0] = iArr2[0];
                iArr7[1] = iArr2[1];
                iArr7[2] = iArr2[2];
                iArr7[3] = iArr2[3];
                m15278roldq(15, iArr2, 0, iArr7, 8);
                m15278roldq(15, iArr2, 0, this.f19782ke, 0);
                m15278roldq(15, iArr2, 0, iArr4, 0);
                int[] iArr8 = this.f19784subkey;
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                m15278roldq(15, iArr2, 0, iArr8, 20);
                roldqo32(34, iArr2, 0, this.f19784subkey, 28);
                m15278roldq(17, iArr2, 0, this.f19783kw, 4);
                return;
            }
            int[] iArr9 = this.f19783kw;
            iArr9[4] = iArr[0];
            iArr9[5] = iArr[1];
            iArr9[6] = iArr[2];
            iArr9[7] = iArr[3];
            decroldq(15, iArr, 0, this.f19784subkey, 28);
            decroldq(30, iArr, 0, this.f19784subkey, 20);
            decroldq(15, iArr, 0, iArr4, 0);
            int[] iArr10 = this.f19784subkey;
            iArr10[16] = iArr4[0];
            iArr10[17] = iArr4[1];
            decroldq(17, iArr, 0, this.f19782ke, 0);
            decroldq(17, iArr, 0, this.f19784subkey, 8);
            decroldq(17, iArr, 0, this.f19784subkey, 0);
            int[] iArr11 = this.f19784subkey;
            iArr11[34] = iArr2[0];
            iArr11[35] = iArr2[1];
            iArr11[32] = iArr2[2];
            iArr11[33] = iArr2[3];
            decroldq(15, iArr2, 0, iArr11, 24);
            decroldq(15, iArr2, 0, this.f19782ke, 4);
            decroldq(15, iArr2, 0, iArr4, 0);
            int[] iArr12 = this.f19784subkey;
            iArr12[18] = iArr4[2];
            iArr12[19] = iArr4[3];
            decroldq(15, iArr2, 0, iArr12, 12);
            decroldqo32(34, iArr2, 0, this.f19784subkey, 4);
            m15278roldq(17, iArr2, 0, this.f19783kw, 0);
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            iArr3[i3] = iArr2[i3] ^ iArr[i3 + 4];
        }
        camelliaF2(iArr3, f19781SIGMA, 8);
        if (z) {
            int[] iArr13 = this.f19783kw;
            iArr13[0] = iArr[0];
            iArr13[1] = iArr[1];
            iArr13[2] = iArr[2];
            iArr13[3] = iArr[3];
            roldqo32(45, iArr, 0, this.f19784subkey, 16);
            m15278roldq(15, iArr, 0, this.f19782ke, 4);
            m15278roldq(17, iArr, 0, this.f19784subkey, 32);
            roldqo32(34, iArr, 0, this.f19784subkey, 44);
            m15278roldq(15, iArr, 4, this.f19784subkey, 4);
            m15278roldq(15, iArr, 4, this.f19782ke, 0);
            m15278roldq(30, iArr, 4, this.f19784subkey, 24);
            roldqo32(34, iArr, 4, this.f19784subkey, 36);
            m15278roldq(15, iArr2, 0, this.f19784subkey, 8);
            m15278roldq(30, iArr2, 0, this.f19784subkey, 20);
            int[] iArr14 = this.f19782ke;
            iArr14[8] = iArr2[1];
            iArr14[9] = iArr2[2];
            iArr14[10] = iArr2[3];
            iArr14[11] = iArr2[0];
            roldqo32(49, iArr2, 0, this.f19784subkey, 40);
            int[] iArr15 = this.f19784subkey;
            iArr15[0] = iArr3[0];
            iArr15[1] = iArr3[1];
            iArr15[2] = iArr3[2];
            iArr15[3] = iArr3[3];
            m15278roldq(30, iArr3, 0, iArr15, 12);
            m15278roldq(30, iArr3, 0, this.f19784subkey, 28);
            roldqo32(51, iArr3, 0, this.f19783kw, 4);
            return;
        }
        int[] iArr16 = this.f19783kw;
        iArr16[4] = iArr[0];
        iArr16[5] = iArr[1];
        iArr16[6] = iArr[2];
        iArr16[7] = iArr[3];
        decroldqo32(45, iArr, 0, this.f19784subkey, 28);
        decroldq(15, iArr, 0, this.f19782ke, 4);
        decroldq(17, iArr, 0, this.f19784subkey, 12);
        decroldqo32(34, iArr, 0, this.f19784subkey, 0);
        decroldq(15, iArr, 4, this.f19784subkey, 40);
        decroldq(15, iArr, 4, this.f19782ke, 8);
        decroldq(30, iArr, 4, this.f19784subkey, 20);
        decroldqo32(34, iArr, 4, this.f19784subkey, 8);
        decroldq(15, iArr2, 0, this.f19784subkey, 36);
        decroldq(30, iArr2, 0, this.f19784subkey, 24);
        int[] iArr17 = this.f19782ke;
        iArr17[2] = iArr2[1];
        iArr17[3] = iArr2[2];
        iArr17[0] = iArr2[3];
        iArr17[1] = iArr2[0];
        decroldqo32(49, iArr2, 0, this.f19784subkey, 4);
        int[] iArr18 = this.f19784subkey;
        iArr18[46] = iArr3[0];
        iArr18[47] = iArr3[1];
        iArr18[44] = iArr3[2];
        iArr18[45] = iArr3[3];
        decroldq(30, iArr3, 0, iArr18, 32);
        decroldq(30, iArr3, 0, this.f19784subkey, 16);
        roldqo32(51, iArr3, 0, this.f19783kw, 0);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "Camellia";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("only simple KeyParameter expected.");
        }
        m15282setKey(z, ((KeyParameter) cipherParameters).m15773getKey());
        this.initialized = true;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bitsOfSecurity(), cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.initialized) {
            throw new IllegalStateException("Camellia is not initialized");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 <= bArr2.length) {
            return this._keySize == 16 ? processBlock128(bArr, i, bArr2, i2) : processBlock192or256(bArr, i, bArr2, i2);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
