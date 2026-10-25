package p131o;

/* renamed from: o.Cw */
/* loaded from: classes.dex */
public final class C1794Cw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1794Cw f7761zbb;

    /* renamed from: zbd */
    private int f7762zbd;

    /* renamed from: zbe */
    private C2271Jv f7763zbe;

    /* renamed from: zbg */
    private byte f7765zbg = 2;

    /* renamed from: zbf */
    private InterfaceC3988jy f7764zbf = AbstractC3595dy.m11749BAnRFn();

    static {
        C1794Cw c1794Cw = new C1794Cw();
        f7761zbb = c1794Cw;
        AbstractC3595dy.m11753YoKzxo(C1794Cw.class, c1794Cw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7765zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7761zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ᐉ\u0000\u0002\u0016", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C1794Cw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C1724Bw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f7761zbb;
        }
        this.f7765zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
