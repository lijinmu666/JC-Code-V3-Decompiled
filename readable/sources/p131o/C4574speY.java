package p131o;

import android.content.Context;

/* renamed from: o.speY */
/* loaded from: classes.dex */
public final class C4574speY implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f16542AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f16543mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f16544wA;

    public C4574speY(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33) {
        this.f16543mjFkc = interfaceC3271Z3;
        this.f16542AZxh = interfaceC3271Z32;
        this.f16544wA = interfaceC3271Z33;
    }

    /* renamed from: mjFkc */
    public static C4574speY m13523mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33) {
        return new C4574speY(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33);
    }

    /* renamed from: wA */
    public static C2039GaZ m13524wA(Context context, InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2) {
        return new C2039GaZ(context, interfaceC3350aDq, interfaceC3350aDq2);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C2039GaZ mo7567get() {
        return m13524wA((Context) this.f16543mjFkc.mo7567get(), (InterfaceC3350aDq) this.f16542AZxh.mo7567get(), (InterfaceC3350aDq) this.f16544wA.mo7567get());
    }
}
