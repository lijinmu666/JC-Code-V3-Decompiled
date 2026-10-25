package p131o;

/* renamed from: o.hu */
/* loaded from: classes.dex */
public final class C3849hu extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3849hu f14071zbb;

    /* renamed from: zbd */
    private int f14072zbd;

    /* renamed from: zbf */
    private C2126Ht f14074zbf;

    /* renamed from: zbg */
    private byte f14075zbg = 2;

    /* renamed from: zbe */
    private String f14073zbe = "DefaultInputStreamHandler";

    static {
        C3849hu c3849hu = new C3849hu();
        f14071zbb = c3849hu;
        AbstractC3595dy.m11753YoKzxo(C3849hu.class, c3849hu);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f14075zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14071zbb, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i2 == 3) {
            return new C3849hu();
        }
        AbstractC3527cu abstractC3527cu = null;
        if (i2 == 4) {
            return new C3591du(abstractC3527cu);
        }
        if (i2 == 5) {
            return f14071zbb;
        }
        this.f14075zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
