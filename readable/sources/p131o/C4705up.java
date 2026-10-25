package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.up */
/* loaded from: classes.dex */
public final class C4705up extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4705up f16886zbb;

    /* renamed from: zbd */
    private int f16887zbd;

    /* renamed from: zbe */
    private String f16888zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private float f16889zbf;

    static {
        C4705up c4705up = new C4705up();
        f16886zbb = c4705up;
        AbstractC3595dy.m11753YoKzxo(C4705up.class, c4705up);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16886zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C4705up();
        }
        AbstractC4438qp abstractC4438qp = null;
        if (i2 == 4) {
            return new C4573sp(abstractC4438qp);
        }
        if (i2 != 5) {
            return null;
        }
        return f16886zbb;
    }
}
