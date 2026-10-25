package p131o;

/* renamed from: o.w9 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC4795w9 implements Runnable {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f17165AZxh;

    /* renamed from: ZfxDd */
    public final Runnable f17166ZfxDd;

    /* renamed from: mjFkc */
    public final C1672B9 f17167mjFkc;

    /* renamed from: wA */
    public final int f17168wA;

    public RunnableC4795w9(C1672B9 c1672b9, AbstractC3140X8 abstractC3140X8, int i, Runnable runnable) {
        this.f17167mjFkc = c1672b9;
        this.f17165AZxh = abstractC3140X8;
        this.f17168wA = i;
        this.f17166ZfxDd = runnable;
    }

    /* renamed from: mjFkc */
    public static Runnable m13823mjFkc(C1672B9 c1672b9, AbstractC3140X8 abstractC3140X8, int i, Runnable runnable) {
        return new RunnableC4795w9(c1672b9, abstractC3140X8, i, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        C1672B9.m7673KLFTb(this.f17167mjFkc, this.f17165AZxh, this.f17168wA, this.f17166ZfxDd);
    }
}
