package p131o;

import android.view.View;

/* renamed from: o.HBzZAD */
/* loaded from: classes.dex */
public abstract class AbstractC2079HBzZAD {
    /* renamed from: mjFkc */
    public static String m8524mjFkc(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
