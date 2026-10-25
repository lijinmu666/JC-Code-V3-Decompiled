package org.bouncycastle.p194crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p213params.DSAParameterGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAValidationParameters;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.encoders.C6255Hex;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class DSAParametersGenerator {

    /* renamed from: L */
    private int f20229L;

    /* renamed from: N */
    private int f20230N;
    private int certainty;

    /* renamed from: digest */
    private InterfaceC5277Digest f20231digest;
    private int iterations;

    /* renamed from: random */
    private SecureRandom f20232random;
    private int usageIndex;
    private boolean use186_3;

    /* renamed from: ZERO */
    private static final BigInteger f20228ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    private static final BigInteger f20226ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f20227TWO = BigInteger.valueOf(2);

    public DSAParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerDivide = bigInteger.subtract(f20226ONE).divide(bigInteger2);
        BigInteger bigIntegerSubtract = bigInteger.subtract(f20227TWO);
        do {
            bigIntegerModPow = BigIntegers.createRandomInRange(f20227TWO, bigIntegerSubtract, secureRandom).modPow(bigIntegerDivide, bigInteger);
        } while (bigIntegerModPow.bitLength() <= 1);
        return bigIntegerModPow;
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(InterfaceC5277Digest interfaceC5277Digest, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
        BigInteger bigIntegerDivide = bigInteger.subtract(f20226ONE).divide(bigInteger2);
        byte[] bArrDecodeStrict = C6255Hex.decodeStrict("6767656E");
        int length = bArr.length + bArrDecodeStrict.length;
        byte[] bArr2 = new byte[length + 3];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecodeStrict, 0, bArr2, bArr.length, bArrDecodeStrict.length);
        bArr2[length] = (byte) i;
        byte[] bArr3 = new byte[interfaceC5277Digest.getDigestSize()];
        for (int i2 = 1; i2 < 65536; i2++) {
            m15489inc(bArr2);
            m15488hash(interfaceC5277Digest, bArr2, bArr3, 0);
            BigInteger bigIntegerModPow = new BigInteger(1, bArr3).modPow(bigIntegerDivide, bigInteger);
            if (bigIntegerModPow.compareTo(f20227TWO) >= 0) {
                return bigIntegerModPow;
            }
        }
        return null;
    }

    private DSAParameters generateParameters_FIPS186_2() {
        int i = 20;
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i2 = this.f20229L;
        int i3 = (i2 - 1) / 160;
        int i4 = i2 / 8;
        byte[] bArr5 = new byte[i4];
        if (!(this.f20231digest instanceof SHA1Digest)) {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
        while (true) {
            this.f20232random.nextBytes(bArr);
            m15488hash(this.f20231digest, bArr, bArr2, 0);
            System.arraycopy(bArr, 0, bArr3, 0, i);
            m15489inc(bArr3);
            m15488hash(this.f20231digest, bArr3, bArr3, 0);
            for (int i5 = 0; i5 != i; i5++) {
                bArr4[i5] = (byte) (bArr2[i5] ^ bArr3[i5]);
            }
            bArr4[0] = (byte) (bArr4[0] | ByteCompanionObject.MIN_VALUE);
            bArr4[19] = (byte) (bArr4[19] | 1);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            if (isProbablePrime(bigInteger)) {
                byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
                m15489inc(bArrM18231clone);
                int i6 = 0;
                while (i6 < 4096) {
                    for (int i7 = 1; i7 <= i3; i7++) {
                        m15489inc(bArrM18231clone);
                        m15488hash(this.f20231digest, bArrM18231clone, bArr5, i4 - (i7 * 20));
                    }
                    int i8 = i4 - (i3 * 20);
                    m15489inc(bArrM18231clone);
                    m15488hash(this.f20231digest, bArrM18231clone, bArr2, 0);
                    System.arraycopy(bArr2, 20 - i8, bArr5, 0, i8);
                    bArr5[0] = (byte) (bArr5[0] | ByteCompanionObject.MIN_VALUE);
                    BigInteger bigInteger2 = new BigInteger(1, bArr5);
                    BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(f20226ONE));
                    if (bigIntegerSubtract.bitLength() == this.f20229L && isProbablePrime(bigIntegerSubtract)) {
                        return new DSAParameters(bigIntegerSubtract, bigInteger, calculateGenerator_FIPS186_2(bigIntegerSubtract, bigInteger, this.f20232random), new DSAValidationParameters(bArr, i6));
                    }
                    i6++;
                    i = 20;
                }
            }
        }
    }

    private DSAParameters generateParameters_FIPS186_3() {
        BigInteger bit;
        int i;
        BigInteger bigIntegerSubtract;
        BigInteger bigIntegerCalculateGenerator_FIPS186_3_Verifiable;
        InterfaceC5277Digest interfaceC5277Digest = this.f20231digest;
        int digestSize = interfaceC5277Digest.getDigestSize() * 8;
        byte[] bArr = new byte[this.f20230N / 8];
        int i2 = this.f20229L;
        int i3 = (i2 - 1) / digestSize;
        int i4 = (i2 - 1) % digestSize;
        int i5 = i2 / 8;
        byte[] bArr2 = new byte[i5];
        int digestSize2 = interfaceC5277Digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        loop0: while (true) {
            this.f20232random.nextBytes(bArr);
            int i6 = 0;
            m15488hash(interfaceC5277Digest, bArr, bArr3, 0);
            bit = new BigInteger(1, bArr3).mod(f20226ONE.shiftLeft(this.f20230N - 1)).setBit(0).setBit(this.f20230N - 1);
            if (isProbablePrime(bit)) {
                byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
                int i7 = this.f20229L * 4;
                i = 0;
                while (i < i7) {
                    for (int i8 = 1; i8 <= i3; i8++) {
                        m15489inc(bArrM18231clone);
                        m15488hash(interfaceC5277Digest, bArrM18231clone, bArr2, i5 - (i8 * digestSize2));
                    }
                    int i9 = i5 - (i3 * digestSize2);
                    m15489inc(bArrM18231clone);
                    m15488hash(interfaceC5277Digest, bArrM18231clone, bArr3, i6);
                    System.arraycopy(bArr3, digestSize2 - i9, bArr2, i6, i9);
                    bArr2[i6] = (byte) (bArr2[i6] | ByteCompanionObject.MIN_VALUE);
                    BigInteger bigInteger = new BigInteger(1, bArr2);
                    bigIntegerSubtract = bigInteger.subtract(bigInteger.mod(bit.shiftLeft(1)).subtract(f20226ONE));
                    if (bigIntegerSubtract.bitLength() == this.f20229L && isProbablePrime(bigIntegerSubtract)) {
                        break loop0;
                    }
                    i++;
                    i6 = 0;
                }
            }
        }
        int i10 = this.usageIndex;
        return (i10 < 0 || (bigIntegerCalculateGenerator_FIPS186_3_Verifiable = calculateGenerator_FIPS186_3_Verifiable(interfaceC5277Digest, bigIntegerSubtract, bit, bArr, i10)) == null) ? new DSAParameters(bigIntegerSubtract, bit, calculateGenerator_FIPS186_3_Unverifiable(bigIntegerSubtract, bit, this.f20232random), new DSAValidationParameters(bArr, i)) : new DSAParameters(bigIntegerSubtract, bit, bigIntegerCalculateGenerator_FIPS186_3_Verifiable, new DSAValidationParameters(bArr, i, this.usageIndex));
    }

    private static int getDefaultN(int i) {
        return i > 1024 ? 256 : 160;
    }

    private static int getMinimumIterations(int i) {
        if (i <= 1024) {
            return 40;
        }
        return (((i - 1) / 1024) * 8) + 48;
    }

    /* renamed from: hash */
    private static void m15488hash(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, byte[] bArr2, int i) {
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        interfaceC5277Digest.mo14967doFinal(bArr2, i);
    }

    /* renamed from: inc */
    private static void m15489inc(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b;
            if (b != 0) {
                return;
            }
        }
    }

    private boolean isProbablePrime(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.certainty);
    }

    public DSAParameters generateParameters() {
        return this.use186_3 ? generateParameters_FIPS186_3() : generateParameters_FIPS186_2();
    }

    /* renamed from: init */
    public void m15490init(int i, int i2, SecureRandom secureRandom) {
        this.f20229L = i;
        this.f20230N = getDefaultN(i);
        this.certainty = i2;
        this.iterations = Math.max(getMinimumIterations(this.f20229L), (i2 + 1) / 2);
        this.f20232random = secureRandom;
        this.use186_3 = false;
        this.usageIndex = -1;
    }

    public DSAParametersGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20231digest = interfaceC5277Digest;
    }

    /* renamed from: init */
    public void m15491init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int iM15701getL = dSAParameterGenerationParameters.m15701getL();
        int iM15702getN = dSAParameterGenerationParameters.m15702getN();
        if (iM15701getL < 1024 || iM15701getL > 3072 || iM15701getL % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (iM15701getL == 1024 && iM15702getN != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        }
        if (iM15701getL == 2048 && iM15702getN != 224 && iM15702getN != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        }
        if (iM15701getL == 3072 && iM15702getN != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        }
        if (this.f20231digest.getDigestSize() * 8 < iM15702getN) {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
        this.f20229L = iM15701getL;
        this.f20230N = iM15702getN;
        this.certainty = dSAParameterGenerationParameters.getCertainty();
        this.iterations = Math.max(getMinimumIterations(iM15701getL), (this.certainty + 1) / 2);
        this.f20232random = dSAParameterGenerationParameters.getRandom();
        this.use186_3 = true;
        this.usageIndex = dSAParameterGenerationParameters.getUsageIndex();
    }
}
