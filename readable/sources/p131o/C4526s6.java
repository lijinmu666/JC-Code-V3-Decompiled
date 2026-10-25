package p131o;

/* renamed from: o.s6 */
/* loaded from: classes.dex */
public final class C4526s6 implements InterfaceC4439qpjZLY {

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f16461mjFkc;

    public C4526s6(InterfaceC3271Z3 interfaceC3271Z3) {
        this.f16461mjFkc = interfaceC3271Z3;
    }

    /* renamed from: AZxh */
    public static C4526s6 m13482AZxh(InterfaceC3271Z3 interfaceC3271Z3) {
        return new C4526s6(interfaceC3271Z3);
    }

    /* renamed from: mjFkc */
    public static AbstractC4391q6 m13483mjFkc(InterfaceC3350aDq interfaceC3350aDq) {
        return (AbstractC4391q6) AbstractC2070H3.m8510wA(AbstractC4460r6.m13336mjFkc(interfaceC3350aDq), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public AbstractC4391q6 mo7567get() {
        return m13483mjFkc((InterfaceC3350aDq) this.f16461mjFkc.mo7567get());
    }
}
