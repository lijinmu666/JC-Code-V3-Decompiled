package p131o;

import android.os.Handler;
import android.os.Looper;

/* renamed from: o.Hd */
/* loaded from: classes.dex */
public class HandlerC2110Hd extends Handler {

    /* renamed from: mjFkc */
    public final Looper f8624mjFkc;

    public HandlerC2110Hd(Looper looper) {
        super(looper);
        this.f8624mjFkc = Looper.getMainLooper();
    }

    public HandlerC2110Hd(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f8624mjFkc = Looper.getMainLooper();
    }
}
