package p094kotlin.concurrent.p096atomics;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC5024zd;

@Metadata(m4987d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a%\u0010\u0000\u001a\u00020\t*\u00020\nH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\b\u001a\u00020\n*\u00020\tH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000b\u001a%\u0010\u0000\u001a\u00020\f*\u00020\rH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000e\u001a%\u0010\b\u001a\u00020\r*\u00020\fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u000e\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a7\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u000fH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u0018\u001aM\u0010\u001b\u001a\u00020\u0017*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001c\u001aM\u0010\u0013\u001a\u00020\u0014*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\u001f\u001aM\u0010\u001b\u001a\u00020\u001e*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010 \u001aM\u0010\u001d\u001a\u00020\u001e*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010 \u001aY\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010!\u001aY\u0010\u001b\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\"\u001aY\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00100\u0016H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019b\u0002\b\u0007b\u0002\b\u001aø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m4988d2 = {"asJavaAtomic", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/concurrent/atomics/AtomicInt;", "(Ljava/util/concurrent/atomic/AtomicInteger;)Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/SinceKotlin;", "version", "2.1", "Lkotlin/concurrent/atomics/ExperimentalAtomicApi;", "asKotlinAtomic", "Ljava/util/concurrent/atomic/AtomicLong;", "Lkotlin/concurrent/atomics/AtomicLong;", "(Ljava/util/concurrent/atomic/AtomicLong;)Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/concurrent/atomics/AtomicBoolean;", "(Ljava/util/concurrent/atomic/AtomicBoolean;)Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicReference;", "T", "Lkotlin/concurrent/atomics/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "update", BuildConfig.f24315FLAVOR, "transform", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)V", "2.2", "Lkotlin/internal/InlineOnly;", "fetchAndUpdate", "(Ljava/util/concurrent/atomic/AtomicInteger;Lkotlin/jvm/functions/Function1;)I", "updateAndFetch", BuildConfig.f24315FLAVOR, "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicLong;Lkotlin/jvm/functions/Function1;)J", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)V", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/concurrent/atomics/AtomicsKt")
/* loaded from: classes.dex */
class AtomicsKt__Atomics_jvmKt extends AtomicsKt__Atomics_commonKt {
    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicBoolean asJavaAtomic(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        return atomicBoolean;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicBoolean asKotlinAtomic(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        return atomicBoolean;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final int fetchAndUpdate(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i;
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i, transform.mo2237invoke(Integer.valueOf(i)).intValue()));
        return i;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    /* renamed from: update */
    private static final void m6086update(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i;
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i, transform.mo2237invoke(Integer.valueOf(i)).intValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final int updateAndFetch(AtomicInteger atomicInteger, Function1<? super Integer, Integer> transform) {
        int i;
        int iIntValue;
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            i = atomicInteger.get();
            iIntValue = transform.mo2237invoke(Integer.valueOf(i)).intValue();
        } while (!atomicInteger.compareAndSet(i, iIntValue));
        return iIntValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicInteger asJavaAtomic(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicInteger asKotlinAtomic(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<this>");
        return atomicInteger;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    /* renamed from: update */
    private static final void m6087update(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLong.get();
        } while (!atomicLong.compareAndSet(j, transform.mo2237invoke(Long.valueOf(j)).longValue()));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicLong asJavaAtomic(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final AtomicLong asKotlinAtomic(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        return atomicLong;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    /* renamed from: update */
    private static final <T> void m6088update(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReference.get();
        } while (!AbstractC5024zd.m14125mjFkc(atomicReference, t, transform.mo2237invoke(t)));
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final <T> AtomicReference<T> asJavaAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        return atomicReference;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.1")
    public static final <T> AtomicReference<T> asKotlinAtomic(AtomicReference<T> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        return atomicReference;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final long fetchAndUpdate(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLong.get();
        } while (!atomicLong.compareAndSet(j, transform.mo2237invoke(Long.valueOf(j)).longValue()));
        return j;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final long updateAndFetch(AtomicLong atomicLong, Function1<? super Long, Long> transform) {
        long j;
        long jLongValue;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            j = atomicLong.get();
            jLongValue = transform.mo2237invoke(Long.valueOf(j)).longValue();
        } while (!atomicLong.compareAndSet(j, jLongValue));
        return jLongValue;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> T fetchAndUpdate(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReference.get();
        } while (!AbstractC5024zd.m14125mjFkc(atomicReference, t, transform.mo2237invoke(t)));
        return t;
    }

    @ExperimentalAtomicApi
    @SinceKotlin(m5061version = "2.2")
    @InlineOnly
    private static final <T> T updateAndFetch(AtomicReference<T> atomicReference, Function1<? super T, ? extends T> transform) {
        T t;
        T tMo2237invoke;
        Intrinsics.checkNotNullParameter(atomicReference, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        do {
            t = atomicReference.get();
            tMo2237invoke = transform.mo2237invoke(t);
        } while (!AbstractC5024zd.m14125mjFkc(atomicReference, t, tMo2237invoke));
        return tMo2237invoke;
    }
}
