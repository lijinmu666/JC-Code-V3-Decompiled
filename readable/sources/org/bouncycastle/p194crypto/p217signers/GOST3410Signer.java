package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.p213params.GOST3410KeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GOST3410Signer implements InterfaceC5276DSAExt {

    /* renamed from: key */
    GOST3410KeyParameters f20963key;

    /* renamed from: random */
    SecureRandom f20964random;

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigIntegerCreateRandomBigInteger;
        BigInteger bigInteger = new BigInteger(1, C6238Arrays.m18267reverse(bArr));
        GOST3410Parameters parameters = this.f20963key.getParameters();
        do {
            bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(parameters.m15752getQ().bitLength(), this.f20964random);
        } while (bigIntegerCreateRandomBigInteger.compareTo(parameters.m15752getQ()) >= 0);
        BigInteger bigIntegerMod = parameters.m15750getA().modPow(bigIntegerCreateRandomBigInteger, parameters.m15751getP()).mod(parameters.m15752getQ());
        return new BigInteger[]{bigIntegerMod, bigIntegerCreateRandomBigInteger.multiply(bigInteger).add(((GOST3410PrivateKeyParameters) this.f20963key).m15753getX().multiply(bigIntegerMod)).mod(parameters.m15752getQ())};
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20963key.getParameters().m15752getQ();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    /* renamed from: init */
    public void mo14965init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random = null;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            }
            this.f20963key = (GOST3410PrivateKeyParameters) cipherParameters;
            this.f20964random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.f20963key = (GOST3410PublicKeyParameters) cipherParameters;
            this.f20964random = null;
        }
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("GOST3410", this.f20963key, z));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, C6238Arrays.m18267reverse(bArr));
        GOST3410Parameters parameters = this.f20963key.getParameters();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (bigIntegerValueOf.compareTo(bigInteger) >= 0 || parameters.m15752getQ().compareTo(bigInteger) <= 0 || bigIntegerValueOf.compareTo(bigInteger2) >= 0 || parameters.m15752getQ().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigIntegerModPow = bigInteger3.modPow(parameters.m15752getQ().subtract(new BigInteger("2")), parameters.m15752getQ());
        return parameters.m15750getA().modPow(bigInteger2.multiply(bigIntegerModPow).mod(parameters.m15752getQ()), parameters.m15751getP()).multiply(((GOST3410PublicKeyParameters) this.f20963key).m15754getY().modPow(parameters.m15752getQ().subtract(bigInteger).multiply(bigIntegerModPow).mod(parameters.m15752getQ()), parameters.m15751getP())).mod(parameters.m15751getP()).mod(parameters.m15752getQ()).equals(bigInteger);
    }
}
