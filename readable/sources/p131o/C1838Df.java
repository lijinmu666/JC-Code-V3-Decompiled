package p131o;

/* renamed from: o.Df */
/* loaded from: classes.dex */
public final class C1838Df extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C1838Df f7884zbd;

    /* renamed from: zbe */
    private int f7885zbe;

    /* renamed from: zbf */
    private C4628tf f7886zbf;

    /* renamed from: zbh */
    private float f7888zbh;

    /* renamed from: zbi */
    private float f7889zbi;

    /* renamed from: zbl */
    private C4628tf f7892zbl;

    /* renamed from: zbm */
    private C4097lf f7893zbm;

    /* renamed from: zbo */
    private byte f7895zbo = 2;

    /* renamed from: zbg */
    private InterfaceC4118ly f7887zbg = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbj */
    private InterfaceC4118ly f7890zbj = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbk */
    private AbstractC4981yx f7891zbk = AbstractC4981yx.f17599AZxh;

    /* renamed from: zbn */
    private InterfaceC4118ly f7894zbn = AbstractC3595dy.m11760wJVbdd();

    static {
        C1838Df c1838Df = new C1838Df();
        f7884zbd = c1838Df;
        AbstractC3595dy.m11753YoKzxo(C1838Df.class, c1838Df);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7895zbo);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7884zbd, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0003\u0001\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004\u001b\u0005ᐉ\u0005\u0006\u001b\u0007ည\u0003\bဉ\u0004\tခ\u0002", new Object[]{"zbe", "zbf", "zbg", C1773Cf.class, "zbh", "zbj", C4828wf.class, "zbm", "zbn", C4496rf.class, "zbk", "zbl", "zbi"});
        }
        if (i2 == 3) {
            return new C1838Df();
        }
        AbstractC4362pf abstractC4362pf = null;
        if (i2 == 4) {
            return new C4694uf(abstractC4362pf);
        }
        if (i2 == 5) {
            return f7884zbd;
        }
        this.f7895zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
