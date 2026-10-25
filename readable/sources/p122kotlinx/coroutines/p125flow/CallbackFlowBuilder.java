package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlow;

@Metadata(m4987d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BT\u0012-\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R7\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, m4988d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class CallbackFlowBuilder<T> extends ChannelFlowBuilder<T> {
    private final Function2<ProducerScope<? super T>, Continuation<? super C1133Unit>, Object> block;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.CallbackFlowBuilder", m6124f = "Builders.kt", m6125i = {0}, m6126l = {330}, m6127m = "collectTo", m6128n = {"scope"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 */
    public static final class C14231 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6056L$0;

        /* renamed from: label */
        int f6057label;

        /* renamed from: result */
        /* synthetic */ Object f6058result;

        /* renamed from: this$0 */
        final /* synthetic */ CallbackFlowBuilder<T> f6059this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14231(CallbackFlowBuilder<T> callbackFlowBuilder, Continuation<? super C14231> continuation) {
            super(continuation);
            this.f6059this$0 = callbackFlowBuilder;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6058result = obj;
            this.f6057label |= Integer.MIN_VALUE;
            return this.f6059this$0.collectTo(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(Function2<? super ProducerScope<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(function2, coroutineContext, i, bufferOverflow);
        this.block = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.ChannelFlowBuilder, p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super C1133Unit> continuation) {
        C14231 c14231;
        if (continuation instanceof C14231) {
            c14231 = (C14231) continuation;
            int i = c14231.f6057label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14231.f6057label = i - Integer.MIN_VALUE;
            } else {
                c14231 = new C14231(this, continuation);
            }
        }
        Object obj = c14231.f6058result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14231.f6057label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c14231.f6056L$0 = producerScope;
            c14231.f6057label = 1;
            if (super.collectTo(producerScope, c14231) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) c14231.f6056L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (producerScope.isClosedForSend()) {
            return C1133Unit.INSTANCE;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // p122kotlinx.coroutines.p125flow.ChannelFlowBuilder, p122kotlinx.coroutines.p125flow.internal.ChannelFlow
    /* renamed from: create */
    public ChannelFlow<T> mo7181create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return new CallbackFlowBuilder(this.block, context, capacity, onBufferOverflow);
    }

    public /* synthetic */ CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.f5601SUSPEND : bufferOverflow);
    }
}
