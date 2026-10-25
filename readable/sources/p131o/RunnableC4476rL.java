package p131o;

/* renamed from: o.rL */
/* loaded from: classes.dex */
public final class RunnableC4476rL implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ C1620AM f16334AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ AbstractC1670B7 f16335mjFkc;

    public RunnableC4476rL(C1620AM c1620am, AbstractC1670B7 abstractC1670B7) {
        this.f16334AZxh = c1620am;
        this.f16335mjFkc = abstractC1670B7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f16334AZxh.f7350AZxh) {
            try {
                C1620AM c1620am = this.f16334AZxh;
                if (c1620am.f7352wA != null) {
                    c1620am.f7352wA.mo10155mjFkc(this.f16335mjFkc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
