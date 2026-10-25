package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.zabxk */
/* loaded from: classes.dex */
public final class C5021zabxk implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f17688AZxh;

    /* renamed from: KLFTb */
    public final InterfaceC3271Z3 f17689KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f17690ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f17691mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f17692wA;

    public C5021zabxk(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35) {
        this.f17691mjFkc = interfaceC3271Z3;
        this.f17688AZxh = interfaceC3271Z32;
        this.f17692wA = interfaceC3271Z33;
        this.f17690ZfxDd = interfaceC3271Z34;
        this.f17689KLFTb = interfaceC3271Z35;
    }

    /* renamed from: mjFkc */
    public static C5021zabxk m14121mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35) {
        return new C5021zabxk(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34, interfaceC3271Z35);
    }

    /* renamed from: wA */
    public static C4217nTET m14122wA(Executor executor, InterfaceC4598tAfC interfaceC4598tAfC, InterfaceC4957yb interfaceC4957yb, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4992z7 interfaceC4992z7) {
        return new C4217nTET(executor, interfaceC4598tAfC, interfaceC4957yb, interfaceC4829wfQA, interfaceC4992z7);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C4217nTET mo7567get() {
        return m14122wA((Executor) this.f17691mjFkc.mo7567get(), (InterfaceC4598tAfC) this.f17688AZxh.mo7567get(), (InterfaceC4957yb) this.f17692wA.mo7567get(), (InterfaceC4829wfQA) this.f17690ZfxDd.mo7567get(), (InterfaceC4992z7) this.f17689KLFTb.mo7567get());
    }
}
