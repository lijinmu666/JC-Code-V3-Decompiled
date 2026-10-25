package p131o;

/* renamed from: o.Du */
/* loaded from: classes.dex */
public final class C1853Du extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1853Du f7913zbb;

    /* renamed from: zbd */
    private int f7914zbd;

    /* renamed from: zbe */
    private float f7915zbe;

    /* renamed from: zbf */
    private float f7916zbf;

    /* renamed from: zbg */
    private float f7917zbg;

    /* renamed from: zbh */
    private float f7918zbh;

    /* renamed from: zbi */
    private float f7919zbi;

    /* renamed from: zbj */
    private long f7920zbj;

    /* renamed from: zbk */
    private byte f7921zbk = 2;

    static {
        C1853Du c1853Du = new C1853Du();
        f7913zbb = c1853Du;
        AbstractC3595dy.m11753YoKzxo(C1853Du.class, c1853Du);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7921zbk);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7913zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ᔁ\u0003\u0005ခ\u0004\u0006ဂ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C1853Du();
        }
        AbstractC1722Bu abstractC1722Bu = null;
        if (i2 == 4) {
            return new C1792Cu(abstractC1722Bu);
        }
        if (i2 == 5) {
            return f7913zbb;
        }
        this.f7921zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
