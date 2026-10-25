package p131o;

/* renamed from: o.Wi */
/* loaded from: classes.dex */
public final class C3110Wi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3110Wi f11486zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f11487zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C3110Wi c3110Wi = new C3110Wi();
        f11486zbb = c3110Wi;
        AbstractC3595dy.m11753YoKzxo(C3110Wi.class, c3110Wi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11486zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", C2909Ti.class});
        }
        if (i2 == 3) {
            return new C3110Wi();
        }
        AbstractC2977Ui abstractC2977Ui = null;
        if (i2 == 4) {
            return new C3045Vi(abstractC2977Ui);
        }
        if (i2 != 5) {
            return null;
        }
        return f11486zbb;
    }
}
