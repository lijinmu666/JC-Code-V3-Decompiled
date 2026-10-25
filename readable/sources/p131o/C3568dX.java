package p131o;

/* renamed from: o.dX */
/* loaded from: classes.dex */
public final class C3568dX extends AbstractC1963FT {

    /* renamed from: JHa */
    public static final AbstractC1963FT f13365JHa = new C3568dX(null, new Object[0], 0);

    /* renamed from: KLFTb */
    public final transient int f13366KLFTb;

    /* renamed from: ZfxDd */
    public final transient Object[] f13367ZfxDd;

    public C3568dX(Object obj, Object[] objArr, int i) {
        this.f13367ZfxDd = objArr;
        this.f13366KLFTb = i;
    }

    /* renamed from: xJ */
    public static C3568dX m11727xJ(int i, Object[] objArr, AbstractC3298ZS abstractC3298ZS) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        AbstractC4343pL.m13124mjFkc(obj, obj2);
        return new C3568dX(null, objArr, 1);
    }

    @Override // p131o.AbstractC1963FT
    /* renamed from: KLFTb */
    public final AbstractC4485rU mo8297KLFTb() {
        return new C3101WW(this, new C3370aX(this.f13367ZfxDd, 0, this.f13366KLFTb));
    }

    @Override // p131o.AbstractC1963FT
    /* renamed from: ZfxDd */
    public final AbstractC4485rU mo8298ZfxDd() {
        return new C2701QW(this, this.f13367ZfxDd, 0, this.f13366KLFTb);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    @Override // p131o.AbstractC1963FT, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        Object[] objArr = this.f13367ZfxDd;
        int i = this.f13366KLFTb;
        if (obj != null && i == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // p131o.AbstractC1963FT
    /* renamed from: mjFkc */
    public final AbstractC2566OO mo8299mjFkc() {
        return new C3370aX(this.f13367ZfxDd, 1, this.f13366KLFTb);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f13366KLFTb;
    }
}
