package p131o;

/* renamed from: o.Tt */
/* loaded from: classes.dex */
public final class C2920Tt extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C2920Tt f10750zbd;

    /* renamed from: zbe */
    private byte f10751zbe = 2;

    static {
        C2920Tt c2920Tt = new C2920Tt();
        f10750zbd = c2920Tt;
        AbstractC3595dy.m11753YoKzxo(C2920Tt.class, c2920Tt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f10751zbe);
        }
        AbstractC2659Pt abstractC2659Pt = null;
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10750zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new C2920Tt();
        }
        if (i2 == 4) {
            return new C2858St(abstractC2659Pt);
        }
        if (i2 == 5) {
            return f10750zbd;
        }
        this.f10751zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
