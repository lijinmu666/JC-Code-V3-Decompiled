package androidx.constraintlayout.p013helper.p014widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import p131o.AbstractC1767Ca;
import p131o.AbstractC1832Da;
import p131o.AbstractC3005V4;
import p131o.C3776gjvQ;
import p131o.C4410qMaC;

/* renamed from: androidx.constraintlayout.helper.widget.Flow */
/* loaded from: classes.dex */
public class C0049Flow extends AbstractC1767Ca {

    /* renamed from: ETF */
    public C4410qMaC f662ETF;

    public C0049Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // p131o.AbstractC1767Ca
    /* renamed from: YoKzxo */
    public void mo369YoKzxo(AbstractC1832Da abstractC1832Da, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (abstractC1832Da == null) {
            setMeasuredDimension(0, 0);
        } else {
            abstractC1832Da.mo8020rdJr(mode, size, mode2, size2);
            setMeasuredDimension(abstractC1832Da.m8001Dp(), abstractC1832Da.m8016gtr());
        }
    }

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh
    /* renamed from: lgHUyS */
    public void mo370lgHUyS(C3776gjvQ c3776gjvQ, boolean z) {
        this.f662ETF.m8021sRqPfw(z);
    }

    @Override // androidx.constraintlayout.p015widget.AbstractC0050AZxh, android.view.View
    public void onMeasure(int i, int i2) {
        mo369YoKzxo(this.f662ETF, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.f662ETF.m13252xCVa(f);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.f662ETF.m13241bc(i);
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f662ETF.m13251wLtdyQ(f);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.f662ETF.m13253yP(i);
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.f662ETF.m13249ui(i);
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f662ETF.m13247tpGcn(f);
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.f662ETF.m13245qGgY(i);
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.f662ETF.m13250vUsV(i);
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.f662ETF.m13243np(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        this.f662ETF.m13237QyMqpM(i);
        requestLayout();
    }

    public void setPadding(int i) {
        this.f662ETF.m8003IyS(i);
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.f662ETF.m8022tAfC(i);
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.f662ETF.m8011Xxz(i);
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.f662ETF.m8012Zdbk(i);
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.f662ETF.m8005KRckQg(i);
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.f662ETF.m13233HExgdj(i);
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f662ETF.m13235KSf(f);
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f662ETF.m13240Vptz(i);
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.f662ETF.m13246qrxT(i);
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.f662ETF.m13230CcoH(i);
        requestLayout();
    }

    @Override // p131o.AbstractC1767Ca, androidx.constraintlayout.p015widget.AbstractC0050AZxh
    /* renamed from: xJ */
    public void mo371xJ(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo371xJ(attributeSet);
        this.f662ETF = new C4410qMaC();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11099Xxz) {
                    this.f662ETF.m13237QyMqpM(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11108Zdbk) {
                    this.f662ETF.m8003IyS(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11262ybBTr) {
                    this.f662ETF.m8004Jk(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11218sqndV) {
                    this.f662ETF.m8013dGDT(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11007Jk) {
                    this.f662ETF.m8011Xxz(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11014KRckQg) {
                    this.f662ETF.m8005KRckQg(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11178mPWV) {
                    this.f662ETF.m8012Zdbk(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11130dkKKW) {
                    this.f662ETF.m8022tAfC(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11200qGgY) {
                    this.f662ETF.m13230CcoH(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11050QyqF) {
                    this.f662ETF.m13250vUsV(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11225tpGcn) {
                    this.f662ETF.m13246qrxT(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f10975Fztqa) {
                    this.f662ETF.m13241bc(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11185nUaNy) {
                    this.f662ETF.m13231ERt(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11079VfB) {
                    this.f662ETF.m13253yP(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f11250xCVa) {
                    this.f662ETF.m13244pJeaSR(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == AbstractC3005V4.f10944BxruE) {
                    this.f662ETF.m13247tpGcn(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f11018LeWm) {
                    this.f662ETF.m13252xCVa(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f11020LsBneK) {
                    this.f662ETF.m13232FOJ(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f11183mzUGzO) {
                    this.f662ETF.m13251wLtdyQ(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f11229ub) {
                    this.f662ETF.m13234JOe(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f11259yP) {
                    this.f662ETF.m13235KSf(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == AbstractC3005V4.f10989Htq) {
                    this.f662ETF.m13249ui(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == AbstractC3005V4.f11246wLtdyQ) {
                    this.f662ETF.m13233HExgdj(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == AbstractC3005V4.f11066Tw) {
                    this.f662ETF.m13245qGgY(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11231ui) {
                    this.f662ETF.m13240Vptz(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == AbstractC3005V4.f11121bc) {
                    this.f662ETF.m13243np(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
        }
        this.f666ZfxDd = this.f662ETF;
        m377MiMN();
    }
}
