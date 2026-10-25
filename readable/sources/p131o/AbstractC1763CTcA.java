package p131o;

import android.os.Handler;
import android.os.Looper;

/* renamed from: o.CTcA */
/* loaded from: classes.dex */
public abstract class AbstractC1763CTcA {
    /* renamed from: mjFkc */
    public static Handler m7846mjFkc() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
