package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p113reflect.KFunction;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata(m4987d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\u001a,\u0010\u0000\u001a \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004H\u0000\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0002\u001av\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2O\b\u0002\u0010\u0012\u001aI\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000bH\u0002\u001a\u0018\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u000bH\u0002\u001a\u0018\u0010O\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\u000eH\u0002\"\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010 \u001a\u00020!8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010)\u001a\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+\"\u000e\u0010,\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010?\u001a\u00020\u0002*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A\"\u0019\u0010B\u001a\u00020\u000b*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D\"\u000e\u0010H\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010J\u001a\u00020\u0002*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010A\"\u0019\u0010L\u001a\u00020\u000e*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006Q"}, m4988d2 = {"createSegmentFunction", "Lkotlin/reflect/KFunction2;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ChannelSegment;", "E", "createSegment", "id", "prev", "NULL_SEGMENT", BuildConfig.f24315FLAVOR, "SEGMENT_SIZE", BuildConfig.f24315FLAVOR, "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "tryResume0", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "onCancellation", "Lkotlin/Function3;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/CoroutineContext;", "context", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Z", "BUFFER_END_RENDEZVOUS", "BUFFER_END_UNLIMITED", "initialBufferEnd", "capacity", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "IN_BUFFER", "RESUMING_BY_RCV", "RESUMING_BY_EB", "POISONED", "DONE_RCV", "INTERRUPTED_SEND", "INTERRUPTED_RCV", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "SUSPEND", "SUSPEND_NO_WAITER", "FAILED", "RESULT_RENDEZVOUS", "RESULT_BUFFERED", "RESULT_SUSPEND", "RESULT_SUSPEND_NO_WAITER", "RESULT_CLOSED", "RESULT_FAILED", "NO_RECEIVE_RESULT", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "NO_CLOSE_CAUSE", "CLOSE_STATUS_ACTIVE", "CLOSE_STATUS_CANCELLATION_STARTED", "CLOSE_STATUS_CLOSED", "CLOSE_STATUS_CANCELLED", "SENDERS_CLOSE_STATUS_SHIFT", "SENDERS_COUNTER_MASK", "sendersCounter", "getSendersCounter", "(J)J", "sendersCloseStatus", "getSendersCloseStatus", "(J)I", "constructSendersAndCloseStatus", "counter", "closeStatus", "EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT", "EB_COMPLETED_COUNTER_MASK", "ebCompletedCounter", "getEbCompletedCounter", "ebPauseExpandBuffers", "getEbPauseExpandBuffers", "(J)Z", "constructEBCompletedAndPauseFlag", "pauseEB", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class BufferedChannelKt {
    private static final long BUFFER_END_RENDEZVOUS = 0;
    private static final long BUFFER_END_UNLIMITED = Long.MAX_VALUE;
    private static final int CLOSE_STATUS_ACTIVE = 0;
    private static final int CLOSE_STATUS_CANCELLATION_STARTED = 1;
    private static final int CLOSE_STATUS_CANCELLED = 3;
    private static final int CLOSE_STATUS_CLOSED = 2;
    private static final long EB_COMPLETED_COUNTER_MASK = 4611686018427387903L;
    private static final long EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT = 4611686018427387904L;
    private static final int RESULT_BUFFERED = 1;
    private static final int RESULT_CLOSED = 4;
    private static final int RESULT_FAILED = 5;
    private static final int RESULT_RENDEZVOUS = 0;
    private static final int RESULT_SUSPEND = 2;
    private static final int RESULT_SUSPEND_NO_WAITER = 3;
    private static final int SENDERS_CLOSE_STATUS_SHIFT = 60;
    private static final long SENDERS_COUNTER_MASK = 1152921504606846975L;
    private static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment<>(-1, null, null, 0);

    @JvmField
    public static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    @JvmField
    public static final C1578Symbol BUFFERED = new C1578Symbol("BUFFERED");
    private static final C1578Symbol IN_BUFFER = new C1578Symbol("SHOULD_BUFFER");
    private static final C1578Symbol RESUMING_BY_RCV = new C1578Symbol("S_RESUMING_BY_RCV");
    private static final C1578Symbol RESUMING_BY_EB = new C1578Symbol("RESUMING_BY_EB");
    private static final C1578Symbol POISONED = new C1578Symbol("POISONED");
    private static final C1578Symbol DONE_RCV = new C1578Symbol("DONE_RCV");
    private static final C1578Symbol INTERRUPTED_SEND = new C1578Symbol("INTERRUPTED_SEND");
    private static final C1578Symbol INTERRUPTED_RCV = new C1578Symbol("INTERRUPTED_RCV");
    private static final C1578Symbol CHANNEL_CLOSED = new C1578Symbol("CHANNEL_CLOSED");

    /* renamed from: SUSPEND */
    private static final C1578Symbol f5627SUSPEND = new C1578Symbol("SUSPEND");
    private static final C1578Symbol SUSPEND_NO_WAITER = new C1578Symbol("SUSPEND_NO_WAITER");

    /* renamed from: FAILED */
    private static final C1578Symbol f5626FAILED = new C1578Symbol("FAILED");
    private static final C1578Symbol NO_RECEIVE_RESULT = new C1578Symbol("NO_RECEIVE_RESULT");
    private static final C1578Symbol CLOSE_HANDLER_CLOSED = new C1578Symbol("CLOSE_HANDLER_CLOSED");
    private static final C1578Symbol CLOSE_HANDLER_INVOKED = new C1578Symbol("CLOSE_HANDLER_INVOKED");
    private static final C1578Symbol NO_CLOSE_CAUSE = new C1578Symbol("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1 */
    public static final /* synthetic */ class C13601<E> extends FunctionReferenceImpl implements Function2<Long, ChannelSegment<E>, ChannelSegment<E>> {
        public static final C13601 INSTANCE = new C13601();

        public C13601() {
            super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(Long l, Object obj) {
            return m7075invoke(l.longValue(), (ChannelSegment) obj);
        }

        /* renamed from: invoke */
        public final ChannelSegment<E> m7075invoke(long j, ChannelSegment<E> channelSegment) {
            return BufferedChannelKt.createSegment(j, channelSegment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructEBCompletedAndPauseFlag(long j, boolean z) {
        return (z ? EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT : 0L) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructSendersAndCloseStatus(long j, int i) {
        return (i << 60) + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> ChannelSegment<E> createSegment(long j, ChannelSegment<E> channelSegment) {
        return new ChannelSegment<>(j, channelSegment, channelSegment.getChannel(), 0);
    }

    public static final <E> KFunction<ChannelSegment<E>> createSegmentFunction() {
        return C13601.INSTANCE;
    }

    public static final C1578Symbol getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }

    private static final long getEbCompletedCounter(long j) {
        return j & 4611686018427387903L;
    }

    private static final boolean getEbPauseExpandBuffers(long j) {
        return (j & EB_COMPLETED_PAUSE_EXPAND_BUFFERS_BIT) != 0;
    }

    private static final int getSendersCloseStatus(long j) {
        return (int) (j >> 60);
    }

    private static final long getSendersCounter(long j) {
        return j & SENDERS_COUNTER_MASK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initialBufferEnd(int i) {
        if (i == 0) {
            return 0L;
        }
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean tryResume0(CancellableContinuation<? super T> cancellableContinuation, T t, Function3<? super Throwable, ? super T, ? super CoroutineContext, C1133Unit> function3) {
        Object objTryResume = cancellableContinuation.tryResume(t, null, function3);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    public static /* synthetic */ boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object obj, Function3 function3, int i, Object obj2) {
        if ((i & 2) != 0) {
            function3 = null;
        }
        return tryResume0(cancellableContinuation, obj, function3);
    }
}
