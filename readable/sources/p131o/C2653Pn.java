package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Pn */
/* loaded from: classes.dex */
public final class C2653Pn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2653Pn f10100zbb;

    /* renamed from: zbd */
    private int f10101zbd;

    /* renamed from: zbe */
    private int f10102zbe;

    /* renamed from: zbf */
    private String f10103zbf = BuildConfig.f24315FLAVOR;

    static {
        C2653Pn c2653Pn = new C2653Pn();
        f10100zbb = c2653Pn;
        AbstractC3595dy.m11753YoKzxo(C2653Pn.class, c2653Pn);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10100zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", C2527Nn.f9815mjFkc, "zbf"});
        }
        if (i2 == 3) {
            return new C2653Pn();
        }
        AbstractC2261Jn abstractC2261Jn = null;
        if (i2 == 4) {
            return new C2392Ln(abstractC2261Jn);
        }
        if (i2 != 5) {
            return null;
        }
        return f10100zbb;
    }
}
