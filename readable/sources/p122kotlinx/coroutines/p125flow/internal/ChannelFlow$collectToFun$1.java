package p122kotlinx.coroutines.p125flow.internal;

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
import p122kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", m6124f = "ChannelFlow.kt", m6125i = {0}, m6126l = {56}, m6127m = "invokeSuspend", m6128n = {"it"}, m6130s = {"L$0"}, m6131v = 1)
/* loaded from: classes.dex */
public final class ChannelFlow$collectToFun$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: L$0 */
    /* synthetic */ Object f7071L$0;

    /* renamed from: label */
    int f7072label;

    /* renamed from: this$0 */
    final /* synthetic */ ChannelFlow<T> f7073this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, Continuation<? super ChannelFlow$collectToFun$1> continuation) {
        super(2, continuation);
        this.f7073this$0 = channelFlow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.f7073this$0, continuation);
        channelFlow$collectToFun$1.f7071L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ProducerScope<? super T> producerScope = (ProducerScope) this.f7071L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f7072label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelFlow<T> channelFlow = this.f7073this$0;
            this.f7071L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
            this.f7072label = 1;
            if (channelFlow.collectTo(producerScope, this) == coroutine_suspended) {
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
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo2167invoke(ProducerScope<? super T> producerScope, Continuation<? super C1133Unit> continuation) {
        return ((ChannelFlow$collectToFun$1) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
