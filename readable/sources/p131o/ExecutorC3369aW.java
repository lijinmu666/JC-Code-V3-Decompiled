package p131o;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: o.aW */
/* loaded from: classes.dex */
public final class ExecutorC3369aW implements Executor {

    /* renamed from: mjFkc */
    public final Handler f12763mjFkc = new HandlerC4932yB(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f12763mjFkc.post(runnable);
    }
}
