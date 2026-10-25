package p131o;

import java.util.Objects;

/* renamed from: o.OE */
/* loaded from: classes.dex */
public final class C2555OE extends AbstractC2219JD {

    /* renamed from: KLFTb */
    public final transient int f9925KLFTb = 1;

    /* renamed from: ZfxDd */
    public final transient int f9926ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f9927wA;

    public C2555OE(Object[] objArr, int i, int i2) {
        this.f9927wA = objArr;
        this.f9926ZfxDd = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC3168XW.m10944mjFkc(i, this.f9925KLFTb, "index");
        Object obj = this.f9927wA[i + i + this.f9926ZfxDd];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9925KLFTb;
    }
}
