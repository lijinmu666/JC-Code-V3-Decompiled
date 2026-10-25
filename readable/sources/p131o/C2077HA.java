package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.HA */
/* loaded from: classes.dex */
public final class C2077HA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2077HA f8546zbb;

    /* renamed from: zbd */
    private int f8547zbd;

    /* renamed from: zbe */
    private String f8548zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private long f8549zbf;

    /* renamed from: zbg */
    private long f8550zbg;

    /* renamed from: zbh */
    private long f8551zbh;

    static {
        C2077HA c2077ha = new C2077HA();
        f8546zbb = c2077ha;
        AbstractC3595dy.m11753YoKzxo(C2077HA.class, c2077ha);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8546zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C2077HA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C1871EA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f8546zbb;
    }
}
