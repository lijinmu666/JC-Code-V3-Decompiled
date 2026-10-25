package p094kotlin.concurrent.p096atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC3171XbiWeM;

@Metadata(m4987d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\u0000\u001a\u00020\t*\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\b\u001a\u00020\n*\u00020\tH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001a7\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\u000e\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001aU\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u0016\u001aU\u0010\u0019\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001a\u001aU\u0010\u001b\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001a\u001aU\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001d\u001aU\u0010\u0019\u001a\u00020\u001c*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001e\u001aU\u0010\u001b\u001a\u00020\u001c*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001e\u001aa\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\r0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010\u001f\u001aa\u0010\u0019\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\r0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010 \u001aa\u0010\u001b\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\r0\u0015H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017b\u0002\b\u0007b\u0002\b\u0018ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0002¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m4988d2 = {"asJavaAtomicArray", "Ljava/util/concurrent/atomic/AtomicIntegerArray;", "Lkotlin/concurrent/atomics/AtomicIntArray;", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;)Ljava/util/concurrent/atomic/AtomicIntegerArray;", "Lkotlin/SinceKotlin;", "version", "2.1", "Lkotlin/concurrent/atomics/ExperimentalAtomicApi;", "asKotlinAtomicArray", "Ljava/util/concurrent/atomic/AtomicLongArray;", "Lkotlin/concurrent/atomics/AtomicLongArray;", "(Ljava/util/concurrent/atomic/AtomicLongArray;)Ljava/util/concurrent/atomic/AtomicLongArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "T", "Lkotlin/concurrent/atomics/AtomicArray;", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;)Ljava/util/concurrent/atomic/AtomicReferenceArray;", "updateAt", BuildConfig.f24315FLAVOR, "index", BuildConfig.f24315FLAVOR, "transform", "Lkotlin/Function1;", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;ILkotlin/jvm/functions/Function1;)V", "2.2", "Lkotlin/internal/InlineOnly;", "updateAndFetchAt", "(Ljava/util/concurrent/atomic/AtomicIntegerArray;ILkotlin/jvm/functions/Function1;)I", "fetchAndUpdateAt", BuildConfig.f24315FLAVOR, "(Ljava/util/concurrent/atomic/AtomicLongArray;ILkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicLongArray;ILkotlin/jvm/functions/Function1;)J", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicReferenceArray;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/concurrent/atomics/AtomicArraysKt")
/* loaded from: classes.dex */
class AtomicArraysKt__AtomicArrays_jvmKt extends AtomicArraysKt__AtomicArrays_commonKt {
    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicIntegerArray asJavaAtomicArray(AtomicIntegerArray atomicIntegerArray) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicIntegerArray asKotlinAtomicArray(AtomicIntegerArray atomicIntegerArray) {
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        return atomicIntegerArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final int fetchAndUpdateAt(AtomicIntegerArray atomicIntegerArray, int i, Function1<? super Integer, Integer> transform) {
        int i2;
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i2 = atomicIntegerArray.get(i);
        } while (!atomicIntegerArray.compareAndSet(i, i2, transform.mo2237invoke(Integer.valueOf(i2)).intValue()));
        return i2;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final int updateAndFetchAt(AtomicIntegerArray atomicIntegerArray, int i, Function1<? super Integer, Integer> transform) {
        int i2;
        int iIntValue;
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i2 = atomicIntegerArray.get(i);
            iIntValue = transform.mo2237invoke(Integer.valueOf(i2)).intValue();
        } while (!atomicIntegerArray.compareAndSet(i, i2, iIntValue));
        return iIntValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final void updateAt(AtomicIntegerArray atomicIntegerArray, int i, Function1<? super Integer, Integer> transform) {
        int i2;
        Intrinsics.checkNotNullParameter(atomicIntegerArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i2 = atomicIntegerArray.get(i);
        } while (!atomicIntegerArray.compareAndSet(i, i2, transform.mo2237invoke(Integer.valueOf(i2)).intValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicLongArray asJavaAtomicArray(AtomicLongArray atomicLongArray) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicLongArray asKotlinAtomicArray(AtomicLongArray atomicLongArray) {
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        return atomicLongArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final void updateAt(AtomicLongArray atomicLongArray, int i, Function1<? super Long, Long> transform) {
        long j;
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLongArray.get(i);
        } while (!atomicLongArray.compareAndSet(i, j, transform.mo2237invoke(Long.valueOf(j)).longValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final <T> AtomicReferenceArray<T> asJavaAtomicArray(AtomicReferenceArray<T> atomicReferenceArray) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        return atomicReferenceArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final <T> AtomicReferenceArray<T> asKotlinAtomicArray(AtomicReferenceArray<T> atomicReferenceArray) {
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        return atomicReferenceArray;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> void updateAt(AtomicReferenceArray<T> atomicReferenceArray, int i, Function1<? super T, ? extends T> transform) {
        T t;
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReferenceArray.get(i);
        } while (!AbstractC3171XbiWeM.m10947mjFkc(atomicReferenceArray, i, t, transform.mo2237invoke(t)));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final long fetchAndUpdateAt(AtomicLongArray atomicLongArray, int i, Function1<? super Long, Long> transform) {
        long j;
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLongArray.get(i);
        } while (!atomicLongArray.compareAndSet(i, j, transform.mo2237invoke(Long.valueOf(j)).longValue()));
        return j;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final long updateAndFetchAt(AtomicLongArray atomicLongArray, int i, Function1<? super Long, Long> transform) {
        long j;
        long jLongValue;
        Intrinsics.checkNotNullParameter(atomicLongArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLongArray.get(i);
            jLongValue = transform.mo2237invoke(Long.valueOf(j)).longValue();
        } while (!atomicLongArray.compareAndSet(i, j, jLongValue));
        return jLongValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> T fetchAndUpdateAt(AtomicReferenceArray<T> atomicReferenceArray, int i, Function1<? super T, ? extends T> transform) {
        T t;
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReferenceArray.get(i);
        } while (!AbstractC3171XbiWeM.m10947mjFkc(atomicReferenceArray, i, t, transform.mo2237invoke(t)));
        return t;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> T updateAndFetchAt(AtomicReferenceArray<T> atomicReferenceArray, int i, Function1<? super T, ? extends T> transform) {
        T t;
        T tMo2237invoke;
        Intrinsics.checkNotNullParameter(atomicReferenceArray, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReferenceArray.get(i);
            tMo2237invoke = transform.mo2237invoke(t);
        } while (!AbstractC3171XbiWeM.m10947mjFkc(atomicReferenceArray, i, t, tMo2237invoke));
        return tMo2237invoke;
    }
}
