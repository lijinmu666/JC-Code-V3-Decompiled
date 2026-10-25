package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Sm */
/* loaded from: classes.dex */
public final class C2849Sm extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2849Sm f10577zbb;

    /* renamed from: zbd */
    private int f10578zbd;

    /* renamed from: zbe */
    private boolean f10579zbe;

    /* renamed from: zbf */
    private String f10580zbf = BuildConfig.f24315FLAVOR;

    static {
        C2849Sm c2849Sm = new C2849Sm();
        f10577zbb = c2849Sm;
        AbstractC3595dy.m11753YoKzxo(C2849Sm.class, c2849Sm);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10577zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2849Sm();
        }
        AbstractC2589Om abstractC2589Om = null;
        if (i2 == 4) {
            return new C2716Qm(abstractC2589Om);
        }
        if (i2 != 5) {
            return null;
        }
        return f10577zbb;
    }
}
