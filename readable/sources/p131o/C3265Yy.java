package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Yy */
/* loaded from: classes.dex */
public final class C3265Yy extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3265Yy f11922zbb;

    /* renamed from: zbd */
    private int f11923zbd;

    /* renamed from: zbe */
    private int f11924zbe;

    /* renamed from: zbf */
    private String f11925zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private float f11926zbg;

    /* renamed from: zbh */
    private float f11927zbh;

    static {
        C3265Yy c3265Yy = new C3265Yy();
        f11922zbb = c3265Yy;
        AbstractC3595dy.m11753YoKzxo(C3265Yy.class, c3265Yy);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11922zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3265Yy();
        }
        AbstractC3196Xx abstractC3196Xx = null;
        if (i2 == 4) {
            return new C4918xy(abstractC3196Xx);
        }
        if (i2 != 5) {
            return null;
        }
        return f11922zbb;
    }
}
