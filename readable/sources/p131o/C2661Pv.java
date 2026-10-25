package p131o;

/* renamed from: o.Pv */
/* loaded from: classes.dex */
public final class C2661Pv extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2661Pv f10116zbb;

    /* renamed from: zbd */
    private int f10117zbd;

    /* renamed from: zbe */
    private float f10118zbe;

    /* renamed from: zbf */
    private int f10119zbf;

    /* renamed from: zbg */
    private byte f10120zbg = 2;

    static {
        C2661Pv c2661Pv = new C2661Pv();
        f10116zbb = c2661Pv;
        AbstractC3595dy.m11753YoKzxo(C2661Pv.class, c2661Pv);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f10120zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10116zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔁ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2661Pv();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C2471Mv(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f10116zbb;
        }
        this.f10120zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
