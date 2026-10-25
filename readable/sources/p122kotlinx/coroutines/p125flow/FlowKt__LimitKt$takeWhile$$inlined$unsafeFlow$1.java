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
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;
import p122kotlinx.coroutines.p125flow.internal.FlowExceptions_commonKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,111:1\n83#2:112\n124#2,17:113\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n83#1:113,17\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_takeWhile$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {123}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$takeWhile_u24lambda_u240", "$this$collectWhile$iv", "$completion$iv", "collector$iv", "$i$a$-unsafeFlow-FlowKt__LimitKt$takeWhile$1", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 */
    public static final class C14821 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6509I$0;

        /* renamed from: I$1 */
        int f6510I$1;

        /* renamed from: L$0 */
        Object f6511L$0;

        /* renamed from: L$1 */
        Object f6512L$1;

        /* renamed from: L$2 */
        Object f6513L$2;

        /* renamed from: L$3 */
        Object f6514L$3;

        /* renamed from: L$4 */
        Object f6515L$4;

        /* renamed from: L$5 */
        Object f6516L$5;

        /* renamed from: label */
        int f6517label;

        /* renamed from: result */
        /* synthetic */ Object f6518result;

        public C14821(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6518result = obj;
            this.f6517label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, Function2 function2) {
        this.$this_takeWhile$inlined = interfaceC1426Flow;
        this.$predicate$inlined = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14821 c14821;
        FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1;
        if (continuation instanceof C14821) {
            c14821 = (C14821) continuation;
            int i = c14821.f6517label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14821.f6517label = i - Integer.MIN_VALUE;
            } else {
                c14821 = new C14821(continuation);
            }
        }
        Object obj = c14821.f6518result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14821.f6517label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow interfaceC1426Flow = this.$this_takeWhile$inlined;
            FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1 flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$12 = new FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1(this.$predicate$inlined, flowCollector);
            try {
                c14821.f6511L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14821.f6512L$1 = SpillingKt.nullOutSpilledVariable(c14821);
                c14821.f6513L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14821.f6514L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14821.f6515L$4 = SpillingKt.nullOutSpilledVariable(c14821);
                c14821.f6516L$5 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$12;
                c14821.f6509I$0 = 0;
                c14821.f6510I$1 = 0;
                c14821.f6517label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$12, c14821) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e) {
                e = e;
                flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1 = flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$12;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1);
                C1344JobKt.ensureActive(c14821.getContext());
                return C1133Unit.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1 = (FlowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1) c14821.f6516L$5;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e2) {
                e = e2;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__LimitKt$takeWhile$lambda$0$$inlined$collectWhile$1);
                C1344JobKt.ensureActive(c14821.getContext());
                return C1133Unit.INSTANCE;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
