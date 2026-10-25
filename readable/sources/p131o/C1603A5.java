package p131o;

import android.view.View;
import android.view.ViewGroup;
import com.p038google.p039android.material.sidesheet.SideSheetBehavior;

/* renamed from: o.A5 */
/* loaded from: classes.dex */
public final class C1603A5 extends AbstractC2547O6 {

    /* renamed from: mjFkc */
    public final SideSheetBehavior f7313mjFkc;

    public C1603A5(SideSheetBehavior sideSheetBehavior) {
        this.f7313mjFkc = sideSheetBehavior;
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: AZxh */
    public float mo7552AZxh(int i) {
        float fMo7556KLFTb = mo7556KLFTb();
        return (fMo7556KLFTb - i) / (fMo7556KLFTb - mo7558ZfxDd());
    }

    /* renamed from: Dt */
    public final boolean m7553Dt(View view) {
        return view.getLeft() > (mo7556KLFTb() - mo7558ZfxDd()) / 2;
    }

    /* renamed from: ETF */
    public final boolean m7554ETF(float f, float f2) {
        return AbstractC2612P6.m9947mjFkc(f, f2) && f2 > ((float) this.f7313mjFkc.m2999Vdz());
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: JHa */
    public int mo7555JHa(View view) {
        return view.getLeft() - this.f7313mjFkc.m3003bbzow();
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: KLFTb */
    public int mo7556KLFTb() {
        return this.f7313mjFkc.m2986JBhc();
    }

    /* renamed from: VA */
    public boolean m7557VA(View view, float f) {
        return Math.abs(((float) view.getRight()) + (f * this.f7313mjFkc.m3000WGXroI())) > this.f7313mjFkc.m3001XV();
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: ZfxDd */
    public int mo7558ZfxDd() {
        return Math.max(0, (mo7556KLFTb() - this.f7313mjFkc.m2988JYn()) - this.f7313mjFkc.m3003bbzow());
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: lgHUyS */
    public boolean mo7559lgHUyS(View view, int i, boolean z) {
        int iM2998SwgkN = this.f7313mjFkc.m2998SwgkN(i);
        C3211Y9 c3211y9M3005jm = this.f7313mjFkc.m3005jm();
        return c3211y9M3005jm != null && (!z ? !c3211y9M3005jm.m11053CqaNbM(view, iM2998SwgkN, view.getTop()) : !c3211y9M3005jm.m11062OjSQV(iM2998SwgkN, view.getTop()));
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: mjFkc */
    public int mo7560mjFkc(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: qdMbNW */
    public void mo7561qdMbNW(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int iM2986JBhc = this.f7313mjFkc.m2986JBhc();
        if (i <= iM2986JBhc) {
            marginLayoutParams.rightMargin = iM2986JBhc - i;
        }
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: wA */
    public int mo7562wA(View view, float f, float f2) {
        if (f < 0.0f) {
            return 3;
        }
        if (m7557VA(view, f)) {
            if (!m7554ETF(f, f2) && !m7553Dt(view)) {
                return 3;
            }
        } else if (f == 0.0f || !AbstractC2612P6.m9947mjFkc(f, f2)) {
            int left = view.getLeft();
            if (Math.abs(left - mo7558ZfxDd()) < Math.abs(left - mo7556KLFTb())) {
                return 3;
            }
        }
        return 5;
    }

    @Override // p131o.AbstractC2547O6
    /* renamed from: xJ */
    public int mo7563xJ() {
        return 0;
    }
}
