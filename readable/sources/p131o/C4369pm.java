package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.pm */
/* loaded from: classes.dex */
public final class C4369pm extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4369pm f15968zbb;

    /* renamed from: zbd */
    private int f15969zbd;

    /* renamed from: zbe */
    private String f15970zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f15971zbf = BuildConfig.f24315FLAVOR;

    static {
        C4369pm c4369pm = new C4369pm();
        f15968zbb = c4369pm;
        AbstractC3595dy.m11753YoKzxo(C4369pm.class, c4369pm);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15968zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4369pm();
        }
        AbstractC4105lm abstractC4105lm = null;
        if (i2 == 4) {
            return new C4236nm(abstractC4105lm);
        }
        if (i2 != 5) {
            return null;
        }
        return f15968zbb;
    }
}
