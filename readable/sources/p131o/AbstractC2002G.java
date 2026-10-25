package p131o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.p038google.p039android.material.internal.CheckableImageButton;
import com.p038google.p039android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* renamed from: o.G */
/* loaded from: classes.dex */
public abstract class AbstractC2002G {
    /* renamed from: AZxh */
    public static ImageView.ScaleType m8345AZxh(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    /* renamed from: Dt */
    public static void m8346Dt(CheckableImageButton checkableImageButton, ImageView.ScaleType scaleType) {
        checkableImageButton.setScaleType(scaleType);
    }

    /* renamed from: JHa */
    public static void m8347JHa(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zM10225CqaNbM = AbstractC2876T9.m10225CqaNbM(checkableImageButton);
        boolean z = onLongClickListener != null;
        boolean z2 = zM10225CqaNbM || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zM10225CqaNbM);
        checkableImageButton.setPressable(zM10225CqaNbM);
        checkableImageButton.setLongClickable(z);
        AbstractC2876T9.m10244NKyg(checkableImageButton, z2 ? 1 : 2);
    }

    /* renamed from: KLFTb */
    public static void m8348KLFTb(CheckableImageButton checkableImageButton) {
    }

    /* renamed from: ZfxDd */
    public static void m8349ZfxDd(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(m8353wA(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = AbstractC4332pCk.m13077VA(drawable).mutate();
        AbstractC4332pCk.m13081qdMbNW(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    /* renamed from: lgHUyS */
    public static void m8350lgHUyS(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        m8347JHa(checkableImageButton, onLongClickListener);
    }

    /* renamed from: mjFkc */
    public static void m8351mjFkc(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = AbstractC4332pCk.m13077VA(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                AbstractC4332pCk.m13081qdMbNW(drawable, colorStateList);
            } else {
                AbstractC4332pCk.m13081qdMbNW(drawable, ColorStateList.valueOf(colorStateList.getColorForState(m8353wA(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                AbstractC4332pCk.m13073Dt(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    /* renamed from: qdMbNW */
    public static void m8352qdMbNW(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m8347JHa(checkableImageButton, onLongClickListener);
    }

    /* renamed from: wA */
    public static int[] m8353wA(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    /* renamed from: xJ */
    public static void m8354xJ(CheckableImageButton checkableImageButton, int i) {
        checkableImageButton.setMinimumWidth(i);
        checkableImageButton.setMinimumHeight(i);
    }
}
