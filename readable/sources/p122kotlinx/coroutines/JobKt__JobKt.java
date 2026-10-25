package p122kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0019\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\b\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0002H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0019\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0019\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015\u001a\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a\u001b\u0010!\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\"\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018\"\u0015\u0010\u001e\u001a\u00020\u0002*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, m4988d2 = {"invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "invokeImmediately", BuildConfig.f24315FLAVOR, "handler", "Lkotlinx/coroutines/JobNode;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "disposeOnCompletion", "handle", "cancelAndJoin", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", BuildConfig.f24315FLAVOR, "isActive", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "cancel", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "message", BuildConfig.f24315FLAVOR, "job", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/JobKt")
@SourceDebugExtension(m6344value = {"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,692:1\n1321#2,2:693\n1321#2,2:695\n1321#2,2:697\n1321#2,2:699\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n520#1:693,2\n534#1:695,2\n628#1:697,2\n652#1:699,2\n*E\n"})
/* loaded from: classes.dex */
public final /* synthetic */ class JobKt__JobKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1 */
    public static final /* synthetic */ class C13451 extends FunctionReferenceImpl implements Function1<Throwable, C1133Unit> {
        public C13451(Object obj) {
            super(1, obj, AbstractC1346JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // p094kotlin.p105jvm.functions.Function1
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(Throwable th) {
            invoke2(th);
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((AbstractC1346JobNode) this.receiver).mo6904invoke(th);
        }
    }

    /* renamed from: Job */
    public static final CompletableJob m7016Job(InterfaceC1342Job interfaceC1342Job) {
        return new C1343JobImpl(interfaceC1342Job);
    }

    public static /* synthetic */ CompletableJob Job$default(InterfaceC1342Job interfaceC1342Job, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC1342Job = null;
        }
        return C1344JobKt.m7009Job(interfaceC1342Job);
    }

    /* renamed from: cancel */
    public static final void m7019cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            interfaceC1342Job.mo6998cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C1344JobKt.m7012cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(InterfaceC1342Job interfaceC1342Job, Continuation<? super C1133Unit> continuation) {
        InterfaceC1342Job.cancel$default(interfaceC1342Job, (CancellationException) null, 1, (Object) null);
        Object objMo7000join = interfaceC1342Job.mo7000join(continuation);
        return objMo7000join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo7000join : C1133Unit.INSTANCE;
    }

    public static final void cancelChildren(InterfaceC1342Job interfaceC1342Job, CancellationException cancellationException) {
        Iterator<InterfaceC1342Job> it = interfaceC1342Job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().mo6998cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(InterfaceC1342Job interfaceC1342Job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C1344JobKt.cancelChildren(interfaceC1342Job, cancellationException);
    }

    public static final DisposableHandle disposeOnCompletion(InterfaceC1342Job interfaceC1342Job, DisposableHandle disposableHandle) {
        return invokeOnCompletion$default(interfaceC1342Job, false, new DisposeOnCompletion(disposableHandle), 1, null);
    }

    public static final void ensureActive(InterfaceC1342Job interfaceC1342Job) {
        if (!interfaceC1342Job.isActive()) {
            throw interfaceC1342Job.getCancellationException();
        }
    }

    /* renamed from: getJob */
    public static final InterfaceC1342Job m7022getJob(CoroutineContext coroutineContext) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            return interfaceC1342Job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final DisposableHandle invokeOnCompletion(InterfaceC1342Job interfaceC1342Job, boolean z, AbstractC1346JobNode abstractC1346JobNode) {
        return interfaceC1342Job instanceof JobSupport ? ((JobSupport) interfaceC1342Job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, abstractC1346JobNode) : interfaceC1342Job.invokeOnCompletion(abstractC1346JobNode.getOnCancelling(), z, new C13451(abstractC1346JobNode));
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(InterfaceC1342Job interfaceC1342Job, boolean z, AbstractC1346JobNode abstractC1346JobNode, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return C1344JobKt.invokeOnCompletion(interfaceC1342Job, z, abstractC1346JobNode);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            return interfaceC1342Job.isActive();
        }
        return true;
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable th, InterfaceC1342Job interfaceC1342Job) {
        return th == null ? new JobCancellationException("Job was cancelled", null, interfaceC1342Job) : th;
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @InterfaceC1231JvmName(m6260name = "Job")
    /* renamed from: Job */
    public static final /* synthetic */ InterfaceC1342Job m7017Job(InterfaceC1342Job interfaceC1342Job) {
        return C1344JobKt.m7009Job(interfaceC1342Job);
    }

    /* renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ InterfaceC1342Job m19984Job$default(InterfaceC1342Job interfaceC1342Job, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC1342Job = null;
        }
        return m7017Job(interfaceC1342Job);
    }

    public static /* synthetic */ void cancel$default(InterfaceC1342Job interfaceC1342Job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        C1344JobKt.m7013cancel(interfaceC1342Job, str, th);
    }

    public static /* synthetic */ void cancelChildren$default(InterfaceC1342Job interfaceC1342Job, Throwable th, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(interfaceC1342Job, th);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job != null) {
            C1344JobKt.ensureActive(interfaceC1342Job);
        }
    }

    /* renamed from: cancel */
    public static final void m7020cancel(InterfaceC1342Job interfaceC1342Job, String str, Throwable th) {
        interfaceC1342Job.mo6998cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return m7021cancel(coroutineContext, th);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C1344JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* renamed from: cancel */
    public static final /* synthetic */ boolean m7021cancel(CoroutineContext coroutineContext, Throwable th) throws Throwable {
        CoroutineContext.InterfaceC1197Element interfaceC1197ElementMo6098get = coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        JobSupport jobSupport = interfaceC1197ElementMo6098get instanceof JobSupport ? (JobSupport) interfaceC1197ElementMo6098get : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(InterfaceC1342Job interfaceC1342Job, Throwable th) throws Throwable {
        for (InterfaceC1342Job interfaceC1342Job2 : interfaceC1342Job.getChildren()) {
            JobSupport jobSupport = interfaceC1342Job2 instanceof JobSupport ? (JobSupport) interfaceC1342Job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, interfaceC1342Job));
            }
        }
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<InterfaceC1342Job> children;
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job == null || (children = interfaceC1342Job.getChildren()) == null) {
            return;
        }
        Iterator<InterfaceC1342Job> it = children.iterator();
        while (it.hasNext()) {
            it.next().mo6998cancel(cancellationException);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th) throws Throwable {
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE);
        if (interfaceC1342Job == null) {
            return;
        }
        for (InterfaceC1342Job interfaceC1342Job2 : interfaceC1342Job.getChildren()) {
            JobSupport jobSupport = interfaceC1342Job2 instanceof JobSupport ? (JobSupport) interfaceC1342Job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, interfaceC1342Job));
            }
        }
    }
}
