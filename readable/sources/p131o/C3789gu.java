package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.gu */
/* loaded from: classes.dex */
public final class C3789gu extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3789gu f13867zbb;

    /* renamed from: zbd */
    private int f13868zbd;

    /* renamed from: zbf */
    private float f13870zbf;

    /* renamed from: zbe */
    private String f13869zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC4118ly f13871zbg = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbh */
    private InterfaceC4118ly f13872zbh = AbstractC3595dy.m11760wJVbdd();

    static {
        C3789gu c3789gu = new C3789gu();
        f13867zbb = c3789gu;
        AbstractC3595dy.m11753YoKzxo(C3789gu.class, c3789gu);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13867zbb, "\u0004\u0005\u0000\u0000\u0001\u007f\u0005\u0000\u0002\u0000\u0001\f\u0002Ȉ\u0003\u0001\u0004Ț\u007fȚ", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3789gu();
        }
        AbstractC3257Ys abstractC3257Ys = null;
        if (i2 == 4) {
            return new C1791Ct(abstractC3257Ys);
        }
        if (i2 != 5) {
            return null;
        }
        return f13867zbb;
    }
}
