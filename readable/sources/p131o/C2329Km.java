package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Km */
/* loaded from: classes.dex */
public final class C2329Km extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2329Km f9228zbb;

    /* renamed from: zbd */
    private int f9229zbd;

    /* renamed from: zbf */
    private Object f9231zbf;

    /* renamed from: zbe */
    private int f9230zbe = 0;

    /* renamed from: zbg */
    private String f9232zbg = BuildConfig.f24315FLAVOR;

    static {
        C2329Km c2329Km = new C2329Km();
        f9228zbb = c2329Km;
        AbstractC3595dy.m11753YoKzxo(C2329Km.class, c2329Km);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9228zbb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u00025\u0000\u0003<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", C2185Im.class});
        }
        if (i2 == 3) {
            return new C2329Km();
        }
        AbstractC4837wm abstractC4837wm = null;
        if (i2 == 4) {
            return new C1647Am(abstractC4837wm);
        }
        if (i2 != 5) {
            return null;
        }
        return f9228zbb;
    }
}
