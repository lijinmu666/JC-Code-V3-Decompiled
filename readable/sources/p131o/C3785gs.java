package p131o;

/* renamed from: o.gs */
/* loaded from: classes.dex */
public final class C3785gs extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3785gs f13847zbb;

    /* renamed from: zbe */
    private byte f13849zbe = 2;

    /* renamed from: zbd */
    private InterfaceC4118ly f13848zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C3785gs c3785gs = new C3785gs();
        f13847zbb = c3785gs;
        AbstractC3595dy.m11753YoKzxo(C3785gs.class, c3785gs);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13849zbe);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13847zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", C3589ds.class});
        }
        if (i2 == 3) {
            return new C3785gs();
        }
        AbstractC3652es abstractC3652es = null;
        if (i2 == 4) {
            return new C3718fs(abstractC3652es);
        }
        if (i2 == 5) {
            return f13847zbb;
        }
        this.f13849zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
