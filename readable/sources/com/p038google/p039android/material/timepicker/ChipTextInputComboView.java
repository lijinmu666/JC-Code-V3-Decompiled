package com.p038google.p039android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.p038google.p039android.material.p059chip.C0251Chip;
import com.p038google.p039android.material.textfield.TextInputLayout;
import p131o.AbstractC1803D4;
import p131o.AbstractC2007G4;
import p131o.AbstractC2876T9;
import p131o.AbstractC4195n8;
import p131o.AbstractC4557sa;
import p131o.C4528s8;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: AZxh */
    public final TextInputLayout f2926AZxh;

    /* renamed from: KLFTb */
    public TextView f2927KLFTb;

    /* renamed from: ZfxDd */
    public TextWatcher f2928ZfxDd;

    /* renamed from: mjFkc */
    public final C0251Chip f2929mjFkc;

    /* renamed from: wA */
    public final EditText f2930wA;

    /* renamed from: com.google.android.material.timepicker.ChipTextInputComboView$AZxh */
    public class C0293AZxh extends AbstractC4195n8 {
        public C0293AZxh() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f2929mjFkc.setText(ChipTextInputComboView.this.m3284wA("00"));
                return;
            }
            String strM3284wA = ChipTextInputComboView.this.m3284wA(editable);
            C0251Chip c0251Chip = ChipTextInputComboView.this.f2929mjFkc;
            if (TextUtils.isEmpty(strM3284wA)) {
                strM3284wA = ChipTextInputComboView.this.m3284wA("00");
            }
            c0251Chip.setText(strM3284wA);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: ZfxDd */
    public final void m3283ZfxDd() {
        this.f2930wA.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2929mjFkc.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3283ZfxDd();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.f2929mjFkc.setChecked(z);
        this.f2930wA.setVisibility(z ? 0 : 4);
        this.f2929mjFkc.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            AbstractC4557sa.m13505lgHUyS(this.f2930wA);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2929mjFkc.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.f2929mjFkc.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f2929mjFkc.toggle();
    }

    /* renamed from: wA */
    public final String m3284wA(CharSequence charSequence) {
        return C4528s8.m13486mjFkc(getResources(), charSequence);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        C0251Chip c0251Chip = (C0251Chip) layoutInflaterFrom.inflate(AbstractC2007G4.f8325qdMbNW, (ViewGroup) this, false);
        this.f2929mjFkc = c0251Chip;
        c0251Chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(AbstractC2007G4.f8309Dt, (ViewGroup) this, false);
        this.f2926AZxh = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f2930wA = editText;
        editText.setVisibility(4);
        C0293AZxh c0293AZxh = new C0293AZxh();
        this.f2928ZfxDd = c0293AZxh;
        editText.addTextChangedListener(c0293AZxh);
        m3283ZfxDd();
        addView(c0251Chip);
        addView(textInputLayout);
        this.f2927KLFTb = (TextView) findViewById(AbstractC1803D4.f7803VA);
        editText.setId(AbstractC2876T9.m10280lgHUyS());
        AbstractC2876T9.m10290tjSezt(this.f2927KLFTb, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
