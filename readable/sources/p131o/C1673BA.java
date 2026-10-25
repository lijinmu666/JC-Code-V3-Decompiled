package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.BA */
/* loaded from: classes.dex */
public final class C1673BA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1673BA f7448zbb;

    /* renamed from: zbd */
    private int f7449zbd;

    /* renamed from: zbe */
    private String f7450zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private C2214JA f7451zbf;

    static {
        C1673BA c1673ba = new C1673BA();
        f7448zbb = c1673ba;
        AbstractC3595dy.m11753YoKzxo(C1673BA.class, c1673ba);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7448zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C1673BA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C1608AA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f7448zbb;
    }
}
