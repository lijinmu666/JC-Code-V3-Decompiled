package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class DHPublicKeyParameters extends DHKeyParameters {

    /* renamed from: ONE */
    private static final BigInteger f20703ONE = BigInteger.valueOf(1);

    /* renamed from: TWO */
    private static final BigInteger f20704TWO = BigInteger.valueOf(2);

    /* renamed from: y */
    private BigInteger f20705y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f20705y = validate(bigInteger, dHParameters);
    }

    private static int legendre(BigInteger bigInteger, BigInteger bigInteger2) {
        int iBitLength = bigInteger2.bitLength();
        int[] iArrFromBigInteger = AbstractC5869Nat.fromBigInteger(iBitLength, bigInteger);
        int[] iArrFromBigInteger2 = AbstractC5869Nat.fromBigInteger(iBitLength, bigInteger2);
        int length = iArrFromBigInteger2.length;
        int i = 0;
        while (true) {
            int i2 = iArrFromBigInteger[0];
            if (i2 == 0) {
                AbstractC5869Nat.shiftDownWord(length, iArrFromBigInteger, 0);
            } else {
                int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(i2);
                if (iNumberOfTrailingZeros > 0) {
                    AbstractC5869Nat.shiftDownBits(length, iArrFromBigInteger, iNumberOfTrailingZeros, 0);
                    int i3 = iArrFromBigInteger2[0];
                    i ^= (iNumberOfTrailingZeros << 1) & (i3 ^ (i3 >>> 1));
                }
                int iM16897compare = AbstractC5869Nat.m16897compare(length, iArrFromBigInteger, iArrFromBigInteger2);
                if (iM16897compare == 0) {
                    break;
                }
                if (iM16897compare < 0) {
                    i ^= iArrFromBigInteger[0] & iArrFromBigInteger2[0];
                    int[] iArr = iArrFromBigInteger2;
                    iArrFromBigInteger2 = iArrFromBigInteger;
                    iArrFromBigInteger = iArr;
                }
                while (true) {
                    int i4 = length - 1;
                    if (iArrFromBigInteger[i4] != 0) {
                        break;
                    }
                    length = i4;
                }
                AbstractC5869Nat.m16936sub(length, iArrFromBigInteger, iArrFromBigInteger2, iArrFromBigInteger);
            }
        }
        if (AbstractC5869Nat.m16926isOne(length, iArrFromBigInteger2)) {
            return 1 - (i & 2);
        }
        return 0;
    }

    private BigInteger validate(BigInteger bigInteger, DHParameters dHParameters) {
        if (bigInteger == null) {
            throw new NullPointerException("y value cannot be null");
        }
        BigInteger bigIntegerM15695getP = dHParameters.m15695getP();
        BigInteger bigInteger2 = f20704TWO;
        if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(bigIntegerM15695getP.subtract(bigInteger2)) > 0) {
            throw new IllegalArgumentException("invalid DH public key");
        }
        BigInteger bigIntegerM15696getQ = dHParameters.m15696getQ();
        if (bigIntegerM15696getQ == null) {
            return bigInteger;
        }
        if (bigIntegerM15695getP.testBit(0) && bigIntegerM15695getP.bitLength() - 1 == bigIntegerM15696getQ.bitLength() && bigIntegerM15695getP.shiftRight(1).equals(bigIntegerM15696getQ)) {
            if (1 == legendre(bigInteger, bigIntegerM15695getP)) {
                return bigInteger;
            }
        } else if (f20703ONE.equals(bigInteger.modPow(bigIntegerM15696getQ, bigIntegerM15695getP))) {
            return bigInteger;
        }
        throw new IllegalArgumentException("Y value does not appear to be in correct group");
    }

    @Override // org.bouncycastle.p194crypto.p213params.DHKeyParameters
    /* renamed from: equals */
    public boolean mo15689equals(Object obj) {
        return (obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).m15698getY().equals(this.f20705y) && super.mo15689equals(obj);
    }

    /* renamed from: getY */
    public BigInteger m15698getY() {
        return this.f20705y;
    }

    @Override // org.bouncycastle.p194crypto.p213params.DHKeyParameters
    public int hashCode() {
        return super.hashCode() ^ this.f20705y.hashCode();
    }
}
