package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.logging.Logger;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p284math.p295raw.AbstractC5866Bits;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.Signature;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.Signature2;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class PicnicEngine {

    /* renamed from: LOG */
    private static final Logger f23970LOG = Logger.getLogger(PicnicEngine.class.getName());
    protected static final int LOWMC_MAX_AND_GATES = 1144;
    protected static final int LOWMC_MAX_KEY_BITS = 256;
    private static final int LOWMC_MAX_STATE_SIZE = 64;
    protected static final int LOWMC_MAX_WORDS = 16;
    private static final int MAX_AUX_BYTES = 176;
    private static final int MAX_DIGEST_SIZE = 64;
    private static final int PICNIC_MAX_LOWMC_BLOCK_SIZE = 32;
    private static final int TRANSFORM_FS = 0;
    private static final int TRANSFORM_INVALID = 255;
    private static final int TRANSFORM_UR = 1;
    private static final int WORD_SIZE_BITS = 32;
    protected static final int saltSizeBytes = 32;
    private final int CRYPTO_BYTES;
    private final int CRYPTO_PUBLICKEYBYTES;
    private final int CRYPTO_SECRETKEYBYTES;
    protected final int UnruhGWithInputBytes;
    protected final int UnruhGWithoutInputBytes;
    protected final int andSizeBytes;

    /* renamed from: digest */
    protected final InterfaceC5284Xof f23971digest;
    protected final int digestSizeBytes;
    protected final LowmcConstants lowmcConstants;
    protected final int numMPCParties;
    protected final int numMPCRounds;
    protected final int numOpenedRounds;
    protected final int numRounds;
    protected final int numSboxes;
    private final int parameters;
    protected final int pqSecurityLevel;
    protected final int seedSizeBytes;
    private int signatureLength;
    protected final int stateSizeBits;
    protected final int stateSizeBytes;
    protected final int stateSizeWords;
    private final int transform;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PicnicEngine(int i, LowmcConstants lowmcConstants) {
        int i2;
        this.lowmcConstants = lowmcConstants;
        this.parameters = i;
        switch (i) {
            case 1:
            case 2:
                this.pqSecurityLevel = 64;
                this.stateSizeBits = 128;
                this.numMPCRounds = 219;
                this.numMPCParties = 3;
                this.numSboxes = 10;
                this.numRounds = 20;
                this.digestSizeBytes = 32;
                this.numOpenedRounds = 0;
                switch (i) {
                    case 1:
                        this.CRYPTO_SECRETKEYBYTES = 49;
                        this.CRYPTO_PUBLICKEYBYTES = 33;
                        i2 = 34036;
                        break;
                    case 2:
                        this.CRYPTO_SECRETKEYBYTES = 49;
                        this.CRYPTO_PUBLICKEYBYTES = 33;
                        i2 = 53965;
                        break;
                    case 3:
                        this.CRYPTO_SECRETKEYBYTES = 73;
                        this.CRYPTO_PUBLICKEYBYTES = 49;
                        i2 = 76784;
                        break;
                    case 4:
                        this.CRYPTO_SECRETKEYBYTES = 73;
                        this.CRYPTO_PUBLICKEYBYTES = 49;
                        i2 = 121857;
                        break;
                    case 5:
                        this.CRYPTO_SECRETKEYBYTES = 97;
                        this.CRYPTO_PUBLICKEYBYTES = 65;
                        i2 = 132876;
                        break;
                    case 6:
                        this.CRYPTO_SECRETKEYBYTES = 97;
                        this.CRYPTO_PUBLICKEYBYTES = 65;
                        i2 = 209526;
                        break;
                    case 7:
                        this.CRYPTO_SECRETKEYBYTES = 52;
                        this.CRYPTO_PUBLICKEYBYTES = 35;
                        i2 = 14612;
                        break;
                    case 8:
                        this.CRYPTO_SECRETKEYBYTES = 73;
                        this.CRYPTO_PUBLICKEYBYTES = 49;
                        i2 = 35028;
                        break;
                    case 9:
                        this.CRYPTO_SECRETKEYBYTES = 97;
                        this.CRYPTO_PUBLICKEYBYTES = 65;
                        i2 = 61028;
                        break;
                    case 10:
                        this.CRYPTO_SECRETKEYBYTES = 52;
                        this.CRYPTO_PUBLICKEYBYTES = 35;
                        i2 = 32061;
                        break;
                    case 11:
                        this.CRYPTO_SECRETKEYBYTES = 73;
                        this.CRYPTO_PUBLICKEYBYTES = 49;
                        i2 = 71179;
                        break;
                    case 12:
                        this.CRYPTO_SECRETKEYBYTES = 97;
                        this.CRYPTO_PUBLICKEYBYTES = 65;
                        i2 = 126286;
                        break;
                    default:
                        i2 = -1;
                        this.CRYPTO_SECRETKEYBYTES = -1;
                        this.CRYPTO_PUBLICKEYBYTES = -1;
                        break;
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes;
                int iNumBytes2 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes2;
                int iNumBytes3 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes3;
                int i3 = this.stateSizeBits;
                this.stateSizeWords = (i3 + 31) / 32;
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        this.transform = 0;
                        break;
                    case 2:
                    case 4:
                    case 6:
                        this.transform = 1;
                        break;
                    default:
                        this.transform = 255;
                        break;
                }
                if (this.transform == 1) {
                    int i4 = iNumBytes3 + iNumBytes;
                    this.UnruhGWithoutInputBytes = i4;
                    this.UnruhGWithInputBytes = i4 + iNumBytes2;
                } else {
                    this.UnruhGWithoutInputBytes = 0;
                    this.UnruhGWithInputBytes = 0;
                }
                this.f23971digest = (i3 == 128 || i3 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 3:
            case 4:
                this.pqSecurityLevel = 96;
                this.stateSizeBits = 192;
                this.numMPCRounds = 329;
                this.numMPCParties = 3;
                this.numSboxes = 10;
                this.numRounds = 30;
                this.digestSizeBytes = 48;
                this.numOpenedRounds = 0;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes4 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes4;
                int iNumBytes22 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes22;
                int iNumBytes32 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes32;
                int i32 = this.stateSizeBits;
                this.stateSizeWords = (i32 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i32 == 128 || i32 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 5:
            case 6:
                this.pqSecurityLevel = 128;
                this.stateSizeBits = 256;
                this.numMPCRounds = 438;
                this.numMPCParties = 3;
                this.numSboxes = 10;
                this.numRounds = 38;
                this.digestSizeBytes = 64;
                this.numOpenedRounds = 0;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes42 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes42;
                int iNumBytes222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes222;
                int iNumBytes322 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes322;
                int i322 = this.stateSizeBits;
                this.stateSizeWords = (i322 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i322 == 128 || i322 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 7:
                this.pqSecurityLevel = 64;
                this.stateSizeBits = 129;
                this.numMPCRounds = 250;
                this.numOpenedRounds = 36;
                this.numMPCParties = 16;
                this.numSboxes = 43;
                this.numRounds = 4;
                this.digestSizeBytes = 32;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes422 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes422;
                int iNumBytes2222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes2222;
                int iNumBytes3222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes3222;
                int i3222 = this.stateSizeBits;
                this.stateSizeWords = (i3222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i3222 == 128 || i3222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 8:
                this.pqSecurityLevel = 96;
                this.stateSizeBits = 192;
                this.numMPCRounds = 419;
                this.numOpenedRounds = 52;
                this.numMPCParties = 16;
                this.numSboxes = 64;
                this.numRounds = 4;
                this.digestSizeBytes = 48;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes4222 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes4222;
                int iNumBytes22222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes22222;
                int iNumBytes32222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes32222;
                int i32222 = this.stateSizeBits;
                this.stateSizeWords = (i32222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i32222 == 128 || i32222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 9:
                this.pqSecurityLevel = 128;
                this.stateSizeBits = 255;
                this.numMPCRounds = 601;
                this.numOpenedRounds = 68;
                this.numMPCParties = 16;
                this.numSboxes = 85;
                this.numRounds = 4;
                this.digestSizeBytes = 64;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes42222 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes42222;
                int iNumBytes222222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes222222;
                int iNumBytes322222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes322222;
                int i322222 = this.stateSizeBits;
                this.stateSizeWords = (i322222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i322222 == 128 || i322222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 10:
                this.pqSecurityLevel = 64;
                this.stateSizeBits = 129;
                this.numMPCRounds = 219;
                this.numMPCParties = 3;
                this.numSboxes = 43;
                this.numRounds = 4;
                this.digestSizeBytes = 32;
                this.numOpenedRounds = 0;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes422222 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes422222;
                int iNumBytes2222222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes2222222;
                int iNumBytes3222222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes3222222;
                int i3222222 = this.stateSizeBits;
                this.stateSizeWords = (i3222222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i3222222 == 128 || i3222222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 11:
                this.pqSecurityLevel = 96;
                this.stateSizeBits = 192;
                this.numMPCRounds = 329;
                this.numMPCParties = 3;
                this.numSboxes = 64;
                this.numRounds = 4;
                this.digestSizeBytes = 48;
                this.numOpenedRounds = 0;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes4222222 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes4222222;
                int iNumBytes22222222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes22222222;
                int iNumBytes32222222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes32222222;
                int i32222222 = this.stateSizeBits;
                this.stateSizeWords = (i32222222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i32222222 == 128 || i32222222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            case 12:
                this.pqSecurityLevel = 128;
                this.stateSizeBits = 255;
                this.numMPCRounds = 438;
                this.numMPCParties = 3;
                this.numSboxes = 85;
                this.numRounds = 4;
                this.digestSizeBytes = 64;
                this.numOpenedRounds = 0;
                switch (i) {
                }
                this.CRYPTO_BYTES = i2;
                int iNumBytes42222222 = C6219Utils.numBytes(this.numSboxes * 3 * this.numRounds);
                this.andSizeBytes = iNumBytes42222222;
                int iNumBytes222222222 = C6219Utils.numBytes(this.stateSizeBits);
                this.stateSizeBytes = iNumBytes222222222;
                int iNumBytes322222222 = C6219Utils.numBytes(this.pqSecurityLevel * 2);
                this.seedSizeBytes = iNumBytes322222222;
                int i322222222 = this.stateSizeBits;
                this.stateSizeWords = (i322222222 + 31) / 32;
                switch (i) {
                }
                if (this.transform == 1) {
                }
                this.f23971digest = (i322222222 == 128 || i322222222 == 129) ? new SHAKEDigest(128) : new SHAKEDigest(256);
                return;
            default:
                throw new IllegalArgumentException("unknown parameter set " + i);
        }
    }

    /* renamed from: Commit */
    private void m18087Commit(byte[] bArr, int i, C6220View c6220View, byte[] bArr2) {
        this.f23971digest.mo14969update((byte) 4);
        this.f23971digest.mo14970update(bArr, i, this.seedSizeBytes);
        this.f23971digest.mo14998doFinal(bArr2, 0, this.digestSizeBytes);
        this.f23971digest.mo14969update((byte) 0);
        this.f23971digest.mo14970update(bArr2, 0, this.digestSizeBytes);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(c6220View.inputShare), 0, this.stateSizeBytes);
        this.f23971digest.mo14970update(c6220View.communicatedBits, 0, this.andSizeBytes);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(c6220View.outputShare), 0, this.stateSizeBytes);
        this.f23971digest.mo14998doFinal(bArr2, 0, this.digestSizeBytes);
    }

    /* renamed from: G */
    private void m18088G(int i, byte[] bArr, int i2, C6220View c6220View, byte[] bArr2) {
        int i3 = this.seedSizeBytes + this.andSizeBytes;
        this.f23971digest.mo14969update((byte) 5);
        this.f23971digest.mo14970update(bArr, i2, this.seedSizeBytes);
        this.f23971digest.mo14998doFinal(bArr2, 0, this.digestSizeBytes);
        this.f23971digest.mo14970update(bArr2, 0, this.digestSizeBytes);
        if (i == 2) {
            this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(c6220View.inputShare), 0, this.stateSizeBytes);
            i3 += this.stateSizeBytes;
        }
        this.f23971digest.mo14970update(c6220View.communicatedBits, 0, this.andSizeBytes);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i3), 0, 2);
        this.f23971digest.mo14998doFinal(bArr2, 0, i3);
    }

    /* renamed from: H3 */
    private void m18089H3(int[] iArr, int[] iArr2, C6220View[][] c6220ViewArr, byte[][][] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][][] bArr5) {
        this.f23971digest.mo14969update((byte) 1);
        byte[] bArr6 = new byte[this.stateSizeWords * 4];
        for (int i = 0; i < this.numMPCRounds; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                AbstractC6245Pack.intToLittleEndian(c6220ViewArr[i][i2].outputShare, bArr6, 0);
                this.f23971digest.mo14970update(bArr6, 0, this.stateSizeBytes);
            }
        }
        m18094implH3(iArr, iArr2, bArr, bArr2, bArr3, bArr4, bArr5);
    }

    /* renamed from: HCP */
    private void m18091HCP(byte[] bArr, int[] iArr, int[] iArr2, byte[][] bArr2, byte[] bArr3, byte[] bArr4, int[] iArr3, int[] iArr4, byte[] bArr5) {
        for (int i = 0; i < this.numMPCRounds; i++) {
            this.f23971digest.mo14970update(bArr2[i], 0, this.digestSizeBytes);
        }
        byte[] bArr6 = new byte[32];
        this.f23971digest.mo14970update(bArr3, 0, this.digestSizeBytes);
        this.f23971digest.mo14970update(bArr4, 0, 32);
        updateDigest(iArr3, bArr6);
        updateDigest(iArr4, bArr6);
        this.f23971digest.mo14970update(bArr5, 0, bArr5.length);
        this.f23971digest.mo14998doFinal(bArr, 0, this.digestSizeBytes);
        if (iArr == null || iArr2 == null) {
            return;
        }
        expandChallengeHash(bArr, iArr, iArr2);
    }

    private void LowMCEnc(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        if (iArr != iArr2) {
            System.arraycopy(iArr, 0, iArr2, 0, this.stateSizeWords);
        }
        KMatricesWithPointer kMatricesWithPointerM18085KMatrix = this.lowmcConstants.m18085KMatrix(this, 0);
        matrix_mul(iArr4, iArr3, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
        xor_array(iArr2, iArr2, iArr4, 0);
        for (int i = 1; i <= this.numRounds; i++) {
            KMatricesWithPointer kMatricesWithPointerM18085KMatrix2 = this.lowmcConstants.m18085KMatrix(this, i);
            matrix_mul(iArr4, iArr3, kMatricesWithPointerM18085KMatrix2.m18081getData(), kMatricesWithPointerM18085KMatrix2.getMatrixPointer());
            substitution(iArr2);
            int i2 = i - 1;
            KMatricesWithPointer kMatricesWithPointerM18086LMatrix = this.lowmcConstants.m18086LMatrix(this, i2);
            matrix_mul(iArr2, iArr2, kMatricesWithPointerM18086LMatrix.m18081getData(), kMatricesWithPointerM18086LMatrix.getMatrixPointer());
            KMatricesWithPointer kMatricesWithPointerRConstant = this.lowmcConstants.RConstant(this, i2);
            xor_array(iArr2, iArr2, kMatricesWithPointerRConstant.m18081getData(), kMatricesWithPointerRConstant.getMatrixPointer());
            xor_array(iArr2, iArr2, iArr4, 0);
        }
    }

    public static int appendUnique(int[] iArr, int i, int i2) {
        if (i2 == 0) {
            iArr[i2] = i;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                if (iArr[i3] == i) {
                    return i2;
                }
            }
            iArr[i2] = i;
        }
        return i2 + 1;
    }

    private boolean arePaddingBitsZero(byte[] bArr, int i) {
        int iNumBytes = C6219Utils.numBytes(i);
        while (i < iNumBytes * 8) {
            if (C6219Utils.m18104getBit(bArr, i) != 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    private void aux_mpc_AND(int i, int i2, int i3, C6217Tape c6217Tape) {
        int i4 = this.numMPCParties - 1;
        C6219Utils.m18110setBit(c6217Tape.f23991tapes[i4], c6217Tape.f23990pos - 1, (byte) ((((i & i2) ^ (C6219Utils.parity16(c6217Tape.tapesToWord()) ^ C6219Utils.m18104getBit(c6217Tape.f23991tapes[i4], c6217Tape.f23990pos - 1))) ^ i3) & 255));
    }

    public static int bitsToChunks(int i, byte[] bArr, int i2, int[] iArr) {
        int i3 = i2 * 8;
        if (i > i3) {
            return 0;
        }
        int i4 = i3 / i;
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = 0;
            for (int i6 = 0; i6 < i; i6++) {
                iArr[i5] = iArr[i5] + (C6219Utils.m18104getBit(bArr, (i5 * i) + i6) << i6);
            }
        }
        return i4;
    }

    /* renamed from: commit */
    private void m18092commit(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2) {
        this.f23971digest.mo14970update(bArr2, 0, this.seedSizeBytes);
        if (bArr3 != null) {
            this.f23971digest.mo14970update(bArr3, 0, this.andSizeBytes);
        }
        this.f23971digest.mo14970update(bArr4, 0, 32);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i), 0, 2);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i2), 0, 2);
        this.f23971digest.mo14998doFinal(bArr, 0, this.digestSizeBytes);
    }

    private void commit_h(byte[] bArr, byte[][] bArr2) {
        for (int i = 0; i < this.numMPCParties; i++) {
            this.f23971digest.mo14970update(bArr2[i], 0, this.digestSizeBytes);
        }
        this.f23971digest.mo14998doFinal(bArr, 0, this.digestSizeBytes);
    }

    private void commit_v(byte[] bArr, byte[] bArr2, C6214Msg c6214Msg) {
        this.f23971digest.mo14970update(bArr2, 0, this.stateSizeBytes);
        for (int i = 0; i < this.numMPCParties; i++) {
            this.f23971digest.mo14970update(c6214Msg.f23968msgs[i], 0, C6219Utils.numBytes(c6214Msg.f23969pos));
        }
        this.f23971digest.mo14998doFinal(bArr, 0, this.digestSizeBytes);
    }

    private void computeSaltAndRootSeed(byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        updateDigest(iArr, bArr3);
        this.f23971digest.mo14970update(bArr2, 0, bArr2.length);
        updateDigest(iArr2, bArr3);
        updateDigest(iArr3, bArr3);
        AbstractC6245Pack.shortToLittleEndian((short) this.stateSizeBits, bArr3, 0);
        this.f23971digest.mo14970update(bArr3, 0, 2);
        this.f23971digest.mo14998doFinal(bArr, 0, bArr.length);
    }

    private byte[] computeSeeds(int[] iArr, int[] iArr2, int[] iArr3, byte[] bArr) {
        byte[] bArr2 = new byte[(this.seedSizeBytes * this.numMPCParties * this.numMPCRounds) + 32];
        byte[] bArr3 = new byte[32];
        updateDigest(iArr, bArr3);
        this.f23971digest.mo14970update(bArr, 0, bArr.length);
        updateDigest(iArr2, bArr3);
        updateDigest(iArr3, bArr3);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(this.stateSizeBits), 0, 2);
        this.f23971digest.mo14998doFinal(bArr2, 0, (this.seedSizeBytes * this.numMPCParties * this.numMPCRounds) + 32);
        return bArr2;
    }

    private boolean contains(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private int countNonZeroChallenges(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int iBitCount = 0;
        while (true) {
            int i5 = i3 + 16;
            i2 = this.numMPCRounds;
            if (i5 > i2) {
                break;
            }
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, (i3 >>> 2) + i);
            int i6 = iLittleEndianToInt >>> 1;
            i4 |= iLittleEndianToInt & i6;
            iBitCount += Integers.bitCount((iLittleEndianToInt ^ i6) & 1431655765);
            i3 = i5;
        }
        int i7 = (i2 - i3) * 2;
        if (i7 > 0) {
            int iLittleEndianToInt_Low = AbstractC6245Pack.littleEndianToInt_Low(bArr, i + (i3 >>> 2), (i7 + 7) / 8) & C6219Utils.getTrailingBitsMask(i7);
            int i8 = iLittleEndianToInt_Low >>> 1;
            i4 |= iLittleEndianToInt_Low & i8;
            iBitCount += Integers.bitCount((iLittleEndianToInt_Low ^ i8) & 1431655765);
        }
        if ((i4 & 1431655765) == 0) {
            return iBitCount;
        }
        return -1;
    }

    private boolean createRandomTape(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        if (i4 < this.digestSizeBytes) {
            return false;
        }
        this.f23971digest.mo14969update((byte) 2);
        this.f23971digest.mo14970update(bArr, i, this.seedSizeBytes);
        this.f23971digest.mo14998doFinal(bArr3, 0, this.digestSizeBytes);
        this.f23971digest.mo14970update(bArr3, 0, this.digestSizeBytes);
        this.f23971digest.mo14970update(bArr2, 0, 32);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i2), 0, 2);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i3), 0, 2);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i4), 0, 2);
        this.f23971digest.mo14998doFinal(bArr3, 0, i4);
        return true;
    }

    private void createRandomTapes(C6217Tape c6217Tape, byte[][] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.andSizeBytes * 2;
        for (int i4 = 0; i4 < this.numMPCParties; i4++) {
            this.f23971digest.mo14970update(bArr[i4 + i], 0, this.seedSizeBytes);
            this.f23971digest.mo14970update(bArr2, 0, 32);
            this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i2), 0, 2);
            this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(i4), 0, 2);
            this.f23971digest.mo14998doFinal(c6217Tape.f23991tapes[i4], 0, i3);
        }
    }

    private int deserializeSignature(Signature signature, byte[] bArr, int i, int i2) {
        int iCountNonZeroChallenges;
        Signature.C6215Proof[] c6215ProofArr = signature.f23977proofs;
        byte[] bArr2 = signature.challengeBits;
        int iNumBytes = C6219Utils.numBytes(this.numMPCRounds * 2);
        if (i < iNumBytes || (iCountNonZeroChallenges = countNonZeroChallenges(bArr, i2)) < 0) {
            return -1;
        }
        int i3 = this.stateSizeBytes * iCountNonZeroChallenges;
        int i4 = this.numMPCRounds;
        int i5 = iNumBytes + 32 + (((this.seedSizeBytes * 2) + this.andSizeBytes + this.digestSizeBytes) * i4) + i3;
        if (this.transform == 1) {
            i5 = i5 + (this.UnruhGWithInputBytes * (i4 - iCountNonZeroChallenges)) + (this.UnruhGWithoutInputBytes * iCountNonZeroChallenges);
        }
        if (i != i5) {
            f23970LOG.fine("sigBytesLen = " + i + ", expected bytesRequired = " + i5);
            return -1;
        }
        System.arraycopy(bArr, i2, bArr2, 0, iNumBytes);
        int i6 = i2 + iNumBytes;
        System.arraycopy(bArr, i6, signature.f23978salt, 0, 32);
        int i7 = i6 + 32;
        for (int i8 = 0; i8 < this.numMPCRounds; i8++) {
            int challenge = getChallenge(bArr2, i8);
            System.arraycopy(bArr, i7, c6215ProofArr[i8].view3Commitment, 0, this.digestSizeBytes);
            int i9 = i7 + this.digestSizeBytes;
            if (this.transform == 1) {
                int i10 = challenge == 0 ? this.UnruhGWithInputBytes : this.UnruhGWithoutInputBytes;
                System.arraycopy(bArr, i9, c6215ProofArr[i8].view3UnruhG, 0, i10);
                i9 += i10;
            }
            System.arraycopy(bArr, i9, c6215ProofArr[i8].communicatedBits, 0, this.andSizeBytes);
            int i11 = i9 + this.andSizeBytes;
            System.arraycopy(bArr, i11, c6215ProofArr[i8].f23979seed1, 0, this.seedSizeBytes);
            int i12 = this.seedSizeBytes;
            int i13 = i11 + i12;
            System.arraycopy(bArr, i13, c6215ProofArr[i8].f23980seed2, 0, i12);
            i7 = i13 + this.seedSizeBytes;
            if (challenge == 1 || challenge == 2) {
                AbstractC6245Pack.littleEndianToInt(bArr, i7, c6215ProofArr[i8].inputShare, 0, this.stateSizeBytes / 4);
                int i14 = this.stateSizeBits;
                if (i14 == 129) {
                    c6215ProofArr[i8].inputShare[this.stateSizeWords - 1] = bArr[(this.stateSizeBytes + i7) - 1] & C1126UByte.MAX_VALUE;
                }
                i7 += this.stateSizeBytes;
                if (!arePaddingBitsZero(c6215ProofArr[i8].inputShare, i14)) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private int deserializeSignature2(Signature2 signature2, byte[] bArr, int i, int i2) {
        Logger logger;
        String str;
        int i3 = this.digestSizeBytes;
        int i4 = i3 + 32;
        if (bArr.length < i4) {
            return -1;
        }
        System.arraycopy(bArr, i2, signature2.challengeHash, 0, i3);
        int i5 = i2 + this.digestSizeBytes;
        System.arraycopy(bArr, i5, signature2.f23983salt, 0, 32);
        int i6 = i5 + 32;
        expandChallengeHash(signature2.challengeHash, signature2.challengeC, signature2.challengeP);
        int iRevealSeedsSize = new C6218Tree(this, this.numMPCRounds, this.seedSizeBytes).revealSeedsSize(signature2.challengeC, this.numOpenedRounds);
        signature2.iSeedInfoLen = iRevealSeedsSize;
        int i7 = i4 + iRevealSeedsSize;
        int iOpenMerkleTreeSize = new C6218Tree(this, this.numMPCRounds, this.digestSizeBytes).openMerkleTreeSize(getMissingLeavesList(signature2.challengeC), this.numMPCRounds - this.numOpenedRounds);
        signature2.cvInfoLen = iOpenMerkleTreeSize;
        int i8 = i7 + iOpenMerkleTreeSize;
        int iRevealSeedsSize2 = new C6218Tree(this, this.numMPCParties, this.seedSizeBytes).revealSeedsSize(new int[1], 1);
        for (int i9 = 0; i9 < this.numMPCRounds; i9++) {
            if (contains(signature2.challengeC, this.numOpenedRounds, i9)) {
                if (signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i9)] != this.numMPCParties - 1) {
                    i8 += this.andSizeBytes;
                }
                i8 = i8 + iRevealSeedsSize2 + this.stateSizeBytes + this.andSizeBytes + this.digestSizeBytes;
            }
        }
        if (i == i8) {
            int i10 = signature2.iSeedInfoLen;
            byte[] bArr2 = new byte[i10];
            signature2.iSeedInfo = bArr2;
            System.arraycopy(bArr, i6, bArr2, 0, i10);
            int i11 = i6 + signature2.iSeedInfoLen;
            int i12 = signature2.cvInfoLen;
            byte[] bArr3 = new byte[i12];
            signature2.f23981cvInfo = bArr3;
            System.arraycopy(bArr, i11, bArr3, 0, i12);
            int i13 = i11 + signature2.cvInfoLen;
            for (int i14 = 0; i14 < this.numMPCRounds; i14++) {
                if (contains(signature2.challengeC, this.numOpenedRounds, i14)) {
                    signature2.f23982proofs[i14] = new Signature2.C6216Proof2(this);
                    Signature2.C6216Proof2 c6216Proof2 = signature2.f23982proofs[i14];
                    c6216Proof2.seedInfoLen = iRevealSeedsSize2;
                    byte[] bArr4 = new byte[iRevealSeedsSize2];
                    c6216Proof2.seedInfo = bArr4;
                    System.arraycopy(bArr, i13, bArr4, 0, iRevealSeedsSize2);
                    int i15 = i13 + signature2.f23982proofs[i14].seedInfoLen;
                    if (signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i14)] != this.numMPCParties - 1) {
                        System.arraycopy(bArr, i15, signature2.f23982proofs[i14].f23985aux, 0, this.andSizeBytes);
                        i15 += this.andSizeBytes;
                        if (!arePaddingBitsZero(signature2.f23982proofs[i14].f23985aux, this.numRounds * 3 * this.numSboxes)) {
                            logger = f23970LOG;
                            str = "failed while deserializing aux bits";
                        }
                    }
                    System.arraycopy(bArr, i15, signature2.f23982proofs[i14].f23986input, 0, this.stateSizeBytes);
                    int i16 = i15 + this.stateSizeBytes;
                    int i17 = this.andSizeBytes;
                    System.arraycopy(bArr, i16, signature2.f23982proofs[i14].f23987msgs, 0, i17);
                    int i18 = i16 + i17;
                    if (arePaddingBitsZero(signature2.f23982proofs[i14].f23987msgs, this.numRounds * 3 * this.numSboxes)) {
                        System.arraycopy(bArr, i18, signature2.f23982proofs[i14].f23984C, 0, this.digestSizeBytes);
                        i13 = i18 + this.digestSizeBytes;
                    } else {
                        logger = f23970LOG;
                        str = "failed while deserializing msgs bits";
                    }
                }
            }
            return 0;
        }
        logger = f23970LOG;
        str = "sigLen = " + i + ", expected bytesRequired = " + i8;
        logger.fine(str);
        return -1;
    }

    private void expandChallengeHash(byte[] bArr, int[] iArr, int[] iArr2) {
        int iCeil_log2 = C6219Utils.ceil_log2(this.numMPCRounds);
        int iCeil_log22 = C6219Utils.ceil_log2(this.numMPCParties);
        int[] iArr3 = new int[(this.digestSizeBytes * 8) / Math.min(iCeil_log2, iCeil_log22)];
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, this.digestSizeBytes);
        int iAppendUnique = 0;
        while (iAppendUnique < this.numOpenedRounds) {
            int iBitsToChunks = bitsToChunks(iCeil_log2, bArr2, this.digestSizeBytes, iArr3);
            for (int i = 0; i < iBitsToChunks; i++) {
                int i2 = iArr3[i];
                if (i2 < this.numMPCRounds) {
                    iAppendUnique = appendUnique(iArr, i2, iAppendUnique);
                }
                if (iAppendUnique == this.numOpenedRounds) {
                    break;
                }
            }
            this.f23971digest.mo14969update((byte) 1);
            this.f23971digest.mo14970update(bArr2, 0, this.digestSizeBytes);
            this.f23971digest.mo14998doFinal(bArr2, 0, this.digestSizeBytes);
        }
        int i3 = 0;
        while (i3 < this.numOpenedRounds) {
            int iBitsToChunks2 = bitsToChunks(iCeil_log22, bArr2, this.digestSizeBytes, iArr3);
            for (int i4 = 0; i4 < iBitsToChunks2; i4++) {
                int i5 = iArr3[i4];
                if (i5 < this.numMPCParties) {
                    iArr2[i3] = i5;
                    i3++;
                }
                if (i3 == this.numOpenedRounds) {
                    break;
                }
            }
            this.f23971digest.mo14969update((byte) 1);
            this.f23971digest.mo14970update(bArr2, 0, this.digestSizeBytes);
            this.f23971digest.mo14998doFinal(bArr2, 0, this.digestSizeBytes);
        }
    }

    /* renamed from: extend */
    public static int m18093extend(int i) {
        return ~(i - 1);
    }

    private void getAuxBits(byte[] bArr, C6217Tape c6217Tape) {
        byte[] bArr2 = c6217Tape.f23991tapes[this.numMPCParties - 1];
        int i = this.stateSizeBits;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.numRounds; i4++) {
            i2 += i;
            int i5 = 0;
            while (i5 < i) {
                C6219Utils.m18110setBit(bArr, i3, C6219Utils.m18104getBit(bArr2, i2));
                i5++;
                i3++;
                i2++;
            }
        }
    }

    private int[] getMissingLeavesList(int[] iArr) {
        int[] iArr2 = new int[this.numMPCRounds - this.numOpenedRounds];
        int i = 0;
        for (int i2 = 0; i2 < this.numMPCRounds; i2++) {
            if (!contains(iArr, this.numOpenedRounds, i2)) {
                iArr2[i] = i2;
                i++;
            }
        }
        return iArr2;
    }

    /* renamed from: implH3 */
    private void m18094implH3(int[] iArr, int[] iArr2, byte[][][] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][][] bArr5) {
        byte[] bArr6 = new byte[this.digestSizeBytes];
        bArr2[C6219Utils.numBytes(this.numMPCRounds * 2) - 1] = 0;
        for (int i = 0; i < this.numMPCRounds; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f23971digest.mo14970update(bArr[i][i2], 0, this.digestSizeBytes);
            }
        }
        if (this.transform == 1) {
            for (int i3 = 0; i3 < this.numMPCRounds; i3++) {
                int i4 = 0;
                while (i4 < 3) {
                    this.f23971digest.mo14970update(bArr5[i3][i4], 0, i4 == 2 ? this.UnruhGWithInputBytes : this.UnruhGWithoutInputBytes);
                    i4++;
                }
            }
        }
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(iArr), 0, this.stateSizeBytes);
        this.f23971digest.mo14970update(AbstractC6245Pack.intToLittleEndian(iArr2), 0, this.stateSizeBytes);
        this.f23971digest.mo14970update(bArr3, 0, 32);
        this.f23971digest.mo14970update(bArr4, 0, bArr4.length);
        this.f23971digest.mo14998doFinal(bArr6, 0, this.digestSizeBytes);
        boolean z = true;
        int i5 = 0;
        while (z) {
            for (int i6 = 0; i6 < this.digestSizeBytes; i6++) {
                byte b = bArr6[i6];
                int i7 = 0;
                while (true) {
                    if (i7 >= 8) {
                        break;
                    }
                    int i8 = (b >>> (6 - i7)) & 3;
                    if (i8 < 3) {
                        setChallenge(bArr2, i5, i8);
                        i5++;
                        if (i5 == this.numMPCRounds) {
                            z = false;
                            break;
                        }
                    }
                    i7 += 2;
                }
                if (!z) {
                    break;
                }
            }
            if (!z) {
                return;
            }
            this.f23971digest.mo14969update((byte) 1);
            this.f23971digest.mo14970update(bArr6, 0, this.digestSizeBytes);
            this.f23971digest.mo14998doFinal(bArr6, 0, this.digestSizeBytes);
        }
    }

    /* renamed from: indexOf */
    public static int m18095indexOf(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean is_picnic3(int i) {
        return i == 7 || i == 8 || i == 9;
    }

    /* renamed from: mpc_AND */
    private int m18096mpc_AND(int i, int i2, int i3, int i4, C6217Tape c6217Tape, C6214Msg c6214Msg) {
        int iM18093extend = ((i3 & m18093extend(i2)) ^ (i4 & m18093extend(i))) ^ c6217Tape.tapesToWord();
        int i5 = c6214Msg.unopened;
        if (i5 >= 0) {
            iM18093extend = C6219Utils.m18109setBit(iM18093extend, c6214Msg.unopened, C6219Utils.m18104getBit(c6214Msg.f23968msgs[i5], c6214Msg.f23969pos));
        }
        wordToMsgs(iM18093extend, c6214Msg);
        return C6219Utils.parity16(iM18093extend) ^ (i & i2);
    }

    private void mpc_LowMC(C6217Tape c6217Tape, C6220View[] c6220ViewArr, int[] iArr, int[] iArr2) {
        C6238Arrays.m18254fill(iArr2, 0, iArr2.length, 0);
        int i = this.stateSizeWords;
        mpc_xor_constant(iArr2, i * 3, iArr, 0, i);
        KMatricesWithPointer kMatricesWithPointerM18085KMatrix = this.lowmcConstants.m18085KMatrix(this, 0);
        for (int i2 = 0; i2 < 3; i2++) {
            matrix_mul_offset(iArr2, i2 * this.stateSizeWords, c6220ViewArr[i2].inputShare, 0, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
        }
        m18098mpc_xor(iArr2, iArr2, 3);
        for (int i3 = 1; i3 <= this.numRounds; i3++) {
            KMatricesWithPointer kMatricesWithPointerM18085KMatrix2 = this.lowmcConstants.m18085KMatrix(this, i3);
            for (int i4 = 0; i4 < 3; i4++) {
                matrix_mul_offset(iArr2, i4 * this.stateSizeWords, c6220ViewArr[i4].inputShare, 0, kMatricesWithPointerM18085KMatrix2.m18081getData(), kMatricesWithPointerM18085KMatrix2.getMatrixPointer());
            }
            mpc_substitution(iArr2, c6217Tape, c6220ViewArr);
            int i5 = i3 - 1;
            KMatricesWithPointer kMatricesWithPointerM18086LMatrix = this.lowmcConstants.m18086LMatrix(this, i5);
            int i6 = this.stateSizeWords;
            mpc_matrix_mul(iArr2, i6 * 3, iArr2, i6 * 3, kMatricesWithPointerM18086LMatrix.m18081getData(), kMatricesWithPointerM18086LMatrix.getMatrixPointer(), 3);
            KMatricesWithPointer kMatricesWithPointerRConstant = this.lowmcConstants.RConstant(this, i5);
            mpc_xor_constant(iArr2, this.stateSizeWords * 3, kMatricesWithPointerRConstant.m18081getData(), kMatricesWithPointerRConstant.getMatrixPointer(), this.stateSizeWords);
            m18098mpc_xor(iArr2, iArr2, 3);
        }
        for (int i7 = 0; i7 < 3; i7++) {
            int i8 = this.stateSizeWords;
            System.arraycopy(iArr2, (i7 + 3) * i8, c6220ViewArr[i7].outputShare, 0, i8);
        }
    }

    private void mpc_matrix_mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.stateSizeWords;
            matrix_mul_offset(iArr, i + (i5 * i6), iArr2, i2 + (i6 * i5), iArr3, i3);
        }
    }

    private void mpc_sbox(int[] iArr, int[] iArr2, C6217Tape c6217Tape, C6214Msg c6214Msg) {
        for (int i = 0; i < this.numSboxes * 3; i += 3) {
            int i2 = i + 2;
            int bitFromWordArray = C6219Utils.getBitFromWordArray(iArr, i2);
            int i3 = iArr2[i2];
            int i4 = i + 1;
            int bitFromWordArray2 = C6219Utils.getBitFromWordArray(iArr, i4);
            int i5 = iArr2[i4];
            int bitFromWordArray3 = C6219Utils.getBitFromWordArray(iArr, i);
            int i6 = iArr2[i];
            int iM18096mpc_AND = m18096mpc_AND(bitFromWordArray, bitFromWordArray2, i3, i5, c6217Tape, c6214Msg);
            int iM18096mpc_AND2 = m18096mpc_AND(bitFromWordArray2, bitFromWordArray3, i5, i6, c6217Tape, c6214Msg);
            int i7 = bitFromWordArray ^ bitFromWordArray2;
            int iM18096mpc_AND3 = m18096mpc_AND(bitFromWordArray3, bitFromWordArray, i6, i3, c6217Tape, c6214Msg) ^ i7;
            C6219Utils.setBitInWordArray(iArr, i2, bitFromWordArray ^ iM18096mpc_AND2);
            C6219Utils.setBitInWordArray(iArr, i4, iM18096mpc_AND3);
            C6219Utils.setBitInWordArray(iArr, i, (i7 ^ bitFromWordArray3) ^ iM18096mpc_AND);
        }
    }

    private void mpc_substitution(int[] iArr, C6217Tape c6217Tape, C6220View[] c6220ViewArr) {
        int[] iArr2 = new int[3];
        int[] iArr3 = new int[3];
        int[] iArr4 = new int[3];
        int[] iArr5 = new int[3];
        int[] iArr6 = new int[3];
        int[] iArr7 = new int[3];
        int i = 0;
        while (i < this.numSboxes * 3) {
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = ((i2 + 3) * this.stateSizeWords * 32) + i;
                iArr2[i2] = C6219Utils.getBitFromWordArray(iArr, i3 + 2);
                iArr3[i2] = C6219Utils.getBitFromWordArray(iArr, i3 + 1);
                iArr4[i2] = C6219Utils.getBitFromWordArray(iArr, i3);
            }
            int i4 = i;
            m18097mpc_AND(iArr2, iArr3, iArr5, c6217Tape, c6220ViewArr);
            m18097mpc_AND(iArr3, iArr4, iArr6, c6217Tape, c6220ViewArr);
            m18097mpc_AND(iArr4, iArr2, iArr7, c6217Tape, c6220ViewArr);
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = ((i5 + 3) * this.stateSizeWords * 32) + i4;
                C6219Utils.setBitInWordArray(iArr, i6 + 2, iArr2[i5] ^ iArr6[i5]);
                C6219Utils.setBitInWordArray(iArr, i6 + 1, (iArr2[i5] ^ iArr3[i5]) ^ iArr7[i5]);
                C6219Utils.setBitInWordArray(iArr, i6, ((iArr2[i5] ^ iArr3[i5]) ^ iArr4[i5]) ^ iArr5[i5]);
            }
            i = i4 + 3;
        }
    }

    /* renamed from: mpc_xor */
    private void m18098mpc_xor(int[] iArr, int[] iArr2, int i) {
        int i2 = this.stateSizeWords * i;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (this.stateSizeWords * i) + i3;
            iArr[i4] = iArr[i4] ^ iArr2[i3];
        }
    }

    private void mpc_xor_constant(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 + i;
            iArr[i5] = iArr[i5] ^ iArr2[i4 + i2];
        }
    }

    private void mpc_xor_constant_verify(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4;
        if (i3 == 0) {
            i4 = this.stateSizeWords * 2;
        } else if (i3 != 2) {
            return;
        } else {
            i4 = this.stateSizeWords * 3;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 + i4;
            iArr[i6] = iArr[i6] ^ iArr2[i5 + i];
        }
    }

    private void picnic_keygen(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        int[] iArr = new int[bArr3.length / 4];
        int[] iArr2 = new int[bArr.length / 4];
        int[] iArr3 = new int[bArr2.length / 4];
        secureRandom.nextBytes(bArr3);
        AbstractC6245Pack.littleEndianToInt(bArr3, 0, iArr);
        C6219Utils.zeroTrailingBits(iArr, this.stateSizeBits);
        secureRandom.nextBytes(bArr);
        AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr2);
        C6219Utils.zeroTrailingBits(iArr2, this.stateSizeBits);
        LowMCEnc(iArr2, iArr3, iArr);
        AbstractC6245Pack.intToLittleEndian(iArr, bArr3, 0);
        AbstractC6245Pack.intToLittleEndian(iArr2, bArr, 0);
        AbstractC6245Pack.intToLittleEndian(iArr3, bArr2, 0);
    }

    private void picnic_read_public_key(int[] iArr, int[] iArr2, byte[] bArr) {
        int i = this.stateSizeBytes;
        int i2 = i + 1;
        int i3 = i / 4;
        AbstractC6245Pack.littleEndianToInt(bArr, 1, iArr, 0, i3);
        AbstractC6245Pack.littleEndianToInt(bArr, i2, iArr2, 0, i3);
        if (i3 < this.stateSizeWords) {
            int i4 = i3 * 4;
            int i5 = this.stateSizeBytes - i4;
            iArr[i3] = AbstractC6245Pack.littleEndianToInt_Low(bArr, i4 + 1, i5);
            iArr2[i3] = AbstractC6245Pack.littleEndianToInt_Low(bArr, i2 + i4, i5);
        }
    }

    private boolean picnic_sign(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int iSerializeSignature2;
        int i = this.stateSizeWords;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int i2 = this.stateSizeBytes;
        int i3 = i2 + 1;
        int i4 = (i2 * 2) + 1;
        int i5 = i2 / 4;
        AbstractC6245Pack.littleEndianToInt(bArr, 1, iArr, 0, i5);
        AbstractC6245Pack.littleEndianToInt(bArr, i3, iArr2, 0, i5);
        AbstractC6245Pack.littleEndianToInt(bArr, i4, iArr3, 0, i5);
        if (i5 < this.stateSizeWords) {
            int i6 = i5 * 4;
            int i7 = this.stateSizeBytes - i6;
            iArr[i5] = AbstractC6245Pack.littleEndianToInt_Low(bArr, i6 + 1, i7);
            iArr2[i5] = AbstractC6245Pack.littleEndianToInt_Low(bArr, i3 + i6, i7);
            iArr3[i5] = AbstractC6245Pack.littleEndianToInt_Low(bArr, i4 + i6, i7);
        }
        if (is_picnic3(this.parameters)) {
            Signature2 signature2 = new Signature2(this);
            if (!sign_picnic3(iArr, iArr2, iArr3, bArr2, signature2)) {
                f23970LOG.fine("Failed to create signature");
                return false;
            }
            iSerializeSignature2 = serializeSignature2(signature2, bArr3, bArr2.length + 4);
            if (iSerializeSignature2 < 0) {
                f23970LOG.fine("Failed to serialize signature");
                return false;
            }
        } else {
            Signature signature = new Signature(this);
            if (sign_picnic1(iArr, iArr2, iArr3, bArr2, signature) != 0) {
                f23970LOG.fine("Failed to create signature");
                return false;
            }
            iSerializeSignature2 = serializeSignature(signature, bArr3, bArr2.length + 4);
            if (iSerializeSignature2 < 0) {
                f23970LOG.fine("Failed to serialize signature");
                return false;
            }
        }
        this.signatureLength = iSerializeSignature2;
        AbstractC6245Pack.intToLittleEndian(iSerializeSignature2, bArr3, 0);
        return true;
    }

    private int picnic_verify(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        Logger logger;
        String str;
        int i2 = this.stateSizeWords;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        picnic_read_public_key(iArr, iArr2, bArr);
        if (is_picnic3(this.parameters)) {
            Signature2 signature2 = new Signature2(this);
            if (deserializeSignature2(signature2, bArr3, i, bArr2.length + 4) == 0) {
                return verify_picnic3(signature2, iArr, iArr2, bArr2);
            }
            logger = f23970LOG;
            str = "Error couldn't deserialize signature (2)!";
        } else {
            Signature signature = new Signature(this);
            if (deserializeSignature(signature, bArr3, i, bArr2.length + 4) == 0) {
                return m18099verify(signature, iArr, iArr2, bArr2);
            }
            logger = f23970LOG;
            str = "Error couldn't deserialize signature!";
        }
        logger.fine(str);
        return -1;
    }

    private int picnic_write_private_key(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i = this.stateSizeBytes;
        int i2 = (i * 3) + 1;
        if (bArr4.length < i2) {
            f23970LOG.fine("Failed writing private key!");
            return -1;
        }
        bArr4[0] = (byte) this.parameters;
        System.arraycopy(bArr, 0, bArr4, 1, i);
        int i3 = this.stateSizeBytes;
        System.arraycopy(bArr2, 0, bArr4, i3 + 1, i3);
        int i4 = this.stateSizeBytes;
        System.arraycopy(bArr3, 0, bArr4, (i4 * 2) + 1, i4);
        return i2;
    }

    private int picnic_write_public_key(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = this.stateSizeBytes;
        int i2 = (i * 2) + 1;
        if (bArr3.length < i2) {
            f23970LOG.fine("Failed writing public key!");
            return -1;
        }
        bArr3[0] = (byte) this.parameters;
        System.arraycopy(bArr, 0, bArr3, 1, i);
        int i3 = this.stateSizeBytes;
        System.arraycopy(bArr2, 0, bArr3, i3 + 1, i3);
        return i2;
    }

    private int serializeSignature2(Signature2 signature2, byte[] bArr, int i) {
        int i2 = this.digestSizeBytes + 32 + signature2.iSeedInfoLen + signature2.cvInfoLen;
        for (int i3 = 0; i3 < this.numMPCRounds; i3++) {
            if (contains(signature2.challengeC, this.numOpenedRounds, i3)) {
                int i4 = signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i3)];
                int i5 = i2 + signature2.f23982proofs[i3].seedInfoLen;
                if (i4 != this.numMPCParties - 1) {
                    i5 += this.andSizeBytes;
                }
                i2 = i5 + this.stateSizeBytes + this.andSizeBytes + this.digestSizeBytes;
            }
        }
        if (bArr.length < i2) {
            return -1;
        }
        System.arraycopy(signature2.challengeHash, 0, bArr, i, this.digestSizeBytes);
        int i6 = this.digestSizeBytes + i;
        System.arraycopy(signature2.f23983salt, 0, bArr, i6, 32);
        int i7 = i6 + 32;
        System.arraycopy(signature2.iSeedInfo, 0, bArr, i7, signature2.iSeedInfoLen);
        int i8 = i7 + signature2.iSeedInfoLen;
        System.arraycopy(signature2.f23981cvInfo, 0, bArr, i8, signature2.cvInfoLen);
        int i9 = i8 + signature2.cvInfoLen;
        for (int i10 = 0; i10 < this.numMPCRounds; i10++) {
            if (contains(signature2.challengeC, this.numOpenedRounds, i10)) {
                Signature2.C6216Proof2 c6216Proof2 = signature2.f23982proofs[i10];
                System.arraycopy(c6216Proof2.seedInfo, 0, bArr, i9, c6216Proof2.seedInfoLen);
                int i11 = i9 + signature2.f23982proofs[i10].seedInfoLen;
                if (signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i10)] != this.numMPCParties - 1) {
                    System.arraycopy(signature2.f23982proofs[i10].f23985aux, 0, bArr, i11, this.andSizeBytes);
                    i11 += this.andSizeBytes;
                }
                System.arraycopy(signature2.f23982proofs[i10].f23986input, 0, bArr, i11, this.stateSizeBytes);
                int i12 = i11 + this.stateSizeBytes;
                System.arraycopy(signature2.f23982proofs[i10].f23987msgs, 0, bArr, i12, this.andSizeBytes);
                int i13 = i12 + this.andSizeBytes;
                System.arraycopy(signature2.f23982proofs[i10].f23984C, 0, bArr, i13, this.digestSizeBytes);
                i9 = i13 + this.digestSizeBytes;
            }
        }
        return i9 - i;
    }

    private void setChallenge(byte[] bArr, int i, int i2) {
        int i3 = i * 2;
        C6219Utils.m18110setBit(bArr, i3, (byte) (i2 & 1));
        C6219Utils.m18110setBit(bArr, i3 + 1, (byte) ((i2 >>> 1) & 1));
    }

    private int sign_picnic1(int[] iArr, int[] iArr2, int[] iArr3, byte[] bArr, Signature signature) {
        byte[] bArr2;
        int i;
        int i2 = 2;
        char c = 1;
        int i3 = 0;
        C6220View[][] c6220ViewArr = (C6220View[][]) Array.newInstance((Class<?>) C6220View.class, this.numMPCRounds, 3);
        int[] iArr4 = {this.numMPCRounds, this.numMPCParties, this.digestSizeBytes};
        Class cls = Byte.TYPE;
        byte[][][] bArr3 = (byte[][][]) Array.newInstance((Class<?>) cls, iArr4);
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) cls, this.numMPCRounds, 3, this.UnruhGWithInputBytes);
        byte[] bArrComputeSeeds = computeSeeds(iArr, iArr2, iArr3, bArr);
        int i4 = this.numMPCParties * this.seedSizeBytes;
        System.arraycopy(bArrComputeSeeds, this.numMPCRounds * i4, signature.f23978salt, 0, 32);
        C6217Tape c6217Tape = new C6217Tape(this);
        int i5 = this.stateSizeBytes;
        int iMax = Math.max(i5 * 9, i5 + this.andSizeBytes);
        byte[] bArr5 = new byte[iMax];
        int i6 = 0;
        while (i6 < this.numMPCRounds) {
            c6220ViewArr[i6][i3] = new C6220View(this);
            c6220ViewArr[i6][c] = new C6220View(this);
            c6220ViewArr[i6][i2] = new C6220View(this);
            int i7 = i3;
            while (i7 < i2) {
                byte[][][] bArr6 = bArr4;
                int i8 = i7;
                int i9 = i6;
                byte[] bArr7 = bArr5;
                int i10 = iMax;
                byte[][][] bArr8 = bArr3;
                C6217Tape c6217Tape2 = c6217Tape;
                byte[] bArr9 = bArrComputeSeeds;
                if (!createRandomTape(bArrComputeSeeds, (this.seedSizeBytes * i7) + (i4 * i6), signature.f23978salt, i9, i8, bArr7, this.stateSizeBytes + this.andSizeBytes)) {
                    f23970LOG.fine("createRandomTape failed");
                    return -1;
                }
                int[] iArr5 = c6220ViewArr[i9][i8].inputShare;
                AbstractC6245Pack.littleEndianToInt(bArr7, 0, iArr5);
                C6219Utils.zeroTrailingBits(iArr5, this.stateSizeBits);
                System.arraycopy(bArr7, this.stateSizeBytes, c6217Tape2.f23991tapes[i8], 0, this.andSizeBytes);
                i7 = i8 + 1;
                i6 = i9;
                bArr5 = bArr7;
                c6217Tape = c6217Tape2;
                bArr4 = bArr6;
                iMax = i10;
                bArr3 = bArr8;
                bArrComputeSeeds = bArr9;
                i2 = 2;
            }
            int i11 = i6;
            byte[] bArr10 = bArr5;
            int i12 = iMax;
            byte[] bArr11 = bArrComputeSeeds;
            byte[][][] bArr12 = bArr3;
            byte[][][] bArr13 = bArr4;
            C6217Tape c6217Tape3 = c6217Tape;
            int i13 = i4 * i11;
            if (!createRandomTape(bArr11, i13 + (this.seedSizeBytes * 2), signature.f23978salt, i11, 2, c6217Tape3.f23991tapes[2], this.andSizeBytes)) {
                f23970LOG.fine("createRandomTape failed");
                return -1;
            }
            C6220View[] c6220ViewArr2 = c6220ViewArr[i11];
            xor_three(c6220ViewArr2[2].inputShare, iArr, c6220ViewArr2[0].inputShare, c6220ViewArr2[1].inputShare);
            c6217Tape3.f23990pos = 0;
            int[] iArrLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr10, 0, i12 / 4);
            mpc_LowMC(c6217Tape3, c6220ViewArr[i11], iArr3, iArrLittleEndianToInt);
            AbstractC6245Pack.intToLittleEndian(iArrLittleEndianToInt, bArr10, 0);
            int[] iArr6 = new int[16];
            C6220View[] c6220ViewArr3 = c6220ViewArr[i11];
            xor_three(iArr6, c6220ViewArr3[0].outputShare, c6220ViewArr3[1].outputShare, c6220ViewArr3[2].outputShare);
            if (!subarrayEquals(iArr6, iArr2, this.stateSizeWords)) {
                f23970LOG.fine("Simulation failed; output does not match public key (round = " + i11 + ")");
                return -1;
            }
            m18087Commit(bArr11, i13, c6220ViewArr[i11][0], bArr12[i11][0]);
            m18087Commit(bArr11, this.seedSizeBytes + i13, c6220ViewArr[i11][1], bArr12[i11][1]);
            m18087Commit(bArr11, (this.seedSizeBytes * 2) + i13, c6220ViewArr[i11][2], bArr12[i11][2]);
            if (this.transform == 1) {
                bArr2 = bArr11;
                m18088G(0, bArr11, i13, c6220ViewArr[i11][0], bArr13[i11][0]);
                m18088G(1, bArr2, i13 + this.seedSizeBytes, c6220ViewArr[i11][1], bArr13[i11][1]);
                i = 2;
                m18088G(2, bArr2, i13 + (this.seedSizeBytes * 2), c6220ViewArr[i11][2], bArr13[i11][2]);
            } else {
                bArr2 = bArr11;
                i = 2;
            }
            i6 = i11 + 1;
            bArr5 = bArr10;
            c6217Tape = c6217Tape3;
            i2 = i;
            bArr4 = bArr13;
            bArrComputeSeeds = bArr2;
            iMax = i12;
            bArr3 = bArr12;
            c = 1;
            i3 = 0;
        }
        byte[] bArr14 = bArrComputeSeeds;
        byte[][][] bArr15 = bArr3;
        byte[][][] bArr16 = bArr4;
        m18089H3(iArr2, iArr3, c6220ViewArr, bArr15, signature.challengeBits, signature.f23978salt, bArr, bArr16);
        for (int i14 = 0; i14 < this.numMPCRounds; i14++) {
            m18100prove(signature.f23977proofs[i14], getChallenge(signature.challengeBits, i14), bArr14, i4 * i14, c6220ViewArr[i14], bArr15[i14], this.transform != 1 ? null : bArr16[i14]);
        }
        return 0;
    }

    private boolean sign_picnic3(int[] iArr, int[] iArr2, int[] iArr3, byte[] bArr, Signature2 signature2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.seedSizeBytes + 32;
        byte[] bArr2 = new byte[i5];
        computeSaltAndRootSeed(bArr2, iArr, iArr2, iArr3, bArr);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr2, 32, i5);
        signature2.f23983salt = C6238Arrays.copyOfRange(bArr2, 0, 32);
        C6218Tree c6218Tree = new C6218Tree(this, this.numMPCRounds, this.seedSizeBytes);
        c6218Tree.generateSeeds(bArrCopyOfRange, signature2.f23983salt, 0);
        byte[][] leaves = c6218Tree.getLeaves();
        int leavesOffset = c6218Tree.getLeavesOffset();
        int i6 = this.numMPCRounds;
        C6217Tape[] c6217TapeArr = new C6217Tape[i6];
        C6218Tree[] c6218TreeArr = new C6218Tree[i6];
        int i7 = 0;
        while (true) {
            i = this.numMPCRounds;
            if (i7 >= i) {
                break;
            }
            c6217TapeArr[i7] = new C6217Tape(this);
            C6218Tree c6218Tree2 = new C6218Tree(this, this.numMPCParties, this.seedSizeBytes);
            c6218TreeArr[i7] = c6218Tree2;
            c6218Tree2.generateSeeds(leaves[i7 + leavesOffset], signature2.f23983salt, i7);
            createRandomTapes(c6217TapeArr[i7], c6218TreeArr[i7].getLeaves(), c6218TreeArr[i7].getLeavesOffset(), signature2.f23983salt, i7);
            i7++;
        }
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, this.stateSizeWords * 4);
        byte[] bArr4 = new byte[MAX_AUX_BYTES];
        int i8 = 0;
        while (true) {
            i2 = this.numMPCRounds;
            if (i8 >= i2) {
                break;
            }
            c6217TapeArr[i8].computeAuxTape(bArr3[i8]);
            i8++;
        }
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) Byte.TYPE, i2, this.numMPCParties, this.digestSizeBytes);
        int i9 = 0;
        while (true) {
            i3 = this.numMPCRounds;
            if (i9 >= i3) {
                break;
            }
            int i10 = 0;
            while (true) {
                i4 = this.numMPCParties;
                if (i10 < i4 - 1) {
                    int i11 = i10;
                    m18092commit(bArr5[i9][i10], c6218TreeArr[i9].m18103getLeaf(i10), null, signature2.f23983salt, i9, i11);
                    i10 = i11 + 1;
                    i9 = i9;
                }
            }
            int i12 = i9;
            int i13 = i4 - 1;
            getAuxBits(bArr4, c6217TapeArr[i12]);
            m18092commit(bArr5[i12][i13], c6218TreeArr[i12].m18103getLeaf(i13), bArr4, signature2.f23983salt, i12, i13);
            i9 = i12 + 1;
        }
        C6214Msg[] c6214MsgArr = new C6214Msg[i3];
        int[] iArr4 = new int[this.stateSizeBits];
        int i14 = 0;
        while (true) {
            int i15 = this.numMPCRounds;
            if (i14 >= i15) {
                int[] iArr5 = {i15, this.digestSizeBytes};
                Class cls = Byte.TYPE;
                byte[][] bArr6 = (byte[][]) Array.newInstance((Class<?>) cls, iArr5);
                byte[][] bArr7 = (byte[][]) Array.newInstance((Class<?>) cls, this.numMPCRounds, this.digestSizeBytes);
                for (int i16 = 0; i16 < this.numMPCRounds; i16++) {
                    commit_h(bArr6[i16], bArr5[i16]);
                    commit_v(bArr7[i16], bArr3[i16], c6214MsgArr[i16]);
                }
                C6218Tree c6218Tree3 = new C6218Tree(this, this.numMPCRounds, this.digestSizeBytes);
                c6218Tree3.buildMerkleTree(bArr7, signature2.f23983salt);
                int i17 = this.numOpenedRounds;
                int[] iArr6 = new int[i17];
                signature2.challengeC = iArr6;
                int[] iArr7 = new int[i17];
                signature2.challengeP = iArr7;
                byte[] bArr8 = new byte[this.digestSizeBytes];
                signature2.challengeHash = bArr8;
                m18091HCP(bArr8, iArr6, iArr7, bArr6, c6218Tree3.f23996nodes[0], signature2.f23983salt, iArr2, iArr3, bArr);
                int[] iArr8 = new int[1];
                signature2.f23981cvInfo = c6218Tree3.openMerkleTree(getMissingLeavesList(signature2.challengeC), this.numMPCRounds - this.numOpenedRounds, iArr8);
                signature2.cvInfoLen = iArr8[0];
                int i18 = this.numMPCRounds;
                int i19 = this.seedSizeBytes;
                byte[] bArr9 = new byte[i18 * i19];
                signature2.iSeedInfo = bArr9;
                signature2.iSeedInfoLen = c6218Tree.revealSeeds(signature2.challengeC, this.numOpenedRounds, bArr9, i18 * i19);
                signature2.f23982proofs = new Signature2.C6216Proof2[this.numMPCRounds];
                for (int i20 = 0; i20 < this.numMPCRounds; i20++) {
                    if (contains(signature2.challengeC, this.numOpenedRounds, i20)) {
                        signature2.f23982proofs[i20] = new Signature2.C6216Proof2(this);
                        int iM18095indexOf = m18095indexOf(signature2.challengeC, this.numOpenedRounds, i20);
                        int[] iArr9 = {signature2.challengeP[iM18095indexOf]};
                        Signature2.C6216Proof2 c6216Proof2 = signature2.f23982proofs[i20];
                        int i21 = this.numMPCParties;
                        int i22 = this.seedSizeBytes;
                        byte[] bArr10 = new byte[i21 * i22];
                        c6216Proof2.seedInfo = bArr10;
                        c6216Proof2.seedInfoLen = c6218TreeArr[i20].revealSeeds(iArr9, 1, bArr10, i21 * i22);
                        if (signature2.challengeP[iM18095indexOf] != this.numMPCParties - 1) {
                            getAuxBits(signature2.f23982proofs[i20].f23985aux, c6217TapeArr[i20]);
                        }
                        System.arraycopy(bArr3[i20], 0, signature2.f23982proofs[i20].f23986input, 0, this.stateSizeBytes);
                        System.arraycopy(c6214MsgArr[i20].f23968msgs[signature2.challengeP[iM18095indexOf]], 0, signature2.f23982proofs[i20].f23987msgs, 0, this.andSizeBytes);
                        System.arraycopy(bArr5[i20][signature2.challengeP[iM18095indexOf]], 0, signature2.f23982proofs[i20].f23984C, 0, this.digestSizeBytes);
                    }
                }
                return true;
            }
            c6214MsgArr[i14] = new C6214Msg(this);
            int[] iArrLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr3[i14], 0, this.stateSizeWords);
            xor_array(iArrLittleEndianToInt, iArrLittleEndianToInt, iArr, 0);
            int i23 = i14;
            int[] iArr10 = iArr4;
            if (simulateOnline(iArrLittleEndianToInt, c6217TapeArr[i14], iArr4, c6214MsgArr[i14], iArr3, iArr2) != 0) {
                f23970LOG.fine("MPC simulation failed, aborting signature");
                return false;
            }
            AbstractC6245Pack.intToLittleEndian(iArrLittleEndianToInt, bArr3[i23], 0);
            i14 = i23 + 1;
            iArr4 = iArr10;
        }
    }

    private int simulateOnline(int[] iArr, C6217Tape c6217Tape, int[] iArr2, C6214Msg c6214Msg, int[] iArr3, int[] iArr4) {
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        KMatricesWithPointer kMatricesWithPointerM18085KMatrix = this.lowmcConstants.m18085KMatrix(this, 0);
        matrix_mul(iArr5, iArr, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
        xor_array(iArr6, iArr5, iArr3, 0);
        for (int i = 1; i <= this.numRounds; i++) {
            tapesToWords(iArr2, c6217Tape);
            mpc_sbox(iArr6, iArr2, c6217Tape, c6214Msg);
            int i2 = i - 1;
            KMatricesWithPointer kMatricesWithPointerM18086LMatrix = this.lowmcConstants.m18086LMatrix(this, i2);
            matrix_mul(iArr6, iArr6, kMatricesWithPointerM18086LMatrix.m18081getData(), kMatricesWithPointerM18086LMatrix.getMatrixPointer());
            KMatricesWithPointer kMatricesWithPointerRConstant = this.lowmcConstants.RConstant(this, i2);
            xor_array(iArr6, iArr6, kMatricesWithPointerRConstant.m18081getData(), kMatricesWithPointerRConstant.getMatrixPointer());
            KMatricesWithPointer kMatricesWithPointerM18085KMatrix2 = this.lowmcConstants.m18085KMatrix(this, i);
            matrix_mul(iArr5, iArr, kMatricesWithPointerM18085KMatrix2.m18081getData(), kMatricesWithPointerM18085KMatrix2.getMatrixPointer());
            xor_array(iArr6, iArr5, iArr6, 0);
        }
        return !subarrayEquals(iArr6, iArr4, this.stateSizeWords) ? -1 : 0;
    }

    private static boolean subarrayEquals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private void substitution(int[] iArr) {
        for (int i = 0; i < this.numSboxes * 3; i += 3) {
            int i2 = i + 2;
            int bitFromWordArray = C6219Utils.getBitFromWordArray(iArr, i2);
            int i3 = i + 1;
            int bitFromWordArray2 = C6219Utils.getBitFromWordArray(iArr, i3);
            int bitFromWordArray3 = C6219Utils.getBitFromWordArray(iArr, i);
            C6219Utils.setBitInWordArray(iArr, i2, (bitFromWordArray2 & bitFromWordArray3) ^ bitFromWordArray);
            int i4 = bitFromWordArray ^ bitFromWordArray2;
            C6219Utils.setBitInWordArray(iArr, i3, (bitFromWordArray & bitFromWordArray3) ^ i4);
            C6219Utils.setBitInWordArray(iArr, i, (i4 ^ bitFromWordArray3) ^ (bitFromWordArray & bitFromWordArray2));
        }
    }

    private void tapesToWords(int[] iArr, C6217Tape c6217Tape) {
        for (int i = 0; i < this.stateSizeBits; i++) {
            iArr[i] = c6217Tape.tapesToWord();
        }
    }

    private void updateDigest(int[] iArr, byte[] bArr) {
        AbstractC6245Pack.intToLittleEndian(iArr, bArr, 0);
        this.f23971digest.mo14970update(bArr, 0, this.stateSizeBytes);
    }

    /* renamed from: verify */
    private int m18099verify(Signature signature, int[] iArr, int[] iArr2, byte[] bArr) {
        int i = 2;
        int[] iArr3 = {this.numMPCRounds, this.numMPCParties, this.digestSizeBytes};
        Class cls = Byte.TYPE;
        byte[][][] bArr2 = (byte[][][]) Array.newInstance((Class<?>) cls, iArr3);
        byte[][][] bArr3 = (byte[][][]) Array.newInstance((Class<?>) cls, this.numMPCRounds, 3, this.UnruhGWithInputBytes);
        int[][][] iArr4 = (int[][][]) Array.newInstance((Class<?>) Integer.TYPE, this.numMPCRounds, 3, this.stateSizeBytes);
        Signature.C6215Proof[] c6215ProofArr = signature.f23977proofs;
        byte[] bArr4 = signature.challengeBits;
        int i2 = this.stateSizeBytes;
        byte[] bArr5 = new byte[Math.max(i2 * 6, i2 + this.andSizeBytes)];
        C6217Tape c6217Tape = new C6217Tape(this);
        int i3 = this.numMPCRounds;
        C6220View[] c6220ViewArr = new C6220View[i3];
        C6220View[] c6220ViewArr2 = new C6220View[i3];
        int i4 = 0;
        while (true) {
            int i5 = this.numMPCRounds;
            if (i4 >= i5) {
                byte[] bArr6 = new byte[C6219Utils.numBytes(i5 * i)];
                m18090H3(iArr, iArr2, iArr4, bArr2, bArr6, signature.f23978salt, bArr, bArr3);
                if (subarrayEquals(bArr4, bArr6, C6219Utils.numBytes(this.numMPCRounds * 2))) {
                    return 0;
                }
                f23970LOG.fine("Invalid signature. Did not verify");
                return -1;
            }
            c6220ViewArr[i4] = new C6220View(this);
            C6220View c6220View = new C6220View(this);
            c6220ViewArr2[i4] = c6220View;
            int i6 = i4;
            C6220View[] c6220ViewArr3 = c6220ViewArr2;
            C6220View[] c6220ViewArr4 = c6220ViewArr;
            C6217Tape c6217Tape2 = c6217Tape;
            byte[] bArr7 = bArr5;
            byte[] bArr8 = bArr4;
            Signature.C6215Proof[] c6215ProofArr2 = c6215ProofArr;
            if (!verifyProof(c6215ProofArr[i4], c6220ViewArr[i4], c6220View, getChallenge(bArr4, i4), signature.f23978salt, i6, bArr5, iArr2, c6217Tape2)) {
                f23970LOG.fine("Invalid signature. Did not verify");
                return -1;
            }
            int challenge = getChallenge(bArr8, i6);
            m18087Commit(c6215ProofArr2[i6].f23979seed1, 0, c6220ViewArr4[i6], bArr2[i6][challenge]);
            int i7 = (challenge + 1) % 3;
            m18087Commit(c6215ProofArr2[i6].f23980seed2, 0, c6220ViewArr3[i6], bArr2[i6][i7]);
            int i8 = (challenge + 2) % 3;
            System.arraycopy(c6215ProofArr2[i6].view3Commitment, 0, bArr2[i6][i8], 0, this.digestSizeBytes);
            if (this.transform == 1) {
                m18088G(challenge, c6215ProofArr2[i6].f23979seed1, 0, c6220ViewArr4[i6], bArr3[i6][challenge]);
                m18088G(i7, c6215ProofArr2[i6].f23980seed2, 0, c6220ViewArr3[i6], bArr3[i6][i7]);
                System.arraycopy(c6215ProofArr2[i6].view3UnruhG, 0, bArr3[i6][i8], 0, challenge == 0 ? this.UnruhGWithInputBytes : this.UnruhGWithoutInputBytes);
            }
            iArr4[i6][challenge] = c6220ViewArr4[i6].outputShare;
            iArr4[i6][i7] = c6220ViewArr3[i6].outputShare;
            int[] iArr5 = new int[this.stateSizeWords];
            xor_three(iArr5, c6220ViewArr4[i6].outputShare, c6220ViewArr3[i6].outputShare, iArr);
            iArr4[i6][i8] = iArr5;
            i4 = i6 + 1;
            bArr4 = bArr8;
            c6220ViewArr = c6220ViewArr4;
            c6217Tape = c6217Tape2;
            c6220ViewArr2 = c6220ViewArr3;
            bArr5 = bArr7;
            c6215ProofArr = c6215ProofArr2;
            i = 2;
        }
    }

    private int verify_picnic3(Signature2 signature2, int[] iArr, int[] iArr2, byte[] bArr) {
        int iVerifyMerkleTree;
        Logger logger;
        String str;
        int i;
        C6218Tree[] c6218TreeArr;
        byte[] bArr2;
        C6218Tree c6218Tree;
        int i2;
        C6218Tree c6218Tree2;
        int i3;
        int[] iArr3 = {this.numMPCRounds, this.numMPCParties, this.digestSizeBytes};
        Class cls = Byte.TYPE;
        byte[][][] bArr3 = (byte[][][]) Array.newInstance((Class<?>) cls, iArr3);
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) cls, this.numMPCRounds, this.digestSizeBytes);
        byte[][] bArr5 = (byte[][]) Array.newInstance((Class<?>) cls, this.numMPCRounds, this.digestSizeBytes);
        C6214Msg[] c6214MsgArr = new C6214Msg[this.numMPCRounds];
        C6218Tree c6218Tree3 = new C6218Tree(this, this.numMPCRounds, this.digestSizeBytes);
        byte[] bArr6 = new byte[64];
        int i4 = this.numMPCRounds;
        C6218Tree[] c6218TreeArr2 = new C6218Tree[i4];
        C6217Tape[] c6217TapeArr = new C6217Tape[i4];
        C6218Tree c6218Tree4 = new C6218Tree(this, this.numMPCRounds, this.seedSizeBytes);
        if (c6218Tree4.reconstructSeeds(signature2.challengeC, this.numOpenedRounds, signature2.iSeedInfo, signature2.iSeedInfoLen, signature2.f23983salt, 0) != 0) {
            return -1;
        }
        int i5 = 0;
        while (true) {
            if (i5 < this.numMPCRounds) {
                if (contains(signature2.challengeC, this.numOpenedRounds, i5)) {
                    c6218TreeArr2[i5] = new C6218Tree(this, this.numMPCParties, this.seedSizeBytes);
                    int[] iArr4 = {signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i5)]};
                    C6218Tree c6218Tree5 = c6218TreeArr2[i5];
                    Signature2.C6216Proof2 c6216Proof2 = signature2.f23982proofs[i5];
                    if (c6218Tree5.reconstructSeeds(iArr4, 1, c6216Proof2.seedInfo, c6216Proof2.seedInfoLen, signature2.f23983salt, i5) != 0) {
                        logger = f23970LOG;
                        str = "Failed to reconstruct seeds for round " + i5;
                        break;
                    }
                } else {
                    C6218Tree c6218Tree6 = new C6218Tree(this, this.numMPCParties, this.seedSizeBytes);
                    c6218TreeArr2[i5] = c6218Tree6;
                    c6218Tree6.generateSeeds(c6218Tree4.m18103getLeaf(i5), signature2.f23983salt, i5);
                }
                i5++;
            } else {
                int i6 = this.numMPCParties - 1;
                byte[] bArr7 = new byte[MAX_AUX_BYTES];
                int i7 = 0;
                while (i7 < this.numMPCRounds) {
                    C6217Tape c6217Tape = new C6217Tape(this);
                    c6217TapeArr[i7] = c6217Tape;
                    byte[] bArr8 = bArr6;
                    int i8 = i7;
                    byte[] bArr9 = bArr7;
                    C6217Tape[] c6217TapeArr2 = c6217TapeArr;
                    createRandomTapes(c6217Tape, c6218TreeArr2[i7].getLeaves(), c6218TreeArr2[i7].getLeavesOffset(), signature2.f23983salt, i8);
                    if (contains(signature2.challengeC, this.numOpenedRounds, i8)) {
                        i = i8;
                        c6218TreeArr = c6218TreeArr2;
                        bArr2 = bArr9;
                        int i9 = signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i)];
                        int i10 = 0;
                        while (i10 < i6) {
                            if (i10 != i9) {
                                i2 = i10;
                                c6218Tree2 = c6218Tree3;
                                i3 = i9;
                                m18092commit(bArr3[i][i10], c6218TreeArr[i].m18103getLeaf(i10), null, signature2.f23983salt, i, i2);
                            } else {
                                i2 = i10;
                                c6218Tree2 = c6218Tree3;
                                i3 = i9;
                            }
                            i10 = i2 + 1;
                            i9 = i3;
                            c6218Tree3 = c6218Tree2;
                        }
                        c6218Tree = c6218Tree3;
                        int i11 = i9;
                        if (i6 != i11) {
                            m18092commit(bArr3[i][i6], c6218TreeArr[i].m18103getLeaf(i6), signature2.f23982proofs[i].f23985aux, signature2.f23983salt, i, i6);
                        }
                        System.arraycopy(signature2.f23982proofs[i].f23984C, 0, bArr3[i][i11], 0, this.digestSizeBytes);
                    } else {
                        c6217TapeArr2[i8].computeAuxTape(null);
                        int i12 = 0;
                        while (i12 < i6) {
                            m18092commit(bArr3[i8][i12], c6218TreeArr2[i8].m18103getLeaf(i12), null, signature2.f23983salt, i8, i12);
                            i12++;
                            c6218TreeArr2 = c6218TreeArr2;
                        }
                        i = i8;
                        c6218TreeArr = c6218TreeArr2;
                        getAuxBits(bArr9, c6217TapeArr2[i]);
                        bArr2 = bArr9;
                        m18092commit(bArr3[i][i6], c6218TreeArr[i].m18103getLeaf(i6), bArr9, signature2.f23983salt, i8, i6);
                        c6218Tree = c6218Tree3;
                    }
                    i7 = i + 1;
                    bArr7 = bArr2;
                    c6217TapeArr = c6217TapeArr2;
                    c6218TreeArr2 = c6218TreeArr;
                    bArr6 = bArr8;
                    c6218Tree3 = c6218Tree;
                }
                C6217Tape[] c6217TapeArr3 = c6217TapeArr;
                C6218Tree c6218Tree7 = c6218Tree3;
                byte[] bArr10 = bArr6;
                for (int i13 = 0; i13 < this.numMPCRounds; i13++) {
                    commit_h(bArr4[i13], bArr3[i13]);
                }
                int[] iArr5 = new int[this.stateSizeBits];
                int i14 = 0;
                while (true) {
                    int i15 = this.numMPCRounds;
                    if (i14 < i15) {
                        c6214MsgArr[i14] = new C6214Msg(this);
                        if (contains(signature2.challengeC, this.numOpenedRounds, i14)) {
                            int i16 = signature2.challengeP[m18095indexOf(signature2.challengeC, this.numOpenedRounds, i14)];
                            if (i16 != i6) {
                                c6217TapeArr3[i14].setAuxBits(signature2.f23982proofs[i14].f23985aux);
                            }
                            System.arraycopy(signature2.f23982proofs[i14].f23987msgs, 0, c6214MsgArr[i14].f23968msgs[i16], 0, this.andSizeBytes);
                            C6238Arrays.m18249fill(c6217TapeArr3[i14].f23991tapes[i16], (byte) 0);
                            c6214MsgArr[i14].unopened = i16;
                            byte[] bArr11 = new byte[this.stateSizeWords * 4];
                            byte[] bArr12 = signature2.f23982proofs[i14].f23986input;
                            System.arraycopy(bArr12, 0, bArr11, 0, bArr12.length);
                            int i17 = this.stateSizeWords;
                            int[] iArr6 = new int[i17];
                            AbstractC6245Pack.littleEndianToInt(bArr11, 0, iArr6, 0, i17);
                            if (simulateOnline(iArr6, c6217TapeArr3[i14], iArr5, c6214MsgArr[i14], iArr2, iArr) != 0) {
                                logger = f23970LOG;
                                str = "MPC simulation failed for round " + i14 + ", signature invalid";
                                break;
                            }
                            commit_v(bArr5[i14], signature2.f23982proofs[i14].f23986input, c6214MsgArr[i14]);
                        } else {
                            bArr5[i14] = null;
                        }
                        i14++;
                    } else {
                        if (c6218Tree7.addMerkleNodes(getMissingLeavesList(signature2.challengeC), i15 - this.numOpenedRounds, signature2.f23981cvInfo, signature2.cvInfoLen) != 0 || (iVerifyMerkleTree = c6218Tree7.verifyMerkleTree(bArr5, signature2.f23983salt)) != 0) {
                            return -1;
                        }
                        m18091HCP(bArr10, null, null, bArr4, c6218Tree7.f23996nodes[0], signature2.f23983salt, iArr, iArr2, bArr);
                        if (subarrayEquals(signature2.challengeHash, bArr10, this.digestSizeBytes)) {
                            return iVerifyMerkleTree;
                        }
                        logger = f23970LOG;
                        str = "Challenge does not match, signature invalid";
                    }
                }
            }
        }
        logger.fine(str);
        return -1;
    }

    private void wordToMsgs(int i, C6214Msg c6214Msg) {
        for (int i2 = 0; i2 < this.numMPCParties; i2++) {
            C6219Utils.m18110setBit(c6214Msg.f23968msgs[i2], c6214Msg.f23969pos, (byte) C6219Utils.m18105getBit(i, i2));
        }
        c6214Msg.f23969pos++;
    }

    private void xor_three(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i = 0; i < this.stateSizeWords; i++) {
            iArr[i] = (iArr2[i] ^ iArr3[i]) ^ iArr4[i];
        }
    }

    public void aux_mpc_sbox(int[] iArr, int[] iArr2, C6217Tape c6217Tape) {
        for (int i = 0; i < this.numSboxes * 3; i += 3) {
            int i2 = i + 2;
            int bitFromWordArray = C6219Utils.getBitFromWordArray(iArr, i2);
            int i3 = i + 1;
            int bitFromWordArray2 = C6219Utils.getBitFromWordArray(iArr, i3);
            int bitFromWordArray3 = C6219Utils.getBitFromWordArray(iArr, i);
            int bitFromWordArray4 = C6219Utils.getBitFromWordArray(iArr2, i2);
            int bitFromWordArray5 = C6219Utils.getBitFromWordArray(iArr2, i3);
            aux_mpc_AND(bitFromWordArray, bitFromWordArray2, ((C6219Utils.getBitFromWordArray(iArr2, i) ^ bitFromWordArray) ^ bitFromWordArray2) ^ bitFromWordArray3, c6217Tape);
            aux_mpc_AND(bitFromWordArray2, bitFromWordArray3, bitFromWordArray4 ^ bitFromWordArray, c6217Tape);
            aux_mpc_AND(bitFromWordArray3, bitFromWordArray, (bitFromWordArray5 ^ bitFromWordArray) ^ bitFromWordArray2, c6217Tape);
        }
    }

    public void crypto_sign(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (picnic_sign(bArr3, bArr2, bArr)) {
            System.arraycopy(bArr2, 0, bArr, 4, bArr2.length);
        }
    }

    public void crypto_sign_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        int i = this.stateSizeWords;
        byte[] bArr3 = new byte[i * 4];
        byte[] bArr4 = new byte[i * 4];
        byte[] bArr5 = new byte[i * 4];
        picnic_keygen(bArr3, bArr4, bArr5, secureRandom);
        picnic_write_public_key(bArr4, bArr3, bArr);
        picnic_write_private_key(bArr5, bArr4, bArr3, bArr2);
    }

    public boolean crypto_sign_open(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (picnic_verify(bArr3, C6238Arrays.copyOfRange(bArr2, 4, bArr.length + 4), bArr2, AbstractC6245Pack.littleEndianToInt(bArr2, 0)) == -1) {
            return false;
        }
        System.arraycopy(bArr2, 4, bArr, 0, bArr.length);
        return true;
    }

    public int getChallenge(byte[] bArr, int i) {
        return C6219Utils.getCrumbAligned(bArr, i);
    }

    public int getPublicKeySize() {
        return this.CRYPTO_PUBLICKEYBYTES;
    }

    public int getSecretKeySize() {
        return this.CRYPTO_SECRETKEYBYTES;
    }

    public int getSignatureSize(int i) {
        return this.CRYPTO_BYTES + i;
    }

    public int getTrueSignatureSize() {
        return this.signatureLength;
    }

    public void matrix_mul(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        matrix_mul_offset(iArr, 0, iArr2, 0, iArr3, i);
    }

    public void matrix_mul_offset(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        int[] iArr4 = new int[16];
        int i4 = this.stateSizeWords;
        iArr4[i4 - 1] = 0;
        int i5 = this.stateSizeBits;
        int i6 = i5 / 32;
        int i7 = (i4 * 32) - i5;
        int iBitPermuteStepSimple = AbstractC5866Bits.bitPermuteStepSimple(AbstractC5866Bits.bitPermuteStepSimple(AbstractC5866Bits.bitPermuteStepSimple((-1) >>> i7, 1431655765, 1), 858993459, 2), 252645135, 4);
        for (int i8 = 0; i8 < this.stateSizeBits; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 ^= iArr3[i3 + ((this.stateSizeWords * i8) + i10)] & iArr2[i2 + i10];
            }
            if (i7 > 0) {
                i9 ^= (iArr3[i3 + ((this.stateSizeWords * i8) + i6)] & iArr2[i2 + i6]) & iBitPermuteStepSimple;
            }
            C6219Utils.m18111setBit(iArr4, i8, C6219Utils.parity32(i9));
        }
        System.arraycopy(iArr4, 0, iArr, i, this.stateSizeWords);
    }

    public void mpc_AND_verify(int[] iArr, int[] iArr2, int[] iArr3, C6217Tape c6217Tape, C6220View c6220View, C6220View c6220View2) {
        byte bM18104getBit = C6219Utils.m18104getBit(c6217Tape.f23991tapes[0], c6217Tape.f23990pos);
        byte bM18104getBit2 = C6219Utils.m18104getBit(c6217Tape.f23991tapes[1], c6217Tape.f23990pos);
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr2[0];
        int i4 = (bM18104getBit ^ (((i2 & i3) ^ (iArr2[1] & i)) ^ (i & i3))) ^ bM18104getBit2;
        iArr3[0] = i4;
        C6219Utils.m18110setBit(c6220View.communicatedBits, c6217Tape.f23990pos, (byte) i4);
        iArr3[1] = C6219Utils.m18104getBit(c6220View2.communicatedBits, c6217Tape.f23990pos);
        c6217Tape.f23990pos++;
    }

    public void mpc_LowMC_verify(C6220View c6220View, C6220View c6220View2, C6217Tape c6217Tape, int[] iArr, int[] iArr2, int i) {
        C6238Arrays.m18254fill(iArr, 0, iArr.length, 0);
        mpc_xor_constant_verify(iArr, iArr2, 0, this.stateSizeWords, i);
        KMatricesWithPointer kMatricesWithPointerM18085KMatrix = this.lowmcConstants.m18085KMatrix(this, 0);
        matrix_mul_offset(iArr, 0, c6220View.inputShare, 0, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
        matrix_mul_offset(iArr, this.stateSizeWords, c6220View2.inputShare, 0, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
        m18098mpc_xor(iArr, iArr, 2);
        for (int i2 = 1; i2 <= this.numRounds; i2++) {
            KMatricesWithPointer kMatricesWithPointerM18085KMatrix2 = this.lowmcConstants.m18085KMatrix(this, i2);
            matrix_mul_offset(iArr, 0, c6220View.inputShare, 0, kMatricesWithPointerM18085KMatrix2.m18081getData(), kMatricesWithPointerM18085KMatrix2.getMatrixPointer());
            matrix_mul_offset(iArr, this.stateSizeWords, c6220View2.inputShare, 0, kMatricesWithPointerM18085KMatrix2.m18081getData(), kMatricesWithPointerM18085KMatrix2.getMatrixPointer());
            mpc_substitution_verify(iArr, c6217Tape, c6220View, c6220View2);
            int i3 = i2 - 1;
            KMatricesWithPointer kMatricesWithPointerM18086LMatrix = this.lowmcConstants.m18086LMatrix(this, i3);
            int i4 = this.stateSizeWords;
            mpc_matrix_mul(iArr, i4 * 2, iArr, i4 * 2, kMatricesWithPointerM18086LMatrix.m18081getData(), kMatricesWithPointerM18086LMatrix.getMatrixPointer(), 2);
            KMatricesWithPointer kMatricesWithPointerRConstant = this.lowmcConstants.RConstant(this, i3);
            mpc_xor_constant_verify(iArr, kMatricesWithPointerRConstant.m18081getData(), kMatricesWithPointerRConstant.getMatrixPointer(), this.stateSizeWords, i);
            m18098mpc_xor(iArr, iArr, 2);
        }
        int i5 = this.stateSizeWords;
        System.arraycopy(iArr, i5 * 2, c6220View.outputShare, 0, i5);
        int i6 = this.stateSizeWords;
        System.arraycopy(iArr, i6 * 3, c6220View2.outputShare, 0, i6);
    }

    public void mpc_substitution_verify(int[] iArr, C6217Tape c6217Tape, C6220View c6220View, C6220View c6220View2) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        int[] iArr4 = new int[2];
        int[] iArr5 = new int[2];
        int[] iArr6 = new int[2];
        int[] iArr7 = new int[2];
        int i = 0;
        while (i < this.numSboxes * 3) {
            for (int i2 = 0; i2 < 2; i2++) {
                int i3 = ((i2 + 2) * this.stateSizeWords * 32) + i;
                iArr2[i2] = C6219Utils.getBitFromWordArray(iArr, i3 + 2);
                iArr3[i2] = C6219Utils.getBitFromWordArray(iArr, i3 + 1);
                iArr4[i2] = C6219Utils.getBitFromWordArray(iArr, i3);
            }
            int i4 = i;
            mpc_AND_verify(iArr2, iArr3, iArr5, c6217Tape, c6220View, c6220View2);
            mpc_AND_verify(iArr3, iArr4, iArr6, c6217Tape, c6220View, c6220View2);
            mpc_AND_verify(iArr4, iArr2, iArr7, c6217Tape, c6220View, c6220View2);
            for (int i5 = 0; i5 < 2; i5++) {
                int i6 = ((i5 + 2) * this.stateSizeWords * 32) + i4;
                C6219Utils.setBitInWordArray(iArr, i6 + 2, iArr2[i5] ^ iArr6[i5]);
                C6219Utils.setBitInWordArray(iArr, i6 + 1, (iArr2[i5] ^ iArr3[i5]) ^ iArr7[i5]);
                C6219Utils.setBitInWordArray(iArr, i6, ((iArr2[i5] ^ iArr3[i5]) ^ iArr4[i5]) ^ iArr5[i5]);
            }
            i = i4 + 3;
        }
    }

    /* renamed from: prove */
    public void m18100prove(Signature.C6215Proof c6215Proof, int i, byte[] bArr, int i2, C6220View[] c6220ViewArr, byte[][] bArr2, byte[][] bArr3) {
        if (i == 0) {
            System.arraycopy(bArr, i2, c6215Proof.f23979seed1, 0, this.seedSizeBytes);
            int i3 = this.seedSizeBytes;
            System.arraycopy(bArr, i2 + i3, c6215Proof.f23980seed2, 0, i3);
        } else if (i == 1) {
            int i4 = this.seedSizeBytes;
            System.arraycopy(bArr, i2 + i4, c6215Proof.f23979seed1, 0, i4);
            int i5 = this.seedSizeBytes;
            System.arraycopy(bArr, i2 + (i5 * 2), c6215Proof.f23980seed2, 0, i5);
        } else {
            if (i != 2) {
                f23970LOG.fine("Invalid challenge");
                throw new IllegalArgumentException("challenge");
            }
            int i6 = this.seedSizeBytes;
            System.arraycopy(bArr, (i6 * 2) + i2, c6215Proof.f23979seed1, 0, i6);
            System.arraycopy(bArr, i2, c6215Proof.f23980seed2, 0, this.seedSizeBytes);
        }
        if (i == 1 || i == 2) {
            System.arraycopy(c6220ViewArr[2].inputShare, 0, c6215Proof.inputShare, 0, this.stateSizeWords);
        }
        System.arraycopy(c6220ViewArr[(i + 1) % 3].communicatedBits, 0, c6215Proof.communicatedBits, 0, this.andSizeBytes);
        int i7 = (i + 2) % 3;
        System.arraycopy(bArr2[i7], 0, c6215Proof.view3Commitment, 0, this.digestSizeBytes);
        if (this.transform == 1) {
            System.arraycopy(bArr3[i7], 0, c6215Proof.view3UnruhG, 0, i == 0 ? this.UnruhGWithInputBytes : this.UnruhGWithoutInputBytes);
        }
    }

    public int serializeSignature(Signature signature, byte[] bArr, int i) {
        Signature.C6215Proof[] c6215ProofArr = signature.f23977proofs;
        byte[] bArr2 = signature.challengeBits;
        int iNumBytes = C6219Utils.numBytes(this.numMPCRounds * 2) + 32;
        int i2 = this.numMPCRounds;
        int i3 = iNumBytes + (((this.seedSizeBytes * 2) + this.stateSizeBytes + this.andSizeBytes + this.digestSizeBytes) * i2);
        if (this.transform == 1) {
            i3 += this.UnruhGWithoutInputBytes * i2;
        }
        if (this.CRYPTO_BYTES < i3) {
            return -1;
        }
        System.arraycopy(bArr2, 0, bArr, i, C6219Utils.numBytes(i2 * 2));
        int iNumBytes2 = C6219Utils.numBytes(this.numMPCRounds * 2) + i;
        System.arraycopy(signature.f23978salt, 0, bArr, iNumBytes2, 32);
        int i4 = iNumBytes2 + 32;
        for (int i5 = 0; i5 < this.numMPCRounds; i5++) {
            int challenge = getChallenge(bArr2, i5);
            System.arraycopy(c6215ProofArr[i5].view3Commitment, 0, bArr, i4, this.digestSizeBytes);
            int i6 = i4 + this.digestSizeBytes;
            if (this.transform == 1) {
                int i7 = challenge == 0 ? this.UnruhGWithInputBytes : this.UnruhGWithoutInputBytes;
                System.arraycopy(c6215ProofArr[i5].view3UnruhG, 0, bArr, i6, i7);
                i6 += i7;
            }
            System.arraycopy(c6215ProofArr[i5].communicatedBits, 0, bArr, i6, this.andSizeBytes);
            int i8 = i6 + this.andSizeBytes;
            System.arraycopy(c6215ProofArr[i5].f23979seed1, 0, bArr, i8, this.seedSizeBytes);
            int i9 = this.seedSizeBytes;
            int i10 = i8 + i9;
            System.arraycopy(c6215ProofArr[i5].f23980seed2, 0, bArr, i10, i9);
            i4 = i10 + this.seedSizeBytes;
            if (challenge == 1 || challenge == 2) {
                AbstractC6245Pack.intToLittleEndian(c6215ProofArr[i5].inputShare, 0, this.stateSizeWords, bArr, i4);
                i4 += this.stateSizeBytes;
            }
        }
        return i4 - i;
    }

    public boolean verifyProof(Signature.C6215Proof c6215Proof, C6220View c6220View, C6220View c6220View2, int i, byte[] bArr, int i2, byte[] bArr2, int[] iArr, C6217Tape c6217Tape) {
        boolean z;
        boolean z2;
        System.arraycopy(c6215Proof.communicatedBits, 0, c6220View2.communicatedBits, 0, this.andSizeBytes);
        c6217Tape.f23990pos = 0;
        if (i == 0) {
            z = true;
            boolean zCreateRandomTape = createRandomTape(c6215Proof.f23979seed1, 0, bArr, i2, 0, bArr2, this.stateSizeBytes + this.andSizeBytes);
            AbstractC6245Pack.littleEndianToInt(bArr2, 0, c6220View.inputShare);
            System.arraycopy(bArr2, this.stateSizeBytes, c6217Tape.f23991tapes[0], 0, this.andSizeBytes);
            z2 = zCreateRandomTape && createRandomTape(c6215Proof.f23980seed2, 0, bArr, i2, 1, bArr2, this.stateSizeBytes + this.andSizeBytes);
            if (z2) {
                AbstractC6245Pack.littleEndianToInt(bArr2, 0, c6220View2.inputShare);
                System.arraycopy(bArr2, this.stateSizeBytes, c6217Tape.f23991tapes[1], 0, this.andSizeBytes);
            }
        } else if (i == 1) {
            z = true;
            boolean zCreateRandomTape2 = createRandomTape(c6215Proof.f23979seed1, 0, bArr, i2, 1, bArr2, this.stateSizeBytes + this.andSizeBytes);
            AbstractC6245Pack.littleEndianToInt(bArr2, 0, c6220View.inputShare);
            System.arraycopy(bArr2, this.stateSizeBytes, c6217Tape.f23991tapes[0], 0, this.andSizeBytes);
            z2 = zCreateRandomTape2 && createRandomTape(c6215Proof.f23980seed2, 0, bArr, i2, 2, c6217Tape.f23991tapes[1], this.andSizeBytes);
            if (z2) {
                System.arraycopy(c6215Proof.inputShare, 0, c6220View2.inputShare, 0, this.stateSizeWords);
            }
        } else if (i != 2) {
            f23970LOG.fine("Invalid Challenge!");
            z = true;
            z2 = false;
        } else {
            z = true;
            boolean zCreateRandomTape3 = createRandomTape(c6215Proof.f23979seed1, 0, bArr, i2, 2, c6217Tape.f23991tapes[0], this.andSizeBytes);
            System.arraycopy(c6215Proof.inputShare, 0, c6220View.inputShare, 0, this.stateSizeWords);
            z2 = zCreateRandomTape3 && createRandomTape(c6215Proof.f23980seed2, 0, bArr, i2, 0, bArr2, this.stateSizeBytes + this.andSizeBytes);
            if (z2) {
                AbstractC6245Pack.littleEndianToInt(bArr2, 0, c6220View2.inputShare);
                System.arraycopy(bArr2, this.stateSizeBytes, c6217Tape.f23991tapes[1], 0, this.andSizeBytes);
            }
        }
        if (!z2) {
            f23970LOG.fine("Failed to generate random tapes, signature verification will fail (but signature may actually be valid)");
            return false;
        }
        C6219Utils.zeroTrailingBits(c6220View.inputShare, this.stateSizeBits);
        C6219Utils.zeroTrailingBits(c6220View2.inputShare, this.stateSizeBits);
        mpc_LowMC_verify(c6220View, c6220View2, c6217Tape, AbstractC6245Pack.littleEndianToInt(bArr2, 0, bArr2.length / 4), iArr, i);
        return z;
    }

    public void xor_array(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        for (int i2 = 0; i2 < this.stateSizeWords; i2++) {
            iArr[i2] = iArr2[i2] ^ iArr3[i2 + i];
        }
    }

    /* renamed from: H3 */
    private void m18090H3(int[] iArr, int[] iArr2, int[][][] iArr3, byte[][][] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][][] bArr5) {
        this.f23971digest.mo14969update((byte) 1);
        byte[] bArr6 = new byte[this.stateSizeWords * 4];
        for (int i = 0; i < this.numMPCRounds; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                AbstractC6245Pack.intToLittleEndian(iArr3[i][i2], bArr6, 0);
                this.f23971digest.mo14970update(bArr6, 0, this.stateSizeBytes);
            }
        }
        m18094implH3(iArr, iArr2, bArr, bArr2, bArr3, bArr4, bArr5);
    }

    private boolean arePaddingBitsZero(int[] iArr, int i) {
        if ((i & 31) == 0) {
            return true;
        }
        return ((~C6219Utils.getTrailingBitsMask(i)) & iArr[i >>> 5]) == 0;
    }

    /* renamed from: mpc_AND */
    private void m18097mpc_AND(int[] iArr, int[] iArr2, int[] iArr3, C6217Tape c6217Tape, C6220View[] c6220ViewArr) {
        byte bM18104getBit = C6219Utils.m18104getBit(c6217Tape.f23991tapes[0], c6217Tape.f23990pos);
        byte bM18104getBit2 = C6219Utils.m18104getBit(c6217Tape.f23991tapes[1], c6217Tape.f23990pos);
        byte bM18104getBit3 = C6219Utils.m18104getBit(c6217Tape.f23991tapes[2], c6217Tape.f23990pos);
        int i = iArr[0];
        int i2 = iArr2[1];
        int i3 = iArr[1];
        int i4 = iArr2[0];
        int i5 = (((i & i4) ^ ((i & i2) ^ (i3 & i4))) ^ bM18104getBit) ^ bM18104getBit2;
        iArr3[0] = i5;
        int i6 = iArr2[2];
        int i7 = iArr[2];
        iArr3[1] = (bM18104getBit2 ^ ((i2 & i3) ^ ((i3 & i6) ^ (i7 & i2)))) ^ bM18104getBit3;
        iArr3[2] = bM18104getBit ^ ((((iArr2[0] & i7) ^ (iArr[0] & i6)) ^ (i7 & i6)) ^ bM18104getBit3);
        C6219Utils.m18110setBit(c6220ViewArr[0].communicatedBits, c6217Tape.f23990pos, (byte) i5);
        C6219Utils.m18110setBit(c6220ViewArr[1].communicatedBits, c6217Tape.f23990pos, (byte) iArr3[1]);
        C6219Utils.m18110setBit(c6220ViewArr[2].communicatedBits, c6217Tape.f23990pos, (byte) iArr3[2]);
        c6217Tape.f23990pos++;
    }

    private static boolean subarrayEquals(int[] iArr, int[] iArr2, int i) {
        if (iArr.length < i || iArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
