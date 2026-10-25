package p122kotlinx.coroutines.channels;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.channels.ChannelResult;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m4988d2 = {"trySendBlocking", "Lkotlinx/coroutines/channels/ChannelResult;", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "sendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(m6344value = {"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,61:1\n1011#2,2:62\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt\n*L\n37#1:62,2\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class ChannelsKt__ChannelsKt {

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", m6124f = "Channels.kt", m6125i = {}, m6126l = {C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1 */
    public static final class C13641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Object $element;
        final /* synthetic */ SendChannel $this_sendBlocking;

        /* renamed from: label */
        int f5637label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13641(SendChannel sendChannel, Object obj, Continuation continuation) {
            super(2, continuation);
            this.$this_sendBlocking = sendChannel;
            this.$element = obj;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C13641(this.$this_sendBlocking, this.$element, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5637label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SendChannel sendChannel = this.$this_sendBlocking;
                Object obj2 = this.$element;
                this.f5637label = 1;
                if (sendChannel.mo7052send(obj2, this) == coroutine_suspended) {
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
            return ((C13641) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", "Lkotlinx/coroutines/channels/ChannelResult;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", m6124f = "Channels.kt", m6125i = {0, 0, 0}, m6126l = {C5125EACTags.INTERCHANGE_CONTROL}, m6127m = "invokeSuspend", m6128n = {"$this$runBlocking", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-ChannelsKt__ChannelsKt$trySendBlocking$2$r$1"}, m6130s = {"L$0", "L$1", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2 */
    public static final class C13652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends C1133Unit>>, Object> {
        final /* synthetic */ E $element;
        final /* synthetic */ SendChannel<E> $this_trySendBlocking;

        /* renamed from: I$0 */
        int f5638I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5639L$0;

        /* renamed from: L$1 */
        Object f5640L$1;

        /* renamed from: label */
        int f5641label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13652(SendChannel<? super E> sendChannel, E e, Continuation<? super C13652> continuation) {
            super(2, continuation);
            this.$this_trySendBlocking = sendChannel;
            this.$element = e;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13652 c13652 = new C13652(this.$this_trySendBlocking, this.$element, continuation);
            c13652.f5639L$0 = obj;
            return c13652;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super ChannelResult<? extends C1133Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super ChannelResult<C1133Unit>>) continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM18546constructorimpl;
            CoroutineScope coroutineScope = (CoroutineScope) this.f5639L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5641label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SendChannel<E> sendChannel = this.$this_trySendBlocking;
                    E e = this.$element;
                    C1124Result.Companion companion = C1124Result.INSTANCE;
                    this.f5639L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.f5640L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.f5638I$0 = 0;
                    this.f5641label = 1;
                    if (sendChannel.mo7052send(e, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
            } catch (Throwable th) {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
            }
            return ChannelResult.m20002boximpl(C1124Result.m18553isSuccessimpl(objM18546constructorimpl) ? ChannelResult.INSTANCE.m20017successJP2dKIU(C1133Unit.INSTANCE) : ChannelResult.INSTANCE.m20015closedJP2dKIU(C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl)));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ChannelResult<C1133Unit>> continuation) {
            return ((C13652) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", m5048imports = {}))
    public static final /* synthetic */ void sendBlocking(SendChannel sendChannel, Object obj) {
        if (ChannelResult.m20012isSuccessimpl(sendChannel.mo19989trySendJP2dKIU(obj))) {
            return;
        }
        BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C13641(sendChannel, obj, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e) {
        Object objMo19989trySendJP2dKIU = sendChannel.mo19989trySendJP2dKIU(e);
        if (objMo19989trySendJP2dKIU instanceof ChannelResult.C1363Failed) {
            return ((ChannelResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C13652(sendChannel, e, null), 1, null)).getHolder();
        }
        return ChannelResult.INSTANCE.m20017successJP2dKIU(C1133Unit.INSTANCE);
    }
}
