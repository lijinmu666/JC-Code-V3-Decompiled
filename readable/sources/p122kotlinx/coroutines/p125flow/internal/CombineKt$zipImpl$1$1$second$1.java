package p122kotlinx.coroutines.p125flow.internal;

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
import p122kotlinx.coroutines.channels.SendChannel;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", m6124f = "Combine.kt", m6125i = {0}, m6126l = {86}, m6127m = "invokeSuspend", m6128n = {"$this$produce"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $flow2 */
    final /* synthetic */ InterfaceC1426Flow<T2> f7160$flow2;

    /* renamed from: L$0 */
    private /* synthetic */ Object f7161L$0;

    /* renamed from: label */
    int f7162label;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1 */
    public static final class C15701<T> implements FlowCollector {
        final /* synthetic */ ProducerScope<Object> $$this$produce;

        public C15701(ProducerScope<Object> producerScope) {
            this.$$this$produce = producerScope;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T2 t2, Continuation<? super C1133Unit> continuation) {
            CombineKt$zipImpl$1$1$second$1$1$emit$1 combineKt$zipImpl$1$1$second$1$1$emit$1;
            if (continuation instanceof CombineKt$zipImpl$1$1$second$1$1$emit$1) {
                combineKt$zipImpl$1$1$second$1$1$emit$1 = (CombineKt$zipImpl$1$1$second$1$1$emit$1) continuation;
                int i = combineKt$zipImpl$1$1$second$1$1$emit$1.f7164label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    combineKt$zipImpl$1$1$second$1$1$emit$1.f7164label = i - Integer.MIN_VALUE;
                } else {
                    combineKt$zipImpl$1$1$second$1$1$emit$1 = new CombineKt$zipImpl$1$1$second$1$1$emit$1(this, continuation);
                }
            }
            Object obj = combineKt$zipImpl$1$1$second$1$1$emit$1.f7165result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = combineKt$zipImpl$1$1$second$1$1$emit$1.f7164label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel<Object> channel = this.$$this$produce.getChannel();
                C1578Symbol c1578Symbol = t2 == 0 ? NullSurrogateKt.f7173NULL : t2;
                combineKt$zipImpl$1$1$second$1$1$emit$1.f7163L$0 = SpillingKt.nullOutSpilledVariable(t2);
                combineKt$zipImpl$1$1$second$1$1$emit$1.f7164label = 1;
                if (channel.mo7052send(c1578Symbol, combineKt$zipImpl$1$1$second$1$1$emit$1) == coroutine_suspended) {
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
    public CombineKt$zipImpl$1$1$second$1(InterfaceC1426Flow<? extends T2> interfaceC1426Flow, Continuation<? super CombineKt$zipImpl$1$1$second$1> continuation) {
        super(2, continuation);
        this.f7160$flow2 = interfaceC1426Flow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.f7160$flow2, continuation);
        combineKt$zipImpl$1$1$second$1.f7161L$0 = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(ProducerScope<? super Object> producerScope, Continuation<? super C1133Unit> continuation) {
        return invoke2((ProducerScope<Object>) producerScope, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope = (ProducerScope) this.f7161L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f7162label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow<T2> interfaceC1426Flow = this.f7160$flow2;
            C15701 c15701 = new C15701(producerScope);
            this.f7161L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
            this.f7162label = 1;
            if (interfaceC1426Flow.mo4308collect(c15701, this) == coroutine_suspended) {
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
        return ((CombineKt$zipImpl$1$1$second$1) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
