package p131o;

import java.util.Objects;

/* renamed from: o.ct */
/* loaded from: classes.dex */
public final class C3526ct extends AbstractC2919Ts {

    /* renamed from: KLFTb */
    public static final AbstractC2919Ts f13264KLFTb = new C3526ct(new Object[0], 0);

    /* renamed from: ZfxDd */
    public final transient int f13265ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f13266wA;

    public C3526ct(Object[] objArr, int i) {
        this.f13266wA = objArr;
        this.f13265ZfxDd = i;
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: JHa */
    public final int mo9911JHa() {
        return 0;
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: ZfxDd */
    public final int mo9912ZfxDd() {
        return this.f13265ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC1851Ds.m8062mjFkc(i, this.f13265ZfxDd, "index");
        Object obj = this.f13266wA[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // p131o.AbstractC2919Ts, p131o.AbstractC2595Os
    /* renamed from: mjFkc */
    public final int mo9913mjFkc(Object[] objArr, int i) {
        System.arraycopy(this.f13266wA, 0, objArr, 0, this.f13265ZfxDd);
        return this.f13265ZfxDd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13265ZfxDd;
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: xJ */
    public final Object[] mo9914xJ() {
        return this.f13266wA;
    }
}
