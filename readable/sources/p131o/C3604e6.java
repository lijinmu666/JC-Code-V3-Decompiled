package p131o;

/* renamed from: o.e6 */
/* loaded from: classes.dex */
public final class C3604e6 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f13435AZxh;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f13436ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f13437mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f13438wA;

    public C3604e6(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        this.f13437mjFkc = interfaceC3271Z3;
        this.f13435AZxh = interfaceC3271Z32;
        this.f13438wA = interfaceC3271Z33;
        this.f13436ZfxDd = interfaceC3271Z34;
    }

    /* renamed from: mjFkc */
    public static C3604e6 m11801mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        return new C3604e6(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34);
    }

    /* renamed from: wA */
    public static C3540d6 m11802wA(InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, Object obj, Object obj2) {
        return new C3540d6(interfaceC3350aDq, interfaceC3350aDq2, (AbstractC3264YxdwU) obj, (C4991z6) obj2);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C3540d6 mo7567get() {
        return m11802wA((InterfaceC3350aDq) this.f13437mjFkc.mo7567get(), (InterfaceC3350aDq) this.f13435AZxh.mo7567get(), this.f13438wA.mo7567get(), this.f13436ZfxDd.mo7567get());
    }
}
