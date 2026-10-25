package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Fq */
/* loaded from: classes.dex */
public final class C1989Fq extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1989Fq f8256zbb;

    /* renamed from: zbd */
    private int f8257zbd;

    /* renamed from: zbe */
    private int f8258zbe;

    /* renamed from: zbf */
    private float f8259zbf;

    /* renamed from: zbg */
    private String f8260zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private String f8261zbh = BuildConfig.f24315FLAVOR;

    static {
        C1989Fq c1989Fq = new C1989Fq();
        f8256zbb = c1989Fq;
        AbstractC3595dy.m11753YoKzxo(C1989Fq.class, c1989Fq);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8256zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C1989Fq();
        }
        AbstractC1849Dq abstractC1849Dq = null;
        if (i2 == 4) {
            return new C1918Eq(abstractC1849Dq);
        }
        if (i2 != 5) {
            return null;
        }
        return f8256zbb;
    }
}
