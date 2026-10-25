package p131o;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.p020emoji2.p021text.C0084wA;

/* renamed from: o.mz */
/* loaded from: classes.dex */
public class C4184mz implements TransformationMethod {

    /* renamed from: mjFkc */
    public final TransformationMethod f15288mjFkc;

    public C4184mz(TransformationMethod transformationMethod) {
        this.f15288mjFkc = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f15288mjFkc;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || C0084wA.m688AZxh().m701ZfxDd() != 1) ? charSequence : C0084wA.m688AZxh().m707rkYL(charSequence);
    }

    /* renamed from: mjFkc */
    public TransformationMethod m12819mjFkc() {
        return this.f15288mjFkc;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        TransformationMethod transformationMethod = this.f15288mjFkc;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z, i, rect);
        }
    }
}
