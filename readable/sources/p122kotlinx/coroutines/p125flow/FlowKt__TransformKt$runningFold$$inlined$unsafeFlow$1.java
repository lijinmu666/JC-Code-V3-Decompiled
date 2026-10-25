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
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,111:1\n102#2,7:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements InterfaceC1426Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_runningFold$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {113, 114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$runningFold_u24lambda_u240", "accumulator", "$i$a$-unsafeFlow-FlowKt__TransformKt$runningFold$1", "collector", "$completion", "$this$runningFold_u24lambda_u240", "accumulator", "$i$a$-unsafeFlow-FlowKt__TransformKt$runningFold$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 */
    public static final class C15351 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6849I$0;

        /* renamed from: L$0 */
        Object f6850L$0;

        /* renamed from: L$1 */
        Object f6851L$1;

        /* renamed from: L$2 */
        Object f6852L$2;

        /* renamed from: L$3 */
        Object f6853L$3;

        /* renamed from: label */
        int f6854label;

        /* renamed from: result */
        /* synthetic */ Object f6855result;

        public C15351(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6855result = obj;
            this.f6854label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, InterfaceC1426Flow interfaceC1426Flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = interfaceC1426Flow;
        this.$operation$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Object] */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
        C15351 c15351;
        C1235Ref.ObjectRef objectRef;
        int i;
        FlowCollector flowCollector2;
        Object obj;
        if (continuation instanceof C15351) {
            c15351 = (C15351) continuation;
            int i2 = c15351.f6854label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c15351.f6854label = i2 - Integer.MIN_VALUE;
            } else {
                c15351 = new C15351(continuation);
            }
        }
        Object obj2 = c15351.f6855result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c15351.f6854label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj2);
            objectRef = new C1235Ref.ObjectRef();
            ?? r10 = (Object) this.$initial$inlined;
            objectRef.f5202element = r10;
            c15351.f6850L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c15351.f6851L$1 = SpillingKt.nullOutSpilledVariable(c15351);
            c15351.f6852L$2 = flowCollector;
            c15351.f6853L$3 = objectRef;
            i = 0;
            c15351.f6849I$0 = 0;
            c15351.f6854label = 1;
            if (flowCollector.mo4309emit(r10, c15351) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            obj = c15351;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
                return C1133Unit.INSTANCE;
            }
            int i4 = c15351.f6849I$0;
            objectRef = (C1235Ref.ObjectRef) c15351.f6853L$3;
            FlowCollector<? super R> flowCollector3 = (FlowCollector) c15351.f6852L$2;
            Object obj3 = (Continuation) c15351.f6851L$1;
            flowCollector2 = (FlowCollector) c15351.f6850L$0;
            ResultKt.throwOnFailure(obj2);
            obj = obj3;
            i = i4;
            flowCollector = flowCollector3;
        }
        InterfaceC1426Flow interfaceC1426Flow = this.$this_runningFold$inlined;
        FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1 = new FlowKt__TransformKt$runningFold$1$1(objectRef, this.$operation$inlined, flowCollector);
        c15351.f6850L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        c15351.f6851L$1 = SpillingKt.nullOutSpilledVariable(obj);
        c15351.f6852L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
        c15351.f6853L$3 = SpillingKt.nullOutSpilledVariable(objectRef);
        c15351.f6849I$0 = i;
        c15351.f6854label = 2;
        if (interfaceC1426Flow.mo4308collect(flowKt__TransformKt$runningFold$1$1, c15351) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }
}
