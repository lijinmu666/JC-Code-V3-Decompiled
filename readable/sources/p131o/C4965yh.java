package p131o;

/* renamed from: o.yh */
/* loaded from: classes.dex */
public final class C4965yh extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4965yh f17559zbb;

    /* renamed from: zbd */
    private int f17560zbd;

    /* renamed from: zbe */
    private float f17561zbe;

    /* renamed from: zbf */
    private float f17562zbf;

    /* renamed from: zbg */
    private float f17563zbg;

    /* renamed from: zbh */
    private float f17564zbh;

    /* renamed from: zbi */
    private C1709Bh f17565zbi;

    /* renamed from: zbj */
    private float f17566zbj;

    /* renamed from: zbk */
    private C3772gh f17567zbk;

    /* renamed from: zbl */
    private float f17568zbl;

    /* renamed from: zbm */
    private AbstractC4981yx f17569zbm;

    /* renamed from: zbn */
    private AbstractC4981yx f17570zbn;

    /* renamed from: zbo */
    private byte f17571zbo = 2;

    static {
        C4965yh c4965yh = new C4965yh();
        f17559zbb = c4965yh;
        AbstractC3595dy.m11753YoKzxo(C4965yh.class, c4965yh);
    }

    public C4965yh() {
        AbstractC4981yx abstractC4981yx = AbstractC4981yx.f17599AZxh;
        this.f17569zbm = abstractC4981yx;
        this.f17570zbn = abstractC4981yx;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f17571zbo);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17559zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ခ\u0003\u0005ခ\u0007\u0006ည\b\u0007ခ\u0005\bဉ\u0006\tᐉ\u0004\nည\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbl", "zbm", "zbj", "zbk", "zbi", "zbn"});
        }
        if (i2 == 3) {
            return new C4965yh();
        }
        AbstractC4832wh abstractC4832wh = null;
        if (i2 == 4) {
            return new C4900xh(abstractC4832wh);
        }
        if (i2 == 5) {
            return f17559zbb;
        }
        this.f17571zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
