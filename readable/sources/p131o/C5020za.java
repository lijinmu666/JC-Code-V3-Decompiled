package p131o;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: o.za */
/* loaded from: classes.dex */
public class C5020za extends AbstractC4956ya {
    @Override // p131o.AbstractC1634Aa
    /* renamed from: AZxh */
    public float mo7612AZxh(View view) {
        return view.getTransitionAlpha();
    }

    @Override // p131o.AbstractC1634Aa
    /* renamed from: JHa */
    public void mo7613JHa(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // p131o.AbstractC1634Aa
    /* renamed from: KLFTb */
    public void mo7614KLFTb(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // p131o.AbstractC1634Aa
    /* renamed from: ZfxDd */
    public void mo7615ZfxDd(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // p131o.AbstractC1634Aa
    /* renamed from: lgHUyS */
    public void mo7616lgHUyS(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // p131o.AbstractC1634Aa
    /* renamed from: xJ */
    public void mo7619xJ(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }
}
