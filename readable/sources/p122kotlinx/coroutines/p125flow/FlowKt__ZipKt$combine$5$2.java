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
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [R, T] */
@Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", m6124f = "Zip.kt", m6125i = {0, 0, 1, 1}, m6126l = {234, 234}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$this$combineInternal", "it"}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combine$5$2<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6964L$0;

    /* renamed from: L$1 */
    /* synthetic */ Object f6965L$1;

    /* renamed from: L$2 */
    Object f6966L$2;

    /* renamed from: label */
    int f6967label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$2(Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$5$2> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowCollector flowCollector2 = (FlowCollector) this.f6964L$0;
        Object[] objArr = (Object[]) this.f6965L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6967label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<T[], Continuation<? super R>, Object> function2 = this.$transform;
            this.f6964L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            this.f6965L$1 = SpillingKt.nullOutSpilledVariable(objArr);
            this.f6966L$2 = flowCollector2;
            this.f6967label = 1;
            obj = function2.mo2167invoke(objArr, this);
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
            FlowCollector flowCollector3 = (FlowCollector) this.f6966L$2;
            ResultKt.throwOnFailure(obj);
            flowCollector = flowCollector3;
        }
        this.f6964L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
        this.f6965L$1 = SpillingKt.nullOutSpilledVariable(objArr);
        this.f6966L$2 = null;
        this.f6967label = 2;
        if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return C1133Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend$$forInline(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f6964L$0;
        InlineMarker.m6315mark(10);
        Object[] objArr = (Object[]) this.f6965L$1;
        InlineMarker.m6315mark(10);
        Object objMo2167invoke = this.$transform.mo2167invoke(objArr, this);
        InlineMarker.m6315mark(0);
        flowCollector.mo4309emit(objMo2167invoke, this);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo6219invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super C1133Unit> continuation) {
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.$transform, continuation);
        flowKt__ZipKt$combine$5$2.f6964L$0 = flowCollector;
        flowKt__ZipKt$combine$5$2.f6965L$1 = tArr;
        return flowKt__ZipKt$combine$5$2.invokeSuspend(C1133Unit.INSTANCE);
    }
}
