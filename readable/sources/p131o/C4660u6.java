package p131o;

import android.content.Context;

/* renamed from: o.u6 */
/* loaded from: classes.dex */
public final class C4660u6 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f16800AZxh;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f16801ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f16802mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f16803wA;

    public C4660u6(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        this.f16802mjFkc = interfaceC3271Z3;
        this.f16800AZxh = interfaceC3271Z32;
        this.f16803wA = interfaceC3271Z33;
        this.f16801ZfxDd = interfaceC3271Z34;
    }

    /* renamed from: mjFkc */
    public static C4660u6 m13694mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        return new C4660u6(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34);
    }

    /* renamed from: wA */
    public static InterfaceC4957yb m13695wA(Context context, InterfaceC4829wfQA interfaceC4829wfQA, AbstractC4391q6 abstractC4391q6, InterfaceC3350aDq interfaceC3350aDq) {
        return (InterfaceC4957yb) AbstractC2070H3.m8510wA(AbstractC4593t6.m13600mjFkc(context, interfaceC4829wfQA, abstractC4391q6, interfaceC3350aDq), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public InterfaceC4957yb mo7567get() {
        return m13695wA((Context) this.f16802mjFkc.mo7567get(), (InterfaceC4829wfQA) this.f16800AZxh.mo7567get(), (AbstractC4391q6) this.f16803wA.mo7567get(), (InterfaceC3350aDq) this.f16801ZfxDd.mo7567get());
    }
}
