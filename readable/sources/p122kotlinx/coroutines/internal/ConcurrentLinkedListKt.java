package p122kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p131o.AbstractC1852Dt;
import p131o.AbstractC3171XbiWeM;
import p131o.AbstractC5024zd;

@Metadata(m4987d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\r\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0080\b\u001as\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u000228\b\b\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0080\b\u001a!\u0010\u0012\u001a\u0002H\u0013\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u0015\u001a8\u0010\u0016\u001a\u00020\r*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u001bH\u0082\b\"\u000e\u0010\u001d\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m4988d2 = {"findSegmentInternal", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "id", BuildConfig.f24315FLAVOR, "createNewSegment", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", BuildConfig.f24315FLAVOR, "Lkotlinx/atomicfu/AtomicRef;", "to", "findSegmentAndMoveForward", "startFrom", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "addConditionally", "Lkotlinx/atomicfu/AtomicInt;", "delta", BuildConfig.f24315FLAVOR, "condition", "Lkotlin/Function1;", "cur", "POINTERS_SHIFT", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,265:1\n41#1,9:280\n103#2,7:266\n103#2,7:273\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n70#1:280,9\n23#1:266,7\n81#1:273,7\n*E\n"})
/* loaded from: classes.dex */
public final class ConcurrentLinkedListKt {

    /* renamed from: CLOSED */
    private static final C1578Symbol f7191CLOSED = new C1578Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    private static final /* synthetic */ boolean addConditionally$atomicfu$ATOMIC_ARRAY$Int(AtomicIntegerArray atomicIntegerArray, int i, int i2, Function1<? super Integer, Boolean> function1) {
        int i3;
        do {
            i3 = atomicIntegerArray.get(i);
            if (!function1.mo2237invoke(Integer.valueOf(i3)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i, i3, i3 + i2));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Object obj, int i, Function1<? super Integer, Boolean> function1) {
        int i2;
        do {
            i2 = atomicIntegerFieldUpdater.get(obj);
            if (!function1.mo2237invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i2, i2 + i));
        return true;
    }

    private static final /* synthetic */ boolean addConditionally$atomicfu$BOXED_ATOMIC$Int(AtomicInteger atomicInteger, int i, Function1<? super Integer, Boolean> function1) {
        int i2;
        do {
            i2 = atomicInteger.get();
            if (!function1.mo2237invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        } while (!atomicInteger.compareAndSet(i2, i2 + i));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* renamed from: close */
    public static final <N extends ConcurrentLinkedListNode<N>> N m7406close(N n) {
        while (true) {
            Object nextOrClosed = n.getNextOrClosed();
            if (nextOrClosed == f7191CLOSED) {
                return n;
            }
            ?? r0 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r0 != 0) {
                n = r0;
            } else if (n.markAsClosed()) {
                return n;
            }
        }
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> Object findSegmentAndMoveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray atomicReferenceArray, int i, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object objFindSegmentInternal;
        loop0: while (true) {
            objFindSegmentInternal = findSegmentInternal(s, j, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceArray.get(i);
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC3171XbiWeM.m10947mjFkc(atomicReferenceArray, i, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        return objFindSegmentInternal;
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> Object findSegmentAndMoveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object objFindSegmentInternal;
        loop0: while (true) {
            objFindSegmentInternal = findSegmentInternal(s, j, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(obj);
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, obj, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        return objFindSegmentInternal;
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> Object findSegmentAndMoveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference atomicReference, long j, S s, Function2<? super Long, ? super S, ? extends S> function2) {
        Object objFindSegmentInternal;
        loop0: while (true) {
            objFindSegmentInternal = findSegmentInternal(s, j, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReference.get();
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC5024zd.m14125mjFkc(atomicReference, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        return objFindSegmentInternal;
    }

    public static final <S extends AbstractC1577Segment<S>> Object findSegmentInternal(S s, long j, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.id >= j && !s.isRemoved()) {
                return SegmentOrClosed.m20046constructorimpl(s);
            }
            Object nextOrClosed = s.getNextOrClosed();
            if (nextOrClosed == f7191CLOSED) {
                return SegmentOrClosed.m20046constructorimpl(f7191CLOSED);
            }
            S sMo2167invoke = (S) ((ConcurrentLinkedListNode) nextOrClosed);
            if (sMo2167invoke == null) {
                sMo2167invoke = function2.mo2167invoke(Long.valueOf(s.id + 1), s);
                if (s.trySetNext(sMo2167invoke)) {
                    if (s.isRemoved()) {
                        s.m7410remove();
                    }
                }
            }
            s = sMo2167invoke;
        }
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> boolean moveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray atomicReferenceArray, int i, S s) {
        while (true) {
            AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceArray.get(i);
            if (abstractC1577Segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractC3171XbiWeM.m10947mjFkc(atomicReferenceArray, i, abstractC1577Segment, s)) {
                if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                    abstractC1577Segment.m7410remove();
                }
                return true;
            }
            if (s.decPointers$kotlinx_coroutines_core()) {
                s.m7410remove();
            }
        }
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> boolean moveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, S s) {
        while (true) {
            AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(obj);
            if (abstractC1577Segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, obj, abstractC1577Segment, s)) {
                if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                    abstractC1577Segment.m7410remove();
                }
                return true;
            }
            if (s.decPointers$kotlinx_coroutines_core()) {
                s.m7410remove();
            }
        }
    }

    public static final /* synthetic */ <S extends AbstractC1577Segment<S>> boolean moveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference atomicReference, S s) {
        while (true) {
            AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReference.get();
            if (abstractC1577Segment.id >= s.id) {
                return true;
            }
            if (!s.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            if (AbstractC5024zd.m14125mjFkc(atomicReference, abstractC1577Segment, s)) {
                if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                    abstractC1577Segment.m7410remove();
                }
                return true;
            }
            if (s.decPointers$kotlinx_coroutines_core()) {
                s.m7410remove();
            }
        }
    }
}
