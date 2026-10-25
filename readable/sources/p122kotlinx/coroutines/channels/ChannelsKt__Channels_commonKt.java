package p122kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.ExceptionsKt;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@Metadata(m4987d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001a$\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001a$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\b\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0007\u001aP\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001a2\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00100\fH\u0086H¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a6\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0003\"\u000e\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00030\u0017*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0018\u001a\u0002H\u0016H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u001a\u0010\u001a\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m4988d2 = {"DEFAULT_CLOSE_MESSAGE", BuildConfig.f24315FLAVOR, "receiveOrNull", "E", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "consume", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", BuildConfig.f24315FLAVOR, "action", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", BuildConfig.f24315FLAVOR, "consumeTo", "C", BuildConfig.f24315FLAVOR, "collection", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelConsumed", "cause", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(m6344value = {"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n97#1,8:273\n156#1:281\n97#1,3:282\n157#1,2:285\n104#1:287\n100#1,3:288\n156#1:291\n97#1,3:292\n157#1,2:295\n104#1:297\n100#1,3:298\n1#2:301\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n156#1:273,8\n199#1:281\n199#1:282,3\n199#1:285,2\n199#1:287\n199#1:288,3\n262#1:291\n262#1:292,3\n262#1:295,2\n262#1:297\n262#1:298,3\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class ChannelsKt__Channels_commonKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m6124f = "Channels.common.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {157}, m6127m = "consumeEach", m6128n = {"$this$consumeEach", "action", "$this$consume$iv", "$this$consumeEach_u24lambda_u240", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$consumeEach$1\n*L\n1#1,272:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeEach$1 */
    public static final class C13661<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5642I$0;

        /* renamed from: I$1 */
        int f5643I$1;

        /* renamed from: I$2 */
        int f5644I$2;

        /* renamed from: L$0 */
        Object f5645L$0;

        /* renamed from: L$1 */
        Object f5646L$1;

        /* renamed from: L$2 */
        Object f5647L$2;

        /* renamed from: L$3 */
        Object f5648L$3;

        /* renamed from: L$4 */
        Object f5649L$4;

        /* renamed from: label */
        int f5650label;

        /* renamed from: result */
        /* synthetic */ Object f5651result;

        public C13661(Continuation<? super C13661> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5651result = obj;
            this.f5650label |= Integer.MIN_VALUE;
            return ChannelsKt__Channels_commonKt.consumeEach(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m6124f = "Channels.common.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {277}, m6127m = "consumeTo", m6128n = {"$this$consumeTo", "collection", "$this$consumeEach$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumeTo$1 */
    public static final class C13671<E, C extends Collection<E>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5652I$0;

        /* renamed from: I$1 */
        int f5653I$1;

        /* renamed from: I$2 */
        int f5654I$2;

        /* renamed from: L$0 */
        Object f5655L$0;

        /* renamed from: L$1 */
        Object f5656L$1;

        /* renamed from: L$2 */
        Object f5657L$2;

        /* renamed from: L$3 */
        Object f5658L$3;

        /* renamed from: L$4 */
        Object f5659L$4;

        /* renamed from: L$5 */
        Object f5660L$5;

        /* renamed from: label */
        int f5661label;

        /* renamed from: result */
        /* synthetic */ Object f5662result;

        public C13671(Continuation<? super C13671> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5662result = obj;
            this.f5661label |= Integer.MIN_VALUE;
            return ChannelsKt.consumeTo(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m6124f = "Channels.common.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {277}, m6127m = "toList", m6128n = {"$this$toList", "$this$toList_u24lambda_u240", "$this$consumeEach$iv", "$completion$iv", "$this$consume$iv$iv", "$this$consumeEach_u24lambda_u240$iv", "$i$a$-buildList-ChannelsKt__Channels_commonKt$toList$2", "$i$f$consumeEach", "$i$f$consume", "$i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv"}, m6130s = {"L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$toList$1 */
    public static final class C13681<E> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5663I$0;

        /* renamed from: I$1 */
        int f5664I$1;

        /* renamed from: I$2 */
        int f5665I$2;

        /* renamed from: I$3 */
        int f5666I$3;

        /* renamed from: L$0 */
        Object f5667L$0;

        /* renamed from: L$1 */
        Object f5668L$1;

        /* renamed from: L$2 */
        Object f5669L$2;

        /* renamed from: L$3 */
        Object f5670L$3;

        /* renamed from: L$4 */
        Object f5671L$4;

        /* renamed from: L$5 */
        Object f5672L$5;

        /* renamed from: L$6 */
        Object f5673L$6;

        /* renamed from: L$7 */
        Object f5674L$7;

        /* renamed from: label */
        int f5675label;

        /* renamed from: result */
        /* synthetic */ Object f5676result;

        public C13681(Continuation<? super C13681> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5676result = obj;
            this.f5675label |= Integer.MIN_VALUE;
            return ChannelsKt.m7103toList(null, this);
        }
    }

    @PublishedApi
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        if (th != null) {
            CancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            if (CancellationException == null) {
                CancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.mo7064cancel(CancellationException);
    }

    /* renamed from: consume */
    public static final <E, R> R m7109consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        try {
            R rMo2237invoke = function1.mo2237invoke(receiveChannel);
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, null);
            InlineMarker.finallyEnd(1);
            return rMo2237invoke;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096 A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:25:0x008e, B:27:0x0096, B:21:0x0067, B:30:0x00a4), top: B:39:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:25:0x008e, B:27:0x0096, B:21:0x0067, B:30:0x00a4), top: B:39:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0088 -> B:39:0x008e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        C13661 c13661;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i;
        ChannelIterator it;
        C13661 c136612;
        int i2;
        int i3;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, C1133Unit> function12;
        Object objMo7069hasNext;
        if (continuation instanceof C13661) {
            c13661 = (C13661) continuation;
            int i4 = c13661.f5650label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13661.f5650label = i4 - Integer.MIN_VALUE;
            } else {
                c13661 = new C13661(continuation);
            }
        }
        Object obj = c13661.f5651result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13661.f5650label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                it = receiveChannel.iterator();
                c136612 = c13661;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                function12 = function1;
                receiveChannel2 = receiveChannel3;
                c136612.f5645L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c136612.f5646L$1 = function12;
                c136612.f5647L$2 = receiveChannel2;
                c136612.f5648L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c136612.f5649L$4 = it;
                c136612.f5642I$0 = i3;
                c136612.f5643I$1 = i2;
                c136612.f5644I$2 = i;
                c136612.f5650label = 1;
                objMo7069hasNext = it.mo7069hasNext(c136612);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13661.f5644I$2;
            int i7 = c13661.f5643I$1;
            int i8 = c13661.f5642I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13661.f5649L$4;
            ReceiveChannel<? extends E> receiveChannel4 = (ReceiveChannel) c13661.f5648L$3;
            ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) c13661.f5647L$2;
            Function1<? super E, C1133Unit> function13 = (Function1) c13661.f5646L$1;
            ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) c13661.f5645L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel6;
                ChannelIterator channelIterator2 = channelIterator;
                i2 = i7;
                receiveChannel2 = receiveChannel5;
                C13661 c136613 = c13661;
                function12 = function13;
                int i9 = i8;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        function12.mo2237invoke((Object) channelIterator2.mo7070next());
                        receiveChannel3 = receiveChannel4;
                        c136612 = c136613;
                        i3 = i9;
                        it = channelIterator2;
                        c136612.f5645L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c136612.f5646L$1 = function12;
                        c136612.f5647L$2 = receiveChannel2;
                        c136612.f5648L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c136612.f5649L$4 = it;
                        c136612.f5642I$0 = i3;
                        c136612.f5643I$1 = i2;
                        c136612.f5644I$2 = i;
                        c136612.f5650label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c136612);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        C13661 c136614 = c136612;
                        receiveChannel4 = receiveChannel3;
                        obj = objMo7069hasNext;
                        channelIterator2 = it;
                        i9 = i3;
                        c136613 = c136614;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            InlineMarker.finallyEnd(1);
                            return C1133Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                receiveChannel2 = receiveChannel5;
            }
        }
        try {
            throw th;
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    private static final <E> Object consumeEach$$forInline(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        try {
            ChannelIterator<? extends E> it = receiveChannel.iterator();
            while (true) {
                InlineMarker.m6315mark(3);
                InlineMarker.m6315mark(0);
                Object objMo7069hasNext = it.mo7069hasNext(null);
                InlineMarker.m6315mark(1);
                if (!((Boolean) objMo7069hasNext).booleanValue()) {
                    C1133Unit c1133Unit = C1133Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, null);
                    InlineMarker.finallyEnd(1);
                    return C1133Unit.INSTANCE;
                }
                function1.mo2237invoke(it.mo7070next());
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00af), top: B:39:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:12:0x0043, B:25:0x009b, B:27:0x00a3, B:28:0x00af), top: B:39:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0095 -> B:25:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<E>> Object consumeTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        C13671 c13671;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i;
        C c2;
        ChannelIterator it;
        C13671 c136712;
        int i2;
        int i3;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Object objMo7069hasNext;
        if (continuation instanceof C13671) {
            c13671 = (C13671) continuation;
            int i4 = c13671.f5661label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c13671.f5661label = i4 - Integer.MIN_VALUE;
            } else {
                c13671 = new C13671(continuation);
            }
        }
        Object obj = c13671.f5662result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c13671.f5661label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                i = 0;
                c2 = c;
                it = receiveChannel.iterator();
                c136712 = c13671;
                i2 = 0;
                i3 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel2 = receiveChannel3;
                receiveChannel4 = receiveChannel2;
                c136712.f5655L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                c136712.f5656L$1 = c2;
                c136712.f5657L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c136712.f5658L$3 = receiveChannel2;
                c136712.f5659L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c136712.f5660L$5 = it;
                c136712.f5652I$0 = i3;
                c136712.f5653I$1 = i2;
                c136712.f5654I$2 = i;
                c136712.f5661label = 1;
                objMo7069hasNext = it.mo7069hasNext(c136712);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                receiveChannel2 = receiveChannel;
                th = th2;
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = c13671.f5654I$2;
            int i7 = c13671.f5653I$1;
            int i8 = c13671.f5652I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13671.f5660L$5;
            ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) c13671.f5659L$4;
            ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) c13671.f5658L$3;
            ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) c13671.f5657L$2;
            Collection collection = (Collection) c13671.f5656L$1;
            ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) c13671.f5655L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i6;
                receiveChannel = receiveChannel8;
                ChannelIterator channelIterator2 = channelIterator;
                ?? r4 = collection;
                int i9 = i8;
                i2 = i7;
                receiveChannel3 = receiveChannel7;
                C13671 c136713 = c13671;
                receiveChannel4 = receiveChannel5;
                if (!((Boolean) obj).booleanValue()) {
                    r4.add(channelIterator2.mo7070next());
                    receiveChannel2 = receiveChannel6;
                    c136712 = c136713;
                    i3 = i9;
                    it = channelIterator2;
                    c2 = r4;
                    try {
                        c136712.f5655L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel);
                        c136712.f5656L$1 = c2;
                        c136712.f5657L$2 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c136712.f5658L$3 = receiveChannel2;
                        c136712.f5659L$4 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c136712.f5660L$5 = it;
                        c136712.f5652I$0 = i3;
                        c136712.f5653I$1 = i2;
                        c136712.f5654I$2 = i;
                        c136712.f5661label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c136712);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        C13671 c136714 = c136712;
                        receiveChannel6 = receiveChannel2;
                        obj = objMo7069hasNext;
                        channelIterator2 = it;
                        i9 = i3;
                        c136713 = c136714;
                        r4 = c2;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel6, null);
                            return r4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel6;
                throw th;
            }
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel receiveChannel) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return receiveChannel.getOnReceiveOrNull();
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel receiveChannel, Continuation continuation) {
        Intrinsics.checkNotNull(receiveChannel, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return receiveChannel.receiveOrNull(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc A[Catch: all -> 0x00d5, TryCatch #1 {all -> 0x00d5, blocks: (B:25:0x00c4, B:27:0x00cc, B:21:0x008e, B:30:0x00d8), top: B:41:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d8 A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #1 {all -> 0x00d5, blocks: (B:25:0x00c4, B:27:0x00cc, B:21:0x008e, B:30:0x00d8), top: B:41:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00bf -> B:41:0x00c4). Please report as a decompilation issue!!! */
    /* renamed from: toList */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object m7110toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        C13681 c13681;
        ReceiveChannel<? extends E> receiveChannel2;
        List list;
        C13681 c136812;
        C13681 c136813;
        ChannelIterator it;
        int i;
        int i2;
        int i3;
        int i4;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th;
        List list2;
        Object objMo7069hasNext;
        if (continuation instanceof C13681) {
            c13681 = (C13681) continuation;
            int i5 = c13681.f5675label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                c13681.f5675label = i5 - Integer.MIN_VALUE;
            } else {
                c13681 = new C13681(continuation);
            }
        }
        Object obj = c13681.f5676result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = c13681.f5675label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                list = listCreateListBuilder;
                c136812 = c13681;
                c136813 = c136812;
                it = receiveChannel.iterator();
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                receiveChannel3 = receiveChannel;
                receiveChannel4 = receiveChannel3;
                receiveChannel2 = receiveChannel4;
                receiveChannel5 = receiveChannel2;
                list2 = listCreateListBuilder;
                c136812.f5667L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                c136812.f5668L$1 = list;
                c136812.f5669L$2 = list2;
                c136812.f5670L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                c136812.f5671L$4 = SpillingKt.nullOutSpilledVariable(c136813);
                c136812.f5672L$5 = receiveChannel2;
                c136812.f5673L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                c136812.f5674L$7 = it;
                c136812.f5663I$0 = i4;
                c136812.f5664I$1 = i3;
                c136812.f5665I$2 = i2;
                c136812.f5666I$3 = i;
                c136812.f5675label = 1;
                objMo7069hasNext = it.mo7069hasNext(c136812);
                if (objMo7069hasNext != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                th = th2;
                receiveChannel2 = receiveChannel;
                th = th;
                throw th;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i7 = c13681.f5666I$3;
            int i8 = c13681.f5665I$2;
            int i9 = c13681.f5664I$1;
            int i10 = c13681.f5663I$0;
            ChannelIterator channelIterator = (ChannelIterator) c13681.f5674L$7;
            ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) c13681.f5673L$6;
            ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) c13681.f5672L$5;
            C13681 c136814 = (C13681) c13681.f5671L$4;
            ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) c13681.f5670L$3;
            List list3 = (List) c13681.f5669L$2;
            list = (List) c13681.f5668L$1;
            ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) c13681.f5667L$0;
            try {
                ResultKt.throwOnFailure(obj);
                c136812 = c13681;
                receiveChannel4 = receiveChannel8;
                it = channelIterator;
                i = i7;
                receiveChannel2 = receiveChannel7;
                i3 = i9;
                i2 = i8;
                receiveChannel5 = receiveChannel6;
                i4 = i10;
                c136813 = c136814;
                List list4 = list3;
                try {
                    if (!((Boolean) obj).booleanValue()) {
                        list4.add(it.mo7070next());
                        receiveChannel3 = receiveChannel9;
                        list2 = list4;
                        c136812.f5667L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel3);
                        c136812.f5668L$1 = list;
                        c136812.f5669L$2 = list2;
                        c136812.f5670L$3 = SpillingKt.nullOutSpilledVariable(receiveChannel4);
                        c136812.f5671L$4 = SpillingKt.nullOutSpilledVariable(c136813);
                        c136812.f5672L$5 = receiveChannel2;
                        c136812.f5673L$6 = SpillingKt.nullOutSpilledVariable(receiveChannel5);
                        c136812.f5674L$7 = it;
                        c136812.f5663I$0 = i4;
                        c136812.f5664I$1 = i3;
                        c136812.f5665I$2 = i2;
                        c136812.f5666I$3 = i;
                        c136812.f5675label = 1;
                        objMo7069hasNext = it.mo7069hasNext(c136812);
                        if (objMo7069hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel9 = receiveChannel3;
                        obj = objMo7069hasNext;
                        list4 = list2;
                        if (!((Boolean) obj).booleanValue()) {
                            C1133Unit c1133Unit = C1133Unit.INSTANCE;
                            ChannelsKt.cancelConsumed(receiveChannel2, null);
                            return CollectionsKt.m5800build(list);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                receiveChannel2 = receiveChannel7;
                throw th;
            }
        }
    }
}
