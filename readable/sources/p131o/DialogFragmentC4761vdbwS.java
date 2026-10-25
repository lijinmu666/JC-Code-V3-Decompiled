package p131o;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: o.vdbwS */
/* loaded from: classes.dex */
public class DialogFragmentC4761vdbwS extends DialogFragment {

    /* renamed from: AZxh */
    public DialogInterface.OnCancelListener f17033AZxh;

    /* renamed from: mjFkc */
    public Dialog f17034mjFkc;

    /* renamed from: wA */
    public Dialog f17035wA;

    /* renamed from: mjFkc */
    public static DialogFragmentC4761vdbwS m13790mjFkc(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC4761vdbwS dialogFragmentC4761vdbwS = new DialogFragmentC4761vdbwS();
        Dialog dialog2 = (Dialog) AbstractC2138I3.m8644lgHUyS(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC4761vdbwS.f17034mjFkc = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC4761vdbwS.f17033AZxh = onCancelListener;
        }
        return dialogFragmentC4761vdbwS;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f17033AZxh;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f17034mjFkc;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f17035wA == null) {
            this.f17035wA = new AlertDialog.Builder((Context) AbstractC2138I3.m8648xJ(getActivity())).create();
        }
        return this.f17035wA;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
