package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ml */
/* loaded from: classes.dex */
public final class C4170ml extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4170ml f15248zbb;

    /* renamed from: zbd */
    private int f15249zbd;

    /* renamed from: zbe */
    private String f15250zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f15251zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f15252zbg = BuildConfig.f24315FLAVOR;

    static {
        C4170ml c4170ml = new C4170ml();
        f15248zbb = c4170ml;
        AbstractC3595dy.m11753YoKzxo(C4170ml.class, c4170ml);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15248zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4170ml();
        }
        AbstractC3778gl abstractC3778gl = null;
        if (i2 == 4) {
            return new C4040kl(abstractC3778gl);
        }
        if (i2 != 5) {
            return null;
        }
        return f15248zbb;
    }
}
