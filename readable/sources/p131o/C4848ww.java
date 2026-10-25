package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ww */
/* loaded from: classes.dex */
public final class C4848ww extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4848ww f17275zbb;

    /* renamed from: zbd */
    private int f17276zbd;

    /* renamed from: zbe */
    private int f17277zbe;

    /* renamed from: zbg */
    private C2271Jv f17279zbg;

    /* renamed from: zbh */
    private C2271Jv f17280zbh;

    /* renamed from: zbj */
    private float f17282zbj;

    /* renamed from: zbl */
    private C2271Jv f17284zbl;

    /* renamed from: zbm */
    private C2271Jv f17285zbm;

    /* renamed from: zbn */
    private C3464bw f17286zbn;

    /* renamed from: zbp */
    private C1658Aw f17288zbp;

    /* renamed from: zbq */
    private byte f17289zbq = 2;

    /* renamed from: zbf */
    private InterfaceC3988jy f17278zbf = AbstractC3595dy.m11749BAnRFn();

    /* renamed from: zbi */
    private String f17281zbi = BuildConfig.f24315FLAVOR;

    /* renamed from: zbk */
    private InterfaceC4118ly f17283zbk = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbo */
    private boolean f17287zbo = true;

    static {
        C4848ww c4848ww = new C4848ww();
        f17275zbb = c4848ww;
        AbstractC3595dy.m11753YoKzxo(C4848ww.class, c4848ww);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f17289zbq);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17275zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0002\b\u0001ᔄ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005ခ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bᐉ\u0007\tဇ\b\nᐉ\t\u000bЛ\f\u0016", new Object[]{"zbd", "zbe", "zbg", "zbh", "zbi", "zbj", "zbl", "zbm", "zbn", "zbo", "zbp", "zbk", C2661Pv.class, "zbf"});
        }
        if (i2 == 3) {
            return new C4848ww();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C4781vw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f17275zbb;
        }
        this.f17289zbq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
