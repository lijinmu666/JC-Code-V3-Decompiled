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
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,111:1\n176#2,7:112\n183#2,7:120\n1307#3:119\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n182#1:119\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_onEmpty$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", m6124f = "Emitters.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m6126l = {113, 121}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$onEmpty_u24lambda_u240", "isEmpty", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1", "collector", "$completion", "$this$onEmpty_u24lambda_u240", "isEmpty", "collector", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onEmpty$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 */
    public static final class C14711 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6430I$0;

        /* renamed from: L$0 */
        Object f6431L$0;

        /* renamed from: L$1 */
        Object f6432L$1;

        /* renamed from: L$2 */
        Object f6433L$2;

        /* renamed from: L$3 */
        Object f6434L$3;

        /* renamed from: L$4 */
        Object f6435L$4;

        /* renamed from: label */
        int f6436label;

        /* renamed from: result */
        /* synthetic */ Object f6437result;

        public C14711(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6437result = obj;
            this.f6436label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, Function2 function2) {
        this.$this_onEmpty$inlined = interfaceC1426Flow;
        this.$action$inlined = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) throws Throwable {
        C14711 c14711;
        C1235Ref.BooleanRef booleanRef;
        Continuation continuation2;
        int i;
        FlowCollector<? super T> flowCollector2;
        SafeCollector safeCollector;
        if (continuation instanceof C14711) {
            c14711 = (C14711) continuation;
            int i2 = c14711.f6436label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14711.f6436label = i2 - Integer.MIN_VALUE;
            } else {
                c14711 = new C14711(continuation);
            }
        }
        Object obj = c14711.f6437result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c14711.f6436label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            booleanRef = new C1235Ref.BooleanRef();
            booleanRef.f5195element = true;
            InterfaceC1426Flow interfaceC1426Flow = this.$this_onEmpty$inlined;
            FlowKt__EmittersKt$onEmpty$1$1 flowKt__EmittersKt$onEmpty$1$1 = new FlowKt__EmittersKt$onEmpty$1$1(booleanRef, flowCollector);
            c14711.f6431L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14711.f6432L$1 = SpillingKt.nullOutSpilledVariable(c14711);
            c14711.f6433L$2 = flowCollector;
            c14711.f6434L$3 = booleanRef;
            c14711.f6430I$0 = 0;
            c14711.f6436label = 1;
            if (interfaceC1426Flow.mo4308collect(flowKt__EmittersKt$onEmpty$1$1, c14711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            continuation2 = c14711;
            i = 0;
            flowCollector2 = flowCollector;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                safeCollector = (SafeCollector) c14711.f6435L$4;
                try {
                    ResultKt.throwOnFailure(obj);
                    safeCollector.releaseIntercepted();
                    return C1133Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    safeCollector.releaseIntercepted();
                    throw th;
                }
            }
            int i4 = c14711.f6430I$0;
            booleanRef = (C1235Ref.BooleanRef) c14711.f6434L$3;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) c14711.f6433L$2;
            continuation2 = (Continuation) c14711.f6432L$1;
            flowCollector2 = (FlowCollector) c14711.f6431L$0;
            ResultKt.throwOnFailure(obj);
            i = i4;
            flowCollector = flowCollector3;
        }
        if (booleanRef.f5195element) {
            SafeCollector safeCollector2 = new SafeCollector(flowCollector, c14711.getContext());
            try {
                Function2 function2 = this.$action$inlined;
                c14711.f6431L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                c14711.f6432L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                c14711.f6433L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14711.f6434L$3 = SpillingKt.nullOutSpilledVariable(booleanRef);
                c14711.f6435L$4 = safeCollector2;
                c14711.f6430I$0 = i;
                c14711.f6436label = 2;
                InlineMarker.m6315mark(6);
                Object objMo2167invoke = function2.mo2167invoke(safeCollector2, c14711);
                InlineMarker.m6315mark(7);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                safeCollector = safeCollector2;
                safeCollector.releaseIntercepted();
            } catch (Throwable th2) {
                th = th2;
                safeCollector = safeCollector2;
                safeCollector.releaseIntercepted();
                throw th;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
