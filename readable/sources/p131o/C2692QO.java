package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.QO */
/* loaded from: classes.dex */
public final class C2692QO implements InterfaceC3432bT {

    /* renamed from: AZxh */
    public final Object f10175AZxh = new Object();

    /* renamed from: mjFkc */
    public final Executor f10176mjFkc;

    /* renamed from: wA */
    public InterfaceC3405b3 f10177wA;

    public C2692QO(Executor executor, InterfaceC3405b3 interfaceC3405b3) {
        this.f10176mjFkc = executor;
        this.f10177wA = interfaceC3405b3;
    }

    @Override // p131o.InterfaceC3432bT
    /* renamed from: mjFkc */
    public final void mo7600mjFkc(AbstractC1670B7 abstractC1670B7) {
        if (abstractC1670B7.mo7669qdMbNW() || abstractC1670B7.mo7671xJ()) {
            return;
        }
        synchronized (this.f10175AZxh) {
            try {
                if (this.f10177wA == null) {
                    return;
                }
                this.f10176mjFkc.execute(new RunnableC2094HN(this, abstractC1670B7));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
