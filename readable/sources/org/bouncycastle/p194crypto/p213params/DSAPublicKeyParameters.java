package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class DSAPublicKeyParameters extends DSAKeyParameters {

    /* renamed from: ONE */
    private static final BigInteger f20717ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f20718TWO = BigInteger.valueOf(2);

    /* renamed from: y */
    private BigInteger f20719y;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        this.f20719y = validate(bigInteger, dSAParameters);
    }

    private BigInteger validate(BigInteger bigInteger, DSAParameters dSAParameters) {
        if (dSAParameters == null) {
            return bigInteger;
        }
        BigInteger bigInteger2 = f20718TWO;
        if (bigInteger2.compareTo(bigInteger) > 0 || dSAParameters.m15705getP().subtract(bigInteger2).compareTo(bigInteger) < 0 || !f20717ONE.equals(bigInteger.modPow(dSAParameters.m15706getQ(), dSAParameters.m15705getP()))) {
            throw new IllegalArgumentException("y value does not appear to be in correct group");
        }
        return bigInteger;
    }

    /* renamed from: getY */
    public BigInteger m15708getY() {
        return this.f20719y;
    }
}
