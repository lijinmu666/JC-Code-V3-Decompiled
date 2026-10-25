package com.flyfishxu.p028kadb.p034queue;

import com.flyfishxu.p028kadb.exception.AdbStreamClosed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.StringCompanionObject;

@Metadata(m4987d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\rJ\f\u0010\u0019\u001a\u00020\u0017H\u0007b\u0002\b\u001aJ\r\u0010\u001b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u001fJ\u0015\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00028\u0000H$¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010%\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m4988d2 = {"Lcom/flyfishxu/kadb/queue/MessageQueue;", "V", BuildConfig.f24315FLAVOR, "<init>", "()V", "readLock", "Ljava/util/concurrent/locks/ReentrantLock;", "queueLock", "queueCond", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "queues", "Ljava/util/concurrent/ConcurrentHashMap;", BuildConfig.f24315FLAVOR, "Ljava/util/Queue;", "openStreams", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "take", "localId", "command", "(II)Ljava/lang/Object;", "startListening", BuildConfig.f24315FLAVOR, "stopListening", "ensureEmpty", "Lorg/jetbrains/annotations/TestOnly;", "readMessage", "()Ljava/lang/Object;", "getLocalId", "message", "(Ljava/lang/Object;)I", "getCommand", "isCloseCommand", BuildConfig.f24315FLAVOR, "(Ljava/lang/Object;)Z", "poll", "read", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMessageQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageQueue.kt\ncom/flyfishxu/kadb/queue/MessageQueue\n+ 2 MessageQueue.kt\ncom/flyfishxu/kadb/queue/MessageQueueKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n103#2,3:123\n107#2:127\n112#2,8:128\n108#2,2:136\n1#3:126\n1739#4:138\n1814#4,3:139\n*S KotlinDebug\n*F\n+ 1 MessageQueue.kt\ncom/flyfishxu/kadb/queue/MessageQueue\n*L\n22#1:123,3\n22#1:127\n24#1:128,8\n22#1:136,2\n48#1:138\n48#1:139,3\n*E\n"})
/* loaded from: classes.dex */
public abstract class MessageQueue<V> {
    private final Set<Integer> openStreams;
    private final Condition queueCond;
    private final ReentrantLock queueLock;
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Queue<V>>> queues;
    private final ReentrantLock readLock = new ReentrantLock();

    public MessageQueue() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.queueLock = reentrantLock;
        this.queueCond = reentrantLock.newCondition();
        this.queues = new ConcurrentHashMap<>();
        this.openStreams = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    /* renamed from: poll */
    private final V m2282poll(int localId, int command) throws AdbStreamClosed {
        ConcurrentHashMap<Integer, Queue<V>> concurrentHashMap = this.queues.get(Integer.valueOf(localId));
        if (concurrentHashMap == null) {
            throw new IllegalStateException("Not listening for localId: " + localId);
        }
        Queue<V> queue = concurrentHashMap.get(Integer.valueOf(command));
        V vPoll = queue != null ? queue.poll() : null;
        if (vPoll != null || this.openStreams.contains(Integer.valueOf(localId))) {
            return vPoll;
        }
        throw new AdbStreamClosed(localId);
    }

    /* renamed from: read */
    private final void m2283read() {
        Queue<V> concurrentLinkedQueue;
        V message = readMessage();
        int localId = getLocalId(message);
        if (isCloseCommand(message)) {
            this.openStreams.remove(Integer.valueOf(localId));
            return;
        }
        ConcurrentHashMap<Integer, Queue<V>> concurrentHashMap = this.queues.get(Integer.valueOf(localId));
        if (concurrentHashMap == null) {
            return;
        }
        int command = getCommand(message);
        synchronized (concurrentHashMap) {
            concurrentLinkedQueue = concurrentHashMap.get(Integer.valueOf(command));
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                concurrentHashMap.put(Integer.valueOf(command), concurrentLinkedQueue);
            }
        }
        concurrentLinkedQueue.add(message);
    }

    public final void ensureEmpty() {
        if (this.queues.isEmpty()) {
            if (!this.openStreams.isEmpty()) {
                throw new IllegalStateException("Check failed.");
            }
            return;
        }
        Set<Integer> setKeySet = this.queues.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        for (Integer num : setKeySet) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%X", Arrays.copyOf(new Object[]{num}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            arrayList.add(str);
        }
        throw new IllegalStateException(("Queues is not empty: " + arrayList).toString());
    }

    public abstract int getCommand(V message);

    public abstract int getLocalId(V message);

    public abstract boolean isCloseCommand(V message);

    public abstract V readMessage();

    public final void startListening(int localId) {
        this.openStreams.add(Integer.valueOf(localId));
        this.queues.putIfAbsent(Integer.valueOf(localId), new ConcurrentHashMap<>());
    }

    public final void stopListening(int localId) {
        this.openStreams.remove(Integer.valueOf(localId));
        this.queues.remove(Integer.valueOf(localId));
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: take */
    public final V m2284take(int localId, int command) {
        ReentrantLock reentrantLock;
        V vM2282poll;
        while (true) {
            reentrantLock = this.queueLock;
            reentrantLock.lock();
            try {
                vM2282poll = m2282poll(localId, command);
                if (vM2282poll != null) {
                    break;
                }
                ReentrantLock reentrantLock2 = this.readLock;
                if (reentrantLock2.tryLock()) {
                    try {
                        this.queueLock.unlock();
                        m2283read();
                        this.queueLock.lock();
                        this.queueCond.signalAll();
                        if (reentrantLock2.isHeldByCurrentThread()) {
                            reentrantLock2.unlock();
                        }
                    } catch (Throwable th) {
                        if (reentrantLock2.isHeldByCurrentThread()) {
                            reentrantLock2.unlock();
                        }
                        throw th;
                    }
                } else {
                    this.queueCond.await();
                }
                if (reentrantLock.isHeldByCurrentThread()) {
                    reentrantLock.unlock();
                }
            } catch (Throwable th2) {
                if (reentrantLock.isHeldByCurrentThread()) {
                    reentrantLock.unlock();
                }
                throw th2;
            }
        }
        if (reentrantLock.isHeldByCurrentThread()) {
            reentrantLock.unlock();
        }
        return vM2282poll;
    }
}
