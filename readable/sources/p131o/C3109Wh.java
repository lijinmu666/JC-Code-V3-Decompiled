package p131o;

/* renamed from: o.Wh */
/* loaded from: classes.dex */
public final class C3109Wh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3109Wh f11483zbb;

    /* renamed from: zbd */
    private int f11484zbd;

    /* renamed from: zbe */
    private float f11485zbe;

    static {
        C3109Wh c3109Wh = new C3109Wh();
        f11483zbb = c3109Wh;
        AbstractC3595dy.m11753YoKzxo(C3109Wh.class, c3109Wh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11483zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0001", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C3109Wh();
        }
        AbstractC2180Ih abstractC2180Ih = null;
        if (i2 == 4) {
            return new C3044Vh(abstractC2180Ih);
        }
        if (i2 != 5) {
            return null;
        }
        return f11483zbb;
    }
}
