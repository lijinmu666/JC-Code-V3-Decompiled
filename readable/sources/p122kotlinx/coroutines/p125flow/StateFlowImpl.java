package p122kotlinx.coroutines.p125flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow;
import p122kotlinx.coroutines.p125flow.internal.FusibleFlow;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\"H\u0016J\u001c\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0096@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0003H\u0014J\u001d\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030,2\u0006\u0010-\u001a\u00020\u000eH\u0014¢\u0006\u0002\u0010.J&\u0010/\u001a\b\u0012\u0004\u0012\u00028\u0000002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016R\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\nR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, m4988d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "sequence", BuildConfig.f24315FLAVOR, "value", "getValue", "()Ljava/lang/Object;", "setValue", "compareAndSet", BuildConfig.f24315FLAVOR, "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "replayCache", BuildConfig.f24315FLAVOR, "getReplayCache", "()Ljava/util/List;", "tryEmit", "(Ljava/lang/Object;)Z", "emit", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "createSlotArray", BuildConfig.f24315FLAVOR, "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,433:1\n14#2:434\n14#2:442\n26#3:435\n26#3:439\n16#4:436\n16#4:440\n13805#5,2:437\n1307#6:441\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n320#1:434\n401#1:442\n329#1:435\n357#1:439\n329#1:436\n357#1:440\n353#1:437,2\n390#1:441\n*E\n"})
/* loaded from: classes.dex */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.StateFlowImpl", m6124f = "StateFlow.kt", m6125i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m6126l = {389, 401, 406}, m6127m = "collect", m6128n = {"collector", "slot", "collector", "slot", "collectorJob", "oldState", "newState", "collector", "slot", "collectorJob", "oldState", "newState"}, m6130s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1 */
    public static final class C15571 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f7038L$0;

        /* renamed from: L$1 */
        Object f7039L$1;

        /* renamed from: L$2 */
        Object f7040L$2;

        /* renamed from: L$3 */
        Object f7041L$3;

        /* renamed from: L$4 */
        Object f7042L$4;

        /* renamed from: label */
        int f7043label;

        /* renamed from: result */
        /* synthetic */ Object f7044result;

        /* renamed from: this$0 */
        final /* synthetic */ StateFlowImpl<T> f7045this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15571(StateFlowImpl<T> stateFlowImpl, Continuation<? super C15571> continuation) {
            super(continuation);
            this.f7045this$0 = stateFlowImpl;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7044result = obj;
            this.f7043label |= Integer.MIN_VALUE;
            return this.f7045this$0.mo4308collect(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i;
        StateFlowSlot[] slots;
        synchronized (this) {
            Object obj = _state$volatile$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            _state$volatile$FU.set(this, newState);
            int i2 = this.sequence;
            if ((i2 & 1) != 0) {
                this.sequence = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.sequence = i3;
            StateFlowSlot[] slots2 = getSlots();
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = slots2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i = this.sequence;
                    if (i == i3) {
                        this.sequence = i3 + 1;
                        return true;
                    }
                    slots = getSlots();
                    C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
                }
                slots2 = slots;
                i3 = i;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        if (r8 == false) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x0099, B:38:0x00a3, B:40:0x00a8, B:51:0x00ce, B:53:0x00d4, B:42:0x00ae, B:46:0x00b5, B:21:0x0057, B:24:0x0065, B:35:0x008a), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a8 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x0099, B:38:0x00a3, B:40:0x00a8, B:51:0x00ce, B:53:0x00d4, B:42:0x00ae, B:46:0x00b5, B:21:0x0057, B:24:0x0065, B:35:0x008a), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #1 {all -> 0x003e, blocks: (B:14:0x003a, B:36:0x0099, B:38:0x00a3, B:40:0x00a8, B:51:0x00ce, B:53:0x00d4, B:42:0x00ae, B:46:0x00b5, B:21:0x0057, B:24:0x0065, B:35:0x008a), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d2 -> B:36:0x0099). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e8 -> B:36:0x0099). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.p125flow.SharedFlow, p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) throws Throwable {
        C15571 c15571;
        StateFlowSlot stateFlowSlot;
        FlowCollector flowCollector2;
        InterfaceC1342Job interfaceC1342Job;
        Object obj;
        StateFlowSlot stateFlowSlot2;
        Object obj2;
        StateFlowSlot stateFlowSlot3;
        boolean zTakePending;
        T t;
        if (continuation instanceof C15571) {
            c15571 = (C15571) continuation;
            int i = c15571.f7043label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15571.f7043label = i - Integer.MIN_VALUE;
            } else {
                c15571 = new C15571(this, continuation);
            }
        }
        Object obj3 = c15571.f7044result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15571.f7043label;
        ?? r6 = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj3);
                StateFlowSlot stateFlowSlotAllocateSlot = allocateSlot();
                try {
                    if (flowCollector instanceof SubscribedFlowCollector) {
                        c15571.f7038L$0 = flowCollector;
                        c15571.f7039L$1 = stateFlowSlotAllocateSlot;
                        c15571.f7043label = 1;
                        if (((SubscribedFlowCollector) flowCollector).onSubscription(c15571) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    stateFlowSlot = stateFlowSlotAllocateSlot;
                } catch (Throwable th) {
                    th = th;
                    r6 = stateFlowSlotAllocateSlot;
                    freeSlot(r6);
                    throw th;
                }
            } else if (i2 == 1) {
                StateFlowSlot stateFlowSlot4 = (StateFlowSlot) c15571.f7039L$1;
                flowCollector = (FlowCollector) c15571.f7038L$0;
                ResultKt.throwOnFailure(obj3);
                stateFlowSlot = stateFlowSlot4;
            } else if (i2 == 2) {
                obj = c15571.f7042L$4;
                interfaceC1342Job = (InterfaceC1342Job) c15571.f7040L$2;
                StateFlowSlot stateFlowSlot5 = (StateFlowSlot) c15571.f7039L$1;
                flowCollector2 = (FlowCollector) c15571.f7038L$0;
                ResultKt.throwOnFailure(obj3);
                stateFlowSlot2 = stateFlowSlot5;
                obj2 = obj;
                stateFlowSlot3 = stateFlowSlot2;
                zTakePending = stateFlowSlot3.takePending();
                r6 = stateFlowSlot3;
                if (!zTakePending) {
                }
                ?? r11 = _state$volatile$FU.get(this);
                if (interfaceC1342Job != null) {
                }
                if (obj != null) {
                }
                if (r11 != NullSurrogateKt.f7173NULL) {
                }
                c15571.f7038L$0 = flowCollector2;
                c15571.f7039L$1 = r6;
                c15571.f7040L$2 = interfaceC1342Job;
                c15571.f7041L$3 = SpillingKt.nullOutSpilledVariable(obj);
                c15571.f7042L$4 = r11;
                c15571.f7043label = 2;
                if (flowCollector2.mo4309emit(t, c15571) != coroutine_suspended) {
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c15571.f7041L$3;
                interfaceC1342Job = (InterfaceC1342Job) c15571.f7040L$2;
                StateFlowSlot stateFlowSlot6 = (StateFlowSlot) c15571.f7039L$1;
                flowCollector2 = (FlowCollector) c15571.f7038L$0;
                ResultKt.throwOnFailure(obj3);
                r6 = stateFlowSlot6;
                ?? r112 = _state$volatile$FU.get(this);
                if (interfaceC1342Job != null) {
                    C1344JobKt.ensureActive(interfaceC1342Job);
                }
                if (obj != null) {
                    boolean zAreEqual = Intrinsics.areEqual(obj, (Object) r112);
                    stateFlowSlot3 = r6;
                    obj2 = r112;
                }
                t = r112 != NullSurrogateKt.f7173NULL ? null : r112;
                c15571.f7038L$0 = flowCollector2;
                c15571.f7039L$1 = r6;
                c15571.f7040L$2 = interfaceC1342Job;
                c15571.f7041L$3 = SpillingKt.nullOutSpilledVariable(obj);
                c15571.f7042L$4 = r112;
                c15571.f7043label = 2;
                if (flowCollector2.mo4309emit(t, c15571) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = r112;
                stateFlowSlot2 = r6;
                obj2 = obj;
                stateFlowSlot3 = stateFlowSlot2;
                zTakePending = stateFlowSlot3.takePending();
                r6 = stateFlowSlot3;
                if (!zTakePending) {
                    c15571.f7038L$0 = flowCollector2;
                    c15571.f7039L$1 = stateFlowSlot3;
                    c15571.f7040L$2 = interfaceC1342Job;
                    c15571.f7041L$3 = obj;
                    c15571.f7042L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    c15571.f7043label = 3;
                    Object objAwaitPending = stateFlowSlot3.awaitPending(c15571);
                    r6 = stateFlowSlot3;
                    if (objAwaitPending == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ?? r1122 = _state$volatile$FU.get(this);
                if (interfaceC1342Job != null) {
                }
                if (obj != null) {
                }
                if (r1122 != NullSurrogateKt.f7173NULL) {
                }
                c15571.f7038L$0 = flowCollector2;
                c15571.f7039L$1 = r6;
                c15571.f7040L$2 = interfaceC1342Job;
                c15571.f7041L$3 = SpillingKt.nullOutSpilledVariable(obj);
                c15571.f7042L$4 = r1122;
                c15571.f7043label = 2;
                if (flowCollector2.mo4309emit(t, c15571) != coroutine_suspended) {
                }
            }
            flowCollector2 = flowCollector;
            interfaceC1342Job = (InterfaceC1342Job) c15571.get$context().mo6098get(InterfaceC1342Job.INSTANCE);
            obj = null;
            r6 = stateFlowSlot;
            ?? r11222 = _state$volatile$FU.get(this);
            if (interfaceC1342Job != null) {
            }
            if (obj != null) {
            }
            if (r11222 != NullSurrogateKt.f7173NULL) {
            }
            c15571.f7038L$0 = flowCollector2;
            c15571.f7039L$1 = r6;
            c15571.f7040L$2 = interfaceC1342Job;
            c15571.f7041L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c15571.f7042L$4 = r11222;
            c15571.f7043label = 2;
            if (flowCollector2.mo4309emit(t, c15571) != coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.f7173NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.f7173NULL;
        }
        return updateState(expect, update);
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow, p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        setValue(t);
        return C1133Unit.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.FusibleFlow
    /* renamed from: fuse */
    public InterfaceC1426Flow<T> mo7379fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // p122kotlinx.coroutines.p125flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.m5801listOf(getValue());
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableStateFlow, p122kotlinx.coroutines.p125flow.StateFlow
    public T getValue() {
        C1578Symbol c1578Symbol = NullSurrogateKt.f7173NULL;
        T t = (T) _state$volatile$FU.get(this);
        if (t == c1578Symbol) {
            return null;
        }
        return t;
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.f7173NULL;
        }
        updateState(null, t);
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow
    /* renamed from: tryEmit */
    public boolean mo7378tryEmit(T value) {
        setValue(value);
        return true;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }
}
