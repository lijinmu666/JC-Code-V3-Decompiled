package p131o;

/* renamed from: o.pi */
/* loaded from: classes.dex */
public final class C4365pi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4365pi f15961zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f15962zbd = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbe */
    private InterfaceC4118ly f15963zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private InterfaceC4118ly f15964zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private InterfaceC4118ly f15965zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C4365pi c4365pi = new C4365pi();
        f15961zbb = c4365pi;
        AbstractC3595dy.m11753YoKzxo(C4365pi.class, c4365pi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15961zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zbd", C3313Zh.class, "zbe", C2583Oh.class, "zbf", C4766vi.class, "zbg", C4101li.class});
        }
        if (i2 == 3) {
            return new C4365pi();
        }
        AbstractC2180Ih abstractC2180Ih = null;
        if (i2 == 4) {
            return new C4166mi(abstractC2180Ih);
        }
        if (i2 != 5) {
            return null;
        }
        return f15961zbb;
    }
}
