package p131o;

/* renamed from: o.Zp */
/* loaded from: classes.dex */
public final class C3322Zp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3322Zp f12230zbb;

    /* renamed from: zbd */
    private int f12231zbd;

    /* renamed from: zbe */
    private float f12232zbe = 0.7f;

    /* renamed from: zbf */
    private int f12233zbf = 2;

    /* renamed from: zbg */
    private float f12234zbg = 0.2f;

    static {
        C3322Zp c3322Zp = new C3322Zp();
        f12230zbb = c3322Zp;
        AbstractC3595dy.m11753YoKzxo(C3322Zp.class, c3322Zp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12230zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3322Zp();
        }
        AbstractC3186Xp abstractC3186Xp = null;
        if (i2 == 4) {
            return new C3254Yp(abstractC3186Xp);
        }
        if (i2 != 5) {
            return null;
        }
        return f12230zbb;
    }
}
