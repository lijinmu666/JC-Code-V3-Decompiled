package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.lj */
/* loaded from: classes.dex */
public final class C4102lj extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4102lj f14804zbb;

    /* renamed from: zbd */
    private int f14805zbd;

    /* renamed from: zbe */
    private int f14806zbe;

    /* renamed from: zbf */
    private int f14807zbf;

    /* renamed from: zbg */
    private String f14808zbg = BuildConfig.f24315FLAVOR;

    static {
        C4102lj c4102lj = new C4102lj();
        f14804zbb = c4102lj;
        AbstractC3595dy.m11753YoKzxo(C4102lj.class, c4102lj);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14804zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004Ȉ", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4102lj();
        }
        AbstractC3968jj abstractC3968jj = null;
        if (i2 == 4) {
            return new C4038kj(abstractC3968jj);
        }
        if (i2 != 5) {
            return null;
        }
        return f14804zbb;
    }
}
