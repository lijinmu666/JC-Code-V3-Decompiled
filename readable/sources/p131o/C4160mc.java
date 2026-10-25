package p131o;

/* renamed from: o.mc */
/* loaded from: classes.dex */
public final class C4160mc {

    /* renamed from: AZxh */
    public final C2987UokA f15201AZxh;

    /* renamed from: mjFkc */
    public final C2245JYn f15202mjFkc;

    public /* synthetic */ C4160mc(C2245JYn c2245JYn, C2987UokA c2987UokA, AbstractC4094lc abstractC4094lc) {
        this.f15202mjFkc = c2245JYn;
        this.f15201AZxh = c2987UokA;
    }

    /* renamed from: equals */
    public final boolean m12775equals(Object obj) {
        if (obj != null && (obj instanceof C4160mc)) {
            C4160mc c4160mc = (C4160mc) obj;
            if (AbstractC2931U2.m10465mjFkc(this.f15202mjFkc, c4160mc.f15202mjFkc) && AbstractC2931U2.m10465mjFkc(this.f15201AZxh, c4160mc.f15201AZxh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC2931U2.m10464AZxh(this.f15202mjFkc, this.f15201AZxh);
    }

    public final String toString() {
        return AbstractC2931U2.m10466wA(this).m10467mjFkc("key", this.f15202mjFkc).m10467mjFkc("feature", this.f15201AZxh).toString();
    }
}
