package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", m6124f = "Delay.kt", m6125i = {}, m6126l = {226}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,407:1\n14#2:408\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n*L\n226#1:408\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ C1235Ref.ObjectRef<Object> $lastValue;

    /* renamed from: label */
    int f6370label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$1(FlowCollector<? super T> flowCollector, C1235Ref.ObjectRef<Object> objectRef, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$1> continuation) {
        super(1, continuation);
        this.$downstream = flowCollector;
        this.$lastValue = objectRef;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo6118create(Continuation<?> continuation) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6370label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.$downstream;
            C1578Symbol c1578Symbol = NullSurrogateKt.f7173NULL;
            Object obj2 = this.$lastValue.f5202element;
            if (obj2 == c1578Symbol) {
                obj2 = null;
            }
            this.f6370label = 1;
            if (flowCollector.mo4309emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$lastValue.f5202element = null;
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2237invoke(Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) mo6118create(continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
