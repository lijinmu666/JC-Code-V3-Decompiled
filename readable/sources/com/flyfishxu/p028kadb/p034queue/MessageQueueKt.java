package com.flyfishxu.p028kadb.p034queue;

import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.InlineMarker;

@Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0082\b\u001a)\u0010\u0006\u001a\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¨\u0006\b"}, m4988d2 = {"lock", BuildConfig.f24315FLAVOR, "T", "Ljava/util/concurrent/locks/ReentrantLock;", "body", "Lkotlin/Function0;", "tryLock", "elseBody", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class MessageQueueKt {
    /* renamed from: lock */
    private static final <T> void m2285lock(ReentrantLock reentrantLock, Function0<? extends T> function0) {
        reentrantLock.lock();
        try {
            function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            if (reentrantLock.isHeldByCurrentThread()) {
                reentrantLock.unlock();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    /* renamed from: tryLock */
    private static final void m2286tryLock(ReentrantLock reentrantLock, Function0<C1133Unit> function0, Function0<C1133Unit> function02) {
        if (!reentrantLock.tryLock()) {
            function02.mo4323invoke();
            return;
        }
        try {
            function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            if (reentrantLock.isHeldByCurrentThread()) {
                reentrantLock.unlock();
            }
            InlineMarker.finallyEnd(1);
        }
    }
}
