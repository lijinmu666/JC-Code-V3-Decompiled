package p131o;

/* renamed from: o.Zk */
/* loaded from: classes.dex */
public final class C3316Zk extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3316Zk f12203zbb;

    /* renamed from: zbe */
    private Object f12205zbe;

    /* renamed from: zbd */
    private int f12204zbd = 0;

    /* renamed from: zbg */
    private byte f12207zbg = 2;

    /* renamed from: zbf */
    private InterfaceC4118ly f12206zbf = AbstractC3595dy.m11760wJVbdd();

    static {
        C3316Zk c3316Zk = new C3316Zk();
        f12203zbb = c3316Zk;
        AbstractC3595dy.m11753YoKzxo(C3316Zk.class, c3316Zk);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f12207zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f12203zbb, "\u0004\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0001\u0001:\u0000\u0003Л", new Object[]{"zbe", "zbd", "zbf", C2581Of.class});
        }
        if (i2 == 3) {
            return new C3316Zk();
        }
        AbstractC3047Vk abstractC3047Vk = null;
        if (i2 == 4) {
            return new C3181Xk(abstractC3047Vk);
        }
        if (i2 == 5) {
            return f12203zbb;
        }
        this.f12207zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
