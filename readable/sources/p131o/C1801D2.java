package p131o;

import android.view.View;
import android.view.ViewParent;

/* renamed from: o.D2 */
/* loaded from: classes.dex */
public class C1801D2 {

    /* renamed from: AZxh */
    public ViewParent f7780AZxh;

    /* renamed from: KLFTb */
    public int[] f7781KLFTb;

    /* renamed from: ZfxDd */
    public boolean f7782ZfxDd;

    /* renamed from: mjFkc */
    public ViewParent f7783mjFkc;

    /* renamed from: wA */
    public final View f7784wA;

    public C1801D2(View view) {
        this.f7784wA = view;
    }

    /* renamed from: AZxh */
    public boolean m7952AZxh(float f, float f2) {
        ViewParent viewParentM7963lgHUyS;
        if (!m7959VA() || (viewParentM7963lgHUyS = m7963lgHUyS(0)) == null) {
            return false;
        }
        return AbstractC4287oa.m12965AZxh(viewParentM7963lgHUyS, this.f7784wA, f, f2);
    }

    /* renamed from: Dt */
    public boolean m7953Dt() {
        return m7954ETF(0);
    }

    /* renamed from: ETF */
    public boolean m7954ETF(int i) {
        return m7963lgHUyS(i) != null;
    }

    /* renamed from: IEE */
    public void m7955IEE(int i) {
        ViewParent viewParentM7963lgHUyS = m7963lgHUyS(i);
        if (viewParentM7963lgHUyS != null) {
            AbstractC4287oa.m12971xJ(viewParentM7963lgHUyS, this.f7784wA, i);
            m7960YoKzxo(i, null);
        }
    }

    /* renamed from: JHa */
    public boolean m7956JHa(int i, int i2, int i3, int i4, int[] iArr) {
        return m7969xJ(i, i2, i3, i4, iArr, 0, null);
    }

    /* renamed from: KLFTb */
    public void m7957KLFTb(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m7969xJ(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: MiMN */
    public void m7958MiMN(boolean z) {
        if (this.f7782ZfxDd) {
            AbstractC2876T9.m10260XFUzSY(this.f7784wA);
        }
        this.f7782ZfxDd = z;
    }

    /* renamed from: VA */
    public boolean m7959VA() {
        return this.f7782ZfxDd;
    }

    /* renamed from: YoKzxo */
    public final void m7960YoKzxo(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f7783mjFkc = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.f7780AZxh = viewParent;
        }
    }

    /* renamed from: ZfxDd */
    public boolean m7961ZfxDd(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentM7963lgHUyS;
        int i4;
        int i5;
        if (!m7959VA() || (viewParentM7963lgHUyS = m7963lgHUyS(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f7784wA.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = m7966qdMbNW();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        AbstractC4287oa.m12970wA(viewParentM7963lgHUyS, this.f7784wA, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f7784wA.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* renamed from: fehf */
    public void m7962fehf() {
        m7955IEE(0);
    }

    /* renamed from: lgHUyS */
    public final ViewParent m7963lgHUyS(int i) {
        if (i == 0) {
            return this.f7783mjFkc;
        }
        if (i != 1) {
            return null;
        }
        return this.f7780AZxh;
    }

    /* renamed from: mjFkc */
    public boolean m7964mjFkc(float f, float f2, boolean z) {
        ViewParent viewParentM7963lgHUyS;
        if (!m7959VA() || (viewParentM7963lgHUyS = m7963lgHUyS(0)) == null) {
            return false;
        }
        return AbstractC4287oa.m12969mjFkc(viewParentM7963lgHUyS, this.f7784wA, f, f2, z);
    }

    /* renamed from: qGY */
    public boolean m7965qGY(int i, int i2) {
        if (m7954ETF(i2)) {
            return true;
        }
        if (!m7959VA()) {
            return false;
        }
        View view = this.f7784wA;
        for (ViewParent parent = this.f7784wA.getParent(); parent != null; parent = parent.getParent()) {
            if (AbstractC4287oa.m12966JHa(parent, view, this.f7784wA, i, i2)) {
                m7960YoKzxo(i2, parent);
                AbstractC4287oa.m12967KLFTb(parent, view, this.f7784wA, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: qdMbNW */
    public final int[] m7966qdMbNW() {
        if (this.f7781KLFTb == null) {
            this.f7781KLFTb = new int[2];
        }
        return this.f7781KLFTb;
    }

    /* renamed from: rkYL */
    public boolean m7967rkYL(int i) {
        return m7965qGY(i, 0);
    }

    /* renamed from: wA */
    public boolean m7968wA(int i, int i2, int[] iArr, int[] iArr2) {
        return m7961ZfxDd(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: xJ */
    public final boolean m7969xJ(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentM7963lgHUyS;
        int i6;
        int i7;
        int[] iArr3;
        if (!m7959VA() || (viewParentM7963lgHUyS = m7963lgHUyS(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f7784wA.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrM7966qdMbNW = m7966qdMbNW();
            iArrM7966qdMbNW[0] = 0;
            iArrM7966qdMbNW[1] = 0;
            iArr3 = iArrM7966qdMbNW;
        } else {
            iArr3 = iArr2;
        }
        AbstractC4287oa.m12968ZfxDd(viewParentM7963lgHUyS, this.f7784wA, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f7784wA.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }
}
