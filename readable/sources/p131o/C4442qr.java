package p131o;

/* renamed from: o.qr */
/* loaded from: classes.dex */
public final class C4442qr extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4442qr f16240zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f16241zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C4442qr c4442qr = new C4442qr();
        f16240zbb = c4442qr;
        AbstractC3595dy.m11753YoKzxo(C4442qr.class, c4442qr);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16240zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", C4241nr.class});
        }
        if (i2 == 3) {
            return new C4442qr();
        }
        AbstractC4308or abstractC4308or = null;
        if (i2 == 4) {
            return new C4374pr(abstractC4308or);
        }
        if (i2 != 5) {
            return null;
        }
        return f16240zbb;
    }
}
