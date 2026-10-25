package p131o;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: o.Ry */
/* loaded from: classes.dex */
public final class C2796Ry {

    /* renamed from: wA */
    public static final C2796Ry f10501wA = new C2796Ry();

    /* renamed from: AZxh */
    public final ConcurrentMap f10502AZxh = new ConcurrentHashMap();

    /* renamed from: mjFkc */
    public final InterfaceC3064Vy f10503mjFkc = new C1727By();

    /* renamed from: mjFkc */
    public static C2796Ry m10116mjFkc() {
        return f10501wA;
    }

    /* renamed from: AZxh */
    public final InterfaceC2998Uy m10117AZxh(Class cls) {
        AbstractC4183my.m12818wA(cls, "messageType");
        InterfaceC2998Uy interfaceC2998UyMo7743mjFkc = (InterfaceC2998Uy) this.f10502AZxh.get(cls);
        if (interfaceC2998UyMo7743mjFkc == null) {
            interfaceC2998UyMo7743mjFkc = this.f10503mjFkc.mo7743mjFkc(cls);
            AbstractC4183my.m12818wA(cls, "messageType");
            InterfaceC2998Uy interfaceC2998Uy = (InterfaceC2998Uy) this.f10502AZxh.putIfAbsent(cls, interfaceC2998UyMo7743mjFkc);
            if (interfaceC2998Uy != null) {
                return interfaceC2998Uy;
            }
        }
        return interfaceC2998UyMo7743mjFkc;
    }
}
