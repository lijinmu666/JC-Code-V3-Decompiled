package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", m6124f = "Migration.kt", m6125i = {0, 0, 1, 1}, m6126l = {189, 189}, m6127m = "invokeSuspend", m6128n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,214:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ Function2 $transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6632L$0;

    /* renamed from: L$1 */
    /* synthetic */ Object f6633L$1;

    /* renamed from: L$2 */
    Object f6634L$2;

    /* renamed from: label */
    int f6635label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo6219invoke(Object obj, Object obj2, Continuation<? super C1133Unit> continuation) {
        return m7318invoke((FlowCollector) obj, (FlowCollector<? super R>) obj2, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2 = (FlowCollector) this.f6632L$0;
        Object obj2 = this.f6633L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6635label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2 function2 = this.$transform;
            this.f6632L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            this.f6633L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.f6634L$2 = flowCollector2;
            this.f6635label = 1;
            obj = function2.mo2167invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return C1133Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.f6634L$2;
            ResultKt.throwOnFailure(obj);
        }
        this.f6632L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        this.f6633L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.f6634L$2 = null;
        this.f6635label = 2;
        if (C1427FlowKt.m7213emitAll(flowCollector, (InterfaceC1426Flow) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final Object m7318invoke(FlowCollector<? super R> flowCollector, T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, continuation);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.f6632L$0 = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.f6633L$1 = t;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.invokeSuspend(C1133Unit.INSTANCE);
    }
}
