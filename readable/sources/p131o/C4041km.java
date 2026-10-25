package p131o;

/* renamed from: o.km */
/* loaded from: classes.dex */
public final class C4041km extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4041km f14594zbb;

    /* renamed from: zbd */
    private int f14595zbd;

    /* renamed from: zbf */
    private Object f14597zbf;

    /* renamed from: zbg */
    private C2717Qn f14598zbg;

    /* renamed from: zbh */
    private boolean f14599zbh;

    /* renamed from: zbi */
    private C3523cq f14600zbi;

    /* renamed from: zbj */
    private C1784Cp f14601zbj;

    /* renamed from: zbk */
    private C4042kn f14602zbk;

    /* renamed from: zbl */
    private int f14603zbl;

    /* renamed from: zbe */
    private int f14596zbe = 0;

    /* renamed from: zbm */
    private byte f14604zbm = 2;

    static {
        C4041km c4041km = new C4041km();
        f14594zbb = c4041km;
        AbstractC3595dy.m11753YoKzxo(C4041km.class, c4041km);
    }

    /* renamed from: KLMXS */
    public static /* synthetic */ void m12599KLMXS(C4041km c4041km, C2717Qn c2717Qn) {
        c2717Qn.getClass();
        c4041km.f14598zbg = c2717Qn;
        c4041km.f14595zbd |= 1;
    }

    /* renamed from: Ne */
    public static C3646em m12600Ne() {
        return (C3646em) f14594zbb.m11764Ucbh();
    }

    /* renamed from: xrEuO */
    public static /* synthetic */ void m12601xrEuO(C4041km c4041km, C1784Cp c1784Cp) {
        c1784Cp.getClass();
        c4041km.f14601zbj = c1784Cp;
        c4041km.f14595zbd |= 8;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f14604zbm);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f14594zbb, "\u0001\b\u0001\u0001\u0001\b\b\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဉ\u0002\u0005:\u0000\u0006:\u0000\u0007ဉ\u0004\bင\u0005", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbj", "zbi", "zbk", "zbl"});
        }
        if (i2 == 3) {
            return new C4041km();
        }
        AbstractC3453bm abstractC3453bm = null;
        if (i2 == 4) {
            return new C3646em(abstractC3453bm);
        }
        if (i2 == 5) {
            return f14594zbb;
        }
        this.f14604zbm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    /* renamed from: OjSQV */
    public final int m12602OjSQV() {
        return this.f14603zbl;
    }

    /* renamed from: cMLeY */
    public final boolean m12603cMLeY() {
        if (this.f14596zbe == 5) {
            return ((Boolean) this.f14597zbf).booleanValue();
        }
        return false;
    }

    /* renamed from: rWxwaT */
    public final boolean m12604rWxwaT() {
        return (this.f14595zbd & 32) != 0;
    }

    /* renamed from: zvd */
    public final boolean m12605zvd() {
        if (this.f14596zbe == 6) {
            return ((Boolean) this.f14597zbf).booleanValue();
        }
        return false;
    }
}
