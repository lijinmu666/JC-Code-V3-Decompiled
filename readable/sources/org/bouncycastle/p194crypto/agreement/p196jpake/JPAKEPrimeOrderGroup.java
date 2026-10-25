package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class JPAKEPrimeOrderGroup {

    /* renamed from: g */
    private final BigInteger f19200g;

    /* renamed from: p */
    private final BigInteger f19201p;

    /* renamed from: q */
    private final BigInteger f19202q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    /* renamed from: getG */
    public BigInteger m15021getG() {
        return this.f19200g;
    }

    /* renamed from: getP */
    public BigInteger m15022getP() {
        return this.f19201p;
    }

    /* renamed from: getQ */
    public BigInteger m15023getQ() {
        return this.f19202q;
    }

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z) {
        JPAKEUtil.validateNotNull(bigInteger, "p");
        JPAKEUtil.validateNotNull(bigInteger2, "q");
        JPAKEUtil.validateNotNull(bigInteger3, "g");
        if (!z) {
            BigInteger bigInteger4 = JPAKEUtil.f19207ONE;
            if (!bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(JPAKEUtil.f19208ZERO)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            }
            if (bigInteger3.compareTo(BigInteger.valueOf(2L)) < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            }
            if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            }
            if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            }
            if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f19201p = bigInteger;
        this.f19202q = bigInteger2;
        this.f19200g = bigInteger3;
    }
}
