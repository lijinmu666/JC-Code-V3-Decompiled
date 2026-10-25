package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class RSAKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: kdf */
    private DerivationFunction f20382kdf;

    /* renamed from: keyLen */
    private final int f20383keyLen;

    /* renamed from: rnd */
    private SecureRandom f20384rnd;

    /* renamed from: ZERO */
    private static final BigInteger f20381ZERO = BigInteger.valueOf(0);

    /* renamed from: ONE */
    private static final BigInteger f20380ONE = BigInteger.valueOf(1);

    public RSAKEMGenerator(int i, DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.f20383keyLen = i;
        this.f20382kdf = derivationFunction;
        this.f20384rnd = secureRandom;
    }

    public static byte[] generateKey(DerivationFunction derivationFunction, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        derivationFunction.mo14966init(new KDFParameters(BigIntegers.asUnsignedByteArray((bigInteger.bitLength() + 7) / 8, bigInteger2), null));
        byte[] bArr = new byte[i];
        derivationFunction.generateBytes(bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
        if (rSAKeyParameters.isPrivate()) {
            throw new IllegalArgumentException("public key required for encryption");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSAKem", ConstraintUtils.bitsOfSecurityFor(rSAKeyParameters.getModulus()), rSAKeyParameters, CryptoServicePurpose.ENCRYPTION));
        BigInteger modulus = rSAKeyParameters.getModulus();
        BigInteger exponent = rSAKeyParameters.getExponent();
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(f20381ZERO, modulus.subtract(f20380ONE), this.f20384rnd);
        return new SecretWithEncapsulationImpl(generateKey(this.f20382kdf, modulus, bigIntegerCreateRandomInRange, this.f20383keyLen), BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, bigIntegerCreateRandomInRange.modPow(exponent, modulus)));
    }
}
