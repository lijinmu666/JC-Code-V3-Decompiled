package org.bouncycastle.p284math.p294field;

import java.math.BigInteger;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public abstract class FiniteFields {

    /* renamed from: GF_2 */
    static final FiniteField f22477GF_2 = new PrimeField(BigInteger.valueOf(2));

    /* renamed from: GF_3 */
    static final FiniteField f22478GF_3 = new PrimeField(BigInteger.valueOf(3));

    public static PolynomialExtensionField getBinaryExtensionField(int[] iArr) {
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i = 1; i < iArr.length; i++) {
            if (iArr[i] <= iArr[i - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        return new GenericPolynomialExtensionField(f22477GF_2, new GF2Polynomial(iArr));
    }

    public static FiniteField getPrimeField(BigInteger bigInteger) {
        int iBitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || iBitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (iBitLength < 3) {
            int iIntValueExact = BigIntegers.intValueExact(bigInteger);
            if (iIntValueExact == 2) {
                return f22477GF_2;
            }
            if (iIntValueExact == 3) {
                return f22478GF_3;
            }
        }
        return new PrimeField(bigInteger);
    }
}
