package p131o;

/* renamed from: o.Aw */
/* loaded from: classes.dex */
public final class C1658Aw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1658Aw f7414zbb;

    /* renamed from: zbe */
    private byte f7416zbe = 2;

    /* renamed from: zbd */
    private InterfaceC4118ly f7415zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C1658Aw c1658Aw = new C1658Aw();
        f7414zbb = c1658Aw;
        AbstractC3595dy.m11753YoKzxo(C1658Aw.class, c1658Aw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7416zbe);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7414zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", C4980yw.class});
        }
        if (i2 == 3) {
            return new C1658Aw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C5045zw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f7414zbb;
        }
        this.f7416zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
