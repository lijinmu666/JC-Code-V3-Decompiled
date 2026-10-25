package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class RSABlindedEngine implements AsymmetricBlockCipher {

    /* renamed from: ONE */
    private static final BigInteger f20015ONE = BigInteger.valueOf(1);

    /* renamed from: core */
    private RSACoreEngine f20016core = new RSACoreEngine();

    /* renamed from: key */
    private RSAKeyParameters f20017key;

    /* renamed from: random */
    private SecureRandom f20018random;

    private BigInteger processInput(BigInteger bigInteger) {
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters;
        BigInteger publicExponent;
        RSAKeyParameters rSAKeyParameters = this.f20017key;
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) || (publicExponent = (rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters).getPublicExponent()) == null) {
            return this.f20016core.processBlock(bigInteger);
        }
        BigInteger modulus = rSAPrivateCrtKeyParameters.getModulus();
        BigInteger bigInteger2 = f20015ONE;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger2, modulus.subtract(bigInteger2), this.f20018random);
        return BigIntegers.modOddInverse(modulus, bigIntegerCreateRandomInRange).multiply(this.f20016core.processBlock(bigIntegerCreateRandomInRange.modPow(publicExponent, modulus).multiply(bigInteger).mod(modulus))).mod(modulus);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.f20016core.getInputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.f20016core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            random = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            random = null;
        }
        this.f20016core.m15376init(z, cipherParameters);
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f20017key = rSAKeyParameters;
        this.f20018random = initSecureRandom(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters, random);
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        if (this.f20017key == null) {
            throw new IllegalStateException("RSA engine not initialised");
        }
        return this.f20016core.convertOutput(processInput(this.f20016core.convertInput(bArr, i, i2)));
    }
}
