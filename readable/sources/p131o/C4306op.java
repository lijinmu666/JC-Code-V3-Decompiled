package p131o;

/* renamed from: o.op */
/* loaded from: classes.dex */
public final class C4306op extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4306op f15847zbb;

    /* renamed from: zbd */
    private int f15848zbd;

    /* renamed from: zbe */
    private boolean f15849zbe;

    /* renamed from: zbf */
    private float f15850zbf = 0.2f;

    /* renamed from: zbg */
    private InterfaceC4118ly f15851zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C4306op c4306op = new C4306op();
        f15847zbb = c4306op;
        AbstractC3595dy.m11753YoKzxo(C4306op.class, c4306op);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15847zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0004\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", C4705up.class});
        }
        if (i2 == 3) {
            return new C4306op();
        }
        AbstractC3975jp abstractC3975jp = null;
        if (i2 == 4) {
            return new C4108lp(abstractC3975jp);
        }
        if (i2 != 5) {
            return null;
        }
        return f15847zbb;
    }
}
