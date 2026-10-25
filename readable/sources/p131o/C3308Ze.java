package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Ze */
/* loaded from: classes.dex */
public final class C3308Ze extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3308Ze f12178zbb;

    /* renamed from: zbd */
    private int f12179zbd;

    /* renamed from: zbf */
    private int f12181zbf;

    /* renamed from: zbh */
    private float f12183zbh;

    /* renamed from: zbi */
    private boolean f12184zbi;

    /* renamed from: zbj */
    private boolean f12185zbj;

    /* renamed from: zbe */
    private String f12180zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f12182zbg = BuildConfig.f24315FLAVOR;

    static {
        C3308Ze c3308Ze = new C3308Ze();
        f12178zbb = c3308Ze;
        AbstractC3595dy.m11753YoKzxo(C3308Ze.class, c3308Ze);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12178zbb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ခ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C3308Ze();
        }
        AbstractC2972Ud abstractC2972Ud = null;
        if (i2 == 4) {
            return new C4827we(abstractC2972Ud);
        }
        if (i2 != 5) {
            return null;
        }
        return f12178zbb;
    }
}
