package p122kotlinx.coroutines.p125flow;

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
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n84#2,6:142\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ FlowCollector $this_flow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1}, m6126l = {142, 143}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1", "value", "$completion", "value", "$i$a$-collectWhile-FlowKt__LimitKt$takeWhile$1$1"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1$1 */
    public static final class C14831 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6520I$0;

        /* renamed from: L$0 */
        Object f6521L$0;

        /* renamed from: L$1 */
        Object f6522L$1;

        /* renamed from: L$2 */
        Object f6523L$2;

        /* renamed from: label */
        int f6524label;

        /* renamed from: result */
        /* synthetic */ Object f6525result;

        public C14831(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6525result = obj;
            this.f6524label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1.this.mo4309emit(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1(Function2 function2, FlowCollector flowCollector) {
        this.$predicate$inlined = function2;
        this.$this_flow$inlined = flowCollector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        C14831 c14831;
        int i;
        Object obj;
        Continuation continuation2;
        if (continuation instanceof C14831) {
            c14831 = (C14831) continuation;
            int i2 = c14831.f6524label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14831.f6524label = i2 - Integer.MIN_VALUE;
            } else {
                c14831 = new C14831(continuation);
            }
        }
        Object objMo2167invoke = c14831.f6525result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c14831.f6524label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objMo2167invoke);
            Function2 function2 = this.$predicate$inlined;
            c14831.f6521L$0 = SpillingKt.nullOutSpilledVariable(t);
            c14831.f6522L$1 = SpillingKt.nullOutSpilledVariable(c14831);
            c14831.f6523L$2 = t;
            i = 0;
            c14831.f6520I$0 = 0;
            c14831.f6524label = 1;
            InlineMarker.m6315mark(6);
            objMo2167invoke = function2.mo2167invoke(t, c14831);
            InlineMarker.m6315mark(7);
            if (objMo2167invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = t;
            continuation2 = c14831;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objMo2167invoke);
                return C1133Unit.INSTANCE;
            }
            int i4 = c14831.f6520I$0;
            Object obj2 = c14831.f6523L$2;
            continuation2 = (Continuation) c14831.f6522L$1;
            obj = c14831.f6521L$0;
            ResultKt.throwOnFailure(objMo2167invoke);
            i = i4;
            t = obj2;
        }
        if (!((Boolean) objMo2167invoke).booleanValue()) {
            throw new AbortFlowException(this);
        }
        FlowCollector flowCollector = this.$this_flow$inlined;
        c14831.f6521L$0 = SpillingKt.nullOutSpilledVariable(obj);
        c14831.f6522L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
        c14831.f6523L$2 = SpillingKt.nullOutSpilledVariable(t);
        c14831.f6520I$0 = i;
        c14831.f6524label = 2;
        if (flowCollector.mo4309emit(t, c14831) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }
}
