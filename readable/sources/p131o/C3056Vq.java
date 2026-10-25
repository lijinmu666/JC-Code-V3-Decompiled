package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Vq */
/* loaded from: classes.dex */
public final class C3056Vq extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3056Vq f11372zbb;

    /* renamed from: zbd */
    private int f11373zbd;

    /* renamed from: zbe */
    private AbstractC4981yx f11374zbe = AbstractC4981yx.f17599AZxh;

    /* renamed from: zbf */
    private String f11375zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private C3255Yq f11376zbg;

    static {
        C3056Vq c3056Vq = new C3056Vq();
        f11372zbb = c3056Vq;
        AbstractC3595dy.m11753YoKzxo(C3056Vq.class, c3056Vq);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11372zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဈ\u0001\u0002ည\u0000\u0004ဉ\u0002", new Object[]{"zbd", "zbf", "zbe", "zbg"});
        }
        if (i2 == 3) {
            return new C3056Vq();
        }
        AbstractC2917Tq abstractC2917Tq = null;
        if (i2 == 4) {
            return new C2989Uq(abstractC2917Tq);
        }
        if (i2 != 5) {
            return null;
        }
        return f11372zbb;
    }
}
