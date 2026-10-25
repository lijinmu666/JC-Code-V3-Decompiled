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
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,111:1\n79#2,2:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function1 $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1}, m6126l = {112, 112}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u241", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2", "collector", "$completion", "$this$asFlow_u24lambda_u241", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$2"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1 */
    public static final class C14291 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6087I$0;

        /* renamed from: L$0 */
        Object f6088L$0;

        /* renamed from: L$1 */
        Object f6089L$1;

        /* renamed from: L$2 */
        Object f6090L$2;

        /* renamed from: L$3 */
        Object f6091L$3;

        /* renamed from: label */
        int f6092label;

        /* renamed from: result */
        /* synthetic */ Object f6093result;

        public C14291(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6093result = obj;
            this.f6092label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(Function1 function1) {
        this.$this_asFlow$inlined = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14291 c14291;
        FlowCollector<? super T> flowCollector2;
        FlowCollector<? super T> flowCollector3;
        Continuation continuation2;
        int i;
        if (continuation instanceof C14291) {
            c14291 = (C14291) continuation;
            int i2 = c14291.f6092label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14291.f6092label = i2 - Integer.MIN_VALUE;
            } else {
                c14291 = new C14291(continuation);
            }
        }
        Object obj = c14291.f6093result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c14291.f6092label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1 function1 = this.$this_asFlow$inlined;
            c14291.f6088L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14291.f6089L$1 = SpillingKt.nullOutSpilledVariable(c14291);
            c14291.f6090L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14291.f6091L$3 = flowCollector;
            c14291.f6087I$0 = 0;
            c14291.f6092label = 1;
            InlineMarker.m6315mark(6);
            Object objMo2237invoke = function1.mo2237invoke(c14291);
            InlineMarker.m6315mark(7);
            if (objMo2237invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            flowCollector3 = flowCollector2;
            continuation2 = c14291;
            obj = objMo2237invoke;
            i = 0;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return C1133Unit.INSTANCE;
            }
            i = c14291.f6087I$0;
            flowCollector = (FlowCollector) c14291.f6091L$3;
            flowCollector2 = (FlowCollector) c14291.f6090L$2;
            continuation2 = (Continuation) c14291.f6089L$1;
            flowCollector3 = (FlowCollector) c14291.f6088L$0;
            ResultKt.throwOnFailure(obj);
        }
        c14291.f6088L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
        c14291.f6089L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
        c14291.f6090L$2 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        c14291.f6091L$3 = null;
        c14291.f6087I$0 = i;
        c14291.f6092label = 2;
        if (flowCollector.mo4309emit(obj, c14291) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }
}
