package p131o;

import java.util.List;

/* renamed from: o.MR */
/* loaded from: classes.dex */
public final class C2439MR extends AbstractC4618tS {

    /* renamed from: KLFTb */
    public final /* synthetic */ AbstractC4618tS f9581KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f9582ZfxDd;

    /* renamed from: wA */
    public final transient int f9583wA;

    public C2439MR(AbstractC4618tS abstractC4618tS, int i, int i2) {
        this.f9581KLFTb = abstractC4618tS;
        this.f9583wA = i;
        this.f9582ZfxDd = i2;
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: JHa */
    public final int mo9509JHa() {
        return this.f9581KLFTb.mo9509JHa() + this.f9583wA;
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: ZfxDd */
    public final int mo9510ZfxDd() {
        return this.f9581KLFTb.mo9509JHa() + this.f9583wA + this.f9582ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC2623PH.m9956mjFkc(i, this.f9582ZfxDd, "index");
        return this.f9581KLFTb.get(i + this.f9583wA);
    }

    @Override // p131o.AbstractC4618tS
    /* renamed from: lgHUyS */
    public final AbstractC4618tS subList(int i, int i2) {
        AbstractC2623PH.m9957wA(i, i2, this.f9582ZfxDd);
        AbstractC4618tS abstractC4618tS = this.f9581KLFTb;
        int i3 = this.f9583wA;
        return abstractC4618tS.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9582ZfxDd;
    }

    @Override // p131o.AbstractC4618tS, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // p131o.AbstractC2566OO
    /* renamed from: xJ */
    public final Object[] mo9512xJ() {
        return this.f9581KLFTb.mo9512xJ();
    }
}
