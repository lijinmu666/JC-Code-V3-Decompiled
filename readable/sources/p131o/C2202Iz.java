package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Iz */
/* loaded from: classes.dex */
public final class C2202Iz extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2202Iz f8821zbb;

    /* renamed from: zbd */
    private int f8822zbd;

    /* renamed from: zbe */
    private String f8823zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f8824zbf = BuildConfig.f24315FLAVOR;

    static {
        C2202Iz c2202Iz = new C2202Iz();
        f8821zbb = c2202Iz;
        AbstractC3595dy.m11753YoKzxo(C2202Iz.class, c2202Iz);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8821zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2202Iz();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2133Hz(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f8821zbb;
    }
}
