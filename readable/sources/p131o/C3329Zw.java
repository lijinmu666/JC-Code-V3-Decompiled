package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Zw */
/* loaded from: classes.dex */
public final class C3329Zw extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3329Zw f12248zbb;

    /* renamed from: zbd */
    private int f12249zbd;

    /* renamed from: zbe */
    private float f12250zbe;

    /* renamed from: zbf */
    private float f12251zbf;

    /* renamed from: zbg */
    private float f12252zbg;

    /* renamed from: zbl */
    private boolean f12257zbl;

    /* renamed from: zbm */
    private float f12258zbm;

    /* renamed from: zbn */
    private float f12259zbn;

    /* renamed from: zbo */
    private byte f12260zbo = 2;

    /* renamed from: zbh */
    private String f12253zbh = BuildConfig.f24315FLAVOR;

    /* renamed from: zbi */
    private int f12254zbi = -1;

    /* renamed from: zbj */
    private float f12255zbj = -1.0f;

    /* renamed from: zbk */
    private float f12256zbk = -1.0f;

    static {
        C3329Zw c3329Zw = new C3329Zw();
        f12248zbb = c3329Zw;
        AbstractC3595dy.m11753YoKzxo(C3329Zw.class, c3329Zw);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f12260zbo);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12248zbb, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0001\u0001ᔁ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဈ\u0003\u0005င\u0004\u0007ခ\u0005\bခ\u0006\tဇ\u0007\nခ\b\u000bခ\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn"});
        }
        if (i2 == 3) {
            return new C3329Zw();
        }
        AbstractC3195Xw abstractC3195Xw = null;
        if (i2 == 4) {
            return new C3262Yw(abstractC3195Xw);
        }
        if (i2 == 5) {
            return f12248zbb;
        }
        this.f12260zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
