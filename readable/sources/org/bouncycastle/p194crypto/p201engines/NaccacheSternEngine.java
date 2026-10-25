package org.bouncycastle.p194crypto.p201engines;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.NaccacheSternKeyParameters;
import org.bouncycastle.p194crypto.p213params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NaccacheSternEngine implements AsymmetricBlockCipher {
    private boolean forEncryption;

    /* renamed from: key */
    private NaccacheSternKeyParameters f19973key;

    /* renamed from: ZERO */
    private static BigInteger f19971ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    private static BigInteger f19970ONE = BigInteger.valueOf(1);

    /* renamed from: lookup */
    private Vector[] f19974lookup = null;

    /* renamed from: debug */
    private boolean f19972debug = false;

    private static BigInteger chineseRemainder(Vector vector, Vector vector2) {
        BigInteger bigIntegerAdd = f19971ZERO;
        BigInteger bigIntegerMultiply = f19970ONE;
        for (int i = 0; i < vector2.size(); i++) {
            bigIntegerMultiply = bigIntegerMultiply.multiply((BigInteger) vector2.elementAt(i));
        }
        for (int i2 = 0; i2 < vector2.size(); i2++) {
            BigInteger bigInteger = (BigInteger) vector2.elementAt(i2);
            BigInteger bigIntegerDivide = bigIntegerMultiply.divide(bigInteger);
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerDivide.multiply(bigIntegerDivide.modInverse(bigInteger)).multiply((BigInteger) vector.elementAt(i2)));
        }
        return bigIntegerAdd.mod(bigIntegerMultiply);
    }

    public byte[] addCryptedBlocks(byte[] bArr, byte[] bArr2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            if (bArr.length > getOutputBlockSize() || bArr2.length > getOutputBlockSize()) {
                throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
            }
        } else if (bArr.length > getInputBlockSize() || bArr2.length > getInputBlockSize()) {
            throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger bigIntegerMod = bigInteger.multiply(bigInteger2).mod(this.f19973key.getModulus());
        if (this.f19972debug) {
            PrintStream printStream = System.out;
            printStream.println("c(m1) as BigInteger:....... " + bigInteger);
            printStream.println("c(m2) as BigInteger:....... " + bigInteger2);
            printStream.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + bigIntegerMod);
        }
        byte[] byteArray = this.f19973key.getModulus().toByteArray();
        C6238Arrays.m18249fill(byteArray, (byte) 0);
        System.arraycopy(bigIntegerMod.toByteArray(), 0, byteArray, byteArray.length - bigIntegerMod.toByteArray().length, bigIntegerMod.toByteArray().length);
        return byteArray;
    }

    /* renamed from: encrypt */
    public byte[] m15366encrypt(BigInteger bigInteger) {
        byte[] byteArray = this.f19973key.getModulus().toByteArray();
        C6238Arrays.m18249fill(byteArray, (byte) 0);
        byte[] byteArray2 = this.f19973key.m15799getG().modPow(bigInteger, this.f19973key.getModulus()).toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, byteArray.length - byteArray2.length, byteArray2.length);
        if (this.f19972debug) {
            System.out.println("Encrypted value is:  " + new BigInteger(byteArray));
        }
        return byteArray;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.forEncryption ? ((r1.getLowerSigmaBound() + 7) / 8) - 1 : this.f19973key.getModulus().toByteArray().length;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.forEncryption ? this.f19973key.getModulus().toByteArray().length : ((r1.getLowerSigmaBound() + 7) / 8) - 1;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.f19973key = (NaccacheSternKeyParameters) cipherParameters;
        if (!this.forEncryption) {
            if (this.f19972debug) {
                System.out.println("Constructing lookup Array");
            }
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.f19973key;
            Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
            this.f19974lookup = new Vector[smallPrimes.size()];
            for (int i = 0; i < smallPrimes.size(); i++) {
                BigInteger bigInteger = (BigInteger) smallPrimes.elementAt(i);
                int iIntValue = bigInteger.intValue();
                this.f19974lookup[i] = new Vector();
                this.f19974lookup[i].addElement(f19970ONE);
                if (this.f19972debug) {
                    System.out.println("Constructing lookup ArrayList for " + iIntValue);
                }
                BigInteger bigIntegerAdd = f19971ZERO;
                for (int i2 = 1; i2 < iIntValue; i2++) {
                    bigIntegerAdd = bigIntegerAdd.add(naccacheSternPrivateKeyParameters.getPhi_n());
                    this.f19974lookup[i].addElement(naccacheSternPrivateKeyParameters.m15799getG().modPow(bigIntegerAdd.divide(bigInteger), naccacheSternPrivateKeyParameters.getModulus()));
                }
            }
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("NaccacheStern", ConstraintUtils.bitsOfSecurityFor(this.f19973key.getModulus()), cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.f19973key == null) {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        }
        if (i2 > getInputBlockSize() + 1) {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
        if (!this.forEncryption && i2 < getInputBlockSize()) {
            throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
        if (i != 0 || i2 != bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (this.f19972debug) {
            System.out.println("input as BigInteger: " + bigInteger);
        }
        if (this.forEncryption) {
            return m15366encrypt(bigInteger);
        }
        Vector vector = new Vector();
        NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.f19973key;
        Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
        for (int i3 = 0; i3 < smallPrimes.size(); i3++) {
            BigInteger bigIntegerModPow = bigInteger.modPow(naccacheSternPrivateKeyParameters.getPhi_n().divide((BigInteger) smallPrimes.elementAt(i3)), naccacheSternPrivateKeyParameters.getModulus());
            Vector vector2 = this.f19974lookup[i3];
            if (vector2.size() != ((BigInteger) smallPrimes.elementAt(i3)).intValue()) {
                if (this.f19972debug) {
                    System.out.println("Prime is " + smallPrimes.elementAt(i3) + ", lookup table has size " + vector2.size());
                }
                throw new InvalidCipherTextException("Error in lookup Array for " + ((BigInteger) smallPrimes.elementAt(i3)).intValue() + ": Size mismatch. Expected ArrayList with length " + ((BigInteger) smallPrimes.elementAt(i3)).intValue() + " but found ArrayList of length " + this.f19974lookup[i3].size());
            }
            int iIndexOf = vector2.indexOf(bigIntegerModPow);
            if (iIndexOf == -1) {
                if (this.f19972debug) {
                    PrintStream printStream = System.out;
                    printStream.println("Actual prime is " + smallPrimes.elementAt(i3));
                    printStream.println("Decrypted value is " + bigIntegerModPow);
                    printStream.println("LookupList for " + smallPrimes.elementAt(i3) + " with size " + this.f19974lookup[i3].size() + " is: ");
                    for (int i4 = 0; i4 < this.f19974lookup[i3].size(); i4++) {
                        System.out.println(this.f19974lookup[i3].elementAt(i4));
                    }
                }
                throw new InvalidCipherTextException("Lookup failed");
            }
            vector.addElement(BigInteger.valueOf(iIndexOf));
        }
        return chineseRemainder(vector, smallPrimes).toByteArray();
    }

    public byte[] processData(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArrProcessBlock;
        if (this.f19972debug) {
            System.out.println();
        }
        if (bArr.length <= getInputBlockSize()) {
            if (this.f19972debug) {
                System.out.println("data size is less then input block size, processing directly");
            }
            return processBlock(bArr, 0, bArr.length);
        }
        int inputBlockSize = getInputBlockSize();
        int outputBlockSize = getOutputBlockSize();
        if (this.f19972debug) {
            PrintStream printStream = System.out;
            printStream.println("Input blocksize is:  " + inputBlockSize + " bytes");
            printStream.println("Output blocksize is: " + outputBlockSize + " bytes");
            printStream.println("Data has length:.... " + bArr.length + " bytes");
        }
        byte[] bArr2 = new byte[((bArr.length / inputBlockSize) + 1) * outputBlockSize];
        int length = 0;
        int length2 = 0;
        while (length < bArr.length) {
            int i = length + inputBlockSize;
            if (i < bArr.length) {
                bArrProcessBlock = processBlock(bArr, length, inputBlockSize);
                length = i;
            } else {
                bArrProcessBlock = processBlock(bArr, length, bArr.length - length);
                length += bArr.length - length;
            }
            if (this.f19972debug) {
                System.out.println("new datapos is " + length);
            }
            if (bArrProcessBlock == null) {
                if (this.f19972debug) {
                    System.out.println("cipher returned null");
                }
                throw new InvalidCipherTextException("cipher returned null");
            }
            System.arraycopy(bArrProcessBlock, 0, bArr2, length2, bArrProcessBlock.length);
            length2 += bArrProcessBlock.length;
        }
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        if (this.f19972debug) {
            System.out.println("returning " + length2 + " bytes");
        }
        return bArr3;
    }

    public void setDebug(boolean z) {
        this.f19972debug = z;
    }
}
