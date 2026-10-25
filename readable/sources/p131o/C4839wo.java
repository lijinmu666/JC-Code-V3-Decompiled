package p131o;

/* renamed from: o.wo */
/* loaded from: classes.dex */
public final class C4839wo extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4839wo f17248zbb;

    /* renamed from: zbd */
    private int f17249zbd;

    /* renamed from: zbe */
    private C4301ol f17250zbe;

    /* renamed from: zbf */
    private C1646Al f17251zbf;

    /* renamed from: zbg */
    private C4238no f17252zbg;

    /* renamed from: zbh */
    private boolean f17253zbh;

    /* renamed from: zbi */
    private byte f17254zbi = 2;

    static {
        C4839wo c4839wo = new C4839wo();
        f17248zbb = c4839wo;
        AbstractC3595dy.m11753YoKzxo(C4839wo.class, c4839wo);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f17254zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17248zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဇ\u0003\u0003ᐉ\u0002\u0004ဉ\u0001", new Object[]{"zbd", "zbe", "zbh", "zbg", "zbf"});
        }
        if (i2 == 3) {
            return new C4839wo();
        }
        AbstractC4572so abstractC4572so = null;
        if (i2 == 4) {
            return new C4704uo(abstractC4572so);
        }
        if (i2 == 5) {
            return f17248zbb;
        }
        this.f17254zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
