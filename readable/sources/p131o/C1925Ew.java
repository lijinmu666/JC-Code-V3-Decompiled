package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Ew */
/* loaded from: classes.dex */
public final class C1925Ew extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1925Ew f8109zbb;

    /* renamed from: zbd */
    private int f8110zbd;

    /* renamed from: zbe */
    private C2271Jv f8111zbe;

    /* renamed from: zbh */
    private int f8114zbh;

    /* renamed from: zbi */
    private int f8115zbi;

    /* renamed from: zbj */
    private byte f8116zbj = 2;

    /* renamed from: zbf */
    private String f8112zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC3988jy f8113zbg = AbstractC3595dy.m11749BAnRFn();

    static {
        C1925Ew c1925Ew = new C1925Ew();
        f8109zbb = c1925Ew;
        AbstractC3595dy.m11753YoKzxo(C1925Ew.class, c1925Ew);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8116zbj);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8109zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ဈ\u0001\u0003\u0016\u0004င\u0002\u0005᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", AbstractC1706Be.m7731mjFkc()});
        }
        if (i2 == 3) {
            return new C1925Ew();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C1855Dw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f8109zbb;
        }
        this.f8116zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
