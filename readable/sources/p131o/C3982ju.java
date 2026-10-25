package p131o;

/* renamed from: o.ju */
/* loaded from: classes.dex */
public final class C3982ju extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3982ju f14390zbb;

    /* renamed from: zbd */
    private int f14391zbd;

    /* renamed from: zbg */
    private C2126Ht f14394zbg;

    /* renamed from: zbh */
    private byte f14395zbh = 2;

    /* renamed from: zbe */
    private String f14392zbe = "InOrderOutputStreamHandler";

    /* renamed from: zbf */
    private InterfaceC4118ly f14393zbf = AbstractC3595dy.m11760wJVbdd();

    static {
        C3982ju c3982ju = new C3982ju();
        f14390zbb = c3982ju;
        AbstractC3595dy.m11753YoKzxo(C3982ju.class, c3982ju);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f14395zbh);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14390zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3982ju();
        }
        AbstractC3527cu abstractC3527cu = null;
        if (i2 == 4) {
            return new C3913iu(abstractC3527cu);
        }
        if (i2 == 5) {
            return f14390zbb;
        }
        this.f14395zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
