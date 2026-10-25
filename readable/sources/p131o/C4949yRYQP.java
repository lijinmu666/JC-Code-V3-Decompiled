package p131o;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.p020emoji2.p021text.C0084wA;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: o.yRYQP */
/* loaded from: classes.dex */
public final class C4949yRYQP implements TextWatcher {

    /* renamed from: AZxh */
    public final boolean f17515AZxh;

    /* renamed from: mjFkc */
    public final EditText f17519mjFkc;

    /* renamed from: wA */
    public C0084wA.KLFTb f17520wA;

    /* renamed from: ZfxDd */
    public int f17518ZfxDd = Integer.MAX_VALUE;

    /* renamed from: KLFTb */
    public int f17517KLFTb = 0;

    /* renamed from: JHa */
    public boolean f17516JHa = true;

    /* renamed from: o.yRYQP$mjFkc */
    public static class mjFkc extends C0084wA.KLFTb {

        /* renamed from: mjFkc */
        public final Reference f17521mjFkc;

        public mjFkc(EditText editText) {
            this.f17521mjFkc = new WeakReference(editText);
        }

        @Override // androidx.p020emoji2.p021text.C0084wA.KLFTb
        /* renamed from: AZxh */
        public void mo712AZxh() {
            super.mo712AZxh();
            C4949yRYQP.m14004AZxh((EditText) this.f17521mjFkc.get(), 1);
        }
    }

    public C4949yRYQP(EditText editText, boolean z) {
        this.f17519mjFkc = editText;
        this.f17515AZxh = z;
    }

    /* renamed from: AZxh */
    public static void m14004AZxh(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            C0084wA.m688AZxh().m707rkYL(editableText);
            C2199IxLrZ.m8807AZxh(editableText, selectionStart, selectionEnd);
        }
    }

    /* renamed from: ZfxDd */
    public final boolean m14005ZfxDd() {
        return (this.f17516JHa && (this.f17515AZxh || C0084wA.m691lgHUyS())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: mjFkc */
    public final C0084wA.KLFTb m14006mjFkc() {
        if (this.f17520wA == null) {
            this.f17520wA = new mjFkc(this.f17519mjFkc);
        }
        return this.f17520wA;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f17519mjFkc.isInEditMode() || m14005ZfxDd() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iM701ZfxDd = C0084wA.m688AZxh().m701ZfxDd();
        if (iM701ZfxDd != 0) {
            if (iM701ZfxDd == 1) {
                C0084wA.m688AZxh().m696IEE((Spannable) charSequence, i, i + i3, this.f17518ZfxDd, this.f17517KLFTb);
                return;
            } else if (iM701ZfxDd != 3) {
                return;
            }
        }
        C0084wA.m688AZxh().m698Pq(m14006mjFkc());
    }

    /* renamed from: wA */
    public void m14007wA(boolean z) {
        if (this.f17516JHa != z) {
            if (this.f17520wA != null) {
                C0084wA.m688AZxh().m702diqgf(this.f17520wA);
            }
            this.f17516JHa = z;
            if (z) {
                m14004AZxh(this.f17519mjFkc, C0084wA.m688AZxh().m701ZfxDd());
            }
        }
    }
}
