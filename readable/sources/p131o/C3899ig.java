package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ig */
/* loaded from: classes.dex */
public final class C3899ig extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3899ig f14160zbb;

    /* renamed from: zbd */
    private int f14161zbd;

    /* renamed from: zbf */
    private float f14163zbf;

    /* renamed from: zbg */
    private float f14164zbg;

    /* renamed from: zbi */
    private float f14166zbi;

    /* renamed from: zbe */
    private String f14162zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbh */
    private float f14165zbh = 1.0f;

    /* renamed from: zbj */
    private InterfaceC4118ly f14167zbj = AbstractC3595dy.m11760wJVbdd();

    static {
        C3899ig c3899ig = new C3899ig();
        f14160zbb = c3899ig;
        AbstractC3595dy.m11753YoKzxo(C3899ig.class, c3899ig);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14160zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C3899ig();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C3835hg(abstractC2645Pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f14160zbb;
    }
}
