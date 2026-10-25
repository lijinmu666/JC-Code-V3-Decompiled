package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ZA */
/* loaded from: classes.dex */
public final class C3278ZA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3278ZA f12007zbb;

    /* renamed from: zbd */
    private int f12008zbd;

    /* renamed from: zbe */
    private int f12009zbe;

    /* renamed from: zbf */
    private int f12010zbf;

    /* renamed from: zbg */
    private String f12011zbg = BuildConfig.f24315FLAVOR;

    static {
        C3278ZA c3278za = new C3278ZA();
        f12007zbb = c3278za;
        AbstractC3595dy.m11753YoKzxo(C3278ZA.class, c3278za);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12007zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", C3142XA.f11553mjFkc, "zbg"});
        }
        if (i2 == 3) {
            return new C3278ZA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C3212YA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f12007zbb;
    }
}
