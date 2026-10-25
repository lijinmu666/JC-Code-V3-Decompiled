package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.qh */
/* loaded from: classes.dex */
public final class C4430qh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4430qh f16221zbb;

    /* renamed from: zbd */
    private int f16222zbd;

    /* renamed from: zbf */
    private Object f16224zbf;

    /* renamed from: zbe */
    private int f16223zbe = 0;

    /* renamed from: zbg */
    private String f16225zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private String f16226zbh = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private AbstractC4981yx f16227zbi = AbstractC4981yx.f17599AZxh;

    static {
        C4430qh c4430qh = new C4430qh();
        f16221zbb = c4430qh;
        AbstractC3595dy.m11753YoKzxo(C4430qh.class, c4430qh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16221zbb, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003<\u0000\u0004<\u0000\u0005ည\u0002", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", C3772gh.class, C1908Eh.class, "zbi"});
        }
        if (i2 == 3) {
            return new C4430qh();
        }
        AbstractC4297oh abstractC4297oh = null;
        if (i2 == 4) {
            return new C4364ph(abstractC4297oh);
        }
        if (i2 != 5) {
            return null;
        }
        return f16221zbb;
    }
}
