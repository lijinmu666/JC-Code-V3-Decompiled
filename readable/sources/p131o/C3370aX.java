package p131o;

/* renamed from: o.aX */
/* loaded from: classes.dex */
public final class C3370aX extends AbstractC4618tS {

    /* renamed from: KLFTb */
    public final transient int f12764KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f12765ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f12766wA;

    public C3370aX(Object[] objArr, int i, int i2) {
        this.f12766wA = objArr;
        this.f12765ZfxDd = i;
        this.f12764KLFTb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC2623PH.m9956mjFkc(i, this.f12764KLFTb, "index");
        Object obj = this.f12766wA[i + i + this.f12765ZfxDd];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12764KLFTb;
    }
}
