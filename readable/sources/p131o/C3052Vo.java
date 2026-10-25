package p131o;

/* renamed from: o.Vo */
/* loaded from: classes.dex */
public final class C3052Vo extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3052Vo f11360zbb;

    /* renamed from: zbd */
    private int f11361zbd;

    /* renamed from: zbe */
    private C3118Wp f11362zbe;

    /* renamed from: zbf */
    private C4646tu f11363zbf;

    /* renamed from: zbg */
    private C2050Gl f11364zbg;

    /* renamed from: zbh */
    private C2529Np f11365zbh;

    /* renamed from: zbi */
    private C3844hp f11366zbi;

    /* renamed from: zbj */
    private C3457bp f11367zbj;

    /* renamed from: zbk */
    private C2122Hp f11368zbk;

    /* renamed from: zbl */
    private byte f11369zbl = 2;

    static {
        C3052Vo c3052Vo = new C3052Vo();
        f11360zbb = c3052Vo;
        AbstractC3595dy.m11753YoKzxo(C3052Vo.class, c3052Vo);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f11369zbl);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11360zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new C3052Vo();
        }
        AbstractC2785Ro abstractC2785Ro = null;
        if (i2 == 4) {
            return new C2915To(abstractC2785Ro);
        }
        if (i2 == 5) {
            return f11360zbb;
        }
        this.f11369zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
