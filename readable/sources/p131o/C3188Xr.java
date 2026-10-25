package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Xr */
/* loaded from: classes.dex */
public final class C3188Xr extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3188Xr f11680zbb;

    /* renamed from: zbd */
    private int f11681zbd;

    /* renamed from: zbe */
    private InterfaceC4118ly f11682zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private String f11683zbf = BuildConfig.f24315FLAVOR;

    static {
        C3188Xr c3188Xr = new C3188Xr();
        f11680zbb = c3188Xr;
        AbstractC3595dy.m11753YoKzxo(C3188Xr.class, c3188Xr);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11680zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zbd", "zbe", C2991Ur.class, "zbf"});
        }
        if (i2 == 3) {
            return new C3188Xr();
        }
        AbstractC3057Vr abstractC3057Vr = null;
        if (i2 == 4) {
            return new C3120Wr(abstractC3057Vr);
        }
        if (i2 != 5) {
            return null;
        }
        return f11680zbb;
    }
}
