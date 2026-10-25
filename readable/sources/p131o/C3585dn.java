package p131o;

/* renamed from: o.dn */
/* loaded from: classes.dex */
public final class C3585dn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3585dn f13396zbb;

    /* renamed from: zbd */
    private InterfaceC4118ly f13397zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C3585dn c3585dn = new C3585dn();
        f13396zbb = c3585dn;
        AbstractC3595dy.m11753YoKzxo(C3585dn.class, c3585dn);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13396zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", C3454bn.class});
        }
        if (i2 == 3) {
            return new C3585dn();
        }
        AbstractC3049Vm abstractC3049Vm = null;
        if (i2 == 4) {
            return new C3183Xm(abstractC3049Vm);
        }
        if (i2 != 5) {
            return null;
        }
        return f13396zbb;
    }
}
