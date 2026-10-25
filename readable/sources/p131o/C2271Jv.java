package p131o;

/* renamed from: o.Jv */
/* loaded from: classes.dex */
public final class C2271Jv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2271Jv f9059zbb;

    /* renamed from: zbd */
    private int f9060zbd;

    /* renamed from: zbe */
    private int f9061zbe;

    /* renamed from: zbf */
    private int f9062zbf;

    /* renamed from: zbg */
    private int f9063zbg;

    /* renamed from: zbh */
    private int f9064zbh;

    /* renamed from: zbi */
    private float f9065zbi;

    /* renamed from: zbj */
    private C3061Vv f9066zbj;

    /* renamed from: zbk */
    private byte f9067zbk = 2;

    static {
        C2271Jv c2271Jv = new C2271Jv();
        f9059zbb = c2271Jv;
        AbstractC3595dy.m11753YoKzxo(C2271Jv.class, c2271Jv);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f9067zbk);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9059zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C2271Jv();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C2195Iv(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f9059zbb;
        }
        this.f9067zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
