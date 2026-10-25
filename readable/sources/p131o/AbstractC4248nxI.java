package p131o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* renamed from: o.nxI */
/* loaded from: classes.dex */
public abstract class AbstractC4248nxI extends Button {

    /* renamed from: AZxh */
    public final C2171IVlxe f15485AZxh;

    /* renamed from: mjFkc */
    public final C2266JrJO f15486mjFkc;

    /* renamed from: wA */
    public C3038Vdz f15487wA;

    public AbstractC4248nxI(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f15486mjFkc = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C2171IVlxe c2171IVlxe = new C2171IVlxe(this);
        this.f15485AZxh = c2171IVlxe;
        c2171IVlxe.m8758MiMN(attributeSet, i);
        c2171IVlxe.m8749AZxh();
        getEmojiTextViewHelper().m10698AZxh(attributeSet, i);
    }

    private C3038Vdz getEmojiTextViewHelper() {
        if (this.f15487wA == null) {
            this.f15487wA = new C3038Vdz(this);
        }
        return this.f15487wA;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8749AZxh();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (AbstractC4689ua.f16857AZxh) {
            return super.getAutoSizeMaxTextSize();
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8757KLFTb();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (AbstractC4689ua.f16857AZxh) {
            return super.getAutoSizeMinTextSize();
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8756JHa();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (AbstractC4689ua.f16857AZxh) {
            return super.getAutoSizeStepGranularity();
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8776xJ();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (AbstractC4689ua.f16857AZxh) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        return c2171IVlxe != null ? c2171IVlxe.m8769lgHUyS() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (AbstractC4689ua.f16857AZxh) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            return c2171IVlxe.m8772qdMbNW();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC4065l8.m12670rkYL(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f15485AZxh.m8751Dt();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f15485AZxh.m8752ETF();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8773rkYL(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe == null || AbstractC4689ua.f16857AZxh || !c2171IVlxe.m8761VA()) {
            return;
        }
        this.f15485AZxh.m8775wA();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().m10701wA(z);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (AbstractC4689ua.f16857AZxh) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8764diqgf(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (AbstractC4689ua.f16857AZxh) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8765eyqo(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (AbstractC4689ua.f16857AZxh) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8760Ucbh(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC4065l8.m12668qGY(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().m10699ZfxDd(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m10700mjFkc(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8759Pq(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f15486mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f15485AZxh.m8767huTpC(colorStateList);
        this.f15485AZxh.m8749AZxh();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f15485AZxh.m8753Gd(mode);
        this.f15485AZxh.m8749AZxh();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8766fehf(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (AbstractC4689ua.f16857AZxh) {
            super.setTextSize(i, f);
            return;
        }
        C2171IVlxe c2171IVlxe = this.f15485AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8762VocHEe(i, f);
        }
    }
}
