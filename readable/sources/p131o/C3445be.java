package p131o;

/* renamed from: o.be */
/* loaded from: classes.dex */
public final class C3445be extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3445be f13127zbb;

    /* renamed from: zbd */
    private int f13128zbd;

    /* renamed from: zbe */
    private int f13129zbe;

    /* renamed from: zbf */
    private int f13130zbf;

    /* renamed from: zbg */
    private byte f13131zbg = 2;

    static {
        C3445be c3445be = new C3445be();
        f13127zbb = c3445be;
        AbstractC3595dy.m11753YoKzxo(C3445be.class, c3445be);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13131zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13127zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3445be();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C3375ae(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f13127zbb;
        }
        this.f13131zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
