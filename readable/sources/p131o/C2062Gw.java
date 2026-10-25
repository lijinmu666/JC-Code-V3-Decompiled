package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Gw */
/* loaded from: classes.dex */
public final class C2062Gw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2062Gw f8449zbb;

    /* renamed from: zbd */
    private int f8450zbd;

    /* renamed from: zbf */
    private int f8452zbf;

    /* renamed from: zbg */
    private int f8453zbg;

    /* renamed from: zbj */
    private C2197Iw f8456zbj;

    /* renamed from: zbl */
    private C4181mw f8458zbl;

    /* renamed from: zbm */
    private C3915iw f8459zbm;

    /* renamed from: zbo */
    private byte f8461zbo = 2;

    /* renamed from: zbe */
    private AbstractC4981yx f8451zbe = AbstractC4981yx.f17599AZxh;

    /* renamed from: zbh */
    private String f8454zbh = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private InterfaceC4118ly f8455zbi = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbk */
    private InterfaceC4118ly f8457zbk = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbn */
    private InterfaceC4118ly f8460zbn = AbstractC3595dy.m11760wJVbdd();

    static {
        C2062Gw c2062Gw = new C2062Gw();
        f8449zbb = c2062Gw;
        AbstractC3595dy.m11753YoKzxo(C2062Gw.class, c2062Gw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8461zbo);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8449zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0003\u0004\u0001ᔊ\u0000\u0002ဈ\u0003\u0003Л\u0004ဉ\u0004\u0005Л\u0006ဉ\u0005\u0007ဉ\u0006\bЛ\tင\u0001\nင\u0002", new Object[]{"zbd", "zbe", "zbh", "zbi", C3722fw.class, "zbj", "zbk", C1925Ew.class, "zbl", "zbm", "zbn", C1794Cw.class, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C2062Gw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C1997Fw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f8449zbb;
        }
        this.f8461zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
