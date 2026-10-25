package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.NA */
/* loaded from: classes.dex */
public final class C2487NA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2487NA f9707zbb;

    /* renamed from: zbd */
    private int f9708zbd;

    /* renamed from: zbg */
    private int f9711zbg;

    /* renamed from: zbe */
    private String f9709zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f9710zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private String f9712zbh = BuildConfig.f24315FLAVOR;

    static {
        C2487NA c2487na = new C2487NA();
        f9707zbb = c2487na;
        AbstractC3595dy.m11753YoKzxo(C2487NA.class, c2487na);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9707zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C2487NA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2418MA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f9707zbb;
    }
}
