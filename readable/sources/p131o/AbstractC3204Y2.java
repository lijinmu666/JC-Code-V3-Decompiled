package p131o;

import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: o.Y2 */
/* loaded from: classes.dex */
public abstract class AbstractC3204Y2 {

    /* renamed from: AZxh */
    public CopyOnWriteArrayList f11785AZxh = new CopyOnWriteArrayList();

    /* renamed from: mjFkc */
    public boolean f11786mjFkc;

    /* renamed from: wA */
    public InterfaceC2317KbE f11787wA;

    public AbstractC3204Y2(boolean z) {
        this.f11786mjFkc = z;
    }

    /* renamed from: AZxh */
    public final void m11043AZxh(boolean z) {
        this.f11786mjFkc = z;
        InterfaceC2317KbE interfaceC2317KbE = this.f11787wA;
        if (interfaceC2317KbE != null) {
            interfaceC2317KbE.mo9246mjFkc(Boolean.valueOf(z));
        }
    }

    /* renamed from: mjFkc */
    public void m11044mjFkc(InterfaceC3041VfB interfaceC3041VfB) {
        this.f11785AZxh.remove(interfaceC3041VfB);
    }
}
