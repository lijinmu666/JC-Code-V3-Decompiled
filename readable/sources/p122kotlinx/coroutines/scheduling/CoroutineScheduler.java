package p122kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.AbstractTimeSource;
import p122kotlinx.coroutines.AbstractTimeSourceKt;
import p122kotlinx.coroutines.DebugStringsKt;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.internal.ResizableAtomicArray;

@Metadata(m4987d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u0012\u0010\u001b\u001a\u00020\u00102\n\u0010\u0017\u001a\u00060\u0018R\u00020\u0000J\u000e\u0010\u001c\u001a\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\u0014\u0010\u001d\u001a\u00020\u00042\n\u0010\u0017\u001a\u00060\u0018R\u00020\u0000H\u0002J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0082\bJ\u0011\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0082\bJ\u0011\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0086\bJ\t\u0010(\u001a\u00020\u0004H\u0082\bJ\t\u0010)\u001a\u00020\u0004H\u0082\bJ\t\u0010*\u001a\u00020\u0007H\u0082\bJ\t\u0010+\u001a\u00020\u0016H\u0082\bJ\t\u0010,\u001a\u00020\u0010H\u0082\bJ\t\u0010-\u001a\u00020\u0007H\u0082\bJ\u0014\u00102\u001a\u00020\u00162\n\u00103\u001a\u000604j\u0002`5H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\u000e\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0007J*\u00109\u001a\u00020\u00162\n\u0010:\u001a\u000604j\u0002`52\f\b\u0002\u0010;\u001a\u00060\u0010j\u0002`<2\b\b\u0002\u0010=\u001a\u00020\u0010J\u001e\u0010>\u001a\u00020\u00122\n\u0010:\u001a\u000604j\u0002`52\n\u0010;\u001a\u00060\u0010j\u0002`<J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0007H\u0002J\u0006\u0010A\u001a\u00020\u0016J\u0012\u0010B\u001a\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u0007H\u0002J\b\u0010C\u001a\u00020\u0010H\u0002J\b\u0010D\u001a\u00020\u0004H\u0002J$\u0010E\u001a\u0004\u0018\u00010\u0012*\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0010H\u0002J\u000e\u0010F\u001a\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\b\u0010G\u001a\u00020\tH\u0016J\u000e\u0010H\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0013\u001a\u00020\u0014X\u0082\u0004R\u001a\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u001f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010 \u001a\u00020\u0014X\u0082\u0004R\u0015\u0010!\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\t\u0010.\u001a\u00020/X\u0082\u0004R\u0011\u00100\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006L"}, m4988d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", BuildConfig.f24315FLAVOR, "maxPoolSize", "idleWorkerKeepAliveNs", BuildConfig.f24315FLAVOR, "schedulerName", BuildConfig.f24315FLAVOR, "<init>", "(IIJLjava/lang/String;)V", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "addToGlobalQueue", BuildConfig.f24315FLAVOR, "task", "Lkotlinx/coroutines/scheduling/Task;", "parkedWorkersStack", "Lkotlinx/atomicfu/AtomicLong;", "parkedWorkersStackTopUpdate", BuildConfig.f24315FLAVOR, "worker", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "oldIndex", "newIndex", "parkedWorkersStackPush", "parkedWorkersStackPop", "parkedWorkersStackNextIndex", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "controlState", "createdWorkers", "getCreatedWorkers", "()I", "availableCpuPermits", "getAvailableCpuPermits", "state", "blockingTasks", "incrementCreatedWorkers", "decrementCreatedWorkers", "incrementBlockingTasks", "decrementBlockingTasks", "tryAcquireCpuPermit", "releaseCpuPermit", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "isTerminated", "()Z", "execute", "command", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "close", "shutdown", "timeout", "dispatch", "block", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "createTask", "signalBlockingWork", "stateSnapshot", "signalCpuWork", "tryCreateWorker", "tryUnpark", "createNewWorker", "submitToLocalQueue", "currentWorker", "toString", "runSafely", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1011:1\n286#1:1014\n284#1:1015\n284#1:1016\n286#1:1017\n281#1:1020\n282#1,5:1021\n292#1:1027\n284#1:1028\n285#1:1029\n284#1:1032\n285#1:1033\n281#1:1034\n289#1:1035\n284#1:1036\n284#1:1039\n285#1:1040\n286#1:1041\n77#2:1012\n77#2:1026\n77#2:1037\n1#3:1013\n26#4:1018\n26#4:1030\n16#5:1019\n16#5:1031\n619#6:1038\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n282#1:1014\n289#1:1015\n290#1:1016\n299#1:1017\n348#1:1020\n377#1:1021,5\n400#1:1027\n444#1:1028\n445#1:1029\n481#1:1032\n482#1:1033\n488#1:1034\n497#1:1035\n497#1:1036\n578#1:1039\n579#1:1040\n580#1:1041\n120#1:1012\n397#1:1026\n514#1:1037\n348#1:1018\n477#1:1030\n348#1:1019\n477#1:1031\n521#1:1038\n*E\n"})
/* loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;

    /* renamed from: CLAIMED */
    private static final int f7221CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;

    /* renamed from: PARKED */
    private static final int f7222PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;

    @JvmField
    public final int corePoolSize;

    @JvmField
    public final GlobalQueue globalBlockingQueue;

    @JvmField
    public final GlobalQueue globalCpuQueue;

    @JvmField
    public final long idleWorkerKeepAliveNs;

    @JvmField
    public final int maxPoolSize;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @JvmField
    public final String schedulerName;

    @JvmField
    public final ResizableAtomicArray<C1581Worker> workers;
    private static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    @JvmField
    public static final C1578Symbol NOT_IN_STACK = new C1578Symbol("NOT_IN_STACK");

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.m7474values().length];
            try {
                iArr[WorkerState.f7228PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.f7227DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m4988d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class WorkerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ WorkerState[] f7226$VALUES;
        public static final WorkerState CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
        public static final WorkerState BLOCKING = new WorkerState("BLOCKING", 1);

        /* renamed from: PARKING */
        public static final WorkerState f7228PARKING = new WorkerState("PARKING", 2);

        /* renamed from: DORMANT */
        public static final WorkerState f7227DORMANT = new WorkerState("DORMANT", 3);
        public static final WorkerState TERMINATED = new WorkerState("TERMINATED", 4);

        /* renamed from: $values */
        private static final /* synthetic */ WorkerState[] m7472$values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, f7228PARKING, f7227DORMANT, TERMINATED};
        }

        static {
            WorkerState[] workerStateArrM7472$values = m7472$values();
            f7226$VALUES = workerStateArrM7472$values;
            $ENTRIES = EnumEntriesKt.enumEntries(workerStateArrM7472$values);
        }

        private WorkerState(String str, int i) {
        }

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static WorkerState m7473valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        /* renamed from: values */
        public static WorkerState[] m7474values() {
            return (WorkerState[]) f7226$VALUES.clone();
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (i < 1) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j > 0) {
            this.globalCpuQueue = new GlobalQueue();
            this.globalBlockingQueue = new GlobalQueue();
            this.workers = new ResizableAtomicArray<>((i + 1) * 2);
            this.controlState$volatile = i << 42;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
    }

    private final boolean addToGlobalQueue(AbstractRunnableC1582Task task) {
        return task.taskContext ? this.globalBlockingQueue.m7431addLast(task) : this.globalCpuQueue.m7431addLast(task);
    }

    private final int blockingTasks(long state) {
        return (int) ((state & BLOCKING_MASK) >> 21);
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j = controlState$volatile$FU.get(this);
                int i = (int) (j & 2097151);
                int iCoerceAtLeast = RangesKt.coerceAtLeast(i - ((int) ((j & BLOCKING_MASK) >> 21)), 0);
                if (iCoerceAtLeast >= this.corePoolSize) {
                    return 0;
                }
                if (i >= this.maxPoolSize) {
                    return 0;
                }
                int i2 = ((int) (getControlState$volatile$FU().get(this) & 2097151)) + 1;
                if (i2 <= 0 || this.workers.m7446get(i2) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                C1581Worker c1581Worker = new C1581Worker(this, i2);
                this.workers.setSynchronized(i2, c1581Worker);
                if (i2 != ((int) (2097151 & controlState$volatile$FU.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i3 = iCoerceAtLeast + 1;
                c1581Worker.start();
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final int createdWorkers(long state) {
        return (int) (state & 2097151);
    }

    private final C1581Worker currentWorker() {
        Thread threadCurrentThread = Thread.currentThread();
        C1581Worker c1581Worker = threadCurrentThread instanceof C1581Worker ? (C1581Worker) threadCurrentThread : null;
        if (c1581Worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return c1581Worker;
    }

    private final void decrementBlockingTasks() {
        getControlState$volatile$FU().addAndGet(this, PARKED_VERSION_MASK);
    }

    private final int decrementCreatedWorkers() {
        return (int) (getControlState$volatile$FU().getAndDecrement(this) & 2097151);
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.dispatch(runnable, z, z2);
    }

    private final int getAvailableCpuPermits() {
        return (int) ((controlState$volatile$FU.get(this) & CPU_PERMITS_MASK) >> 42);
    }

    private final /* synthetic */ long getControlState$volatile() {
        return this.controlState$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getControlState$volatile$FU() {
        return controlState$volatile$FU;
    }

    private final int getCreatedWorkers() {
        return (int) (getControlState$volatile$FU().get(this) & 2097151);
    }

    private final /* synthetic */ long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private final /* synthetic */ int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private final long incrementBlockingTasks() {
        return controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$volatile$FU.incrementAndGet(this) & 2097151);
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater atomicLongFieldUpdater, Object obj, Function1<? super Long, C1133Unit> function1) {
        while (true) {
            function1.mo2237invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final int parkedWorkersStackNextIndex(C1581Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            C1581Worker c1581Worker = (C1581Worker) nextParkedWorker;
            int indexInArray = c1581Worker.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = c1581Worker.getNextParkedWorker();
        }
        return -1;
    }

    private final C1581Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            C1581Worker c1581WorkerM7446get = this.workers.m7446get((int) (2097151 & j));
            if (c1581WorkerM7446get == null) {
                return null;
            }
            long j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            int iParkedWorkersStackNextIndex = parkedWorkersStackNextIndex(c1581WorkerM7446get);
            if (iParkedWorkersStackNextIndex >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, j, iParkedWorkersStackNextIndex | j2)) {
                c1581WorkerM7446get.setNextParkedWorker(NOT_IN_STACK);
                return c1581WorkerM7446get;
            }
        }
    }

    private final long releaseCpuPermit() {
        return getControlState$volatile$FU().addAndGet(this, 4398046511104L);
    }

    private final /* synthetic */ void setControlState$volatile(long j) {
        this.controlState$volatile = j;
    }

    private final /* synthetic */ void setParkedWorkersStack$volatile(long j) {
        this.parkedWorkersStack$volatile = j;
    }

    private final /* synthetic */ void set_isTerminated$volatile(int i) {
        this._isTerminated$volatile = i;
    }

    private final void signalBlockingWork(long stateSnapshot) {
        if (tryUnpark() || tryCreateWorker(stateSnapshot)) {
            return;
        }
        tryUnpark();
    }

    private final AbstractRunnableC1582Task submitToLocalQueue(C1581Worker c1581Worker, AbstractRunnableC1582Task abstractRunnableC1582Task, boolean z) {
        WorkerState workerState;
        if (c1581Worker == null || (workerState = c1581Worker.state) == WorkerState.TERMINATED) {
            return abstractRunnableC1582Task;
        }
        if (!abstractRunnableC1582Task.taskContext && workerState == WorkerState.BLOCKING) {
            return abstractRunnableC1582Task;
        }
        c1581Worker.mayHaveLocalTasks = true;
        return c1581Worker.localQueue.m7478add(abstractRunnableC1582Task, z);
    }

    private final boolean tryAcquireCpuPermit() {
        long j;
        AtomicLongFieldUpdater controlState$volatile$FU2 = getControlState$volatile$FU();
        do {
            j = controlState$volatile$FU2.get(this);
            if (((int) ((CPU_PERMITS_MASK & j) >> 42)) == 0) {
                return false;
            }
        } while (!getControlState$volatile$FU().compareAndSet(this, j, j - 4398046511104L));
        return true;
    }

    private final boolean tryCreateWorker(long state) {
        if (RangesKt.coerceAtLeast(((int) (2097151 & state)) - ((int) ((state & BLOCKING_MASK) >> 21)), 0) < this.corePoolSize) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = controlState$volatile$FU.get(coroutineScheduler);
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    private final boolean tryUnpark() {
        C1581Worker c1581WorkerParkedWorkersStackPop;
        do {
            c1581WorkerParkedWorkersStackPop = parkedWorkersStackPop();
            if (c1581WorkerParkedWorkersStackPop == null) {
                return false;
            }
        } while (!C1581Worker.workerCtl$volatile$FU.compareAndSet(c1581WorkerParkedWorkersStackPop, -1, 0));
        LockSupport.unpark(c1581WorkerParkedWorkersStackPop);
        return true;
    }

    public final int availableCpuPermits(long state) {
        return (int) ((state & CPU_PERMITS_MASK) >> 42);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        shutdown(10000L);
    }

    public final AbstractRunnableC1582Task createTask(Runnable block, boolean taskContext) {
        long jNanoTime = C1583TasksKt.schedulerTimeSource.nanoTime();
        if (!(block instanceof AbstractRunnableC1582Task)) {
            return C1583TasksKt.m7475asTask(block, jNanoTime, taskContext);
        }
        AbstractRunnableC1582Task abstractRunnableC1582Task = (AbstractRunnableC1582Task) block;
        abstractRunnableC1582Task.submissionTime = jNanoTime;
        abstractRunnableC1582Task.taskContext = taskContext;
        return abstractRunnableC1582Task;
    }

    public final void dispatch(Runnable block, boolean taskContext, boolean fair) {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
        if (abstractTimeSource != null) {
            abstractTimeSource.trackTask();
        }
        AbstractRunnableC1582Task abstractRunnableC1582TaskCreateTask = createTask(block, taskContext);
        boolean z = abstractRunnableC1582TaskCreateTask.taskContext;
        long jAddAndGet = z ? controlState$volatile$FU.addAndGet(this, PARKED_VERSION_INC) : 0L;
        AbstractRunnableC1582Task abstractRunnableC1582TaskSubmitToLocalQueue = submitToLocalQueue(currentWorker(), abstractRunnableC1582TaskCreateTask, fair);
        if (abstractRunnableC1582TaskSubmitToLocalQueue != null && !addToGlobalQueue(abstractRunnableC1582TaskSubmitToLocalQueue)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (z) {
            signalBlockingWork(jAddAndGet);
        } else {
            signalCpuWork();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        dispatch$default(this, command, false, false, 6, null);
    }

    public final boolean isTerminated() {
        return _isTerminated$volatile$FU.get(this) == 1;
    }

    public final boolean parkedWorkersStackPush(C1581Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.m7446get((int) (2097151 & j)));
        } while (!parkedWorkersStack$volatile$FU.compareAndSet(this, j, j2 | indexInArray));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(C1581Worker worker, int oldIndex, int newIndex) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int iParkedWorkersStackNextIndex = (int) (2097151 & j);
            long j2 = (PARKED_VERSION_INC + j) & PARKED_VERSION_MASK;
            if (iParkedWorkersStackNextIndex == oldIndex) {
                iParkedWorkersStackNextIndex = newIndex == 0 ? parkedWorkersStackNextIndex(worker) : newIndex;
            }
            if (iParkedWorkersStackNextIndex >= 0 && parkedWorkersStack$volatile$FU.compareAndSet(this, j, j2 | iParkedWorkersStackNextIndex)) {
                return;
            }
        }
    }

    public final void runSafely(AbstractRunnableC1582Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource == null) {
                }
            } finally {
                AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                if (abstractTimeSource2 != null) {
                    abstractTimeSource2.unTrackTask();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void shutdown(long timeout) throws InterruptedException {
        int i;
        AbstractRunnableC1582Task abstractRunnableC1582TaskRemoveFirstOrNull;
        if (_isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            C1581Worker c1581WorkerCurrentWorker = currentWorker();
            synchronized (this.workers) {
                i = (int) (getControlState$volatile$FU().get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    C1581Worker c1581WorkerM7446get = this.workers.m7446get(i2);
                    Intrinsics.checkNotNull(c1581WorkerM7446get);
                    C1581Worker c1581Worker = c1581WorkerM7446get;
                    if (c1581Worker != c1581WorkerCurrentWorker) {
                        while (c1581Worker.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(c1581Worker);
                            c1581Worker.join(timeout);
                        }
                        c1581Worker.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.globalBlockingQueue.m7432close();
            this.globalCpuQueue.m7432close();
            while (true) {
                if (c1581WorkerCurrentWorker == null) {
                    abstractRunnableC1582TaskRemoveFirstOrNull = this.globalCpuQueue.removeFirstOrNull();
                    if (abstractRunnableC1582TaskRemoveFirstOrNull == null && (abstractRunnableC1582TaskRemoveFirstOrNull = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                        break;
                    }
                } else {
                    abstractRunnableC1582TaskRemoveFirstOrNull = c1581WorkerCurrentWorker.findTask(true);
                    if (abstractRunnableC1582TaskRemoveFirstOrNull != null) {
                        continue;
                    }
                }
                runSafely(abstractRunnableC1582TaskRemoveFirstOrNull);
            }
            if (c1581WorkerCurrentWorker != null) {
                c1581WorkerCurrentWorker.tryReleaseCpu(WorkerState.TERMINATED);
            }
            parkedWorkersStack$volatile$FU.set(this, 0L);
            controlState$volatile$FU.set(this, 0L);
        }
    }

    public final void signalCpuWork() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iCurrentLength = this.workers.currentLength();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iCurrentLength; i6++) {
            C1581Worker c1581WorkerM7446get = this.workers.m7446get(i6);
            if (c1581WorkerM7446get != null) {
                int size$kotlinx_coroutines_core = c1581WorkerM7446get.localQueue.getSize$kotlinx_coroutines_core();
                int i7 = WhenMappings.$EnumSwitchMapping$0[c1581WorkerM7446get.state.ordinal()];
                if (i7 == 1) {
                    i3++;
                } else if (i7 == 2) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(size$kotlinx_coroutines_core);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i7 == 3) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(size$kotlinx_coroutines_core);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i7 == 4) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(size$kotlinx_coroutines_core);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (i7 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i5++;
                }
            }
        }
        long j = controlState$volatile$FU.get(this);
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.m7433getSize() + ", global blocking queue size = " + this.globalBlockingQueue.m7433getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((BLOCKING_MASK & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((CPU_PERMITS_MASK & j) >> 42))) + "}]";
    }

    @Metadata(m4987d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0002J\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0014H\u0002J\u000e\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\u0010\u00104\u001a\u0004\u0018\u00010\u00142\u0006\u0010)\u001a\u00020$J\n\u00105\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\u00142\u0006\u00107\u001a\u00020$H\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u00109\u001a\u0004\u0018\u00010\u00142\n\u0010:\u001a\u00060\u0005j\u0002`;H\u0002R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\r8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, m4988d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "index", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "terminationDeadline", BuildConfig.f24315FLAVOR, "nextParkedWorker", BuildConfig.f24315FLAVOR, "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "tryAcquireCpuPermit", BuildConfig.f24315FLAVOR, "tryReleaseCpu", "newState", "run", BuildConfig.f24315FLAVOR, "mayHaveLocalTasks", "runWorker", "isIo", "tryPark", "inStack", "executeTask", "task", "nextInt", "upperBound", "park", "tryTerminateWorker", "findTask", "findBlockingTask", "findAnyTask", "scanLocalQueue", "pollGlobalQueues", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1011:1\n298#2,2:1012\n286#2:1014\n300#2,4:1015\n305#2:1019\n295#2,2:1023\n281#2:1027\n290#2:1028\n284#2:1029\n281#2:1030\n1#3:1020\n77#4:1021\n77#4:1022\n26#5:1025\n16#6:1026\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n684#1:1012,2\n684#1:1014\n684#1:1015,4\n699#1:1019\n799#1:1023,2\n850#1:1027\n876#1:1028\n876#1:1029\n941#1:1030\n790#1:1021\n793#1:1022\n846#1:1025\n846#1:1026\n*E\n"})
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$Worker */
    public final class C1581Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(C1581Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;

        @JvmField
        public final WorkQueue localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;

        @JvmField
        public WorkerState state;
        private final C1235Ref.ObjectRef<AbstractRunnableC1582Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private C1581Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new C1235Ref.ObjectRef<>();
            this.state = WorkerState.f7227DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int iNanoTime = (int) System.nanoTime();
            this.rngState = iNanoTime == 0 ? 42 : iNanoTime;
        }

        private final void executeTask(AbstractRunnableC1582Task task) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.f7228PARKING) {
                this.state = WorkerState.BLOCKING;
            }
            if (!task.taskContext) {
                CoroutineScheduler.this.runSafely(task);
                return;
            }
            if (tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
            CoroutineScheduler.this.runSafely(task);
            CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.f7227DORMANT;
            }
        }

        private final AbstractRunnableC1582Task findAnyTask(boolean scanLocalQueue) {
            AbstractRunnableC1582Task abstractRunnableC1582TaskPollGlobalQueues;
            AbstractRunnableC1582Task abstractRunnableC1582TaskPollGlobalQueues2;
            if (scanLocalQueue) {
                boolean z = m7471nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z && (abstractRunnableC1582TaskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return abstractRunnableC1582TaskPollGlobalQueues2;
                }
                AbstractRunnableC1582Task abstractRunnableC1582TaskM7479poll = this.localQueue.m7479poll();
                if (abstractRunnableC1582TaskM7479poll != null) {
                    return abstractRunnableC1582TaskM7479poll;
                }
                if (!z && (abstractRunnableC1582TaskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return abstractRunnableC1582TaskPollGlobalQueues;
                }
            } else {
                AbstractRunnableC1582Task abstractRunnableC1582TaskPollGlobalQueues3 = pollGlobalQueues();
                if (abstractRunnableC1582TaskPollGlobalQueues3 != null) {
                    return abstractRunnableC1582TaskPollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final AbstractRunnableC1582Task findBlockingTask() {
            AbstractRunnableC1582Task abstractRunnableC1582TaskPollBlocking = this.localQueue.pollBlocking();
            if (abstractRunnableC1582TaskPollBlocking != null) {
                return abstractRunnableC1582TaskPollBlocking;
            }
            AbstractRunnableC1582Task abstractRunnableC1582TaskRemoveFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return abstractRunnableC1582TaskRemoveFirstOrNull == null ? trySteal(1) : abstractRunnableC1582TaskRemoveFirstOrNull;
        }

        /* renamed from: inStack */
        private final boolean m7467inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        /* renamed from: park */
        private final void m7468park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final AbstractRunnableC1582Task pollGlobalQueues() {
            if (m7471nextInt(2) == 0) {
                AbstractRunnableC1582Task abstractRunnableC1582TaskRemoveFirstOrNull = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                return abstractRunnableC1582TaskRemoveFirstOrNull != null ? abstractRunnableC1582TaskRemoveFirstOrNull : CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            AbstractRunnableC1582Task abstractRunnableC1582TaskRemoveFirstOrNull2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return abstractRunnableC1582TaskRemoveFirstOrNull2 != null ? abstractRunnableC1582TaskRemoveFirstOrNull2 : CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    AbstractRunnableC1582Task abstractRunnableC1582TaskFindTask = findTask(this.mayHaveLocalTasks);
                    if (abstractRunnableC1582TaskFindTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(abstractRunnableC1582TaskFindTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            m7469tryPark();
                        } else if (z) {
                            tryReleaseCpu(WorkerState.f7228PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            long j;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater controlState$volatile$FU = CoroutineScheduler.getControlState$volatile$FU();
            do {
                j = controlState$volatile$FU.get(coroutineScheduler);
                if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & j) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.getControlState$volatile$FU().compareAndSet(coroutineScheduler, j, j - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        /* renamed from: tryPark */
        private final void m7469tryPark() {
            if (!m7467inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (m7467inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.f7228PARKING);
                Thread.interrupted();
                m7468park();
            }
        }

        private final AbstractRunnableC1582Task trySteal(int stealingMode) {
            int i = (int) (CoroutineScheduler.getControlState$volatile$FU().get(CoroutineScheduler.this) & 2097151);
            if (i < 2) {
                return null;
            }
            int iM7471nextInt = m7471nextInt(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                iM7471nextInt++;
                if (iM7471nextInt > i) {
                    iM7471nextInt = 1;
                }
                C1581Worker c1581WorkerM7446get = coroutineScheduler.workers.m7446get(iM7471nextInt);
                if (c1581WorkerM7446get != null && c1581WorkerM7446get != this) {
                    long jTrySteal = c1581WorkerM7446get.localQueue.trySteal(stealingMode, this.stolenTask);
                    if (jTrySteal == -1) {
                        C1235Ref.ObjectRef<AbstractRunnableC1582Task> objectRef = this.stolenTask;
                        AbstractRunnableC1582Task abstractRunnableC1582Task = objectRef.f5202element;
                        objectRef.f5202element = null;
                        return abstractRunnableC1582Task;
                    }
                    if (jTrySteal > 0) {
                        jMin = Math.min(jMin, jTrySteal);
                    }
                }
            }
            if (jMin == LongCompanionObject.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.getControlState$volatile$FU().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.corePoolSize) {
                        return;
                    }
                    if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                        int i = this.indexInArray;
                        setIndexInArray(0);
                        coroutineScheduler.parkedWorkersStackTopUpdate(this, i, 0);
                        int andDecrement = (int) (CoroutineScheduler.getControlState$volatile$FU().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i) {
                            C1581Worker c1581WorkerM7446get = coroutineScheduler.workers.m7446get(andDecrement);
                            Intrinsics.checkNotNull(c1581WorkerM7446get);
                            C1581Worker c1581Worker = c1581WorkerM7446get;
                            coroutineScheduler.workers.setSynchronized(i, c1581Worker);
                            c1581Worker.setIndexInArray(i);
                            coroutineScheduler.parkedWorkersStackTopUpdate(c1581Worker, andDecrement, i);
                        }
                        coroutineScheduler.workers.setSynchronized(andDecrement, null);
                        C1133Unit c1133Unit = C1133Unit.INSTANCE;
                        this.state = WorkerState.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final AbstractRunnableC1582Task findTask(boolean mayHaveLocalTasks) {
            return tryAcquireCpuPermit() ? findAnyTask(mayHaveLocalTasks) : findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        /* renamed from: isIo */
        public final boolean m7470isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        /* renamed from: nextInt */
        public final int m7471nextInt(int upperBound) {
            int i = this.rngState;
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >> 17);
            int i4 = i3 ^ (i3 << 5);
            this.rngState = i4;
            int i5 = upperBound - 1;
            return (i5 & upperBound) == 0 ? i5 & i4 : (Integer.MAX_VALUE & i4) % upperBound;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final /* synthetic */ void setWorkerCtl$volatile(int i) {
            this.workerCtl$volatile = i;
        }

        public final boolean tryReleaseCpu(WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z = workerState == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }

        public C1581Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? C1583TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j, (i3 & 8) != 0 ? C1583TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }
}
