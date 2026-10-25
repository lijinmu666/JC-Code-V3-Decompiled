package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.RA */
/* loaded from: classes.dex */
public final class C2743RA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2743RA f10391zbb;

    /* renamed from: zbd */
    private int f10392zbd;

    /* renamed from: zbe */
    private String f10393zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f10394zbf = BuildConfig.f24315FLAVOR;

    static {
        C2743RA c2743ra = new C2743RA();
        f10391zbb = c2743ra;
        AbstractC3595dy.m11753YoKzxo(C2743RA.class, c2743ra);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10391zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2743RA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2678QA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f10391zbb;
    }
}
