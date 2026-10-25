package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Ti */
/* loaded from: classes.dex */
public final class C2909Ti extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2909Ti f10737zbb;

    /* renamed from: zbd */
    private String f10738zbd = BuildConfig.f24315FLAVOR;

    /* renamed from: zbe */
    private InterfaceC4118ly f10739zbe = AbstractC3595dy.m11760wJVbdd();

    static {
        C2909Ti c2909Ti = new C2909Ti();
        f10737zbb = c2909Ti;
        AbstractC3595dy.m11753YoKzxo(C2909Ti.class, c2909Ti);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f10737zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zbd", "zbe", C3314Zi.class});
        }
        if (i2 == 3) {
            return new C2909Ti();
        }
        AbstractC2648Pi abstractC2648Pi = null;
        if (i2 == 4) {
            return new C2844Si(abstractC2648Pi);
        }
        if (i2 != 5) {
            return null;
        }
        return f10737zbb;
    }
}
