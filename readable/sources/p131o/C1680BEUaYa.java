package p131o;

import android.os.Bundle;
import androidx.fragment.p022app.Fragment;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.C0103JHa;
import androidx.savedstate.C0184mjFkc;

/* renamed from: o.BEUaYa */
/* loaded from: classes.dex */
public class C1680BEUaYa implements InterfaceC4193n6, InterfaceC3958ja {

    /* renamed from: AZxh */
    public final C3893ia f7462AZxh;

    /* renamed from: mjFkc */
    public final Fragment f7464mjFkc;

    /* renamed from: wA */
    public C0103JHa f7465wA = null;

    /* renamed from: ZfxDd */
    public C4127m6 f7463ZfxDd = null;

    public C1680BEUaYa(Fragment fragment, C3893ia c3893ia) {
        this.f7464mjFkc = fragment;
        this.f7462AZxh = c3893ia;
    }

    /* renamed from: AZxh */
    public void m7690AZxh(AbstractC0112wA.mjFkc mjfkc) {
        this.f7465wA.m1043lgHUyS(mjfkc);
    }

    @Override // p131o.InterfaceC3068W0
    /* renamed from: JHa */
    public AbstractC0112wA mo770JHa() {
        m7692ZfxDd();
        return this.f7465wA;
    }

    /* renamed from: KLFTb */
    public boolean m7691KLFTb() {
        return this.f7465wA != null;
    }

    /* renamed from: ZfxDd */
    public void m7692ZfxDd() {
        if (this.f7465wA == null) {
            this.f7465wA = new C0103JHa(this);
            this.f7463ZfxDd = C4127m6.m12743mjFkc(this);
        }
    }

    /* renamed from: lgHUyS */
    public void m7693lgHUyS(Bundle bundle) {
        this.f7463ZfxDd.m12745KLFTb(bundle);
    }

    @Override // p131o.InterfaceC4193n6
    /* renamed from: mjFkc */
    public C0184mjFkc mo825mjFkc() {
        m7692ZfxDd();
        return this.f7463ZfxDd.m12744AZxh();
    }

    @Override // p131o.InterfaceC3958ja
    /* renamed from: wA */
    public C3893ia mo841wA() {
        m7692ZfxDd();
        return this.f7462AZxh;
    }

    /* renamed from: xJ */
    public void m7694xJ(Bundle bundle) {
        this.f7463ZfxDd.m12746ZfxDd(bundle);
    }
}
