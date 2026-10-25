package p122kotlinx.coroutines.scheduling;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p122kotlinx.coroutines.CoroutineDispatcher;
import p122kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u000f"}, m4988d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "<init>", "()V", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", BuildConfig.f24315FLAVOR, "name", BuildConfig.f24315FLAVOR, "shutdown", BuildConfig.f24315FLAVOR, "shutdown$kotlinx_coroutines_core", "close", "toString", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE = new DefaultScheduler();

    private DefaultScheduler() {
        super(C1583TasksKt.CORE_POOL_SIZE, C1583TasksKt.MAX_POOL_SIZE, C1583TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, C1583TasksKt.DEFAULT_SCHEDULER_NAME);
    }

    @Override // p122kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher, p122kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism, String name) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return parallelism >= C1583TasksKt.CORE_POOL_SIZE ? LimitedDispatcherKt.namedOrThis(this, name) : super.limitedParallelism(parallelism, name);
    }

    public final void shutdown$kotlinx_coroutines_core() {
        super.close();
    }

    @Override // p122kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: toString */
    public String getName() {
        return "Dispatchers.Default";
    }
}
