package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Rj */
/* loaded from: classes.dex */
public final class C2778Rj extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2778Rj f10454zbb;

    /* renamed from: zbe */
    private Object f10456zbe;

    /* renamed from: zbd */
    private int f10455zbd = 0;

    /* renamed from: zbf */
    private String f10457zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f10458zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private String f10459zbh = BuildConfig.f24315FLAVOR;

    static {
        C2778Rj c2778Rj = new C2778Rj();
        f10454zbb = c2778Rj;
        AbstractC3595dy.m11753YoKzxo(C2778Rj.class, c2778Rj);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10454zbb, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003=\u0000\u0004Ȉ\u0005Ȉ", new Object[]{"zbe", "zbd", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C2778Rj();
        }
        AbstractC2649Pj abstractC2649Pj = null;
        if (i2 == 4) {
            return new C2713Qj(abstractC2649Pj);
        }
        if (i2 != 5) {
            return null;
        }
        return f10454zbb;
    }
}
