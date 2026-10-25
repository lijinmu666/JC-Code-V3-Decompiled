package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Rf */
/* loaded from: classes.dex */
public final class C2774Rf extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2774Rf f10443zbb;

    /* renamed from: zbd */
    private int f10444zbd;

    /* renamed from: zbe */
    private InterfaceC4118ly f10445zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private String f10446zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private float f10447zbg;

    static {
        C2774Rf c2774Rf = new C2774Rf();
        f10443zbb = c2774Rf;
        AbstractC3595dy.m11753YoKzxo(C2774Rf.class, c2774Rf);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10443zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000\u0003ခ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C2774Rf();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C2708Qf(abstractC2645Pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f10443zbb;
    }
}
