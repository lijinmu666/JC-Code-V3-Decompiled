package p131o;

/* renamed from: o.hp */
/* loaded from: classes.dex */
public final class C3844hp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3844hp f14065zbb;

    /* renamed from: zbd */
    private int f14066zbd;

    /* renamed from: zbe */
    private AbstractC4981yx f14067zbe = AbstractC4981yx.f17599AZxh;

    /* renamed from: zbf */
    private float f14068zbf;

    static {
        C3844hp c3844hp = new C3844hp();
        f14065zbb = c3844hp;
        AbstractC3595dy.m11753YoKzxo(C3844hp.class, c3844hp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14065zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3844hp();
        }
        AbstractC3586dp abstractC3586dp = null;
        if (i2 == 4) {
            return new C3715fp(abstractC3586dp);
        }
        if (i2 != 5) {
            return null;
        }
        return f14065zbb;
    }
}
