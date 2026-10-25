package p131o;

/* renamed from: o.uh */
/* loaded from: classes.dex */
public final class C4696uh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4696uh f16861zbb;

    /* renamed from: zbd */
    private int f16862zbd;

    /* renamed from: zbe */
    private int f16863zbe;

    /* renamed from: zbg */
    private int f16865zbg;

    /* renamed from: zbh */
    private boolean f16866zbh;

    /* renamed from: zbi */
    private byte f16867zbi = 2;

    /* renamed from: zbf */
    private InterfaceC4118ly f16864zbf = AbstractC3595dy.m11760wJVbdd();

    static {
        C4696uh c4696uh = new C4696uh();
        f16861zbb = c4696uh;
        AbstractC3595dy.m11753YoKzxo(C4696uh.class, c4696uh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f16867zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16861zbb, "\u0001\u0004\u0000\u0001\u0003\u0006\u0004\u0000\u0001\u0002\u0003ᔄ\u0000\u0004Л\u0005င\u0001\u0006ဇ\u0002", new Object[]{"zbd", "zbe", "zbf", C4965yh.class, "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C4696uh();
        }
        AbstractC4498rh abstractC4498rh = null;
        if (i2 == 4) {
            return new C4630th(abstractC4498rh);
        }
        if (i2 == 5) {
            return f16861zbb;
        }
        this.f16867zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
