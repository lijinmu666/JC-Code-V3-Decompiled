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
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.channels.ProduceKt;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;
import p122kotlinx.coroutines.p127selects.OnTimeoutKt;
import p122kotlinx.coroutines.p127selects.SelectImplementation;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", m6124f = "Delay.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {215, 415}, m6127m = "invokeSuspend", m6128n = {"$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$scopedFlow", "downstream", "values", "lastValue", "timeoutMillis", "$this$select_u24lambda_u240$iv", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n14#2:408\n14#2:410\n1#3:409\n54#4,5:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n212#1:408\n215#1:410\n222#1:411,5\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ InterfaceC1426Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;

    /* renamed from: I$0 */
    int f6361I$0;

    /* renamed from: I$1 */
    int f6362I$1;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6363L$0;

    /* renamed from: L$1 */
    /* synthetic */ Object f6364L$1;

    /* renamed from: L$2 */
    Object f6365L$2;

    /* renamed from: L$3 */
    Object f6366L$3;

    /* renamed from: L$4 */
    Object f6367L$4;

    /* renamed from: L$5 */
    Object f6368L$5;

    /* renamed from: label */
    int f6369label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = interfaceC1426Flow;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0101 -> B:7:0x002e). Please report as a decompilation issue!!! */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        C1235Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel;
        C1235Ref.LongRef longRef;
        C1235Ref.ObjectRef objectRef2;
        SelectImplementation selectImplementation;
        CoroutineScope coroutineScope = (CoroutineScope) this.f6363L$0;
        FlowCollector flowCollector = (FlowCollector) this.f6364L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6369label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            objectRef = new C1235Ref.ObjectRef();
            receiveChannel = receiveChannelProduce$default;
            if (objectRef.f5202element == NullSurrogateKt.f7172DONE) {
            }
        } else if (i == 1) {
            longRef = (C1235Ref.LongRef) this.f6367L$4;
            objectRef = (C1235Ref.ObjectRef) this.f6366L$3;
            receiveChannel = (ReceiveChannel) this.f6365L$2;
            ResultKt.throwOnFailure(obj);
            objectRef.f5202element = null;
            C1235Ref.ObjectRef objectRef3 = objectRef;
            C1235Ref.LongRef longRef2 = longRef;
            objectRef2 = objectRef3;
            selectImplementation = new SelectImplementation(get$context());
            if (objectRef2.f5202element != null) {
            }
            selectImplementation.mo7482invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector, null));
            this.f6363L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.f6364L$1 = flowCollector;
            this.f6365L$2 = receiveChannel;
            this.f6366L$3 = objectRef2;
            this.f6367L$4 = SpillingKt.nullOutSpilledVariable(longRef2);
            this.f6368L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation);
            this.f6361I$0 = 0;
            this.f6362I$1 = 0;
            this.f6369label = 2;
            if (selectImplementation.doSelect(this) == coroutine_suspended) {
            }
            objectRef = objectRef2;
            if (objectRef.f5202element == NullSurrogateKt.f7172DONE) {
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (C1235Ref.ObjectRef) this.f6366L$3;
            ReceiveChannel receiveChannel2 = (ReceiveChannel) this.f6365L$2;
            ResultKt.throwOnFailure(obj);
            receiveChannel = receiveChannel2;
            objectRef = objectRef2;
            if (objectRef.f5202element == NullSurrogateKt.f7172DONE) {
                longRef = new C1235Ref.LongRef();
                T t = objectRef.f5202element;
                if (t != null) {
                    Function1<T, Long> function1 = this.$timeoutMillisSelector;
                    C1578Symbol c1578Symbol = NullSurrogateKt.f7173NULL;
                    if (t == c1578Symbol) {
                        t = null;
                    }
                    long jLongValue = function1.mo2237invoke(t).longValue();
                    longRef.f5201element = jLongValue;
                    if (jLongValue < 0) {
                        throw new IllegalArgumentException("Debounce timeout should not be negative");
                    }
                    if (jLongValue == 0) {
                        T t2 = objectRef.f5202element;
                        if (t2 == c1578Symbol) {
                            t2 = null;
                        }
                        this.f6363L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.f6364L$1 = flowCollector;
                        this.f6365L$2 = receiveChannel;
                        this.f6366L$3 = objectRef;
                        this.f6367L$4 = longRef;
                        this.f6368L$5 = null;
                        this.f6369label = 1;
                        if (flowCollector.mo4309emit(t2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef.f5202element = null;
                    }
                }
                C1235Ref.ObjectRef objectRef32 = objectRef;
                C1235Ref.LongRef longRef22 = longRef;
                objectRef2 = objectRef32;
                selectImplementation = new SelectImplementation(get$context());
                if (objectRef2.f5202element != null) {
                    OnTimeoutKt.onTimeout(selectImplementation, longRef22.f5201element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector, objectRef2, null));
                }
                selectImplementation.mo7482invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector, null));
                this.f6363L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f6364L$1 = flowCollector;
                this.f6365L$2 = receiveChannel;
                this.f6366L$3 = objectRef2;
                this.f6367L$4 = SpillingKt.nullOutSpilledVariable(longRef22);
                this.f6368L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation);
                this.f6361I$0 = 0;
                this.f6362I$1 = 0;
                this.f6369label = 2;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                if (objectRef.f5202element == NullSurrogateKt.f7172DONE) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo6219invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.f6363L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.f6364L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(C1133Unit.INSTANCE);
    }
}
