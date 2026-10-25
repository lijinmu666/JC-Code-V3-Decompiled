package p131o;

/* renamed from: o.Uk */
/* loaded from: classes.dex */
public final class C2979Uk extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2979Uk f10906zbb;

    /* renamed from: zbd */
    private int f10907zbd;

    /* renamed from: zbe */
    private float f10908zbe = 50.0f;

    /* renamed from: zbf */
    private int f10909zbf = 1;

    static {
        C2979Uk c2979Uk = new C2979Uk();
        f10906zbb = c2979Uk;
        AbstractC3595dy.m11753YoKzxo(C2979Uk.class, c2979Uk);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10906zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002င\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2979Uk();
        }
        AbstractC2714Qk abstractC2714Qk = null;
        if (i2 == 4) {
            return new C2846Sk(abstractC2714Qk);
        }
        if (i2 != 5) {
            return null;
        }
        return f10906zbb;
    }
}
