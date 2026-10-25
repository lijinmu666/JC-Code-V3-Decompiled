package p131o;

/* renamed from: o.Ht */
/* loaded from: classes.dex */
public final class C2126Ht extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C2126Ht f8659zbd;

    /* renamed from: zbe */
    private byte f8660zbe = 2;

    static {
        C2126Ht c2126Ht = new C2126Ht();
        f8659zbd = c2126Ht;
        AbstractC3595dy.m11753YoKzxo(C2126Ht.class, c2126Ht);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8660zbe);
        }
        AbstractC1994Ft abstractC1994Ft = null;
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8659zbd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new C2126Ht();
        }
        if (i2 == 4) {
            return new C2059Gt(abstractC1994Ft);
        }
        if (i2 == 5) {
            return f8659zbd;
        }
        this.f8660zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
