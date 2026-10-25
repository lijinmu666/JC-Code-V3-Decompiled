package p131o;

/* renamed from: o.EeoThB */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1904EeoThB implements Runnable {

    /* renamed from: AZxh */
    public final InterfaceC3339a4 f8023AZxh;

    /* renamed from: mjFkc */
    public final C2668Q0 f8024mjFkc;

    public RunnableC1904EeoThB(C2668Q0 c2668q0, InterfaceC3339a4 interfaceC3339a4) {
        this.f8024mjFkc = c2668q0;
        this.f8023AZxh = interfaceC3339a4;
    }

    /* renamed from: mjFkc */
    public static Runnable m8167mjFkc(C2668Q0 c2668q0, InterfaceC3339a4 interfaceC3339a4) {
        return new RunnableC1904EeoThB(c2668q0, interfaceC3339a4);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8024mjFkc.m9993mjFkc(this.f8023AZxh);
    }
}
