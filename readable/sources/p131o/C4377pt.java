package p131o;

/* renamed from: o.pt */
/* loaded from: classes.dex */
public final class C4377pt extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C4377pt f15984zbd;

    /* renamed from: zbe */
    private int f15985zbe;

    /* renamed from: zbf */
    private boolean f15986zbf;

    /* renamed from: zbg */
    private byte f15987zbg = 2;

    static {
        C4377pt c4377pt = new C4377pt();
        f15984zbd = c4377pt;
        AbstractC3595dy.m11753YoKzxo(C4377pt.class, c4377pt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f15987zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15984zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4377pt();
        }
        AbstractC4243nt abstractC4243nt = null;
        if (i2 == 4) {
            return new C4310ot(abstractC4243nt);
        }
        if (i2 == 5) {
            return f15984zbd;
        }
        this.f15987zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
