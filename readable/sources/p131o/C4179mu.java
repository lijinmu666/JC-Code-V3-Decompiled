package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.mu */
/* loaded from: classes.dex */
public final class C4179mu extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4179mu f15262zbb;

    /* renamed from: zbd */
    private int f15263zbd;

    /* renamed from: zbe */
    private int f15264zbe;

    /* renamed from: zbf */
    private C4706uq f15265zbf;

    /* renamed from: zbg */
    private String f15266zbg = BuildConfig.f24315FLAVOR;

    static {
        C4179mu c4179mu = new C4179mu();
        f15262zbb = c4179mu;
        AbstractC3595dy.m11753YoKzxo(C4179mu.class, c4179mu);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15262zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4179mu();
        }
        AbstractC4050ku abstractC4050ku = null;
        if (i2 == 4) {
            return new C4114lu(abstractC4050ku);
        }
        if (i2 != 5) {
            return null;
        }
        return f15262zbb;
    }
}
