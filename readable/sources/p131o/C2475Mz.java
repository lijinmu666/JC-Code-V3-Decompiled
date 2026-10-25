package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Mz */
/* loaded from: classes.dex */
public final class C2475Mz extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2475Mz f9625zbb;

    /* renamed from: zbd */
    private int f9626zbd;

    /* renamed from: zbe */
    private String f9627zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f9628zbf = BuildConfig.f24315FLAVOR;

    static {
        C2475Mz c2475Mz = new C2475Mz();
        f9625zbb = c2475Mz;
        AbstractC3595dy.m11753YoKzxo(C2475Mz.class, c2475Mz);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9625zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2475Mz();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C2406Lz(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f9625zbb;
    }
}
