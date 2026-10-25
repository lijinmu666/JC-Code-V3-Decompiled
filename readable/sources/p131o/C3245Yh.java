package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Yh */
/* loaded from: classes.dex */
public final class C3245Yh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3245Yh f11890zbb;

    /* renamed from: zbd */
    private String f11891zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private String f11892zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private float f11893zbf;

    static {
        C3245Yh c3245Yh = new C3245Yh();
        f11890zbb = c3245Yh;
        AbstractC3595dy.m11753YoKzxo(C3245Yh.class, c3245Yh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11890zbb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3245Yh();
        }
        AbstractC2180Ih abstractC2180Ih = null;
        if (i2 == 4) {
            return new C3178Xh(abstractC2180Ih);
        }
        if (i2 != 5) {
            return null;
        }
        return f11890zbb;
    }
}
