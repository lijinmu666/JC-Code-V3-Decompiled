package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowOperatorImpl;
import p122kotlinx.coroutines.p125flow.internal.FusibleFlow;

@Metadata(m4987d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a$\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u000e¨\u0006\u000f"}, m4988d2 = {"buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", BuildConfig.f24315FLAVOR, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "conflate", "flowOn", "context", "Lkotlin/coroutines/CoroutineContext;", "cancellable", "checkFlowContext", BuildConfig.f24315FLAVOR, "checkFlowContext$FlowKt__ContextKt", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ContextKt {
    /* renamed from: buffer */
    public static final <T> InterfaceC1426Flow<T> m7276buffer(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i, BufferOverflow bufferOverflow) {
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        }
        if (i == -1 && bufferOverflow != BufferOverflow.f5601SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i = 0;
        }
        int i2 = i;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (interfaceC1426Flow instanceof FusibleFlow) {
            return FusibleFlow.fuse$default((FusibleFlow) interfaceC1426Flow, null, i2, bufferOverflow2, 1, null);
        }
        return new ChannelFlowOperatorImpl(interfaceC1426Flow, null, i2, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ InterfaceC1426Flow buffer$default(InterfaceC1426Flow interfaceC1426Flow, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.f5601SUSPEND;
        }
        return C1427FlowKt.m7196buffer(interfaceC1426Flow, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> InterfaceC1426Flow<T> cancellable(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return interfaceC1426Flow instanceof CancellableFlow ? interfaceC1426Flow : new CancellableFlowImpl(interfaceC1426Flow);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        if (coroutineContext.mo6098get(InterfaceC1342Job.INSTANCE) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }

    public static final <T> InterfaceC1426Flow<T> conflate(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return buffer$default(interfaceC1426Flow, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: flowOn */
    public static final <T> InterfaceC1426Flow<T> m7277flowOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            return interfaceC1426Flow;
        }
        if (interfaceC1426Flow instanceof FusibleFlow) {
            return FusibleFlow.fuse$default((FusibleFlow) interfaceC1426Flow, coroutineContext, 0, null, 6, null);
        }
        return new ChannelFlowOperatorImpl(interfaceC1426Flow, coroutineContext, 0, null, 12, null);
    }

    public static /* synthetic */ InterfaceC1426Flow buffer$default(InterfaceC1426Flow interfaceC1426Flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return m7275buffer(interfaceC1426Flow, i);
    }

    @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.4.0, binary compatibility with earlier versions")
    /* renamed from: buffer */
    public static final /* synthetic */ InterfaceC1426Flow m7275buffer(InterfaceC1426Flow interfaceC1426Flow, int i) {
        return buffer$default(interfaceC1426Flow, i, null, 2, null);
    }
}
