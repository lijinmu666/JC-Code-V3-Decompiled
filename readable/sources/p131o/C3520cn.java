package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.cn */
/* loaded from: classes.dex */
public final class C3520cn extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3520cn f13250zbb;

    /* renamed from: zbd */
    private int f13251zbd;

    /* renamed from: zbe */
    private int f13252zbe;

    /* renamed from: zbf */
    private int f13253zbf = 2;

    /* renamed from: zbg */
    private String f13254zbg = BuildConfig.f24315FLAVOR;

    static {
        C3520cn c3520cn = new C3520cn();
        f13250zbb = c3520cn;
        AbstractC3595dy.m11753YoKzxo(C3520cn.class, c3520cn);
    }

    /* renamed from: CqaNbM */
    public static /* synthetic */ void m11617CqaNbM(C3520cn c3520cn, int i) {
        c3520cn.f13252zbe = i - 1;
        c3520cn.f13251zbd |= 1;
    }

    /* renamed from: OjSQV */
    public static C3115Wm m11619OjSQV() {
        return (C3115Wm) f13250zbb.m11764Ucbh();
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13250zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", C3250Ym.f11898mjFkc, "zbf", "zbg"});
        }
        if (i2 == 3) {
            return new C3520cn();
        }
        AbstractC2983Um abstractC2983Um = null;
        if (i2 == 4) {
            return new C3115Wm(abstractC2983Um);
        }
        if (i2 != 5) {
            return null;
        }
        return f13250zbb;
    }
}
