package p131o;

/* renamed from: o.si */
/* loaded from: classes.dex */
public final class C4565si extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4565si f16538zbb;

    /* renamed from: zbd */
    private float f16539zbd;

    /* renamed from: zbe */
    private float f16540zbe;

    static {
        C4565si c4565si = new C4565si();
        f16538zbb = c4565si;
        AbstractC3595dy.m11753YoKzxo(C4565si.class, c4565si);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16538zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C4565si();
        }
        AbstractC4431qi abstractC4431qi = null;
        if (i2 == 4) {
            return new C4499ri(abstractC4431qi);
        }
        if (i2 != 5) {
            return null;
        }
        return f16538zbb;
    }
}
