package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* renamed from: o.SwgkN */
/* loaded from: classes.dex */
public abstract class AbstractC2862SwgkN extends EditText implements InterfaceC3537d3 {

    /* renamed from: AZxh */
    public final C2171IVlxe f10617AZxh;

    /* renamed from: JHa */
    public mjFkc f10618JHa;

    /* renamed from: KLFTb */
    public final C2216JBhc f10619KLFTb;

    /* renamed from: ZfxDd */
    public final C4129m8 f10620ZfxDd;

    /* renamed from: mjFkc */
    public final C2266JrJO f10621mjFkc;

    /* renamed from: wA */
    public final C4884xROA f10622wA;

    /* renamed from: o.SwgkN$mjFkc */
    public class mjFkc {
        public mjFkc() {
        }

        /* renamed from: AZxh */
        public void m10205AZxh(TextClassifier textClassifier) {
            AbstractC2862SwgkN.super.setTextClassifier(textClassifier);
        }

        /* renamed from: mjFkc */
        public TextClassifier m10206mjFkc() {
            return AbstractC2862SwgkN.super.getTextClassifier();
        }
    }

    public AbstractC2862SwgkN(Context context, AttributeSet attributeSet, int i) {
        super(C4861x8.m13900AZxh(context), attributeSet, i);
        AbstractC4326p8.m13067mjFkc(this, getContext());
        C2266JrJO c2266JrJO = new C2266JrJO(this);
        this.f10621mjFkc = c2266JrJO;
        c2266JrJO.m9059KLFTb(attributeSet, i);
        C2171IVlxe c2171IVlxe = new C2171IVlxe(this);
        this.f10617AZxh = c2171IVlxe;
        c2171IVlxe.m8758MiMN(attributeSet, i);
        c2171IVlxe.m8749AZxh();
        this.f10622wA = new C4884xROA(this);
        this.f10620ZfxDd = new C4129m8();
        C2216JBhc c2216JBhc = new C2216JBhc(this);
        this.f10619KLFTb = c2216JBhc;
        c2216JBhc.m8918wA(attributeSet, i);
        m10204ZfxDd(c2216JBhc);
    }

    private mjFkc getSuperCaller() {
        if (this.f10618JHa == null) {
            this.f10618JHa = new mjFkc();
        }
        return this.f10618JHa;
    }

    /* renamed from: ZfxDd */
    public void m10204ZfxDd(C2216JBhc c2216JBhc) {
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
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9055AZxh();
        }
        C2171IVlxe c2171IVlxe = this.f10617AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8749AZxh();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC4065l8.m12670rkYL(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9064wA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            return c2266JrJO.m9060ZfxDd();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f10617AZxh.m8751Dt();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f10617AZxh.m8752ETF();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().m10206mjFkc();
    }

    @Override // p131o.InterfaceC3537d3
    /* renamed from: mjFkc */
    public C1901EcuP mo10138mjFkc(C1901EcuP c1901EcuP) {
        return this.f10620ZfxDd.mo11599mjFkc(this, c1901EcuP);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrM10292vI;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f10617AZxh.m8755IEE(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionM12442mjFkc = AbstractC3971jm.m12442mjFkc(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionM12442mjFkc != null && Build.VERSION.SDK_INT <= 30 && (strArrM10292vI = AbstractC2876T9.m10292vI(this)) != null) {
            AbstractC3260YuaD.m11143wA(editorInfo, strArrM10292vI);
            inputConnectionM12442mjFkc = AbstractC2476N.m9571wA(this, inputConnectionM12442mjFkc, editorInfo);
        }
        return this.f10619KLFTb.m8916ZfxDd(inputConnectionM12442mjFkc, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC4963yfx.m14043mjFkc(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (AbstractC4963yfx.m14042AZxh(this, i)) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9058JHa(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9065xJ(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f10617AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2171IVlxe c2171IVlxe = this.f10617AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8771qGY();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC4065l8.m12668qGY(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f10619KLFTb.m8915KLFTb(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f10619KLFTb.m8917mjFkc(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9063qdMbNW(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2266JrJO c2266JrJO = this.f10621mjFkc;
        if (c2266JrJO != null) {
            c2266JrJO.m9056Dt(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f10617AZxh.m8767huTpC(colorStateList);
        this.f10617AZxh.m8749AZxh();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f10617AZxh.m8753Gd(mode);
        this.f10617AZxh.m8749AZxh();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C2171IVlxe c2171IVlxe = this.f10617AZxh;
        if (c2171IVlxe != null) {
            c2171IVlxe.m8766fehf(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().m10205AZxh(textClassifier);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }
}
