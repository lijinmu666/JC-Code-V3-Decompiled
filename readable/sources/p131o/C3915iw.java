package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.iw */
/* loaded from: classes.dex */
public final class C3915iw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3915iw f14227zbb;

    /* renamed from: zbd */
    private int f14228zbd;

    /* renamed from: zbe */
    private int f14229zbe;

    /* renamed from: zbf */
    private String f14230zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC3988jy f14231zbg = AbstractC3595dy.m11749BAnRFn();

    static {
        C3915iw c3915iw = new C3915iw();
        f14227zbb = c3915iw;
        AbstractC3595dy.m11753YoKzxo(C3915iw.class, c3915iw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14227zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0001\u0002င\u0000\u0003ࠞ", new Object[]{"zbd", "zbf", "zbe", "zbg", C3984jw.f14396mjFkc});
        }
        if (i2 == 3) {
            return new C3915iw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C3853hw(abstractC2129Hv);
        }
        if (i2 != 5) {
            return null;
        }
        return f14227zbb;
    }
}
