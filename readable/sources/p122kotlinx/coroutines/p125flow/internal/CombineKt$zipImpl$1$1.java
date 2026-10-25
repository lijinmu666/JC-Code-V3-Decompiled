package p122kotlinx.coroutines.p125flow.internal;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CompletableJob;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.JobKt__JobKt;
import p122kotlinx.coroutines.channels.ChannelResult;
import p122kotlinx.coroutines.channels.ProduceKt;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.channels.SendChannel;
import p122kotlinx.coroutines.internal.ThreadContextKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", m6124f = "Combine.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {123}, m6127m = "invokeSuspend", m6128n = {"$this$coroutineScope", "second", "collectJob", "scopeContext", "cnt"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, m6131v = 1)
/* loaded from: classes.dex */
public final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $flow */
    final /* synthetic */ InterfaceC1426Flow<T1> f7137$flow;

    /* renamed from: $flow2 */
    final /* synthetic */ InterfaceC1426Flow<T2> f7138$flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f7139L$0;

    /* renamed from: L$1 */
    Object f7140L$1;

    /* renamed from: L$2 */
    Object f7141L$2;

    /* renamed from: L$3 */
    Object f7142L$3;

    /* renamed from: L$4 */
    Object f7143L$4;

    /* renamed from: label */
    int f7144label;

    @Metadata(m4987d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", m6124f = "Combine.kt", m6125i = {}, m6126l = {124}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 */
    public static final class C15692 extends SuspendLambda implements Function2<C1133Unit, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $cnt */
        final /* synthetic */ Object f7145$cnt;
        final /* synthetic */ CompletableJob $collectJob;

        /* renamed from: $flow */
        final /* synthetic */ InterfaceC1426Flow<T1> f7146$flow;
        final /* synthetic */ CoroutineContext $scopeContext;

        /* renamed from: $second */
        final /* synthetic */ ReceiveChannel<Object> f7147$second;
        final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

        /* renamed from: label */
        int f7148label;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* renamed from: $cnt */
            final /* synthetic */ Object f7149$cnt;
            final /* synthetic */ CompletableJob $collectJob;
            final /* synthetic */ CoroutineContext $scopeContext;

            /* renamed from: $second */
            final /* synthetic */ ReceiveChannel<Object> f7150$second;
            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

            @Metadata(m4987d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", m6124f = "Combine.kt", m6125i = {1, 2}, m6126l = {126, 129, 129}, m6127m = "invokeSuspend", m6128n = {"otherValue", "otherValue"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
            @SourceDebugExtension(m6344value = {"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,140:1\n996#2:141\n14#3:142\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1$2$1$1\n*L\n126#1:141\n129#1:142\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C63551 extends SuspendLambda implements Function2<C1133Unit, Continuation<? super C1133Unit>, Object> {
                final /* synthetic */ CompletableJob $collectJob;

                /* renamed from: $second */
                final /* synthetic */ ReceiveChannel<Object> f7151$second;
                final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

                /* renamed from: $value */
                final /* synthetic */ T1 f7152$value;

                /* renamed from: L$0 */
                Object f7153L$0;

                /* renamed from: L$1 */
                Object f7154L$1;

                /* renamed from: label */
                int f7155label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C63551(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, T1 t1, CompletableJob completableJob, Continuation<? super C63551> continuation) {
                    super(2, continuation);
                    this.f7151$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = function3;
                    this.f7152$value = t1;
                    this.$collectJob = completableJob;
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                /* renamed from: create */
                public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
                    return new C63551(this.f7151$second, this.$this_unsafeFlow, this.$transform, this.f7152$value, this.$collectJob, continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0084 A[RETURN] */
                /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.flow.FlowCollector] */
                /* JADX WARN: Type inference failed for: r1v6 */
                /* JADX WARN: Type inference failed for: r1v7 */
                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objMo19995receiveCatchingJP2dKIU;
                    Object obj2;
                    ?? r1;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f7155label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel<Object> receiveChannel = this.f7151$second;
                        this.f7155label = 1;
                        objMo19995receiveCatchingJP2dKIU = receiveChannel.mo19995receiveCatchingJP2dKIU(this);
                        if (objMo19995receiveCatchingJP2dKIU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return C1133Unit.INSTANCE;
                            }
                            FlowCollector flowCollector = (FlowCollector) this.f7154L$1;
                            obj2 = this.f7153L$0;
                            ResultKt.throwOnFailure(obj);
                            r1 = flowCollector;
                            this.f7153L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.f7154L$1 = null;
                            this.f7155label = 3;
                            if (r1.mo4309emit(obj, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return C1133Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        objMo19995receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
                    }
                    CompletableJob completableJob = this.$collectJob;
                    if (objMo19995receiveCatchingJP2dKIU instanceof ChannelResult.C1363Failed) {
                        Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(objMo19995receiveCatchingJP2dKIU);
                        if (thM20006exceptionOrNullimpl == null) {
                            throw new AbortFlowException(completableJob);
                        }
                        throw thM20006exceptionOrNullimpl;
                    }
                    Object obj3 = this.$this_unsafeFlow;
                    Function3 function3 = this.$transform;
                    Object obj4 = this.f7152$value;
                    Object obj5 = objMo19995receiveCatchingJP2dKIU == NullSurrogateKt.f7173NULL ? null : objMo19995receiveCatchingJP2dKIU;
                    this.f7153L$0 = SpillingKt.nullOutSpilledVariable(objMo19995receiveCatchingJP2dKIU);
                    this.f7154L$1 = obj3;
                    this.f7155label = 2;
                    Object objMo6219invoke = function3.mo6219invoke(obj4, obj5, this);
                    if (objMo6219invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objMo19995receiveCatchingJP2dKIU;
                    obj = objMo6219invoke;
                    r1 = obj3;
                    this.f7153L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.f7154L$1 = null;
                    this.f7155label = 3;
                    if (r1.mo4309emit(obj, this) == coroutine_suspended) {
                    }
                    return C1133Unit.INSTANCE;
                }

                @Override // p094kotlin.p105jvm.functions.Function2
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo2167invoke(C1133Unit c1133Unit, Continuation<? super C1133Unit> continuation) {
                    return ((C63551) mo2166create(c1133Unit, continuation)).invokeSuspend(C1133Unit.INSTANCE);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, CompletableJob completableJob) {
                this.$scopeContext = coroutineContext;
                this.f7149$cnt = obj;
                this.f7150$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = function3;
                this.$collectJob = completableJob;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // p122kotlinx.coroutines.p125flow.FlowCollector
            /* renamed from: emit */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mo4309emit(T1 t1, Continuation<? super C1133Unit> continuation) {
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                if (continuation instanceof CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (CombineKt$zipImpl$1$1$2$1$emit$1) continuation;
                    int i = combineKt$zipImpl$1$1$2$1$emit$1.f7157label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.f7157label = i - Integer.MIN_VALUE;
                    } else {
                        combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                    }
                }
                Object obj = combineKt$zipImpl$1$1$2$1$emit$1.f7158result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = combineKt$zipImpl$1$1$2$1$emit$1.f7157label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.$scopeContext;
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    Object obj2 = this.f7149$cnt;
                    C63551 c63551 = new C63551(this.f7150$second, this.$this_unsafeFlow, this.$transform, t1, this.$collectJob, null);
                    combineKt$zipImpl$1$1$2$1$emit$1.f7156L$0 = SpillingKt.nullOutSpilledVariable(t1);
                    combineKt$zipImpl$1$1$2$1$emit$1.f7157label = 1;
                    if (ChannelFlowKt.withContextUndispatched(coroutineContext, c1133Unit, obj2, c63551, combineKt$zipImpl$1$1$2$1$emit$1) == coroutine_suspended) {
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
        public C15692(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, CompletableJob completableJob, Continuation<? super C15692> continuation) {
            super(2, continuation);
            this.f7146$flow = interfaceC1426Flow;
            this.$scopeContext = coroutineContext;
            this.f7145$cnt = obj;
            this.f7147$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = function3;
            this.$collectJob = completableJob;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C15692(this.f7146$flow, this.$scopeContext, this.f7145$cnt, this.f7147$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7148label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T1> interfaceC1426Flow = this.f7146$flow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scopeContext, this.f7145$cnt, this.f7147$second, this.$this_unsafeFlow, this.$transform, this.$collectJob);
                this.f7148label = 1;
                if (interfaceC1426Flow.mo4308collect(anonymousClass1, this) == coroutine_suspended) {
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

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(C1133Unit c1133Unit, Continuation<? super C1133Unit> continuation) {
            return ((C15692) mo2166create(c1133Unit, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(InterfaceC1426Flow<? extends T2> interfaceC1426Flow, InterfaceC1426Flow<? extends T1> interfaceC1426Flow2, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.f7138$flow2 = interfaceC1426Flow;
        this.f7137$flow = interfaceC1426Flow2;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f7138$flow2, this.f7137$flow, this.$this_unsafeFlow, this.$transform, continuation);
        combineKt$zipImpl$1$1.f7139L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ReceiveChannel receiveChannel;
        CompletableJob completableJob;
        ReceiveChannel receiveChannel2;
        CompletableJob completableJob2;
        CoroutineContext coroutineContextMo6100plus;
        C1133Unit c1133Unit;
        C15692 c15692;
        CoroutineScope coroutineScope = (CoroutineScope) this.f7139L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.f7144label;
        try {
            if (r2 != 0) {
                if (r2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                completableJob2 = (CompletableJob) this.f7141L$2;
                receiveChannel2 = (ReceiveChannel) this.f7140L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    r2 = receiveChannel2;
                } catch (AbortFlowException e) {
                    e = e;
                }
                ReceiveChannel.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
                return C1133Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            ReceiveChannel receiveChannelProduce$default = ProduceKt.produce$default(coroutineScope, null, 0, new CombineKt$zipImpl$1$1$second$1(this.f7138$flow2, null), 3, null);
            final CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((InterfaceC1342Job) null, 1, (Object) null);
            Intrinsics.checkNotNull(receiveChannelProduce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((SendChannel) receiveChannelProduce$default).invokeOnClose(new Function1<Throwable, C1133Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(Throwable th) {
                    invoke2(th);
                    return C1133Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (completableJobJob$default.isActive()) {
                        completableJobJob$default.mo6998cancel((CancellationException) new AbortFlowException(completableJobJob$default));
                    }
                }
            });
            try {
                CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                Object objThreadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                coroutineContextMo6100plus = coroutineScope.getCoroutineContext().mo6100plus(completableJobJob$default);
                c1133Unit = C1133Unit.INSTANCE;
                c15692 = new C15692(this.f7137$flow, coroutineContext, objThreadContextElements, receiveChannelProduce$default, this.$this_unsafeFlow, this.$transform, completableJobJob$default, null);
                this.f7139L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.f7140L$1 = receiveChannelProduce$default;
                this.f7141L$2 = completableJobJob$default;
                this.f7142L$3 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                this.f7143L$4 = SpillingKt.nullOutSpilledVariable(objThreadContextElements);
                this.f7144label = 1;
                completableJob = completableJobJob$default;
                receiveChannel = receiveChannelProduce$default;
            } catch (AbortFlowException e2) {
                e = e2;
                completableJob = completableJobJob$default;
                receiveChannel = receiveChannelProduce$default;
            } catch (Throwable th) {
                th = th;
                receiveChannel = receiveChannelProduce$default;
            }
            try {
            } catch (AbortFlowException e3) {
                e = e3;
                receiveChannel2 = receiveChannel;
                completableJob2 = completableJob;
                FlowExceptions_commonKt.checkOwnership(e, completableJob2);
                r2 = receiveChannel2;
                ReceiveChannel.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
                return C1133Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                r2 = receiveChannel;
                ReceiveChannel.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
                throw th;
            }
            if (ChannelFlowKt.withContextUndispatched$default(coroutineContextMo6100plus, c1133Unit, null, c15692, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            r2 = receiveChannel;
            ReceiveChannel.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
            return C1133Unit.INSTANCE;
            FlowExceptions_commonKt.checkOwnership(e, completableJob2);
            r2 = receiveChannel2;
            ReceiveChannel.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
            return C1133Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
