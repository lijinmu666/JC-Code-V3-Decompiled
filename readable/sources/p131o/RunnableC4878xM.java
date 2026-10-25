package p131o;

/* renamed from: o.xM */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC4878xM implements Runnable {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f17371AZxh;

    /* renamed from: ZfxDd */
    public final AbstractC2097HPA f17372ZfxDd;

    /* renamed from: mjFkc */
    public final C4217nTET f17373mjFkc;

    /* renamed from: wA */
    public final InterfaceC3736g9 f17374wA;

    public RunnableC4878xM(C4217nTET c4217nTET, AbstractC3140X8 abstractC3140X8, InterfaceC3736g9 interfaceC3736g9, AbstractC2097HPA abstractC2097HPA) {
        this.f17373mjFkc = c4217nTET;
        this.f17371AZxh = abstractC3140X8;
        this.f17374wA = interfaceC3736g9;
        this.f17372ZfxDd = abstractC2097HPA;
    }

    /* renamed from: mjFkc */
    public static Runnable m13932mjFkc(C4217nTET c4217nTET, AbstractC3140X8 abstractC3140X8, InterfaceC3736g9 interfaceC3736g9, AbstractC2097HPA abstractC2097HPA) {
        return new RunnableC4878xM(c4217nTET, abstractC3140X8, interfaceC3736g9, abstractC2097HPA);
    }

    @Override // java.lang.Runnable
    public void run() {
        C4217nTET.m12882wA(this.f17373mjFkc, this.f17371AZxh, this.f17374wA, this.f17372ZfxDd);
    }
}
