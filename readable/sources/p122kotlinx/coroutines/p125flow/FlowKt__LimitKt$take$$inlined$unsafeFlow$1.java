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
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;
import p122kotlinx.coroutines.p125flow.internal.FlowExceptions_commonKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,111:1\n50#2,4:112\n64#2,4:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ int $count$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_take$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {115}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$take_u24lambda_u241", "ownershipMarker", "consumed", "$i$a$-unsafeFlow-FlowKt__LimitKt$take$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 */
    public static final class C14811 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6500I$0;

        /* renamed from: L$0 */
        Object f6501L$0;

        /* renamed from: L$1 */
        Object f6502L$1;

        /* renamed from: L$2 */
        Object f6503L$2;

        /* renamed from: L$3 */
        Object f6504L$3;

        /* renamed from: L$4 */
        Object f6505L$4;

        /* renamed from: label */
        int f6506label;

        /* renamed from: result */
        /* synthetic */ Object f6507result;

        public C14811(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6507result = obj;
            this.f6506label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, int i) {
        this.$this_take$inlined = interfaceC1426Flow;
        this.$count$inlined = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14811 c14811;
        Object obj;
        if (continuation instanceof C14811) {
            c14811 = (C14811) continuation;
            int i = c14811.f6506label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14811.f6506label = i - Integer.MIN_VALUE;
            } else {
                c14811 = new C14811(continuation);
            }
        }
        Object obj2 = c14811.f6507result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14811.f6506label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Object obj3 = new Object();
            C1235Ref.IntRef intRef = new C1235Ref.IntRef();
            try {
                InterfaceC1426Flow interfaceC1426Flow = this.$this_take$inlined;
                FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1 = new FlowKt__LimitKt$take$2$1(intRef, this.$count$inlined, flowCollector, obj3);
                c14811.f6501L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14811.f6502L$1 = SpillingKt.nullOutSpilledVariable(c14811);
                c14811.f6503L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14811.f6504L$3 = obj3;
                c14811.f6505L$4 = SpillingKt.nullOutSpilledVariable(intRef);
                c14811.f6500I$0 = 0;
                c14811.f6506label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__LimitKt$take$2$1, c14811) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (AbortFlowException e) {
                e = e;
                obj = obj3;
                FlowExceptions_commonKt.checkOwnership(e, obj);
                return C1133Unit.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = c14811.f6504L$3;
            try {
                ResultKt.throwOnFailure(obj2);
            } catch (AbortFlowException e2) {
                e = e2;
                FlowExceptions_commonKt.checkOwnership(e, obj);
                return C1133Unit.INSTANCE;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
