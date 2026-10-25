package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Wf */
/* loaded from: classes.dex */
public final class C3107Wf extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3107Wf f11476zbb;

    /* renamed from: zbd */
    private int f11477zbd;

    /* renamed from: zbe */
    private String f11478zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC3917iy f11479zbf = AbstractC3595dy.m11752VocHEe();

    /* renamed from: zbg */
    private InterfaceC3917iy f11480zbg = AbstractC3595dy.m11752VocHEe();

    /* renamed from: zbh */
    private InterfaceC4118ly f11481zbh = AbstractC3595dy.m11760wJVbdd();

    static {
        C3107Wf c3107Wf = new C3107Wf();
        f11476zbb = c3107Wf;
        AbstractC3595dy.m11753YoKzxo(C3107Wf.class, c3107Wf);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f11476zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001ဈ\u0000\u0002$\u0003$\u0004\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i2 == 3) {
            return new C3107Wf();
        }
        AbstractC2645Pf abstractC2645Pf = null;
        if (i2 == 4) {
            return new C3040Vf(abstractC2645Pf);
        }
        if (i2 != 5) {
            return null;
        }
        return f11476zbb;
    }
}
