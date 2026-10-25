package p131o;

import java.util.Objects;

/* renamed from: o.GE */
/* loaded from: classes.dex */
public final class C2017GE extends AbstractC2219JD {

    /* renamed from: KLFTb */
    public static final AbstractC2219JD f8339KLFTb = new C2017GE(new Object[0], 0);

    /* renamed from: ZfxDd */
    public final transient int f8340ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f8341wA;

    public C2017GE(Object[] objArr, int i) {
        this.f8341wA = objArr;
        this.f8340ZfxDd = i;
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: JHa */
    public final int mo8416JHa() {
        return 0;
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: ZfxDd */
    public final int mo8417ZfxDd() {
        return this.f8340ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC3168XW.m10944mjFkc(i, this.f8340ZfxDd, "index");
        Object obj = this.f8341wA[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // p131o.AbstractC2219JD, p131o.AbstractC4998zD
    /* renamed from: mjFkc */
    public final int mo8418mjFkc(Object[] objArr, int i) {
        System.arraycopy(this.f8341wA, 0, objArr, 0, this.f8340ZfxDd);
        return this.f8340ZfxDd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8340ZfxDd;
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: xJ */
    public final Object[] mo8419xJ() {
        return this.f8341wA;
    }
}
