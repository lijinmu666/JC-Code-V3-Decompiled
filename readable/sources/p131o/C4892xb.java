package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.xb */
/* loaded from: classes.dex */
public final class C4892xb implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f17401AZxh;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f17402ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f17403mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f17404wA;

    public C4892xb(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        this.f17403mjFkc = interfaceC3271Z3;
        this.f17401AZxh = interfaceC3271Z32;
        this.f17404wA = interfaceC3271Z33;
        this.f17402ZfxDd = interfaceC3271Z34;
    }

    /* renamed from: mjFkc */
    public static C4892xb m13950mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34) {
        return new C4892xb(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34);
    }

    /* renamed from: wA */
    public static C4824wb m13951wA(Executor executor, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4957yb interfaceC4957yb, InterfaceC4992z7 interfaceC4992z7) {
        return new C4824wb(executor, interfaceC4829wfQA, interfaceC4957yb, interfaceC4992z7);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C4824wb mo7567get() {
        return m13951wA((Executor) this.f17403mjFkc.mo7567get(), (InterfaceC4829wfQA) this.f17401AZxh.mo7567get(), (InterfaceC4957yb) this.f17404wA.mo7567get(), (InterfaceC4992z7) this.f17402ZfxDd.mo7567get());
    }
}
