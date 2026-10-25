package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.InterfaceC1342Job;

@Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
@Metadata(m4987d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H'¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface ParentJob extends InterfaceC1342Job {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        /* renamed from: fold */
        public static <R> R m7027fold(ParentJob parentJob, R r, Function2<? super R, ? super CoroutineContext.InterfaceC1197Element, ? extends R> function2) {
            return (R) InterfaceC1342Job.DefaultImpls.m7004fold(parentJob, r, function2);
        }

        /* renamed from: get */
        public static <E extends CoroutineContext.InterfaceC1197Element> E m7028get(ParentJob parentJob, CoroutineContext.InterfaceC1198Key<E> interfaceC1198Key) {
            return (E) InterfaceC1342Job.DefaultImpls.m7005get(parentJob, interfaceC1198Key);
        }

        public static CoroutineContext minusKey(ParentJob parentJob, CoroutineContext.InterfaceC1198Key<?> interfaceC1198Key) {
            return InterfaceC1342Job.DefaultImpls.minusKey(parentJob, interfaceC1198Key);
        }

        /* renamed from: plus */
        public static CoroutineContext m7029plus(ParentJob parentJob, CoroutineContext coroutineContext) {
            return InterfaceC1342Job.DefaultImpls.m7006plus(parentJob, coroutineContext);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @Deprecated
        /* renamed from: plus */
        public static InterfaceC1342Job m7030plus(ParentJob parentJob, InterfaceC1342Job interfaceC1342Job) {
            return ParentJob.super.mo7001plus(interfaceC1342Job);
        }
    }

    @InternalCoroutinesApi
    CancellationException getChildJobCancellationCause();
}
