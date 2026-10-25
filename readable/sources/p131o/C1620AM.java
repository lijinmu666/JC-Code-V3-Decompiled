package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.AM */
/* loaded from: classes.dex */
public final class C1620AM implements InterfaceC3432bT {

    /* renamed from: AZxh */
    public final Object f7350AZxh = new Object();

    /* renamed from: mjFkc */
    public final Executor f7351mjFkc;

    /* renamed from: wA */
    public InterfaceC3270Z2 f7352wA;

    public C1620AM(Executor executor, InterfaceC3270Z2 interfaceC3270Z2) {
        this.f7351mjFkc = executor;
        this.f7352wA = interfaceC3270Z2;
    }

    @Override // p131o.InterfaceC3432bT
    /* renamed from: mjFkc */
    public final void mo7600mjFkc(AbstractC1670B7 abstractC1670B7) {
        synchronized (this.f7350AZxh) {
            try {
                if (this.f7352wA == null) {
                    return;
                }
                this.f7351mjFkc.execute(new RunnableC4476rL(this, abstractC1670B7));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
