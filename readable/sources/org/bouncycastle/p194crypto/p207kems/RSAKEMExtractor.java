package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;

/* loaded from: classes2.dex */
public class RSAKEMExtractor implements EncapsulatedSecretExtractor {

    /* renamed from: kdf */
    private DerivationFunction f20377kdf;

    /* renamed from: keyLen */
    private final int f20378keyLen;

    /* renamed from: privKey */
    private final RSAKeyParameters f20379privKey;

    public RSAKEMExtractor(RSAKeyParameters rSAKeyParameters, int i, DerivationFunction derivationFunction) {
        if (!rSAKeyParameters.isPrivate()) {
            throw new IllegalArgumentException("private key required for encryption");
        }
        this.f20379privKey = rSAKeyParameters;
        this.f20378keyLen = i;
        this.f20377kdf = derivationFunction;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSAKem", ConstraintUtils.bitsOfSecurityFor(rSAKeyParameters.getModulus()), rSAKeyParameters, CryptoServicePurpose.DECRYPTION));
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        BigInteger modulus = this.f20379privKey.getModulus();
        return RSAKEMGenerator.generateKey(this.f20377kdf, modulus, new BigInteger(1, bArr).modPow(this.f20379privKey.getExponent(), modulus), this.f20378keyLen);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return (this.f20379privKey.getModulus().bitLength() + 7) / 8;
    }
}
