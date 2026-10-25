package p131o;

import android.content.Context;
import java.util.concurrent.Executor;

/* renamed from: o.C9 */
/* loaded from: classes.dex */
public final class C1739C9 implements InterfaceC4439qpjZLY {

    /* renamed from: AZxh */
    public final InterfaceC3271Z3 f7570AZxh;

    /* renamed from: JHa */
    public final InterfaceC3271Z3 f7571JHa;

    /* renamed from: KLFTb */
    public final InterfaceC3271Z3 f7572KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC3271Z3 f7573ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3271Z3 f7574mjFkc;

    /* renamed from: wA */
    public final InterfaceC3271Z3 f7575wA;

    /* renamed from: xJ */
    public final InterfaceC3271Z3 f7576xJ;

    public C1739C9(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35, InterfaceC3271Z3 interfaceC3271Z36, InterfaceC3271Z3 interfaceC3271Z37) {
        this.f7574mjFkc = interfaceC3271Z3;
        this.f7570AZxh = interfaceC3271Z32;
        this.f7575wA = interfaceC3271Z33;
        this.f7573ZfxDd = interfaceC3271Z34;
        this.f7572KLFTb = interfaceC3271Z35;
        this.f7571JHa = interfaceC3271Z36;
        this.f7576xJ = interfaceC3271Z37;
    }

    /* renamed from: mjFkc */
    public static C1739C9 m7775mjFkc(InterfaceC3271Z3 interfaceC3271Z3, InterfaceC3271Z3 interfaceC3271Z32, InterfaceC3271Z3 interfaceC3271Z33, InterfaceC3271Z3 interfaceC3271Z34, InterfaceC3271Z3 interfaceC3271Z35, InterfaceC3271Z3 interfaceC3271Z36, InterfaceC3271Z3 interfaceC3271Z37) {
        return new C1739C9(interfaceC3271Z3, interfaceC3271Z32, interfaceC3271Z33, interfaceC3271Z34, interfaceC3271Z35, interfaceC3271Z36, interfaceC3271Z37);
    }

    /* renamed from: wA */
    public static C1672B9 m7776wA(Context context, InterfaceC4598tAfC interfaceC4598tAfC, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4957yb interfaceC4957yb, Executor executor, InterfaceC4992z7 interfaceC4992z7, InterfaceC3350aDq interfaceC3350aDq) {
        return new C1672B9(context, interfaceC4598tAfC, interfaceC4829wfQA, interfaceC4957yb, executor, interfaceC4992z7, interfaceC3350aDq);
    }

    @Override // p131o.InterfaceC3271Z3
    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C1672B9 mo7567get() {
        return m7776wA((Context) this.f7574mjFkc.mo7567get(), (InterfaceC4598tAfC) this.f7570AZxh.mo7567get(), (InterfaceC4829wfQA) this.f7575wA.mo7567get(), (InterfaceC4957yb) this.f7573ZfxDd.mo7567get(), (Executor) this.f7572KLFTb.mo7567get(), (InterfaceC4992z7) this.f7571JHa.mo7567get(), (InterfaceC3350aDq) this.f7576xJ.mo7567get());
    }
}
