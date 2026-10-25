package p131o;

/* renamed from: o.Te */
/* loaded from: classes.dex */
public final class C2905Te extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2905Te f10715zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f10716zbd = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbe */
    private InterfaceC4118ly f10717zbe = AbstractC3595dy.m11760wJVbdd();

    static {
        C2905Te c2905Te = new C2905Te();
        f10715zbb = c2905Te;
        AbstractC3595dy.m11753YoKzxo(C2905Te.class, c2905Te);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10715zbb, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zbd", C2707Qe.class, "zbe", C2322Kf.class});
        }
        if (i2 == 3) {
            return new C2905Te();
        }
        AbstractC2773Re abstractC2773Re = null;
        if (i2 == 4) {
            return new C2840Se(abstractC2773Re);
        }
        if (i2 != 5) {
            return null;
        }
        return f10715zbb;
    }
}
