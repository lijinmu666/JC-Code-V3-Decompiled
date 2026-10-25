package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ef */
/* loaded from: classes.dex */
public final class C3639ef extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3639ef f13483zbb;

    /* renamed from: zbd */
    private int f13484zbd;

    /* renamed from: zbe */
    private int f13485zbe;

    /* renamed from: zbf */
    private AbstractC4981yx f13486zbf = AbstractC4981yx.f17599AZxh;

    /* renamed from: zbg */
    private String f13487zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private float f13488zbh;

    static {
        C3639ef c3639ef = new C3639ef();
        f13483zbb = c3639ef;
        AbstractC3595dy.m11753YoKzxo(C3639ef.class, c3639ef);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13483zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3639ef();
        }
        AbstractC2973Ue abstractC2973Ue = null;
        if (i2 == 4) {
            return new C3575df(abstractC2973Ue);
        }
        if (i2 != 5) {
            return null;
        }
        return f13483zbb;
    }
}
