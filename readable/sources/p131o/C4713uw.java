package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.uw */
/* loaded from: classes.dex */
public final class C4713uw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4713uw f16929zbb;

    /* renamed from: zbd */
    private int f16930zbd;

    /* renamed from: zbf */
    private float f16932zbf;

    /* renamed from: zbe */
    private String f16931zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f16933zbg = BuildConfig.f24315FLAVOR;

    static {
        C4713uw c4713uw = new C4713uw();
        f16929zbb = c4713uw;
        AbstractC3595dy.m11753YoKzxo(C4713uw.class, c4713uw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16929zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4713uw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C4648tw(abstractC2129Hv);
        }
        if (i2 != 5) {
            return null;
        }
        return f16929zbb;
    }
}
