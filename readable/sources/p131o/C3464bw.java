package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.bw */
/* loaded from: classes.dex */
public final class C3464bw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3464bw f13179zbb;

    /* renamed from: zbd */
    private int f13180zbd;

    /* renamed from: zbe */
    private AbstractC4981yx f13181zbe;

    /* renamed from: zbf */
    private AbstractC4981yx f13182zbf;

    /* renamed from: zbg */
    private AbstractC4981yx f13183zbg;

    /* renamed from: zbh */
    private C2271Jv f13184zbh;

    /* renamed from: zbi */
    private String f13185zbi;

    /* renamed from: zbj */
    private byte f13186zbj = 2;

    static {
        C3464bw c3464bw = new C3464bw();
        f13179zbb = c3464bw;
        AbstractC3595dy.m11753YoKzxo(C3464bw.class, c3464bw);
    }

    public C3464bw() {
        AbstractC4981yx abstractC4981yx = AbstractC4981yx.f17599AZxh;
        this.f13181zbe = abstractC4981yx;
        this.f13182zbf = abstractC4981yx;
        this.f13183zbg = abstractC4981yx;
        this.f13185zbi = BuildConfig.f24315FLAVOR;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13186zbj);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13179zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0002\u0001ᔊ\u0000\u0002ည\u0001\u0003ည\u0002\u0004ᐉ\u0003\u0005ဈ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C3464bw();
        }
        AbstractC2129Hv abstractC2129Hv = null;
        if (i2 == 4) {
            return new C3396aw(abstractC2129Hv);
        }
        if (i2 == 5) {
            return f13179zbb;
        }
        this.f13186zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
