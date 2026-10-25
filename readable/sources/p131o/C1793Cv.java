package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Cv */
/* loaded from: classes.dex */
public final class C1793Cv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1793Cv f7755zbb;

    /* renamed from: zbd */
    private int f7756zbd;

    /* renamed from: zbe */
    private int f7757zbe;

    /* renamed from: zbf */
    private int f7758zbf;

    /* renamed from: zbg */
    private int f7759zbg;

    /* renamed from: zbh */
    private String f7760zbh = BuildConfig.f24315FLAVOR;

    static {
        C1793Cv c1793Cv = new C1793Cv();
        f7755zbb = c1793Cv;
        AbstractC3595dy.m11753YoKzxo(C1793Cv.class, c1793Cv);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7755zbb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဏ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", C2061Gv.f8448mjFkc, "zbf", C1996Fv.f8274mjFkc, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C1793Cv();
        }
        AbstractC1657Av abstractC1657Av = null;
        if (i2 == 4) {
            return new C1723Bv(abstractC1657Av);
        }
        if (i2 != 5) {
            return null;
        }
        return f7755zbb;
    }
}
