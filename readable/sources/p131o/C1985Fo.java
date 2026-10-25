package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Fo */
/* loaded from: classes.dex */
public final class C1985Fo extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1985Fo f8250zbb;

    /* renamed from: zbd */
    private int f8251zbd;

    /* renamed from: zbe */
    private String f8252zbe = BuildConfig.f24315FLAVOR;

    static {
        C1985Fo c1985Fo = new C1985Fo();
        f8250zbb = c1985Fo;
        AbstractC3595dy.m11753YoKzxo(C1985Fo.class, c1985Fo);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8250zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C1985Fo();
        }
        AbstractC4972yo abstractC4972yo = null;
        if (i2 == 4) {
            return new C1847Do(abstractC4972yo);
        }
        if (i2 != 5) {
            return null;
        }
        return f8250zbb;
    }
}
