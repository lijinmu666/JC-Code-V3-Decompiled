package p131o;

/* renamed from: o.YV */
/* loaded from: classes.dex */
public final class C3235YV extends AbstractC4618tS {

    /* renamed from: KLFTb */
    public static final AbstractC4618tS f11885KLFTb = new C3235YV(new Object[0], 0);

    /* renamed from: ZfxDd */
    public final transient int f11886ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f11887wA;

    public C3235YV(Object[] objArr, int i) {
        this.f11887wA = objArr;
        this.f11886ZfxDd = i;
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: JHa */
    public final int mo9509JHa() {
        return 0;
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: ZfxDd */
    public final int mo9510ZfxDd() {
        return this.f11886ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC2623PH.m9956mjFkc(i, this.f11886ZfxDd, "index");
        Object obj = this.f11887wA[i];
        obj.getClass();
        return obj;
    }

    @Override // p131o.AbstractC4618tS, p131o.AbstractC2566OO
    /* renamed from: mjFkc */
    public final int mo9899mjFkc(Object[] objArr, int i) {
        System.arraycopy(this.f11887wA, 0, objArr, 0, this.f11886ZfxDd);
        return this.f11886ZfxDd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11886ZfxDd;
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: xJ */
    public final Object[] mo9512xJ() {
        return this.f11887wA;
    }
}
