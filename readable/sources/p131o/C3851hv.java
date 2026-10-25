package p131o;

/* renamed from: o.hv */
/* loaded from: classes.dex */
public final class C3851hv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3851hv f14078zbb;

    /* renamed from: zbd */
    private int f14079zbd;

    /* renamed from: zbe */
    private C3721fv f14080zbe;

    /* renamed from: zbf */
    private double f14081zbf;

    /* renamed from: zbg */
    private boolean f14082zbg;

    /* renamed from: zbh */
    private C4312ov f14083zbh;

    /* renamed from: zbi */
    private byte f14084zbi = 2;

    static {
        C3851hv c3851hv = new C3851hv();
        f14078zbb = c3851hv;
        AbstractC3595dy.m11753YoKzxo(C3851hv.class, c3851hv);
    }

    /* renamed from: Ne */
    public static C3851hv m12241Ne() {
        return f14078zbb;
    }

    /* renamed from: CqaNbM */
    public final C4312ov m12243CqaNbM() {
        C4312ov c4312ov = this.f14083zbh;
        return c4312ov == null ? C4312ov.m13041cMLeY() : c4312ov;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f14084zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14078zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002\u0004ᐉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3851hv();
        }
        AbstractC3463bv abstractC3463bv = null;
        if (i2 == 4) {
            return new C3790gv(abstractC3463bv);
        }
        if (i2 == 5) {
            return f14078zbb;
        }
        this.f14084zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
