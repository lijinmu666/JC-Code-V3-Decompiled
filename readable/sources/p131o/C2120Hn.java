package p131o;

/* renamed from: o.Hn */
/* loaded from: classes.dex */
public final class C2120Hn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2120Hn f8648zbb;

    /* renamed from: zbd */
    private int f8649zbd;

    /* renamed from: zbe */
    private float f8650zbe = 1.0f;

    /* renamed from: zbf */
    private int f8651zbf;

    static {
        C2120Hn c2120Hn = new C2120Hn();
        f8648zbb = c2120Hn;
        AbstractC3595dy.m11753YoKzxo(C2120Hn.class, c2120Hn);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8648zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2120Hn();
        }
        AbstractC1846Dn abstractC1846Dn = null;
        if (i2 == 4) {
            return new C1983Fn(abstractC1846Dn);
        }
        if (i2 != 5) {
            return null;
        }
        return f8648zbb;
    }
}
