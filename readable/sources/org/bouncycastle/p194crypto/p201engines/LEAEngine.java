package org.bouncycastle.p194crypto.p201engines;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class LEAEngine implements BlockCipher {
    private static final int BASEROUNDS = 16;
    private static final int BLOCKSIZE = 16;

    /* renamed from: DELTA */
    private static final int[] f19953DELTA = {-1007687205, 1147300610, 2044886154, 2027892972, 1902027934, -947529206, -531697110, -440137385};

    /* renamed from: KEY0 */
    private static final int f19954KEY0 = 0;

    /* renamed from: KEY1 */
    private static final int f19955KEY1 = 1;

    /* renamed from: KEY2 */
    private static final int f19956KEY2 = 2;

    /* renamed from: KEY3 */
    private static final int f19957KEY3 = 3;

    /* renamed from: KEY4 */
    private static final int f19958KEY4 = 4;

    /* renamed from: KEY5 */
    private static final int f19959KEY5 = 5;

    /* renamed from: MASK128 */
    private static final int f19960MASK128 = 3;

    /* renamed from: MASK256 */
    private static final int f19961MASK256 = 7;
    private static final int NUMWORDS = 4;
    private static final int NUMWORDS128 = 4;
    private static final int NUMWORDS192 = 6;
    private static final int NUMWORDS256 = 8;

    /* renamed from: ROT1 */
    private static final int f19962ROT1 = 1;

    /* renamed from: ROT11 */
    private static final int f19963ROT11 = 11;

    /* renamed from: ROT13 */
    private static final int f19964ROT13 = 13;

    /* renamed from: ROT17 */
    private static final int f19965ROT17 = 17;

    /* renamed from: ROT3 */
    private static final int f19966ROT3 = 3;

    /* renamed from: ROT5 */
    private static final int f19967ROT5 = 5;

    /* renamed from: ROT6 */
    private static final int f19968ROT6 = 6;

    /* renamed from: ROT9 */
    private static final int f19969ROT9 = 9;
    private boolean forEncryption;
    private final int[] theBlock = new int[4];
    private int[][] theRoundKeys;
    private int theRounds;

    private static int bufLength(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    private static void checkBuffer(byte[] bArr, int i, boolean z) {
        int iBufLength = bufLength(bArr);
        int i2 = i + 16;
        if (i < 0 || i2 < 0 || i2 > iBufLength) {
            if (!z) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        AbstractC6245Pack.littleEndianToInt(bArr, i, this.theBlock, 0, 4);
        for (int i3 = this.theRounds - 1; i3 >= 0; i3--) {
            decryptRound(i3);
        }
        AbstractC6245Pack.intToLittleEndian(this.theBlock, bArr2, i2);
        return 16;
    }

    private void decryptRound(int i) {
        int[] iArr = this.theRoundKeys[i];
        int i2 = i % 4;
        int iRightIndex = rightIndex(i2);
        int[] iArr2 = this.theBlock;
        iArr2[iRightIndex] = iArr[1] ^ (m15365ror32(iArr2[iRightIndex], 9) - (this.theBlock[i2] ^ iArr[0]));
        int iRightIndex2 = rightIndex(iRightIndex);
        int[] iArr3 = this.theBlock;
        iArr3[iRightIndex2] = (m15364rol32(iArr3[iRightIndex2], 5) - (this.theBlock[iRightIndex] ^ iArr[2])) ^ iArr[3];
        int iRightIndex3 = rightIndex(iRightIndex2);
        int[] iArr4 = this.theBlock;
        iArr4[iRightIndex3] = iArr[5] ^ (m15364rol32(iArr4[iRightIndex3], 3) - (this.theBlock[iRightIndex2] ^ iArr[4]));
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        AbstractC6245Pack.littleEndianToInt(bArr, i, this.theBlock, 0, 4);
        for (int i3 = 0; i3 < this.theRounds; i3++) {
            encryptRound(i3);
        }
        AbstractC6245Pack.intToLittleEndian(this.theBlock, bArr2, i2);
        return 16;
    }

    private void encryptRound(int i) {
        int[] iArr = this.theRoundKeys[i];
        int i2 = (i + 3) % 4;
        int iLeftIndex = leftIndex(i2);
        int[] iArr2 = this.theBlock;
        iArr2[i2] = m15365ror32((iArr[4] ^ iArr2[iLeftIndex]) + (iArr2[i2] ^ iArr[5]), 3);
        int iLeftIndex2 = leftIndex(iLeftIndex);
        int[] iArr3 = this.theBlock;
        iArr3[iLeftIndex] = m15365ror32((iArr3[iLeftIndex2] ^ iArr[2]) + (iArr[3] ^ iArr3[iLeftIndex]), 5);
        int iLeftIndex3 = leftIndex(iLeftIndex2);
        int[] iArr4 = this.theBlock;
        iArr4[iLeftIndex2] = m15364rol32((iArr4[iLeftIndex3] ^ iArr[0]) + (iArr[1] ^ iArr4[iLeftIndex2]), 9);
    }

    private void generate128RoundKeys(int[] iArr) {
        for (int i = 0; i < this.theRounds; i++) {
            int iM15364rol32 = m15364rol32(f19953DELTA[i & 3], i);
            iArr[0] = m15364rol32(iArr[0] + iM15364rol32, 1);
            iArr[1] = m15364rol32(iArr[1] + m15364rol32(iM15364rol32, 1), 3);
            iArr[2] = m15364rol32(iArr[2] + m15364rol32(iM15364rol32, 2), 6);
            iArr[3] = m15364rol32(iArr[3] + m15364rol32(iM15364rol32, 3), 11);
            int[] iArr2 = this.theRoundKeys[i];
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
            iArr2[2] = iArr[2];
            int i2 = iArr[1];
            iArr2[3] = i2;
            iArr2[4] = iArr[3];
            iArr2[5] = i2;
        }
    }

    private void generate192RoundKeys(int[] iArr) {
        for (int i = 0; i < this.theRounds; i++) {
            int iM15364rol32 = m15364rol32(f19953DELTA[i % 6], i);
            iArr[0] = m15364rol32(iArr[0] + m15364rol32(iM15364rol32, 0), 1);
            iArr[1] = m15364rol32(iArr[1] + m15364rol32(iM15364rol32, 1), 3);
            iArr[2] = m15364rol32(iArr[2] + m15364rol32(iM15364rol32, 2), 6);
            iArr[3] = m15364rol32(iArr[3] + m15364rol32(iM15364rol32, 3), 11);
            iArr[4] = m15364rol32(iArr[4] + m15364rol32(iM15364rol32, 4), 13);
            iArr[5] = m15364rol32(iArr[5] + m15364rol32(iM15364rol32, 5), 17);
            System.arraycopy(iArr, 0, this.theRoundKeys[i], 0, 6);
        }
    }

    private void generate256RoundKeys(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < this.theRounds; i2++) {
            int iM15364rol32 = m15364rol32(f19953DELTA[i2 & 7], i2);
            int[] iArr2 = this.theRoundKeys[i2];
            int i3 = i & 7;
            int iM15364rol322 = m15364rol32(iArr[i3] + iM15364rol32, 1);
            iArr2[0] = iM15364rol322;
            iArr[i3] = iM15364rol322;
            int i4 = (i + 1) & 7;
            int iM15364rol323 = m15364rol32(iArr[i4] + m15364rol32(iM15364rol32, 1), 3);
            iArr2[1] = iM15364rol323;
            iArr[i4] = iM15364rol323;
            int i5 = (i + 2) & 7;
            int iM15364rol324 = m15364rol32(iArr[i5] + m15364rol32(iM15364rol32, 2), 6);
            iArr2[2] = iM15364rol324;
            iArr[i5] = iM15364rol324;
            int i6 = (i + 3) & 7;
            int iM15364rol325 = m15364rol32(iArr[i6] + m15364rol32(iM15364rol32, 3), 11);
            iArr2[3] = iM15364rol325;
            iArr[i6] = iM15364rol325;
            int i7 = (i + 4) & 7;
            int iM15364rol326 = m15364rol32(iArr[i7] + m15364rol32(iM15364rol32, 4), 13);
            iArr2[4] = iM15364rol326;
            iArr[i7] = iM15364rol326;
            int i8 = (i + 5) & 7;
            int iM15364rol327 = m15364rol32(iArr[i8] + m15364rol32(iM15364rol32, 5), 17);
            iArr2[5] = iM15364rol327;
            i += 6;
            iArr[i8] = iM15364rol327;
        }
    }

    private void generateRoundKeys(byte[] bArr) {
        int length = (bArr.length >> 1) + 16;
        this.theRounds = length;
        this.theRoundKeys = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, 6);
        int length2 = bArr.length / 4;
        int[] iArr = new int[length2];
        AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr, 0, length2);
        if (length2 == 4) {
            generate128RoundKeys(iArr);
        } else if (length2 != 6) {
            generate256RoundKeys(iArr);
        } else {
            generate192RoundKeys(iArr);
        }
    }

    private static int leftIndex(int i) {
        if (i == 0) {
            return 3;
        }
        return i - 1;
    }

    private static int rightIndex(int i) {
        if (i == 3) {
            return 0;
        }
        return i + 1;
    }

    /* renamed from: rol32 */
    private static int m15364rol32(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: ror32 */
    private static int m15365ror32(int i, int i2) {
        return (i << (32 - i2)) | (i >>> i2);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "LEA";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Invalid parameter passed to LEA init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        int length = bArrM15773getKey.length;
        if ((length << 1) % 16 != 0 || length < 16 || length > 32) {
            throw new IllegalArgumentException("KeyBitSize must be 128, 192 or 256");
        }
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), length * 8, cipherParameters, C5342Utils.getPurpose(this.forEncryption)));
        generateRoundKeys(bArrM15773getKey);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        checkBuffer(bArr, i, false);
        checkBuffer(bArr2, i2, true);
        return this.forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
