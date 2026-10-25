package p131o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* renamed from: o.JYgkl */
/* loaded from: classes.dex */
public abstract class AbstractC2244JYgkl extends AutoCompleteTextView {

    /* renamed from: ZfxDd */
    public static final int[] f8988ZfxDd = {R.attr.popupBackground};

    /* renamed from: AZxh */
    public final C2171IVlxe f8989AZxh;

    /* renamed from: mjFkc */
    public final C2266JrJO f8990mjFkc;

    /* renamed from: wA */
    public final C2216JBhc f8991wA;

    public AbstractC2244JYgkl(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(getContext(), attributeSet, f8988ZfxDd, i, 0);
        if (c1606a8M7575diqgf.m7586fehf(0)) {
            setDropDownBackgroundDrawable(c1606a8M7575diqgf.m7593xJ(0));
        }
        c1606a8M7575diqgf.m7585eyqo();
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f8990mjFkc = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C2171IVlxe c2171IVlxe = new C2171IVlxe(this);
        this.f8989AZxh = c2171IVlxe;
        c2171IVlxe.m8758MiMN(attributeSet, i);
        c2171IVlxe.m8749AZxh();
        C2216JBhc c2216JBhc = new C2216JBhc(this);
        this.f8991wA = c2216JBhc;
        c2216JBhc.m8918wA(attributeSet, i);
        m8984mjFkc(c2216JBhc);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C2171IVlxe c2171IVlxe = this.f8989AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8749AZxh();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC4065l8.m12670rkYL(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8989AZxh.m8751Dt();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8989AZxh.m8752ETF();
    }

    /* renamed from: mjFkc */
    public void m8984mjFkc(C2216JBhc c2216JBhc) {
        KeyListener keyListener = getKeyListener();
        if (c2216JBhc.m8914AZxh(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerM8917mjFkc = c2216JBhc.m8917mjFkc(keyListener);
            if (keyListenerM8917mjFkc == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerM8917mjFkc);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f8991wA.m8916ZfxDd(AbstractC3971jm.m12442mjFkc(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f8989AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f8989AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC4065l8.m12668qGY(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AbstractC4768vjlshU.m13794AZxh(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f8991wA.m8915KLFTb(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8991wA.m8917mjFkc(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f8990mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8989AZxh.m8767huTpC(colorStateList);
        this.f8989AZxh.m8749AZxh();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8989AZxh.m8753Gd(mode);
        this.f8989AZxh.m8749AZxh();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C2171IVlxe c2171IVlxe = this.f8989AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8766fehf(context, i);
        }
    }
}
