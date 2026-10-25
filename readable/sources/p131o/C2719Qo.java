package p131o;

/* renamed from: o.Qo */
/* loaded from: classes.dex */
public final class C2719Qo extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2719Qo f10276zbb;

    /* renamed from: zbd */
    private int f10277zbd;

    /* renamed from: zbe */
    private int f10278zbe;

    /* renamed from: zbf */
    private C3176Xg f10279zbf;

    /* renamed from: zbg */
    private C2788Rr f10280zbg;

    /* renamed from: zbh */
    private C4173mo f10281zbh;

    /* renamed from: zbi */
    private C5048zz f10282zbi;

    /* renamed from: zbj */
    private byte f10283zbj = 2;

    static {
        C2719Qo c2719Qo = new C2719Qo();
        f10276zbb = c2719Qo;
        AbstractC3595dy.m11753YoKzxo(C2719Qo.class, c2719Qo);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f10283zbj);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10276zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ဉ\u0002\u0002ဉ\u0003\u0003᠌\u0000\u0004ဉ\u0004\u0005ᐉ\u0001", new Object[]{"zbd", "zbg", "zbh", "zbe", C2591Oo.f10003mjFkc, "zbi", "zbf"});
        }
        if (i2 == 3) {
            return new C2719Qo();
        }
        AbstractC2331Ko abstractC2331Ko = null;
        if (i2 == 4) {
            return new C2461Mo(abstractC2331Ko);
        }
        if (i2 == 5) {
            return f10276zbb;
        }
        this.f10283zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
