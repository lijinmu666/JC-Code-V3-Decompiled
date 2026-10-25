package p131o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;

/* renamed from: o.H1 */
/* loaded from: classes.dex */
public class C2068H1 extends AbstractC4219nUaNy implements Checkable, InterfaceC2350L6 {

    /* renamed from: Dt */
    public final C2205J1 f8478Dt;

    /* renamed from: ETF */
    public boolean f8479ETF;

    /* renamed from: MiMN */
    public boolean f8480MiMN;

    /* renamed from: VA */
    public boolean f8481VA;

    /* renamed from: YoKzxo */
    public static final int[] f8474YoKzxo = {R.attr.state_checkable};

    /* renamed from: rkYL */
    public static final int[] f8477rkYL = {R.attr.state_checked};

    /* renamed from: qGY */
    public static final int[] f8476qGY = {AbstractC3800h4.f13922CqaNbM};

    /* renamed from: fehf */
    public static final int f8475fehf = AbstractC2737R4.f10374qdMbNW;

    /* renamed from: o.H1$mjFkc */
    public interface mjFkc {
    }

    public C2068H1(Context context) {
        this(context, null);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f8478Dt.m8845VA().getBounds());
        return rectF;
    }

    /* renamed from: JHa */
    public boolean m8490JHa() {
        return this.f8480MiMN;
    }

    /* renamed from: KLFTb */
    public boolean m8491KLFTb() {
        C2205J1 c2205j1 = this.f8478Dt;
        return c2205j1 != null && c2205j1.m8841OjSQV();
    }

    /* renamed from: ZfxDd */
    public final void m8492ZfxDd() {
        this.f8478Dt.m8825ETF();
    }

    @Override // p131o.AbstractC4219nUaNy
    public ColorStateList getCardBackgroundColor() {
        return this.f8478Dt.m8838MiMN();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f8478Dt.m8852YoKzxo();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f8478Dt.m8872rkYL();
    }

    public int getCheckedIconGravity() {
        return this.f8478Dt.m8869qGY();
    }

    public int getCheckedIconMargin() {
        return this.f8478Dt.m8861fehf();
    }

    public int getCheckedIconSize() {
        return this.f8478Dt.m8829IEE();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f8478Dt.m8842Pq();
    }

    @Override // p131o.AbstractC4219nUaNy
    public int getContentPaddingBottom() {
        return this.f8478Dt.m8864lB().bottom;
    }

    @Override // p131o.AbstractC4219nUaNy
    public int getContentPaddingLeft() {
        return this.f8478Dt.m8864lB().left;
    }

    @Override // p131o.AbstractC4219nUaNy
    public int getContentPaddingRight() {
        return this.f8478Dt.m8864lB().right;
    }

    @Override // p131o.AbstractC4219nUaNy
    public int getContentPaddingTop() {
        return this.f8478Dt.m8864lB().top;
    }

    public float getProgress() {
        return this.f8478Dt.m8862huTpC();
    }

    @Override // p131o.AbstractC4219nUaNy
    public float getRadius() {
        return this.f8478Dt.m8860eyqo();
    }

    public ColorStateList getRippleColor() {
        return this.f8478Dt.m8827Gd();
    }

    public C2141I6 getShapeAppearanceModel() {
        return this.f8478Dt.m8828HGpJ();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f8478Dt.m8875vI();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f8478Dt.m8848VocHEe();
    }

    public int getStrokeWidth() {
        return this.f8478Dt.m8822BAnRFn();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8481VA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC2607P1.m9940JHa(this, this.f8478Dt.m8845VA());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (m8491KLFTb()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8474YoKzxo);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8477rkYL);
        }
        if (m8490JHa()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8476qGY);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(m8491KLFTb());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // p131o.AbstractC4219nUaNy, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8478Dt.m8882zvd(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f8479ETF) {
            if (!this.f8478Dt.m8866mByQ()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f8478Dt.m8857cMLeY(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setCardBackgroundColor(int i) {
        this.f8478Dt.m8871rWxwaT(ColorStateList.valueOf(i));
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.f8478Dt.m8820ANMGZc();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f8478Dt.m8847Vnb(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f8478Dt.m8839NPj(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f8481VA != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f8478Dt.m8855aqHPIZ(drawable);
    }

    public void setCheckedIconGravity(int i) {
        if (this.f8478Dt.m8869qGY() != i) {
            this.f8478Dt.m8850WrLQs(i);
        }
    }

    public void setCheckedIconMargin(int i) {
        this.f8478Dt.m8837KRTLGT(i);
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.f8478Dt.m8837KRTLGT(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconResource(int i) {
        this.f8478Dt.m8855aqHPIZ(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.f8478Dt.m8826GMIER(i);
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.f8478Dt.m8826GMIER(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f8478Dt.m8874uHVRx(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        C2205J1 c2205j1 = this.f8478Dt;
        if (c2205j1 != null) {
            c2205j1.m8846Vdz();
        }
    }

    public void setDragged(boolean z) {
        if (this.f8480MiMN != z) {
            this.f8480MiMN = z;
            refreshDrawableState();
            m8492ZfxDd();
            invalidate();
        }
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.f8478Dt.m8859dm();
    }

    public void setOnCheckedChangeListener(mjFkc mjfkc) {
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f8478Dt.m8859dm();
        this.f8478Dt.m8863jm();
    }

    public void setProgress(float f) {
        this.f8478Dt.m8832JYgkl(f);
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setRadius(float f) {
        super.setRadius(f);
        this.f8478Dt.m8833JYn(f);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f8478Dt.m8834JrJO(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.f8478Dt.m8834JrJO(AbstractC4768vjlshU.m13795mjFkc(getContext(), i));
    }

    @Override // p131o.InterfaceC2350L6
    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        setClipToOutline(c2141i6.m8674eyqo(getBoundsAsRectF()));
        this.f8478Dt.m8867nxI(c2141i6);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        this.f8478Dt.m8851XV(i);
        invalidate();
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f8478Dt.m8859dm();
        this.f8478Dt.m8863jm();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (m8491KLFTb() && isEnabled()) {
            this.f8481VA = !this.f8481VA;
            refreshDrawableState();
            m8492ZfxDd();
            this.f8478Dt.m8868oCFDzJ(this.f8481VA, true);
        }
    }

    /* renamed from: xJ */
    public void m8493xJ(int i, int i2, int i3, int i4) {
        super.m12885AZxh(i, i2, i3, i4);
    }

    public C2068H1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13942fehf);
    }

    @Override // p131o.AbstractC4219nUaNy
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f8478Dt.m8871rWxwaT(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f8478Dt.m8849WGXroI(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2068H1(Context context, AttributeSet attributeSet, int i) {
        int i2 = f8475fehf;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        this.f8481VA = false;
        this.f8480MiMN = false;
        this.f8479ETF = true;
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(getContext(), attributeSet, AbstractC3340a5.f12551eEOGOh, i, i2, new int[0]);
        C2205J1 c2205j1 = new C2205J1(this, attributeSet, i, i2);
        this.f8478Dt = c2205j1;
        c2205j1.m8871rWxwaT(super.getCardBackgroundColor());
        c2205j1.m8856bbzow(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        c2205j1.m8836KLMXS(typedArrayM12940lgHUyS);
        typedArrayM12940lgHUyS.recycle();
    }
}
