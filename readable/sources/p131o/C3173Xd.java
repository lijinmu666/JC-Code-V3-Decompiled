package p131o;

/* renamed from: o.Xd */
/* loaded from: classes.dex */
public final class C3173Xd extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3173Xd f11630zbd;

    /* renamed from: zbe */
    private int f11631zbe;

    /* renamed from: zbf */
    private int f11632zbf;

    /* renamed from: zbg */
    private byte f11633zbg = 2;

    static {
        C3173Xd c3173Xd = new C3173Xd();
        f11630zbd = c3173Xd;
        AbstractC3595dy.m11753YoKzxo(C3173Xd.class, c3173Xd);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f11633zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11630zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zbe", "zbf", C3105Wd.f11474mjFkc});
        }
        if (i2 == 3) {
            return new C3173Xd();
        }
        AbstractC3807hB abstractC3807hB = null;
        if (i2 == 4) {
            return new C3037Vd(abstractC3807hB);
        }
        if (i2 == 5) {
            return f11630zbd;
        }
        this.f11633zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
