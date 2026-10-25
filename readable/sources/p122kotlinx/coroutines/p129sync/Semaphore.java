package p122kotlinx.coroutines.p129sync;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\fÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/sync/Semaphore;", BuildConfig.f24315FLAVOR, "availablePermits", BuildConfig.f24315FLAVOR, "getAvailablePermits", "()I", "acquire", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAcquire", BuildConfig.f24315FLAVOR, BuildConfig.BUILD_TYPE, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface Semaphore {
    /* renamed from: acquire */
    Object m7501acquire(Continuation<? super C1133Unit> continuation);

    int getAvailablePermits();

    /* renamed from: release */
    void m7502release();

    boolean tryAcquire();
}
