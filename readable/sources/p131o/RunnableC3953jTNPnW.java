package p131o;

/* renamed from: o.jTNPnW */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC3953jTNPnW implements Runnable {

    /* renamed from: AZxh */
    public final InterfaceC3339a4 f14314AZxh;

    /* renamed from: mjFkc */
    public final C4190n3 f14315mjFkc;

    public RunnableC3953jTNPnW(C4190n3 c4190n3, InterfaceC3339a4 interfaceC3339a4) {
        this.f14315mjFkc = c4190n3;
        this.f14314AZxh = interfaceC3339a4;
    }

    /* renamed from: mjFkc */
    public static Runnable m12434mjFkc(C4190n3 c4190n3, InterfaceC3339a4 interfaceC3339a4) {
        return new RunnableC3953jTNPnW(c4190n3, interfaceC3339a4);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14315mjFkc.m12848ZfxDd(this.f14314AZxh);
    }
}
