package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ag */
/* loaded from: classes.dex */
public final class C3377ag extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3377ag f12799zbb;

    /* renamed from: zbd */
    private int f12800zbd;

    /* renamed from: zbf */
    private Object f12802zbf;

    /* renamed from: zbe */
    private int f12801zbe = 0;

    /* renamed from: zbg */
    private String f12803zbg = BuildConfig.f24315FLAVOR;

    static {
        C3377ag c3377ag = new C3377ag();
        f12799zbb = c3377ag;
        AbstractC3595dy.m11753YoKzxo(C3377ag.class, c3377ag);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12799zbb, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", C2774Rf.class, C2906Tf.class, C3965jg.class, C3175Xf.class});
        }
        if (i2 == 3) {
            return new C3377ag();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C3310Zf(abstractC2645Pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f12799zbb;
    }
}
