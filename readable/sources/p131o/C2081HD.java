package p131o;

import java.util.List;

/* renamed from: o.HD */
/* loaded from: classes.dex */
public final class C2081HD extends AbstractC2219JD {

    /* renamed from: KLFTb */
    public final /* synthetic */ AbstractC2219JD f8552KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f8553ZfxDd;

    /* renamed from: wA */
    public final transient int f8554wA;

    public C2081HD(AbstractC2219JD abstractC2219JD, int i, int i2) {
        this.f8552KLFTb = abstractC2219JD;
        this.f8554wA = i;
        this.f8553ZfxDd = i2;
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: JHa */
    public final int mo8416JHa() {
        return this.f8552KLFTb.mo8416JHa() + this.f8554wA;
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: ZfxDd */
    public final int mo8417ZfxDd() {
        return this.f8552KLFTb.mo8416JHa() + this.f8554wA + this.f8553ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC3168XW.m10944mjFkc(i, this.f8553ZfxDd, "index");
        return this.f8552KLFTb.get(i + this.f8554wA);
    }

    @Override // p131o.AbstractC2219JD
    /* renamed from: lgHUyS */
    public final AbstractC2219JD subList(int i, int i2) {
        AbstractC3168XW.m10945wA(i, i2, this.f8553ZfxDd);
        int i3 = this.f8554wA;
        return this.f8552KLFTb.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8553ZfxDd;
    }

    @Override // p131o.AbstractC2219JD, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // p131o.AbstractC4998zD
    /* renamed from: xJ */
    public final Object[] mo8419xJ() {
        return this.f8552KLFTb.mo8419xJ();
    }
}
