package p131o;

import java.util.List;

/* renamed from: o.Ss */
/* loaded from: classes.dex */
public final class C2857Ss extends AbstractC2919Ts {

    /* renamed from: KLFTb */
    public final /* synthetic */ AbstractC2919Ts f10602KLFTb;

    /* renamed from: ZfxDd */
    public final transient int f10603ZfxDd;

    /* renamed from: wA */
    public final transient int f10604wA;

    public C2857Ss(AbstractC2919Ts abstractC2919Ts, int i, int i2) {
        this.f10602KLFTb = abstractC2919Ts;
        this.f10604wA = i;
        this.f10603ZfxDd = i2;
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: JHa */
    public final int mo9911JHa() {
        return this.f10602KLFTb.mo9911JHa() + this.f10604wA;
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: ZfxDd */
    public final int mo9912ZfxDd() {
        return this.f10602KLFTb.mo9911JHa() + this.f10604wA + this.f10603ZfxDd;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC1851Ds.m8062mjFkc(i, this.f10603ZfxDd, "index");
        return this.f10602KLFTb.get(i + this.f10604wA);
    }

    @Override // p131o.AbstractC2919Ts
    /* renamed from: lgHUyS */
    public final AbstractC2919Ts subList(int i, int i2) {
        AbstractC1851Ds.m8061ZfxDd(i, i2, this.f10603ZfxDd);
        int i3 = this.f10604wA;
        return this.f10602KLFTb.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10603ZfxDd;
    }

    @Override // p131o.AbstractC2919Ts, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // p131o.AbstractC2595Os
    /* renamed from: xJ */
    public final Object[] mo9914xJ() {
        return this.f10602KLFTb.mo9914xJ();
    }
}
