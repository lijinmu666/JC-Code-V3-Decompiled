package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Nw */
/* loaded from: classes.dex */
public final class C2536Nw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2536Nw f9829zbb;

    /* renamed from: zbd */
    private int f9830zbd;

    /* renamed from: zbe */
    private String f9831zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private double f9832zbf = 1.0d;

    /* renamed from: zbg */
    private InterfaceC4118ly f9833zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C2536Nw c2536Nw = new C2536Nw();
        f9829zbb = c2536Nw;
        AbstractC3595dy.m11753YoKzxo(C2536Nw.class, c2536Nw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9829zbb, "\u0001\u0003\u0000\u0001\u0001\u000f\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002က\u0001\u000f\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C2536Nw();
        }
        AbstractC2402Lw abstractC2402Lw = null;
        if (i2 == 4) {
            return new C2472Mw(abstractC2402Lw);
        }
        if (i2 != 5) {
            return null;
        }
        return f9829zbb;
    }
}
