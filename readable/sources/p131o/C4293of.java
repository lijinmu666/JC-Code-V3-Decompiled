package p131o;

/* renamed from: o.of */
/* loaded from: classes.dex */
public final class C4293of extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4293of f15784zbb;

    /* renamed from: zbe */
    private byte f15786zbe = 2;

    /* renamed from: zbd */
    private InterfaceC4118ly f15785zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C4293of c4293of = new C4293of();
        f15784zbb = c4293of;
        AbstractC3595dy.m11753YoKzxo(C4293of.class, c4293of);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f15786zbe);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15784zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", C4097lf.class});
        }
        if (i2 == 3) {
            return new C4293of();
        }
        AbstractC4163mf abstractC4163mf = null;
        if (i2 == 4) {
            return new C4228nf(abstractC4163mf);
        }
        if (i2 == 5) {
            return f15784zbb;
        }
        this.f15786zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
