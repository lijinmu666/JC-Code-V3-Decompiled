package p131o;

import p094kotlin.p105jvm.internal.Intrinsics;

/* renamed from: o.E3 */
/* loaded from: classes.dex */
public class C1864E3 extends C1733C3 {

    /* renamed from: wA */
    public final Object f7928wA;

    public C1864E3(int i) {
        super(i);
        this.f7928wA = new Object();
    }

    @Override // p131o.C1733C3, p131o.InterfaceC1601A3
    /* renamed from: AZxh */
    public Object mo7550AZxh() {
        Object objMo7550AZxh;
        synchronized (this.f7928wA) {
            objMo7550AZxh = super.mo7550AZxh();
        }
        return objMo7550AZxh;
    }

    @Override // p131o.C1733C3, p131o.InterfaceC1601A3
    /* renamed from: mjFkc */
    public boolean mo7551mjFkc(Object instance) {
        boolean zMo7551mjFkc;
        Intrinsics.checkNotNullParameter(instance, "instance");
        synchronized (this.f7928wA) {
            zMo7551mjFkc = super.mo7551mjFkc(instance);
        }
        return zMo7551mjFkc;
    }
}
