package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Rt */
/* loaded from: classes.dex */
public final class C2791Rt extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2791Rt f10486zbb;

    /* renamed from: zbd */
    private int f10487zbd;

    /* renamed from: zbh */
    private C2920Tt f10491zbh;

    /* renamed from: zbi */
    private byte f10492zbi = 2;

    /* renamed from: zbe */
    private String f10488zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f10489zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f10490zbg = BuildConfig.f24315FLAVOR;

    static {
        C2791Rt c2791Rt = new C2791Rt();
        f10486zbb = c2791Rt;
        AbstractC3595dy.m11753YoKzxo(C2791Rt.class, c2791Rt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f10492zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10486zbb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ᐉ\u0003Ϫဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new C2791Rt();
        }
        AbstractC2659Pt abstractC2659Pt = null;
        if (i2 == 4) {
            return new C2724Qt(abstractC2659Pt);
        }
        if (i2 == 5) {
            return f10486zbb;
        }
        this.f10492zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
