package p131o;

/* renamed from: o.Ay */
/* loaded from: classes.dex */
public final class C1660Ay implements InterfaceC2200Iy {

    /* renamed from: mjFkc */
    public final InterfaceC2200Iy[] f7420mjFkc;

    public C1660Ay(InterfaceC2200Iy... interfaceC2200IyArr) {
        this.f7420mjFkc = interfaceC2200IyArr;
    }

    @Override // p131o.InterfaceC2200Iy
    /* renamed from: AZxh */
    public final boolean mo7642AZxh(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.f7420mjFkc[i].mo7642AZxh(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // p131o.InterfaceC2200Iy
    /* renamed from: mjFkc */
    public final InterfaceC2132Hy mo7643mjFkc(Class cls) {
        for (int i = 0; i < 2; i++) {
            InterfaceC2200Iy interfaceC2200Iy = this.f7420mjFkc[i];
            if (interfaceC2200Iy.mo7642AZxh(cls)) {
                return interfaceC2200Iy.mo7643mjFkc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
