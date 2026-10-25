package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p119time.TimeSource;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0082\u0080\u0004J\n\u0010\u0007\u001a\u00020\bH\u0096\u0080\u0004J\u0011\u0010\t\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000eH\u0086\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u0016R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d¨\u0006\u001a"}, m4988d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "zero", BuildConfig.f24315FLAVOR, "read", "toString", BuildConfig.f24315FLAVOR, "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "elapsedFrom", "Lkotlin/time/Duration;", "timeMark", "elapsedFrom-6eNON_k", "(J)J", "differenceBetween", "one", "another", "differenceBetween-fRLX17w", "(JJ)J", "adjustReading", "duration", "adjustReading-6QKq23U", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
    private static final long zero = System.nanoTime();

    private MonotonicTimeSource() {
    }

    /* renamed from: read */
    private final long m6886read() {
        return System.nanoTime() - zero;
    }

    /* renamed from: adjustReading-6QKq23U, reason: not valid java name */
    public final long m19945adjustReading6QKq23U(long timeMark, long duration) {
        return TimeSource.Monotonic.ValueTimeMark.m19957constructorimpl(LongSaturatedMathKt.m19943saturatingAddNuflL3o(timeMark, DurationUnit.NANOSECONDS, duration));
    }

    /* renamed from: differenceBetween-fRLX17w, reason: not valid java name */
    public final long m19946differenceBetweenfRLX17w(long one, long another) {
        return LongSaturatedMathKt.saturatingOriginsDiff(one, another, DurationUnit.NANOSECONDS);
    }

    /* renamed from: elapsedFrom-6eNON_k, reason: not valid java name */
    public final long m19947elapsedFrom6eNON_k(long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(m6886read(), timeMark, DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
    /* renamed from: markNow */
    public /* bridge */ /* synthetic */ ComparableTimeMark mo6860markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m19954boximpl(m19948markNowz9LOYto());
    }

    /* renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m19948markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m19957constructorimpl(m6886read());
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, p094kotlin.p119time.TimeSource
    /* renamed from: markNow */
    public /* bridge */ /* synthetic */ TimeMark mo6860markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m19954boximpl(m19948markNowz9LOYto());
    }
}
