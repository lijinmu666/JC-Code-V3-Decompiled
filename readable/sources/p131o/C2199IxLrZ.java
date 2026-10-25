package p131o;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.p020emoji2.p021text.C0084wA;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: o.IxLrZ */
/* loaded from: classes.dex */
public final class C2199IxLrZ implements InputFilter {

    /* renamed from: AZxh */
    public C0084wA.KLFTb f8817AZxh;

    /* renamed from: mjFkc */
    public final TextView f8818mjFkc;

    /* renamed from: o.IxLrZ$mjFkc */
    public static class mjFkc extends C0084wA.KLFTb {

        /* renamed from: AZxh */
        public final Reference f8819AZxh;

        /* renamed from: mjFkc */
        public final Reference f8820mjFkc;

        public mjFkc(TextView textView, C2199IxLrZ c2199IxLrZ) {
            this.f8820mjFkc = new WeakReference(textView);
            this.f8819AZxh = new WeakReference(c2199IxLrZ);
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.KLFTb
        /* renamed from: AZxh */
        public void mo712AZxh() {
            CharSequence text;
            CharSequence charSequenceM707rkYL;
            super.mo712AZxh();
            TextView textView = (TextView) this.f8820mjFkc.get();
            if (m8809wA(textView, (InputFilter) this.f8819AZxh.get()) && textView.isAttachedToWindow() && text != (charSequenceM707rkYL = C0084wA.m688AZxh().m707rkYL((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceM707rkYL);
                int selectionEnd = Selection.getSelectionEnd(charSequenceM707rkYL);
                textView.setText(charSequenceM707rkYL);
                if (charSequenceM707rkYL instanceof Spannable) {
                    C2199IxLrZ.m8807AZxh((Spannable) charSequenceM707rkYL, selectionStart, selectionEnd);
                }
            }
        }

        /* renamed from: wA */
        public final boolean m8809wA(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public C2199IxLrZ(TextView textView) {
        this.f8818mjFkc = textView;
    }

    /* renamed from: AZxh */
    public static void m8807AZxh(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f8818mjFkc.isInEditMode()) {
            return charSequence;
        }
        int iM701ZfxDd = C0084wA.m688AZxh().m701ZfxDd();
        if (iM701ZfxDd != 0) {
            if (iM701ZfxDd == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.f8818mjFkc.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return C0084wA.m688AZxh().m705qGY(charSequence, 0, charSequence.length());
            }
            if (iM701ZfxDd != 3) {
                return charSequence;
            }
        }
        C0084wA.m688AZxh().m698Pq(m8808mjFkc());
        return charSequence;
    }

    /* renamed from: mjFkc */
    public final C0084wA.KLFTb m8808mjFkc() {
        if (this.f8817AZxh == null) {
            this.f8817AZxh = new mjFkc(this.f8818mjFkc, this);
        }
        return this.f8817AZxh;
    }
}
