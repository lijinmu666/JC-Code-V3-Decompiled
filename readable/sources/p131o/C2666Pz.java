package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Pz */
/* loaded from: classes.dex */
public final class C2666Pz extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2666Pz f10133zbb;

    /* renamed from: zbd */
    private int f10134zbd;

    /* renamed from: zbe */
    private String f10135zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private int f10136zbf = 1;

    /* renamed from: zbg */
    private boolean f10137zbg;

    /* renamed from: zbh */
    private int f10138zbh;

    static {
        C2666Pz c2666Pz = new C2666Pz();
        f10133zbb = c2666Pz;
        AbstractC3595dy.m11753YoKzxo(C2666Pz.class, c2666Pz);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10133zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", C2603Oz.f10022mjFkc, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C2666Pz();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2539Nz(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f10133zbb;
    }
}
