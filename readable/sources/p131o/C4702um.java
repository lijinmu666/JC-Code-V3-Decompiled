package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.um */
/* loaded from: classes.dex */
public final class C4702um extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4702um f16878zbb;

    /* renamed from: zbd */
    private int f16879zbd;

    /* renamed from: zbe */
    private boolean f16880zbe;

    /* renamed from: zbf */
    private String f16881zbf = BuildConfig.f24315FLAVOR;

    static {
        C4702um c4702um = new C4702um();
        f16878zbb = c4702um;
        AbstractC3595dy.m11753YoKzxo(C4702um.class, c4702um);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16878zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4702um();
        }
        AbstractC4435qm abstractC4435qm = null;
        if (i2 == 4) {
            return new C4570sm(abstractC4435qm);
        }
        if (i2 != 5) {
            return null;
        }
        return f16878zbb;
    }
}
