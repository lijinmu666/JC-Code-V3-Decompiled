package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.rf */
/* loaded from: classes.dex */
public final class C4496rf extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4496rf f16373zbb;

    /* renamed from: zbd */
    private int f16374zbd;

    /* renamed from: zbe */
    private int f16375zbe;

    /* renamed from: zbf */
    private String f16376zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private float f16377zbg;

    /* renamed from: zbh */
    private float f16378zbh;

    static {
        C4496rf c4496rf = new C4496rf();
        f16373zbb = c4496rf;
        AbstractC3595dy.m11753YoKzxo(C4496rf.class, c4496rf);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16373zbb, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005᠌\u0000", new Object[]{"zbd", "zbf", "zbg", "zbh", "zbe", C1906Ef.f8030mjFkc});
        }
        if (i2 == 3) {
            return new C4496rf();
        }
        AbstractC4362pf abstractC4362pf = null;
        if (i2 == 4) {
            return new C4428qf(abstractC4362pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f16373zbb;
    }
}
