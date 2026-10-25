package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u0002H\u0002¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u000e"}, m4988d2 = {"completeWith", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/CompletableDeferred;", "result", "Lkotlin/Result;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "CompletableDeferred", "parent", "Lkotlinx/coroutines/Job;", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "asDeferred", "Lkotlinx/coroutines/Deferred;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
/* loaded from: classes.dex */
public final class CompletableDeferredKt {
    public static final <T> CompletableDeferred<T> CompletableDeferred(InterfaceC1342Job interfaceC1342Job) {
        return new CompletableDeferredImpl(interfaceC1342Job);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(InterfaceC1342Job interfaceC1342Job, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC1342Job = null;
        }
        return CompletableDeferred(interfaceC1342Job);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Deferred<T> asDeferred(CompletableDeferred<T> completableDeferred) {
        return new ReadonlyDeferred(completableDeferred);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean completeWith(CompletableDeferred<T> completableDeferred, Object obj) {
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(obj);
        return thM18549exceptionOrNullimpl == null ? completableDeferred.complete(obj) : completableDeferred.completeExceptionally(thM18549exceptionOrNullimpl);
    }

    public static final <T> CompletableDeferred<T> CompletableDeferred(T t) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(null);
        completableDeferredImpl.complete(t);
        return completableDeferredImpl;
    }
}
