package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.kx */
/* loaded from: classes.dex */
public final class C4053kx extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4053kx f14650zbb;

    /* renamed from: zbd */
    private String f14651zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private AbstractC4981yx f14652zbe = AbstractC4981yx.f17599AZxh;

    static {
        C4053kx c4053kx = new C4053kx();
        f14650zbb = c4053kx;
        AbstractC3595dy.m11753YoKzxo(C4053kx.class, c4053kx);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C2926Ty(f14650zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C4053kx();
        }
        AbstractC3854hx abstractC3854hx = null;
        if (i2 == 4) {
            return new C3916ix(abstractC3854hx);
        }
        if (i2 != 5) {
            return null;
        }
        return f14650zbb;
    }
}
