package p131o;

/* renamed from: o.Nh */
/* loaded from: classes.dex */
public final class C2521Nh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2521Nh f9809zbb;

    /* renamed from: zbd */
    private int f9810zbd;

    /* renamed from: zbe */
    private InterfaceC3988jy f9811zbe = AbstractC3595dy.m11749BAnRFn();

    static {
        C2521Nh c2521Nh = new C2521Nh();
        f9809zbb = c2521Nh;
        AbstractC3595dy.m11753YoKzxo(C2521Nh.class, c2521Nh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9809zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002'", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C2521Nh();
        }
        AbstractC2180Ih abstractC2180Ih = null;
        if (i2 == 4) {
            return new C2324Kh(abstractC2180Ih);
        }
        if (i2 != 5) {
            return null;
        }
        return f9809zbb;
    }
}
