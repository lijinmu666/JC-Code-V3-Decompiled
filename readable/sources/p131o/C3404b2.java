package p131o;

import android.content.Context;

/* renamed from: o.b2 */
/* loaded from: classes.dex */
public final class C3404b2 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f12845AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f12846mjFkc;

    public C3404b2(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32) {
        this.f12846mjFkc = interfaceC3271Z3;
        this.f12845AZxh = interfaceC3271Z32;
    }

    /* renamed from: mjFkc */
    public static C3404b2 m11445mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32) {
        return new C3404b2(interfaceC3271Z3, interfaceC3271Z32);
    }

    /* renamed from: wA */
    public static C3337a2 m11446wA(Context context, Object obj) {
        return new C3337a2(context, (C2039GaZ) obj);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C3337a2 mo7567get() {
        return m11446wA((Context) this.f12846mjFkc.mo7567get(), this.f12845AZxh.mo7567get());
    }
}
