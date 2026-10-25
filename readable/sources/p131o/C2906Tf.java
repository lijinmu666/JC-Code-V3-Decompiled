package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Tf */
/* loaded from: classes.dex */
public final class C2906Tf extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2906Tf f10718zbb;

    /* renamed from: zbd */
    private int f10719zbd;

    /* renamed from: zbe */
    private InterfaceC4118ly f10720zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbf */
    private String f10721zbf = BuildConfig.f24315FLAVOR;

    static {
        C2906Tf c2906Tf = new C2906Tf();
        f10718zbb = c2906Tf;
        AbstractC3595dy.m11753YoKzxo(C2906Tf.class, c2906Tf);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10718zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C2906Tf();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C2841Sf(abstractC2645Pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f10718zbb;
    }
}
