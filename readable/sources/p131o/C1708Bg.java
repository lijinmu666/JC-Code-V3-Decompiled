package p131o;

/* renamed from: o.Bg */
/* loaded from: classes.dex */
public final class C1708Bg extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1708Bg f7503zbb;

    /* renamed from: zbd */
    private int f7504zbd;

    /* renamed from: zbe */
    private float f7505zbe = 0.01f;

    static {
        C1708Bg c1708Bg = new C1708Bg();
        f7503zbb = c1708Bg;
        AbstractC3595dy.m11753YoKzxo(C1708Bg.class, c1708Bg);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7503zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C1708Bg();
        }
        AbstractC5027zg abstractC5027zg = null;
        if (i2 == 4) {
            return new C1641Ag(abstractC5027zg);
        }
        if (i2 != 5) {
            return null;
        }
        return f7503zbb;
    }
}
