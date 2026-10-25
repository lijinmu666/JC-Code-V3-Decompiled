package p131o;

/* renamed from: o.D5 */
/* loaded from: classes.dex */
public final class C1804D5 {

    /* renamed from: AZxh */
    public static C1804D5 f7827AZxh;

    /* renamed from: wA */
    public static final C1866E5 f7828wA = new C1866E5(0, false, false, 0, 0);

    /* renamed from: mjFkc */
    public C1866E5 f7829mjFkc;

    /* renamed from: AZxh */
    public static synchronized C1804D5 m7970AZxh() {
        try {
            if (f7827AZxh == null) {
                f7827AZxh = new C1804D5();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7827AZxh;
    }

    /* renamed from: mjFkc */
    public C1866E5 m7971mjFkc() {
        return this.f7829mjFkc;
    }

    /* renamed from: wA */
    public final synchronized void m7972wA(C1866E5 c1866e5) {
        if (c1866e5 == null) {
            this.f7829mjFkc = f7828wA;
            return;
        }
        C1866E5 c1866e52 = this.f7829mjFkc;
        if (c1866e52 == null || c1866e52.m8103JHa() < c1866e5.m8103JHa()) {
            this.f7829mjFkc = c1866e5;
        }
    }
}
