package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Xe */
/* loaded from: classes.dex */
public final class C3174Xe extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3174Xe f11634zbb;

    /* renamed from: zbd */
    private int f11635zbd;

    /* renamed from: zbe */
    private int f11636zbe;

    /* renamed from: zbf */
    private String f11637zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private float f11638zbg;

    /* renamed from: zbh */
    private float f11639zbh;

    static {
        C3174Xe c3174Xe = new C3174Xe();
        f11634zbb = c3174Xe;
        AbstractC3595dy.m11753YoKzxo(C3174Xe.class, c3174Xe);
    }

    /* renamed from: Ne */
    public static C3174Xe m10949Ne() {
        return f11634zbb;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11634zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zbd", "zbe", C3106We.f11475mjFkc, "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3174Xe();
        }
        AbstractC2973Ue abstractC2973Ue = null;
        if (i2 == 4) {
            return new C3039Ve(abstractC2973Ue);
        }
        if (i2 != 5) {
            return null;
        }
        return f11634zbb;
    }
}
