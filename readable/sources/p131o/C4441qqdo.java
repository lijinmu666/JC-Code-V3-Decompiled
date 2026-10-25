package p131o;

/* renamed from: o.qqdo */
/* loaded from: classes.dex */
public final class C4441qqdo {

    /* renamed from: AZxh */
    public final int f16237AZxh;

    /* renamed from: mjFkc */
    public final Class f16238mjFkc;

    /* renamed from: wA */
    public final int f16239wA;

    public C4441qqdo(Class cls, int i, int i2) {
        this.f16238mjFkc = (Class) AbstractC2207J3.m8886wA(cls, "Null dependency anInterface.");
        this.f16237AZxh = i;
        this.f16239wA = i2;
    }

    /* renamed from: lgHUyS */
    public static C4441qqdo m13297lgHUyS(Class cls) {
        return new C4441qqdo(cls, 1, 1);
    }

    /* renamed from: mjFkc */
    public static String m13298mjFkc(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    /* renamed from: qdMbNW */
    public static C4441qqdo m13299qdMbNW(Class cls) {
        return new C4441qqdo(cls, 2, 0);
    }

    /* renamed from: xJ */
    public static C4441qqdo m13300xJ(Class cls) {
        return new C4441qqdo(cls, 1, 0);
    }

    /* renamed from: AZxh */
    public Class m13301AZxh() {
        return this.f16238mjFkc;
    }

    /* renamed from: JHa */
    public boolean m13302JHa() {
        return this.f16237AZxh == 2;
    }

    /* renamed from: KLFTb */
    public boolean m13303KLFTb() {
        return this.f16237AZxh == 1;
    }

    /* renamed from: ZfxDd */
    public boolean m13304ZfxDd() {
        return this.f16239wA == 0;
    }

    /* renamed from: equals */
    public boolean m13305equals(Object obj) {
        if (!(obj instanceof C4441qqdo)) {
            return false;
        }
        C4441qqdo c4441qqdo = (C4441qqdo) obj;
        return this.f16238mjFkc == c4441qqdo.f16238mjFkc && this.f16237AZxh == c4441qqdo.f16237AZxh && this.f16239wA == c4441qqdo.f16239wA;
    }

    public int hashCode() {
        return this.f16239wA ^ ((((this.f16238mjFkc.hashCode() ^ 1000003) * 1000003) ^ this.f16237AZxh) * 1000003);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f16238mjFkc);
        sb.append(", type=");
        int i = this.f16237AZxh;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(m13298mjFkc(this.f16239wA));
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: wA */
    public boolean m13306wA() {
        return this.f16239wA == 2;
    }
}
