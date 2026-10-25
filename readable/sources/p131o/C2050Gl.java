package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Gl */
/* loaded from: classes.dex */
public final class C2050Gl extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2050Gl f8437zbb;

    /* renamed from: zbd */
    private int f8438zbd;

    /* renamed from: zbh */
    private float f8442zbh;

    /* renamed from: zbi */
    private byte f8443zbi = 2;

    /* renamed from: zbe */
    private String f8439zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f8440zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC4118ly f8441zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C2050Gl c2050Gl = new C2050Gl();
        f8437zbb = c2050Gl;
        AbstractC3595dy.m11753YoKzxo(C2050Gl.class, c2050Gl);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8443zbi);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8437zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003Л\u0004ခ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", C4848ww.class, "zbh"});
        }
        if (i2 == 3) {
            return new C2050Gl();
        }
        AbstractC1780Cl abstractC1780Cl = null;
        if (i2 == 4) {
            return new C1912El(abstractC1780Cl);
        }
        if (i2 == 5) {
            return f8437zbb;
        }
        this.f8443zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
