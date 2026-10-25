package p122kotlinx.coroutines.p125flow;

import java.util.List;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1338DelayKt;

@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m4988d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", BuildConfig.f24315FLAVOR, "replayExpiration", "<init>", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "equals", BuildConfig.f24315FLAVOR, "other", BuildConfig.f24315FLAVOR, "hashCode", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
/* loaded from: classes.dex */
final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    @Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", m6124f = "SharingStarted.kt", m6125i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, m6126l = {175, 177, 179, 180, 182}, m6127m = "invokeSuspend", m6128n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, m6130s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1 */
    public static final class C15551 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super C1133Unit>, Object> {

        /* renamed from: I$0 */
        /* synthetic */ int f7032I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f7033L$0;

        /* renamed from: label */
        int f7034label;

        public C15551(Continuation<? super C15551> continuation) {
            super(3, continuation);
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo6219invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super C1133Unit> continuation) {
            return m7387invoke(flowCollector, num.intValue(), continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[RETURN] */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            long j;
            SharingCommand sharingCommand;
            FlowCollector flowCollector = (FlowCollector) this.f7033L$0;
            int i = this.f7032I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.f7034label;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        if (StartedWhileSubscribed.this.replayExpiration > 0) {
                            SharingCommand sharingCommand2 = SharingCommand.f7016STOP;
                            this.f7033L$0 = flowCollector;
                            this.f7032I$0 = i;
                            this.f7034label = 3;
                            if (flowCollector.mo4309emit(sharingCommand2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            j = StartedWhileSubscribed.this.replayExpiration;
                            this.f7033L$0 = flowCollector;
                            this.f7032I$0 = i;
                            this.f7034label = 4;
                            if (C1338DelayKt.m6972delay(j, this) == coroutine_suspended) {
                            }
                        }
                        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                        this.f7033L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.f7032I$0 = i;
                        this.f7034label = 5;
                        if (flowCollector.mo4309emit(sharingCommand, this) == coroutine_suspended) {
                        }
                    } else if (i2 == 3) {
                        ResultKt.throwOnFailure(obj);
                        j = StartedWhileSubscribed.this.replayExpiration;
                        this.f7033L$0 = flowCollector;
                        this.f7032I$0 = i;
                        this.f7034label = 4;
                        if (C1338DelayKt.m6972delay(j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                        this.f7033L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.f7032I$0 = i;
                        this.f7034label = 5;
                        if (flowCollector.mo4309emit(sharingCommand, this) == coroutine_suspended) {
                        }
                    } else if (i2 == 4) {
                        ResultKt.throwOnFailure(obj);
                        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                        this.f7033L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.f7032I$0 = i;
                        this.f7034label = 5;
                        if (flowCollector.mo4309emit(sharingCommand, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                if (i > 0) {
                    SharingCommand sharingCommand3 = SharingCommand.f7015START;
                    this.f7033L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.f7032I$0 = i;
                    this.f7034label = 1;
                    if (flowCollector.mo4309emit(sharingCommand3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    long j2 = StartedWhileSubscribed.this.stopTimeout;
                    this.f7033L$0 = flowCollector;
                    this.f7032I$0 = i;
                    this.f7034label = 2;
                    if (C1338DelayKt.m6972delay(j2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (StartedWhileSubscribed.this.replayExpiration > 0) {
                    }
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.f7033L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.f7032I$0 = i;
                    this.f7034label = 5;
                    if (flowCollector.mo4309emit(sharingCommand, this) == coroutine_suspended) {
                    }
                }
            }
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final Object m7387invoke(FlowCollector<? super SharingCommand> flowCollector, int i, Continuation<? super C1133Unit> continuation) {
            C15551 c15551 = StartedWhileSubscribed.this.new C15551(continuation);
            c15551.f7033L$0 = flowCollector;
            c15551.f7032I$0 = i;
            return c15551.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it", "Lkotlinx/coroutines/flow/SharingCommand;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", m6124f = "SharingStarted.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.StartedWhileSubscribed$command$2 */
    public static final class C15562 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {

        /* renamed from: L$0 */
        /* synthetic */ Object f7036L$0;

        /* renamed from: label */
        int f7037label;

        public C15562(Continuation<? super C15562> continuation) {
            super(2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15562 c15562 = new C15562(continuation);
            c15562.f7036L$0 = obj;
            return c15562;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SharingCommand sharingCommand = (SharingCommand) this.f7036L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7037label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return C1207Boxing.boxBoolean(sharingCommand != SharingCommand.f7015START);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SharingCommand sharingCommand, Continuation<? super Boolean> continuation) {
            return ((C15562) mo2166create(sharingCommand, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public StartedWhileSubscribed(long j, long j2) {
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (j < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // p122kotlinx.coroutines.p125flow.SharingStarted
    /* renamed from: command */
    public InterfaceC1426Flow<SharingCommand> mo7384command(StateFlow<Integer> subscriptionCount) {
        return C1427FlowKt.distinctUntilChanged(C1427FlowKt.dropWhile(C1427FlowKt.transformLatest(subscriptionCount, new C15551(null)), new C15562(null)));
    }

    /* renamed from: equals */
    public boolean m7386equals(Object other) {
        if (other instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) other;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (Long.hashCode(this.stopTimeout) * 31) + Long.hashCode(this.replayExpiration);
    }

    public String toString() {
        List listCreateListBuilder = CollectionsKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            listCreateListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < LongCompanionObject.MAX_VALUE) {
            listCreateListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(CollectionsKt.m5800build(listCreateListBuilder), null, null, null, 0, null, null, 63, null) + ')';
    }
}
