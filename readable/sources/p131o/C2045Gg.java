package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Gg */
/* loaded from: classes.dex */
public final class C2045Gg extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2045Gg f8412zbb;

    /* renamed from: zbd */
    private int f8413zbd;

    /* renamed from: zbe */
    private C2979Uk f8414zbe;

    /* renamed from: zbf */
    private C3530cx f8415zbf;

    /* renamed from: zbg */
    private String f8416zbg = BuildConfig.f24315FLAVOR;

    static {
        C2045Gg c2045Gg = new C2045Gg();
        f8412zbb = c2045Gg;
        AbstractC3595dy.m11753YoKzxo(C2045Gg.class, c2045Gg);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8412zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0002\u0003ဉ\u0001", new Object[]{"zbd", "zbe", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new C2045Gg();
        }
        AbstractC1707Bf abstractC1707Bf = null;
        if (i2 == 4) {
            return new C3576dg(abstractC1707Bf);
        }
        if (i2 != 5) {
            return null;
        }
        return f8412zbb;
    }
}
