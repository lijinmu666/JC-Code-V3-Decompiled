package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.BuildersKt;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CompletableDeferred;
import p122kotlinx.coroutines.CompletableDeferredKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.channels.InterfaceC1361Channel;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlow;

@Metadata(m4987d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\b\f\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002H\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0019\u001a,\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001a\u001aG\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00180\u001f0\u001eH\u0002¢\u0006\u0002\b \u001a\u001e\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013\u001a\u001c\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020$\u001aP\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010&\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0)\u0012\u0006\u0012\u0004\u0018\u00010*0'¢\u0006\u0002\b+¢\u0006\u0002\u0010,\u001aP\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00182-\u0010&\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0)\u0012\u0006\u0012\u0004\u0018\u00010*0'¢\u0006\u0002\b+¢\u0006\u0002\u0010-¨\u0006."}, m4988d2 = {"shareIn", "Lkotlinx/coroutines/flow/SharedFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "replay", BuildConfig.f24315FLAVOR, "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "stateIn", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchSharingDeferred", BuildConfig.f24315FLAVOR, "result", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "launchSharingDeferred$FlowKt__ShareKt", "asFlow", "asSharedFlow", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,482:1\n1#2:483\n35#3,5:484\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n*L\n382#1:484,5\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ShareKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt", m6124f = "Share.kt", m6125i = {0, 0, 0, 0}, m6126l = {326}, m6127m = "stateIn", m6128n = {"$this$stateIn", "scope", "config", "result"}, m6130s = {"L$0", "L$1", "L$2", "L$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$stateIn$1 */
    public static final class C15201<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6752L$0;

        /* renamed from: L$1 */
        Object f6753L$1;

        /* renamed from: L$2 */
        Object f6754L$2;

        /* renamed from: L$3 */
        Object f6755L$3;

        /* renamed from: label */
        int f6756label;

        /* renamed from: result */
        /* synthetic */ Object f6757result;

        public C15201(Continuation<? super C15201> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6757result = obj;
            this.f6756label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7248stateIn(null, null, this);
        }
    }

    @ExperimentalCoroutinesApi
    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7327asFlow(SharedFlow<? extends T> sharedFlow) {
        return C1427FlowKt.m7219flow(new FlowKt__ShareKt$asFlow$$inlined$transform$1(sharedFlow, null));
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> SharingConfig<T> configureSharing$FlowKt__ShareKt(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        ChannelFlow channelFlow;
        InterfaceC1426Flow<T> interfaceC1426FlowDropChannelOperators;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, InterfaceC1361Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - i;
        if (!(interfaceC1426Flow instanceof ChannelFlow) || (interfaceC1426FlowDropChannelOperators = (channelFlow = (ChannelFlow) interfaceC1426Flow).dropChannelOperators()) == null) {
            return new SharingConfig<>(interfaceC1426Flow, iCoerceAtLeast, BufferOverflow.f5601SUSPEND, EmptyCoroutineContext.INSTANCE);
        }
        int i2 = channelFlow.capacity;
        if (i2 != -3 && i2 != -2 && i2 != 0) {
            iCoerceAtLeast = i2;
        } else if (channelFlow.onBufferOverflow == BufferOverflow.f5601SUSPEND) {
            if (i2 == 0) {
                iCoerceAtLeast = 0;
            }
        } else if (i == 0) {
            iCoerceAtLeast = 1;
        }
        return new SharingConfig<>(interfaceC1426FlowDropChannelOperators, iCoerceAtLeast, channelFlow.onBufferOverflow, channelFlow.context);
    }

    private static final <T> InterfaceC1342Job launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, InterfaceC1426Flow<? extends T> interfaceC1426Flow, MutableSharedFlow<T> mutableSharedFlow, SharingStarted sharingStarted, T t) {
        return BuildersKt.m6910launch(coroutineScope, coroutineContext, Intrinsics.areEqual(sharingStarted, SharingStarted.INSTANCE.getEagerly()) ? CoroutineStart.f5506DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(sharingStarted, interfaceC1426Flow, mutableSharedFlow, t, null));
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope coroutineScope, CoroutineContext coroutineContext, InterfaceC1426Flow<? extends T> interfaceC1426Flow, CompletableDeferred<C1124Result<StateFlow<T>>> completableDeferred) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(interfaceC1426Flow, completableDeferred, null), 2, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new SubscribedSharedFlow(sharedFlow, function2);
    }

    /* renamed from: shareIn */
    public static final <T> SharedFlow<T> m7328shareIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i) {
        SharingConfig sharingConfigConfigureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(interfaceC1426Flow, i);
        MutableSharedFlow MutableSharedFlow = SharedFlowKt.MutableSharedFlow(i, sharingConfigConfigureSharing$FlowKt__ShareKt.extraBufferCapacity, sharingConfigConfigureSharing$FlowKt__ShareKt.onBufferOverflow);
        return new ReadonlySharedFlow(MutableSharedFlow, launchSharing$FlowKt__ShareKt(coroutineScope, sharingConfigConfigureSharing$FlowKt__ShareKt.context, sharingConfigConfigureSharing$FlowKt__ShareKt.upstream, MutableSharedFlow, sharingStarted, SharedFlowKt.NO_VALUE));
    }

    public static /* synthetic */ SharedFlow shareIn$default(InterfaceC1426Flow interfaceC1426Flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return C1427FlowKt.m7245shareIn(interfaceC1426Flow, coroutineScope, sharingStarted, i);
    }

    /* renamed from: stateIn */
    public static final <T> StateFlow<T> m7330stateIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, T t) {
        SharingConfig sharingConfigConfigureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(interfaceC1426Flow, 1);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(t);
        return new ReadonlyStateFlow(MutableStateFlow, launchSharing$FlowKt__ShareKt(coroutineScope, sharingConfigConfigureSharing$FlowKt__ShareKt.context, sharingConfigConfigureSharing$FlowKt__ShareKt.upstream, MutableStateFlow, sharingStarted, t));
    }

    public static final <T> StateFlow<T> onSubscription(StateFlow<? extends T> stateFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new SubscribedStateFlow(stateFlow, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: stateIn */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7329stateIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, Continuation<? super StateFlow<? extends T>> continuation) {
        C15201 c15201;
        if (continuation instanceof C15201) {
            c15201 = (C15201) continuation;
            int i = c15201.f6756label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15201.f6756label = i - Integer.MIN_VALUE;
            } else {
                c15201 = new C15201(continuation);
            }
        }
        Object objMo6928await = c15201.f6757result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15201.f6756label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo6928await);
            SharingConfig sharingConfigConfigureSharing$FlowKt__ShareKt = configureSharing$FlowKt__ShareKt(interfaceC1426Flow, 1);
            CompletableDeferred CompletableDeferred = CompletableDeferredKt.CompletableDeferred((InterfaceC1342Job) coroutineScope.getCoroutineContext().mo6098get(InterfaceC1342Job.INSTANCE));
            launchSharingDeferred$FlowKt__ShareKt(coroutineScope, sharingConfigConfigureSharing$FlowKt__ShareKt.context, sharingConfigConfigureSharing$FlowKt__ShareKt.upstream, CompletableDeferred);
            c15201.f6752L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15201.f6753L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            c15201.f6754L$2 = SpillingKt.nullOutSpilledVariable(sharingConfigConfigureSharing$FlowKt__ShareKt);
            c15201.f6755L$3 = SpillingKt.nullOutSpilledVariable(CompletableDeferred);
            c15201.f6756label = 1;
            objMo6928await = CompletableDeferred.mo6928await(c15201);
            if (objMo6928await == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo6928await);
        }
        Object value = ((C1124Result) objMo6928await).getValue();
        ResultKt.throwOnFailure(value);
        return value;
    }
}
