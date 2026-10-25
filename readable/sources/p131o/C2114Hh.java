package p131o;

/* renamed from: o.Hh */
/* loaded from: classes.dex */
public final class C2114Hh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2114Hh f8636zbb;

    /* renamed from: zbd */
    private int f8637zbd;

    /* renamed from: zbe */
    private int f8638zbe;

    /* renamed from: zbf */
    private int f8639zbf;

    /* renamed from: zbg */
    private int f8640zbg;

    /* renamed from: zbh */
    private int f8641zbh;

    /* renamed from: zbi */
    private byte f8642zbi = 2;

    static {
        C2114Hh c2114Hh = new C2114Hh();
        f8636zbb = c2114Hh;
        AbstractC3595dy.m11753YoKzxo(C2114Hh.class, c2114Hh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8642zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8636zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C2114Hh();
        }
        AbstractC1976Fh abstractC1976Fh = null;
        if (i2 == 4) {
            return new C2046Gh(abstractC1976Fh);
        }
        if (i2 == 5) {
            return f8636zbb;
        }
        this.f8642zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
