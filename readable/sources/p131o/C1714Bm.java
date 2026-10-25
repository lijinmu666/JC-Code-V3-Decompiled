package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Bm */
/* loaded from: classes.dex */
public final class C1714Bm extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1714Bm f7524zbb;

    /* renamed from: zbd */
    private int f7525zbd;

    /* renamed from: zbe */
    private String f7526zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f7527zbf = BuildConfig.f24315FLAVOR;

    static {
        C1714Bm c1714Bm = new C1714Bm();
        f7524zbb = c1714Bm;
        AbstractC3595dy.m11753YoKzxo(C1714Bm.class, c1714Bm);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7524zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C1714Bm();
        }
        AbstractC4905xm abstractC4905xm = null;
        if (i2 == 4) {
            return new C5033zm(abstractC4905xm);
        }
        if (i2 != 5) {
            return null;
        }
        return f7524zbb;
    }
}
