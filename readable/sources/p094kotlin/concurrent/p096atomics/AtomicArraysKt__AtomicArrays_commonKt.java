package p094kotlin.concurrent.p096atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a-\u0010\u000b\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a-\u0010\u0010\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\r\u001a@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a-\u0010\u000b\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u000e\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u000f\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001a-\u0010\u0010\u001a\u00020\u0013*\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0087\u0080\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\n¢\u0006\u0002\u0010\u0015\u001aN\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00180\u0005H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tb\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00180\u0017\"\u0006\b\u0000\u0010\u0018\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001cb\u0002\b\n¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m4988d2 = {"AtomicIntArray", "Lkotlin/concurrent/atomics/AtomicIntArray;", "size", BuildConfig.f24315FLAVOR, "init", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "Lkotlin/SinceKotlin;", "version", "2.1", "Lkotlin/concurrent/atomics/ExperimentalAtomicApi;", "fetchAndIncrementAt", "index", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;I)I", "incrementAndFetchAt", "decrementAndFetchAt", "fetchAndDecrementAt", "AtomicLongArray", "Lkotlin/concurrent/atomics/AtomicLongArray;", BuildConfig.f24315FLAVOR, "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;I)J", "AtomicArray", "Lkotlin/concurrent/atomics/AtomicArray;", "T", "(ILkotlin/jvm/functions/Function1;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "atomicArrayOfNulls", "(I)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "2.2", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/concurrent/atomics/AtomicArraysKt")
@SourceDebugExtension(m6344value = {"SMAP\nAtomicArrays.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicArrays.common.kt\nkotlin/concurrent/atomics/AtomicArraysKt__AtomicArrays_commonKt\n*L\n1#1,769:1\n667#1:770\n*S KotlinDebug\n*F\n+ 1 AtomicArrays.common.kt\nkotlin/concurrent/atomics/AtomicArraysKt__AtomicArrays_commonKt\n*L\n679#1:770\n*E\n"})
/* loaded from: classes.dex */
class AtomicArraysKt__AtomicArrays_commonKt {
    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final /* synthetic */ <T> AtomicReferenceArray<T> AtomicArray(int i, Function1<? super Integer, ? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = init.mo2237invoke(Integer.valueOf(i2));
        }
        return new AtomicReferenceArray<>(objArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicIntegerArray AtomicIntArray(int i, Function1<? super Integer, Integer> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = init.mo2237invoke(Integer.valueOf(i2)).intValue();
        }
        return new AtomicIntegerArray(iArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicLongArray AtomicLongArray(int i, Function1<? super Integer, Long> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = init.mo2237invoke(Integer.valueOf(i2)).longValue();
        }
        return new AtomicLongArray(jArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    public static final /* synthetic */ <T> AtomicReferenceArray<T> atomicArrayOfNulls(int i) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        return new AtomicReferenceArray<>(objArr);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final int decrementAndFetchAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray.addAndGet(i, -1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final int fetchAndDecrementAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray.getAndAdd(i, -1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final int fetchAndIncrementAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray.getAndAdd(i, 1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final int incrementAndFetchAt(AtomicIntegerArray atomicIntegerArray, int i) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray.addAndGet(i, 1);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final long decrementAndFetchAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray.addAndGet(i, -1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final long fetchAndDecrementAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray.getAndAdd(i, -1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final long fetchAndIncrementAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray.getAndAdd(i, 1L);
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final long incrementAndFetchAt(AtomicLongArray atomicLongArray, int i) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray.addAndGet(i, 1L);
    }
}
