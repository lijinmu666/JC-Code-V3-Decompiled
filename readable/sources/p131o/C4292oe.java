package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.oe */
/* loaded from: classes.dex */
public final class C4292oe extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C4292oe f15775zbd;

    /* renamed from: zbe */
    private int f15776zbe;

    /* renamed from: zbg */
    private Object f15778zbg;

    /* renamed from: zbi */
    private int f15780zbi;

    /* renamed from: zbj */
    private int f15781zbj;

    /* renamed from: zbk */
    private int f15782zbk;

    /* renamed from: zbf */
    private int f15777zbf = 0;

    /* renamed from: zbl */
    private byte f15783zbl = 2;

    /* renamed from: zbh */
    private String f15779zbh = BuildConfig.f24315FLAVOR;

    static {
        C4292oe c4292oe = new C4292oe();
        f15775zbd = c4292oe;
        AbstractC3595dy.m11753YoKzxo(C4292oe.class, c4292oe);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f15783zbl);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f15775zbd, "\u0001\u0007\u0001\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0006=\u0000\u0007=\u0000\b6\u0000", new Object[]{"zbg", "zbf", "zbe", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i2 == 3) {
            return new C4292oe();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C4227ne(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f15775zbd;
        }
        this.f15783zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
