package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.vh */
/* loaded from: classes.dex */
public final class C4765vh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4765vh f17038zbb;

    /* renamed from: zbd */
    private int f17039zbd;

    /* renamed from: zbe */
    private long f17040zbe;

    /* renamed from: zbh */
    private int f17043zbh;

    /* renamed from: zbi */
    private int f17044zbi;

    /* renamed from: zbl */
    private C4230nh f17047zbl;

    /* renamed from: zbm */
    private AbstractC4981yx f17048zbm;

    /* renamed from: zbn */
    private C2114Hh f17049zbn;

    /* renamed from: zbo */
    private String f17050zbo;

    /* renamed from: zbp */
    private InterfaceC4118ly f17051zbp;

    /* renamed from: zbq */
    private InterfaceC4118ly f17052zbq;

    /* renamed from: zbr */
    private AbstractC4981yx f17053zbr;

    /* renamed from: zbs */
    private String f17054zbs;

    /* renamed from: zbt */
    private byte f17055zbt = 2;

    /* renamed from: zbf */
    private String f17041zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private String f17042zbg = BuildConfig.f24315FLAVOR;

    /* renamed from: zbj */
    private InterfaceC4118ly f17045zbj = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbk */
    private String f17046zbk = BuildConfig.f24315FLAVOR;

    static {
        C4765vh c4765vh = new C4765vh();
        f17038zbb = c4765vh;
        AbstractC3595dy.m11753YoKzxo(C4765vh.class, c4765vh);
    }

    public C4765vh() {
        AbstractC4981yx abstractC4981yx = AbstractC4981yx.f17599AZxh;
        this.f17048zbm = abstractC4981yx;
        this.f17050zbo = BuildConfig.f24315FLAVOR;
        this.f17051zbp = AbstractC3595dy.m11760wJVbdd();
        this.f17052zbq = AbstractC3595dy.m11760wJVbdd();
        this.f17053zbr = abstractC4981yx;
        this.f17054zbs = BuildConfig.f24315FLAVOR;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f17055zbt);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17038zbb, "\u0001\u000f\u0000\u0001\u0001\u001c\u000f\u0000\u0003\u0004\u0001ᔂ\u0000\u0002б\u0010ဈ\u0001\u0011ဈ\u0002\u0012င\u0003\u0013င\u0004\u0014\u001a\u0015ဈ\u0005\u0016ည\u0007\u0017ᐉ\b\u0018ᐉ\u0006\u0019ည\n\u001aဈ\t\u001bဈ\u000b\u001c\u001b", new Object[]{"zbd", "zbe", "zbp", C4696uh.class, "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbl", "zbr", "zbo", "zbs", "zbq", C4430qh.class});
        }
        if (i2 == 3) {
            return new C4765vh();
        }
        AbstractC4498rh abstractC4498rh = null;
        if (i2 == 4) {
            return new C4564sh(abstractC4498rh);
        }
        if (i2 == 5) {
            return f17038zbb;
        }
        this.f17055zbt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
