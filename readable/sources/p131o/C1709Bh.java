package p131o;

/* renamed from: o.Bh */
/* loaded from: classes.dex */
public final class C1709Bh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1709Bh f7506zbb;

    /* renamed from: zbd */
    private int f7507zbd;

    /* renamed from: zbe */
    private float f7508zbe;

    /* renamed from: zbf */
    private float f7509zbf;

    /* renamed from: zbg */
    private float f7510zbg;

    /* renamed from: zbh */
    private float f7511zbh;

    /* renamed from: zbi */
    private byte f7512zbi = 2;

    static {
        C1709Bh c1709Bh = new C1709Bh();
        f7506zbb = c1709Bh;
        AbstractC3595dy.m11753YoKzxo(C1709Bh.class, c1709Bh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7512zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7506zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ᔁ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C1709Bh();
        }
        AbstractC5028zh abstractC5028zh = null;
        if (i2 == 4) {
            return new C1642Ah(abstractC5028zh);
        }
        if (i2 == 5) {
            return f7506zbb;
        }
        this.f7512zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
