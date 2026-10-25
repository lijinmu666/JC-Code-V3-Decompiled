package p131o;

/* renamed from: o.Qh */
/* loaded from: classes.dex */
public final class C2711Qh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2711Qh f10203zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f10204zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C2711Qh c2711Qh = new C2711Qh();
        f10203zbb = c2711Qh;
        AbstractC3595dy.m11753YoKzxo(C2711Qh.class, c2711Qh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10203zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", C4565si.class});
        }
        if (i2 == 3) {
            return new C2711Qh();
        }
        AbstractC2180Ih abstractC2180Ih = null;
        if (i2 == 4) {
            return new C2647Ph(abstractC2180Ih);
        }
        if (i2 != 5) {
            return null;
        }
        return f10203zbb;
    }
}
