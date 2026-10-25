package org.bouncycastle.p194crypto.p201engines;

import java.lang.reflect.Array;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
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
public class RijndaelEngine implements BlockCipher {

    /* renamed from: MAXKC */
    private static final int f20023MAXKC = 64;
    private static final int MAXROUNDS = 14;

    /* renamed from: A0 */
    private long f20029A0;

    /* renamed from: A1 */
    private long f20030A1;

    /* renamed from: A2 */
    private long f20031A2;

    /* renamed from: A3 */
    private long f20032A3;

    /* renamed from: BC */
    private int f20033BC;

    /* renamed from: BC_MASK */
    private long f20034BC_MASK;

    /* renamed from: ROUNDS */
    private int f20035ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;
    private static final byte[] logtable = {0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 27, 104, 51, -18, -33, 3, 100, 4, -32, 14, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, 28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, 15, -31, 36, 18, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, 16, 126, 110, 72, -61, -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, C1217Base64.padSymbol, -70, 43, 121, 10, 21, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, 11, -11, 89, -53, 95, -80, -100, -87, 81, -96, ByteCompanionObject.MAX_VALUE, 12, -10, 111, 23, -60, 73, -20, -40, 67, 31, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, C5066Utf8.REPLACEMENT_BYTE, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, 24, 13, 99, -116, ByteCompanionObject.MIN_VALUE, -64, -9, 112, 7};
    private static final byte[] aLogtable = {0, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, C5066Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, C1217Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, C5066Utf8.REPLACEMENT_BYTE, 65, -61, 94, -30, C1217Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1};

    /* renamed from: S */
    private static final byte[] f20024S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, C5066Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, C1217Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};

    /* renamed from: Si */
    private static final byte[] f20025Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, C1217Base64.padSymbol, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, C5066Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};

    /* renamed from: rcon */
    private static final int[] f20026rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* renamed from: shifts0 */
    static byte[][] f20027shifts0 = {new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 32}, new byte[]{0, 8, 24, 32}};

    /* renamed from: shifts1 */
    static byte[][] f20028shifts1 = {new byte[]{0, 24, 16, 8}, new byte[]{0, 32, 24, 16}, new byte[]{0, 40, 32, 24}, new byte[]{0, 48, 40, 24}, new byte[]{0, 56, 40, 32}};

    public RijndaelEngine() {
        this(128);
    }

    private void InvMixColumn() {
        long jM15383mul0xe = 0;
        long jM15383mul0xe2 = 0;
        long jM15383mul0xe3 = 0;
        long jM15383mul0xe4 = 0;
        for (int i = 0; i < this.f20033BC; i += 8) {
            int i2 = (int) ((this.f20029A0 >> i) & 255);
            int i3 = (int) ((this.f20030A1 >> i) & 255);
            int i4 = (int) ((this.f20031A2 >> i) & 255);
            long j = jM15383mul0xe3;
            int i5 = (int) ((this.f20032A3 >> i) & 255);
            int i6 = -1;
            int i7 = i2 != 0 ? logtable[i2 & 255] & C1126UByte.MAX_VALUE : -1;
            int i8 = i3 != 0 ? logtable[i3 & 255] & C1126UByte.MAX_VALUE : -1;
            int i9 = i4 != 0 ? logtable[i4 & 255] & C1126UByte.MAX_VALUE : -1;
            if (i5 != 0) {
                i6 = logtable[i5 & 255] & C1126UByte.MAX_VALUE;
            }
            jM15383mul0xe |= ((((m15383mul0xe(i7) ^ m15381mul0xb(i8)) ^ m15382mul0xd(i9)) ^ m15380mul0x9(i6)) & 255) << i;
            jM15383mul0xe4 |= ((((m15383mul0xe(i8) ^ m15381mul0xb(i9)) ^ m15382mul0xd(i6)) ^ m15380mul0x9(i7)) & 255) << i;
            jM15383mul0xe2 |= ((((m15383mul0xe(i9) ^ m15381mul0xb(i6)) ^ m15382mul0xd(i7)) ^ m15380mul0x9(i8)) & 255) << i;
            jM15383mul0xe3 = (((((m15383mul0xe(i6) ^ m15381mul0xb(i7)) ^ m15382mul0xd(i8)) ^ m15380mul0x9(i9)) & 255) << i) | j;
        }
        this.f20029A0 = jM15383mul0xe;
        this.f20030A1 = jM15383mul0xe4;
        this.f20031A2 = jM15383mul0xe2;
        this.f20032A3 = jM15383mul0xe3;
    }

    private void KeyAddition(long[] jArr) {
        this.f20029A0 ^= jArr[0];
        this.f20030A1 ^= jArr[1];
        this.f20031A2 ^= jArr[2];
        this.f20032A3 ^= jArr[3];
    }

    private void MixColumn() {
        long jM15378mul0x2 = 0;
        long jM15378mul0x22 = 0;
        long jM15378mul0x23 = 0;
        long jM15378mul0x24 = 0;
        for (int i = 0; i < this.f20033BC; i += 8) {
            int i2 = (int) ((this.f20029A0 >> i) & 255);
            int i3 = (int) ((this.f20030A1 >> i) & 255);
            int i4 = (int) ((this.f20031A2 >> i) & 255);
            long j = jM15378mul0x23;
            int i5 = (int) ((this.f20032A3 >> i) & 255);
            jM15378mul0x2 |= ((((m15378mul0x2(i2) ^ m15379mul0x3(i3)) ^ i4) ^ i5) & 255) << i;
            jM15378mul0x24 |= ((((m15378mul0x2(i3) ^ m15379mul0x3(i4)) ^ i5) ^ i2) & 255) << i;
            jM15378mul0x22 |= ((((m15378mul0x2(i4) ^ m15379mul0x3(i5)) ^ i2) ^ i3) & 255) << i;
            jM15378mul0x23 = (((((m15378mul0x2(i5) ^ m15379mul0x3(i2)) ^ i3) ^ i4) & 255) << i) | j;
        }
        this.f20029A0 = jM15378mul0x2;
        this.f20030A1 = jM15378mul0x24;
        this.f20031A2 = jM15378mul0x22;
        this.f20032A3 = jM15378mul0x23;
    }

    private void ShiftRow(byte[] bArr) {
        this.f20030A1 = m15384shift(this.f20030A1, bArr[1]);
        this.f20031A2 = m15384shift(this.f20031A2, bArr[2]);
        this.f20032A3 = m15384shift(this.f20032A3, bArr[3]);
    }

    private void Substitution(byte[] bArr) {
        this.f20029A0 = m15377applyS(this.f20029A0, bArr);
        this.f20030A1 = m15377applyS(this.f20030A1, bArr);
        this.f20031A2 = m15377applyS(this.f20031A2, bArr);
        this.f20032A3 = m15377applyS(this.f20032A3, bArr);
    }

    /* renamed from: applyS */
    private long m15377applyS(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.f20033BC; i += 8) {
            j2 |= (bArr[(int) ((j >> i) & 255)] & C1126UByte.MAX_VALUE) << i;
        }
        return j2;
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.f20035ROUNDS]);
        Substitution(f20025Si);
        ShiftRow(this.shifts1SC);
        for (int i = this.f20035ROUNDS - 1; i > 0; i--) {
            KeyAddition(jArr[i]);
            InvMixColumn();
            Substitution(f20025Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i = 1; i < this.f20035ROUNDS; i++) {
            Substitution(f20024S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i]);
        }
        Substitution(f20024S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.f20035ROUNDS]);
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4 = 8;
        int length = bArr.length * 8;
        int i5 = 1;
        int i6 = 0;
        int i7 = 4;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 64);
        long[][] jArr = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 15, 4);
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == 192) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
            }
            i = 8;
        }
        this.f20035ROUNDS = length >= this.blockBits ? i + 6 : (this.f20033BC / 8) + 6;
        int i8 = 0;
        int i9 = 0;
        while (i8 < bArr.length) {
            bArr2[i8 % 4][i8 / 4] = bArr[i9];
            i8++;
            i9++;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i && i11 < (this.f20035ROUNDS + 1) * (this.f20033BC / 8)) {
            int i12 = i6;
            while (i12 < i7) {
                int i13 = this.f20033BC;
                long[] jArr2 = jArr[i11 / (i13 / 8)];
                jArr2[i12] = ((bArr2[i12][i10] & C1126UByte.MAX_VALUE) << ((i11 * 8) % i13)) | jArr2[i12];
                i12++;
                i7 = 4;
            }
            i10++;
            i11++;
            i6 = 0;
            i7 = 4;
        }
        int i14 = 0;
        while (i11 < (this.f20035ROUNDS + i5) * (this.f20033BC / i4)) {
            int i15 = 0;
            for (int i16 = 4; i15 < i16; i16 = 4) {
                byte[] bArr3 = bArr2[i15];
                i15++;
                bArr3[0] = (byte) (f20024S[bArr2[i15 % 4][i - 1] & C1126UByte.MAX_VALUE] ^ bArr3[0]);
            }
            byte[] bArr4 = bArr2[0];
            int i17 = i14 + 1;
            bArr4[0] = (byte) (f20026rcon[i14] ^ bArr4[0]);
            if (i <= 6) {
                for (int i18 = i5; i18 < i; i18++) {
                    for (int i19 = 0; i19 < 4; i19++) {
                        byte[] bArr5 = bArr2[i19];
                        bArr5[i18] = (byte) (bArr5[i18] ^ bArr5[i18 - 1]);
                    }
                }
            } else {
                int i20 = i5;
                while (true) {
                    i2 = 4;
                    i3 = 0;
                    if (i20 >= 4) {
                        break;
                    }
                    while (i3 < i2) {
                        byte[] bArr6 = bArr2[i3];
                        bArr6[i20] = (byte) (bArr6[i20] ^ bArr6[i20 - 1]);
                        i3++;
                        i2 = 4;
                    }
                    i20++;
                }
                while (i3 < 4) {
                    byte[] bArr7 = bArr2[i3];
                    bArr7[4] = (byte) (bArr7[4] ^ f20024S[bArr7[3] & C1126UByte.MAX_VALUE]);
                    i3++;
                }
                int i21 = 5;
                while (i21 < i) {
                    int i22 = 0;
                    while (i22 < i2) {
                        byte[] bArr8 = bArr2[i22];
                        bArr8[i21] = (byte) (bArr8[i21] ^ bArr8[i21 - 1]);
                        i22++;
                        i2 = 4;
                    }
                    i21++;
                    i2 = 4;
                }
            }
            int i23 = 0;
            while (i23 < i && i11 < (this.f20035ROUNDS + i5) * (this.f20033BC / i4)) {
                for (int i24 = 0; i24 < 4; i24++) {
                    int i25 = this.f20033BC;
                    long[] jArr3 = jArr[i11 / (i25 / 8)];
                    jArr3[i24] = ((bArr2[i24][i23] & C1126UByte.MAX_VALUE) << ((i11 * 8) % i25)) | jArr3[i24];
                }
                i23++;
                i11++;
                i4 = 8;
                i5 = 1;
            }
            i14 = i17;
            i4 = 8;
            i5 = 1;
        }
        return jArr;
    }

    /* renamed from: mul0x2 */
    private byte m15378mul0x2(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & C1126UByte.MAX_VALUE) + 25];
        }
        return (byte) 0;
    }

    /* renamed from: mul0x3 */
    private byte m15379mul0x3(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & C1126UByte.MAX_VALUE) + 1];
        }
        return (byte) 0;
    }

    /* renamed from: mul0x9 */
    private byte m15380mul0x9(int i) {
        if (i >= 0) {
            return aLogtable[i + 199];
        }
        return (byte) 0;
    }

    /* renamed from: mul0xb */
    private byte m15381mul0xb(int i) {
        if (i >= 0) {
            return aLogtable[i + 104];
        }
        return (byte) 0;
    }

    /* renamed from: mul0xd */
    private byte m15382mul0xd(int i) {
        if (i >= 0) {
            return aLogtable[i + 238];
        }
        return (byte) 0;
    }

    /* renamed from: mul0xe */
    private byte m15383mul0xe(int i) {
        if (i >= 0) {
            return aLogtable[i + 223];
        }
        return (byte) 0;
    }

    private void packBlock(byte[] bArr, int i) {
        for (int i2 = 0; i2 != this.f20033BC; i2 += 8) {
            bArr[i] = (byte) (this.f20029A0 >> i2);
            bArr[i + 1] = (byte) (this.f20030A1 >> i2);
            int i3 = i + 3;
            bArr[i + 2] = (byte) (this.f20031A2 >> i2);
            i += 4;
            bArr[i3] = (byte) (this.f20032A3 >> i2);
        }
    }

    /* renamed from: shift */
    private long m15384shift(long j, int i) {
        return ((j << (this.f20033BC - i)) | (j >>> i)) & this.f20034BC_MASK;
    }

    private void unpackBlock(byte[] bArr, int i) {
        this.f20029A0 = bArr[i] & C1126UByte.MAX_VALUE;
        this.f20030A1 = bArr[i + 1] & C1126UByte.MAX_VALUE;
        int i2 = i + 3;
        this.f20031A2 = bArr[i + 2] & C1126UByte.MAX_VALUE;
        int i3 = i + 4;
        this.f20032A3 = bArr[i2] & C1126UByte.MAX_VALUE;
        for (int i4 = 8; i4 != this.f20033BC; i4 += 8) {
            this.f20029A0 |= (bArr[i3] & C1126UByte.MAX_VALUE) << i4;
            this.f20030A1 |= (bArr[i3 + 1] & C1126UByte.MAX_VALUE) << i4;
            int i5 = i3 + 3;
            this.f20031A2 |= (bArr[i3 + 2] & C1126UByte.MAX_VALUE) << i4;
            i3 += 4;
            this.f20032A3 |= (bArr[i5] & C1126UByte.MAX_VALUE) << i4;
        }
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "Rijndael";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20033BC / 2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        this.workingKey = generateWorkingKey(bArrM15773getKey);
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bArrM15773getKey.length * 8, cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
        int i3 = this.f20033BC;
        if ((i3 / 2) + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if ((i3 / 2) + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        boolean z = this.forEncryption;
        unpackBlock(bArr, i);
        long[][] jArr = this.workingKey;
        if (z) {
            encryptBlock(jArr);
        } else {
            decryptBlock(jArr);
        }
        packBlock(bArr2, i2);
        return this.f20033BC / 2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }

    public RijndaelEngine(int i) {
        if (i == 128) {
            this.f20033BC = 32;
            this.f20034BC_MASK = BodyPartID.bodyIdMax;
            this.shifts0SC = f20027shifts0[0];
            this.shifts1SC = f20028shifts1[0];
        } else if (i == 160) {
            this.f20033BC = 40;
            this.f20034BC_MASK = 1099511627775L;
            this.shifts0SC = f20027shifts0[1];
            this.shifts1SC = f20028shifts1[1];
        } else if (i == 192) {
            this.f20033BC = 48;
            this.f20034BC_MASK = 281474976710655L;
            this.shifts0SC = f20027shifts0[2];
            this.shifts1SC = f20028shifts1[2];
        } else if (i == 224) {
            this.f20033BC = 56;
            this.f20034BC_MASK = 72057594037927935L;
            this.shifts0SC = f20027shifts0[3];
            this.shifts1SC = f20028shifts1[3];
        } else {
            if (i != 256) {
                throw new IllegalArgumentException("unknown blocksize to Rijndael");
            }
            this.f20033BC = 64;
            this.f20034BC_MASK = -1L;
            this.shifts0SC = f20027shifts0[4];
            this.shifts1SC = f20028shifts1[4];
        }
        this.blockBits = i;
    }
}
