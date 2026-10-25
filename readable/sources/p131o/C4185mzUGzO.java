package p131o;

import android.graphics.Typeface;

/* renamed from: o.mzUGzO */
/* loaded from: classes.dex */
public final class C4185mzUGzO extends AbstractC3139X7 {

    /* renamed from: AZxh */
    public final mjFkc f15289AZxh;

    /* renamed from: mjFkc */
    public final Typeface f15290mjFkc;

    /* renamed from: wA */
    public boolean f15291wA;

    /* renamed from: o.mzUGzO$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo7924mjFkc(Typeface typeface);
    }

    public C4185mzUGzO(mjFkc mjfkc, Typeface typeface) {
        this.f15290mjFkc = typeface;
        this.f15289AZxh = mjfkc;
    }

    @Override // p131o.AbstractC3139X7
    /* renamed from: AZxh */
    public void mo2738AZxh(Typeface typeface, boolean z) {
        m12820ZfxDd(typeface);
    }

    /* renamed from: ZfxDd */
    public final void m12820ZfxDd(Typeface typeface) {
        if (this.f15291wA) {
            return;
        }
        this.f15289AZxh.mo7924mjFkc(typeface);
    }

    @Override // p131o.AbstractC3139X7
    /* renamed from: mjFkc */
    public void mo2739mjFkc(int i) {
        m12820ZfxDd(this.f15290mjFkc);
    }

    /* renamed from: wA */
    public void m12821wA() {
        this.f15291wA = true;
    }
}
