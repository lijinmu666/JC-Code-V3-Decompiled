package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Kg */
/* loaded from: classes.dex */
public final class C2323Kg extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2323Kg f9217zbb;

    /* renamed from: zbd */
    private int f9218zbd;

    /* renamed from: zbf */
    private int f9220zbf;

    /* renamed from: zbe */
    private String f9219zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC3917iy f9221zbg = AbstractC3595dy.m11752VocHEe();

    /* renamed from: zbh */
    private String f9222zbh = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private InterfaceC4118ly f9223zbi = AbstractC3595dy.m11760wJVbdd();

    static {
        C2323Kg c2323Kg = new C2323Kg();
        f9217zbb = c2323Kg;
        AbstractC3595dy.m11753YoKzxo(C2323Kg.class, c2323Kg);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9217zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0001\u0003$\u0004ဈ\u0002\u0005\u001a", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C2323Kg();
        }
        AbstractC2179Ig abstractC2179Ig = null;
        if (i2 == 4) {
            return new C2252Jg(abstractC2179Ig);
        }
        if (i2 != 5) {
            return null;
        }
        return f9217zbb;
    }
}
