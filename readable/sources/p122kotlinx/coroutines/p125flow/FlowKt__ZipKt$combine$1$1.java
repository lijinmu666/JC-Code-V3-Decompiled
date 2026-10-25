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
import p094kotlin.p105jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", m6124f = "Zip.kt", m6125i = {0, 0, 1, 1}, m6126l = {29, 29}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$this$combineInternal", "it"}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6959L$0;

    /* renamed from: L$1 */
    /* synthetic */ Object f6960L$1;

    /* renamed from: L$2 */
    Object f6961L$2;

    /* renamed from: label */
    int f6962label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combine$1$1> continuation) {
        super(3, continuation);
        this.$transform = function3;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2 = (FlowCollector) this.f6959L$0;
        Object[] objArr = (Object[]) this.f6960L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6962label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<T1, T2, Continuation<? super R>, Object> function3 = this.$transform;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            this.f6959L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            this.f6960L$1 = SpillingKt.nullOutSpilledVariable(objArr);
            this.f6961L$2 = flowCollector2;
            this.f6962label = 1;
            obj = function3.mo6219invoke(obj2, obj3, this);
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
            flowCollector = (FlowCollector) this.f6961L$2;
            ResultKt.throwOnFailure(obj);
        }
        this.f6959L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        this.f6960L$1 = SpillingKt.nullOutSpilledVariable(objArr);
        this.f6961L$2 = null;
        this.f6962label = 2;
        if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo6219invoke(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super C1133Unit> continuation) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.$transform, continuation);
        flowKt__ZipKt$combine$1$1.f6959L$0 = flowCollector;
        flowKt__ZipKt$combine$1$1.f6960L$1 = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(C1133Unit.INSTANCE);
    }
}
