package p131o;

/* renamed from: o.br */
/* loaded from: classes.dex */
public final class C3459br extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3459br f13158zbb;

    /* renamed from: zbd */
    private int f13159zbd;

    /* renamed from: zbf */
    private Object f13161zbf;

    /* renamed from: zbg */
    private boolean f13162zbg;

    /* renamed from: zbi */
    private long f13164zbi;

    /* renamed from: zbm */
    private float f13168zbm;

    /* renamed from: zbn */
    private float f13169zbn;

    /* renamed from: zbo */
    private float f13170zbo;

    /* renamed from: zbe */
    private int f13160zbe = 0;

    /* renamed from: zbp */
    private byte f13171zbp = 2;

    /* renamed from: zbh */
    private InterfaceC4118ly f13163zbh = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbj */
    private boolean f13165zbj = true;

    /* renamed from: zbk */
    private InterfaceC3917iy f13166zbk = AbstractC3595dy.m11752VocHEe();

    /* renamed from: zbl */
    private float f13167zbl = 0.15f;

    static {
        C3459br c3459br = new C3459br();
        f13158zbb = c3459br;
        AbstractC3595dy.m11753YoKzxo(C3459br.class, c3459br);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13171zbp);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13158zbb, "\u0001\n\u0001\u0001\u0002\r\n\u0000\u0002\u0001\u0002м\u0000\u0003ဇ\u0000\u0004\u001b\u0005\u0013\u0006ခ\u0003\u0007ခ\u0004\bခ\u0005\u000bခ\u0006\fဂ\u0001\rဇ\u0002", new Object[]{"zbf", "zbe", "zbd", C5039zr.class, "zbg", "zbh", C2854Sq.class, "zbk", "zbl", "zbm", "zbn", "zbo", "zbi", "zbj"});
        }
        if (i2 == 3) {
            return new C3459br();
        }
        AbstractC3323Zq abstractC3323Zq = null;
        if (i2 == 4) {
            return new C3390ar(abstractC3323Zq);
        }
        if (i2 == 5) {
            return f13158zbb;
        }
        this.f13171zbp = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
