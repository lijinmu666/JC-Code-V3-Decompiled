package p131o;

/* renamed from: o.no */
/* loaded from: classes.dex */
public final class C4238no extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4238no f15468zbb;

    /* renamed from: zbd */
    private int f15469zbd;

    /* renamed from: zbe */
    private C1646Al f15470zbe;

    /* renamed from: zbf */
    private C2334Kr f15471zbf;

    /* renamed from: zbg */
    private C3176Xg f15472zbg;

    /* renamed from: zbh */
    private C2334Kr f15473zbh;

    /* renamed from: zbi */
    private byte f15474zbi = 2;

    static {
        C4238no c4238no = new C4238no();
        f15468zbb = c4238no;
        AbstractC3595dy.m11753YoKzxo(C4238no.class, c4238no);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f15474zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15468zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C4238no();
        }
        AbstractC3973jo abstractC3973jo = null;
        if (i2 == 4) {
            return new C4107lo(abstractC3973jo);
        }
        if (i2 == 5) {
            return f15468zbb;
        }
        this.f15474zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
