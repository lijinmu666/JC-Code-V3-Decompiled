package p131o;

/* renamed from: o.Fs */
/* loaded from: classes.dex */
public final class C1993Fs extends AbstractC1790Cs {

    /* renamed from: mjFkc */
    public final Object f8273mjFkc;

    public C1993Fs(Object obj) {
        this.f8273mjFkc = obj;
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: AZxh */
    public final Object mo7937AZxh(Object obj) {
        return this.f8273mjFkc;
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: equals */
    public final boolean mo7938equals(Object obj) {
        if (obj instanceof C1993Fs) {
            return this.f8273mjFkc.equals(((C1993Fs) obj).f8273mjFkc);
        }
        return false;
    }

    @Override // p131o.AbstractC1790Cs
    public final int hashCode() {
        return this.f8273mjFkc.hashCode() + 1502476572;
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: mjFkc */
    public final Object mo7939mjFkc() {
        return this.f8273mjFkc;
    }

    public final String toString() {
        return "Optional.of(" + this.f8273mjFkc.toString() + ")";
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: wA */
    public final boolean mo7940wA() {
        return true;
    }
}
