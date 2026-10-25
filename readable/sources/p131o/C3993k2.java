package p131o;

/* renamed from: o.k2 */
/* loaded from: classes.dex */
public class C3993k2 extends Exception {

    /* renamed from: mjFkc */
    public final int f14413mjFkc;

    public C3993k2(String str, int i) {
        super(AbstractC2138I3.m8641JHa(str, "Provided message must not be empty."));
        this.f14413mjFkc = i;
    }

    /* renamed from: mjFkc */
    public int m12462mjFkc() {
        return this.f14413mjFkc;
    }

    public C3993k2(String str, int i, Throwable th) {
        super(AbstractC2138I3.m8641JHa(str, "Provided message must not be empty."), th);
        this.f14413mjFkc = i;
    }
}
