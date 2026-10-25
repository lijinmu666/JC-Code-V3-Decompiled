package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Lq */
/* loaded from: classes.dex */
public final class C2395Lq extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2395Lq f9483zbb;

    /* renamed from: zbd */
    private int f9484zbd;

    /* renamed from: zbe */
    private String f9485zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private float f9486zbf;

    static {
        C2395Lq c2395Lq = new C2395Lq();
        f9483zbb = c2395Lq;
        AbstractC3595dy.m11753YoKzxo(C2395Lq.class, c2395Lq);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9483zbb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2395Lq();
        }
        AbstractC2264Jq abstractC2264Jq = null;
        if (i2 == 4) {
            return new C2333Kq(abstractC2264Jq);
        }
        if (i2 != 5) {
            return null;
        }
        return f9483zbb;
    }
}
