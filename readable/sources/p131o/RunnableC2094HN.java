package p131o;

/* renamed from: o.HN */
/* loaded from: classes.dex */
public final class RunnableC2094HN implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ C2692QO f8590AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ AbstractC1670B7 f8591mjFkc;

    public RunnableC2094HN(C2692QO c2692qo, AbstractC1670B7 abstractC1670B7) {
        this.f8590AZxh = c2692qo;
        this.f8591mjFkc = abstractC1670B7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8590AZxh.f10175AZxh) {
            try {
                C2692QO c2692qo = this.f8590AZxh;
                if (c2692qo.f10177wA != null) {
                    c2692qo.f10177wA.mo4877mjFkc((Exception) AbstractC2138I3.m8648xJ(this.f8591mjFkc.mo7665KLFTb()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
