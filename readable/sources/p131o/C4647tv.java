package p131o;

/* renamed from: o.tv */
/* loaded from: classes.dex */
public final class C4647tv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4647tv f16752zbb;

    /* renamed from: zbd */
    private int f16753zbd;

    /* renamed from: zbe */
    private C4915xv f16754zbe;

    /* renamed from: zbf */
    private double f16755zbf;

    /* renamed from: zbg */
    private double f16756zbg;

    static {
        C4647tv c4647tv = new C4647tv();
        f16752zbb = c4647tv;
        AbstractC3595dy.m11753YoKzxo(C4647tv.class, c4647tv);
    }

    /* renamed from: CqaNbM */
    public static /* synthetic */ void m13656CqaNbM(C4647tv c4647tv, C4915xv c4915xv) {
        c4915xv.getClass();
        c4647tv.f16754zbe = c4915xv;
        c4647tv.f16753zbd |= 1;
    }

    /* renamed from: OjSQV */
    public static C4581sv m13658OjSQV() {
        return (C4581sv) f16752zbb.m11764Ucbh();
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16752zbb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0000\u0003\u0000", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4647tv();
        }
        AbstractC4514rv abstractC4514rv = null;
        if (i2 == 4) {
            return new C4581sv(abstractC4514rv);
        }
        if (i2 != 5) {
            return null;
        }
        return f16752zbb;
    }
}
