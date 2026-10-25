package p131o;

/* renamed from: o.Sv */
/* loaded from: classes.dex */
public final class C2860Sv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2860Sv f10613zbb;

    /* renamed from: zbd */
    private int f10614zbd;

    /* renamed from: zbe */
    private double f10615zbe;

    /* renamed from: zbf */
    private double f10616zbf;

    static {
        C2860Sv c2860Sv = new C2860Sv();
        f10613zbb = c2860Sv;
        AbstractC3595dy.m11753YoKzxo(C2860Sv.class, c2860Sv);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10613zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2860Sv();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C2793Rv(abstractC2129Hv);
        }
        if (i2 != 5) {
            return null;
        }
        return f10613zbb;
    }
}
