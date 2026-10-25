package p131o;

/* renamed from: o.os */
/* loaded from: classes.dex */
public final class C4309os extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4309os f15861zbb;

    /* renamed from: zbd */
    private int f15862zbd;

    /* renamed from: zbf */
    private int f15864zbf;

    /* renamed from: zbe */
    private int f15863zbe = 1;

    /* renamed from: zbg */
    private int f15865zbg = 4;

    /* renamed from: zbh */
    private int f15866zbh = 240;

    /* renamed from: zbi */
    private InterfaceC3988jy f15867zbi = AbstractC3595dy.m11749BAnRFn();

    static {
        C4309os c4309os = new C4309os();
        f15861zbb = c4309os;
        AbstractC3595dy.m11753YoKzxo(C4309os.class, c4309os);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15861zbb, "\u0001\u0005\u0000\u0001\u0003\n\u0005\u0000\u0001\u0000\u0003᠌\u0000\u0007င\u0001\bင\u0002\tင\u0003\nࠬ", new Object[]{"zbd", "zbe", C4242ns.f15484mjFkc, "zbf", "zbg", "zbh", "zbi", C4177ms.f15259mjFkc});
        }
        if (i2 == 3) {
            return new C4309os();
        }
        AbstractC4048ks abstractC4048ks = null;
        if (i2 == 4) {
            return new C4111ls(abstractC4048ks);
        }
        if (i2 != 5) {
            return null;
        }
        return f15861zbb;
    }
}
