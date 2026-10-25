package p131o;

/* renamed from: o.hh */
/* loaded from: classes.dex */
public final class C3836hh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3836hh f14044zbb;

    /* renamed from: zbd */
    private int f14045zbd;

    /* renamed from: zbe */
    private long f14046zbe;

    /* renamed from: zbf */
    private float f14047zbf = 0.5f;

    static {
        C3836hh c3836hh = new C3836hh();
        f14044zbb = c3836hh;
        AbstractC3595dy.m11753YoKzxo(C3836hh.class, c3836hh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14044zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3836hh();
        }
        AbstractC3513cg abstractC3513cg = null;
        if (i2 == 4) {
            return new C1975Fg(abstractC3513cg);
        }
        if (i2 != 5) {
            return null;
        }
        return f14044zbb;
    }
}
