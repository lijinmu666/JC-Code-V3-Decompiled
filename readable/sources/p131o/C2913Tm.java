package p131o;

/* renamed from: o.Tm */
/* loaded from: classes.dex */
public final class C2913Tm {

    /* renamed from: AZxh */
    public final int f10743AZxh;

    /* renamed from: mjFkc */
    public final int f10744mjFkc;

    public C2913Tm(int i, int i2) {
        AbstractC1851Ds.m8063wA(i < 32767 && i >= 0);
        AbstractC1851Ds.m8063wA(i2 < 32767 && i2 >= 0);
        this.f10744mjFkc = i;
        this.f10743AZxh = i2;
    }

    /* renamed from: AZxh */
    public final int m10435AZxh() {
        return this.f10744mjFkc;
    }

    /* renamed from: equals */
    public final boolean m10436equals(Object obj) {
        if (obj instanceof C2913Tm) {
            C2913Tm c2913Tm = (C2913Tm) obj;
            if (this.f10744mjFkc == c2913Tm.f10744mjFkc && this.f10743AZxh == c2913Tm.f10743AZxh) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10743AZxh | (this.f10744mjFkc << 16);
    }

    /* renamed from: mjFkc */
    public final int m10437mjFkc() {
        return this.f10743AZxh;
    }

    public final String toString() {
        return this.f10744mjFkc + "x" + this.f10743AZxh;
    }
}
