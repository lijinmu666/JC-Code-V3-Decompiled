package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Zi */
/* loaded from: classes.dex */
public final class C3314Zi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3314Zi f12199zbb;

    /* renamed from: zbd */
    private String f12200zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private String f12201zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private double f12202zbf;

    static {
        C3314Zi c3314Zi = new C3314Zi();
        f12199zbb = c3314Zi;
        AbstractC3595dy.m11753YoKzxo(C3314Zi.class, c3314Zi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12199zbb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0000\u0003Ȉ", new Object[]{"zbd", "zbf", "zbe"});
        }
        if (i2 == 3) {
            return new C3314Zi();
        }
        AbstractC3179Xi abstractC3179Xi = null;
        if (i2 == 4) {
            return new C3246Yi(abstractC3179Xi);
        }
        if (i2 != 5) {
            return null;
        }
        return f12199zbb;
    }
}
