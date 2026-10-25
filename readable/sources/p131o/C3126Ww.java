package p131o;

/* renamed from: o.Ww */
/* loaded from: classes.dex */
public final class C3126Ww extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3126Ww f11504zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f11505zbd = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbe */
    private InterfaceC4118ly f11506zbe = AbstractC3595dy.m11760wJVbdd();

    static {
        C3126Ww c3126Ww = new C3126Ww();
        f11504zbb = c3126Ww;
        AbstractC3595dy.m11753YoKzxo(C3126Ww.class, c3126Ww);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11504zbb, "\u0001\u0002\u0000\u0000\u0001\u000f\u0002\u0000\u0002\u0000\u0001\u001b\u000f\u001a", new Object[]{"zbd", C2663Pw.class, "zbe"});
        }
        if (i2 == 3) {
            return new C3126Ww();
        }
        AbstractC2402Lw abstractC2402Lw = null;
        if (i2 == 4) {
            return new C3062Vw(abstractC2402Lw);
        }
        if (i2 != 5) {
            return null;
        }
        return f11504zbb;
    }
}
