package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.re */
/* loaded from: classes.dex */
public final class C4495re extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4495re f16368zbb;

    /* renamed from: zbd */
    private int f16369zbd;

    /* renamed from: zbg */
    private byte f16372zbg = 2;

    /* renamed from: zbe */
    private String f16370zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private float f16371zbf = 1.0f;

    static {
        C4495re c4495re = new C4495re();
        f16368zbb = c4495re;
        AbstractC3595dy.m11753YoKzxo(C4495re.class, c4495re);
    }

    /* renamed from: CqaNbM */
    public final String m13391CqaNbM() {
        return this.f16370zbe;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f16372zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16368zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4495re();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C4427qe(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f16368zbb;
        }
        this.f16372zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    /* renamed from: OjSQV */
    public final float m13392OjSQV() {
        return this.f16371zbf;
    }
}
