package p131o;

/* renamed from: o.Ux */
/* loaded from: classes.dex */
public final class C2997Ux implements InterfaceC2200Iy {

    /* renamed from: mjFkc */
    public static final C2997Ux f10927mjFkc = new C2997Ux();

    /* renamed from: wA */
    public static C2997Ux m10652wA() {
        return f10927mjFkc;
    }

    @Override // p131o.InterfaceC2200Iy
    /* renamed from: AZxh */
    public final boolean mo7642AZxh(Class cls) {
        return AbstractC3595dy.class.isAssignableFrom(cls);
    }

    @Override // p131o.InterfaceC2200Iy
    /* renamed from: mjFkc */
    public final InterfaceC2132Hy mo7643mjFkc(Class cls) {
        if (!AbstractC3595dy.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC2132Hy) AbstractC3595dy.m11751Gd(cls.asSubclass(AbstractC3595dy.class)).mo7631IEE(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
