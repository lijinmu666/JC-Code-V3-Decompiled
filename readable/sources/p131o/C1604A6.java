package p131o;

import android.content.Context;

/* renamed from: o.A6 */
/* loaded from: classes.dex */
public final class C1604A6 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f7314AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f7315mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f7316wA;

    public C1604A6(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33) {
        this.f7315mjFkc = interfaceC3271Z3;
        this.f7314AZxh = interfaceC3271Z32;
        this.f7316wA = interfaceC3271Z33;
    }

    /* renamed from: mjFkc */
    public static C1604A6 m7564mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33) {
        return new C1604A6(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33);
    }

    /* renamed from: wA */
    public static C4991z6 m7565wA(Context context, String str, int i) {
        return new C4991z6(context, str, i);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C4991z6 mo7567get() {
        return m7565wA((Context) this.f7315mjFkc.mo7567get(), (String) this.f7314AZxh.mo7567get(), ((Integer) this.f7316wA.mo7567get()).intValue());
    }
}
