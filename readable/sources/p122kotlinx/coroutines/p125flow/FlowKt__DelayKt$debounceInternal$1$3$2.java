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
import p122kotlinx.coroutines.channels.ChannelResult;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "value", "Lkotlinx/coroutines/channels/ChannelResult;", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", m6124f = "Delay.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {236}, m6127m = "invokeSuspend", m6128n = {"value", "$v$c$kotlinx-coroutines-channels-ChannelResult$-$this$onFailure$0$iv", "it", "$i$f$onFailure-WpGqRn0", "$i$a$-onFailure-WpGqRn0-FlowKt__DelayKt$debounceInternal$1$3$2$2"}, m6130s = {"L$0", "L$1", "L$3", "I$0", "I$1"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,407:1\n1011#2,2:408\n1028#2:410\n1029#2:413\n1#3:411\n14#4:412\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n232#1:408,2\n233#1:410\n233#1:413\n236#1:412\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ C1235Ref.ObjectRef<Object> $lastValue;

    /* renamed from: I$0 */
    int f6371I$0;

    /* renamed from: I$1 */
    int f6372I$1;

    /* renamed from: L$0 */
    /* synthetic */ Object f6373L$0;

    /* renamed from: L$1 */
    Object f6374L$1;

    /* renamed from: L$2 */
    Object f6375L$2;

    /* renamed from: L$3 */
    Object f6376L$3;

    /* renamed from: label */
    int f6377label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$2(C1235Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$downstream = flowCollector;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.f6373L$0 = ((ChannelResult) obj).getHolder();
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(ChannelResult<? extends Object> channelResult, Continuation<? super C1133Unit> continuation) {
        return m20028invokeWpGqRn0(channelResult.getHolder(), continuation);
    }

    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m20028invokeWpGqRn0(Object obj, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) mo2166create(ChannelResult.m20002boximpl(obj), continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, kotlinx.coroutines.internal.Symbol] */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C1235Ref.ObjectRef<Object> objectRef;
        C1235Ref.ObjectRef<Object> objectRef2;
        ?? r0 = this.f6373L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6377label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = this.$lastValue;
            boolean z = r0 instanceof ChannelResult.C1363Failed;
            if (!z) {
                objectRef.f5202element = r0;
            }
            FlowCollector<T> flowCollector = this.$downstream;
            if (z) {
                Throwable thM20006exceptionOrNullimpl = ChannelResult.m20006exceptionOrNullimpl(r0);
                if (thM20006exceptionOrNullimpl != null) {
                    throw thM20006exceptionOrNullimpl;
                }
                Object obj2 = objectRef.f5202element;
                if (obj2 != null) {
                    if (obj2 == NullSurrogateKt.f7173NULL) {
                        obj2 = null;
                    }
                    this.f6373L$0 = SpillingKt.nullOutSpilledVariable(r0);
                    this.f6374L$1 = r0;
                    this.f6375L$2 = objectRef;
                    this.f6376L$3 = SpillingKt.nullOutSpilledVariable(thM20006exceptionOrNullimpl);
                    this.f6371I$0 = 0;
                    this.f6372I$1 = 0;
                    this.f6377label = 1;
                    if (flowCollector.mo4309emit(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.f5202element = NullSurrogateKt.f7172DONE;
            }
            return C1133Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (C1235Ref.ObjectRef) this.f6375L$2;
        ResultKt.throwOnFailure(obj);
        objectRef = objectRef2;
        objectRef.f5202element = NullSurrogateKt.f7172DONE;
        return C1133Unit.INSTANCE;
    }
}
