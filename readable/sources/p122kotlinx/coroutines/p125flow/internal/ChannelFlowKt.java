package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.TypeIntrinsics;
import p122kotlinx.coroutines.internal.ThreadContextKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001aX\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\t2\b\b\u0002\u0010\f\u001a\u00020\r2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0080@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m4988d2 = {"asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "withContextUndispatched", "V", "newContext", "value", "countOrElement", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,240:1\n103#2,5:241\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n220#1:241,5\n*E\n"})
/* loaded from: classes.dex */
public final class ChannelFlowKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlowKt", m6124f = "ChannelFlow.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {221}, m6127m = "withContextUndispatched", m6128n = {"newContext", "value", "countOrElement", "block", "context$iv", "countOrElement$iv", "oldValue$iv", "$i$f$withCoroutineContext", "$i$a$-withCoroutineContext-ChannelFlowKt$withContextUndispatched$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$1 */
    public static final class C15631<T, V> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f7074I$0;

        /* renamed from: I$1 */
        int f7075I$1;

        /* renamed from: L$0 */
        Object f7076L$0;

        /* renamed from: L$1 */
        Object f7077L$1;

        /* renamed from: L$2 */
        Object f7078L$2;

        /* renamed from: L$3 */
        Object f7079L$3;

        /* renamed from: L$4 */
        Object f7080L$4;

        /* renamed from: L$5 */
        Object f7081L$5;

        /* renamed from: L$6 */
        Object f7082L$6;

        /* renamed from: L$7 */
        Object f7083L$7;

        /* renamed from: label */
        int f7084label;

        /* renamed from: result */
        /* synthetic */ Object f7085result;

        public C15631(Continuation<? super C15631> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7085result = obj;
            this.f7084label |= Integer.MIN_VALUE;
            return ChannelFlowKt.withContextUndispatched(null, null, null, null, this);
        }
    }

    public static final <T> ChannelFlow<T> asChannelFlow(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        ChannelFlow<T> channelFlow = interfaceC1426Flow instanceof ChannelFlow ? (ChannelFlow) interfaceC1426Flow : null;
        if (channelFlow == null) {
            return new ChannelFlowOperatorImpl(interfaceC1426Flow, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, V> Object withContextUndispatched(CoroutineContext coroutineContext, V v, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        C15631 c15631;
        Object objUpdateThreadContext;
        Object objWrapWithContinuationImpl;
        if (continuation instanceof C15631) {
            c15631 = (C15631) continuation;
            int i = c15631.f7084label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15631.f7084label = i - Integer.MIN_VALUE;
            } else {
                c15631 = new C15631(continuation);
            }
        }
        Object obj2 = c15631.f7085result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15631.f7084label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj3 = c15631.f7082L$6;
            CoroutineContext coroutineContext2 = (CoroutineContext) c15631.f7080L$4;
            try {
                ResultKt.throwOnFailure(obj2);
                objUpdateThreadContext = obj3;
                coroutineContext = coroutineContext2;
                objWrapWithContinuationImpl = obj2;
                ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                return objWrapWithContinuationImpl;
            } catch (Throwable th) {
                th = th;
                objUpdateThreadContext = obj3;
                coroutineContext = coroutineContext2;
                ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj2);
        objUpdateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            c15631.f7076L$0 = coroutineContext;
            c15631.f7077L$1 = v;
            c15631.f7078L$2 = SpillingKt.nullOutSpilledVariable(obj);
            c15631.f7079L$3 = function2;
            c15631.f7080L$4 = coroutineContext;
            c15631.f7081L$5 = SpillingKt.nullOutSpilledVariable(obj);
            c15631.f7082L$6 = objUpdateThreadContext;
            c15631.f7083L$7 = c15631;
            c15631.f7074I$0 = 0;
            c15631.f7075I$1 = 0;
            c15631.f7084label = 1;
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(c15631, coroutineContext);
            objWrapWithContinuationImpl = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, v, stackFrameContinuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo2167invoke(v, stackFrameContinuation);
            if (objWrapWithContinuationImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c15631);
            }
            if (objWrapWithContinuationImpl == coroutine_suspended) {
                return coroutine_suspended;
            }
            ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            return objWrapWithContinuationImpl;
        } catch (Throwable th2) {
            th = th2;
            ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            throw th;
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, obj2, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }
}
