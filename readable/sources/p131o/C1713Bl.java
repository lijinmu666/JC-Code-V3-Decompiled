package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Bl */
/* loaded from: classes.dex */
public final class C1713Bl extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1713Bl f7517zbb;

    /* renamed from: zbd */
    private int f7518zbd;

    /* renamed from: zbe */
    private C4178mt f7519zbe;

    /* renamed from: zbf */
    private C1853Du f7520zbf;

    /* renamed from: zbg */
    private boolean f7521zbg;

    /* renamed from: zbi */
    private byte f7523zbi = 2;

    /* renamed from: zbh */
    private String f7522zbh = BuildConfig.f24315FLAVOR;

    static {
        C1713Bl c1713Bl = new C1713Bl();
        f7517zbb = c1713Bl;
        AbstractC3595dy.m11753YoKzxo(C1713Bl.class, c1713Bl);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f7523zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7517zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C1713Bl();
        }
        AbstractC4904xl abstractC4904xl = null;
        if (i2 == 4) {
            return new C5032zl(abstractC4904xl);
        }
        if (i2 == 5) {
            return f7517zbb;
        }
        this.f7523zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
