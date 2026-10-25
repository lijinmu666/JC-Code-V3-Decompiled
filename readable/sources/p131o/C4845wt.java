package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.wt */
/* loaded from: classes.dex */
public final class C4845wt extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4845wt f17268zbb;

    /* renamed from: zbd */
    private int f17269zbd;

    /* renamed from: zbg */
    private C2126Ht f17272zbg;

    /* renamed from: zbh */
    private byte f17273zbh = 2;

    /* renamed from: zbe */
    private String f17270zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f17271zbf = BuildConfig.f24315FLAVOR;

    static {
        C4845wt c4845wt = new C4845wt();
        f17268zbb = c4845wt;
        AbstractC3595dy.m11753YoKzxo(C4845wt.class, c4845wt);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f17273zbh);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17268zbb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ȉ\u0002Ȉ\u0003ᐉ\u0000", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C4845wt();
        }
        AbstractC4445qt abstractC4445qt = null;
        if (i2 == 4) {
            return new C4778vt(abstractC4445qt);
        }
        if (i2 == 5) {
            return f17268zbb;
        }
        this.f17273zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
