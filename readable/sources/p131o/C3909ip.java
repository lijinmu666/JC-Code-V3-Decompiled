package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ip */
/* loaded from: classes.dex */
public final class C3909ip extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3909ip f14214zbb;

    /* renamed from: zbd */
    private int f14215zbd;

    /* renamed from: zbe */
    private String f14216zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC4118ly f14217zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private InterfaceC4118ly f14218zbg = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbh */
    private InterfaceC4118ly f14219zbh = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbi */
    private C4301ol f14220zbi;

    /* renamed from: zbj */
    private C2596Ot f14221zbj;

    static {
        C3909ip c3909ip = new C3909ip();
        f14214zbb = c3909ip;
        AbstractC3595dy.m11753YoKzxo(C3909ip.class, c3909ip);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14214zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဉ\u0001\u0004\u001a\u0005ဉ\u0002\u0006\u001a", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbj", "zbg"});
        }
        if (i2 == 3) {
            return new C3909ip();
        }
        AbstractC3649ep abstractC3649ep = null;
        if (i2 == 4) {
            return new C3782gp(abstractC3649ep);
        }
        if (i2 != 5) {
            return null;
        }
        return f14214zbb;
    }
}
