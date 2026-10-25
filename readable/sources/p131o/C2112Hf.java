package p131o;

/* renamed from: o.Hf */
/* loaded from: classes.dex */
public final class C2112Hf extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2112Hf f8625zbb;

    /* renamed from: zbe */
    private byte f8627zbe = 2;

    /* renamed from: zbd */
    private InterfaceC4118ly f8626zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C2112Hf c2112Hf = new C2112Hf();
        f8625zbb = c2112Hf;
        AbstractC3595dy.m11753YoKzxo(C2112Hf.class, c2112Hf);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8627zbe);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8625zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", C1838Df.class});
        }
        if (i2 == 3) {
            return new C2112Hf();
        }
        AbstractC1974Ff abstractC1974Ff = null;
        if (i2 == 4) {
            return new C2044Gf(abstractC1974Ff);
        }
        if (i2 == 5) {
            return f8625zbb;
        }
        this.f8627zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
