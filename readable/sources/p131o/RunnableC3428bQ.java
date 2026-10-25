package p131o;

/* renamed from: o.bQ */
/* loaded from: classes.dex */
public final class RunnableC3428bQ implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ C3887iR f13096AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ AbstractC1670B7 f13097mjFkc;

    public RunnableC3428bQ(C3887iR c3887iR, AbstractC1670B7 abstractC1670B7) {
        this.f13096AZxh = c3887iR;
        this.f13097mjFkc = abstractC1670B7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13096AZxh.f14150AZxh) {
            try {
                C3887iR c3887iR = this.f13096AZxh;
                if (c3887iR.f14152wA != null) {
                    c3887iR.f14152wA.mo4876mjFkc(this.f13097mjFkc.mo7664JHa());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
