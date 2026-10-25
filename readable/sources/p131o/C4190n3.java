package p131o;

/* renamed from: o.n3 */
/* loaded from: classes.dex */
public class C4190n3 implements InterfaceC3339a4 {

    /* renamed from: AZxh */
    public volatile InterfaceC3339a4 f15304AZxh;

    /* renamed from: mjFkc */
    public InterfaceC2848SllyO f15305mjFkc;

    /* renamed from: wA */
    public static final InterfaceC2848SllyO f15303wA = C4060l3.m12654AZxh();

    /* renamed from: ZfxDd */
    public static final InterfaceC3339a4 f15302ZfxDd = C4124m3.m12739mjFkc();

    public C4190n3(InterfaceC2848SllyO interfaceC2848SllyO, InterfaceC3339a4 interfaceC3339a4) {
        this.f15305mjFkc = interfaceC2848SllyO;
        this.f15304AZxh = interfaceC3339a4;
    }

    /* renamed from: AZxh */
    public static /* synthetic */ void m12845AZxh(InterfaceC3339a4 interfaceC3339a4) {
    }

    /* renamed from: mjFkc */
    public static C4190n3 m12846mjFkc() {
        return new C4190n3(f15303wA, f15302ZfxDd);
    }

    /* renamed from: wA */
    public static /* synthetic */ Object m12847wA() {
        return null;
    }

    /* renamed from: ZfxDd */
    public void m12848ZfxDd(InterfaceC3339a4 interfaceC3339a4) {
        InterfaceC2848SllyO interfaceC2848SllyO;
        if (this.f15304AZxh != f15302ZfxDd) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC2848SllyO = this.f15305mjFkc;
            this.f15305mjFkc = null;
            this.f15304AZxh = interfaceC3339a4;
        }
        interfaceC2848SllyO.mo10161mjFkc(interfaceC3339a4);
    }

    @Override // p131o.InterfaceC3339a4
    /* renamed from: get */
    public Object mo8427get() {
        return this.f15304AZxh.mo8427get();
    }
}
