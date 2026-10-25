package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Wx */
/* loaded from: classes.dex */
public final class C3127Wx extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3127Wx f11507zbb;

    /* renamed from: zbd */
    private int f11508zbd;

    /* renamed from: zbe */
    private C2386Li f11509zbe;

    /* renamed from: zbg */
    private int f11511zbg;

    /* renamed from: zbf */
    private String f11510zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private int f11512zbh = 93;

    static {
        C3127Wx c3127Wx = new C3127Wx();
        f11507zbb = c3127Wx;
        AbstractC3595dy.m11753YoKzxo(C3127Wx.class, c3127Wx);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11507zbb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3127Wx();
        }
        AbstractC2861Sw abstractC2861Sw = null;
        if (i2 == 4) {
            return new C4714ux(abstractC2861Sw);
        }
        if (i2 != 5) {
            return null;
        }
        return f11507zbb;
    }
}
