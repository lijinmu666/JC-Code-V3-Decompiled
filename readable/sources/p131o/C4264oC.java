package p131o;

import java.util.Objects;

/* renamed from: o.oC */
/* loaded from: classes.dex */
public final class C4264oC extends AbstractC2878TB {

    /* renamed from: KLFTb */
    public static final AbstractC2878TB f15511KLFTb = new C4264oC(new Object[0], 0);

    /* renamed from: ZfxDd */
    public final transient int f15512ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f15513wA;

    public C4264oC(Object[] objArr, int i) {
        this.f15513wA = objArr;
        this.f15512ZfxDd = i;
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: JHa */
    public final int mo8411JHa() {
        return 0;
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: ZfxDd */
    public final int mo8412ZfxDd() {
        return this.f15512ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC4284oV.m12960mjFkc(i, this.f15512ZfxDd, "index");
        Object obj = this.f15513wA[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // p131o.AbstractC2878TB, p131o.AbstractC2014GB
    /* renamed from: mjFkc */
    public final int mo8413mjFkc(Object[] objArr, int i) {
        System.arraycopy(this.f15513wA, 0, objArr, 0, this.f15512ZfxDd);
        return this.f15512ZfxDd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15512ZfxDd;
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: xJ */
    public final Object[] mo8414xJ() {
        return this.f15513wA;
    }
}
