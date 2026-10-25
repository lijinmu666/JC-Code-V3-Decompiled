package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.rp */
/* loaded from: classes.dex */
public final class C4507rp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4507rp f16390zbb;

    /* renamed from: zbd */
    private int f16391zbd;

    /* renamed from: zbe */
    private String f16392zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC4118ly f16393zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private boolean f16394zbg;

    static {
        C4507rp c4507rp = new C4507rp();
        f16390zbb = c4507rp;
        AbstractC3595dy.m11753YoKzxo(C4507rp.class, c4507rp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16390zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001a\u0003ဇ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4507rp();
        }
        AbstractC4045kp abstractC4045kp = null;
        if (i2 == 4) {
            return new C4372pp(abstractC4045kp);
        }
        if (i2 != 5) {
            return null;
        }
        return f16390zbb;
    }
}
