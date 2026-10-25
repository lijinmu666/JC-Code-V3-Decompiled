package p131o;

/* renamed from: o.de */
/* loaded from: classes.dex */
public final class C3574de extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C3574de f13370zbb;

    /* renamed from: zbd */
    private int f13371zbd;

    /* renamed from: zbf */
    private C4312ov f13373zbf;

    /* renamed from: zbg */
    private byte f13374zbg = 2;

    /* renamed from: zbe */
    private InterfaceC4118ly f13372zbe = AbstractC3595dy.m11760wJVbdd();

    static {
        C3574de c3574de = new C3574de();
        f13370zbb = c3574de;
        AbstractC3595dy.m11753YoKzxo(C3574de.class, c3574de);
    }

    /* renamed from: CqaNbM */
    public static C3574de m11734CqaNbM() {
        return f13370zbb;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f13374zbg);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f13370zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000", new Object[]{"zbd", "zbe", C3445be.class, "zbf"});
        }
        if (i2 == 3) {
            return new C3574de();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C3511ce(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f13370zbb;
        }
        this.f13374zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    /* renamed from: OjSQV */
    public final C4312ov m11736OjSQV() {
        C4312ov c4312ov = this.f13373zbf;
        return c4312ov == null ? C4312ov.m13041cMLeY() : c4312ov;
    }
}
