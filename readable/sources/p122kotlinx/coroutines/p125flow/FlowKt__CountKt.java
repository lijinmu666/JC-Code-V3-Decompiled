package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;

@Metadata(m4987d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m4988d2 = {"count", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__CountKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CountKt", m6124f = "Count.kt", m6125i = {0, 0}, m6126l = {13}, m6127m = "count", m6128n = {"$this$count", "i"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$1 */
    public static final class C14621<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6346L$0;

        /* renamed from: L$1 */
        Object f6347L$1;

        /* renamed from: label */
        int f6348label;

        /* renamed from: result */
        /* synthetic */ Object f6349result;

        public C14621(Continuation<? super C14621> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6349result = obj;
            this.f6348label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7209count(null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CountKt", m6124f = "Count.kt", m6125i = {0, 0, 0}, m6126l = {25}, m6127m = "count", m6128n = {"$this$count", "predicate", "i"}, m6130s = {"L$0", "L$1", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$3 */
    public static final class C14643<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6351L$0;

        /* renamed from: L$1 */
        Object f6352L$1;

        /* renamed from: L$2 */
        Object f6353L$2;

        /* renamed from: label */
        int f6354label;

        /* renamed from: result */
        /* synthetic */ Object f6355result;

        public C14643(Continuation<? super C14643> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6355result = obj;
            this.f6354label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7210count(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$4 */
    public static final class C14654<T> implements FlowCollector {

        /* renamed from: $i */
        final /* synthetic */ C1235Ref.IntRef f6356$i;
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

        /* JADX WARN: Multi-variable type inference failed */
        public C14654(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, C1235Ref.IntRef intRef) {
            this.$predicate = function2;
            this.f6356$i = intRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
            if (continuation instanceof FlowKt__CountKt$count$4$emit$1) {
                flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) continuation;
                int i = flowKt__CountKt$count$4$emit$1.f6358label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CountKt$count$4$emit$1.f6358label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, continuation);
                }
            }
            Object objMo2167invoke = flowKt__CountKt$count$4$emit$1.f6359result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CountKt$count$4$emit$1.f6358label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMo2167invoke);
                Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                flowKt__CountKt$count$4$emit$1.f6357L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__CountKt$count$4$emit$1.f6358label = 1;
                objMo2167invoke = function2.mo2167invoke(t, flowKt__CountKt$count$4$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo2167invoke);
            }
            if (((Boolean) objMo2167invoke).booleanValue()) {
                this.f6356$i.f5200element++;
            }
            return C1133Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: count */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7278count(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super Integer> continuation) {
        C14621 c14621;
        C1235Ref.IntRef intRef;
        if (continuation instanceof C14621) {
            c14621 = (C14621) continuation;
            int i = c14621.f6348label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14621.f6348label = i - Integer.MIN_VALUE;
            } else {
                c14621 = new C14621(continuation);
            }
        }
        Object obj = c14621.f6349result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14621.f6348label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final C1235Ref.IntRef intRef2 = new C1235Ref.IntRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt.count.2
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                    intRef2.f5200element++;
                    return C1133Unit.INSTANCE;
                }
            };
            c14621.f6346L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c14621.f6347L$1 = intRef2;
            c14621.f6348label = 1;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c14621) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (C1235Ref.IntRef) c14621.f6347L$1;
            ResultKt.throwOnFailure(obj);
        }
        return C1207Boxing.m6121boxInt(intRef.f5200element);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: count */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7279count(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        C14643 c14643;
        C1235Ref.IntRef intRef;
        if (continuation instanceof C14643) {
            c14643 = (C14643) continuation;
            int i = c14643.f6354label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14643.f6354label = i - Integer.MIN_VALUE;
            } else {
                c14643 = new C14643(continuation);
            }
        }
        Object obj = c14643.f6355result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14643.f6354label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.IntRef intRef2 = new C1235Ref.IntRef();
            FlowCollector<? super Object> c14654 = new C14654<>(function2, intRef2);
            c14643.f6351L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c14643.f6352L$1 = SpillingKt.nullOutSpilledVariable(function2);
            c14643.f6353L$2 = intRef2;
            c14643.f6354label = 1;
            if (interfaceC1426Flow.mo4308collect(c14654, c14643) == coroutine_suspended) {
                return coroutine_suspended;
            }
            intRef = intRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (C1235Ref.IntRef) c14643.f6353L$2;
            ResultKt.throwOnFailure(obj);
        }
        return C1207Boxing.m6121boxInt(intRef.f5200element);
    }
}
