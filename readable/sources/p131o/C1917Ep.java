package p131o;

/* renamed from: o.Ep */
/* loaded from: classes.dex */
public final class C1917Ep extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1917Ep f8057zbb;

    /* renamed from: zbd */
    private int f8058zbd;

    /* renamed from: zbe */
    private float f8059zbe = 0.3f;

    static {
        C1917Ep c1917Ep = new C1917Ep();
        f8057zbb = c1917Ep;
        AbstractC3595dy.m11753YoKzxo(C1917Ep.class, c1917Ep);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8057zbb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C1917Ep();
        }
        AbstractC5036zp abstractC5036zp = null;
        if (i2 == 4) {
            return new C1717Bp(abstractC5036zp);
        }
        if (i2 != 5) {
            return null;
        }
        return f8057zbb;
    }
}
