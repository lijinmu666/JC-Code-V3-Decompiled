package p131o;

import android.os.Handler;
import android.os.Looper;

/* renamed from: o.oL */
/* loaded from: classes.dex */
public class HandlerC4274oL extends Handler {

    /* renamed from: mjFkc */
    public final Looper f15526mjFkc;

    public HandlerC4274oL(Looper looper) {
        super(looper);
        this.f15526mjFkc = Looper.getMainLooper();
    }

    public HandlerC4274oL(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f15526mjFkc = Looper.getMainLooper();
    }
}
