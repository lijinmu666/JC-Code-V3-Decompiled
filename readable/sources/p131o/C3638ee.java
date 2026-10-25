package p131o;

/* renamed from: o.ee */
/* loaded from: classes.dex */
public final class C3638ee extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3638ee f13479zbb;

    /* renamed from: zbe */
    private Object f13481zbe;

    /* renamed from: zbd */
    private int f13480zbd = 0;

    /* renamed from: zbf */
    private byte f13482zbf = 2;

    static {
        C3638ee c3638ee = new C3638ee();
        f13479zbb = c3638ee;
        AbstractC3595dy.m11753YoKzxo(C3638ee.class, c3638ee);
    }

    /* renamed from: zvd */
    public static C3638ee m11853zvd() {
        return f13479zbb;
    }

    /* renamed from: CqaNbM */
    public final C4312ov m11854CqaNbM() {
        return this.f13480zbd == 2 ? (C4312ov) this.f13481zbe : C4312ov.m13041cMLeY();
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13482zbf);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13479zbb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0003\u0001м\u0000\u0002м\u0000\u0003м\u0000", new Object[]{"zbe", "zbd", C3574de.class, C4312ov.class, C3851hv.class});
        }
        if (i2 == 3) {
            return new C3638ee();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C3306Zd(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f13479zbb;
        }
        this.f13482zbf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    /* renamed from: Ne */
    public final C3851hv m11855Ne() {
        return this.f13480zbd == 3 ? (C3851hv) this.f13481zbe : C3851hv.m12241Ne();
    }

    /* renamed from: OjSQV */
    public final boolean m11856OjSQV() {
        return this.f13480zbd == 1;
    }

    /* renamed from: cMLeY */
    public final boolean m11857cMLeY() {
        return this.f13480zbd == 3;
    }

    /* renamed from: xrEuO */
    public final C3574de m11858xrEuO() {
        return this.f13480zbd == 1 ? (C3574de) this.f13481zbe : C3574de.m11734CqaNbM();
    }
}
