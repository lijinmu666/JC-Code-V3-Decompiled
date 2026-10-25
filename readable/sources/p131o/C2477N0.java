package p131o;

import java.math.BigDecimal;

/* renamed from: o.N0 */
/* loaded from: classes.dex */
public final class C2477N0 extends Number {

    /* renamed from: mjFkc */
    public final String f9630mjFkc;

    public C2477N0(String str) {
        this.f9630mjFkc = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f9630mjFkc);
    }

    /* renamed from: equals */
    public boolean m9572equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2477N0)) {
            return false;
        }
        String str = this.f9630mjFkc;
        String str2 = ((C2477N0) obj).f9630mjFkc;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f9630mjFkc);
    }

    public int hashCode() {
        return this.f9630mjFkc.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f9630mjFkc);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f9630mjFkc);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f9630mjFkc).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f9630mjFkc);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f9630mjFkc).longValue();
        }
    }

    public String toString() {
        return this.f9630mjFkc;
    }
}
