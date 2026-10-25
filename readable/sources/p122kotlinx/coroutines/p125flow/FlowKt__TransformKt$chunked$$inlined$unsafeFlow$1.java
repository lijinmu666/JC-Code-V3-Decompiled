package p122kotlinx.coroutines.p125flow;

import java.util.ArrayList;
import java.util.List;
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

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n153#2,12:112\n165#2:125\n1#3:124\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<List<? extends T>> {
    final /* synthetic */ int $size$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_chunked$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m6126l = {113, 123}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$chunked_u24lambda_u241", "result", "$i$a$-unsafeFlow-FlowKt__TransformKt$chunked$2", "collector", "$completion", "$this$chunked_u24lambda_u241", "result", "it", "$i$a$-unsafeFlow-FlowKt__TransformKt$chunked$2", "$i$a$-let-FlowKt__TransformKt$chunked$2$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1$1 */
    public static final class C15211 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6758I$0;

        /* renamed from: I$1 */
        int f6759I$1;

        /* renamed from: L$0 */
        Object f6760L$0;

        /* renamed from: L$1 */
        Object f6761L$1;

        /* renamed from: L$2 */
        Object f6762L$2;

        /* renamed from: L$3 */
        Object f6763L$3;

        /* renamed from: L$4 */
        Object f6764L$4;

        /* renamed from: label */
        int f6765label;

        /* renamed from: result */
        /* synthetic */ Object f6766result;

        public C15211(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6766result = obj;
            this.f6765label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, int i) {
        this.$this_chunked$inlined = interfaceC1426Flow;
        this.$size$inlined = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super List<? extends T>> flowCollector, Continuation<? super C1133Unit> continuation) {
        C15211 c15211;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        C1235Ref.ObjectRef objectRef;
        Continuation continuation2;
        int i;
        if (continuation instanceof C15211) {
            c15211 = (C15211) continuation;
            int i2 = c15211.f6765label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c15211.f6765label = i2 - Integer.MIN_VALUE;
            } else {
                c15211 = new C15211(continuation);
            }
        }
        Object obj = c15211.f6766result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c15211.f6765label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            InterfaceC1426Flow interfaceC1426Flow = this.$this_chunked$inlined;
            FlowKt__TransformKt$chunked$2$1 flowKt__TransformKt$chunked$2$1 = new FlowKt__TransformKt$chunked$2$1(objectRef2, this.$size$inlined, flowCollector);
            c15211.f6760L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c15211.f6761L$1 = SpillingKt.nullOutSpilledVariable(c15211);
            c15211.f6762L$2 = flowCollector;
            c15211.f6763L$3 = objectRef2;
            c15211.f6758I$0 = 0;
            c15211.f6765label = 1;
            if (interfaceC1426Flow.mo4308collect(flowKt__TransformKt$chunked$2$1, c15211) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            flowCollector3 = flowCollector2;
            objectRef = objectRef2;
            continuation2 = c15211;
            i = 0;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return C1133Unit.INSTANCE;
            }
            i = c15211.f6758I$0;
            objectRef = (C1235Ref.ObjectRef) c15211.f6763L$3;
            flowCollector2 = (FlowCollector) c15211.f6762L$2;
            continuation2 = (Continuation) c15211.f6761L$1;
            flowCollector3 = (FlowCollector) c15211.f6760L$0;
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList = (ArrayList) objectRef.f5202element;
        if (arrayList != null) {
            c15211.f6760L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            c15211.f6761L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            c15211.f6762L$2 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            c15211.f6763L$3 = SpillingKt.nullOutSpilledVariable(objectRef);
            c15211.f6764L$4 = SpillingKt.nullOutSpilledVariable(arrayList);
            c15211.f6758I$0 = i;
            c15211.f6759I$1 = 0;
            c15211.f6765label = 2;
            if (flowCollector2.mo4309emit(arrayList, c15211) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
