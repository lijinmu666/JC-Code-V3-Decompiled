package p131o;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* renamed from: o.ad */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterfaceOnClickListenerC3374ad implements DialogInterface.OnClickListener {
    /* renamed from: AZxh */
    public static AbstractDialogInterfaceOnClickListenerC3374ad m11392AZxh(Activity activity, Intent intent, int i) {
        return new C2319Kc(intent, activity, i);
    }

    /* renamed from: wA */
    public static AbstractDialogInterfaceOnClickListenerC3374ad m11393wA(InterfaceC2929U0 interfaceC2929U0, Intent intent, int i) {
        return new C3305Zc(intent, interfaceC2929U0, 2);
    }

    /* renamed from: mjFkc */
    public abstract void mo9268mjFkc();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                mo9268mjFkc();
            } catch (ActivityNotFoundException e) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
