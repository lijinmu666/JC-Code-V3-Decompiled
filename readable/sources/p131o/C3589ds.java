package p131o;

/* renamed from: o.ds */
/* loaded from: classes.dex */
public final class C3589ds extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3589ds f13398zbd;

    /* renamed from: zbe */
    private int f13399zbe;

    /* renamed from: zbf */
    private long f13400zbf;

    /* renamed from: zbg */
    private C4706uq f13401zbg;

    /* renamed from: zbh */
    private C1785Cq f13402zbh;

    /* renamed from: zbj */
    private byte f13404zbj = 2;

    /* renamed from: zbi */
    private InterfaceC4118ly f13403zbi = AbstractC3595dy.m11760wJVbdd();

    static {
        C3589ds c3589ds = new C3589ds();
        f13398zbd = c3589ds;
        AbstractC3595dy.m11753YoKzxo(C3589ds.class, c3589ds);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13404zbj);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13398zbd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zbe", "zbf", "zbg", "zbi", C1989Fq.class, "zbh"});
        }
        if (i2 == 3) {
            return new C3589ds();
        }
        AbstractC3460bs abstractC3460bs = null;
        if (i2 == 4) {
            return new C3525cs(abstractC3460bs);
        }
        if (i2 == 5) {
            return f13398zbd;
        }
        this.f13404zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
