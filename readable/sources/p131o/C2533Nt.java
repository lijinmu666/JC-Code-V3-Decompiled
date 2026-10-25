package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Nt */
/* loaded from: classes.dex */
public final class C2533Nt extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2533Nt f9824zbb;

    /* renamed from: zbd */
    private int f9825zbd;

    /* renamed from: zbe */
    private String f9826zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private C2336Kt f9827zbf;

    static {
        C2533Nt c2533Nt = new C2533Nt();
        f9824zbb = c2533Nt;
        AbstractC3595dy.m11753YoKzxo(C2533Nt.class, c2533Nt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9824zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2533Nt();
        }
        AbstractC2193It abstractC2193It = null;
        if (i2 == 4) {
            return new C2469Mt(abstractC2193It);
        }
        if (i2 != 5) {
            return null;
        }
        return f9824zbb;
    }
}
