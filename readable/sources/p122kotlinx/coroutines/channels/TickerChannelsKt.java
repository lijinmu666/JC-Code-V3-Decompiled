package p122kotlinx.coroutines.channels;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.AbstractTimeSource;
import p122kotlinx.coroutines.AbstractTimeSourceKt;
import p122kotlinx.coroutines.C1338DelayKt;
import p122kotlinx.coroutines.Dispatchers;
import p122kotlinx.coroutines.EventLoop_commonKt;
import p122kotlinx.coroutines.GlobalScope;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(m4987d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001a,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, m4988d2 = {"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", BuildConfig.f24315FLAVOR, "delayMillis", BuildConfig.f24315FLAVOR, "initialDelayMillis", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
/* loaded from: classes.dex */
public final class TickerChannelsKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.TickerChannelsKt", m6124f = "TickerChannels.kt", m6125i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m6126l = {102, 104, 105}, m6127m = "fixedDelayTicker", m6128n = {"channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis"}, m6130s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 */
    public static final class C14081 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f5990J$0;

        /* renamed from: J$1 */
        long f5991J$1;

        /* renamed from: L$0 */
        Object f5992L$0;

        /* renamed from: label */
        int f5993label;

        /* renamed from: result */
        /* synthetic */ Object f5994result;

        public C14081(Continuation<? super C14081> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5994result = obj;
            this.f5993label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedDelayTicker(0L, 0L, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.TickerChannelsKt", m6124f = "TickerChannels.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, m6126l = {C5125EACTags.UNIFORM_RESOURCE_LOCATOR, 84, 90, 92}, m6127m = "fixedPeriodTicker", m6128n = {"channel", "delayMillis", "initialDelayMillis", "deadline", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "channel", "delayMillis", "initialDelayMillis", "deadline", "delayNs", "now", "nextDelay"}, m6130s = {"L$0", "J$0", "J$1", "J$2", "L$0", "J$0", "J$1", "J$2", "J$3", "L$0", "J$0", "J$1", "J$2", "J$3", "J$4", "J$5", "J$6", "L$0", "J$0", "J$1", "J$2", "J$3", "J$4", "J$5"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 */
    public static final class C14091 extends ContinuationImpl {

        /* renamed from: J$0 */
        long f5995J$0;

        /* renamed from: J$1 */
        long f5996J$1;

        /* renamed from: J$2 */
        long f5997J$2;

        /* renamed from: J$3 */
        long f5998J$3;

        /* renamed from: J$4 */
        long f5999J$4;

        /* renamed from: J$5 */
        long f6000J$5;

        /* renamed from: J$6 */
        long f6001J$6;

        /* renamed from: L$0 */
        Object f6002L$0;

        /* renamed from: label */
        int f6003label;

        /* renamed from: result */
        /* synthetic */ Object f6004result;

        public C14091(Continuation<? super C14091> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6004result = obj;
            this.f6003label |= Integer.MIN_VALUE;
            return TickerChannelsKt.fixedPeriodTicker(0L, 0L, null, this);
        }
    }

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", m6124f = "TickerChannels.kt", m6125i = {0, 1}, m6126l = {C5125EACTags.APPLICATION_IMAGE, C5125EACTags.DISPLAY_IMAGE}, m6127m = "invokeSuspend", m6128n = {"$this$produce", "$this$produce"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3 */
    public static final class C14103 extends SuspendLambda implements Function2<ProducerScope<? super C1133Unit>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;

        /* renamed from: $mode */
        final /* synthetic */ TickerMode f6005$mode;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6006L$0;

        /* renamed from: label */
        int f6007label;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        /* renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TickerMode.m7161values().length];
                try {
                    iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14103(TickerMode tickerMode, long j, long j2, Continuation<? super C14103> continuation) {
            super(2, continuation);
            this.f6005$mode = tickerMode;
            this.$delayMillis = j;
            this.$initialDelayMillis = j2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14103 c14103 = new C14103(this.f6005$mode, this.$delayMillis, this.$initialDelayMillis, continuation);
            c14103.f6006L$0 = obj;
            return c14103;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.f6006L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6007label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.f6005$mode.ordinal()];
                if (i2 == 1) {
                    long j = this.$delayMillis;
                    long j2 = this.$initialDelayMillis;
                    SendChannel channel = producerScope.getChannel();
                    this.f6006L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                    this.f6007label = 1;
                    if (TickerChannelsKt.fixedPeriodTicker(j, j2, channel, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    long j3 = this.$delayMillis;
                    long j4 = this.$initialDelayMillis;
                    SendChannel channel2 = producerScope.getChannel();
                    this.f6006L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                    this.f6007label = 2;
                    if (TickerChannelsKt.fixedDelayTicker(j3, j4, channel2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(ProducerScope<? super C1133Unit> producerScope, Continuation<? super C1133Unit> continuation) {
            return ((C14103) mo2166create(producerScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008c -> B:14:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j, long j2, SendChannel<? super C1133Unit> sendChannel, Continuation<? super C1133Unit> continuation) {
        C14081 c14081;
        long j3;
        long j4;
        if (continuation instanceof C14081) {
            c14081 = (C14081) continuation;
            int i = c14081.f5993label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14081.f5993label = i - Integer.MIN_VALUE;
            } else {
                c14081 = new C14081(continuation);
            }
        }
        Object obj = c14081.f5994result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14081.f5993label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c14081.f5992L$0 = sendChannel;
            c14081.f5990J$0 = j;
            c14081.f5991J$1 = j2;
            c14081.f5993label = 1;
            if (C1338DelayKt.m6972delay(j2, c14081) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            j2 = c14081.f5991J$1;
            j = c14081.f5990J$0;
            sendChannel = (SendChannel) c14081.f5992L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            j4 = c14081.f5991J$1;
            j3 = c14081.f5990J$0;
            sendChannel = (SendChannel) c14081.f5992L$0;
            ResultKt.throwOnFailure(obj);
            c14081.f5992L$0 = sendChannel;
            c14081.f5990J$0 = j3;
            c14081.f5991J$1 = j4;
            c14081.f5993label = 3;
            if (C1338DelayKt.m6972delay(j3, c14081) == coroutine_suspended) {
                return coroutine_suspended;
            }
            long j5 = j4;
            j = j3;
            j2 = j5;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j4 = c14081.f5991J$1;
            j3 = c14081.f5990J$0;
            sendChannel = (SendChannel) c14081.f5992L$0;
            ResultKt.throwOnFailure(obj);
            long j52 = j4;
            j = j3;
            j2 = j52;
        }
        C1133Unit c1133Unit = C1133Unit.INSTANCE;
        c14081.f5992L$0 = sendChannel;
        c14081.f5990J$0 = j;
        c14081.f5991J$1 = j2;
        c14081.f5993label = 2;
        if (sendChannel.mo7052send(c1133Unit, c14081) != coroutine_suspended) {
            return coroutine_suspended;
        }
        long j6 = j;
        j4 = j2;
        j3 = j6;
        c14081.f5992L$0 = sendChannel;
        c14081.f5990J$0 = j3;
        c14081.f5991J$1 = j4;
        c14081.f5993label = 3;
        if (C1338DelayKt.m6972delay(j3, c14081) == coroutine_suspended) {
        }
        long j522 = j4;
        j = j3;
        j2 = j522;
        C1133Unit c1133Unit2 = C1133Unit.INSTANCE;
        c14081.f5992L$0 = sendChannel;
        c14081.f5990J$0 = j;
        c14081.f5991J$1 = j2;
        c14081.f5993label = 2;
        if (sendChannel.mo7052send(c1133Unit2, c14081) != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0162 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x013a -> B:48:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0163 -> B:53:0x0169). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j, long j2, SendChannel<? super C1133Unit> sendChannel, Continuation<? super C1133Unit> continuation) {
        C14091 c14091;
        SendChannel sendChannel2;
        long j3;
        long j4;
        long jDelayToNanos;
        long j5;
        long j6;
        char c;
        long j7;
        long j8;
        SendChannel sendChannel3;
        long jNanoTime;
        C14091 c140912;
        long j9;
        long jCoerceAtLeast;
        long jDelayNanosToMillis;
        char c2;
        C1133Unit c1133Unit;
        long j10 = j2;
        if (continuation instanceof C14091) {
            c14091 = (C14091) continuation;
            int i = c14091.f6003label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14091.f6003label = i - Integer.MIN_VALUE;
            } else {
                c14091 = new C14091(continuation);
            }
        }
        Object obj = c14091.f6004result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14091.f6003label;
        int i3 = 2;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
            long jNanoTime2 = (abstractTimeSource != null ? abstractTimeSource.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos(j2);
            sendChannel2 = sendChannel;
            c14091.f6002L$0 = sendChannel2;
            c14091.f5995J$0 = j;
            c14091.f5996J$1 = j10;
            c14091.f5997J$2 = jNanoTime2;
            c14091.f6003label = 1;
            if (C1338DelayKt.m6972delay(j10, c14091) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = jNanoTime2;
            j4 = j;
        } else if (i2 == 1) {
            long j11 = c14091.f5997J$2;
            long j12 = c14091.f5996J$1;
            j4 = c14091.f5995J$0;
            SendChannel sendChannel4 = (SendChannel) c14091.f6002L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel2 = sendChannel4;
            j10 = j12;
            j3 = j11;
        } else if (i2 == 2) {
            j7 = c14091.f5998J$3;
            j8 = c14091.f5997J$2;
            j6 = c14091.f5996J$1;
            j5 = c14091.f5995J$0;
            sendChannel3 = (SendChannel) c14091.f6002L$0;
            ResultKt.throwOnFailure(obj);
            AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
            jNanoTime = abstractTimeSource2 == null ? abstractTimeSource2.nanoTime() : System.nanoTime();
            c140912 = c14091;
            j9 = j8;
            jCoerceAtLeast = RangesKt.coerceAtLeast(j8 - jNanoTime, 0L);
            if (jCoerceAtLeast == 0) {
            }
            jDelayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
            c140912.f6002L$0 = sendChannel3;
            c140912.f5995J$0 = j5;
            c140912.f5996J$1 = j6;
            long j13 = j6;
            c140912.f5997J$2 = j9;
            c140912.f5998J$3 = j7;
            c140912.f5999J$4 = jNanoTime;
            c140912.f6000J$5 = jCoerceAtLeast;
            c2 = 4;
            c140912.f6003label = 4;
            if (C1338DelayKt.m6972delay(jDelayNanosToMillis, c140912) != coroutine_suspended) {
            }
        } else if (i2 == 3) {
            j7 = c14091.f5998J$3;
            j3 = c14091.f5997J$2;
            j6 = c14091.f5996J$1;
            j5 = c14091.f5995J$0;
            SendChannel sendChannel5 = (SendChannel) c14091.f6002L$0;
            ResultKt.throwOnFailure(obj);
            sendChannel2 = sendChannel5;
            c = 3;
            long j14 = j6;
            j4 = j5;
            jDelayToNanos = j7;
            j10 = j14;
            i3 = 2;
            j8 = j3 + jDelayToNanos;
            c1133Unit = C1133Unit.INSTANCE;
            c14091.f6002L$0 = sendChannel2;
            c14091.f5995J$0 = j4;
            c14091.f5996J$1 = j10;
            c14091.f5997J$2 = j8;
            c14091.f5998J$3 = jDelayToNanos;
            c14091.f6003label = i3;
            if (sendChannel2.mo7052send(c1133Unit, c14091) == coroutine_suspended) {
            }
        } else {
            if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j15 = c14091.f5998J$3;
            j3 = c14091.f5997J$2;
            long j16 = c14091.f5996J$1;
            long j17 = c14091.f5995J$0;
            sendChannel3 = (SendChannel) c14091.f6002L$0;
            ResultKt.throwOnFailure(obj);
            c2 = 4;
            j4 = j17;
            jDelayToNanos = j15;
            j10 = j16;
            sendChannel2 = sendChannel3;
            i3 = 2;
            j8 = j3 + jDelayToNanos;
            c1133Unit = C1133Unit.INSTANCE;
            c14091.f6002L$0 = sendChannel2;
            c14091.f5995J$0 = j4;
            c14091.f5996J$1 = j10;
            c14091.f5997J$2 = j8;
            c14091.f5998J$3 = jDelayToNanos;
            c14091.f6003label = i3;
            if (sendChannel2.mo7052send(c1133Unit, c14091) == coroutine_suspended) {
                return coroutine_suspended;
            }
            sendChannel3 = sendChannel2;
            long j18 = j10;
            j7 = jDelayToNanos;
            j5 = j4;
            j6 = j18;
            AbstractTimeSource abstractTimeSource22 = AbstractTimeSourceKt.timeSource;
            jNanoTime = abstractTimeSource22 == null ? abstractTimeSource22.nanoTime() : System.nanoTime();
            c140912 = c14091;
            j9 = j8;
            jCoerceAtLeast = RangesKt.coerceAtLeast(j8 - jNanoTime, 0L);
            if (jCoerceAtLeast == 0 || j7 == 0) {
                jDelayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(jCoerceAtLeast);
                c140912.f6002L$0 = sendChannel3;
                c140912.f5995J$0 = j5;
                c140912.f5996J$1 = j6;
                long j132 = j6;
                c140912.f5997J$2 = j9;
                c140912.f5998J$3 = j7;
                c140912.f5999J$4 = jNanoTime;
                c140912.f6000J$5 = jCoerceAtLeast;
                c2 = 4;
                c140912.f6003label = 4;
                if (C1338DelayKt.m6972delay(jDelayNanosToMillis, c140912) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = j9;
                j4 = j5;
                c14091 = c140912;
                jDelayToNanos = j7;
                j10 = j132;
                sendChannel2 = sendChannel3;
                i3 = 2;
                j8 = j3 + jDelayToNanos;
                c1133Unit = C1133Unit.INSTANCE;
                c14091.f6002L$0 = sendChannel2;
                c14091.f5995J$0 = j4;
                c14091.f5996J$1 = j10;
                c14091.f5997J$2 = j8;
                c14091.f5998J$3 = jDelayToNanos;
                c14091.f6003label = i3;
                if (sendChannel2.mo7052send(c1133Unit, c14091) == coroutine_suspended) {
                }
            } else {
                long j19 = j7 - ((jNanoTime - j9) % j7);
                long j20 = jNanoTime + j19;
                long jDelayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j19);
                c140912.f6002L$0 = sendChannel3;
                c140912.f5995J$0 = j5;
                c140912.f5996J$1 = j6;
                c140912.f5997J$2 = j20;
                c140912.f5998J$3 = j7;
                c140912.f5999J$4 = jNanoTime;
                c140912.f6000J$5 = jCoerceAtLeast;
                c140912.f6001J$6 = j19;
                c = 3;
                c140912.f6003label = 3;
                if (C1338DelayKt.m6972delay(jDelayNanosToMillis2, c140912) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel3;
                c14091 = c140912;
                j3 = j20;
                long j142 = j6;
                j4 = j5;
                jDelayToNanos = j7;
                j10 = j142;
                i3 = 2;
                j8 = j3 + jDelayToNanos;
                c1133Unit = C1133Unit.INSTANCE;
                c14091.f6002L$0 = sendChannel2;
                c14091.f5995J$0 = j4;
                c14091.f5996J$1 = j10;
                c14091.f5997J$2 = j8;
                c14091.f5998J$3 = jDelayToNanos;
                c14091.f6003label = i3;
                if (sendChannel2.mo7052send(c1133Unit, c14091) == coroutine_suspended) {
                }
            }
        }
        jDelayToNanos = EventLoop_commonKt.delayToNanos(j4);
        j8 = j3 + jDelayToNanos;
        c1133Unit = C1133Unit.INSTANCE;
        c14091.f6002L$0 = sendChannel2;
        c14091.f5995J$0 = j4;
        c14091.f5996J$1 = j10;
        c14091.f5997J$2 = j8;
        c14091.f5998J$3 = jDelayToNanos;
        c14091.f6003label = i3;
        if (sendChannel2.mo7052send(c1133Unit, c14091) == coroutine_suspended) {
        }
    }

    @ObsoleteCoroutinesApi
    /* renamed from: ticker */
    public static final ReceiveChannel<C1133Unit> m7158ticker(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return ProduceKt.m7151produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().mo6100plus(coroutineContext), 0, new C14103(tickerMode, j, j2, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return m7158ticker(j, j2, coroutineContext, tickerMode);
    }
}
