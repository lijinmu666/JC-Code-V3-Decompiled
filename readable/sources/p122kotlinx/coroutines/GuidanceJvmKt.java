package p122kotlinx.coroutines;

import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m4988d2 = {"runInterruptible", "T", "context", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class GuidanceJvmKt {
    @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Passing a Job to `runInterruptible` prevents it from being cancelled when the caller gets cancelled. This pattern should be avoided. This overload will be deprecated with an error in the future.")
    public static final <T> Object runInterruptible(InterfaceC1342Job interfaceC1342Job, Function0<? extends T> function0, Continuation<? super T> continuation) {
        Intrinsics.checkNotNull(interfaceC1342Job, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext");
        return InterruptibleKt.runInterruptible(interfaceC1342Job, function0, continuation);
    }
}
