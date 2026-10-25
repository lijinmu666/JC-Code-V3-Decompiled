package com.p038google.p039android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2862SwgkN;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4922y1;

/* loaded from: classes.dex */
public class TextInputEditText extends AbstractC2862SwgkN {

    /* renamed from: lgHUyS */
    public boolean f2810lgHUyS;

    /* renamed from: xJ */
    public final Rect f2811xJ;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13949qdMbNW);
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.m3171getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* renamed from: KLFTb */
    public final boolean m3118KLFTb(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f2810lgHUyS;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!m3118KLFTb(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f2811xJ);
        rect.bottom = this.f2811xJ.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return m3118KLFTb(textInputLayout) ? textInputLayout.getGlobalVisibleRect(rect, point) : super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.m3190vadzgd()) ? super.getHint() : textInputLayout.m3171getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.m3190vadzgd() && super.getHint() == null && AbstractC4922y1.m13981mjFkc()) {
            setHint(BuildConfig.f24315FLAVOR);
        }
    }

    @Override // p131o.AbstractC2862SwgkN, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!m3118KLFTb(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f2811xJ.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f2811xJ);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.f2810lgHUyS = z;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, 0), attributeSet, i);
        this.f2811xJ = new Rect();
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context, attributeSet, AbstractC3340a5.f12623olO, i, AbstractC2737R4.f10371ZfxDd, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12391IxLrZ, false));
        typedArrayM12940lgHUyS.recycle();
    }
}
