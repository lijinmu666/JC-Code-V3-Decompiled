package p122kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.CoroutineStart;
import p122kotlinx.coroutines.p127selects.SelectImplementation;
import p122kotlinx.coroutines.p127selects.SelectInstance;
import p122kotlinx.coroutines.p127selects.TrySelectDetailedResult;

@Metadata(m4987d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000267B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00152\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0017\u0010(\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0010¢\u0006\u0002\b)J\b\u00104\u001a\u000205H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010!\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u00110\"j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030 \u0012\u0006\u0012\u0004\u0018\u00010\u0011`#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00101\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b2\u0010.\u001a\u0004\b3\u00100¨\u00068"}, m4988d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", BuildConfig.f24315FLAVOR, "<init>", "(I)V", "getCapacity", "()I", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "subscribers", BuildConfig.f24315FLAVOR, "lastConflatedElement", BuildConfig.f24315FLAVOR, "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "removeSubscriber", BuildConfig.f24315FLAVOR, "s", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "close", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "isClosedForSend", "()Z", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "toString", BuildConfig.f24315FLAVOR, "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n11#2:364\n11#2:365\n11#2:369\n11#2:372\n11#2:378\n11#2:379\n11#2:385\n11#2:388\n11#2:389\n11#2:390\n774#3:366\n865#3,2:367\n1869#3,2:370\n1761#3,3:373\n1869#3,2:376\n1869#3,2:380\n774#3:382\n865#3,2:383\n1869#3,2:386\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n115#1:364\n137#1:365\n162#1:369\n186#1:372\n228#1:378\n280#1:379\n292#1:385\n304#1:388\n331#1:389\n343#1:390\n138#1:366\n138#1:367,2\n175#1:370,2\n191#1:373,3\n200#1:376,2\n282#1:380,2\n287#1:382\n287#1:383,2\n295#1:386,2\n*E\n"})
/* loaded from: classes.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends BufferedChannel<E>> subscribers;

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m4988d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,363:1\n11#2:364\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n311#1:364\n*E\n"})
    public final class SubscriberBuffered extends BufferedChannel<E> {
        /* JADX WARN: Multi-variable type inference failed */
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.getCapacity(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // p122kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: cancelImpl, reason: merged with bridge method [inline-methods] */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            ReentrantLock reentrantLock = ((BroadcastChannelImpl) BroadcastChannelImpl.this).lock;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.removeSubscriber(this);
                return super.cancelImpl$kotlinx_coroutines_core(cause);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m4988d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // p122kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: cancelImpl, reason: merged with bridge method [inline-methods] */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            BroadcastChannelImpl.this.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", m6124f = "BroadcastChannel.kt", m6125i = {}, m6126l = {240}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,363:1\n11#2:364\n1#3:365\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n253#1:364\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2 */
    public static final class C13532 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Object $element;

        /* renamed from: $select */
        final /* synthetic */ SelectInstance<?> f5582$select;

        /* renamed from: label */
        int f5583label;

        /* renamed from: this$0 */
        final /* synthetic */ BroadcastChannelImpl<E> f5584this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13532(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, SelectInstance<?> selectInstance, Continuation<? super C13532> continuation) {
            super(2, continuation);
            this.f5584this$0 = broadcastChannelImpl;
            this.$element = obj;
            this.f5582$select = selectInstance;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C13532(this.f5584this$0, this.$element, this.f5582$select, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5583label;
            boolean z = true;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BroadcastChannelImpl<E> broadcastChannelImpl = this.f5584this$0;
                    Object obj2 = this.$element;
                    this.f5583label = 1;
                    if (broadcastChannelImpl.mo7052send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                if (!this.f5584this$0.isClosedForSend() || (!(th instanceof ClosedSendChannelException) && this.f5584this$0.getSendException() != th)) {
                    throw th;
                }
                z = false;
            }
            ReentrantLock reentrantLock = ((BroadcastChannelImpl) this.f5584this$0).lock;
            BroadcastChannelImpl<E> broadcastChannelImpl2 = this.f5584this$0;
            SelectInstance<?> selectInstance = this.f5582$select;
            reentrantLock.lock();
            try {
                ((BroadcastChannelImpl) broadcastChannelImpl2).onSendInternalResult.put(selectInstance, z ? C1133Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
                Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                if (((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl2, c1133Unit) != TrySelectDetailedResult.REREGISTER) {
                    ((BroadcastChannelImpl) broadcastChannelImpl2).onSendInternalResult.remove(selectInstance);
                }
                reentrantLock.unlock();
                return c1133Unit;
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C13532) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.BroadcastChannelImpl", m6124f = "BroadcastChannel.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {179}, m6127m = "send", m6128n = {"element", "subs", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-BroadcastChannelImpl$send$2"}, m6130s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 */
    public static final class C13541 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5585I$0;

        /* renamed from: I$1 */
        int f5586I$1;

        /* renamed from: L$0 */
        Object f5587L$0;

        /* renamed from: L$1 */
        Object f5588L$1;

        /* renamed from: L$2 */
        Object f5589L$2;

        /* renamed from: L$3 */
        Object f5590L$3;

        /* renamed from: L$4 */
        Object f5591L$4;

        /* renamed from: L$5 */
        Object f5592L$5;

        /* renamed from: label */
        int f5593label;

        /* renamed from: result */
        /* synthetic */ Object f5594result;

        /* renamed from: this$0 */
        final /* synthetic */ BroadcastChannelImpl<E> f5595this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13541(BroadcastChannelImpl<E> broadcastChannelImpl, Continuation<? super C13541> continuation) {
            super(continuation);
            this.f5595this$0 = broadcastChannelImpl;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5594result = obj;
            this.f5593label |= Integer.MIN_VALUE;
            return this.f5595this$0.mo7052send(null, this);
        }
    }

    public BroadcastChannelImpl(int i) {
        super(0, null);
        this.capacity = i;
        if (i >= 1 || i == -1) {
            this.lock = new ReentrantLock();
            this.subscribers = CollectionsKt.emptyList();
            this.lastConflatedElement = BroadcastChannelKt.NO_ELEMENT;
            this.onSendInternalResult = new HashMap<>();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i + " was specified").toString());
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void removeSubscriber(ReceiveChannel<? extends E> s) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.subscribers;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != s) {
                    arrayList.add(obj);
                }
            }
            this.subscribers = arrayList;
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p122kotlinx.coroutines.channels.BufferedChannel
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.subscribers.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).cancelImpl$kotlinx_coroutines_core(cause);
            }
            this.lastConflatedElement = BroadcastChannelKt.NO_ELEMENT;
            boolean zCancelImpl$kotlinx_coroutines_core = super.cancelImpl$kotlinx_coroutines_core(cause);
            reentrantLock.unlock();
            return zCancelImpl$kotlinx_coroutines_core;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p122kotlinx.coroutines.channels.BufferedChannel, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.subscribers.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).mo7051close(cause);
            }
            List<? extends BufferedChannel<E>> list = this.subscribers;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).hasElements$kotlinx_coroutines_core()) {
                    arrayList.add(obj);
                }
            }
            this.subscribers = arrayList;
            boolean zMo7051close = super.mo7051close(cause);
            reentrantLock.unlock();
            return zMo7051close;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final E getValue() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                Throwable closeCause = getCloseCause();
                if (closeCause == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw closeCause;
            }
            if (this.lastConflatedElement == BroadcastChannelKt.NO_ELEMENT) {
                throw new IllegalStateException("No value");
            }
            E e = (E) this.lastConflatedElement;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final E getValueOrNull() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            E e = null;
            if (!isClosedForReceive() && this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                e = (E) this.lastConflatedElement;
            }
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p122kotlinx.coroutines.channels.BufferedChannel, p122kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForSend();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p122kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            SubscriberBuffered subscriberConflated = this.capacity == -1 ? new SubscriberConflated() : new SubscriberBuffered();
            if (isClosedForSend() && this.lastConflatedElement == BroadcastChannelKt.NO_ELEMENT) {
                ((BufferedChannel) subscriberConflated).mo7051close(getCloseCause());
                reentrantLock.unlock();
                return subscriberConflated;
            }
            if (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
                ((BufferedChannel) subscriberConflated).mo19989trySendJP2dKIU(getValue());
            }
            this.subscribers = CollectionsKt.m5882plus((Collection<? extends ReceiveChannel<E>>) this.subscribers, subscriberConflated);
            reentrantLock.unlock();
            return subscriberConflated;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p122kotlinx.coroutines.channels.BufferedChannel
    public void registerSelectForSend(SelectInstance<?> select, Object element) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object objRemove = this.onSendInternalResult.remove(select);
            if (objRemove != null) {
                select.selectInRegistrationPhase(objRemove);
                return;
            }
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
            reentrantLock.unlock();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(select.getContext()), null, CoroutineStart.UNDISPATCHED, new C13532(this, element, select, null), 1, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00aa -> B:12:0x0040). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.channels.BufferedChannel, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) throws Throwable {
        C13541 c13541;
        Iterable iterable;
        Iterable iterable2;
        Iterator it;
        int i;
        if (continuation instanceof C13541) {
            c13541 = (C13541) continuation;
            int i2 = c13541.f5593label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c13541.f5593label = i2 - Integer.MIN_VALUE;
            } else {
                c13541 = new C13541(this, continuation);
            }
        }
        Object obj = c13541.f5594result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c13541.f5593label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (isClosedForSend()) {
                    throw getSendException();
                }
                if (this.capacity == -1) {
                    this.lastConflatedElement = e;
                }
                List<? extends BufferedChannel<E>> list = this.subscribers;
                reentrantLock.unlock();
                iterable = list;
                iterable2 = iterable;
                it = list.iterator();
                i = 0;
                if (it.hasNext()) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c13541.f5585I$0;
            it = (Iterator) c13541.f5590L$3;
            iterable = (Iterable) c13541.f5589L$2;
            iterable2 = (List) c13541.f5588L$1;
            Object obj2 = c13541.f5587L$0;
            ResultKt.throwOnFailure(obj);
            C13541 c135412 = c13541;
            int i5 = i4;
            e = obj2;
            Iterable iterable3 = iterable2;
            Iterable iterable4 = iterable;
            Iterator it2 = it;
            C13541 c135413 = c135412;
            if (((Boolean) obj).booleanValue() && isClosedForSend()) {
                throw getSendException();
            }
            i = i5;
            c13541 = c135413;
            it = it2;
            iterable = iterable4;
            iterable2 = iterable3;
            if (it.hasNext()) {
                Object next = it.next();
                BufferedChannel bufferedChannel = (BufferedChannel) next;
                c13541.f5587L$0 = e;
                c13541.f5588L$1 = SpillingKt.nullOutSpilledVariable(iterable2);
                c13541.f5589L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                c13541.f5590L$3 = it;
                c13541.f5591L$4 = SpillingKt.nullOutSpilledVariable(next);
                c13541.f5592L$5 = SpillingKt.nullOutSpilledVariable(bufferedChannel);
                c13541.f5585I$0 = i;
                c13541.f5586I$1 = 0;
                c13541.f5593label = 1;
                Object objSendBroadcast$kotlinx_coroutines_core = bufferedChannel.sendBroadcast$kotlinx_coroutines_core(e, c13541);
                if (objSendBroadcast$kotlinx_coroutines_core == coroutine_suspended) {
                    return coroutine_suspended;
                }
                c135412 = c13541;
                i5 = i;
                obj = objSendBroadcast$kotlinx_coroutines_core;
                Iterable iterable32 = iterable2;
                Iterable iterable42 = iterable;
                Iterator it22 = it;
                C13541 c1354132 = c135412;
                if (((Boolean) obj).booleanValue()) {
                }
                i = i5;
                c13541 = c1354132;
                it = it22;
                iterable = iterable42;
                iterable2 = iterable32;
                if (it.hasNext()) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }

    @Override // p122kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.lastConflatedElement != BroadcastChannelKt.NO_ELEMENT) {
            str = "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; ";
        } else {
            str = BuildConfig.f24315FLAVOR;
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt.joinToString$default(this.subscribers, ";", "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    @Override // p122kotlinx.coroutines.channels.BufferedChannel, p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo19989trySendJP2dKIU(E element) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                return super.mo19989trySendJP2dKIU(element);
            }
            List<? extends BufferedChannel<E>> list = this.subscribers;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).shouldSendSuspend$kotlinx_coroutines_core()) {
                        return ChannelResult.INSTANCE.m20016failurePtdJZtk();
                    }
                }
            }
            if (this.capacity == -1) {
                this.lastConflatedElement = element;
            }
            Iterator<T> it2 = this.subscribers.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).mo19989trySendJP2dKIU(element);
            }
            return ChannelResult.INSTANCE.m20017successJP2dKIU(C1133Unit.INSTANCE);
        } finally {
            reentrantLock.unlock();
        }
    }
}
