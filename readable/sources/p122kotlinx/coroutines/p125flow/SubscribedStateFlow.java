package p122kotlinx.coroutines.p125flow;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;

@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BD\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00028\u0000X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m4988d2 = {"Lkotlinx/coroutines/flow/SubscribedStateFlow;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "collect", BuildConfig.f24315FLAVOR, "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replayCache", BuildConfig.f24315FLAVOR, "getReplayCache", "()Ljava/util/List;", "value", "getValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class SubscribedStateFlow<T> implements StateFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> action;
    private final StateFlow<T> stateFlow;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.SubscribedStateFlow", m6124f = "Share.kt", m6125i = {0}, m6126l = {465}, m6127m = "collect", m6128n = {"collector"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.SubscribedStateFlow$collect$1 */
    public static final class C15601 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f7060L$0;

        /* renamed from: label */
        int f7061label;

        /* renamed from: result */
        /* synthetic */ Object f7062result;

        /* renamed from: this$0 */
        final /* synthetic */ SubscribedStateFlow<T> f7063this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15601(SubscribedStateFlow<T> subscribedStateFlow, Continuation<? super C15601> continuation) {
            super(continuation);
            this.f7063this$0 = subscribedStateFlow;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7062result = obj;
            this.f7061label |= Integer.MIN_VALUE;
            return this.f7063this$0.mo4308collect(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedStateFlow(StateFlow<? extends T> stateFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        this.stateFlow = stateFlow;
        this.action = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.SharedFlow, p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        C15601 c15601;
        if (continuation instanceof C15601) {
            c15601 = (C15601) continuation;
            int i = c15601.f7061label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15601.f7061label = i - Integer.MIN_VALUE;
            } else {
                c15601 = new C15601(this, continuation);
            }
        }
        Object obj = c15601.f7062result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15601.f7061label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<T> stateFlow = this.stateFlow;
            SubscribedFlowCollector subscribedFlowCollector = new SubscribedFlowCollector(flowCollector, this.action);
            c15601.f7060L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c15601.f7061label = 1;
            if (stateFlow.mo4308collect(subscribedFlowCollector, c15601) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // p122kotlinx.coroutines.p125flow.SharedFlow
    public List<T> getReplayCache() {
        return this.stateFlow.getReplayCache();
    }

    @Override // p122kotlinx.coroutines.p125flow.StateFlow
    public T getValue() {
        return this.stateFlow.getValue();
    }
}
