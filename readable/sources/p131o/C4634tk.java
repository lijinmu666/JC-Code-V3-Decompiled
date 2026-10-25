package p131o;

/* renamed from: o.tk */
/* loaded from: classes.dex */
public final class C4634tk extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4634tk f16715zbb;

    /* renamed from: zbd */
    private int f16716zbd;

    /* renamed from: zbg */
    private float f16719zbg;

    /* renamed from: zbe */
    private String f16717zbe = "en";

    /* renamed from: zbf */
    private int f16718zbf = -1;

    /* renamed from: zbh */
    private InterfaceC4118ly f16720zbh = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbi */
    private InterfaceC4118ly f16721zbi = AbstractC3595dy.m11760wJVbdd();

    static {
        C4634tk c4634tk = new C4634tk();
        f16715zbb = c4634tk;
        AbstractC3595dy.m11753YoKzxo(C4634tk.class, c4634tk);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16715zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ခ\u0002\u0004\u001a\u0005\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C4634tk();
        }
        AbstractC4501rk abstractC4501rk = null;
        if (i2 == 4) {
            return new C4568sk(abstractC4501rk);
        }
        if (i2 != 5) {
            return null;
        }
        return f16715zbb;
    }
}
