package p122kotlinx.coroutines.p125flow;

import java.util.NoSuchElementException;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;
import p122kotlinx.coroutines.p125flow.internal.FlowExceptions_commonKt;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001ap\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\b\b\u0001\u0010\u0002*\u0002H\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032F\u0010\u0004\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0086@¢\u0006\u0002\u0010\f\u001av\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000f\u001a\u0002H\u000e2H\b\u0004\u0010\u0004\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0086H¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001a \u0010\u0014\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0015\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001aB\u0010\u0015\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017H\u0086@¢\u0006\u0002\u0010\u0019\u001a \u0010\u001a\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001aD\u0010\u001a\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u001b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001a \u0010\u001c\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013¨\u0006\u001d"}, m4988d2 = {"reduce", "S", "T", "Lkotlinx/coroutines/flow/Flow;", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "accumulator", "value", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fold", "R", "initial", "acc", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleOrNull", "first", "predicate", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,168:1\n124#2,17:169\n124#2,17:186\n124#2,17:203\n124#2,17:220\n124#2,17:237\n*S KotlinDebug\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n68#1:169,17\n88#1:186,17\n102#1:203,17\n120#1:220,17\n133#1:237,17\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ReduceKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "first", m6128n = {"$this$first", "result", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 */
    public static final class C15011<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6655I$0;

        /* renamed from: L$0 */
        Object f6656L$0;

        /* renamed from: L$1 */
        Object f6657L$1;

        /* renamed from: L$2 */
        Object f6658L$2;

        /* renamed from: L$3 */
        Object f6659L$3;

        /* renamed from: label */
        int f6660label;

        /* renamed from: result */
        /* synthetic */ Object f6661result;

        public C15011(Continuation<? super C15011> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6661result = obj;
            this.f6660label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7215first(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "first", m6128n = {"$this$first", "predicate", "result", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3 */
    public static final class C15023<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6662I$0;

        /* renamed from: L$0 */
        Object f6663L$0;

        /* renamed from: L$1 */
        Object f6664L$1;

        /* renamed from: L$2 */
        Object f6665L$2;

        /* renamed from: L$3 */
        Object f6666L$3;

        /* renamed from: L$4 */
        Object f6667L$4;

        /* renamed from: label */
        int f6668label;

        /* renamed from: result */
        /* synthetic */ Object f6669result;

        public C15023(Continuation<? super C15023> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6669result = obj;
            this.f6668label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7216first(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "firstOrNull", m6128n = {"$this$firstOrNull", "result", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1 */
    public static final class C15031<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6670I$0;

        /* renamed from: L$0 */
        Object f6671L$0;

        /* renamed from: L$1 */
        Object f6672L$1;

        /* renamed from: L$2 */
        Object f6673L$2;

        /* renamed from: L$3 */
        Object f6674L$3;

        /* renamed from: label */
        int f6675label;

        /* renamed from: result */
        /* synthetic */ Object f6676result;

        public C15031(Continuation<? super C15031> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6676result = obj;
            this.f6675label |= Integer.MIN_VALUE;
            return C1427FlowKt.firstOrNull(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "firstOrNull", m6128n = {"$this$firstOrNull", "predicate", "result", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3 */
    public static final class C15043<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6677I$0;

        /* renamed from: L$0 */
        Object f6678L$0;

        /* renamed from: L$1 */
        Object f6679L$1;

        /* renamed from: L$2 */
        Object f6680L$2;

        /* renamed from: L$3 */
        Object f6681L$3;

        /* renamed from: L$4 */
        Object f6682L$4;

        /* renamed from: label */
        int f6683label;

        /* renamed from: result */
        /* synthetic */ Object f6684result;

        public C15043(Continuation<? super C15043> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6684result = obj;
            this.f6683label |= Integer.MIN_VALUE;
            return C1427FlowKt.firstOrNull(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {40}, m6127m = "fold", m6128n = {"$this$fold", "initial", "operation", "accumulator", "$i$f$fold"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$1\n*L\n1#1,168:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 */
    public static final class C15051<T, R> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6685I$0;

        /* renamed from: L$0 */
        Object f6686L$0;

        /* renamed from: L$1 */
        Object f6687L$1;

        /* renamed from: L$2 */
        Object f6688L$2;

        /* renamed from: L$3 */
        Object f6689L$3;

        /* renamed from: label */
        int f6690label;

        /* renamed from: result */
        /* synthetic */ Object f6691result;

        public C15051(Continuation<? super C15051> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6691result = obj;
            this.f6690label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.m7323fold(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2\n*L\n1#1,168:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2 */
    public static final class C15062<T> implements FlowCollector {
        final /* synthetic */ C1235Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public C15062(C1235Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            C1235Ref.ObjectRef objectRef;
            if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
                int i = flowKt__ReduceKt$fold$2$emit$1.f6694label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.f6694label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
                }
            }
            T t2 = (T) flowKt__ReduceKt$fold$2$emit$1.f6695result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$fold$2$emit$1.f6694label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(t2);
                C1235Ref.ObjectRef objectRef2 = this.$accumulator;
                Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                T t3 = objectRef2.f5202element;
                flowKt__ReduceKt$fold$2$emit$1.f6692L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__ReduceKt$fold$2$emit$1.f6693L$1 = objectRef2;
                flowKt__ReduceKt$fold$2$emit$1.f6694label = 1;
                Object objMo6219invoke = function3.mo6219invoke(t3, t, flowKt__ReduceKt$fold$2$emit$1);
                if (objMo6219invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                t2 = (T) objMo6219invoke;
                objectRef = objectRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (C1235Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$1.f6693L$1;
                ResultKt.throwOnFailure(t2);
            }
            objectRef.f5202element = t2;
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            C1235Ref.ObjectRef<R> objectRef = this.$accumulator;
            objectRef.f5202element = (T) this.$operation.mo6219invoke(objectRef.f5202element, t, continuation);
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0}, m6126l = {151}, m6127m = "last", m6128n = {"$this$last", "result"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 */
    public static final class C15071<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6697L$0;

        /* renamed from: L$1 */
        Object f6698L$1;

        /* renamed from: label */
        int f6699label;

        /* renamed from: result */
        /* synthetic */ Object f6700result;

        public C15071(Continuation<? super C15071> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6700result = obj;
            this.f6699label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7227last(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0}, m6126l = {163}, m6127m = "lastOrNull", m6128n = {"$this$lastOrNull", "result"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 */
    public static final class C15091<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6702L$0;

        /* renamed from: L$1 */
        Object f6703L$1;

        /* renamed from: label */
        int f6704label;

        /* renamed from: result */
        /* synthetic */ Object f6705result;

        public C15091(Continuation<? super C15091> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6705result = obj;
            this.f6704label |= Integer.MIN_VALUE;
            return C1427FlowKt.lastOrNull(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0}, m6126l = {18}, m6127m = "reduce", m6128n = {"$this$reduce", "operation", "accumulator"}, m6130s = {"L$0", "L$1", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 */
    public static final class C15111<S, T extends S> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6707L$0;

        /* renamed from: L$1 */
        Object f6708L$1;

        /* renamed from: L$2 */
        Object f6709L$2;

        /* renamed from: label */
        int f6710label;

        /* renamed from: result */
        /* synthetic */ Object f6711result;

        public C15111(Continuation<? super C15111> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6711result = obj;
            this.f6710label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7239reduce(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2 */
    public static final class C15122<T> implements FlowCollector {
        final /* synthetic */ C1235Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public C15122(C1235Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            C1235Ref.ObjectRef<Object> objectRef;
            C1235Ref.ObjectRef<Object> objectRef2;
            if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
                int i = flowKt__ReduceKt$reduce$2$emit$1.f6714label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.f6714label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
                }
            }
            Object obj = flowKt__ReduceKt$reduce$2$emit$1.f6715result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__ReduceKt$reduce$2$emit$1.f6714label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = this.$accumulator;
                Object obj2 = objectRef.f5202element;
                if (obj2 != NullSurrogateKt.f7173NULL) {
                    Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                    flowKt__ReduceKt$reduce$2$emit$1.f6712L$0 = SpillingKt.nullOutSpilledVariable(t);
                    flowKt__ReduceKt$reduce$2$emit$1.f6713L$1 = objectRef;
                    flowKt__ReduceKt$reduce$2$emit$1.f6714label = 1;
                    Object objMo6219invoke = function3.mo6219invoke(obj2, t, flowKt__ReduceKt$reduce$2$emit$1);
                    if (objMo6219invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t = objMo6219invoke;
                    objectRef2 = objectRef;
                }
                objectRef.f5202element = t;
                return C1133Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef2 = (C1235Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.f6713L$1;
            ResultKt.throwOnFailure(obj);
            t = obj;
            objectRef = objectRef2;
            objectRef.f5202element = t;
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0}, m6126l = {C5125EACTags.f18346SEX}, m6127m = "single", m6128n = {"$this$single", "result"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 */
    public static final class C15131<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6717L$0;

        /* renamed from: L$1 */
        Object f6718L$1;

        /* renamed from: label */
        int f6719label;

        /* renamed from: result */
        /* synthetic */ Object f6720result;

        public C15131(Continuation<? super C15131> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6720result = obj;
            this.f6719label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7246single(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "singleOrNull", m6128n = {"$this$singleOrNull", "result", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1 */
    public static final class C15151<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6722I$0;

        /* renamed from: L$0 */
        Object f6723L$0;

        /* renamed from: L$1 */
        Object f6724L$1;

        /* renamed from: L$2 */
        Object f6725L$2;

        /* renamed from: L$3 */
        Object f6726L$3;

        /* renamed from: label */
        int f6727label;

        /* renamed from: result */
        /* synthetic */ Object f6728result;

        public C15151(Continuation<? super C15151> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6728result = obj;
            this.f6727label |= Integer.MIN_VALUE;
            return C1427FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: first */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7321first(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15011 c15011;
        C1235Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        T t;
        if (continuation instanceof C15011) {
            c15011 = (C15011) continuation;
            int i = c15011.f6660label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15011.f6660label = i - Integer.MIN_VALUE;
            } else {
                c15011 = new C15011(continuation);
            }
        }
        Object obj = c15011.f6661result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15011.f6660label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = (T) NullSurrogateKt.f7173NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public Object mo4309emit(T t2, Continuation<? super C1133Unit> continuation2) {
                    objectRef2.f5202element = t2;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c15011.f6656L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15011.f6657L$1 = objectRef2;
                c15011.f6658L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15011.f6659L$3 = flowCollector2;
                c15011.f6655I$0 = 0;
                c15011.f6660label = 1;
                if (interfaceC1426Flow.mo4308collect(flowCollector2, c15011) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15011.get$context());
                t = objectRef.f5202element;
                if (t != NullSurrogateKt.f7173NULL) {
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) c15011.f6659L$3;
            objectRef = (C1235Ref.ObjectRef) c15011.f6657L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15011.get$context());
                t = objectRef.f5202element;
                if (t != NullSurrogateKt.f7173NULL) {
                }
            }
        }
        t = objectRef.f5202element;
        if (t != NullSurrogateKt.f7173NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15031 c15031;
        C1235Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (continuation instanceof C15031) {
            c15031 = (C15031) continuation;
            int i = c15031.f6675label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15031.f6675label = i - Integer.MIN_VALUE;
            } else {
                c15031 = new C15031(continuation);
            }
        }
        Object obj = c15031.f6676result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15031.f6675label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                    objectRef2.f5202element = t;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c15031.f6671L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15031.f6672L$1 = objectRef2;
                c15031.f6673L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15031.f6674L$3 = flowCollector2;
                c15031.f6670I$0 = 0;
                c15031.f6675label = 1;
                if (interfaceC1426Flow.mo4308collect(flowCollector2, c15031) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15031.get$context());
                return objectRef.f5202element;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c15031.f6674L$3;
            objectRef = (C1235Ref.ObjectRef) c15031.f6672L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15031.get$context());
                return objectRef.f5202element;
            }
        }
        return objectRef.f5202element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: fold */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, R> Object m7323fold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        C15051 c15051;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C15051) {
            c15051 = (C15051) continuation;
            int i = c15051.f6690label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15051.f6690label = i - Integer.MIN_VALUE;
            } else {
                c15051 = new C15051(continuation);
            }
        }
        Object obj = c15051.f6691result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15051.f6690label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = r;
            FlowCollector<? super Object> c15062 = new C15062<>(objectRef2, function3);
            c15051.f6686L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15051.f6687L$1 = SpillingKt.nullOutSpilledVariable(r);
            c15051.f6688L$2 = SpillingKt.nullOutSpilledVariable(function3);
            c15051.f6689L$3 = objectRef2;
            c15051.f6685I$0 = 0;
            c15051.f6690label = 1;
            if (interfaceC1426Flow.mo4308collect(c15062, c15051) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c15051.f6689L$3;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.f5202element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
        objectRef.f5202element = r;
        C15062 c15062 = new C15062(objectRef, function3);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c15062, continuation);
        InlineMarker.m6315mark(1);
        return objectRef.f5202element;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: last */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7324last(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15071 c15071;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C15071) {
            c15071 = (C15071) continuation;
            int i = c15071.f6699label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15071.f6699label = i - Integer.MIN_VALUE;
            } else {
                c15071 = new C15071(continuation);
            }
        }
        Object obj = c15071.f6700result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15071.f6699label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = (T) NullSurrogateKt.f7173NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                    objectRef2.f5202element = t;
                    return C1133Unit.INSTANCE;
                }
            };
            c15071.f6697L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15071.f6698L$1 = objectRef2;
            c15071.f6699label = 1;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c15071) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c15071.f6698L$1;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.f5202element;
        if (t != NullSurrogateKt.f7173NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object lastOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15091 c15091;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C15091) {
            c15091 = (C15091) continuation;
            int i = c15091.f6704label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15091.f6704label = i - Integer.MIN_VALUE;
            } else {
                c15091 = new C15091(continuation);
            }
        }
        Object obj = c15091.f6705result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15091.f6704label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                    objectRef2.f5202element = t;
                    return C1133Unit.INSTANCE;
                }
            };
            c15091.f6702L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15091.f6703L$1 = objectRef2;
            c15091.f6704label = 1;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c15091) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c15091.f6703L$1;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.f5202element;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    /* renamed from: reduce */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, T extends S> Object m7325reduce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        C15111 c15111;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C15111) {
            c15111 = (C15111) continuation;
            int i = c15111.f6710label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15111.f6710label = i - Integer.MIN_VALUE;
            } else {
                c15111 = new C15111(continuation);
            }
        }
        Object obj = c15111.f6711result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15111.f6710label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = NullSurrogateKt.f7173NULL;
            FlowCollector<? super Object> c15122 = new C15122<>(objectRef2, function3);
            c15111.f6707L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15111.f6708L$1 = SpillingKt.nullOutSpilledVariable(function3);
            c15111.f6709L$2 = objectRef2;
            c15111.f6710label = 1;
            if (interfaceC1426Flow.mo4308collect(c15122, c15111) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c15111.f6709L$2;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.f5202element;
        if (t != NullSurrogateKt.f7173NULL) {
            return t;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: single */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7326single(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15131 c15131;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C15131) {
            c15131 = (C15131) continuation;
            int i = c15131.f6719label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15131.f6719label = i - Integer.MIN_VALUE;
            } else {
                c15131 = new C15131(continuation);
            }
        }
        Object obj = c15131.f6720result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15131.f6719label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = (T) NullSurrogateKt.f7173NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                    C1235Ref.ObjectRef<Object> objectRef3 = objectRef2;
                    if (objectRef3.f5202element != NullSurrogateKt.f7173NULL) {
                        throw new IllegalArgumentException("Flow has more than one element");
                    }
                    objectRef3.f5202element = t;
                    return C1133Unit.INSTANCE;
                }
            };
            c15131.f6717L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c15131.f6718L$1 = objectRef2;
            c15131.f6719label = 1;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c15131) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c15131.f6718L$1;
            ResultKt.throwOnFailure(obj);
        }
        T t = objectRef.f5202element;
        if (t != NullSurrogateKt.f7173NULL) {
            return t;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object singleOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        C15151 c15151;
        C1235Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        T t;
        if (continuation instanceof C15151) {
            c15151 = (C15151) continuation;
            int i = c15151.f6727label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15151.f6727label = i - Integer.MIN_VALUE;
            } else {
                c15151 = new C15151(continuation);
            }
        }
        Object obj = c15151.f6728result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15151.f6727label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = (T) NullSurrogateKt.f7173NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public Object mo4309emit(T t2, Continuation<? super C1133Unit> continuation2) {
                    C1235Ref.ObjectRef objectRef3 = objectRef2;
                    T t3 = objectRef3.f5202element;
                    T t4 = (T) NullSurrogateKt.f7173NULL;
                    if (t3 == t4) {
                        objectRef3.f5202element = t2;
                        return C1133Unit.INSTANCE;
                    }
                    objectRef3.f5202element = t4;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c15151.f6723L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15151.f6724L$1 = objectRef2;
                c15151.f6725L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15151.f6726L$3 = flowCollector2;
                c15151.f6722I$0 = 0;
                c15151.f6727label = 1;
                if (interfaceC1426Flow.mo4308collect(flowCollector2, c15151) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15151.get$context());
                t = objectRef.f5202element;
                if (t == NullSurrogateKt.f7173NULL) {
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c15151.f6726L$3;
            objectRef = (C1235Ref.ObjectRef) c15151.f6724L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15151.get$context());
                t = objectRef.f5202element;
                if (t == NullSurrogateKt.f7173NULL) {
                }
            }
        }
        t = objectRef.f5202element;
        if (t == NullSurrogateKt.f7173NULL) {
            return null;
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: first */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7322first(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        C15023 c15023;
        C1235Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        T t;
        if (continuation instanceof C15023) {
            c15023 = (C15023) continuation;
            int i = c15023.f6668label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15023.f6668label = i - Integer.MIN_VALUE;
            } else {
                c15023 = new C15023(continuation);
            }
        }
        Object obj = c15023.f6669result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15023.f6668label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            objectRef2.f5202element = (T) NullSurrogateKt.f7173NULL;
            FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function2, objectRef2);
            try {
                c15023.f6663L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15023.f6664L$1 = SpillingKt.nullOutSpilledVariable(function2);
                c15023.f6665L$2 = objectRef2;
                c15023.f6666L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15023.f6667L$4 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                c15023.f6662I$0 = 0;
                c15023.f6668label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, c15023) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15023.get$context());
                t = objectRef.f5202element;
                if (t != NullSurrogateKt.f7173NULL) {
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) c15023.f6667L$4;
            objectRef = (C1235Ref.ObjectRef) c15023.f6665L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15023.get$context());
                t = objectRef.f5202element;
                if (t != NullSurrogateKt.f7173NULL) {
                }
            }
        }
        t = objectRef.f5202element;
        if (t != NullSurrogateKt.f7173NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        C15043 c15043;
        C1235Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof C15043) {
            c15043 = (C15043) continuation;
            int i = c15043.f6683label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15043.f6683label = i - Integer.MIN_VALUE;
            } else {
                c15043 = new C15043(continuation);
            }
        }
        Object obj = c15043.f6684result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15043.f6683label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            FlowCollector<? super Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, objectRef2);
            try {
                c15043.f6678L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15043.f6679L$1 = SpillingKt.nullOutSpilledVariable(function2);
                c15043.f6680L$2 = objectRef2;
                c15043.f6681L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c15043.f6682L$4 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                c15043.f6677I$0 = 0;
                c15043.f6683label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2, c15043) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (AbortFlowException e2) {
                objectRef = objectRef2;
                e = e2;
                flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15043.get$context());
                return objectRef.f5202element;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c15043.f6682L$4;
            objectRef = (C1235Ref.ObjectRef) c15043.f6680L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c15043.get$context());
                return objectRef.f5202element;
            }
        }
        return objectRef.f5202element;
    }
}
