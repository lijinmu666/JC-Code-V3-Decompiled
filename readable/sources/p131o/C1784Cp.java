package p131o;

/* renamed from: o.Cp */
/* loaded from: classes.dex */
public final class C1784Cp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1784Cp f7668zbb;

    /* renamed from: zbd */
    private int f7669zbd;

    /* renamed from: zbe */
    private int f7670zbe = 1;

    /* renamed from: zbf */
    private boolean f7671zbf;

    static {
        C1784Cp c1784Cp = new C1784Cp();
        f7668zbb = c1784Cp;
        AbstractC3595dy.m11753YoKzxo(C1784Cp.class, c1784Cp);
    }

    /* renamed from: CqaNbM */
    public static /* synthetic */ void m7858CqaNbM(C1784Cp c1784Cp, int i) {
        c1784Cp.f7670zbe = 1;
        c1784Cp.f7669zbd = 1 | c1784Cp.f7669zbd;
    }

    /* renamed from: OjSQV */
    public static C1650Ap m7860OjSQV() {
        return (C1650Ap) f7668zbb.m11764Ucbh();
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7668zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zbd", "zbe", C4510rs.f16397mjFkc, "zbf"});
        }
        if (i2 == 3) {
            return new C1784Cp();
        }
        AbstractC4973yp abstractC4973yp = null;
        if (i2 == 4) {
            return new C1650Ap(abstractC4973yp);
        }
        if (i2 != 5) {
            return null;
        }
        return f7668zbb;
    }
}
