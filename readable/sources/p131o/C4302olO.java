package p131o;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.p020emoji2.p021text.C0084wA;

/* renamed from: o.olO */
/* loaded from: classes.dex */
public final class C4302olO extends InputConnectionWrapper {

    /* renamed from: AZxh */
    public final mjFkc f15844AZxh;

    /* renamed from: mjFkc */
    public final TextView f15845mjFkc;

    /* renamed from: o.olO$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public void m13036AZxh(EditorInfo editorInfo) {
            if (C0084wA.m691lgHUyS()) {
                C0084wA.m688AZxh().m703eyqo(editorInfo);
            }
        }

        /* renamed from: mjFkc */
        public boolean m13037mjFkc(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
            return C0084wA.m690KLFTb(inputConnection, editable, i, i2, z);
        }
    }

    public C4302olO(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new mjFkc());
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        return this.f15844AZxh.m13037mjFkc(this, m13035mjFkc(), i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return this.f15844AZxh.m13037mjFkc(this, m13035mjFkc(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }

    /* renamed from: mjFkc */
    public final Editable m13035mjFkc() {
        return this.f15845mjFkc.getEditableText();
    }

    public C4302olO(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, mjFkc mjfkc) {
        super(inputConnection, false);
        this.f15845mjFkc = textView;
        this.f15844AZxh = mjfkc;
        mjfkc.m13036AZxh(editorInfo);
    }
}
