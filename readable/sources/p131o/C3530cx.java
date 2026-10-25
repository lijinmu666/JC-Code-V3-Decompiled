package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.cx */
/* loaded from: classes.dex */
public final class C3530cx extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3530cx f13267zbb;

    /* renamed from: zbd */
    private int f13268zbd;

    /* renamed from: zbf */
    private float f13270zbf;

    /* renamed from: zbe */
    private String f13269zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private int f13271zbg = 1;

    static {
        C3530cx c3530cx = new C3530cx();
        f13267zbb = c3530cx;
        AbstractC3595dy.m11753YoKzxo(C3530cx.class, c3530cx);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13267zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003င\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3530cx();
        }
        AbstractC3398ax abstractC3398ax = null;
        if (i2 == 4) {
            return new C3465bx(abstractC3398ax);
        }
        if (i2 != 5) {
            return null;
        }
        return f13267zbb;
    }
}
