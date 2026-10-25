package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Kp */
/* loaded from: classes.dex */
public final class C2332Kp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2332Kp f9233zbb;

    /* renamed from: zbd */
    private int f9234zbd;

    /* renamed from: zbe */
    private boolean f9235zbe;

    /* renamed from: zbf */
    private String f9236zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f9237zbg = BuildConfig.f24315FLAVOR;

    static {
        C2332Kp c2332Kp = new C2332Kp();
        f9233zbb = c2332Kp;
        AbstractC3595dy.m11753YoKzxo(C2332Kp.class, c2332Kp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9233zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C2332Kp();
        }
        AbstractC2188Ip abstractC2188Ip = null;
        if (i2 == 4) {
            return new C2263Jp(abstractC2188Ip);
        }
        if (i2 != 5) {
            return null;
        }
        return f9233zbb;
    }
}
