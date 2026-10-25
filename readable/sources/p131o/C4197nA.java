package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.nA */
/* loaded from: classes.dex */
public final class C4197nA extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4197nA f15351zbb;

    /* renamed from: zbd */
    private int f15352zbd;

    /* renamed from: zbe */
    private boolean f15353zbe;

    /* renamed from: zbf */
    private int f15354zbf;

    /* renamed from: zbh */
    private int f15356zbh;

    /* renamed from: zbi */
    private int f15357zbi;

    /* renamed from: zbj */
    private int f15358zbj;

    /* renamed from: zbk */
    private int f15359zbk;

    /* renamed from: zbg */
    private boolean f15355zbg = true;

    /* renamed from: zbl */
    private String f15360zbl = BuildConfig.f24315FLAVOR;

    /* renamed from: zbm */
    private String f15361zbm = BuildConfig.f24315FLAVOR;

    static {
        C4197nA c4197nA = new C4197nA();
        f15351zbb = c4197nA;
        AbstractC3595dy.m11753YoKzxo(C4197nA.class, c4197nA);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            InterfaceC3855hy interfaceC3855hy = C4328pA.f15910mjFkc;
            InterfaceC3855hy interfaceC3855hy2 = C4067lA.f14676mjFkc;
            InterfaceC3855hy interfaceC3855hy3 = C4262oA.f15510mjFkc;
            return AbstractC3595dy.m11750ETF(f15351zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zbd", "zbe", "zbf", interfaceC3855hy, "zbg", "zbh", interfaceC3855hy2, "zbi", interfaceC3855hy3, "zbj", interfaceC3855hy3, "zbk", interfaceC3855hy3, "zbl", "zbm"});
        }
        if (i2 == 3) {
            return new C4197nA();
        }
        AbstractC4983yz abstractC4983yz = null;
        if (i2 == 4) {
            return new C4131mA(abstractC4983yz);
        }
        if (i2 != 5) {
            return null;
        }
        return f15351zbb;
    }
}
