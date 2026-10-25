package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

@Metadata(m4987d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010 J%\u0010\u001e\u001a\u0004\u0018\u00010\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J'\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, m4988d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "collectContextSize", BuildConfig.f24315FLAVOR, "lastEmissionContext", "completion_", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "invokeSuspend", BuildConfig.f24315FLAVOR, "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "checkContext", "currentContext", "previousContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: classes.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    @JvmField
    public final CoroutineContext collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    public final FlowCollector<T> collector;
    private Continuation<? super C1133Unit> completion_;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.mo6097fold(0, new Function2() { // from class: o.f6
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return Integer.valueOf(SafeCollector.collectContextSize$lambda$0(((Integer) obj).intValue(), (CoroutineContext.InterfaceC1197Element) obj2));
            }
        })).intValue();
    }

    private final void checkContext(CoroutineContext currentContext, CoroutineContext previousContext, T value) {
        if (previousContext instanceof DownstreamExceptionContext) {
            exceptionTransparencyViolated((DownstreamExceptionContext) previousContext, value);
        }
        SafeCollector_commonKt.checkContext(this, currentContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int collectContextSize$lambda$0(int i, CoroutineContext.InterfaceC1197Element interfaceC1197Element) {
        return i + 1;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext exception, Object value) {
        throw new IllegalStateException(StringsKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + exception.e + ", but then emission attempt of value '" + value + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        try {
            Object objM7393emit = m7393emit(continuation, (Continuation<? super C1133Unit>) t);
            if (objM7393emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return objM7393emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7393emit : C1133Unit.INSTANCE;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionContext(th, continuation.getContext());
            throw th;
        }
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl, p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super C1133Unit> continuation = this.completion_;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.ContinuationImpl, p094kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl, p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object result) {
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(result);
        if (thM18549exceptionOrNullimpl != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(thM18549exceptionOrNullimpl, getContext());
        }
        Continuation<? super C1133Unit> continuation = this.completion_;
        if (continuation != null) {
            continuation.resumeWith(result);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.ContinuationImpl, p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    /* renamed from: emit */
    private final Object m7393emit(Continuation<? super C1133Unit> uCont, T value) {
        CoroutineContext context = uCont.getContext();
        C1344JobKt.ensureActive(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, value);
            this.lastEmissionContext = context;
        }
        this.completion_ = uCont;
        Function3 function3 = SafeCollectorKt.f7174emitFun;
        FlowCollector<T> flowCollector = this.collector;
        Intrinsics.checkNotNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objMo6219invoke = function3.mo6219invoke(flowCollector, value, this);
        if (!Intrinsics.areEqual(objMo6219invoke, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.completion_ = null;
        }
        return objMo6219invoke;
    }
}
