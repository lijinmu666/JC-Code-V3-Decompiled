package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Sq */
/* loaded from: classes.dex */
public final class C2854Sq extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2854Sq f10595zbb;

    /* renamed from: zbd */
    private int f10596zbd;

    /* renamed from: zbf */
    private Object f10598zbf;

    /* renamed from: zbg */
    private float f10599zbg;

    /* renamed from: zbi */
    private boolean f10601zbi;

    /* renamed from: zbe */
    private int f10597zbe = 0;

    /* renamed from: zbh */
    private String f10600zbh = BuildConfig.f24315FLAVOR;

    static {
        C2854Sq c2854Sq = new C2854Sq();
        f10595zbb = c2854Sq;
        AbstractC3595dy.m11753YoKzxo(C2854Sq.class, c2854Sq);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10595zbb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002ခ\u0000\u0003;\u0000\u0004ဈ\u0001\u0005ဇ\u0002", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C2854Sq();
        }
        AbstractC2721Qq abstractC2721Qq = null;
        if (i2 == 4) {
            return new C2787Rq(abstractC2721Qq);
        }
        if (i2 != 5) {
            return null;
        }
        return f10595zbb;
    }
}
