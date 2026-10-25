package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
@SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n*L\n1#1,141:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$collectWhile$collector$1(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.$predicate = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 flowKt__LimitKt$collectWhile$collector$1$emit$1;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) {
            flowKt__LimitKt$collectWhile$collector$1$emit$1 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) continuation;
            int i = flowKt__LimitKt$collectWhile$collector$1$emit$1.f6541label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$collector$1$emit$1.f6541label = i - Integer.MIN_VALUE;
            } else {
                flowKt__LimitKt$collectWhile$collector$1$emit$1 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
            }
        }
        Object objMo2167invoke = flowKt__LimitKt$collectWhile$collector$1$emit$1.f6542result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__LimitKt$collectWhile$collector$1$emit$1.f6541label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo2167invoke);
            Function2<T, Continuation<? super Boolean>, Object> function2 = this.$predicate;
            flowKt__LimitKt$collectWhile$collector$1$emit$1.f6540L$0 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__LimitKt$collectWhile$collector$1$emit$1.f6541label = 1;
            objMo2167invoke = function2.mo2167invoke(t, flowKt__LimitKt$collectWhile$collector$1$emit$1);
            if (objMo2167invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo2167invoke);
        }
        if (((Boolean) objMo2167invoke).booleanValue()) {
            return C1133Unit.INSTANCE;
        }
        throw new AbortFlowException(this);
    }

    public Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
        InlineMarker.m6315mark(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, continuation);
        InlineMarker.m6315mark(5);
        if (((Boolean) this.$predicate.mo2167invoke(t, continuation)).booleanValue()) {
            return C1133Unit.INSTANCE;
        }
        throw new AbortFlowException(this);
    }
}
