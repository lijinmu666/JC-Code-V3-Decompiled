package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Ri */
/* loaded from: classes.dex */
public final class C2777Ri extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2777Ri f10448zbb;

    /* renamed from: zbd */
    private int f10449zbd;

    /* renamed from: zbe */
    private String f10450zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f10451zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f10452zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private int f10453zbh;

    static {
        C2777Ri c2777Ri = new C2777Ri();
        f10448zbb = c2777Ri;
        AbstractC3595dy.m11753YoKzxo(C2777Ri.class, c2777Ri);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10448zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", C4298oi.f15813mjFkc});
        }
        if (i2 == 3) {
            return new C2777Ri();
        }
        AbstractC3966jh abstractC3966jh = null;
        if (i2 == 4) {
            return new C2452Mh(abstractC3966jh);
        }
        if (i2 != 5) {
            return null;
        }
        return f10448zbb;
    }
}
