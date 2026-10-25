package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.bu */
/* loaded from: classes.dex */
public final class C3462bu extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3462bu f13172zbb;

    /* renamed from: zbd */
    private int f13173zbd;

    /* renamed from: zbh */
    private C2126Ht f13177zbh;

    /* renamed from: zbi */
    private byte f13178zbi = 2;

    /* renamed from: zbe */
    private String f13174zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC4118ly f13175zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private InterfaceC4118ly f13176zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C3462bu c3462bu = new C3462bu();
        f13172zbb = c3462bu;
        AbstractC3595dy.m11753YoKzxo(C3462bu.class, c3462bu);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13178zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13172zbb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0002\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001Ϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new C3462bu();
        }
        AbstractC3326Zt abstractC3326Zt = null;
        if (i2 == 4) {
            return new C3393au(abstractC3326Zt);
        }
        if (i2 == 5) {
            return f13172zbb;
        }
        this.f13178zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
