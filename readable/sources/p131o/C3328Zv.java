package p131o;

/* renamed from: o.Zv */
/* loaded from: classes.dex */
public final class C3328Zv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3328Zv f12242zbb;

    /* renamed from: zbd */
    private int f12243zbd;

    /* renamed from: zbe */
    private C3464bw f12244zbe;

    /* renamed from: zbf */
    private float f12245zbf;

    /* renamed from: zbh */
    private byte f12247zbh = 2;

    /* renamed from: zbg */
    private InterfaceC3917iy f12246zbg = AbstractC3595dy.m11752VocHEe();

    static {
        C3328Zv c3328Zv = new C3328Zv();
        f12242zbb = c3328Zv;
        AbstractC3595dy.m11753YoKzxo(C3328Zv.class, c3328Zv);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f12247zbh);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12242zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ခ\u0001\u0003\u0013", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3328Zv();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C3261Yv(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f12242zbb;
        }
        this.f12247zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
