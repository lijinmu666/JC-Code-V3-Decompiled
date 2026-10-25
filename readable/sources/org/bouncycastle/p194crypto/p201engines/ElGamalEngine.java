package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.ElGamalKeyParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ElGamalPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ElGamalEngine implements AsymmetricBlockCipher {

    /* renamed from: bitSize */
    private int f19839bitSize;
    private boolean forEncryption;

    /* renamed from: key */
    private ElGamalKeyParameters f19840key;

    /* renamed from: random */
    private SecureRandom f19841random;

    /* renamed from: ZERO */
    private static final BigInteger f19838ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    private static final BigInteger f19836ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f19837TWO = BigInteger.valueOf(2);

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        boolean z = this.forEncryption;
        int i = this.f19839bitSize;
        return z ? (i - 1) / 8 : ((i + 7) / 8) * 2;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        boolean z = this.forEncryption;
        int i = this.f19839bitSize;
        return z ? ((i + 7) / 8) * 2 : (i - 1) / 8;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f19840key = (ElGamalKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            this.f19840key = (ElGamalKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.f19841random = secureRandom;
        this.forEncryption = z;
        this.f19839bitSize = this.f19840key.getParameters().m15745getP().bitLength();
        ElGamalKeyParameters elGamalKeyParameters = this.f19840key;
        if (z) {
            if (!(elGamalKeyParameters instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(elGamalKeyParameters instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSA", ConstraintUtils.bitsOfSecurityFor(this.f19840key.getParameters().m15745getP()), this.f19840key, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigIntegerCreateRandomBigInteger;
        if (this.f19840key == null) {
            throw new IllegalStateException("ElGamal engine not initialised");
        }
        if (i2 > (this.forEncryption ? (this.f19839bitSize + 6) / 8 : getInputBlockSize())) {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        BigInteger bigIntegerM15745getP = this.f19840key.getParameters().m15745getP();
        if (this.f19840key instanceof ElGamalPrivateKeyParameters) {
            int i3 = i2 / 2;
            byte[] bArr2 = new byte[i3];
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, i3);
            System.arraycopy(bArr, i + i3, bArr3, 0, i3);
            return BigIntegers.asUnsignedByteArray(new BigInteger(1, bArr2).modPow(bigIntegerM15745getP.subtract(f19836ONE).subtract(((ElGamalPrivateKeyParameters) this.f19840key).m15746getX()), bigIntegerM15745getP).multiply(new BigInteger(1, bArr3)).mod(bigIntegerM15745getP));
        }
        if (i != 0 || i2 != bArr.length) {
            byte[] bArr4 = new byte[i2];
            System.arraycopy(bArr, i, bArr4, 0, i2);
            bArr = bArr4;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(bigIntegerM15745getP) >= 0) {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.f19840key;
        int iBitLength = bigIntegerM15745getP.bitLength();
        while (true) {
            bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.f19841random);
            if (!bigIntegerCreateRandomBigInteger.equals(f19838ZERO) && bigIntegerCreateRandomBigInteger.compareTo(bigIntegerM15745getP.subtract(f19837TWO)) <= 0) {
                break;
            }
        }
        BigInteger bigIntegerModPow = this.f19840key.getParameters().m15743getG().modPow(bigIntegerCreateRandomBigInteger, bigIntegerM15745getP);
        BigInteger bigIntegerMod = bigInteger.multiply(elGamalPublicKeyParameters.m15747getY().modPow(bigIntegerCreateRandomBigInteger, bigIntegerM15745getP)).mod(bigIntegerM15745getP);
        byte[] byteArray = bigIntegerModPow.toByteArray();
        byte[] byteArray2 = bigIntegerMod.toByteArray();
        int outputBlockSize = getOutputBlockSize();
        byte[] bArr5 = new byte[outputBlockSize];
        int i4 = outputBlockSize / 2;
        if (byteArray.length > i4) {
            System.arraycopy(byteArray, 1, bArr5, i4 - (byteArray.length - 1), byteArray.length - 1);
        } else {
            System.arraycopy(byteArray, 0, bArr5, i4 - byteArray.length, byteArray.length);
        }
        if (byteArray2.length > i4) {
            System.arraycopy(byteArray2, 1, bArr5, outputBlockSize - (byteArray2.length - 1), byteArray2.length - 1);
        } else {
            System.arraycopy(byteArray2, 0, bArr5, outputBlockSize - byteArray2.length, byteArray2.length);
        }
        return bArr5;
    }
}
