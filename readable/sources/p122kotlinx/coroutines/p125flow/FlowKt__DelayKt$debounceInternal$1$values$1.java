package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", m6124f = "Delay.kt", m6125i = {0}, m6126l = {204}, m6127m = "invokeSuspend", m6128n = {"$this$produce"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ InterfaceC1426Flow<T> $this_debounceInternal;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6378L$0;

    /* renamed from: label */
    int f6379label;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1 */
    public static final class C14661<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<Object> $$this$produce;

        public C14661(ProducerScope<Object> producerScope) {
            this.$$this$produce = producerScope;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1;
            if (continuation instanceof FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) {
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = (FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) continuation;
                int i = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6381label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6381label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, continuation);
                }
            }
            Object obj = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6382result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6381label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope<Object> producerScope = this.$$this$produce;
                Object obj2 = t == null ? NullSurrogateKt.f7173NULL : t;
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6380L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.f6381label = 1;
                if (producerScope.mo7052send(obj2, flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$values$1(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1$values$1> continuation) {
        super(2, continuation);
        this.$this_debounceInternal = interfaceC1426Flow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$values$1 flowKt__DelayKt$debounceInternal$1$values$1 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1$values$1.f6378L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$values$1;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(ProducerScope<? super Object> producerScope, Continuation<? super C1133Unit> continuation) {
        return invoke2((ProducerScope<Object>) producerScope, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope = (ProducerScope) this.f6378L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6379label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow<T> interfaceC1426Flow = this.$this_debounceInternal;
            C14661 c14661 = new C14661(producerScope);
            this.f6378L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
            this.f6379label = 1;
            if (interfaceC1426Flow.mo4308collect(c14661, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<Object> producerScope, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
