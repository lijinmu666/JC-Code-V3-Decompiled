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
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", m6124f = "Delay.kt", m6125i = {0}, m6126l = {293}, m6127m = "invokeSuspend", m6128n = {"value"}, m6130s = {"L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,407:1\n14#2:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n*L\n293#1:408\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements Function2<C1133Unit, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ C1235Ref.ObjectRef<Object> $lastValue;

    /* renamed from: L$0 */
    Object f6398L$0;

    /* renamed from: label */
    int f6399label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$1$2(C1235Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$sample$2$1$2> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$downstream = flowCollector;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6399label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.ObjectRef<Object> objectRef = this.$lastValue;
            Object obj2 = objectRef.f5202element;
            if (obj2 == null) {
                return C1133Unit.INSTANCE;
            }
            objectRef.f5202element = null;
            FlowCollector<T> flowCollector = this.$downstream;
            Object obj3 = obj2 != NullSurrogateKt.f7173NULL ? obj2 : null;
            this.f6398L$0 = SpillingKt.nullOutSpilledVariable(obj2);
            this.f6399label = 1;
            if (flowCollector.mo4309emit(obj3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(C1133Unit c1133Unit, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$2) mo2166create(c1133Unit, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
