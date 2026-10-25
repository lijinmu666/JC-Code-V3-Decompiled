package p131o;

/* renamed from: o.he */
/* loaded from: classes.dex */
public final class C3833he extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3833he f14038zbb;

    /* renamed from: zbd */
    private int f14039zbd;

    /* renamed from: zbf */
    private C4312ov f14041zbf;

    /* renamed from: zbg */
    private float f14042zbg;

    /* renamed from: zbh */
    private byte f14043zbh = 2;

    /* renamed from: zbe */
    private int f14040zbe = 2;

    static {
        C3833he c3833he = new C3833he();
        f14038zbb = c3833he;
        AbstractC3595dy.m11753YoKzxo(C3833he.class, c3833he);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f14043zbh);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14038zbb, "\u0001\u0003\u0000\u0001\u0001\u0007\u0003\u0000\u0000\u0001\u0001᠌\u0000\u0002ᐉ\u0001\u0007ခ\u0002", new Object[]{"zbd", "zbe", C3703fe.f13616mjFkc, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3833he();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C3769ge(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f14038zbb;
        }
        this.f14043zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
