package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;

/* loaded from: classes2.dex */
class SimpleBigDecimal {
    private static final long serialVersionUID = 1;

    /* renamed from: bigInt */
    private final BigInteger f22140bigInt;

    /* renamed from: scale */
    private final int f22141scale;

    public SimpleBigDecimal(BigInteger bigInteger, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        this.f22140bigInt = bigInteger;
        this.f22141scale = i;
    }

    private void checkScale(SimpleBigDecimal simpleBigDecimal) {
        if (this.f22141scale != simpleBigDecimal.f22141scale) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public static SimpleBigDecimal getInstance(BigInteger bigInteger, int i) {
        return new SimpleBigDecimal(bigInteger.shiftLeft(i), i);
    }

    /* renamed from: add */
    public SimpleBigDecimal m16362add(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.f22140bigInt.add(bigInteger.shiftLeft(this.f22141scale)), this.f22141scale);
    }

    public SimpleBigDecimal adjustScale(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        int i2 = this.f22141scale;
        return i == i2 ? this : new SimpleBigDecimal(this.f22140bigInt.shiftLeft(i - i2), i);
    }

    public int compareTo(BigInteger bigInteger) {
        return this.f22140bigInt.compareTo(bigInteger.shiftLeft(this.f22141scale));
    }

    /* renamed from: divide */
    public SimpleBigDecimal m16364divide(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.f22140bigInt.divide(bigInteger), this.f22141scale);
    }

    /* renamed from: equals */
    public boolean m16366equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleBigDecimal)) {
            return false;
        }
        SimpleBigDecimal simpleBigDecimal = (SimpleBigDecimal) obj;
        return this.f22140bigInt.equals(simpleBigDecimal.f22140bigInt) && this.f22141scale == simpleBigDecimal.f22141scale;
    }

    /* renamed from: floor */
    public BigInteger m16367floor() {
        return this.f22140bigInt.shiftRight(this.f22141scale);
    }

    public int getScale() {
        return this.f22141scale;
    }

    public int hashCode() {
        return this.f22141scale ^ this.f22140bigInt.hashCode();
    }

    public int intValue() {
        return m16367floor().intValue();
    }

    public long longValue() {
        return m16367floor().longValue();
    }

    public SimpleBigDecimal multiply(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.f22140bigInt.multiply(bigInteger), this.f22141scale);
    }

    /* renamed from: negate */
    public SimpleBigDecimal m16368negate() {
        return new SimpleBigDecimal(this.f22140bigInt.negate(), this.f22141scale);
    }

    /* renamed from: round */
    public BigInteger m16369round() {
        return m16363add(new SimpleBigDecimal(ECConstants.f22091ONE, 1).adjustScale(this.f22141scale)).m16367floor();
    }

    public SimpleBigDecimal shiftLeft(int i) {
        return new SimpleBigDecimal(this.f22140bigInt.shiftLeft(i), this.f22141scale);
    }

    public SimpleBigDecimal subtract(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.f22140bigInt.subtract(bigInteger.shiftLeft(this.f22141scale)), this.f22141scale);
    }

    public String toString() {
        if (this.f22141scale == 0) {
            return this.f22140bigInt.toString();
        }
        BigInteger bigIntegerM16367floor = m16367floor();
        BigInteger bigIntegerSubtract = this.f22140bigInt.subtract(bigIntegerM16367floor.shiftLeft(this.f22141scale));
        if (this.f22140bigInt.signum() == -1) {
            bigIntegerSubtract = ECConstants.f22091ONE.shiftLeft(this.f22141scale).subtract(bigIntegerSubtract);
        }
        if (bigIntegerM16367floor.signum() == -1 && !bigIntegerSubtract.equals(ECConstants.f22094ZERO)) {
            bigIntegerM16367floor = bigIntegerM16367floor.add(ECConstants.f22091ONE);
        }
        String string = bigIntegerM16367floor.toString();
        char[] cArr = new char[this.f22141scale];
        String string2 = bigIntegerSubtract.toString(2);
        int length = string2.length();
        int i = this.f22141scale - length;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = '0';
        }
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i + i3] = string2.charAt(i3);
        }
        return string + "." + new String(cArr);
    }

    /* renamed from: add */
    public SimpleBigDecimal m16363add(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return new SimpleBigDecimal(this.f22140bigInt.add(simpleBigDecimal.f22140bigInt), this.f22141scale);
    }

    public int compareTo(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return this.f22140bigInt.compareTo(simpleBigDecimal.f22140bigInt);
    }

    /* renamed from: divide */
    public SimpleBigDecimal m16365divide(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return new SimpleBigDecimal(this.f22140bigInt.shiftLeft(this.f22141scale).divide(simpleBigDecimal.f22140bigInt), this.f22141scale);
    }

    public SimpleBigDecimal multiply(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        BigInteger bigIntegerMultiply = this.f22140bigInt.multiply(simpleBigDecimal.f22140bigInt);
        int i = this.f22141scale;
        return new SimpleBigDecimal(bigIntegerMultiply, i + i);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal simpleBigDecimal) {
        return m16363add(simpleBigDecimal.m16368negate());
    }
}
