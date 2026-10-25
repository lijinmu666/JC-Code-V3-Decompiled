package p131o;

/* renamed from: o.bg */
/* loaded from: classes.dex */
public final class C3447bg extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C3447bg f13138zbd;

    /* renamed from: zbf */
    private byte f13140zbf = 2;

    /* renamed from: zbe */
    private InterfaceC4118ly f13139zbe = AbstractC3595dy.m11760wJVbdd();

    static {
        C3447bg c3447bg = new C3447bg();
        f13138zbd = c3447bg;
        AbstractC3595dy.m11753YoKzxo(C3447bg.class, c3447bg);
    }

    /* renamed from: CqaNbM */
    public static C3447bg m11569CqaNbM() {
        return f13138zbd;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13140zbf);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13138zbd, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0000\u0003\u001b", new Object[]{"zbe", C3377ag.class});
        }
        if (i2 == 3) {
            return new C3447bg();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C3242Yf(abstractC2645Pf);
        }
        if (i2 == 5) {
            return f13138zbd;
        }
        this.f13140zbf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
