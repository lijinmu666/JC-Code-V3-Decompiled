package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Li */
/* loaded from: classes.dex */
public final class C2386Li extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2386Li f9470zbb;

    /* renamed from: zbd */
    private int f9471zbd;

    /* renamed from: zbe */
    private String f9472zbe = "visionkit-pa.googleapis.com";

    /* renamed from: zbf */
    private String f9473zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC4118ly f9474zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C2386Li c2386Li = new C2386Li();
        f9470zbb = c2386Li;
        AbstractC3595dy.m11753YoKzxo(C2386Li.class, c2386Li);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9470zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", C2325Ki.class});
        }
        if (i2 == 3) {
            return new C2386Li();
        }
        AbstractC2115Hi abstractC2115Hi = null;
        if (i2 == 4) {
            return new C2181Ii(abstractC2115Hi);
        }
        if (i2 != 5) {
            return null;
        }
        return f9470zbb;
    }
}
