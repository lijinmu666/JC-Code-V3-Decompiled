package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.nh */
/* loaded from: classes.dex */
public final class C4230nh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4230nh f15437zbb;

    /* renamed from: zbd */
    private int f15438zbd;

    /* renamed from: zbe */
    private double f15439zbe;

    /* renamed from: zbf */
    private double f15440zbf;

    /* renamed from: zbh */
    private double f15442zbh;

    /* renamed from: zbi */
    private boolean f15443zbi;

    /* renamed from: zbj */
    private double f15444zbj;

    /* renamed from: zbk */
    private double f15445zbk;

    /* renamed from: zbl */
    private byte f15446zbl = 2;

    /* renamed from: zbg */
    private String f15441zbg = BuildConfig.f24315FLAVOR;

    static {
        C4230nh c4230nh = new C4230nh();
        f15437zbb = c4230nh;
        AbstractC3595dy.m11753YoKzxo(C4230nh.class, c4230nh);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f15446zbl);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15437zbb, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001\u0004က\u0005\u0005က\u0006\u0006ဇ\u0004\u0007က\u0003\bဈ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbj", "zbk", "zbi", "zbh", "zbg"});
        }
        if (i2 == 3) {
            return new C4230nh();
        }
        AbstractC4033kh abstractC4033kh = null;
        if (i2 == 4) {
            return new C4100lh(abstractC4033kh);
        }
        if (i2 == 5) {
            return f15437zbb;
        }
        this.f15446zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
