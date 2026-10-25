package p131o;

import java.util.Collections;
import java.util.Map;

/* renamed from: o.Kx */
/* loaded from: classes.dex */
public final class C2340Kx {

    /* renamed from: AZxh */
    public static volatile C2340Kx f9288AZxh;

    /* renamed from: wA */
    public static final C2340Kx f9289wA = new C2340Kx(true);

    /* renamed from: mjFkc */
    public final Map f9290mjFkc = Collections.emptyMap();

    public C2340Kx(boolean z) {
    }

    /* renamed from: AZxh */
    public static C2340Kx m9290AZxh() {
        C2340Kx c2340Kx = f9288AZxh;
        if (c2340Kx != null) {
            return c2340Kx;
        }
        synchronized (C2340Kx.class) {
            try {
                C2340Kx c2340Kx2 = f9288AZxh;
                if (c2340Kx2 != null) {
                    return c2340Kx2;
                }
                C2796Ry c2796Ry = C2796Ry.f10501wA;
                C2340Kx c2340KxM10447mjFkc = AbstractC2925Tx.m10447mjFkc(C2340Kx.class);
                f9288AZxh = c2340KxM10447mjFkc;
                return c2340KxM10447mjFkc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static C2340Kx m9291mjFkc() {
        C2796Ry c2796Ry = C2796Ry.f10501wA;
        return f9289wA;
    }

    /* renamed from: wA */
    public final C3531cy m9292wA(InterfaceC2341Ky interfaceC2341Ky, int i) {
        return (C3531cy) this.f9290mjFkc.get(new C2273Jx(interfaceC2341Ky, i));
    }
}
