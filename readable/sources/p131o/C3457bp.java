package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.bp */
/* loaded from: classes.dex */
public final class C3457bp extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3457bp f13150zbb;

    /* renamed from: zbd */
    private int f13151zbd;

    /* renamed from: zbf */
    private int f13153zbf;

    /* renamed from: zbg */
    private int f13154zbg;

    /* renamed from: zbi */
    private float f13156zbi;

    /* renamed from: zbe */
    private InterfaceC4118ly f13152zbe = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbh */
    private String f13155zbh = BuildConfig.f24315FLAVOR;

    static {
        C3457bp c3457bp = new C3457bp();
        f13150zbb = c3457bp;
        AbstractC3595dy.m11753YoKzxo(C3457bp.class, c3457bp);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13150zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001c\u0002င\u0000\u0003င\u0001\u0004ဈ\u0002\u0005ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i2 == 3) {
            return new C3457bp();
        }
        AbstractC3185Xo abstractC3185Xo = null;
        if (i2 == 4) {
            return new C3321Zo(abstractC3185Xo);
        }
        if (i2 != 5) {
            return null;
        }
        return f13150zbb;
    }
}
