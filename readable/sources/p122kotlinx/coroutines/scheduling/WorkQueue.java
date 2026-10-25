package p122kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p131o.AbstractC1852Dt;
import p131o.AbstractC3171XbiWeM;

@Metadata(m4987d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\"\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u0017H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0017H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J$\u0010)\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0005j\u0002`\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020(H\u0002J\n\u0010,\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010-\u001a\u00020&*\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0010X\u0082\u0004R\t\u0010\u0011\u001a\u00020\u0010X\u0082\u0004R\t\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¨\u0006."}, m4988d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", BuildConfig.f24315FLAVOR, "<init>", "()V", "bufferSize", BuildConfig.f24315FLAVOR, "getBufferSize", "()I", "size", "getSize$kotlinx_coroutines_core", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "Lkotlinx/atomicfu/AtomicInt;", "consumerIndex", "blockingTasksInBuffer", "poll", "add", "task", "fair", BuildConfig.f24315FLAVOR, "addLast", "trySteal", BuildConfig.f24315FLAVOR, "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stealWithExclusiveMode", "onlyBlocking", "pollBlocking", "pollWithExclusiveMode", "tryExtractFromTheMiddle", "index", "offloadAllWorkTo", BuildConfig.f24315FLAVOR, "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "tryStealLastScheduled", "pollTo", "queue", "pollBuffer", "decrementIfBlocking", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,246:1\n77#2:247\n77#2:248\n77#2:249\n77#2:252\n77#2:253\n1#3:250\n21#4:251\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n91#1:247\n153#1:248\n176#1:249\n196#1:252\n240#1:253\n196#1:251\n*E\n"})
/* loaded from: classes.dex */
public final class WorkQueue {
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private final AtomicReferenceArray<AbstractRunnableC1582Task> buffer = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");

    public static /* synthetic */ AbstractRunnableC1582Task add$default(WorkQueue workQueue, AbstractRunnableC1582Task abstractRunnableC1582Task, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return workQueue.m7478add(abstractRunnableC1582Task, z);
    }

    /* renamed from: addLast */
    private final AbstractRunnableC1582Task m7476addLast(AbstractRunnableC1582Task task) {
        if (getBufferSize() == 127) {
            return task;
        }
        if (task.taskContext) {
            blockingTasksInBuffer$volatile$FU.incrementAndGet(this);
        }
        int i = producerIndex$volatile$FU.get(this) & 127;
        while (this.buffer.get(i) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i, task);
        producerIndex$volatile$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(AbstractRunnableC1582Task abstractRunnableC1582Task) {
        if (abstractRunnableC1582Task == null || !abstractRunnableC1582Task.taskContext) {
            return;
        }
        blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
    }

    private final /* synthetic */ int getBlockingTasksInBuffer$volatile() {
        return this.blockingTasksInBuffer$volatile;
    }

    private final int getBufferSize() {
        return producerIndex$volatile$FU.get(this) - consumerIndex$volatile$FU.get(this);
    }

    private final /* synthetic */ int getConsumerIndex$volatile() {
        return this.consumerIndex$volatile;
    }

    private final /* synthetic */ Object getLastScheduledTask$volatile() {
        return this.lastScheduledTask$volatile;
    }

    private final /* synthetic */ int getProducerIndex$volatile() {
        return this.producerIndex$volatile;
    }

    private final AbstractRunnableC1582Task pollBuffer() {
        AbstractRunnableC1582Task andSet;
        while (true) {
            int i = consumerIndex$volatile$FU.get(this);
            if (i - producerIndex$volatile$FU.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (consumerIndex$volatile$FU.compareAndSet(this, i, i + 1) && (andSet = this.buffer.getAndSet(i2, null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: pollTo */
    private final boolean m7477pollTo(GlobalQueue queue) {
        AbstractRunnableC1582Task abstractRunnableC1582TaskPollBuffer = pollBuffer();
        if (abstractRunnableC1582TaskPollBuffer == null) {
            return false;
        }
        queue.m7431addLast(abstractRunnableC1582TaskPollBuffer);
        return true;
    }

    private final AbstractRunnableC1582Task pollWithExclusiveMode(boolean onlyBlocking) {
        AbstractRunnableC1582Task abstractRunnableC1582Task;
        do {
            abstractRunnableC1582Task = (AbstractRunnableC1582Task) lastScheduledTask$volatile$FU.get(this);
            if (abstractRunnableC1582Task == null || abstractRunnableC1582Task.taskContext != onlyBlocking) {
                int i = consumerIndex$volatile$FU.get(this);
                int i2 = producerIndex$volatile$FU.get(this);
                while (i != i2) {
                    if (onlyBlocking && blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                        return null;
                    }
                    i2--;
                    AbstractRunnableC1582Task abstractRunnableC1582TaskTryExtractFromTheMiddle = tryExtractFromTheMiddle(i2, onlyBlocking);
                    if (abstractRunnableC1582TaskTryExtractFromTheMiddle != null) {
                        return abstractRunnableC1582TaskTryExtractFromTheMiddle;
                    }
                }
                return null;
            }
        } while (!AbstractC1852Dt.m8064mjFkc(lastScheduledTask$volatile$FU, this, abstractRunnableC1582Task, null));
        return abstractRunnableC1582Task;
    }

    private final /* synthetic */ void setBlockingTasksInBuffer$volatile(int i) {
        this.blockingTasksInBuffer$volatile = i;
    }

    private final /* synthetic */ void setConsumerIndex$volatile(int i) {
        this.consumerIndex$volatile = i;
    }

    private final /* synthetic */ void setLastScheduledTask$volatile(Object obj) {
        this.lastScheduledTask$volatile = obj;
    }

    private final /* synthetic */ void setProducerIndex$volatile(int i) {
        this.producerIndex$volatile = i;
    }

    private final AbstractRunnableC1582Task stealWithExclusiveMode(boolean onlyBlocking) {
        int i = consumerIndex$volatile$FU.get(this);
        int i2 = producerIndex$volatile$FU.get(this);
        while (i != i2) {
            if (onlyBlocking && blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            int i3 = i + 1;
            AbstractRunnableC1582Task abstractRunnableC1582TaskTryExtractFromTheMiddle = tryExtractFromTheMiddle(i, onlyBlocking);
            if (abstractRunnableC1582TaskTryExtractFromTheMiddle != null) {
                return abstractRunnableC1582TaskTryExtractFromTheMiddle;
            }
            i = i3;
        }
        return null;
    }

    private final AbstractRunnableC1582Task tryExtractFromTheMiddle(int index, boolean onlyBlocking) {
        int i = index & 127;
        AbstractRunnableC1582Task abstractRunnableC1582Task = this.buffer.get(i);
        if (abstractRunnableC1582Task == null || abstractRunnableC1582Task.taskContext != onlyBlocking || !AbstractC3171XbiWeM.m10947mjFkc(this.buffer, i, abstractRunnableC1582Task, null)) {
            return null;
        }
        if (onlyBlocking) {
            blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
        }
        return abstractRunnableC1582Task;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.scheduling.Task] */
    private final long tryStealLastScheduled(int stealingMode, C1235Ref.ObjectRef<AbstractRunnableC1582Task> stolenTaskRef) {
        ?? r0;
        do {
            r0 = (AbstractRunnableC1582Task) lastScheduledTask$volatile$FU.get(this);
            if (r0 == 0) {
                return -2L;
            }
            if (((r0.taskContext ? 1 : 2) & stealingMode) == 0) {
                return -2L;
            }
            long jNanoTime = C1583TasksKt.schedulerTimeSource.nanoTime() - r0.submissionTime;
            long j = C1583TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (jNanoTime < j) {
                return j - jNanoTime;
            }
        } while (!AbstractC1852Dt.m8064mjFkc(lastScheduledTask$volatile$FU, this, r0, null));
        stolenTaskRef.f5202element = r0;
        return -1L;
    }

    /* renamed from: add */
    public final AbstractRunnableC1582Task m7478add(AbstractRunnableC1582Task task, boolean fair) {
        if (fair) {
            return m7476addLast(task);
        }
        AbstractRunnableC1582Task abstractRunnableC1582Task = (AbstractRunnableC1582Task) lastScheduledTask$volatile$FU.getAndSet(this, task);
        if (abstractRunnableC1582Task == null) {
            return null;
        }
        return m7476addLast(abstractRunnableC1582Task);
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object obj = lastScheduledTask$volatile$FU.get(this);
        int bufferSize = getBufferSize();
        return obj != null ? bufferSize + 1 : bufferSize;
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        AbstractRunnableC1582Task abstractRunnableC1582Task = (AbstractRunnableC1582Task) lastScheduledTask$volatile$FU.getAndSet(this, null);
        if (abstractRunnableC1582Task != null) {
            globalQueue.m7431addLast(abstractRunnableC1582Task);
        }
        while (m7477pollTo(globalQueue)) {
        }
    }

    /* renamed from: poll */
    public final AbstractRunnableC1582Task m7479poll() {
        AbstractRunnableC1582Task abstractRunnableC1582Task = (AbstractRunnableC1582Task) lastScheduledTask$volatile$FU.getAndSet(this, null);
        return abstractRunnableC1582Task == null ? pollBuffer() : abstractRunnableC1582Task;
    }

    public final AbstractRunnableC1582Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long trySteal(int stealingMode, C1235Ref.ObjectRef<AbstractRunnableC1582Task> stolenTaskRef) {
        T tStealWithExclusiveMode;
        if (stealingMode == 3) {
            tStealWithExclusiveMode = pollBuffer();
        } else {
            tStealWithExclusiveMode = stealWithExclusiveMode(stealingMode == 1);
        }
        if (tStealWithExclusiveMode == 0) {
            return tryStealLastScheduled(stealingMode, stolenTaskRef);
        }
        stolenTaskRef.f5202element = tStealWithExclusiveMode;
        return -1L;
    }
}
