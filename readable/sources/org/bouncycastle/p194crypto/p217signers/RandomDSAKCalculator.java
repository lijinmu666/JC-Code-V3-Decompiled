package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class RandomDSAKCalculator implements DSAKCalculator {

    /* renamed from: ZERO */
    private static final BigInteger f21031ZERO = BigInteger.valueOf(0);

    /* renamed from: q */
    private BigInteger f21032q;

    /* renamed from: random */
    private SecureRandom f21033random;

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: init */
    public void mo15858init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    public boolean isDeterministic() {
        return false;
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: nextK */
    public BigInteger mo15860nextK() {
        int iBitLength = this.f21032q.bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.f21033random);
            if (!bigIntegerCreateRandomBigInteger.equals(f21031ZERO) && bigIntegerCreateRandomBigInteger.compareTo(this.f21032q) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAKCalculator
    /* renamed from: init */
    public void mo15859init(BigInteger bigInteger, SecureRandom secureRandom) {
        this.f21032q = bigInteger;
        this.f21033random = secureRandom;
    }
}
