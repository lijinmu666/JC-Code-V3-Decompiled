package p131o;

/* renamed from: o.WB */
/* loaded from: classes.dex */
public final class C3079WB {

    /* renamed from: AZxh */
    public final Object f11443AZxh;

    /* renamed from: mjFkc */
    public final Object f11444mjFkc;

    /* renamed from: wA */
    public final Object f11445wA;

    public C3079WB(Object obj, Object obj2, Object obj3) {
        this.f11444mjFkc = obj;
        this.f11443AZxh = obj2;
        this.f11445wA = obj3;
    }

    /* renamed from: mjFkc */
    public final IllegalArgumentException m10834mjFkc() {
        Object obj = this.f11445wA;
        Object obj2 = this.f11443AZxh;
        Object obj3 = this.f11444mjFkc;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + "=" + String.valueOf(obj2) + " and " + String.valueOf(obj3) + "=" + String.valueOf(obj));
    }
}
