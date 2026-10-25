package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
class RSACoreEngine {
    static final String NO_LENSTRA_CHECK = "org.bouncycastle.rsa.no_lenstra_check";
    private boolean forEncryption;

    /* renamed from: key */
    private RSAKeyParameters f20021key;

    private CryptoServicePurpose getPurpose(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = z && z2;
        boolean z5 = !z && z2;
        if (!z && !z2) {
            z3 = true;
        }
        return z4 ? CryptoServicePurpose.SIGNING : z5 ? CryptoServicePurpose.ENCRYPTION : z3 ? CryptoServicePurpose.VERIFYING : CryptoServicePurpose.DECRYPTION;
    }

    public BigInteger convertInput(byte[] bArr, int i, int i2) {
        if (i2 > getInputBlockSize() + 1) {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (i2 == getInputBlockSize() + 1 && !this.forEncryption) {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (i != 0 || i2 != bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(this.f20021key.getModulus()) < 0) {
            return bigInteger;
        }
        throw new DataLengthException("input too large for RSA cipher.");
    }

    public byte[] convertOutput(BigInteger bigInteger) {
        byte[] bArr;
        byte[] byteArray = bigInteger.toByteArray();
        if (!this.forEncryption) {
            if (byteArray[0] == 0) {
                int length = byteArray.length - 1;
                bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
            } else {
                int length2 = byteArray.length;
                bArr = new byte[length2];
                System.arraycopy(byteArray, 0, bArr, 0, length2);
            }
            C6238Arrays.m18249fill(byteArray, (byte) 0);
            return bArr;
        }
        if (byteArray[0] == 0 && byteArray.length > getOutputBlockSize()) {
            int length3 = byteArray.length - 1;
            byte[] bArr2 = new byte[length3];
            System.arraycopy(byteArray, 1, bArr2, 0, length3);
            return bArr2;
        }
        if (byteArray.length >= getOutputBlockSize()) {
            return byteArray;
        }
        int outputBlockSize = getOutputBlockSize();
        byte[] bArr3 = new byte[outputBlockSize];
        System.arraycopy(byteArray, 0, bArr3, outputBlockSize - byteArray.length, byteArray.length);
        return bArr3;
    }

    public int getInputBlockSize() {
        int iBitLength = (this.f20021key.getModulus().bitLength() + 7) / 8;
        return this.forEncryption ? iBitLength - 1 : iBitLength;
    }

    public int getOutputBlockSize() {
        int iBitLength = (this.f20021key.getModulus().bitLength() + 7) / 8;
        return this.forEncryption ? iBitLength : iBitLength - 1;
    }

    /* renamed from: init */
    public void m15376init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.forEncryption = z;
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f20021key = rSAKeyParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSA", ConstraintUtils.bitsOfSecurityFor(rSAKeyParameters.getModulus()), this.f20021key, getPurpose(this.f20021key.isPrivate(), z)));
    }

    public BigInteger processBlock(BigInteger bigInteger) {
        RSAKeyParameters rSAKeyParameters = this.f20021key;
        if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
            RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
            BigInteger publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
            if (publicExponent != null || Properties.isOverrideSet(NO_LENSTRA_CHECK)) {
                BigInteger bigIntegerM15808getP = rSAPrivateCrtKeyParameters.m15808getP();
                BigInteger bigIntegerM15809getQ = rSAPrivateCrtKeyParameters.m15809getQ();
                BigInteger bigIntegerM15806getDP = rSAPrivateCrtKeyParameters.m15806getDP();
                BigInteger bigIntegerM15807getDQ = rSAPrivateCrtKeyParameters.m15807getDQ();
                BigInteger bigIntegerM15810getQInv = rSAPrivateCrtKeyParameters.m15810getQInv();
                BigInteger bigIntegerModPow = bigInteger.remainder(bigIntegerM15808getP).modPow(bigIntegerM15806getDP, bigIntegerM15808getP);
                BigInteger bigIntegerModPow2 = bigInteger.remainder(bigIntegerM15809getQ).modPow(bigIntegerM15807getDQ, bigIntegerM15809getQ);
                BigInteger bigIntegerAdd = bigIntegerModPow.subtract(bigIntegerModPow2).multiply(bigIntegerM15810getQInv).mod(bigIntegerM15808getP).multiply(bigIntegerM15809getQ).add(bigIntegerModPow2);
                if (publicExponent == null || bigIntegerAdd.modPow(publicExponent, rSAPrivateCrtKeyParameters.getModulus()).equals(bigInteger)) {
                    return bigIntegerAdd;
                }
                throw new IllegalStateException("RSA engine faulty decryption/signing detected");
            }
            if (this.f20021key.getExponent() == null) {
                throw new IllegalStateException("null exponent, should \"org.bouncycastle.rsa.no_lenstra_check\" be enabled?");
            }
        }
        return bigInteger.modPow(this.f20021key.getExponent(), this.f20021key.getModulus());
    }
}
