package p122kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002¢\u0006\u0002\u0010\t\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m4988d2 = {"runInterruptible", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runInterruptibleInExpectedContext", "coroutineContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "WORKING", BuildConfig.f24315FLAVOR, "FINISHED", "INTERRUPTING", "INTERRUPTED", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class InterruptibleKt {
    private static final int FINISHED = 1;
    private static final int INTERRUPTED = 3;
    private static final int INTERRUPTING = 2;

    /* renamed from: WORKING */
    private static final int f5531WORKING = 0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", m6124f = "Interruptible.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.InterruptibleKt$runInterruptible$2 */
    public static final class C13412<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

        /* renamed from: $block */
        final /* synthetic */ Function0<T> f5532$block;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5533L$0;

        /* renamed from: label */
        int f5534label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13412(Function0<? extends T> function0, Continuation<? super C13412> continuation) {
            super(2, continuation);
            this.f5532$block = function0;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13412 c13412 = new C13412(this.f5532$block, continuation);
            c13412.f5533L$0 = obj;
            return c13412;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.f5533L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5534label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return InterruptibleKt.runInterruptibleInExpectedContext(coroutineScope.getCoroutineContext(), this.f5532$block);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C13412) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public static final <T> Object runInterruptible(CoroutineContext coroutineContext, Function0<? extends T> function0, Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineContext, new C13412(function0, null), continuation);
    }

    public static /* synthetic */ Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(coroutineContext, function0, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T runInterruptibleInExpectedContext(CoroutineContext coroutineContext, Function0<? extends T> function0) throws Throwable {
        try {
            ThreadState threadState = new ThreadState();
            threadState.m7036setup(C1344JobKt.m7015getJob(coroutineContext));
            try {
                return function0.mo4323invoke();
            } finally {
                threadState.clearInterrupt();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
