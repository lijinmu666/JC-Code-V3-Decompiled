package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Ki */
/* loaded from: classes.dex */
public final class C2325Ki extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2325Ki f9224zbb;

    /* renamed from: zbd */
    private int f9225zbd;

    /* renamed from: zbe */
    private String f9226zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private AbstractC4981yx f9227zbf = AbstractC4981yx.f17599AZxh;

    static {
        C2325Ki c2325Ki = new C2325Ki();
        f9224zbb = c2325Ki;
        AbstractC3595dy.m11753YoKzxo(C2325Ki.class, c2325Ki);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9224zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2325Ki();
        }
        AbstractC2115Hi abstractC2115Hi = null;
        if (i2 == 4) {
            return new C2254Ji(abstractC2115Hi);
        }
        if (i2 != 5) {
            return null;
        }
        return f9224zbb;
    }
}
