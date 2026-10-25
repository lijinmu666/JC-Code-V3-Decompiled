package p122kotlinx.coroutines.p124debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.collections.AbstractMutableSet;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.p106markers.KMutableIterator;
import p094kotlin.p105jvm.internal.p106markers.KMutableMap;
import p094kotlin.p112ranges.RangesKt;
import p122kotlinx.coroutines.p124debug.internal.ConcurrentWeakMap;
import p131o.AbstractC3171XbiWeM;

@Metadata(m4987d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003)*+B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J!\u0010\u001c\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010$\u001a\u00020\u0014H\u0016J\u0006\u0010%\u001a\u00020\u0014J\u0014\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0002R\t\u0010\t\u001a\u00020\nX\u0082\u0004R\u001f\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u00120\rR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\fX\u0082\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 ¨\u0006,"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", BuildConfig.f24315FLAVOR, "V", "Ljava/util/AbstractMap;", "weakRefQueue", BuildConfig.f24315FLAVOR, "<init>", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "Ljava/lang/ref/ReferenceQueue;", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "decrementSize", BuildConfig.f24315FLAVOR, "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "putSynchronized", "keys", BuildConfig.f24315FLAVOR, "getKeys", "()Ljava/util/Set;", "entries", BuildConfig.f24315FLAVOR, "getEntries", "clear", "runWeakRefQueueCleaningLoopUntilInterrupted", "cleanWeakRef", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n1#2:282\n*E\n"})
/* loaded from: classes.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMap<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater core$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    private volatile /* synthetic */ int _size$volatile;
    private volatile /* synthetic */ Object core$volatile;
    private final ReferenceQueue<K> weakRefQueue;

    @Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J1\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\fJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0002\u0010\u001f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u001f0!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\b\u001a\u00020\tX\u0082\u0004R\u0017\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000bX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u0004¨\u0006#"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", BuildConfig.f24315FLAVOR, "allocated", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "shift", "threshold", "load", "Lkotlinx/atomicfu/AtomicInt;", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "values", "index", "hash", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "removeCleanedAt", BuildConfig.f24315FLAVOR, "putImpl", "value", "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "cleanWeakRef", "weakRef", "keyValueIterator", BuildConfig.f24315FLAVOR, "E", "factory", "Lkotlin/Function2;", "KeyValueIterator", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$Core */
    public final class C1413Core {
        private static final /* synthetic */ AtomicIntegerFieldUpdater load$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(C1413Core.class, "load$volatile");
        private final int allocated;

        /* renamed from: keys */
        private final /* synthetic */ AtomicReferenceArray f6011keys;
        private volatile /* synthetic */ int load$volatile;
        private final int shift;
        private final int threshold;

        /* renamed from: values */
        private final /* synthetic */ AtomicReferenceArray f6014values;

        @Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\u000e\u0010\u0010\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00028\u0001X\u0082.¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0014"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", BuildConfig.f24315FLAVOR, "factory", "Lkotlin/Function2;", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", BuildConfig.f24315FLAVOR, "key", "Ljava/lang/Object;", "value", "findNext", BuildConfig.f24315FLAVOR, "hasNext", BuildConfig.f24315FLAVOR, "next", "()Ljava/lang/Object;", "remove", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
        @SourceDebugExtension(m6344value = {"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n1#2:282\n*E\n"})
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$Core$KeyValueIterator */
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            private final Function2<K, V, E> factory;
            private int index = -1;
            private K key;
            private V value;

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                findNext();
            }

            private final void findNext() {
                K k;
                while (true) {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= ((C1413Core) C1413Core.this).allocated) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) C1413Core.this.getF6011keys().get(this.index);
                    if (hashedWeakRef != null && (k = (K) hashedWeakRef.get()) != null) {
                        this.key = k;
                        Object obj = (V) C1413Core.this.getF6014values().get(this.index);
                        if (obj instanceof C1420Marked) {
                            obj = (V) ((C1420Marked) obj).ref;
                        }
                        if (obj != null) {
                            this.value = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < ((C1413Core) C1413Core.this).allocated;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index >= ((C1413Core) C1413Core.this).allocated) {
                    throw new NoSuchElementException();
                }
                Function2<K, V, E> function2 = this.factory;
                K k = this.key;
                if (k == false) {
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                    k = (K) C1133Unit.INSTANCE;
                }
                V v = this.value;
                if (v == false) {
                    Intrinsics.throwUninitializedPropertyAccessException("value");
                    v = (V) C1133Unit.INSTANCE;
                }
                E e = (E) function2.mo2167invoke(k, v);
                findNext();
                return e;
            }

            @Override // java.util.Iterator
            public Void remove() {
                ConcurrentWeakMapKt.m7173noImpl();
                throw new KotlinNothingValueException();
            }
        }

        public C1413Core(int i) {
            this.allocated = i;
            this.shift = Integer.numberOfLeadingZeros(i) + 1;
            this.threshold = (i * 2) / 3;
            this.f6011keys = new AtomicReferenceArray(i);
            this.f6014values = new AtomicReferenceArray(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: getKeys, reason: from getter */
        public final /* synthetic */ AtomicReferenceArray getF6011keys() {
            return this.f6011keys;
        }

        private final /* synthetic */ int getLoad$volatile() {
            return this.load$volatile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: getValues, reason: from getter */
        public final /* synthetic */ AtomicReferenceArray getF6014values() {
            return this.f6014values;
        }

        /* renamed from: index */
        private final int m7168index(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(C1413Core c1413Core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i, Object obj3) {
            if ((i & 4) != 0) {
                hashedWeakRef = null;
            }
            return c1413Core.m7170putImpl(obj, obj2, hashedWeakRef);
        }

        private final void removeCleanedAt(int index) {
            Object obj;
            do {
                obj = getF6014values().get(index);
                if (obj == null || (obj instanceof C1420Marked)) {
                    return;
                }
            } while (!AbstractC3171XbiWeM.m10947mjFkc(getF6014values(), index, obj, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        private final /* synthetic */ void setLoad$volatile(int i) {
            this.load$volatile = i;
        }

        private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Object obj, Function1<? super Integer, Integer> function1) {
            int i;
            do {
                i = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, function1.mo2237invoke(Integer.valueOf(i)).intValue()));
        }

        public final void cleanWeakRef(HashedWeakRef<?> weakRef) {
            int iM7168index = m7168index(weakRef.hash);
            while (true) {
                HashedWeakRef<?> hashedWeakRef = (HashedWeakRef) getF6011keys().get(iM7168index);
                if (hashedWeakRef == null) {
                    return;
                }
                if (hashedWeakRef == weakRef) {
                    removeCleanedAt(iM7168index);
                    return;
                } else {
                    if (iM7168index == 0) {
                        iM7168index = this.allocated;
                    }
                    iM7168index--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: getImpl */
        public final V m7169getImpl(K key) {
            int iM7168index = m7168index(key.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) getF6011keys().get(iM7168index);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t = hashedWeakRef.get();
                if (Intrinsics.areEqual(key, t)) {
                    V v = (V) getF6014values().get(iM7168index);
                    return v instanceof C1420Marked ? (V) ((C1420Marked) v).ref : v;
                }
                if (t == 0) {
                    removeCleanedAt(iM7168index);
                }
                if (iM7168index == 0) {
                    iM7168index = this.allocated;
                }
                iM7168index--;
            }
        }

        public final <E> Iterator<E> keyValueIterator(Function2<? super K, ? super V, ? extends E> factory) {
            return new KeyValueIterator(factory);
        }

        /* renamed from: putImpl */
        public final Object m7170putImpl(K key, V value, HashedWeakRef<K> weakKey0) {
            int i;
            Object obj;
            int iM7168index = m7168index(key.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) getF6011keys().get(iM7168index);
                if (hashedWeakRef != null) {
                    T t = hashedWeakRef.get();
                    if (!Intrinsics.areEqual(key, t)) {
                        if (t == 0) {
                            removeCleanedAt(iM7168index);
                        }
                        if (iM7168index == 0) {
                            iM7168index = this.allocated;
                        }
                        iM7168index--;
                    } else if (z) {
                        load$volatile$FU.decrementAndGet(this);
                    }
                } else if (value != null) {
                    if (!z) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = load$volatile$FU;
                        do {
                            i = atomicIntegerFieldUpdater.get(this);
                            if (i >= this.threshold) {
                                return ConcurrentWeakMapKt.f6025REHASH;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1));
                        z = true;
                    }
                    if (weakKey0 == null) {
                        weakKey0 = new HashedWeakRef<>(key, ((ConcurrentWeakMap) ConcurrentWeakMap.this).weakRefQueue);
                    }
                    if (AbstractC3171XbiWeM.m10947mjFkc(getF6011keys(), iM7168index, null, weakKey0)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj = getF6014values().get(iM7168index);
                if (obj instanceof C1420Marked) {
                    return ConcurrentWeakMapKt.f6025REHASH;
                }
            } while (!AbstractC3171XbiWeM.m10947mjFkc(getF6014values(), iM7168index, obj, value));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: rehash */
        public final ConcurrentWeakMap<K, V>.C1413Core m7171rehash() {
            int i;
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.C1413Core c1413Core = (ConcurrentWeakMap<K, V>.C1413Core) ConcurrentWeakMap.this.new C1413Core(Integer.highestOneBit(RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i2 = this.allocated;
                while (i < i2) {
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) getF6011keys().get(i);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        removeCleanedAt(i);
                    }
                    while (true) {
                        obj = getF6014values().get(i);
                        if (obj instanceof C1420Marked) {
                            obj = ((C1420Marked) obj).ref;
                            break;
                        }
                        if (AbstractC3171XbiWeM.m10947mjFkc(getF6014values(), i, obj, ConcurrentWeakMapKt.m7172mark(obj))) {
                            break;
                        }
                    }
                    i = (obj2 == null || obj == null || c1413Core.m7170putImpl(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.f6025REHASH) ? i + 1 : 0;
                }
                return c1413Core;
            }
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u000f"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", BuildConfig.f24315FLAVOR, "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$Entry */
    public static final class C1414Entry<K, V> implements Map.Entry<K, V>, KMutableMap.InterfaceC1236Entry {
        private final K key;
        private final V value;

        public C1414Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            ConcurrentWeakMapKt.m7173noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010H\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "add", BuildConfig.f24315FLAVOR, "element", "(Ljava/lang/Object;)Z", "iterator", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public final class KeyValueSet<E> extends AbstractMutableSet<E> {
        private final Function2<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // p094kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E element) {
            ConcurrentWeakMapKt.m7173noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // p094kotlin.collections.AbstractMutableSet
        /* renamed from: getSize */
        public int mo5121getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((C1413Core) ConcurrentWeakMap.getCore$volatile$FU().get(ConcurrentWeakMap.this)).keyValueIterator(this.factory);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map.Entry _get_entries_$lambda$0(Object obj, Object obj2) {
        return new C1414Entry(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _get_keys_$lambda$0(Object obj, Object obj2) {
        return obj;
    }

    private final void cleanWeakRef(HashedWeakRef<?> w) {
        ((C1413Core) core$volatile$FU.get(this)).cleanWeakRef(w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementSize() {
        _size$volatile$FU.decrementAndGet(this);
    }

    private final /* synthetic */ Object getCore$volatile() {
        return this.core$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getCore$volatile$FU() {
        return core$volatile$FU;
    }

    private final /* synthetic */ int get_size$volatile() {
        return this._size$volatile;
    }

    private final synchronized V putSynchronized(K key, V value) {
        V v;
        C1413Core c1413CoreM7171rehash = (C1413Core) core$volatile$FU.get(this);
        while (true) {
            v = (V) C1413Core.putImpl$default(c1413CoreM7171rehash, key, value, null, 4, null);
            if (v == ConcurrentWeakMapKt.f6025REHASH) {
                c1413CoreM7171rehash = c1413CoreM7171rehash.m7171rehash();
                core$volatile$FU.set(this, c1413CoreM7171rehash);
            }
        }
        return v;
    }

    private final /* synthetic */ void setCore$volatile(Object obj) {
        this.core$volatile = obj;
    }

    private final /* synthetic */ void set_size$volatile(int i) {
        this._size$volatile = i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((C1413Core) core$volatile$FU.get(this)).m7169getImpl(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(new Function2() { // from class: o.LlB
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return ConcurrentWeakMap._get_entries_$lambda$0(obj, obj2);
            }
        });
    }

    /* renamed from: getKeys */
    public Set<K> m7165getKeys() {
        return new KeyValueSet(new Function2() { // from class: o.kOlLW
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return ConcurrentWeakMap._get_keys_$lambda$0(obj, obj2);
            }
        });
    }

    /* renamed from: getSize */
    public int m7166getSize() {
        return _size$volatile$FU.get(this);
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return m7165getKeys();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        V vPutSynchronized = (V) C1413Core.putImpl$default((C1413Core) core$volatile$FU.get(this), key, value, null, 4, null);
        if (vPutSynchronized == ConcurrentWeakMapKt.f6025REHASH) {
            vPutSynchronized = putSynchronized(key, value);
        }
        if (vPutSynchronized == null) {
            _size$volatile$FU.incrementAndGet(this);
        }
        return vPutSynchronized;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        if (key == 0) {
            return null;
        }
        V vPutSynchronized = (V) C1413Core.putImpl$default((C1413Core) core$volatile$FU.get(this), key, null, null, 4, null);
        if (vPutSynchronized == ConcurrentWeakMapKt.f6025REHASH) {
            vPutSynchronized = putSynchronized(key, null);
        }
        if (vPutSynchronized != null) {
            _size$volatile$FU.decrementAndGet(this);
        }
        return vPutSynchronized;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if (this.weakRefQueue == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.weakRefQueue.remove();
                Intrinsics.checkNotNull(referenceRemove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                cleanWeakRef((HashedWeakRef) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return m7166getSize();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    public ConcurrentWeakMap(boolean z) {
        this.core$volatile = new C1413Core(16);
        this.weakRefQueue = z ? new ReferenceQueue<>() : null;
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
