package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Wt */
/* loaded from: classes.dex */
public final class C3123Wt extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3123Wt f11495zbb;

    /* renamed from: zbd */
    private int f11496zbd;

    /* renamed from: zbj */
    private C3258Yt f11502zbj;

    /* renamed from: zbk */
    private byte f11503zbk = 2;

    /* renamed from: zbe */
    private String f11497zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC4118ly f11498zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private InterfaceC4118ly f11499zbg = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbh */
    private InterfaceC4118ly f11500zbh = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbi */
    private InterfaceC4118ly f11501zbi = AbstractC3595dy.m11760wJVbdd();

    static {
        C3123Wt c3123Wt = new C3123Wt();
        f11495zbb = c3123Wt;
        AbstractC3595dy.m11753YoKzxo(C3123Wt.class, c3123Wt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f11503zbk);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11495zbb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbj", "zbg", "zbi"});
        }
        if (i2 == 3) {
            return new C3123Wt();
        }
        AbstractC2993Ut abstractC2993Ut = null;
        if (i2 == 4) {
            return new C3059Vt(abstractC2993Ut);
        }
        if (i2 == 5) {
            return f11495zbb;
        }
        this.f11503zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
