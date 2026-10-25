package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import p131o.AbstractC3005V4;
import p131o.C2257Jk;
import p131o.C3776gjvQ;

/* renamed from: androidx.constraintlayout.widget.Barrier */
/* loaded from: classes.dex */
public class C0051Barrier extends AbstractC0050AZxh {

    /* renamed from: Dt */
    public int f671Dt;

    /* renamed from: ETF */
    public C2257Jk f672ETF;

    /* renamed from: qdMbNW */
    public int f673qdMbNW;

    public C0051Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* renamed from: YoKzxo */
    public boolean m384YoKzxo() {
        return this.f672ETF.m9034sRqPfw();
    }

    public int getMargin() {
        return this.f672ETF.m9032gtr();
    }

    /* renamed from: getType */
    public int m385getType() {
        return this.f673qdMbNW;
    }

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh
    /* renamed from: lgHUyS */
    public void mo370lgHUyS(C3776gjvQ c3776gjvQ, boolean z) {
        m386rkYL(c3776gjvQ, this.f673qdMbNW, z);
    }

    /* renamed from: rkYL */
    public final void m386rkYL(C3776gjvQ c3776gjvQ, int i, boolean z) {
        this.f671Dt = i;
        if (z) {
            int i2 = this.f673qdMbNW;
            if (i2 == 5) {
                this.f671Dt = 1;
            } else if (i2 == 6) {
                this.f671Dt = 0;
            }
        } else {
            int i3 = this.f673qdMbNW;
            if (i3 == 5) {
                this.f671Dt = 0;
            } else if (i3 == 6) {
                this.f671Dt = 1;
            }
        }
        if (c3776gjvQ instanceof C2257Jk) {
            ((C2257Jk) c3776gjvQ).m9033hvGY(this.f671Dt);
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f672ETF.m9031fLidf(z);
    }

    public void setDpMargin(int i) {
        this.f672ETF.m9029Rc((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.f672ETF.m9029Rc(i);
    }

    /* renamed from: setType */
    public void m387setType(int i) {
        this.f673qdMbNW = i;
    }

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh
    /* renamed from: xJ */
    public void mo371xJ(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo371xJ(attributeSet);
        this.f672ETF = new C2257Jk();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11084Vu) {
                    m387setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11054RWyiuY) {
                    this.f672ETF.m9031fLidf(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == AbstractC3005V4.f11233uxlM) {
                    this.f672ETF.m9029Rc(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f666ZfxDd = this.f672ETF;
        m377MiMN();
    }

    public C0051Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
