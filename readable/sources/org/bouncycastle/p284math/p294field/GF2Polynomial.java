package org.bouncycastle.p284math.p294field;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class GF2Polynomial implements Polynomial {
    protected final int[] exponents;

    public GF2Polynomial(int[] iArr) {
        this.exponents = C6238Arrays.m18234clone(iArr);
    }

    /* renamed from: equals */
    public boolean m16874equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GF2Polynomial) {
            return C6238Arrays.areEqual(this.exponents, ((GF2Polynomial) obj).exponents);
        }
        return false;
    }

    @Override // org.bouncycastle.p284math.p294field.Polynomial
    public int getDegree() {
        return this.exponents[r1.length - 1];
    }

    @Override // org.bouncycastle.p284math.p294field.Polynomial
    public int[] getExponentsPresent() {
        return C6238Arrays.m18234clone(this.exponents);
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.exponents);
    }
}
