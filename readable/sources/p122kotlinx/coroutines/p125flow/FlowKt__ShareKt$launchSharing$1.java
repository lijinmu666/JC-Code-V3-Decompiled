package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.SharingStarted;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", m6124f = "Share.kt", m6125i = {}, m6126l = {210, 214, 215, 221}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ T $initialValue;

    /* renamed from: $shared */
    final /* synthetic */ MutableSharedFlow<T> f6739$shared;
    final /* synthetic */ SharingStarted $started;
    final /* synthetic */ InterfaceC1426Flow<T> $upstream;

    /* renamed from: label */
    int f6740label;

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", m6124f = "Share.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 */
    public static final class C15171 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {

        /* renamed from: I$0 */
        /* synthetic */ int f6741I$0;

        /* renamed from: label */
        int f6742label;

        public C15171(Continuation<? super C15171> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15171 c15171 = new C15171(continuation);
            c15171.f6741I$0 = ((Number) obj).intValue();
            return c15171;
        }

        /* renamed from: invoke */
        public final Object m7332invoke(int i, Continuation<? super Boolean> continuation) {
            return ((C15171) mo2166create(Integer.valueOf(i), continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.f6741I$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6742label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(i > 0);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(Integer num, Continuation<? super Boolean> continuation) {
            return m7332invoke(num.intValue(), continuation);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", m6124f = "Share.kt", m6125i = {0}, m6126l = {223}, m6127m = "invokeSuspend", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 */
    public static final class C15182 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ T $initialValue;

        /* renamed from: $shared */
        final /* synthetic */ MutableSharedFlow<T> f6743$shared;
        final /* synthetic */ InterfaceC1426Flow<T> $upstream;

        /* renamed from: L$0 */
        /* synthetic */ Object f6744L$0;

        /* renamed from: label */
        int f6745label;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SharingCommand.m7383values().length];
                try {
                    iArr[SharingCommand.f7015START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SharingCommand.f7016STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15182(InterfaceC1426Flow<? extends T> interfaceC1426Flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super C15182> continuation) {
            super(2, continuation);
            this.$upstream = interfaceC1426Flow;
            this.f6743$shared = mutableSharedFlow;
            this.$initialValue = t;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15182 c15182 = new C15182(this.$upstream, this.f6743$shared, this.$initialValue, continuation);
            c15182.f6744L$0 = obj;
            return c15182;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SharingCommand sharingCommand = (SharingCommand) this.f6744L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6745label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[sharingCommand.ordinal()];
                if (i2 == 1) {
                    InterfaceC1426Flow<T> interfaceC1426Flow = this.$upstream;
                    SharedFlow sharedFlow = this.f6743$shared;
                    this.f6744L$0 = SpillingKt.nullOutSpilledVariable(sharingCommand);
                    this.f6745label = 1;
                    if (interfaceC1426Flow.mo4308collect(sharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    T t = this.$initialValue;
                    if (t == SharedFlowKt.NO_VALUE) {
                        this.f6743$shared.resetReplayCache();
                    } else {
                        C1207Boxing.boxBoolean(this.f6743$shared.mo7378tryEmit(t));
                    }
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
        public final Object mo2167invoke(SharingCommand sharingCommand, Continuation<? super C1133Unit> continuation) {
            return ((C15182) mo2166create(sharingCommand, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, InterfaceC1426Flow<? extends T> interfaceC1426Flow, MutableSharedFlow<T> mutableSharedFlow, T t, Continuation<? super FlowKt__ShareKt$launchSharing$1> continuation) {
        super(2, continuation);
        this.$started = sharingStarted;
        this.$upstream = interfaceC1426Flow;
        this.f6739$shared = mutableSharedFlow;
        this.$initialValue = t;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.f6739$shared, this.$initialValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[RETURN] */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InterfaceC1426Flow<T> interfaceC1426Flow;
        SharedFlow sharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6740label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    interfaceC1426Flow = this.$upstream;
                    sharedFlow = this.f6739$shared;
                    this.f6740label = 3;
                    if (interfaceC1426Flow.mo4308collect(sharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SharingStarted sharingStarted = this.$started;
            SharingStarted.Companion companion = SharingStarted.INSTANCE;
            if (sharingStarted == companion.getEagerly()) {
                InterfaceC1426Flow<T> interfaceC1426Flow2 = this.$upstream;
                SharedFlow sharedFlow2 = this.f6739$shared;
                this.f6740label = 1;
                if (interfaceC1426Flow2.mo4308collect(sharedFlow2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (this.$started == companion.getLazily()) {
                StateFlow<Integer> subscriptionCount = this.f6739$shared.getSubscriptionCount();
                C15171 c15171 = new C15171(null);
                this.f6740label = 2;
                if (C1427FlowKt.m7216first(subscriptionCount, c15171, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                interfaceC1426Flow = this.$upstream;
                sharedFlow = this.f6739$shared;
                this.f6740label = 3;
                if (interfaceC1426Flow.mo4308collect(sharedFlow, this) == coroutine_suspended) {
                }
            } else {
                InterfaceC1426Flow interfaceC1426FlowDistinctUntilChanged = C1427FlowKt.distinctUntilChanged(this.$started.mo7384command(this.f6739$shared.getSubscriptionCount()));
                C15182 c15182 = new C15182(this.$upstream, this.f6739$shared, this.$initialValue, null);
                this.f6740label = 4;
                if (C1427FlowKt.collectLatest(interfaceC1426FlowDistinctUntilChanged, c15182, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
