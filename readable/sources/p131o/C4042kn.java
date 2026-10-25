package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.kn */
/* loaded from: classes.dex */
public final class C4042kn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4042kn f14605zbb;

    /* renamed from: zbd */
    private int f14606zbd;

    /* renamed from: zbe */
    private boolean f14607zbe;

    /* renamed from: zbf */
    private String f14608zbf = BuildConfig.f24315FLAVOR;

    static {
        C4042kn c4042kn = new C4042kn();
        f14605zbb = c4042kn;
        AbstractC3595dy.m11753YoKzxo(C4042kn.class, c4042kn);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14605zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4042kn();
        }
        AbstractC3452bl abstractC3452bl = null;
        if (i2 == 4) {
            return new C3779gm(abstractC3452bl);
        }
        if (i2 != 5) {
            return null;
        }
        return f14605zbb;
    }
}
