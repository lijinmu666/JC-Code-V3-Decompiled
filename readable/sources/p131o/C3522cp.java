package p131o;

import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: o.cp */
/* loaded from: classes.dex */
public final class C3522cp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3522cp f13255zbb;

    /* renamed from: zbd */
    private int f13256zbd;

    /* renamed from: zbe */
    private int f13257zbe;

    /* renamed from: zbf */
    private String f13258zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbg */
    private InterfaceC4118ly f13259zbg = AbstractC3595dy.m11760wJVbdd();

    static {
        C3522cp c3522cp = new C3522cp();
        f13255zbb = c3522cp;
        AbstractC3595dy.m11753YoKzxo(C3522cp.class, c3522cp);
    }

    /* renamed from: CqaNbM */
    public static C3522cp m11620CqaNbM(byte[] bArr, C2340Kx c2340Kx) {
        return (C3522cp) AbstractC3595dy.m11759vI(f13255zbb, bArr, c2340Kx);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13255zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", C1640Af.class});
        }
        if (i2 == 3) {
            return new C3522cp();
        }
        AbstractC3252Yo abstractC3252Yo = null;
        if (i2 == 4) {
            return new C3387ap(abstractC3252Yo);
        }
        if (i2 != 5) {
            return null;
        }
        return f13255zbb;
    }

    /* renamed from: KLMXS */
    public final List m11622KLMXS() {
        return this.f13259zbg;
    }

    /* renamed from: OjSQV */
    public final int m11623OjSQV() {
        return this.f13257zbe;
    }

    /* renamed from: xrEuO */
    public final String m11624xrEuO() {
        return this.f13258zbf;
    }
}
