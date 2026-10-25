package p122kotlinx.coroutines.scheduling;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p122kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0005"}, m4988d2 = {"isSchedulerWorker", BuildConfig.f24315FLAVOR, "thread", "Ljava/lang/Thread;", "mayNotBlock", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CoroutineSchedulerKt {
    @InterfaceC1231JvmName(m6260name = "isSchedulerWorker")
    public static final boolean isSchedulerWorker(Thread thread) {
        return thread instanceof CoroutineScheduler.C1581Worker;
    }

    @InterfaceC1231JvmName(m6260name = "mayNotBlock")
    public static final boolean mayNotBlock(Thread thread) {
        return (thread instanceof CoroutineScheduler.C1581Worker) && ((CoroutineScheduler.C1581Worker) thread).state == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
