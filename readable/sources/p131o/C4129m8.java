package p131o;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* renamed from: o.m8 */
/* loaded from: classes.dex */
public final class C4129m8 implements InterfaceC3472c3 {
    /* renamed from: AZxh */
    public static CharSequence m12753AZxh(Context context, ClipData.Item item, int i) {
        if ((i & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }

    /* renamed from: wA */
    public static void m12754wA(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // p131o.InterfaceC3472c3
    /* renamed from: mjFkc */
    public C1901EcuP mo11599mjFkc(View view, C1901EcuP c1901EcuP) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c1901EcuP);
        }
        if (c1901EcuP.m8153ZfxDd() == 2) {
            return c1901EcuP;
        }
        ClipData clipDataM8151AZxh = c1901EcuP.m8151AZxh();
        int iM8154wA = c1901EcuP.m8154wA();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < clipDataM8151AZxh.getItemCount(); i++) {
            CharSequence charSequenceM12753AZxh = m12753AZxh(context, clipDataM8151AZxh.getItemAt(i), iM8154wA);
            if (charSequenceM12753AZxh != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceM12753AZxh);
                } else {
                    m12754wA(editable, charSequenceM12753AZxh);
                    z = true;
                }
            }
        }
        return null;
    }
}
