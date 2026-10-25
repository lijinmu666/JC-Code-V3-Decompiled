package p131o;

import java.util.List;

/* renamed from: o.QB */
/* loaded from: classes.dex */
public final class C2679QB extends AbstractC2878TB {

    /* renamed from: KLFTb */
    public final /* synthetic */ AbstractC2878TB f10153KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f10154ZfxDd;

    /* renamed from: wA */
    public final transient int f10155wA;

    public C2679QB(AbstractC2878TB abstractC2878TB, int i, int i2) {
        this.f10153KLFTb = abstractC2878TB;
        this.f10155wA = i;
        this.f10154ZfxDd = i2;
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: JHa */
    public final int mo8411JHa() {
        return this.f10153KLFTb.mo8411JHa() + this.f10155wA;
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: ZfxDd */
    public final int mo8412ZfxDd() {
        return this.f10153KLFTb.mo8411JHa() + this.f10155wA + this.f10154ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC4284oV.m12960mjFkc(i, this.f10154ZfxDd, "index");
        return this.f10153KLFTb.get(i + this.f10155wA);
    }

    @Override // p131o.AbstractC2878TB
    /* renamed from: lgHUyS */
    public final AbstractC2878TB subList(int i, int i2) {
        AbstractC4284oV.m12961wA(i, i2, this.f10154ZfxDd);
        int i3 = this.f10155wA;
        return this.f10153KLFTb.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10154ZfxDd;
    }

    @Override // p131o.AbstractC2878TB, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // p131o.AbstractC2014GB
    /* renamed from: xJ */
    public final Object[] mo8414xJ() {
        return this.f10153KLFTb.mo8414xJ();
    }
}
