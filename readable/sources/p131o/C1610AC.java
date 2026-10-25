package p131o;

import java.util.Objects;

/* renamed from: o.AC */
/* loaded from: classes.dex */
public final class C1610AC extends AbstractC2878TB {

    /* renamed from: KLFTb */
    public final transient int f7328KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f7329ZfxDd;

    /* renamed from: wA */
    public final transient Object[] f7330wA;

    public C1610AC(Object[] objArr, int i, int i2) {
        this.f7330wA = objArr;
        this.f7329ZfxDd = i;
        this.f7328KLFTb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC4284oV.m12960mjFkc(i, this.f7328KLFTb, "index");
        Object obj = this.f7330wA[i + i + this.f7329ZfxDd];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7328KLFTb;
    }
}
