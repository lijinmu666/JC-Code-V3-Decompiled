package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.CramerShoupKeyParameters;
import org.bouncycastle.p194crypto.p213params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.CramerShoupPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class CramerShoupCoreEngine {

    /* renamed from: ONE */
    private static final BigInteger f19789ONE = BigInteger.valueOf(1);
    private boolean forEncryption;

    /* renamed from: key */
    private CramerShoupKeyParameters f19790key;

    /* renamed from: label */
    private byte[] f19791label = null;

    /* renamed from: random */
    private SecureRandom f19792random;

    public static class CramerShoupCiphertextException extends Exception {
        private static final long serialVersionUID = -6360977166495345076L;

        public CramerShoupCiphertextException(String str) {
            super(str);
        }
    }

    private BigInteger generateRandomElement(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f19789ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    private boolean isValidMessage(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) < 0;
    }

    public BigInteger convertInput(byte[] bArr, int i, int i2) {
        if (i2 > getInputBlockSize() + 1) {
            throw new DataLengthException("input too large for Cramer Shoup cipher.");
        }
        if (i2 == getInputBlockSize() + 1 && this.forEncryption) {
            throw new DataLengthException("input too large for Cramer Shoup cipher.");
        }
        if (i != 0 || i2 != bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(this.f19790key.getParameters().m15678getP()) < 0) {
            return bigInteger;
        }
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
    }

    public byte[] convertOutput(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (this.forEncryption) {
            if (byteArray[0] == 0) {
                int length = byteArray.length - 1;
                byte[] bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
                return bArr;
            }
        } else {
            if (byteArray[0] == 0 && byteArray.length > getOutputBlockSize()) {
                int length2 = byteArray.length - 1;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(byteArray, 1, bArr2, 0, length2);
                return bArr2;
            }
            if (byteArray.length < getOutputBlockSize()) {
                int outputBlockSize = getOutputBlockSize();
                byte[] bArr3 = new byte[outputBlockSize];
                System.arraycopy(byteArray, 0, bArr3, outputBlockSize - byteArray.length, byteArray.length);
                return bArr3;
            }
        }
        return byteArray;
    }

    public BigInteger decryptBlock(CramerShoupCiphertext cramerShoupCiphertext) throws CramerShoupCiphertextException {
        if (this.f19790key.isPrivate() && !this.forEncryption) {
            CramerShoupKeyParameters cramerShoupKeyParameters = this.f19790key;
            if (cramerShoupKeyParameters instanceof CramerShoupPrivateKeyParameters) {
                CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) cramerShoupKeyParameters;
                BigInteger bigIntegerM15678getP = cramerShoupPrivateKeyParameters.getParameters().m15678getP();
                InterfaceC5277Digest interfaceC5277DigestM15677getH = cramerShoupPrivateKeyParameters.getParameters().m15677getH();
                byte[] byteArray = cramerShoupCiphertext.m15285getU1().toByteArray();
                interfaceC5277DigestM15677getH.mo14970update(byteArray, 0, byteArray.length);
                byte[] byteArray2 = cramerShoupCiphertext.m15286getU2().toByteArray();
                interfaceC5277DigestM15677getH.mo14970update(byteArray2, 0, byteArray2.length);
                byte[] byteArray3 = cramerShoupCiphertext.m15284getE().toByteArray();
                interfaceC5277DigestM15677getH.mo14970update(byteArray3, 0, byteArray3.length);
                byte[] bArr = this.f19791label;
                if (bArr != null) {
                    interfaceC5277DigestM15677getH.mo14970update(bArr, 0, bArr.length);
                }
                byte[] bArr2 = new byte[interfaceC5277DigestM15677getH.getDigestSize()];
                interfaceC5277DigestM15677getH.mo14967doFinal(bArr2, 0);
                BigInteger bigInteger = new BigInteger(1, bArr2);
                if (cramerShoupCiphertext.f19788v.equals(cramerShoupCiphertext.f19786u1.modPow(cramerShoupPrivateKeyParameters.m15680getX1().add(cramerShoupPrivateKeyParameters.m15682getY1().multiply(bigInteger)), bigIntegerM15678getP).multiply(cramerShoupCiphertext.f19787u2.modPow(cramerShoupPrivateKeyParameters.m15681getX2().add(cramerShoupPrivateKeyParameters.m15683getY2().multiply(bigInteger)), bigIntegerM15678getP)).mod(bigIntegerM15678getP))) {
                    return cramerShoupCiphertext.f19785e.multiply(cramerShoupCiphertext.f19786u1.modPow(cramerShoupPrivateKeyParameters.m15684getZ(), bigIntegerM15678getP).modInverse(bigIntegerM15678getP)).mod(bigIntegerM15678getP);
                }
                throw new CramerShoupCiphertextException("Sorry, that ciphertext is not correct");
            }
        }
        return null;
    }

    public CramerShoupCiphertext encryptBlock(BigInteger bigInteger) {
        if (this.f19790key.isPrivate() || !this.forEncryption) {
            return null;
        }
        CramerShoupKeyParameters cramerShoupKeyParameters = this.f19790key;
        if (!(cramerShoupKeyParameters instanceof CramerShoupPublicKeyParameters)) {
            return null;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) cramerShoupKeyParameters;
        BigInteger bigIntegerM15678getP = cramerShoupPublicKeyParameters.getParameters().m15678getP();
        BigInteger bigIntegerM15675getG1 = cramerShoupPublicKeyParameters.getParameters().m15675getG1();
        BigInteger bigIntegerM15676getG2 = cramerShoupPublicKeyParameters.getParameters().m15676getG2();
        BigInteger bigIntegerM15688getH = cramerShoupPublicKeyParameters.m15688getH();
        if (!isValidMessage(bigInteger, bigIntegerM15678getP)) {
            return null;
        }
        BigInteger bigIntegerGenerateRandomElement = generateRandomElement(bigIntegerM15678getP, this.f19792random);
        BigInteger bigIntegerModPow = bigIntegerM15675getG1.modPow(bigIntegerGenerateRandomElement, bigIntegerM15678getP);
        BigInteger bigIntegerModPow2 = bigIntegerM15676getG2.modPow(bigIntegerGenerateRandomElement, bigIntegerM15678getP);
        BigInteger bigIntegerMod = bigIntegerM15688getH.modPow(bigIntegerGenerateRandomElement, bigIntegerM15678getP).multiply(bigInteger).mod(bigIntegerM15678getP);
        InterfaceC5277Digest interfaceC5277DigestM15677getH = cramerShoupPublicKeyParameters.getParameters().m15677getH();
        byte[] byteArray = bigIntegerModPow.toByteArray();
        interfaceC5277DigestM15677getH.mo14970update(byteArray, 0, byteArray.length);
        byte[] byteArray2 = bigIntegerModPow2.toByteArray();
        interfaceC5277DigestM15677getH.mo14970update(byteArray2, 0, byteArray2.length);
        byte[] byteArray3 = bigIntegerMod.toByteArray();
        interfaceC5277DigestM15677getH.mo14970update(byteArray3, 0, byteArray3.length);
        byte[] bArr = this.f19791label;
        if (bArr != null) {
            interfaceC5277DigestM15677getH.mo14970update(bArr, 0, bArr.length);
        }
        byte[] bArr2 = new byte[interfaceC5277DigestM15677getH.getDigestSize()];
        interfaceC5277DigestM15677getH.mo14967doFinal(bArr2, 0);
        return new CramerShoupCiphertext(bigIntegerModPow, bigIntegerModPow2, bigIntegerMod, cramerShoupPublicKeyParameters.m15686getC().modPow(bigIntegerGenerateRandomElement, bigIntegerM15678getP).multiply(cramerShoupPublicKeyParameters.m15687getD().modPow(bigIntegerGenerateRandomElement.multiply(new BigInteger(1, bArr2)), bigIntegerM15678getP)).mod(bigIntegerM15678getP));
    }

    public int getInputBlockSize() {
        int iBitLength = (this.f19790key.getParameters().m15678getP().bitLength() + 7) / 8;
        return this.forEncryption ? iBitLength - 1 : iBitLength;
    }

    public int getOutputBlockSize() {
        int iBitLength = (this.f19790key.getParameters().m15678getP().bitLength() + 7) / 8;
        return this.forEncryption ? iBitLength : iBitLength - 1;
    }

    /* renamed from: init */
    public void m15292init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f19790key = (CramerShoupKeyParameters) parametersWithRandom.getParameters();
            random = parametersWithRandom.getRandom();
        } else {
            this.f19790key = (CramerShoupKeyParameters) cipherParameters;
            random = null;
        }
        this.f19792random = initSecureRandom(z, random);
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("CramerShoup", ConstraintUtils.bitsOfSecurityFor(this.f19790key.getParameters().m15678getP()), this.f19790key, C5342Utils.getPurpose(z)));
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    /* renamed from: init */
    public void m15293init(boolean z, CipherParameters cipherParameters, String str) {
        m15292init(z, cipherParameters);
        this.f19791label = C6250Strings.toUTF8ByteArray(str);
    }
}
