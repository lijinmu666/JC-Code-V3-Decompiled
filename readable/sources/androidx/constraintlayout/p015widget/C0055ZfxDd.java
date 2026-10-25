package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.p015widget.ConstraintLayout;

/* renamed from: androidx.constraintlayout.widget.ZfxDd */
/* loaded from: classes.dex */
public class C0055ZfxDd extends View {
    public C0055ZfxDd(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.C0052AZxh c0052AZxh = (ConstraintLayout.C0052AZxh) getLayoutParams();
        c0052AZxh.f745mjFkc = i;
        setLayoutParams(c0052AZxh);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.C0052AZxh c0052AZxh = (ConstraintLayout.C0052AZxh) getLayoutParams();
        c0052AZxh.f698AZxh = i;
        setLayoutParams(c0052AZxh);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.C0052AZxh c0052AZxh = (ConstraintLayout.C0052AZxh) getLayoutParams();
        c0052AZxh.f757wA = f;
        setLayoutParams(c0052AZxh);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
