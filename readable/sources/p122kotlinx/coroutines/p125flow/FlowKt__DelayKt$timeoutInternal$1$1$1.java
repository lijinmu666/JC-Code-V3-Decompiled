package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", m6124f = "Delay.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {395}, m6127m = "invokeSuspend", m6128n = {"value", "$v$c$kotlinx-coroutines-channels-ChannelResult$-$this$onSuccess$0$iv", "it", "$i$f$onSuccess-WpGqRn0", "$i$a$-onSuccess-WpGqRn0-FlowKt__DelayKt$timeoutInternal$1$1$1$1"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n1011#2,2:408\n1049#2:410\n1050#2:412\n1#3:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1$1$1\n*L\n394#1:408,2\n396#1:410\n396#1:412\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<T> $downStream;

    /* renamed from: I$0 */
    int f6415I$0;

    /* renamed from: I$1 */
    int f6416I$1;

    /* renamed from: L$0 */
    /* synthetic */ Object f6417L$0;

    /* renamed from: L$1 */
    Object f6418L$1;

    /* renamed from: L$2 */
    Object f6419L$2;

    /* renamed from: label */
    int f6420label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> continuation) {
        super(2, continuation);
        this.$downStream = flowCollector;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 flowKt__DelayKt$timeoutInternal$1$1$1 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, continuation);
        flowKt__DelayKt$timeoutInternal$1$1$1.f6417L$0 = ((ChannelResult) obj).getHolder();
        return flowKt__DelayKt$timeoutInternal$1$1$1;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(Object obj, Continuation<? super Boolean> continuation) {
        return m20030invokeWpGqRn0(((ChannelResult) obj).getHolder(), continuation);
    }

    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m20030invokeWpGqRn0(Object obj, Continuation<? super Boolean> continuation) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) mo2166create(ChannelResult.m20002boximpl(obj), continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2 = this.f6417L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6420label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector<T> flowCollector = this.$downStream;
            if (!(obj2 instanceof ChannelResult.C1363Failed)) {
                this.f6417L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f6418L$1 = obj2;
                this.f6419L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f6415I$0 = 0;
                this.f6416I$1 = 0;
                this.f6420label = 1;
                if (flowCollector.mo4309emit(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.f6418L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (!(obj2 instanceof ChannelResult.Closed)) {
            return C1207Boxing.boxBoolean(true);
        }
        Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(obj2);
        if (thM20006exceptionOrNullimpl == null) {
            return C1207Boxing.boxBoolean(false);
        }
        throw thM20006exceptionOrNullimpl;
    }
}
