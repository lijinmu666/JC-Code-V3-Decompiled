package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSABlindingParameters;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class RSABlindingEngine implements AsymmetricBlockCipher {
    private BigInteger blindingFactor;

    /* renamed from: core */
    private RSACoreEngine f20019core = new RSACoreEngine();
    private boolean forEncryption;

    /* renamed from: key */
    private RSAKeyParameters f20020key;

    private BigInteger blindMessage(BigInteger bigInteger) {
        return bigInteger.multiply(this.blindingFactor.modPow(this.f20020key.getExponent(), this.f20020key.getModulus())).mod(this.f20020key.getModulus());
    }

    private BigInteger unblindMessage(BigInteger bigInteger) {
        BigInteger modulus = this.f20020key.getModulus();
        return bigInteger.multiply(BigIntegers.modOddInverse(modulus, this.blindingFactor)).mod(modulus);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.f20019core.getInputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.f20019core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        RSABlindingParameters rSABlindingParameters = (RSABlindingParameters) cipherParameters;
        this.f20019core.m15376init(z, rSABlindingParameters.getPublicKey());
        this.forEncryption = z;
        this.f20020key = rSABlindingParameters.getPublicKey();
        this.blindingFactor = rSABlindingParameters.getBlindingFactor();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        BigInteger bigIntegerConvertInput = this.f20019core.convertInput(bArr, i, i2);
        return this.f20019core.convertOutput(this.forEncryption ? blindMessage(bigIntegerConvertInput) : unblindMessage(bigIntegerConvertInput));
    }
}
