package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Xn */
/* loaded from: classes.dex */
public final class C3184Xn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3184Xn f11676zbb;

    /* renamed from: zbd */
    private int f11677zbd;

    /* renamed from: zbe */
    private int f11678zbe;

    /* renamed from: zbf */
    private String f11679zbf = BuildConfig.f24315FLAVOR;

    static {
        C3184Xn c3184Xn = new C3184Xn();
        f11676zbb = c3184Xn;
        AbstractC3595dy.m11753YoKzxo(C3184Xn.class, c3184Xn);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11676zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", C3050Vn.f11359mjFkc, "zbf"});
        }
        if (i2 == 3) {
            return new C3184Xn();
        }
        AbstractC2783Rn abstractC2783Rn = null;
        if (i2 == 4) {
            return new C2914Tn(abstractC2783Rn);
        }
        if (i2 != 5) {
            return null;
        }
        return f11676zbb;
    }
}
