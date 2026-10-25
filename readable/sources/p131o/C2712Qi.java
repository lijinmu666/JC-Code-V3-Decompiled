package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Qi */
/* loaded from: classes.dex */
public final class C2712Qi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2712Qi f10205zbb;

    /* renamed from: zbd */
    private int f10206zbd;

    /* renamed from: zbe */
    private String f10207zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private int f10208zbf;

    static {
        C2712Qi c2712Qi = new C2712Qi();
        f10205zbb = c2712Qi;
        AbstractC3595dy.m11753YoKzxo(C2712Qi.class, c2712Qi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10205zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2712Qi();
        }
        AbstractC2385Lh abstractC2385Lh = null;
        if (i2 == 4) {
            return new C4231ni(abstractC2385Lh);
        }
        if (i2 != 5) {
            return null;
        }
        return f10205zbb;
    }
}
