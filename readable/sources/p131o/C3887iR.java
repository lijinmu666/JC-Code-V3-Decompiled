package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.iR */
/* loaded from: classes.dex */
public final class C3887iR implements InterfaceC3432bT {

    /* renamed from: AZxh */
    public final Object f14150AZxh = new Object();

    /* renamed from: mjFkc */
    public final Executor f14151mjFkc;

    /* renamed from: wA */
    public InterfaceC3665f3 f14152wA;

    public C3887iR(Executor executor, InterfaceC3665f3 interfaceC3665f3) {
        this.f14151mjFkc = executor;
        this.f14152wA = interfaceC3665f3;
    }

    @Override // p131o.InterfaceC3432bT
    /* renamed from: mjFkc */
    public final void mo7600mjFkc(AbstractC1670B7 abstractC1670B7) {
        if (abstractC1670B7.mo7669qdMbNW()) {
            synchronized (this.f14150AZxh) {
                try {
                    if (this.f14152wA == null) {
                        return;
                    }
                    this.f14151mjFkc.execute(new RunnableC3428bQ(this, abstractC1670B7));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
