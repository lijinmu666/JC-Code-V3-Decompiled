package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.zz */
/* loaded from: classes.dex */
public final class C5048zz extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C5048zz f17755zbb;

    /* renamed from: zbd */
    private int f17756zbd;

    /* renamed from: zbe */
    private C2386Li f17757zbe;

    /* renamed from: zbf */
    private String f17758zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private boolean f17759zbg;

    /* renamed from: zbh */
    private C2121Ho f17760zbh;

    static {
        C5048zz c5048zz = new C5048zz();
        f17755zbb = c5048zz;
        AbstractC3595dy.m11753YoKzxo(C5048zz.class, c5048zz);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17755zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C5048zz();
        }
        AbstractC4850wy abstractC4850wy = null;
        if (i2 == 4) {
            return new C3198Xy(abstractC4850wy);
        }
        if (i2 != 5) {
            return null;
        }
        return f17755zbb;
    }
}
