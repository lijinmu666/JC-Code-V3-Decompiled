package p131o;

import java.util.HashMap;
import java.util.Map;

/* renamed from: o.KF */
/* loaded from: classes.dex */
public final class C2292KF implements InterfaceC3987jxC {

    /* renamed from: ZfxDd */
    public static final InterfaceC2735R2 f9140ZfxDd = new InterfaceC2735R2() { // from class: o.IF
        @Override // p131o.InterfaceC4156mYYU
        /* renamed from: mjFkc */
        public final void mo7597mjFkc(Object obj, Object obj2) {
            InterfaceC2735R2 interfaceC2735R2 = C2292KF.f9140ZfxDd;
            throw new C2570ORe("Couldn't find encoder for type ".concat(String.valueOf(obj.getClass().getCanonicalName())));
        }
    };

    /* renamed from: mjFkc */
    public final Map f9142mjFkc = new HashMap();

    /* renamed from: AZxh */
    public final Map f9141AZxh = new HashMap();

    /* renamed from: wA */
    public final InterfaceC2735R2 f9143wA = f9140ZfxDd;

    /* renamed from: AZxh */
    public final C2423MF m9182AZxh() {
        return new C2423MF(new HashMap(this.f9142mjFkc), new HashMap(this.f9141AZxh), this.f9143wA);
    }

    @Override // p131o.InterfaceC3987jxC
    /* renamed from: mjFkc */
    public final /* bridge */ /* synthetic */ InterfaceC3987jxC mo9183mjFkc(Class cls, InterfaceC2735R2 interfaceC2735R2) {
        this.f9142mjFkc.put(cls, interfaceC2735R2);
        this.f9141AZxh.remove(cls);
        return this;
    }
}
