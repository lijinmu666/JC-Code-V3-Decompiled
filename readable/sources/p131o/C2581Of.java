package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Of */
/* loaded from: classes.dex */
public final class C2581Of extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C2581Of f9968zbd;

    /* renamed from: zbe */
    private int f9969zbe;

    /* renamed from: zbg */
    private Object f9971zbg;

    /* renamed from: zbi */
    private Object f9973zbi;

    /* renamed from: zbl */
    private AbstractC4981yx f9976zbl;

    /* renamed from: zbm */
    private C1797Cz f9977zbm;

    /* renamed from: zbn */
    private int f9978zbn;

    /* renamed from: zbo */
    private int f9979zbo;

    /* renamed from: zbp */
    private boolean f9980zbp;

    /* renamed from: zbq */
    private int f9981zbq;

    /* renamed from: zbr */
    private AbstractC4981yx f9982zbr;

    /* renamed from: zbf */
    private int f9970zbf = 0;

    /* renamed from: zbh */
    private int f9972zbh = 0;

    /* renamed from: zbs */
    private byte f9983zbs = 2;

    /* renamed from: zbj */
    private String f9974zbj = "FaceAttributesClientBrainEmbedder";

    /* renamed from: zbk */
    private String f9975zbk = BuildConfig.f24315FLAVOR;

    static {
        C2581Of c2581Of = new C2581Of();
        f9968zbd = c2581Of;
        AbstractC3595dy.m11753YoKzxo(C2581Of.class, c2581Of);
    }

    public C2581Of() {
        AbstractC4981yx abstractC4981yx = AbstractC4981yx.f17599AZxh;
        this.f9976zbl = abstractC4981yx;
        this.f9980zbp = true;
        this.f9981zbq = 1;
        this.f9982zbr = abstractC4981yx;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f9983zbs);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9968zbd, "\u0004\r\u0002\u0001\u0002\u0010\r\u0000\u0000\u0001\u0002<\u0000\u0003;\u0000\u0004ဇ\u0006\u0005᠌\u0007\u0007м\u0001\b;\u0001\tဈ\u0000\nဈ\u0001\fင\u0004\rဉ\u0003\u000eည\b\u000fည\u0002\u0010င\u0005", new Object[]{"zbg", "zbf", "zbi", "zbh", "zbe", C2449Me.class, "zbp", "zbq", C2450Mf.f9591mjFkc, C3447bg.class, "zbj", "zbk", "zbn", "zbm", "zbr", "zbl", "zbo"});
        }
        if (i2 == 3) {
            return new C2581Of();
        }
        AbstractC2383Lf abstractC2383Lf = null;
        if (i2 == 4) {
            return new C2519Nf(abstractC2383Lf);
        }
        if (i2 == 5) {
            return f9968zbd;
        }
        this.f9983zbs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
