package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p122kotlinx.coroutines.DelicateCoroutinesApi;
import p122kotlinx.coroutines.internal.SystemPropsKt;
import p122kotlinx.coroutines.p127selects.SelectClause1;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.channels.Channel */
/* loaded from: classes.dex */
public interface InterfaceC1361Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final int BUFFERED = -2;
    public static final int CONFLATED = -1;
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";

    /* renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OPTIONAL_CHANNEL = -3;
    public static final int RENDEZVOUS = 0;
    public static final int UNLIMITED = Integer.MAX_VALUE;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.channels.Channel$DefaultImpls */
    public static final class DefaultImpls {
        @Deprecated
        public static <E> SelectClause1<E> getOnReceiveOrNull(InterfaceC1361Channel<E> interfaceC1361Channel) {
            return InterfaceC1361Channel.super.getOnReceiveOrNull();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
        @Deprecated
        /* renamed from: offer */
        public static <E> boolean m7077offer(InterfaceC1361Channel<E> interfaceC1361Channel, E e) {
            return InterfaceC1361Channel.super.mo7053offer(e);
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
        @Deprecated
        /* renamed from: poll */
        public static <E> E m7078poll(InterfaceC1361Channel<E> interfaceC1361Channel) {
            return (E) InterfaceC1361Channel.super.mo7067poll();
        }

        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
        @LowPriorityInOverloadResolution
        @Deprecated
        public static <E> Object receiveOrNull(InterfaceC1361Channel<E> interfaceC1361Channel, Continuation<? super E> continuation) {
            return InterfaceC1361Channel.super.receiveOrNull(continuation);
        }
    }

    @Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m4988d2 = {"Lkotlinx/coroutines/channels/Channel$Factory;", BuildConfig.f24315FLAVOR, "<init>", "()V", "UNLIMITED", BuildConfig.f24315FLAVOR, "RENDEZVOUS", "CONFLATED", "BUFFERED", "OPTIONAL_CHANNEL", "DEFAULT_BUFFER_PROPERTY_NAME", BuildConfig.f24315FLAVOR, "getDEFAULT_BUFFER_PROPERTY_NAME$annotations", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.channels.Channel$Factory, reason: from kotlin metadata */
    public static final class Companion {
        public static final int BUFFERED = -2;
        public static final int CONFLATED = -1;
        public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
        public static final int OPTIONAL_CHANNEL = -3;
        public static final int RENDEZVOUS = 0;
        public static final int UNLIMITED = Integer.MAX_VALUE;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private Companion() {
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void getDEFAULT_BUFFER_PROPERTY_NAME$annotations() {
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return CHANNEL_DEFAULT_CAPACITY;
        }
    }
}
