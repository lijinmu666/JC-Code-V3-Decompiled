package p122kotlinx.coroutines.p128stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "<init>", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class StreamFlow<T> implements InterfaceC1426Flow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile;
    private final Stream<T> stream;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.stream.StreamFlow", m6124f = "Stream.kt", m6125i = {0, 0}, m6126l = {22}, m6127m = "collect", m6128n = {"collector", "value"}, m6130s = {"L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1 */
    public static final class C15901 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f7268L$0;

        /* renamed from: L$1 */
        Object f7269L$1;

        /* renamed from: L$2 */
        Object f7270L$2;

        /* renamed from: label */
        int f7271label;

        /* renamed from: result */
        /* synthetic */ Object f7272result;

        /* renamed from: this$0 */
        final /* synthetic */ StreamFlow<T> f7273this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15901(StreamFlow<T> streamFlow, Continuation<? super C15901> continuation) {
            super(continuation);
            this.f7273this$0 = streamFlow;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7272result = obj;
            this.f7271label |= Integer.MIN_VALUE;
            return this.f7273this$0.mo4308collect(null, this);
        }
    }

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    private final /* synthetic */ int getConsumed$volatile() {
        return this.consumed$volatile;
    }

    private final /* synthetic */ void setConsumed$volatile(int i) {
        this.consumed$volatile = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C15901 c15901;
        FlowCollector flowCollector2;
        Iterator<T> it;
        if (continuation instanceof C15901) {
            c15901 = (C15901) continuation;
            int i = c15901.f7271label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15901.f7271label = i - Integer.MIN_VALUE;
            } else {
                c15901 = new C15901(this, continuation);
            }
        }
        Object obj = c15901.f7272result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15901.f7271label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (!consumed$volatile$FU.compareAndSet(this, 0, 1)) {
                    throw new IllegalStateException("Stream.consumeAsFlow can be collected only once");
                }
                flowCollector2 = flowCollector;
                it = this.stream.iterator();
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c15901.f7269L$1;
                FlowCollector flowCollector3 = (FlowCollector) c15901.f7268L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector3;
            }
            while (it.hasNext()) {
                T next = it.next();
                c15901.f7268L$0 = flowCollector2;
                c15901.f7269L$1 = it;
                c15901.f7270L$2 = SpillingKt.nullOutSpilledVariable(next);
                c15901.f7271label = 1;
                if (flowCollector2.mo4309emit(next, c15901) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.stream.close();
            return C1133Unit.INSTANCE;
        } catch (Throwable th) {
            this.stream.close();
            throw th;
        }
    }
}
