package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Tp */
/* loaded from: classes.dex */
public final class C2916Tp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2916Tp f10745zbb;

    /* renamed from: zbd */
    private int f10746zbd;

    /* renamed from: zbe */
    private String f10747zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f10748zbf = BuildConfig.f24315FLAVOR;

    static {
        C2916Tp c2916Tp = new C2916Tp();
        f10745zbb = c2916Tp;
        AbstractC3595dy.m11753YoKzxo(C2916Tp.class, c2916Tp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10745zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2916Tp();
        }
        AbstractC2786Rp abstractC2786Rp = null;
        if (i2 == 4) {
            return new C2853Sp(abstractC2786Rp);
        }
        if (i2 != 5) {
            return null;
        }
        return f10745zbb;
    }
}
