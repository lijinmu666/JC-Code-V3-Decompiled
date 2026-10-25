package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.TA */
/* loaded from: classes.dex */
public final class C2877TA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2877TA f10660zbb;

    /* renamed from: zbd */
    private int f10661zbd;

    /* renamed from: zbf */
    private int f10663zbf;

    /* renamed from: zbh */
    private boolean f10665zbh;

    /* renamed from: zbm */
    private int f10670zbm;

    /* renamed from: zbe */
    private String f10662zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f10664zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private String f10666zbi = BuildConfig.f24315FLAVOR;

    /* renamed from: zbj */
    private InterfaceC4118ly f10667zbj = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbk */
    private InterfaceC4118ly f10668zbk = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbl */
    private InterfaceC4118ly f10669zbl = AbstractC3595dy.m11760wJVbdd();

    static {
        C2877TA c2877ta = new C2877TA();
        f10660zbb = c2877ta;
        AbstractC3595dy.m11753YoKzxo(C2877TA.class, c2877ta);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10660zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0003\u0000\u0001ဈ\u0000\u0002င\u0001\u0003\u001a\u0004\u001b\u0006ဈ\u0002\u0007ဇ\u0003\bဈ\u0004\t\u001a\nင\u0005", new Object[]{"zbd", "zbe", "zbf", "zbj", "zbk", C2487NA.class, "zbg", "zbh", "zbi", "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new C2877TA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2809SA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f10660zbb;
    }
}
