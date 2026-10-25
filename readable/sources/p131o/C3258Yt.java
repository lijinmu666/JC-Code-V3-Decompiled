package p131o;

/* renamed from: o.Yt */
/* loaded from: classes.dex */
public final class C3258Yt extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3258Yt f11916zbd;

    /* renamed from: zbe */
    private int f11917zbe;

    /* renamed from: zbg */
    private byte f11919zbg = 2;

    /* renamed from: zbf */
    private boolean f11918zbf = true;

    static {
        C3258Yt c3258Yt = new C3258Yt();
        f11916zbd = c3258Yt;
        AbstractC3595dy.m11753YoKzxo(C3258Yt.class, c3258Yt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f11919zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11916zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3258Yt();
        }
        AbstractC2993Ut abstractC2993Ut = null;
        if (i2 == 4) {
            return new C3190Xt(abstractC2993Ut);
        }
        if (i2 == 5) {
            return f11916zbd;
        }
        this.f11919zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
