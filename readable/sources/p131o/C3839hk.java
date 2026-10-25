package p131o;

/* renamed from: o.hk */
/* loaded from: classes.dex */
public final class C3839hk extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3839hk f14048zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f14049zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C3839hk c3839hk = new C3839hk();
        f14048zbb = c3839hk;
        AbstractC3595dy.m11753YoKzxo(C3839hk.class, c3839hk);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14048zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", C3644ek.class});
        }
        if (i2 == 3) {
            return new C3839hk();
        }
        AbstractC3710fk abstractC3710fk = null;
        if (i2 == 4) {
            return new C3777gk(abstractC3710fk);
        }
        if (i2 != 5) {
            return null;
        }
        return f14048zbb;
    }
}
