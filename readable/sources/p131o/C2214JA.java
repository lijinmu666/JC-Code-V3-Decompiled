package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.JA */
/* loaded from: classes.dex */
public final class C2214JA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2214JA f8885zbb;

    /* renamed from: zbd */
    private int f8886zbd;

    /* renamed from: zbe */
    private String f8887zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f8888zbf = BuildConfig.f24315FLAVOR;

    static {
        C2214JA c2214ja = new C2214JA();
        f8885zbb = c2214ja;
        AbstractC3595dy.m11753YoKzxo(C2214JA.class, c2214ja);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8885zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2214JA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2145IA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f8885zbb;
    }
}
