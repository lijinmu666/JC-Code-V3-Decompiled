package org.bouncycastle.p194crypto.generators;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.NaccacheSternKeyParameters;
import org.bouncycastle.p194crypto.p213params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: param */
    private NaccacheSternKeyGenerationParameters f20271param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, AbstractC5816Primes.SMALL_FACTOR_LIMIT, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};

    /* renamed from: ONE */
    private static final BigInteger f20270ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomPrime;
        do {
            bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i, i2, secureRandom);
        } while (bigIntegerCreateRandomPrime.bitLength() != i);
        return bigIntegerCreateRandomPrime;
    }

    /* renamed from: getInt */
    private static int m15495getInt(SecureRandom secureRandom, int i) {
        int iNextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((i * (secureRandom.nextInt() & Integer.MAX_VALUE)) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = iNextInt % i;
        } while ((iNextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), m15495getInt(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigIntegerGeneratePrime;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerGeneratePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigIntegerAdd2;
        BigInteger bigInteger3;
        BigInteger bigIntegerMultiply;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        long j;
        BigInteger bigIntegerMod;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        int i;
        BigInteger bigInteger9;
        BigInteger bigInteger10;
        BigInteger bigInteger11;
        PrintStream printStream;
        StringBuilder sb;
        String str;
        long j2;
        BigInteger bigIntegerCreateRandomPrime;
        SecureRandom secureRandom;
        SecureRandom secureRandom2;
        int i2;
        BigInteger bigInteger12;
        int i3;
        int strength = this.f20271param.getStrength();
        SecureRandom random = this.f20271param.getRandom();
        int certainty = this.f20271param.getCertainty();
        boolean zM15798isDebug = this.f20271param.m15798isDebug();
        if (zM15798isDebug) {
            System.out.println("Fetching first " + this.f20271param.getCntSmallPrimes() + " primes.");
        }
        Vector vectorPermuteList = permuteList(findFirstPrimes(this.f20271param.getCntSmallPrimes()), random);
        BigInteger bigIntegerMultiply2 = f20270ONE;
        BigInteger bigIntegerMultiply3 = bigIntegerMultiply2;
        for (int i4 = 0; i4 < vectorPermuteList.size() / 2; i4++) {
            bigIntegerMultiply3 = bigIntegerMultiply3.multiply((BigInteger) vectorPermuteList.elementAt(i4));
        }
        for (int size = vectorPermuteList.size() / 2; size < vectorPermuteList.size(); size++) {
            bigIntegerMultiply2 = bigIntegerMultiply2.multiply((BigInteger) vectorPermuteList.elementAt(size));
        }
        BigInteger bigIntegerMultiply4 = bigIntegerMultiply3.multiply(bigIntegerMultiply2);
        int iBitLength = (((strength - bigIntegerMultiply4.bitLength()) - 48) / 2) + 1;
        BigInteger bigIntegerGeneratePrime3 = generatePrime(iBitLength, certainty, random);
        BigInteger bigIntegerGeneratePrime4 = generatePrime(iBitLength, certainty, random);
        if (zM15798isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger bigIntegerShiftLeft = bigIntegerGeneratePrime3.multiply(bigIntegerMultiply3).shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bigIntegerGeneratePrime4.multiply(bigIntegerMultiply2).shiftLeft(1);
        long j3 = 0;
        while (true) {
            j3++;
            int i5 = 24;
            bigIntegerGeneratePrime = generatePrime(24, certainty, random);
            bigIntegerAdd = bigIntegerGeneratePrime.multiply(bigIntegerShiftLeft).add(f20270ONE);
            if (bigIntegerAdd.isProbablePrime(certainty)) {
                while (true) {
                    bigIntegerGeneratePrime2 = generatePrime(i5, certainty, random);
                    if (!bigIntegerGeneratePrime.equals(bigIntegerGeneratePrime2)) {
                        BigInteger bigIntegerMultiply5 = bigIntegerGeneratePrime2.multiply(bigIntegerShiftLeft2);
                        bigInteger = bigIntegerShiftLeft2;
                        bigInteger2 = f20270ONE;
                        bigIntegerAdd2 = bigIntegerMultiply5.add(bigInteger2);
                        if (bigIntegerAdd2.isProbablePrime(certainty)) {
                            break;
                        }
                        bigIntegerShiftLeft2 = bigInteger;
                        bigIntegerShiftLeft = bigIntegerShiftLeft;
                        i5 = 24;
                    }
                }
                bigInteger3 = bigIntegerShiftLeft;
                if (BigIntegers.modOddIsCoprime(bigIntegerGeneratePrime.multiply(bigIntegerGeneratePrime2), bigIntegerMultiply4)) {
                    bigIntegerMultiply = bigIntegerAdd.multiply(bigIntegerAdd2);
                    bigInteger4 = bigIntegerGeneratePrime4;
                    if (bigIntegerMultiply.bitLength() >= strength) {
                        break;
                    }
                    int i6 = strength;
                    secureRandom2 = random;
                    i2 = certainty;
                    bigInteger12 = bigInteger4;
                    if (zM15798isDebug) {
                        PrintStream printStream2 = System.out;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("key size too small. Should be ");
                        i3 = i6;
                        sb2.append(i3);
                        sb2.append(" but is actually ");
                        sb2.append(bigIntegerAdd.multiply(bigIntegerAdd2).bitLength());
                        printStream2.println(sb2.toString());
                    } else {
                        i3 = i6;
                    }
                    bigIntegerGeneratePrime4 = bigInteger12;
                    strength = i3;
                    bigIntegerShiftLeft2 = bigInteger;
                    bigIntegerShiftLeft = bigInteger3;
                    random = secureRandom2;
                    certainty = i2;
                } else {
                    i3 = strength;
                    secureRandom2 = random;
                    i2 = certainty;
                }
            } else {
                bigInteger = bigIntegerShiftLeft2;
                secureRandom2 = random;
                i2 = certainty;
                bigInteger3 = bigIntegerShiftLeft;
                i3 = strength;
            }
            bigInteger12 = bigIntegerGeneratePrime4;
            bigIntegerGeneratePrime4 = bigInteger12;
            strength = i3;
            bigIntegerShiftLeft2 = bigInteger;
            bigIntegerShiftLeft = bigInteger3;
            random = secureRandom2;
            certainty = i2;
        }
        BigInteger bigInteger13 = bigIntegerGeneratePrime3;
        if (zM15798isDebug) {
            bigInteger5 = bigIntegerGeneratePrime2;
            System.out.println("needed " + j3 + " tries to generate p and q.");
        } else {
            bigInteger5 = bigIntegerGeneratePrime2;
        }
        BigInteger bigIntegerMultiply6 = bigIntegerAdd.subtract(bigInteger2).multiply(bigIntegerAdd2.subtract(bigInteger2));
        if (zM15798isDebug) {
            System.out.println("generating g");
        }
        long j4 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger6 = bigIntegerAdd2;
            j = j4;
            int i7 = 0;
            while (i7 != vectorPermuteList.size()) {
                BigInteger bigIntegerDivide = bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i7));
                while (true) {
                    j2 = j + 1;
                    bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(strength, certainty, random);
                    secureRandom = random;
                    if (bigIntegerCreateRandomPrime.modPow(bigIntegerDivide, bigIntegerMultiply).equals(f20270ONE)) {
                        j = j2;
                        random = secureRandom;
                    }
                }
                vector.addElement(bigIntegerCreateRandomPrime);
                i7++;
                j = j2;
                random = secureRandom;
            }
            SecureRandom secureRandom3 = random;
            bigIntegerMod = f20270ONE;
            int i8 = 0;
            while (i8 < vectorPermuteList.size()) {
                bigIntegerMod = bigIntegerMod.multiply(((BigInteger) vector.elementAt(i8)).modPow(bigIntegerMultiply4.divide((BigInteger) vectorPermuteList.elementAt(i8)), bigIntegerMultiply)).mod(bigIntegerMultiply);
                i8++;
                certainty = certainty;
            }
            int i9 = certainty;
            int i10 = 0;
            while (true) {
                if (i10 >= vectorPermuteList.size()) {
                    BigInteger bigIntegerModPow = bigIntegerMod.modPow(bigIntegerMultiply6.divide(BigInteger.valueOf(4L)), bigIntegerMultiply);
                    BigInteger bigInteger14 = f20270ONE;
                    if (!bigIntegerModPow.equals(bigInteger14)) {
                        if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime), bigIntegerMultiply).equals(bigInteger14)) {
                            bigInteger7 = bigInteger5;
                            if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger7), bigIntegerMultiply).equals(bigInteger14)) {
                                bigInteger8 = bigInteger13;
                                if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger8), bigIntegerMultiply).equals(bigInteger14)) {
                                    i = strength;
                                    bigInteger9 = bigInteger4;
                                    if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger9), bigIntegerMultiply).equals(bigInteger14)) {
                                        break;
                                    }
                                    if (zM15798isDebug) {
                                        PrintStream printStream3 = System.out;
                                        StringBuilder sb3 = new StringBuilder();
                                        bigInteger11 = bigIntegerMultiply6;
                                        sb3.append("g has order phi(n)/b\n g: ");
                                        sb3.append(bigIntegerMod);
                                        printStream3.println(sb3.toString());
                                    } else {
                                        bigInteger11 = bigIntegerMultiply6;
                                    }
                                } else {
                                    if (zM15798isDebug) {
                                        PrintStream printStream4 = System.out;
                                        StringBuilder sb4 = new StringBuilder();
                                        i = strength;
                                        sb4.append("g has order phi(n)/a\n g: ");
                                        sb4.append(bigIntegerMod);
                                        printStream4.println(sb4.toString());
                                    } else {
                                        i = strength;
                                    }
                                    bigInteger11 = bigIntegerMultiply6;
                                }
                            } else {
                                if (zM15798isDebug) {
                                    System.out.println("g has order phi(n)/q'\n g: " + bigIntegerMod);
                                }
                                bigInteger11 = bigIntegerMultiply6;
                                bigInteger8 = bigInteger13;
                            }
                        } else if (zM15798isDebug) {
                            printStream = System.out;
                            sb = new StringBuilder();
                            str = "g has order phi(n)/p'\n g: ";
                            sb.append(str);
                            sb.append(bigIntegerMod);
                            printStream.println(sb.toString());
                        }
                    } else if (zM15798isDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/4\n g:";
                        sb.append(str);
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                } else if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i10)), bigIntegerMultiply).equals(f20270ONE)) {
                    i10++;
                } else if (zM15798isDebug) {
                    System.out.println("g has order phi(n)/" + vectorPermuteList.elementAt(i10) + "\n g: " + bigIntegerMod);
                }
            }
            bigInteger11 = bigIntegerMultiply6;
            bigInteger8 = bigInteger13;
            bigInteger7 = bigInteger5;
            i = strength;
            bigInteger9 = bigInteger4;
            bigInteger4 = bigInteger9;
            bigInteger5 = bigInteger7;
            j4 = j;
            bigIntegerMultiply6 = bigInteger11;
            strength = i;
            bigIntegerAdd2 = bigInteger6;
            random = secureRandom3;
            certainty = i9;
            bigInteger13 = bigInteger8;
        }
        BigInteger bigInteger15 = bigIntegerMultiply6;
        if (zM15798isDebug) {
            PrintStream printStream5 = System.out;
            printStream5.println("needed " + j + " tries to generate g");
            printStream5.println();
            printStream5.println("found new NaccacheStern cipher variables:");
            printStream5.println("smallPrimes: " + vectorPermuteList);
            printStream5.println("sigma:...... " + bigIntegerMultiply4 + " (" + bigIntegerMultiply4.bitLength() + " bits)");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("a:.......... ");
            sb5.append(bigInteger8);
            printStream5.println(sb5.toString());
            printStream5.println("b:.......... " + bigInteger9);
            printStream5.println("p':......... " + bigIntegerGeneratePrime);
            printStream5.println("q':......... " + bigInteger7);
            printStream5.println("p:.......... " + bigIntegerAdd);
            printStream5.println("q:.......... " + bigInteger6);
            printStream5.println("n:.......... " + bigIntegerMultiply);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("phi(n):..... ");
            bigInteger10 = bigInteger15;
            sb6.append(bigInteger10);
            printStream5.println(sb6.toString());
            printStream5.println("g:.......... " + bigIntegerMod);
            printStream5.println();
        } else {
            bigInteger10 = bigInteger15;
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength(), vectorPermuteList, bigInteger10));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f20271param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("NaccacheStern KeyGen", ConstraintUtils.bitsOfSecurityForFF(keyGenerationParameters.getStrength()), keyGenerationParameters, CryptoServicePurpose.KEYGEN));
    }
}
