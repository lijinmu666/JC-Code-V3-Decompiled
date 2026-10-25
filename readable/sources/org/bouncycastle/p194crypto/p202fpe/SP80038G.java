package org.bouncycastle.p194crypto.p202fpe;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.p221util.RadixConverter;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class SP80038G {
    protected static final int BLOCK_SIZE = 16;
    static final String FF1_DISABLED = "org.bouncycastle.fpe.disable_ff1";
    static final String FPE_DISABLED = "org.bouncycastle.fpe.disable";

    /* renamed from: LOG2 */
    protected static final double f20185LOG2 = Math.log(2.0d);
    protected static final double TWO_TO_96 = Math.pow(2.0d, 96.0d);

    public static int calculateB_FF1(int i, int i2) {
        int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(i);
        int iBitLength = iNumberOfTrailingZeros * i2;
        int i3 = i >>> iNumberOfTrailingZeros;
        if (i3 != 1) {
            iBitLength += BigInteger.valueOf(i3).pow(i2).bitLength();
        }
        return (iBitLength + 7) / 8;
    }

    public static BigInteger[] calculateModUV(BigInteger bigInteger, int i, int i2) {
        BigInteger bigIntegerPow = bigInteger.pow(i);
        BigInteger[] bigIntegerArr = {bigIntegerPow, bigIntegerPow};
        if (i2 != i) {
            bigIntegerArr[1] = bigIntegerPow.multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    public static byte[] calculateP_FF1(int i, byte b, int i2, int i3) {
        byte[] bArr = {1, 2, 1, 0, (byte) (i >> 8), (byte) i, 10, b, 0, 0, 0, 0, 0, 0, 0, 0};
        AbstractC6245Pack.intToBigEndian(i2, bArr, 8);
        AbstractC6245Pack.intToBigEndian(i3, bArr, 12);
        return bArr;
    }

    public static byte[] calculateTweak64_FF3_1(byte[] bArr) {
        byte b = bArr[0];
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        byte b4 = bArr[3];
        return new byte[]{b, b2, b3, (byte) (b4 & 240), bArr[4], bArr[5], bArr[6], (byte) (b4 << 4)};
    }

    public static BigInteger calculateY_FF1(BlockCipher blockCipher, byte[] bArr, int i, int i2, int i3, byte[] bArr2, short[] sArr, RadixConverter radixConverter) {
        int length = bArr.length;
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(radixConverter.fromEncoding(sArr));
        int i4 = ((-(length + i + 1)) & 15) + length;
        int i5 = i4 + 1 + i;
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        bArr3[i4] = (byte) i3;
        System.arraycopy(bArrAsUnsignedByteArray, 0, bArr3, i5 - bArrAsUnsignedByteArray.length, bArrAsUnsignedByteArray.length);
        byte[] bArrM15472prf = m15472prf(blockCipher, C6238Arrays.concatenate(bArr2, bArr3));
        if (i2 > 16) {
            int i6 = (i2 + 15) / 16;
            byte[] bArr4 = new byte[i6 * 16];
            int iBigEndianToInt = AbstractC6245Pack.bigEndianToInt(bArrM15472prf, 12);
            System.arraycopy(bArrM15472prf, 0, bArr4, 0, 16);
            for (int i7 = 1; i7 < i6; i7++) {
                int i8 = i7 * 16;
                System.arraycopy(bArrM15472prf, 0, bArr4, i8, 12);
                AbstractC6245Pack.intToBigEndian(iBigEndianToInt ^ i7, bArr4, i8 + 12);
                blockCipher.processBlock(bArr4, i8, bArr4, i8);
            }
            bArrM15472prf = bArr4;
        }
        return m15471num(bArrM15472prf, 0, i2);
    }

    public static BigInteger calculateY_FF3(BlockCipher blockCipher, byte[] bArr, int i, int i2, short[] sArr, RadixConverter radixConverter) {
        byte[] bArr2 = new byte[16];
        AbstractC6245Pack.intToBigEndian(AbstractC6245Pack.bigEndianToInt(bArr, i) ^ i2, bArr2, 0);
        BigIntegers.asUnsignedByteArray(radixConverter.fromEncoding(sArr), bArr2, 4, 12);
        C6238Arrays.reverseInPlace(bArr2);
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        C6238Arrays.reverseInPlace(bArr2);
        return m15471num(bArr2, 0, 16);
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z, int i, byte[] bArr, int i2, int i3) {
        checkCipher(blockCipher);
        if (i < 2 || i > 256) {
            throw new IllegalArgumentException();
        }
        checkData(z, i, bArr, i2, i3);
    }

    public static void checkCipher(BlockCipher blockCipher) {
        if (16 != blockCipher.getBlockSize()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkData(boolean z, int i, byte[] bArr, int i2, int i3) {
        checkLength(z, i, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            if ((bArr[i2 + i4] & C1126UByte.MAX_VALUE) >= i) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    private static void checkLength(boolean z, int i, int i2) {
        int iFloor;
        if (i2 >= 2) {
            double d = i;
            if (Math.pow(d, i2) >= 1000000.0d) {
                if (z || i2 <= (iFloor = ((int) Math.floor(Math.log(TWO_TO_96) / Math.log(d))) * 2)) {
                    return;
                }
                throw new IllegalArgumentException("maximum input length is " + iFloor);
            }
        }
        throw new IllegalArgumentException("input too short");
    }

    /* renamed from: decFF1 */
    public static short[] m15469decFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i, int i2, int i3, short[] sArr, short[] sArr2) {
        int radix = radixConverter.getRadix();
        int length = bArr.length;
        int iCalculateB_FF1 = calculateB_FF1(radix, i3);
        int i4 = (iCalculateB_FF1 + 7) & (-4);
        byte[] bArrCalculateP_FF1 = calculateP_FF1(radix, (byte) i2, i, length);
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radix), i2, i3);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i5 = i2;
        int i6 = 9;
        while (i6 >= 0) {
            short[] sArr5 = sArr4;
            int i7 = iCalculateB_FF1;
            short[] sArr6 = sArr3;
            i5 = i - i5;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr5).subtract(calculateY_FF1(blockCipher, bArr, iCalculateB_FF1, i4, i6, bArrCalculateP_FF1, sArr3, radixConverter)).mod(bigIntegerArrCalculateModUV[i6 & 1]), i5, sArr5);
            i6--;
            sArr3 = sArr5;
            sArr4 = sArr6;
            iCalculateB_FF1 = i7;
        }
        return C6238Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] decFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i, int i2, int i3, short[] sArr, short[] sArr2) {
        int i4 = i3;
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radixConverter.getRadix()), i2, i4);
        C6238Arrays.reverseInPlace(sArr);
        C6238Arrays.reverseInPlace(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i5 = 7;
        while (i5 >= 0) {
            int i6 = i - i4;
            int i7 = i5 & 1;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr4).subtract(calculateY_FF3(blockCipher, bArr, 4 - (i7 * 4), i5, sArr3, radixConverter)).mod(bigIntegerArrCalculateModUV[1 - i7]), i6, sArr4);
            i5--;
            i4 = i6;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        C6238Arrays.reverseInPlace(sArr3);
        C6238Arrays.reverseInPlace(sArr4);
        return C6238Arrays.concatenate(sArr3, sArr4);
    }

    public static byte[] decryptFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), bArr2, i, i2);
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        return m15473toByte(m15469decFF1(blockCipher, radixConverter, bArr, i2, i3, i4, m15474toShort(bArr2, i, i3), m15474toShort(bArr2, i + i3, i4)));
    }

    public static short[] decryptFF1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), sArr, i, i2);
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        short[] sArr2 = new short[i3];
        short[] sArr3 = new short[i4];
        System.arraycopy(sArr, i, sArr2, 0, i3);
        System.arraycopy(sArr, i + i3, sArr3, 0, i4);
        return m15469decFF1(blockCipher, radixConverter, bArr, i2, i3, i4, sArr2, sArr3);
    }

    public static byte[] decryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i, i2);
        if (bArr.length == 8) {
            return implDecryptFF3(blockCipher, radixConverter, bArr, bArr2, i, i2);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] decryptFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i, i2);
        if (bArr.length == 7) {
            return implDecryptFF3(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), bArr2, i, i2);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] decryptFF3_1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i, i2);
        if (bArr.length == 7) {
            return implDecryptFF3w(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), sArr, i, i2);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    /* renamed from: encFF1 */
    private static short[] m15470encFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i, int i2, int i3, short[] sArr, short[] sArr2) {
        int radix = radixConverter.getRadix();
        int length = bArr.length;
        int iCalculateB_FF1 = calculateB_FF1(radix, i3);
        int i4 = (iCalculateB_FF1 + 7) & (-4);
        byte[] bArrCalculateP_FF1 = calculateP_FF1(radix, (byte) i2, i, length);
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radix), i2, i3);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i5 = 0;
        int i6 = i3;
        while (i5 < 10) {
            short[] sArr5 = sArr4;
            int i7 = i5;
            short[] sArr6 = sArr3;
            i6 = i - i6;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr6).add(calculateY_FF1(blockCipher, bArr, iCalculateB_FF1, i4, i5, bArrCalculateP_FF1, sArr5, radixConverter)).mod(bigIntegerArrCalculateModUV[i7 & 1]), i6, sArr6);
            i5 = i7 + 1;
            sArr3 = sArr5;
            sArr4 = sArr6;
        }
        return C6238Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] encFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i, int i2, int i3, short[] sArr, short[] sArr2) {
        int i4 = i2;
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radixConverter.getRadix()), i4, i3);
        C6238Arrays.reverseInPlace(sArr);
        C6238Arrays.reverseInPlace(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i5 = 0;
        while (i5 < 8) {
            int i6 = i - i4;
            int i7 = i5 & 1;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr3).add(calculateY_FF3(blockCipher, bArr, 4 - (i7 * 4), i5, sArr4, radixConverter)).mod(bigIntegerArrCalculateModUV[1 - i7]), i6, sArr3);
            i5++;
            i4 = i6;
            short[] sArr5 = sArr4;
            sArr4 = sArr3;
            sArr3 = sArr5;
        }
        C6238Arrays.reverseInPlace(sArr3);
        C6238Arrays.reverseInPlace(sArr4);
        return C6238Arrays.concatenate(sArr3, sArr4);
    }

    public static byte[] encryptFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), bArr2, i, i2);
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        return m15473toByte(m15470encFF1(blockCipher, radixConverter, bArr, i2, i3, i4, m15474toShort(bArr2, i, i3), m15474toShort(bArr2, i + i3, i4)));
    }

    public static short[] encryptFF1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), sArr, i, i2);
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        short[] sArr2 = new short[i3];
        short[] sArr3 = new short[i4];
        System.arraycopy(sArr, i, sArr2, 0, i3);
        System.arraycopy(sArr, i + i3, sArr3, 0, i4);
        return m15470encFF1(blockCipher, radixConverter, bArr, i2, i3, i4, sArr2, sArr3);
    }

    public static byte[] encryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i, i2);
        if (bArr.length == 8) {
            return implEncryptFF3(blockCipher, radixConverter, bArr, bArr2, i, i2);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] encryptFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i, i2);
        if (bArr.length == 7) {
            return encryptFF3(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), bArr2, i, i2);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3_1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i, i2);
        if (bArr.length == 7) {
            return encryptFF3w(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), sArr, i, i2);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i, i2);
        if (bArr.length == 8) {
            return implEncryptFF3w(blockCipher, radixConverter, bArr, sArr, i, i2);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] implDecryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        return m15473toByte(decFF3_1(blockCipher, radixConverter, bArr, i2, i3, i4, m15474toShort(bArr2, i, i4), m15474toShort(bArr2, i + i4, i3)));
    }

    public static short[] implDecryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        short[] sArr2 = new short[i4];
        short[] sArr3 = new short[i3];
        System.arraycopy(sArr, i, sArr2, 0, i4);
        System.arraycopy(sArr, i + i4, sArr3, 0, i3);
        return decFF3_1(blockCipher, radixConverter, bArr, i2, i3, i4, sArr2, sArr3);
    }

    public static byte[] implEncryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        return m15473toByte(encFF3_1(blockCipher, radixConverter, bArr, i2, i3, i4, m15474toShort(bArr2, i, i4), m15474toShort(bArr2, i + i4, i3)));
    }

    public static short[] implEncryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i, int i2) {
        int i3 = i2 / 2;
        int i4 = i2 - i3;
        short[] sArr2 = new short[i4];
        short[] sArr3 = new short[i3];
        System.arraycopy(sArr, i, sArr2, 0, i4);
        System.arraycopy(sArr, i + i4, sArr3, 0, i3);
        return encFF3_1(blockCipher, radixConverter, bArr, i2, i3, i4, sArr2, sArr3);
    }

    /* renamed from: num */
    public static BigInteger m15471num(byte[] bArr, int i, int i2) {
        return new BigInteger(1, C6238Arrays.copyOfRange(bArr, i, i2 + i));
    }

    /* renamed from: prf */
    public static byte[] m15472prf(BlockCipher blockCipher, byte[] bArr) {
        if (bArr.length % 16 != 0) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length / 16;
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < length; i++) {
            C6240Bytes.m18280xorTo(16, bArr, i * 16, bArr2, 0);
            blockCipher.processBlock(bArr2, 0, bArr2, 0);
        }
        return bArr2;
    }

    /* renamed from: toByte */
    private static byte[] m15473toByte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) sArr[i];
        }
        return bArr;
    }

    /* renamed from: toShort */
    private static short[] m15474toShort(byte[] bArr, int i, int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 != i2; i3++) {
            sArr[i3] = (short) (bArr[i + i3] & C1126UByte.MAX_VALUE);
        }
        return sArr;
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z, int i, short[] sArr, int i2, int i3) {
        checkCipher(blockCipher);
        if (i < 2 || i > 65536) {
            throw new IllegalArgumentException();
        }
        checkData(z, i, sArr, i2, i3);
    }

    public static void checkData(boolean z, int i, short[] sArr, int i2, int i3) {
        checkLength(z, i, i3);
        for (int i4 = 0; i4 < i3; i4++) {
            if ((sArr[i2 + i4] & 65535) >= i) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }
}
