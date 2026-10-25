package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Bi */
/* loaded from: classes.dex */
public final class C1710Bi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1710Bi f7513zbb;

    /* renamed from: zbd */
    private int f7514zbd;

    /* renamed from: zbe */
    private C3056Vq f7515zbe;

    /* renamed from: zbf */
    private String f7516zbf = BuildConfig.f24315FLAVOR;

    static {
        C1710Bi c1710Bi = new C1710Bi();
        f7513zbb = c1710Bi;
        AbstractC3595dy.m11753YoKzxo(C1710Bi.class, c1710Bi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7513zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C1710Bi();
        }
        AbstractC5029zi abstractC5029zi = null;
        if (i2 == 4) {
            return new C1643Ai(abstractC5029zi);
        }
        if (i2 != 5) {
            return null;
        }
        return f7513zbb;
    }
}
