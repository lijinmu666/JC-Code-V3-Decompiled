package p131o;

/* renamed from: o.Dy */
/* loaded from: classes.dex */
public final class C1858Dy {

    /* renamed from: mjFkc */
    public final C1796Cy f7926mjFkc;

    public C1858Dy(EnumC4784vz enumC4784vz, Object obj, EnumC4784vz enumC4784vz2, Object obj2) {
        this.f7926mjFkc = new C1796Cy(enumC4784vz, obj, enumC4784vz2, obj2);
    }

    /* renamed from: AZxh */
    public static int m8095AZxh(C1796Cy c1796Cy, Object obj, Object obj2) {
        return C2664Px.m9976mjFkc(c1796Cy.f7769mjFkc, 1, obj) + C2664Px.m9976mjFkc(c1796Cy.f7770wA, 2, obj2);
    }

    /* renamed from: KLFTb */
    public static void m8096KLFTb(AbstractC2063Gx abstractC2063Gx, C1796Cy c1796Cy, Object obj, Object obj2) {
        C2664Px.m9972ETF(abstractC2063Gx, c1796Cy.f7769mjFkc, 1, obj);
        C2664Px.m9972ETF(abstractC2063Gx, c1796Cy.f7770wA, 2, obj2);
    }

    /* renamed from: ZfxDd */
    public static C1858Dy m8097ZfxDd(EnumC4784vz enumC4784vz, Object obj, EnumC4784vz enumC4784vz2, Object obj2) {
        return new C1858Dy(enumC4784vz, obj, enumC4784vz2, obj2);
    }

    /* renamed from: mjFkc */
    public final int m8098mjFkc(int i, Object obj, Object obj2) {
        C1796Cy c1796Cy = this.f7926mjFkc;
        int iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i << 3);
        int iM8095AZxh = m8095AZxh(c1796Cy, obj, obj2);
        return iM8470ZfxDd + AbstractC2063Gx.m8470ZfxDd(iM8095AZxh) + iM8095AZxh;
    }

    /* renamed from: wA */
    public final C1796Cy m8099wA() {
        return this.f7926mjFkc;
    }
}
