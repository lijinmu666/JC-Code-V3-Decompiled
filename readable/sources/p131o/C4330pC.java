package p131o;

import java.util.HashMap;
import java.util.Map;

/* renamed from: o.pC */
/* loaded from: classes.dex */
public final class C4330pC implements InterfaceC3987jxC {

    /* renamed from: ZfxDd */
    public static final InterfaceC2735R2 f15914ZfxDd = new InterfaceC2735R2() { // from class: o.mC
        @Override // p131o.InterfaceC4156mYYU
        /* renamed from: mjFkc */
        public final void mo7597mjFkc(Object obj, Object obj2) {
            InterfaceC2735R2 interfaceC2735R2 = C4330pC.f15914ZfxDd;
            throw new C2570ORe("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    };

    /* renamed from: mjFkc */
    public final Map f15916mjFkc = new HashMap();

    /* renamed from: AZxh */
    public final Map f15915AZxh = new HashMap();

    /* renamed from: wA */
    public final InterfaceC2735R2 f15917wA = f15914ZfxDd;

    /* renamed from: AZxh */
    public final C4532sC m13070AZxh() {
        return new C4532sC(new HashMap(this.f15916mjFkc), new HashMap(this.f15915AZxh), this.f15917wA);
    }

    @Override // p131o.InterfaceC3987jxC
    /* renamed from: mjFkc */
    public final /* bridge */ /* synthetic */ InterfaceC3987jxC mo9183mjFkc(Class cls, InterfaceC2735R2 interfaceC2735R2) {
        this.f15916mjFkc.put(cls, interfaceC2735R2);
        this.f15915AZxh.remove(cls);
        return this;
    }
}
