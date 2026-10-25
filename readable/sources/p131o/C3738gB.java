package p131o;

/* renamed from: o.gB */
/* loaded from: classes.dex */
public final class C3738gB extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3738gB f13681zbd;

    /* renamed from: zbe */
    private int f13682zbe;

    /* renamed from: zbf */
    private double f13683zbf;

    /* renamed from: zbg */
    private int f13684zbg;

    /* renamed from: zbh */
    private int f13685zbh;

    /* renamed from: zbi */
    private double f13686zbi;

    /* renamed from: zbj */
    private double f13687zbj;

    /* renamed from: zbk */
    private byte f13688zbk = 2;

    static {
        C3738gB c3738gB = new C3738gB();
        f13681zbd = c3738gB;
        AbstractC3595dy.m11753YoKzxo(C3738gB.class, c3738gB);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13688zbk);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13681zbd, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001က\u0000\u0002င\u0001\u0003င\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C3738gB();
        }
        AbstractC3609eB abstractC3609eB = null;
        if (i2 == 4) {
            return new C3673fB(abstractC3609eB);
        }
        if (i2 == 5) {
            return f13681zbd;
        }
        this.f13688zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
