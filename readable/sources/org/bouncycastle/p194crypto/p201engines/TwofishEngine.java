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
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;

    /* renamed from: P */
    private static final byte[][] f20122P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, ByteCompanionObject.MIN_VALUE, 120, -28, -35, -47, 56, 13, -58, 53, -104, 24, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, 25, 91, C1217Base64.padSymbol, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, 22, 12, -29, 97, -64, -116, 58, -11, 115, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, 29, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, ByteCompanionObject.MAX_VALUE, -43, 26, 75, 14, -89, 90, 40, 20, C5066Utf8.REPLACEMENT_BYTE, 41, -120, 60, 76, 2, -72, -38, -80, 23, 85, 31, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, -36, -2, 50, -92, -54, 16, 33, -16, -45, 93, 15, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, 15, -8, 27, -121, -6, 6, C5066Utf8.REPLACEMENT_BYTE, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, 14, ByteCompanionObject.MIN_VALUE, 93, -46, -43, -96, -124, 7, 20, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, 16, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 43, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, 23, 102, -108, -95, 29, C1217Base64.padSymbol, -16, -34, -77, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, 26, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, 24, 35, -35, 31, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, 25, -115, -27, -104, 87, 103, ByteCompanionObject.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, -122, 86, 85, 9, -66, -111}};

    /* renamed from: P_00 */
    private static final int f20123P_00 = 1;

    /* renamed from: P_01 */
    private static final int f20124P_01 = 0;

    /* renamed from: P_02 */
    private static final int f20125P_02 = 0;

    /* renamed from: P_03 */
    private static final int f20126P_03 = 1;

    /* renamed from: P_04 */
    private static final int f20127P_04 = 1;

    /* renamed from: P_10 */
    private static final int f20128P_10 = 0;

    /* renamed from: P_11 */
    private static final int f20129P_11 = 0;

    /* renamed from: P_12 */
    private static final int f20130P_12 = 1;

    /* renamed from: P_13 */
    private static final int f20131P_13 = 1;

    /* renamed from: P_14 */
    private static final int f20132P_14 = 0;

    /* renamed from: P_20 */
    private static final int f20133P_20 = 1;

    /* renamed from: P_21 */
    private static final int f20134P_21 = 1;

    /* renamed from: P_22 */
    private static final int f20135P_22 = 0;

    /* renamed from: P_23 */
    private static final int f20136P_23 = 0;

    /* renamed from: P_24 */
    private static final int f20137P_24 = 0;

    /* renamed from: P_30 */
    private static final int f20138P_30 = 0;

    /* renamed from: P_31 */
    private static final int f20139P_31 = 1;

    /* renamed from: P_32 */
    private static final int f20140P_32 = 1;

    /* renamed from: P_33 */
    private static final int f20141P_33 = 0;

    /* renamed from: P_34 */
    private static final int f20142P_34 = 1;

    /* renamed from: ROUNDS */
    private static final int f20143ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;

    /* renamed from: SK_BUMP */
    private static final int f20144SK_BUMP = 16843009;

    /* renamed from: SK_ROTL */
    private static final int f20145SK_ROTL = 9;

    /* renamed from: SK_STEP */
    private static final int f20146SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;

    /* renamed from: gSBox */
    private int[] f20151gSBox;
    private int[] gSubKeys;
    private boolean encrypting = false;

    /* renamed from: gMDS0 */
    private int[] f20147gMDS0 = new int[256];

    /* renamed from: gMDS1 */
    private int[] f20148gMDS1 = new int[256];

    /* renamed from: gMDS2 */
    private int[] f20149gMDS2 = new int[256];

    /* renamed from: gMDS3 */
    private int[] f20150gMDS3 = new int[256];

    /* renamed from: k64Cnt */
    private int f20152k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256));
        for (int i = 0; i < 256; i++) {
            byte[][] bArr = f20122P;
            int i2 = bArr[0][i] & C1126UByte.MAX_VALUE;
            int iM15442Mx_X = m15442Mx_X(i2) & 255;
            int iM15443Mx_Y = m15443Mx_Y(i2) & 255;
            int i3 = bArr[1][i] & 255;
            int[] iArr = {i2, i3};
            int[] iArr2 = {iM15442Mx_X, m15442Mx_X(i3) & 255};
            int[] iArr3 = {iM15443Mx_Y, m15443Mx_Y(i3) & 255};
            int[] iArr4 = this.f20147gMDS0;
            int i4 = iArr[1] | (iArr2[1] << 8);
            int i5 = iArr3[1];
            iArr4[i] = i4 | (i5 << 16) | (i5 << 24);
            int[] iArr5 = this.f20148gMDS1;
            int i6 = iArr3[0];
            iArr5[i] = i6 | (i6 << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            int[] iArr6 = this.f20149gMDS2;
            int i7 = iArr2[1];
            int i8 = iArr3[1];
            iArr6[i] = (iArr[1] << 16) | i7 | (i8 << 8) | (i8 << 24);
            int[] iArr7 = this.f20150gMDS3;
            int i9 = iArr2[0];
            iArr7[i] = (iArr3[0] << 16) | (iArr[0] << 8) | i9 | (i9 << 24);
        }
    }

    /* renamed from: F32 */
    private int m15437F32(int i, int[] iArr) {
        int i2;
        int i3;
        int iM15445b0 = m15445b0(i);
        int iM15446b1 = m15446b1(i);
        int iM15447b2 = m15447b2(i);
        int iM15448b3 = m15448b3(i);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = this.f20152k64Cnt & 3;
        if (i8 != 0) {
            if (i8 == 1) {
                int[] iArr2 = this.f20147gMDS0;
                byte[][] bArr = f20122P;
                i2 = (iArr2[(bArr[0][iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i4)] ^ this.f20148gMDS1[(bArr[0][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i4)]) ^ this.f20149gMDS2[(bArr[1][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i4)];
                i3 = this.f20150gMDS3[m15448b3(i4) ^ (bArr[1][iM15448b3] & C1126UByte.MAX_VALUE)];
                return i2 ^ i3;
            }
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
            }
            int[] iArr3 = this.f20147gMDS0;
            byte[][] bArr2 = f20122P;
            byte[] bArr3 = bArr2[0];
            i2 = (iArr3[(bArr3[(bArr3[iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i5)] & C1126UByte.MAX_VALUE) ^ m15445b0(i4)] ^ this.f20148gMDS1[(bArr2[0][(bArr2[1][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i5)] & C1126UByte.MAX_VALUE) ^ m15446b1(i4)]) ^ this.f20149gMDS2[(bArr2[1][(bArr2[0][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i5)] & C1126UByte.MAX_VALUE) ^ m15447b2(i4)];
            int[] iArr4 = this.f20150gMDS3;
            byte[] bArr4 = bArr2[1];
            i3 = iArr4[m15448b3(i4) ^ (bArr4[(bArr4[iM15448b3] & C1126UByte.MAX_VALUE) ^ m15448b3(i5)] & C1126UByte.MAX_VALUE)];
            return i2 ^ i3;
        }
        byte[][] bArr5 = f20122P;
        iM15445b0 = (bArr5[1][iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i7);
        iM15446b1 = (bArr5[0][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i7);
        iM15447b2 = (bArr5[0][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i7);
        iM15448b3 = (bArr5[1][iM15448b3] & C1126UByte.MAX_VALUE) ^ m15448b3(i7);
        byte[][] bArr6 = f20122P;
        iM15445b0 = (bArr6[1][iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i6);
        iM15446b1 = (bArr6[1][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i6);
        iM15447b2 = (bArr6[0][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i6);
        iM15448b3 = (bArr6[0][iM15448b3] & C1126UByte.MAX_VALUE) ^ m15448b3(i6);
        int[] iArr32 = this.f20147gMDS0;
        byte[][] bArr22 = f20122P;
        byte[] bArr32 = bArr22[0];
        i2 = (iArr32[(bArr32[(bArr32[iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i5)] & C1126UByte.MAX_VALUE) ^ m15445b0(i4)] ^ this.f20148gMDS1[(bArr22[0][(bArr22[1][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i5)] & C1126UByte.MAX_VALUE) ^ m15446b1(i4)]) ^ this.f20149gMDS2[(bArr22[1][(bArr22[0][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i5)] & C1126UByte.MAX_VALUE) ^ m15447b2(i4)];
        int[] iArr42 = this.f20150gMDS3;
        byte[] bArr42 = bArr22[1];
        i3 = iArr42[m15448b3(i4) ^ (bArr42[(bArr42[iM15448b3] & C1126UByte.MAX_VALUE) ^ m15448b3(i5)] & C1126UByte.MAX_VALUE)];
        return i2 ^ i3;
    }

    /* renamed from: Fe32_0 */
    private int m15438Fe32_0(int i) {
        int[] iArr = this.f20151gSBox;
        return iArr[(((i >>> 24) & 255) * 2) + 513] ^ ((iArr[(i & 255) * 2] ^ iArr[(((i >>> 8) & 255) * 2) + 1]) ^ iArr[(((i >>> 16) & 255) * 2) + 512]);
    }

    /* renamed from: Fe32_3 */
    private int m15439Fe32_3(int i) {
        int[] iArr = this.f20151gSBox;
        return iArr[(((i >>> 16) & 255) * 2) + 513] ^ ((iArr[((i >>> 24) & 255) * 2] ^ iArr[((i & 255) * 2) + 1]) ^ iArr[(((i >>> 8) & 255) * 2) + 512]);
    }

    /* renamed from: LFSR1 */
    private int m15440LFSR1(int i) {
        return (i >> 1) ^ ((i & 1) != 0 ? GF256_FDBK_2 : 0);
    }

    /* renamed from: LFSR2 */
    private int m15441LFSR2(int i) {
        return ((i >> 2) ^ ((i & 2) != 0 ? GF256_FDBK_2 : 0)) ^ ((i & 1) != 0 ? GF256_FDBK_4 : 0);
    }

    /* renamed from: Mx_X */
    private int m15442Mx_X(int i) {
        return m15441LFSR2(i) ^ i;
    }

    /* renamed from: Mx_Y */
    private int m15443Mx_Y(int i) {
        return m15441LFSR2(i) ^ (m15440LFSR1(i) ^ i);
    }

    private int RS_MDS_Encode(int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = m15444RS_rem(i2);
        }
        int iM15444RS_rem = i ^ i2;
        for (int i4 = 0; i4 < 4; i4++) {
            iM15444RS_rem = m15444RS_rem(iM15444RS_rem);
        }
        return iM15444RS_rem;
    }

    /* renamed from: RS_rem */
    private int m15444RS_rem(int i) {
        int i2 = i >>> 24;
        int i3 = i2 & 255;
        int i4 = ((i3 << 1) ^ ((i2 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i5 = ((i3 >>> 1) ^ ((i2 & 1) != 0 ? 166 : 0)) ^ i4;
        return ((i5 << 8) ^ (((i << 8) ^ (i5 << 24)) ^ (i4 << 16))) ^ i3;
    }

    /* renamed from: b0 */
    private int m15445b0(int i) {
        return i & 255;
    }

    /* renamed from: b1 */
    private int m15446b1(int i) {
        return (i >>> 8) & 255;
    }

    /* renamed from: b2 */
    private int m15447b2(int i) {
        return (i >>> 16) & 255;
    }

    /* renamed from: b3 */
    private int m15448b3(int i) {
        return (i >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i) ^ this.gSubKeys[4];
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + 4) ^ this.gSubKeys[5];
        int iLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(bArr, i + 8) ^ this.gSubKeys[6];
        int iLittleEndianToInt4 = AbstractC6245Pack.littleEndianToInt(bArr, i + 12) ^ this.gSubKeys[7];
        int i3 = 39;
        for (int i4 = 0; i4 < 16; i4 += 2) {
            int iM15438Fe32_0 = m15438Fe32_0(iLittleEndianToInt);
            int iM15439Fe32_3 = m15439Fe32_3(iLittleEndianToInt2);
            int i5 = iLittleEndianToInt4 ^ (((iM15439Fe32_3 * 2) + iM15438Fe32_0) + this.gSubKeys[i3]);
            iLittleEndianToInt3 = Integers.rotateLeft(iLittleEndianToInt3, 1) ^ ((iM15438Fe32_0 + iM15439Fe32_3) + this.gSubKeys[i3 - 1]);
            iLittleEndianToInt4 = Integers.rotateRight(i5, 1);
            int iM15438Fe32_02 = m15438Fe32_0(iLittleEndianToInt3);
            int iM15439Fe32_32 = m15439Fe32_3(iLittleEndianToInt4);
            int i6 = i3 - 3;
            int i7 = iLittleEndianToInt2 ^ (((iM15439Fe32_32 * 2) + iM15438Fe32_02) + this.gSubKeys[i3 - 2]);
            i3 -= 4;
            iLittleEndianToInt = Integers.rotateLeft(iLittleEndianToInt, 1) ^ ((iM15438Fe32_02 + iM15439Fe32_32) + this.gSubKeys[i6]);
            iLittleEndianToInt2 = Integers.rotateRight(i7, 1);
        }
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt3 ^ this.gSubKeys[0], bArr2, i2);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt4 ^ this.gSubKeys[1], bArr2, i2 + 4);
        AbstractC6245Pack.intToLittleEndian(this.gSubKeys[2] ^ iLittleEndianToInt, bArr2, i2 + 8);
        AbstractC6245Pack.intToLittleEndian(this.gSubKeys[3] ^ iLittleEndianToInt2, bArr2, i2 + 12);
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i) ^ this.gSubKeys[0];
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + 4) ^ this.gSubKeys[1];
        int iLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(bArr, i + 8) ^ this.gSubKeys[2];
        int iLittleEndianToInt4 = AbstractC6245Pack.littleEndianToInt(bArr, i + 12) ^ this.gSubKeys[3];
        int i3 = 8;
        for (int i4 = 0; i4 < 16; i4 += 2) {
            int iM15438Fe32_0 = m15438Fe32_0(iLittleEndianToInt);
            int iM15439Fe32_3 = m15439Fe32_3(iLittleEndianToInt2);
            iLittleEndianToInt3 = Integers.rotateRight(iLittleEndianToInt3 ^ ((iM15438Fe32_0 + iM15439Fe32_3) + this.gSubKeys[i3]), 1);
            iLittleEndianToInt4 = Integers.rotateLeft(iLittleEndianToInt4, 1) ^ ((iM15438Fe32_0 + (iM15439Fe32_3 * 2)) + this.gSubKeys[i3 + 1]);
            int iM15438Fe32_02 = m15438Fe32_0(iLittleEndianToInt3);
            int iM15439Fe32_32 = m15439Fe32_3(iLittleEndianToInt4);
            int i5 = i3 + 3;
            iLittleEndianToInt = Integers.rotateRight(iLittleEndianToInt ^ ((iM15438Fe32_02 + iM15439Fe32_32) + this.gSubKeys[i3 + 2]), 1);
            i3 += 4;
            iLittleEndianToInt2 = Integers.rotateLeft(iLittleEndianToInt2, 1) ^ ((iM15438Fe32_02 + (iM15439Fe32_32 * 2)) + this.gSubKeys[i5]);
        }
        AbstractC6245Pack.intToLittleEndian(this.gSubKeys[4] ^ iLittleEndianToInt3, bArr2, i2);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt4 ^ this.gSubKeys[5], bArr2, i2 + 4);
        AbstractC6245Pack.intToLittleEndian(this.gSubKeys[6] ^ iLittleEndianToInt, bArr2, i2 + 8);
        AbstractC6245Pack.intToLittleEndian(this.gSubKeys[7] ^ iLittleEndianToInt2, bArr2, i2 + 12);
    }

    /* renamed from: setKey */
    private void m15449setKey(byte[] bArr) {
        int iM15445b0;
        int iM15446b1;
        int iM15447b2;
        int iM15448b3;
        int iM15447b22;
        int iM15446b12;
        int iM15445b02;
        int iM15448b32;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        for (int i = 0; i < this.f20152k64Cnt; i++) {
            int i2 = i * 8;
            iArr[i] = AbstractC6245Pack.littleEndianToInt(bArr, i2);
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i2 + 4);
            iArr2[i] = iLittleEndianToInt;
            iArr3[(this.f20152k64Cnt - 1) - i] = RS_MDS_Encode(iArr[i], iLittleEndianToInt);
        }
        for (int i3 = 0; i3 < 20; i3++) {
            int i4 = f20146SK_STEP * i3;
            int iM15437F32 = m15437F32(i4, iArr);
            int iRotateLeft = Integers.rotateLeft(m15437F32(i4 + 16843009, iArr2), 8);
            int i5 = iM15437F32 + iRotateLeft;
            int[] iArr4 = this.gSubKeys;
            int i6 = i3 * 2;
            iArr4[i6] = i5;
            int i7 = i5 + iRotateLeft;
            iArr4[i6 + 1] = (i7 << 9) | (i7 >>> 23);
        }
        int i8 = iArr3[0];
        int i9 = iArr3[1];
        int i10 = 2;
        int i11 = iArr3[2];
        int i12 = iArr3[3];
        this.f20151gSBox = new int[1024];
        int i13 = 0;
        while (i13 < 256) {
            int i14 = this.f20152k64Cnt & 3;
            if (i14 != 0) {
                if (i14 == 1) {
                    int[] iArr5 = this.f20151gSBox;
                    int i15 = i13 * 2;
                    int[] iArr6 = this.f20147gMDS0;
                    byte[][] bArr2 = f20122P;
                    iArr5[i15] = iArr6[(bArr2[0][i13] & C1126UByte.MAX_VALUE) ^ m15445b0(i8)];
                    this.f20151gSBox[i15 + 1] = this.f20148gMDS1[(bArr2[0][i13] & C1126UByte.MAX_VALUE) ^ m15446b1(i8)];
                    this.f20151gSBox[i15 + 512] = this.f20149gMDS2[(bArr2[1][i13] & C1126UByte.MAX_VALUE) ^ m15447b2(i8)];
                    this.f20151gSBox[i15 + 513] = this.f20150gMDS3[(bArr2[1][i13] & C1126UByte.MAX_VALUE) ^ m15448b3(i8)];
                } else if (i14 == i10) {
                    iM15448b32 = i13;
                    iM15445b02 = iM15448b32;
                    iM15446b12 = iM15445b02;
                    iM15447b22 = iM15446b12;
                    int[] iArr7 = this.f20151gSBox;
                    int i16 = i13 * 2;
                    int[] iArr8 = this.f20147gMDS0;
                    byte[][] bArr3 = f20122P;
                    byte[] bArr4 = bArr3[0];
                    iArr7[i16] = iArr8[(bArr4[(bArr4[iM15445b02] & C1126UByte.MAX_VALUE) ^ m15445b0(i9)] & C1126UByte.MAX_VALUE) ^ m15445b0(i8)];
                    this.f20151gSBox[i16 + 1] = this.f20148gMDS1[(bArr3[0][(bArr3[1][iM15446b12] & C1126UByte.MAX_VALUE) ^ m15446b1(i9)] & C1126UByte.MAX_VALUE) ^ m15446b1(i8)];
                    this.f20151gSBox[i16 + 512] = this.f20149gMDS2[(bArr3[1][(bArr3[0][iM15447b22] & C1126UByte.MAX_VALUE) ^ m15447b2(i9)] & C1126UByte.MAX_VALUE) ^ m15447b2(i8)];
                    int[] iArr9 = this.f20150gMDS3;
                    byte[] bArr5 = bArr3[1];
                    this.f20151gSBox[i16 + 513] = iArr9[(bArr5[(bArr5[iM15448b32] & C1126UByte.MAX_VALUE) ^ m15448b3(i9)] & C1126UByte.MAX_VALUE) ^ m15448b3(i8)];
                } else if (i14 == 3) {
                    iM15448b3 = i13;
                    iM15445b0 = iM15448b3;
                    iM15446b1 = iM15445b0;
                    iM15447b2 = iM15446b1;
                }
                i13++;
                i10 = 2;
            } else {
                byte[][] bArr6 = f20122P;
                iM15445b0 = (bArr6[1][i13] & C1126UByte.MAX_VALUE) ^ m15445b0(i12);
                iM15446b1 = (bArr6[0][i13] & C1126UByte.MAX_VALUE) ^ m15446b1(i12);
                iM15447b2 = (bArr6[0][i13] & C1126UByte.MAX_VALUE) ^ m15447b2(i12);
                iM15448b3 = (bArr6[1][i13] & C1126UByte.MAX_VALUE) ^ m15448b3(i12);
            }
            byte[][] bArr7 = f20122P;
            iM15445b02 = (bArr7[1][iM15445b0] & C1126UByte.MAX_VALUE) ^ m15445b0(i11);
            iM15446b12 = (bArr7[1][iM15446b1] & C1126UByte.MAX_VALUE) ^ m15446b1(i11);
            iM15447b22 = (bArr7[0][iM15447b2] & C1126UByte.MAX_VALUE) ^ m15447b2(i11);
            iM15448b32 = (bArr7[0][iM15448b3] & C1126UByte.MAX_VALUE) ^ m15448b3(i11);
            int[] iArr72 = this.f20151gSBox;
            int i162 = i13 * 2;
            int[] iArr82 = this.f20147gMDS0;
            byte[][] bArr32 = f20122P;
            byte[] bArr42 = bArr32[0];
            iArr72[i162] = iArr82[(bArr42[(bArr42[iM15445b02] & C1126UByte.MAX_VALUE) ^ m15445b0(i9)] & C1126UByte.MAX_VALUE) ^ m15445b0(i8)];
            this.f20151gSBox[i162 + 1] = this.f20148gMDS1[(bArr32[0][(bArr32[1][iM15446b12] & C1126UByte.MAX_VALUE) ^ m15446b1(i9)] & C1126UByte.MAX_VALUE) ^ m15446b1(i8)];
            this.f20151gSBox[i162 + 512] = this.f20149gMDS2[(bArr32[1][(bArr32[0][iM15447b22] & C1126UByte.MAX_VALUE) ^ m15447b2(i9)] & C1126UByte.MAX_VALUE) ^ m15447b2(i8)];
            int[] iArr92 = this.f20150gMDS3;
            byte[] bArr52 = bArr32[1];
            this.f20151gSBox[i162 + 513] = iArr92[(bArr52[(bArr52[iM15448b32] & C1126UByte.MAX_VALUE) ^ m15448b3(i9)] & C1126UByte.MAX_VALUE) ^ m15448b3(i8)];
            i13++;
            i10 = 2;
        }
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
        }
        this.encrypting = z;
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        this.workingKey = bArrM15773getKey;
        int length = bArrM15773getKey.length * 8;
        if (length != 128 && length != 192 && length != 256) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), length, cipherParameters, C5342Utils.getPurpose(z)));
        byte[] bArr = this.workingKey;
        this.f20152k64Cnt = bArr.length / 8;
        m15449setKey(bArr);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
        decryptBlock(bArr, i, bArr2, i2);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            m15449setKey(bArr);
        }
    }
}
