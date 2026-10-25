package p131o;

/* renamed from: o.f9 */
/* loaded from: classes.dex */
public final class C3671f9 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f13530AZxh;

    /* renamed from: KLFTb */
    public final InterfaceC3271Z3 f13531KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f13532ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f13533mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f13534wA;

    public C3671f9(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35) {
        this.f13533mjFkc = interfaceC3271Z3;
        this.f13530AZxh = interfaceC3271Z32;
        this.f13534wA = interfaceC3271Z33;
        this.f13532ZfxDd = interfaceC3271Z34;
        this.f13531KLFTb = interfaceC3271Z35;
    }

    /* renamed from: mjFkc */
    public static C3671f9 m11897mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35) {
        return new C3671f9(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34, interfaceC3271Z35);
    }

    /* renamed from: wA */
    public static C3543d9 m11898wA(InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, InterfaceC4324p6 interfaceC4324p6, C1672B9 c1672b9, C4824wb c4824wb) {
        return new C3543d9(interfaceC3350aDq, interfaceC3350aDq2, interfaceC4324p6, c1672b9, c4824wb);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C3543d9 mo7567get() {
        return m11898wA((InterfaceC3350aDq) this.f13533mjFkc.mo7567get(), (InterfaceC3350aDq) this.f13530AZxh.mo7567get(), (InterfaceC4324p6) this.f13534wA.mo7567get(), (C1672B9) this.f13532ZfxDd.mo7567get(), (C4824wb) this.f13531KLFTb.mo7567get());
    }
}
