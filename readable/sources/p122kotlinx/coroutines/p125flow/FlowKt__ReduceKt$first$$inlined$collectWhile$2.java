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
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt\n*L\n1#1,141:1\n103#2,6:142\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ReduceKt$first$$inlined$collectWhile$2<T> implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ C1235Ref.ObjectRef $result$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", m6124f = "Reduce.kt", m6125i = {0, 0, 0, 0}, m6126l = {142}, m6127m = "emit", m6128n = {"value", "$completion", "it", "$i$a$-collectWhile-FlowKt__ReduceKt$first$4"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 */
    public static final class C14991 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6641I$0;

        /* renamed from: L$0 */
        Object f6642L$0;

        /* renamed from: L$1 */
        Object f6643L$1;

        /* renamed from: L$2 */
        Object f6644L$2;

        /* renamed from: label */
        int f6645label;

        /* renamed from: result */
        /* synthetic */ Object f6646result;

        public C14991(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6646result = obj;
            this.f6645label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt$first$$inlined$collectWhile$2.this.mo4309emit(null, this);
        }
    }

    public FlowKt__ReduceKt$first$$inlined$collectWhile$2(Function2 function2, C1235Ref.ObjectRef objectRef) {
        this.$predicate$inlined = function2;
        this.$result$inlined = objectRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        C14991 c14991;
        if (continuation instanceof C14991) {
            c14991 = (C14991) continuation;
            int i = c14991.f6645label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14991.f6645label = i - Integer.MIN_VALUE;
            } else {
                c14991 = new C14991(continuation);
            }
        }
        Object objMo2167invoke = c14991.f6646result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14991.f6645label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo2167invoke);
            Function2 function2 = this.$predicate$inlined;
            c14991.f6642L$0 = SpillingKt.nullOutSpilledVariable(t);
            c14991.f6643L$1 = SpillingKt.nullOutSpilledVariable(c14991);
            c14991.f6644L$2 = t;
            c14991.f6641I$0 = 0;
            c14991.f6645label = 1;
            InlineMarker.m6315mark(6);
            objMo2167invoke = function2.mo2167invoke(t, c14991);
            InlineMarker.m6315mark(7);
            if (objMo2167invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            t = (T) c14991.f6644L$2;
            ResultKt.throwOnFailure(objMo2167invoke);
        }
        if (!((Boolean) objMo2167invoke).booleanValue()) {
            return C1133Unit.INSTANCE;
        }
        this.$result$inlined.f5202element = t;
        throw new AbortFlowException(this);
    }
}
