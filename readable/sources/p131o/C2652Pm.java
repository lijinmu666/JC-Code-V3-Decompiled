package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Pm */
/* loaded from: classes.dex */
public final class C2652Pm extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2652Pm f10095zbb;

    /* renamed from: zbd */
    private int f10096zbd;

    /* renamed from: zbe */
    private String f10097zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f10098zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private int f10099zbg = 1;

    static {
        C2652Pm c2652Pm = new C2652Pm();
        f10095zbb = c2652Pm;
        AbstractC3595dy.m11753YoKzxo(C2652Pm.class, c2652Pm);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10095zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", C2526Nm.f9814mjFkc});
        }
        if (i2 == 3) {
            return new C2652Pm();
        }
        AbstractC2260Jm abstractC2260Jm = null;
        if (i2 == 4) {
            return new C2391Lm(abstractC2260Jm);
        }
        if (i2 != 5) {
            return null;
        }
        return f10095zbb;
    }
}
