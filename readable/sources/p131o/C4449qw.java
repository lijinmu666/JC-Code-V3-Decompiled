package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.qw */
/* loaded from: classes.dex */
public final class C4449qw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4449qw f16264zbb;

    /* renamed from: zbd */
    private int f16265zbd;

    /* renamed from: zbe */
    private C2386Li f16266zbe;

    /* renamed from: zbf */
    private String f16267zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private int f16268zbg;

    /* renamed from: zbh */
    private boolean f16269zbh;

    /* renamed from: zbi */
    private int f16270zbi;

    static {
        C4449qw c4449qw = new C4449qw();
        f16264zbb = c4449qw;
        AbstractC3595dy.m11753YoKzxo(C4449qw.class, c4449qw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16264zbb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဇ\u0003\u0005᠌\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", C2535Nv.f9828mjFkc});
        }
        if (i2 == 3) {
            return new C4449qw();
        }
        AbstractC2128Hu abstractC2128Hu = null;
        if (i2 == 4) {
            return new C4115lv(abstractC2128Hu);
        }
        if (i2 != 5) {
            return null;
        }
        return f16264zbb;
    }
}
