package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p122kotlinx.coroutines.ThreadContextElement;
import p122kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(m4987d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m4988d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "threadContextElements", "context", "Lkotlin/coroutines/CoroutineContext;", "updateThreadContext", "countOrElement", "restoreThreadContext", BuildConfig.f24315FLAVOR, "oldState", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ThreadContextKt {

    @JvmField
    public static final C1578Symbol NO_THREAD_ELEMENTS = new C1578Symbol("NO_THREAD_ELEMENTS");
    private static final Function2<Object, CoroutineContext.InterfaceC1197Element, Object> countAll = new Function2() { // from class: o.q8
        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public final Object mo2167invoke(Object obj, Object obj2) {
            return ThreadContextKt.countAll$lambda$0(obj, (CoroutineContext.InterfaceC1197Element) obj2);
        }
    };

    /* renamed from: findOne */
    private static final Function2<ThreadContextElement<?>, CoroutineContext.InterfaceC1197Element, ThreadContextElement<?>> f7211findOne = new Function2() { // from class: o.r8
        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public final Object mo2167invoke(Object obj, Object obj2) {
            return ThreadContextKt.findOne$lambda$0((ThreadContextElement) obj, (CoroutineContext.InterfaceC1197Element) obj2);
        }
    };
    private static final Function2<ThreadState, CoroutineContext.InterfaceC1197Element, ThreadState> updateState = new Function2() { // from class: kotlinx.coroutines.internal.mjFkc
        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public final Object mo2167invoke(Object obj, Object obj2) {
            return ThreadContextKt.updateState$lambda$0((ThreadState) obj, (CoroutineContext.InterfaceC1197Element) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object countAll$lambda$0(Object obj, CoroutineContext.InterfaceC1197Element interfaceC1197Element) {
        if (!(interfaceC1197Element instanceof ThreadContextElement)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? interfaceC1197Element : Integer.valueOf(iIntValue + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadContextElement<?> findOne$lambda$0(ThreadContextElement<?> threadContextElement, CoroutineContext.InterfaceC1197Element interfaceC1197Element) {
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (interfaceC1197Element instanceof ThreadContextElement) {
            return (ThreadContextElement) interfaceC1197Element;
        }
        return null;
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).m7466restore(coroutineContext);
            return;
        }
        Object objMo6097fold = coroutineContext.mo6097fold(null, f7211findOne);
        Intrinsics.checkNotNull(objMo6097fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) objMo6097fold).restoreThreadContext(coroutineContext, obj);
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object objMo6097fold = coroutineContext.mo6097fold(0, countAll);
        Intrinsics.checkNotNull(objMo6097fold);
        return objMo6097fold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadState updateState$lambda$0(ThreadState threadState, CoroutineContext.InterfaceC1197Element interfaceC1197Element) {
        if (interfaceC1197Element instanceof ThreadContextElement) {
            ThreadContextElement<?> threadContextElement = (ThreadContextElement) interfaceC1197Element;
            threadState.m7465append(threadContextElement, threadContextElement.updateThreadContext(threadState.context));
        }
        return threadState;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.mo6097fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
