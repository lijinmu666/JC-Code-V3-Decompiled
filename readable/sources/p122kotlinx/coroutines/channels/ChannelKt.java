package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p122kotlinx.coroutines.channels.ChannelResult;

@Metadata(m4987d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\u0003\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\t\u0010\n\u001aV\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022!\u0010\f\u001a\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u000f\u0010\n\u001aX\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0010\u0010\n\u001aX\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\n\u001a>\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¨\u0006\u001b"}, m4988d2 = {"getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onSuccess", "action", "value", BuildConfig.f24315FLAVOR, "onSuccess-WpGqRn0", "onFailure-WpGqRn0", "onClosed", "onClosed-WpGqRn0", "Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ChannelKt {
    /* renamed from: Channel */
    public static final <E> InterfaceC1361Channel<E> m7082Channel(int i, BufferOverflow bufferOverflow, Function1<? super E, C1133Unit> function1) {
        InterfaceC1361Channel<E> bufferedChannel;
        if (i == -2) {
            bufferedChannel = bufferOverflow == BufferOverflow.f5601SUSPEND ? new BufferedChannel<>(InterfaceC1361Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), function1) : new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        } else {
            if (i == -1) {
                if (bufferOverflow == BufferOverflow.f5601SUSPEND) {
                    return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, function1);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i != 0) {
                return i != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.f5601SUSPEND ? new BufferedChannel(i, function1) : new ConflatedBufferedChannel(i, bufferOverflow, function1) : new BufferedChannel(Integer.MAX_VALUE, function1);
            }
            bufferedChannel = bufferOverflow == BufferOverflow.f5601SUSPEND ? new BufferedChannel<>(0, function1) : new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ InterfaceC1361Channel Channel$default(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.f5601SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return m7082Channel(i, bufferOverflow, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m19998getOrElseWpGqRn0(Object obj, Function1<? super Throwable, ? extends T> function1) {
        return obj instanceof ChannelResult.C1363Failed ? function1.mo2237invoke(ChannelResult.m20006exceptionOrNullimpl(obj)) : obj;
    }

    /* renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m19999onClosedWpGqRn0(Object obj, Function1<? super Throwable, C1133Unit> function1) {
        if (obj instanceof ChannelResult.Closed) {
            function1.mo2237invoke(ChannelResult.m20006exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m20000onFailureWpGqRn0(Object obj, Function1<? super Throwable, C1133Unit> function1) {
        if (obj instanceof ChannelResult.C1363Failed) {
            function1.mo2237invoke(ChannelResult.m20006exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m20001onSuccessWpGqRn0(Object obj, Function1<? super T, C1133Unit> function1) {
        if (!(obj instanceof ChannelResult.C1363Failed)) {
            function1.mo2237invoke(obj);
        }
        return obj;
    }

    public static /* synthetic */ InterfaceC1361Channel Channel$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m7081Channel(i);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.4.0, binary compatibility with earlier versions")
    /* renamed from: Channel */
    public static final /* synthetic */ InterfaceC1361Channel m7081Channel(int i) {
        return Channel$default(i, null, null, 6, null);
    }
}
