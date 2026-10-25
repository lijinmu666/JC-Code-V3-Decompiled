package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Pw */
/* loaded from: classes.dex */
public final class C2663Pw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2663Pw f10121zbb;

    /* renamed from: zbd */
    private int f10122zbd;

    /* renamed from: zbe */
    private int f10123zbe;

    /* renamed from: zbf */
    private String f10124zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC3917iy f10125zbg = AbstractC3595dy.m11752VocHEe();

    /* renamed from: zbh */
    private int f10126zbh;

    /* renamed from: zbi */
    private int f10127zbi;

    /* renamed from: zbj */
    private float f10128zbj;

    static {
        C2663Pw c2663Pw = new C2663Pw();
        f10121zbb = c2663Pw;
        AbstractC3595dy.m11753YoKzxo(C2663Pw.class, c2663Pw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10121zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0013\u0004င\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C2663Pw();
        }
        AbstractC2402Lw abstractC2402Lw = null;
        if (i2 == 4) {
            return new C2600Ow(abstractC2402Lw);
        }
        if (i2 != 5) {
            return null;
        }
        return f10121zbb;
    }
}
