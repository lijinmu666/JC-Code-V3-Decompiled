package p131o;

/* renamed from: o.al */
/* loaded from: classes.dex */
public final class C3382al extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3382al f12809zbd;

    /* renamed from: zbe */
    private byte f12810zbe = 2;

    static {
        C3382al c3382al = new C3382al();
        f12809zbd = c3382al;
        AbstractC3595dy.m11753YoKzxo(C3382al.class, c3382al);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f12810zbe);
        }
        AbstractC3113Wk abstractC3113Wk = null;
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12809zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new C3382al();
        }
        if (i2 == 4) {
            return new C3248Yk(abstractC3113Wk);
        }
        if (i2 == 5) {
            return f12809zbd;
        }
        this.f12810zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
