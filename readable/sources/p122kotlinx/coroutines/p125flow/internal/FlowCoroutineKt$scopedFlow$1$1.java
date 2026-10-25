package p122kotlinx.coroutines.p125flow.internal;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
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
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.p125flow.FlowCollector;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", m6124f = "FlowCoroutine.kt", m6125i = {0}, m6126l = {C5125EACTags.PIN_USAGE_POLICY}, m6127m = "invokeSuspend", m6128n = {"$this$flowScope"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $block */
    final /* synthetic */ Function3<CoroutineScope, FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> f7168$block;
    final /* synthetic */ FlowCollector<R> $this_flow;

    /* renamed from: L$0 */
    private /* synthetic */ Object f7169L$0;

    /* renamed from: label */
    int f7170label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowCoroutineKt$scopedFlow$1$1(Function3<? super CoroutineScope, ? super FlowCollector<? super R>, ? super Continuation<? super C1133Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super FlowCoroutineKt$scopedFlow$1$1> continuation) {
        super(2, continuation);
        this.f7168$block = function3;
        this.$this_flow = flowCollector;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.f7168$block, this.$this_flow, continuation);
        flowCoroutineKt$scopedFlow$1$1.f7169L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.f7169L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f7170label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<CoroutineScope, FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> function3 = this.f7168$block;
            Object obj2 = this.$this_flow;
            this.f7169L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.f7170label = 1;
            if (function3.mo6219invoke(coroutineScope, obj2, this) == coroutine_suspended) {
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
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((FlowCoroutineKt$scopedFlow$1$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
