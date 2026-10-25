package p131o;

import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: o.Ie */
/* loaded from: classes.dex */
public final class C2177Ie extends AbstractC3330Zx implements InterfaceC2404Ly {

    /* renamed from: zbd */
    private static final C2177Ie f8763zbd;

    /* renamed from: zbe */
    private int f8764zbe;

    /* renamed from: zbf */
    private int f8765zbf;

    /* renamed from: zbg */
    private int f8766zbg;

    /* renamed from: zbh */
    private C4292oe f8767zbh;

    /* renamed from: zbj */
    private int f8769zbj;

    /* renamed from: zbk */
    private int f8770zbk;

    /* renamed from: zbm */
    private C4561se f8772zbm;

    /* renamed from: zbp */
    private long f8775zbp;

    /* renamed from: zbq */
    private byte f8776zbq = 2;

    /* renamed from: zbi */
    private String f8768zbi = BuildConfig.f24315FLAVOR;

    /* renamed from: zbl */
    private InterfaceC4118ly f8771zbl = AbstractC3595dy.m11760wJVbdd();

    /* renamed from: zbn */
    private String f8773zbn = BuildConfig.f24315FLAVOR;

    /* renamed from: zbo */
    private InterfaceC4118ly f8774zbo = AbstractC3595dy.m11760wJVbdd();

    static {
        C2177Ie c2177Ie = new C2177Ie();
        f8763zbd = c2177Ie;
        AbstractC3595dy.m11753YoKzxo(C2177Ie.class, c2177Ie);
    }

    /* renamed from: CqaNbM */
    public static C2177Ie m8795CqaNbM() {
        return f8763zbd;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f8776zbq);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f8763zbd, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0003\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007Л\bᐉ\u0006\tဈ\u0007\n\u001a\u000bဂ\b", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", C2043Ge.class, "zbm", "zbn", "zbo", "zbp"});
        }
        if (i2 == 3) {
            return new C2177Ie();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C2111He(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f8763zbd;
        }
        this.f8776zbq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    /* renamed from: xrEuO */
    public final List m8797xrEuO() {
        return this.f8771zbl;
    }
}
