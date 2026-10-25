package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.AbstractCoroutine;
import p122kotlinx.coroutines.CoroutineContextKt;
import p122kotlinx.coroutines.CoroutineExceptionHandler;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.GlobalScope;
import p122kotlinx.coroutines.JobSupport;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;
import p122kotlinx.coroutines.channels.BroadcastKt;

@Metadata(m4987d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0099\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072-\b\u0002\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, m4988d2 = {"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "capacity", BuildConfig.f24315FLAVOR, "start", "Lkotlinx/coroutines/CoroutineStart;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "onCompletion", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "cause", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,124:1\n56#2,4:125\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastKt\n*L\n21#1:125,4\n*E\n"})
/* loaded from: classes.dex */
public final class BroadcastKt {

    /* JADX INFO: Add missing generic type declarations: [E] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", m6124f = "Broadcast.kt", m6125i = {0, 1, 1}, m6126l = {26, 27}, m6127m = "invokeSuspend", m6128n = {"$this$broadcast", "$this$broadcast", "e"}, m6130s = {"L$0", "L$0", "L$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.BroadcastKt$broadcast$2 */
    public static final class C13552<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $channel;

        /* renamed from: L$0 */
        private /* synthetic */ Object f5596L$0;

        /* renamed from: L$1 */
        Object f5597L$1;

        /* renamed from: L$2 */
        Object f5598L$2;

        /* renamed from: label */
        int f5599label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13552(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C13552> continuation) {
            super(2, continuation);
            this.$channel = receiveChannel;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C13552 c13552 = new C13552(this.$channel, continuation);
            c13552.f5596L$0 = obj;
            return c13552;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0063 -> B:7:0x0019). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator<E> it;
            ChannelIterator<E> channelIterator;
            Object objMo7069hasNext;
            ProducerScope producerScope = (ProducerScope) this.f5596L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5599label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$channel.iterator();
                this.f5596L$0 = producerScope;
                this.f5597L$1 = it;
                this.f5598L$2 = null;
                this.f5599label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext == coroutine_suspended) {
                }
            } else if (i == 1) {
                channelIterator = (ChannelIterator) this.f5597L$1;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) this.f5597L$1;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                this.f5596L$0 = producerScope;
                this.f5597L$1 = it;
                this.f5598L$2 = null;
                this.f5599label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelIterator = it;
                obj = objMo7069hasNext;
                if (((Boolean) obj).booleanValue()) {
                    return C1133Unit.INSTANCE;
                }
                E eMo7070next = channelIterator.mo7070next();
                this.f5596L$0 = producerScope;
                this.f5597L$1 = channelIterator;
                this.f5598L$2 = SpillingKt.nullOutSpilledVariable(eMo7070next);
                this.f5599label = 2;
                if (producerScope.mo7052send(eMo7070next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = channelIterator;
                this.f5596L$0 = producerScope;
                this.f5597L$1 = it;
                this.f5598L$2 = null;
                this.f5599label = 1;
                objMo7069hasNext = it.mo7069hasNext(this);
                if (objMo7069hasNext == coroutine_suspended) {
                }
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super E> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C13552) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(final ReceiveChannel<? extends E> receiveChannel, int i, CoroutineStart coroutineStart) {
        return broadcast$default(CoroutineScopeKt.m6957plus(CoroutineScopeKt.m6957plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE)), null, i, coroutineStart, new Function1() { // from class: o.IvRQOa
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return BroadcastKt.broadcast$lambda$1(receiveChannel, (Throwable) obj);
            }
        }, new C13552(receiveChannel, null), 1, null);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel receiveChannel, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.f5507LAZY;
        }
        return broadcast(receiveChannel, i, coroutineStart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit broadcast$lambda$1(ReceiveChannel receiveChannel, Throwable th) {
        ChannelsKt.cancelConsumed(receiveChannel, th);
        return C1133Unit.INSTANCE;
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i = 1;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.f5507LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        return broadcast(coroutineScope, coroutineContext2, i3, coroutineStart2, function1, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> broadcast(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1<? super Throwable, C1133Unit> function1, Function2<? super ProducerScope<? super E>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        BroadcastCoroutine broadcastCoroutine;
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        BroadcastChannel BroadcastChannel = BroadcastChannelKt.BroadcastChannel(i);
        if (coroutineStart.m6962isLazy()) {
            broadcastCoroutine = new LazyBroadcastCoroutine(coroutineContextNewCoroutineContext, BroadcastChannel, function2);
        } else {
            broadcastCoroutine = new BroadcastCoroutine(coroutineContextNewCoroutineContext, BroadcastChannel, true);
        }
        if (function1 != null) {
            ((JobSupport) broadcastCoroutine).invokeOnCompletion(function1);
        }
        ((AbstractCoroutine) broadcastCoroutine).m6900start(coroutineStart, broadcastCoroutine, function2);
        return (BroadcastChannel<E>) broadcastCoroutine;
    }
}
