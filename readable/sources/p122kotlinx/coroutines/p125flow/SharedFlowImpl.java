package p122kotlinx.coroutines.p125flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.CancellableContinuationImpl;
import p122kotlinx.coroutines.CancellableContinuationKt;
import p122kotlinx.coroutines.DisposableHandle;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowKt;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowSlot;
import p122kotlinx.coroutines.p125flow.internal.FusibleFlow;

@Metadata(m4987d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001iB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0096@¢\u0006\u0002\u00100J\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0016\u00105\u001a\u0002062\u0006\u00103\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u00107J\u0015\u00108\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00104J\u0015\u00109\u001a\u0002022\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00104J\b\u0010:\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010\u0010H\u0002J7\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0010\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u0002062\u0006\u00103\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u00107J\u0010\u0010E\u001a\u0002062\u0006\u0010F\u001a\u00020GH\u0002J\r\u0010H\u001a\u00020\u0013H\u0000¢\u0006\u0002\bIJ%\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000f2\u0006\u0010L\u001a\u00020\u0013H\u0000¢\u0006\u0004\bM\u0010NJ(\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J\b\u0010T\u001a\u000206H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010\u00102\u0006\u0010V\u001a\u00020\u0003H\u0002J\u0010\u0010W\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0003H\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\u00102\u0006\u0010Y\u001a\u00020\u0013H\u0002J\u0016\u0010Z\u001a\u0002062\u0006\u0010V\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010[J1\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000f2\u0014\u0010]\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010K0\u000fH\u0002¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\u0003H\u0014J\u001d\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f2\u0006\u0010a\u001a\u00020\bH\u0014¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u000206H\u0016J&\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006j"}, m4988d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", BuildConfig.f24315FLAVOR, "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "[Ljava/lang/Object;", "replayIndex", BuildConfig.f24315FLAVOR, "minCollectorIndex", "bufferSize", "queueSize", "head", "getHead", "()J", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "bufferEndIndex", "getBufferEndIndex", "queueEndIndex", "getQueueEndIndex", "replayCache", BuildConfig.f24315FLAVOR, "getReplayCache", "()Ljava/util/List;", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;)Z", "emit", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmitLocked", "tryEmitNoCollectorsLocked", "dropOldestLocked", "correctCollectorIndexesOnDropOldest", "newHead", "enqueueLocked", "item", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "updateCollectorIndexLocked", "Lkotlin/coroutines/Continuation;", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "cleanupTailLocked", "tryTakeValue", "slot", "tryPeekLocked", "getPeekedValueLockedAt", "index", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findSlotsToResumeLocked", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "Emitter", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,741:1\n26#2:742\n26#2:745\n26#2:764\n26#2:767\n26#2:776\n26#2:787\n26#2:797\n16#3:743\n16#3:746\n16#3:765\n16#3:768\n16#3:777\n16#3:788\n16#3:798\n1307#4:744\n1#5:747\n91#6,2:748\n93#6,2:751\n95#6:754\n91#6,2:769\n93#6,2:772\n95#6:775\n91#6,2:790\n93#6,2:793\n95#6:796\n13805#7:750\n13806#7:753\n13805#7:771\n13806#7:774\n13805#7:792\n13806#7:795\n433#8,9:755\n442#8:766\n433#8,9:778\n442#8:789\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n366#1:742\n406#1:745\n499#1:764\n520#1:767\n636#1:776\n671#1:787\n699#1:797\n366#1:743\n406#1:746\n499#1:765\n520#1:768\n636#1:777\n671#1:788\n699#1:798\n388#1:744\n468#1:748,2\n468#1:751,2\n468#1:754\n543#1:769,2\n543#1:772,2\n543#1:775\n686#1:790,2\n686#1:793,2\n686#1:796\n468#1:750\n468#1:753\n543#1:771\n543#1:774\n686#1:792\n686#1:795\n497#1:755,9\n497#1:766\n670#1:778,9\n670#1:789\n*E\n"})
/* loaded from: classes.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", BuildConfig.f24315FLAVOR, "value", BuildConfig.f24315FLAVOR, "cont", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$Emitter */
    public static final class C1552Emitter implements DisposableHandle {

        @JvmField
        public final Continuation<C1133Unit> cont;

        @JvmField
        public final SharedFlowImpl<?> flow;

        @JvmField
        public long index;

        @JvmField
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public C1552Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super C1133Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // p122kotlinx.coroutines.DisposableHandle
        /* renamed from: dispose */
        public void mo6978dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.m7058values().length];
            try {
                iArr[BufferOverflow.f5601SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.SharedFlowImpl", m6124f = "SharedFlow.kt", m6125i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m6126l = {387, 394, 397}, m6127m = "collect$suspendImpl", m6128n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "newValue", "$this", "collector", "slot", "collectorJob", "newValue"}, m6130s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1 */
    public static final class C15531<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f7004L$0;

        /* renamed from: L$1 */
        Object f7005L$1;

        /* renamed from: L$2 */
        Object f7006L$2;

        /* renamed from: L$3 */
        Object f7007L$3;

        /* renamed from: L$4 */
        Object f7008L$4;

        /* renamed from: label */
        int f7009label;

        /* renamed from: result */
        /* synthetic */ Object f7010result;

        /* renamed from: this$0 */
        final /* synthetic */ SharedFlowImpl<T> f7011this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15531(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super C15531> continuation) {
            super(continuation);
            this.f7011this$0 = sharedFlowImpl;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7010result = obj;
            this.f7009label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.f7011this$0, null, this);
        }
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super C1133Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    C1124Result.Companion companion = C1124Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(C1552Emitter emitter) {
        synchronized (this) {
            try {
                if (emitter.index >= m7380getHead()) {
                    Object[] objArr = this.buffer;
                    Intrinsics.checkNotNull(objArr);
                    if (SharedFlowKt.getBufferAt(objArr, emitter.index) == emitter) {
                        SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
                        cleanupTailLocked();
                    }
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (m7380getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, m7380getHead() + getTotalSize(), null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, FlowCollector<? super T> flowCollector, Continuation<?> continuation) throws Throwable {
        C15531 c15531;
        SharedFlowImpl<T> sharedFlowImpl2;
        Throwable th;
        SharedFlowSlot sharedFlowSlot;
        FlowCollector<? super T> flowCollector2;
        InterfaceC1342Job interfaceC1342Job;
        FlowCollector flowCollector3;
        if (continuation instanceof C15531) {
            c15531 = (C15531) continuation;
            int i = c15531.f7009label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15531.f7009label = i - Integer.MIN_VALUE;
            } else {
                c15531 = new C15531(sharedFlowImpl, continuation);
            }
        }
        Object obj = c15531.f7010result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15531.f7009label;
        if (i2 != 0) {
            if (i2 == 1) {
                sharedFlowSlot = (SharedFlowSlot) c15531.f7006L$2;
                FlowCollector<? super T> flowCollector4 = (FlowCollector) c15531.f7005L$1;
                SharedFlowImpl<T> sharedFlowImpl3 = (SharedFlowImpl) c15531.f7004L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    flowCollector2 = flowCollector4;
                    sharedFlowImpl = sharedFlowImpl3;
                    try {
                        interfaceC1342Job = (InterfaceC1342Job) c15531.get$context().mo6098get(InterfaceC1342Job.INSTANCE);
                        flowCollector3 = flowCollector2;
                    } catch (Throwable th2) {
                        sharedFlowImpl2 = sharedFlowImpl;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sharedFlowImpl2 = sharedFlowImpl3;
                }
            } else {
                if (i2 != 2 && i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                InterfaceC1342Job interfaceC1342Job2 = (InterfaceC1342Job) c15531.f7007L$3;
                sharedFlowSlot = (SharedFlowSlot) c15531.f7006L$2;
                FlowCollector flowCollector5 = (FlowCollector) c15531.f7005L$1;
                sharedFlowImpl2 = (SharedFlowImpl) c15531.f7004L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    flowCollector3 = flowCollector5;
                    interfaceC1342Job = interfaceC1342Job2;
                    sharedFlowImpl = sharedFlowImpl2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            sharedFlowImpl2.freeSlot(sharedFlowSlot);
            throw th;
        }
        ResultKt.throwOnFailure(obj);
        SharedFlowSlot sharedFlowSlotAllocateSlot = sharedFlowImpl.allocateSlot();
        try {
            if (flowCollector instanceof SubscribedFlowCollector) {
                c15531.f7004L$0 = sharedFlowImpl;
                c15531.f7005L$1 = flowCollector;
                c15531.f7006L$2 = sharedFlowSlotAllocateSlot;
                c15531.f7009label = 1;
                if (((SubscribedFlowCollector) flowCollector).onSubscription(c15531) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            flowCollector2 = flowCollector;
            sharedFlowSlot = sharedFlowSlotAllocateSlot;
            interfaceC1342Job = (InterfaceC1342Job) c15531.get$context().mo6098get(InterfaceC1342Job.INSTANCE);
            flowCollector3 = flowCollector2;
        } catch (Throwable th5) {
            sharedFlowImpl2 = sharedFlowImpl;
            th = th5;
            sharedFlowSlot = sharedFlowSlotAllocateSlot;
        }
        while (true) {
            Object objTryTakeValue = sharedFlowImpl.tryTakeValue(sharedFlowSlot);
            if (objTryTakeValue == SharedFlowKt.NO_VALUE) {
                c15531.f7004L$0 = sharedFlowImpl;
                c15531.f7005L$1 = flowCollector3;
                c15531.f7006L$2 = sharedFlowSlot;
                c15531.f7007L$3 = interfaceC1342Job;
                c15531.f7008L$4 = SpillingKt.nullOutSpilledVariable(objTryTakeValue);
                c15531.f7009label = 2;
                if (sharedFlowImpl.awaitValue(sharedFlowSlot, c15531) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (interfaceC1342Job != null) {
                    C1344JobKt.ensureActive(interfaceC1342Job);
                }
                c15531.f7004L$0 = sharedFlowImpl;
                c15531.f7005L$1 = flowCollector3;
                c15531.f7006L$2 = sharedFlowSlot;
                c15531.f7007L$3 = interfaceC1342Job;
                c15531.f7008L$4 = SpillingKt.nullOutSpilledVariable(objTryTakeValue);
                c15531.f7009label = 3;
                if (flowCollector3.mo4309emit(objTryTakeValue, c15531) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j = sharedFlowSlot.index;
                    if (0 <= j && j < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, m7380getHead(), null);
        this.bufferSize--;
        long jM7380getHead = m7380getHead() + 1;
        if (this.replayIndex < jM7380getHead) {
            this.replayIndex = jM7380getHead;
        }
        if (this.minCollectorIndex < jM7380getHead) {
            correctCollectorIndexesOnDropOldest(jM7380getHead);
        }
    }

    public static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t, Continuation<? super C1133Unit> continuation) {
        Object objEmitSuspend;
        return (!sharedFlowImpl.mo7378tryEmit(t) && (objEmitSuspend = sharedFlowImpl.emitSuspend(t, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objEmitSuspend : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitSuspend(T t, Continuation<? super C1133Unit> continuation) {
        Continuation<C1133Unit>[] continuationArrFindSlotsToResumeLocked;
        C1552Emitter c1552Emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<C1133Unit>[] continuationArrFindSlotsToResumeLocked2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t)) {
                    C1124Result.Companion companion = C1124Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
                    continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                    c1552Emitter = null;
                } else {
                    C1552Emitter c1552Emitter2 = new C1552Emitter(this, getTotalSize() + m7380getHead(), t, cancellableContinuationImpl);
                    enqueueLocked(c1552Emitter2);
                    this.queueSize++;
                    if (this.bufferCapacity == 0) {
                        continuationArrFindSlotsToResumeLocked2 = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked2);
                    }
                    continuationArrFindSlotsToResumeLocked = continuationArrFindSlotsToResumeLocked2;
                    c1552Emitter = c1552Emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c1552Emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, c1552Emitter);
        }
        for (Continuation<C1133Unit> continuation2 : continuationArrFindSlotsToResumeLocked) {
            if (continuation2 != null) {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                continuation2.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArrGrowBuffer = this.buffer;
        if (objArrGrowBuffer == null) {
            objArrGrowBuffer = growBuffer(null, 0, 2);
        } else if (totalSize >= objArrGrowBuffer.length) {
            objArrGrowBuffer = growBuffer(objArrGrowBuffer, totalSize, objArrGrowBuffer.length * 2);
        }
        SharedFlowKt.setBufferAt(objArrGrowBuffer, m7380getHead() + totalSize, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation<C1133Unit>[] findSlotsToResumeLocked(Continuation<C1133Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super C1133Unit> continuation;
        int length = resumesIn.length;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            resumesIn = resumesIn;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        Intrinsics.checkNotNullExpressionValue(CopyOf, "copyOf(...)");
                        resumesIn = CopyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    private final long getBufferEndIndex() {
        return m7380getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHead */
    public final long m7380getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        return bufferAt instanceof C1552Emitter ? ((C1552Emitter) bufferAt).value : bufferAt;
    }

    private final long getQueueEndIndex() {
        return m7380getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((m7380getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long jM7380getHead = m7380getHead();
        for (int i = 0; i < curSize; i++) {
            long j = i + jM7380getHead;
            SharedFlowKt.setBufferAt(objArr, j, SharedFlowKt.getBufferAt(curBuffer, j));
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        enqueueLocked(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = m7380getHead() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j = slot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= m7380getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<C1133Unit>[] continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long jTryPeekLocked = tryPeekLocked(slot);
                if (jTryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j = slot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(jTryPeekLocked);
                    slot.index = jTryPeekLocked + 1;
                    continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<C1133Unit> continuation : continuationArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (continuation != null) {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                continuation.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long jMin = Math.min(newMinCollectorIndex, newReplayIndex);
        for (long jM7380getHead = m7380getHead(); jM7380getHead < jMin; jM7380getHead++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, jM7380getHead, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - jMin);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    @Override // p122kotlinx.coroutines.p125flow.SharedFlow, p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow, p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        return emit$suspendImpl(this, t, continuation);
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.FusibleFlow
    /* renamed from: fuse */
    public InterfaceC1426Flow<T> mo7379fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    public final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    @Override // p122kotlinx.coroutines.p125flow.SharedFlow
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            for (int i = 0; i < replaySize; i++) {
                arrayList.add(SharedFlowKt.getBufferAt(objArr, this.replayIndex + i));
            }
            return arrayList;
        }
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
    }

    @Override // p122kotlinx.coroutines.p125flow.MutableSharedFlow
    /* renamed from: tryEmit */
    public boolean mo7378tryEmit(T value) {
        int i;
        boolean z;
        Continuation<C1133Unit>[] continuationArrFindSlotsToResumeLocked = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(value)) {
                continuationArrFindSlotsToResumeLocked = findSlotsToResumeLocked(continuationArrFindSlotsToResumeLocked);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<C1133Unit> continuation : continuationArrFindSlotsToResumeLocked) {
            if (continuation != null) {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                continuation.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
            }
        }
        return z;
    }

    public final Continuation<C1133Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        long j;
        long j2;
        long j3;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long jM7380getHead = m7380getHead();
        long j4 = this.bufferSize + jM7380getHead;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j4++;
        }
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j5 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (0 <= j5 && j5 < j4) {
                        j4 = j5;
                    }
                }
            }
        }
        if (j4 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        int iMin = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j4))) : this.queueSize;
        Continuation<C1133Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j6 = this.queueSize + bufferEndIndex;
        if (iMin > 0) {
            continuationArr = new Continuation[iMin];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j7 = bufferEndIndex;
            int i = 0;
            while (true) {
                if (bufferEndIndex >= j6) {
                    j = j4;
                    j2 = j6;
                    break;
                }
                Object bufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j = j4;
                C1578Symbol c1578Symbol = SharedFlowKt.NO_VALUE;
                if (bufferAt != c1578Symbol) {
                    Intrinsics.checkNotNull(bufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    C1552Emitter c1552Emitter = (C1552Emitter) bufferAt;
                    int i2 = i + 1;
                    j2 = j6;
                    continuationArr[i] = c1552Emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, c1578Symbol);
                    SharedFlowKt.setBufferAt(objArr, j7, c1552Emitter.value);
                    j3 = 1;
                    j7++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                } else {
                    j2 = j6;
                    j3 = 1;
                }
                bufferEndIndex += j3;
                j4 = j;
                j6 = j2;
            }
            bufferEndIndex = j7;
        } else {
            j = j4;
            j2 = j6;
        }
        long jMax = Math.max(this.replayIndex, Math.max(jM7380getHead, bufferEndIndex - this.replay));
        if (this.bufferCapacity == 0 && jMax < j2) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.getBufferAt(objArr2, jMax), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                jMax++;
            }
        }
        long j8 = bufferEndIndex;
        updateBufferLocked(jMax, getNCollectors() == 0 ? j8 : j, j8, j2);
        cleanupTailLocked();
        return !(continuationArr.length == 0) ? findSlotsToResumeLocked(continuationArr) : continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }
}
