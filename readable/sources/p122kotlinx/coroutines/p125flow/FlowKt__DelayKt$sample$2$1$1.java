package p122kotlinx.coroutines.p125flow;

import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.channels.ChannelResult;
import p122kotlinx.coroutines.channels.ReceiveChannel;
import p122kotlinx.coroutines.p125flow.internal.ChildCancelledException;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "result", "Lkotlinx/coroutines/channels/ChannelResult;", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", m6124f = "Delay.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n1011#2,2:408\n1028#2:410\n1029#2:412\n1#3:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$1\n*L\n281#1:408,2\n282#1:410\n282#1:412\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ C1235Ref.ObjectRef<Object> $lastValue;

    /* renamed from: $ticker */
    final /* synthetic */ ReceiveChannel<C1133Unit> f6395$ticker;

    /* renamed from: L$0 */
    /* synthetic */ Object f6396L$0;

    /* renamed from: label */
    int f6397label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(C1235Ref.ObjectRef<Object> objectRef, ReceiveChannel<C1133Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.f6395$ticker = receiveChannel;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.f6395$ticker, continuation);
        flowKt__DelayKt$sample$2$1$1.f6396L$0 = ((ChannelResult) obj).getHolder();
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(ChannelResult<? extends Object> channelResult, Continuation<? super C1133Unit> continuation) {
        return m20029invokeWpGqRn0(channelResult.getHolder(), continuation);
    }

    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m20029invokeWpGqRn0(Object obj, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) mo2166create(ChannelResult.m20002boximpl(obj), continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, kotlinx.coroutines.internal.Symbol] */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ?? r0 = this.f6396L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f6397label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        C1235Ref.ObjectRef<Object> objectRef = this.$lastValue;
        boolean z = r0 instanceof ChannelResult.C1363Failed;
        if (!z) {
            objectRef.f5202element = r0;
        }
        ReceiveChannel<C1133Unit> receiveChannel = this.f6395$ticker;
        if (z) {
            Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(r0);
            if (thM20006exceptionOrNullimpl != null) {
                throw thM20006exceptionOrNullimpl;
            }
            receiveChannel.mo7064cancel((CancellationException) new ChildCancelledException());
            objectRef.f5202element = NullSurrogateKt.f7172DONE;
        }
        return C1133Unit.INSTANCE;
    }
}
