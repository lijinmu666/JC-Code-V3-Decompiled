package p131o;

/* renamed from: o.rj */
/* loaded from: classes.dex */
public final class C4500rj extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4500rj f16387zbb;

    /* renamed from: zbd */
    private InterfaceC3917iy f16388zbd = AbstractC3595dy.m11752VocHEe();

    static {
        C4500rj c4500rj = new C4500rj();
        f16387zbb = c4500rj;
        AbstractC3595dy.m11753YoKzxo(C4500rj.class, c4500rj);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16387zbb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"zbd"});
        }
        if (i2 == 3) {
            return new C4500rj();
        }
        AbstractC4366pj abstractC4366pj = null;
        if (i2 == 4) {
            return new C4432qj(abstractC4366pj);
        }
        if (i2 != 5) {
            return null;
        }
        return f16387zbb;
    }
}
