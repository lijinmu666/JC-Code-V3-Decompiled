package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.yt */
/* loaded from: classes.dex */
public final class C4977yt extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4977yt f17586zbb;

    /* renamed from: zbd */
    private String f17587zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private boolean f17588zbe;

    static {
        C4977yt c4977yt = new C4977yt();
        f17586zbb = c4977yt;
        AbstractC3595dy.m11753YoKzxo(C4977yt.class, c4977yt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17586zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"zbd", "zbe"});
        }
        if (i2 == 3) {
            return new C4977yt();
        }
        AbstractC4445qt abstractC4445qt = null;
        if (i2 == 4) {
            return new C4913xt(abstractC4445qt);
        }
        if (i2 != 5) {
            return null;
        }
        return f17586zbb;
    }
}
