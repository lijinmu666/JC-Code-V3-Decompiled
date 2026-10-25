package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class SAKKEPrivateKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: qMinOne */
    private static final BigInteger f20828qMinOne = SAKKEPublicKeyParameters.f20837q.subtract(BigInteger.ONE);
    private final SAKKEPublicKeyParameters publicParams;

    /* renamed from: z */
    private final BigInteger f20829z;

    public SAKKEPrivateKeyParameters(BigInteger bigInteger, SAKKEPublicKeyParameters sAKKEPublicKeyParameters) {
        super(true);
        this.f20829z = bigInteger;
        this.publicParams = sAKKEPublicKeyParameters;
        if (!sAKKEPublicKeyParameters.getPoint().multiply(bigInteger).normalize().m16333equals(sAKKEPublicKeyParameters.m15814getZ())) {
            throw new IllegalStateException("public key and private key of SAKKE do not match");
        }
    }

    public BigInteger getMasterSecret() {
        return this.f20829z;
    }

    public SAKKEPublicKeyParameters getPublicParams() {
        return this.publicParams;
    }

    public SAKKEPrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        BigInteger bigInteger = BigIntegers.f24191TWO;
        BigInteger bigInteger2 = f20828qMinOne;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger, bigInteger2, secureRandom);
        this.f20829z = bigIntegerCreateRandomInRange;
        this.publicParams = new SAKKEPublicKeyParameters(BigIntegers.createRandomInRange(bigInteger, bigInteger2, secureRandom), SAKKEPublicKeyParameters.f20830P.multiply(bigIntegerCreateRandomInRange).normalize());
    }
}
