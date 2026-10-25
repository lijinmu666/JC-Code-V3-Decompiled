package p122kotlinx.coroutines.p125flow;

import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CancellableContinuationImpl;
import p122kotlinx.coroutines.internal.Concurrent_commonKt;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowKt;
import p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowSlot;
import p131o.AbstractC5024zd;

@Metadata(m4987d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J'\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000e2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0015R$\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0016"}, m4988d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "<init>", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "allocateLocked", BuildConfig.f24315FLAVOR, "flow", "freeLocked", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 Concurrent.common.kt\nkotlinx/coroutines/internal/Concurrent_commonKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,433:1\n34#2,2:434\n1#3:436\n433#4,10:437\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n280#1:434,2\n303#1:437,10\n*E\n"})
/* loaded from: classes.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    private final AtomicReference<Object> _state = new AtomicReference<>(null);

    public final Object awaitPending(Continuation<? super C1133Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (!AbstractC5024zd.m14125mjFkc(this._state, StateFlowKt.f7046NONE, cancellableContinuationImpl)) {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    public final void makePending() {
        AtomicReference<Object> atomicReference = this._state;
        while (true) {
            Object value = Concurrent_commonKt.getValue(atomicReference);
            if (value == null || value == StateFlowKt.f7047PENDING) {
                return;
            }
            if (value == StateFlowKt.f7046NONE) {
                if (AbstractC5024zd.m14125mjFkc(this._state, value, StateFlowKt.f7047PENDING)) {
                    return;
                }
            } else if (AbstractC5024zd.m14125mjFkc(this._state, value, StateFlowKt.f7046NONE)) {
                ((CancellableContinuationImpl) value).resumeWith(C1124Result.m18546constructorimpl(C1133Unit.INSTANCE));
                return;
            }
        }
    }

    public final boolean takePending() {
        Object andSet = this._state.getAndSet(StateFlowKt.f7046NONE);
        Intrinsics.checkNotNull(andSet);
        return andSet == StateFlowKt.f7047PENDING;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> flow) {
        if (Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        Concurrent_commonKt.setValue(this._state, StateFlowKt.f7046NONE);
        return true;
    }

    @Override // p122kotlinx.coroutines.p125flow.internal.AbstractSharedFlowSlot
    public Continuation<C1133Unit>[] freeLocked(StateFlowImpl<?> flow) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
