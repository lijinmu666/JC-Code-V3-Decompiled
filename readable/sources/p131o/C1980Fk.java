package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Fk */
/* loaded from: classes.dex */
public final class C1980Fk extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C1980Fk f8244zbb;

    /* renamed from: zbd */
    private int f8245zbd;

    /* renamed from: zbe */
    private String f8246zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private InterfaceC4118ly f8247zbf = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbg */
    private InterfaceC4118ly f8248zbg = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbh */
    private long f8249zbh;

    static {
        C1980Fk c1980Fk = new C1980Fk();
        f8244zbb = c1980Fk;
        AbstractC3595dy.m11753YoKzxo(C1980Fk.class, c1980Fk);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8244zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001a\u0003\u001b\u0004ဂ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg", C2388Lk.class, "zbh"});
        }
        if (i2 == 3) {
            return new C1980Fk();
        }
        AbstractC5031zk abstractC5031zk = null;
        if (i2 == 4) {
            return new C1843Dk(abstractC5031zk);
        }
        if (i2 != 5) {
            return null;
        }
        return f8244zbb;
    }
}
