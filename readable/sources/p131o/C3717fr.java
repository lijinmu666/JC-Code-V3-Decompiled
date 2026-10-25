package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.fr */
/* loaded from: classes.dex */
public final class C3717fr extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3717fr f13626zbb;

    /* renamed from: zbd */
    private int f13627zbd;

    /* renamed from: zbe */
    private int f13628zbe;

    /* renamed from: zbf */
    private int f13629zbf;

    /* renamed from: zbg */
    private int f13630zbg;

    /* renamed from: zbh */
    private String f13631zbh = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private String f13632zbi = BuildConfig.f24315FLAVOR;

    static {
        C3717fr c3717fr = new C3717fr();
        f13626zbb = c3717fr;
        AbstractC3595dy.m11753YoKzxo(C3717fr.class, c3717fr);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13626zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C3717fr();
        }
        AbstractC3524cr abstractC3524cr = null;
        if (i2 == 4) {
            return new C3651er(abstractC3524cr);
        }
        if (i2 != 5) {
            return null;
        }
        return f13626zbb;
    }
}
