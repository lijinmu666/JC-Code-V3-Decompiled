package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.fj */
/* loaded from: classes.dex */
public final class C3709fj extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3709fj f13618zbb;

    /* renamed from: zbd */
    private String f13619zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private InterfaceC4118ly f13620zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private String f13621zbf = BuildConfig.f24315FLAVOR;

    static {
        C3709fj c3709fj = new C3709fj();
        f13618zbb = c3709fj;
        AbstractC3595dy.m11753YoKzxo(C3709fj.class, c3709fj);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13618zbb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003Ȉ", new Object[]{"zbd", "zbe", C3516cj.class, "zbf"});
        }
        if (i2 == 3) {
            return new C3709fj();
        }
        AbstractC3580dj abstractC3580dj = null;
        if (i2 == 4) {
            return new C3643ej(abstractC3580dj);
        }
        if (i2 != 5) {
            return null;
        }
        return f13618zbb;
    }
}
