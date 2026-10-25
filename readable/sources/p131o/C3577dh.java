package p131o;

/* renamed from: o.dh */
/* loaded from: classes.dex */
public final class C3577dh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3577dh f13375zbb;

    /* renamed from: zbd */
    private int f13376zbd = 0;

    /* renamed from: zbe */
    private Object f13377zbe;

    static {
        C3577dh c3577dh = new C3577dh();
        f13375zbb = c3577dh;
        AbstractC3595dy.m11753YoKzxo(C3577dh.class, c3577dh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13375zbb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001;\u0000\u0002=\u0000", new Object[]{"zbe", "zbd"});
        }
        if (i2 == 3) {
            return new C3577dh();
        }
        AbstractC3448bh abstractC3448bh = null;
        if (i2 == 4) {
            return new C3514ch(abstractC3448bh);
        }
        if (i2 != 5) {
            return null;
        }
        return f13375zbb;
    }
}
