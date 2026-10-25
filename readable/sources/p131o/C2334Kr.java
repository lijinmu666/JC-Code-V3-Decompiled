package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.Kr */
/* loaded from: classes.dex */
public final class C2334Kr extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C2334Kr f9238zbb;

    /* renamed from: zbd */
    private int f9239zbd;

    /* renamed from: zbg */
    private C2265Jr f9242zbg;

    /* renamed from: zbh */
    private C3056Vq f9243zbh;

    /* renamed from: zbi */
    private C3056Vq f9244zbi;

    /* renamed from: zbj */
    private C4234nk f9245zbj;

    /* renamed from: zbm */
    private float f9248zbm;

    /* renamed from: zbp */
    private boolean f9251zbp;

    /* renamed from: zbq */
    private C1797Cz f9252zbq;

    /* renamed from: zbe */
    private String f9240zbe = BuildConfig.f24315FLAVOR;

    /* renamed from: zbf */
    private String f9241zbf = BuildConfig.f24315FLAVOR;

    /* renamed from: zbk */
    private String f9246zbk = "en";

    /* renamed from: zbl */
    private int f9247zbl = -1;

    /* renamed from: zbn */
    private InterfaceC4118ly f9249zbn = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbo */
    private InterfaceC4118ly f9250zbo = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbr */
    private int f9253zbr = -1;

    static {
        C2334Kr c2334Kr = new C2334Kr();
        f9238zbb = c2334Kr;
        AbstractC3595dy.m11753YoKzxo(C2334Kr.class, c2334Kr);
    }

    /* renamed from: CqaNbM */
    public static /* synthetic */ void m9280CqaNbM(C2334Kr c2334Kr, String str) {
        c2334Kr.f9239zbd |= 1;
        c2334Kr.f9240zbe = "PassThroughCoarseClassifier";
    }

    /* renamed from: OjSQV */
    public static C2124Hr m9282OjSQV() {
        return (C2124Hr) f9238zbb.m11764Ucbh();
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f9238zbb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002င\u0007\u0003ခ\b\u0004\u001a\u0005\u001a\u0006ဉ\u0002\bဇ\t\tဉ\n\nဉ\u0003\u000bဈ\u0006\fဉ\u0004\rင\u000b\u000eဉ\u0005\u000fဈ\u0001", new Object[]{"zbd", "zbe", "zbl", "zbm", "zbn", "zbo", "zbg", "zbp", "zbq", "zbh", "zbk", "zbi", "zbr", "zbj", "zbf"});
        }
        if (i2 == 3) {
            return new C2334Kr();
        }
        AbstractC2057Gr abstractC2057Gr = null;
        if (i2 == 4) {
            return new C2124Hr(abstractC2057Gr);
        }
        if (i2 != 5) {
            return null;
        }
        return f9238zbb;
    }
}
