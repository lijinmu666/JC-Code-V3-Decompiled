package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.Duration;
import p122kotlinx.coroutines.C1338DelayKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.FlowPreview;
import p122kotlinx.coroutines.channels.ProduceKt;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.p125flow.internal.FlowCoroutineKt;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;
import p122kotlinx.coroutines.p127selects.SelectImplementation;

@Metadata(m4987d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\b\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0005H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0007\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0000\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\t\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0017\u0010\t\u001a-\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\t¨\u0006\u001a"}, m4988d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", BuildConfig.f24315FLAVOR, "Lkotlin/Function1;", "timeout", "Lkotlin/time/Duration;", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceDuration", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "sample", "periodMillis", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "period", "sample-HG0u8IE", "timeout-HG0u8IE", "timeoutInternal", "timeoutInternal-HG0u8IE$FlowKt__DelayKt", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n1#2:408\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__DelayKt {

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1", m6124f = "Delay.kt", m6125i = {0, 1, 2}, m6126l = {307, 309, 310}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce", "$this$produce"}, m6130s = {"L$0", "L$0", "L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$1 */
    public static final class C14671 extends SuspendLambda implements Function2<ProducerScope<? super C1133Unit>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ long $delayMillis;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6384L$0;

        /* renamed from: label */
        int f6385label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14671(long j, Continuation<? super C14671> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14671 c14671 = new C14671(this.$delayMillis, continuation);
            c14671.f6384L$0 = obj;
            return c14671;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0053 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:15:0x0036). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.f6384L$0
                kotlinx.coroutines.channels.ProducerScope r0 = (p122kotlinx.coroutines.channels.ProducerScope) r0
                java.lang.Object r1 = p094kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.f6385label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L26
                if (r2 == r5) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L22
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                p094kotlin.ResultKt.throwOnFailure(r9)
                goto L47
            L22:
                p094kotlin.ResultKt.throwOnFailure(r9)
                goto L36
            L26:
                p094kotlin.ResultKt.throwOnFailure(r9)
                long r6 = r8.$delayMillis
                r8.f6384L$0 = r0
                r8.f6385label = r5
                java.lang.Object r9 = p122kotlinx.coroutines.C1338DelayKt.m6972delay(r6, r8)
                if (r9 != r1) goto L36
                return r1
            L36:
                kotlinx.coroutines.channels.SendChannel r9 = r0.getChannel()
                kotlin.Unit r2 = p094kotlin.C1133Unit.INSTANCE
                r8.f6384L$0 = r0
                r8.f6385label = r4
                java.lang.Object r9 = r9.mo7052send(r2, r8)
                if (r9 != r1) goto L47
                return r1
            L47:
                long r5 = r8.$delayMillis
                r8.f6384L$0 = r0
                r8.f6385label = r3
                java.lang.Object r9 = p122kotlinx.coroutines.C1338DelayKt.m6972delay(r5, r8)
                if (r9 != r1) goto L36
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p122kotlinx.coroutines.p125flow.FlowKt__DelayKt.C14671.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super C1133Unit> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C14671) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", m6124f = "Delay.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {412}, m6127m = "invokeSuspend", m6128n = {"$this$scopedFlow", "downstream", "values", "lastValue", "ticker", "$this$select_u24lambda_u240$iv", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n54#2,5:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2\n*L\n278#1:408,5\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2 */
    public static final class C14682<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ InterfaceC1426Flow<T> $this_sample;

        /* renamed from: I$0 */
        int f6386I$0;

        /* renamed from: I$1 */
        int f6387I$1;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6388L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6389L$1;

        /* renamed from: L$2 */
        Object f6390L$2;

        /* renamed from: L$3 */
        Object f6391L$3;

        /* renamed from: L$4 */
        Object f6392L$4;

        /* renamed from: L$5 */
        Object f6393L$5;

        /* renamed from: label */
        int f6394label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14682(long j, InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C14682> continuation) {
            super(3, continuation);
            this.$periodMillis = j;
            this.$this_sample = interfaceC1426Flow;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            C1235Ref.ObjectRef objectRef;
            ReceiveChannel<C1133Unit> receiveChannelFixedPeriodTicker;
            CoroutineScope coroutineScope = (CoroutineScope) this.f6388L$0;
            FlowCollector flowCollector = (FlowCollector) this.f6389L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6394label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
                C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
                receiveChannel = receiveChannelProduce$default;
                objectRef = objectRef2;
                receiveChannelFixedPeriodTicker = C1427FlowKt.fixedPeriodTicker(coroutineScope, this.$periodMillis);
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                receiveChannelFixedPeriodTicker = (ReceiveChannel) this.f6392L$4;
                objectRef = (C1235Ref.ObjectRef) this.f6391L$3;
                receiveChannel = (ReceiveChannel) this.f6390L$2;
                ResultKt.throwOnFailure(obj);
            }
            while (objectRef.f5202element != NullSurrogateKt.f7172DONE) {
                SelectImplementation selectImplementation = new SelectImplementation(get$context());
                selectImplementation.mo7482invoke(receiveChannel.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannelFixedPeriodTicker, null));
                selectImplementation.mo7482invoke(receiveChannelFixedPeriodTicker.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, null));
                this.f6388L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f6389L$1 = flowCollector;
                this.f6390L$2 = receiveChannel;
                this.f6391L$3 = objectRef;
                this.f6392L$4 = receiveChannelFixedPeriodTicker;
                this.f6393L$5 = SpillingKt.nullOutSpilledVariable(selectImplementation);
                this.f6386I$0 = 0;
                this.f6387I$1 = 0;
                this.f6394label = 1;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo6219invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
            C14682 c14682 = new C14682(this.$periodMillis, this.$this_sample, continuation);
            c14682.f6388L$0 = coroutineScope;
            c14682.f6389L$1 = flowCollector;
            return c14682.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @FlowPreview
    public static final <T> InterfaceC1426Flow<T> debounce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, final long j) {
        if (j >= 0) {
            return j == 0 ? interfaceC1426Flow : debounceInternal$FlowKt__DelayKt(interfaceC1426Flow, new Function1() { // from class: kotlinx.coroutines.flow.AZxh
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return Long.valueOf(FlowKt__DelayKt.debounce$lambda$1$FlowKt__DelayKt(j, obj));
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long debounce$lambda$1$FlowKt__DelayKt(long j, Object obj) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long debounce$lambda$2$FlowKt__DelayKt(Function1 function1, Object obj) {
        return C1338DelayKt.m19981toDelayMillisLRDsOJo(((Duration) function1.mo2237invoke(obj)).getRawValue());
    }

    @FlowPreview
    /* renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20024debounceHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return C1427FlowKt.debounce(interfaceC1426Flow, C1338DelayKt.m19981toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @InterfaceC1231JvmName(m6260name = "debounceDuration")
    public static final <T> InterfaceC1426Flow<T> debounceDuration(InterfaceC1426Flow<? extends T> interfaceC1426Flow, final Function1<? super T, Duration> function1) {
        return debounceInternal$FlowKt__DelayKt(interfaceC1426Flow, new Function1() { // from class: kotlinx.coroutines.flow.mjFkc
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Long.valueOf(FlowKt__DelayKt.debounce$lambda$2$FlowKt__DelayKt(function1, obj));
            }
        });
    }

    private static final <T> InterfaceC1426Flow<T> debounceInternal$FlowKt__DelayKt(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(function1, interfaceC1426Flow, null));
    }

    public static final ReceiveChannel<C1133Unit> fixedPeriodTicker(CoroutineScope coroutineScope, long j) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new C14671(j, null), 1, null);
    }

    @FlowPreview
    /* renamed from: sample */
    public static final <T> InterfaceC1426Flow<T> m7282sample(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new C14682(j, interfaceC1426Flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive");
    }

    @FlowPreview
    /* renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20025sampleHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return C1427FlowKt.m7243sample(interfaceC1426Flow, C1338DelayKt.m19981toDelayMillisLRDsOJo(j));
    }

    @FlowPreview
    /* renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20026timeoutHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return m20027timeoutInternalHG0u8IE$FlowKt__DelayKt(interfaceC1426Flow, j);
    }

    /* renamed from: timeoutInternal-HG0u8IE$FlowKt__DelayKt, reason: not valid java name */
    private static final <T> InterfaceC1426Flow<T> m20027timeoutInternalHG0u8IE$FlowKt__DelayKt(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$timeoutInternal$1(j, interfaceC1426Flow, null));
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    public static final <T> InterfaceC1426Flow<T> debounce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, Long> function1) {
        return debounceInternal$FlowKt__DelayKt(interfaceC1426Flow, function1);
    }
}
