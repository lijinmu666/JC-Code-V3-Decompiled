package org.bouncycastle.p284math.p294field;

import java.math.BigInteger;

/* loaded from: classes2.dex */
class PrimeField implements FiniteField {
    protected final BigInteger characteristic;

    public PrimeField(BigInteger bigInteger) {
        this.characteristic = bigInteger;
    }

    /* renamed from: equals */
    public boolean m16876equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrimeField) {
            return this.characteristic.equals(((PrimeField) obj).characteristic);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p294field.FiniteField
    public BigInteger getCharacteristic() {
        return this.characteristic;
    }

    @Override // org.bouncycastle.p284math.p294field.FiniteField
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.characteristic.hashCode();
    }
}
