package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.go */
/* loaded from: classes.dex */
public final class C3781go extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3781go f13842zbb;

    /* renamed from: zbd */
    private int f13843zbd;

    /* renamed from: zbe */
    private String f13844zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private int f13845zbf;

    static {
        C3781go c3781go = new C3781go();
        f13842zbb = c3781go;
        AbstractC3595dy.m11753YoKzxo(C3781go.class, c3781go);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13842zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001", new Object[]{"zbd", "zbe", "zbf", C3648eo.f13498mjFkc});
        }
        if (i2 == 3) {
            return new C3781go();
        }
        AbstractC3320Zn abstractC3320Zn = null;
        if (i2 == 4) {
            return new C3455bo(abstractC3320Zn);
        }
        if (i2 != 5) {
            return null;
        }
        return f13842zbb;
    }
}
