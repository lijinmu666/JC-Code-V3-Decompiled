package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Af */
/* loaded from: classes.dex */
public final class C1640Af extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1640Af f7386zbb;

    /* renamed from: zbd */
    private int f7387zbd;

    /* renamed from: zbe */
    private InterfaceC4118ly f7388zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private String f7389zbf = BuildConfig.f24315FLAVOR;

    static {
        C1640Af c1640Af = new C1640Af();
        f7386zbb = c1640Af;
        AbstractC3595dy.m11753YoKzxo(C1640Af.class, c1640Af);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f7386zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zbd", "zbe", C2712Qi.class, "zbf"});
        }
        if (i2 == 3) {
            return new C1640Af();
        }
        AbstractC4762ve abstractC4762ve = null;
        if (i2 == 4) {
            return new C3241Ye(abstractC4762ve);
        }
        if (i2 != 5) {
            return null;
        }
        return f7386zbb;
    }
}
